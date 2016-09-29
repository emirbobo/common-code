package org.codehaus.jackson.map.deser;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ResolvableDeserializer;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.annotate.JsonCachable;
import org.codehaus.jackson.map.deser.impl.BeanPropertyMap;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.util.TokenBuffer;

@JsonCachable
public class BeanDeserializer
  extends StdDeserializer<Object>
  implements ResolvableDeserializer
{
  protected final SettableAnyProperty _anySetter;
  protected final Map<String, SettableBeanProperty> _backRefs;
  protected final BeanPropertyMap _beanProperties;
  protected final JavaType _beanType;
  protected final Constructor<?> _defaultConstructor;
  protected final Creator.Delegating _delegatingCreator;
  protected final AnnotatedClass _forClass;
  protected final HashSet<String> _ignorableProps;
  protected final boolean _ignoreAllUnknown;
  protected final Creator.NumberBased _numberCreator;
  protected final BeanProperty _property;
  protected final Creator.PropertyBased _propertyBasedCreator;
  protected final Creator.StringBased _stringCreator;
  protected HashMap<ClassKey, JsonDeserializer<Object>> _subDeserializers;
  
  protected BeanDeserializer(BeanDeserializer paramBeanDeserializer)
  {
    super(paramBeanDeserializer._beanType);
    this._forClass = paramBeanDeserializer._forClass;
    this._beanType = paramBeanDeserializer._beanType;
    this._property = paramBeanDeserializer._property;
    this._beanProperties = paramBeanDeserializer._beanProperties;
    this._backRefs = paramBeanDeserializer._backRefs;
    this._ignorableProps = paramBeanDeserializer._ignorableProps;
    this._ignoreAllUnknown = paramBeanDeserializer._ignoreAllUnknown;
    this._anySetter = paramBeanDeserializer._anySetter;
    this._defaultConstructor = paramBeanDeserializer._defaultConstructor;
    this._stringCreator = paramBeanDeserializer._stringCreator;
    this._numberCreator = paramBeanDeserializer._numberCreator;
    this._delegatingCreator = paramBeanDeserializer._delegatingCreator;
    this._propertyBasedCreator = paramBeanDeserializer._propertyBasedCreator;
  }
  
  public BeanDeserializer(AnnotatedClass paramAnnotatedClass, JavaType paramJavaType, BeanProperty paramBeanProperty, CreatorContainer paramCreatorContainer, BeanPropertyMap paramBeanPropertyMap, Map<String, SettableBeanProperty> paramMap, HashSet<String> paramHashSet, boolean paramBoolean, SettableAnyProperty paramSettableAnyProperty)
  {
    super(paramJavaType);
    this._forClass = paramAnnotatedClass;
    this._beanType = paramJavaType;
    this._property = paramBeanProperty;
    this._beanProperties = paramBeanPropertyMap;
    this._backRefs = paramMap;
    this._ignorableProps = paramHashSet;
    this._ignoreAllUnknown = paramBoolean;
    this._anySetter = paramSettableAnyProperty;
    this._stringCreator = paramCreatorContainer.stringCreator();
    this._numberCreator = paramCreatorContainer.numberCreator();
    this._delegatingCreator = paramCreatorContainer.delegatingCreator();
    this._propertyBasedCreator = paramCreatorContainer.propertyBasedCreator();
    if ((this._delegatingCreator != null) || (this._propertyBasedCreator != null)) {}
    for (this._defaultConstructor = null;; this._defaultConstructor = paramCreatorContainer.getDefaultConstructor()) {
      return;
    }
  }
  
  protected final Object _deserializeUsingPropertyBased(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    Creator.PropertyBased localPropertyBased = this._propertyBasedCreator;
    PropertyValueBuffer localPropertyValueBuffer = localPropertyBased.startBuilding(paramJsonParser, paramDeserializationContext);
    Object localObject1 = null;
    Object localObject4 = paramJsonParser.getCurrentToken();
    Object localObject2;
    if (localObject4 == JsonToken.FIELD_NAME)
    {
      localObject4 = paramJsonParser.getCurrentName();
      paramJsonParser.nextToken();
      SettableBeanProperty localSettableBeanProperty = localPropertyBased.findCreatorProperty((String)localObject4);
      if (localSettableBeanProperty != null)
      {
        Object localObject5 = localSettableBeanProperty.deserialize(paramJsonParser, paramDeserializationContext);
        localObject2 = localObject1;
        if (localPropertyValueBuffer.assignParameter(localSettableBeanProperty.getCreatorIndex(), localObject5)) {
          paramJsonParser.nextToken();
        }
      }
    }
    for (;;)
    {
      label122:
      Object localObject3;
      try
      {
        localObject2 = localPropertyBased.build(localPropertyValueBuffer);
        if (localObject2.getClass() != this._beanType.getRawClass())
        {
          paramJsonParser = handlePolymorphic(paramJsonParser, paramDeserializationContext, localObject2, (TokenBuffer)localObject1);
          return paramJsonParser;
        }
      }
      catch (Exception localException)
      {
        wrapAndThrow(localException, this._beanType.getRawClass(), (String)localObject4, paramDeserializationContext);
        localObject3 = localObject1;
      }
      for (;;)
      {
        localObject4 = paramJsonParser.nextToken();
        localObject1 = localObject3;
        break;
        localObject4 = localObject3;
        if (localObject1 != null) {
          localObject4 = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
        }
        paramJsonParser = deserialize(paramJsonParser, paramDeserializationContext, localObject4);
        break label122;
        localObject3 = this._beanProperties.find((String)localObject4);
        if (localObject3 != null)
        {
          localPropertyValueBuffer.bufferProperty((SettableBeanProperty)localObject3, ((SettableBeanProperty)localObject3).deserialize(paramJsonParser, paramDeserializationContext));
          localObject3 = localObject1;
        }
        else if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject4)))
        {
          paramJsonParser.skipChildren();
          localObject3 = localObject1;
        }
        else if (this._anySetter != null)
        {
          localPropertyValueBuffer.bufferAnyProperty(this._anySetter, (String)localObject4, this._anySetter.deserialize(paramJsonParser, paramDeserializationContext));
          localObject3 = localObject1;
        }
        else
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new TokenBuffer(paramJsonParser.getCodec());
          }
          ((TokenBuffer)localObject3).writeFieldName((String)localObject4);
          ((TokenBuffer)localObject3).copyCurrentStructure(paramJsonParser);
        }
      }
      try
      {
        localObject3 = localPropertyBased.build(localPropertyValueBuffer);
        paramJsonParser = (JsonParser)localObject3;
        if (localObject1 == null) {
          continue;
        }
        if (localObject3.getClass() == this._beanType.getRawClass()) {
          break label378;
        }
        paramJsonParser = handlePolymorphic(null, paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
      }
      catch (Exception paramJsonParser)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
        paramJsonParser = null;
      }
      continue;
      label378:
      paramJsonParser = handleUnknownProperties(paramDeserializationContext, localObject3, (TokenBuffer)localObject1);
    }
  }
  
  protected JsonDeserializer<Object> _findSubclassDeserializer(DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    for (;;)
    {
      Object localObject;
      try
      {
        if (this._subDeserializers == null)
        {
          paramTokenBuffer = null;
          if (paramTokenBuffer != null) {
            return paramTokenBuffer;
          }
        }
        else
        {
          paramTokenBuffer = this._subDeserializers;
          localObject = new org/codehaus/jackson/map/type/ClassKey;
          ((ClassKey)localObject).<init>(paramObject.getClass());
          paramTokenBuffer = (JsonDeserializer)paramTokenBuffer.get(localObject);
          continue;
        }
        localObject = paramDeserializationContext.getDeserializerProvider();
      }
      finally {}
      if (localObject != null)
      {
        paramTokenBuffer = paramDeserializationContext.constructType(paramObject.getClass());
        paramDeserializationContext = ((DeserializerProvider)localObject).findValueDeserializer(paramDeserializationContext.getConfig(), paramTokenBuffer, this._property);
        paramTokenBuffer = paramDeserializationContext;
        if (paramDeserializationContext == null) {}
      }
      try
      {
        if (this._subDeserializers == null)
        {
          paramTokenBuffer = new java/util/HashMap;
          paramTokenBuffer.<init>();
          this._subDeserializers = paramTokenBuffer;
        }
        paramTokenBuffer = this._subDeserializers;
        localObject = new org/codehaus/jackson/map/type/ClassKey;
        ((ClassKey)localObject).<init>(paramObject.getClass());
        paramTokenBuffer.put(localObject, paramDeserializationContext);
        paramTokenBuffer = paramDeserializationContext;
      }
      finally {}
    }
  }
  
  protected Object constructDefaultInstance()
  {
    try
    {
      Object localObject1 = this._defaultConstructor.newInstance(new Object[0]);
      return localObject1;
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
  
  public final Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    JsonToken localJsonToken = paramJsonParser.getCurrentToken();
    if (localJsonToken == JsonToken.START_OBJECT)
    {
      paramJsonParser.nextToken();
      paramJsonParser = deserializeFromObject(paramJsonParser, paramDeserializationContext);
    }
    for (;;)
    {
      return paramJsonParser;
      switch (1.$SwitchMap$org$codehaus$jackson$JsonToken[localJsonToken.ordinal()])
      {
      default: 
        throw paramDeserializationContext.mappingException(getBeanClass());
      case 1: 
        paramJsonParser = deserializeFromString(paramJsonParser, paramDeserializationContext);
        break;
      case 2: 
      case 3: 
        paramJsonParser = deserializeFromNumber(paramJsonParser, paramDeserializationContext);
        break;
      case 4: 
        paramJsonParser = paramJsonParser.getEmbeddedObject();
        break;
      case 5: 
      case 6: 
      case 7: 
        paramJsonParser = deserializeUsingCreator(paramJsonParser, paramDeserializationContext);
        break;
      case 8: 
      case 9: 
        paramJsonParser = deserializeFromObject(paramJsonParser, paramDeserializationContext);
      }
    }
  }
  
  public Object deserialize(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject)
    throws IOException, JsonProcessingException
  {
    Object localObject2 = paramJsonParser.getCurrentToken();
    Object localObject1 = localObject2;
    if (localObject2 == JsonToken.START_OBJECT) {
      localObject1 = paramJsonParser.nextToken();
    }
    if (localObject1 == JsonToken.FIELD_NAME)
    {
      localObject1 = paramJsonParser.getCurrentName();
      localObject2 = this._beanProperties.find((String)localObject1);
      paramJsonParser.nextToken();
      if (localObject2 != null) {}
      for (;;)
      {
        try
        {
          ((SettableBeanProperty)localObject2).deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject);
          localObject1 = paramJsonParser.nextToken();
        }
        catch (Exception localException)
        {
          wrapAndThrow(localException, paramObject, (String)localObject1, paramDeserializationContext);
          continue;
        }
        if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject1))) {
          paramJsonParser.skipChildren();
        } else if (this._anySetter != null) {
          this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
        } else {
          handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, (String)localObject1);
        }
      }
    }
    return paramObject;
  }
  
  public Object deserializeFromNumber(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (this._numberCreator != null) {}
    switch (paramJsonParser.getNumberType())
    {
    default: 
      if (this._delegatingCreator != null) {
        paramJsonParser = this._delegatingCreator.deserialize(paramJsonParser, paramDeserializationContext);
      }
      break;
    case ???: 
    case ???: 
      for (;;)
      {
        return paramJsonParser;
        paramJsonParser = this._numberCreator.construct(paramJsonParser.getIntValue());
        continue;
        paramJsonParser = this._numberCreator.construct(paramJsonParser.getLongValue());
      }
    }
    throw paramDeserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON Number");
  }
  
  public Object deserializeFromObject(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (this._defaultConstructor == null) {
      if (this._propertyBasedCreator != null) {
        localObject1 = _deserializeUsingPropertyBased(paramJsonParser, paramDeserializationContext);
      }
    }
    Object localObject2;
    do
    {
      for (;;)
      {
        return localObject1;
        if (this._delegatingCreator == null) {
          break;
        }
        localObject1 = this._delegatingCreator.deserialize(paramJsonParser, paramDeserializationContext);
      }
      if (this._beanType.isAbstract()) {
        throw JsonMappingException.from(paramJsonParser, "Can not instantiate abstract type " + this._beanType + " (need to add/enable type information?)");
      }
      throw JsonMappingException.from(paramJsonParser, "No suitable constructor found for type " + this._beanType + ": can not instantiate from JSON object (need to add/enable type information?)");
      localObject2 = constructDefaultInstance();
      localObject1 = localObject2;
    } while (paramJsonParser.getCurrentToken() == JsonToken.END_OBJECT);
    Object localObject1 = paramJsonParser.getCurrentName();
    paramJsonParser.nextToken();
    SettableBeanProperty localSettableBeanProperty = this._beanProperties.find((String)localObject1);
    if (localSettableBeanProperty != null) {}
    for (;;)
    {
      try
      {
        localSettableBeanProperty.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2);
        paramJsonParser.nextToken();
      }
      catch (Exception localException1)
      {
        wrapAndThrow(localException1, localObject2, (String)localObject1, paramDeserializationContext);
        continue;
      }
      if ((this._ignorableProps != null) && (this._ignorableProps.contains(localObject1))) {
        paramJsonParser.skipChildren();
      } else if (this._anySetter != null) {
        try
        {
          this._anySetter.deserializeAndSet(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject1);
        }
        catch (Exception localException2)
        {
          wrapAndThrow(localException2, localObject2, (String)localObject1, paramDeserializationContext);
        }
      } else {
        handleUnknownProperty(paramJsonParser, paramDeserializationContext, localObject2, (String)localObject1);
      }
    }
  }
  
  public Object deserializeFromString(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (this._stringCreator != null) {
      paramJsonParser = this._stringCreator.construct(paramJsonParser.getText());
    }
    for (;;)
    {
      return paramJsonParser;
      if (this._delegatingCreator != null)
      {
        paramJsonParser = this._delegatingCreator.deserialize(paramJsonParser, paramDeserializationContext);
      }
      else
      {
        if ((!paramDeserializationContext.isEnabled(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)) || (paramJsonParser.getTextLength() != 0)) {
          break;
        }
        paramJsonParser = null;
      }
    }
    throw paramDeserializationContext.instantiationException(getBeanClass(), "no suitable creator method found to deserialize from JSON String");
  }
  
  public Object deserializeUsingCreator(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext)
    throws IOException, JsonProcessingException
  {
    if (this._delegatingCreator != null) {
      try
      {
        paramJsonParser = this._delegatingCreator.deserialize(paramJsonParser, paramDeserializationContext);
        return paramJsonParser;
      }
      catch (Exception paramJsonParser)
      {
        wrapInstantiationProblem(paramJsonParser, paramDeserializationContext);
      }
    }
    throw paramDeserializationContext.mappingException(getBeanClass());
  }
  
  public Object deserializeWithType(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, TypeDeserializer paramTypeDeserializer)
    throws IOException, JsonProcessingException
  {
    return paramTypeDeserializer.deserializeTypedFromObject(paramJsonParser, paramDeserializationContext);
  }
  
  public SettableBeanProperty findBackReference(String paramString)
  {
    if (this._backRefs == null) {}
    for (paramString = null;; paramString = (SettableBeanProperty)this._backRefs.get(paramString)) {
      return paramString;
    }
  }
  
  public final Class<?> getBeanClass()
  {
    return this._beanType.getRawClass();
  }
  
  public int getPropertyCount()
  {
    return this._beanProperties.size();
  }
  
  public JavaType getValueType()
  {
    return this._beanType;
  }
  
  protected Object handlePolymorphic(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    JsonDeserializer localJsonDeserializer = _findSubclassDeserializer(paramDeserializationContext, paramObject, paramTokenBuffer);
    Object localObject;
    if (localJsonDeserializer != null)
    {
      localObject = paramObject;
      if (paramTokenBuffer != null)
      {
        paramTokenBuffer.writeEndObject();
        paramTokenBuffer = paramTokenBuffer.asParser();
        paramTokenBuffer.nextToken();
        localObject = localJsonDeserializer.deserialize(paramTokenBuffer, paramDeserializationContext, paramObject);
      }
      paramObject = localObject;
      if (paramJsonParser != null) {
        paramObject = localJsonDeserializer.deserialize(paramJsonParser, paramDeserializationContext, localObject);
      }
    }
    for (;;)
    {
      return paramObject;
      localObject = paramObject;
      if (paramTokenBuffer != null) {
        localObject = handleUnknownProperties(paramDeserializationContext, paramObject, paramTokenBuffer);
      }
      paramObject = localObject;
      if (paramJsonParser != null) {
        paramObject = deserialize(paramJsonParser, paramDeserializationContext, localObject);
      }
    }
  }
  
  protected Object handleUnknownProperties(DeserializationContext paramDeserializationContext, Object paramObject, TokenBuffer paramTokenBuffer)
    throws IOException, JsonProcessingException
  {
    paramTokenBuffer.writeEndObject();
    JsonParser localJsonParser = paramTokenBuffer.asParser();
    while (localJsonParser.nextToken() != JsonToken.END_OBJECT)
    {
      paramTokenBuffer = localJsonParser.getCurrentName();
      localJsonParser.nextToken();
      handleUnknownProperty(localJsonParser, paramDeserializationContext, paramObject, paramTokenBuffer);
    }
    return paramObject;
  }
  
  protected void handleUnknownProperty(JsonParser paramJsonParser, DeserializationContext paramDeserializationContext, Object paramObject, String paramString)
    throws IOException, JsonProcessingException
  {
    if ((this._ignoreAllUnknown) || ((this._ignorableProps != null) && (this._ignorableProps.contains(paramString)))) {
      paramJsonParser.skipChildren();
    }
    for (;;)
    {
      return;
      super.handleUnknownProperty(paramJsonParser, paramDeserializationContext, paramObject, paramString);
    }
  }
  
  public boolean hasProperty(String paramString)
  {
    if (this._beanProperties.find(paramString) != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterator<SettableBeanProperty> properties()
  {
    if (this._beanProperties == null) {
      throw new IllegalStateException("Can only call before BeanDeserializer has been resolved");
    }
    return this._beanProperties.allProperties();
  }
  
  public void resolve(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider)
    throws JsonMappingException
  {
    Iterator localIterator = this._beanProperties.allProperties();
    Object localObject2;
    Object localObject1;
    while (localIterator.hasNext())
    {
      SettableBeanProperty localSettableBeanProperty = (SettableBeanProperty)localIterator.next();
      if (!localSettableBeanProperty.hasValueDeserializer()) {
        localSettableBeanProperty.setValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, localSettableBeanProperty.getType(), localSettableBeanProperty));
      }
      localObject2 = localSettableBeanProperty.getManagedReferenceName();
      if (localObject2 != null)
      {
        localObject1 = localSettableBeanProperty._valueDeserializer;
        boolean bool = false;
        if ((localObject1 instanceof BeanDeserializer)) {
          localObject1 = ((BeanDeserializer)localObject1).findBackReference((String)localObject2);
        }
        while (localObject1 == null)
        {
          throw new IllegalArgumentException("Can not handle managed/back reference '" + (String)localObject2 + "': no back reference property found from type " + localSettableBeanProperty.getType());
          if ((localObject1 instanceof ContainerDeserializer))
          {
            localObject1 = ((ContainerDeserializer)localObject1).getContentDeserializer();
            if (!(localObject1 instanceof BeanDeserializer)) {
              throw new IllegalArgumentException("Can not handle managed/back reference '" + (String)localObject2 + "': value deserializer is of type ContainerDeserializer, but content type is not handled by a BeanDeserializer " + " (instead it's of type " + localObject1.getClass().getName() + ")");
            }
            localObject1 = ((BeanDeserializer)localObject1).findBackReference((String)localObject2);
            bool = true;
          }
          else
          {
            if ((localObject1 instanceof AbstractDeserializer)) {
              throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + this._beanType.getRawClass().getName() + "." + localSettableBeanProperty.getName() + ")");
            }
            throw new IllegalArgumentException("Can not handle managed/back reference '" + (String)localObject2 + "': type for value deserializer is not BeanDeserializer or ContainerDeserializer, but " + localObject1.getClass().getName());
          }
        }
        JavaType localJavaType2 = this._beanType;
        JavaType localJavaType1 = ((SettableBeanProperty)localObject1).getType();
        if (!localJavaType1.getRawClass().isAssignableFrom(localJavaType2.getRawClass())) {
          throw new IllegalArgumentException("Can not handle managed/back reference '" + (String)localObject2 + "': back reference type (" + localJavaType1.getRawClass().getName() + ") not compatible with managed type (" + localJavaType2.getRawClass().getName() + ")");
        }
        this._beanProperties.replace(new SettableBeanProperty.ManagedReferenceProperty((String)localObject2, localSettableBeanProperty, (SettableBeanProperty)localObject1, this._forClass.getAnnotations(), bool));
      }
    }
    if ((this._anySetter != null) && (!this._anySetter.hasValueDeserializer())) {
      this._anySetter.setValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, this._anySetter.getType(), this._anySetter.getProperty()));
    }
    if (this._delegatingCreator != null)
    {
      localObject1 = new BeanProperty.Std(null, this._delegatingCreator.getValueType(), this._forClass.getAnnotations(), this._delegatingCreator.getCreator());
      localObject1 = findDeserializer(paramDeserializationConfig, paramDeserializerProvider, this._delegatingCreator.getValueType(), (BeanProperty)localObject1);
      this._delegatingCreator.setDeserializer((JsonDeserializer)localObject1);
    }
    if (this._propertyBasedCreator != null)
    {
      localObject2 = this._propertyBasedCreator.properties().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (SettableBeanProperty)((Iterator)localObject2).next();
        if (!((SettableBeanProperty)localObject1).hasValueDeserializer()) {
          ((SettableBeanProperty)localObject1).setValueDeserializer(findDeserializer(paramDeserializationConfig, paramDeserializerProvider, ((SettableBeanProperty)localObject1).getType(), (BeanProperty)localObject1));
        }
      }
    }
  }
  
  @Deprecated
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, int paramInt)
    throws IOException
  {
    wrapAndThrow(paramThrowable, paramObject, paramInt, null);
  }
  
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, int paramInt, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof JsonMappingException))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, paramInt);
  }
  
  @Deprecated
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString)
    throws IOException
  {
    wrapAndThrow(paramThrowable, paramObject, paramString, null);
  }
  
  public void wrapAndThrow(Throwable paramThrowable, Object paramObject, String paramString, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0)
    {
      if ((i != 0) && ((paramThrowable instanceof JsonMappingException))) {
        break label100;
      }
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    label100:
    throw JsonMappingException.wrapWithPath(paramThrowable, paramObject, paramString);
  }
  
  protected void wrapInstantiationProblem(Throwable paramThrowable, DeserializationContext paramDeserializationContext)
    throws IOException
  {
    while (((paramThrowable instanceof InvocationTargetException)) && (paramThrowable.getCause() != null)) {
      paramThrowable = paramThrowable.getCause();
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    if ((paramDeserializationContext == null) || (paramDeserializationContext.isEnabled(DeserializationConfig.Feature.WRAP_EXCEPTIONS))) {}
    for (int i = 1; (paramThrowable instanceof IOException); i = 0) {
      throw ((IOException)paramThrowable);
    }
    if ((i == 0) && ((paramThrowable instanceof RuntimeException))) {
      throw ((RuntimeException)paramThrowable);
    }
    throw paramDeserializationContext.instantiationException(this._beanType.getRawClass(), paramThrowable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\BeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */