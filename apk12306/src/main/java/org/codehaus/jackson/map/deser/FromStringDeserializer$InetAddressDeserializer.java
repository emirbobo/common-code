package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.net.InetAddress;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$InetAddressDeserializer
  extends FromStringDeserializer<InetAddress>
{
  public FromStringDeserializer$InetAddressDeserializer()
  {
    super(InetAddress.class);
  }
  
  protected InetAddress _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    return InetAddress.getByName(paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$InetAddressDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */