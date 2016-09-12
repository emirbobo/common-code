package org.codehaus.jackson.map.ser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap.SerializerAndMapResult;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public class BeanPropertyWriter
  implements BeanProperty
{
  protected final Method _accessorMethod;
  protected final JavaType _cfgSerializationType;
  protected final Annotations _contextAnnotations;
  protected final JavaType _declaredType;
  protected PropertySerializerMap _dynamicSerializers;
  protected final Field _field;
  protected Class<?>[] _includeInViews;
  protected HashMap<Object, Object> _internalSettings;
  protected final AnnotatedMember _member;
  protected final SerializedString _name;
  protected JavaType _nonTrivialBaseType;
  protected final JsonSerializer<Object> _serializer;
  protected final boolean _suppressNulls;
  protected final Object _suppressableValue;
  protected TypeSerializer _typeSerializer;
  
  public BeanPropertyWriter(AnnotatedMember paramAnnotatedMember, Annotations paramAnnotations, String paramString, JavaType paramJavaType1, JsonSerializer<Object> paramJsonSerializer, TypeSerializer paramTypeSerializer, JavaType paramJavaType2, Method paramMethod, Field paramField, boolean paramBoolean, Object paramObject)
  {
    this(paramAnnotatedMember, paramAnnotations, new SerializedString(paramString), paramJavaType1, paramJsonSerializer, paramTypeSerializer, paramJavaType2, paramMethod, paramField, paramBoolean, paramObject);
  }
  
  public BeanPropertyWriter(AnnotatedMember paramAnnotatedMember, Annotations paramAnnotations, SerializedString paramSerializedString, JavaType paramJavaType1, JsonSerializer<Object> paramJsonSerializer, TypeSerializer paramTypeSerializer, JavaType paramJavaType2, Method paramMethod, Field paramField, boolean paramBoolean, Object paramObject)
  {
    this._member = paramAnnotatedMember;
    this._contextAnnotations = paramAnnotations;
    this._name = paramSerializedString;
    this._declaredType = paramJavaType1;
    this._serializer = paramJsonSerializer;
    if (paramJsonSerializer == null) {}
    for (paramAnnotatedMember = PropertySerializerMap.emptyMap();; paramAnnotatedMember = null)
    {
      this._dynamicSerializers = paramAnnotatedMember;
      this._typeSerializer = paramTypeSerializer;
      this._cfgSerializationType = paramJavaType2;
      this._accessorMethod = paramMethod;
      this._field = paramField;
      this._suppressNulls = paramBoolean;
      this._suppressableValue = paramObject;
      return;
    }
  }
  
  protected BeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter)
  {
    this(paramBeanPropertyWriter, paramBeanPropertyWriter._serializer);
  }
  
  protected BeanPropertyWriter(BeanPropertyWriter paramBeanPropertyWriter, JsonSerializer<Object> paramJsonSerializer)
  {
    this._serializer = paramJsonSerializer;
    this._member = paramBeanPropertyWriter._member;
    this._contextAnnotations = paramBeanPropertyWriter._contextAnnotations;
    this._name = paramBeanPropertyWriter._name;
    this._declaredType = paramBeanPropertyWriter._declaredType;
    this._dynamicSerializers = paramBeanPropertyWriter._dynamicSerializers;
    this._typeSerializer = paramBeanPropertyWriter._typeSerializer;
    this._cfgSerializationType = paramBeanPropertyWriter._cfgSerializationType;
    this._accessorMethod = paramBeanPropertyWriter._accessorMethod;
    this._field = paramBeanPropertyWriter._field;
    this._suppressNulls = paramBeanPropertyWriter._suppressNulls;
    this._suppressableValue = paramBeanPropertyWriter._suppressableValue;
    if (paramBeanPropertyWriter._internalSettings != null) {
      this._internalSettings = new HashMap(paramBeanPropertyWriter._internalSettings);
    }
  }
  
  protected final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap paramPropertySerializerMap, Class<?> paramClass, SerializerProvider paramSerializerProvider)
    throws JsonMappingException
  {
    if (this._nonTrivialBaseType != null) {}
    for (paramClass = paramPropertySerializerMap.findAndAddSerializer(this._nonTrivialBaseType.forcedNarrowBy(paramClass), paramSerializerProvider, this);; paramClass = paramPropertySerializerMap.findAndAddSerializer(paramClass, paramSerializerProvider, this))
    {
      if (paramPropertySerializerMap != paramClass.map) {
        this._dynamicSerializers = paramClass.map;
      }
      return paramClass.serializer;
    }
  }
  
  protected void _reportSelfReference(Object paramObject)
    throws JsonMappingException
  {
    throw new JsonMappingException("Direct self-reference leading to cycle");
  }
  
  public final Object get(Object paramObject)
    throws Exception
  {
    if (this._accessorMethod != null) {}
    for (paramObject = this._accessorMethod.invoke(paramObject, new Object[0]);; paramObject = this._field.get(paramObject)) {
      return paramObject;
    }
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    return this._member.getAnnotation(paramClass);
  }
  
  public <A extends Annotation> A getContextAnnotation(Class<A> paramClass)
  {
    return this._contextAnnotations.get(paramClass);
  }
  
  public Type getGenericPropertyType()
  {
    if (this._accessorMethod != null) {}
    for (Type localType = this._accessorMethod.getGenericReturnType();; localType = this._field.getGenericType()) {
      return localType;
    }
  }
  
  public Object getInternalSetting(Object paramObject)
  {
    if (this._internalSettings == null) {}
    for (paramObject = null;; paramObject = this._internalSettings.get(paramObject)) {
      return paramObject;
    }
  }
  
  public AnnotatedMember getMember()
  {
    return this._member;
  }
  
  public String getName()
  {
    return this._name.getValue();
  }
  
  public Class<?> getPropertyType()
  {
    if (this._accessorMethod != null) {}
    for (Class localClass = this._accessorMethod.getReturnType();; localClass = this._field.getType()) {
      return localClass;
    }
  }
  
  public Class<?> getRawSerializationType()
  {
    if (this._cfgSerializationType == null) {}
    for (Object localObject = null;; localObject = this._cfgSerializationType.getRawClass()) {
      return (Class<?>)localObject;
    }
  }
  
  public JavaType getSerializationType()
  {
    return this._cfgSerializationType;
  }
  
  public SerializedString getSerializedName()
  {
    return this._name;
  }
  
  protected JsonSerializer<Object> getSerializer()
  {
    return this._serializer;
  }
  
  public JavaType getType()
  {
    return this._declaredType;
  }
  
  public Class<?>[] getViews()
  {
    return this._includeInViews;
  }
  
  public boolean hasSerializer()
  {
    if (this._serializer != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Object removeInternalSetting(Object paramObject)
  {
    Object localObject = null;
    if (this._internalSettings != null)
    {
      paramObject = this._internalSettings.remove(paramObject);
      localObject = paramObject;
      if (this._internalSettings.size() == 0)
      {
        this._internalSettings = null;
        localObject = paramObject;
      }
    }
    return localObject;
  }
  
  public void serializeAsField(Object paramObject, JsonGenerator paramJsonGenerator, SerializerProvider paramSerializerProvider)
    throws Exception
  {
    Object localObject = get(paramObject);
    if (localObject == null) {
      if (!this._suppressNulls)
      {
        paramJsonGenerator.writeFieldName(this._name);
        paramSerializerProvider.defaultSerializeNull(paramJsonGenerator);
      }
    }
    for (;;)
    {
      return;
      if (localObject == paramObject) {
        _reportSelfReference(paramObject);
      }
      if ((this._suppressableValue == null) || (!this._suppressableValue.equals(localObject)))
      {
        JsonSerializer localJsonSerializer = this._serializer;
        paramObject = localJsonSerializer;
        if (localJsonSerializer == null)
        {
          Class localClass = localObject.getClass();
          PropertySerializerMap localPropertySerializerMap = this._dynamicSerializers;
          localJsonSerializer = localPropertySerializerMap.serializerFor(localClass);
          paramObject = localJsonSerializer;
          if (localJsonSerializer == null) {
            paramObject = _findAndAddDynamic(localPropertySerializerMap, localClass, paramSerializerProvider);
          }
        }
        paramJsonGenerator.writeFieldName(this._name);
        if (this._typeSerializer == null) {
          ((JsonSerializer)paramObject).serialize(localObject, paramJsonGenerator, paramSerializerProvider);
        } else {
          ((JsonSerializer)paramObject).serializeWithType(localObject, paramJsonGenerator, paramSerializerProvider, this._typeSerializer);
        }
      }
    }
  }
  
  public Object setInternalSetting(Object paramObject1, Object paramObject2)
  {
    if (this._internalSettings == null) {
      this._internalSettings = new HashMap();
    }
    return this._internalSettings.put(paramObject1, paramObject2);
  }
  
  public void setNonTrivialBaseType(JavaType paramJavaType)
  {
    this._nonTrivialBaseType = paramJavaType;
  }
  
  public void setViews(Class<?>[] paramArrayOfClass)
  {
    this._includeInViews = paramArrayOfClass;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(40);
    localStringBuilder.append("property '").append(getName()).append("' (");
    if (this._accessorMethod != null)
    {
      localStringBuilder.append("via method ").append(this._accessorMethod.getDeclaringClass().getName()).append("#").append(this._accessorMethod.getName());
      if (this._serializer != null) {
        break label142;
      }
      localStringBuilder.append(", no static serializer");
    }
    for (;;)
    {
      localStringBuilder.append(')');
      return localStringBuilder.toString();
      localStringBuilder.append("field \"").append(this._field.getDeclaringClass().getName()).append("#").append(this._field.getName());
      break;
      label142:
      localStringBuilder.append(", static serializer of type " + this._serializer.getClass().getName());
    }
  }
  
  public BeanPropertyWriter withSerializer(JsonSerializer<Object> paramJsonSerializer)
  {
    if (getClass() != BeanPropertyWriter.class) {
      throw new IllegalStateException("BeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
    }
    return new BeanPropertyWriter(this, paramJsonSerializer);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\BeanPropertyWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */