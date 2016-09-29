package cn.domob.android.ads;

import cn.domob.android.i.g;

public class DomobPreRollSceneInfo
  extends DomobSceneInfo
{
  private static final int b = 10;
  private static final int c = 10;
  private int d;
  private int e;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  protected boolean a()
  {
    return this.h;
  }
  
  protected int b()
  {
    if (this.f) {}
    for (int i = this.d;; i = g.a(e(), 10)) {
      return i;
    }
  }
  
  protected int c()
  {
    if (this.g) {}
    for (int i = this.e;; i = g.a(e(), 10)) {
      return i;
    }
  }
  
  public void setCountdownCoordinatesX(int paramInt)
  {
    this.f = true;
    this.d = paramInt;
  }
  
  public void setCountdownCoordinatesY(int paramInt)
  {
    this.g = true;
    this.e = paramInt;
  }
  
  public void setWhetherToAddCountdown(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobPreRollSceneInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */