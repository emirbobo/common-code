package cn.domob.wall.core.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.bean.AdExtend;

public class d
  extends RelativeLayout
{
  private static cn.domob.wall.core.h.d a = new cn.domob.wall.core.h.d(d.class.getSimpleName());
  private a b;
  private Context c;
  private Dialog d;
  private cn.domob.wall.core.b e;
  private b f;
  private ProgressBar g;
  
  public d(final cn.domob.wall.core.b paramb, Context paramContext, AdExtend paramAdExtend)
  {
    super(paramContext);
    this.c = paramContext;
    this.b = new a(paramContext);
    this.e = paramb;
    setBackgroundColor(-1);
    this.f = new b(this.e, this.c, paramAdExtend.getmLabel(), new b.a()
    {
      public void a()
      {
        d.a().b("ewall close");
        if (d.a(d.this) != null) {
          d.a(d.this).dismiss();
        }
      }
    });
    paramContext = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    paramContext.setDuration(600L);
    this.f.startAnimation(paramContext);
    this.d = new Dialog(this.c, 16973840);
    this.d.setContentView(this.f);
    this.b.a(new a.a()
    {
      public void a(a paramAnonymousa, String paramAnonymousString)
      {
        d.a().b("EWallView onURLIntercepted URL:" + paramAnonymousString);
        try
        {
          paramAnonymousa = (Activity)d.c(d.this);
          Runnable local1 = new cn/domob/wall/core/d/d$2$1;
          local1.<init>(this, paramAnonymousString);
          paramAnonymousa.runOnUiThread(local1);
          cn.domob.wall.core.f.a.a().a(paramb, DService.EWallReportType.E_PAGE_CLICK, paramAnonymousString);
          return;
        }
        catch (Exception paramAnonymousa)
        {
          for (;;)
          {
            d.a().a(paramAnonymousa);
          }
        }
      }
    });
    cn.domob.wall.core.f.a.a().a(paramb, DService.EWallReportType.E_PAGE_REQ, null);
    this.b.loadUrl(paramAdExtend.getmUrl());
    this.b.setOnKeyListener(new View.OnKeyListener()
    {
      public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0)) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    });
    this.b.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
    this.b.a(new a.b()
    {
      public void a(a paramAnonymousa, String paramAnonymousString)
      {
        d.d(d.this).setVisibility(4);
        cn.domob.wall.core.f.a.a().a(paramb, DService.EWallReportType.E_PAGE_SHOW, null);
      }
    });
    addView(this.b, new RelativeLayout.LayoutParams(-1, -1));
    this.g = new ProgressBar(this.c);
    paramb = new RelativeLayout.LayoutParams(-2, -2);
    paramb.addRule(13);
    this.g.setLayoutParams(paramb);
    this.g.setVisibility(0);
    addView(this.g);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */