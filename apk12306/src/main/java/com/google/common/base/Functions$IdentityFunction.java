package com.google.common.base;

 enum Functions$IdentityFunction
  implements Function<Object, Object>
{
  INSTANCE;
  
  private Functions$IdentityFunction() {}
  
  public Object apply(Object paramObject)
  {
    return paramObject;
  }
  
  public String toString()
  {
    return "identity";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Functions$IdentityFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */