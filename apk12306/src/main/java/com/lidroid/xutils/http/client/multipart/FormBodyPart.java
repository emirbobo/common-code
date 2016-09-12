package com.lidroid.xutils.http.client.multipart;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.http.client.multipart.content.ContentBody;

public class FormBodyPart
{
  private final ContentBody body;
  private final MinimalFieldHeader header;
  private final String name;
  
  static
  {
    JniLib.a(FormBodyPart.class, 999);
  }
  
  public FormBodyPart(String paramString, ContentBody paramContentBody)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramContentBody == null) {
      throw new IllegalArgumentException("Body may not be null");
    }
    this.name = paramString;
    this.body = paramContentBody;
    this.header = new MinimalFieldHeader();
    generateContentDisposition(paramContentBody);
    generateContentType(paramContentBody);
    generateTransferEncoding(paramContentBody);
  }
  
  public FormBodyPart(String paramString1, ContentBody paramContentBody, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Name may not be null");
    }
    if (paramContentBody == null) {
      throw new IllegalArgumentException("Body may not be null");
    }
    this.name = paramString1;
    this.body = paramContentBody;
    this.header = new MinimalFieldHeader();
    if (paramString2 != null) {
      addField("Content-Disposition", paramString2);
    }
    for (;;)
    {
      generateContentType(paramContentBody);
      generateTransferEncoding(paramContentBody);
      return;
      generateContentDisposition(paramContentBody);
    }
  }
  
  public native void addField(String paramString1, String paramString2);
  
  protected native void generateContentDisposition(ContentBody paramContentBody);
  
  protected native void generateContentType(ContentBody paramContentBody);
  
  protected native void generateTransferEncoding(ContentBody paramContentBody);
  
  public native ContentBody getBody();
  
  public native MinimalFieldHeader getHeader();
  
  public native String getName();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\FormBodyPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */