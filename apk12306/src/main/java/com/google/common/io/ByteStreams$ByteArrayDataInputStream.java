package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;

class ByteStreams$ByteArrayDataInputStream
  implements ByteArrayDataInput
{
  final DataInput input;
  
  static
  {
    JniLib.a(ByteArrayDataInputStream.class, 822);
  }
  
  ByteStreams$ByteArrayDataInputStream(byte[] paramArrayOfByte)
  {
    this.input = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  ByteStreams$ByteArrayDataInputStream(byte[] paramArrayOfByte, int paramInt)
  {
    this.input = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte, paramInt, paramArrayOfByte.length - paramInt));
  }
  
  public native boolean readBoolean();
  
  public native byte readByte();
  
  public native char readChar();
  
  public native double readDouble();
  
  public native float readFloat();
  
  public native void readFully(byte[] paramArrayOfByte);
  
  public native void readFully(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public native int readInt();
  
  public native String readLine();
  
  public native long readLong();
  
  public native short readShort();
  
  public native String readUTF();
  
  public native int readUnsignedByte();
  
  public native int readUnsignedShort();
  
  public native int skipBytes(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams$ByteArrayDataInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */