package com.alipay.sdk.protocol;

import com.alipay.sdk.data.Request;
import com.alipay.sdk.data.Response;

public abstract class WindowData
  extends FrameData
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  public static final int h = 7;
  public static final int i = 8;
  public static final int j = 9;
  public static final int k = 10;
  public static final int l = -10;
  private boolean m = false;
  private boolean n = false;
  private int o = -1;
  
  protected WindowData(Request paramRequest, Response paramResponse)
  {
    super(paramRequest, paramResponse);
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public abstract boolean f();
  
  public abstract int g();
  
  public abstract String h();
  
  public void j()
  {
    this.o += 1;
  }
  
  public int k()
  {
    return this.o;
  }
  
  public boolean l()
  {
    return this.m;
  }
  
  public boolean m()
  {
    return this.n;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\WindowData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */