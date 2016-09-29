package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$Relation$1
{
  SortedLists$Relation$1()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int exactMatchFound(List<? extends E> paramList, E paramE, int paramInt1, int paramInt2, int paramInt3, Comparator<? super E> paramComparator, boolean paramBoolean)
  {
    return FLOOR.exactMatchFound(paramList, paramE, paramInt1, paramInt2, paramInt3, paramComparator, paramBoolean) - 1;
  }
  
  <E> int exactMatchNotFound(List<? extends E> paramList, E paramE, int paramInt, Comparator<? super E> paramComparator)
  {
    return paramInt - 1;
  }
  
  SortedLists.Relation reverse()
  {
    return HIGHER;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedLists$Relation$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */