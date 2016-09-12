package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import java.util.HashMap;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonTypeInfo.As;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;
import org.codehaus.jackson.type.JavaType;

public abstract class TypeDeserializerBase
  extends TypeDeserializer
{
  protected final JavaType _baseType;
  protected final HashMap<String, JsonDeserializer<Object>> _deserializers;
  protected final TypeIdResolver _idResolver;
  protected final BeanProperty _property;
  
  protected TypeDeserializerBase(JavaType paramJavaType, TypeIdResolver paramTypeIdResolver, BeanProperty paramBeanProperty)
  {
    this._baseType = paramJavaType;
    this._idResolver = paramTypeIdResolver;
    this._property = paramBeanProperty;
    this._deserializers = new HashMap();
  }
  
  protected final JsonDeserializer<Object> _findDeserializer(DeserializationContext paramDeserializationContext, String paramString)
    throws IOException, JsonProcessingException
  {
    Object localObject2;
    synchronized (this._deserializers)
    {
      localObject2 = (JsonDeserializer)this._deserializers.get(paramString);
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label131;
      }
      localObject2 = this._idResolver.typeFromId(paramString);
      if (localObject2 == null) {
        throw paramDeserializationContext.unknownTypeException(this._baseType, paramString);
      }
    }
    Object localObject1 = localObject2;
    if (this._baseType != null)
    {
      localObject1 = localObject2;
      if (this._baseType.getClass() == localObject2.getClass()) {
        localObject1 = this._baseType.narrowBy(((JavaType)localObject2).getRawClass());
      }
    }
    localObject1 = paramDeserializationContext.getDeserializerProvider().findValueDeserializer(paramDeserializationContext.getConfig(), (JavaType)localObject1, this._property);
    this._deserializers.put(paramString, localObject1);
    label131:
    return (JsonDeserializer<Object>)localObject1;
  }
  
  public String baseTypeName()
  {
    return this._baseType.getRawClass().getName();
  }
  
  public String getPropertyName()
  {
    return null;
  }
  
  public TypeIdResolver getTypeIdResolver()
  {
    return this._idResolver;
  }
  
  public abstract JsonTypeInfo.As getTypeInclusion();
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[').append(getClass().getName());
    localStringBuilder.append("; base-type:").append(this._baseType);
    localStringBuilder.append("; id-resolver: ").append(this._idResolver);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\jsontype\impl\TypeDeserializerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */