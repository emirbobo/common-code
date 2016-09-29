package cn.domob.wall.core.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import cn.domob.wall.core.h.d;

class b$7$2
  implements MediaPlayer.OnErrorListener
{
  b$7$2(b.7 param7) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    b.b().e(this.a.a, "Video play error.");
    return false;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$7$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */