package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.Locale;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$LocaleDeserializer
  extends FromStringDeserializer<Locale>
{
  public FromStringDeserializer$LocaleDeserializer()
  {
    super(Locale.class);
  }
  
  protected Locale _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    int i = paramString.indexOf('_');
    if (i < 0) {
      paramString = new Locale(paramString);
    }
    for (;;)
    {
      return paramString;
      paramDeserializationContext = paramString.substring(0, i);
      paramString = paramString.substring(i + 1);
      i = paramString.indexOf('_');
      if (i < 0) {
        paramString = new Locale(paramDeserializationContext, paramString);
      } else {
        paramString = new Locale(paramDeserializationContext, paramString.substring(0, i), paramString.substring(i + 1));
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$LocaleDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */