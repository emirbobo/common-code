package com.google.common.io;

import com.bangcle.andjni.JniLib;

class LineReader$1
  extends LineBuffer
{
  static
  {
    JniLib.a(1.class, 842);
  }
  
  LineReader$1(LineReader paramLineReader) {}
  
  protected native void handleLine(String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\LineReader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */