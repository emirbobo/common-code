package com.google.common.primitives;

import java.util.Comparator;

 enum Shorts$LexicographicalComparator
  implements Comparator<short[]>
{
  INSTANCE;
  
  private Shorts$LexicographicalComparator() {}
  
  public int compare(short[] paramArrayOfShort1, short[] paramArrayOfShort2)
  {
    int k = Math.min(paramArrayOfShort1.length, paramArrayOfShort2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = Shorts.compare(paramArrayOfShort1[i], paramArrayOfShort2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfShort1.length - paramArrayOfShort2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Shorts$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */