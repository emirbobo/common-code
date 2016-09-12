package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

final class Creator$Delegating
{
  protected final AnnotatedMember _creator;
  protected final Constructor<?> _ctor;
  protected JsonDeserializer<Object> _deserializer;
  protected final Method _factoryMethod;
  protected final JavaType _valueType;
  
  public Creator$Delegating(BasicBeanDescription paramBasicBeanDescription, AnnotatedConstructor paramAnnotatedConstructor, AnnotatedMethod paramAnnotatedMethod)
  {
    paramBasicBeanDescription = paramBasicBeanDescription.bindingsForBeanType();
    if (paramAnnotatedConstructor != null)
    {
      this._creator = paramAnnotatedConstructor;
      this._ctor = paramAnnotatedConstructor.getAnnotated();
      this._factoryMethod = null;
    }
    for (this._valueType = paramBasicBeanDescription.resolveType(paramAnnotatedConstructor.getParameterType(0));; this._valueType = paramBasicBeanDescription.resolveType(paramAnnotatedMethod.getParameterType(0)))
    {
      return;
      if (paramAnnotatedMethod == null) {
        break;
      }
      this._creator = paramAnnotatedMethod;
      this._ctor = null;
      this._factoryMethod = paramAnnotatedMethod.getAnnotated();
    }
    throw new IllegalArgumentException("Internal error: neither delegating constructor nor factory method passed");
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Object localObject = null;
    paramJsonParser = this._deserializer.deserialize(paramJsonParser, paramDeserializationContext);
    try
    {
      if (this._ctor != null) {}
      for (paramJsonParser = this._ctor.newInstance(new Object[] { paramJsonParser });; paramJsonParser = this._factoryMethod.invoke(null, new Object[] { paramJsonParser })) {
        return paramJsonParser;
      }
    }
    catch (Exception paramJsonParser)
    {
      for (;;)
      {
        ClassUtil.unwrapAndThrowAsIAE(paramJsonParser);
        paramJsonParser = (JsonParser)localObject;
      }
    }
  }
  
  public AnnotatedMember getCreator()
  {
    return this._creator;
  }
  
  public JavaType getValueType()
  {
    return this._valueType;
  }
  
  public void setDeserializer(JsonDeserializer<Object> paramJsonDeserializer)
  {
    this._deserializer = paramJsonDeserializer;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\Creator$Delegating.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */