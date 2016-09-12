package com.google.common.primitives;

import java.util.Comparator;

 enum Longs$LexicographicalComparator
  implements Comparator<long[]>
{
  INSTANCE;
  
  private Longs$LexicographicalComparator() {}
  
  public int compare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int k = Math.min(paramArrayOfLong1.length, paramArrayOfLong2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = Longs.compare(paramArrayOfLong1[i], paramArrayOfLong2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfLong1.length - paramArrayOfLong2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Longs$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */