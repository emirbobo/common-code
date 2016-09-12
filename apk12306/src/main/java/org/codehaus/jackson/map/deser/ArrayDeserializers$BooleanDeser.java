package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.BooleanBuilder;

@JacksonStdImpl
final class ArrayDeserializers$BooleanDeser
  extends ArrayDeserializers.ArrayDeser<boolean[]>
{
  public ArrayDeserializers$BooleanDeser()
  {
    super(boolean[].class);
  }
  
  private final boolean[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new boolean[] { _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public boolean[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {}
    ArrayBuilders.BooleanBuilder localBooleanBuilder;
    Object localObject1;
    int i;
    for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (boolean[])localBooleanBuilder.completeAndClearBuffer(localObject1, i))
    {
      return paramJsonParser;
      localBooleanBuilder = paramDeserializationContext.getArrayBuilders().getBooleanBuilder();
      localObject1 = (boolean[])localBooleanBuilder.resetAndStart();
      i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        boolean bool = _parseBooleanPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject2 = localObject1;
        int j = i;
        if (i >= localObject1.length)
        {
          localObject2 = (boolean[])localBooleanBuilder.appendCompletedChunk(localObject1, i);
          j = 0;
        }
        localObject2[j] = bool;
        i = j + 1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$BooleanDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */