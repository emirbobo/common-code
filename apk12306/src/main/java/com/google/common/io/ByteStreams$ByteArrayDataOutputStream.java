package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;

class ByteStreams$ByteArrayDataOutputStream
  implements ByteArrayDataOutput
{
  final ByteArrayOutputStream byteArrayOutputSteam;
  final DataOutput output;
  
  static
  {
    JniLib.a(ByteArrayDataOutputStream.class, 823);
  }
  
  ByteStreams$ByteArrayDataOutputStream()
  {
    this(new ByteArrayOutputStream());
  }
  
  ByteStreams$ByteArrayDataOutputStream(int paramInt)
  {
    this(new ByteArrayOutputStream(paramInt));
  }
  
  ByteStreams$ByteArrayDataOutputStream(ByteArrayOutputStream paramByteArrayOutputStream)
  {
    this.byteArrayOutputSteam = paramByteArrayOutputStream;
    this.output = new DataOutputStream(paramByteArrayOutputStream);
  }
  
  public native byte[] toByteArray();
  
  public native void write(int paramInt);
  
  public native void write(byte[] paramArrayOfByte);
  
  public native void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native void writeBoolean(boolean paramBoolean);
  
  public native void writeByte(int paramInt);
  
  public native void writeBytes(String paramString);
  
  public native void writeChar(int paramInt);
  
  public native void writeChars(String paramString);
  
  public native void writeDouble(double paramDouble);
  
  public native void writeFloat(float paramFloat);
  
  public native void writeInt(int paramInt);
  
  public native void writeLong(long paramLong);
  
  public native void writeShort(int paramInt);
  
  public native void writeUTF(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams$ByteArrayDataOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */