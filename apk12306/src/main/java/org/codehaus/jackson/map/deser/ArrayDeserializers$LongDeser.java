package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.LongBuilder;

@JacksonStdImpl
final class ArrayDeserializers$LongDeser
  extends ArrayDeserializers.ArrayDeser<long[]>
{
  public ArrayDeserializers$LongDeser()
  {
    super(long[].class);
  }
  
  private final long[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new long[] { _parseLongPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public long[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {}
    ArrayBuilders.LongBuilder localLongBuilder;
    Object localObject2;
    int i;
    for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (long[])localLongBuilder.completeAndClearBuffer(localObject2, i))
    {
      return paramJsonParser;
      localLongBuilder = paramDeserializationContext.getArrayBuilders().getLongBuilder();
      localObject2 = (long[])localLongBuilder.resetAndStart();
      i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        long l = _parseLongPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject1 = localObject2;
        int j = i;
        if (i >= localObject2.length)
        {
          localObject1 = (long[])localLongBuilder.appendCompletedChunk(localObject2, i);
          j = 0;
        }
        localObject1[j] = l;
        i = j + 1;
        localObject2 = localObject1;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$LongDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */