package org.codehaus.jackson.map.ext;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.deser.StdScalarDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

abstract class JodaDeserializers$JodaDeserializer<T>
  extends StdScalarDeserializer<T>
{
  static final DateTimeFormatter _localDateTimeFormat = ;
  
  protected JodaDeserializers$JodaDeserializer(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected DateTime parseLocal(JsonParser paramJsonParser)
    throws IOException, JsonProcessingException
  {
    paramJsonParser = paramJsonParser.getText().trim();
    if (paramJsonParser.length() == 0) {}
    for (paramJsonParser = null;; paramJsonParser = _localDateTimeFormat.parseDateTime(paramJsonParser)) {
      return paramJsonParser;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\JodaDeserializers$JodaDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */