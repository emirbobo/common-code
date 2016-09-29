package com.lidroid.xutils.http.client.multipart.content;

import com.lidroid.xutils.http.client.multipart.MultipartEntity.CallBackInfo;

public abstract class AbstractContentBody
  implements ContentBody
{
  protected MultipartEntity.CallBackInfo callBackInfo = MultipartEntity.CallBackInfo.DEFAULT;
  private final String mediaType;
  private final String mimeType;
  private final String subType;
  
  public AbstractContentBody(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("MIME type may not be null");
    }
    this.mimeType = paramString;
    int i = paramString.indexOf('/');
    if (i != -1) {
      this.mediaType = paramString.substring(0, i);
    }
    for (this.subType = paramString.substring(i + 1);; this.subType = null)
    {
      return;
      this.mediaType = paramString;
    }
  }
  
  public String getMediaType()
  {
    return this.mediaType;
  }
  
  public String getMimeType()
  {
    return this.mimeType;
  }
  
  public String getSubType()
  {
    return this.subType;
  }
  
  public void setCallBackInfo(MultipartEntity.CallBackInfo paramCallBackInfo)
  {
    this.callBackInfo = paramCallBackInfo;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\content\AbstractContentBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */