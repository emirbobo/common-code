package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.Map;
import org.codehaus.jackson.JsonProcessingException;

final class PropertyValue$Map
  extends PropertyValue
{
  final Object _key;
  
  public PropertyValue$Map(PropertyValue paramPropertyValue, Object paramObject1, Object paramObject2)
  {
    super(paramPropertyValue, paramObject1);
    this._key = paramObject2;
  }
  
  public void assign(Object paramObject)
    throws IOException, JsonProcessingException
  {
    ((Map)paramObject).put(this._key, this.value);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\PropertyValue$Map.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */