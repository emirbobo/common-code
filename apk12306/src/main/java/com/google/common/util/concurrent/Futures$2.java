package com.google.common.util.concurrent;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

final class Futures$2
  implements Function<Exception, X>
{
  static
  {
    JniLib.a(2.class, 892);
  }
  
  public native X apply(Exception paramException);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\util\concurrent\Futures$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */