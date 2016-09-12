package org.codehaus.jackson.map.deser;

import java.util.regex.Pattern;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$PatternDeserializer
  extends FromStringDeserializer<Pattern>
{
  public FromStringDeserializer$PatternDeserializer()
  {
    super(Pattern.class);
  }
  
  protected Pattern _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return Pattern.compile(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$PatternDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */