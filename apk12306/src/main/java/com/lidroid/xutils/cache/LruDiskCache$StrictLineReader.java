package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class LruDiskCache$StrictLineReader
  implements Closeable
{
  private static final byte CR = 13;
  private static final byte LF = 10;
  private byte[] buf;
  private final Charset charset = Charset.forName("US-ASCII");
  private int end;
  private final InputStream in;
  private int pos;
  
  static
  {
    JniLib.a(StrictLineReader.class, 944);
  }
  
  public LruDiskCache$StrictLineReader(LruDiskCache paramLruDiskCache, InputStream paramInputStream)
  {
    this(paramLruDiskCache, paramInputStream, 8192);
  }
  
  public LruDiskCache$StrictLineReader(LruDiskCache paramLruDiskCache, InputStream paramInputStream, int paramInt)
  {
    if (paramInputStream == null) {
      throw new NullPointerException();
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("capacity <= 0");
    }
    this.in = paramInputStream;
    this.buf = new byte[paramInt];
  }
  
  private native void fillBuf()
    throws IOException;
  
  public native void close()
    throws IOException;
  
  public native String readLine()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$StrictLineReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */