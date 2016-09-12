package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.ShortBuilder;

@JacksonStdImpl
final class ArrayDeserializers$ShortDeser
  extends ArrayDeserializers.ArrayDeser<short[]>
{
  public ArrayDeserializers$ShortDeser()
  {
    super(short[].class);
  }
  
  private final short[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new short[] { _parseShortPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public short[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {}
    ArrayBuilders.ShortBuilder localShortBuilder;
    Object localObject2;
    int i;
    for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (short[])localShortBuilder.completeAndClearBuffer(localObject2, i))
    {
      return paramJsonParser;
      localShortBuilder = paramDeserializationContext.getArrayBuilders().getShortBuilder();
      localObject2 = (short[])localShortBuilder.resetAndStart();
      i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        int k = _parseShortPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject1 = localObject2;
        int j = i;
        if (i >= localObject2.length)
        {
          localObject1 = (short[])localShortBuilder.appendCompletedChunk(localObject2, i);
          j = 0;
        }
        localObject1[j] = ((short)k);
        i = j + 1;
        localObject2 = localObject1;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$ShortDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */