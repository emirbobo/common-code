package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonMappingException.Reference;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public class BeanSerializer
  extends SerializerBase<Object>
  implements ResolvableSerializer, SchemaAware
{
  protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
  protected final AnyGetterWriter _anyGetterWriter;
  protected final BeanPropertyWriter[] _filteredProps;
  protected final Object _propertyFilterId;
  protected final BeanPropertyWriter[] _props;
  
  public BeanSerializer(Class<?> paramClass, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2, AnyGetterWriter paramAnyGetterWriter, Object paramObject)
  {
    super(paramClass);
    this._props = paramArrayOfBeanPropertyWriter1;
    this._filteredProps = paramArrayOfBeanPropertyWriter2;
    this._anyGetterWriter = paramAnyGetterWriter;
    this._propertyFilterId = paramObject;
  }
  
  protected BeanSerializer(BeanSerializer paramBeanSerializer)
  {
    this(paramBeanSerializer._handledType, paramBeanSerializer._props, paramBeanSerializer._filteredProps, paramBeanSerializer._anyGetterWriter, paramBeanSerializer._propertyFilterId);
  }
  
  public BeanSerializer(JavaType paramJavaType, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter1, BeanPropertyWriter[] paramArrayOfBeanPropertyWriter2, AnyGetterWriter paramAnyGetterWriter, Object paramObject)
  {
    super(paramJavaType);
    this._props = paramArrayOfBeanPropertyWriter1;
    this._filteredProps = paramArrayOfBeanPropertyWriter2;
    this._anyGetterWriter = paramAnyGetterWriter;
    this._propertyFilterId = paramObject;
  }
  
  public static BeanSerializer createDummy(Class<?> paramClass)
  {
    return new BeanSerializer(paramClass, NO_PROPS, null, null, null);
  }
  
  protected BeanPropertyFilter findFilter(SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    Object localObject = this._propertyFilterId;
    paramSerializerProvider = paramSerializerProvider.getFilterProvider();
    if (paramSerializerProvider == null) {
      throw new JsonMappingException("Can not resolve BeanPropertyFilter with id '" + localObject + "'; no FilterProvider configured");
    }
    paramSerializerProvider = paramSerializerProvider.findFilter(localObject);
    if (paramSerializerProvider == null) {
      throw new JsonMappingException("No filter configured with id '" + localObject + "' (type " + localObject.getClass().getName() + ")");
    }
    return paramSerializerProvider;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    ObjectNode localObjectNode2 = createSchemaNode("object", true);
    ObjectNode localObjectNode1 = localObjectNode2.objectNode();
    int i = 0;
    if (i < this._props.length)
    {
      BeanPropertyWriter localBeanPropertyWriter = this._props[i];
      paramType = localBeanPropertyWriter.getSerializationType();
      label51:
      Object localObject1;
      if (paramType == null)
      {
        paramType = localBeanPropertyWriter.getGenericPropertyType();
        Object localObject2 = localBeanPropertyWriter.getSerializer();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = localBeanPropertyWriter.getRawSerializationType();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = localBeanPropertyWriter.getPropertyType();
          }
          localObject1 = paramSerializerProvider.findValueSerializer((Class)localObject1, localBeanPropertyWriter);
        }
        if (!(localObject1 instanceof SchemaAware)) {
          break label147;
        }
      }
      label147:
      for (paramType = ((SchemaAware)localObject1).getSchema(paramSerializerProvider, paramType);; paramType = JsonSchema.getDefaultSchemaNode())
      {
        localObjectNode1.put(localBeanPropertyWriter.getName(), paramType);
        i++;
        break;
        paramType = paramType.getRawClass();
        break label51;
      }
    }
    localObjectNode2.put("properties", localObjectNode1);
    return localObjectNode2;
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    int i;
    int j;
    label18:
    BeanPropertyWriter localBeanPropertyWriter;
    if (this._filteredProps == null)
    {
      i = 0;
      j = 0;
      int k = this._props.length;
      if (j >= k) {
        break label239;
      }
      localBeanPropertyWriter = this._props[j];
      if (!localBeanPropertyWriter.hasSerializer()) {
        break label55;
      }
    }
    for (;;)
    {
      j++;
      break label18;
      i = this._filteredProps.length;
      break;
      label55:
      Object localObject1 = localBeanPropertyWriter.getSerializationType();
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = paramSerializerProvider.constructType(localBeanPropertyWriter.getGenericPropertyType());
        localObject2 = localObject1;
        if (!((JavaType)localObject1).isFinal())
        {
          if ((!((JavaType)localObject1).isContainerType()) && (((JavaType)localObject1).containedTypeCount() <= 0)) {
            continue;
          }
          localBeanPropertyWriter.setNonTrivialBaseType((JavaType)localObject1);
          continue;
        }
      }
      JsonSerializer localJsonSerializer = paramSerializerProvider.findValueSerializer((JavaType)localObject2, localBeanPropertyWriter);
      localObject1 = localJsonSerializer;
      if (((JavaType)localObject2).isContainerType())
      {
        localObject2 = (TypeSerializer)((JavaType)localObject2).getContentType().getTypeHandler();
        localObject1 = localJsonSerializer;
        if (localObject2 != null)
        {
          localObject1 = localJsonSerializer;
          if ((localJsonSerializer instanceof ContainerSerializerBase)) {
            localObject1 = ((ContainerSerializerBase)localJsonSerializer).withValueTypeSerializer((TypeSerializer)localObject2);
          }
        }
      }
      localObject2 = localBeanPropertyWriter.withSerializer((JsonSerializer)localObject1);
      this._props[j] = localObject2;
      if (j < i)
      {
        localObject2 = this._filteredProps[j];
        if (localObject2 != null) {
          this._filteredProps[j] = ((BeanPropertyWriter)localObject2).withSerializer((JsonSerializer)localObject1);
        }
      }
    }
    label239:
    if (this._anyGetterWriter != null) {
      this._anyGetterWriter.resolve(paramSerializerProvider);
    }
  }
  
  public final void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeStartObject();
    if (this._propertyFilterId != null) {
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      paramJsonGenerator.writeEndObject();
      return;
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  protected void serializeFields(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    BeanPropertyWriter[] arrayOfBeanPropertyWriter;
    if ((this._filteredProps != null) && (paramSerializerProvider.getSerializationView() != null)) {
      arrayOfBeanPropertyWriter = this._filteredProps;
    }
    int k;
    for (;;)
    {
      int j = 0;
      k = 0;
      int i = 0;
      try
      {
        int m = arrayOfBeanPropertyWriter.length;
        for (;;)
        {
          if (i < m)
          {
            BeanPropertyWriter localBeanPropertyWriter = arrayOfBeanPropertyWriter[i];
            if (localBeanPropertyWriter != null)
            {
              j = i;
              k = i;
              localBeanPropertyWriter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider);
            }
            i++;
            continue;
            arrayOfBeanPropertyWriter = this._props;
            break;
          }
        }
        j = i;
        k = i;
        if (this._anyGetterWriter != null)
        {
          j = i;
          k = i;
          this._anyGetterWriter.getAndSerialize(paramObject, paramJsonGenerator, paramSerializerProvider);
        }
        return;
      }
      catch (Exception localException)
      {
        if (j == arrayOfBeanPropertyWriter.length) {}
        for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[j].getName())
        {
          wrapAndThrow(paramSerializerProvider, localException, paramObject, paramJsonGenerator);
          break;
        }
      }
      catch (StackOverflowError paramJsonGenerator)
      {
        paramSerializerProvider = new JsonMappingException("Infinite recursion (StackOverflowError)");
        if (k != arrayOfBeanPropertyWriter.length) {}
      }
    }
    for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[k].getName())
    {
      paramSerializerProvider.prependPath(new JsonMappingException.Reference(paramObject, paramJsonGenerator));
      throw paramSerializerProvider;
    }
  }
  
  protected void serializeFieldsFiltered(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    BeanPropertyWriter[] arrayOfBeanPropertyWriter;
    if ((this._filteredProps != null) && (paramSerializerProvider.getSerializationView() != null)) {
      arrayOfBeanPropertyWriter = this._filteredProps;
    }
    int k;
    for (;;)
    {
      BeanPropertyFilter localBeanPropertyFilter = findFilter(paramSerializerProvider);
      int j = 0;
      k = 0;
      int i = 0;
      try
      {
        int m = arrayOfBeanPropertyWriter.length;
        for (;;)
        {
          if (i < m)
          {
            BeanPropertyWriter localBeanPropertyWriter = arrayOfBeanPropertyWriter[i];
            if (localBeanPropertyWriter != null)
            {
              j = i;
              k = i;
              localBeanPropertyFilter.serializeAsField(paramObject, paramJsonGenerator, paramSerializerProvider, localBeanPropertyWriter);
            }
            i++;
            continue;
            arrayOfBeanPropertyWriter = this._props;
            break;
          }
        }
        j = i;
        k = i;
        if (this._anyGetterWriter != null)
        {
          j = i;
          k = i;
          this._anyGetterWriter.getAndSerialize(paramObject, paramJsonGenerator, paramSerializerProvider);
        }
        return;
      }
      catch (Exception localException)
      {
        if (j == arrayOfBeanPropertyWriter.length) {}
        for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[j].getName())
        {
          wrapAndThrow(paramSerializerProvider, localException, paramObject, paramJsonGenerator);
          break;
        }
      }
      catch (StackOverflowError paramJsonGenerator)
      {
        paramSerializerProvider = new JsonMappingException("Infinite recursion (StackOverflowError)");
        if (k != arrayOfBeanPropertyWriter.length) {}
      }
    }
    for (paramJsonGenerator = "[anySetter]";; paramJsonGenerator = arrayOfBeanPropertyWriter[k].getName())
    {
      paramSerializerProvider.prependPath(new JsonMappingException.Reference(paramObject, paramJsonGenerator));
      throw paramSerializerProvider;
    }
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonGenerationException
  {
    paramTypeSerializer.writeTypePrefixForObject(paramObject, paramJsonGenerator);
    if (this._propertyFilterId != null) {
      serializeFieldsFiltered(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
    for (;;)
    {
      paramTypeSerializer.writeTypeSuffixForObject(paramObject, paramJsonGenerator);
      return;
      serializeFields(paramObject, paramJsonGenerator, paramSerializerProvider);
    }
  }
  
  public String toString()
  {
    return "BeanSerializer for " + handledType().getName();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\BeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */