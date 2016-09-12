package cn.domob.android.j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import cn.domob.android.i.f;

class a$8
  implements MediaPlayer.OnErrorListener
{
  a$8(a parama) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    a.m().d("video play error");
    a.a(this.a, false);
    a.b(this.a);
    return true;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a$8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */