package com.tl.uic;

import android.os.Handler;
import com.bangcle.andjni.JniLib;
import java.util.TimerTask;

class EnvironmentalData$1
  extends TimerTask
{
  static
  {
    JniLib.a(1.class, 1080);
  }
  
  EnvironmentalData$1(EnvironmentalData paramEnvironmentalData, Handler paramHandler) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\EnvironmentalData$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */