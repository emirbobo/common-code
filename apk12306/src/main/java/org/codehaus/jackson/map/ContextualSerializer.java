package org.codehaus.jackson.map;

public abstract interface ContextualSerializer<T>
{
  public abstract JsonSerializer<T> createContextual(SerializationConfig paramSerializationConfig, BeanProperty paramBeanProperty)
    throws JsonMappingException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ContextualSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */