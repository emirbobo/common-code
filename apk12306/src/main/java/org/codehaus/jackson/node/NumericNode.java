package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonParser.NumberType;

public abstract class NumericNode
  extends ValueNode
{
  public abstract BigInteger getBigIntegerValue();
  
  public abstract BigDecimal getDecimalValue();
  
  public abstract double getDoubleValue();
  
  public abstract int getIntValue();
  
  public abstract long getLongValue();
  
  public abstract JsonParser.NumberType getNumberType();
  
  public abstract Number getNumberValue();
  
  public double getValueAsDouble()
  {
    return getDoubleValue();
  }
  
  public double getValueAsDouble(double paramDouble)
  {
    return getDoubleValue();
  }
  
  public int getValueAsInt()
  {
    return getIntValue();
  }
  
  public int getValueAsInt(int paramInt)
  {
    return getIntValue();
  }
  
  public long getValueAsLong()
  {
    return getLongValue();
  }
  
  public long getValueAsLong(long paramLong)
  {
    return getLongValue();
  }
  
  public abstract String getValueAsText();
  
  public final boolean isNumber()
  {
    return true;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\NumericNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */