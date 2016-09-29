package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonParser.NumberType;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;

abstract class BaseNodeDeserializer<N extends JsonNode>
  extends StdDeserializer<N>
{
  public BaseNodeDeserializer(Class<N> paramClass)
  {
    super(paramClass);
  }
  
  protected void _handleDuplicateField(String paramString, ObjectNode paramObjectNode, JsonNode paramJsonNode1, JsonNode paramJsonNode2)
    throws JsonProcessingException
  {}
  
  protected void _reportProblem(JsonParser paramJsonParser, String paramString)
    throws JsonMappingException
  {
    throw new JsonMappingException(paramString, paramJsonParser.getTokenLocation());
  }
  
  protected final JsonNode deserializeAny(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonNodeFactory localJsonNodeFactory = paramDeserializationContext.getNodeFactory();
    switch (paramJsonParser.getCurrentToken())
    {
    default: 
      throw paramDeserializationContext.mappingException(getValueClass());
    case ???: 
    case ???: 
      paramJsonParser = deserializeObject(paramJsonParser, paramDeserializationContext);
    }
    for (;;)
    {
      return paramJsonParser;
      paramJsonParser = deserializeArray(paramJsonParser, paramDeserializationContext);
      continue;
      paramJsonParser = localJsonNodeFactory.textNode(paramJsonParser.getText());
      continue;
      JsonParser.NumberType localNumberType = paramJsonParser.getNumberType();
      if ((localNumberType == JsonParser.NumberType.BIG_INTEGER) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_INTEGER_FOR_INTS)))
      {
        paramJsonParser = localJsonNodeFactory.numberNode(paramJsonParser.getBigIntegerValue());
      }
      else if (localNumberType == JsonParser.NumberType.INT)
      {
        paramJsonParser = localJsonNodeFactory.numberNode(paramJsonParser.getIntValue());
      }
      else
      {
        paramJsonParser = localJsonNodeFactory.numberNode(paramJsonParser.getLongValue());
        continue;
        if ((paramJsonParser.getNumberType() == JsonParser.NumberType.BIG_DECIMAL) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.USE_BIG_DECIMAL_FOR_FLOATS)))
        {
          paramJsonParser = localJsonNodeFactory.numberNode(paramJsonParser.getDecimalValue());
        }
        else
        {
          paramJsonParser = localJsonNodeFactory.numberNode(paramJsonParser.getDoubleValue());
          continue;
          paramJsonParser = localJsonNodeFactory.booleanNode(true);
          continue;
          paramJsonParser = localJsonNodeFactory.booleanNode(false);
          continue;
          paramJsonParser = localJsonNodeFactory.nullNode();
        }
      }
    }
  }
  
  protected final ArrayNode deserializeArray(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    ArrayNode localArrayNode = paramDeserializationContext.getNodeFactory().arrayNode();
    while (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
      localArrayNode.add(deserializeAny(paramJsonParser, paramDeserializationContext));
    }
    return localArrayNode;
  }
  
  protected final ObjectNode deserializeObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    ObjectNode localObjectNode = paramDeserializationContext.getNodeFactory().objectNode();
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {}
    for (localObject1 = paramJsonParser.nextToken(); localObject1 == JsonToken.FIELD_NAME; localObject1 = paramJsonParser.nextToken())
    {
      String str = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      localObject2 = deserializeAny(paramJsonParser, paramDeserializationContext);
      localObject1 = localObjectNode.put(str, (JsonNode)localObject2);
      if (localObject1 != null) {
        _handleDuplicateField(str, localObjectNode, (JsonNode)localObject1, (JsonNode)localObject2);
      }
    }
    return localObjectNode;
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromAny(paramJsonParser, paramDeserializationContext);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\BaseNodeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */