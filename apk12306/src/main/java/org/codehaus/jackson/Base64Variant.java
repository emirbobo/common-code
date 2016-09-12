package org.codehaus.jackson;

import java.util.Arrays;

public final class Base64Variant
{
  public static final int BASE64_VALUE_INVALID = -1;
  public static final int BASE64_VALUE_PADDING = -2;
  static final char PADDING_CHAR_NONE = '\000';
  private final int[] _asciiToBase64 = new int[''];
  private final byte[] _base64ToAsciiB = new byte[64];
  private final char[] _base64ToAsciiC = new char[64];
  final int _maxLineLength;
  final String _name;
  final char _paddingChar;
  final boolean _usesPadding;
  
  public Base64Variant(String paramString1, String paramString2, boolean paramBoolean, char paramChar, int paramInt)
  {
    this._name = paramString1;
    this._usesPadding = paramBoolean;
    this._paddingChar = ((char)paramChar);
    this._maxLineLength = paramInt;
    int i = paramString2.length();
    if (i != 64) {
      throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + i + ")");
    }
    paramString2.getChars(0, i, this._base64ToAsciiC, 0);
    Arrays.fill(this._asciiToBase64, -1);
    for (paramInt = 0; paramInt < i; paramInt++)
    {
      int j = this._base64ToAsciiC[paramInt];
      this._base64ToAsciiB[paramInt] = ((byte)(byte)j);
      this._asciiToBase64[j] = paramInt;
    }
    if (paramBoolean) {
      this._asciiToBase64[paramChar] = -2;
    }
  }
  
  public Base64Variant(Base64Variant paramBase64Variant, String paramString, int paramInt)
  {
    this(paramBase64Variant, paramString, paramBase64Variant._usesPadding, paramBase64Variant._paddingChar, paramInt);
  }
  
  public Base64Variant(Base64Variant paramBase64Variant, String paramString, boolean paramBoolean, char paramChar, int paramInt)
  {
    this._name = paramString;
    paramString = paramBase64Variant._base64ToAsciiB;
    System.arraycopy(paramString, 0, this._base64ToAsciiB, 0, paramString.length);
    paramString = paramBase64Variant._base64ToAsciiC;
    System.arraycopy(paramString, 0, this._base64ToAsciiC, 0, paramString.length);
    paramBase64Variant = paramBase64Variant._asciiToBase64;
    System.arraycopy(paramBase64Variant, 0, this._asciiToBase64, 0, paramBase64Variant.length);
    this._usesPadding = paramBoolean;
    this._paddingChar = ((char)paramChar);
    this._maxLineLength = paramInt;
  }
  
  public int decodeBase64Byte(byte paramByte)
  {
    if (paramByte <= Byte.MAX_VALUE) {}
    for (paramByte = this._asciiToBase64[paramByte];; paramByte = -1) {
      return paramByte;
    }
  }
  
  public int decodeBase64Char(char paramChar)
  {
    if (paramChar <= '') {}
    for (paramChar = this._asciiToBase64[paramChar];; paramChar = '￿') {
      return paramChar;
    }
  }
  
  public int decodeBase64Char(int paramInt)
  {
    if (paramInt <= 127) {}
    for (paramInt = this._asciiToBase64[paramInt];; paramInt = -1) {
      return paramInt;
    }
  }
  
  public String encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, false);
  }
  
  public String encode(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    int m = paramArrayOfByte.length;
    StringBuilder localStringBuilder = new StringBuilder((m >> 2) + m + (m >> 3));
    if (paramBoolean) {
      localStringBuilder.append('"');
    }
    int j = getMaxLineLength() >> 2;
    for (int i = 0; i <= m - 3; i = k)
    {
      int n = i + 1;
      i = paramArrayOfByte[i];
      k = n + 1;
      encodeBase64Chunk(localStringBuilder, (i << 8 | paramArrayOfByte[n] & 0xFF) << 8 | paramArrayOfByte[k] & 0xFF);
      j--;
      i = j;
      if (j <= 0)
      {
        localStringBuilder.append('\\');
        localStringBuilder.append('n');
        i = getMaxLineLength() >> 2;
      }
      k++;
      j = i;
    }
    int k = m - i;
    if (k > 0)
    {
      m = i + 1;
      j = paramArrayOfByte[i] << 16;
      i = j;
      if (k == 2) {
        i = j | (paramArrayOfByte[m] & 0xFF) << 8;
      }
      encodeBase64Partial(localStringBuilder, i, k);
    }
    for (;;)
    {
      if (paramBoolean) {
        localStringBuilder.append('"');
      }
      return localStringBuilder.toString();
    }
  }
  
  public byte encodeBase64BitsAsByte(int paramInt)
  {
    return this._base64ToAsciiB[paramInt];
  }
  
  public char encodeBase64BitsAsChar(int paramInt)
  {
    return this._base64ToAsciiC[paramInt];
  }
  
  public int encodeBase64Chunk(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)this._base64ToAsciiB[(paramInt1 >> 18 & 0x3F)]);
    paramInt2 = i + 1;
    paramArrayOfByte[i] = ((byte)this._base64ToAsciiB[(paramInt1 >> 12 & 0x3F)]);
    i = paramInt2 + 1;
    paramArrayOfByte[paramInt2] = ((byte)this._base64ToAsciiB[(paramInt1 >> 6 & 0x3F)]);
    paramArrayOfByte[i] = ((byte)this._base64ToAsciiB[(paramInt1 & 0x3F)]);
    return i + 1;
  }
  
  public int encodeBase64Chunk(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    int i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = ((char)this._base64ToAsciiC[(paramInt1 >> 18 & 0x3F)]);
    paramInt2 = i + 1;
    paramArrayOfChar[i] = ((char)this._base64ToAsciiC[(paramInt1 >> 12 & 0x3F)]);
    i = paramInt2 + 1;
    paramArrayOfChar[paramInt2] = ((char)this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)]);
    paramArrayOfChar[i] = ((char)this._base64ToAsciiC[(paramInt1 & 0x3F)]);
    return i + 1;
  }
  
  public void encodeBase64Chunk(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt >> 18 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt >> 12 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt >> 6 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt & 0x3F)]);
  }
  
  public int encodeBase64Partial(int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int j = paramInt3 + 1;
    paramArrayOfByte[paramInt3] = ((byte)this._base64ToAsciiB[(paramInt1 >> 18 & 0x3F)]);
    int i = j + 1;
    paramArrayOfByte[j] = ((byte)this._base64ToAsciiB[(paramInt1 >> 12 & 0x3F)]);
    if (this._usesPadding)
    {
      paramInt3 = (byte)this._paddingChar;
      j = i + 1;
      if (paramInt2 == 2)
      {
        paramInt1 = this._base64ToAsciiB[(paramInt1 >> 6 & 0x3F)];
        paramArrayOfByte[i] = ((byte)paramInt1);
        paramInt1 = j + 1;
        paramArrayOfByte[j] = ((byte)paramInt3);
        paramInt3 = paramInt1;
      }
    }
    for (;;)
    {
      return paramInt3;
      paramInt1 = paramInt3;
      break;
      paramInt3 = i;
      if (paramInt2 == 2)
      {
        paramArrayOfByte[i] = ((byte)this._base64ToAsciiB[(paramInt1 >> 6 & 0x3F)]);
        paramInt3 = i + 1;
      }
    }
  }
  
  public int encodeBase64Partial(int paramInt1, int paramInt2, char[] paramArrayOfChar, int paramInt3)
  {
    int j = paramInt3 + 1;
    paramArrayOfChar[paramInt3] = ((char)this._base64ToAsciiC[(paramInt1 >> 18 & 0x3F)]);
    int i = j + 1;
    paramArrayOfChar[j] = ((char)this._base64ToAsciiC[(paramInt1 >> 12 & 0x3F)]);
    if (this._usesPadding)
    {
      j = i + 1;
      if (paramInt2 == 2)
      {
        paramInt1 = this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)];
        paramArrayOfChar[i] = ((char)paramInt1);
        paramInt3 = j + 1;
        paramArrayOfChar[j] = ((char)this._paddingChar);
      }
    }
    for (;;)
    {
      return paramInt3;
      paramInt1 = this._paddingChar;
      break;
      paramInt3 = i;
      if (paramInt2 == 2)
      {
        paramArrayOfChar[i] = ((char)this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)]);
        paramInt3 = i + 1;
      }
    }
  }
  
  public void encodeBase64Partial(StringBuilder paramStringBuilder, int paramInt1, int paramInt2)
  {
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt1 >> 18 & 0x3F)]);
    paramStringBuilder.append(this._base64ToAsciiC[(paramInt1 >> 12 & 0x3F)]);
    if (this._usesPadding) {
      if (paramInt2 == 2)
      {
        paramInt1 = this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)];
        int i = paramInt1;
        paramStringBuilder.append(i);
        paramStringBuilder.append(this._paddingChar);
      }
    }
    for (;;)
    {
      return;
      paramInt1 = this._paddingChar;
      int j = paramInt1;
      break;
      if (paramInt2 == 2) {
        paramStringBuilder.append(this._base64ToAsciiC[(paramInt1 >> 6 & 0x3F)]);
      }
    }
  }
  
  public int getMaxLineLength()
  {
    return this._maxLineLength;
  }
  
  public String getName()
  {
    return this._name;
  }
  
  public byte getPaddingByte()
  {
    return (byte)this._paddingChar;
  }
  
  public char getPaddingChar()
  {
    return this._paddingChar;
  }
  
  public String toString()
  {
    return this._name;
  }
  
  public boolean usesPadding()
  {
    return this._usesPadding;
  }
  
  public boolean usesPaddingChar(char paramChar)
  {
    if (paramChar == this._paddingChar) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean usesPaddingChar(int paramInt)
  {
    if (paramInt == this._paddingChar) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\Base64Variant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */