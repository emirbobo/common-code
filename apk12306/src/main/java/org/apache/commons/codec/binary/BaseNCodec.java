package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public abstract class BaseNCodec
  implements BinaryDecoder, BinaryEncoder
{
  private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
  private static final int DEFAULT_BUFFER_SIZE = 8192;
  protected static final int MASK_8BITS = 255;
  public static final int MIME_CHUNK_SIZE = 76;
  protected static final byte PAD_DEFAULT = 61;
  public static final int PEM_CHUNK_SIZE = 64;
  protected final byte PAD = (byte)61;
  protected byte[] buffer;
  private final int chunkSeparatorLength;
  protected int currentLinePos;
  private final int encodedBlockSize;
  protected boolean eof;
  protected final int lineLength;
  protected int modulus;
  protected int pos;
  private int readPos;
  private final int unencodedBlockSize;
  
  protected BaseNCodec(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.unencodedBlockSize = paramInt1;
    this.encodedBlockSize = paramInt2;
    if ((paramInt3 > 0) && (paramInt4 > 0)) {}
    for (paramInt1 = paramInt3 / paramInt2 * paramInt2;; paramInt1 = 0)
    {
      this.lineLength = paramInt1;
      this.chunkSeparatorLength = paramInt4;
      return;
    }
  }
  
  protected static boolean isWhiteSpace(byte paramByte)
  {
    switch (paramByte)
    {
    }
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  private void reset()
  {
    this.buffer = null;
    this.pos = 0;
    this.readPos = 0;
    this.currentLinePos = 0;
    this.modulus = 0;
    this.eof = false;
  }
  
  private void resizeBuffer()
  {
    if (this.buffer == null)
    {
      this.buffer = new byte[getDefaultBufferSize()];
      this.pos = 0;
      this.readPos = 0;
    }
    for (;;)
    {
      return;
      byte[] arrayOfByte = new byte[this.buffer.length * 2];
      System.arraycopy(this.buffer, 0, arrayOfByte, 0, this.buffer.length);
      this.buffer = arrayOfByte;
    }
  }
  
  int available()
  {
    if (this.buffer != null) {}
    for (int i = this.pos - this.readPos;; i = 0) {
      return i;
    }
  }
  
  protected boolean containsAlphabetOrPad(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfByte == null)
    {
      bool1 = bool2;
      return bool1;
    }
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      if ((61 == paramArrayOfByte[i]) || (isInAlphabet(paramArrayOfByte[i])))
      {
        bool1 = true;
        break;
      }
    }
  }
  
  public Object decode(Object paramObject)
    throws DecoderException
  {
    if ((paramObject instanceof byte[])) {}
    for (paramObject = decode((byte[])paramObject);; paramObject = decode((String)paramObject))
    {
      return paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
    }
    throw new DecoderException("Parameter supplied to Base-N decode is not a byte[] or a String");
  }
  
  abstract void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public byte[] decode(String paramString)
  {
    return decode(StringUtils.getBytesUtf8(paramString));
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    reset();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return paramArrayOfByte;
      decode(paramArrayOfByte, 0, paramArrayOfByte.length);
      decode(paramArrayOfByte, 0, -1);
      paramArrayOfByte = new byte[this.pos];
      readResults(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof byte[])) {
      throw new EncoderException("Parameter supplied to Base-N encode is not a byte[]");
    }
    return encode((byte[])paramObject);
  }
  
  abstract void encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    reset();
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (;;)
    {
      return paramArrayOfByte;
      encode(paramArrayOfByte, 0, paramArrayOfByte.length);
      encode(paramArrayOfByte, 0, -1);
      paramArrayOfByte = new byte[this.pos - this.readPos];
      readResults(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  public String encodeAsString(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encode(paramArrayOfByte));
  }
  
  public String encodeToString(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encode(paramArrayOfByte));
  }
  
  protected void ensureBufferSize(int paramInt)
  {
    if ((this.buffer == null) || (this.buffer.length < this.pos + paramInt)) {
      resizeBuffer();
    }
  }
  
  protected int getDefaultBufferSize()
  {
    return 8192;
  }
  
  public long getEncodedLength(byte[] paramArrayOfByte)
  {
    long l2 = (paramArrayOfByte.length + this.unencodedBlockSize - 1) / this.unencodedBlockSize * this.encodedBlockSize;
    long l1 = l2;
    if (this.lineLength > 0) {
      l1 = l2 + (this.lineLength + l2 - 1L) / this.lineLength * this.chunkSeparatorLength;
    }
    return l1;
  }
  
  boolean hasData()
  {
    if (this.buffer != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected abstract boolean isInAlphabet(byte paramByte);
  
  public boolean isInAlphabet(String paramString)
  {
    return isInAlphabet(StringUtils.getBytesUtf8(paramString), true);
  }
  
  public boolean isInAlphabet(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int i = 0;
    if (i < paramArrayOfByte.length) {
      if ((isInAlphabet(paramArrayOfByte[i])) || ((paramBoolean) && ((paramArrayOfByte[i] == 61) || (isWhiteSpace(paramArrayOfByte[i]))))) {}
    }
    for (paramBoolean = false;; paramBoolean = true)
    {
      return paramBoolean;
      i++;
      break;
    }
  }
  
  int readResults(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.buffer != null)
    {
      paramInt2 = Math.min(available(), paramInt2);
      System.arraycopy(this.buffer, this.readPos, paramArrayOfByte, paramInt1, paramInt2);
      this.readPos += paramInt2;
      paramInt1 = paramInt2;
      if (this.readPos >= this.pos)
      {
        this.buffer = null;
        paramInt1 = paramInt2;
      }
      return paramInt1;
    }
    if (this.eof) {}
    for (paramInt1 = -1;; paramInt1 = 0) {
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\binary\BaseNCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */