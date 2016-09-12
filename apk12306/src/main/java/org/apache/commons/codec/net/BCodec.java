package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.binary.Base64;

public class BCodec
  extends RFC1522Codec
  implements StringDecoder, StringEncoder
{
  private final String charset;
  
  public BCodec()
  {
    this("UTF-8");
  }
  
  public BCodec(String paramString)
  {
    this.charset = paramString;
  }
  
  public Object decode(Object paramObject)
    throws DecoderException
  {
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = decode((String)paramObject))
    {
      return paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
    }
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be decoded using BCodec");
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
        paramString = decodeText(paramString);
      }
      catch (UnsupportedEncodingException paramString)
      {
        throw new DecoderException(paramString.getMessage(), paramString);
      }
    }
  }
  
  protected byte[] doDecoding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = null;; paramArrayOfByte = Base64.decodeBase64(paramArrayOfByte)) {
      return paramArrayOfByte;
    }
  }
  
  protected byte[] doEncoding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (paramArrayOfByte = null;; paramArrayOfByte = Base64.encodeBase64(paramArrayOfByte)) {
      return paramArrayOfByte;
    }
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (paramObject == null) {}
    for (paramObject = null;; paramObject = encode((String)paramObject))
    {
      return paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
    }
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be encoded using BCodec");
  }
  
  public String encode(String paramString)
    throws EncoderException
  {
    if (paramString == null) {}
    for (paramString = null;; paramString = encode(paramString, getDefaultCharset())) {
      return paramString;
    }
  }
  
  public String encode(String paramString1, String paramString2)
    throws EncoderException
  {
    if (paramString1 == null) {
      paramString1 = null;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        paramString1 = encodeText(paramString1, paramString2);
      }
      catch (UnsupportedEncodingException paramString1)
      {
        throw new EncoderException(paramString1.getMessage(), paramString1);
      }
    }
  }
  
  public String getDefaultCharset()
  {
    return this.charset;
  }
  
  protected String getEncoding()
  {
    return "B";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\net\BCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */