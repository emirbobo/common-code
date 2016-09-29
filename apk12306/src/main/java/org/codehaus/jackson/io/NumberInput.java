package org.codehaus.jackson.io;

public final class NumberInput
{
  static final long L_BILLION = 1000000000L;
  static final String MAX_LONG_STR = String.valueOf(Long.MAX_VALUE);
  static final String MIN_LONG_STR_NO_SIGN = String.valueOf(Long.MIN_VALUE).substring(1);
  public static final String NASTY_SMALL_DOUBLE = "2.2250738585072012e-308";
  
  public static final boolean inLongRange(String paramString, boolean paramBoolean)
  {
    boolean bool = true;
    String str;
    int j;
    if (paramBoolean)
    {
      str = MIN_LONG_STR_NO_SIGN;
      j = str.length();
      i = paramString.length();
      if (i >= j) {
        break label41;
      }
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      str = MAX_LONG_STR;
      break;
      label41:
      if (i <= j) {
        break label51;
      }
    }
    label51:
    for (int i = 0;; i++)
    {
      paramBoolean = bool;
      if (i >= j) {
        break;
      }
      int k = paramString.charAt(i) - str.charAt(i);
      if (k != 0)
      {
        paramBoolean = bool;
        if (k < 0) {
          break;
        }
        paramBoolean = false;
        break;
      }
    }
  }
  
  public static final boolean inLongRange(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    boolean bool = true;
    String str;
    int i;
    if (paramBoolean)
    {
      str = MIN_LONG_STR_NO_SIGN;
      i = str.length();
      if (paramInt2 >= i) {
        break label38;
      }
    }
    for (paramBoolean = bool;; paramBoolean = false)
    {
      return paramBoolean;
      str = MAX_LONG_STR;
      break;
      label38:
      if (paramInt2 <= i) {
        break label49;
      }
    }
    label49:
    for (paramInt2 = 0;; paramInt2++)
    {
      paramBoolean = bool;
      if (paramInt2 >= i) {
        break;
      }
      int j = paramArrayOfChar[(paramInt1 + paramInt2)] - str.charAt(paramInt2);
      if (j != 0)
      {
        paramBoolean = bool;
        if (j < 0) {
          break;
        }
        paramBoolean = false;
        break;
      }
    }
  }
  
  public static double parseAsDouble(String paramString, double paramDouble)
  {
    double d;
    if (paramString == null) {
      d = paramDouble;
    }
    for (;;)
    {
      return d;
      paramString = paramString.trim();
      d = paramDouble;
      if (paramString.length() != 0) {
        try
        {
          d = parseDouble(paramString);
        }
        catch (NumberFormatException paramString)
        {
          d = paramDouble;
        }
      }
    }
  }
  
  public static int parseAsInt(String paramString, int paramInt)
  {
    int i;
    if (paramString == null) {
      i = paramInt;
    }
    for (;;)
    {
      return i;
      String str = paramString.trim();
      int k = str.length();
      i = paramInt;
      if (k != 0)
      {
        int m = 0;
        i = m;
        int j = k;
        paramString = str;
        int n;
        if (k < 0)
        {
          n = str.charAt(0);
          if (n != 43) {
            break label123;
          }
          paramString = str.substring(1);
          j = paramString.length();
          i = m;
        }
        for (;;)
        {
          if (i >= j) {
            break label169;
          }
          k = paramString.charAt(i);
          if ((k > 57) || (k < 48))
          {
            try
            {
              double d = parseDouble(paramString);
              i = (int)d;
            }
            catch (NumberFormatException paramString)
            {
              label123:
              i = paramInt;
            }
            i = m;
            j = k;
            paramString = str;
            if (n != 45) {
              continue;
            }
            i = 0 + 1;
            j = k;
            paramString = str;
            continue;
            break;
          }
          i++;
        }
        try
        {
          label169:
          i = Integer.parseInt(paramString);
        }
        catch (NumberFormatException paramString)
        {
          i = paramInt;
        }
      }
    }
  }
  
  public static long parseAsLong(String paramString, long paramLong)
  {
    long l;
    if (paramString == null) {
      l = paramLong;
    }
    for (;;)
    {
      return l;
      String str = paramString.trim();
      int m = str.length();
      l = paramLong;
      if (m != 0)
      {
        int k = 0;
        int i = k;
        int j = m;
        paramString = str;
        int n;
        if (m < 0)
        {
          n = str.charAt(0);
          if (n != 43) {
            break label123;
          }
          paramString = str.substring(1);
          j = paramString.length();
          i = k;
        }
        for (;;)
        {
          if (i >= j) {
            break label169;
          }
          k = paramString.charAt(i);
          if ((k > 57) || (k < 48))
          {
            try
            {
              double d = parseDouble(paramString);
              l = d;
            }
            catch (NumberFormatException paramString)
            {
              label123:
              l = paramLong;
            }
            i = k;
            j = m;
            paramString = str;
            if (n != 45) {
              continue;
            }
            i = 0 + 1;
            j = m;
            paramString = str;
            continue;
            break;
          }
          i++;
        }
        try
        {
          label169:
          l = Long.parseLong(paramString);
        }
        catch (NumberFormatException paramString)
        {
          l = paramLong;
        }
      }
    }
  }
  
  public static final double parseDouble(String paramString)
    throws NumberFormatException
  {
    if ("2.2250738585072012e-308".equals(paramString)) {}
    for (double d = 2.2250738585072014E-308D;; d = Double.parseDouble(paramString)) {
      return d;
    }
  }
  
  public static final int parseInt(String paramString)
  {
    int m = 0;
    int i = paramString.charAt(0);
    int i1 = paramString.length();
    if (i == 45) {
      m = 1;
    }
    int j;
    if (m != 0)
    {
      if ((i1 == 1) || (i1 > 10))
      {
        i = Integer.parseInt(paramString);
        return i;
      }
      j = 1 + 1;
      i = paramString.charAt(1);
    }
    for (;;)
    {
      if ((i > 57) || (i < 48))
      {
        i = Integer.parseInt(paramString);
        break;
        if (i1 <= 9) {
          break label287;
        }
        i = Integer.parseInt(paramString);
        break;
      }
      int n = i - 48;
      i = n;
      int k = j;
      if (j < i1)
      {
        k = j + 1;
        i = paramString.charAt(j);
        if ((i > 57) || (i < 48))
        {
          i = Integer.parseInt(paramString);
          break;
        }
        i = n * 10 + (i - 48);
        j = i;
        if (k >= i1) {
          break label274;
        }
        j = k + 1;
        k = paramString.charAt(k);
        if ((k > 57) || (k < 48))
        {
          i = Integer.parseInt(paramString);
          break;
        }
        n = i * 10 + (k - 48);
        i = n;
        k = j;
        if (j < i1)
        {
          i = j;
          j = n;
          do
          {
            k = i + 1;
            i = paramString.charAt(i);
            if ((i > 57) || (i < 48))
            {
              i = Integer.parseInt(paramString);
              break;
            }
            n = j * 10 + (i - 48);
            j = n;
            i = k;
          } while (k < i1);
          i = n;
        }
      }
      j = i;
      label274:
      i = j;
      if (m == 0) {
        break;
      }
      i = -j;
      break;
      label287:
      j = 1;
    }
  }
  
  public static final int parseInt(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfChar[paramInt1] - '0';
    int j = paramInt2 + paramInt1;
    int k = paramInt1 + 1;
    paramInt1 = i;
    if (k < j)
    {
      paramInt2 = i * 10 + (paramArrayOfChar[k] - '0');
      i = k + 1;
      paramInt1 = paramInt2;
      if (i < j)
      {
        paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
        i++;
        paramInt1 = paramInt2;
        if (i < j)
        {
          paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
          i++;
          paramInt1 = paramInt2;
          if (i < j)
          {
            paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
            i++;
            paramInt1 = paramInt2;
            if (i < j)
            {
              paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
              i++;
              paramInt1 = paramInt2;
              if (i < j)
              {
                paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                i++;
                paramInt1 = paramInt2;
                if (i < j)
                {
                  paramInt2 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  i++;
                  paramInt1 = paramInt2;
                  if (i < j) {
                    paramInt1 = paramInt2 * 10 + (paramArrayOfChar[i] - '0');
                  }
                }
              }
            }
          }
        }
      }
    }
    return paramInt1;
  }
  
  public static final long parseLong(String paramString)
  {
    if (paramString.length() <= 9) {}
    for (long l = parseInt(paramString);; l = Long.parseLong(paramString)) {
      return l;
    }
  }
  
  public static final long parseLong(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    paramInt2 -= 9;
    long l = parseInt(paramArrayOfChar, paramInt1, paramInt2);
    return parseInt(paramArrayOfChar, paramInt1 + paramInt2, 9) + l * 1000000000L;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\io\NumberInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */