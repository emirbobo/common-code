package org.codehaus.jackson.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.impl.JsonParserMinimalBase;
import org.codehaus.jackson.impl.JsonReadContext;

public final class TokenBuffer$Parser
  extends JsonParserMinimalBase
{
  protected transient ByteArrayBuilder _byteBuilder;
  protected boolean _closed;
  protected ObjectCodec _codec;
  protected JsonLocation _location = null;
  protected JsonReadContext _parsingContext;
  protected TokenBuffer.Segment _segment;
  protected int _segmentPtr;
  
  public TokenBuffer$Parser(TokenBuffer.Segment paramSegment, ObjectCodec paramObjectCodec)
  {
    super(0);
    this._segment = paramSegment;
    this._segmentPtr = -1;
    this._codec = paramObjectCodec;
    this._parsingContext = JsonReadContext.createRootContext(-1, -1);
  }
  
  protected final void _checkIsNumber()
    throws JsonParseException
  {
    if ((this._currToken == null) || (!this._currToken.isNumeric())) {
      throw _constructError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
    }
  }
  
  protected final Object _currentObject()
  {
    return this._segment.get(this._segmentPtr);
  }
  
  protected void _decodeBase64(String paramString, ByteArrayBuilder paramByteArrayBuilder, Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    int i = 0;
    int k = paramString.length();
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      char c = paramString.charAt(i);
      if (j >= k) {
        return;
      }
      if (c > ' ')
      {
        int m = paramBase64Variant.decodeBase64Char(c);
        if (m < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 0, null);
        }
        if (j >= k) {
          _reportBase64EOF();
        }
        i = j + 1;
        c = paramString.charAt(j);
        j = paramBase64Variant.decodeBase64Char(c);
        if (j < 0) {
          _reportInvalidBase64(paramBase64Variant, c, 1, null);
        }
        m = m << 6 | j;
        if (i >= k) {
          _reportBase64EOF();
        }
        j = i + 1;
        c = paramString.charAt(i);
        i = paramBase64Variant.decodeBase64Char(c);
        if (i < 0)
        {
          if (i != -2) {
            _reportInvalidBase64(paramBase64Variant, c, 2, null);
          }
          if (j >= k) {
            _reportBase64EOF();
          }
          i = j + 1;
          c = paramString.charAt(j);
          if (!paramBase64Variant.usesPaddingChar(c)) {
            _reportInvalidBase64(paramBase64Variant, c, 3, "expected padding character '" + paramBase64Variant.getPaddingChar() + "'");
          }
          paramByteArrayBuilder.append(m >> 4);
          break;
        }
        m = m << 6 | i;
        if (j >= k) {
          _reportBase64EOF();
        }
        i = j + 1;
        c = paramString.charAt(j);
        j = paramBase64Variant.decodeBase64Char(c);
        if (j < 0)
        {
          if (j != -2) {
            _reportInvalidBase64(paramBase64Variant, c, 3, null);
          }
          paramByteArrayBuilder.appendTwoBytes(m >> 2);
          break;
        }
        paramByteArrayBuilder.appendThreeBytes(m << 6 | j);
        break;
      }
      i = j;
    }
  }
  
  protected void _handleEOF()
    throws JsonParseException
  {
    _throwInternal();
  }
  
  protected void _reportBase64EOF()
    throws JsonParseException
  {
    throw _constructError("Unexpected end-of-String in base64 content");
  }
  
  protected void _reportInvalidBase64(Base64Variant paramBase64Variant, char paramChar, int paramInt, String paramString)
    throws JsonParseException
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
      throw _constructError((String)localObject);
      if (paramBase64Variant.usesPaddingChar(paramChar)) {
        paramBase64Variant = "Unexpected padding character ('" + paramBase64Variant.getPaddingChar() + "') as character #" + (paramInt + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if ((!Character.isDefined(paramChar)) || (Character.isISOControl(paramChar))) {
        paramBase64Variant = "Illegal character (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      } else {
        paramBase64Variant = "Illegal character '" + paramChar + "' (code 0x" + Integer.toHexString(paramChar) + ") in base64 content";
      }
    }
  }
  
  public void close()
    throws IOException
  {
    if (!this._closed) {
      this._closed = true;
    }
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException, JsonParseException
  {
    Object localObject = getNumberValue();
    if ((localObject instanceof BigInteger)) {
      localObject = (BigInteger)localObject;
    }
    for (;;)
    {
      return (BigInteger)localObject;
      switch (TokenBuffer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[getNumberType().ordinal()])
      {
      default: 
        localObject = BigInteger.valueOf(((Number)localObject).longValue());
        break;
      case 3: 
        localObject = ((BigDecimal)localObject).toBigInteger();
      }
    }
  }
  
  public byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException
  {
    Object localObject;
    if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      localObject = _currentObject();
      if ((localObject instanceof byte[])) {
        paramBase64Variant = (byte[])localObject;
      }
    }
    for (;;)
    {
      return paramBase64Variant;
      if (this._currToken != JsonToken.VALUE_STRING) {
        throw _constructError("Current token (" + this._currToken + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
      }
      String str = getText();
      if (str == null)
      {
        paramBase64Variant = null;
      }
      else
      {
        ByteArrayBuilder localByteArrayBuilder = this._byteBuilder;
        localObject = localByteArrayBuilder;
        if (localByteArrayBuilder == null)
        {
          localObject = new ByteArrayBuilder(100);
          this._byteBuilder = ((ByteArrayBuilder)localObject);
        }
        _decodeBase64(str, (ByteArrayBuilder)localObject, paramBase64Variant);
        paramBase64Variant = ((ByteArrayBuilder)localObject).toByteArray();
      }
    }
  }
  
  public ObjectCodec getCodec()
  {
    return this._codec;
  }
  
  public JsonLocation getCurrentLocation()
  {
    if (this._location == null) {}
    for (JsonLocation localJsonLocation = JsonLocation.NA;; localJsonLocation = this._location) {
      return localJsonLocation;
    }
  }
  
  public String getCurrentName()
  {
    return this._parsingContext.getCurrentName();
  }
  
  public BigDecimal getDecimalValue()
    throws IOException, JsonParseException
  {
    Object localObject = getNumberValue();
    if ((localObject instanceof BigDecimal)) {
      localObject = (BigDecimal)localObject;
    }
    for (;;)
    {
      return (BigDecimal)localObject;
      switch (TokenBuffer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[getNumberType().ordinal()])
      {
      case 3: 
      case 4: 
      default: 
        localObject = BigDecimal.valueOf(((Number)localObject).doubleValue());
        break;
      case 1: 
      case 5: 
        localObject = BigDecimal.valueOf(((Number)localObject).longValue());
        break;
      case 2: 
        localObject = new BigDecimal((BigInteger)localObject);
      }
    }
  }
  
  public double getDoubleValue()
    throws IOException, JsonParseException
  {
    return getNumberValue().doubleValue();
  }
  
  public Object getEmbeddedObject()
  {
    if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {}
    for (Object localObject = _currentObject();; localObject = null) {
      return localObject;
    }
  }
  
  public float getFloatValue()
    throws IOException, JsonParseException
  {
    return getNumberValue().floatValue();
  }
  
  public int getIntValue()
    throws IOException, JsonParseException
  {
    if (this._currToken == JsonToken.VALUE_NUMBER_INT) {}
    for (int i = ((Number)_currentObject()).intValue();; i = getNumberValue().intValue()) {
      return i;
    }
  }
  
  public long getLongValue()
    throws IOException, JsonParseException
  {
    return getNumberValue().longValue();
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException, JsonParseException
  {
    Object localObject = getNumberValue();
    if ((localObject instanceof Integer)) {
      localObject = JsonParser.NumberType.INT;
    }
    for (;;)
    {
      return (JsonParser.NumberType)localObject;
      if ((localObject instanceof Long)) {
        localObject = JsonParser.NumberType.LONG;
      } else if ((localObject instanceof Double)) {
        localObject = JsonParser.NumberType.DOUBLE;
      } else if ((localObject instanceof BigDecimal)) {
        localObject = JsonParser.NumberType.BIG_DECIMAL;
      } else if ((localObject instanceof Float)) {
        localObject = JsonParser.NumberType.FLOAT;
      } else if ((localObject instanceof BigInteger)) {
        localObject = JsonParser.NumberType.BIG_INTEGER;
      } else {
        localObject = null;
      }
    }
  }
  
  public final Number getNumberValue()
    throws IOException, JsonParseException
  {
    _checkIsNumber();
    return (Number)_currentObject();
  }
  
  public JsonStreamContext getParsingContext()
  {
    return this._parsingContext;
  }
  
  public String getText()
  {
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if ((this._currToken == JsonToken.VALUE_STRING) || (this._currToken == JsonToken.FIELD_NAME))
    {
      localObject3 = _currentObject();
      if ((localObject3 instanceof String)) {
        localObject1 = (String)localObject3;
      }
    }
    for (;;)
    {
      return (String)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = localObject3.toString();
        continue;
        localObject1 = localObject2;
        if (this._currToken != null) {
          switch (TokenBuffer.1.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()])
          {
          default: 
            localObject1 = this._currToken.asString();
            break;
          case 7: 
          case 8: 
            localObject3 = _currentObject();
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = localObject3.toString();
            }
            break;
          }
        }
      }
    }
  }
  
  public char[] getTextCharacters()
  {
    Object localObject = getText();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((String)localObject).toCharArray()) {
      return (char[])localObject;
    }
  }
  
  public int getTextLength()
  {
    String str = getText();
    if (str == null) {}
    for (int i = 0;; i = str.length()) {
      return i;
    }
  }
  
  public int getTextOffset()
  {
    return 0;
  }
  
  public JsonLocation getTokenLocation()
  {
    return getCurrentLocation();
  }
  
  public boolean hasTextCharacters()
  {
    return false;
  }
  
  public boolean isClosed()
  {
    return this._closed;
  }
  
  public JsonToken nextToken()
    throws IOException, JsonParseException
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!this._closed)
    {
      if (this._segment != null) {
        break label22;
      }
      localObject1 = localObject2;
    }
    label22:
    do
    {
      return (JsonToken)localObject1;
      int i = this._segmentPtr + 1;
      this._segmentPtr = i;
      if (i < 16) {
        break;
      }
      this._segmentPtr = 0;
      this._segment = this._segment.next();
      localObject1 = localObject2;
    } while (this._segment == null);
    this._currToken = this._segment.type(this._segmentPtr);
    if (this._currToken == JsonToken.FIELD_NAME)
    {
      localObject1 = _currentObject();
      if ((localObject1 instanceof String))
      {
        localObject1 = (String)localObject1;
        label107:
        this._parsingContext.setCurrentName((String)localObject1);
      }
    }
    for (;;)
    {
      localObject1 = this._currToken;
      break;
      localObject1 = localObject1.toString();
      break label107;
      if (this._currToken == JsonToken.START_OBJECT)
      {
        this._parsingContext = this._parsingContext.createChildObjectContext(-1, -1);
      }
      else if (this._currToken == JsonToken.START_ARRAY)
      {
        this._parsingContext = this._parsingContext.createChildArrayContext(-1, -1);
      }
      else if ((this._currToken == JsonToken.END_OBJECT) || (this._currToken == JsonToken.END_ARRAY))
      {
        this._parsingContext = this._parsingContext.getParent();
        if (this._parsingContext == null) {
          this._parsingContext = JsonReadContext.createRootContext(-1, -1);
        }
      }
    }
  }
  
  public JsonToken peekNextToken()
    throws IOException, JsonParseException
  {
    JsonToken localJsonToken = null;
    if (this._closed) {}
    label60:
    label67:
    for (;;)
    {
      return localJsonToken;
      TokenBuffer.Segment localSegment2 = this._segment;
      int j = this._segmentPtr + 1;
      int i = j;
      TokenBuffer.Segment localSegment1 = localSegment2;
      if (j >= 16)
      {
        i = 0;
        if (localSegment2 != null) {
          break label60;
        }
      }
      for (localSegment1 = null;; localSegment1 = localSegment2.next())
      {
        if (localSegment1 == null) {
          break label67;
        }
        localJsonToken = localSegment1.type(i);
        break;
      }
    }
  }
  
  public void setCodec(ObjectCodec paramObjectCodec)
  {
    this._codec = paramObjectCodec;
  }
  
  public void setLocation(JsonLocation paramJsonLocation)
  {
    this._location = paramJsonLocation;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\util\TokenBuffer$Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */