package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.node.ObjectNode;

final class JsonNodeDeserializer$ObjectDeserializer
  extends BaseNodeDeserializer<ObjectNode>
{
  protected static final ObjectDeserializer _instance = new ObjectDeserializer();
  
  protected JsonNodeDeserializer$ObjectDeserializer()
  {
    super(ObjectNode.class);
  }
  
  public static ObjectDeserializer getInstance()
  {
    return _instance;
  }
  
  public ObjectNode deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
      paramJsonParser.nextToken();
    }
    for (paramJsonParser = deserializeObject(paramJsonParser, paramDeserializationContext);; paramJsonParser = deserializeObject(paramJsonParser, paramDeserializationContext))
    {
      return paramJsonParser;
      if (paramJsonParser.getCurrentToken() != JsonToken.FIELD_NAME) {
        break;
      }
    }
    throw paramDeserializationContext.mappingException(ObjectNode.class);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\JsonNodeDeserializer$ObjectDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */