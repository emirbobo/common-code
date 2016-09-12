package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;

public class StdDeserializer$SqlDateDeserializer
  extends StdScalarDeserializer<java.sql.Date>
{
  public StdDeserializer$SqlDateDeserializer()
  {
    super(java.sql.Date.class);
  }
  
  public java.sql.Date deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    paramJsonParser = _parseDate(paramJsonParser, paramDeserializationContext);
    if (paramJsonParser == null) {}
    for (paramJsonParser = null;; paramJsonParser = new java.sql.Date(paramJsonParser.getTime())) {
      return paramJsonParser;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$SqlDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */