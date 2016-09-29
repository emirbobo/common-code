package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.ContextualDeserializer;
import org.codehaus.jackson.map.ContextualKeyDeserializer;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class StdDeserializerProvider
  extends DeserializerProvider
{
  static final HashMap<JavaType, KeyDeserializer> _keyDeserializers = ;
  protected final ConcurrentHashMap<JavaType, JsonDeserializer<Object>> _cachedDeserializers = new ConcurrentHashMap(64, 0.75F, 2);
  protected DeserializerFactory _factory;
  protected final HashMap<JavaType, JsonDeserializer<Object>> _incompleteDeserializers = new HashMap(8);
  
  public StdDeserializerProvider()
  {
    this(BeanDeserializerFactory.instance);
  }
  
  public StdDeserializerProvider(DeserializerFactory paramDeserializerFactory)
  {
    this._factory = paramDeserializerFactory;
  }
  
  protected JsonDeserializer<Object> _createAndCache2(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    try
    {
      paramBeanProperty = _createDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
      if (paramBeanProperty == null)
      {
        paramDeserializationConfig = null;
        return paramDeserializationConfig;
      }
    }
    catch (IllegalArgumentException paramDeserializationConfig)
    {
      throw new JsonMappingException(paramDeserializationConfig.getMessage(), null, paramDeserializationConfig);
    }
    boolean bool3 = paramBeanProperty instanceof ResolvableDeserializer;
    if (paramBeanProperty.getClass() == BeanDeserializer.class) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.USE_ANNOTATIONS))
        {
          Object localObject = paramDeserializationConfig.getAnnotationIntrospector();
          localObject = ((AnnotationIntrospector)localObject).findCachability(AnnotatedClass.construct(paramBeanProperty.getClass(), (AnnotationIntrospector)localObject, null));
          bool2 = bool1;
          if (localObject != null) {
            bool2 = ((Boolean)localObject).booleanValue();
          }
        }
      }
      if (bool3)
      {
        this._incompleteDeserializers.put(paramJavaType, paramBeanProperty);
        _resolveDeserializer(paramDeserializationConfig, (ResolvableDeserializer)paramBeanProperty);
        this._incompleteDeserializers.remove(paramJavaType);
      }
      paramDeserializationConfig = paramBeanProperty;
      if (!bool2) {
        break;
      }
      this._cachedDeserializers.put(paramJavaType, paramBeanProperty);
      paramDeserializationConfig = paramBeanProperty;
      break;
    }
  }
  
  protected JsonDeserializer<Object> _createAndCacheValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    synchronized (this._incompleteDeserializers)
    {
      JsonDeserializer localJsonDeserializer = _findCachedDeserializer(paramJavaType);
      if (localJsonDeserializer != null)
      {
        paramDeserializationConfig = localJsonDeserializer;
        return paramDeserializationConfig;
      }
      i = this._incompleteDeserializers.size();
      if (i > 0)
      {
        localJsonDeserializer = (JsonDeserializer)this._incompleteDeserializers.get(paramJavaType);
        if (localJsonDeserializer != null) {
          paramDeserializationConfig = localJsonDeserializer;
        }
      }
    }
  }
  
  protected JsonDeserializer<Object> _createDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (paramJavaType.isEnumType()) {
      paramDeserializationConfig = this._factory.createEnumDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
    }
    for (;;)
    {
      return paramDeserializationConfig;
      if (paramJavaType.isContainerType())
      {
        if (paramJavaType.isArrayType())
        {
          paramDeserializationConfig = this._factory.createArrayDeserializer(paramDeserializationConfig, this, (ArrayType)paramJavaType, paramBeanProperty);
          continue;
        }
        if (paramJavaType.isMapLikeType())
        {
          paramJavaType = (MapLikeType)paramJavaType;
          if (paramJavaType.isTrueMapType())
          {
            paramDeserializationConfig = this._factory.createMapDeserializer(paramDeserializationConfig, this, (MapType)paramJavaType, paramBeanProperty);
            continue;
          }
          paramDeserializationConfig = this._factory.createMapLikeDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
          continue;
        }
        if (paramJavaType.isCollectionLikeType())
        {
          paramJavaType = (CollectionLikeType)paramJavaType;
          if (paramJavaType.isTrueCollectionType())
          {
            paramDeserializationConfig = this._factory.createCollectionDeserializer(paramDeserializationConfig, this, (CollectionType)paramJavaType, paramBeanProperty);
            continue;
          }
          paramDeserializationConfig = this._factory.createCollectionLikeDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
          continue;
        }
      }
      if (JsonNode.class.isAssignableFrom(paramJavaType.getRawClass())) {
        paramDeserializationConfig = this._factory.createTreeDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
      } else {
        paramDeserializationConfig = this._factory.createBeanDeserializer(paramDeserializationConfig, this, paramJavaType, paramBeanProperty);
      }
    }
  }
  
  protected JsonDeserializer<Object> _findCachedDeserializer(JavaType paramJavaType)
  {
    return (JsonDeserializer)this._cachedDeserializers.get(paramJavaType);
  }
  
  protected KeyDeserializer _handleUnknownKeyDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    throw new JsonMappingException("Can not find a (Map) Key deserializer for type " + paramJavaType);
  }
  
  protected JsonDeserializer<Object> _handleUnknownValueDeserializer(JavaType paramJavaType)
    throws JsonMappingException
  {
    if (!ClassUtil.isConcrete(paramJavaType.getRawClass())) {
      throw new JsonMappingException("Can not find a Value deserializer for abstract type " + paramJavaType);
    }
    throw new JsonMappingException("Can not find a Value deserializer for type " + paramJavaType);
  }
  
  protected void _resolveDeserializer(DeserializationConfig paramDeserializationConfig, ResolvableDeserializer paramResolvableDeserializer)
    throws JsonMappingException
  {
    paramResolvableDeserializer.resolve(paramDeserializationConfig, this);
  }
  
  public int cachedDeserializersCount()
  {
    return this._cachedDeserializers.size();
  }
  
  public KeyDeserializer findKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    KeyDeserializer localKeyDeserializer1 = this._factory.createKeyDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    Object localObject;
    if (localKeyDeserializer1 == null)
    {
      localObject = paramJavaType.getRawClass();
      if ((localObject == String.class) || (localObject == Object.class)) {
        localObject = null;
      }
    }
    for (;;)
    {
      return (KeyDeserializer)localObject;
      KeyDeserializer localKeyDeserializer2 = (KeyDeserializer)_keyDeserializers.get(paramJavaType);
      localObject = localKeyDeserializer2;
      if (localKeyDeserializer2 == null) {
        if (paramJavaType.isEnumType())
        {
          localObject = StdKeyDeserializers.constructEnumKeyDeserializer(paramDeserializationConfig, paramJavaType);
        }
        else
        {
          localKeyDeserializer2 = StdKeyDeserializers.findStringBasedKeyDeserializer(paramDeserializationConfig, paramJavaType);
          localObject = localKeyDeserializer2;
          if (localKeyDeserializer2 == null) {
            if (localKeyDeserializer1 == null)
            {
              localObject = _handleUnknownKeyDeserializer(paramJavaType);
            }
            else
            {
              paramJavaType = localKeyDeserializer1;
              if ((localKeyDeserializer1 instanceof ContextualKeyDeserializer)) {
                paramJavaType = ((ContextualKeyDeserializer)localKeyDeserializer1).createContextual(paramDeserializationConfig, paramBeanProperty);
              }
              localObject = paramJavaType;
            }
          }
        }
      }
    }
  }
  
  public JsonDeserializer<Object> findTypedValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    JsonDeserializer localJsonDeserializer = findValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    paramJavaType = this._factory.findTypeDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
    paramDeserializationConfig = localJsonDeserializer;
    if (paramJavaType != null) {
      paramDeserializationConfig = new WrappedDeserializer(paramJavaType, localJsonDeserializer);
    }
    return paramDeserializationConfig;
  }
  
  public JsonDeserializer<Object> findValueDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = _findCachedDeserializer(paramJavaType);
    if (localObject != null)
    {
      paramJavaType = (JavaType)localObject;
      if ((localObject instanceof ContextualDeserializer)) {
        paramJavaType = ((ContextualDeserializer)localObject).createContextual(paramDeserializationConfig, paramBeanProperty);
      }
    }
    for (;;)
    {
      return paramJavaType;
      JsonDeserializer localJsonDeserializer = _createAndCacheValueDeserializer(paramDeserializationConfig, paramJavaType, paramBeanProperty);
      localObject = localJsonDeserializer;
      if (localJsonDeserializer == null) {
        localObject = _handleUnknownValueDeserializer(paramJavaType);
      }
      paramJavaType = (JavaType)localObject;
      if ((localObject instanceof ContextualDeserializer)) {
        paramJavaType = ((ContextualDeserializer)localObject).createContextual(paramDeserializationConfig, paramBeanProperty);
      }
    }
  }
  
  public void flushCachedDeserializers()
  {
    this._cachedDeserializers.clear();
  }
  
  public boolean hasValueDeserializerFor(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
  {
    boolean bool = false;
    JsonDeserializer localJsonDeserializer2 = _findCachedDeserializer(paramJavaType);
    JsonDeserializer localJsonDeserializer1 = localJsonDeserializer2;
    if (localJsonDeserializer2 == null) {}
    try
    {
      localJsonDeserializer1 = _createAndCacheValueDeserializer(paramDeserializationConfig, paramJavaType, null);
      if (localJsonDeserializer1 != null) {
        bool = true;
      }
    }
    catch (Exception paramDeserializationConfig)
    {
      for (;;) {}
    }
    return bool;
  }
  
  public DeserializerProvider withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
  {
    this._factory = this._factory.withAbstractTypeResolver(paramAbstractTypeResolver);
    return this;
  }
  
  public DeserializerProvider withAdditionalDeserializers(Deserializers paramDeserializers)
  {
    this._factory = this._factory.withAdditionalDeserializers(paramDeserializers);
    return this;
  }
  
  public DeserializerProvider withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
  {
    this._factory = this._factory.withAdditionalKeyDeserializers(paramKeyDeserializers);
    return this;
  }
  
  public DeserializerProvider withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
  {
    this._factory = this._factory.withDeserializerModifier(paramBeanDeserializerModifier);
    return this;
  }
  
  protected static final class WrappedDeserializer
    extends JsonDeserializer<Object>
  {
    final JsonDeserializer<Object> _deserializer;
    final TypeDeserializer _typeDeserializer;
    
    public WrappedDeserializer(TypeDeserializer paramTypeDeserializer, JsonDeserializer<Object> paramJsonDeserializer)
    {
      this._typeDeserializer = paramTypeDeserializer;
      this._deserializer = paramJsonDeserializer;
    }
    
    public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
      throws IOException, JsonProcessingException
    {
      return this._deserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, this._typeDeserializer);
    }
    
    public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
      throws IOException, JsonProcessingException
    {
      throw new IllegalStateException("Type-wrapped deserializer's deserializeWithType should never get called");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializerProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */