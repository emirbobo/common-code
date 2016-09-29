package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.Comparator;

@Beta
public final class MinMaxPriorityQueue$Builder<B>
{
  private static final int UNSET_EXPECTED_SIZE = -1;
  private final Comparator<B> comparator;
  private int expectedSize = -1;
  private int maximumSize = Integer.MAX_VALUE;
  
  static
  {
    JniLib.a(Builder.class, 643);
  }
  
  private MinMaxPriorityQueue$Builder(Comparator<B> paramComparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  private native <T extends B> Ordering<T> ordering();
  
  public native <T extends B> MinMaxPriorityQueue<T> create();
  
  public native <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> paramIterable);
  
  public native Builder<B> expectedSize(int paramInt);
  
  public native Builder<B> maximumSize(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\MinMaxPriorityQueue$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */