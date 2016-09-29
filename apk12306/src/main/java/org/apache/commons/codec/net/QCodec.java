package org.apache.commons.codec.net;

import java.io.UnsupportedEncodingException;
import java.util.BitSet;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringDecoder;
import org.apache.commons.codec.StringEncoder;

public class QCodec
  extends RFC1522Codec
  implements StringDecoder, StringEncoder
{
  private static final byte BLANK = 32;
  private static final BitSet PRINTABLE_CHARS = new BitSet(256);
  private static final byte UNDERSCORE = 95;
  private final String charset;
  private boolean encodeBlanks = false;
  
  static
  {
    PRINTABLE_CHARS.set(32);
    PRINTABLE_CHARS.set(33);
    PRINTABLE_CHARS.set(34);
    PRINTABLE_CHARS.set(35);
    PRINTABLE_CHARS.set(36);
    PRINTABLE_CHARS.set(37);
    PRINTABLE_CHARS.set(38);
    PRINTABLE_CHARS.set(39);
    PRINTABLE_CHARS.set(40);
    PRINTABLE_CHARS.set(41);
    PRINTABLE_CHARS.set(42);
    PRINTABLE_CHARS.set(43);
    PRINTABLE_CHARS.set(44);
    PRINTABLE_CHARS.set(45);
    PRINTABLE_CHARS.set(46);
    PRINTABLE_CHARS.set(47);
    for (int i = 48; i <= 57; i++) {
      PRINTABLE_CHARS.set(i);
    }
    PRINTABLE_CHARS.set(58);
    PRINTABLE_CHARS.set(59);
    PRINTABLE_CHARS.set(60);
    PRINTABLE_CHARS.set(62);
    PRINTABLE_CHARS.set(64);
    for (i = 65; i <= 90; i++) {
      PRINTABLE_CHARS.set(i);
    }
    PRINTABLE_CHARS.set(91);
    PRINTABLE_CHARS.set(92);
    PRINTABLE_CHARS.set(93);
    PRINTABLE_CHARS.set(94);
    PRINTABLE_CHARS.set(96);
    for (i = 97; i <= 122; i++) {
      PRINTABLE_CHARS.set(i);
    }
    PRINTABLE_CHARS.set(123);
    PRINTABLE_CHARS.set(124);
    PRINTABLE_CHARS.set(125);
    PRINTABLE_CHARS.set(126);
  }
  
  public QCodec()
  {
    this("UTF-8");
  }
  
  public QCodec(String paramString)
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
    throw new DecoderException("Objects of type " + paramObject.getClass().getName() + " cannot be decoded using Q codec");
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
    throws DecoderException
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      int k = 0;
      int j = 0;
      int i = k;
      byte[] arrayOfByte;
      if (j < paramArrayOfByte.length)
      {
        if (paramArrayOfByte[j] == 95) {
          i = 1;
        }
      }
      else
      {
        if (i == 0) {
          break label97;
        }
        arrayOfByte = new byte[paramArrayOfByte.length];
        i = 0;
        label44:
        if (i >= paramArrayOfByte.length) {
          break label88;
        }
        j = paramArrayOfByte[i];
        if (j == 95) {
          break label78;
        }
        arrayOfByte[i] = ((byte)j);
      }
      for (;;)
      {
        i++;
        break label44;
        j++;
        break;
        label78:
        arrayOfByte[i] = ((byte)32);
      }
      label88:
      paramArrayOfByte = QuotedPrintableCodec.decodeQuotedPrintable(arrayOfByte);
      continue;
      label97:
      paramArrayOfByte = QuotedPrintableCodec.decodeQuotedPrintable(paramArrayOfByte);
    }
  }
  
  protected byte[] doEncoding(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = null;
    }
    byte[] arrayOfByte;
    do
    {
      return paramArrayOfByte;
      arrayOfByte = QuotedPrintableCodec.encodeQuotedPrintable(PRINTABLE_CHARS, paramArrayOfByte);
      paramArrayOfByte = arrayOfByte;
    } while (!this.encodeBlanks);
    for (int i = 0;; i++)
    {
      paramArrayOfByte = arrayOfByte;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (arrayOfByte[i] == 32) {
        arrayOfByte[i] = ((byte)95);
      }
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
    throw new EncoderException("Objects of type " + paramObject.getClass().getName() + " cannot be encoded using Q codec");
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
    return "Q";
  }
  
  public boolean isEncodeBlanks()
  {
    return this.encodeBlanks;
  }
  
  public void setEncodeBlanks(boolean paramBoolean)
  {
    this.encodeBlanks = paramBoolean;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\net\QCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */