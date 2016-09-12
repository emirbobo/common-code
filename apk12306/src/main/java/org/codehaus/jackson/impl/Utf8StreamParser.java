package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.InputStream;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.sym.BytesToNameCanonicalizer;
import org.codehaus.jackson.sym.Name;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;
import org.codehaus.jackson.util.TextBuffer;

public final class Utf8StreamParser
  extends StreamBasedParserBase
{
  static final byte BYTE_LF = 10;
  private static final int[] sInputCodesLatin1 = CharTypes.getInputCodeLatin1();
  private static final int[] sInputCodesUtf8 = ;
  protected ObjectCodec _objectCodec;
  private int _quad1;
  protected int[] _quadBuffer = new int[16];
  protected final BytesToNameCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public Utf8StreamParser(IOContext paramIOContext, int paramInt1, InputStream paramInputStream, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, byte[] paramArrayOfByte, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    super(paramIOContext, paramInt1, paramInputStream, paramArrayOfByte, paramInt2, paramInt3, paramBoolean);
    this._objectCodec = paramObjectCodec;
    this._symbols = paramBytesToNameCanonicalizer;
    if (!JsonParser.Feature.CANONICALIZE_FIELD_NAMES.enabledIn(paramInt1)) {
      _throwInternal();
    }
  }
  
  private final int _decodeBase64Escape(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IOException, JsonParseException
  {
    if (paramInt1 != 92) {
      throw reportInvalidChar(paramBase64Variant, paramInt1, paramInt2);
    }
    int j = _decodeEscaped();
    if ((j <= 32) && (paramInt2 == 0)) {
      paramInt1 = -1;
    }
    int i;
    do
    {
      return paramInt1;
      i = paramBase64Variant.decodeBase64Char(j);
      paramInt1 = i;
    } while (i >= 0);
    throw reportInvalidChar(paramBase64Variant, j, paramInt2);
  }
  
  private final int _decodeUtf8_2(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    return (paramInt & 0x1F) << 6 | i & 0x3F;
  }
  
  private final int _decodeUtf8_3(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, this._inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_3fast(int paramInt)
    throws IOException, JsonParseException
  {
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, this._inputPtr);
    }
    return ((paramInt & 0xF) << 6 | i & 0x3F) << 6 | j & 0x3F;
  }
  
  private final int _decodeUtf8_4(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i];
    if ((i & 0xC0) != 128) {
      _reportInvalidOther(i & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    if ((j & 0xC0) != 128) {
      _reportInvalidOther(j & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    int k = this._inputPtr;
    this._inputPtr = (k + 1);
    k = arrayOfByte[k];
    if ((k & 0xC0) != 128) {
      _reportInvalidOther(k & 0xFF, this._inputPtr);
    }
    return ((((paramInt & 0x7) << 6 | i & 0x3F) << 6 | j & 0x3F) << 6 | k & 0x3F) - 65536;
  }
  
  private final void _finishString2(char[] paramArrayOfChar, int paramInt)
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    int j;
    int i;
    for (char[] arrayOfChar = paramArrayOfChar;; arrayOfChar = paramArrayOfChar)
    {
      j = this._inputPtr;
      i = j;
      if (j >= this._inputEnd)
      {
        loadMoreGuaranteed();
        i = this._inputPtr;
      }
      paramArrayOfChar = arrayOfChar;
      j = paramInt;
      if (paramInt >= arrayOfChar.length)
      {
        paramArrayOfChar = this._textBuffer.finishCurrentSegment();
        j = 0;
      }
      int k = Math.min(this._inputEnd, paramArrayOfChar.length - j + i);
      for (paramInt = j; i < k; paramInt++)
      {
        j = i + 1;
        i = arrayOfByte[i] & 0xFF;
        if (arrayOfInt[i] != 0)
        {
          this._inputPtr = j;
          if (i != 34) {
            break label158;
          }
          this._textBuffer.setCurrentLength(paramInt);
          return;
        }
        paramArrayOfChar[paramInt] = ((char)(char)i);
        i = j;
      }
      this._inputPtr = i;
    }
    label158:
    switch (arrayOfInt[i])
    {
    default: 
      if (i < 32) {
        _throwUnquotedSpace(i, "string value");
      }
      break;
    }
    for (;;)
    {
      arrayOfChar = paramArrayOfChar;
      j = paramInt;
      if (paramInt >= paramArrayOfChar.length)
      {
        arrayOfChar = this._textBuffer.finishCurrentSegment();
        j = 0;
      }
      arrayOfChar[j] = ((char)(char)i);
      paramInt = j + 1;
      break;
      i = _decodeEscaped();
      continue;
      i = _decodeUtf8_2(i);
      continue;
      if (this._inputEnd - this._inputPtr >= 2)
      {
        i = _decodeUtf8_3fast(i);
      }
      else
      {
        i = _decodeUtf8_3(i);
        continue;
        j = _decodeUtf8_4(i);
        i = paramInt + 1;
        paramArrayOfChar[paramInt] = ((char)(char)(0xD800 | j >> 10));
        arrayOfChar = paramArrayOfChar;
        paramInt = i;
        if (i >= paramArrayOfChar.length)
        {
          arrayOfChar = this._textBuffer.finishCurrentSegment();
          paramInt = 0;
        }
        i = 0xDC00 | j & 0x3FF;
        paramArrayOfChar = arrayOfChar;
        continue;
        _reportInvalidChar(i);
      }
    }
  }
  
  private final JsonToken _nextAfterName()
  {
    this._nameCopied = false;
    JsonToken localJsonToken = this._nextToken;
    this._nextToken = null;
    if (localJsonToken == JsonToken.START_ARRAY) {
      this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
    }
    for (;;)
    {
      this._currToken = localJsonToken;
      return localJsonToken;
      if (localJsonToken == JsonToken.START_OBJECT) {
        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
      }
    }
  }
  
  private final JsonToken _nextTokenNotInObject(int paramInt)
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken;
    if (paramInt == 34)
    {
      this._tokenIncomplete = true;
      localJsonToken = JsonToken.VALUE_STRING;
      this._currToken = localJsonToken;
    }
    for (;;)
    {
      return localJsonToken;
      switch (paramInt)
      {
      default: 
        localJsonToken = _handleUnexpectedValue(paramInt);
        this._currToken = localJsonToken;
        break;
      case 91: 
        this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        localJsonToken = JsonToken.START_ARRAY;
        this._currToken = localJsonToken;
        break;
      case 123: 
        this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        localJsonToken = JsonToken.START_OBJECT;
        this._currToken = localJsonToken;
        break;
      case 93: 
      case 125: 
        _reportUnexpectedChar(paramInt, "expected a value");
      case 116: 
        _matchToken(JsonToken.VALUE_TRUE);
        localJsonToken = JsonToken.VALUE_TRUE;
        this._currToken = localJsonToken;
        break;
      case 102: 
        _matchToken(JsonToken.VALUE_FALSE);
        localJsonToken = JsonToken.VALUE_FALSE;
        this._currToken = localJsonToken;
        break;
      case 110: 
        _matchToken(JsonToken.VALUE_NULL);
        localJsonToken = JsonToken.VALUE_NULL;
        this._currToken = localJsonToken;
        break;
      case 45: 
      case 48: 
      case 49: 
      case 50: 
      case 51: 
      case 52: 
      case 53: 
      case 54: 
      case 55: 
      case 56: 
      case 57: 
        localJsonToken = parseNumberText(paramInt);
        this._currToken = localJsonToken;
      }
    }
  }
  
  private final JsonToken _parseFloatText(char[] paramArrayOfChar, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
    throws IOException, JsonParseException
  {
    int i1 = 0;
    int m = 0;
    int i = 0;
    int i2 = 0;
    Object localObject = paramArrayOfChar;
    int j = paramInt1;
    int n = paramInt2;
    if (paramInt2 == 46)
    {
      paramArrayOfChar[paramInt1] = ((char)(char)paramInt2);
      paramInt1++;
      k = paramInt2;
      paramInt2 = m;
      if ((this._inputPtr < this._inputEnd) || (loadMore())) {
        break label467;
      }
      m = 1;
      label63:
      i = m;
      i1 = paramInt2;
      localObject = paramArrayOfChar;
      j = paramInt1;
      n = k;
      if (paramInt2 == 0)
      {
        reportUnexpectedNumberChar(k, "Decimal point not followed by a digit");
        n = k;
        j = paramInt1;
        localObject = paramArrayOfChar;
        i1 = paramInt2;
        i = m;
      }
    }
    i2 = 0;
    int k = 0;
    if (n != 101)
    {
      paramInt1 = i;
      m = j;
      if (n != 69) {}
    }
    else
    {
      paramArrayOfChar = (char[])localObject;
      paramInt2 = j;
      if (j >= localObject.length)
      {
        paramArrayOfChar = this._textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      paramInt1 = paramInt2 + 1;
      paramArrayOfChar[paramInt2] = ((char)(char)n);
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = this._inputBuffer;
      paramInt2 = this._inputPtr;
      this._inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      if ((paramInt2 != 45) && (paramInt2 != 43)) {
        break label618;
      }
      if (paramInt1 < paramArrayOfChar.length) {
        break label615;
      }
      paramArrayOfChar = this._textBuffer.finishCurrentSegment();
      paramInt1 = 0;
      label241:
      paramArrayOfChar[paramInt1] = ((char)(char)paramInt2);
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      localObject = this._inputBuffer;
      paramInt2 = this._inputPtr;
      this._inputPtr = (paramInt2 + 1);
      paramInt2 = localObject[paramInt2] & 0xFF;
      paramInt1++;
      m = k;
    }
    for (;;)
    {
      n = i;
      k = m;
      j = paramInt1;
      if (paramInt2 <= 57)
      {
        n = i;
        k = m;
        j = paramInt1;
        if (paramInt2 >= 48)
        {
          k = m + 1;
          localObject = paramArrayOfChar;
          j = paramInt1;
          if (paramInt1 >= paramArrayOfChar.length)
          {
            localObject = this._textBuffer.finishCurrentSegment();
            j = 0;
          }
          paramInt1 = j + 1;
          localObject[j] = ((char)(char)paramInt2);
          if ((this._inputPtr < this._inputEnd) || (loadMore())) {
            break label580;
          }
          n = 1;
          j = paramInt1;
        }
      }
      paramInt1 = n;
      i2 = k;
      m = j;
      if (k == 0)
      {
        reportUnexpectedNumberChar(paramInt2, "Exponent indicator not followed by a digit");
        m = j;
        i2 = k;
        paramInt1 = n;
      }
      if (paramInt1 == 0) {
        this._inputPtr -= 1;
      }
      this._textBuffer.setCurrentLength(m);
      return resetFloat(paramBoolean, paramInt3, i1, i2);
      label467:
      localObject = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = localObject[i] & 0xFF;
      m = i2;
      k = i;
      if (i < 48) {
        break label63;
      }
      m = i2;
      k = i;
      if (i > 57) {
        break label63;
      }
      j = paramInt2 + 1;
      localObject = paramArrayOfChar;
      paramInt2 = paramInt1;
      if (paramInt1 >= paramArrayOfChar.length)
      {
        localObject = this._textBuffer.finishCurrentSegment();
        paramInt2 = 0;
      }
      localObject[paramInt2] = ((char)(char)i);
      paramInt1 = paramInt2 + 1;
      paramInt2 = j;
      paramArrayOfChar = (char[])localObject;
      k = i;
      break;
      label580:
      paramArrayOfChar = this._inputBuffer;
      paramInt2 = this._inputPtr;
      this._inputPtr = (paramInt2 + 1);
      paramInt2 = paramArrayOfChar[paramInt2] & 0xFF;
      m = k;
      paramArrayOfChar = (char[])localObject;
      continue;
      label615:
      break label241;
      label618:
      m = k;
    }
  }
  
  private final JsonToken _parserNumber2(char[] paramArrayOfChar, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore()))
    {
      this._textBuffer.setCurrentLength(paramInt1);
      paramArrayOfChar = resetInt(paramBoolean, paramInt2);
    }
    for (;;)
    {
      return paramArrayOfChar;
      Object localObject = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      int j = localObject[i] & 0xFF;
      if ((j > 57) || (j < 48))
      {
        if ((j == 46) || (j == 101) || (j == 69)) {
          paramArrayOfChar = _parseFloatText(paramArrayOfChar, paramInt1, j, paramBoolean, paramInt2);
        }
      }
      else
      {
        localObject = paramArrayOfChar;
        i = paramInt1;
        if (paramInt1 >= paramArrayOfChar.length)
        {
          localObject = this._textBuffer.finishCurrentSegment();
          i = 0;
        }
        localObject[i] = ((char)(char)j);
        paramInt2++;
        paramInt1 = i + 1;
        paramArrayOfChar = (char[])localObject;
        break;
      }
      this._inputPtr -= 1;
      this._textBuffer.setCurrentLength(paramInt1);
      paramArrayOfChar = resetInt(paramBoolean, paramInt2);
    }
  }
  
  private final void _skipCComment()
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      int j = arrayOfByte[i] & 0xFF;
      i = arrayOfInt[j];
      if (i != 0) {
        switch (i)
        {
        default: 
          _reportInvalidChar(j);
          break;
        case 42: 
          if (this._inputBuffer[this._inputPtr] == 47) {
            this._inputPtr += 1;
          }
          break;
        }
      }
    }
    for (;;)
    {
      return;
      _skipLF();
      break;
      _skipCR();
      break;
      _reportInvalidEOF(" in a comment");
    }
  }
  
  private final void _skipComment()
    throws IOException, JsonParseException
  {
    if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
      _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
    }
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in a comment");
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (i == 47) {
      _skipCppComment();
    }
    for (;;)
    {
      return;
      if (i == 42) {
        _skipCComment();
      } else {
        _reportUnexpectedChar(i, "was expecting either '*' or '/' for a comment");
      }
    }
  }
  
  private final void _skipCppComment()
    throws IOException, JsonParseException
  {
    int[] arrayOfInt = CharTypes.getInputCodeComment();
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      int j = arrayOfByte[i] & 0xFF;
      i = arrayOfInt[j];
      if (i != 0) {
        switch (i)
        {
        case 42: 
        default: 
          _reportInvalidChar(j);
          break;
        case 10: 
          _skipLF();
        }
      }
    }
    for (;;)
    {
      return;
      _skipCR();
    }
  }
  
  private final void _skipUtf8_2(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
  }
  
  private final void _skipUtf8_3(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
  }
  
  private final void _skipUtf8_4(int paramInt)
    throws IOException, JsonParseException
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    arrayOfByte = this._inputBuffer;
    paramInt = this._inputPtr;
    this._inputPtr = (paramInt + 1);
    paramInt = arrayOfByte[paramInt];
    if ((paramInt & 0xC0) != 128) {
      _reportInvalidOther(paramInt & 0xFF, this._inputPtr);
    }
  }
  
  private final int _skipWS()
    throws IOException, JsonParseException
  {
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32)
      {
        if (i != 47) {
          return i;
        }
        _skipComment();
      }
      else if (i != 32)
      {
        if (i == 10) {
          _skipLF();
        } else if (i == 13) {
          _skipCR();
        } else if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
    }
    throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
  }
  
  private final int _skipWSOrEnd()
    throws IOException, JsonParseException
  {
    int i;
    if ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      byte[] arrayOfByte = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (i > 32) {
        if (i == 47) {}
      }
    }
    for (;;)
    {
      return i;
      _skipComment();
      break;
      if (i == 32) {
        break;
      }
      if (i == 10)
      {
        _skipLF();
        break;
      }
      if (i == 13)
      {
        _skipCR();
        break;
      }
      if (i == 9) {
        break;
      }
      _throwInvalidSpace(i);
      break;
      _handleEOF();
      i = -1;
    }
  }
  
  private final int _verifyNoLeadingZeroes()
    throws IOException, JsonParseException
  {
    int i;
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      i = 48;
    }
    for (;;)
    {
      return i;
      int j = this._inputBuffer[this._inputPtr] & 0xFF;
      if ((j < 48) || (j > 57))
      {
        i = 48;
      }
      else
      {
        if (!isEnabled(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)) {
          reportInvalidNumber("Leading zeroes not allowed");
        }
        this._inputPtr += 1;
        i = j;
        if (j == 48)
        {
          i = j;
          if ((this._inputPtr < this._inputEnd) || (loadMore()))
          {
            j = this._inputBuffer[this._inputPtr] & 0xFF;
            if ((j < 48) || (j > 57))
            {
              i = 48;
            }
            else
            {
              this._inputPtr += 1;
              i = j;
              if (j == 48) {
                break;
              }
              i = j;
            }
          }
        }
      }
    }
  }
  
  private final Name addName(int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws JsonParseException
  {
    int i3 = (paramInt1 << 2) - 4 + paramInt2;
    int i2;
    Object localObject1;
    int i;
    int m;
    label49:
    int j;
    int i1;
    int n;
    label120:
    Object localObject2;
    if (paramInt2 < 4)
    {
      i2 = paramArrayOfInt[(paramInt1 - 1)];
      paramArrayOfInt[(paramInt1 - 1)] = (i2 << (4 - paramInt2 << 3));
      localObject1 = this._textBuffer.emptyAndGetCurrentSegment();
      i = 0;
      m = 0;
      if (i >= i3) {
        break label520;
      }
      j = paramArrayOfInt[(i >> 2)] >> (3 - (i & 0x3) << 3) & 0xFF;
      int k = i + 1;
      i1 = j;
      n = k;
      if (j <= 127) {
        break label558;
      }
      if ((j & 0xE0) != 192) {
        break label455;
      }
      i = j & 0x1F;
      j = 1;
      if (k + j > i3) {
        _reportInvalidEOF(" in field name");
      }
      i1 = paramArrayOfInt[(k >> 2)] >> (3 - (k & 0x3) << 3);
      n = k + 1;
      if ((i1 & 0xC0) != 128) {
        _reportInvalidOther(i1);
      }
      i1 = i << 6 | i1 & 0x3F;
      k = i1;
      i = n;
      if (j > 1)
      {
        i = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
        n++;
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i);
        }
        i1 = i1 << 6 | i & 0x3F;
        k = i1;
        i = n;
        if (j > 2)
        {
          k = paramArrayOfInt[(n >> 2)] >> (3 - (n & 0x3) << 3);
          i = n + 1;
          if ((k & 0xC0) != 128) {
            _reportInvalidOther(k & 0xFF);
          }
          k = i1 << 6 | k & 0x3F;
        }
      }
      i1 = k;
      n = i;
      if (j <= 2) {
        break label558;
      }
      k -= 65536;
      localObject2 = localObject1;
      if (m >= localObject1.length) {
        localObject2 = this._textBuffer.expandCurrentSegment();
      }
      j = m + 1;
      localObject2[m] = ((char)(char)(55296 + (k >> 10)));
      i1 = 0xDC00 | k & 0x3FF;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (j >= localObject1.length) {
        localObject2 = this._textBuffer.expandCurrentSegment();
      }
      m = j + 1;
      localObject2[j] = ((char)(char)i1);
      localObject1 = localObject2;
      break label49;
      i2 = 0;
      break;
      label455:
      if ((j & 0xF0) == 224)
      {
        i = j & 0xF;
        j = 2;
        break label120;
      }
      if ((j & 0xF8) == 240)
      {
        i = j & 0x7;
        j = 3;
        break label120;
      }
      _reportInvalidInitial(j);
      i = 1;
      j = 1;
      break label120;
      label520:
      localObject1 = new String((char[])localObject1, 0, m);
      if (paramInt2 < 4) {
        paramArrayOfInt[(paramInt1 - 1)] = i2;
      }
      return this._symbols.addName((String)localObject1, paramArrayOfInt, paramInt1);
      label558:
      j = m;
      i = n;
    }
  }
  
  private final Name findName(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    Name localName = this._symbols.findName(paramInt1);
    if (localName != null) {}
    for (;;)
    {
      return localName;
      this._quadBuffer[0] = paramInt1;
      localName = addName(this._quadBuffer, 1, paramInt2);
    }
  }
  
  private final Name findName(int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    Name localName = this._symbols.findName(paramInt1, paramInt2);
    if (localName != null) {}
    for (;;)
    {
      return localName;
      this._quadBuffer[0] = paramInt1;
      this._quadBuffer[1] = paramInt2;
      localName = addName(this._quadBuffer, 2, paramInt3);
    }
  }
  
  private final Name findName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
    throws JsonParseException
  {
    int[] arrayOfInt = paramArrayOfInt;
    if (paramInt1 >= paramArrayOfInt.length)
    {
      arrayOfInt = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
      this._quadBuffer = arrayOfInt;
    }
    int i = paramInt1 + 1;
    arrayOfInt[paramInt1] = paramInt2;
    Name localName = this._symbols.findName(arrayOfInt, i);
    paramArrayOfInt = localName;
    if (localName == null) {
      paramArrayOfInt = addName(arrayOfInt, i, paramInt3);
    }
    return paramArrayOfInt;
  }
  
  public static int[] growArrayBy(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt == null) {}
    int[] arrayOfInt;
    for (paramArrayOfInt = new int[paramInt];; paramArrayOfInt = arrayOfInt)
    {
      return paramArrayOfInt;
      int i = paramArrayOfInt.length;
      arrayOfInt = new int[i + paramInt];
      System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i);
    }
  }
  
  private int nextByte()
    throws IOException, JsonParseException
  {
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  private final Name parseFieldName(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    return parseEscapedFieldName(this._quadBuffer, 0, paramInt1, paramInt2, paramInt3);
  }
  
  private final Name parseFieldName(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException, JsonParseException
  {
    this._quadBuffer[0] = paramInt1;
    return parseEscapedFieldName(this._quadBuffer, 1, paramInt2, paramInt3, paramInt4);
  }
  
  protected byte[] _decodeBase64(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    ByteArrayBuilder localByteArrayBuilder = _getByteArrayBuilder();
    for (;;)
    {
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      byte[] arrayOfByte = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      int k = arrayOfByte[i] & 0xFF;
      if (k > 32)
      {
        int j = paramBase64Variant.decodeBase64Char(k);
        i = j;
        if (j < 0)
        {
          if (k == 34) {
            return localByteArrayBuilder.toByteArray();
          }
          i = _decodeBase64Escape(paramBase64Variant, k, 0);
          if (i < 0) {}
        }
        else
        {
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = this._inputBuffer;
          j = this._inputPtr;
          this._inputPtr = (j + 1);
          int m = arrayOfByte[j] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(m);
          j = k;
          if (k < 0) {
            j = _decodeBase64Escape(paramBase64Variant, m, 1);
          }
          m = i << 6 | j;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          int n = arrayOfByte[i] & 0xFF;
          k = paramBase64Variant.decodeBase64Char(n);
          j = k;
          if (k < 0)
          {
            i = k;
            if (k != -2) {
              i = _decodeBase64Escape(paramBase64Variant, n, 2);
            }
            j = i;
            if (i == -2)
            {
              if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfByte = this._inputBuffer;
              i = this._inputPtr;
              this._inputPtr = (i + 1);
              i = arrayOfByte[i] & 0xFF;
              if (!paramBase64Variant.usesPaddingChar(i)) {
                throw reportInvalidChar(paramBase64Variant, i, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
              }
              localByteArrayBuilder.append(m >> 4);
              continue;
            }
          }
          m = m << 6 | j;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfByte = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          n = arrayOfByte[i] & 0xFF;
          j = paramBase64Variant.decodeBase64Char(n);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2) {
              i = _decodeBase64Escape(paramBase64Variant, n, 3);
            }
            k = i;
            if (i == -2)
            {
              localByteArrayBuilder.appendTwoBytes(m >> 2);
              continue;
            }
          }
          localByteArrayBuilder.appendThreeBytes(m << 6 | k);
        }
      }
    }
  }
  
  protected int _decodeCharForError(int paramInt)
    throws IOException, JsonParseException
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      if ((paramInt & 0xE0) != 192) {
        break label145;
      }
      i = paramInt & 0x1F;
      paramInt = 1;
    }
    for (;;)
    {
      int j = nextByte();
      if ((j & 0xC0) != 128) {
        _reportInvalidOther(j & 0xFF);
      }
      j = i << 6 | j & 0x3F;
      i = j;
      if (paramInt > 1)
      {
        i = nextByte();
        if ((i & 0xC0) != 128) {
          _reportInvalidOther(i & 0xFF);
        }
        j = j << 6 | i & 0x3F;
        i = j;
        if (paramInt > 2)
        {
          paramInt = nextByte();
          if ((paramInt & 0xC0) != 128) {
            _reportInvalidOther(paramInt & 0xFF);
          }
          i = j << 6 | paramInt & 0x3F;
        }
      }
      return i;
      label145:
      if ((paramInt & 0xF0) == 224)
      {
        i = paramInt & 0xF;
        paramInt = 2;
      }
      else if ((paramInt & 0xF8) == 240)
      {
        i = paramInt & 0x7;
        paramInt = 3;
      }
      else
      {
        _reportInvalidInitial(paramInt & 0xFF);
        j = 1;
        i = paramInt;
        paramInt = j;
      }
    }
  }
  
  protected final char _decodeEscaped()
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    byte[] arrayOfByte = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    j = arrayOfByte[j];
    int i;
    switch (j)
    {
    default: 
      j = _handleUnrecognizedCharacterEscape((char)_decodeCharForError(j));
      i = j;
    }
    for (;;)
    {
      return i;
      j = 8;
      i = j;
      continue;
      j = 9;
      i = j;
      continue;
      j = 10;
      i = j;
      continue;
      j = 12;
      i = j;
      continue;
      j = 13;
      i = j;
      continue;
      j = (char)j;
      i = j;
      continue;
      j = 0;
      for (int k = 0; k < 4; k++)
      {
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in character escape sequence");
        }
        arrayOfByte = this._inputBuffer;
        int m = this._inputPtr;
        this._inputPtr = (m + 1);
        int n = arrayOfByte[m];
        m = CharTypes.charToHex(n);
        if (m < 0) {
          _reportUnexpectedChar(n, "expected a hex-digit for character escape sequence");
        }
        j = j << 4 | m;
      }
      j = (char)j;
      i = j;
    }
  }
  
  protected void _finishString()
    throws IOException, JsonParseException
  {
    int j = this._inputPtr;
    int i = j;
    if (j >= this._inputEnd)
    {
      loadMoreGuaranteed();
      i = this._inputPtr;
    }
    char[] arrayOfChar = this._textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = sInputCodesUtf8;
    int m = Math.min(this._inputEnd, arrayOfChar.length + i);
    byte[] arrayOfByte = this._inputBuffer;
    int k = 0;
    j = i;
    i = k;
    if (j < m)
    {
      k = arrayOfByte[j] & 0xFF;
      if (arrayOfInt[k] != 0)
      {
        if (k != 34) {
          break label124;
        }
        this._inputPtr = (j + 1);
        this._textBuffer.setCurrentLength(i);
      }
    }
    for (;;)
    {
      return;
      j++;
      arrayOfChar[i] = ((char)(char)k);
      i++;
      break;
      label124:
      this._inputPtr = j;
      _finishString2(arrayOfChar, i);
    }
  }
  
  protected final String _getText2(JsonToken paramJsonToken)
  {
    if (paramJsonToken == null) {
      paramJsonToken = null;
    }
    for (;;)
    {
      return paramJsonToken;
      switch (paramJsonToken)
      {
      default: 
        paramJsonToken = paramJsonToken.asString();
        break;
      case ???: 
        paramJsonToken = this._parsingContext.getCurrentName();
        break;
      case ???: 
      case ???: 
      case ???: 
        paramJsonToken = this._textBuffer.contentsAsString();
      }
    }
  }
  
  protected JsonToken _handleApostropheValue()
    throws IOException, JsonParseException
  {
    int i = 0;
    Object localObject2 = this._textBuffer.emptyAndGetCurrentSegment();
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    if (this._inputPtr >= this._inputEnd) {
      loadMoreGuaranteed();
    }
    Object localObject1 = localObject2;
    int k = i;
    if (i >= localObject2.length)
    {
      localObject1 = this._textBuffer.finishCurrentSegment();
      k = 0;
    }
    i = this._inputEnd;
    int n = this._inputPtr + (localObject1.length - k);
    int m = i;
    int j = k;
    if (n < i) {
      m = n;
    }
    for (j = k;; j++)
    {
      localObject2 = localObject1;
      i = j;
      if (this._inputPtr >= m) {
        break;
      }
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      n = arrayOfByte[i] & 0xFF;
      if ((n == 39) || (arrayOfInt[n] != 0))
      {
        if (n != 39) {
          break label180;
        }
        this._textBuffer.setCurrentLength(j);
        return JsonToken.VALUE_STRING;
      }
      localObject1[j] = ((char)(char)n);
    }
    label180:
    switch (arrayOfInt[n])
    {
    default: 
      if (n < 32) {
        _throwUnquotedSpace(n, "string value");
      }
      _reportInvalidChar(n);
      k = j;
      localObject2 = localObject1;
      i = n;
    case 1: 
    case 2: 
    case 3: 
      for (;;)
      {
        localObject1 = localObject2;
        j = k;
        if (k >= localObject2.length)
        {
          localObject1 = this._textBuffer.finishCurrentSegment();
          j = 0;
        }
        localObject1[j] = ((char)(char)i);
        i = j + 1;
        localObject2 = localObject1;
        break;
        i = n;
        localObject2 = localObject1;
        k = j;
        if (n != 34)
        {
          i = _decodeEscaped();
          localObject2 = localObject1;
          k = j;
          continue;
          i = _decodeUtf8_2(n);
          localObject2 = localObject1;
          k = j;
          continue;
          if (this._inputEnd - this._inputPtr >= 2)
          {
            i = _decodeUtf8_3fast(n);
            localObject2 = localObject1;
            k = j;
          }
          else
          {
            i = _decodeUtf8_3(n);
            localObject2 = localObject1;
            k = j;
          }
        }
      }
    }
    i = _decodeUtf8_4(n);
    k = j + 1;
    localObject1[j] = ((char)(char)(0xD800 | i >> 10));
    if (k >= localObject1.length)
    {
      localObject1 = this._textBuffer.finishCurrentSegment();
      k = 0;
    }
    for (;;)
    {
      i = 0xDC00 | i & 0x3FF;
      localObject2 = localObject1;
      break;
    }
  }
  
  protected JsonToken _handleInvalidNumberStart(int paramInt, boolean paramBoolean)
    throws IOException, JsonParseException
  {
    double d = Double.NEGATIVE_INFINITY;
    int i = paramInt;
    Object localObject;
    if (paramInt == 73)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOFInValue();
      }
      localObject = this._inputBuffer;
      paramInt = this._inputPtr;
      this._inputPtr = (paramInt + 1);
      paramInt = localObject[paramInt];
      if (paramInt != 78) {
        break label176;
      }
      if (paramBoolean)
      {
        localObject = "-INF";
        i = paramInt;
        if (!_matchToken((String)localObject, 3)) {
          break label161;
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
          break label127;
        }
        if (!paramBoolean) {
          break label120;
        }
      }
      for (;;)
      {
        localObject = resetAsNaN((String)localObject, d);
        return (JsonToken)localObject;
        localObject = "+INF";
        break;
        label120:
        d = Double.POSITIVE_INFINITY;
      }
      label127:
      _reportError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
      i = paramInt;
    }
    for (;;)
    {
      label161:
      reportUnexpectedNumberChar(i, "expected digit (0-9) to follow minus sign, for valid numeric value");
      localObject = null;
      break;
      label176:
      i = paramInt;
      if (paramInt == 110)
      {
        if (paramBoolean)
        {
          localObject = "-Infinity";
          label194:
          i = paramInt;
          if (!_matchToken((String)localObject, 3)) {
            continue;
          }
          if (!isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
            break label248;
          }
          if (!paramBoolean) {
            break label241;
          }
        }
        for (;;)
        {
          localObject = resetAsNaN((String)localObject, d);
          break;
          localObject = "+Infinity";
          break label194;
          label241:
          d = Double.POSITIVE_INFINITY;
        }
        label248:
        _reportError("Non-standard token '" + (String)localObject + "': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        i = paramInt;
      }
    }
  }
  
  protected JsonToken _handleUnexpectedValue(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject;
    switch (paramInt)
    {
    default: 
      _reportUnexpectedChar(paramInt, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
      localObject = null;
    }
    for (;;)
    {
      return (JsonToken)localObject;
      if (!isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
        break;
      }
      localObject = _handleApostropheValue();
      continue;
      if (_matchToken("NaN", 1))
      {
        if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
          localObject = resetAsNaN("NaN", NaN.0D);
        } else {
          _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
        }
      }
      else
      {
        localObject = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = (i + 1);
        _reportUnexpectedChar(localObject[i] & 0xFF, "expected 'NaN' or a valid value");
        break;
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOFInValue();
        }
        localObject = this._inputBuffer;
        paramInt = this._inputPtr;
        this._inputPtr = (paramInt + 1);
        localObject = _handleInvalidNumberStart(localObject[paramInt] & 0xFF, false);
      }
    }
  }
  
  protected final Name _handleUnusualFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject1;
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)))
    {
      localObject1 = _parseApostropheFieldName();
      return (Name)localObject1;
    }
    if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
      _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
    }
    Object localObject3 = CharTypes.getInputCodeUtf8JsNames();
    if (localObject3[paramInt] != 0) {
      _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
    }
    Object localObject2 = this._quadBuffer;
    int j = 0;
    int k = 0;
    int m = 0;
    int i = paramInt;
    paramInt = m;
    for (;;)
    {
      if (k < 4)
      {
        k++;
        j = j << 8 | i;
        localObject1 = localObject2;
        i = k;
      }
      for (;;)
      {
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        m = this._inputBuffer[this._inputPtr] & 0xFF;
        if (localObject3[m] == 0) {
          break label286;
        }
        k = paramInt;
        localObject2 = localObject1;
        if (i > 0)
        {
          localObject2 = localObject1;
          if (paramInt >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            this._quadBuffer = ((int[])localObject2);
          }
          localObject2[paramInt] = j;
          k = paramInt + 1;
        }
        localObject3 = this._symbols.findName((int[])localObject2, k);
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        localObject1 = addName((int[])localObject2, k, i);
        break;
        localObject1 = localObject2;
        if (paramInt >= localObject2.length)
        {
          localObject1 = growArrayBy((int[])localObject2, localObject2.length);
          this._quadBuffer = ((int[])localObject1);
        }
        k = paramInt + 1;
        localObject1[paramInt] = j;
        paramInt = 1;
        j = i;
        i = paramInt;
        paramInt = k;
      }
      label286:
      this._inputPtr += 1;
      k = i;
      localObject2 = localObject1;
      i = m;
    }
  }
  
  protected void _matchToken(JsonToken paramJsonToken)
    throws IOException, JsonParseException
  {
    byte[] arrayOfByte = paramJsonToken.asByteArray();
    int i = 1;
    int j = arrayOfByte.length;
    while (i < j)
    {
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      if (arrayOfByte[i] != this._inputBuffer[this._inputPtr]) {
        _reportInvalidToken(paramJsonToken.asString().substring(0, i), "'null', 'true' or 'false'");
      }
      this._inputPtr += 1;
      i++;
    }
  }
  
  protected final boolean _matchToken(String paramString, int paramInt)
    throws IOException, JsonParseException
  {
    int j = paramString.length();
    int i;
    do
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in a value");
      }
      if (this._inputBuffer[this._inputPtr] != paramString.charAt(paramInt)) {
        _reportInvalidToken(paramString.substring(0, paramInt), "'null', 'true', 'false' or NaN");
      }
      this._inputPtr += 1;
      i = paramInt + 1;
      paramInt = i;
    } while (i < j);
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
    for (;;)
    {
      return true;
      if (Character.isJavaIdentifierPart((char)_decodeCharForError(this._inputBuffer[this._inputPtr] & 0xFF)))
      {
        this._inputPtr += 1;
        _reportInvalidToken(paramString.substring(0, i), "'null', 'true', 'false' or NaN");
      }
    }
  }
  
  protected final Name _parseApostropheFieldName()
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing ''' for name");
    }
    Object localObject1 = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    int n = localObject1[i] & 0xFF;
    if (n == 39) {
      localObject1 = BytesToNameCanonicalizer.getEmptyName();
    }
    int j;
    Object localObject3;
    for (;;)
    {
      return (Name)localObject1;
      localObject1 = this._quadBuffer;
      k = 0;
      j = 0;
      localObject3 = sInputCodesLatin1;
      i = 0;
      if (n != 39) {
        break;
      }
      if (j <= 0) {
        break label619;
      }
      localObject2 = localObject1;
      if (i >= localObject1.length)
      {
        localObject2 = growArrayBy((int[])localObject1, localObject1.length);
        this._quadBuffer = ((int[])localObject2);
      }
      m = i + 1;
      localObject2[i] = k;
      i = m;
      localObject3 = this._symbols.findName((int[])localObject2, i);
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = addName((int[])localObject2, i, j);
      }
    }
    int m = n;
    int i2 = k;
    int i3 = j;
    int i1 = i;
    Object localObject2 = localObject1;
    if (n != 34)
    {
      m = n;
      i2 = k;
      i3 = j;
      i1 = i;
      localObject2 = localObject1;
      if (localObject3[n] != 0)
      {
        if (n == 92) {
          break label458;
        }
        _throwUnquotedSpace(n, "name");
      }
    }
    for (;;)
    {
      m = n;
      i2 = k;
      i3 = j;
      i1 = i;
      localObject2 = localObject1;
      if (n > 127)
      {
        i2 = k;
        i1 = j;
        m = i;
        localObject2 = localObject1;
        if (j >= 4)
        {
          localObject2 = localObject1;
          if (i >= localObject1.length)
          {
            localObject2 = growArrayBy((int[])localObject1, localObject1.length);
            this._quadBuffer = ((int[])localObject2);
          }
          localObject2[i] = k;
          i2 = 0;
          i1 = 0;
          m = i + 1;
        }
        if (n >= 2048) {
          break label467;
        }
        i = i2 << 8 | n >> 6 | 0xC0;
        k = i1 + 1;
        j = m;
        label352:
        m = n & 0x3F | 0x80;
        i1 = j;
        i3 = k;
        i2 = i;
      }
      if (i3 >= 4) {
        break label571;
      }
      j = i3 + 1;
      k = i2 << 8 | m;
      i = i1;
      localObject1 = localObject2;
      label399:
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in field name");
      }
      localObject2 = this._inputBuffer;
      m = this._inputPtr;
      this._inputPtr = (m + 1);
      n = localObject2[m] & 0xFF;
      break;
      label458:
      n = _decodeEscaped();
    }
    label467:
    int k = i2 << 8 | n >> 12 | 0xE0;
    i = i1 + 1;
    if (i >= 4)
    {
      localObject1 = localObject2;
      if (m >= localObject2.length)
      {
        localObject1 = growArrayBy((int[])localObject2, localObject2.length);
        this._quadBuffer = ((int[])localObject1);
      }
      j = m + 1;
      localObject1[m] = k;
      k = 0;
      i = 0;
    }
    for (;;)
    {
      k = k << 8 | n >> 6 & 0x3F | 0x80;
      m = i + 1;
      i = k;
      k = m;
      localObject2 = localObject1;
      break label352;
      label571:
      localObject1 = localObject2;
      if (i1 >= localObject2.length)
      {
        localObject1 = growArrayBy((int[])localObject2, localObject2.length);
        this._quadBuffer = ((int[])localObject1);
      }
      i = i1 + 1;
      localObject1[i1] = i2;
      k = m;
      j = 1;
      break label399;
      label619:
      localObject2 = localObject1;
      break;
      j = m;
      localObject1 = localObject2;
    }
  }
  
  protected final Name _parseFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject;
    if (paramInt != 34) {
      localObject = _handleUnusualFieldName(paramInt);
    }
    for (;;)
    {
      return (Name)localObject;
      if (this._inputPtr + 9 > this._inputEnd)
      {
        localObject = slowParseFieldName();
      }
      else
      {
        localObject = this._inputBuffer;
        int[] arrayOfInt = sInputCodesLatin1;
        paramInt = this._inputPtr;
        this._inputPtr = (paramInt + 1);
        paramInt = localObject[paramInt] & 0xFF;
        if (arrayOfInt[paramInt] == 0)
        {
          int i = this._inputPtr;
          this._inputPtr = (i + 1);
          i = localObject[i] & 0xFF;
          if (arrayOfInt[i] == 0)
          {
            paramInt = paramInt << 8 | i;
            i = this._inputPtr;
            this._inputPtr = (i + 1);
            i = localObject[i] & 0xFF;
            if (arrayOfInt[i] == 0)
            {
              paramInt = paramInt << 8 | i;
              i = this._inputPtr;
              this._inputPtr = (i + 1);
              i = localObject[i] & 0xFF;
              if (arrayOfInt[i] == 0)
              {
                paramInt = paramInt << 8 | i;
                i = this._inputPtr;
                this._inputPtr = (i + 1);
                i = localObject[i] & 0xFF;
                if (arrayOfInt[i] == 0)
                {
                  this._quad1 = paramInt;
                  localObject = parseMediumFieldName(i, arrayOfInt);
                }
                else if (i == 34)
                {
                  localObject = findName(paramInt, 4);
                }
                else
                {
                  localObject = parseFieldName(paramInt, i, 4);
                }
              }
              else if (i == 34)
              {
                localObject = findName(paramInt, 3);
              }
              else
              {
                localObject = parseFieldName(paramInt, i, 3);
              }
            }
            else if (i == 34)
            {
              localObject = findName(paramInt, 2);
            }
            else
            {
              localObject = parseFieldName(paramInt, i, 2);
            }
          }
          else if (i == 34)
          {
            localObject = findName(paramInt, 1);
          }
          else
          {
            localObject = parseFieldName(paramInt, i, 1);
          }
        }
        else if (paramInt == 34)
        {
          localObject = BytesToNameCanonicalizer.getEmptyName();
        }
        else
        {
          localObject = parseFieldName(0, paramInt, 0);
        }
      }
    }
  }
  
  protected void _reportInvalidChar(int paramInt)
    throws JsonParseException
  {
    if (paramInt < 32) {
      _throwInvalidSpace(paramInt);
    }
    _reportInvalidInitial(paramInt);
  }
  
  protected void _reportInvalidInitial(int paramInt)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 start byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt)
    throws JsonParseException
  {
    _reportError("Invalid UTF-8 middle byte 0x" + Integer.toHexString(paramInt));
  }
  
  protected void _reportInvalidOther(int paramInt1, int paramInt2)
    throws JsonParseException
  {
    this._inputPtr = paramInt2;
    _reportInvalidOther(paramInt1);
  }
  
  protected void _reportInvalidToken(String paramString1, String paramString2)
    throws IOException, JsonParseException
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString1);
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
      char c;
      do
      {
        _reportError("Unrecognized token '" + localStringBuilder.toString() + "': was expecting " + paramString2);
        return;
        paramString1 = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = (i + 1);
        c = (char)_decodeCharForError(paramString1[i]);
      } while (!Character.isJavaIdentifierPart(c));
      this._inputPtr += 1;
      localStringBuilder.append(c);
    }
  }
  
  protected final void _skipCR()
    throws IOException
  {
    if (((this._inputPtr < this._inputEnd) || (loadMore())) && (this._inputBuffer[this._inputPtr] == 10)) {
      this._inputPtr += 1;
    }
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected final void _skipLF()
    throws IOException
  {
    this._currInputRow += 1;
    this._currInputRowStart = this._inputPtr;
  }
  
  protected void _skipString()
    throws IOException, JsonParseException
  {
    this._tokenIncomplete = false;
    int[] arrayOfInt = sInputCodesUtf8;
    byte[] arrayOfByte = this._inputBuffer;
    int k = this._inputPtr;
    int m = this._inputEnd;
    int j = m;
    int i = k;
    if (k >= m)
    {
      loadMoreGuaranteed();
      i = this._inputPtr;
      j = this._inputEnd;
    }
    label198:
    for (;;)
    {
      if (i < j)
      {
        k = i + 1;
        m = arrayOfByte[i] & 0xFF;
        i = k;
        if (arrayOfInt[m] == 0) {
          break label198;
        }
        this._inputPtr = k;
        if (m != 34) {}
      }
      else
      {
        this._inputPtr = i;
        break;
      }
      switch (arrayOfInt[m])
      {
      default: 
        if (m < 32) {
          _throwUnquotedSpace(m, "string value");
        }
        break;
      case 1: 
        _decodeEscaped();
        break;
      case 2: 
        _skipUtf8_2(m);
        break;
      case 3: 
        _skipUtf8_3(m);
        break;
      case 4: 
        _skipUtf8_4(m);
        break;
        _reportInvalidChar(m);
        break;
      }
    }
  }
  
  public void close()
    throws IOException
  {
    super.close();
    this._symbols.release();
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    if ((this._currToken != JsonToken.VALUE_STRING) && ((this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT) || (this._binaryValue == null))) {
      _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
    }
    if (this._tokenIncomplete) {}
    try
    {
      this._binaryValue = _decodeBase64(paramBase64Variant);
      this._tokenIncomplete = false;
      return this._binaryValue;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw _constructError("Failed to decode VALUE_STRING as base64 (" + paramBase64Variant + "): " + localIllegalArgumentException.getMessage());
    }
  }
  
  public ObjectCodec getCodec()
  {
    return this._objectCodec;
  }
  
  public String getText()
    throws IOException, JsonParseException
  {
    Object localObject = this._currToken;
    if (localObject == JsonToken.VALUE_STRING) {
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
    }
    for (localObject = this._textBuffer.contentsAsString();; localObject = _getText2((JsonToken)localObject)) {
      return (String)localObject;
    }
  }
  
  public char[] getTextCharacters()
    throws IOException, JsonParseException
  {
    Object localObject;
    if (this._currToken != null) {
      switch (this._currToken)
      {
      default: 
        localObject = this._currToken.asCharArray();
      }
    }
    for (;;)
    {
      return (char[])localObject;
      int i;
      if (!this._nameCopied)
      {
        localObject = this._parsingContext.getCurrentName();
        i = ((String)localObject).length();
        if (this._nameCopyBuffer != null) {
          break label121;
        }
        this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(i);
      }
      for (;;)
      {
        ((String)localObject).getChars(0, i, this._nameCopyBuffer, 0);
        this._nameCopied = true;
        localObject = this._nameCopyBuffer;
        break;
        label121:
        if (this._nameCopyBuffer.length < i) {
          this._nameCopyBuffer = new char[i];
        }
      }
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
      localObject = this._textBuffer.getTextBuffer();
      continue;
      localObject = null;
    }
  }
  
  public int getTextLength()
    throws IOException, JsonParseException
  {
    int i = 0;
    if (this._currToken != null) {
      switch (this._currToken)
      {
      default: 
        i = this._currToken.asCharArray().length;
      }
    }
    for (;;)
    {
      return i;
      i = this._parsingContext.getCurrentName().length();
      continue;
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
      i = this._textBuffer.size();
    }
  }
  
  public int getTextOffset()
    throws IOException, JsonParseException
  {
    int j = 0;
    int i = j;
    if (this._currToken != null)
    {
      i = j;
      switch (this._currToken)
      {
      }
    }
    for (i = j;; i = this._textBuffer.getTextOffset())
    {
      return i;
      if (this._tokenIncomplete)
      {
        this._tokenIncomplete = false;
        _finishString();
      }
    }
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    Object localObject = null;
    if (this._currToken == JsonToken.FIELD_NAME) {
      localObject = _nextAfterName();
    }
    int i;
    for (;;)
    {
      return (JsonToken)localObject;
      if (this._tokenIncomplete) {
        _skipString();
      }
      int j = _skipWSOrEnd();
      if (j < 0)
      {
        close();
        this._currToken = null;
      }
      else
      {
        this._tokenInputTotal = (this._currInputProcessed + this._inputPtr - 1L);
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (this._inputPtr - this._currInputRowStart - 1);
        this._binaryValue = null;
        if (j == 93)
        {
          if (!this._parsingContext.inArray()) {
            _reportMismatchedEndMarker(j, '}');
          }
          this._parsingContext = this._parsingContext.getParent();
          localObject = JsonToken.END_ARRAY;
          this._currToken = ((JsonToken)localObject);
        }
        else if (j == 125)
        {
          if (!this._parsingContext.inObject()) {
            _reportMismatchedEndMarker(j, ']');
          }
          this._parsingContext = this._parsingContext.getParent();
          localObject = JsonToken.END_OBJECT;
          this._currToken = ((JsonToken)localObject);
        }
        else
        {
          i = j;
          if (this._parsingContext.expectComma())
          {
            if (j != 44) {
              _reportUnexpectedChar(j, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
            }
            i = _skipWS();
          }
          if (!this._parsingContext.inObject())
          {
            localObject = _nextTokenNotInObject(i);
          }
          else
          {
            localObject = _parseFieldName(i);
            this._parsingContext.setCurrentName(((Name)localObject).getName());
            this._currToken = JsonToken.FIELD_NAME;
            i = _skipWS();
            if (i != 58) {
              _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
            }
            i = _skipWS();
            if (i != 34) {
              break;
            }
            this._tokenIncomplete = true;
            this._nextToken = JsonToken.VALUE_STRING;
            localObject = this._currToken;
          }
        }
      }
    }
    switch (i)
    {
    default: 
      localObject = _handleUnexpectedValue(i);
    }
    for (;;)
    {
      this._nextToken = ((JsonToken)localObject);
      localObject = this._currToken;
      break;
      localObject = JsonToken.START_ARRAY;
      continue;
      localObject = JsonToken.START_OBJECT;
      continue;
      _reportUnexpectedChar(i, "expected a value");
      _matchToken(JsonToken.VALUE_TRUE);
      localObject = JsonToken.VALUE_TRUE;
      continue;
      _matchToken(JsonToken.VALUE_FALSE);
      localObject = JsonToken.VALUE_FALSE;
      continue;
      _matchToken(JsonToken.VALUE_NULL);
      localObject = JsonToken.VALUE_NULL;
      continue;
      localObject = parseNumberText(i);
    }
  }
  
  protected Name parseEscapedFieldName(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IOException, JsonParseException
  {
    Object localObject2 = sInputCodesLatin1;
    int i = paramInt3;
    Object localObject1;
    if (localObject2[paramInt3] != 0)
    {
      if (paramInt3 == 34)
      {
        localObject1 = paramArrayOfInt;
        paramInt3 = paramInt1;
        if (paramInt4 > 0)
        {
          localObject1 = paramArrayOfInt;
          if (paramInt1 >= paramArrayOfInt.length)
          {
            localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
            this._quadBuffer = ((int[])localObject1);
          }
          localObject1[paramInt1] = paramInt2;
          paramInt3 = paramInt1 + 1;
        }
        localObject2 = this._symbols.findName((int[])localObject1, paramInt3);
        paramArrayOfInt = (int[])localObject2;
        if (localObject2 == null) {
          paramArrayOfInt = addName((int[])localObject1, paramInt3, paramInt4);
        }
        return paramArrayOfInt;
      }
      if (paramInt3 != 92)
      {
        _throwUnquotedSpace(paramInt3, "name");
        label118:
        i = paramInt3;
        if (paramInt3 <= 127) {
          break label490;
        }
        if (paramInt4 < 4) {
          break label487;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        i = paramInt1 + 1;
        localObject1[paramInt1] = paramInt2;
        paramInt2 = 0;
        paramInt4 = 0;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = i;
        label179:
        if (paramInt3 >= 2048) {
          break label325;
        }
        i = paramInt2 << 8 | paramInt3 >> 6 | 0xC0;
        paramInt2 = paramInt4 + 1;
        paramInt4 = paramInt1;
        paramInt1 = i;
        paramInt3 = paramInt3 & 0x3F | 0x80;
        i = paramInt2;
        paramInt2 = paramInt3;
        paramInt3 = paramInt1;
        paramInt1 = paramInt4;
      }
    }
    for (;;)
    {
      if (i < 4)
      {
        paramInt4 = i + 1;
        paramInt2 = paramInt3 << 8 | paramInt2;
        label257:
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in field name");
        }
        localObject1 = this._inputBuffer;
        paramInt3 = this._inputPtr;
        this._inputPtr = (paramInt3 + 1);
        paramInt3 = localObject1[paramInt3] & 0xFF;
        break;
        paramInt3 = _decodeEscaped();
        break label118;
        label325:
        paramInt2 = paramInt2 << 8 | paramInt3 >> 12 | 0xE0;
        i = paramInt4 + 1;
        if (i < 4) {
          break label478;
        }
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        i = paramInt1 + 1;
        localObject1[paramInt1] = paramInt2;
        paramInt4 = 0;
        paramInt2 = 0;
        paramInt1 = i;
        paramArrayOfInt = (int[])localObject1;
      }
      for (;;)
      {
        i = paramInt4 << 8 | paramInt3 >> 6 & 0x3F | 0x80;
        paramInt2++;
        paramInt4 = paramInt1;
        paramInt1 = i;
        break;
        localObject1 = paramArrayOfInt;
        if (paramInt1 >= paramArrayOfInt.length)
        {
          localObject1 = growArrayBy(paramArrayOfInt, paramArrayOfInt.length);
          this._quadBuffer = ((int[])localObject1);
        }
        paramInt4 = paramInt1 + 1;
        localObject1[paramInt1] = paramInt3;
        paramInt3 = 1;
        paramArrayOfInt = (int[])localObject1;
        paramInt1 = paramInt4;
        paramInt4 = paramInt3;
        break label257;
        label478:
        paramInt4 = paramInt2;
        paramInt2 = i;
      }
      label487:
      break label179;
      label490:
      paramInt3 = paramInt2;
      paramInt2 = i;
      i = paramInt4;
    }
  }
  
  protected Name parseLongFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject = sInputCodesLatin1;
    int j = 2;
    int i = paramInt;
    for (paramInt = j;; paramInt++)
    {
      if (this._inputEnd - this._inputPtr < 4) {
        localObject = parseEscapedFieldName(this._quadBuffer, paramInt, 0, i, 0);
      }
      for (;;)
      {
        return (Name)localObject;
        byte[] arrayOfByte = this._inputBuffer;
        j = this._inputPtr;
        this._inputPtr = (j + 1);
        j = arrayOfByte[j] & 0xFF;
        if (localObject[j] != 0)
        {
          if (j == 34) {
            localObject = findName(this._quadBuffer, paramInt, i, 1);
          } else {
            localObject = parseEscapedFieldName(this._quadBuffer, paramInt, i, j, 1);
          }
        }
        else
        {
          i = i << 8 | j;
          arrayOfByte = this._inputBuffer;
          j = this._inputPtr;
          this._inputPtr = (j + 1);
          j = arrayOfByte[j] & 0xFF;
          if (localObject[j] != 0)
          {
            if (j == 34) {
              localObject = findName(this._quadBuffer, paramInt, i, 2);
            } else {
              localObject = parseEscapedFieldName(this._quadBuffer, paramInt, i, j, 2);
            }
          }
          else
          {
            i = i << 8 | j;
            arrayOfByte = this._inputBuffer;
            j = this._inputPtr;
            this._inputPtr = (j + 1);
            j = arrayOfByte[j] & 0xFF;
            if (localObject[j] != 0)
            {
              if (j == 34) {
                localObject = findName(this._quadBuffer, paramInt, i, 3);
              } else {
                localObject = parseEscapedFieldName(this._quadBuffer, paramInt, i, j, 3);
              }
            }
            else
            {
              j = i << 8 | j;
              arrayOfByte = this._inputBuffer;
              i = this._inputPtr;
              this._inputPtr = (i + 1);
              i = arrayOfByte[i] & 0xFF;
              if (localObject[i] == 0) {
                break;
              }
              if (i == 34) {
                localObject = findName(this._quadBuffer, paramInt, j, 4);
              } else {
                localObject = parseEscapedFieldName(this._quadBuffer, paramInt, j, i, 4);
              }
            }
          }
        }
      }
      if (paramInt >= this._quadBuffer.length) {
        this._quadBuffer = growArrayBy(this._quadBuffer, paramInt);
      }
      this._quadBuffer[paramInt] = j;
    }
  }
  
  protected final Name parseMediumFieldName(int paramInt, int[] paramArrayOfInt)
    throws IOException, JsonParseException
  {
    byte[] arrayOfByte = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfByte[i] & 0xFF;
    if (paramArrayOfInt[i] != 0) {
      if (i == 34) {
        paramArrayOfInt = findName(this._quad1, paramInt, 1);
      }
    }
    for (;;)
    {
      return paramArrayOfInt;
      paramArrayOfInt = parseFieldName(this._quad1, paramInt, i, 1);
      continue;
      paramInt = paramInt << 8 | i;
      arrayOfByte = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfByte[i] & 0xFF;
      if (paramArrayOfInt[i] != 0)
      {
        if (i == 34) {
          paramArrayOfInt = findName(this._quad1, paramInt, 2);
        } else {
          paramArrayOfInt = parseFieldName(this._quad1, paramInt, i, 2);
        }
      }
      else
      {
        paramInt = paramInt << 8 | i;
        arrayOfByte = this._inputBuffer;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfByte[i] & 0xFF;
        if (paramArrayOfInt[i] != 0)
        {
          if (i == 34) {
            paramArrayOfInt = findName(this._quad1, paramInt, 3);
          } else {
            paramArrayOfInt = parseFieldName(this._quad1, paramInt, i, 3);
          }
        }
        else
        {
          paramInt = paramInt << 8 | i;
          arrayOfByte = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          i = arrayOfByte[i] & 0xFF;
          if (paramArrayOfInt[i] != 0)
          {
            if (i == 34) {
              paramArrayOfInt = findName(this._quad1, paramInt, 4);
            } else {
              paramArrayOfInt = parseFieldName(this._quad1, paramInt, i, 4);
            }
          }
          else
          {
            this._quadBuffer[0] = this._quad1;
            this._quadBuffer[1] = paramInt;
            paramArrayOfInt = parseLongFieldName(i);
          }
        }
      }
    }
  }
  
  protected final JsonToken parseNumberText(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject = this._textBuffer.emptyAndGetCurrentSegment();
    boolean bool;
    int i;
    byte[] arrayOfByte;
    int j;
    if (paramInt == 45)
    {
      bool = true;
      if (!bool) {
        break label107;
      }
      i = 0 + 1;
      localObject[0] = ((char)45);
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      arrayOfByte = this._inputBuffer;
      paramInt = this._inputPtr;
      this._inputPtr = (paramInt + 1);
      j = arrayOfByte[paramInt] & 0xFF;
      if (j >= 48)
      {
        paramInt = j;
        if (j <= 57) {
          break label109;
        }
      }
      localObject = _handleInvalidNumberStart(j, true);
    }
    for (;;)
    {
      return (JsonToken)localObject;
      bool = false;
      break;
      label107:
      i = 0;
      label109:
      j = paramInt;
      if (paramInt == 48) {
        j = _verifyNoLeadingZeroes();
      }
      int k = i + 1;
      localObject[i] = ((char)(char)j);
      int m = 1;
      int n = this._inputPtr + localObject.length;
      i = k;
      j = m;
      paramInt = n;
      if (n > this._inputEnd)
      {
        paramInt = this._inputEnd;
        j = m;
      }
      for (i = k;; i++)
      {
        if (this._inputPtr >= paramInt)
        {
          localObject = _parserNumber2((char[])localObject, i, bool, j);
          break;
        }
        arrayOfByte = this._inputBuffer;
        k = this._inputPtr;
        this._inputPtr = (k + 1);
        k = arrayOfByte[k] & 0xFF;
        if ((k < 48) || (k > 57))
        {
          if ((k != 46) && (k != 101) && (k != 69)) {
            break label299;
          }
          localObject = _parseFloatText((char[])localObject, i, k, bool, j);
          break;
        }
        j++;
        localObject[i] = ((char)(char)k);
      }
      label299:
      this._inputPtr -= 1;
      this._textBuffer.setCurrentLength(i);
      localObject = resetInt(bool, j);
    }
  }
  
  protected IllegalArgumentException reportInvalidChar(Base64Variant paramBase64Variant, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    return reportInvalidChar(paramBase64Variant, paramInt1, paramInt2, null);
  }
  
  protected IllegalArgumentException reportInvalidChar(Base64Variant paramBase64Variant, int paramInt1, int paramInt2, String paramString)
    throws IllegalArgumentException
  {
    if (paramInt1 <= 32) {
      paramBase64Variant = "Illegal white space character (code 0x" + Integer.toHexString(paramInt1) + ") as character #" + (paramInt2 + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramBase64Variant;
      if (paramString != null) {
        localObject = paramBase64Variant + ": " + paramString;
      }
      return new IllegalArgumentException((String)localObject);
      if (paramBase64Variant.usesPaddingChar(paramInt1)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt2 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramInt1)) || (Character.isISOControl(paramInt1))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + (char)paramInt1 + "' (code 0x" + Integer.toHexString(paramInt1) + ") in base64 content";
      }
    }
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
  }
  
  protected Name slowParseFieldName()
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing '\"' for name");
    }
    Object localObject = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = localObject[i] & 0xFF;
    if (i == 34) {}
    for (localObject = BytesToNameCanonicalizer.getEmptyName();; localObject = parseEscapedFieldName(this._quadBuffer, 0, 0, i, 0)) {
      return (Name)localObject;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\Utf8StreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */