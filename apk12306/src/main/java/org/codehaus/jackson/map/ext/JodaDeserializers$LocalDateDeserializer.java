package org.codehaus.jackson.map.ext;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaDeserializers$LocalDateDeserializer
  extends JodaDeserializers.JodaDeserializer<LocalDate>
{
  public JodaDeserializers$LocalDateDeserializer()
  {
    super(LocalDate.class);
  }
  
  public LocalDate deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject = null;
    if (paramJsonParser.isExpectedStartArrayToken())
    {
      paramJsonParser.nextToken();
      int k = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int i = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int j = paramJsonParser.getIntValue();
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after LocalDate ints");
      }
      paramJsonParser = new LocalDate(k, i, j);
    }
    for (;;)
    {
      return paramJsonParser;
      switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array, String or Number");
        paramJsonParser = (JsonParser)localObject;
        break;
      case 1: 
        paramJsonParser = new LocalDate(paramJsonParser.getLongValue());
        break;
      case 2: 
        paramDeserializationContext = parseLocal(paramJsonParser);
        paramJsonParser = (JsonParser)localObject;
        if (paramDeserializationContext != null) {
          paramJsonParser = paramDeserializationContext.toLocalDate();
        }
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\JodaDeserializers$LocalDateDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */