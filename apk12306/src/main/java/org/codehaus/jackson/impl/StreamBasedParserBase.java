package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.io.IOContext;

public abstract class StreamBasedParserBase
  extends JsonNumericParserBase
{
  protected boolean _bufferRecyclable;
  protected byte[] _inputBuffer;
  protected InputStream _inputStream;
  
  protected StreamBasedParserBase(IOContext paramIOContext, int paramInt1, InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1);
    this._inputStream = paramInputStream;
    this._inputBuffer = paramArrayOfByte;
    this._inputPtr = paramInt2;
    this._inputEnd = paramInt3;
    this._bufferRecyclable = paramBoolean;
  }
  
  protected void _closeInput()
    throws IOException
  {
    if (this._inputStream != null)
    {
      if ((this._ioContext.isResourceManaged()) || (isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE))) {
        this._inputStream.close();
      }
      this._inputStream = null;
    }
  }
  
  protected final boolean _loadToHaveAtLeast(int paramInt)
    throws IOException
  {
    boolean bool = false;
    if (this._inputStream == null) {}
    for (;;)
    {
      return bool;
      int j = this._inputEnd - this._inputPtr;
      if ((j > 0) && (this._inputPtr > 0))
      {
        this._currInputProcessed += this._inputPtr;
        this._currInputRowStart -= this._inputPtr;
        System.arraycopy(this._inputBuffer, this._inputPtr, this._inputBuffer, 0, j);
        this._inputEnd = j;
        label83:
        this._inputPtr = 0;
      }
      for (;;)
      {
        if (this._inputEnd >= paramInt) {
          break label188;
        }
        int i = this._inputStream.read(this._inputBuffer, this._inputEnd, this._inputBuffer.length - this._inputEnd);
        if (i < 1)
        {
          _closeInput();
          if (i != 0) {
            break;
          }
          throw new IOException("InputStream.read() returned 0 characters when trying to read " + j + " bytes");
          this._inputEnd = 0;
          break label83;
        }
        this._inputEnd += i;
      }
      label188:
      bool = true;
    }
  }
  
  protected void _releaseBuffers()
    throws IOException
  {
    super._releaseBuffers();
    if (this._bufferRecyclable)
    {
      byte[] arrayOfByte = this._inputBuffer;
      if (arrayOfByte != null)
      {
        this._inputBuffer = null;
        this._ioContext.releaseReadIOBuffer(arrayOfByte);
      }
    }
  }
  
  public Object getInputSource()
  {
    return this._inputStream;
  }
  
  protected final boolean loadMore()
    throws IOException
  {
    boolean bool2 = false;
    this._currInputProcessed += this._inputEnd;
    this._currInputRowStart -= this._inputEnd;
    boolean bool1 = bool2;
    int i;
    if (this._inputStream != null)
    {
      i = this._inputStream.read(this._inputBuffer, 0, this._inputBuffer.length);
      if (i <= 0) {
        break label74;
      }
      this._inputPtr = 0;
      this._inputEnd = i;
      bool1 = true;
    }
    label74:
    do
    {
      return bool1;
      _closeInput();
      bool1 = bool2;
    } while (i != 0);
    throw new IOException("InputStream.read() returned 0 characters when trying to read " + this._inputBuffer.length + " bytes");
  }
  
  public int releaseBuffered(OutputStream paramOutputStream)
    throws IOException
  {
    int i = this._inputEnd - this._inputPtr;
    if (i < 1) {
      i = 0;
    }
    for (;;)
    {
      return i;
      int j = this._inputPtr;
      paramOutputStream.write(this._inputBuffer, j, i);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\StreamBasedParserBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */