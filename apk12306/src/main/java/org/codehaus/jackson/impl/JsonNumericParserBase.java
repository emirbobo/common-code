package org.codehaus.jackson.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.IOContext;
import org.codehaus.jackson.io.NumberInput;
import org.codehaus.jackson.util.TextBuffer;

public abstract class JsonNumericParserBase
  extends JsonParserBase
{
  static final BigDecimal BD_MAX_INT = new BigDecimal(Long.MAX_VALUE);
  static final BigDecimal BD_MAX_LONG;
  static final BigDecimal BD_MIN_INT;
  static final BigDecimal BD_MIN_LONG = new BigDecimal(Long.MIN_VALUE);
  protected static final char CHAR_NULL = '\000';
  protected static final int INT_0 = 48;
  protected static final int INT_1 = 49;
  protected static final int INT_2 = 50;
  protected static final int INT_3 = 51;
  protected static final int INT_4 = 52;
  protected static final int INT_5 = 53;
  protected static final int INT_6 = 54;
  protected static final int INT_7 = 55;
  protected static final int INT_8 = 56;
  protected static final int INT_9 = 57;
  protected static final int INT_DECIMAL_POINT = 46;
  protected static final int INT_E = 69;
  protected static final int INT_MINUS = 45;
  protected static final int INT_PLUS = 43;
  protected static final int INT_e = 101;
  static final double MAX_INT_D = 2.147483647E9D;
  static final long MAX_INT_L = 2147483647L;
  static final double MAX_LONG_D = 9.223372036854776E18D;
  static final double MIN_INT_D = -2.147483648E9D;
  static final long MIN_INT_L = -2147483648L;
  static final double MIN_LONG_D = -9.223372036854776E18D;
  protected static final int NR_BIGDECIMAL = 16;
  protected static final int NR_BIGINT = 4;
  protected static final int NR_DOUBLE = 8;
  protected static final int NR_INT = 1;
  protected static final int NR_LONG = 2;
  protected static final int NR_UNKNOWN = 0;
  protected int _expLength;
  protected int _fractLength;
  protected int _intLength;
  protected int _numTypesValid = 0;
  protected BigDecimal _numberBigDecimal;
  protected BigInteger _numberBigInt;
  protected double _numberDouble;
  protected int _numberInt;
  protected long _numberLong;
  protected boolean _numberNegative;
  
  static
  {
    BD_MAX_LONG = new BigDecimal(Long.MAX_VALUE);
    BD_MIN_INT = new BigDecimal(Long.MIN_VALUE);
  }
  
  protected JsonNumericParserBase(IOContext paramIOContext, int paramInt)
  {
    super(paramIOContext, paramInt);
  }
  
  private final void _parseSlowFloatValue(int paramInt)
    throws IOException, JsonParseException
  {
    if (paramInt == 16) {}
    try
    {
      this._numberBigDecimal = this._textBuffer.contentsAsDecimal();
      for (this._numTypesValid = 16;; this._numTypesValid = 8)
      {
        return;
        this._numberDouble = this._textBuffer.contentsAsDouble();
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        _wrapError("Malformed numeric value '" + this._textBuffer.contentsAsString() + "'", localNumberFormatException);
      }
    }
  }
  
  private final void _parseSlowIntValue(int paramInt1, char[] paramArrayOfChar, int paramInt2, int paramInt3)
    throws IOException, JsonParseException
  {
    String str = this._textBuffer.contentsAsString();
    try
    {
      if (NumberInput.inLongRange(paramArrayOfChar, paramInt2, paramInt3, this._numberNegative)) {
        this._numberLong = Long.parseLong(str);
      }
      for (this._numTypesValid = 2;; this._numTypesValid = 4)
      {
        return;
        paramArrayOfChar = new java/math/BigInteger;
        paramArrayOfChar.<init>(str);
        this._numberBigInt = paramArrayOfChar;
      }
    }
    catch (NumberFormatException paramArrayOfChar)
    {
      for (;;)
      {
        _wrapError("Malformed numeric value '" + str + "'", paramArrayOfChar);
      }
    }
  }
  
  protected void _parseNumericValue(int paramInt)
    throws IOException, JsonParseException
  {
    char[] arrayOfChar;
    int k;
    int i;
    if (this._currToken == JsonToken.VALUE_NUMBER_INT)
    {
      arrayOfChar = this._textBuffer.getTextBuffer();
      int j = this._textBuffer.getTextOffset();
      k = this._intLength;
      i = j;
      if (this._numberNegative) {
        i = j + 1;
      }
      if (k <= 9)
      {
        i = NumberInput.parseInt(arrayOfChar, i, k);
        paramInt = i;
        if (this._numberNegative) {
          paramInt = -i;
        }
        this._numberInt = paramInt;
        this._numTypesValid = 1;
      }
    }
    for (;;)
    {
      return;
      if (k <= 18)
      {
        long l2 = NumberInput.parseLong(arrayOfChar, i, k);
        long l1 = l2;
        if (this._numberNegative) {
          l1 = -l2;
        }
        if (k == 10) {
          if (this._numberNegative)
          {
            if (l1 >= -2147483648L)
            {
              this._numberInt = ((int)l1);
              this._numTypesValid = 1;
            }
          }
          else if (l1 <= 2147483647L)
          {
            this._numberInt = ((int)l1);
            this._numTypesValid = 1;
            continue;
          }
        }
        this._numberLong = l1;
        this._numTypesValid = 2;
      }
      else
      {
        _parseSlowIntValue(paramInt, arrayOfChar, i, k);
        continue;
        if (this._currToken == JsonToken.VALUE_NUMBER_FLOAT) {
          _parseSlowFloatValue(paramInt);
        } else {
          _reportError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
        }
      }
    }
  }
  
  protected void convertNumberToBigDecimal()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x8) != 0) {
      this._numberBigDecimal = new BigDecimal(getText());
    }
    for (;;)
    {
      this._numTypesValid |= 0x10;
      return;
      if ((this._numTypesValid & 0x4) != 0) {
        this._numberBigDecimal = new BigDecimal(this._numberBigInt);
      } else if ((this._numTypesValid & 0x2) != 0) {
        this._numberBigDecimal = BigDecimal.valueOf(this._numberLong);
      } else if ((this._numTypesValid & 0x1) != 0) {
        this._numberBigDecimal = BigDecimal.valueOf(this._numberInt);
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToBigInteger()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x10) != 0) {
      this._numberBigInt = this._numberBigDecimal.toBigInteger();
    }
    for (;;)
    {
      this._numTypesValid |= 0x4;
      return;
      if ((this._numTypesValid & 0x2) != 0) {
        this._numberBigInt = BigInteger.valueOf(this._numberLong);
      } else if ((this._numTypesValid & 0x1) != 0) {
        this._numberBigInt = BigInteger.valueOf(this._numberInt);
      } else if ((this._numTypesValid & 0x8) != 0) {
        this._numberBigInt = BigDecimal.valueOf(this._numberDouble).toBigInteger();
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToDouble()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x10) != 0) {
      this._numberDouble = this._numberBigDecimal.doubleValue();
    }
    for (;;)
    {
      this._numTypesValid |= 0x8;
      return;
      if ((this._numTypesValid & 0x4) != 0) {
        this._numberDouble = this._numberBigInt.doubleValue();
      } else if ((this._numTypesValid & 0x2) != 0) {
        this._numberDouble = this._numberLong;
      } else if ((this._numTypesValid & 0x1) != 0) {
        this._numberDouble = this._numberInt;
      } else {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToInt()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x2) != 0)
    {
      int i = (int)this._numberLong;
      if (i != this._numberLong) {
        _reportError("Numeric value (" + getText() + ") out of range of int");
      }
      this._numberInt = i;
    }
    for (;;)
    {
      this._numTypesValid |= 0x1;
      return;
      if ((this._numTypesValid & 0x4) != 0)
      {
        this._numberInt = this._numberBigInt.intValue();
      }
      else if ((this._numTypesValid & 0x8) != 0)
      {
        if ((this._numberDouble < -2.147483648E9D) || (this._numberDouble > 2.147483647E9D)) {
          reportOverflowInt();
        }
        this._numberInt = ((int)this._numberDouble);
      }
      else if ((this._numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_INT.compareTo(this._numberBigDecimal) > 0) || (BD_MAX_INT.compareTo(this._numberBigDecimal) < 0)) {
          reportOverflowInt();
        }
        this._numberInt = this._numberBigDecimal.intValue();
      }
      else
      {
        _throwInternal();
      }
    }
  }
  
  protected void convertNumberToLong()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x1) != 0) {
      this._numberLong = this._numberInt;
    }
    for (;;)
    {
      this._numTypesValid |= 0x2;
      return;
      if ((this._numTypesValid & 0x4) != 0)
      {
        this._numberLong = this._numberBigInt.longValue();
      }
      else if ((this._numTypesValid & 0x8) != 0)
      {
        if ((this._numberDouble < -9.223372036854776E18D) || (this._numberDouble > 9.223372036854776E18D)) {
          reportOverflowLong();
        }
        this._numberLong = (this._numberDouble);
      }
      else if ((this._numTypesValid & 0x10) != 0)
      {
        if ((BD_MIN_LONG.compareTo(this._numberBigDecimal) > 0) || (BD_MAX_LONG.compareTo(this._numberBigDecimal) < 0)) {
          reportOverflowLong();
        }
        this._numberLong = this._numberBigDecimal.longValue();
      }
      else
      {
        _throwInternal();
      }
    }
  }
  
  public BigInteger getBigIntegerValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x4) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(4);
      }
      if ((this._numTypesValid & 0x4) == 0) {
        convertNumberToBigInteger();
      }
    }
    return this._numberBigInt;
  }
  
  public BigDecimal getDecimalValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x10) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(16);
      }
      if ((this._numTypesValid & 0x10) == 0) {
        convertNumberToBigDecimal();
      }
    }
    return this._numberBigDecimal;
  }
  
  public double getDoubleValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x8) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(8);
      }
      if ((this._numTypesValid & 0x8) == 0) {
        convertNumberToDouble();
      }
    }
    return this._numberDouble;
  }
  
  public float getFloatValue()
    throws IOException, JsonParseException
  {
    return (float)getDoubleValue();
  }
  
  public int getIntValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x1) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(1);
      }
      if ((this._numTypesValid & 0x1) == 0) {
        convertNumberToInt();
      }
    }
    return this._numberInt;
  }
  
  public long getLongValue()
    throws IOException, JsonParseException
  {
    if ((this._numTypesValid & 0x2) == 0)
    {
      if (this._numTypesValid == 0) {
        _parseNumericValue(2);
      }
      if ((this._numTypesValid & 0x2) == 0) {
        convertNumberToLong();
      }
    }
    return this._numberLong;
  }
  
  public JsonParser.NumberType getNumberType()
    throws IOException, JsonParseException
  {
    if (this._numTypesValid == 0) {
      _parseNumericValue(0);
    }
    JsonParser.NumberType localNumberType;
    if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
      if ((this._numTypesValid & 0x1) != 0) {
        localNumberType = JsonParser.NumberType.INT;
      }
    }
    for (;;)
    {
      return localNumberType;
      if ((this._numTypesValid & 0x2) != 0)
      {
        localNumberType = JsonParser.NumberType.LONG;
      }
      else
      {
        localNumberType = JsonParser.NumberType.BIG_INTEGER;
        continue;
        if ((this._numTypesValid & 0x10) != 0) {
          localNumberType = JsonParser.NumberType.BIG_DECIMAL;
        } else {
          localNumberType = JsonParser.NumberType.DOUBLE;
        }
      }
    }
  }
  
  public Number getNumberValue()
    throws IOException, JsonParseException
  {
    if (this._numTypesValid == 0) {
      _parseNumericValue(0);
    }
    Object localObject;
    if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
      if ((this._numTypesValid & 0x1) != 0) {
        localObject = Integer.valueOf(this._numberInt);
      }
    }
    for (;;)
    {
      return (Number)localObject;
      if ((this._numTypesValid & 0x2) != 0)
      {
        localObject = Long.valueOf(this._numberLong);
      }
      else if ((this._numTypesValid & 0x4) != 0)
      {
        localObject = this._numberBigInt;
      }
      else
      {
        localObject = this._numberBigDecimal;
        continue;
        if ((this._numTypesValid & 0x10) != 0)
        {
          localObject = this._numberBigDecimal;
        }
        else
        {
          if ((this._numTypesValid & 0x8) == 0) {
            _throwInternal();
          }
          localObject = Double.valueOf(this._numberDouble);
        }
      }
    }
  }
  
  protected void reportInvalidNumber(String paramString)
    throws JsonParseException
  {
    _reportError("Invalid numeric value: " + paramString);
  }
  
  protected void reportOverflowInt()
    throws IOException, JsonParseException
  {
    _reportError("Numeric value (" + getText() + ") out of range of int (" + Integer.MIN_VALUE + " - " + Integer.MAX_VALUE + ")");
  }
  
  protected void reportOverflowLong()
    throws IOException, JsonParseException
  {
    _reportError("Numeric value (" + getText() + ") out of range of long (" + Long.MIN_VALUE + " - " + Long.MAX_VALUE + ")");
  }
  
  protected void reportUnexpectedNumberChar(int paramInt, String paramString)
    throws JsonParseException
  {
    String str2 = "Unexpected character (" + _getCharDesc(paramInt) + ") in numeric value";
    String str1 = str2;
    if (paramString != null) {
      str1 = str2 + ": " + paramString;
    }
    _reportError(str1);
  }
  
  protected final JsonToken reset(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < 1) && (paramInt3 < 1)) {}
    for (JsonToken localJsonToken = resetInt(paramBoolean, paramInt1);; localJsonToken = resetFloat(paramBoolean, paramInt1, paramInt2, paramInt3)) {
      return localJsonToken;
    }
  }
  
  protected final JsonToken resetAsNaN(String paramString, double paramDouble)
  {
    this._textBuffer.resetWithString(paramString);
    this._numberDouble = paramDouble;
    this._numTypesValid = 8;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  protected final JsonToken resetFloat(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    this._numberNegative = paramBoolean;
    this._intLength = paramInt1;
    this._fractLength = paramInt2;
    this._expLength = paramInt3;
    this._numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  protected final JsonToken resetInt(boolean paramBoolean, int paramInt)
  {
    this._numberNegative = paramBoolean;
    this._intLength = paramInt;
    this._fractLength = 0;
    this._expLength = 0;
    this._numTypesValid = 0;
    return JsonToken.VALUE_NUMBER_INT;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\impl\JsonNumericParserBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */