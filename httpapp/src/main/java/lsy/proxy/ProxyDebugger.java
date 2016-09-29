package lsy.proxy;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import org.apache.http.Header;
import org.apache.http.HttpResponse;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-7-16
 * Time: 上午10:44
 * To change this template use File | Settings | File Templates.
 */
public class ProxyDebugger
{
    public static void debug(ChannelHandlerContext ctx, HttpRequest req)
    {
        HttpMethod method = req.getMethod();

        HttpHeaders headers = req.headers();
        Set<String> headerNames = headers.names();

        debug("\n\n");
        debug("+----------------- "+req.getProtocolVersion()+" Request --------------------------+");
        debug("Method:"+req.getMethod().toString()+" URI : "+req.getUri());
        debug("+--------List Headers----------+");
        for(String name : headerNames)
        {
            debug("Header [ "+name+" ] = "+headers.get(name));
        }
    }
    public static void debug(String info)
    {
        System.out.print("DEBUG : ");
        System.out.println(info);
    }

    public static void debug(HttpRequest req, HttpResponse response, byte[] responseContent)
    {
        StringBuffer line = new StringBuffer("+----------------- Access ");
        if(req!=null)
        {
            line.append(req.getMethod() + " " + req.getUri());
        }
        line.append(" Reponse Ver:" + response.getProtocolVersion() + "--------------------------+");
        debug(line.toString());
        debug("StatusLine :"+response.getStatusLine());
        debug("+-------- Headers List ----------+");
        Header[] proxyHeaders = response.getAllHeaders();
        String contextType = null;
        if(proxyHeaders!=null)
            for(Header header : proxyHeaders)
            {
                debug(header.getName()+" = "+header.getValue());
                if("Content-Type".equals(header.getName()))
                {
                    contextType = header.getValue();
                }
            }
        if(contextType!=null && contextType.indexOf("text")>=0 && responseContent != null)
        {
            debug("+-------- Response-Context ----------+");
            debug(new String(responseContent));
        }
    }
}
