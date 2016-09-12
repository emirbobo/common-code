package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.type.JavaType;

public class StdDeserializer$AtomicReferenceDeserializer
  extends StdScalarDeserializer<AtomicReference<?>>
  implements ResolvableDeserializer
{
  protected final BeanProperty _property;
  protected final JavaType _referencedType;
  protected JsonDeserializer<?> _valueDeserializer;
  
  public StdDeserializer$AtomicReferenceDeserializer(JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    super(AtomicReference.class);
    this._referencedType = paramJavaType;
    this._property = paramBeanProperty;
  }
  
  public AtomicReference<?> deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    return new AtomicReference(this._valueDeserializer.deserialize(paramJsonParser, paramDeserializationContext));
  }
  
  public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
    throws JsonMappingException
  {
    this._valueDeserializer = paramDeserializerProvider.findValueDeserializer(paramDeserializationConfig, this._referencedType, this._property);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\StdDeserializer$AtomicReferenceDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */