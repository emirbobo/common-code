package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.zip.Checksum;

@Beta
public final class ByteStreams
{
  private static final int BUF_SIZE = 4096;
  
  static
  {
    JniLib.a(ByteStreams.class, 824);
  }
  
  public static native long copy(InputSupplier<? extends InputStream> paramInputSupplier, OutputSupplier<? extends OutputStream> paramOutputSupplier)
    throws IOException;
  
  public static native long copy(InputSupplier<? extends InputStream> paramInputSupplier, OutputStream paramOutputStream)
    throws IOException;
  
  public static native long copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException;
  
  public static native long copy(ReadableByteChannel paramReadableByteChannel, WritableByteChannel paramWritableByteChannel)
    throws IOException;
  
  public static native boolean equal(InputSupplier<? extends InputStream> paramInputSupplier1, InputSupplier<? extends InputStream> paramInputSupplier2)
    throws IOException;
  
  public static native long getChecksum(InputSupplier<? extends InputStream> paramInputSupplier, Checksum paramChecksum)
    throws IOException;
  
  public static native byte[] getDigest(InputSupplier<? extends InputStream> paramInputSupplier, MessageDigest paramMessageDigest)
    throws IOException;
  
  public static native InputSupplier<InputStream> join(Iterable<? extends InputSupplier<? extends InputStream>> paramIterable);
  
  public static InputSupplier<InputStream> join(InputSupplier<? extends InputStream>... paramVarArgs)
  {
    return join(Arrays.asList(paramVarArgs));
  }
  
  public static native long length(InputSupplier<? extends InputStream> paramInputSupplier)
    throws IOException;
  
  public static native ByteArrayDataInput newDataInput(byte[] paramArrayOfByte);
  
  public static native ByteArrayDataInput newDataInput(byte[] paramArrayOfByte, int paramInt);
  
  public static native ByteArrayDataOutput newDataOutput();
  
  public static native ByteArrayDataOutput newDataOutput(int paramInt);
  
  public static native InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] paramArrayOfByte);
  
  public static native InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native int read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public static native <T> T readBytes(InputSupplier<? extends InputStream> paramInputSupplier, ByteProcessor<T> paramByteProcessor)
    throws IOException;
  
  public static native void readFully(InputStream paramInputStream, byte[] paramArrayOfByte)
    throws IOException;
  
  public static native void readFully(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public static native void skipFully(InputStream paramInputStream, long paramLong)
    throws IOException;
  
  public static native InputSupplier<InputStream> slice(InputSupplier<? extends InputStream> paramInputSupplier, long paramLong1, long paramLong2);
  
  public static native byte[] toByteArray(InputSupplier<? extends InputStream> paramInputSupplier)
    throws IOException;
  
  public static native byte[] toByteArray(InputStream paramInputStream)
    throws IOException;
  
  public static native void write(byte[] paramArrayOfByte, OutputSupplier<? extends OutputStream> paramOutputSupplier)
    throws IOException;
  
  private static class ByteArrayDataInputStream
    implements ByteArrayDataInput
  {
    final DataInput input;
    
    static
    {
      JniLib.a(ByteArrayDataInputStream.class, 822);
    }
    
    ByteArrayDataInputStream(byte[] paramArrayOfByte)
    {
      this.input = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    }
    
    ByteArrayDataInputStream(byte[] paramArrayOfByte, int paramInt)
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
  
  private static class ByteArrayDataOutputStream
    implements ByteArrayDataOutput
  {
    final ByteArrayOutputStream byteArrayOutputSteam;
    final DataOutput output;
    
    static
    {
      JniLib.a(ByteArrayDataOutputStream.class, 823);
    }
    
    ByteArrayDataOutputStream()
    {
      this(new ByteArrayOutputStream());
    }
    
    ByteArrayDataOutputStream(int paramInt)
    {
      this(new ByteArrayOutputStream(paramInt));
    }
    
    ByteArrayDataOutputStream(ByteArrayOutputStream paramByteArrayOutputStream)
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\ByteStreams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */