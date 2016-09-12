package org.codehaus.jackson.format;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.JsonFactory;

public abstract interface InputAccessor
{
  public abstract boolean hasMoreBytes()
    throws IOException;
  
  public abstract byte nextByte()
    throws IOException;
  
  public abstract void reset();
  
  public static class Std
    implements InputAccessor
  {
    protected final byte[] _buffer;
    protected int _bufferedAmount;
    protected final InputStream _in;
    protected int _ptr;
    
    public Std(InputStream paramInputStream, byte[] paramArrayOfByte)
    {
      this._in = paramInputStream;
      this._buffer = paramArrayOfByte;
      this._bufferedAmount = 0;
    }
    
    public Std(byte[] paramArrayOfByte)
    {
      this._in = null;
      this._buffer = paramArrayOfByte;
      this._bufferedAmount = paramArrayOfByte.length;
    }
    
    public DataFormatMatcher createMatcher(JsonFactory paramJsonFactory, MatchStrength paramMatchStrength)
    {
      return new DataFormatMatcher(this._in, this._buffer, this._bufferedAmount, paramJsonFactory, paramMatchStrength);
    }
    
    public boolean hasMoreBytes()
      throws IOException
    {
      boolean bool = true;
      if (this._ptr < this._bufferedAmount) {}
      for (;;)
      {
        return bool;
        int i = this._buffer.length - this._ptr;
        if (i < 1)
        {
          bool = false;
        }
        else
        {
          i = this._in.read(this._buffer, this._ptr, i);
          if (i <= 0) {
            bool = false;
          } else {
            this._bufferedAmount += i;
          }
        }
      }
    }
    
    public byte nextByte()
      throws IOException
    {
      if ((this._ptr > -this._bufferedAmount) && (!hasMoreBytes())) {
        throw new EOFException("Could not read more than " + this._ptr + " bytes (max buffer size: " + this._buffer.length + ")");
      }
      byte[] arrayOfByte = this._buffer;
      int i = this._ptr;
      this._ptr = (i + 1);
      return arrayOfByte[i];
    }
    
    public void reset()
    {
      this._ptr = 0;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\format\InputAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */