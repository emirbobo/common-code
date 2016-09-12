package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.Base64Variants;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdDeserializer$StringDeserializer
  extends StdScalarDeserializer<String>
{
  public StdDeserializer$StringDeserializer()
  {
    super(String.class);
  }
  
  public String deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_STRING) {
      paramJsonParser = paramJsonParser.getText();
    }
    for (;;)
    {
      return paramJsonParser;
      if (localJsonToken == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        paramJsonParser = paramJsonParser.getEmbeddedObject();
        if (paramJsonParser == null) {
          paramJsonParser = null;
        } else if ((paramJsonParser instanceof byte[])) {
          paramJsonParser = Base64Variants.getDefaultVariant().encode((byte[])paramJsonParser, false);
        } else {
          paramJsonParser = paramJsonParser.toString();
        }
      }
      else
      {
        if (!localJsonToken.isScalarValue()) {
          break;
        }
        paramJsonParser = paramJsonParser.getText();
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
  
  public String deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return deserialize(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$StringDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */