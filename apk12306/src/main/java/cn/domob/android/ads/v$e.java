package cn.domob.android.ads;

import android.content.Context;
import android.graphics.Color;
import cn.domob.android.i.g;

public class v$e
{
  private Context a;
  private int b = -1;
  private int c = -1;
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private v.d h;
  private v.c i;
  private v.b j;
  private boolean k = false;
  private String l = "triangle";
  private int[] m = null;
  private boolean n = false;
  private int o = 0;
  private boolean p = false;
  private int q = 0;
  private boolean r = false;
  private int s = Color.parseColor("#7f000000");
  private boolean t = true;
  private int u = Color.parseColor("#7f000000");
  private boolean v = false;
  private boolean w = false;
  private int x;
  private int y;
  
  v$e(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private void a()
  {
    if (this.k)
    {
      if (!"rectangle".equals(this.l)) {
        break label70;
      }
      this.x = g.a(this.a, 88);
      this.y = g.a(this.a, 28);
      if ((this.m == null) || (this.m.length != 2)) {
        this.m = b();
      }
    }
    for (;;)
    {
      return;
      label70:
      if ("triangle".equals(this.l))
      {
        this.x = g.a(this.a, 36);
        this.y = g.a(this.a, 36);
      }
    }
  }
  
  private int[] b()
  {
    return new int[] { (this.b - this.x) / 2, -(g.a(this.a, 15) + this.y) };
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\v$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */