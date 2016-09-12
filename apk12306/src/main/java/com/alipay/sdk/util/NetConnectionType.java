package com.alipay.sdk.util;

public enum NetConnectionType
{
  private int p;
  private String q;
  
  private NetConnectionType(int paramInt1, String paramString1)
  {
    this.p = paramInt1;
    this.q = paramString1;
  }
  
  public static NetConnectionType a(int paramInt)
  {
    NetConnectionType[] arrayOfNetConnectionType = values();
    int i2 = arrayOfNetConnectionType.length;
    int i1 = 0;
    NetConnectionType localNetConnectionType;
    if (i1 < i2)
    {
      localNetConnectionType = arrayOfNetConnectionType[i1];
      if (localNetConnectionType.a() != paramInt) {}
    }
    for (;;)
    {
      return localNetConnectionType;
      i1++;
      break;
      localNetConnectionType = o;
    }
  }
  
  public final int a()
  {
    return this.p;
  }
  
  public final void a(String paramString)
  {
    this.q = paramString;
  }
  
  public final String b()
  {
    return this.q;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\NetConnectionType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */