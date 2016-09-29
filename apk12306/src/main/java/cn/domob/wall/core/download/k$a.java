package cn.domob.wall.core.download;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import cn.domob.wall.core.DService.OnImageDownload;

class k$a
  extends Handler
{
  String a;
  ImageView b;
  
  public k$a(k paramk, String paramString, ImageView paramImageView)
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
        this.c.a.onDownloadSuc(paramMessage, this.a, this.b);
      }
    }
    for (;;)
    {
      return;
      label68:
      if (this.c.a != null)
      {
        this.c.a.onDownloadFail(this.a, this.b);
        continue;
        label101:
        if (this.c.a != null) {
          this.c.a.onDownloadFail(this.a, this.b);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\k$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */