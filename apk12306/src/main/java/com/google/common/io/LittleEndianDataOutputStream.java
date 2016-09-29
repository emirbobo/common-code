package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Beta
public class LittleEndianDataOutputStream
  extends FilterOutputStream
  implements DataOutput
{
  static
  {
    JniLib.a(LittleEndianDataOutputStream.class, 845);
  }
  
  public LittleEndianDataOutputStream(OutputStream paramOutputStream)
  {
    super(new DataOutputStream((OutputStream)Preconditions.checkNotNull(paramOutputStream)));
  }
  
  public native void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public native void writeBoolean(boolean paramBoolean)
    throws IOException;
  
  public native void writeByte(int paramInt)
    throws IOException;
  
  @Deprecated
  public native void writeBytes(String paramString)
    throws IOException;
  
  public native void writeChar(int paramInt)
    throws IOException;
  
  public native void writeChars(String paramString)
    throws IOException;
  
  public native void writeDouble(double paramDouble)
    throws IOException;
  
  public native void writeFloat(float paramFloat)
    throws IOException;
  
  public native void writeInt(int paramInt)
    throws IOException;
  
  public native void writeLong(long paramLong)
    throws IOException;
  
  public native void writeShort(int paramInt)
    throws IOException;
  
  public native void writeUTF(String paramString)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\LittleEndianDataOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */