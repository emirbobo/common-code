package cn.dbox.ui.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import cn.dbox.core.b.k;

class b$1
  implements b.k
{
  b$1(b paramb) {}
  
  public void a(Bitmap paramBitmap, String paramString, ImageView paramImageView)
  {
    if ((paramImageView.getTag().equals(paramString)) && (paramBitmap != null)) {
      paramImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(String paramString, ImageView paramImageView) {}
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */