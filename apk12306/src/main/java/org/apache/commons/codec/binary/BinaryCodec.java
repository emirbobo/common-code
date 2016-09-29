package org.apache.commons.codec.binary;

import org.apache.commons.codec.BinaryDecoder;
import org.apache.commons.codec.BinaryEncoder;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

public class BinaryCodec
  implements BinaryDecoder, BinaryEncoder
{
  private static final int[] BITS = { 1, 2, 4, 8, 16, 32, 64, 128 };
  private static final int BIT_0 = 1;
  private static final int BIT_1 = 2;
  private static final int BIT_2 = 4;
  private static final int BIT_3 = 8;
  private static final int BIT_4 = 16;
  private static final int BIT_5 = 32;
  private static final int BIT_6 = 64;
  private static final int BIT_7 = 128;
  private static final byte[] EMPTY_BYTE_ARRAY;
  private static final char[] EMPTY_CHAR_ARRAY = new char[0];
  
  static
  {
    EMPTY_BYTE_ARRAY = new byte[0];
  }
  
  public static byte[] fromAscii(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (isEmpty(paramArrayOfByte))
    {
      localObject = EMPTY_BYTE_ARRAY;
      return (byte[])localObject;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length >> 3];
    int j = 0;
    for (int i = paramArrayOfByte.length - 1;; i -= 8)
    {
      localObject = arrayOfByte;
      if (j >= arrayOfByte.length) {
        break;
      }
      for (int k = 0; k < BITS.length; k++) {
        if (paramArrayOfByte[(i - k)] == 49) {
          arrayOfByte[j] = ((byte)(byte)(arrayOfByte[j] | BITS[k]));
        }
      }
      j++;
    }
  }
  
  public static byte[] fromAscii(char[] paramArrayOfChar)
  {
    Object localObject;
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0))
    {
      localObject = EMPTY_BYTE_ARRAY;
      return (byte[])localObject;
    }
    byte[] arrayOfByte = new byte[paramArrayOfChar.length >> 3];
    int j = 0;
    for (int i = paramArrayOfChar.length - 1;; i -= 8)
    {
      localObject = arrayOfByte;
      if (j >= arrayOfByte.length) {
        break;
      }
      for (int k = 0; k < BITS.length; k++) {
        if (paramArrayOfChar[(i - k)] == '1') {
          arrayOfByte[j] = ((byte)(byte)(arrayOfByte[j] | BITS[k]));
        }
      }
      j++;
    }
  }
  
  private static boolean isEmpty(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static byte[] toAsciiBytes(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (isEmpty(paramArrayOfByte))
    {
      localObject = EMPTY_BYTE_ARRAY;
      return (byte[])localObject;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte.length << 3];
    int j = 0;
    for (int i = arrayOfByte.length - 1;; i -= 8)
    {
      localObject = arrayOfByte;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      int k = 0;
      if (k < BITS.length)
      {
        if ((paramArrayOfByte[j] & BITS[k]) == 0) {
          arrayOfByte[(i - k)] = ((byte)48);
        }
        for (;;)
        {
          k++;
          break;
          arrayOfByte[(i - k)] = ((byte)49);
        }
      }
      j++;
    }
  }
  
  public static char[] toAsciiChars(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (isEmpty(paramArrayOfByte))
    {
      localObject = EMPTY_CHAR_ARRAY;
      return (char[])localObject;
    }
    char[] arrayOfChar = new char[paramArrayOfByte.length << 3];
    int j = 0;
    for (int i = arrayOfChar.length - 1;; i -= 8)
    {
      localObject = arrayOfChar;
      if (j >= paramArrayOfByte.length) {
        break;
      }
      int k = 0;
      if (k < BITS.length)
      {
        if ((paramArrayOfByte[j] & BITS[k]) == 0) {
          arrayOfChar[(i - k)] = ((char)48);
        }
        for (;;)
        {
          k++;
          break;
          arrayOfChar[(i - k)] = ((char)49);
        }
      }
      j++;
    }
  }
  
  public static String toAsciiString(byte[] paramArrayOfByte)
  {
    return new String(toAsciiChars(paramArrayOfByte));
  }
  
  public Object decode(Object paramObject)
    throws DecoderException
  {
    if (paramObject == null) {
      paramObject = EMPTY_BYTE_ARRAY;
    }
    for (;;)
    {
      return paramObject;
      if ((paramObject instanceof byte[]))
      {
        paramObject = fromAscii((byte[])paramObject);
      }
      else if ((paramObject instanceof char[]))
      {
        paramObject = fromAscii((char[])paramObject);
      }
      else
      {
        if (!(paramObject instanceof String)) {
          break;
        }
        paramObject = fromAscii(((String)paramObject).toCharArray());
      }
    }
    throw new DecoderException("argument not a byte array");
  }
  
  public byte[] decode(byte[] paramArrayOfByte)
  {
    return fromAscii(paramArrayOfByte);
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof byte[])) {
      throw new EncoderException("argument not a byte array");
    }
    return toAsciiChars((byte[])paramObject);
  }
  
  public byte[] encode(byte[] paramArrayOfByte)
  {
    return toAsciiBytes(paramArrayOfByte);
  }
  
  public byte[] toByteArray(String paramString)
  {
    if (paramString == null) {}
    for (paramString = EMPTY_BYTE_ARRAY;; paramString = fromAscii(paramString.toCharArray())) {
      return paramString;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\binary\BinaryCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */