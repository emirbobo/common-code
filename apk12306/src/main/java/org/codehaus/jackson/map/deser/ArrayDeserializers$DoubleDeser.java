package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ArrayBuilders.DoubleBuilder;

@JacksonStdImpl
final class ArrayDeserializers$DoubleDeser
  extends ArrayDeserializers.ArrayDeser<double[]>
{
  public ArrayDeserializers$DoubleDeser()
  {
    super(double[].class);
  }
  
  private final double[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    return new double[] { _parseDoublePrimitive(paramJsonParser, paramDeserializationContext) };
  }
  
  public double[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {}
    ArrayBuilders.DoubleBuilder localDoubleBuilder;
    Object localObject2;
    int i;
    for (paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);; paramJsonParser = (double[])localDoubleBuilder.completeAndClearBuffer(localObject2, i))
    {
      return paramJsonParser;
      localDoubleBuilder = paramDeserializationContext.getArrayBuilders().getDoubleBuilder();
      localObject2 = (double[])localDoubleBuilder.resetAndStart();
      i = 0;
      while (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        double d = _parseDoublePrimitive(paramJsonParser, paramDeserializationContext);
        Object localObject1 = localObject2;
        int j = i;
        if (i >= localObject2.length)
        {
          localObject1 = (double[])localDoubleBuilder.appendCompletedChunk(localObject2, i);
          j = 0;
        }
        localObject1[j] = d;
        i = j + 1;
        localObject2 = localObject1;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$DoubleDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */