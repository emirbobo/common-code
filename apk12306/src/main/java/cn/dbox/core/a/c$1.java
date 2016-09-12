package cn.dbox.core.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.webkit.DownloadListener;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.VideoView;
import cn.dbox.core.h.d;
import java.util.Arrays;
import java.util.List;

class c$1
  implements DownloadListener
{
  c$1(c paramc) {}
  
  public void onDownloadStart(String paramString1, String paramString2, final String paramString3, String paramString4, long paramLong)
  {
    paramString2 = paramString1.substring(paramString1.lastIndexOf("."));
    c.c().a(this.a, paramString1 + "----on Download start:" + paramString2);
    if (Arrays.asList(c.d()).contains(paramString2))
    {
      paramString2 = null;
      if ((c.a(this.a) instanceof Activity)) {
        paramString2 = (Activity)c.a(this.a);
      }
      if ((paramString2 == null) || (!paramString2.isFinishing()))
      {
        c.a(this.a, true);
        c.b(this.a);
        Toast.makeText(c.a(this.a), "Loading video...", 0).show();
        paramString3 = new Dialog(c.a(this.a), 16973831);
        paramString3.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            c.c().b(c.1.this.a, "Video dialog dismissed.");
            c.a(c.1.this.a, false);
            c.c(c.1.this.a);
            if (c.d(c.1.this.a) == null) {
              c.1.this.a.b();
            }
          }
        });
        paramString2 = new VideoView(c.a(this.a));
        paramString2.setVideoURI(Uri.parse(paramString1));
        paramString1 = new MediaController(c.a(this.a));
        paramString1.setMediaPlayer(paramString2);
        paramString1.setAnchorView(paramString2);
        paramString2.setMediaController(paramString1);
        paramString2.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            c.c().e(c.1.this.a, "Video play error.");
            return false;
          }
        });
        paramString2.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            paramString3.dismiss();
          }
        });
        paramString4 = new RelativeLayout(c.a(this.a));
        paramString4.setBackgroundColor(-16777216);
        paramString4.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        paramString1 = new RelativeLayout.LayoutParams(-1, -1);
        paramString1.addRule(13);
        paramString4.addView(paramString2, paramString1);
        paramString3.setContentView(paramString4);
        paramString3.show();
        paramString2.start();
        paramString2.requestFocus();
      }
    }
    for (;;)
    {
      return;
      c.c().b("should not alert a dialog now");
      continue;
      if (c.e(this.a) != null) {
        c.e(this.a).a(paramString1, c.d(this.a), this.a.b);
      }
      if (c.f(this.a) != null) {
        c.f(this.a).a(paramString1, c.d(this.a), this.a.c);
      }
      if (c.g(this.a) != null) {
        c.g(this.a).a(paramString1, c.d(this.a), this.a.d);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a\c$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */