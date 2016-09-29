package com.worklight.wlclient.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

class UIActivity$2
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(2.class, 1320);
  }
  
  UIActivity$2(UIActivity paramUIActivity, String paramString) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\wlclient\ui\UIActivity$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */