package cn.domob.android.ads.a;

import android.view.View;
import android.view.View.OnClickListener;
import cn.domob.android.i.f;

class d$5
  implements View.OnClickListener
{
  d$5(d paramd) {}
  
  public void onClick(View paramView)
  {
    try
    {
      d.t(this.a);
      return;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        d.b().e(this, "intent " + d.r(this.a) + " error");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */