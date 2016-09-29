package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.type.JavaType;

public class AbstractDeserializer
  extends JsonDeserializer<Object>
{
  protected final JavaType _baseType;
  
  public AbstractDeserializer(JavaType paramJavaType)
  {
    this._baseType = paramJavaType;
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    throw paramDeserializationContext.instantiationException(this._baseType.getRawClass(), "abstract types can only be instantiated with additional type information");
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    switch (paramJsonParser.getCurrentToken())
    {
    default: 
      paramJsonParser = paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
    }
    for (;;)
    {
      return paramJsonParser;
      paramJsonParser = paramJsonParser.getText();
      continue;
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS))
      {
        paramJsonParser = paramJsonParser.getBigIntegerValue();
      }
      else
      {
        paramJsonParser = Integer.valueOf(paramJsonParser.getIntValue());
        continue;
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS))
        {
          paramJsonParser = paramJsonParser.getDecimalValue();
        }
        else
        {
          paramJsonParser = Double.valueOf(paramJsonParser.getDoubleValue());
          continue;
          paramJsonParser = Boolean.TRUE;
          continue;
          paramJsonParser = Boolean.FALSE;
          continue;
          paramJsonParser = paramJsonParser.getEmbeddedObject();
          continue;
          paramJsonParser = null;
          continue;
          paramJsonParser = paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\AbstractDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */