package cn.domob.android.j;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import cn.domob.android.i.f;

class a$11
  implements MediaPlayer.OnCompletionListener
{
  a$11(a parama) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    a.m().b("Video playback is complete");
    a.b(this.a, true);
    if (a.k(this.a)) {
      a.l(this.a);
    }
    a.j(this.a).c(false);
    long l;
    if (a.m(this.a).a())
    {
      l = a.m(this.a).b();
      if (l <= 0L) {
        this.a.g();
      }
    }
    for (;;)
    {
      return;
      if (l > 0L)
      {
        if (a.n(this.a)) {
          a.o(this.a);
        }
        a.q(this.a).postDelayed(a.p(this.a), l);
        a.j(this.a).f();
        a.j(this.a).d();
        continue;
        if (a.n(this.a)) {
          a.o(this.a);
        }
        a.j(this.a).f();
        a.j(this.a).d();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a$11.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */