package cn.domob.android.offerwall;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cn.domob.android.a.a;
import cn.domob.android.a.c;
import java.util.Hashtable;

class DomobActivity$2
  implements DialogInterface.OnClickListener
{
  DomobActivity$2(DomobActivity paramDomobActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (a)a.a.get(DomobActivity.a(this.a));
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\DomobActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */