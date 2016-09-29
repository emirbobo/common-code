package org.codehaus.jackson.io;

public final class NumberOutput
{
  private static int BILLION;
  static final char[] FULL_TRIPLETS;
  static final byte[] FULL_TRIPLETS_B;
  static final char[] LEADING_TRIPLETS;
  private static long MAX_INT_AS_LONG;
  private static int MILLION = 1000000;
  private static long MIN_INT_AS_LONG;
  private static final char NULL_CHAR = '\000';
  static final String SMALLEST_LONG;
  private static long TEN_BILLION_L;
  private static long THOUSAND_L;
  static final String[] sSmallIntStrs = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
  static final String[] sSmallIntStrs2 = { "-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10" };
  
  static
  {
    BILLION = 1000000000;
    TEN_BILLION_L = 10000000000L;
    THOUSAND_L = 1000L;
    MIN_INT_AS_LONG = -2147483648L;
    MAX_INT_AS_LONG = 2147483647L;
    SMALLEST_LONG = String.valueOf(Long.MIN_VALUE);
    LEADING_TRIPLETS = new char['ྠ'];
    FULL_TRIPLETS = new char['ྠ'];
    int n = 0;
    label213:
    for (int i = 0; i < 10; i++)
    {
      int i2 = (char)(i + 48);
      int j;
      if (i == 0) {
        j = 0;
      }
      for (int k = 0;; k++)
      {
        if (k >= 10) {
          break label213;
        }
        int i3 = (char)(k + 48);
        if ((i == 0) && (k == 0)) {}
        for (int m = 0;; m = i3)
        {
          for (int i1 = 0; i1 < 10; i1++)
          {
            int i4 = (char)(i1 + 48);
            LEADING_TRIPLETS[n] = ((char)j);
            LEADING_TRIPLETS[(n + 1)] = ((char)m);
            LEADING_TRIPLETS[(n + 2)] = ((char)i4);
            FULL_TRIPLETS[n] = ((char)i2);
            FULL_TRIPLETS[(n + 1)] = ((char)i3);
            FULL_TRIPLETS[(n + 2)] = ((char)i4);
            n += 4;
          }
          j = i2;
          break;
        }
      }
    }
    FULL_TRIPLETS_B = new byte['ྠ'];
    for (i = 0; i < 4000; i++) {
      FULL_TRIPLETS_B[i] = ((byte)(byte)FULL_TRIPLETS[i]);
    }
  }
  
  private static int calcLongStrLength(long paramLong)
  {
    int i = 10;
    for (long l = TEN_BILLION_L;; l = (l << 3) + (l << 1))
    {
      if ((paramLong < l) || (i == 19)) {
        return i;
      }
      i++;
    }
  }
  
  private static int outputFullTriplet(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int j = paramInt1 << 2;
    paramInt1 = paramInt2 + 1;
    byte[] arrayOfByte = FULL_TRIPLETS_B;
    int i = j + 1;
    paramArrayOfByte[paramInt2] = ((byte)arrayOfByte[j]);
    paramInt2 = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = ((byte)FULL_TRIPLETS_B[i]);
    paramArrayOfByte[paramInt2] = ((byte)FULL_TRIPLETS_B[(i + 1)]);
    return paramInt2 + 1;
  }
  
  private static int outputFullTriplet(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int j = paramInt1 << 2;
    int i = paramInt2 + 1;
    char[] arrayOfChar = FULL_TRIPLETS;
    paramInt1 = j + 1;
    paramArrayOfChar[paramInt2] = ((char)arrayOfChar[j]);
    paramInt2 = i + 1;
    paramArrayOfChar[i] = ((char)FULL_TRIPLETS[paramInt1]);
    paramArrayOfChar[paramInt2] = ((char)FULL_TRIPLETS[(paramInt1 + 1)]);
    return paramInt2 + 1;
  }
  
  public static int outputInt(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt1 < 0)
    {
      if (paramInt1 == Integer.MIN_VALUE)
      {
        paramInt1 = outputLong(paramInt1, paramArrayOfByte, paramInt2);
        return paramInt1;
      }
      paramArrayOfByte[paramInt2] = ((byte)45);
      j = -paramInt1;
      i = paramInt2 + 1;
    }
    if (j < MILLION)
    {
      if (j < 1000) {
        if (j < 10)
        {
          paramArrayOfByte[i] = ((byte)(byte)(j + 48));
          paramInt1 = i + 1;
        }
      }
      for (;;)
      {
        break;
        paramInt1 = outputLeadingTriplet(j, paramArrayOfByte, i);
        continue;
        paramInt1 = j / 1000;
        paramInt1 = outputFullTriplet(j - paramInt1 * 1000, paramArrayOfByte, outputLeadingTriplet(paramInt1, paramArrayOfByte, i));
      }
    }
    int k;
    if (j >= BILLION)
    {
      k = 1;
      label130:
      paramInt1 = j;
      paramInt2 = i;
      if (k != 0)
      {
        paramInt1 = j - BILLION;
        if (paramInt1 < BILLION) {
          break label231;
        }
        paramInt1 -= BILLION;
        paramArrayOfByte[i] = ((byte)50);
        paramInt2 = i + 1;
      }
      label170:
      j = paramInt1 / 1000;
      i = j / 1000;
      if (k == 0) {
        break label244;
      }
    }
    label231:
    label244:
    for (paramInt2 = outputFullTriplet(i, paramArrayOfByte, paramInt2);; paramInt2 = outputLeadingTriplet(i, paramArrayOfByte, paramInt2))
    {
      paramInt1 = outputFullTriplet(paramInt1 - j * 1000, paramArrayOfByte, outputFullTriplet(j - i * 1000, paramArrayOfByte, paramInt2));
      break;
      k = 0;
      break label130;
      paramArrayOfByte[i] = ((byte)49);
      paramInt2 = i + 1;
      break label170;
    }
  }
  
  public static int outputInt(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt1 < 0)
    {
      if (paramInt1 == Integer.MIN_VALUE)
      {
        paramInt1 = outputLong(paramInt1, paramArrayOfChar, paramInt2);
        return paramInt1;
      }
      paramArrayOfChar[paramInt2] = ((char)45);
      j = -paramInt1;
      i = paramInt2 + 1;
    }
    if (j < MILLION)
    {
      if (j < 1000) {
        if (j < 10)
        {
          paramArrayOfChar[i] = ((char)(char)(j + 48));
          paramInt1 = i + 1;
        }
      }
      for (;;)
      {
        break;
        paramInt1 = outputLeadingTriplet(j, paramArrayOfChar, i);
        continue;
        paramInt1 = j / 1000;
        paramInt1 = outputFullTriplet(j - paramInt1 * 1000, paramArrayOfChar, outputLeadingTriplet(paramInt1, paramArrayOfChar, i));
      }
    }
    int k;
    if (j >= BILLION)
    {
      k = 1;
      label130:
      paramInt1 = j;
      paramInt2 = i;
      if (k != 0)
      {
        paramInt1 = j - BILLION;
        if (paramInt1 < BILLION) {
          break label230;
        }
        paramInt1 -= BILLION;
        paramArrayOfChar[i] = ((char)50);
        paramInt2 = i + 1;
      }
      label170:
      i = paramInt1 / 1000;
      j = i / 1000;
      if (k == 0) {
        break label243;
      }
    }
    label230:
    label243:
    for (paramInt2 = outputFullTriplet(j, paramArrayOfChar, paramInt2);; paramInt2 = outputLeadingTriplet(j, paramArrayOfChar, paramInt2))
    {
      paramInt1 = outputFullTriplet(paramInt1 - i * 1000, paramArrayOfChar, outputFullTriplet(i - j * 1000, paramArrayOfChar, paramInt2));
      break;
      k = 0;
      break label130;
      paramArrayOfChar[i] = ((char)49);
      paramInt2 = i + 1;
      break label170;
    }
  }
  
  private static int outputLeadingTriplet(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramInt1 <<= 2;
    char[] arrayOfChar = LEADING_TRIPLETS;
    int i = paramInt1 + 1;
    int j = arrayOfChar[paramInt1];
    paramInt1 = paramInt2;
    if (j != 0)
    {
      paramArrayOfByte[paramInt2] = ((byte)(byte)j);
      paramInt1 = paramInt2 + 1;
    }
    j = LEADING_TRIPLETS[i];
    paramInt2 = paramInt1;
    if (j != 0)
    {
      paramArrayOfByte[paramInt1] = ((byte)(byte)j);
      paramInt2 = paramInt1 + 1;
    }
    paramArrayOfByte[paramInt2] = ((byte)(byte)LEADING_TRIPLETS[(i + 1)]);
    return paramInt2 + 1;
  }
  
  private static int outputLeadingTriplet(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    paramInt1 <<= 2;
    char[] arrayOfChar = LEADING_TRIPLETS;
    int i = paramInt1 + 1;
    int j = arrayOfChar[paramInt1];
    paramInt1 = paramInt2;
    if (j != 0)
    {
      paramArrayOfChar[paramInt2] = ((char)j);
      paramInt1 = paramInt2 + 1;
    }
    j = LEADING_TRIPLETS[i];
    paramInt2 = paramInt1;
    if (j != 0)
    {
      paramArrayOfChar[paramInt1] = ((char)j);
      paramInt2 = paramInt1 + 1;
    }
    paramArrayOfChar[paramInt2] = ((char)LEADING_TRIPLETS[(i + 1)]);
    return paramInt2 + 1;
  }
  
  public static int outputLong(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramLong < 0L) {
      if (paramLong > MIN_INT_AS_LONG) {
        paramInt = outputInt((int)paramLong, paramArrayOfByte, paramInt);
      }
    }
    for (;;)
    {
      return paramInt;
      int j;
      int i;
      if (paramLong == Long.MIN_VALUE)
      {
        j = SMALLEST_LONG.length();
        i = 0;
        while (i < j)
        {
          paramArrayOfByte[paramInt] = ((byte)(byte)SMALLEST_LONG.charAt(i));
          i++;
          paramInt++;
        }
      }
      else
      {
        paramArrayOfByte[paramInt] = ((byte)45);
        long l = -paramLong;
        i = paramInt + 1;
        do
        {
          j = i + calcLongStrLength(l);
          paramInt = j;
          while (l > MAX_INT_AS_LONG)
          {
            paramInt -= 3;
            paramLong = l / THOUSAND_L;
            outputFullTriplet((int)(l - THOUSAND_L * paramLong), paramArrayOfByte, paramInt);
            l = paramLong;
          }
          l = paramLong;
          i = paramInt;
        } while (paramLong > MAX_INT_AS_LONG);
        paramInt = outputInt((int)paramLong, paramArrayOfByte, paramInt);
        continue;
        int m = (int)l;
        int k = paramInt;
        for (paramInt = m; paramInt >= 1000; paramInt = m)
        {
          k -= 3;
          m = paramInt / 1000;
          outputFullTriplet(paramInt - m * 1000, paramArrayOfByte, k);
        }
        outputLeadingTriplet(paramInt, paramArrayOfByte, i);
        paramInt = j;
      }
    }
  }
  
  public static int outputLong(long paramLong, char[] paramArrayOfChar, int paramInt)
  {
    if (paramLong < 0L) {
      if (paramLong > MIN_INT_AS_LONG) {
        paramInt = outputInt((int)paramLong, paramArrayOfChar, paramInt);
      }
    }
    for (;;)
    {
      return paramInt;
      int i;
      if (paramLong == Long.MIN_VALUE)
      {
        i = SMALLEST_LONG.length();
        SMALLEST_LONG.getChars(0, i, paramArrayOfChar, paramInt);
        paramInt += i;
      }
      else
      {
        paramArrayOfChar[paramInt] = ((char)45);
        long l = -paramLong;
        i = paramInt + 1;
        int j;
        do
        {
          j = i + calcLongStrLength(l);
          paramInt = j;
          while (l > MAX_INT_AS_LONG)
          {
            paramInt -= 3;
            paramLong = l / THOUSAND_L;
            outputFullTriplet((int)(l - THOUSAND_L * paramLong), paramArrayOfChar, paramInt);
            l = paramLong;
          }
          l = paramLong;
          i = paramInt;
        } while (paramLong > MAX_INT_AS_LONG);
        paramInt = outputInt((int)paramLong, paramArrayOfChar, paramInt);
        continue;
        int m = (int)l;
        int k = paramInt;
        for (paramInt = m; paramInt >= 1000; paramInt = m)
        {
          k -= 3;
          m = paramInt / 1000;
          outputFullTriplet(paramInt - m * 1000, paramArrayOfChar, k);
        }
        outputLeadingTriplet(paramInt, paramArrayOfChar, i);
        paramInt = j;
      }
    }
  }
  
  public static String toString(double paramDouble)
  {
    return Double.toString(paramDouble);
  }
  
  public static String toString(int paramInt)
  {
    String str;
    if (paramInt < sSmallIntStrs.length) {
      if (paramInt >= 0) {
        str = sSmallIntStrs[paramInt];
      }
    }
    for (;;)
    {
      return str;
      int i = -paramInt - 1;
      if (i < sSmallIntStrs2.length) {
        str = sSmallIntStrs2[i];
      } else {
        str = Integer.toString(paramInt);
      }
    }
  }
  
  public static String toString(long paramLong)
  {
    if ((paramLong <= 2147483647L) && (paramLong >= -2147483648L)) {}
    for (String str = toString((int)paramLong);; str = Long.toString(paramLong)) {
      return str;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\io\NumberOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */