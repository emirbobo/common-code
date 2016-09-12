package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class PropertySerializerMap$Single
  extends PropertySerializerMap
{
  private final JsonSerializer<Object> _serializer;
  private final Class<?> _type;
  
  public PropertySerializerMap$Single(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    this._type = paramClass;
    this._serializer = paramJsonSerializer;
  }
  
  protected PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    return new PropertySerializerMap.Double(this._type, this._serializer, paramClass, paramJsonSerializer);
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> paramClass)
  {
    if (paramClass == this._type) {}
    for (paramClass = this._serializer;; paramClass = null) {
      return paramClass;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\impl\PropertySerializerMap$Single.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */