package cn.dbox.core.d;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cn.dbox.core.b.k;

class l$a
  extends Handler
{
  String a;
  ImageView b;
  
  public l$a(l paraml, String paramString, ImageView paramImageView)
  {
    this.a = paramString;
    this.b = paramImageView;
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.b.getTag().equals(this.a))
    {
      if (paramMessage.obj == null) {
        break label101;
      }
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage == null) {
        break label68;
      }
      if (this.c.a != null) {
        this.c.a.a(paramMessage, this.a, this.b);
      }
    }
    for (;;)
    {
      return;
      label68:
      if (this.c.a != null)
      {
        this.c.a.a(this.a, this.b);
        continue;
        label101:
        if (this.c.a != null) {
          this.c.a.a(this.a, this.b);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\l$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */