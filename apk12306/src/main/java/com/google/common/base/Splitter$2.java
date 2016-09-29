package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class Splitter$2
  implements Splitter.Strategy
{
  static
  {
    JniLib.a(2.class, 312);
  }
  
  Splitter$2(String paramString) {}
  
  public native Splitter.SplittingIterator iterator(Splitter paramSplitter, CharSequence paramCharSequence);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */