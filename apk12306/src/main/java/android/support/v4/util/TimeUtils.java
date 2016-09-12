package android.support.v4.util;

import java.io.PrintWriter;

public class TimeUtils
{
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  private static final int SECONDS_PER_DAY = 86400;
  private static final int SECONDS_PER_HOUR = 3600;
  private static final int SECONDS_PER_MINUTE = 60;
  private static char[] sFormatStr = new char[24];
  private static final Object sFormatSync = new Object();
  
  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramInt1 > 99) || ((paramBoolean) && (paramInt3 >= 3))) {
      paramInt1 = paramInt2 + 3;
    }
    for (;;)
    {
      return paramInt1;
      if ((paramInt1 > 9) || ((paramBoolean) && (paramInt3 >= 2))) {
        paramInt1 = paramInt2 + 2;
      } else if ((paramBoolean) || (paramInt1 > 0)) {
        paramInt1 = paramInt2 + 1;
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    if (paramLong1 == 0L) {
      paramPrintWriter.print("--");
    }
    for (;;)
    {
      return;
      formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
    }
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter)
  {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt)
  {
    synchronized (sFormatSync)
    {
      paramInt = formatDurationLocked(paramLong, paramInt);
      String str = new java/lang/String;
      str.<init>(sFormatStr, 0, paramInt);
      paramPrintWriter.print(str);
      return;
    }
  }
  
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    }
  }
  
  private static int formatDurationLocked(long paramLong, int paramInt)
  {
    if (sFormatStr.length < paramInt) {
      sFormatStr = new char[paramInt];
    }
    char[] arrayOfChar = sFormatStr;
    if (paramLong == 0L)
    {
      while (paramInt - 1 < 0) {
        arrayOfChar[0] = ((char)32);
      }
      arrayOfChar[0] = ((char)48);
      paramInt = 1;
      return paramInt;
    }
    int i2;
    int i5;
    int n;
    int i1;
    int m;
    int k;
    int i3;
    int i4;
    boolean bool;
    if (paramLong > 0L)
    {
      i2 = 43;
      i5 = (int)(paramLong % 1000L);
      j = (int)Math.floor(paramLong / 1000L);
      n = 0;
      i1 = 0;
      m = 0;
      i = j;
      if (j > 86400)
      {
        n = j / 86400;
        i = j - 86400 * n;
      }
      j = i;
      if (i > 3600)
      {
        i1 = i / 3600;
        j = i - i1 * 3600;
      }
      k = j;
      if (j > 60)
      {
        m = j / 60;
        k = j - m * 60;
      }
      i3 = 0;
      i4 = 0;
      if (paramInt == 0) {
        break label332;
      }
      i = accumField(n, 1, false, 0);
      if (i <= 0) {
        break label309;
      }
      bool = true;
      label198:
      i += accumField(i1, 1, bool, 2);
      if (i <= 0) {
        break label315;
      }
      bool = true;
      label217:
      i += accumField(m, 1, bool, 2);
      if (i <= 0) {
        break label321;
      }
      bool = true;
      label236:
      j = i + accumField(k, 1, bool, 2);
      if (j <= 0) {
        break label327;
      }
    }
    label309:
    label315:
    label321:
    label327:
    for (int i = 3;; i = 0)
    {
      j += accumField(i5, 2, true, i) + 1;
      i = i4;
      for (;;)
      {
        i3 = i;
        if (j >= paramInt) {
          break;
        }
        arrayOfChar[i] = ((char)32);
        i++;
        j++;
      }
      i2 = 45;
      paramLong = -paramLong;
      break;
      bool = false;
      break label198;
      bool = false;
      break label217;
      bool = false;
      break label236;
    }
    label332:
    arrayOfChar[i3] = ((char)i2);
    int j = i3 + 1;
    if (paramInt != 0)
    {
      paramInt = 1;
      label352:
      n = printField(arrayOfChar, n, 'd', j, false, 0);
      if (n == j) {
        break label505;
      }
      bool = true;
      label377:
      if (paramInt == 0) {
        break label511;
      }
      i = 2;
      label383:
      n = printField(arrayOfChar, i1, 'h', n, bool, i);
      if (n == j) {
        break label516;
      }
      bool = true;
      label409:
      if (paramInt == 0) {
        break label522;
      }
      i = 2;
      label415:
      m = printField(arrayOfChar, m, 'm', n, bool, i);
      if (m == j) {
        break label527;
      }
      bool = true;
      label441:
      if (paramInt == 0) {
        break label533;
      }
      i = 2;
      label447:
      i = printField(arrayOfChar, k, 's', m, bool, i);
      if ((paramInt == 0) || (i == j)) {
        break label538;
      }
    }
    label505:
    label511:
    label516:
    label522:
    label527:
    label533:
    label538:
    for (paramInt = 3;; paramInt = 0)
    {
      paramInt = printField(arrayOfChar, i5, 'm', i, true, paramInt);
      arrayOfChar[paramInt] = ((char)115);
      paramInt++;
      break;
      paramInt = 0;
      break label352;
      bool = false;
      break label377;
      i = 0;
      break label383;
      bool = false;
      break label409;
      i = 0;
      break label415;
      bool = false;
      break label441;
      i = 0;
      break label447;
    }
  }
  
  private static int printField(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    if (!paramBoolean)
    {
      i = paramInt2;
      if (paramInt1 <= 0) {}
    }
    else
    {
      int j;
      if ((!paramBoolean) || (paramInt3 < 3))
      {
        i = paramInt1;
        j = paramInt2;
        if (paramInt1 <= 99) {}
      }
      else
      {
        i = paramInt1 / 100;
        paramArrayOfChar[paramInt2] = ((char)(char)(i + 48));
        j = paramInt2 + 1;
        i = paramInt1 - i * 100;
      }
      if (((!paramBoolean) || (paramInt3 < 2)) && (i <= 9))
      {
        paramInt3 = i;
        paramInt1 = j;
        if (paramInt2 == j) {}
      }
      else
      {
        paramInt2 = i / 10;
        paramArrayOfChar[j] = ((char)(char)(paramInt2 + 48));
        paramInt1 = j + 1;
        paramInt3 = i - paramInt2 * 10;
      }
      paramArrayOfChar[paramInt1] = ((char)(char)(paramInt3 + 48));
      paramInt1++;
      paramArrayOfChar[paramInt1] = ((char)paramChar);
      i = paramInt1 + 1;
    }
    return i;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\util\TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */