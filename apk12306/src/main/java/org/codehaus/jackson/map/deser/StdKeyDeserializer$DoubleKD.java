package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

final class StdKeyDeserializer$DoubleKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$DoubleKD()
  {
    super(Double.class);
  }
  
  public Double _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    return Double.valueOf(_parseDouble(paramString));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$DoubleKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */