package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.base.Function;

abstract class Sets$InvertibleFunction<A, B>
  implements Function<A, B>
{
  public InvertibleFunction<B, A> inverse()
  {
    new InvertibleFunction()
    {
      static
      {
        JniLib.a(1.class, 724);
      }
      
      public native A apply(B paramAnonymousB);
      
      public native Sets.InvertibleFunction<A, B> inverse();
      
      native B invert(A paramAnonymousA);
    };
  }
  
  abstract A invert(B paramB);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Sets$InvertibleFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */