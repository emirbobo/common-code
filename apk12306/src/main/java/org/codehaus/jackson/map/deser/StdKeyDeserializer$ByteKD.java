package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

final class StdKeyDeserializer$ByteKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$ByteKD()
  {
    super(Byte.class);
  }
  
  public Byte _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    int i = _parseInt(paramString);
    if ((i < -128) || (i > 127)) {
      throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "overflow, value can not be represented as 8-bit value");
    }
    return Byte.valueOf((byte)i);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$ByteKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */