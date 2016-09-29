package com.google.common.primitives;

import java.util.Comparator;

 enum Booleans$LexicographicalComparator
  implements Comparator<boolean[]>
{
  INSTANCE;
  
  private Booleans$LexicographicalComparator() {}
  
  public int compare(boolean[] paramArrayOfBoolean1, boolean[] paramArrayOfBoolean2)
  {
    int k = Math.min(paramArrayOfBoolean1.length, paramArrayOfBoolean2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = Booleans.compare(paramArrayOfBoolean1[i], paramArrayOfBoolean2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfBoolean1.length - paramArrayOfBoolean2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Booleans$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */