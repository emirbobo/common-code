package lsy.station;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import lsy.ext.HttpConnect;
import lsy.ext.HttpUtil;
import lsy.proxy.ProxyDebugger;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Set;
import java.util.regex.Pattern;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-15
 * Time: 下午7:59
 * To change this template use File | Settings | File Templates.
 */
public class StationHttpClientManager
{
    public static final Pattern PatternHaveProtocol = Pattern.compile("^[a-z0-9]+://.*$", Pattern.CASE_INSENSITIVE);
//    MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
    PoolingHttpClientConnectionManager connectionManager;
    RequestConfig globalConfig = RequestConfig.custom()
            .setCookieSpec(CookieSpecs.BEST_MATCH)
            .build();
    RequestConfig localConfig = RequestConfig.copy(globalConfig)
            .setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)
            .build();
    HttpClient httpClient;

    int jumpCount = 0;
    static int MaxJumpCount = 10;

    public StationHttpClientManager()
    {
        connectionManager = new PoolingHttpClientConnectionManager();
        httpClient = HttpClients.custom()
                .setDefaultRequestConfig(globalConfig)
                .setConnectionManager(connectionManager)
                .build();
    }

    public FullHttpResponse proxyRequest(ChannelHandlerContext ctx, HttpRequest req)
    {
        HttpMethod method = req.getMethod();
        HttpHeaders headers = req.headers();
        Set<String> headerNames = headers.names();

        jumpCount = 0;
        String targetHost = headers.get("Host");
        int targetPort = 80;
        ProxyDebugger.debug("URI : "+req.getUri());
        if(targetHost.contains(":"))
        {
            String hostInfo[] = targetHost.split(":");
//            targetHost = hostInfo[0];
            try {
                targetPort = Integer.parseInt(hostInfo[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        HttpHost proxyHttpHost = new HttpHost(targetHost,targetPort);
        org.apache.http.HttpRequest proxyRequest = null;
//        String uri = getUri(req.getUri());
        String uri = (req.getUri());
        ProxyDebugger.debug("Start Request URI : " + uri);
        if("GET".equals(method.name()))
            proxyRequest = new HttpGet(uri);
        else if("POST".equals(method.name()))
            {
                proxyRequest = new HttpPost(uri);
//                ((HttpPost)proxyRequest).setConfig(localConfig);

            }
        else if("PUT".equals(method.name()))
            {
                proxyRequest = new HttpPut(uri);
            }
        else if("HEAD".equals(method.name()))
            {
                proxyRequest = new HttpHead(uri);
            }
        else if("TRACE".equals(method.name()))
            {
                proxyRequest = new HttpTrace(uri);
            }
        else if("DELETE".equals(method.name()))
            {
                proxyRequest = new HttpDelete(uri);
            }
        else if("OPTIONS".equals(method.name()))
            {
                proxyRequest = new HttpOptions(uri);
            }
        else if("CONNECT".equals(method.name()))
            {
                proxyRequest = new HttpConnect(req);
            }
        else
        {
            throw new RuntimeException("不支持 "+method.name());
        }
//        httpClient.execute();
        for(String name : headerNames)
        {
            String headerValue = headers.get(name);
//            if(!"Cookie".equals(name))
            if(!CONTENT_LENGTH.equals(name))
            {
//                ProxyDebugger.debug("Add Header " + name);
                proxyRequest.setHeader(name,headerValue);
            }
        }
        try {
            org.apache.http.HttpResponse httpResponse = httpClient.execute(proxyHttpHost, proxyRequest);
            FullHttpResponse proxyResponse = toProxyResponse(req,httpResponse);
            proxyResponse = processResponse(proxyResponse);
            ProxyDebugger.debug("End Request URI : " + uri);
            return proxyResponse;

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private FullHttpResponse processResponse(FullHttpResponse proxyResponse) {
        HttpHeaders headers = proxyResponse.headers();
        String headerLocation = headers.get("Location");
        if(headerLocation == null)
        {
            return proxyResponse;
        }
        else
        {
            try {
                URI uri = new URI(headerLocation);
                int port = HttpUtil.getPort(headerLocation);
                ProxyDebugger.debug("Tunnel Location : "+headerLocation+" "+uri.getHost()+" "+port);
                HttpHost proxyHttpHost = new HttpHost(uri.getHost(),port);
                org.apache.http.HttpRequest proxyRequest = new HttpGet(uri);
//                for(String name : headerNames)
//                {
//                    String headerValue = headers.get(name);
//                    {
//                        proxyRequest.setHeader(name,headerValue);
//                    }
//                }

                org.apache.http.HttpResponse httpResponse = httpClient.execute(proxyHttpHost, proxyRequest);
                proxyResponse = toProxyResponse(null,httpResponse);
                proxyResponse = processResponse(proxyResponse);
                ProxyDebugger.debug("Redirect To " + headerLocation);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            proxyRequest = new HttpGet(uri);
        }
        return proxyResponse;
    }

    private String getUri(String uri)
    {
        ProxyDebugger.debug("Parsing URI : "+uri);
        if(PatternHaveProtocol.matcher(uri).matches())
        {
            int i = uri.indexOf(":");
            uri = uri.substring(i+3);
            i = uri.indexOf("/");
            if(i>0)
                return uri.substring(i);
            else
                return "/";
        }
        return uri;
    }

    private FullHttpResponse toProxyResponse(HttpRequest req, HttpResponse httpResponse)
    {
        HttpEntity entity = httpResponse.getEntity();
        byte [] responseContent = null;
        if (entity != null)
        {
            try {
                InputStream is = entity.getContent();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte [] buf = new byte[1024];
                int read = 0;
                while ((read = is.read(buf))>=0)
                {
                    if(read>0)
                        bos.write(buf,0,read);
                }
                is.close();
                bos.close();
                responseContent=bos.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
        FullHttpResponse response = null;
        HttpVersion httpVersion = HTTP_1_1;
        HttpResponseStatus status = HttpResponseStatus.valueOf(httpResponse.getStatusLine().getStatusCode());
        if(responseContent == null)
            response = new DefaultFullHttpResponse(httpVersion, status);
        else
            response = new DefaultFullHttpResponse(httpVersion, status, Unpooled.wrappedBuffer(responseContent));
        Header[] proxyHeaders = httpResponse.getAllHeaders();
            if(proxyHeaders!=null)
                for(Header header : proxyHeaders)
                {
                    response.headers().set(header.getName(),header.getValue());
                }
        String contentLength = response.headers().get(CONTENT_LENGTH);
        if(contentLength == null && responseContent!=null)
            response.headers().set(CONTENT_LENGTH, response.content().readableBytes());

        ProxyDebugger.debug(req,httpResponse,responseContent);
        return response;  //To change body of created methods use File | Settings | File Templates.
    }
}
