package com.alipay.sdk.data;

import com.bangcle.andjni.JniLib;
import java.util.ArrayList;
import org.apache.http.Header;

public class InteractionData
{
  public static final String a = "application/octet-stream;binary/octet-stream";
  private Header[] b = null;
  private String c = null;
  private String d = null;
  
  static
  {
    JniLib.a(InteractionData.class, 99);
  }
  
  public native void a(String paramString);
  
  public native void a(Header[] paramArrayOfHeader);
  
  public native Header[] a();
  
  public native ArrayList b();
  
  public native void b(String paramString);
  
  public native String c();
  
  public native String d();
  
  public native void e();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\data\InteractionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */