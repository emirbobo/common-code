package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonProcessingException;

final class PropertyValue$Any
  extends PropertyValue
{
  final SettableAnyProperty _property;
  final String _propertyName;
  
  public PropertyValue$Any(PropertyValue paramPropertyValue, Object paramObject, SettableAnyProperty paramSettableAnyProperty, String paramString)
  {
    super(paramPropertyValue, paramObject);
    this._property = paramSettableAnyProperty;
    this._propertyName = paramString;
  }
  
  public void assign(Object paramObject)
    throws IOException, JsonProcessingException
  {
    this._property.set(paramObject, this._propertyName, this.value);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\PropertyValue$Any.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */