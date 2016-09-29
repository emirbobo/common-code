package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.IOException;

class Joiner$2
  extends Joiner
{
  static
  {
    JniLib.a(2.class, 291);
  }
  
  Joiner$2(Joiner paramJoiner1, Joiner paramJoiner2)
  {
    super(paramJoiner2, null);
  }
  
  public native <A extends Appendable> A appendTo(A paramA, Iterable<?> paramIterable)
    throws IOException;
  
  public native Joiner useForNull(String paramString);
  
  public native Joiner.MapJoiner withKeyValueSeparator(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Joiner$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */