package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.ByteBuilder;

@JacksonStdImpl
final class ArrayDeserializers$ByteDeser
  extends ArrayDeserializers.ArrayDeser<byte[]>
{
  public ArrayDeserializers$ByteDeser()
  {
    super(byte[].class);
  }
  
  private final byte[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    int j;
    if ((localJsonToken == JsonToken.VALUE_NUMBER_INT) || (localJsonToken == JsonToken.VALUE_NUMBER_FLOAT)) {
      j = paramJsonParser.getByteValue();
    }
    for (int i = j;; i = j)
    {
      return new byte[] { i };
      if (localJsonToken != JsonToken.VALUE_NULL) {
        throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
      }
      j = 0;
    }
  }
  
  public byte[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject1 = paramJsonParser.getCurrentToken();
    if (localObject1 == JsonToken.VALUE_STRING) {
      paramJsonParser = paramJsonParser.getBinaryValue(paramDeserializationContext.getBase64Variant());
    }
    for (;;)
    {
      return paramJsonParser;
      if (localObject1 == JsonToken.VALUE_EMBEDDED_OBJECT)
      {
        localObject1 = paramJsonParser.getEmbeddedObject();
        if (localObject1 == null)
        {
          paramJsonParser = null;
          continue;
        }
        if ((localObject1 instanceof byte[]))
        {
          paramJsonParser = (byte[])localObject1;
          continue;
        }
      }
      if (!paramJsonParser.isExpectedStartArrayToken())
      {
        paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);
      }
      else
      {
        ArrayBuilders.ByteBuilder localByteBuilder = paramDeserializationContext.getArrayBuilders().getByteBuilder();
        localObject1 = (byte[])localByteBuilder.resetAndStart();
        int i = 0;
        Object localObject2 = paramJsonParser.nextToken();
        if (localObject2 != JsonToken.END_ARRAY)
        {
          if ((localObject2 == JsonToken.VALUE_NUMBER_INT) || (localObject2 == JsonToken.VALUE_NUMBER_FLOAT)) {}
          for (int j = paramJsonParser.getByteValue();; j = 0)
          {
            localObject2 = localObject1;
            int k = i;
            if (i >= localObject1.length)
            {
              localObject2 = (byte[])localByteBuilder.appendCompletedChunk(localObject1, i);
              k = 0;
            }
            localObject2[k] = ((byte)j);
            i = k + 1;
            localObject1 = localObject2;
            break;
            if (localObject2 != JsonToken.VALUE_NULL) {
              throw paramDeserializationContext.mappingException(this._valueClass.getComponentType());
            }
          }
        }
        paramJsonParser = (byte[])localByteBuilder.completeAndClearBuffer(localObject1, i);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$ByteDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */