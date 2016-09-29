package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

final class MultiInputStream
  extends InputStream
{
  private InputStream in;
  private Iterator<? extends InputSupplier<? extends InputStream>> it;
  
  static
  {
    JniLib.a(MultiInputStream.class, 846);
  }
  
  public MultiInputStream(Iterator<? extends InputSupplier<? extends InputStream>> paramIterator)
    throws IOException
  {
    this.it = paramIterator;
    advance();
  }
  
  private native void advance()
    throws IOException;
  
  public native int available()
    throws IOException;
  
  public native void close()
    throws IOException;
  
  public native boolean markSupported();
  
  public native int read()
    throws IOException;
  
  public native int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public native long skip(long paramLong)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\MultiInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */