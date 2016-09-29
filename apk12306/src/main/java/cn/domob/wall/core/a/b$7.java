package cn.domob.wall.core.a;

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
import cn.domob.wall.core.h.d;
import java.util.Arrays;
import java.util.List;

class b$7
  implements DownloadListener
{
  b$7(b paramb) {}
  
  public void onDownloadStart(String paramString1, final String paramString2, String paramString3, String paramString4, long paramLong)
  {
    paramString2 = paramString1.substring(paramString1.lastIndexOf("."));
    b.b().a(this.a, paramString1 + "----on Download start:" + paramString2);
    if (Arrays.asList(b.c()).contains(paramString2))
    {
      paramString2 = null;
      if ((b.e(this.a) instanceof Activity)) {
        paramString2 = (Activity)b.e(this.a);
      }
      if ((paramString2 == null) || (!paramString2.isFinishing()))
      {
        b.a(this.a, true);
        b.f(this.a);
        Toast.makeText(b.e(this.a), "Loading video...", 0).show();
        paramString2 = new Dialog(b.e(this.a), 16973831);
        paramString2.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            b.b().b(b.7.this.a, "Video dialog dismissed.");
            b.a(b.7.this.a, false);
            b.g(b.7.this.a);
            if (b.h(b.7.this.a) == null) {
              b.i(b.7.this.a);
            }
          }
        });
        paramString3 = new VideoView(b.e(this.a));
        paramString3.setVideoURI(Uri.parse(paramString1));
        paramString1 = new MediaController(b.e(this.a));
        paramString1.setMediaPlayer(paramString3);
        paramString1.setAnchorView(paramString3);
        paramString3.setMediaController(paramString1);
        paramString3.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            b.b().e(b.7.this.a, "Video play error.");
            return false;
          }
        });
        paramString3.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            paramString2.dismiss();
          }
        });
        paramString1 = new RelativeLayout(b.e(this.a));
        paramString1.setBackgroundColor(-16777216);
        paramString1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        paramString4 = new RelativeLayout.LayoutParams(-1, -1);
        paramString4.addRule(13);
        paramString1.addView(paramString3, paramString4);
        paramString2.setContentView(paramString1);
        paramString2.show();
        paramString3.start();
        paramString3.requestFocus();
      }
    }
    for (;;)
    {
      return;
      b.b().b("should not alert a dialog now");
      continue;
      if (b.c(this.a) != null) {
        b.c(this.a).a(paramString1, b.h(this.a), this.a.a);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */