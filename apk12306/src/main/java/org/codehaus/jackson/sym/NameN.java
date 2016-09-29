package org.codehaus.jackson.sym;

public final class NameN
  extends Name
{
  final int mQuadLen;
  final int[] mQuads;
  
  NameN(String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    super(paramString, paramInt1);
    if (paramInt2 < 3) {
      throw new IllegalArgumentException("Qlen must >= 3");
    }
    this.mQuads = paramArrayOfInt;
    this.mQuadLen = paramInt2;
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != this.mQuadLen) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      for (int i = 0;; i++)
      {
        if (i >= paramInt) {
          break label47;
        }
        bool1 = bool2;
        if (paramArrayOfInt[i] != this.mQuads[i]) {
          break;
        }
      }
      label47:
      bool1 = true;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\sym\NameN.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */