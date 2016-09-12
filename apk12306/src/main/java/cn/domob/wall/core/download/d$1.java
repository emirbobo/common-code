package cn.domob.wall.core.download;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class d$1
  implements DialogInterface.OnClickListener
{
  d$1(d paramd, Context paramContext, Intent paramIntent) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (d.a(this.c) != null) {
      d.a(this.c).s(d.b(this.c));
    }
    this.a.startActivity(this.b);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\d$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */