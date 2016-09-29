package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;
import javax.annotation.Nullable;

final class ComparisonChain$1
  extends ComparisonChain
{
  static
  {
    JniLib.a(1.class, 373);
  }
  
  ComparisonChain$1()
  {
    super(null);
  }
  
  native ComparisonChain classify(int paramInt);
  
  public native ComparisonChain compare(double paramDouble1, double paramDouble2);
  
  public native ComparisonChain compare(float paramFloat1, float paramFloat2);
  
  public native ComparisonChain compare(int paramInt1, int paramInt2);
  
  public native ComparisonChain compare(long paramLong1, long paramLong2);
  
  public native ComparisonChain compare(Comparable paramComparable1, Comparable paramComparable2);
  
  public native <T> ComparisonChain compare(@Nullable T paramT1, @Nullable T paramT2, Comparator<T> paramComparator);
  
  public native ComparisonChain compare(boolean paramBoolean1, boolean paramBoolean2);
  
  public native int result();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\ComparisonChain$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */