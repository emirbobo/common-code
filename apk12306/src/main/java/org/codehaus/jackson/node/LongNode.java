package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.io.NumberOutput;
import org.codehaus.jackson.map.SerializerProvider;

public final class LongNode
  extends NumericNode
{
  final long _value;
  
  public LongNode(long paramLong)
  {
    this._value = paramLong;
  }
  
  public static LongNode valueOf(long paramLong)
  {
    return new LongNode(paramLong);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_INT;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {}
    for (;;)
    {
      return bool;
      if (paramObject == null) {
        bool = false;
      } else if (paramObject.getClass() != getClass()) {
        bool = false;
      } else if (((LongNode)paramObject)._value != this._value) {
        bool = false;
      }
    }
  }
  
  public BigInteger getBigIntegerValue()
  {
    return BigInteger.valueOf(this._value);
  }
  
  public BigDecimal getDecimalValue()
  {
    return BigDecimal.valueOf(this._value);
  }
  
  public double getDoubleValue()
  {
    return this._value;
  }
  
  public int getIntValue()
  {
    return (int)this._value;
  }
  
  public long getLongValue()
  {
    return this._value;
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return JsonParser.NumberType.LONG;
  }
  
  public Number getNumberValue()
  {
    return Long.valueOf(this._value);
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
  {
    if (this._value != 0L) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public String getValueAsText()
  {
    return NumberOutput.toString(this._value);
  }
  
  public int hashCode()
  {
    return (int)this._value ^ (int)(this._value >> 32);
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public boolean isLong()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(this._value);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\LongNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */