public final class kj
{
  static
  {
    "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
  }
  
  private static final long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = 0;
    long l3 = 0L;
    int i = paramInt2;
    paramInt2 = j;
    if (i > 0)
    {
      i--;
      j = paramArrayOfByte[paramInt1];
      if (j != 47) {
        break label152;
      }
    }
    label152:
    for (long l2 = 1L;; l2 = 0L)
    {
      long l1 = l2;
      if (j >= 48)
      {
        l1 = l2;
        if (j <= 57) {
          l1 = j + 2 - 48;
        }
      }
      l2 = l1;
      if (j >= 65)
      {
        l2 = l1;
        if (j <= 90) {
          l2 = j + 12 - 65;
        }
      }
      l1 = l2;
      if (j >= 97)
      {
        l1 = l2;
        if (j <= 122) {
          l1 = j + 38 - 97;
        }
      }
      l3 += (l1 << paramInt2);
      paramInt2 += 6;
      paramInt1++;
      break;
      return l3;
    }
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.getBytes();
    int k = paramString.length;
    byte[] arrayOfByte = new byte[k * 3 / 4];
    int i = 0;
    long l;
    int m;
    for (int j = 0; k >= 4; j = m)
    {
      l = a(paramString, j, 4);
      k -= 4;
      m = j + 4;
      for (j = 2; j >= 0; j--)
      {
        arrayOfByte[(i + j)] = ((byte)(byte)(int)(0xFF & l));
        l >>= 8;
      }
      i += 3;
    }
    if (k == 3)
    {
      l = a(paramString, j, 3);
      for (m = 1; m >= 0; m--)
      {
        arrayOfByte[(i + m)] = ((byte)(byte)(int)(0xFF & l));
        l >>= 8;
      }
    }
    if (k == 2) {
      arrayOfByte[i] = ((byte)(byte)(int)(a(paramString, j, 2) & 0xFF));
    }
    return arrayOfByte;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */