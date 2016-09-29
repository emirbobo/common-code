package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdDeserializer$NumberDeserializer
  extends StdScalarDeserializer<Number>
{
  public StdDeserializer$NumberDeserializer()
  {
    super(Number.class);
  }
  
  public Number deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)) {
        paramJsonParser = paramJsonParser.getBigIntegerValue();
      }
    }
    for (;;)
    {
      return paramJsonParser;
      paramJsonParser = paramJsonParser.getNumberValue();
      continue;
      if (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)
      {
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
          paramJsonParser = paramJsonParser.getDecimalValue();
        } else {
          paramJsonParser = Double.valueOf(paramJsonParser.getDoubleValue());
        }
      }
      else
      {
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText().trim();
        try
        {
          if (paramJsonParser.indexOf('.') < 0) {
            break label147;
          }
          if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            paramJsonParser = new BigDecimal(paramJsonParser);
          }
        }
        catch (IllegalArgumentException paramJsonParser)
        {
          throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid number");
        }
        paramJsonParser = new Double(paramJsonParser);
        continue;
        label147:
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS))
        {
          paramJsonParser = new BigInteger(paramJsonParser);
        }
        else
        {
          long l = Long.parseLong(paramJsonParser);
          if ((l <= 2147483647L) && (l >= -2147483648L)) {
            paramJsonParser = Integer.valueOf((int)l);
          } else {
            paramJsonParser = Long.valueOf(l);
          }
        }
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    switch (StdDeserializer.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
    {
    }
    for (paramJsonParser = paramTypeDeserializer.deserializeTypedFromScalar(paramJsonParser, paramDeserializationContext);; paramJsonParser = deserialize(paramJsonParser, paramDeserializationContext)) {
      return paramJsonParser;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$NumberDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */