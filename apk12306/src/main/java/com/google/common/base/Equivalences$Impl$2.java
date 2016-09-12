package com.google.common.base;

import javax.annotation.Nullable;

 enum Equivalences$Impl$2
{
  Equivalences$Impl$2()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean equivalent(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    if (paramObject1 == paramObject2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int hash(@Nullable Object paramObject)
  {
    return System.identityHashCode(paramObject);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Equivalences$Impl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */