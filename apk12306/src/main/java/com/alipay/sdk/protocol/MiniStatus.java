package com.alipay.sdk.protocol;

public enum MiniStatus
{
  private String k;
  
  private MiniStatus(String paramString1)
  {
    this.k = paramString1;
  }
  
  public static MiniStatus a(String paramString)
  {
    Object localObject = null;
    MiniStatus[] arrayOfMiniStatus = values();
    int n = arrayOfMiniStatus.length;
    int m = 0;
    if (m < n)
    {
      MiniStatus localMiniStatus = arrayOfMiniStatus[m];
      if (!paramString.startsWith(localMiniStatus.a())) {
        break label47;
      }
      localObject = localMiniStatus;
    }
    label47:
    for (;;)
    {
      m++;
      break;
      return (MiniStatus)localObject;
    }
  }
  
  public final String a()
  {
    return this.k;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\MiniStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */