package com.google.common.base;

import com.bangcle.andjni.JniLib;

class Joiner$1
  extends Joiner
{
  static
  {
    JniLib.a(1.class, 290);
  }
  
  Joiner$1(Joiner paramJoiner1, Joiner paramJoiner2, String paramString)
  {
    super(paramJoiner2, null);
  }
  
  public native Joiner skipNulls();
  
  native CharSequence toString(Object paramObject);
  
  public native Joiner useForNull(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Joiner$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */