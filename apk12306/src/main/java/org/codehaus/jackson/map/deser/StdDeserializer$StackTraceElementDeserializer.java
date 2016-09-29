package org.codehaus.jackson.map.deser;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonMappingException;

public class StdDeserializer$StackTraceElementDeserializer
  extends StdScalarDeserializer<StackTraceElement>
{
  public StdDeserializer$StackTraceElementDeserializer()
  {
    super(StackTraceElement.class);
  }
  
  public StackTraceElement deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramJsonParser.getCurrentToken() == JsonToken.START_OBJECT)
    {
      String str3 = "";
      String str1 = "";
      String str2 = "";
      int i = -1;
      for (;;)
      {
        JsonToken localJsonToken = paramJsonParser.nextValue();
        if (localJsonToken == JsonToken.END_OBJECT) {
          break;
        }
        String str4 = paramJsonParser.getCurrentName();
        if ("className".equals(str4)) {
          str3 = paramJsonParser.getText();
        } else if ("fileName".equals(str4)) {
          str2 = paramJsonParser.getText();
        } else if ("lineNumber".equals(str4))
        {
          if (localJsonToken.isNumeric()) {
            i = paramJsonParser.getIntValue();
          } else {
            throw JsonMappingException.from(paramJsonParser, "Non-numeric token (" + localJsonToken + ") for property 'lineNumber'");
          }
        }
        else if ("methodName".equals(str4)) {
          str1 = paramJsonParser.getText();
        } else if (!"nativeMethod".equals(str4)) {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, this._valueClass, str4);
        }
      }
      return new StackTraceElement(str3, str1, str2, i);
    }
    throw paramDeserializationContext.mappingException(this._valueClass);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$StackTraceElementDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */