package com.tl.uic.util;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import org.apache.http.entity.AbstractHttpEntity;

public final class HTTPUtil
{
  private static final int BUFFER_SIZE = 1024;
  private static final int SUCCESS_IM_USED_RFC_3229 = 226;
  private static final int SUCCESS_OK = 200;
  public static final String TLF_SESSION_ID_FROM_PCA = "TLTSID";
  private static volatile HTTPUtil _myInstance;
  
  static
  {
    JniLib.a(HTTPUtil.class, 1118);
  }
  
  public static native Boolean checkWhiteList();
  
  public static native String convertStreamToString(InputStream paramInputStream)
    throws IOException;
  
  public static native AbstractHttpEntity createEntity(String paramString, Boolean paramBoolean)
    throws IOException;
  
  private static native String getBodyFromUrl(String paramString);
  
  public static native String getCookieValue(URLConnection paramURLConnection, String paramString);
  
  public static native HTTPUtil getInstance();
  
  public static native Boolean sendHttpImagePost(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public static native Boolean sendHttpPost(String paramString1, String paramString2, String paramString3, Boolean paramBoolean);
  
  private static native Boolean sendPost(String paramString1, String paramString2, Boolean paramBoolean1, Boolean paramBoolean2, String paramString3, String paramString4, String paramString5);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\HTTPUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */