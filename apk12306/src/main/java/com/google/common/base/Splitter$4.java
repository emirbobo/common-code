package com.google.common.base;

import com.bangcle.andjni.JniLib;

final class Splitter$4
  implements Splitter.Strategy
{
  static
  {
    JniLib.a(4.class, 316);
  }
  
  Splitter$4(int paramInt) {}
  
  public native Splitter.SplittingIterator iterator(Splitter paramSplitter, CharSequence paramCharSequence);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */