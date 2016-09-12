package com.bontai.mobiads.ads;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;
import java.io.File;

class AppHelp$1
  implements DialogInterface.OnClickListener
{
  static
  {
    JniLib.a(1.class, 182);
  }
  
  AppHelp$1(Context paramContext, File paramFile, String paramString) {}
  
  public native void onClick(DialogInterface paramDialogInterface, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\AppHelp$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */