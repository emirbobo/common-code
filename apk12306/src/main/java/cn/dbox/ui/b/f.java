package cn.dbox.ui.b;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.dbox.core.bean.d;
import cn.dbox.ui.common.e;
import cn.dbox.ui.common.e.a;
import cn.dbox.ui.common.e.b;

public class f
  extends RelativeLayout
{
  e a;
  e.b b;
  private String c = null;
  
  public f(Context paramContext, d paramd)
  {
    super(paramContext);
    a(paramContext, paramd);
  }
  
  public void a()
  {
    if ((this.a != null) && (this.c != null)) {
      this.a.loadUrl(this.c);
    }
  }
  
  public void a(Context paramContext, d paramd)
  {
    this.c = paramd.g();
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    setLayoutParams(localLayoutParams);
    setBackgroundColor(-789000);
    this.a = new e(paramContext, paramd);
    this.a.setLayoutParams(localLayoutParams);
    this.a.a(new e.a()
    {
      public void a(e paramAnonymouse, String paramAnonymousString)
      {
        f.this.a.loadUrl(paramAnonymousString);
      }
    });
    addView(this.a);
  }
  
  public void a(e.b paramb)
  {
    this.b = paramb;
    if (this.a != null) {
      this.a.a(paramb);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */