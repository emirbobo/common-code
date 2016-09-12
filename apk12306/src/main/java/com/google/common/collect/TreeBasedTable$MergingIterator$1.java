package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.util.Comparator;

class TreeBasedTable$MergingIterator$1
  implements Comparator<PeekingIterator<T>>
{
  static
  {
    JniLib.a(1.class, 806);
  }
  
  TreeBasedTable$MergingIterator$1(TreeBasedTable.MergingIterator paramMergingIterator) {}
  
  public native int compare(PeekingIterator<T> paramPeekingIterator1, PeekingIterator<T> paramPeekingIterator2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\TreeBasedTable$MergingIterator$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */