package org.apache.commons.codec.language;

class ColognePhonetic$CologneInputBuffer
  extends ColognePhonetic.CologneBuffer
{
  private final ColognePhonetic this$0;
  
  public ColognePhonetic$CologneInputBuffer(ColognePhonetic paramColognePhonetic, char[] paramArrayOfChar)
  {
    super(paramColognePhonetic, paramArrayOfChar);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\language\ColognePhonetic$CologneInputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */