package com.google.common.base;

import com.bangcle.andjni.JniLib;

class FinalizableReferenceQueue$SystemLoader
  implements FinalizableReferenceQueue.FinalizerLoader
{
  static
  {
    JniLib.a(SystemLoader.class, 281);
  }
  
  public native Class<?> loadFinalizer();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\FinalizableReferenceQueue$SystemLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */