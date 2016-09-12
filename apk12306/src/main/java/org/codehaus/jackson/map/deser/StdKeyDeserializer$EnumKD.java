package org.codehaus.jackson.map.deser;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

final class StdKeyDeserializer$EnumKD
  extends StdKeyDeserializer
{
  final EnumResolver<?> _resolver;
  
  StdKeyDeserializer$EnumKD(EnumResolver<?> paramEnumResolver)
  {
    super(paramEnumResolver.getEnumClass());
    this._resolver = paramEnumResolver;
  }
  
  public Enum<?> _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws JsonMappingException
  {
    Enum localEnum = this._resolver.findEnum(paramString);
    if (localEnum == null) {
      throw paramDeserializationContext.weirdKeyException(this._keyClass, paramString, "not one of values for Enum class");
    }
    return localEnum;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$EnumKD.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */