package cn.dbox.ui.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.dbox.ui.e.d;

public class c
  extends RelativeLayout
{
  public final int a = 50;
  cn.dbox.ui.d.c b;
  private Context c;
  private String d;
  private View e;
  private ImageView f;
  private TextView g;
  private RelativeLayout h;
  private RelativeLayout i;
  
  public c(Context paramContext, String paramString)
  {
    super(paramContext);
    this.c = paramContext;
    this.d = paramString;
    a();
    if (this.e != null)
    {
      paramContext = new RelativeLayout.LayoutParams(-1, k.a(paramContext, 50));
      addView(this.e, paramContext);
    }
  }
  
  public void a()
  {
    this.e = LayoutInflater.from(this.c).inflate(d.a(this.c, "dbox_home_titlebar"), null);
    this.h = ((RelativeLayout)this.e.findViewById(cn.dbox.ui.e.c.a(this.c, "home_back_rl")));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.this.b != null) {
          c.this.b.b();
        }
      }
    });
    this.i = ((RelativeLayout)this.e.findViewById(cn.dbox.ui.e.c.a(this.c, "home_set_rl")));
    this.i.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (c.this.b != null) {
          c.this.b.a();
        }
      }
    });
    this.g = ((TextView)this.e.findViewById(cn.dbox.ui.e.c.a(this.c, "home_title_text")));
    this.f = ((ImageView)this.e.findViewById(cn.dbox.ui.e.c.a(this.c, "home_title")));
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    if (this.d != null) {
      if (this.d.length() == 3) {
        this.g.setText(" " + this.d + " ");
      }
    }
    for (;;)
    {
      this.g.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      return;
      this.g.setText(this.d);
      continue;
      this.g.setText("");
    }
  }
  
  public void a(cn.dbox.ui.d.c paramc)
  {
    this.b = paramc;
  }
  
  public void a(String paramString)
  {
    if (this.g != null) {
      this.g.setText(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.g != null)
    {
      if (!paramBoolean) {
        break label20;
      }
      this.g.setVisibility(0);
    }
    for (;;)
    {
      return;
      label20:
      this.g.setVisibility(4);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.i != null)
    {
      if (!paramBoolean) {
        break label20;
      }
      this.i.setVisibility(0);
    }
    for (;;)
    {
      return;
      label20:
      this.i.setVisibility(4);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */