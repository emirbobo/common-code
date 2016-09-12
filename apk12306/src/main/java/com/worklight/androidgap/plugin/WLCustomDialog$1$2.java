package com.worklight.androidgap.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

class WLCustomDialog$1$2
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(2.class, 1195);
  }
  
  WLCustomDialog$1$2(WLCustomDialog.1 param1) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLCustomDialog$1$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */