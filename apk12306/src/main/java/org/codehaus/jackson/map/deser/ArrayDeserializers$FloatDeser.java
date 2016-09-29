package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.FloatBuilder;

@JacksonStdImpl
final class ArrayDeserializers$FloatDeser
  extends ArrayDeserializers.ArrayDeser<float[]>
{
  public ArrayDeserializers$FloatDeser()
  {
    super(float[].class);
  }
  
  private final float[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new float[] { _parseFloatPrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public float[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {}
    ArrayBuilders.FloatBuilder localFloatBuilder;
    Object localObject2;
    int i;
    for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (float[])localFloatBuilder.completeAndClearBuffer(localObject2, i))
    {
      return paramJsonParser;
      localFloatBuilder = paramDeserializationContext.getArrayBuilders().getFloatBuilder();
      localObject2 = (float[])localFloatBuilder.resetAndStart();
      i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        float f = _parseFloatPrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject1 = localObject2;
        int j = i;
        if (i >= localObject2.length)
        {
          localObject1 = (float[])localFloatBuilder.appendCompletedChunk(localObject2, i);
          j = 0;
        }
        localObject1[j] = f;
        i = j + 1;
        localObject2 = localObject1;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$FloatDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */