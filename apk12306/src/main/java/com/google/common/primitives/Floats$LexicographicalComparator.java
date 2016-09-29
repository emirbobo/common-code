package com.google.common.primitives;

import java.util.Comparator;

 enum Floats$LexicographicalComparator
  implements Comparator<float[]>
{
  INSTANCE;
  
  private Floats$LexicographicalComparator() {}
  
  public int compare(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    int k = Math.min(paramArrayOfFloat1.length, paramArrayOfFloat2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = Floats.compare(paramArrayOfFloat1[i], paramArrayOfFloat2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfFloat1.length - paramArrayOfFloat2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Floats$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */