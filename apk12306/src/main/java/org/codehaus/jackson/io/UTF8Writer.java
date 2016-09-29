package org.codehaus.jackson.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class UTF8Writer
  extends Writer
{
  static final int SURR1_FIRST = 55296;
  static final int SURR1_LAST = 56319;
  static final int SURR2_FIRST = 56320;
  static final int SURR2_LAST = 57343;
  protected final IOContext _context;
  OutputStream _out;
  byte[] _outBuffer;
  final int _outBufferEnd;
  int _outPtr;
  int _surrogate = 0;
  
  public UTF8Writer(IOContext paramIOContext, OutputStream paramOutputStream)
  {
    this._context = paramIOContext;
    this._out = paramOutputStream;
    this._outBuffer = paramIOContext.allocWriteEncodingBuffer();
    this._outBufferEnd = (this._outBuffer.length - 4);
    this._outPtr = 0;
  }
  
  private int convertSurrogate(int paramInt)
    throws IOException
  {
    int i = this._surrogate;
    this._surrogate = 0;
    if ((paramInt < 56320) || (paramInt > 57343)) {
      throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i) + ", second 0x" + Integer.toHexString(paramInt) + "; illegal combination");
    }
    return 65536 + (i - 55296 << 10) + (paramInt - 56320);
  }
  
  private void throwIllegal(int paramInt)
    throws IOException
  {
    if (paramInt > 1114111) {
      throw new IOException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627");
    }
    if (paramInt >= 55296)
    {
      if (paramInt <= 56319) {
        throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
      }
      throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
    }
    throw new IOException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output");
  }
  
  public Writer append(char paramChar)
    throws IOException
  {
    write(paramChar);
    return this;
  }
  
  public void close()
    throws IOException
  {
    if (this._out != null)
    {
      if (this._outPtr > 0)
      {
        this._out.write(this._outBuffer, 0, this._outPtr);
        this._outPtr = 0;
      }
      OutputStream localOutputStream = this._out;
      this._out = null;
      byte[] arrayOfByte = this._outBuffer;
      if (arrayOfByte != null)
      {
        this._outBuffer = null;
        this._context.releaseWriteEncodingBuffer(arrayOfByte);
      }
      localOutputStream.close();
      int i = this._surrogate;
      this._surrogate = 0;
      if (i > 0) {
        throwIllegal(i);
      }
    }
  }
  
  public void flush()
    throws IOException
  {
    if (this._out != null)
    {
      if (this._outPtr > 0)
      {
        this._out.write(this._outBuffer, 0, this._outPtr);
        this._outPtr = 0;
      }
      this._out.flush();
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    int i;
    byte[] arrayOfByte;
    if (this._surrogate > 0)
    {
      i = convertSurrogate(paramInt);
      if (this._outPtr >= this._outBufferEnd)
      {
        this._out.write(this._outBuffer, 0, this._outPtr);
        this._outPtr = 0;
      }
      if (i < 128)
      {
        arrayOfByte = this._outBuffer;
        paramInt = this._outPtr;
        this._outPtr = (paramInt + 1);
        arrayOfByte[paramInt] = ((byte)(byte)i);
      }
    }
    else
    {
      for (;;)
      {
        return;
        i = paramInt;
        if (paramInt < 55296) {
          break;
        }
        i = paramInt;
        if (paramInt > 57343) {
          break;
        }
        if (paramInt > 56319) {
          throwIllegal(paramInt);
        }
        this._surrogate = paramInt;
      }
    }
    paramInt = this._outPtr;
    int j;
    if (i < 2048)
    {
      arrayOfByte = this._outBuffer;
      j = paramInt + 1;
      arrayOfByte[paramInt] = ((byte)(byte)(i >> 6 | 0xC0));
      arrayOfByte = this._outBuffer;
      paramInt = j + 1;
      arrayOfByte[j] = ((byte)(byte)(i & 0x3F | 0x80));
    }
    for (;;)
    {
      this._outPtr = paramInt;
      break;
      if (i <= 65535)
      {
        arrayOfByte = this._outBuffer;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(byte)(i >> 12 | 0xE0));
        arrayOfByte = this._outBuffer;
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i >> 6 & 0x3F | 0x80));
        this._outBuffer[paramInt] = ((byte)(byte)(i & 0x3F | 0x80));
        paramInt++;
      }
      else
      {
        if (i > 1114111) {
          throwIllegal(i);
        }
        arrayOfByte = this._outBuffer;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(byte)(i >> 18 | 0xF0));
        arrayOfByte = this._outBuffer;
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i >> 12 & 0x3F | 0x80));
        arrayOfByte = this._outBuffer;
        j = paramInt + 1;
        arrayOfByte[paramInt] = ((byte)(byte)(i >> 6 & 0x3F | 0x80));
        arrayOfByte = this._outBuffer;
        paramInt = j + 1;
        arrayOfByte[j] = ((byte)(byte)(i & 0x3F | 0x80));
      }
    }
  }
  
  public void write(String paramString)
    throws IOException
  {
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramString.charAt(paramInt1));
      }
      return;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (this._surrogate > 0)
    {
      i = paramString.charAt(paramInt1);
      j = paramInt2 - 1;
      write(convertSurrogate(i));
      i = paramInt1 + 1;
    }
    paramInt1 = this._outPtr;
    byte[] arrayOfByte = this._outBuffer;
    int n = this._outBufferEnd;
    int i1 = j + i;
    paramInt2 = i;
    int k;
    for (;;)
    {
      if (paramInt2 < i1)
      {
        i = paramInt1;
        if (paramInt1 >= n)
        {
          this._out.write(arrayOfByte, 0, paramInt1);
          i = 0;
        }
        j = paramInt2 + 1;
        k = paramString.charAt(paramInt2);
        if (k < 128)
        {
          paramInt1 = i + 1;
          arrayOfByte[i] = ((byte)(byte)k);
          paramInt2 = i1 - j;
          k = n - paramInt1;
          i = paramInt2;
          if (paramInt2 > k) {
            i = k;
          }
          for (paramInt2 = j;; paramInt2 = k)
          {
            if (paramInt2 >= i + j) {
              break label292;
            }
            k = paramInt2 + 1;
            int m = paramString.charAt(paramInt2);
            if (m >= 128)
            {
              paramInt2 = paramInt1;
              paramInt1 = k;
              i = m;
              label219:
              if (i >= 2048) {
                break label294;
              }
              j = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(byte)(i >> 6 | 0xC0));
              arrayOfByte[j] = ((byte)(byte)(i & 0x3F | 0x80));
              i = j + 1;
              paramInt2 = paramInt1;
              paramInt1 = i;
              label274:
              break;
            }
            arrayOfByte[paramInt1] = ((byte)(byte)m);
            paramInt1++;
          }
          label292:
          continue;
          label294:
          if ((i < 55296) || (i > 57343))
          {
            j = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(byte)(i >> 12 | 0xE0));
            paramInt2 = j + 1;
            arrayOfByte[j] = ((byte)(byte)(i >> 6 & 0x3F | 0x80));
            j = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(byte)(i & 0x3F | 0x80));
            paramInt2 = paramInt1;
            paramInt1 = j;
            continue;
          }
          if (i > 56319)
          {
            this._outPtr = paramInt2;
            throwIllegal(i);
          }
          this._surrogate = i;
          if (paramInt1 >= i1) {
            paramInt1 = paramInt2;
          }
        }
      }
    }
    for (;;)
    {
      this._outPtr = paramInt1;
      break;
      i = paramInt1 + 1;
      paramInt1 = convertSurrogate(paramString.charAt(paramInt1));
      if (paramInt1 > 1114111)
      {
        this._outPtr = paramInt2;
        throwIllegal(paramInt1);
      }
      j = paramInt2 + 1;
      arrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >> 18 | 0xF0));
      paramInt2 = j + 1;
      arrayOfByte[j] = ((byte)(byte)(paramInt1 >> 12 & 0x3F | 0x80));
      j = paramInt2 + 1;
      arrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >> 6 & 0x3F | 0x80));
      arrayOfByte[j] = ((byte)(byte)(paramInt1 & 0x3F | 0x80));
      paramInt1 = j + 1;
      paramInt2 = i;
      break label274;
      paramInt2 = i;
      paramInt1 = j;
      i = k;
      break label219;
    }
  }
  
  public void write(char[] paramArrayOfChar)
    throws IOException
  {
    write(paramArrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramInt2 < 2)
    {
      if (paramInt2 == 1) {
        write(paramArrayOfChar[paramInt1]);
      }
      return;
    }
    int i = paramInt1;
    int j = paramInt2;
    if (this._surrogate > 0)
    {
      i = paramArrayOfChar[paramInt1];
      j = paramInt2 - 1;
      write(convertSurrogate(i));
      i = paramInt1 + 1;
    }
    paramInt1 = this._outPtr;
    byte[] arrayOfByte = this._outBuffer;
    int n = this._outBufferEnd;
    int i1 = j + i;
    paramInt2 = i;
    int k;
    for (;;)
    {
      if (paramInt2 < i1)
      {
        i = paramInt1;
        if (paramInt1 >= n)
        {
          this._out.write(arrayOfByte, 0, paramInt1);
          i = 0;
        }
        j = paramInt2 + 1;
        k = paramArrayOfChar[paramInt2];
        if (k < 128)
        {
          paramInt1 = i + 1;
          arrayOfByte[i] = ((byte)(byte)k);
          paramInt2 = i1 - j;
          k = n - paramInt1;
          i = paramInt2;
          if (paramInt2 > k) {
            i = k;
          }
          for (paramInt2 = j;; paramInt2 = k)
          {
            if (paramInt2 >= i + j) {
              break label284;
            }
            k = paramInt2 + 1;
            int m = paramArrayOfChar[paramInt2];
            if (m >= 128)
            {
              paramInt2 = paramInt1;
              paramInt1 = k;
              i = m;
              label211:
              if (i >= 2048) {
                break label286;
              }
              j = paramInt2 + 1;
              arrayOfByte[paramInt2] = ((byte)(byte)(i >> 6 | 0xC0));
              arrayOfByte[j] = ((byte)(byte)(i & 0x3F | 0x80));
              i = j + 1;
              paramInt2 = paramInt1;
              paramInt1 = i;
              label266:
              break;
            }
            arrayOfByte[paramInt1] = ((byte)(byte)m);
            paramInt1++;
          }
          label284:
          continue;
          label286:
          if ((i < 55296) || (i > 57343))
          {
            j = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(byte)(i >> 12 | 0xE0));
            paramInt2 = j + 1;
            arrayOfByte[j] = ((byte)(byte)(i >> 6 & 0x3F | 0x80));
            j = paramInt2 + 1;
            arrayOfByte[paramInt2] = ((byte)(byte)(i & 0x3F | 0x80));
            paramInt2 = paramInt1;
            paramInt1 = j;
            continue;
          }
          if (i > 56319)
          {
            this._outPtr = paramInt2;
            throwIllegal(i);
          }
          this._surrogate = i;
          if (paramInt1 >= i1) {
            paramInt1 = paramInt2;
          }
        }
      }
    }
    for (;;)
    {
      this._outPtr = paramInt1;
      break;
      i = paramInt1 + 1;
      paramInt1 = convertSurrogate(paramArrayOfChar[paramInt1]);
      if (paramInt1 > 1114111)
      {
        this._outPtr = paramInt2;
        throwIllegal(paramInt1);
      }
      j = paramInt2 + 1;
      arrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >> 18 | 0xF0));
      paramInt2 = j + 1;
      arrayOfByte[j] = ((byte)(byte)(paramInt1 >> 12 & 0x3F | 0x80));
      j = paramInt2 + 1;
      arrayOfByte[paramInt2] = ((byte)(byte)(paramInt1 >> 6 & 0x3F | 0x80));
      arrayOfByte[j] = ((byte)(byte)(paramInt1 & 0x3F | 0x80));
      paramInt1 = j + 1;
      paramInt2 = i;
      break label266;
      paramInt2 = i;
      paramInt1 = j;
      i = k;
      break label211;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\io\UTF8Writer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */