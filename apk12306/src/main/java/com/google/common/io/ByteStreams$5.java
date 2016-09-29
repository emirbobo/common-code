package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;

final class ByteStreams$5
  implements InputSupplier<InputStream>
{
  static
  {
    JniLib.a(5.class, 821);
  }
  
  ByteStreams$5(Iterable paramIterable) {}
  
  public native InputStream getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */