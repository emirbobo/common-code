package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

final class StdKeyDeserializer$BoolKD
  extends StdKeyDeserializer
{
  StdKeyDeserializer$BoolKD()
  {
    super(Boolean.class);
  }
  
  public Boolean _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    if ("true".equals(paramString)) {}
    for (paramString = Boolean.TRUE;; paramString = Boolean.FALSE)
    {
      return paramString;
      if (!"false".equals(paramString)) {
        break;
      }
    }
    throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "value not 'true' or 'false'");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$BoolKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */