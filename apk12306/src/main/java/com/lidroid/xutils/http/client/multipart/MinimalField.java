package com.lidroid.xutils.http.client.multipart;

import com.bangcle.andjni.JniLib;

class MinimalField
{
  private final String name;
  private final String value;
  
  static
  {
    JniLib.a(MinimalField.class, 1001);
  }
  
  MinimalField(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }
  
  public native String getBody();
  
  public native String getName();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\MinimalField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */