package org.codehaus.jackson.map.ser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.BeanProperty.Std;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.SerializerFactory.Config;
import org.codehaus.jackson.map.Serializers;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.SubtypeResolver;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BeanSerializerFactory
  extends BasicSerializerFactory
{
  public static final BeanSerializerFactory instance = new BeanSerializerFactory(null);
  protected final SerializerFactory.Config _factoryConfig;
  
  @Deprecated
  protected BeanSerializerFactory()
  {
    this(null);
  }
  
  protected BeanSerializerFactory(SerializerFactory.Config paramConfig)
  {
    Object localObject = paramConfig;
    if (paramConfig == null) {
      localObject = new ConfigImpl();
    }
    this._factoryConfig = ((SerializerFactory.Config)localObject);
  }
  
  protected BeanPropertyWriter _constructWriter(SerializationConfig paramSerializationConfig, TypeBindings paramTypeBindings, PropertyBuilder paramPropertyBuilder, boolean paramBoolean, String paramString, AnnotatedMember paramAnnotatedMember)
    throws JsonMappingException
  {
    if (paramSerializationConfig.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS)) {
      paramAnnotatedMember.fixAccess();
    }
    JavaType localJavaType = paramAnnotatedMember.getType(paramTypeBindings);
    BeanProperty.Std localStd = new BeanProperty.Std(paramString, localJavaType, paramPropertyBuilder.getClassAnnotations(), paramAnnotatedMember);
    JsonSerializer localJsonSerializer = findSerializerFromAnnotation(paramSerializationConfig, paramAnnotatedMember, localStd);
    paramTypeBindings = null;
    if (ClassUtil.isCollectionMapOrArray(localJavaType.getRawClass())) {
      paramTypeBindings = findPropertyContentTypeSerializer(localJavaType, paramSerializationConfig, paramAnnotatedMember, localStd);
    }
    paramTypeBindings = paramPropertyBuilder.buildWriter(paramString, localJavaType, localJsonSerializer, findPropertyTypeSerializer(localJavaType, paramSerializationConfig, paramAnnotatedMember, localStd), paramTypeBindings, paramAnnotatedMember, paramBoolean);
    paramTypeBindings.setViews(paramSerializationConfig.getAnnotationIntrospector().findSerializationViews(paramAnnotatedMember));
    return paramTypeBindings;
  }
  
  protected List<BeanPropertyWriter> _sortBeanProperties(List<BeanPropertyWriter> paramList, List<String> paramList1, String[] paramArrayOfString, boolean paramBoolean)
  {
    int i = paramList.size();
    if (paramBoolean) {}
    for (Object localObject1 = new TreeMap();; localObject1 = new LinkedHashMap(i * 2))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject2 = (BeanPropertyWriter)paramList.next();
        ((Map)localObject1).put(((BeanPropertyWriter)localObject2).getName(), localObject2);
      }
    }
    paramList = new LinkedHashMap(i * 2);
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      for (i = 0; i < j; i++)
      {
        String str = paramArrayOfString[i];
        localObject2 = (BeanPropertyWriter)((Map)localObject1).get(str);
        if (localObject2 != null) {
          paramList.put(str, localObject2);
        }
      }
    }
    Object localObject2 = paramList1.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      paramList1 = (String)((Iterator)localObject2).next();
      paramArrayOfString = (BeanPropertyWriter)((Map)localObject1).get(paramList1);
      if (paramArrayOfString != null) {
        paramList.put(paramList1, paramArrayOfString);
      }
    }
    paramList.putAll((Map)localObject1);
    return new ArrayList(paramList.values());
  }
  
  protected JsonSerializer<Object> constructBeanSerializer(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (paramBasicBeanDescription.getBeanClass() == Object.class) {
      throw new IllegalArgumentException("Can not create bean serializer for Object.class");
    }
    BeanSerializerBuilder localBeanSerializerBuilder = constructBeanSerializerBuilder(paramBasicBeanDescription);
    Object localObject3 = findBeanProperties(paramSerializationConfig, paramBasicBeanDescription);
    AnnotatedMethod localAnnotatedMethod = paramBasicBeanDescription.findAnyGetter();
    Object localObject2 = localObject3;
    Object localObject1;
    if (this._factoryConfig.hasSerializerModifiers())
    {
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = new ArrayList();
      }
      localObject3 = this._factoryConfig.serializerModifiers().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = ((BeanSerializerModifier)((Iterator)localObject3).next()).changeProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
      }
    }
    if ((localObject2 == null) || (((List)localObject2).size() == 0)) {
      if (localAnnotatedMethod == null) {
        if (paramBasicBeanDescription.hasKnownClassAnnotations()) {
          paramSerializationConfig = localBeanSerializerBuilder.createDummy();
        }
      }
    }
    for (;;)
    {
      return paramSerializationConfig;
      paramSerializationConfig = null;
      continue;
      for (localObject1 = Collections.emptyList();; localObject1 = sortBeanProperties(paramSerializationConfig, paramBasicBeanDescription, filterBeanProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject2)))
      {
        localObject2 = localObject1;
        if (!this._factoryConfig.hasSerializerModifiers()) {
          break;
        }
        localObject3 = this._factoryConfig.serializerModifiers().iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject1 = ((BeanSerializerModifier)((Iterator)localObject3).next()).orderProperties(paramSerializationConfig, paramBasicBeanDescription, (List)localObject1);
        }
      }
      localBeanSerializerBuilder.setProperties((List)localObject2);
      localBeanSerializerBuilder.setFilterId(findFilterId(paramSerializationConfig, paramBasicBeanDescription));
      if (localAnnotatedMethod != null)
      {
        localObject1 = localAnnotatedMethod.getType(paramBasicBeanDescription.bindingsForBeanType());
        localBeanSerializerBuilder.setAnyGetter(new AnyGetterWriter(localAnnotatedMethod, MapSerializer.construct(null, (JavaType)localObject1, paramSerializationConfig.isEnabled(SerializationConfig.Feature.USE_STATIC_TYPING), createTypeSerializer(paramSerializationConfig, ((JavaType)localObject1).getContentType(), paramBeanProperty), paramBeanProperty, null, null)));
      }
      processViews(paramSerializationConfig, localBeanSerializerBuilder);
      localObject1 = localBeanSerializerBuilder;
      if (this._factoryConfig.hasSerializerModifiers())
      {
        localObject2 = this._factoryConfig.serializerModifiers().iterator();
        for (paramBeanProperty = localBeanSerializerBuilder;; paramBeanProperty = ((BeanSerializerModifier)((Iterator)localObject2).next()).updateBuilder(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty))
        {
          localObject1 = paramBeanProperty;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
        }
      }
      paramSerializationConfig = ((BeanSerializerBuilder)localObject1).build();
    }
  }
  
  protected BeanSerializerBuilder constructBeanSerializerBuilder(BasicBeanDescription paramBasicBeanDescription)
  {
    return new BeanSerializerBuilder(paramBasicBeanDescription);
  }
  
  protected BeanPropertyWriter constructFilteredBeanWriter(BeanPropertyWriter paramBeanPropertyWriter, Class<?>[] paramArrayOfClass)
  {
    return FilteredBeanPropertyWriter.constructViewBased(paramBeanPropertyWriter, paramArrayOfClass);
  }
  
  protected PropertyBuilder constructPropertyBuilder(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    return new PropertyBuilder(paramSerializationConfig, paramBasicBeanDescription);
  }
  
  public JsonSerializer<Object> createKeySerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
  {
    Object localObject;
    if (!this._factoryConfig.hasKeySerializers()) {
      localObject = null;
    }
    for (;;)
    {
      return (JsonSerializer<Object>)localObject;
      BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramSerializationConfig.introspectClassAnnotations(paramJavaType.getRawClass());
      localObject = null;
      Iterator localIterator = this._factoryConfig.keySerializers().iterator();
      if (localIterator.hasNext())
      {
        JsonSerializer localJsonSerializer = ((Serializers)localIterator.next()).findSerializer(paramSerializationConfig, paramJavaType, localBasicBeanDescription, paramBeanProperty);
        localObject = localJsonSerializer;
        if (localJsonSerializer == null) {
          break;
        }
        localObject = localJsonSerializer;
      }
    }
  }
  
  public JsonSerializer<Object> createSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    BasicBeanDescription localBasicBeanDescription = (BasicBeanDescription)paramSerializationConfig.introspect(paramJavaType);
    Object localObject = findSerializerFromAnnotation(paramSerializationConfig, localBasicBeanDescription.getClassInfo(), paramBeanProperty);
    if (localObject != null) {
      paramSerializationConfig = (SerializationConfig)localObject;
    }
    for (;;)
    {
      return paramSerializationConfig;
      JavaType localJavaType = modifyTypeByAnnotation(paramSerializationConfig, localBasicBeanDescription.getClassInfo(), paramJavaType);
      if (localJavaType != paramJavaType) {}
      for (boolean bool = true;; bool = false)
      {
        if (!paramJavaType.isContainerType()) {
          break label84;
        }
        paramSerializationConfig = buildContainerSerializer(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty, bool);
        break;
      }
      label84:
      localObject = this._factoryConfig.serializers().iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext())
        {
          paramJavaType = ((Serializers)((Iterator)localObject).next()).findSerializer(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty);
          if (paramJavaType != null)
          {
            paramSerializationConfig = paramJavaType;
            break;
          }
        }
      }
      paramJavaType = findSerializerByLookup(localJavaType, paramSerializationConfig, localBasicBeanDescription, paramBeanProperty, bool);
      if (paramJavaType != null)
      {
        paramSerializationConfig = paramJavaType;
      }
      else
      {
        paramJavaType = findSerializerByPrimaryType(localJavaType, paramSerializationConfig, localBasicBeanDescription, paramBeanProperty, bool);
        if (paramJavaType != null)
        {
          paramSerializationConfig = paramJavaType;
        }
        else
        {
          localObject = findBeanSerializer(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty);
          paramJavaType = (JavaType)localObject;
          if (localObject == null) {
            paramJavaType = super.findSerializerByAddonType(paramSerializationConfig, localJavaType, localBasicBeanDescription, paramBeanProperty, bool);
          }
          paramSerializationConfig = paramJavaType;
        }
      }
    }
  }
  
  protected Iterable<Serializers> customSerializers()
  {
    return this._factoryConfig.serializers();
  }
  
  protected List<BeanPropertyWriter> filterBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List<BeanPropertyWriter> paramList)
  {
    paramSerializationConfig = paramSerializationConfig.getAnnotationIntrospector().findPropertiesToIgnore(paramBasicBeanDescription.getClassInfo());
    if ((paramSerializationConfig != null) && (paramSerializationConfig.length > 0))
    {
      paramBasicBeanDescription = ArrayBuilders.arrayToSet(paramSerializationConfig);
      paramSerializationConfig = paramList.iterator();
      while (paramSerializationConfig.hasNext()) {
        if (paramBasicBeanDescription.contains(((BeanPropertyWriter)paramSerializationConfig.next()).getName())) {
          paramSerializationConfig.remove();
        }
      }
    }
    return paramList;
  }
  
  protected List<BeanPropertyWriter> findBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
    throws JsonMappingException
  {
    Object localObject1 = paramSerializationConfig.getDefaultVisibilityChecker();
    Object localObject2 = localObject1;
    if (!paramSerializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_GETTERS)) {
      localObject2 = ((VisibilityChecker)localObject1).withGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject1 = localObject2;
    if (!paramSerializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS)) {
      localObject1 = ((VisibilityChecker)localObject2).withIsGetterVisibility(JsonAutoDetect.Visibility.NONE);
    }
    localObject2 = localObject1;
    if (!paramSerializationConfig.isEnabled(SerializationConfig.Feature.AUTO_DETECT_FIELDS)) {
      localObject2 = ((VisibilityChecker)localObject1).withFieldVisibility(JsonAutoDetect.Visibility.NONE);
    }
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    localObject1 = localAnnotationIntrospector.findAutoDetectVisibility(paramBasicBeanDescription.getClassInfo(), (VisibilityChecker)localObject2);
    Object localObject3 = paramBasicBeanDescription.findGetters((VisibilityChecker)localObject1, null);
    Object localObject4 = paramBasicBeanDescription.findSerializableFields((VisibilityChecker)localObject1, ((LinkedHashMap)localObject3).keySet());
    removeIgnorableTypes(paramSerializationConfig, paramBasicBeanDescription, (Map)localObject3);
    removeIgnorableTypes(paramSerializationConfig, paramBasicBeanDescription, (Map)localObject4);
    if ((((LinkedHashMap)localObject3).isEmpty()) && (((LinkedHashMap)localObject4).isEmpty()))
    {
      paramBasicBeanDescription = null;
      return paramBasicBeanDescription;
    }
    boolean bool = usesStaticTyping(paramSerializationConfig, paramBasicBeanDescription, null, null);
    localObject2 = constructPropertyBuilder(paramSerializationConfig, paramBasicBeanDescription);
    localObject1 = new ArrayList(((LinkedHashMap)localObject3).size());
    TypeBindings localTypeBindings = paramBasicBeanDescription.bindingsForBeanType();
    Iterator localIterator = ((LinkedHashMap)localObject4).entrySet().iterator();
    while (localIterator.hasNext())
    {
      paramBasicBeanDescription = (Map.Entry)localIterator.next();
      localObject4 = localAnnotationIntrospector.findReferenceType((AnnotatedMember)paramBasicBeanDescription.getValue());
      if ((localObject4 == null) || (!((AnnotationIntrospector.ReferenceProperty)localObject4).isBackReference())) {
        ((ArrayList)localObject1).add(_constructWriter(paramSerializationConfig, localTypeBindings, (PropertyBuilder)localObject2, bool, (String)paramBasicBeanDescription.getKey(), (AnnotatedMember)paramBasicBeanDescription.getValue()));
      }
    }
    localObject3 = ((LinkedHashMap)localObject3).entrySet().iterator();
    for (;;)
    {
      paramBasicBeanDescription = (BasicBeanDescription)localObject1;
      if (!((Iterator)localObject3).hasNext()) {
        break;
      }
      paramBasicBeanDescription = (Map.Entry)((Iterator)localObject3).next();
      localObject4 = localAnnotationIntrospector.findReferenceType((AnnotatedMember)paramBasicBeanDescription.getValue());
      if ((localObject4 == null) || (!((AnnotationIntrospector.ReferenceProperty)localObject4).isBackReference())) {
        ((ArrayList)localObject1).add(_constructWriter(paramSerializationConfig, localTypeBindings, (PropertyBuilder)localObject2, bool, (String)paramBasicBeanDescription.getKey(), (AnnotatedMember)paramBasicBeanDescription.getValue()));
      }
    }
  }
  
  public JsonSerializer<Object> findBeanSerializer(SerializationConfig paramSerializationConfig, JavaType paramJavaType, BasicBeanDescription paramBasicBeanDescription, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    if (!isPotentialBeanType(paramJavaType.getRawClass())) {
      paramJavaType = null;
    }
    do
    {
      return paramJavaType;
      paramBeanProperty = constructBeanSerializer(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty);
      paramJavaType = paramBeanProperty;
    } while (!this._factoryConfig.hasSerializerModifiers());
    Iterator localIterator = this._factoryConfig.serializerModifiers().iterator();
    for (;;)
    {
      paramJavaType = paramBeanProperty;
      if (!localIterator.hasNext()) {
        break;
      }
      paramBeanProperty = ((BeanSerializerModifier)localIterator.next()).modifySerializer(paramSerializationConfig, paramBasicBeanDescription, paramBeanProperty);
    }
  }
  
  protected Object findFilterId(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription)
  {
    return paramSerializationConfig.getAnnotationIntrospector().findFilterId(paramBasicBeanDescription.getClassInfo());
  }
  
  public TypeSerializer findPropertyContentTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    JavaType localJavaType = paramJavaType.getContentType();
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    paramJavaType = localAnnotationIntrospector.findPropertyContentTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (paramJavaType == null) {}
    for (paramJavaType = createTypeSerializer(paramSerializationConfig, localJavaType, paramBeanProperty);; paramJavaType = paramJavaType.buildTypeSerializer(paramSerializationConfig, localJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector), paramBeanProperty)) {
      return paramJavaType;
    }
  }
  
  public TypeSerializer findPropertyTypeSerializer(JavaType paramJavaType, SerializationConfig paramSerializationConfig, AnnotatedMember paramAnnotatedMember, BeanProperty paramBeanProperty)
    throws JsonMappingException
  {
    AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
    TypeResolverBuilder localTypeResolverBuilder = localAnnotationIntrospector.findPropertyTypeResolver(paramSerializationConfig, paramAnnotatedMember, paramJavaType);
    if (localTypeResolverBuilder == null) {}
    for (paramJavaType = createTypeSerializer(paramSerializationConfig, paramJavaType, paramBeanProperty);; paramJavaType = localTypeResolverBuilder.buildTypeSerializer(paramSerializationConfig, paramJavaType, paramSerializationConfig.getSubtypeResolver().collectAndResolveSubtypes(paramAnnotatedMember, paramSerializationConfig, localAnnotationIntrospector), paramBeanProperty)) {
      return paramJavaType;
    }
  }
  
  public SerializerFactory.Config getConfig()
  {
    return this._factoryConfig;
  }
  
  protected boolean isPotentialBeanType(Class<?> paramClass)
  {
    if ((ClassUtil.canBeABeanType(paramClass) == null) && (!ClassUtil.isProxyType(paramClass))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void processViews(SerializationConfig paramSerializationConfig, BeanSerializerBuilder paramBeanSerializerBuilder)
  {
    List localList = paramBeanSerializerBuilder.getProperties();
    boolean bool = paramSerializationConfig.isEnabled(SerializationConfig.Feature.DEFAULT_VIEW_INCLUSION);
    int m = localList.size();
    int i = 0;
    BeanPropertyWriter[] arrayOfBeanPropertyWriter = new BeanPropertyWriter[m];
    int j = 0;
    if (j < m)
    {
      paramSerializationConfig = (BeanPropertyWriter)localList.get(j);
      Class[] arrayOfClass = paramSerializationConfig.getViews();
      int k;
      if (arrayOfClass == null)
      {
        k = i;
        if (bool)
        {
          arrayOfBeanPropertyWriter[j] = paramSerializationConfig;
          k = i;
        }
      }
      for (;;)
      {
        j++;
        i = k;
        break;
        k = i + 1;
        arrayOfBeanPropertyWriter[j] = constructFilteredBeanWriter(paramSerializationConfig, arrayOfClass);
      }
    }
    if ((bool) && (i == 0)) {}
    for (;;)
    {
      return;
      paramBeanSerializerBuilder.setFilteredProperties(arrayOfBeanPropertyWriter);
    }
  }
  
  protected <T extends AnnotatedMember> void removeIgnorableTypes(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, Map<String, T> paramMap)
  {
    if (paramMap.isEmpty()) {}
    for (;;)
    {
      return;
      AnnotationIntrospector localAnnotationIntrospector = paramSerializationConfig.getAnnotationIntrospector();
      Iterator localIterator = paramMap.entrySet().iterator();
      HashMap localHashMap = new HashMap();
      while (localIterator.hasNext())
      {
        Class localClass = ((AnnotatedMember)((Map.Entry)localIterator.next()).getValue()).getRawType();
        paramMap = (Boolean)localHashMap.get(localClass);
        paramBasicBeanDescription = paramMap;
        if (paramMap == null)
        {
          paramMap = localAnnotationIntrospector.isIgnorableType(((BasicBeanDescription)paramSerializationConfig.introspectClassAnnotations(localClass)).getClassInfo());
          paramBasicBeanDescription = paramMap;
          if (paramMap == null) {
            paramBasicBeanDescription = Boolean.FALSE;
          }
          localHashMap.put(localClass, paramBasicBeanDescription);
        }
        if (paramBasicBeanDescription.booleanValue()) {
          localIterator.remove();
        }
      }
    }
  }
  
  protected List<BeanPropertyWriter> sortBeanProperties(SerializationConfig paramSerializationConfig, BasicBeanDescription paramBasicBeanDescription, List<BeanPropertyWriter> paramList)
  {
    List localList = paramBasicBeanDescription.findCreatorPropertyNames();
    Object localObject = paramSerializationConfig.getAnnotationIntrospector();
    AnnotatedClass localAnnotatedClass = paramBasicBeanDescription.getClassInfo();
    paramBasicBeanDescription = ((AnnotationIntrospector)localObject).findSerializationPropertyOrder(localAnnotatedClass);
    localObject = ((AnnotationIntrospector)localObject).findSerializationSortAlphabetically(localAnnotatedClass);
    if (localObject == null) {}
    for (boolean bool = paramSerializationConfig.isEnabled(SerializationConfig.Feature.SORT_PROPERTIES_ALPHABETICALLY);; bool = ((Boolean)localObject).booleanValue())
    {
      if ((!bool) && (localList.isEmpty()))
      {
        paramSerializationConfig = paramList;
        if (paramBasicBeanDescription == null) {}
      }
      else
      {
        paramSerializationConfig = _sortBeanProperties(paramList, localList, paramBasicBeanDescription, bool);
      }
      return paramSerializationConfig;
    }
  }
  
  public SerializerFactory withConfig(SerializerFactory.Config paramConfig)
  {
    if (this._factoryConfig == paramConfig) {}
    for (paramConfig = this;; paramConfig = new BeanSerializerFactory(paramConfig))
    {
      return paramConfig;
      if (getClass() != BeanSerializerFactory.class) {
        throw new IllegalStateException("Subtype of BeanSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
      }
    }
  }
  
  public static class ConfigImpl
    extends SerializerFactory.Config
  {
    protected static final BeanSerializerModifier[] NO_MODIFIERS = new BeanSerializerModifier[0];
    protected static final Serializers[] NO_SERIALIZERS = new Serializers[0];
    protected final Serializers[] _additionalKeySerializers;
    protected final Serializers[] _additionalSerializers;
    protected final BeanSerializerModifier[] _modifiers;
    
    public ConfigImpl()
    {
      this(null, null, null);
    }
    
    protected ConfigImpl(Serializers[] paramArrayOfSerializers1, Serializers[] paramArrayOfSerializers2, BeanSerializerModifier[] paramArrayOfBeanSerializerModifier)
    {
      Serializers[] arrayOfSerializers = paramArrayOfSerializers1;
      if (paramArrayOfSerializers1 == null) {
        arrayOfSerializers = NO_SERIALIZERS;
      }
      this._additionalSerializers = arrayOfSerializers;
      paramArrayOfSerializers1 = paramArrayOfSerializers2;
      if (paramArrayOfSerializers2 == null) {
        paramArrayOfSerializers1 = NO_SERIALIZERS;
      }
      this._additionalKeySerializers = paramArrayOfSerializers1;
      paramArrayOfSerializers1 = paramArrayOfBeanSerializerModifier;
      if (paramArrayOfBeanSerializerModifier == null) {
        paramArrayOfSerializers1 = NO_MODIFIERS;
      }
      this._modifiers = paramArrayOfSerializers1;
    }
    
    public boolean hasKeySerializers()
    {
      if (this._additionalKeySerializers.length > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public boolean hasSerializerModifiers()
    {
      if (this._modifiers.length > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public boolean hasSerializers()
    {
      if (this._additionalSerializers.length > 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public Iterable<Serializers> keySerializers()
    {
      return ArrayBuilders.arrayAsIterable(this._additionalKeySerializers);
    }
    
    public Iterable<BeanSerializerModifier> serializerModifiers()
    {
      return ArrayBuilders.arrayAsIterable(this._modifiers);
    }
    
    public Iterable<Serializers> serializers()
    {
      return ArrayBuilders.arrayAsIterable(this._additionalSerializers);
    }
    
    public SerializerFactory.Config withAdditionalKeySerializers(Serializers paramSerializers)
    {
      if (paramSerializers == null) {
        throw new IllegalArgumentException("Can not pass null Serializers");
      }
      paramSerializers = (Serializers[])ArrayBuilders.insertInListNoDup(this._additionalKeySerializers, paramSerializers);
      return new ConfigImpl(this._additionalSerializers, paramSerializers, this._modifiers);
    }
    
    public SerializerFactory.Config withAdditionalSerializers(Serializers paramSerializers)
    {
      if (paramSerializers == null) {
        throw new IllegalArgumentException("Can not pass null Serializers");
      }
      return new ConfigImpl((Serializers[])ArrayBuilders.insertInListNoDup(this._additionalSerializers, paramSerializers), this._additionalKeySerializers, this._modifiers);
    }
    
    public SerializerFactory.Config withSerializerModifier(BeanSerializerModifier paramBeanSerializerModifier)
    {
      if (paramBeanSerializerModifier == null) {
        throw new IllegalArgumentException("Can not pass null modifier");
      }
      paramBeanSerializerModifier = (BeanSerializerModifier[])ArrayBuilders.insertInListNoDup(this._modifiers, paramBeanSerializerModifier);
      return new ConfigImpl(this._additionalSerializers, this._additionalKeySerializers, paramBeanSerializerModifier);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\ser\BeanSerializerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */