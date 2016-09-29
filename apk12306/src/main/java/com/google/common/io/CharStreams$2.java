package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

final class CharStreams$2
  implements InputSupplier<InputStreamReader>
{
  static
  {
    JniLib.a(2.class, 826);
  }
  
  CharStreams$2(InputSupplier paramInputSupplier, Charset paramCharset) {}
  
  public native InputStreamReader getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\CharStreams$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */