package com.google.common.base;

import com.bangcle.andjni.JniLib;

class Splitter$4$1
  extends Splitter.SplittingIterator
{
  static
  {
    JniLib.a(1.class, 315);
  }
  
  Splitter$4$1(Splitter.4 param4, Splitter paramSplitter, CharSequence paramCharSequence)
  {
    super(paramSplitter, paramCharSequence);
  }
  
  public native int separatorEnd(int paramInt);
  
  public native int separatorStart(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\Splitter$4$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */