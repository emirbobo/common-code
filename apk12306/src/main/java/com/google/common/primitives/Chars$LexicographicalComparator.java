package com.google.common.primitives;

import java.util.Comparator;

 enum Chars$LexicographicalComparator
  implements Comparator<char[]>
{
  INSTANCE;
  
  private Chars$LexicographicalComparator() {}
  
  public int compare(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    int k = Math.min(paramArrayOfChar1.length, paramArrayOfChar2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = Chars.compare(paramArrayOfChar1[i], paramArrayOfChar2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfChar1.length - paramArrayOfChar2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\Chars$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */