package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.util.Map;

public final class Joiner$MapJoiner
{
  private final Joiner joiner;
  private final String keyValueSeparator;
  
  static
  {
    JniLib.a(MapJoiner.class, 293);
  }
  
  private Joiner$MapJoiner(Joiner paramJoiner, String paramString)
  {
    this.joiner = paramJoiner;
    this.keyValueSeparator = ((String)Preconditions.checkNotNull(paramString));
  }
  
  public native <A extends Appendable> A appendTo(A paramA, Map<?, ?> paramMap)
    throws IOException;
  
  public native StringBuilder appendTo(StringBuilder paramStringBuilder, Map<?, ?> paramMap);
  
  public native String join(Map<?, ?> paramMap);
  
  public native MapJoiner useForNull(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Joiner$MapJoiner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */