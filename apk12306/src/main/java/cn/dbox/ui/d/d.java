package cn.dbox.ui.d;

import android.support.v4.view.ViewPager.OnPageChangeListener;

public class d
  implements ViewPager.OnPageChangeListener
{
  a a;
  
  public d(a parama)
  {
    this.a = parama;
  }
  
  public void a(a parama)
  {
    this.a = parama;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    if (this.a != null) {
      this.a.a(paramInt);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */