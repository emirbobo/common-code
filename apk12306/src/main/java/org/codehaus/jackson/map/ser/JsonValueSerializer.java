package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public final class JsonValueSerializer
  extends SerializerBase<Object>
  implements ResolvableSerializer, SchemaAware
{
  protected final Method _accessorMethod;
  protected boolean _forceTypeInformation;
  protected final BeanProperty _property;
  protected JsonSerializer<Object> _valueSerializer;
  
  public JsonValueSerializer(Method paramMethod, JsonSerializer<Object> paramJsonSerializer, BeanProperty paramBeanProperty)
  {
    super(Object.class);
    this._accessorMethod = paramMethod;
    this._valueSerializer = paramJsonSerializer;
    this._property = paramBeanProperty;
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
    throws JsonMappingException
  {
    if ((this._valueSerializer instanceof SchemaAware)) {}
    for (paramSerializerProvider = ((SchemaAware)this._valueSerializer).getSchema(paramSerializerProvider, null);; paramSerializerProvider = JsonSchema.getDefaultSchemaNode()) {
      return paramSerializerProvider;
    }
  }
  
  protected boolean isNaturalTypeWithStdHandling(JavaType paramJavaType, JsonSerializer<?> paramJsonSerializer)
  {
    boolean bool2 = false;
    Class localClass = paramJavaType.getRawClass();
    boolean bool1;
    if (paramJavaType.isPrimitive())
    {
      if ((localClass == Integer.TYPE) || (localClass == Boolean.TYPE) || (localClass == Double.TYPE)) {
        break label76;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((localClass != String.class) && (localClass != Integer.class) && (localClass != Boolean.class))
      {
        bool1 = bool2;
        if (localClass != Double.class) {}
      }
      else
      {
        label76:
        bool1 = bool2;
        if (paramJsonSerializer.getClass().getAnnotation(JacksonStdImpl.class) != null) {
          bool1 = true;
        }
      }
    }
  }
  
  public void resolve(SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    if ((this._valueSerializer == null) && ((paramSerializerProvider.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING)) || (Modifier.isFinal(this._accessorMethod.getReturnType().getModifiers()))))
    {
      JavaType localJavaType = paramSerializerProvider.constructType(this._accessorMethod.getGenericReturnType());
      this._valueSerializer = paramSerializerProvider.findTypedValueSerializer(localJavaType, false, this._property);
      this._forceTypeInformation = isNaturalTypeWithStdHandling(localJavaType, this._valueSerializer);
    }
  }
  
  /* Error */
  public void serialize(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, org.codehaus.jackson.JsonGenerationException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	org/codehaus/jackson/map/ser/JsonValueSerializer:_accessorMethod	Ljava/lang/reflect/Method;
    //   4: aload_1
    //   5: iconst_0
    //   6: anewarray 23	java/lang/Object
    //   9: invokevirtual 143	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnonnull +9 -> 25
    //   19: aload_3
    //   20: aload_2
    //   21: invokevirtual 147	org/codehaus/jackson/map/SerializerProvider:defaultSerializeNull	(Lorg/codehaus/jackson/JsonGenerator;)V
    //   24: return
    //   25: aload_0
    //   26: getfield 30	org/codehaus/jackson/map/ser/JsonValueSerializer:_valueSerializer	Lorg/codehaus/jackson/map/JsonSerializer;
    //   29: astore 5
    //   31: aload 5
    //   33: astore 4
    //   35: aload 5
    //   37: ifnonnull +19 -> 56
    //   40: aload_3
    //   41: aload 6
    //   43: invokevirtual 77	java/lang/Object:getClass	()Ljava/lang/Class;
    //   46: iconst_1
    //   47: aload_0
    //   48: getfield 32	org/codehaus/jackson/map/ser/JsonValueSerializer:_property	Lorg/codehaus/jackson/map/BeanProperty;
    //   51: invokevirtual 150	org/codehaus/jackson/map/SerializerProvider:findTypedValueSerializer	(Ljava/lang/Class;ZLorg/codehaus/jackson/map/BeanProperty;)Lorg/codehaus/jackson/map/JsonSerializer;
    //   54: astore 4
    //   56: aload 4
    //   58: aload 6
    //   60: aload_2
    //   61: aload_3
    //   62: invokevirtual 154	org/codehaus/jackson/map/JsonSerializer:serialize	(Ljava/lang/Object;Lorg/codehaus/jackson/JsonGenerator;Lorg/codehaus/jackson/map/SerializerProvider;)V
    //   65: goto -41 -> 24
    //   68: astore_1
    //   69: aload_1
    //   70: athrow
    //   71: astore_2
    //   72: aload_2
    //   73: instanceof 156
    //   76: ifeq +18 -> 94
    //   79: aload_2
    //   80: invokevirtual 162	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   83: ifnull +11 -> 94
    //   86: aload_2
    //   87: invokevirtual 162	java/lang/Throwable:getCause	()Ljava/lang/Throwable;
    //   90: astore_2
    //   91: goto -19 -> 72
    //   94: aload_2
    //   95: instanceof 164
    //   98: ifeq +8 -> 106
    //   101: aload_2
    //   102: checkcast 164	java/lang/Error
    //   105: athrow
    //   106: aload_2
    //   107: aload_1
    //   108: new 166	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   115: aload_0
    //   116: getfield 28	org/codehaus/jackson/map/ser/JsonValueSerializer:_accessorMethod	Ljava/lang/reflect/Method;
    //   119: invokevirtual 173	java/lang/reflect/Method:getName	()Ljava/lang/String;
    //   122: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc -77
    //   127: invokevirtual 177	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 182	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 186	org/codehaus/jackson/map/JsonMappingException:wrapWithPath	(Ljava/lang/Throwable;Ljava/lang/Object;Ljava/lang/String;)Lorg/codehaus/jackson/map/JsonMappingException;
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	JsonValueSerializer
    //   0	137	1	paramObject	Object
    //   0	137	2	paramJsonGenerator	JsonGenerator
    //   0	137	3	paramSerializerProvider	SerializerProvider
    //   33	24	4	localJsonSerializer1	JsonSerializer
    //   29	7	5	localJsonSerializer2	JsonSerializer
    //   12	47	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	14	68	java/io/IOException
    //   19	24	68	java/io/IOException
    //   25	31	68	java/io/IOException
    //   40	56	68	java/io/IOException
    //   56	65	68	java/io/IOException
    //   0	14	71	java/lang/Exception
    //   19	24	71	java/lang/Exception
    //   25	31	71	java/lang/Exception
    //   40	56	71	java/lang/Exception
    //   56	65	71	java/lang/Exception
  }
  
  public void serializeWithType(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider, TypeSerializer paramTypeSerializer)
    throws IOException, JsonProcessingException
  {
    for (;;)
    {
      try
      {
        localObject = this._accessorMethod.invoke(paramObject, new Object[0]);
        if (localObject == null)
        {
          paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
          return;
        }
      }
      catch (IOException paramObject)
      {
        Object localObject;
        JsonSerializer localJsonSerializer;
        throw ((Throwable)paramObject);
        paramSerializerProvider.findTypedValueSerializer(localObject.getClass(), true, this._property).serialize(localObject, paramJsonGenerator, paramSerializerProvider);
        continue;
      }
      catch (Exception paramJsonGenerator)
      {
        if ((!(paramJsonGenerator instanceof InvocationTargetException)) || (paramJsonGenerator.getCause() == null)) {
          continue;
        }
        paramJsonGenerator = paramJsonGenerator.getCause();
        continue;
        if (!(paramJsonGenerator instanceof Error)) {
          continue;
        }
        throw ((Error)paramJsonGenerator);
        throw JsonMappingException.wrapWithPath(paramJsonGenerator, paramObject, this._accessorMethod.getName() + "()");
      }
      localJsonSerializer = this._valueSerializer;
      if (localJsonSerializer == null) {
        continue;
      }
      if (this._forceTypeInformation) {
        paramTypeSerializer.writeTypePrefixForScalar(paramObject, paramJsonGenerator);
      }
      localJsonSerializer.serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, paramTypeSerializer);
      if (this._forceTypeInformation) {
        paramTypeSerializer.writeTypeSuffixForScalar(paramObject, paramJsonGenerator);
      }
    }
  }
  
  public String toString()
  {
    return "(@JsonValue serializer for method " + this._accessorMethod.getDeclaringClass() + "#" + this._accessorMethod.getName() + ")";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\JsonValueSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */