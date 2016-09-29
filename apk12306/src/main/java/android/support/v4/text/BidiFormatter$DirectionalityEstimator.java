package android.support.v4.text;

class BidiFormatter$DirectionalityEstimator
{
  private static final byte[] DIR_TYPE_CACHE = new byte['܀'];
  private static final int DIR_TYPE_CACHE_SIZE = 1792;
  private int charIndex;
  private final boolean isHtml;
  private char lastChar;
  private final int length;
  private final String text;
  
  static
  {
    for (int i = 0; i < 1792; i++) {
      DIR_TYPE_CACHE[i] = Character.getDirectionality(i);
    }
  }
  
  BidiFormatter$DirectionalityEstimator(String paramString, boolean paramBoolean)
  {
    this.text = paramString;
    this.isHtml = paramBoolean;
    this.length = paramString.length();
  }
  
  private static byte getCachedDirectionality(char paramChar)
  {
    byte b2;
    if (paramChar < '܀') {
      b2 = DIR_TYPE_CACHE[paramChar];
    }
    for (byte b1 = b2;; b1 = b2)
    {
      return b1;
      b2 = Character.getDirectionality(paramChar);
    }
  }
  
  private byte skipEntityBackward()
  {
    int k = this.charIndex;
    int j;
    if (this.charIndex > 0)
    {
      String str = this.text;
      j = this.charIndex - 1;
      this.charIndex = j;
      this.lastChar = str.charAt(j);
      if (this.lastChar == '&') {
        j = 12;
      }
    }
    for (int i = j;; i = j)
    {
      return i;
      if (this.lastChar != ';') {
        break;
      }
      this.charIndex = k;
      this.lastChar = ((char)59);
      j = 13;
    }
  }
  
  private byte skipEntityForward()
  {
    int i;
    do
    {
      if (this.charIndex >= this.length) {
        break;
      }
      String str = this.text;
      i = this.charIndex;
      this.charIndex = (i + 1);
      i = str.charAt(i);
      this.lastChar = ((char)i);
    } while (i != 59);
    return 12;
  }
  
  private byte skipTagBackward()
  {
    int j = this.charIndex;
    label158:
    for (;;)
    {
      String str;
      int k;
      if (this.charIndex > 0)
      {
        str = this.text;
        k = this.charIndex - 1;
        this.charIndex = k;
        this.lastChar = str.charAt(k);
        if (this.lastChar == '<') {
          j = 12;
        }
      }
      for (int i = j;; i = j)
      {
        return i;
        if (this.lastChar != '>') {
          break;
        }
        this.charIndex = j;
        this.lastChar = ((char)62);
        j = 13;
      }
      if ((this.lastChar == '"') || (this.lastChar == '\''))
      {
        k = this.lastChar;
        for (;;)
        {
          if (this.charIndex <= 0) {
            break label158;
          }
          str = this.text;
          int m = this.charIndex - 1;
          this.charIndex = m;
          m = str.charAt(m);
          this.lastChar = ((char)m);
          if (m == k) {
            break;
          }
        }
      }
    }
  }
  
  private byte skipTagForward()
  {
    int j = this.charIndex;
    String str;
    int k;
    if (this.charIndex < this.length)
    {
      str = this.text;
      k = this.charIndex;
      this.charIndex = (k + 1);
      this.lastChar = str.charAt(k);
      if (this.lastChar == '>') {
        j = 12;
      }
    }
    for (int i = j;; i = j)
    {
      return i;
      if ((this.lastChar != '"') && (this.lastChar != '\'')) {
        break;
      }
      k = this.lastChar;
      for (;;)
      {
        if (this.charIndex >= this.length) {
          break label137;
        }
        str = this.text;
        int m = this.charIndex;
        this.charIndex = (m + 1);
        m = str.charAt(m);
        this.lastChar = ((char)m);
        if (m == k) {
          break;
        }
      }
      label137:
      break;
      this.charIndex = j;
      this.lastChar = ((char)60);
      j = 13;
    }
  }
  
  byte dirTypeBackward()
  {
    this.lastChar = this.text.charAt(this.charIndex - 1);
    int j;
    int i;
    if (Character.isLowSurrogate(this.lastChar))
    {
      j = Character.codePointBefore(this.text, this.charIndex);
      this.charIndex -= Character.charCount(j);
      j = Character.getDirectionality(j);
      i = j;
    }
    for (;;)
    {
      return i;
      this.charIndex -= 1;
      j = getCachedDirectionality(this.lastChar);
      i = j;
      if (this.isHtml) {
        if (this.lastChar == '>')
        {
          j = skipTagBackward();
          i = j;
        }
        else
        {
          i = j;
          if (this.lastChar == ';')
          {
            j = skipEntityBackward();
            i = j;
          }
        }
      }
    }
  }
  
  byte dirTypeForward()
  {
    this.lastChar = this.text.charAt(this.charIndex);
    int j;
    int i;
    if (Character.isHighSurrogate(this.lastChar))
    {
      j = Character.codePointAt(this.text, this.charIndex);
      this.charIndex += Character.charCount(j);
      j = Character.getDirectionality(j);
      i = j;
    }
    for (;;)
    {
      return i;
      this.charIndex += 1;
      j = getCachedDirectionality(this.lastChar);
      i = j;
      if (this.isHtml) {
        if (this.lastChar == '<')
        {
          j = skipTagForward();
          i = j;
        }
        else
        {
          i = j;
          if (this.lastChar == '&')
          {
            j = skipEntityForward();
            i = j;
          }
        }
      }
    }
  }
  
  int getEntryDir()
  {
    this.charIndex = 0;
    int i = 0;
    int k = 0;
    int m = 0;
    int j;
    for (;;)
    {
      if ((this.charIndex < this.length) && (m == 0)) {
        switch (dirTypeForward())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          m = i;
          break;
        case 14: 
        case 15: 
          i++;
          k = -1;
          break;
        case 16: 
        case 17: 
          i++;
          k = 1;
          break;
        case 18: 
          i--;
          k = 0;
          break;
        case 0: 
          if (i == 0) {
            j = -1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      return j;
      m = i;
      break;
      if (i == 0)
      {
        j = 1;
      }
      else
      {
        m = i;
        break;
        if (m == 0)
        {
          j = 0;
        }
        else
        {
          j = k;
          if (k == 0)
          {
            for (;;)
            {
              if (this.charIndex <= 0) {
                break label287;
              }
              switch (dirTypeBackward())
              {
              default: 
                break;
              case 14: 
              case 15: 
                if (m == i)
                {
                  j = -1;
                  break;
                }
                i--;
                break;
              case 16: 
              case 17: 
                if (m == i)
                {
                  j = 1;
                  break;
                }
                i--;
                break;
              case 18: 
                i++;
              }
            }
            label287:
            j = 0;
          }
        }
      }
    }
  }
  
  int getExitDir()
  {
    int m = -1;
    this.charIndex = this.length;
    int i = 0;
    int j = 0;
    int k;
    for (;;)
    {
      if (this.charIndex > 0) {
        switch (dirTypeBackward())
        {
        case 9: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          if (j == 0) {
            j = i;
          }
          break;
        case 0: 
          if (i == 0) {
            k = m;
          }
          break;
        }
      }
    }
    for (;;)
    {
      return k;
      if (j != 0) {
        break;
      }
      j = i;
      break;
      k = m;
      if (j != i)
      {
        i--;
        break;
        if (i == 0)
        {
          k = 1;
        }
        else
        {
          if (j != 0) {
            break;
          }
          j = i;
          break;
          if (j == i)
          {
            k = 1;
          }
          else
          {
            i--;
            break;
            i++;
            break;
            k = 0;
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\text\BidiFormatter$DirectionalityEstimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */