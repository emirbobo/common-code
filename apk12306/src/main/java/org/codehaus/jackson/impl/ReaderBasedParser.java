package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.Reader;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.sym.CharsToNameCanonicalizer;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;
import org.codehaus.jackson.util.TextBuffer;

public final class ReaderBasedParser
  extends ReaderBasedNumericParser
{
  protected ObjectCodec _objectCodec;
  protected final CharsToNameCanonicalizer _symbols;
  protected boolean _tokenIncomplete = false;
  
  public ReaderBasedParser(IOContext paramIOContext, int paramInt, Reader paramReader, ObjectCodec paramObjectCodec, CharsToNameCanonicalizer paramCharsToNameCanonicalizer)
  {
    super(paramIOContext, paramInt, paramReader);
    this._objectCodec = paramObjectCodec;
    this._symbols = paramCharsToNameCanonicalizer;
  }
  
  private final int _decodeBase64Escape(Base64Variant paramBase64Variant, char paramChar, int paramInt)
    throws IOException, JsonParseException
  {
    if (paramChar != '\\') {
      throw reportInvalidChar(paramBase64Variant, paramChar, paramInt);
    }
    paramChar = _decodeEscaped();
    int i;
    if ((paramChar <= ' ') && (paramInt == 0)) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      j = paramBase64Variant.decodeBase64Char(paramChar);
      i = j;
    } while (j >= 0);
    throw reportInvalidChar(paramBase64Variant, paramChar, paramInt);
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
  
  private String _parseFieldName2(int paramInt1, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    this._textBuffer.resetWithShared(this._inputBuffer, paramInt1, this._inputPtr - paramInt1);
    char[] arrayOfChar = this._textBuffer.getCurrentSegment();
    paramInt1 = this._textBuffer.getCurrentSegmentSize();
    int i = paramInt2;
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(": was expecting closing '" + (char)paramInt3 + "' for name");
      }
      Object localObject = this._inputBuffer;
      paramInt2 = this._inputPtr;
      this._inputPtr = (paramInt2 + 1);
      int j = localObject[paramInt2];
      paramInt2 = j;
      if (j <= 92)
      {
        if (j != 92) {
          break label174;
        }
        paramInt2 = _decodeEscaped();
      }
      for (;;)
      {
        i = i * 31 + j;
        j = paramInt1 + 1;
        arrayOfChar[paramInt1] = ((char)paramInt2);
        if (j < arrayOfChar.length) {
          break label260;
        }
        arrayOfChar = this._textBuffer.finishCurrentSegment();
        paramInt1 = 0;
        break;
        label174:
        paramInt2 = j;
        if (j <= paramInt3)
        {
          if (j == paramInt3)
          {
            this._textBuffer.setCurrentLength(paramInt1);
            localObject = this._textBuffer;
            arrayOfChar = ((TextBuffer)localObject).getTextBuffer();
            paramInt2 = ((TextBuffer)localObject).getTextOffset();
            paramInt1 = ((TextBuffer)localObject).size();
            return this._symbols.findSymbol(arrayOfChar, paramInt2, paramInt1, i);
          }
          paramInt2 = j;
          if (j < 32)
          {
            _throwUnquotedSpace(j, "name");
            paramInt2 = j;
          }
        }
      }
      label260:
      paramInt1 = j;
    }
  }
  
  private String _parseUnusualFieldName2(int paramInt1, int paramInt2, int[] paramArrayOfInt)
    throws IOException, JsonParseException
  {
    this._textBuffer.resetWithShared(this._inputBuffer, paramInt1, this._inputPtr - paramInt1);
    char[] arrayOfChar = this._textBuffer.getCurrentSegment();
    paramInt1 = this._textBuffer.getCurrentSegmentSize();
    int k = paramArrayOfInt.length;
    for (;;)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {}
      int j;
      for (;;)
      {
        this._textBuffer.setCurrentLength(paramInt1);
        paramArrayOfInt = this._textBuffer;
        arrayOfChar = paramArrayOfInt.getTextBuffer();
        j = paramArrayOfInt.getTextOffset();
        paramInt1 = paramArrayOfInt.size();
        return this._symbols.findSymbol(arrayOfChar, j, paramInt1, paramInt2);
        int i = this._inputBuffer[this._inputPtr];
        if (i <= k)
        {
          if (paramArrayOfInt[i] != 0) {}
        }
        else {
          while (Character.isJavaIdentifierPart(i))
          {
            this._inputPtr += 1;
            paramInt2 = paramInt2 * 31 + i;
            j = paramInt1 + 1;
            arrayOfChar[paramInt1] = i;
            if (j < arrayOfChar.length) {
              break label188;
            }
            arrayOfChar = this._textBuffer.finishCurrentSegment();
            paramInt1 = 0;
            break;
          }
        }
      }
      label188:
      paramInt1 = j;
    }
  }
  
  private final void _skipCComment()
    throws IOException, JsonParseException
  {
    for (;;)
    {
      int i;
      if ((this._inputPtr < this._inputEnd) || (loadMore()))
      {
        char[] arrayOfChar = this._inputBuffer;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfChar[i];
        if (i > 42) {
          continue;
        }
        if (i != 42) {
          break label103;
        }
        if ((this._inputPtr < this._inputEnd) || (loadMore())) {}
      }
      else
      {
        _reportInvalidEOF(" in a comment");
      }
      for (;;)
      {
        return;
        if (this._inputBuffer[this._inputPtr] != '/') {
          break;
        }
        this._inputPtr += 1;
      }
      label103:
      if (i < 32) {
        if (i == 10) {
          _skipLF();
        } else if (i == 13) {
          _skipCR();
        } else if (i != 9) {
          _throwInvalidSpace(i);
        }
      }
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
    char[] arrayOfChar = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    i = arrayOfChar[i];
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
    for (;;)
    {
      int i;
      if ((this._inputPtr < this._inputEnd) || (loadMore()))
      {
        char[] arrayOfChar = this._inputBuffer;
        i = this._inputPtr;
        this._inputPtr = (i + 1);
        i = arrayOfChar[i];
        if (i >= 32) {
          continue;
        }
        if (i != 10) {
          break label56;
        }
        _skipLF();
      }
      for (;;)
      {
        return;
        label56:
        if (i != 13) {
          break;
        }
        _skipCR();
      }
      if (i != 9) {
        _throwInvalidSpace(i);
      }
    }
  }
  
  private final int _skipWS()
    throws IOException, JsonParseException
  {
    while ((this._inputPtr < this._inputEnd) || (loadMore()))
    {
      char[] arrayOfChar = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfChar[i];
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
      char[] arrayOfChar = this._inputBuffer;
      i = this._inputPtr;
      this._inputPtr = (i + 1);
      i = arrayOfChar[i];
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
  
  protected byte[] _decodeBase64(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    ByteArrayBuilder localByteArrayBuilder = _getByteArrayBuilder();
    for (;;)
    {
      if (this._inputPtr >= this._inputEnd) {
        loadMoreGuaranteed();
      }
      char[] arrayOfChar = this._inputBuffer;
      int i = this._inputPtr;
      this._inputPtr = (i + 1);
      char c = arrayOfChar[i];
      if (c > ' ')
      {
        int j = paramBase64Variant.decodeBase64Char(c);
        i = j;
        if (j < 0)
        {
          if (c == '"') {
            return localByteArrayBuilder.toByteArray();
          }
          i = _decodeBase64Escape(paramBase64Variant, c, 0);
          if (i < 0) {}
        }
        else
        {
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = this._inputBuffer;
          j = this._inputPtr;
          this._inputPtr = (j + 1);
          c = arrayOfChar[j];
          int k = paramBase64Variant.decodeBase64Char(c);
          j = k;
          if (k < 0) {
            j = _decodeBase64Escape(paramBase64Variant, c, 1);
          }
          int m = i << 6 | j;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          c = arrayOfChar[i];
          k = paramBase64Variant.decodeBase64Char(c);
          j = k;
          if (k < 0)
          {
            i = k;
            if (k != -2) {
              i = _decodeBase64Escape(paramBase64Variant, c, 2);
            }
            j = i;
            if (i == -2)
            {
              if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
              }
              arrayOfChar = this._inputBuffer;
              i = this._inputPtr;
              this._inputPtr = (i + 1);
              c = arrayOfChar[i];
              if (!paramBase64Variant.usesPaddingChar(c)) {
                throw reportInvalidChar(paramBase64Variant, c, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
              }
              localByteArrayBuilder.append(m >> 4);
              continue;
            }
          }
          m = m << 6 | j;
          if (this._inputPtr >= this._inputEnd) {
            loadMoreGuaranteed();
          }
          arrayOfChar = this._inputBuffer;
          i = this._inputPtr;
          this._inputPtr = (i + 1);
          c = arrayOfChar[i];
          j = paramBase64Variant.decodeBase64Char(c);
          k = j;
          if (j < 0)
          {
            i = j;
            if (j != -2) {
              i = _decodeBase64Escape(paramBase64Variant, c, 3);
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
  
  protected final char _decodeEscaped()
    throws IOException, JsonParseException
  {
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(" in character escape sequence");
    }
    char[] arrayOfChar = this._inputBuffer;
    int i = this._inputPtr;
    this._inputPtr = (i + 1);
    char c2 = arrayOfChar[i];
    char c1 = c2;
    switch (c2)
    {
    default: 
      i = _handleUnrecognizedCharacterEscape(c2);
      c1 = i;
    }
    for (;;)
    {
      return c1;
      i = 8;
      c1 = i;
      continue;
      i = 9;
      c1 = i;
      continue;
      i = 10;
      c1 = i;
      continue;
      i = 12;
      c1 = i;
      continue;
      i = 13;
      c1 = i;
      continue;
      i = 0;
      for (int j = 0; j < 4; j++)
      {
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOF(" in character escape sequence");
        }
        arrayOfChar = this._inputBuffer;
        int k = this._inputPtr;
        this._inputPtr = (k + 1);
        k = arrayOfChar[k];
        int m = CharTypes.charToHex(k);
        if (m < 0) {
          _reportUnexpectedChar(k, "expected a hex-digit for character escape sequence");
        }
        i = i << 4 | m;
      }
      i = (char)i;
      c1 = i;
    }
  }
  
  protected void _finishString()
    throws IOException, JsonParseException
  {
    int i = this._inputPtr;
    int k = this._inputEnd;
    int j = i;
    if (i < k)
    {
      int[] arrayOfInt = CharTypes.getInputCodeLatin1();
      int m = arrayOfInt.length;
      int n = this._inputBuffer[i];
      if ((n < m) && (arrayOfInt[n] != 0))
      {
        j = i;
        if (n != 34) {
          break label99;
        }
        this._textBuffer.resetWithShared(this._inputBuffer, this._inputPtr, i - this._inputPtr);
        this._inputPtr = (i + 1);
      }
    }
    for (;;)
    {
      return;
      j = i + 1;
      i = j;
      if (j < k) {
        break;
      }
      label99:
      this._textBuffer.resetWithCopy(this._inputBuffer, this._inputPtr, j - this._inputPtr);
      this._inputPtr = j;
      _finishString2();
    }
  }
  
  protected void _finishString2()
    throws IOException, JsonParseException
  {
    Object localObject1 = this._textBuffer.getCurrentSegment();
    int i = this._textBuffer.getCurrentSegmentSize();
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing quote for a string value");
    }
    Object localObject2 = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    int k = localObject2[j];
    j = k;
    if (k <= 92)
    {
      if (k != 92) {
        break label125;
      }
      j = _decodeEscaped();
    }
    for (;;)
    {
      localObject2 = localObject1;
      k = i;
      if (i >= localObject1.length)
      {
        localObject2 = this._textBuffer.finishCurrentSegment();
        k = 0;
      }
      localObject2[k] = ((char)j);
      i = k + 1;
      localObject1 = localObject2;
      break;
      label125:
      j = k;
      if (k <= 34)
      {
        if (k == 34)
        {
          this._textBuffer.setCurrentLength(i);
          return;
        }
        j = k;
        if (k < 32)
        {
          _throwUnquotedSpace(k, "string value");
          j = k;
        }
      }
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
  
  protected final JsonToken _handleApostropheValue()
    throws IOException, JsonParseException
  {
    Object localObject1 = this._textBuffer.emptyAndGetCurrentSegment();
    int i = this._textBuffer.getCurrentSegmentSize();
    if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
      _reportInvalidEOF(": was expecting closing quote for a string value");
    }
    Object localObject2 = this._inputBuffer;
    int j = this._inputPtr;
    this._inputPtr = (j + 1);
    int k = localObject2[j];
    j = k;
    if (k <= 92)
    {
      if (k != 92) {
        break label125;
      }
      j = _decodeEscaped();
    }
    for (;;)
    {
      localObject2 = localObject1;
      k = i;
      if (i >= localObject1.length)
      {
        localObject2 = this._textBuffer.finishCurrentSegment();
        k = 0;
      }
      localObject2[k] = ((char)j);
      i = k + 1;
      localObject1 = localObject2;
      break;
      label125:
      j = k;
      if (k <= 39)
      {
        if (k == 39)
        {
          this._textBuffer.setCurrentLength(i);
          return JsonToken.VALUE_STRING;
        }
        j = k;
        if (k < 32)
        {
          _throwUnquotedSpace(k, "string value");
          j = k;
        }
      }
    }
  }
  
  protected final JsonToken _handleUnexpectedValue(int paramInt)
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
        _reportUnexpectedChar(localObject[i], "expected 'NaN' or a valid value");
        break;
        if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
          _reportInvalidEOFInValue();
        }
        localObject = this._inputBuffer;
        paramInt = this._inputPtr;
        this._inputPtr = (paramInt + 1);
        localObject = _handleInvalidNumberStart(localObject[paramInt], false);
      }
    }
  }
  
  protected final String _handleUnusualFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject;
    if ((paramInt == 39) && (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
      localObject = _parseApostropheFieldName();
    }
    for (;;)
    {
      return (String)localObject;
      if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
        _reportUnexpectedChar(paramInt, "was expecting double-quote to start field name");
      }
      localObject = CharTypes.getInputCodeLatin1JsNames();
      int m = localObject.length;
      boolean bool;
      label81:
      int j;
      int k;
      int n;
      if (paramInt < m) {
        if ((localObject[paramInt] == 0) && ((paramInt < 48) || (paramInt > 57)))
        {
          bool = true;
          if (!bool) {
            _reportUnexpectedChar(paramInt, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
          }
          i = this._inputPtr;
          j = 0;
          k = 0;
          n = this._inputEnd;
          paramInt = i;
          if (i >= n) {
            break label260;
          }
          paramInt = i;
          i = k;
        }
      }
      label233:
      do
      {
        j = this._inputBuffer[paramInt];
        if (j < m)
        {
          if (localObject[j] == 0) {
            break label233;
          }
          j = this._inputPtr - 1;
          this._inputPtr = paramInt;
          localObject = this._symbols.findSymbol(this._inputBuffer, j, paramInt - j, i);
          break;
          bool = false;
          break label81;
          bool = Character.isJavaIdentifierPart((char)paramInt);
          break label81;
        }
        if (!Character.isJavaIdentifierPart((char)j))
        {
          j = this._inputPtr - 1;
          this._inputPtr = paramInt;
          localObject = this._symbols.findSymbol(this._inputBuffer, j, paramInt - j, i);
          break;
        }
        j = i * 31 + j;
        k = paramInt + 1;
        i = j;
        paramInt = k;
      } while (k < n);
      paramInt = k;
      label260:
      int i = this._inputPtr;
      this._inputPtr = paramInt;
      localObject = _parseUnusualFieldName2(i - 1, j, (int[])localObject);
    }
  }
  
  protected void _matchToken(JsonToken paramJsonToken)
    throws IOException, JsonParseException
  {
    paramJsonToken = paramJsonToken.asString();
    int i = 1;
    int j = paramJsonToken.length();
    while (i < j)
    {
      if ((this._inputPtr >= this._inputEnd) && (!loadMore())) {
        _reportInvalidEOF(" in a value");
      }
      if (this._inputBuffer[this._inputPtr] != paramJsonToken.charAt(i)) {
        _reportInvalidToken(paramJsonToken.substring(0, i), "'null', 'true' or 'false'");
      }
      this._inputPtr += 1;
      i++;
    }
  }
  
  protected final String _parseApostropheFieldName()
    throws IOException, JsonParseException
  {
    int k = this._inputPtr;
    int i = 0;
    int m = 0;
    int n = this._inputEnd;
    int j = k;
    Object localObject;
    if (k < n)
    {
      localObject = CharTypes.getInputCodeLatin1();
      int i1 = localObject.length;
      j = k;
      i = m;
      k = this._inputBuffer[j];
      if (k == 39)
      {
        k = this._inputPtr;
        this._inputPtr = (j + 1);
        localObject = this._symbols.findSymbol(this._inputBuffer, k, j - k, i);
        label82:
        return (String)localObject;
      }
      if ((k >= i1) || (localObject[k] == 0)) {
        break label121;
      }
    }
    for (;;)
    {
      k = this._inputPtr;
      this._inputPtr = j;
      localObject = _parseFieldName2(k, i, 39);
      break label82;
      label121:
      m = i * 31 + k;
      k = j + 1;
      i = m;
      j = k;
      if (k < n) {
        break;
      }
      i = m;
      j = k;
    }
  }
  
  protected final String _parseFieldName(int paramInt)
    throws IOException, JsonParseException
  {
    Object localObject;
    if (paramInt != 34) {
      localObject = _handleUnusualFieldName(paramInt);
    }
    for (;;)
    {
      return (String)localObject;
      paramInt = this._inputPtr;
      int k = 0;
      int i = 0;
      int m = this._inputEnd;
      int j = paramInt;
      if (paramInt < m)
      {
        localObject = CharTypes.getInputCodeLatin1();
        int n = localObject.length;
        do
        {
          int i1 = this._inputBuffer[paramInt];
          if ((i1 < n) && (localObject[i1] != 0))
          {
            k = i;
            j = paramInt;
            if (i1 != 34) {
              break label142;
            }
            j = this._inputPtr;
            this._inputPtr = (paramInt + 1);
            localObject = this._symbols.findSymbol(this._inputBuffer, j, paramInt - j, i);
            break;
          }
          k = i * 31 + i1;
          j = paramInt + 1;
          i = k;
          paramInt = j;
        } while (j < m);
      }
      label142:
      paramInt = this._inputPtr;
      this._inputPtr = j;
      localObject = _parseFieldName2(paramInt, k, 34);
    }
  }
  
  protected final void _skipCR()
    throws IOException
  {
    if (((this._inputPtr < this._inputEnd) || (loadMore())) && (this._inputBuffer[this._inputPtr] == '\n')) {
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
    int i = this._inputPtr;
    int j = this._inputEnd;
    char[] arrayOfChar = this._inputBuffer;
    for (;;)
    {
      int k = j;
      int m = i;
      if (i >= j)
      {
        this._inputPtr = i;
        if (!loadMore()) {
          _reportInvalidEOF(": was expecting closing quote for a string value");
        }
        m = this._inputPtr;
        k = this._inputEnd;
      }
      i = m + 1;
      j = arrayOfChar[m];
      if (j <= 92)
      {
        if (j == 92)
        {
          this._inputPtr = i;
          _decodeEscaped();
          i = this._inputPtr;
          j = this._inputEnd;
          continue;
        }
        if (j <= 34)
        {
          if (j == 34)
          {
            this._inputPtr = i;
            return;
          }
          if (j < 32)
          {
            this._inputPtr = i;
            _throwUnquotedSpace(j, "string value");
          }
        }
      }
      j = k;
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
  
  public final String getText()
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
          int i = j;
          if (this._parsingContext.expectComma())
          {
            if (j != 44) {
              _reportUnexpectedChar(j, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
            }
            i = _skipWS();
          }
          boolean bool = this._parsingContext.inObject();
          j = i;
          if (bool)
          {
            localObject = _parseFieldName(i);
            this._parsingContext.setCurrentName((String)localObject);
            this._currToken = JsonToken.FIELD_NAME;
            i = _skipWS();
            if (i != 58) {
              _reportUnexpectedChar(i, "was expecting a colon to separate field name and value");
            }
            j = _skipWS();
          }
          switch (j)
          {
          default: 
            localObject = _handleUnexpectedValue(j);
          }
          for (;;)
          {
            if (!bool) {
              break label640;
            }
            this._nextToken = ((JsonToken)localObject);
            localObject = this._currToken;
            break;
            this._tokenIncomplete = true;
            localObject = JsonToken.VALUE_STRING;
            continue;
            if (!bool) {
              this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
            }
            localObject = JsonToken.START_ARRAY;
            continue;
            if (!bool) {
              this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
            }
            localObject = JsonToken.START_OBJECT;
            continue;
            _reportUnexpectedChar(j, "expected a value");
            _matchToken(JsonToken.VALUE_TRUE);
            localObject = JsonToken.VALUE_TRUE;
            continue;
            _matchToken(JsonToken.VALUE_FALSE);
            localObject = JsonToken.VALUE_FALSE;
            continue;
            _matchToken(JsonToken.VALUE_NULL);
            localObject = JsonToken.VALUE_NULL;
            continue;
            localObject = parseNumberText(j);
          }
          label640:
          this._currToken = ((JsonToken)localObject);
        }
      }
    }
  }
  
  protected IllegalArgumentException reportInvalidChar(Base64Variant paramBase64Variant, char paramChar, int paramInt)
    throws IllegalArgumentException
  {
    return reportInvalidChar(paramBase64Variant, paramChar, paramInt, null);
  }
  
  protected IllegalArgumentException reportInvalidChar(Base64Variant paramBase64Variant, char paramChar, int paramInt, String paramString)
    throws IllegalArgumentException
  {
    if (paramChar <= ' ') {
      paramBase64Variant = "Illegal white space character (code 0x" + Integer.toHexString(paramChar) + ") as character #" + (paramInt + 1) + " of 4-char base64 unit: can only used between units";
    }
    for (;;)
    {
      Object localObject = paramBase64Variant;
      if (paramString != null) {
        localObject = paramBase64Variant + ": " + paramString;
      }
      return new IllegalArgumentException((String)localObject);
      if (paramBase64Variant.usesPaddingChar(paramChar)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramChar)) || (Character.isISOControl(paramChar))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + paramChar + "' (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      }
    }
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._objectCodec = paramObjectCodec;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\ReaderBasedParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */