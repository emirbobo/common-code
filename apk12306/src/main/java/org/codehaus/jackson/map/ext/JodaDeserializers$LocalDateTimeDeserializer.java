package org.codehaus.jackson.map.ext;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

public class JodaDeserializers$LocalDateTimeDeserializer
  extends JodaDeserializers.JodaDeserializer<LocalDateTime>
{
  public JodaDeserializers$LocalDateTimeDeserializer()
  {
    super(LocalDateTime.class);
  }
  
  public LocalDateTime deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject = null;
    if (paramJsonParser.isExpectedStartArrayToken())
    {
      paramJsonParser.nextToken();
      int n = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int i1 = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int j = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int i2 = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int m = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int k = paramJsonParser.getIntValue();
      int i = 0;
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY)
      {
        i = paramJsonParser.getIntValue();
        paramJsonParser.nextToken();
      }
      if (paramJsonParser.getCurrentToken() != JsonToken.END_ARRAY) {
        paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after LocalDateTime ints");
      }
      paramJsonParser = new LocalDateTime(n, i1, j, i2, m, k, i);
    }
    for (;;)
    {
      return paramJsonParser;
      switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array or Number");
        paramJsonParser = (JsonParser)localObject;
        break;
      case 1: 
        paramJsonParser = new LocalDateTime(paramJsonParser.getLongValue());
        break;
      case 2: 
        paramDeserializationContext = parseLocal(paramJsonParser);
        paramJsonParser = (JsonParser)localObject;
        if (paramDeserializationContext != null) {
          paramJsonParser = paramDeserializationContext.toLocalDateTime();
        }
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\JodaDeserializers$LocalDateTimeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */