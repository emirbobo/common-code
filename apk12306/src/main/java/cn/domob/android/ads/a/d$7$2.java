package cn.domob.android.ads.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import cn.domob.android.i.f;

class d$7$2
  implements MediaPlayer.OnErrorListener
{
  d$7$2(d.7 param7) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    d.b().e(this.a.a, "Video play error.");
    return false;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$7$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */