package cn.dbox.core.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.dbox.core.bean.a;
import cn.dbox.core.h.d;

public class b
{
  private static d d = new d(b.class.getSimpleName());
  private static final int k = 100;
  a a;
  c b;
  cn.dbox.ui.common.c c;
  private Context e = null;
  private c.b f;
  private RelativeLayout g;
  private Dialog h = null;
  private Animation i;
  private boolean j = false;
  private a l;
  
  public b(Context paramContext, String paramString1, String paramString2, c.b paramb, a parama, a parama1)
  {
    this.b = new c(paramContext, paramString1, paramString2, paramb, parama, true);
    this.b.a(new c.e()
    {
      public void a()
      {
        b.this.b();
      }
      
      public void a(String paramAnonymousString)
      {
        if (b.this.c != null)
        {
          b.this.c.a(true);
          b.this.c.a(paramAnonymousString);
        }
      }
      
      public void b()
      {
        b.a(b.this, true);
      }
    });
    this.a = parama;
    this.l = parama1;
    this.e = paramContext;
    this.f = paramb;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int m = Integer.toBinaryString(paramInt2).length() - 1;
    if ((paramInt1 >>> m) % 2 == (paramInt2 >>> m) % 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean c()
  {
    if ((this.e instanceof Activity)) {}
    for (boolean bool = a(((Activity)this.e).getWindow().getAttributes().flags, 1024);; bool = false) {
      return bool;
    }
  }
  
  public Dialog a()
    throws Exception
  {
    d.a(this, "Start to build FS/RFS landingpage");
    this.g = new RelativeLayout(this.e);
    this.c = new cn.dbox.ui.common.c(this.e, this.a.e());
    this.c.b(false);
    this.c.a(false);
    this.c.setId(9999);
    if (this.l.ordinal() == a.b.ordinal()) {
      this.g.addView(this.c);
    }
    this.c.a(new cn.dbox.ui.d.c()
    {
      public void a() {}
      
      public void b()
      {
        b.this.b();
      }
    });
    this.g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    if (this.l.ordinal() == a.b.ordinal()) {
      localLayoutParams.addRule(3, 9999);
    }
    this.g.addView(this.b, localLayoutParams);
    if (c())
    {
      this.h = new Dialog(this.e, 16973841);
      if (this.l.ordinal() != a.c.ordinal()) {
        break label351;
      }
      this.i = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      this.i.setDuration(100L);
      this.g.startAnimation(this.i);
    }
    for (;;)
    {
      this.h = new Dialog(this.e, 16973840);
      this.h.getWindow().getAttributes().dimAmount = 0.5F;
      this.h.getWindow().setFlags(2, 2);
      this.h.setContentView(this.g);
      this.h.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          b.a(b.this).removeView(b.this.b);
          if (b.b(b.this) != null) {
            b.b(b.this).f(b.this.a);
          }
          if ((!b.c(b.this)) && (b.b(b.this) != null)) {
            b.b(b.this).e(b.this.a);
          }
        }
      });
      return this.h;
      this.h = new Dialog(this.e, 16973840);
      break;
      label351:
      this.i = new TranslateAnimation(1, 1.0F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
      this.i.setDuration(100L);
      this.b.startAnimation(this.i);
    }
  }
  
  public void b()
  {
    if ((this.h != null) && (this.h.isShowing())) {
      this.h.dismiss();
    }
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */