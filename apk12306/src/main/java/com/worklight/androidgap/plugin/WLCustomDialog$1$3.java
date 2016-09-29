package com.worklight.androidgap.plugin;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

class WLCustomDialog$1$3
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(3.class, 1196);
  }
  
  WLCustomDialog$1$3(WLCustomDialog.1 param1) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WLCustomDialog$1$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */