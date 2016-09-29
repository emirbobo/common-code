package com.google.common.collect;

import com.bangcle.andjni.JniLib;
import java.lang.reflect.Field;

final class Serialization$FieldSetter<T>
{
  private final Field field;
  
  static
  {
    JniLib.a(FieldSetter.class, 715);
  }
  
  private Serialization$FieldSetter(Field paramField)
  {
    this.field = paramField;
    paramField.setAccessible(true);
  }
  
  native void set(T paramT, int paramInt);
  
  native void set(T paramT, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\collect\Serialization$FieldSetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */