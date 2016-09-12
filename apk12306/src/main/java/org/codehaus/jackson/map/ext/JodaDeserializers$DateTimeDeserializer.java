package org.codehaus.jackson.map.ext;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInstant;

public class JodaDeserializers$DateTimeDeserializer<T extends ReadableInstant>
  extends JodaDeserializers.JodaDeserializer<T>
{
  public JodaDeserializers$DateTimeDeserializer(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  public T deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT) {
      paramJsonParser = new DateTime(paramJsonParser.getLongValue(), DateTimeZone.UTC);
    }
    for (;;)
    {
      return paramJsonParser;
      if (localJsonToken != JsonToken.VALUE_STRING) {
        break;
      }
      paramJsonParser = paramJsonParser.getText().trim();
      if (paramJsonParser.length() == 0) {
        paramJsonParser = null;
      } else {
        paramJsonParser = new DateTime(paramJsonParser, DateTimeZone.UTC);
      }
    }
    throw paramDeserializationContext.mappingException(getValueClass());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\JodaDeserializers$DateTimeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */