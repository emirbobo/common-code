package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.io.OutputStream;

@Beta
public final class NullOutputStream
  extends OutputStream
{
  static
  {
    JniLib.a(NullOutputStream.class, 848);
  }
  
  public native void write(int paramInt);
  
  public native void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\NullOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */