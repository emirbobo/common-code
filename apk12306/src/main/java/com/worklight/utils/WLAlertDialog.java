package com.worklight.utils;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.bangcle.andjni.JniLib;

public final class WLAlertDialog
  implements Runnable
{
  public static final DialogInterface.OnClickListener exitListener = new DialogInterface.OnClickListener()
  {
    static
    {
      JniLib.a(1.class, 1278);
    }
    
    public native void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt);
  };
  private DialogInterface.OnClickListener clickListener;
  private String message;
  private String positiveButtonText;
  private String title;
  
  static
  {
    JniLib.a(WLAlertDialog.class, 1279);
  }
  
  public WLAlertDialog() {}
  
  public WLAlertDialog(String paramString1, String paramString2)
  {
    init(paramString1, paramString2, "WLClient.close");
  }
  
  public WLAlertDialog(String paramString1, String paramString2, String paramString3)
  {
    init(paramString1, paramString2, paramString3);
  }
  
  private native void init(String paramString1, String paramString2, String paramString3);
  
  public native DialogInterface.OnClickListener getClickListener();
  
  public native String getMessage();
  
  public native String getPositiveButtonText();
  
  public native String getTitle();
  
  public native void run();
  
  public native void setClickListener(DialogInterface.OnClickListener paramOnClickListener);
  
  public native void setMessage(String paramString);
  
  public native void setPositiveButtonText(String paramString);
  
  public native void setTitle(String paramString);
  
  public native void show();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\utils\WLAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */