package cn.dbox.core.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import cn.dbox.core.h.d;

class c$1$2
  implements MediaPlayer.OnErrorListener
{
  c$1$2(c.1 param1) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    c.c().e(this.a.a, "Video play error.");
    return false;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$1$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */