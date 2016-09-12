package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdSerializers$NumberSerializer
  extends ScalarSerializerBase<Number>
{
  public static final NumberSerializer instance = new NumberSerializer();
  
  public StdSerializers$NumberSerializer()
  {
    super(Number.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("number", true);
  }
  
  public void serialize(Number paramNumber, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    if ((paramNumber instanceof BigDecimal)) {
      paramJsonGenerator.writeNumber((BigDecimal)paramNumber);
    }
    for (;;)
    {
      return;
      if ((paramNumber instanceof BigInteger)) {
        paramJsonGenerator.writeNumber((BigInteger)paramNumber);
      } else if ((paramNumber instanceof Double)) {
        paramJsonGenerator.writeNumber(((Double)paramNumber).doubleValue());
      } else if ((paramNumber instanceof Float)) {
        paramJsonGenerator.writeNumber(((Float)paramNumber).floatValue());
      } else {
        paramJsonGenerator.writeNumber(paramNumber.toString());
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\StdSerializers$NumberSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */