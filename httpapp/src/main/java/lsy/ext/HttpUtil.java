package lsy.ext;

import lsy.proxy.ProxyDebugger;

import java.util.regex.Pattern;

/**
 * Created by Administrator on 2014/9/10.
 */
public class HttpUtil {
    public static final Pattern PatternHaveProtocol = Pattern.compile("^[a-z0-9]+://.*$", Pattern.CASE_INSENSITIVE);

    public static int getPort(String url)
    {
        if(PatternHaveProtocol.matcher(url).matches())
        {
            int pos = url.indexOf(':');
            String protocol = url.substring(0,pos);
            pos+=3;
            int port = "https".equals(protocol) ? 443 : 80;
            String seg = url.substring(pos,url.indexOf('/',pos));
            ProxyDebugger.debug("Match "+url+" Host-Seg "+seg);
            pos = seg.indexOf(':');
            if(pos > 0)
            {
                port = Integer.parseInt(seg.substring(pos));
            }
            return port;
        }
        return 80;
    }
}
