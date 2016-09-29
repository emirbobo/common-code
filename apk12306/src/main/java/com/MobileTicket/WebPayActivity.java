package com.MobileTicket;

import android.app.Activity;
import android.os.Bundle;
import com.bangcle.andjni.JniLib;

public class WebPayActivity
  extends Activity
{
  private static boolean callJSFlag = false;
  
  static
  {
    JniLib.a(WebPayActivity.class, 20);
  }
  
  public static native boolean isCallJSFlag();
  
  public static native void setCallJSFlag(boolean paramBoolean);
  
  public native void onCreate(Bundle paramBundle);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\WebPayActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */