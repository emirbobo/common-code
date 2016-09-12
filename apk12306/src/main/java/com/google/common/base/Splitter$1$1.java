package com.google.common.base;

import com.bangcle.andjni.JniLib;

class Splitter$1$1
  extends Splitter.SplittingIterator
{
  static
  {
    JniLib.a(1.class, 309);
  }
  
  Splitter$1$1(Splitter.1 param1, Splitter paramSplitter, CharSequence paramCharSequence)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  native int separatorEnd(int paramInt);
  
  native int separatorStart(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */