package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

@JacksonStdImpl
public final class StdSerializers$LongSerializer
  extends ScalarSerializerBase<Long>
{
  static final LongSerializer instance = new LongSerializer();
  
  public StdSerializers$LongSerializer()
  {
    super(Long.class);
  }
  
  public JsonNode getSchema(SerializerProvider paramSerializerProvider, Type paramType)
  {
    return createSchemaNode("number", true);
  }
  
  public void serialize(Long paramLong, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws IOException, JsonGenerationException
  {
    paramJsonGenerator.writeNumber(paramLong.longValue());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\StdSerializers$LongSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */