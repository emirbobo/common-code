package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

final class Creator$PropertyBased
{
  protected final Constructor<?> _ctor;
  protected final Object[] _defaultValues;
  protected final Method _factoryMethod;
  protected final HashMap<String, SettableBeanProperty> _properties;
  
  public Creator$PropertyBased(AnnotatedConstructor paramAnnotatedConstructor, SettableBeanProperty[] paramArrayOfSettableBeanProperty1, AnnotatedMethod paramAnnotatedMethod, SettableBeanProperty[] paramArrayOfSettableBeanProperty2)
  {
    if (paramAnnotatedConstructor != null)
    {
      this._ctor = paramAnnotatedConstructor.getAnnotated();
      this._factoryMethod = null;
    }
    for (paramAnnotatedMethod = paramArrayOfSettableBeanProperty1;; paramAnnotatedMethod = paramArrayOfSettableBeanProperty2)
    {
      this._properties = new HashMap();
      paramAnnotatedConstructor = null;
      int i = 0;
      int j = paramAnnotatedMethod.length;
      while (i < j)
      {
        paramArrayOfSettableBeanProperty2 = paramAnnotatedMethod[i];
        this._properties.put(paramArrayOfSettableBeanProperty2.getName(), paramArrayOfSettableBeanProperty2);
        paramArrayOfSettableBeanProperty1 = paramAnnotatedConstructor;
        if (paramArrayOfSettableBeanProperty2.getType().isPrimitive())
        {
          paramArrayOfSettableBeanProperty1 = paramAnnotatedConstructor;
          if (paramAnnotatedConstructor == null) {
            paramArrayOfSettableBeanProperty1 = new Object[j];
          }
          paramArrayOfSettableBeanProperty1[i] = ClassUtil.defaultValue(paramArrayOfSettableBeanProperty2.getType().getRawClass());
        }
        i++;
        paramAnnotatedConstructor = paramArrayOfSettableBeanProperty1;
      }
      if (paramAnnotatedMethod == null) {
        break;
      }
      this._ctor = null;
      this._factoryMethod = paramAnnotatedMethod.getAnnotated();
    }
    throw new IllegalArgumentException("Internal error: neither delegating constructor nor factory method passed");
    this._defaultValues = paramAnnotatedConstructor;
  }
  
  public Object build(PropertyValueBuffer paramPropertyValueBuffer)
    throws Exception
  {
    Object localObject1 = null;
    try
    {
      Object localObject2;
      if (this._ctor != null) {
        localObject2 = this._ctor.newInstance(paramPropertyValueBuffer.getParameters(this._defaultValues));
      }
      for (localObject1 = localObject2;; localObject1 = localObject2)
      {
        for (localObject2 = paramPropertyValueBuffer.buffered();; localObject2 = ((PropertyValue)localObject2).next)
        {
          paramPropertyValueBuffer = (PropertyValueBuffer)localObject1;
          if (localObject2 == null) {
            break;
          }
          ((PropertyValue)localObject2).assign(localObject1);
        }
        localObject2 = this._factoryMethod.invoke(null, paramPropertyValueBuffer.getParameters(this._defaultValues));
      }
      return paramPropertyValueBuffer;
    }
    catch (Exception paramPropertyValueBuffer)
    {
      ClassUtil.throwRootCause(paramPropertyValueBuffer);
      paramPropertyValueBuffer = (PropertyValueBuffer)localObject1;
    }
  }
  
  public SettableBeanProperty findCreatorProperty(String paramString)
  {
    return (SettableBeanProperty)this._properties.get(paramString);
  }
  
  public Collection<SettableBeanProperty> properties()
  {
    return this._properties.values();
  }
  
  public PropertyValueBuffer startBuilding(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
  {
    return new PropertyValueBuffer(paramJsonParser, paramDeserializationContext, this._properties.size());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\Creator$PropertyBased.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */