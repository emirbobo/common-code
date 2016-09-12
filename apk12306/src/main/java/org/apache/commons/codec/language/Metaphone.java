package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class Metaphone
  implements StringEncoder
{
  private static final String FRONTV = "EIY";
  private static final String VARSON = "CSPTG";
  private static final String VOWELS = "AEIOU";
  private int maxCodeLen = 4;
  
  private boolean isLastChar(int paramInt1, int paramInt2)
  {
    if (paramInt2 + 1 == paramInt1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean isNextChar(StringBuffer paramStringBuffer, int paramInt, char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramInt < paramStringBuffer.length() - 1) {
        if (paramStringBuffer.charAt(paramInt + 1) != paramChar) {
          break label42;
        }
      }
    }
    label42:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  private boolean isPreviousChar(StringBuffer paramStringBuffer, int paramInt, char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt > 0)
    {
      bool1 = bool2;
      if (paramInt < paramStringBuffer.length()) {
        if (paramStringBuffer.charAt(paramInt - 1) != paramChar) {
          break label40;
        }
      }
    }
    label40:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  private boolean isVowel(StringBuffer paramStringBuffer, int paramInt)
  {
    if ("AEIOU".indexOf(paramStringBuffer.charAt(paramInt)) >= 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean regionMatch(StringBuffer paramStringBuffer, int paramInt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      bool1 = bool2;
      if (paramString.length() + paramInt - 1 < paramStringBuffer.length()) {
        bool1 = paramStringBuffer.substring(paramInt, paramString.length() + paramInt).equals(paramString);
      }
    }
    return bool1;
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }
    return metaphone((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return metaphone(paramString);
  }
  
  public int getMaxCodeLen()
  {
    return this.maxCodeLen;
  }
  
  public boolean isMetaphoneEqual(String paramString1, String paramString2)
  {
    return metaphone(paramString1).equals(metaphone(paramString2));
  }
  
  public String metaphone(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      if (paramString.length() == 1)
      {
        paramString = paramString.toUpperCase(Locale.ENGLISH);
      }
      else
      {
        char[] arrayOfChar = paramString.toUpperCase(Locale.ENGLISH).toCharArray();
        paramString = new StringBuffer(40);
        StringBuffer localStringBuffer = new StringBuffer(10);
        switch (arrayOfChar[0])
        {
        default: 
          paramString.append(arrayOfChar);
        }
        int k;
        int i;
        char c;
        int j;
        for (;;)
        {
          k = paramString.length();
          i = 0;
          for (;;)
          {
            if ((localStringBuffer.length() >= getMaxCodeLen()) || (i >= k)) {
              break label1426;
            }
            c = paramString.charAt(i);
            if ((c == 'C') || (!isPreviousChar(paramString, i, c))) {
              break;
            }
            j = i + 1;
            i = j;
            if (localStringBuffer.length() > getMaxCodeLen())
            {
              localStringBuffer.setLength(getMaxCodeLen());
              i = j;
            }
          }
          if (arrayOfChar[1] == 'N')
          {
            paramString.append(arrayOfChar, 1, arrayOfChar.length - 1);
          }
          else
          {
            paramString.append(arrayOfChar);
            continue;
            if (arrayOfChar[1] == 'E')
            {
              paramString.append(arrayOfChar, 1, arrayOfChar.length - 1);
            }
            else
            {
              paramString.append(arrayOfChar);
              continue;
              if (arrayOfChar[1] == 'R')
              {
                paramString.append(arrayOfChar, 1, arrayOfChar.length - 1);
              }
              else if (arrayOfChar[1] == 'H')
              {
                paramString.append(arrayOfChar, 1, arrayOfChar.length - 1);
                paramString.setCharAt(0, 'W');
              }
              else
              {
                paramString.append(arrayOfChar);
                continue;
                arrayOfChar[0] = ((char)83);
                paramString.append(arrayOfChar);
              }
            }
          }
        }
        switch (c)
        {
        default: 
          j = i;
        }
        for (;;)
        {
          j++;
          break;
          j = i;
          if (i == 0)
          {
            localStringBuffer.append(c);
            j = i;
            continue;
            if (isPreviousChar(paramString, i, 'M'))
            {
              j = i;
              if (isLastChar(k, i)) {}
            }
            else
            {
              localStringBuffer.append(c);
              j = i;
              continue;
              if ((isPreviousChar(paramString, i, 'S')) && (!isLastChar(k, i)))
              {
                j = i;
                if ("EIY".indexOf(paramString.charAt(i + 1)) >= 0) {}
              }
              else if (regionMatch(paramString, i, "CIA"))
              {
                localStringBuffer.append('X');
                j = i;
              }
              else if ((!isLastChar(k, i)) && ("EIY".indexOf(paramString.charAt(i + 1)) >= 0))
              {
                localStringBuffer.append('S');
                j = i;
              }
              else if ((isPreviousChar(paramString, i, 'S')) && (isNextChar(paramString, i, 'H')))
              {
                localStringBuffer.append('K');
                j = i;
              }
              else if (isNextChar(paramString, i, 'H'))
              {
                if ((i == 0) && (k >= 3) && (isVowel(paramString, 2)))
                {
                  localStringBuffer.append('K');
                  j = i;
                }
                else
                {
                  localStringBuffer.append('X');
                  j = i;
                }
              }
              else
              {
                localStringBuffer.append('K');
                j = i;
                continue;
                if ((!isLastChar(k, i + 1)) && (isNextChar(paramString, i, 'G')) && ("EIY".indexOf(paramString.charAt(i + 2)) >= 0))
                {
                  localStringBuffer.append('J');
                  j = i + 2;
                }
                else
                {
                  localStringBuffer.append('T');
                  j = i;
                  continue;
                  if (isLastChar(k, i + 1))
                  {
                    j = i;
                    if (isNextChar(paramString, i, 'H')) {}
                  }
                  else if ((!isLastChar(k, i + 1)) && (isNextChar(paramString, i, 'H')))
                  {
                    j = i;
                    if (!isVowel(paramString, i + 2)) {}
                  }
                  else if (i > 0)
                  {
                    j = i;
                    if (!regionMatch(paramString, i, "GN"))
                    {
                      j = i;
                      if (regionMatch(paramString, i, "GNED")) {}
                    }
                  }
                  else
                  {
                    if (isPreviousChar(paramString, i, 'G')) {}
                    for (j = 1;; j = 0)
                    {
                      if ((isLastChar(k, i)) || ("EIY".indexOf(paramString.charAt(i + 1)) < 0) || (j != 0)) {
                        break label1000;
                      }
                      localStringBuffer.append('J');
                      j = i;
                      break;
                    }
                    label1000:
                    localStringBuffer.append('K');
                    j = i;
                    continue;
                    j = i;
                    if (!isLastChar(k, i)) {
                      if (i > 0)
                      {
                        j = i;
                        if ("CSPTG".indexOf(paramString.charAt(i - 1)) >= 0) {}
                      }
                      else
                      {
                        j = i;
                        if (isVowel(paramString, i + 1))
                        {
                          localStringBuffer.append('H');
                          j = i;
                          continue;
                          localStringBuffer.append(c);
                          j = i;
                          continue;
                          if (i > 0)
                          {
                            j = i;
                            if (!isPreviousChar(paramString, i, 'C'))
                            {
                              localStringBuffer.append(c);
                              j = i;
                            }
                          }
                          else
                          {
                            localStringBuffer.append(c);
                            j = i;
                            continue;
                            if (isNextChar(paramString, i, 'H'))
                            {
                              localStringBuffer.append('F');
                              j = i;
                            }
                            else
                            {
                              localStringBuffer.append(c);
                              j = i;
                              continue;
                              localStringBuffer.append('K');
                              j = i;
                              continue;
                              if ((regionMatch(paramString, i, "SH")) || (regionMatch(paramString, i, "SIO")) || (regionMatch(paramString, i, "SIA")))
                              {
                                localStringBuffer.append('X');
                                j = i;
                              }
                              else
                              {
                                localStringBuffer.append('S');
                                j = i;
                                continue;
                                if ((regionMatch(paramString, i, "TIA")) || (regionMatch(paramString, i, "TIO")))
                                {
                                  localStringBuffer.append('X');
                                  j = i;
                                }
                                else
                                {
                                  j = i;
                                  if (!regionMatch(paramString, i, "TCH")) {
                                    if (regionMatch(paramString, i, "TH"))
                                    {
                                      localStringBuffer.append('0');
                                      j = i;
                                    }
                                    else
                                    {
                                      localStringBuffer.append('T');
                                      j = i;
                                      continue;
                                      localStringBuffer.append('F');
                                      j = i;
                                      continue;
                                      j = i;
                                      if (!isLastChar(k, i))
                                      {
                                        j = i;
                                        if (isVowel(paramString, i + 1))
                                        {
                                          localStringBuffer.append(c);
                                          j = i;
                                          continue;
                                          localStringBuffer.append('K');
                                          localStringBuffer.append('S');
                                          j = i;
                                          continue;
                                          localStringBuffer.append('S');
                                          j = i;
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        label1426:
        paramString = localStringBuffer.toString();
      }
    }
  }
  
  public void setMaxCodeLen(int paramInt)
  {
    this.maxCodeLen = paramInt;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\language\Metaphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */