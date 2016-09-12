package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public final class ContainerSerializers
{
  public static ContainerSerializerBase<?> collectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    return new CollectionSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  public static JsonSerializer<?> enumSetSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    return new EnumSetSerializer(paramJavaType, paramBeanProperty);
  }
  
  public static ContainerSerializerBase<?> indexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    return new IndexedListSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
  }
  
  public static ContainerSerializerBase<?> iterableSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    return new IterableSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty);
  }
  
  public static ContainerSerializerBase<?> iteratorSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    return new IteratorSerializer(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty);
  }
  
  public static abstract class AsArraySerializer<T>
    extends ContainerSerializerBase<T>
    implements ResolvableSerializer
  {
    protected PropertySerializerMap _dynamicSerializers;
    protected JsonSerializer<Object> _elementSerializer;
    protected final JavaType _elementType;
    protected final BeanProperty _property;
    protected final boolean _staticTyping;
    protected final TypeSerializer _valueTypeSerializer;
    
    @Deprecated
    protected AsArraySerializer(Class<?> paramClass, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
    {
      this(paramClass, paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, null);
    }
    
    protected AsArraySerializer(Class<?> paramClass, JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
    {
      super(false);
      this._elementType = paramJavaType;
      if (!paramBoolean)
      {
        paramBoolean = bool;
        if (paramJavaType != null)
        {
          paramBoolean = bool;
          if (!paramJavaType.isFinal()) {}
        }
      }
      else
      {
        paramBoolean = true;
      }
      this._staticTyping = paramBoolean;
      this._valueTypeSerializer = paramTypeSerializer;
      this._property = paramBeanProperty;
      this._elementSerializer = paramJsonSerializer;
      this._dynamicSerializers = PropertySerializerMap.emptyMap();
    }
    
    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, SerializerProvider paramSerializerProvider)
      throws JsonMappingException
    {
      paramClass = paramPropertySerializerMap.findAndAddSerializer(paramClass, paramSerializerProvider, this._property);
      if (paramPropertySerializerMap != paramClass.map) {
        this._dynamicSerializers = paramClass.map;
      }
      return paramClass.serializer;
    }
    
    protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, JavaType paramJavaType, SerializerProvider paramSerializerProvider)
      throws JsonMappingException
    {
      paramJavaType = paramPropertySerializerMap.findAndAddSerializer(paramJavaType, paramSerializerProvider, this._property);
      if (paramPropertySerializerMap != paramJavaType.map) {
        this._dynamicSerializers = paramJavaType.map;
      }
      return paramJavaType.serializer;
    }
    
    public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
      throws JsonMappingException
    {
      ObjectNode localObjectNode = createSchemaNode("array", true);
      Object localObject1 = null;
      if (paramType != null)
      {
        localObject2 = paramSerializerProvider.constructType(paramType).getContentType();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if ((paramType instanceof ParameterizedType))
          {
            paramType = ((ParameterizedType)paramType).getActualTypeArguments();
            localObject1 = localObject2;
            if (paramType.length == 1) {
              localObject1 = paramSerializerProvider.constructType(paramType[0]);
            }
          }
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = localObject1;
        if (this._elementType != null) {
          localObject2 = this._elementType;
        }
      }
      if (localObject2 != null)
      {
        localObject1 = null;
        paramType = (Type)localObject1;
        if (((JavaType)localObject2).getRawClass() != Object.class)
        {
          localObject2 = paramSerializerProvider.findValueSerializer((JavaType)localObject2, this._property);
          paramType = (Type)localObject1;
          if ((localObject2 instanceof SchemaAware)) {
            paramType = ((SchemaAware)localObject2).getSchema(paramSerializerProvider, null);
          }
        }
        paramSerializerProvider = paramType;
        if (paramType == null) {
          paramSerializerProvider = JsonSchema.getDefaultSchemaNode();
        }
        localObjectNode.put("items", paramSerializerProvider);
      }
      return localObjectNode;
    }
    
    public void resolve(SerializerProvider paramSerializerProvider)
      throws JsonMappingException
    {
      if ((this._staticTyping) && (this._elementType != null) && (this._elementSerializer == null)) {
        this._elementSerializer = paramSerializerProvider.findValueSerializer(this._elementType, this._property);
      }
    }
    
    public final void serialize(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      paramJsonGenerator.writeStartArray();
      serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
      paramJsonGenerator.writeEndArray();
    }
    
    protected abstract void serializeContents(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException;
    
    public final void serializeWithType(T paramT, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
      throws IOException, JsonGenerationException
    {
      paramTypeSerializer.writeTypePrefixForArray(paramT, paramJsonGenerator);
      serializeContents(paramT, paramJsonGenerator, paramSerializerProvider);
      paramTypeSerializer.writeTypeSuffixForArray(paramT, paramJsonGenerator);
    }
  }
  
  @JacksonStdImpl
  public static class CollectionSerializer
    extends ContainerSerializers.AsArraySerializer<Collection<?>>
  {
    @Deprecated
    public CollectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
    {
      this(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, null);
    }
    
    public CollectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
    {
      super(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
    }
    
    public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
    {
      return new CollectionSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property);
    }
    
    public void serializeContents(Collection<?> paramCollection, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      if (this._elementSerializer != null) {
        serializeContentsUsing(paramCollection, paramJsonGenerator, paramSerializerProvider, this._elementSerializer);
      }
      Iterator localIterator;
      do
      {
        return;
        localIterator = paramCollection.iterator();
      } while (!localIterator.hasNext());
      Object localObject2 = this._dynamicSerializers;
      TypeSerializer localTypeSerializer = this._valueTypeSerializer;
      int i = 0;
      label52:
      int j = i;
      for (;;)
      {
        Object localObject4;
        Class localClass;
        Object localObject3;
        try
        {
          localObject4 = localIterator.next();
          if (localObject4 == null)
          {
            j = i;
            paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
            localObject1 = localObject2;
            j = i + 1;
            i = j;
            localObject2 = localObject1;
            if (localIterator.hasNext()) {
              break label52;
            }
            break;
          }
          j = i;
          localClass = localObject4.getClass();
          j = i;
          JsonSerializer localJsonSerializer = ((PropertySerializerMap)localObject2).serializerFor(localClass);
          localObject3 = localJsonSerializer;
          Object localObject1 = localObject2;
          if (localJsonSerializer == null)
          {
            j = i;
            if (this._elementType.hasGenericTypes())
            {
              j = i;
              localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, this._elementType.forcedNarrowBy(localClass), paramSerializerProvider);
              j = i;
              localObject1 = this._dynamicSerializers;
              localObject3 = localObject2;
            }
          }
          else
          {
            if (localTypeSerializer != null) {
              break label249;
            }
            j = i;
            ((JsonSerializer)localObject3).serialize(localObject4, paramJsonGenerator, paramSerializerProvider);
            continue;
          }
        }
        catch (Exception paramJsonGenerator)
        {
          wrapAndThrow(paramSerializerProvider, paramJsonGenerator, paramCollection, j);
        }
        j = i;
        localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, localClass, paramSerializerProvider);
        continue;
        label249:
        j = i;
        ((JsonSerializer)localObject3).serializeWithType(localObject4, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
      }
    }
    
    public void serializeContentsUsing(Collection<?> paramCollection, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, JsonSerializer<Object> paramJsonSerializer)
      throws IOException, JsonGenerationException
    {
      Iterator localIterator = paramCollection.iterator();
      TypeSerializer localTypeSerializer;
      int i;
      if (localIterator.hasNext())
      {
        localTypeSerializer = this._valueTypeSerializer;
        i = 0;
      }
      for (;;)
      {
        Object localObject = localIterator.next();
        if (localObject == null) {}
        try
        {
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
          for (;;)
          {
            i++;
            if (localIterator.hasNext()) {
              break;
            }
            return;
            if (localTypeSerializer != null) {
              break label92;
            }
            paramJsonSerializer.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            wrapAndThrow(paramSerializerProvider, localException, paramCollection, i);
            continue;
            label92:
            paramJsonSerializer.serializeWithType(localException, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
          }
        }
      }
    }
  }
  
  public static class EnumSetSerializer
    extends ContainerSerializers.AsArraySerializer<EnumSet<? extends Enum<?>>>
  {
    public EnumSetSerializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
    {
      super(paramJavaType, true, null, paramBeanProperty);
    }
    
    public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
    {
      return this;
    }
    
    public void serializeContents(EnumSet<? extends Enum<?>> paramEnumSet, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      Object localObject = this._elementSerializer;
      Iterator localIterator = paramEnumSet.iterator();
      for (paramEnumSet = (EnumSet<? extends Enum<?>>)localObject; localIterator.hasNext(); paramEnumSet = (EnumSet<? extends Enum<?>>)localObject)
      {
        Enum localEnum = (Enum)localIterator.next();
        localObject = paramEnumSet;
        if (paramEnumSet == null) {
          localObject = paramSerializerProvider.findValueSerializer(localEnum.getDeclaringClass(), this._property);
        }
        ((JsonSerializer)localObject).serialize(localEnum, paramJsonGenerator, paramSerializerProvider);
      }
    }
  }
  
  @JacksonStdImpl
  public static class IndexedListSerializer
    extends ContainerSerializers.AsArraySerializer<List<?>>
  {
    public IndexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
    {
      super(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
    }
    
    public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
    {
      return new IndexedListSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property, this._elementSerializer);
    }
    
    public void serializeContents(List<?> paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      if (this._elementSerializer != null) {
        serializeContentsUsing(paramList, paramJsonGenerator, paramSerializerProvider, this._elementSerializer);
      }
      int k;
      do
      {
        for (;;)
        {
          return;
          if (this._valueTypeSerializer == null) {
            break;
          }
          serializeTypedContents(paramList, paramJsonGenerator, paramSerializerProvider);
        }
        k = paramList.size();
      } while (k == 0);
      int j = 0;
      int i = 0;
      for (;;)
      {
        Class localClass;
        try
        {
          localObject2 = this._dynamicSerializers;
          if (i >= k) {
            break;
          }
          j = i;
          Object localObject4 = paramList.get(i);
          if (localObject4 == null)
          {
            j = i;
            paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
            localObject1 = localObject2;
            i++;
            localObject2 = localObject1;
            continue;
          }
          j = i;
          localClass = localObject4.getClass();
          j = i;
          JsonSerializer localJsonSerializer = ((PropertySerializerMap)localObject2).serializerFor(localClass);
          Object localObject3 = localJsonSerializer;
          Object localObject1 = localObject2;
          if (localJsonSerializer == null)
          {
            j = i;
            if (this._elementType.hasGenericTypes())
            {
              j = i;
              localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, this._elementType.forcedNarrowBy(localClass), paramSerializerProvider);
              j = i;
              localObject1 = this._dynamicSerializers;
              localObject3 = localObject2;
            }
          }
          else
          {
            j = i;
            ((JsonSerializer)localObject3).serialize(localObject4, paramJsonGenerator, paramSerializerProvider);
            continue;
          }
        }
        catch (Exception paramJsonGenerator)
        {
          wrapAndThrow(paramSerializerProvider, paramJsonGenerator, paramList, j);
        }
        j = i;
        Object localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, localClass, paramSerializerProvider);
      }
    }
    
    public void serializeContentsUsing(List<?> paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, JsonSerializer<Object> paramJsonSerializer)
      throws IOException, JsonGenerationException
    {
      int j = paramList.size();
      if (j == 0) {
        return;
      }
      TypeSerializer localTypeSerializer = this._valueTypeSerializer;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramList.get(i);
        if (localObject == null) {}
        try
        {
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
          for (;;)
          {
            i++;
            break;
            if (localTypeSerializer != null) {
              break label88;
            }
            paramJsonSerializer.serialize(localObject, paramJsonGenerator, paramSerializerProvider);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            wrapAndThrow(paramSerializerProvider, localException, paramList, i);
            continue;
            label88:
            paramJsonSerializer.serializeWithType(localException, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
          }
        }
      }
    }
    
    public void serializeTypedContents(List<?> paramList, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      int m = paramList.size();
      if (m == 0) {
        return;
      }
      int k = 0;
      int i = 0;
      int j = k;
      for (;;)
      {
        Class localClass;
        try
        {
          TypeSerializer localTypeSerializer = this._valueTypeSerializer;
          j = k;
          localObject2 = this._dynamicSerializers;
          if (i >= m) {
            break;
          }
          j = i;
          Object localObject4 = paramList.get(i);
          if (localObject4 == null)
          {
            j = i;
            paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
            localObject1 = localObject2;
            i++;
            localObject2 = localObject1;
            continue;
          }
          j = i;
          localClass = localObject4.getClass();
          j = i;
          JsonSerializer localJsonSerializer = ((PropertySerializerMap)localObject2).serializerFor(localClass);
          Object localObject3 = localJsonSerializer;
          Object localObject1 = localObject2;
          if (localJsonSerializer == null)
          {
            j = i;
            if (this._elementType.hasGenericTypes())
            {
              j = i;
              localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, this._elementType.forcedNarrowBy(localClass), paramSerializerProvider);
              j = i;
              localObject1 = this._dynamicSerializers;
              localObject3 = localObject2;
            }
          }
          else
          {
            j = i;
            ((JsonSerializer)localObject3).serializeWithType(localObject4, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
            continue;
          }
        }
        catch (Exception paramJsonGenerator)
        {
          wrapAndThrow(paramSerializerProvider, paramJsonGenerator, paramList, j);
        }
        j = i;
        Object localObject2 = _findAndAddDynamic((PropertySerializerMap)localObject2, localClass, paramSerializerProvider);
      }
    }
  }
  
  @JacksonStdImpl
  public static class IterableSerializer
    extends ContainerSerializers.AsArraySerializer<Iterable<?>>
  {
    public IterableSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
    {
      super(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty);
    }
    
    public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
    {
      return new IterableSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property);
    }
    
    public void serializeContents(Iterable<?> paramIterable, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      Iterator localIterator = paramIterable.iterator();
      TypeSerializer localTypeSerializer;
      Object localObject1;
      if (localIterator.hasNext())
      {
        localTypeSerializer = this._valueTypeSerializer;
        paramIterable = null;
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject3 = localIterator.next();
        if (localObject3 == null) {
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        }
        while (!localIterator.hasNext())
        {
          return;
          Class localClass = localObject3.getClass();
          Object localObject2;
          if (localClass == localObject1) {
            localObject2 = paramIterable;
          }
          for (;;)
          {
            if (localTypeSerializer != null) {
              break label115;
            }
            ((JsonSerializer)localObject2).serialize(localObject3, paramJsonGenerator, paramSerializerProvider);
            break;
            localObject2 = paramSerializerProvider.findValueSerializer(localClass, this._property);
            paramIterable = (Iterable<?>)localObject2;
            localObject1 = localClass;
          }
          label115:
          ((JsonSerializer)localObject2).serializeWithType(localObject3, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
        }
      }
    }
  }
  
  @JacksonStdImpl
  public static class IteratorSerializer
    extends ContainerSerializers.AsArraySerializer<Iterator<?>>
  {
    public IteratorSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
    {
      super(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty);
    }
    
    public ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer paramTypeSerializer)
    {
      return new IteratorSerializer(this._elementType, this._staticTyping, paramTypeSerializer, this._property);
    }
    
    public void serializeContents(Iterator<?> paramIterator, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
      throws IOException, JsonGenerationException
    {
      TypeSerializer localTypeSerializer;
      Object localObject1;
      Object localObject2;
      if (paramIterator.hasNext())
      {
        localTypeSerializer = this._valueTypeSerializer;
        localObject1 = null;
        localObject2 = null;
      }
      for (;;)
      {
        Object localObject4 = paramIterator.next();
        if (localObject4 == null) {
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
        }
        while (!paramIterator.hasNext())
        {
          return;
          Class localClass = localObject4.getClass();
          Object localObject3;
          if (localClass == localObject2) {
            localObject3 = localObject1;
          }
          for (;;)
          {
            if (localTypeSerializer != null) {
              break label107;
            }
            ((JsonSerializer)localObject3).serialize(localObject4, paramJsonGenerator, paramSerializerProvider);
            break;
            localObject3 = paramSerializerProvider.findValueSerializer(localClass, this._property);
            localObject1 = localObject3;
            localObject2 = localClass;
          }
          label107:
          ((JsonSerializer)localObject3).serializeWithType(localObject4, paramJsonGenerator, paramSerializerProvider, localTypeSerializer);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\ContainerSerializers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */