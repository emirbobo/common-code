package org.codehaus.jackson.map.deser;

import java.lang.reflect.Method;
import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$StringFactoryKeyDeserializer
  extends StdKeyDeserializer
{
  final Method _factoryMethod;
  
  public StdKeyDeserializer$StringFactoryKeyDeserializer(Method paramMethod)
  {
    super(paramMethod.getDeclaringClass());
    this._factoryMethod = paramMethod;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws Exception
  {
    return this._factoryMethod.invoke(null, new Object[] { paramString });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$StringFactoryKeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */