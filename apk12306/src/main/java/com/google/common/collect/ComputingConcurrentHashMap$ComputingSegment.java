package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class ComputingConcurrentHashMap$ComputingSegment
  extends CustomConcurrentHashMap.Segment
{
  static
  {
    JniLib.a(ComputingSegment.class, 379);
  }
  
  ComputingConcurrentHashMap$ComputingSegment(ComputingConcurrentHashMap paramComputingConcurrentHashMap, int paramInt1, int paramInt2)
  {
    super(paramComputingConcurrentHashMap, paramInt1, paramInt2);
  }
  
  native V compute(K paramK, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComputingConcurrentHashMap$ComputingSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */