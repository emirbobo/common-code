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

public class URLCodec
  implements BinaryDecoder, BinaryEncoder, StringDecoder, StringEncoder
{
  protected static final byte ESCAPE_CHAR = 37;
  static final int RADIX = 16;
  protected static final BitSet WWW_FORM_URL = new BitSet(256);
  protected String charset;
  
  static
  {
    for (int i = 97; i <= 122; i++) {
      WWW_FORM_URL.set(i);
    }
    for (i = 65; i <= 90; i++) {
      WWW_FORM_URL.set(i);
    }
    for (i = 48; i <= 57; i++) {
      WWW_FORM_URL.set(i);
    }
    WWW_FORM_URL.set(45);
    WWW_FORM_URL.set(95);
    WWW_FORM_URL.set(46);
    WWW_FORM_URL.set(42);
    WWW_FORM_URL.set(32);
  }
  
  public URLCodec()
  {
    this("UTF-8");
  }
  
  public URLCodec(String paramString)
  {
    this.charset = paramString;
  }
  
  public static final byte[] decodeUrl(byte[] paramArrayOfByte)
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
        if (j == 43) {
          localByteArrayOutputStream.write(32);
        }
        for (;;)
        {
          i++;
          break;
          if (j == 37)
          {
            i++;
            try
            {
              j = Utils.digit16(paramArrayOfByte[i]);
              i++;
              localByteArrayOutputStream.write((char)((j << 4) + Utils.digit16(paramArrayOfByte[i])));
            }
            catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
            {
              throw new DecoderException("Invalid URL encoding: ", paramArrayOfByte);
            }
          }
          else
          {
            localByteArrayOutputStream.write(j);
          }
        }
      }
    }
  }
  
  public static final byte[] encodeUrl(BitSet paramBitSet, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (paramBitSet = null;; paramBitSet = paramBitSet.toByteArray())
    {
      return paramBitSet;
      BitSet localBitSet = paramBitSet;
      if (paramBitSet == null) {
        localBitSet = WWW_FORM_URL;
      }
      paramBitSet = new ByteArrayOutputStream();
      int j = 0;
      if (j < paramArrayOfByte.length)
      {
        int k = paramArrayOfByte[j];
        int i = k;
        if (k < 0) {
          i = k + 256;
        }
        if (localBitSet.get(i))
        {
          k = i;
          if (i == 32) {
            k = 43;
          }
          paramBitSet.write(k);
        }
        for (;;)
        {
          j++;
          break;
          paramBitSet.write(37);
          k = Character.toUpperCase(Character.forDigit(i >> 4 & 0xF, 16));
          i = Character.toUpperCase(Character.forDigit(i & 0xF, 16));
          paramBitSet.write(k);
          paramBitSet.write(i);
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
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL decoded");
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
    return decodeUrl(paramArrayOfByte);
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
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be URL encoded");
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
    return encodeUrl(WWW_FORM_URL, paramArrayOfByte);
  }
  
  public String getDefaultCharset()
  {
    return this.charset;
  }
  
  public String getEncoding()
  {
    return this.charset;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\net\URLCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */