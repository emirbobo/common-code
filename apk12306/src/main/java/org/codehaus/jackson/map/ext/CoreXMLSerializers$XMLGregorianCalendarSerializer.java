package org.codehaus.jackson.map.ext;

import java.io.IOException;
import java.lang.reflect.Type;
import javax.xml.datatype.XMLGregorianCalendar;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.codehaus.jackson.map.ser.StdSerializers.CalendarSerializer;

public class CoreXMLSerializers$XMLGregorianCalendarSerializer
  extends SerializerBase<XMLGregorianCalendar>
{
  public CoreXMLSerializers$XMLGregorianCalendarSerializer()
  {
    super(XMLGregorianCalendar.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    return StdSerializers.CalendarSerializer.instance.getSchema(paramSerializerProvider, paramType);
  }
  
  public void serialize(XMLGregorianCalendar paramXMLGregorianCalendar, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    StdSerializers.CalendarSerializer.instance.serialize(paramXMLGregorianCalendar.toGregorianCalendar(), paramJsonGenerator, paramSerializerProvider);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\CoreXMLSerializers$XMLGregorianCalendarSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */