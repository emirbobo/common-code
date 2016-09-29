package com.google.common.primitives;

import java.util.Comparator;

 enum SignedBytes$LexicographicalComparator
  implements Comparator<byte[]>
{
  INSTANCE;
  
  private SignedBytes$LexicographicalComparator() {}
  
  public int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int k = Math.min(paramArrayOfByte1.length, paramArrayOfByte2.length);
    int i = 0;
    int j;
    if (i < k)
    {
      j = SignedBytes.compare(paramArrayOfByte1[i], paramArrayOfByte2[i]);
      if (j == 0) {}
    }
    for (i = j;; i = paramArrayOfByte1.length - paramArrayOfByte2.length)
    {
      return i;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\primitives\SignedBytes$LexicographicalComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */