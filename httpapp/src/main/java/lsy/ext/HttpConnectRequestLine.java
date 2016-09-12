package lsy.ext;

import org.apache.http.ProtocolVersion;
import org.apache.http.message.BasicRequestLine;

/**
 * Created by Administrator on 2014/9/9.
 */
public class HttpConnectRequestLine extends BasicRequestLine
{
    public HttpConnectRequestLine(String method, String uri, ProtocolVersion version) {
        super(method, uri, version);
    }
}
