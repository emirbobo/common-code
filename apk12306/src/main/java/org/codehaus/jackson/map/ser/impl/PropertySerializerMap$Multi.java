package org.codehaus.jackson.map.ser.impl;

import org.codehaus.jackson.map.JsonSerializer;

final class PropertySerializerMap$Multi
  extends PropertySerializerMap
{
  private static final int MAX_ENTRIES = 8;
  private final PropertySerializerMap.TypeAndSerializer[] _entries;
  
  public PropertySerializerMap$Multi(PropertySerializerMap.TypeAndSerializer[] paramArrayOfTypeAndSerializer)
  {
    this._entries = paramArrayOfTypeAndSerializer;
  }
  
  protected PropertySerializerMap newWith(Class<?> paramClass, JsonSerializer<Object> paramJsonSerializer)
  {
    int i = this._entries.length;
    if (i == 8) {}
    PropertySerializerMap.TypeAndSerializer[] arrayOfTypeAndSerializer;
    for (paramClass = this;; paramClass = new Multi(arrayOfTypeAndSerializer))
    {
      return paramClass;
      arrayOfTypeAndSerializer = new PropertySerializerMap.TypeAndSerializer[i + 1];
      System.arraycopy(this._entries, 0, arrayOfTypeAndSerializer, 0, i);
      arrayOfTypeAndSerializer[i] = new PropertySerializerMap.TypeAndSerializer(paramClass, paramJsonSerializer);
    }
  }
  
  public JsonSerializer<Object> serializerFor(Class<?> paramClass)
  {
    int i = 0;
    int j = this._entries.length;
    PropertySerializerMap.TypeAndSerializer localTypeAndSerializer;
    if (i < j)
    {
      localTypeAndSerializer = this._entries[i];
      if (localTypeAndSerializer.type != paramClass) {}
    }
    for (paramClass = localTypeAndSerializer.serializer;; paramClass = null)
    {
      return paramClass;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\impl\PropertySerializerMap$Multi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */