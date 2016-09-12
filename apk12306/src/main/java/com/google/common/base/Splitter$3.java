package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Splitter$3
  implements Splitter.Strategy
{
  static
  {
    JniLib.a(3.class, 314);
  }
  
  Splitter$3(Pattern paramPattern) {}
  
  public native Splitter.SplittingIterator iterator(Splitter paramSplitter, CharSequence paramCharSequence);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */