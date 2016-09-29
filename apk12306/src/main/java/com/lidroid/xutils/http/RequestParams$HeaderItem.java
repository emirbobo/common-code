package com.lidroid.xutils.http;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

public class RequestParams$HeaderItem
{
  public final Header header;
  public final boolean overwrite;
  
  public RequestParams$HeaderItem(RequestParams paramRequestParams, String paramString1, String paramString2)
  {
    this.overwrite = false;
    this.header = new BasicHeader(paramString1, paramString2);
  }
  
  public RequestParams$HeaderItem(RequestParams paramRequestParams, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.overwrite = paramBoolean;
    this.header = new BasicHeader(paramString1, paramString2);
  }
  
  public RequestParams$HeaderItem(RequestParams paramRequestParams, Header paramHeader)
  {
    this.overwrite = false;
    this.header = paramHeader;
  }
  
  public RequestParams$HeaderItem(RequestParams paramRequestParams, Header paramHeader, boolean paramBoolean)
  {
    this.overwrite = paramBoolean;
    this.header = paramHeader;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\RequestParams$HeaderItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */