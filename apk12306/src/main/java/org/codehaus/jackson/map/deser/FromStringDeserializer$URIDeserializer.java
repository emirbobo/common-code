package org.codehaus.jackson.map.deser;

import java.net.URI;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$URIDeserializer
  extends FromStringDeserializer<URI>
{
  public FromStringDeserializer$URIDeserializer()
  {
    super(URI.class);
  }
  
  protected URI _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IllegalArgumentException
  {
    return URI.create(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$URIDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */