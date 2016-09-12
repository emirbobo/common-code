package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.map.TypeSerializer;

public abstract class ContainerSerializerBase<T>
  extends SerializerBase<T>
{
  protected ContainerSerializerBase(Class<T> paramClass)
  {
    super(paramClass);
  }
  
  protected ContainerSerializerBase(Class<?> paramClass, boolean paramBoolean)
  {
    super(paramClass, paramBoolean);
  }
  
  public abstract ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer);
  
  public ContainerSerializerBase<?> withValueTypeSerializer(TypeSerializer paramTypeSerializer)
  {
    if (paramTypeSerializer == null) {}
    for (paramTypeSerializer = this;; paramTypeSerializer = _withValueTypeSerializer(paramTypeSerializer)) {
      return paramTypeSerializer;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\ContainerSerializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */