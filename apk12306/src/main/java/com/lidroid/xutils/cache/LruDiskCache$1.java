package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.util.concurrent.Callable;

class LruDiskCache$1
  implements Callable<Void>
{
  static
  {
    JniLib.a(1.class, 937);
  }
  
  LruDiskCache$1(LruDiskCache paramLruDiskCache) {}
  
  public native Void call()
    throws Exception;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */