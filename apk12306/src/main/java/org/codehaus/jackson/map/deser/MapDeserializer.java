package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class MapDeserializer
  extends ContainerDeserializer<Map<Object, Object>>
  implements ResolvableDeserializer
{
  protected final Constructor<Map<Object, Object>> _defaultCtor;
  protected HashSet<String> _ignorableProperties;
  protected final KeyDeserializer _keyDeserializer;
  protected final JavaType _mapType;
  protected Creator.PropertyBased _propertyBasedCreator;
  protected final JsonDeserializer<Object> _valueDeserializer;
  protected final TypeDeserializer _valueTypeDeserializer;
  
  public MapDeserializer(JavaType paramJavaType, Constructor<Map<Object, Object>> paramConstructor, KeyDeserializer paramKeyDeserializer, JsonDeserializer<Object> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    super(Map.class);
    this._mapType = paramJavaType;
    this._defaultCtor = paramConstructor;
    this._keyDeserializer = paramKeyDeserializer;
    this._valueDeserializer = paramJsonDeserializer;
    this._valueTypeDeserializer = paramTypeDeserializer;
  }
  
  public Map<Object, Object> _deserializeUsingCreator(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Creator.PropertyBased localPropertyBased = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBased.startBuilding(paramJsonParser, paramDeserializationContext);
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    JsonDeserializer localJsonDeserializer = this._valueDeserializer;
    TypeDeserializer localTypeDeserializer = this._valueTypeDeserializer;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject2 = paramJsonParser.getCurrentName();
      localObject1 = paramJsonParser.nextToken();
      if ((this._ignorableProperties != null) && (this._ignorableProperties.contains(localObject2))) {
        paramJsonParser.skipChildren();
      }
      do
      {
        localObject1 = paramJsonParser.nextToken();
        break;
        localObject2 = localPropertyBased.findCreatorProperty((String)localObject2);
        if (localObject2 == null) {
          break label180;
        }
        localObject1 = ((SettableBeanProperty)localObject2).deserialize(paramJsonParser, paramDeserializationContext);
      } while (!localPropertyValueBuffer.assignParameter(((SettableBeanProperty)localObject2).getCreatorIndex(), localObject1));
      paramJsonParser.nextToken();
    }
    for (;;)
    {
      try
      {
        localObject1 = (Map)localPropertyBased.build(localPropertyValueBuffer);
        _readAndBind(paramJsonParser, paramDeserializationContext, (Map)localObject1);
        paramJsonParser = (JsonParser)localObject1;
      }
      catch (Exception paramJsonParser)
      {
        wrapAndThrow(paramJsonParser, this._mapType.getRawClass());
        paramJsonParser = null;
        continue;
      }
      return paramJsonParser;
      label180:
      localObject2 = paramJsonParser.getCurrentName();
      if (this._keyDeserializer == null)
      {
        label193:
        if (localObject1 != JsonToken.VALUE_NULL) {
          break label228;
        }
        localObject1 = null;
      }
      for (;;)
      {
        localPropertyValueBuffer.bufferMapProperty(localObject2, localObject1);
        break;
        localObject2 = this._keyDeserializer.deserializeKey((String)localObject2, paramDeserializationContext);
        break label193;
        label228:
        if (localTypeDeserializer == null) {
          localObject1 = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
        } else {
          localObject1 = localJsonDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
        }
      }
      try
      {
        paramJsonParser = (Map)localPropertyBased.build(localPropertyValueBuffer);
      }
      catch (Exception paramJsonParser)
      {
        wrapAndThrow(paramJsonParser, this._mapType.getRawClass());
        paramJsonParser = null;
      }
    }
  }
  
  protected final void _readAndBind(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Map<Object, Object> paramMap)
    throws IOException, JsonProcessingException
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    KeyDeserializer localKeyDeserializer = this._keyDeserializer;
    JsonDeserializer localJsonDeserializer = this._valueDeserializer;
    TypeDeserializer localTypeDeserializer = this._valueTypeDeserializer;
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject1 = paramJsonParser.getCurrentName();
      if (localKeyDeserializer == null) {}
      JsonToken localJsonToken;
      for (localObject2 = localObject1;; localObject2 = localKeyDeserializer.deserializeKey((String)localObject1, paramDeserializationContext))
      {
        localJsonToken = paramJsonParser.nextToken();
        if ((this._ignorableProperties == null) || (!this._ignorableProperties.contains(localObject1))) {
          break label117;
        }
        paramJsonParser.skipChildren();
        localObject1 = paramJsonParser.nextToken();
        break;
      }
      label117:
      if (localJsonToken == JsonToken.VALUE_NULL) {
        localObject1 = null;
      }
      for (;;)
      {
        paramMap.put(localObject2, localObject1);
        break;
        if (localTypeDeserializer == null) {
          localObject1 = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
        } else {
          localObject1 = localJsonDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
        }
      }
    }
  }
  
  public Map<Object, Object> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject = paramJsonParser.getCurrentToken();
    if ((localObject != JsonToken.START_OBJECT) && (localObject != JsonToken.FIELD_NAME) && (localObject != JsonToken.END_OBJECT)) {
      throw paramDeserializationContext.mappingException(getMapClass());
    }
    if (this._propertyBasedCreator != null) {
      paramJsonParser = _deserializeUsingCreator(paramJsonParser, paramDeserializationContext);
    }
    for (;;)
    {
      return paramJsonParser;
      if (this._defaultCtor == null) {
        throw paramDeserializationContext.instantiationException(getMapClass(), "No default constructor found");
      }
      try
      {
        localObject = (Map)this._defaultCtor.newInstance(new Object[0]);
        _readAndBind(paramJsonParser, paramDeserializationContext, (Map)localObject);
        paramJsonParser = (JsonParser)localObject;
      }
      catch (Exception paramJsonParser)
      {
        throw paramDeserializationContext.instantiationException(getMapClass(), paramJsonParser);
      }
    }
  }
  
  public Map<Object, Object> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Map<Object, Object> paramMap)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if ((localJsonToken != JsonToken.START_OBJECT) && (localJsonToken != JsonToken.FIELD_NAME)) {
      throw paramDeserializationContext.mappingException(getMapClass());
    }
    _readAndBind(paramJsonParser, paramDeserializationContext, paramMap);
    return paramMap;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return this._valueDeserializer;
  }
  
  public JavaType getContentType()
  {
    return this._mapType.getContentType();
  }
  
  public final Class<?> getMapClass()
  {
    return this._mapType.getRawClass();
  }
  
  public JavaType getValueType()
  {
    return this._mapType;
  }
  
  public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
    throws JsonMappingException
  {
    if (this._propertyBasedCreator != null)
    {
      Iterator localIterator = this._propertyBasedCreator.properties().iterator();
      while (localIterator.hasNext())
      {
        SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)localIterator.next();
        localSettableBeanProperty.setValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, localSettableBeanProperty.getType(), localSettableBeanProperty));
      }
    }
  }
  
  public void setCreators(CreatorContainer paramCreatorContainer)
  {
    this._propertyBasedCreator = paramCreatorContainer.propertyBasedCreator();
  }
  
  public void setIgnorableProperties(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    for (paramArrayOfString = null;; paramArrayOfString = ArrayBuilders.arrayToSet(paramArrayOfString))
    {
      this._ignorableProperties = paramArrayOfString;
      return;
    }
  }
  
  protected void wrapAndThrow(Throwable paramThrowable, Object paramObject)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if (((paramThrowable instanceof IOException)) && (!(paramThrowable instanceof JsonMappingException))) {
      throw ((IOException)paramThrowable);
    }
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\MapDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */