package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

final class CharStreams$3
  implements OutputSupplier<OutputStreamWriter>
{
  static
  {
    JniLib.a(3.class, 827);
  }
  
  CharStreams$3(OutputSupplier paramOutputSupplier, Charset paramCharset) {}
  
  public native OutputStreamWriter getOutput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\CharStreams$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */