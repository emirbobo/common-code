package com.worklight.androidgap.plugin;

import android.app.ProgressDialog;
import com.bangcle.andjni.JniLib;

public class MyBusyIndicator
  extends BusyIndicator
{
  private boolean isShowing = false;
  private ProgressDialog spinnerDialog = null;
  
  static
  {
    JniLib.a(MyBusyIndicator.class, 1180);
  }
  
  public native void hide();
  
  public native boolean isShowing();
  
  public native void show(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\MyBusyIndicator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */