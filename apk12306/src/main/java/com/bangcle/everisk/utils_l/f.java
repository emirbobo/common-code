package com.bangcle.everisk.utils_l;

import com.bangcle.everisk.shell.LibProc;

public final class f
{
  private String ab = "";
  private long ac = 0L;
  private long ad = 0L;
  private long ae = 0L;
  private long af = 0L;
  
  public f(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    this.ab = paramString;
    this.ac = paramLong1;
    this.ad = paramLong2;
    this.ae = paramLong3;
  }
  
  public final void G()
  {
    if (this.af < this.ad) {
      this.af += this.ac;
    }
    try
    {
      for (;;)
      {
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("wait ");
        LibProc.a("RiskStubShell.Delay", this.af + " second for " + this.ab);
        Thread.sleep(this.af * 1000L);
        return;
        if (this.af < this.ae) {
          this.af += this.af;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\utils_l\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */