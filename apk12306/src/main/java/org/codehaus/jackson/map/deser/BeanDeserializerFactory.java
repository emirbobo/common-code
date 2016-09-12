package org.codehaus.jackson.map.deser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.AbstractTypeResolver;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.DeserializerFactory;
import org.codehaus.jackson.map.DeserializerFactory.Config;
import org.codehaus.jackson.map.DeserializerProvider;
import org.codehaus.jackson.map.Deserializers;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.KeyDeserializer;
import org.codehaus.jackson.map.KeyDeserializers;
import org.codehaus.jackson.map.TypeDeserializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.type.ArrayType;
import org.codehaus.jackson.map.type.CollectionLikeType;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapLikeType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BeanDeserializerFactory
  extends BasicDeserializerFactory
{
  private static final Class<?>[] INIT_CAUSE_PARAMS = { Throwable.class };
  public static final BeanDeserializerFactory instance = new BeanDeserializerFactory(null);
  protected final DeserializerFactory.Config _factoryConfig;
  
  @Deprecated
  public BeanDeserializerFactory()
  {
    this(null);
  }
  
  public BeanDeserializerFactory(DeserializerFactory.Config paramConfig)
  {
    Object localObject = paramConfig;
    if (paramConfig == null) {
      localObject = new ConfigImpl();
    }
    this._factoryConfig = ((DeserializerFactory.Config)localObject);
  }
  
  protected void _addDeserializerConstructors(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorContainer paramCreatorContainer)
    throws JsonMappingException
  {
    Iterator localIterator = paramBasicBeanDescription.getConstructors().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedConstructor localAnnotatedConstructor = (AnnotatedConstructor)localIterator.next();
      int n = localAnnotatedConstructor.getParameterCount();
      if (n >= 1)
      {
        boolean bool1 = paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedConstructor);
        boolean bool2 = paramVisibilityChecker.isCreatorVisible(localAnnotatedConstructor);
        AnnotatedParameter localAnnotatedParameter;
        Object localObject;
        if (n == 1)
        {
          localAnnotatedParameter = localAnnotatedConstructor.getParameter(0);
          localObject = paramAnnotationIntrospector.findPropertyNameForParam(localAnnotatedParameter);
          if ((localObject == null) || (((String)localObject).length() == 0))
          {
            localObject = localAnnotatedConstructor.getParameterClass(0);
            if (localObject == String.class)
            {
              if ((bool1) || (bool2)) {
                paramCreatorContainer.addStringConstructor(localAnnotatedConstructor);
              }
            }
            else if ((localObject == Integer.TYPE) || (localObject == Integer.class))
            {
              if ((bool1) || (bool2)) {
                paramCreatorContainer.addIntConstructor(localAnnotatedConstructor);
              }
            }
            else if ((localObject == Long.TYPE) || (localObject == Long.class))
            {
              if ((bool1) || (bool2)) {
                paramCreatorContainer.addLongConstructor(localAnnotatedConstructor);
              }
            }
            else if (bool1) {
              paramCreatorContainer.addDelegatingConstructor(localAnnotatedConstructor);
            }
          }
          else
          {
            paramCreatorContainer.addPropertyConstructor(localAnnotatedConstructor, new SettableBeanProperty[] { constructCreatorProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject, 0, localAnnotatedParameter) });
          }
        }
        else if ((bool1) || (bool2))
        {
          int i = 0;
          int k = 0;
          SettableBeanProperty[] arrayOfSettableBeanProperty = new SettableBeanProperty[n];
          int j = 0;
          while (j < n)
          {
            localAnnotatedParameter = localAnnotatedConstructor.getParameter(j);
            int m;
            if (localAnnotatedParameter == null)
            {
              localObject = null;
              if ((localObject != null) && (((String)localObject).length() != 0)) {
                break label407;
              }
              m = 1;
              label315:
              m = k | m;
              if (m != 0) {
                break label413;
              }
            }
            label407:
            label413:
            for (k = 1;; k = 0)
            {
              i |= k;
              if ((m == 0) || ((i == 0) && (!bool1))) {
                break label419;
              }
              throw new IllegalArgumentException("Argument #" + j + " of constructor " + localAnnotatedConstructor + " has no property name annotation; must have name when multiple-paramater constructor annotated as Creator");
              localObject = paramAnnotationIntrospector.findPropertyNameForParam(localAnnotatedParameter);
              break;
              m = 0;
              break label315;
            }
            label419:
            arrayOfSettableBeanProperty[j] = constructCreatorProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject, j, localAnnotatedParameter);
            j++;
            k = m;
          }
          if (i != 0) {
            paramCreatorContainer.addPropertyConstructor(localAnnotatedConstructor, arrayOfSettableBeanProperty);
          }
        }
      }
    }
  }
  
  protected void _addDeserializerFactoryMethods(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, VisibilityChecker<?> paramVisibilityChecker, AnnotationIntrospector paramAnnotationIntrospector, CreatorContainer paramCreatorContainer)
    throws JsonMappingException
  {
    Iterator localIterator = paramBasicBeanDescription.getFactoryMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      int j = localAnnotatedMethod.getParameterCount();
      if (j >= 1)
      {
        boolean bool = paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedMethod);
        Object localObject;
        if (j == 1)
        {
          localObject = paramAnnotationIntrospector.findPropertyNameForParam(localAnnotatedMethod.getParameter(0));
          if ((localObject == null) || (((String)localObject).length() == 0))
          {
            localObject = localAnnotatedMethod.getParameterClass(0);
            if (localObject == String.class)
            {
              if ((!bool) && (!paramVisibilityChecker.isCreatorVisible(localAnnotatedMethod))) {
                continue;
              }
              paramCreatorContainer.addStringFactory(localAnnotatedMethod);
              continue;
            }
            if ((localObject == Integer.TYPE) || (localObject == Integer.class))
            {
              if ((!bool) && (!paramVisibilityChecker.isCreatorVisible(localAnnotatedMethod))) {
                continue;
              }
              paramCreatorContainer.addIntFactory(localAnnotatedMethod);
              continue;
            }
            if ((localObject == Long.TYPE) || (localObject == Long.class))
            {
              if ((!bool) && (!paramVisibilityChecker.isCreatorVisible(localAnnotatedMethod))) {
                continue;
              }
              paramCreatorContainer.addLongFactory(localAnnotatedMethod);
              continue;
            }
            if (!paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedMethod)) {
              continue;
            }
            paramCreatorContainer.addDelegatingFactory(localAnnotatedMethod);
          }
        }
        else
        {
          if (!paramAnnotationIntrospector.hasCreatorAnnotation(localAnnotatedMethod)) {
            continue;
          }
        }
        SettableBeanProperty[] arrayOfSettableBeanProperty = new SettableBeanProperty[j];
        for (int i = 0; i < j; i++)
        {
          AnnotatedParameter localAnnotatedParameter = localAnnotatedMethod.getParameter(i);
          localObject = paramAnnotationIntrospector.findPropertyNameForParam(localAnnotatedParameter);
          if ((localObject == null) || (((String)localObject).length() == 0)) {
            throw new IllegalArgumentException("Argument #" + i + " of factory method " + localAnnotatedMethod + " has no property name annotation; must have when multiple-paramater static method annotated as Creator");
          }
          arrayOfSettableBeanProperty[i] = constructCreatorProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject, i, localAnnotatedParameter);
        }
        paramCreatorContainer.addPropertyFactory(localAnnotatedMethod, arrayOfSettableBeanProperty);
      }
    }
  }
  
  protected JsonDeserializer<?> _findCustomArrayDeserializer(ArrayType paramArrayType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findArrayDeserializer(paramArrayType, paramDeserializationConfig, paramDeserializerProvider, paramBeanProperty, paramTypeDeserializer, paramJsonDeserializer);
    } while (localJsonDeserializer == null);
    for (paramArrayType = localJsonDeserializer;; paramArrayType = null) {
      return paramArrayType;
    }
  }
  
  protected JsonDeserializer<Object> _findCustomBeanDeserializer(JavaType paramJavaType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findBeanDeserializer(paramJavaType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty);
    } while (localJsonDeserializer == null);
    for (paramJavaType = localJsonDeserializer;; paramJavaType = null) {
      return paramJavaType;
    }
  }
  
  protected JsonDeserializer<?> _findCustomCollectionDeserializer(CollectionType paramCollectionType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findCollectionDeserializer(paramCollectionType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramTypeDeserializer, paramJsonDeserializer);
    } while (localJsonDeserializer == null);
    for (paramCollectionType = localJsonDeserializer;; paramCollectionType = null) {
      return paramCollectionType;
    }
  }
  
  protected JsonDeserializer<?> _findCustomCollectionLikeDeserializer(CollectionLikeType paramCollectionLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findCollectionLikeDeserializer(paramCollectionLikeType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramTypeDeserializer, paramJsonDeserializer);
    } while (localJsonDeserializer == null);
    for (paramCollectionLikeType = localJsonDeserializer;; paramCollectionLikeType = null) {
      return paramCollectionLikeType;
    }
  }
  
  protected JsonDeserializer<?> _findCustomEnumDeserializer(Class<?> paramClass, DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findEnumDeserializer(paramClass, paramDeserializationConfig, paramBasicBeanDescription, paramBeanProperty);
    } while (localJsonDeserializer == null);
    for (paramClass = localJsonDeserializer;; paramClass = null) {
      return paramClass;
    }
  }
  
  protected JsonDeserializer<?> _findCustomMapDeserializer(MapType paramMapType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findMapDeserializer(paramMapType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramKeyDeserializer, paramTypeDeserializer, paramJsonDeserializer);
    } while (localJsonDeserializer == null);
    for (paramMapType = localJsonDeserializer;; paramMapType = null) {
      return paramMapType;
    }
  }
  
  protected JsonDeserializer<?> _findCustomMapLikeDeserializer(MapLikeType paramMapLikeType, DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty, KeyDeserializer paramKeyDeserializer, TypeDeserializer paramTypeDeserializer, JsonDeserializer<?> paramJsonDeserializer)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findMapLikeDeserializer(paramMapLikeType, paramDeserializationConfig, paramDeserializerProvider, paramBasicBeanDescription, paramBeanProperty, paramKeyDeserializer, paramTypeDeserializer, paramJsonDeserializer);
    } while (localJsonDeserializer == null);
    for (paramMapLikeType = localJsonDeserializer;; paramMapLikeType = null) {
      return paramMapLikeType;
    }
  }
  
  protected JsonDeserializer<?> _findCustomTreeNodeDeserializer(Class<? extends JsonNode> paramClass, DeserializationConfig paramDeserializationConfig, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Iterator localIterator = this._factoryConfig.deserializers().iterator();
    JsonDeserializer localJsonDeserializer;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localJsonDeserializer = ((Deserializers)localIterator.next()).findTreeNodeDeserializer(paramClass, paramDeserializationConfig, paramBeanProperty);
    } while (localJsonDeserializer == null);
    for (paramClass = localJsonDeserializer;; paramClass = null) {
      return paramClass;
    }
  }
  
  protected JavaType _mapAbstractType2(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
  {
    Class localClass = paramJavaType.getRawClass();
    Object localObject;
    if (this._factoryConfig.hasAbstractTypeResolvers())
    {
      Iterator localIterator = this._factoryConfig.abstractTypeResolvers().iterator();
      while (localIterator.hasNext())
      {
        localObject = ((AbstractTypeResolver)localIterator.next()).findTypeMapping(paramDeserializationConfig, paramJavaType);
        if ((localObject != null) && (((JavaType)localObject).getRawClass() != localClass)) {
          paramDeserializationConfig = (DeserializationConfig)localObject;
        }
      }
    }
    for (;;)
    {
      return paramDeserializationConfig;
      localObject = paramDeserializationConfig.getAbstractTypeResolver();
      if (localObject != null)
      {
        paramJavaType = ((AbstractTypeResolver)localObject).findTypeMapping(paramDeserializationConfig, paramJavaType);
        if (paramJavaType != null)
        {
          paramDeserializationConfig = paramJavaType;
          if (paramJavaType.getRawClass() != localClass) {
            continue;
          }
        }
      }
      paramDeserializationConfig = null;
    }
  }
  
  protected void addBeanProps(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanDeserializerBuilder paramBeanDeserializerBuilder)
    throws JsonMappingException
  {
    Object localObject2 = paramDeserializationConfig.getDefaultVisibilityChecker();
    Object localObject1 = localObject2;
    if (!paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_SETTERS)) {
      localObject1 = ((VisibilityChecker)localObject2).withSetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = localObject1;
    if (!paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_FIELDS)) {
      localObject2 = ((VisibilityChecker)localObject1).withFieldVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = paramDeserializationConfig.getAnnotationIntrospector().findAutoDetectVisibility(paramBasicBeanDescription.getClassInfo(), (VisibilityChecker)localObject2);
    Object localObject3 = paramBasicBeanDescription.findSetters((VisibilityChecker)localObject2);
    Object localObject4 = paramBasicBeanDescription.findAnySetter();
    Object localObject5 = paramDeserializationConfig.getAnnotationIntrospector();
    localObject1 = ((AnnotationIntrospector)localObject5).findIgnoreUnknownProperties(paramBasicBeanDescription.getClassInfo());
    if (localObject1 != null) {
      paramBeanDeserializerBuilder.setIgnoreUnknownProperties(((Boolean)localObject1).booleanValue());
    }
    localObject1 = ArrayBuilders.arrayToSet(((AnnotationIntrospector)localObject5).findPropertiesToIgnore(paramBasicBeanDescription.getClassInfo()));
    localObject5 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject5).hasNext()) {
      paramBeanDeserializerBuilder.addIgnorable((String)((Iterator)localObject5).next());
    }
    localObject5 = paramBasicBeanDescription.getClassInfo();
    Object localObject6 = ((AnnotatedClass)localObject5).ignoredMemberMethods().iterator();
    Object localObject7;
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = paramBasicBeanDescription.okNameForSetter((AnnotatedMethod)((Iterator)localObject6).next());
      if (localObject7 != null) {
        paramBeanDeserializerBuilder.addIgnorable((String)localObject7);
      }
    }
    localObject5 = ((AnnotatedClass)localObject5).ignoredFields().iterator();
    while (((Iterator)localObject5).hasNext()) {
      paramBeanDeserializerBuilder.addIgnorable(((AnnotatedField)((Iterator)localObject5).next()).getName());
    }
    localObject5 = new HashMap();
    localObject6 = ((Map)localObject3).entrySet().iterator();
    while (((Iterator)localObject6).hasNext())
    {
      Object localObject8 = (Map.Entry)((Iterator)localObject6).next();
      localObject7 = (String)((Map.Entry)localObject8).getKey();
      if (!((HashSet)localObject1).contains(localObject7))
      {
        localObject8 = (AnnotatedMethod)((Map.Entry)localObject8).getValue();
        if (isIgnorableType(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedMethod)localObject8).getParameterClass(0), (Map)localObject5))
        {
          paramBeanDeserializerBuilder.addIgnorable((String)localObject7);
        }
        else
        {
          localObject7 = constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject7, (AnnotatedMethod)localObject8);
          if (localObject7 != null) {
            paramBeanDeserializerBuilder.addProperty((SettableBeanProperty)localObject7);
          }
        }
      }
    }
    if (localObject4 != null) {
      paramBeanDeserializerBuilder.setAnySetter(constructAnySetter(paramDeserializationConfig, paramBasicBeanDescription, (AnnotatedMethod)localObject4));
    }
    localObject3 = new HashSet(((Map)localObject3).keySet());
    localObject4 = paramBasicBeanDescription.findDeserializableFields((VisibilityChecker)localObject2, (Collection)localObject3).entrySet().iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject7 = (Map.Entry)((Iterator)localObject4).next();
      localObject6 = (String)((Map.Entry)localObject7).getKey();
      if ((!((HashSet)localObject1).contains(localObject6)) && (!paramBeanDeserializerBuilder.hasProperty((String)localObject6)))
      {
        localObject7 = (AnnotatedField)((Map.Entry)localObject7).getValue();
        if (isIgnorableType(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedField)localObject7).getRawType(), (Map)localObject5))
        {
          paramBeanDeserializerBuilder.addIgnorable((String)localObject6);
        }
        else
        {
          localObject7 = constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject6, (AnnotatedField)localObject7);
          if (localObject7 != null)
          {
            paramBeanDeserializerBuilder.addProperty((SettableBeanProperty)localObject7);
            ((HashSet)localObject3).add(localObject6);
          }
        }
      }
    }
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS))
    {
      localObject2 = paramBasicBeanDescription.findGetters((VisibilityChecker)localObject2, (Collection)localObject3).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = (AnnotatedMethod)((Map.Entry)localObject5).getValue();
        localObject6 = ((AnnotatedMethod)localObject4).getRawType();
        if ((Collection.class.isAssignableFrom((Class)localObject6)) || (Map.class.isAssignableFrom((Class)localObject6)))
        {
          localObject5 = (String)((Map.Entry)localObject5).getKey();
          if ((!((HashSet)localObject1).contains(localObject5)) && (!paramBeanDeserializerBuilder.hasProperty((String)localObject5)))
          {
            paramBeanDeserializerBuilder.addProperty(constructSetterlessProperty(paramDeserializationConfig, paramBasicBeanDescription, (String)localObject5, (AnnotatedMethod)localObject4));
            ((HashSet)localObject3).add(localObject5);
          }
        }
      }
    }
  }
  
  protected void addReferenceProperties(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanDeserializerBuilder paramBeanDeserializerBuilder)
    throws JsonMappingException
  {
    Object localObject1 = paramBasicBeanDescription.findBackReferenceProperties();
    if (localObject1 != null)
    {
      Iterator localIterator = ((Map)localObject1).entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (AnnotatedMember)((Map.Entry)localObject2).getValue();
        if ((localObject2 instanceof AnnotatedMethod)) {
          paramBeanDeserializerBuilder.addBackReferenceProperty((String)localObject1, constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedMember)localObject2).getName(), (AnnotatedMethod)localObject2));
        } else {
          paramBeanDeserializerBuilder.addBackReferenceProperty((String)localObject1, constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, ((AnnotatedMember)localObject2).getName(), (AnnotatedField)localObject2));
        }
      }
    }
  }
  
  public JsonDeserializer<Object> buildBeanDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramJavaType = constructBeanDeserializerBuilder(paramBasicBeanDescription);
    paramJavaType.setCreators(findDeserializerCreators(paramDeserializationConfig, paramBasicBeanDescription));
    addBeanProps(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
    addReferenceProperties(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
    Object localObject = paramJavaType;
    if (this._factoryConfig.hasDeserializerModifiers())
    {
      Iterator localIterator = this._factoryConfig.deserializerModifiers().iterator();
      for (;;)
      {
        localObject = paramJavaType;
        if (!localIterator.hasNext()) {
          break;
        }
        paramJavaType = ((BeanDeserializerModifier)localIterator.next()).updateBuilder(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      }
    }
    paramJavaType = ((BeanDeserializerBuilder)localObject).build(paramBeanProperty);
    paramBeanProperty = paramJavaType;
    if (this._factoryConfig.hasDeserializerModifiers())
    {
      localObject = this._factoryConfig.deserializerModifiers().iterator();
      for (;;)
      {
        paramBeanProperty = paramJavaType;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramJavaType = ((BeanDeserializerModifier)((Iterator)localObject).next()).modifyDeserializer(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      }
    }
    return paramBeanProperty;
  }
  
  public JsonDeserializer<Object> buildThrowableDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    paramJavaType = constructBeanDeserializerBuilder(paramBasicBeanDescription);
    paramJavaType.setCreators(findDeserializerCreators(paramDeserializationConfig, paramBasicBeanDescription));
    addBeanProps(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
    Object localObject = paramBasicBeanDescription.findMethod("initCause", INIT_CAUSE_PARAMS);
    if (localObject != null)
    {
      localObject = constructSettableProperty(paramDeserializationConfig, paramBasicBeanDescription, "cause", (AnnotatedMethod)localObject);
      if (localObject != null) {
        paramJavaType.addProperty((SettableBeanProperty)localObject);
      }
    }
    paramJavaType.addIgnorable("localizedMessage");
    paramJavaType.addIgnorable("message");
    localObject = paramJavaType;
    if (this._factoryConfig.hasDeserializerModifiers())
    {
      Iterator localIterator = this._factoryConfig.deserializerModifiers().iterator();
      for (;;)
      {
        localObject = paramJavaType;
        if (!localIterator.hasNext()) {
          break;
        }
        paramJavaType = ((BeanDeserializerModifier)localIterator.next()).updateBuilder(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      }
    }
    paramBeanProperty = ((BeanDeserializerBuilder)localObject).build(paramBeanProperty);
    paramJavaType = paramBeanProperty;
    if ((paramBeanProperty instanceof BeanDeserializer)) {
      paramJavaType = new ThrowableDeserializer((BeanDeserializer)paramBeanProperty);
    }
    paramBeanProperty = paramJavaType;
    if (this._factoryConfig.hasDeserializerModifiers())
    {
      localObject = this._factoryConfig.deserializerModifiers().iterator();
      for (;;)
      {
        paramBeanProperty = paramJavaType;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramJavaType = ((BeanDeserializerModifier)((Iterator)localObject).next()).modifyDeserializer(paramDeserializationConfig, paramBasicBeanDescription, paramJavaType);
      }
    }
    return paramBeanProperty;
  }
  
  protected SettableAnyProperty constructAnySetter(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, AnnotatedMethod paramAnnotatedMethod)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMethod.fixAccess();
    }
    JavaType localJavaType = paramBasicBeanDescription.bindingsForBeanType().resolveType(paramAnnotatedMethod.getParameterType(1));
    BeanProperty.Std localStd = new BeanProperty.Std(paramAnnotatedMethod.getName(), localJavaType, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    localJavaType = resolveType(paramDeserializationConfig, paramBasicBeanDescription, localJavaType, paramAnnotatedMethod, localStd);
    paramBasicBeanDescription = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedMethod, localStd);
    if (paramBasicBeanDescription != null)
    {
      paramDeserializationConfig = new SettableAnyProperty(localStd, paramAnnotatedMethod, localJavaType);
      paramDeserializationConfig.setValueDeserializer(paramBasicBeanDescription);
    }
    for (;;)
    {
      return paramDeserializationConfig;
      paramDeserializationConfig = new SettableAnyProperty(localStd, paramAnnotatedMethod, modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedMethod, localJavaType, localStd.getName()));
    }
  }
  
  protected BeanDeserializerBuilder constructBeanDeserializerBuilder(BasicBeanDescription paramBasicBeanDescription)
  {
    return new BeanDeserializerBuilder(paramBasicBeanDescription);
  }
  
  protected SettableBeanProperty constructSettableProperty(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, String paramString, AnnotatedField paramAnnotatedField)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedField.fixAccess();
    }
    JavaType localJavaType2 = paramBasicBeanDescription.bindingsForBeanType().resolveType(paramAnnotatedField.getGenericType());
    Object localObject2 = new BeanProperty.Std(paramString, localJavaType2, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedField);
    JavaType localJavaType1 = resolveType(paramDeserializationConfig, paramBasicBeanDescription, localJavaType2, paramAnnotatedField, (BeanProperty)localObject2);
    Object localObject1 = localObject2;
    if (localJavaType1 != localJavaType2) {
      localObject1 = ((BeanProperty.Std)localObject2).withType(localJavaType1);
    }
    localObject1 = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedField, (BeanProperty)localObject1);
    localObject2 = modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedField, localJavaType1, paramString);
    paramBasicBeanDescription = new SettableBeanProperty.FieldProperty(paramString, (JavaType)localObject2, (TypeDeserializer)((JavaType)localObject2).getTypeHandler(), paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedField);
    if (localObject1 != null) {
      paramBasicBeanDescription.setValueDeserializer((JsonDeserializer)localObject1);
    }
    paramDeserializationConfig = paramDeserializationConfig.getAnnotationIntrospector().findReferenceType(paramAnnotatedField);
    if ((paramDeserializationConfig != null) && (paramDeserializationConfig.isManagedReference())) {
      paramBasicBeanDescription.setManagedReferenceName(paramDeserializationConfig.getName());
    }
    return paramBasicBeanDescription;
  }
  
  protected SettableBeanProperty constructSettableProperty(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, String paramString, AnnotatedMethod paramAnnotatedMethod)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMethod.fixAccess();
    }
    JavaType localJavaType2 = paramBasicBeanDescription.bindingsForBeanType().resolveType(paramAnnotatedMethod.getParameterType(0));
    Object localObject2 = new BeanProperty.Std(paramString, localJavaType2, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    JavaType localJavaType1 = resolveType(paramDeserializationConfig, paramBasicBeanDescription, localJavaType2, paramAnnotatedMethod, (BeanProperty)localObject2);
    Object localObject1 = localObject2;
    if (localJavaType1 != localJavaType2) {
      localObject1 = ((BeanProperty.Std)localObject2).withType(localJavaType1);
    }
    localObject1 = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedMethod, (BeanProperty)localObject1);
    localObject2 = modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedMethod, localJavaType1, paramString);
    paramBasicBeanDescription = new SettableBeanProperty.MethodProperty(paramString, (JavaType)localObject2, (TypeDeserializer)((JavaType)localObject2).getTypeHandler(), paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    if (localObject1 != null) {
      paramBasicBeanDescription.setValueDeserializer((JsonDeserializer)localObject1);
    }
    paramDeserializationConfig = paramDeserializationConfig.getAnnotationIntrospector().findReferenceType(paramAnnotatedMethod);
    if ((paramDeserializationConfig != null) && (paramDeserializationConfig.isManagedReference())) {
      paramBasicBeanDescription.setManagedReferenceName(paramDeserializationConfig.getName());
    }
    return paramBasicBeanDescription;
  }
  
  protected SettableBeanProperty constructSetterlessProperty(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, String paramString, AnnotatedMethod paramAnnotatedMethod)
    throws JsonMappingException
  {
    if (paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMethod.fixAccess();
    }
    JavaType localJavaType = paramAnnotatedMethod.getType(paramBasicBeanDescription.bindingsForBeanType());
    JsonDeserializer localJsonDeserializer = findDeserializerFromAnnotation(paramDeserializationConfig, paramAnnotatedMethod, new BeanProperty.Std(paramString, localJavaType, paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod));
    paramDeserializationConfig = modifyTypeByAnnotation(paramDeserializationConfig, paramAnnotatedMethod, localJavaType, paramString);
    paramDeserializationConfig = new SettableBeanProperty.SetterlessProperty(paramString, paramDeserializationConfig, (TypeDeserializer)paramDeserializationConfig.getTypeHandler(), paramBasicBeanDescription.getClassAnnotations(), paramAnnotatedMethod);
    if (localJsonDeserializer != null) {
      paramDeserializationConfig.setValueDeserializer(localJsonDeserializer);
    }
    return paramDeserializationConfig;
  }
  
  public JsonDeserializer<Object> createBeanDeserializer(DeserializationConfig paramDeserializationConfig, DeserializerProvider paramDeserializerProvider, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    Object localObject = paramJavaType;
    if (paramJavaType.isAbstract()) {
      localObject = mapAbstractType(paramDeserializationConfig, paramJavaType);
    }
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspect((JavaType)localObject);
    paramJavaType = findDeserializerFromAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (paramJavaType != null) {
      paramDeserializationConfig = paramJavaType;
    }
    for (;;)
    {
      return paramDeserializationConfig;
      JavaType localJavaType = modifyTypeByAnnotation(paramDeserializationConfig, localBasicBeanDescription.getClassInfo(), (JavaType)localObject, null);
      paramJavaType = (JavaType)localObject;
      if (localJavaType.getRawClass() != ((JavaType)localObject).getRawClass())
      {
        paramJavaType = localJavaType;
        localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspect(paramJavaType);
      }
      localObject = _findCustomBeanDeserializer(paramJavaType, paramDeserializationConfig, paramDeserializerProvider, localBasicBeanDescription, paramBeanProperty);
      if (localObject != null)
      {
        paramDeserializationConfig = (DeserializationConfig)localObject;
      }
      else if (paramJavaType.isThrowable())
      {
        paramDeserializationConfig = buildThrowableDeserializer(paramDeserializationConfig, paramJavaType, localBasicBeanDescription, paramBeanProperty);
      }
      else
      {
        if (paramJavaType.isAbstract())
        {
          localObject = materializeAbstractType(paramDeserializationConfig, localBasicBeanDescription);
          if (localObject != null)
          {
            paramDeserializationConfig = buildBeanDeserializer(paramDeserializationConfig, (JavaType)localObject, (BasicBeanDescription)paramDeserializationConfig.introspect((JavaType)localObject), paramBeanProperty);
            continue;
          }
        }
        paramDeserializerProvider = findStdBeanDeserializer(paramDeserializationConfig, paramDeserializerProvider, paramJavaType, paramBeanProperty);
        if (paramDeserializerProvider != null) {
          paramDeserializationConfig = paramDeserializerProvider;
        } else if (!isPotentialBeanType(paramJavaType.getRawClass())) {
          paramDeserializationConfig = null;
        } else if (paramJavaType.isAbstract()) {
          paramDeserializationConfig = new AbstractDeserializer(paramJavaType);
        } else {
          paramDeserializationConfig = buildBeanDeserializer(paramDeserializationConfig, paramJavaType, localBasicBeanDescription, paramBeanProperty);
        }
      }
    }
  }
  
  public KeyDeserializer createKeyDeserializer(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    KeyDeserializer localKeyDeserializer;
    if (this._factoryConfig.hasKeyDeserializers())
    {
      BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
      Iterator localIterator = this._factoryConfig.keyDeserializers().iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localKeyDeserializer = ((KeyDeserializers)localIterator.next()).findKeyDeserializer(paramJavaType, paramDeserializationConfig, localBasicBeanDescription, paramBeanProperty);
      } while (localKeyDeserializer == null);
    }
    for (paramDeserializationConfig = localKeyDeserializer;; paramDeserializationConfig = null) {
      return paramDeserializationConfig;
    }
  }
  
  protected CreatorContainer findDeserializerCreators(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException
  {
    boolean bool = paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    CreatorContainer localCreatorContainer = new CreatorContainer(paramBasicBeanDescription, bool);
    AnnotationIntrospector localAnnotationIntrospector = paramDeserializationConfig.getAnnotationIntrospector();
    if (paramBasicBeanDescription.getType().isConcrete())
    {
      localObject = paramBasicBeanDescription.findDefaultConstructor();
      if (localObject != null)
      {
        if (bool) {
          ClassUtil.checkAndFixAccess((Member)localObject);
        }
        localCreatorContainer.setDefaultConstructor((Constructor)localObject);
      }
    }
    VisibilityChecker localVisibilityChecker = paramDeserializationConfig.getDefaultVisibilityChecker();
    Object localObject = localVisibilityChecker;
    if (!paramDeserializationConfig.isEnabled(DeserializationConfig.Feature.AUTO_DETECT_CREATORS)) {
      localObject = localVisibilityChecker.withCreatorVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject = paramDeserializationConfig.getAnnotationIntrospector().findAutoDetectVisibility(paramBasicBeanDescription.getClassInfo(), (VisibilityChecker)localObject);
    _addDeserializerConstructors(paramDeserializationConfig, paramBasicBeanDescription, (VisibilityChecker)localObject, localAnnotationIntrospector, localCreatorContainer);
    _addDeserializerFactoryMethods(paramDeserializationConfig, paramBasicBeanDescription, (VisibilityChecker)localObject, localAnnotationIntrospector, localCreatorContainer);
    return localCreatorContainer;
  }
  
  public final DeserializerFactory.Config getConfig()
  {
    return this._factoryConfig;
  }
  
  protected boolean isIgnorableType(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription, Class<?> paramClass, Map<Class<?>, Boolean> paramMap)
  {
    paramMap = (Boolean)paramMap.get(paramClass);
    paramBasicBeanDescription = paramMap;
    if (paramMap == null)
    {
      paramBasicBeanDescription = (BasicBeanDescription)paramDeserializationConfig.introspectClassAnnotations(paramClass);
      paramDeserializationConfig = paramDeserializationConfig.getAnnotationIntrospector().isIgnorableType(paramBasicBeanDescription.getClassInfo());
      paramBasicBeanDescription = paramDeserializationConfig;
      if (paramDeserializationConfig == null) {
        paramBasicBeanDescription = Boolean.FALSE;
      }
    }
    return paramBasicBeanDescription.booleanValue();
  }
  
  protected boolean isPotentialBeanType(Class<?> paramClass)
  {
    String str = ClassUtil.canBeABeanType(paramClass);
    if (str != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
    }
    if (ClassUtil.isProxyType(paramClass)) {
      throw new IllegalArgumentException("Can not deserialize Proxy class " + paramClass.getName() + " as a Bean");
    }
    str = ClassUtil.isLocalType(paramClass);
    if (str != null) {
      throw new IllegalArgumentException("Can not deserialize Class " + paramClass.getName() + " (of type " + str + ") as a Bean");
    }
    return true;
  }
  
  protected JavaType mapAbstractType(DeserializationConfig paramDeserializationConfig, JavaType paramJavaType)
    throws JsonMappingException
  {
    for (;;)
    {
      JavaType localJavaType = _mapAbstractType2(paramDeserializationConfig, paramJavaType);
      if (localJavaType == null) {
        return paramJavaType;
      }
      Class localClass2 = paramJavaType.getRawClass();
      Class localClass1 = localJavaType.getRawClass();
      if ((localClass2 == localClass1) || (!localClass2.isAssignableFrom(localClass1))) {
        throw new IllegalArgumentException("Invalid abstract type resolution from " + paramJavaType + " to " + localJavaType + ": latter is not a subtype of former");
      }
      paramJavaType = localJavaType;
    }
  }
  
  protected JavaType materializeAbstractType(DeserializationConfig paramDeserializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException
  {
    Object localObject = paramDeserializationConfig.getAbstractTypeResolver();
    if ((localObject == null) && (!this._factoryConfig.hasAbstractTypeResolvers())) {
      paramBasicBeanDescription = null;
    }
    for (;;)
    {
      return paramBasicBeanDescription;
      JavaType localJavaType = paramBasicBeanDescription.getType();
      if (paramDeserializationConfig.getAnnotationIntrospector().findTypeResolver(paramDeserializationConfig, paramBasicBeanDescription.getClassInfo(), localJavaType) != null)
      {
        paramBasicBeanDescription = null;
      }
      else if (localObject != null)
      {
        localObject = ((AbstractTypeResolver)localObject).resolveAbstractType(paramDeserializationConfig, localJavaType);
        paramBasicBeanDescription = (BasicBeanDescription)localObject;
        if (localObject != null) {}
      }
      else
      {
        localObject = this._factoryConfig.abstractTypeResolvers().iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            paramBasicBeanDescription = ((AbstractTypeResolver)((Iterator)localObject).next()).resolveAbstractType(paramDeserializationConfig, localJavaType);
            if (paramBasicBeanDescription != null) {
              break;
            }
          }
        }
        paramBasicBeanDescription = null;
      }
    }
  }
  
  public DeserializerFactory withConfig(DeserializerFactory.Config paramConfig)
  {
    if (this._factoryConfig == paramConfig) {}
    for (paramConfig = this;; paramConfig = new BeanDeserializerFactory(paramConfig))
    {
      return paramConfig;
      if (getClass() != BeanDeserializerFactory.class) {
        throw new IllegalStateException("Subtype of BeanDeserializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalDeserializers': can not instantiate subtype with " + "additional deserializer definitions");
      }
    }
  }
  
  public static class ConfigImpl
    extends DeserializerFactory.Config
  {
    protected static final AbstractTypeResolver[] NO_ABSTRACT_TYPE_RESOLVERS = new AbstractTypeResolver[0];
    protected static final KeyDeserializers[] NO_KEY_DESERIALIZERS = new KeyDeserializers[0];
    protected static final BeanDeserializerModifier[] NO_MODIFIERS = new BeanDeserializerModifier[0];
    protected final AbstractTypeResolver[] _abstractTypeResolvers;
    protected final Deserializers[] _additionalDeserializers;
    protected final KeyDeserializers[] _additionalKeyDeserializers;
    protected final BeanDeserializerModifier[] _modifiers;
    
    public ConfigImpl()
    {
      this(null, null, null, null);
    }
    
    protected ConfigImpl(Deserializers[] paramArrayOfDeserializers, KeyDeserializers[] paramArrayOfKeyDeserializers, BeanDeserializerModifier[] paramArrayOfBeanDeserializerModifier, AbstractTypeResolver[] paramArrayOfAbstractTypeResolver)
    {
      Deserializers[] arrayOfDeserializers = paramArrayOfDeserializers;
      if (paramArrayOfDeserializers == null) {
        arrayOfDeserializers = BeanDeserializerFactory.NO_DESERIALIZERS;
      }
      this._additionalDeserializers = arrayOfDeserializers;
      paramArrayOfDeserializers = paramArrayOfKeyDeserializers;
      if (paramArrayOfKeyDeserializers == null) {
        paramArrayOfDeserializers = NO_KEY_DESERIALIZERS;
      }
      this._additionalKeyDeserializers = paramArrayOfDeserializers;
      paramArrayOfDeserializers = paramArrayOfBeanDeserializerModifier;
      if (paramArrayOfBeanDeserializerModifier == null) {
        paramArrayOfDeserializers = NO_MODIFIERS;
      }
      this._modifiers = paramArrayOfDeserializers;
      paramArrayOfDeserializers = paramArrayOfAbstractTypeResolver;
      if (paramArrayOfAbstractTypeResolver == null) {
        paramArrayOfDeserializers = NO_ABSTRACT_TYPE_RESOLVERS;
      }
      this._abstractTypeResolvers = paramArrayOfDeserializers;
    }
    
    public Iterable<AbstractTypeResolver> abstractTypeResolvers()
    {
      return ArrayBuilders.arrayAsIterable(this._abstractTypeResolvers);
    }
    
    public Iterable<BeanDeserializerModifier> deserializerModifiers()
    {
      return ArrayBuilders.arrayAsIterable(this._modifiers);
    }
    
    public Iterable<Deserializers> deserializers()
    {
      return ArrayBuilders.arrayAsIterable(this._additionalDeserializers);
    }
    
    public boolean hasAbstractTypeResolvers()
    {
      if (this._abstractTypeResolvers.length > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public boolean hasDeserializerModifiers()
    {
      if (this._modifiers.length > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public boolean hasDeserializers()
    {
      if (this._additionalDeserializers.length > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public boolean hasKeyDeserializers()
    {
      if (this._additionalKeyDeserializers.length > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public Iterable<KeyDeserializers> keyDeserializers()
    {
      return ArrayBuilders.arrayAsIterable(this._additionalKeyDeserializers);
    }
    
    public DeserializerFactory.Config withAbstractTypeResolver(AbstractTypeResolver paramAbstractTypeResolver)
    {
      if (paramAbstractTypeResolver == null) {
        throw new IllegalArgumentException("Can not pass null resolver");
      }
      paramAbstractTypeResolver = (AbstractTypeResolver[])ArrayBuilders.insertInListNoDup(this._abstractTypeResolvers, paramAbstractTypeResolver);
      return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, this._modifiers, paramAbstractTypeResolver);
    }
    
    public DeserializerFactory.Config withAdditionalDeserializers(Deserializers paramDeserializers)
    {
      if (paramDeserializers == null) {
        throw new IllegalArgumentException("Can not pass null Deserializers");
      }
      return new ConfigImpl((Deserializers[])ArrayBuilders.insertInListNoDup(this._additionalDeserializers, paramDeserializers), this._additionalKeyDeserializers, this._modifiers, this._abstractTypeResolvers);
    }
    
    public DeserializerFactory.Config withAdditionalKeyDeserializers(KeyDeserializers paramKeyDeserializers)
    {
      if (paramKeyDeserializers == null) {
        throw new IllegalArgumentException("Can not pass null KeyDeserializers");
      }
      paramKeyDeserializers = (KeyDeserializers[])ArrayBuilders.insertInListNoDup(this._additionalKeyDeserializers, paramKeyDeserializers);
      return new ConfigImpl(this._additionalDeserializers, paramKeyDeserializers, this._modifiers, this._abstractTypeResolvers);
    }
    
    public DeserializerFactory.Config withDeserializerModifier(BeanDeserializerModifier paramBeanDeserializerModifier)
    {
      if (paramBeanDeserializerModifier == null) {
        throw new IllegalArgumentException("Can not pass null modifier");
      }
      paramBeanDeserializerModifier = (BeanDeserializerModifier[])ArrayBuilders.insertInListNoDup(this._modifiers, paramBeanDeserializerModifier);
      return new ConfigImpl(this._additionalDeserializers, this._additionalKeyDeserializers, paramBeanDeserializerModifier, this._abstractTypeResolvers);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\deser\BeanDeserializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */