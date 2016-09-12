package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ObjectBuffer;

@JacksonStdImpl
final class ArrayDeserializers$StringDeser
  extends ArrayDeserializers.ArrayDeser<String[]>
{
  public ArrayDeserializers$StringDeser()
  {
    super(String[].class);
  }
  
  private final String[] handleNonArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)) {
      throw paramDeserializationContext.mappingException(this._valueClass);
    }
    if (paramJsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {}
    for (paramJsonParser = null;; paramJsonParser = paramJsonParser.getText()) {
      return new String[] { paramJsonParser };
    }
  }
  
  public String[] deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (!paramJsonParser.isExpectedStartArrayToken()) {
      paramJsonParser = handleNonArray(paramJsonParser, paramDeserializationContext);
    }
    for (;;)
    {
      return paramJsonParser;
      ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
      Object localObject1 = localObjectBuffer.resetAndStart();
      int i = 0;
      Object localObject2 = paramJsonParser.nextToken();
      if (localObject2 != JsonToken.END_ARRAY)
      {
        if (localObject2 == JsonToken.VALUE_NULL) {}
        for (localObject2 = null;; localObject2 = paramJsonParser.getText())
        {
          Object localObject3 = localObject1;
          int j = i;
          if (i >= localObject1.length)
          {
            localObject3 = localObjectBuffer.appendCompletedChunk((Object[])localObject1);
            j = 0;
          }
          localObject3[j] = localObject2;
          i = j + 1;
          localObject1 = localObject3;
          break;
        }
      }
      paramJsonParser = (String[])localObjectBuffer.completeAndClearBuffer((Object[])localObject1, i, String.class);
      paramDeserializationContext.returnObjectBuffer(localObjectBuffer);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\ArrayDeserializers$StringDeser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */