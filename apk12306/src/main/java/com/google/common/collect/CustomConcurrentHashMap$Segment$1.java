package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class CustomConcurrentHashMap$Segment$1
  implements Runnable
{
  static
  {
    JniLib.a(1.class, 402);
  }
  
  CustomConcurrentHashMap$Segment$1(CustomConcurrentHashMap.Segment paramSegment) {}
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\CustomConcurrentHashMap$Segment$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */