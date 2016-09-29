package org.codehaus.jackson.io;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;

public final class UTF32Reader
  extends BaseReader
{
  final boolean mBigEndian;
  int mByteCount = 0;
  int mCharCount = 0;
  char mSurrogate = (char)0;
  
  public UTF32Reader(IOContext paramIOContext, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramIOContext, paramInputStream, paramArrayOfByte, paramInt1, paramInt2);
    this.mBigEndian = paramBoolean;
  }
  
  private boolean loadMore(int paramInt)
    throws IOException
  {
    boolean bool = false;
    this.mByteCount += this._length - paramInt;
    if (paramInt > 0)
    {
      if (this._ptr > 0)
      {
        for (int i = 0; i < paramInt; i++) {
          this._buffer[i] = ((byte)this._buffer[(this._ptr + i)]);
        }
        this._ptr = 0;
      }
      for (this._length = paramInt; this._length < 4; this._length += paramInt)
      {
        paramInt = this._in.read(this._buffer, this._length, this._buffer.length - this._length);
        if (paramInt < 1)
        {
          if (paramInt < 0)
          {
            freeBuffers();
            reportUnexpectedEOF(this._length, 4);
          }
          reportStrangeStream();
        }
      }
    }
    this._ptr = 0;
    paramInt = this._in.read(this._buffer);
    if (paramInt < 1)
    {
      this._length = 0;
      if (paramInt < 0) {
        freeBuffers();
      }
    }
    for (;;)
    {
      return bool;
      reportStrangeStream();
      this._length = paramInt;
      break;
      bool = true;
    }
  }
  
  private void reportInvalid(int paramInt1, int paramInt2, String paramString)
    throws IOException
  {
    int i = this.mByteCount;
    int k = this._ptr;
    int j = this.mCharCount;
    throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(paramInt1) + paramString + " at char #" + (j + paramInt2) + ", byte #" + (i + k - 1) + ")");
  }
  
  private void reportUnexpectedEOF(int paramInt1, int paramInt2)
    throws IOException
  {
    int j = this.mByteCount;
    int i = this.mCharCount;
    throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + paramInt1 + ", needed " + paramInt2 + ", at char #" + i + ", byte #" + (j + paramInt1) + ")");
  }
  
  public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = -1;
    if (this._buffer == null) {
      paramInt2 = i;
    }
    while (paramInt2 < 1) {
      return paramInt2;
    }
    if ((paramInt1 < 0) || (paramInt1 + paramInt2 > paramArrayOfChar.length)) {
      reportBounds(paramArrayOfChar, paramInt1, paramInt2);
    }
    int m = paramInt2 + paramInt1;
    label72:
    label151:
    int j;
    if (this.mSurrogate != 0)
    {
      paramInt2 = paramInt1 + 1;
      paramArrayOfChar[paramInt1] = ((char)this.mSurrogate);
      this.mSurrogate = ((char)0);
      if (paramInt2 >= m) {
        break label423;
      }
      i = this._ptr;
      if (!this.mBigEndian) {
        break label324;
      }
      i = this._buffer[i] << 24 | (this._buffer[(i + 1)] & 0xFF) << 16 | (this._buffer[(i + 2)] & 0xFF) << 8 | this._buffer[(i + 3)] & 0xFF;
      this._ptr += 4;
      if (i <= 65535) {
        break label387;
      }
      if (i > 1114111) {
        reportInvalid(i, paramInt2 - paramInt1, "(above " + Integer.toHexString(1114111) + ") ");
      }
      j = i - 65536;
      i = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)(char)(55296 + (j >> 10)));
      int k = 0xDC00 | j & 0x3FF;
      j = k;
      paramInt2 = i;
      if (i < m) {
        break label391;
      }
      this.mSurrogate = ((char)(char)k);
      paramInt2 = i;
    }
    label324:
    label387:
    label391:
    label423:
    for (;;)
    {
      paramInt2 -= paramInt1;
      this.mCharCount += paramInt2;
      break;
      j = this._length - this._ptr;
      if (j < 4)
      {
        paramInt2 = i;
        if (!loadMore(j)) {
          break;
        }
      }
      paramInt2 = paramInt1;
      break label72;
      i = this._buffer[i] & 0xFF | (this._buffer[(i + 1)] & 0xFF) << 8 | (this._buffer[(i + 2)] & 0xFF) << 16 | this._buffer[(i + 3)] << 24;
      break label151;
      j = i;
      i = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)(char)j);
      paramInt2 = i;
      if (this._ptr < this._length) {
        break label72;
      }
      paramInt2 = i;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\io\UTF32Reader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */