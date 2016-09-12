package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class Enums$ValueOfFunction<T extends Enum<T>>
  implements Function<String, T>
{
  private final Class<T> enumClass;
  
  static
  {
    JniLib.a(ValueOfFunction.class, 276);
  }
  
  private Enums$ValueOfFunction(Class<T> paramClass)
  {
    this.enumClass = ((Class)Preconditions.checkNotNull(paramClass));
  }
  
  public native T apply(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Enums$ValueOfFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */