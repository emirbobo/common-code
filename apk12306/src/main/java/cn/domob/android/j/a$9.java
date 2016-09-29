package cn.domob.android.j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.widget.VideoView;
import cn.domob.android.i.f;

class a$9
  implements MediaPlayer.OnPreparedListener
{
  a$9(a parama) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (a.c(this.a) != null)
    {
      a.m().b("video prepared");
      a.d(this.a);
      if (!a.e(this.a)) {
        break label157;
      }
      a.c(this.a).pause();
    }
    for (;;)
    {
      a.c(this.a).seekTo(a.f(this.a));
      if (a.g(this.a) <= 0)
      {
        int i = a.c(this.a).getDuration();
        if (i > 0) {
          a.a(this.a, i);
        }
      }
      if (!a.h(this.a))
      {
        a.m().b("video duration: " + a.c(this.a).getDuration());
        a.a(this.a, true);
        a.i(this.a);
      }
      return;
      label157:
      a.c(this.a).start();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */