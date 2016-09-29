package cn.dbox.core.d;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class e$1
  implements DialogInterface.OnClickListener
{
  e$1(e parame, Context paramContext, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (e.a(this.c) != null) {
      e.a(this.c).m(e.b(this.c));
    }
    this.a.startActivity(this.b);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\e$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */