package com.phonegap.plugins.childBrowser;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

class ChildBrowser$9
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(9.class, 1050);
  }
  
  ChildBrowser$9(ChildBrowser paramChildBrowser) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\phonegap\plugins\childBrowser\ChildBrowser$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */