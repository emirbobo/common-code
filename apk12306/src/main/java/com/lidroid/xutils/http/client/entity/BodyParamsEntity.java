package com.lidroid.xutils.http.client.entity;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.entity.AbstractHttpEntity;

public class BodyParamsEntity
  extends AbstractHttpEntity
  implements Cloneable
{
  private String charset = "UTF-8";
  protected byte[] content;
  private boolean dirty = true;
  private List<NameValuePair> params;
  
  static
  {
    JniLib.a(BodyParamsEntity.class, 995);
  }
  
  public BodyParamsEntity()
  {
    this(null);
  }
  
  public BodyParamsEntity(String paramString)
  {
    if (paramString != null) {
      this.charset = paramString;
    }
    setContentType("application/x-www-form-urlencoded");
    this.params = new ArrayList();
  }
  
  public BodyParamsEntity(List<NameValuePair> paramList)
  {
    this(paramList, null);
  }
  
  public BodyParamsEntity(List<NameValuePair> paramList, String paramString)
  {
    if (paramString != null) {
      this.charset = paramString;
    }
    setContentType("application/x-www-form-urlencoded");
    this.params = paramList;
    refreshContent();
  }
  
  private native void refreshContent();
  
  public native BodyParamsEntity addParameter(String paramString1, String paramString2);
  
  public native BodyParamsEntity addParams(List<NameValuePair> paramList);
  
  public native Object clone()
    throws CloneNotSupportedException;
  
  public native InputStream getContent()
    throws IOException;
  
  public native long getContentLength();
  
  public native boolean isRepeatable();
  
  public native boolean isStreaming();
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\entity\BodyParamsEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */