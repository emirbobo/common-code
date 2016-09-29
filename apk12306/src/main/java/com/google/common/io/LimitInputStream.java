package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class LimitInputStream
  extends FilterInputStream
{
  private long left;
  private long mark = -1L;
  
  static
  {
    JniLib.a(LimitInputStream.class, 841);
  }
  
  public LimitInputStream(InputStream paramInputStream, long paramLong)
  {
    super(paramInputStream);
    Preconditions.checkNotNull(paramInputStream);
    if (paramLong >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "limit must be non-negative");
      this.left = paramLong;
      return;
    }
  }
  
  public native int available()
    throws IOException;
  
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\LimitInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */