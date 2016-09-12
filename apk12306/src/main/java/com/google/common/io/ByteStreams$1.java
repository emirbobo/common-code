package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.ByteArrayInputStream;

final class ByteStreams$1
  implements InputSupplier<ByteArrayInputStream>
{
  static
  {
    JniLib.a(1.class, 817);
  }
  
  ByteStreams$1(byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public native ByteArrayInputStream getInput();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */