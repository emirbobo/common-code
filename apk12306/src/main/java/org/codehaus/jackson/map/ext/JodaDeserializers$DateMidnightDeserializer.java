package org.codehaus.jackson.map.ext;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;

public class JodaDeserializers$DateMidnightDeserializer
  extends JodaDeserializers.JodaDeserializer<DateMidnight>
{
  public JodaDeserializers$DateMidnightDeserializer()
  {
    super(DateMidnight.class);
  }
  
  public DateMidnight deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject = null;
    if (paramJsonParser.isExpectedStartArrayToken())
    {
      paramJsonParser.nextToken();
      int i = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int j = paramJsonParser.getIntValue();
      paramJsonParser.nextToken();
      int k = paramJsonParser.getIntValue();
      if (paramJsonParser.nextToken() != JsonToken.END_ARRAY) {
        paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.END_ARRAY, "after DateMidnight ints");
      }
      paramJsonParser = new DateMidnight(i, j, k);
    }
    for (;;)
    {
      return paramJsonParser;
      switch (JodaDeserializers.1.$SwitchMap$org$codehaus$jackson$JsonToken[paramJsonParser.getCurrentToken().ordinal()])
      {
      default: 
        paramDeserializationContext.wrongTokenException(paramJsonParser, JsonToken.START_ARRAY, "expected JSON Array, Number or String");
        paramJsonParser = (JsonParser)localObject;
        break;
      case 1: 
        paramJsonParser = new DateMidnight(paramJsonParser.getLongValue());
        break;
      case 2: 
        paramDeserializationContext = parseLocal(paramJsonParser);
        paramJsonParser = (JsonParser)localObject;
        if (paramDeserializationContext != null) {
          paramJsonParser = paramDeserializationContext.toDateMidnight();
        }
        break;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ext\JodaDeserializers$DateMidnightDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */