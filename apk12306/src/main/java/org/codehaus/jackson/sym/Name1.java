package org.codehaus.jackson.sym;

public final class Name1
  extends Name
{
  static final Name1 sEmptyName = new Name1("", 0, 0);
  final int mQuad;
  
  Name1(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString, paramInt1);
    this.mQuad = paramInt2;
  }
  
  static final Name1 getEmptyName()
  {
    return sEmptyName;
  }
  
  public boolean equals(int paramInt)
  {
    if (paramInt == this.mQuad) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean equals(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.mQuad) && (paramInt2 == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean equals(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool = true;
    if ((paramInt == 1) && (paramArrayOfInt[0] == this.mQuad)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\sym\Name1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */