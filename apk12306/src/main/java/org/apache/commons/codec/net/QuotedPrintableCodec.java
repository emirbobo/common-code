package org.apache.commons.codec.net;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.StringUtils;

public class QuotedPrintableCodec
  implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
{
  private static final byte ESCAPE_CHAR = 61;
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  private static final byte SPACE = 32;
  private static final byte TAB = 9;
  private final String charset;
  
  static
  {
    for (int i = 33; i <= 60; i++) {
      PRINTABLE_CHARS.set(i);
    }
    for (i = 62; i <= 126; i++) {
      PRINTABLE_CHARS.set(i);
    }
    PRINTABLE_CHARS.set(9);
    PRINTABLE_CHARS.set(32);
  }
  
  public QuotedPrintableCodec()
  {
    this("UTF-8");
  }
  
  public QuotedPrintableCodec(String paramString)
  {
    this.charset = paramString;
  }
  
  public static final byte[] decodeQuotedPrintable(byte[] paramArrayOfByte)
    throws DecoderException
  {
    if (paramArrayOfByte == null) {}
    ByteArrayOutputStream localByteArrayOutputStream;
    for (paramArrayOfByte = null;; paramArrayOfByte = localByteArrayOutputStream.toByteArray())
    {
      return paramArrayOfByte;
      localByteArrayOutputStream = new ByteArrayOutputStream();
      int i = 0;
      if (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        if (j == 61) {
          i++;
        }
        for (;;)
        {
          try
          {
            j = Utils.digit16(paramArrayOfByte[i]);
            i++;
            localByteArrayOutputStream.write((char)((j << 4) + Utils.digit16(paramArrayOfByte[i])));
            i++;
          }
          catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
          {
            throw new DecoderException("Invalid quoted-printable encoding", paramArrayOfByte);
          }
          localByteArrayOutputStream.write(j);
        }
      }
    }
  }
  
  private static final void encodeQuotedPrintable(int paramInt, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    paramByteArrayOutputStream.write(61);
    int i = Character.toUpperCase(Character.forDigit(paramInt >> 4 & 0xF, 16));
    paramInt = Character.toUpperCase(Character.forDigit(paramInt & 0xF, 16));
    paramByteArrayOutputStream.write(i);
    paramByteArrayOutputStream.write(paramInt);
  }
  
  public static final byte[] encodeQuotedPrintable(BitSet paramBitSet, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (paramBitSet = null;; paramBitSet = paramBitSet.toByteArray())
    {
      return paramBitSet;
      BitSet localBitSet = paramBitSet;
      if (paramBitSet == null) {
        localBitSet = PRINTABLE_CHARS;
      }
      paramBitSet = new ByteArrayOutputStream();
      int i = 0;
      if (i < paramArrayOfByte.length)
      {
        int k = paramArrayOfByte[i];
        int j = k;
        if (k < 0) {
          j = k + 256;
        }
        if (localBitSet.get(j)) {
          paramBitSet.write(j);
        }
        for (;;)
        {
          i++;
          break;
          encodeQuotedPrintable(j, paramBitSet);
        }
      }
    }
  }
  
  public Object decode(Object paramObject)
    throws DecoderException
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      if ((paramObject instanceof byte[]))
      {
        paramObject = decode((byte[])paramObject);
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        paramObject = decode((String)paramObject);
      }
    }
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable decoded");
  }
  
  public String decode(String paramString)
    throws DecoderException
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = decode(paramString, getDefaultCharset());
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new DecoderException(paramString.getMessage(), paramString);
      }
    }
  }
  
  public String decode(String paramString1, String paramString2)
    throws DecoderException, UnsupportedEncodingException
  {
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = new String(decode(StringUtils.getBytesUsAscii(paramString1)), paramString2)) {
      return paramString1;
    }
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
    throws DecoderException
  {
    return decodeQuotedPrintable(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      return paramObject;
      if ((paramObject instanceof byte[]))
      {
        paramObject = encode((byte[])paramObject);
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        paramObject = encode((String)paramObject);
      }
    }
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be quoted-printable encoded");
  }
  
  public String encode(String paramString)
    throws EncoderException
  {
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = encode(paramString, getDefaultCharset());
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new EncoderException(paramString.getMessage(), paramString);
      }
    }
  }
  
  public String encode(String paramString1, String paramString2)
    throws UnsupportedEncodingException
  {
    if (paramString1 == null) {}
    for (paramString1 = null;; paramString1 = StringUtils.newStringUsAscii(encode(paramString1.getBytes(paramString2)))) {
      return paramString1;
    }
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfByte);
  }
  
  public String getDefaultCharset()
  {
    return this.charset;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\net\QuotedPrintableCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */