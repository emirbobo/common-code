package cn.dbox.ui.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class d
  extends RelativeLayout
{
  private View a;
  
  public d(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public void a(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.a = LayoutInflater.from(paramContext).inflate(cn.dbox.ui.e.d.a(paramContext, "dbox_container_noad"), null);
    this.a.setLayoutParams(localLayoutParams);
    setLayoutParams(localLayoutParams);
    addView(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */