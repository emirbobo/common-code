package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$Relation$5
{
  SortedLists$Relation$5()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int exactMatchFound(List<? extends E> paramList, E paramE, int paramInt1, int paramInt2, int paramInt3, Comparator<? super E> paramComparator, boolean paramBoolean)
  {
    return CEILING.exactMatchFound(paramList, paramE, paramInt1, paramInt2, paramInt3, paramComparator, paramBoolean) + 1;
  }
  
  <E> int exactMatchNotFound(List<? extends E> paramList, E paramE, int paramInt, Comparator<? super E> paramComparator)
  {
    return paramInt;
  }
  
  SortedLists.Relation reverse()
  {
    return LOWER;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedLists$Relation$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */