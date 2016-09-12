package org.apache.commons.codec.binary;

import java.math.BigInteger;

public class Base64
  extends BaseNCodec
{
  private static final int BITS_PER_ENCODED_BYTE = 6;
  private static final int BYTES_PER_ENCODED_BLOCK = 4;
  private static final int BYTES_PER_UNENCODED_BLOCK = 3;
  static final byte[] CHUNK_SEPARATOR = { 13, 10 };
  private static final byte[] DECODE_TABLE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, 62, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
  private static final int MASK_6BITS = 63;
  private static final byte[] STANDARD_ENCODE_TABLE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
  private static final byte[] URL_SAFE_ENCODE_TABLE = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
  private int bitWorkArea;
  private final int decodeSize;
  private final byte[] decodeTable;
  private final int encodeSize;
  private final byte[] encodeTable;
  private final byte[] lineSeparator;
  
  public Base64()
  {
    this(0);
  }
  
  public Base64(int paramInt)
  {
    this(paramInt, CHUNK_SEPARATOR);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, paramArrayOfByte, false);
  }
  
  public Base64(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public Base64(boolean paramBoolean)
  {
    this(76, CHUNK_SEPARATOR, paramBoolean);
  }
  
  public static byte[] decodeBase64(String paramString)
  {
    return new Base64().decode(paramString);
  }
  
  public static byte[] decodeBase64(byte[] paramArrayOfByte)
  {
    return new Base64().decode(paramArrayOfByte);
  }
  
  public static BigInteger decodeInteger(byte[] paramArrayOfByte)
  {
    return new BigInteger(1, decodeBase64(paramArrayOfByte));
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return encodeBase64(paramArrayOfByte, paramBoolean, false);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    return encodeBase64(paramArrayOfByte, paramBoolean1, paramBoolean2, Integer.MAX_VALUE);
  }
  
  public static byte[] encodeBase64(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject = paramArrayOfByte;
    if (paramArrayOfByte != null) {
      if (paramArrayOfByte.length != 0) {
        break label18;
      }
    }
    for (localObject = paramArrayOfByte;; localObject = ((Base64)localObject).encode(paramArrayOfByte))
    {
      return (byte[])localObject;
      label18:
      if (paramBoolean1) {}
      for (localObject = new Base64(paramBoolean2);; localObject = new Base64(0, CHUNK_SEPARATOR, paramBoolean2))
      {
        long l = ((Base64)localObject).getEncodedLength(paramArrayOfByte);
        if (l <= paramInt) {
          break;
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + l + ") than the specified maximum size of " + paramInt);
      }
    }
  }
  
  public static byte[] encodeBase64Chunked(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, true);
  }
  
  public static String encodeBase64String(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfByte, false));
  }
  
  public static byte[] encodeBase64URLSafe(byte[] paramArrayOfByte)
  {
    return encodeBase64(paramArrayOfByte, false, true);
  }
  
  public static String encodeBase64URLSafeString(byte[] paramArrayOfByte)
  {
    return StringUtils.newStringUtf8(encodeBase64(paramArrayOfByte, false, true));
  }
  
  public static byte[] encodeInteger(BigInteger paramBigInteger)
  {
    if (paramBigInteger == null) {
      throw new NullPointerException("encodeInteger called with null parameter");
    }
    return encodeBase64(toIntegerBytes(paramBigInteger), false);
  }
  
  public static boolean isArrayByteBase64(byte[] paramArrayOfByte)
  {
    return isBase64(paramArrayOfByte);
  }
  
  public static boolean isBase64(byte paramByte)
  {
    if ((paramByte == 61) || ((paramByte >= 0) && (paramByte < DECODE_TABLE.length) && (DECODE_TABLE[paramByte] != -1))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isBase64(String paramString)
  {
    return isBase64(StringUtils.getBytesUtf8(paramString));
  }
  
  public static boolean isBase64(byte[] paramArrayOfByte)
  {
    int i = 0;
    if (i < paramArrayOfByte.length) {
      if ((isBase64(paramArrayOfByte[i])) || (isWhiteSpace(paramArrayOfByte[i]))) {}
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      i++;
      break;
    }
  }
  
  static byte[] toIntegerBytes(BigInteger paramBigInteger)
  {
    int m = paramBigInteger.bitLength() + 7 >> 3 << 3;
    byte[] arrayOfByte = paramBigInteger.toByteArray();
    if ((paramBigInteger.bitLength() % 8 != 0) && (paramBigInteger.bitLength() / 8 + 1 == m / 8)) {
      paramBigInteger = arrayOfByte;
    }
    for (;;)
    {
      return paramBigInteger;
      int i = 0;
      int k = arrayOfByte.length;
      int j = k;
      if (paramBigInteger.bitLength() % 8 == 0)
      {
        i = 1;
        j = k - 1;
      }
      k = m / 8;
      paramBigInteger = new byte[m / 8];
      System.arraycopy(arrayOfByte, i, paramBigInteger, k - j, j);
    }
  }
  
  void decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {}
    label403:
    for (;;)
    {
      return;
      if (paramInt2 < 0) {
        this.eof = true;
      }
      int i = 0;
      int j;
      if (i < paramInt2)
      {
        ensureBufferSize(this.decodeSize);
        j = paramArrayOfByte[paramInt1];
        if (j == 61) {
          this.eof = true;
        }
      }
      for (;;)
      {
        if ((!this.eof) || (this.modulus == 0)) {
          break label403;
        }
        ensureBufferSize(this.decodeSize);
        switch (this.modulus)
        {
        default: 
          break;
        case 2: 
          this.bitWorkArea >>= 4;
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(this.bitWorkArea & 0xFF));
          break;
          if ((j >= 0) && (j < DECODE_TABLE.length))
          {
            j = DECODE_TABLE[j];
            if (j >= 0)
            {
              this.modulus = ((this.modulus + 1) % 4);
              this.bitWorkArea = ((this.bitWorkArea << 6) + j);
              if (this.modulus == 0)
              {
                byte[] arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(this.bitWorkArea >> 16 & 0xFF));
                arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(this.bitWorkArea >> 8 & 0xFF));
                arrayOfByte = this.buffer;
                j = this.pos;
                this.pos = (j + 1);
                arrayOfByte[j] = ((byte)(byte)(this.bitWorkArea & 0xFF));
              }
            }
          }
          i++;
          paramInt1++;
          break;
        case 3: 
          this.bitWorkArea >>= 2;
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(this.bitWorkArea >> 8 & 0xFF));
          paramArrayOfByte = this.buffer;
          paramInt1 = this.pos;
          this.pos = (paramInt1 + 1);
          paramArrayOfByte[paramInt1] = ((byte)(byte)(this.bitWorkArea & 0xFF));
          break;
        }
      }
    }
  }
  
  void encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.eof) {}
    for (;;)
    {
      return;
      if (paramInt2 < 0)
      {
        this.eof = true;
        if ((this.modulus != 0) || (this.lineLength != 0))
        {
          ensureBufferSize(this.encodeSize);
          paramInt1 = this.pos;
          switch (this.modulus)
          {
          }
          for (;;)
          {
            this.currentLinePos += this.pos - paramInt1;
            if ((this.lineLength <= 0) || (this.currentLinePos <= 0)) {
              break;
            }
            System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
            this.pos += this.lineSeparator.length;
            break;
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[(this.bitWorkArea >> 2 & 0x3F)]);
            paramArrayOfByte = this.buffer;
            paramInt2 = this.pos;
            this.pos = (paramInt2 + 1);
            paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[(this.bitWorkArea << 4 & 0x3F)]);
            if (this.encodeTable == STANDARD_ENCODE_TABLE)
            {
              paramArrayOfByte = this.buffer;
              paramInt2 = this.pos;
              this.pos = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = ((byte)61);
              paramArrayOfByte = this.buffer;
              paramInt2 = this.pos;
              this.pos = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = ((byte)61);
              continue;
              paramArrayOfByte = this.buffer;
              paramInt2 = this.pos;
              this.pos = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[(this.bitWorkArea >> 10 & 0x3F)]);
              paramArrayOfByte = this.buffer;
              paramInt2 = this.pos;
              this.pos = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[(this.bitWorkArea >> 4 & 0x3F)]);
              paramArrayOfByte = this.buffer;
              paramInt2 = this.pos;
              this.pos = (paramInt2 + 1);
              paramArrayOfByte[paramInt2] = ((byte)this.encodeTable[(this.bitWorkArea << 2 & 0x3F)]);
              if (this.encodeTable == STANDARD_ENCODE_TABLE)
              {
                paramArrayOfByte = this.buffer;
                paramInt2 = this.pos;
                this.pos = (paramInt2 + 1);
                paramArrayOfByte[paramInt2] = ((byte)61);
              }
            }
          }
        }
      }
      else
      {
        int i = 0;
        while (i < paramInt2)
        {
          ensureBufferSize(this.encodeSize);
          this.modulus = ((this.modulus + 1) % 3);
          int k = paramArrayOfByte[paramInt1];
          int j = k;
          if (k < 0) {
            j = k + 256;
          }
          this.bitWorkArea = ((this.bitWorkArea << 8) + j);
          if (this.modulus == 0)
          {
            byte[] arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[(this.bitWorkArea >> 18 & 0x3F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[(this.bitWorkArea >> 12 & 0x3F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[(this.bitWorkArea >> 6 & 0x3F)]);
            arrayOfByte = this.buffer;
            j = this.pos;
            this.pos = (j + 1);
            arrayOfByte[j] = ((byte)this.encodeTable[(this.bitWorkArea & 0x3F)]);
            this.currentLinePos += 4;
            if ((this.lineLength > 0) && (this.lineLength <= this.currentLinePos))
            {
              System.arraycopy(this.lineSeparator, 0, this.buffer, this.pos, this.lineSeparator.length);
              this.pos += this.lineSeparator.length;
              this.currentLinePos = 0;
            }
          }
          i++;
          paramInt1++;
        }
      }
    }
  }
  
  protected boolean isInAlphabet(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte < this.decodeTable.length) && (this.decodeTable[paramByte] != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isUrlSafe()
  {
    if (this.encodeTable == URL_SAFE_ENCODE_TABLE) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\binary\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */