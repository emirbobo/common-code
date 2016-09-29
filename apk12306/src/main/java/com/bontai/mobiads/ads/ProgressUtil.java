package com.bontai.mobiads.ads;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.bangcle.andjni.JniLib;

public class ProgressUtil
{
  static
  {
    JniLib.a(ProgressUtil.class, 189);
  }
  
  public static native ProgressDialog getProgressDialog(Activity paramActivity);
  
  public static native ProgressDialog getProgressDialogContext(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\ProgressUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */