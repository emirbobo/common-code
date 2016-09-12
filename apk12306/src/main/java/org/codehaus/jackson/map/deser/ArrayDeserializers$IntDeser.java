package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.IntBuilder;

@JacksonStdImpl
final class ArrayDeserializers$IntDeser
  extends ArrayDeserializers.ArrayDeser<int[]>
{
  public ArrayDeserializers$IntDeser()
  {
    super(int[].class);
  }
  
  private final int[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new int[] { _parseIntPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public int[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {}
    ArrayBuilders.IntBuilder localIntBuilder;
    Object localObject1;
    int i;
    for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (int[])localIntBuilder.completeAndClearBuffer(localObject1, i))
    {
      return paramJsonParser;
      localIntBuilder = paramDeserializationContext.getArrayBuilders().getIntBuilder();
      localObject1 = (int[])localIntBuilder.resetAndStart();
      i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        int k = _parseIntPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int j = i;
        if (i >= localObject1.length)
        {
          localObject2 = (int[])localIntBuilder.appendCompletedChunk(localObject1, i);
          j = 0;
        }
        localObject2[j] = k;
        i = j + 1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$IntDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */