package org.codehaus.jackson.map.module;

import java.util.HashMap;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.type.JavaType;

public class SimpleDeserializers
  implements Deserializers
{
  protected HashMap<ClassKey, JsonDeserializer<?>> _classMappings = null;
  
  public <T> void addDeserializer(Class<T> paramClass, JsonDeserializer<? extends T> paramJsonDeserializer)
  {
    paramClass = new ClassKey(paramClass);
    if (this._classMappings == null) {
      this._classMappings = new HashMap();
    }
    this._classMappings.put(paramClass, paramJsonDeserializer);
  }
  
  public JsonDeserializer<?> findArrayDeserializer(ArrayType paramArrayType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramArrayType = null;; paramArrayType = (JsonDeserializer)this._classMappings.get(new ClassKey(paramArrayType.getRawClass()))) {
      return paramArrayType;
    }
  }
  
  public JsonDeserializer<?> findBeanDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramJavaType = null;; paramJavaType = (JsonDeserializer)this._classMappings.get(new ClassKey(paramJavaType.getRawClass()))) {
      return paramJavaType;
    }
  }
  
  public JsonDeserializer<?> findCollectionDeserializer(CollectionType paramCollectionType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramCollectionType = null;; paramCollectionType = (JsonDeserializer)this._classMappings.get(new ClassKey(paramCollectionType.getRawClass()))) {
      return paramCollectionType;
    }
  }
  
  public JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType paramCollectionLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramCollectionLikeType = null;; paramCollectionLikeType = (JsonDeserializer)this._classMappings.get(new ClassKey(paramCollectionLikeType.getRawClass()))) {
      return paramCollectionLikeType;
    }
  }
  
  public JsonDeserializer<?> findEnumDeserializer(Class<?> paramClass, DeserializationConfig paramDeserializationConfig, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramClass = null;; paramClass = (JsonDeserializer)this._classMappings.get(new ClassKey(paramClass))) {
      return paramClass;
    }
  }
  
  public JsonDeserializer<?> findMapDeserializer(MapType paramMapType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramMapType = null;; paramMapType = (JsonDeserializer)this._classMappings.get(new ClassKey(paramMapType.getRawClass()))) {
      return paramMapType;
    }
  }
  
  public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType paramMapLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanDescription paramBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramMapLikeType = null;; paramMapLikeType = (JsonDeserializer)this._classMappings.get(new ClassKey(paramMapLikeType.getRawClass()))) {
      return paramMapLikeType;
    }
  }
  
  public JsonDeserializer<?> findTreeNodeDeserializer(Class<? extends JsonNode> paramClass, DeserializationConfig paramDeserializationConfig, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (this._classMappings == null) {}
    for (paramClass = null;; paramClass = (JsonDeserializer)this._classMappings.get(new ClassKey(paramClass))) {
      return paramClass;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\module\SimpleDeserializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */