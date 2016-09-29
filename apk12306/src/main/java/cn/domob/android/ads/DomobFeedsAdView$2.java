package cn.domob.android.ads;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.android.b.a;
import cn.domob.android.i.d;

class DomobFeedsAdView$2
  implements Runnable
{
  DomobFeedsAdView$2(DomobFeedsAdView paramDomobFeedsAdView, Context paramContext) {}
  
  public void run()
  {
    j.c localc = this.b.a.B().d();
    int k = (int)localc.w();
    if (localc.u())
    {
      int i = (int)(a.t(this.a) * 36.0F);
      int j = (int)(a.t(this.a) * 36.0F);
      localObject = new ImageButton(this.a);
      ((ImageButton)localObject).setVisibility(8);
      ((ImageButton)localObject).setBackgroundDrawable(d.b(this.a, "domob_close.png"));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, j);
      localLayoutParams.addRule(11);
      this.b.addView((View)localObject, localLayoutParams);
      ((ImageButton)localObject).setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DomobFeedsAdView.2.this.b.close();
        }
      });
      DomobFeedsAdView.a(this.b).postDelayed(new Runnable()
      {
        public void run()
        {
          localObject.setVisibility(0);
        }
      }, k * 1000);
    }
    this.b.getLayoutParams().height = this.b.j;
    if (localc.x()) {
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (DomobFeedsAdView.2.this.b.a()) {
            DomobFeedsAdView.2.this.b.o();
          }
        }
      }, k * 1000);
    }
    this.b.a.a(System.currentTimeMillis());
    final Object localObject = this.b.a.B().d();
    float f = ((j.c)localObject).y();
    if (((j.c)localObject).z()) {
      DomobFeedsAdView.a(this.b).postDelayed(new Runnable()
      {
        public void run()
        {
          DomobFeedsAdView.2.this.b.close();
        }
      }, (f * 1000.0F));
    }
    this.b.n();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobFeedsAdView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */