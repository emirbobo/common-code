package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class CountingInputStream
  extends FilterInputStream
{
  private long count;
  private long mark = -1L;
  
  static
  {
    JniLib.a(CountingInputStream.class, 831);
  }
  
  public CountingInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }
  
  public native long getCount();
  
  public native void mark(int paramInt);
  
  public native int read()
    throws IOException;
  
  public native int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public native void reset()
    throws IOException;
  
  public native long skip(long paramLong)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\CountingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */