package com.google.common.base;

import javax.annotation.Nullable;

 enum Equivalences$Impl$1
{
  Equivalences$Impl$1()
  {
    super(paramString, paramInt, null);
  }
  
  public boolean equivalent(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    boolean bool;
    if (paramObject1 == null) {
      if (paramObject2 == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = paramObject1.equals(paramObject2);
    }
  }
  
  public int hash(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    for (int i = 0;; i = paramObject.hashCode()) {
      return i;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Equivalences$Impl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */