package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Method;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.ClassUtil;

public class EnumDeserializer$FactoryBasedDeserializer
  extends StdScalarDeserializer<Object>
{
  protected final Class<?> _enumClass;
  protected final Method _factory;
  
  public EnumDeserializer$FactoryBasedDeserializer(Class<?> paramClass, AnnotatedMethod paramAnnotatedMethod)
  {
    super(Enum.class);
    this._enumClass = paramClass;
    this._factory = paramAnnotatedMethod.getAnnotated();
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (paramJsonParser.getCurrentToken() != JsonToken.VALUE_STRING) {
      throw paramDeserializationContext.mappingException(this._enumClass);
    }
    paramJsonParser = paramJsonParser.getText();
    try
    {
      paramJsonParser = this._factory.invoke(this._enumClass, new Object[] { paramJsonParser });
      return paramJsonParser;
    }
    catch (Exception paramJsonParser)
    {
      for (;;)
      {
        ClassUtil.unwrapAndThrowAsIAE(paramJsonParser);
        paramJsonParser = null;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\EnumDeserializer$FactoryBasedDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */