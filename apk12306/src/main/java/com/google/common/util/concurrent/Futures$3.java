package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

final class Futures$3
  implements Function<Exception, X>
{
  static
  {
    JniLib.a(3.class, 893);
  }
  
  Futures$3(Exception paramException) {}
  
  public native X apply(Exception paramException);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */