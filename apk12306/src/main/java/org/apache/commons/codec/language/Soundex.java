package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Soundex
  implements StringEncoder
{
  public static final Soundex US_ENGLISH = new Soundex();
  private static final char[] US_ENGLISH_MAPPING = "01230120022455012623010202".toCharArray();
  public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
  private int maxLength = 4;
  private final char[] soundexMapping;
  
  public Soundex()
  {
    this.soundexMapping = US_ENGLISH_MAPPING;
  }
  
  public Soundex(String paramString)
  {
    this.soundexMapping = paramString.toCharArray();
  }
  
  public Soundex(char[] paramArrayOfChar)
  {
    this.soundexMapping = new char[paramArrayOfChar.length];
    System.arraycopy(paramArrayOfChar, 0, this.soundexMapping, 0, paramArrayOfChar.length);
  }
  
  private char getMappingCode(String paramString, int paramInt)
  {
    int k = map(paramString.charAt(paramInt));
    int i = k;
    if (paramInt > 1)
    {
      i = k;
      if (k != 48)
      {
        int j = paramString.charAt(paramInt - 1);
        if (72 != j)
        {
          i = k;
          if (87 != j) {}
        }
        else
        {
          char c = paramString.charAt(paramInt - 2);
          if ((map(c) != k) && ('H' != c))
          {
            i = k;
            if ('W' != c) {}
          }
          else
          {
            paramInt = 0;
            i = paramInt;
          }
        }
      }
    }
    return i;
  }
  
  private char[] getSoundexMapping()
  {
    return this.soundexMapping;
  }
  
  private char map(char paramChar)
  {
    int i = paramChar - 'A';
    if ((i < 0) || (i >= getSoundexMapping().length)) {
      throw new IllegalArgumentException("The character is not mapped: " + paramChar);
    }
    return getSoundexMapping()[i];
  }
  
  public int difference(String paramString1, String paramString2)
    throws EncoderException
  {
    return SoundexUtils.difference(this, paramString1, paramString2);
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
    }
    return soundex((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return soundex(paramString);
  }
  
  public int getMaxLength()
  {
    return this.maxLength;
  }
  
  public void setMaxLength(int paramInt)
  {
    this.maxLength = paramInt;
  }
  
  public String soundex(String paramString)
  {
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
      paramString = SoundexUtils.clean(paramString);
    } while (paramString.length() == 0);
    char[] arrayOfChar = new char[4];
    char[] tmp30_28 = arrayOfChar;
    tmp30_28[0] = 48;
    char[] tmp35_30 = tmp30_28;
    tmp35_30[1] = 48;
    char[] tmp40_35 = tmp35_30;
    tmp40_35[2] = 48;
    char[] tmp45_40 = tmp40_35;
    tmp45_40[3] = 48;
    tmp45_40;
    int i = 1;
    int j = 1;
    arrayOfChar[0] = paramString.charAt(0);
    int k = getMappingCode(paramString, 0);
    for (;;)
    {
      int m;
      if ((i < paramString.length()) && (j < arrayOfChar.length))
      {
        m = i + 1;
        int n = getMappingCode(paramString, i);
        if (n != 0)
        {
          i = j;
          if (n != 48)
          {
            i = j;
            if (n != k)
            {
              arrayOfChar[j] = ((char)n);
              i = j + 1;
            }
          }
          k = n;
          j = i;
          i = m;
        }
      }
      else
      {
        paramString = new String(arrayOfChar);
        break;
      }
      i = m;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\language\Soundex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */