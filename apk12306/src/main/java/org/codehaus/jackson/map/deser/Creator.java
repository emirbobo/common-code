package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
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

abstract class Creator
{
  static final class Delegating
  {
    protected final AnnotatedMember _creator;
    protected final Constructor<?> _ctor;
    protected JsonDeserializer<Object> _deserializer;
    protected final Method _factoryMethod;
    protected final JavaType _valueType;
    
    public Delegating(BasicBeanDescription paramBasicBeanDescription, AnnotatedConstructor paramAnnotatedConstructor, AnnotatedMethod paramAnnotatedMethod)
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
  
  static final class NumberBased
  {
    protected final Constructor<?> _intCtor;
    protected final Method _intFactoryMethod;
    protected final Constructor<?> _longCtor;
    protected final Method _longFactoryMethod;
    protected final Class<?> _valueClass;
    
    public NumberBased(Class<?> paramClass, AnnotatedConstructor paramAnnotatedConstructor1, AnnotatedMethod paramAnnotatedMethod1, AnnotatedConstructor paramAnnotatedConstructor2, AnnotatedMethod paramAnnotatedMethod2)
    {
      this._valueClass = paramClass;
      if (paramAnnotatedConstructor1 == null)
      {
        paramClass = null;
        this._intCtor = paramClass;
        if (paramAnnotatedConstructor2 != null) {
          break label68;
        }
        paramClass = null;
        label30:
        this._longCtor = paramClass;
        if (paramAnnotatedMethod1 != null) {
          break label77;
        }
        paramClass = null;
        label41:
        this._intFactoryMethod = paramClass;
        if (paramAnnotatedMethod2 != null) {
          break label85;
        }
      }
      label68:
      label77:
      label85:
      for (paramClass = (Class<?>)localObject;; paramClass = paramAnnotatedMethod2.getAnnotated())
      {
        this._longFactoryMethod = paramClass;
        return;
        paramClass = paramAnnotatedConstructor1.getAnnotated();
        break;
        paramClass = paramAnnotatedConstructor2.getAnnotated();
        break label30;
        paramClass = paramAnnotatedMethod1.getAnnotated();
        break label41;
      }
    }
    
    public Object construct(int paramInt)
    {
      try
      {
        if (this._intCtor != null) {}
        for (Object localObject1 = this._intCtor.newInstance(new Object[] { Integer.valueOf(paramInt) });; localObject1 = this._intFactoryMethod.invoke(this._valueClass, new Object[] { Integer.valueOf(paramInt) }))
        {
          return localObject1;
          if (this._intFactoryMethod == null) {
            break;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ClassUtil.unwrapAndThrowAsIAE(localException);
          Object localObject2 = construct(paramInt);
        }
      }
    }
    
    public Object construct(long paramLong)
    {
      try
      {
        if (this._longCtor != null) {}
        for (Object localObject1 = this._longCtor.newInstance(new Object[] { Long.valueOf(paramLong) });; localObject1 = this._longFactoryMethod.invoke(this._valueClass, new Object[] { Long.valueOf(paramLong) }))
        {
          return localObject1;
          if (this._longFactoryMethod == null) {
            break;
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ClassUtil.unwrapAndThrowAsIAE(localException);
          Object localObject2 = null;
        }
      }
    }
  }
  
  static final class PropertyBased
  {
    protected final Constructor<?> _ctor;
    protected final Object[] _defaultValues;
    protected final Method _factoryMethod;
    protected final HashMap<String, SettableBeanProperty> _properties;
    
    public PropertyBased(AnnotatedConstructor paramAnnotatedConstructor, SettableBeanProperty[] paramArrayOfSettableBeanProperty1, AnnotatedMethod paramAnnotatedMethod, SettableBeanProperty[] paramArrayOfSettableBeanProperty2)
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
  
  static final class StringBased
  {
    protected final Constructor<?> _ctor;
    protected final Method _factoryMethod;
    protected final Class<?> _valueClass;
    
    public StringBased(Class<?> paramClass, AnnotatedConstructor paramAnnotatedConstructor, AnnotatedMethod paramAnnotatedMethod)
    {
      this._valueClass = paramClass;
      if (paramAnnotatedConstructor == null)
      {
        paramClass = null;
        this._ctor = paramClass;
        if (paramAnnotatedMethod != null) {
          break label44;
        }
      }
      label44:
      for (paramClass = (Class<?>)localObject;; paramClass = paramAnnotatedMethod.getAnnotated())
      {
        this._factoryMethod = paramClass;
        return;
        paramClass = paramAnnotatedConstructor.getAnnotated();
        break;
      }
    }
    
    public Object construct(String paramString)
    {
      try
      {
        if (this._ctor != null) {}
        for (paramString = this._ctor.newInstance(new Object[] { paramString });; paramString = this._factoryMethod.invoke(this._valueClass, new Object[] { paramString }))
        {
          return paramString;
          if (this._factoryMethod == null) {
            break;
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          ClassUtil.unwrapAndThrowAsIAE(paramString);
          paramString = null;
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\Creator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */