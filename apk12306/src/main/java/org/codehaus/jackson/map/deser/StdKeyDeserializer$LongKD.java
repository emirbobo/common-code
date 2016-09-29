package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

final class StdKeyDeserializer$LongKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$LongKD()
  {
    super(Long.class);
  }
  
  public Long _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    return Long.valueOf(_parseLong(paramString));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$LongKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */