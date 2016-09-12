package cn.dbox.ui.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.dbox.core.b;
import cn.dbox.core.b.k;
import cn.dbox.ui.common.k;
import cn.dbox.ui.e.c;

public class d
  extends RelativeLayout
{
  public static final int a = 50;
  private View b;
  private ImageView c;
  private TextView d;
  
  public d(Context paramContext, String paramString1, String paramString2, b paramb)
  {
    super(paramContext);
    a(paramContext, paramString1, paramString2, paramb);
    if (this.b != null)
    {
      paramString1 = new RelativeLayout.LayoutParams(-1, k.a(paramContext, 50));
      paramString1.topMargin = k.a(paramContext, 5);
      addView(this.b, paramString1);
    }
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, b paramb)
  {
    this.b = LayoutInflater.from(paramContext).inflate(cn.dbox.ui.e.d.a(paramContext, "dbox_channel_titlebar"), null);
    this.c = ((ImageView)this.b.findViewById(c.a(paramContext, "se_channel_header_logo")));
    this.d = ((TextView)this.b.findViewById(c.a(paramContext, "se_channel_header_name")));
    this.d.setText(paramString2);
    this.c.setTag(paramString1);
    paramb.a(paramString1, this.c, new b.k()
    {
      public void a(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
      {
        if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
          paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
        }
      }
      
      public void a(String paramAnonymousString, ImageView paramAnonymousImageView) {}
    });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */