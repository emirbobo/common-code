package org.codehaus.jackson.map.module;

import java.util.HashMap;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.type.JavaType;

public class SimpleSerializers
  implements Serializers
{
  protected HashMap<ClassKey, JsonSerializer<?>> _classMappings = null;
  protected HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings = null;
  
  private void _addSerializer(Class<?> paramClass, JsonSerializer<?> paramJsonSerializer)
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
      if (this._classMappings == null) {
        this._classMappings = new HashMap();
      }
      this._classMappings.put(localClassKey, paramJsonSerializer);
    }
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
  
  public <T> void addSerializer(Class<? extends T> paramClass, JsonSerializer<T> paramJsonSerializer)
  {
    _addSerializer(paramClass, paramJsonSerializer);
  }
  
  public void addSerializer(JsonSerializer<?> paramJsonSerializer)
  {
    Class localClass = paramJsonSerializer.handledType();
    if ((localClass == null) || (localClass == Object.class)) {
      throw new IllegalArgumentException("JsonSerializer of type " + paramJsonSerializer.getClass().getName() + " does not define valid handledType() (use alternative registration method?)");
    }
    _addSerializer(localClass, paramJsonSerializer);
  }
  
  public JsonSerializer<?> findArraySerializer(SerializationConfig paramSerializationConfig, ArrayType paramArrayType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramArrayType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer<?> findCollectionLikeSerializer(SerializationConfig paramSerializationConfig, CollectionLikeType paramCollectionLikeType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramCollectionLikeType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer<?> findCollectionSerializer(SerializationConfig paramSerializationConfig, CollectionType paramCollectionType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer)
  {
    return findSerializer(paramSerializationConfig, paramCollectionType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer<?> findMapLikeSerializer(SerializationConfig paramSerializationConfig, MapLikeType paramMapLikeType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
  {
    return findSerializer(paramSerializationConfig, paramMapLikeType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer<?> findMapSerializer(SerializationConfig paramSerializationConfig, MapType paramMapType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer1, TypeSerializer paramTypeSerializer, JsonSerializer<Object> paramJsonSerializer2)
  {
    return findSerializer(paramSerializationConfig, paramMapType, paramBeanDescription, paramBeanProperty);
  }
  
  public JsonSerializer<?> findSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty)
  {
    paramSerializationConfig = paramJavaType.getRawClass();
    paramBeanProperty = new ClassKey(paramSerializationConfig);
    if (paramSerializationConfig.isInterface())
    {
      if (this._interfaceMappings == null) {
        break label121;
      }
      paramJavaType = (JsonSerializer)this._interfaceMappings.get(paramBeanProperty);
      if (paramJavaType == null) {
        break label121;
      }
      paramSerializationConfig = paramJavaType;
    }
    for (;;)
    {
      return paramSerializationConfig;
      if (this._classMappings != null)
      {
        paramJavaType = (JsonSerializer)this._classMappings.get(paramBeanProperty);
        if (paramJavaType != null) {
          paramSerializationConfig = paramJavaType;
        } else {
          for (paramJavaType = paramSerializationConfig;; paramJavaType = paramJavaType.getSuperclass())
          {
            if (paramJavaType == null) {
              break label121;
            }
            paramBeanProperty.reset(paramJavaType);
            paramBeanDescription = (JsonSerializer)this._classMappings.get(paramBeanProperty);
            if (paramBeanDescription != null)
            {
              paramSerializationConfig = paramBeanDescription;
              break;
            }
          }
        }
      }
      else
      {
        label121:
        if (this._interfaceMappings != null)
        {
          paramJavaType = _findInterfaceMapping(paramSerializationConfig, paramBeanProperty);
          if (paramJavaType != null)
          {
            paramSerializationConfig = paramJavaType;
            continue;
          }
          if (!paramSerializationConfig.isInterface())
          {
            do
            {
              paramSerializationConfig = paramSerializationConfig.getSuperclass();
              if (paramSerializationConfig == null) {
                break;
              }
              paramJavaType = _findInterfaceMapping(paramSerializationConfig, paramBeanProperty);
            } while (paramJavaType == null);
            paramSerializationConfig = paramJavaType;
            continue;
          }
        }
        paramSerializationConfig = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\module\SimpleSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */