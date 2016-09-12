package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdDeserializer$ClassDeserializer
  extends StdScalarDeserializer<Class<?>>
{
  public StdDeserializer$ClassDeserializer()
  {
    super(Class.class);
  }
  
  public Class<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) {
      try
      {
        paramJsonParser = Class.forName(paramJsonParser.getText());
        return paramJsonParser;
      }
      catch (ClassNotFoundException paramJsonParser)
      {
        throw paramDeserializationContext.instantiationException(this._valueClass, paramJsonParser);
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$ClassDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */