package cn.domob.android.ads;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.android.i.f;
import java.util.HashMap;

public class z
  extends n
{
  private static f g = new f(z.class.getSimpleName());
  
  public z(Context paramContext, k paramk, j paramj, g paramg)
  {
    super(paramContext, paramk, paramj, paramg);
    g.b("New DomobSplashAdapter instance.");
  }
  
  public void a()
  {
    n();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(HashMap<String, String> paramHashMap, String paramString, long paramLong) {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    if ((this.f instanceof B))
    {
      ((B)this.f).destroy();
      this.f = null;
    }
  }
  
  public void n()
  {
    if (this.f == null)
    {
      ImageView localImageView = new ImageView(this.a);
      this.f = localImageView;
      localImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.b.a(), this.b.b()));
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      if (this.c != null) {
        localImageView.setImageBitmap(BitmapFactory.decodeFile(this.c.h()));
      }
      g();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */