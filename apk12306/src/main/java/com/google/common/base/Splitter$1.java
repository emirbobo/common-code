package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class Splitter$1
  implements Splitter.Strategy
{
  static
  {
    JniLib.a(1.class, 310);
  }
  
  Splitter$1(CharMatcher paramCharMatcher) {}
  
  public native Splitter.SplittingIterator iterator(Splitter paramSplitter, CharSequence paramCharSequence);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */