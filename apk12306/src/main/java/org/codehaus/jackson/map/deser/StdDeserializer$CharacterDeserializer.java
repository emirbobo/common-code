package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdDeserializer$CharacterDeserializer
  extends StdDeserializer.PrimitiveOrWrapperDeserializer<Character>
{
  public StdDeserializer$CharacterDeserializer(Class<Character> paramClass, Character paramCharacter)
  {
    super(paramClass, paramCharacter);
  }
  
  public Character deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    int i;
    if (localJsonToken == JsonToken.VALUE_NUMBER_INT)
    {
      i = paramJsonParser.getIntValue();
      if ((i < 0) || (i > 65535)) {}
    }
    else
    {
      for (paramJsonParser = Character.valueOf((char)i);; paramJsonParser = Character.valueOf(paramJsonParser.charAt(0)))
      {
        return paramJsonParser;
        if (localJsonToken != JsonToken.VALUE_STRING) {
          break;
        }
        paramJsonParser = paramJsonParser.getText();
        if (paramJsonParser.length() != 1) {
          break;
        }
      }
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$CharacterDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */