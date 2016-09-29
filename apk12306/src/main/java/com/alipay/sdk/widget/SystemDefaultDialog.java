package com.alipay.sdk.widget;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.bangcle.andjni.JniLib;

public class SystemDefaultDialog
{
  private static boolean a;
  
  static
  {
    JniLib.a(SystemDefaultDialog.class, 144);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private static native AlertDialog.Builder a(Context paramContext, String paramString1, String paramString2, DialogInterface.OnClickListener paramOnClickListener1, String paramString3, DialogInterface.OnClickListener paramOnClickListener2);
  
  public static native Dialog a(Context paramContext, String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, String paramString4, DialogInterface.OnClickListener paramOnClickListener2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\widget\SystemDefaultDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */