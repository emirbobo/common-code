package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

final class SoundexUtils
{
  static String clean(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        localObject = paramString;
      }
    }
    else {
      return (String)localObject;
    }
    int m = paramString.length();
    localObject = new char[m];
    int j = 0;
    int i = 0;
    label36:
    if (j < m)
    {
      if (!Character.isLetter(paramString.charAt(j))) {
        break label114;
      }
      int k = i + 1;
      localObject[i] = paramString.charAt(j);
      i = k;
    }
    label114:
    for (;;)
    {
      j++;
      break label36;
      if (i == m)
      {
        localObject = paramString.toUpperCase(Locale.ENGLISH);
        break;
      }
      localObject = new String((char[])localObject, 0, i).toUpperCase(Locale.ENGLISH);
      break;
    }
  }
  
  static int difference(StringEncoder paramStringEncoder, String paramString1, String paramString2)
    throws EncoderException
  {
    return differenceEncoded(paramStringEncoder.encode(paramString1), paramStringEncoder.encode(paramString2));
  }
  
  static int differenceEncoded(String paramString1, String paramString2)
  {
    int k;
    if ((paramString1 == null) || (paramString2 == null))
    {
      k = 0;
      return k;
    }
    int m = Math.min(paramString1.length(), paramString2.length());
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramString1.charAt(j) == paramString2.charAt(j)) {
        k = i + 1;
      }
      j++;
      i = k;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\language\SoundexUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */