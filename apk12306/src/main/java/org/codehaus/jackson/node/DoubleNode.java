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

public final class DoubleNode
  extends NumericNode
{
  protected final double _value;
  
  public DoubleNode(double paramDouble)
  {
    this._value = paramDouble;
  }
  
  public static DoubleNode valueOf(double paramDouble)
  {
    return new DoubleNode(paramDouble);
  }
  
  public JsonToken asToken()
  {
    return JsonToken.VALUE_NUMBER_FLOAT;
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
      } else if (((DoubleNode)paramObject)._value != this._value) {
        bool = false;
      }
    }
  }
  
  public BigInteger getBigIntegerValue()
  {
    return getDecimalValue().toBigInteger();
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
    return JsonParser.NumberType.DOUBLE;
  }
  
  public Number getNumberValue()
  {
    return Double.valueOf(this._value);
  }
  
  public String getValueAsText()
  {
    return NumberOutput.toString(this._value);
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this._value);
    return (int)l ^ (int)(l >> 32);
  }
  
  public boolean isDouble()
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\DoubleNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */