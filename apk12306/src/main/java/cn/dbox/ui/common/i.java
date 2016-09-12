package cn.dbox.ui.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.dbox.ui.d.e;
import cn.dbox.ui.e.c;
import cn.dbox.ui.e.d;

public class i
  extends RelativeLayout
{
  public final int a = 45;
  e b;
  private Context c;
  private View d;
  private ImageView e;
  private TextView f;
  private RelativeLayout g;
  private RelativeLayout h;
  
  public i(Context paramContext)
  {
    super(paramContext);
    this.c = paramContext;
    a();
    if (this.d != null)
    {
      paramContext = new RelativeLayout.LayoutParams(-1, k.a(paramContext, 45));
      addView(this.d, paramContext);
    }
  }
  
  public void a()
  {
    this.d = LayoutInflater.from(this.c).inflate(d.a(this.c, "dbox_home_titlebar"), null);
    this.g = ((RelativeLayout)this.d.findViewById(c.a(this.c, "home_back_rl")));
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (i.this.b != null) {
          i.this.b.c();
        }
      }
    });
    this.h = ((RelativeLayout)this.d.findViewById(c.a(this.c, "home_set_rl")));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (i.this.b != null) {
          i.this.b.b();
        }
      }
    });
    this.e = ((ImageView)this.d.findViewById(c.a(this.c, "home_title")));
    this.f = ((TextView)this.d.findViewById(c.a(this.c, "home_title_text")));
    this.f.setVisibility(0);
    this.f.setText("旅行休闲");
    this.e.setVisibility(8);
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (i.this.b != null) {
          i.this.b.a();
        }
      }
    });
  }
  
  public void a(e parame)
  {
    this.b = parame;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */