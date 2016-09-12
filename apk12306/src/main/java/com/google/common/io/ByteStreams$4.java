package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;

final class ByteStreams$4
  implements InputSupplier<InputStream>
{
  static
  {
    JniLib.a(4.class, 820);
  }
  
  ByteStreams$4(InputSupplier paramInputSupplier, long paramLong1, long paramLong2) {}
  
  public native InputStream getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */