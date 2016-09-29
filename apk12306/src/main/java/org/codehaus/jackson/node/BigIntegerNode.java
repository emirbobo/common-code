package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class BigIntegerNode
  extends NumericNode
{
  protected final BigInteger _value;
  
  public BigIntegerNode(BigInteger paramBigInteger)
  {
    this._value = paramBigInteger;
  }
  
  public static BigIntegerNode valueOf(BigInteger paramBigInteger)
  {
    return new BigIntegerNode(paramBigInteger);
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
      } else if (((BigIntegerNode)paramObject)._value != this._value) {
        bool = false;
      }
    }
  }
  
  public BigInteger getBigIntegerValue()
  {
    return this._value;
  }
  
  public BigDecimal getDecimalValue()
  {
    return new BigDecimal(this._value);
  }
  
  public double getDoubleValue()
  {
    return this._value.doubleValue();
  }
  
  public int getIntValue()
  {
    return this._value.intValue();
  }
  
  public long getLongValue()
  {
    return this._value.longValue();
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return JsonParser.NumberType.BIG_INTEGER;
  }
  
  public Number getNumberValue()
  {
    return this._value;
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
  {
    if (!BigInteger.ZERO.equals(this._value)) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  public String getValueAsText()
  {
    return this._value.toString();
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
  
  public boolean isBigInteger()
  {
    return true;
  }
  
  public boolean isIntegralNumber()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(this._value);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\BigIntegerNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */