package cn.domob.android.ads;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.android.i.f;

class DomobAdView$1
  implements Runnable
{
  DomobAdView$1(DomobAdView paramDomobAdView, AnimationSet[] paramArrayOfAnimationSet, View paramView, n paramn) {}
  
  public void run()
  {
    if (this.d.f.getLayoutParams() != null)
    {
      DomobAdView.k().a("AdView's layoutParams is not null.");
      this.d.f.getLayoutParams().width = this.d.i;
      this.d.f.getLayoutParams().height = this.d.j;
      if (this.a == null) {
        break label356;
      }
      DomobAdView.k().b("Show ad with animation.");
      Object localObject = this.a[0];
      AnimationSet localAnimationSet = this.a[1];
      this.d.f.setInAnimation((Animation)localObject);
      this.d.f.setOutAnimation(localAnimationSet);
      label112:
      this.d.f.setVisibility(0);
      this.d.f.addView(this.b, new RelativeLayout.LayoutParams(this.d.i, this.d.j));
      if (!this.d.k) {
        break label389;
      }
      this.d.k = false;
      label176:
      if (this.d.f.getChildCount() >= 3)
      {
        if (!(this.d.f.getChildAt(0) instanceof a)) {
          break label402;
        }
        localObject = (a)this.d.f.getChildAt(0);
        this.d.f.removeView((View)localObject);
        ((a)localObject).destroy();
      }
    }
    for (;;)
    {
      this.d.b(this.c);
      this.d.a.a(System.currentTimeMillis());
      if (this.d.n != null) {
        this.d.n.onReceivedFreshAd(this.d);
      }
      if (this.d.o != null) {
        this.d.o.onDomobAdReturned(this.d);
      }
      return;
      DomobAdView.k().a("AdView's layoutParams is null.");
      this.d.f.setLayoutParams(new RelativeLayout.LayoutParams(this.d.i, this.d.j));
      break;
      label356:
      DomobAdView.k().b("Show ad without animation.");
      this.d.f.setInAnimation(null);
      this.d.f.setOutAnimation(null);
      break label112;
      label389:
      this.d.f.showNext();
      break label176;
      label402:
      this.d.f.removeViewAt(0);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobAdView$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */