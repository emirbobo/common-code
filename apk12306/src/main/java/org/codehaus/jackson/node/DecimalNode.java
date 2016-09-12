package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class DecimalNode
  extends NumericNode
{
  protected final BigDecimal _value;
  
  public DecimalNode(BigDecimal paramBigDecimal)
  {
    this._value = paramBigDecimal;
  }
  
  public static DecimalNode valueOf(BigDecimal paramBigDecimal)
  {
    return new DecimalNode(paramBigDecimal);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_FLOAT;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if (paramObject.getClass() == getClass()) {
          bool1 = ((DecimalNode)paramObject)._value.equals(this._value);
        }
      }
    }
  }
  
  public BigInteger getBigIntegerValue()
  {
    return this._value.toBigInteger();
  }
  
  public BigDecimal getDecimalValue()
  {
    return this._value;
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
    return JsonParser.NumberType.BIG_DECIMAL;
  }
  
  public Number getNumberValue()
  {
    return this._value;
  }
  
  public String getValueAsText()
  {
    return this._value.toString();
  }
  
  public int hashCode()
  {
    return this._value.hashCode();
  }
  
  public boolean isBigDecimal()
  {
    return true;
  }
  
  public boolean isFloatingPointNumber()
  {
    return true;
  }
  
  public final void serialize(JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonProcessingException
  {
    paramJsonGenerator.writeNumber(this._value);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\DecimalNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */