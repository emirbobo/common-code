package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class ContainerSerializers$CollectionSerializer
  extends ContainerSerializers.AsArraySerializer<Collection<?>>
{
  @Deprecated
  public ContainerSerializers$CollectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty)
  {
    this(paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, null);
  }
  
  public ContainerSerializers$CollectionSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    super(Collection.class, paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\ContainerSerializers$CollectionSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */