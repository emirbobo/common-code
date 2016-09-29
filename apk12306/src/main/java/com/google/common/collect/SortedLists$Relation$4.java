package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$Relation$4
{
  SortedLists$Relation$4()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int exactMatchFound(List<? extends E> paramList, E paramE, int paramInt1, int paramInt2, int paramInt3, Comparator<? super E> paramComparator, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (;;)
    {
      return paramInt2;
      paramInt1 = paramInt2;
      while (paramInt1 < paramInt3)
      {
        paramInt2 = paramInt1 + (paramInt3 - paramInt1 + 1) / 2;
        if (paramComparator.compare(paramList.get(paramInt2), paramE) > 0) {
          paramInt3 = paramInt2 - 1;
        } else {
          paramInt1 = paramInt2;
        }
      }
      paramInt2 = paramInt1;
    }
  }
  
  <E> int exactMatchNotFound(List<? extends E> paramList, E paramE, int paramInt, Comparator<? super E> paramComparator)
  {
    return paramInt;
  }
  
  SortedLists.Relation reverse()
  {
    return FLOOR;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedLists$Relation$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */