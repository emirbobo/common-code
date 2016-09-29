package org.codehaus.jackson.map.ser;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.SerializerFactory.Config;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class CustomSerializerFactory
  extends BeanSerializerFactory
{
  protected HashMap<ClassKey, JsonSerializer<?>> _directClassMappings = null;
  protected JsonSerializer<?> _enumSerializerOverride;
  protected HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings = null;
  protected HashMap<ClassKey, JsonSerializer<?>> _transitiveClassMappings = null;
  
  public CustomSerializerFactory()
  {
    this(null);
  }
  
  public CustomSerializerFactory(SerializerFactory.Config paramConfig)
  {
    super(paramConfig);
  }
  
  protected JsonSerializer<?> _findInterfaceMapping(Class<?> paramClass, ClassKey paramClassKey)
  {
    Class[] arrayOfClass = paramClass.getInterfaces();
    int j = arrayOfClass.length;
    int i = 0;
    Object localObject;
    if (i < j)
    {
      localObject = arrayOfClass[i];
      paramClassKey.reset((Class)localObject);
      paramClass = (JsonSerializer)this._interfaceMappings.get(paramClassKey);
      if (paramClass == null) {}
    }
    for (;;)
    {
      return paramClass;
      localObject = _findInterfaceMapping((Class)localObject, paramClassKey);
      paramClass = (Class<?>)localObject;
      if (localObject == null)
      {
        i++;
        break;
        paramClass = null;
      }
    }
  }
  
  public <T> void addGenericMapping(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    ClassKey localClassKey = new ClassKey(paramClass);
    if (paramClass.isInterface())
    {
      if (this._interfaceMappings == null) {
        this._interfaceMappings = new HashMap();
      }
      this._interfaceMappings.put(localClassKey, paramJsonSerializer);
    }
    for (;;)
    {
      return;
      if (this._transitiveClassMappings == null) {
        this._transitiveClassMappings = new HashMap();
      }
      this._transitiveClassMappings.put(localClassKey, paramJsonSerializer);
    }
  }
  
  public <T> void addSpecificMapping(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    ClassKey localClassKey = new ClassKey(paramClass);
    if (paramClass.isInterface()) {
      throw new IllegalArgumentException("Can not add specific mapping for an interface (" + paramClass.getName() + ")");
    }
    if (Modifier.isAbstract(paramClass.getModifiers())) {
      throw new IllegalArgumentException("Can not add specific mapping for an abstract class (" + paramClass.getName() + ")");
    }
    if (this._directClassMappings == null) {
      this._directClassMappings = new HashMap();
    }
    this._directClassMappings.put(localClassKey, paramJsonSerializer);
  }
  
  public JsonSerializer<Object> createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    JsonSerializer localJsonSerializer = findCustomSerializer(paramJavaType.getRawClass(), paramSerializationConfig);
    if (localJsonSerializer != null) {}
    for (paramSerializationConfig = localJsonSerializer;; paramSerializationConfig = super.createSerializer(paramSerializationConfig, paramJavaType, paramBeanProperty)) {
      return paramSerializationConfig;
    }
  }
  
  protected JsonSerializer<?> findCustomSerializer(Class<?> paramClass, SerializationConfig paramSerializationConfig)
  {
    ClassKey localClassKey = new ClassKey(paramClass);
    if (this._directClassMappings != null)
    {
      paramSerializationConfig = (JsonSerializer)this._directClassMappings.get(localClassKey);
      if (paramSerializationConfig != null) {
        paramClass = paramSerializationConfig;
      }
    }
    for (;;)
    {
      return paramClass;
      if ((paramClass.isEnum()) && (this._enumSerializerOverride != null))
      {
        paramClass = this._enumSerializerOverride;
      }
      else
      {
        if (this._transitiveClassMappings != null) {
          for (paramSerializationConfig = paramClass;; paramSerializationConfig = paramSerializationConfig.getSuperclass())
          {
            if (paramSerializationConfig == null) {
              break label109;
            }
            localClassKey.reset(paramSerializationConfig);
            JsonSerializer localJsonSerializer = (JsonSerializer)this._transitiveClassMappings.get(localClassKey);
            if (localJsonSerializer != null)
            {
              paramClass = localJsonSerializer;
              break;
            }
          }
        }
        label109:
        if (this._interfaceMappings != null)
        {
          localClassKey.reset(paramClass);
          paramSerializationConfig = (JsonSerializer)this._interfaceMappings.get(localClassKey);
          if (paramSerializationConfig != null) {
            paramClass = paramSerializationConfig;
          } else {
            for (;;)
            {
              if (paramClass == null) {
                break label173;
              }
              paramSerializationConfig = _findInterfaceMapping(paramClass, localClassKey);
              if (paramSerializationConfig != null)
              {
                paramClass = paramSerializationConfig;
                break;
              }
              paramClass = paramClass.getSuperclass();
            }
          }
        }
        else
        {
          label173:
          paramClass = null;
        }
      }
    }
  }
  
  public void setEnumSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    this._enumSerializerOverride = paramJsonSerializer;
  }
  
  public SerializerFactory withConfig(SerializerFactory.Config paramConfig)
  {
    if (getClass() != CustomSerializerFactory.class) {
      throw new IllegalStateException("Subtype of CustomSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }
    return new CustomSerializerFactory(paramConfig);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\CustomSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */