package org.codehaus.jackson.io;

import java.lang.ref.SoftReference;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;
import org.codehaus.jackson.util.TextBuffer;

public final class JsonStringEncoder
{
  private static final byte[] HEX_BYTES = CharTypes.copyHexBytes();
  private static final char[] HEX_CHARS = ;
  private static final int INT_0 = 48;
  private static final int INT_BACKSLASH = 92;
  private static final int INT_U = 117;
  private static final int SURR1_FIRST = 55296;
  private static final int SURR1_LAST = 56319;
  private static final int SURR2_FIRST = 56320;
  private static final int SURR2_LAST = 57343;
  protected static final ThreadLocal<SoftReference<JsonStringEncoder>> _threadEncoder = new ThreadLocal();
  protected ByteArrayBuilder _byteBuilder;
  protected final char[] _quoteBuffer = new char[6];
  protected TextBuffer _textBuffer;
  
  public JsonStringEncoder()
  {
    this._quoteBuffer[0] = ((char)92);
    this._quoteBuffer[2] = ((char)48);
    this._quoteBuffer[3] = ((char)48);
  }
  
  private int _appendByteEscape(int paramInt1, int paramInt2, ByteArrayBuilder paramByteArrayBuilder, int paramInt3)
  {
    paramByteArrayBuilder.setCurrentSegmentLength(paramInt3);
    paramByteArrayBuilder.append(92);
    if (paramInt2 < 0)
    {
      paramByteArrayBuilder.append(117);
      if (paramInt1 > 255)
      {
        paramInt2 = paramInt1 >> 8;
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt2 >> 4)]);
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt2 & 0xF)]);
        paramInt1 &= 0xFF;
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt1 >> 4)]);
        paramByteArrayBuilder.append(HEX_BYTES[(paramInt1 & 0xF)]);
      }
    }
    for (;;)
    {
      return paramByteArrayBuilder.getCurrentSegmentLength();
      paramByteArrayBuilder.append(48);
      paramByteArrayBuilder.append(48);
      break;
      paramByteArrayBuilder.append((byte)paramInt2);
    }
  }
  
  private int _appendSingleEscape(int paramInt, char[] paramArrayOfChar)
  {
    if (paramInt < 0)
    {
      paramInt = -(paramInt + 1);
      paramArrayOfChar[1] = ((char)117);
      paramArrayOfChar[4] = ((char)HEX_CHARS[(paramInt >> 4)]);
      paramArrayOfChar[5] = ((char)HEX_CHARS[(paramInt & 0xF)]);
    }
    for (paramInt = 6;; paramInt = 2)
    {
      return paramInt;
      paramArrayOfChar[1] = ((char)(char)paramInt);
    }
  }
  
  private int _convertSurrogate(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 56320) || (paramInt2 > 57343)) {
      throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(paramInt1) + ", second 0x" + Integer.toHexString(paramInt2) + "; illegal combination");
    }
    return 65536 + (paramInt1 - 55296 << 10) + (paramInt2 - 56320);
  }
  
  private void _throwIllegalSurrogate(int paramInt)
  {
    if (paramInt > 1114111) {
      throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output; max is 0x10FFFF as per RFC 4627");
    }
    if (paramInt >= 55296)
    {
      if (paramInt <= 56319) {
        throw new IllegalArgumentException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
      }
      throw new IllegalArgumentException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(paramInt) + ")");
    }
    throw new IllegalArgumentException("Illegal character point (0x" + Integer.toHexString(paramInt) + ") to output");
  }
  
  public static JsonStringEncoder getInstance()
  {
    Object localObject1 = (SoftReference)_threadEncoder.get();
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = (JsonStringEncoder)((SoftReference)localObject1).get())
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = new JsonStringEncoder();
        _threadEncoder.set(new SoftReference(localObject2));
      }
      return (JsonStringEncoder)localObject2;
    }
  }
  
  public byte[] encodeAsUTF8(String paramString)
  {
    Object localObject1 = this._byteBuilder;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ByteArrayBuilder(null);
      this._byteBuilder = ((ByteArrayBuilder)localObject2);
    }
    int i2 = paramString.length();
    int i = 0;
    localObject1 = ((ByteArrayBuilder)localObject2).resetAndGetFirstSegment();
    int k = localObject1.length;
    int j = 0;
    int m;
    label69:
    int n;
    int i1;
    if (j < i2)
    {
      m = paramString.charAt(j);
      j++;
      if (m <= 127)
      {
        n = k;
        i1 = i;
        if (i >= k)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          n = localObject1.length;
          i1 = 0;
        }
        i = i1 + 1;
        localObject1[i1] = ((byte)(byte)m);
        if (j < i2) {}
      }
    }
    for (;;)
    {
      return this._byteBuilder.completeAndCoalesce(i);
      m = paramString.charAt(j);
      j++;
      k = n;
      break label69;
      if (i >= k)
      {
        localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
        i = localObject1.length;
      }
      for (k = 0;; k = n)
      {
        if (m < 2048)
        {
          i1 = k + 1;
          localObject1[k] = ((byte)(byte)(m >> 6 | 0xC0));
          n = j;
          k = i1;
          j = i;
          i = n;
          n = m;
        }
        for (;;)
        {
          m = j;
          i1 = k;
          if (k >= j)
          {
            localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
            m = localObject1.length;
            i1 = 0;
          }
          localObject1[i1] = ((byte)(byte)(n & 0x3F | 0x80));
          n = i1 + 1;
          j = i;
          k = m;
          i = n;
          break;
          if ((m >= 55296) && (m <= 57343)) {
            break label383;
          }
          i1 = k + 1;
          localObject1[k] = ((byte)(byte)(m >> 12 | 0xE0));
          k = i;
          n = i1;
          if (i1 >= i)
          {
            localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
            k = localObject1.length;
            n = 0;
          }
          localObject1[n] = ((byte)(byte)(m >> 6 & 0x3F | 0x80));
          i1 = n + 1;
          i = j;
          n = m;
          j = k;
          k = i1;
        }
        label383:
        if (m > 56319) {
          _throwIllegalSurrogate(m);
        }
        if (j >= i2) {
          _throwIllegalSurrogate(m);
        }
        i1 = j + 1;
        n = _convertSurrogate(m, paramString.charAt(j));
        if (n > 1114111) {
          _throwIllegalSurrogate(n);
        }
        m = k + 1;
        localObject1[k] = ((byte)(byte)(n >> 18 | 0xF0));
        j = i;
        k = m;
        if (m >= i)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          j = localObject1.length;
          k = 0;
        }
        i = k + 1;
        localObject1[k] = ((byte)(byte)(n >> 12 & 0x3F | 0x80));
        if (i >= j)
        {
          localObject1 = ((ByteArrayBuilder)localObject2).finishCurrentSegment();
          j = localObject1.length;
          i = 0;
        }
        for (;;)
        {
          localObject1[i] = ((byte)(byte)(n >> 6 & 0x3F | 0x80));
          k = i + 1;
          i = i1;
          break;
        }
        n = i;
        i = k;
      }
    }
  }
  
  public char[] quoteAsString(String paramString)
  {
    Object localObject1 = this._textBuffer;
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new TextBuffer(null);
      this._textBuffer = ((TextBuffer)localObject2);
    }
    localObject1 = ((TextBuffer)localObject2).emptyAndGetCurrentSegment();
    int[] arrayOfInt = CharTypes.get7BitOutputEscapes();
    int n = arrayOfInt.length;
    int j = 0;
    int m = paramString.length();
    int i = 0;
    int k = i;
    label67:
    int i1;
    if (j < m)
    {
      i1 = paramString.charAt(j);
      if ((i1 < n) && (arrayOfInt[i1] != 0))
      {
        i1 = _appendSingleEscape(arrayOfInt[paramString.charAt(j)], this._quoteBuffer);
        if (i + i1 <= localObject1.length) {
          break label250;
        }
        k = localObject1.length - i;
        if (k > 0) {
          System.arraycopy(this._quoteBuffer, 0, localObject1, i, k);
        }
        localObject1 = ((TextBuffer)localObject2).finishCurrentSegment();
        i1 -= k;
        System.arraycopy(this._quoteBuffer, k, localObject1, i, i1);
        i += i1;
      }
    }
    for (;;)
    {
      j++;
      break;
      k = i;
      Object localObject3 = localObject1;
      if (i >= localObject1.length)
      {
        localObject3 = ((TextBuffer)localObject2).finishCurrentSegment();
        k = 0;
      }
      i = k + 1;
      localObject3[k] = ((char)i1);
      j++;
      if (j >= m)
      {
        k = i;
        ((TextBuffer)localObject2).setCurrentLength(k);
        return ((TextBuffer)localObject2).contentsAsArray();
      }
      localObject1 = localObject3;
      break label67;
      label250:
      System.arraycopy(this._quoteBuffer, 0, localObject1, i, i1);
      i += i1;
    }
  }
  
  public byte[] quoteAsUTF8(String paramString)
  {
    Object localObject1 = this._byteBuilder;
    Object localObject3 = localObject1;
    if (localObject1 == null)
    {
      localObject3 = new ByteArrayBuilder(null);
      this._byteBuilder = ((ByteArrayBuilder)localObject3);
    }
    int j = 0;
    int n = paramString.length();
    int i = 0;
    localObject1 = ((ByteArrayBuilder)localObject3).resetAndGetFirstSegment();
    int k;
    int m;
    int i1;
    for (;;)
    {
      k = i;
      int[] arrayOfInt;
      if (j < n)
      {
        arrayOfInt = CharTypes.get7BitOutputEscapes();
        localObject2 = localObject1;
        k = j;
      }
      for (;;)
      {
        m = paramString.charAt(k);
        if ((m > 127) || (arrayOfInt[m] != 0))
        {
          localObject1 = localObject2;
          j = i;
          if (i >= localObject2.length)
          {
            localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
            j = 0;
          }
          i = k + 1;
          i1 = paramString.charAt(k);
          if (i1 > 127) {
            break label229;
          }
          k = _appendByteEscape(i1, arrayOfInt[i1], (ByteArrayBuilder)localObject3, j);
          localObject1 = ((ByteArrayBuilder)localObject3).getCurrentSegment();
          j = i;
          i = k;
          break;
        }
        localObject1 = localObject2;
        j = i;
        if (i >= localObject2.length)
        {
          localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
          j = 0;
        }
        i = j + 1;
        localObject1[j] = ((byte)(byte)m);
        k++;
        if (k >= n)
        {
          k = i;
          return this._byteBuilder.completeAndCoalesce(k);
        }
        localObject2 = localObject1;
      }
      label229:
      if (i1 > 2047) {
        break;
      }
      localObject1[j] = ((byte)(byte)(i1 >> 6 | 0xC0));
      k = i1 & 0x3F | 0x80;
      j++;
      Object localObject2 = localObject1;
      m = j;
      if (j >= localObject1.length)
      {
        localObject2 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
        m = 0;
      }
      localObject2[m] = ((byte)(byte)k);
      k = m + 1;
      j = i;
      localObject1 = localObject2;
      i = k;
    }
    if ((i1 < 55296) || (i1 > 57343))
    {
      k = j + 1;
      localObject1[j] = ((byte)(byte)(i1 >> 12 | 0xE0));
      if (k < localObject1.length) {
        break label579;
      }
      localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
    }
    label579:
    for (j = 0;; j = k)
    {
      localObject1[j] = ((byte)(byte)(i1 >> 6 & 0x3F | 0x80));
      k = i1 & 0x3F | 0x80;
      j++;
      break;
      if (i1 > 56319) {
        _throwIllegalSurrogate(i1);
      }
      if (i >= n) {
        _throwIllegalSurrogate(i1);
      }
      m = i + 1;
      k = _convertSurrogate(i1, paramString.charAt(i));
      if (k > 1114111) {
        _throwIllegalSurrogate(k);
      }
      i = j + 1;
      localObject1[j] = ((byte)(byte)(k >> 18 | 0xF0));
      if (i >= localObject1.length)
      {
        localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
        i = 0;
      }
      for (;;)
      {
        j = i + 1;
        localObject1[i] = ((byte)(byte)(k >> 12 & 0x3F | 0x80));
        if (j >= localObject1.length) {
          localObject1 = ((ByteArrayBuilder)localObject3).finishCurrentSegment();
        }
        for (i = 0;; i = j)
        {
          localObject1[i] = ((byte)(byte)(k >> 6 & 0x3F | 0x80));
          k = k & 0x3F | 0x80;
          j = i + 1;
          i = m;
          break;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\io\JsonStringEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */