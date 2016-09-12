package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class PropertySerializerMap$Double
  extends PropertySerializerMap
{
  private final JsonSerializer<Object> _serializer1;
  private final JsonSerializer<Object> _serializer2;
  private final Class<?> _type1;
  private final Class<?> _type2;
  
  public PropertySerializerMap$Double(Class<?> paramClass1, JsonSerializer<Object> paramJsonSerializer1, Class<?> paramClass2, JsonSerializer<Object> paramJsonSerializer2)
  {
    this._type1 = paramClass1;
    this._serializer1 = paramJsonSerializer1;
    this._type2 = paramClass2;
    this._serializer2 = paramJsonSerializer2;
  }
  
  protected PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    return new PropertySerializerMap.Multi(new PropertySerializerMap.TypeAndSerializer[] { new PropertySerializerMap.TypeAndSerializer(this._type1, this._serializer1), new PropertySerializerMap.TypeAndSerializer(this._type2, this._serializer2) });
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> paramClass)
  {
    if (paramClass == this._type1) {
      paramClass = this._serializer1;
    }
    for (;;)
    {
      return paramClass;
      if (paramClass == this._type2) {
        paramClass = this._serializer2;
      } else {
        paramClass = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\impl\PropertySerializerMap$Double.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */