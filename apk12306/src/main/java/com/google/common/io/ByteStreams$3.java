package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.security.MessageDigest;

final class ByteStreams$3
  implements ByteProcessor<byte[]>
{
  static
  {
    JniLib.a(3.class, 819);
  }
  
  ByteStreams$3(MessageDigest paramMessageDigest) {}
  
  public native byte[] getResult();
  
  public native boolean processBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */