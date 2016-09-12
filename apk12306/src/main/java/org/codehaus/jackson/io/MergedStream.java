package org.codehaus.jackson.io;

import java.io.IOException;
import java.io.InputStream;

public final class MergedStream
  extends InputStream
{
  byte[] _buffer;
  protected final IOContext _context;
  final int _end;
  final InputStream _in;
  int _ptr;
  
  public MergedStream(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._buffer = paramArrayOfByte;
    this._ptr = paramInt1;
    this._end = paramInt2;
  }
  
  private void freeMergedBuffer()
  {
    byte[] arrayOfByte = this._buffer;
    if (arrayOfByte != null)
    {
      this._buffer = null;
      if (this._context != null) {
        this._context.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  public int available()
    throws IOException
  {
    if (this._buffer != null) {}
    for (int i = this._end - this._ptr;; i = this._in.available()) {
      return i;
    }
  }
  
  public void close()
    throws IOException
  {
    freeMergedBuffer();
    this._in.close();
  }
  
  public void mark(int paramInt)
  {
    if (this._buffer == null) {
      this._in.mark(paramInt);
    }
  }
  
  public boolean markSupported()
  {
    if ((this._buffer == null) && (this._in.markSupported())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public int read()
    throws IOException
  {
    int j;
    if (this._buffer != null)
    {
      byte[] arrayOfByte = this._buffer;
      i = this._ptr;
      this._ptr = (i + 1);
      j = arrayOfByte[i] & 0xFF;
      i = j;
      if (this._ptr >= this._end) {
        freeMergedBuffer();
      }
    }
    for (int i = j;; i = this._in.read()) {
      return i;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i;
    if (this._buffer != null)
    {
      int j = this._end - this._ptr;
      i = paramInt2;
      if (paramInt2 > j) {
        i = j;
      }
      System.arraycopy(this._buffer, this._ptr, paramArrayOfByte, paramInt1, i);
      this._ptr += i;
      if (this._ptr >= this._end) {
        freeMergedBuffer();
      }
    }
    for (;;)
    {
      return i;
      i = this._in.read(paramArrayOfByte, paramInt1, paramInt2);
    }
  }
  
  public void reset()
    throws IOException
  {
    if (this._buffer == null) {
      this._in.reset();
    }
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l1 = 0L;
    long l2 = paramLong;
    int i;
    if (this._buffer != null)
    {
      i = this._end - this._ptr;
      if (i > paramLong) {
        this._ptr += (int)paramLong;
      }
    }
    for (;;)
    {
      return paramLong;
      freeMergedBuffer();
      l1 = 0L + i;
      l2 = paramLong - i;
      paramLong = l1;
      if (l2 > 0L) {
        paramLong = l1 + this._in.skip(l2);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\io\MergedStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */