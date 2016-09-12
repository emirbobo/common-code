package cn.domob.android.ads.a;

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
import cn.domob.android.i.f;
import java.util.Arrays;
import java.util.List;

class d$7
  implements DownloadListener
{
  d$7(d paramd) {}
  
  public void onDownloadStart(String paramString1, final String paramString2, String paramString3, String paramString4, long paramLong)
  {
    paramString2 = paramString1.substring(paramString1.lastIndexOf("."));
    d.b().a(this.a, paramString1 + "----on Download start:" + paramString2);
    if (Arrays.asList(d.c()).contains(paramString2))
    {
      paramString2 = null;
      if ((d.e(this.a) instanceof Activity)) {
        paramString2 = (Activity)d.e(this.a);
      }
      if ((paramString2 == null) || (!paramString2.isFinishing()))
      {
        d.a(this.a, true);
        d.f(this.a);
        Toast.makeText(d.e(this.a), "Loading video...", 0).show();
        paramString2 = new Dialog(d.e(this.a), 16973831);
        paramString2.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            d.b().b(d.7.this.a, "Video dialog dismissed.");
            d.a(d.7.this.a, false);
            d.g(d.7.this.a);
            if (d.h(d.7.this.a) == null) {
              d.i(d.7.this.a);
            }
          }
        });
        paramString3 = new VideoView(d.e(this.a));
        paramString3.setVideoURI(Uri.parse(paramString1));
        paramString1 = new MediaController(d.e(this.a));
        paramString1.setMediaPlayer(paramString3);
        paramString1.setAnchorView(paramString3);
        paramString3.setMediaController(paramString1);
        paramString3.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            d.b().e(d.7.this.a, "Video play error.");
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
        paramString4 = new RelativeLayout(d.e(this.a));
        paramString4.setBackgroundColor(-16777216);
        paramString4.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        paramString1 = new RelativeLayout.LayoutParams(-1, -1);
        paramString1.addRule(13);
        paramString4.addView(paramString3, paramString1);
        paramString2.setContentView(paramString4);
        paramString2.show();
        paramString3.start();
        paramString3.requestFocus();
      }
    }
    for (;;)
    {
      return;
      d.b().b("should not alert a dialog now");
      continue;
      if (d.c(this.a) != null) {
        d.c(this.a).a(paramString1, d.h(this.a));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */