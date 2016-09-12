package com.google.common.collect;

import com.bangcle.andjni.JniLib;

class Sets$InvertibleFunction$1
  extends Sets.InvertibleFunction<B, A>
{
  static
  {
    JniLib.a(1.class, 724);
  }
  
  Sets$InvertibleFunction$1(Sets.InvertibleFunction paramInvertibleFunction) {}
  
  public native A apply(B paramB);
  
  public native Sets.InvertibleFunction<A, B> inverse();
  
  native B invert(A paramA);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$InvertibleFunction$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */