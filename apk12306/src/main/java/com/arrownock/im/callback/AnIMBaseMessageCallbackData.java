package com.arrownock.im.callback;

public abstract class AnIMBaseMessageCallbackData
{
  private String from = null;
  private String msgId = null;
  
  public AnIMBaseMessageCallbackData(String paramString1, String paramString2)
  {
    this.msgId = paramString1;
    this.from = paramString2;
  }
  
  public String getFrom()
  {
    return this.from;
  }
  
  public String getMsgId()
  {
    return this.msgId;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\im\callback\AnIMBaseMessageCallbackData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */