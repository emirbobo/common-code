package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.util.ObjectBuffer;

@JacksonStdImpl
public class UntypedObjectDeserializer
  extends StdDeserializer<Object>
{
  public UntypedObjectDeserializer()
  {
    super(Object.class);
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    switch (paramJsonParser.getCurrentToken())
    {
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case ???: 
      paramJsonParser = paramJsonParser.getText();
    }
    for (;;)
    {
      return paramJsonParser;
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS))
      {
        paramJsonParser = paramJsonParser.getBigIntegerValue();
      }
      else
      {
        paramJsonParser = paramJsonParser.getNumberValue();
        continue;
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS))
        {
          paramJsonParser = paramJsonParser.getDecimalValue();
        }
        else
        {
          paramJsonParser = Double.valueOf(paramJsonParser.getDoubleValue());
          continue;
          paramJsonParser = Boolean.TRUE;
          continue;
          paramJsonParser = Boolean.FALSE;
          continue;
          paramJsonParser = paramJsonParser.getEmbeddedObject();
          continue;
          paramJsonParser = null;
          continue;
          paramJsonParser = mapArray(paramJsonParser, paramDeserializationContext);
          continue;
          paramJsonParser = mapObject(paramJsonParser, paramDeserializationContext);
        }
      }
    }
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    switch (localJsonToken)
    {
    default: 
      throw paramDeserializationContext.mappingException(Object.class);
    case ???: 
    case ???: 
    case ???: 
      paramJsonParser = paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
    }
    for (;;)
    {
      return paramJsonParser;
      paramJsonParser = paramJsonParser.getText();
      continue;
      if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS))
      {
        paramJsonParser = paramJsonParser.getBigIntegerValue();
      }
      else
      {
        paramJsonParser = Integer.valueOf(paramJsonParser.getIntValue());
        continue;
        if (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS))
        {
          paramJsonParser = paramJsonParser.getDecimalValue();
        }
        else
        {
          paramJsonParser = Double.valueOf(paramJsonParser.getDoubleValue());
          continue;
          paramJsonParser = Boolean.TRUE;
          continue;
          paramJsonParser = Boolean.FALSE;
          continue;
          paramJsonParser = paramJsonParser.getEmbeddedObject();
          continue;
          paramJsonParser = null;
        }
      }
    }
  }
  
  protected List<Object> mapArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramJsonParser.nextToken() == JsonToken.END_ARRAY)
    {
      paramJsonParser = new ArrayList(4);
      return paramJsonParser;
    }
    ObjectBuffer localObjectBuffer = paramDeserializationContext.leaseObjectBuffer();
    Object localObject2 = localObjectBuffer.resetAndStart();
    int i = 0;
    int j = 0;
    for (;;)
    {
      Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
      int k = j + 1;
      j = i;
      Object localObject1 = localObject2;
      if (i >= localObject2.length)
      {
        localObject1 = localObjectBuffer.appendCompletedChunk((Object[])localObject2);
        j = 0;
      }
      i = j + 1;
      localObject1[j] = localObject3;
      if (paramJsonParser.nextToken() == JsonToken.END_ARRAY)
      {
        paramJsonParser = new ArrayList((k >> 3) + k + 1);
        localObjectBuffer.completeAndClearBuffer((Object[])localObject1, i, paramJsonParser);
        break;
      }
      j = k;
      localObject2 = localObject1;
    }
  }
  
  protected Map<String, Object> mapObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    if (localObject1 != JsonToken.FIELD_NAME) {
      paramJsonParser = new LinkedHashMap(4);
    }
    for (;;)
    {
      return paramJsonParser;
      String str1 = paramJsonParser.getText();
      paramJsonParser.nextToken();
      localObject2 = deserialize(paramJsonParser, paramDeserializationContext);
      if (paramJsonParser.nextToken() != JsonToken.FIELD_NAME)
      {
        paramJsonParser = new LinkedHashMap(4);
        paramJsonParser.put(str1, localObject2);
      }
      else
      {
        String str2 = paramJsonParser.getText();
        paramJsonParser.nextToken();
        Object localObject3 = deserialize(paramJsonParser, paramDeserializationContext);
        if (paramJsonParser.nextToken() != JsonToken.FIELD_NAME)
        {
          paramJsonParser = new LinkedHashMap(4);
          paramJsonParser.put(str1, localObject2);
          paramJsonParser.put(str2, localObject3);
        }
        else
        {
          localObject1 = new LinkedHashMap();
          ((LinkedHashMap)localObject1).put(str1, localObject2);
          ((LinkedHashMap)localObject1).put(str2, localObject3);
          do
          {
            localObject2 = paramJsonParser.getText();
            paramJsonParser.nextToken();
            ((LinkedHashMap)localObject1).put(localObject2, deserialize(paramJsonParser, paramDeserializationContext));
          } while (paramJsonParser.nextToken() != JsonToken.END_OBJECT);
          paramJsonParser = (JsonParser)localObject1;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\UntypedObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */