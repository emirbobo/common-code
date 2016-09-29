package com.lidroid.xutils.http;

import android.text.TextUtils;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.http.client.multipart.content.ContentBody;
import com.lidroid.xutils.task.Priority;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeader;

public class RequestParams
{
  private HttpEntity bodyEntity;
  private List<NameValuePair> bodyParams;
  private String charset = "UTF-8";
  private HashMap<String, ContentBody> fileParams;
  private List<HeaderItem> headers;
  private Priority priority;
  private List<NameValuePair> queryStringParams;
  
  static
  {
    JniLib.a(RequestParams.class, 984);
  }
  
  public RequestParams() {}
  
  public RequestParams(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.charset = paramString;
    }
  }
  
  public native void addBodyParameter(String paramString, File paramFile);
  
  public native void addBodyParameter(String paramString1, File paramFile, String paramString2);
  
  public native void addBodyParameter(String paramString1, File paramFile, String paramString2, String paramString3);
  
  public native void addBodyParameter(String paramString1, File paramFile, String paramString2, String paramString3, String paramString4);
  
  public native void addBodyParameter(String paramString, InputStream paramInputStream, long paramLong);
  
  public native void addBodyParameter(String paramString1, InputStream paramInputStream, long paramLong, String paramString2);
  
  public native void addBodyParameter(String paramString1, InputStream paramInputStream, long paramLong, String paramString2, String paramString3);
  
  public native void addBodyParameter(String paramString1, String paramString2);
  
  public native void addBodyParameter(List<NameValuePair> paramList);
  
  public native void addBodyParameter(NameValuePair paramNameValuePair);
  
  public native void addHeader(String paramString1, String paramString2);
  
  public native void addHeader(Header paramHeader);
  
  public native void addHeaders(List<Header> paramList);
  
  public native void addQueryStringParameter(String paramString1, String paramString2);
  
  public native void addQueryStringParameter(List<NameValuePair> paramList);
  
  public native void addQueryStringParameter(NameValuePair paramNameValuePair);
  
  public native String getCharset();
  
  public native HttpEntity getEntity();
  
  public native List<HeaderItem> getHeaders();
  
  public native Priority getPriority();
  
  public native List<NameValuePair> getQueryStringParams();
  
  public native void setBodyEntity(HttpEntity paramHttpEntity);
  
  public native void setContentType(String paramString);
  
  public native void setHeader(String paramString1, String paramString2);
  
  public native void setHeader(Header paramHeader);
  
  public native void setHeaders(List<Header> paramList);
  
  public native void setPriority(Priority paramPriority);
  
  public class HeaderItem
  {
    public final Header header;
    public final boolean overwrite;
    
    public HeaderItem(String paramString1, String paramString2)
    {
      this.overwrite = false;
      this.header = new BasicHeader(paramString1, paramString2);
    }
    
    public HeaderItem(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.overwrite = paramBoolean;
      this.header = new BasicHeader(paramString1, paramString2);
    }
    
    public HeaderItem(Header paramHeader)
    {
      this.overwrite = false;
      this.header = paramHeader;
    }
    
    public HeaderItem(Header paramHeader, boolean paramBoolean)
    {
      this.overwrite = paramBoolean;
      this.header = paramHeader;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\RequestParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */