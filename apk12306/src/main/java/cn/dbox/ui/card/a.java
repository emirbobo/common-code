package cn.dbox.ui.card;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.dbox.core.b.e;
import cn.dbox.core.b.k;
import java.util.ArrayList;

public class a
  extends LinearLayout
{
  ArrayList<cn.dbox.core.bean.d> a;
  public int b = 3;
  private View c;
  private ImageView d;
  private TextView e;
  private cn.dbox.ui.d.b f;
  
  public a(Context paramContext, cn.dbox.core.bean.c paramc, cn.dbox.core.b paramb)
  {
    super(paramContext);
    a(paramContext, paramc, paramb);
    if (this.c != null) {
      addView(this.c);
    }
  }
  
  public void a(Context paramContext, cn.dbox.core.bean.c paramc, cn.dbox.core.b paramb)
  {
    this.c = LayoutInflater.from(paramContext).inflate(cn.dbox.ui.e.d.a(paramContext, "dbox_channel_item"), null);
    this.d = ((ImageView)this.c.findViewById(cn.dbox.ui.e.c.a(paramContext, "channel_header_logo")));
    this.e = ((TextView)this.c.findViewById(cn.dbox.ui.e.c.a(paramContext, "channel_header_name")));
    Object localObject = paramc.b();
    String str = paramc.c();
    this.e.setText((CharSequence)localObject);
    this.d.setTag(str);
    paramb.a(str, this.d, new b.k()
    {
      public void a(Bitmap paramAnonymousBitmap, String paramAnonymousString, ImageView paramAnonymousImageView)
      {
        if ((paramAnonymousImageView.getTag().equals(paramAnonymousString)) && (paramAnonymousBitmap != null)) {
          paramAnonymousImageView.setImageBitmap(paramAnonymousBitmap);
        }
      }
      
      public void a(String paramAnonymousString, ImageView paramAnonymousImageView) {}
    });
    localObject = (ScrollCardView)this.c.findViewById(cn.dbox.ui.e.c.a(paramContext, "card_view"));
    ((ScrollCardView)localObject).setNumColumns(this.b);
    this.a = paramc.d();
    ((ScrollCardView)localObject).setAdapter(new cn.dbox.ui.a.b(paramContext, this.a, paramb));
    ((ScrollCardView)localObject).setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((a.a(a.this) != null) && (paramAnonymousInt < a.this.a.size())) {
          a.a(a.this).a((cn.dbox.core.bean.d)a.this.a.get(paramAnonymousInt), b.e.c);
        }
      }
    });
  }
  
  public void a(cn.dbox.ui.d.b paramb)
  {
    this.f = paramb;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\card\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */