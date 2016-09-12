package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.util.List;
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
public class ContainerSerializers$IndexedListSerializer
  extends ContainerSerializers.AsArraySerializer<List<?>>
{
  public ContainerSerializers$IndexedListSerializer(JavaType paramJavaType, boolean paramBoolean, TypeSerializer paramTypeSerializer, BeanProperty paramBeanProperty, JsonSerializer<Object> paramJsonSerializer)
  {
    super(List.class, paramJavaType, paramBoolean, paramTypeSerializer, paramBeanProperty, paramJsonSerializer);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\ContainerSerializers$IndexedListSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */