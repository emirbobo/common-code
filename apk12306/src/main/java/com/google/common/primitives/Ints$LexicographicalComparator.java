package com.google.common.primitives;

import java.util.Comparator;

 enum Ints$LexicographicalComparator
  implements Comparator<int[]>
{
  INSTANCE;
  
  private Ints$LexicographicalComparator() {}
  
  public int compare(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int k = Math.min(paramArrayOfInt1.length, paramArrayOfInt2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = Ints.compare(paramArrayOfInt1[i], paramArrayOfInt2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfInt1.length - paramArrayOfInt2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Ints$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */