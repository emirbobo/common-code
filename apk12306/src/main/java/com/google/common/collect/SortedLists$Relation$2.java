package com.google.common.collect;

import java.util.Comparator;
import java.util.List;

 enum SortedLists$Relation$2
{
  SortedLists$Relation$2()
  {
    super(paramString, paramInt, null);
  }
  
  <E> int exactMatchFound(List<? extends E> paramList, E paramE, int paramInt1, int paramInt2, int paramInt3, Comparator<? super E> paramComparator, boolean paramBoolean)
  {
    if (!paramBoolean) {
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      return paramInt1;
      while (paramInt1 < paramInt2)
      {
        paramInt3 = paramInt1 + (paramInt2 - paramInt1) / 2;
        if (paramComparator.compare(paramList.get(paramInt3), paramE) < 0) {
          paramInt1 = paramInt3 + 1;
        } else {
          paramInt2 = paramInt3;
        }
      }
    }
  }
  
  <E> int exactMatchNotFound(List<? extends E> paramList, E paramE, int paramInt, Comparator<? super E> paramComparator)
  {
    return paramInt - 1;
  }
  
  SortedLists.Relation reverse()
  {
    return CEILING;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\SortedLists$Relation$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */