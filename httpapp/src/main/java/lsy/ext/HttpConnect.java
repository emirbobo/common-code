package lsy.ext;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpRequest;
import lsy.proxy.ProxyDebugger;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpRequestBase;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2014/9/9.
 */
public class HttpConnect extends HttpRequestBase
{
    String method = "CONNECT";
    HttpConnectRequestLine requestLine;
    ProtocolVersion protocolVersion = new HttpVersion(1,1);
    LinkedHashMap<String,String> headers = new LinkedHashMap<>();

    public HttpConnect(HttpRequest req)
    {
        super();

        HttpHeaders headers = req.headers();
        for(String name : headers.names())
        {
            this.headers.put(name,headers.get(name));
        }

        String targetHost = headers.get("Host");
        int targetPort = 80;
        if(req.getUri().contains(":"))
        {
            String hostInfo[] = req.getUri().split(":");
//            targetHost = hostInfo[0];
            try {
                targetPort = Integer.parseInt(hostInfo[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        StringBuffer url = new StringBuffer();
        url.append("CONNECT "+targetHost+":"+targetPort+" "
                        +req.getProtocolVersion().protocolName()+"/"+req.getProtocolVersion().majorVersion()+"."+req.getProtocolVersion().minorVersion()
        );
        url.append("\r\nHost: "+targetHost+":"+targetPort);
        url.append("\r\nProxy-Connection: Keep-Alive");//url.append("\r\nProxy-Authorization: xxxxxxx");
        url.append("\r\nContent-Length: 0");
        url.append("\r\n");
        url.append("\r\n");
        ProxyDebugger.debug("URL : " + url.toString());

        try {
//            URI uriObj = null;

//            new URI(req.getProtocolVersion().protocolName()+"://"
//                    +targetHost+":"+targetPort
//                    +"/";

        } catch (Exception e) {
            e.printStackTrace();
        }
//                socket.connect('HTTP代理服务器IP',HTTP代理服务器端口)
//                socket.send('CONNECT XXX.XXX.XXX:80 HTTP/1.1\r\n\r\n')
//                socket.recv(1024)
//                socket.send('GET /XXX.EXE HTTP/1.1\r\n

        //setURI(uri);
        requestLine = new HttpConnectRequestLine(method,"",protocolVersion);

    }

    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public ProtocolVersion getProtocolVersion() {
        return protocolVersion;
    }

    @Override
    public RequestLine getRequestLine()
    {
        HttpConnectRequestLine requestLine = new HttpConnectRequestLine(method,"",getProtocolVersion());
        requestLine.toString();
        return requestLine;
    }
}
