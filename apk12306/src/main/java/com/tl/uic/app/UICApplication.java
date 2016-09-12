package com.tl.uic.app;

import android.app.Application;
import com.bangcle.andjni.JniLib;
import com.tl.uic.Tealeaf;

public class UICApplication
  extends Application
{
  private Tealeaf tealeaf;
  
  static
  {
    JniLib.a(UICApplication.class, 1088);
  }
  
  public final native Tealeaf getTealeaf();
  
  public native void onCreate();
  
  public native void onLowMemory();
  
  public native void onTerminate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\app\UICApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */