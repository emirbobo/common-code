package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.TimeZone;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$TimeZoneDeserializer
  extends FromStringDeserializer<TimeZone>
{
  public FromStringDeserializer$TimeZoneDeserializer()
  {
    super(TimeZone.class);
  }
  
  protected TimeZone _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return TimeZone.getTimeZone(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$TimeZoneDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */