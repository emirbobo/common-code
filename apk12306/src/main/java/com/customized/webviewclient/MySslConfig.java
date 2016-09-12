package com.customized.webviewclient;

import android.net.http.SslCertificate;
import com.bangcle.andjni.JniLib;
import java.util.HashMap;

public class MySslConfig
{
  private static String[] domainWhiteList;
  private static HashMap<String, String> issuerWhiteListMap;
  
  static
  {
    JniLib.a(MySslConfig.class, 253);
    domainWhiteList = new String[] { "114.255.140.184:8280", "mobile.12306.cn" };
    issuerWhiteListMap = new HashMap();
    issuerWhiteListMap.put("114.255.140.184", "mobile.12306.cn");
  }
  
  public static native boolean isInWhiteList(SslCertificate paramSslCertificate);
  
  public static native boolean isInWhiteList(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\customized\webviewclient\MySslConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */