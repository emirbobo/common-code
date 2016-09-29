package com.lidroid.xutils.util;

import com.bangcle.andjni.JniLib;
import java.util.ArrayList;
import java.util.List;

public class CharsetUtils
{
  public static final String DEFAULT_ENCODING_CHARSET = "ISO-8859-1";
  public static final List<String> SUPPORT_CHARSET;
  
  static
  {
    JniLib.a(CharsetUtils.class, 1020);
    SUPPORT_CHARSET = new ArrayList();
    SUPPORT_CHARSET.add("ISO-8859-1");
    SUPPORT_CHARSET.add("GB2312");
    SUPPORT_CHARSET.add("GBK");
    SUPPORT_CHARSET.add("GB18030");
    SUPPORT_CHARSET.add("US-ASCII");
    SUPPORT_CHARSET.add("ASCII");
    SUPPORT_CHARSET.add("ISO-2022-KR");
    SUPPORT_CHARSET.add("ISO-8859-2");
    SUPPORT_CHARSET.add("ISO-2022-JP");
    SUPPORT_CHARSET.add("ISO-2022-JP-2");
    SUPPORT_CHARSET.add("UTF-8");
  }
  
  public static native String getEncoding(String paramString, int paramInt);
  
  public static native boolean isCharset(String paramString1, String paramString2, int paramInt);
  
  public static native String toCharset(String paramString1, String paramString2, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\CharsetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */