package cn.dbox.ui.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.DownloadListener;

class e$3
  implements DownloadListener
{
  e$3(e parame) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse(paramString1));
    this.a.e.startActivity(paramString1);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\e$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */