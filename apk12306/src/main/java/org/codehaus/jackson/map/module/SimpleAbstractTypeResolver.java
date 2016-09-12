package org.codehaus.jackson.map.module;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class SimpleAbstractTypeResolver
  extends AbstractTypeResolver
{
  protected final HashMap<ClassKey, Class<?>> _mappings = new HashMap();
  
  public <T> SimpleAbstractTypeResolver addMapping(Class<T> paramClass, Class<? extends T> paramClass1)
  {
    if (paramClass == paramClass1) {
      throw new IllegalArgumentException("Can not add mapping from class to itself");
    }
    if (!paramClass.isAssignableFrom(paramClass1)) {
      throw new IllegalArgumentException("Can not add mapping from class " + paramClass.getName() + " to " + paramClass1.getName() + ", as latter is not a subtype of former");
    }
    if (!Modifier.isAbstract(paramClass.getModifiers())) {
      throw new IllegalArgumentException("Can not add mapping from class " + paramClass.getName() + " since it is not abstract");
    }
    this._mappings.put(new ClassKey(paramClass), paramClass1);
    return this;
  }
  
  public JavaType findTypeMapping(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    paramDeserializationConfig = paramJavaType.getRawClass();
    paramDeserializationConfig = (Class)this._mappings.get(new ClassKey(paramDeserializationConfig));
    if (paramDeserializationConfig == null) {}
    for (paramDeserializationConfig = null;; paramDeserializationConfig = paramJavaType.narrowBy(paramDeserializationConfig)) {
      return paramDeserializationConfig;
    }
  }
  
  public JavaType resolveAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    return null;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\module\SimpleAbstractTypeResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */