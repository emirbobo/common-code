package org.apache.commons.codec.language;

class ColognePhonetic$CologneOutputBuffer
  extends ColognePhonetic.CologneBuffer
{
  private final ColognePhonetic this$0;
  
  public ColognePhonetic$CologneOutputBuffer(ColognePhonetic paramColognePhonetic, int paramInt)
  {
    super(paramColognePhonetic, paramInt);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\language\ColognePhonetic$CologneOutputBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */