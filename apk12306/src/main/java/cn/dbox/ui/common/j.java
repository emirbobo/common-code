package cn.dbox.ui.common;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.dbox.ui.d.g;
import cn.dbox.ui.e.c;
import cn.dbox.ui.e.d;

public class j
  extends RelativeLayout
{
  private View a;
  private EditText b;
  private EditText c;
  private RelativeLayout d;
  private RelativeLayout e;
  private RelativeLayout f;
  private TextView g;
  private TextView h;
  private Dialog i;
  private Context j;
  private g k;
  
  public j(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public void a()
  {
    a locala = new a(this.j);
    locala.a(new a.a()
    {
      public void a()
      {
        if (j.d(j.this) != null) {
          j.d(j.this).dismiss();
        }
      }
    });
    this.i.setContentView(locala);
    this.i.show();
  }
  
  public void a(Context paramContext)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.a = LayoutInflater.from(paramContext).inflate(d.a(paramContext, "dbox_set"), null);
    this.a.setLayoutParams(localLayoutParams);
    this.j = paramContext;
    this.i = new Dialog(paramContext, 16973840);
    this.b = ((EditText)this.a.findViewById(c.a(paramContext, "about_suggest")));
    this.c = ((EditText)this.a.findViewById(c.a(paramContext, "about_suggest_tel")));
    this.d = ((RelativeLayout)this.a.findViewById(c.a(paramContext, "set_about")));
    this.d.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (j.a(j.this) != null) {
          j.a(j.this).b();
        }
        j.this.a();
      }
    });
    this.e = ((RelativeLayout)this.a.findViewById(c.a(paramContext, "set_contact")));
    this.e.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (j.a(j.this) != null) {
          j.a(j.this).c();
        }
      }
    });
    this.f = ((RelativeLayout)this.a.findViewById(c.a(paramContext, "about_back_rl")));
    this.f.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (j.a(j.this) != null) {
          j.a(j.this).a();
        }
      }
    });
    this.g = ((TextView)this.a.findViewById(c.a(paramContext, "about_send")));
    this.g.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (j.a(j.this) != null) {
          j.a(j.this).a(j.b(j.this).getText().toString().trim(), j.c(j.this).getText().toString().trim());
        }
      }
    });
    this.h = ((TextView)this.a.findViewById(c.a(paramContext, "about_set")));
    this.h.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView) {}
    });
    setLayoutParams(localLayoutParams);
    addView(this.a);
  }
  
  public void a(g paramg)
  {
    this.k = paramg;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */