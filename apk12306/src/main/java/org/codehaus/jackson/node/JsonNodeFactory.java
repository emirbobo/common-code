package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.math.BigInteger;

public class JsonNodeFactory
{
  public static final JsonNodeFactory instance = new JsonNodeFactory();
  
  public POJONode POJONode(Object paramObject)
  {
    return new POJONode(paramObject);
  }
  
  public ArrayNode arrayNode()
  {
    return new ArrayNode(this);
  }
  
  public BinaryNode binaryNode(byte[] paramArrayOfByte)
  {
    return BinaryNode.valueOf(paramArrayOfByte);
  }
  
  public BinaryNode binaryNode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return BinaryNode.valueOf(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public BooleanNode booleanNode(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (BooleanNode localBooleanNode = BooleanNode.getTrue();; localBooleanNode = BooleanNode.getFalse()) {
      return localBooleanNode;
    }
  }
  
  public NullNode nullNode()
  {
    return NullNode.getInstance();
  }
  
  public NumericNode numberNode(byte paramByte)
  {
    return IntNode.valueOf(paramByte);
  }
  
  public NumericNode numberNode(double paramDouble)
  {
    return DoubleNode.valueOf(paramDouble);
  }
  
  public NumericNode numberNode(float paramFloat)
  {
    return DoubleNode.valueOf(paramFloat);
  }
  
  public NumericNode numberNode(int paramInt)
  {
    return IntNode.valueOf(paramInt);
  }
  
  public NumericNode numberNode(long paramLong)
  {
    return LongNode.valueOf(paramLong);
  }
  
  public NumericNode numberNode(BigDecimal paramBigDecimal)
  {
    return DecimalNode.valueOf(paramBigDecimal);
  }
  
  public NumericNode numberNode(BigInteger paramBigInteger)
  {
    return BigIntegerNode.valueOf(paramBigInteger);
  }
  
  public NumericNode numberNode(short paramShort)
  {
    return IntNode.valueOf(paramShort);
  }
  
  public ObjectNode objectNode()
  {
    return new ObjectNode(this);
  }
  
  public TextNode textNode(String paramString)
  {
    return TextNode.valueOf(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\node\JsonNodeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */