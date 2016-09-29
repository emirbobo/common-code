package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.StringReader;

final class CharStreams$1
  implements InputSupplier<StringReader>
{
  static
  {
    JniLib.a(1.class, 825);
  }
  
  CharStreams$1(String paramString) {}
  
  public native StringReader getInput();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\CharStreams$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */