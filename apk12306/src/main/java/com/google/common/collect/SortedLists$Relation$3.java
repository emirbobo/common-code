package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$Relation$3
{
  SortedLists$Relation$3()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int exactMatchFound(List<? extends E> paramList, E paramE, int paramInt1, int paramInt2, int paramInt3, Comparator<? super E> paramComparator, boolean paramBoolean)
  {
    return paramInt2;
  }
  
  <E> int exactMatchNotFound(List<? extends E> paramList, E paramE, int paramInt, Comparator<? super E> paramComparator)
  {
    return -1;
  }
  
  SortedLists.Relation reverse()
  {
    return this;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedLists$Relation$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */