package com.google.common.base;

 enum Functions$ToStringFunction
  implements Function<Object, String>
{
  INSTANCE;
  
  private Functions$ToStringFunction() {}
  
  public String apply(Object paramObject)
  {
    Preconditions.checkNotNull(paramObject);
    return paramObject.toString();
  }
  
  public String toString()
  {
    return "toString";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Functions$ToStringFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */