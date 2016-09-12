package org.codehaus.jackson.map.deser;

public abstract class StdDeserializer$PrimitiveOrWrapperDeserializer<T>
  extends StdScalarDeserializer<T>
{
  final T _nullValue;
  
  protected StdDeserializer$PrimitiveOrWrapperDeserializer(Class<T> paramClass, T paramT)
  {
    super(paramClass);
    this._nullValue = paramT;
  }
  
  public final T getNullValue()
  {
    return (T)this._nullValue;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$PrimitiveOrWrapperDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */