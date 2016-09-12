package com.worklight.common;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

final class WLUtils$2
  implements Runnable
{
  static
  {
    JniLib.a(2.class, 1267);
  }
  
  WLUtils$2(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLUtils$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */