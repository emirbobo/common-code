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

public final class IntNode
  extends NumericNode
{
  private static final IntNode[] CANONICALS = new IntNode[12];
  static final int MAX_CANONICAL = 10;
  static final int MIN_CANONICAL = -1;
  final int _value;
  
  static
  {
    for (int i = 0; i < 12; i++) {
      CANONICALS[i] = new IntNode(i - 1);
    }
  }
  
  public IntNode(int paramInt)
  {
    this._value = paramInt;
  }
  
  public static IntNode valueOf(int paramInt)
  {
    if ((paramInt > 10) || (paramInt < -1)) {}
    for (IntNode localIntNode = new IntNode(paramInt);; localIntNode = CANONICALS[(paramInt + 1)]) {
      return localIntNode;
    }
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
      } else if (((IntNode)paramObject)._value != this._value) {
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
    return this._value;
  }
  
  public long getLongValue()
  {
    return this._value;
  }
  
  public JsonParser.NumberType getNumberType()
  {
    return JsonParser.NumberType.INT;
  }
  
  public Number getNumberValue()
  {
    return Integer.valueOf(this._value);
  }
  
  public boolean getValueAsBoolean(boolean paramBoolean)
  {
    if (this._value != 0) {}
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
    return this._value;
  }
  
  public boolean isInt()
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\IntNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */