package org.codehaus.jackson.sym;

public final class Name2
  extends Name
{
  final int mQuad1;
  final int mQuad2;
  
  Name2(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramString, paramInt1);
    this.mQuad1 = paramInt2;
    this.mQuad2 = paramInt3;
  }
  
  public boolean equals(int paramInt)
  {
    return false;
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.mQuad1) && (paramInt2 == this.mQuad2)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 2) && (paramArrayOfInt[0] == this.mQuad1) && (paramArrayOfInt[1] == this.mQuad2)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\sym\Name2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */