package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonProcessingException;

final class PropertyValue$Regular
  extends PropertyValue
{
  final SettableBeanProperty _property;
  
  public PropertyValue$Regular(PropertyValue paramPropertyValue, Object paramObject, SettableBeanProperty paramSettableBeanProperty)
  {
    super(paramPropertyValue, paramObject);
    this._property = paramSettableBeanProperty;
  }
  
  public void assign(Object paramObject)
    throws IOException, JsonProcessingException
  {
    this._property.set(paramObject, this.value);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\PropertyValue$Regular.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */