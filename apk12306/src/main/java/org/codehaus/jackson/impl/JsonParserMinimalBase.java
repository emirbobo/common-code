package org.codehaus.jackson.impl;

import java.io.IOException;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.NumberInput;

public abstract class JsonParserMinimalBase
  extends JsonParser
{
  protected static final int INT_APOSTROPHE = 39;
  protected static final int INT_ASTERISK = 42;
  protected static final int INT_BACKSLASH = 92;
  protected static final int INT_COLON = 58;
  protected static final int INT_COMMA = 44;
  protected static final int INT_CR = 13;
  protected static final int INT_LBRACKET = 91;
  protected static final int INT_LCURLY = 123;
  protected static final int INT_LF = 10;
  protected static final int INT_QUOTE = 34;
  protected static final int INT_RBRACKET = 93;
  protected static final int INT_RCURLY = 125;
  protected static final int INT_SLASH = 47;
  protected static final int INT_SPACE = 32;
  protected static final int INT_TAB = 9;
  protected static final int INT_b = 98;
  protected static final int INT_f = 102;
  protected static final int INT_n = 110;
  protected static final int INT_r = 114;
  protected static final int INT_t = 116;
  protected static final int INT_u = 117;
  
  protected JsonParserMinimalBase() {}
  
  protected JsonParserMinimalBase(int paramInt)
  {
    super(paramInt);
  }
  
  protected static final String _getCharDesc(int paramInt)
  {
    char c = (char)paramInt;
    String str;
    if (Character.isISOControl(c)) {
      str = "(CTRL-CHAR, code " + paramInt + ")";
    }
    for (;;)
    {
      return str;
      if (paramInt > 255) {
        str = "'" + c + "' (code " + paramInt + " / 0x" + Integer.toHexString(paramInt) + ")";
      } else {
        str = "'" + c + "' (code " + paramInt + ")";
      }
    }
  }
  
  protected final JsonParseException _constructError(String paramString, Throwable paramThrowable)
  {
    return new JsonParseException(paramString, getCurrentLocation(), paramThrowable);
  }
  
  protected abstract void _handleEOF()
    throws JsonParseException;
  
  protected char _handleUnrecognizedCharacterEscape(char paramChar)
    throws JsonProcessingException
  {
    if (isEnabled(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)) {}
    for (;;)
    {
      return paramChar;
      if ((paramChar != '\'') || (!isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES))) {
        _reportError("Unrecognized character escape " + _getCharDesc(paramChar));
      }
    }
  }
  
  protected final void _reportError(String paramString)
    throws JsonParseException
  {
    throw _constructError(paramString);
  }
  
  protected void _reportInvalidEOF()
    throws JsonParseException
  {
    _reportInvalidEOF(" in " + this._currToken);
  }
  
  protected void _reportInvalidEOF(String paramString)
    throws JsonParseException
  {
    _reportError("Unexpected end-of-input" + paramString);
  }
  
  protected void _reportInvalidEOFInValue()
    throws JsonParseException
  {
    _reportInvalidEOF(" in a value");
  }
  
  protected void _reportUnexpectedChar(int paramInt, String paramString)
    throws JsonParseException
  {
    String str2 = "Unexpected character (" + _getCharDesc(paramInt) + ")";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    _reportError(str1);
  }
  
  protected final void _throwInternal()
  {
    throw new RuntimeException("Internal error: this code path should never get executed");
  }
  
  protected void _throwInvalidSpace(int paramInt)
    throws JsonParseException
  {
    paramInt = (char)paramInt;
    _reportError("Illegal character (" + _getCharDesc(paramInt) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
  }
  
  protected void _throwUnquotedSpace(int paramInt, String paramString)
    throws JsonParseException
  {
    if ((!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS)) || (paramInt >= 32))
    {
      paramInt = (char)paramInt;
      _reportError("Illegal unquoted character (" + _getCharDesc(paramInt) + "): has to be escaped using backslash to be included in " + paramString);
    }
  }
  
  protected final void _wrapError(String paramString, Throwable paramThrowable)
    throws JsonParseException
  {
    throw _constructError(paramString, paramThrowable);
  }
  
  public abstract void close()
    throws IOException;
  
  public abstract byte[] getBinaryValue(Base64Variant paramBase64Variant)
    throws IOException, JsonParseException;
  
  public abstract String getCurrentName()
    throws IOException, JsonParseException;
  
  public abstract JsonStreamContext getParsingContext();
  
  public abstract String getText()
    throws IOException, JsonParseException;
  
  public abstract char[] getTextCharacters()
    throws IOException, JsonParseException;
  
  public abstract int getTextLength()
    throws IOException, JsonParseException;
  
  public abstract int getTextOffset()
    throws IOException, JsonParseException;
  
  public boolean getValueAsBoolean(boolean paramBoolean)
    throws IOException, JsonParseException
  {
    boolean bool2 = true;
    boolean bool1;
    if (this._currToken != null) {
      bool1 = bool2;
    }
    switch (this._currToken)
    {
    default: 
      bool1 = paramBoolean;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (getIntValue() == 0)
      {
        bool1 = false;
        continue;
        bool1 = false;
        continue;
        Object localObject = getEmbeddedObject();
        if ((localObject instanceof Boolean))
        {
          bool1 = ((Boolean)localObject).booleanValue();
        }
        else
        {
          if (!"true".equals(getText().trim())) {
            break;
          }
          bool1 = bool2;
        }
      }
    }
  }
  
  public double getValueAsDouble(double paramDouble)
    throws IOException, JsonParseException
  {
    double d = paramDouble;
    if (this._currToken != null) {
      switch (this._currToken)
      {
      default: 
        d = paramDouble;
      }
    }
    for (;;)
    {
      return d;
      d = getDoubleValue();
      continue;
      d = 1.0D;
      continue;
      d = 0.0D;
      continue;
      d = NumberInput.parseAsDouble(getText(), paramDouble);
      continue;
      Object localObject = getEmbeddedObject();
      d = paramDouble;
      if ((localObject instanceof Number)) {
        d = ((Number)localObject).doubleValue();
      }
    }
  }
  
  public int getValueAsInt(int paramInt)
    throws IOException, JsonParseException
  {
    int i = paramInt;
    if (this._currToken != null) {
      switch (this._currToken)
      {
      default: 
        i = paramInt;
      }
    }
    for (;;)
    {
      return i;
      i = getIntValue();
      continue;
      i = 1;
      continue;
      i = 0;
      continue;
      i = NumberInput.parseAsInt(getText(), paramInt);
      continue;
      Object localObject = getEmbeddedObject();
      i = paramInt;
      if ((localObject instanceof Number)) {
        i = ((Number)localObject).intValue();
      }
    }
  }
  
  public long getValueAsLong(long paramLong)
    throws IOException, JsonParseException
  {
    long l = paramLong;
    if (this._currToken != null) {
      switch (this._currToken)
      {
      default: 
        l = paramLong;
      }
    }
    for (;;)
    {
      return l;
      l = getLongValue();
      continue;
      l = 1L;
      continue;
      l = 0L;
      continue;
      l = NumberInput.parseAsLong(getText(), paramLong);
      continue;
      Object localObject = getEmbeddedObject();
      l = paramLong;
      if ((localObject instanceof Number)) {
        l = ((Number)localObject).longValue();
      }
    }
  }
  
  public abstract boolean hasTextCharacters();
  
  public abstract boolean isClosed();
  
  public abstract JsonToken nextToken()
    throws IOException, JsonParseException;
  
  public JsonParser skipChildren()
    throws IOException, JsonParseException
  {
    if ((this._currToken != JsonToken.START_OBJECT) && (this._currToken != JsonToken.START_ARRAY)) {}
    for (;;)
    {
      return this;
      int i = 1;
      int j;
      do
      {
        for (;;)
        {
          JsonToken localJsonToken = nextToken();
          if (localJsonToken == null)
          {
            _handleEOF();
            break;
          }
          switch (localJsonToken)
          {
          default: 
            break;
          case ???: 
          case ???: 
            i++;
          }
        }
        j = i - 1;
        i = j;
      } while (j != 0);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\JsonParserMinimalBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */