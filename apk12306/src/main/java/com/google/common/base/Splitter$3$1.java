package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.util.regex.Matcher;

class Splitter$3$1
  extends Splitter.SplittingIterator
{
  static
  {
    JniLib.a(1.class, 313);
  }
  
  Splitter$3$1(Splitter.3 param3, Splitter paramSplitter, CharSequence paramCharSequence, Matcher paramMatcher)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  public native int separatorEnd(int paramInt);
  
  public native int separatorStart(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */