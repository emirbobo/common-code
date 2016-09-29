package cn.dbox.ui.a;

import android.view.View;
import android.view.View.OnClickListener;

class g$b
  implements View.OnClickListener
{
  private int b;
  
  public g$b(g paramg, int paramInt)
  {
    this.b = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (g.a(this.a) != null) {
      g.a(this.a).a(paramView, this.b, this.a.getItemId(this.b));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a\g$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */