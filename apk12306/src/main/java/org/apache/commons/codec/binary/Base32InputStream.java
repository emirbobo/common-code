package org.apache.commons.codec.binary;

import java.io.InputStream;

public class Base32InputStream
  extends BaseNCodecInputStream
{
  public Base32InputStream(InputStream paramInputStream)
  {
    this(paramInputStream, false);
  }
  
  public Base32InputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    super(paramInputStream, new Base32(false), paramBoolean);
  }
  
  public Base32InputStream(InputStream paramInputStream, boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramInputStream, new Base32(paramInt, paramArrayOfByte), paramBoolean);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\binary\Base32InputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */