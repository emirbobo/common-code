package cn.dbox.core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Hashtable;

class d$2
  implements DialogInterface.OnClickListener
{
  d$2(d paramd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = (b)b.a.get(d.a(this.a));
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\d$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */