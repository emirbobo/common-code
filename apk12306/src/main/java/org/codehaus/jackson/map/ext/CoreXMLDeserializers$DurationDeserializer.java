package org.codehaus.jackson.map.ext;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.FromStringDeserializer;

public class CoreXMLDeserializers$DurationDeserializer
  extends FromStringDeserializer<Duration>
{
  public CoreXMLDeserializers$DurationDeserializer()
  {
    super(Duration.class);
  }
  
  protected Duration _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return CoreXMLDeserializers._dataTypeFactory.newDuration(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\CoreXMLDeserializers$DurationDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */