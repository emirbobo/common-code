package cn.domob.wall.core.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Hashtable;

class DownloadCancelActivity$2
  implements DialogInterface.OnClickListener
{
  DownloadCancelActivity$2(DownloadCancelActivity paramDownloadCancelActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (b)b.a.get(DownloadCancelActivity.a(this.a));
    if (paramDialogInterface != null)
    {
      paramDialogInterface.b();
      paramDialogInterface = paramDialogInterface.a();
      if (paramDialogInterface != null) {
        paramDialogInterface.b();
      }
    }
    this.a.finish();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\DownloadCancelActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */