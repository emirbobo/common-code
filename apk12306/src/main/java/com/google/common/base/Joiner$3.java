package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.util.AbstractList;

final class Joiner$3
  extends AbstractList<Object>
{
  static
  {
    JniLib.a(3.class, 292);
  }
  
  Joiner$3(Object[] paramArrayOfObject, Object paramObject1, Object paramObject2) {}
  
  public native Object get(int paramInt);
  
  public native int size();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Joiner$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */