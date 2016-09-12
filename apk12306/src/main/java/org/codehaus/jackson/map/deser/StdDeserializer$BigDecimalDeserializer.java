package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.math.BigDecimal;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class StdDeserializer$BigDecimalDeserializer
  extends StdScalarDeserializer<BigDecimal>
{
  public StdDeserializer$BigDecimalDeserializer()
  {
    super(BigDecimal.class);
  }
  
  public BigDecimal deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      paramJsonParser = paramJsonParser.getDecimalValue();
    }
    for (;;)
    {
      return paramJsonParser;
      if (localJsonToken == JsonToken.VALUE_STRING)
      {
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0)
        {
          paramJsonParser = null;
          continue;
        }
        try
        {
          paramJsonParser = new BigDecimal(paramJsonParser);
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
        }
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$BigDecimalDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */