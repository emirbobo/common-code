package org.codehaus.jackson.map.deser;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.UUID;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;

public class FromStringDeserializer$UUIDDeserializer
  extends FromStringDeserializer<UUID>
{
  public FromStringDeserializer$UUIDDeserializer()
  {
    super(UUID.class);
  }
  
  protected UUID _deserialize(String paramString, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    return UUID.fromString(paramString);
  }
  
  protected UUID _deserializeEmbedded(Object paramObject, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      if (paramObject.length != 16) {
        paramDeserializationContext.mappingException("Can only construct UUIDs from 16 byte arrays; got " + paramObject.length + " bytes");
      }
      paramObject = new DataInputStream(new ByteArrayInputStream((byte[])paramObject));
    }
    for (paramObject = new UUID(((DataInputStream)paramObject).readLong(), ((DataInputStream)paramObject).readLong());; paramObject = null)
    {
      return (UUID)paramObject;
      super._deserializeEmbedded(paramObject, paramDeserializationContext);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\FromStringDeserializer$UUIDDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */