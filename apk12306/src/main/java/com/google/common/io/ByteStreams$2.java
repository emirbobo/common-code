package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.util.zip.Checksum;

final class ByteStreams$2
  implements ByteProcessor<Long>
{
  static
  {
    JniLib.a(2.class, 818);
  }
  
  ByteStreams$2(Checksum paramChecksum) {}
  
  public native Long getResult();
  
  public native boolean processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */