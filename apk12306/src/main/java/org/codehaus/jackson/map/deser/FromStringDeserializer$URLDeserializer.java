package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.net.URL;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$URLDeserializer
  extends FromStringDeserializer<URL>
{
  public FromStringDeserializer$URLDeserializer()
  {
    super(URL.class);
  }
  
  protected URL _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return new URL(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$URLDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */