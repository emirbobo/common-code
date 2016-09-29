package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import org.codehaus.jackson.map.DeserializationContext;

final class StdKeyDeserializer$StringCtorKeyDeserializer
  extends StdKeyDeserializer
{
  final Constructor<?> _ctor;
  
  public StdKeyDeserializer$StringCtorKeyDeserializer(Constructor<?> paramConstructor)
  {
    super(paramConstructor.getDeclaringClass());
    this._ctor = paramConstructor;
  }
  
  public Object _parse(String paramString, DeserializationContext paramDeserializationContext)
    throws Exception
  {
    return this._ctor.newInstance(new Object[] { paramString });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdKeyDeserializer$StringCtorKeyDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */