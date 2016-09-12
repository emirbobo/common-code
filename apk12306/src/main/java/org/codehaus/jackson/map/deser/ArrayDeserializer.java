package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Array;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.util.ObjectBuffer;
import org.codehaus.jackson.type.JavaType;

@JacksonStdImpl
public class ArrayDeserializer
  extends ContainerDeserializer<Object[]>
{
  protected final JavaType _arrayType;
  protected final Class<?> _elementClass;
  protected final JsonDeserializer<Object> _elementDeserializer;
  final TypeDeserializer _elementTypeDeserializer;
  protected final boolean _untyped;
  
  @Deprecated
  public ArrayDeserializer(ArrayType paramArrayType, JsonDeserializer<Object> paramJsonDeserializer)
  {
    this(paramArrayType, paramJsonDeserializer, null);
  }
  
  public ArrayDeserializer(ArrayType paramArrayType, JsonDeserializer<Object> paramJsonDeserializer, TypeDeserializer paramTypeDeserializer)
  {
    super(Object[].class);
    this._arrayType = paramArrayType;
    this._elementClass = paramArrayType.getContentType().getRawClass();
    if (this._elementClass == Object.class) {}
    for (boolean bool = true;; bool = false)
    {
      this._untyped = bool;
      this._elementDeserializer = paramJsonDeserializer;
      this._elementTypeDeserializer = paramTypeDeserializer;
      return;
    }
  }
  
  private final Object[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
    {
      if ((paramJsonParser.getCurrentToken() == JsonToken.VALUE_STRING) && (this._elementClass == Byte.class))
      {
        paramDeserializationContext = deserializeFromBase64(paramJsonParser, paramDeserializationContext);
        return paramDeserializationContext;
      }
      throw paramDeserializationContext.mappingException(this._arrayType.getRawClass());
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL)
    {
      paramJsonParser = null;
      label62:
      if (!this._untyped) {
        break label118;
      }
    }
    label118:
    for (paramDeserializationContext = new Object[1];; paramDeserializationContext = (Object[])Array.newInstance(this._elementClass, 1))
    {
      paramDeserializationContext[0] = paramJsonParser;
      break;
      if (this._elementTypeDeserializer == null)
      {
        paramJsonParser = this._elementDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
        break label62;
      }
      paramJsonParser = this._elementDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, this._elementTypeDeserializer);
      break label62;
    }
  }
  
  public Object[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken())
    {
      paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);
      return paramJsonParser;
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject2 = localObjectBuffer.resetAndStart();
    int i = 0;
    TypeDeserializer localTypeDeserializer = this._elementTypeDeserializer;
    Object localObject1 = paramJsonParser.nextToken();
    if (localObject1 != JsonToken.END_ARRAY)
    {
      if (localObject1 == JsonToken.VALUE_NULL) {
        localObject1 = null;
      }
      for (;;)
      {
        Object localObject3 = localObject2;
        int j = i;
        if (i >= localObject2.length)
        {
          localObject3 = localObjectBuffer.appendCompletedChunk((Object[])localObject2);
          j = 0;
        }
        localObject3[j] = localObject1;
        i = j + 1;
        localObject2 = localObject3;
        break;
        if (localTypeDeserializer == null) {
          localObject1 = this._elementDeserializer.deserialize(paramJsonParser, paramDeserializationContext);
        } else {
          localObject1 = this._elementDeserializer.deserializeWithType(paramJsonParser, paramDeserializationContext, localTypeDeserializer);
        }
      }
    }
    if (this._untyped) {}
    for (paramJsonParser = localObjectBuffer.completeAndClearBuffer((Object[])localObject2, i);; paramJsonParser = localObjectBuffer.completeAndClearBuffer((Object[])localObject2, i, this._elementClass))
    {
      paramDeserializationContext.returnObjectBuffer(localObjectBuffer);
      break;
    }
  }
  
  protected Byte[] deserializeFromBase64(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    paramDeserializationContext = paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
    paramJsonParser = new Byte[paramDeserializationContext.length];
    int i = 0;
    int j = paramDeserializationContext.length;
    while (i < j)
    {
      paramJsonParser[i] = Byte.valueOf(paramDeserializationContext[i]);
      i++;
    }
    return paramJsonParser;
  }
  
  public Object[] deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return (Object[])paramTypeDeserializer.deserializeTypedFromArray(paramJsonParser, paramDeserializationContext);
  }
  
  public JsonDeserializer<Object> getContentDeserializer()
  {
    return this._elementDeserializer;
  }
  
  public JavaType getContentType()
  {
    return this._arrayType.getContentType();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */