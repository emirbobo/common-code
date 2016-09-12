package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class ColognePhonetic
  implements StringEncoder
{
  private static final char[][] PREPROCESS_MAP = { { 196, 65 }, { 220, 85 }, { 214, 79 }, { 223, 83 } };
  static Class class$java$lang$String;
  
  private static boolean arrayContains(char[] paramArrayOfChar, char paramChar)
  {
    int i = 0;
    if (i < paramArrayOfChar.length) {
      if (paramArrayOfChar[i] != paramChar) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i++;
      break;
    }
  }
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError().initCause(paramString);
    }
  }
  
  private String preprocess(String paramString)
  {
    paramString = paramString.toUpperCase(Locale.GERMAN).toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] > 'Z') {}
      for (int j = 0;; j++) {
        if (j < PREPROCESS_MAP.length)
        {
          if (paramString[i] == PREPROCESS_MAP[j][0]) {
            paramString[i] = ((char)PREPROCESS_MAP[j][1]);
          }
        }
        else
        {
          i++;
          break;
        }
      }
    }
    return new String(paramString);
  }
  
  public String colognePhonetic(String paramString)
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = paramString.toString())
    {
      return paramString;
      Object localObject = preprocess(paramString);
      paramString = new CologneOutputBuffer(((String)localObject).length() * 2);
      localObject = new CologneInputBuffer(((String)localObject).toCharArray());
      int i1 = 45;
      int n = 47;
      int m = ((CologneInputBuffer)localObject).length();
      int j = i1;
      if (m > 0)
      {
        int i = ((CologneInputBuffer)localObject).removeNext();
        i1 = ((CologneInputBuffer)localObject).length();
        int k;
        label98:
        int i2;
        if (i1 > 0)
        {
          m = ((CologneInputBuffer)localObject).getNextChar();
          k = m;
          if (!arrayContains(new char[] { 65, 69, 73, 74, 79, 85, 89 }, i)) {
            break label221;
          }
          i2 = 48;
          m = i1;
          j = i2;
        }
        for (;;)
        {
          if ((j != 45) && (((n != j) && ((j != 48) || (n == 47))) || (j < 48) || (j > 56))) {
            paramString.addRight(j);
          }
          i1 = i;
          n = j;
          j = i1;
          break;
          m = 45;
          k = m;
          break label98;
          label221:
          if ((i == 72) || (i < 65) || (i > 90))
          {
            m = i1;
            if (n == 47) {
              break;
            }
            m = 45;
            j = m;
            m = i1;
            continue;
          }
          if ((i == 66) || ((i == 80) && (k != 72)))
          {
            m = 49;
            j = m;
            m = i1;
          }
          else
          {
            if ((i == 68) || (i == 84)) {
              if (!arrayContains(new char[] { 83, 67, 90 }, k))
              {
                m = 50;
                j = m;
                m = i1;
                continue;
              }
            }
            if (arrayContains(new char[] { 87, 70, 80, 86 }, i))
            {
              m = 51;
              j = m;
              m = i1;
            }
            else if (arrayContains(new char[] { 71, 75, 81 }, i))
            {
              m = 52;
              j = m;
              m = i1;
            }
            else
            {
              if (i == 88) {
                if (!arrayContains(new char[] { 67, 75, 81 }, j))
                {
                  i2 = 52;
                  ((CologneInputBuffer)localObject).addLeft('S');
                  m = i1 + 1;
                  j = i2;
                  continue;
                }
              }
              if ((i == 83) || (i == 90))
              {
                m = 56;
                j = m;
                m = i1;
              }
              else if (i == 67)
              {
                if (n == 47)
                {
                  if (arrayContains(new char[] { 65, 72, 75, 76, 79, 81, 82, 85, 88 }, k))
                  {
                    m = 52;
                    j = m;
                    m = i1;
                  }
                  else
                  {
                    m = 56;
                    j = m;
                    m = i1;
                  }
                }
                else
                {
                  if (!arrayContains(new char[] { 83, 90 }, j))
                  {
                    if (arrayContains(new char[] { 65, 72, 79, 85, 75, 81, 88 }, k)) {}
                  }
                  else
                  {
                    m = 56;
                    j = m;
                    m = i1;
                    continue;
                  }
                  m = 52;
                  j = m;
                  m = i1;
                }
              }
              else if (arrayContains(new char[] { 84, 68, 88 }, i))
              {
                m = 56;
                j = m;
                m = i1;
              }
              else if (i == 82)
              {
                m = 55;
                j = m;
                m = i1;
              }
              else if (i == 76)
              {
                m = 53;
                j = m;
                m = i1;
              }
              else if ((i == 77) || (i == 78))
              {
                m = 54;
                j = m;
                m = i1;
              }
              else
              {
                m = i;
                j = m;
                m = i1;
              }
            }
          }
        }
      }
    }
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof String))
    {
      StringBuffer localStringBuffer = new StringBuffer().append("This method’s parameter was expected to be of the type ");
      Class localClass;
      if (class$java$lang$String == null)
      {
        localClass = class$("java.lang.String");
        class$java$lang$String = localClass;
      }
      for (;;)
      {
        throw new EncoderException(localClass.getName() + ". But actually it was of the type " + paramObject.getClass().getName() + ".");
        localClass = class$java$lang$String;
      }
    }
    return encode((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return colognePhonetic(paramString);
  }
  
  public boolean isEncodeEqual(String paramString1, String paramString2)
  {
    return colognePhonetic(paramString1).equals(colognePhonetic(paramString2));
  }
  
  private abstract class CologneBuffer
  {
    protected final char[] data;
    protected int length = 0;
    
    public CologneBuffer(int paramInt)
    {
      this.data = new char[paramInt];
      this.length = 0;
    }
    
    public CologneBuffer(char[] paramArrayOfChar)
    {
      this.data = paramArrayOfChar;
      this.length = paramArrayOfChar.length;
    }
    
    protected abstract char[] copyData(int paramInt1, int paramInt2);
    
    public int length()
    {
      return this.length;
    }
    
    public String toString()
    {
      return new String(copyData(0, this.length));
    }
  }
  
  private class CologneInputBuffer
    extends ColognePhonetic.CologneBuffer
  {
    public CologneInputBuffer(char[] paramArrayOfChar)
    {
      super(paramArrayOfChar);
    }
    
    public void addLeft(char paramChar)
    {
      this.length += 1;
      this.data[getNextPos()] = ((char)paramChar);
    }
    
    protected char[] copyData(int paramInt1, int paramInt2)
    {
      char[] arrayOfChar = new char[paramInt2];
      System.arraycopy(this.data, this.data.length - this.length + paramInt1, arrayOfChar, 0, paramInt2);
      return arrayOfChar;
    }
    
    public char getNextChar()
    {
      return this.data[getNextPos()];
    }
    
    protected int getNextPos()
    {
      return this.data.length - this.length;
    }
    
    public char removeNext()
    {
      char c = getNextChar();
      this.length -= 1;
      return c;
    }
  }
  
  private class CologneOutputBuffer
    extends ColognePhonetic.CologneBuffer
  {
    public CologneOutputBuffer(int paramInt)
    {
      super(paramInt);
    }
    
    public void addRight(char paramChar)
    {
      this.data[this.length] = ((char)paramChar);
      this.length += 1;
    }
    
    protected char[] copyData(int paramInt1, int paramInt2)
    {
      char[] arrayOfChar = new char[paramInt2];
      System.arraycopy(this.data, paramInt1, arrayOfChar, 0, paramInt2);
      return arrayOfChar;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\language\ColognePhonetic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */