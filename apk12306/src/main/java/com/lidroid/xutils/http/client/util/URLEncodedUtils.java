package com.lidroid.xutils.http.client.util;

import com.bangcle.andjni.JniLib;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

public class URLEncodedUtils
{
  public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
  private static final char[] DELIM;
  private static final BitSet FRAGMENT;
  private static final String NAME_VALUE_SEPARATOR = "=";
  private static final String PARAMETER_SEPARATOR = "&";
  private static final BitSet PATHSAFE;
  private static final BitSet PUNCT;
  private static final int RADIX = 16;
  private static final BitSet RESERVED;
  private static final BitSet UNRESERVED;
  private static final BitSet URLENCODER;
  private static final BitSet USERINFO;
  
  static
  {
    JniLib.a(URLEncodedUtils.class, 1010);
    DELIM = new char[] { '&' };
    UNRESERVED = new BitSet(256);
    PUNCT = new BitSet(256);
    USERINFO = new BitSet(256);
    PATHSAFE = new BitSet(256);
    FRAGMENT = new BitSet(256);
    RESERVED = new BitSet(256);
    URLENCODER = new BitSet(256);
    int i = 97;
    if (i > 122)
    {
      i = 65;
      label122:
      if (i <= 90) {
        break label501;
      }
    }
    for (i = 48;; i++)
    {
      if (i > 57)
      {
        UNRESERVED.set(95);
        UNRESERVED.set(45);
        UNRESERVED.set(46);
        UNRESERVED.set(42);
        URLENCODER.or(UNRESERVED);
        UNRESERVED.set(33);
        UNRESERVED.set(126);
        UNRESERVED.set(39);
        UNRESERVED.set(40);
        UNRESERVED.set(41);
        PUNCT.set(44);
        PUNCT.set(59);
        PUNCT.set(58);
        PUNCT.set(36);
        PUNCT.set(38);
        PUNCT.set(43);
        PUNCT.set(61);
        USERINFO.or(UNRESERVED);
        USERINFO.or(PUNCT);
        PATHSAFE.or(UNRESERVED);
        PATHSAFE.set(47);
        PATHSAFE.set(59);
        PATHSAFE.set(58);
        PATHSAFE.set(64);
        PATHSAFE.set(38);
        PATHSAFE.set(61);
        PATHSAFE.set(43);
        PATHSAFE.set(36);
        PATHSAFE.set(44);
        RESERVED.set(59);
        RESERVED.set(47);
        RESERVED.set(63);
        RESERVED.set(58);
        RESERVED.set(64);
        RESERVED.set(38);
        RESERVED.set(61);
        RESERVED.set(43);
        RESERVED.set(36);
        RESERVED.set(44);
        RESERVED.set(91);
        RESERVED.set(93);
        FRAGMENT.or(RESERVED);
        FRAGMENT.or(UNRESERVED);
        return;
        UNRESERVED.set(i);
        i++;
        break;
        label501:
        UNRESERVED.set(i);
        i++;
        break label122;
      }
      UNRESERVED.set(i);
    }
  }
  
  private static native String decodeFormFields(String paramString1, String paramString2);
  
  private static native String decodeFormFields(String paramString, Charset paramCharset);
  
  static native String encFragment(String paramString, Charset paramCharset);
  
  static native String encPath(String paramString, Charset paramCharset);
  
  static native String encUserInfo(String paramString, Charset paramCharset);
  
  private static native String encodeFormFields(String paramString1, String paramString2);
  
  private static native String encodeFormFields(String paramString, Charset paramCharset);
  
  public static native String format(Iterable<? extends NameValuePair> paramIterable, Charset paramCharset);
  
  public static native String format(List<? extends NameValuePair> paramList, String paramString);
  
  public static native boolean isEncoded(HttpEntity paramHttpEntity);
  
  public static native List<NameValuePair> parse(String paramString);
  
  public static native List<NameValuePair> parse(URI paramURI);
  
  public static native void parse(List<NameValuePair> paramList, Scanner paramScanner);
  
  private static native String urldecode(String paramString, Charset paramCharset, boolean paramBoolean);
  
  private static native String urlencode(String paramString, Charset paramCharset, BitSet paramBitSet, boolean paramBoolean);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\util\URLEncodedUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */