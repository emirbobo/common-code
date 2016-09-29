package cn.domob.android.ads;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class DomobFeedsAdView$1
  implements Runnable
{
  DomobFeedsAdView$1(DomobFeedsAdView paramDomobFeedsAdView, View paramView) {}
  
  public void run()
  {
    this.b.removeAllViews();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(this.b.i, this.b.j);
    localLayoutParams.addRule(13);
    this.b.addView(this.a, localLayoutParams);
    if (this.b.o != null) {
      this.b.o.onDomobAdReturned(this.b);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobFeedsAdView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */