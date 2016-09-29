package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class StdDeserializer$BigIntegerDeserializer
  extends StdScalarDeserializer<BigInteger>
{
  public StdDeserializer$BigIntegerDeserializer()
  {
    super(BigInteger.class);
  }
  
  public BigInteger deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
      switch (StdDeserializer.1.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[paramJsonParser.getNumberType().ordinal()])
      {
      default: 
        paramJsonParser = paramJsonParser.getText().trim();
        if (paramJsonParser.length() == 0) {
          paramJsonParser = null;
        }
        break;
      }
    }
    for (;;)
    {
      return paramJsonParser;
      paramJsonParser = BigInteger.valueOf(paramJsonParser.getLongValue());
      continue;
      if (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)
      {
        paramJsonParser = paramJsonParser.getDecimalValue().toBigInteger();
        continue;
      }
      if (localJsonToken == JsonToken.VALUE_STRING) {
        break;
      }
      throw paramDeserializationContext.mappingException(this._valueClass);
      try
      {
        paramJsonParser = new BigInteger(paramJsonParser);
      }
      catch (IllegalArgumentException paramJsonParser)
      {
        throw paramDeserializationContext.weirdStringException(this._valueClass, "not a valid representation");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$BigIntegerDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */