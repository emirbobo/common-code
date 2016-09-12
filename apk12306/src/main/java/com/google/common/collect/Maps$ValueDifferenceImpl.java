package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import javax.annotation.Nullable;

class Maps$ValueDifferenceImpl<V>
  implements MapDifference.ValueDifference<V>
{
  private final V left;
  private final V right;
  
  static
  {
    JniLib.a(ValueDifferenceImpl.class, 641);
  }
  
  Maps$ValueDifferenceImpl(@Nullable V paramV1, @Nullable V paramV2)
  {
    this.left = paramV1;
    this.right = paramV2;
  }
  
  public native boolean equals(@Nullable Object paramObject);
  
  public native int hashCode();
  
  public native V leftValue();
  
  public native V rightValue();
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Maps$ValueDifferenceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */