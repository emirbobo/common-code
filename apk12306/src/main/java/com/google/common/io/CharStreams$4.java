package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.Reader;

final class CharStreams$4
  implements InputSupplier<Reader>
{
  static
  {
    JniLib.a(4.class, 828);
  }
  
  CharStreams$4(Iterable paramIterable) {}
  
  public native Reader getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\CharStreams$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */