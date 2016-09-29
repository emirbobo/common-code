package com.worklight.common;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Callable;

final class Logger$3
  implements Callable<Logger.LEVEL>
{
  static
  {
    JniLib.a(3.class, 1247);
  }
  
  public native Logger.LEVEL call();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */