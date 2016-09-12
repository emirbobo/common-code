package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;

public class TimestampDeserializer
  extends StdScalarDeserializer<Timestamp>
{
  public TimestampDeserializer()
  {
    super(Timestamp.class);
  }
  
  public Timestamp deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    return new Timestamp(_parseDate(paramJsonParser, paramDeserializationContext).getTime());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\TimestampDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */