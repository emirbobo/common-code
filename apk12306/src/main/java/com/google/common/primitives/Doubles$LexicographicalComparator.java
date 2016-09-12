package com.google.common.primitives;

import java.util.Comparator;

 enum Doubles$LexicographicalComparator
  implements Comparator<double[]>
{
  INSTANCE;
  
  private Doubles$LexicographicalComparator() {}
  
  public int compare(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    int k = Math.min(paramArrayOfDouble1.length, paramArrayOfDouble2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = Doubles.compare(paramArrayOfDouble1[i], paramArrayOfDouble2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfDouble1.length - paramArrayOfDouble2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Doubles$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */