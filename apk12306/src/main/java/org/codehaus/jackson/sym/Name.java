package org.codehaus.jackson.sym;

public abstract class Name
{
  protected final int _hashCode;
  protected final String _name;
  
  protected Name(String paramString, int paramInt)
  {
    this._name = paramString;
    this._hashCode = paramInt;
  }
  
  public abstract boolean equals(int paramInt);
  
  public abstract boolean equals(int paramInt1, int paramInt2);
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public abstract boolean equals(int[] paramArrayOfInt, int paramInt);
  
  public String getName()
  {
    return this._name;
  }
  
  public final int hashCode()
  {
    return this._hashCode;
  }
  
  public String toString()
  {
    return this._name;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\sym\Name.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */