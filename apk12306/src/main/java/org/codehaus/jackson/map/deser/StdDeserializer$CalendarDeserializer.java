package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public class StdDeserializer$CalendarDeserializer
  extends StdScalarDeserializer<Calendar>
{
  Class<? extends Calendar> _calendarClass;
  
  public StdDeserializer$CalendarDeserializer()
  {
    this(null);
  }
  
  public StdDeserializer$CalendarDeserializer(Class<? extends Calendar> paramClass)
  {
    super(Calendar.class);
    this._calendarClass = paramClass;
  }
  
  public Calendar deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Date localDate = _parseDate(paramJsonParser, paramDeserializationContext);
    if (localDate == null) {
      paramJsonParser = null;
    }
    for (;;)
    {
      return paramJsonParser;
      if (this._calendarClass == null)
      {
        paramJsonParser = paramDeserializationContext.constructCalendar(localDate);
        continue;
      }
      try
      {
        paramJsonParser = (Calendar)this._calendarClass.newInstance();
        paramJsonParser.setTimeInMillis(localDate.getTime());
      }
      catch (Exception paramJsonParser)
      {
        throw paramDeserializationContext.instantiationException(this._calendarClass, paramJsonParser);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$CalendarDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */