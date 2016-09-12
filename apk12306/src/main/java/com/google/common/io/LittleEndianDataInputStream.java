package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.DataInput;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class LittleEndianDataInputStream
  extends FilterInputStream
  implements DataInput
{
  static
  {
    JniLib.a(LittleEndianDataInputStream.class, 844);
  }
  
  public LittleEndianDataInputStream(InputStream paramInputStream)
  {
    super((InputStream)Preconditions.checkNotNull(paramInputStream));
  }
  
  private native byte readAndCheckByte()
    throws IOException, EOFException;
  
  public native boolean readBoolean()
    throws IOException;
  
  public native byte readByte()
    throws IOException;
  
  public native char readChar()
    throws IOException;
  
  public native double readDouble()
    throws IOException;
  
  public native float readFloat()
    throws IOException;
  
  public native void readFully(byte[] paramArrayOfByte)
    throws IOException;
  
  public native void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public native int readInt()
    throws IOException;
  
  public native String readLine();
  
  public native long readLong()
    throws IOException;
  
  public native short readShort()
    throws IOException;
  
  public native String readUTF()
    throws IOException;
  
  public native int readUnsignedByte()
    throws IOException;
  
  public native int readUnsignedShort()
    throws IOException;
  
  public native int skipBytes(int paramInt)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\LittleEndianDataInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */