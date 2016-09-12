package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

final class StdKeyDeserializer$FloatKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$FloatKD()
  {
    super(Float.class);
  }
  
  public Float _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    return Float.valueOf((float)_parseDouble(paramString));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$FloatKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */