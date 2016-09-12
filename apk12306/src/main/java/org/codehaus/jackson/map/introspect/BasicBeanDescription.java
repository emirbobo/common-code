package org.codehaus.jackson.map.introspect;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.ReferenceProperty;
import org.codehaus.jackson.map.BeanDescription;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.PropertyNamingStrategy;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.type.TypeBindings;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BasicBeanDescription
  extends BeanDescription
{
  protected final AnnotationIntrospector _annotationIntrospector;
  protected TypeBindings _bindings;
  protected final AnnotatedClass _classInfo;
  protected final MapperConfig<?> _config;
  
  public BasicBeanDescription(MapperConfig<?> paramMapperConfig, JavaType paramJavaType, AnnotatedClass paramAnnotatedClass)
  {
    super(paramJavaType);
    this._config = paramMapperConfig;
    this._annotationIntrospector = paramMapperConfig.getAnnotationIntrospector();
    this._classInfo = paramAnnotatedClass;
  }
  
  public static String descFor(AnnotatedElement paramAnnotatedElement)
  {
    if ((paramAnnotatedElement instanceof Class)) {
      paramAnnotatedElement = "class " + ((Class)paramAnnotatedElement).getName();
    }
    for (;;)
    {
      return paramAnnotatedElement;
      if ((paramAnnotatedElement instanceof Method))
      {
        paramAnnotatedElement = (Method)paramAnnotatedElement;
        paramAnnotatedElement = "method " + paramAnnotatedElement.getName() + " (from class " + paramAnnotatedElement.getDeclaringClass().getName() + ")";
      }
      else if ((paramAnnotatedElement instanceof Constructor))
      {
        paramAnnotatedElement = (Constructor)paramAnnotatedElement;
        paramAnnotatedElement = "constructor() (from class " + paramAnnotatedElement.getDeclaringClass().getName() + ")";
      }
      else
      {
        paramAnnotatedElement = "unknown type [" + paramAnnotatedElement.getClass() + "]";
      }
    }
  }
  
  public static String manglePropertyName(String paramString)
  {
    int j = paramString.length();
    if (j == 0)
    {
      paramString = null;
      return paramString;
    }
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      char c1;
      if (i < j)
      {
        char c2 = paramString.charAt(i);
        c1 = Character.toLowerCase(c2);
        if (c2 != c1) {}
      }
      else
      {
        if (localObject1 == null) {
          break;
        }
        paramString = ((StringBuilder)localObject1).toString();
        break;
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder(paramString);
      }
      ((StringBuilder)localObject2).setCharAt(i, c1);
      i++;
      localObject1 = localObject2;
    }
  }
  
  public LinkedHashMap<String, AnnotatedField> _findPropertyFields(VisibilityChecker<?> paramVisibilityChecker, Collection<String> paramCollection, boolean paramBoolean)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    PropertyNamingStrategy localPropertyNamingStrategy = this._config.getPropertyNamingStrategy();
    Iterator localIterator = this._classInfo.fields().iterator();
    label69:
    label236:
    label279:
    while (localIterator.hasNext())
    {
      AnnotatedField localAnnotatedField = (AnnotatedField)localIterator.next();
      Object localObject2;
      Object localObject1;
      if (paramBoolean)
      {
        localObject2 = this._annotationIntrospector.findSerializablePropertyName(localAnnotatedField);
        if (localObject2 == null) {
          break label236;
        }
        localObject1 = localObject2;
        if (((String)localObject2).length() == 0)
        {
          localObject2 = localAnnotatedField.getName();
          localObject1 = localObject2;
          if (localPropertyNamingStrategy != null) {
            localObject1 = localPropertyNamingStrategy.nameForField(this._config, localAnnotatedField, (String)localObject2);
          }
        }
      }
      for (;;)
      {
        if ((paramCollection != null) && (paramCollection.contains(localObject1))) {
          break label279;
        }
        localObject2 = (AnnotatedField)localLinkedHashMap.put(localObject1, localAnnotatedField);
        if ((localObject2 == null) || (((AnnotatedField)localObject2).getDeclaringClass() != localAnnotatedField.getDeclaringClass())) {
          break;
        }
        paramVisibilityChecker = ((AnnotatedField)localObject2).getFullName();
        paramCollection = localAnnotatedField.getFullName();
        throw new IllegalArgumentException("Multiple fields representing property \"" + (String)localObject1 + "\": " + paramVisibilityChecker + " vs " + paramCollection);
        localObject2 = this._annotationIntrospector.findDeserializablePropertyName(localAnnotatedField);
        break label69;
        if (!paramVisibilityChecker.isFieldVisible(localAnnotatedField)) {
          break;
        }
        localObject2 = localAnnotatedField.getName();
        localObject1 = localObject2;
        if (localPropertyNamingStrategy != null) {
          localObject1 = localPropertyNamingStrategy.nameForField(this._config, localAnnotatedField, (String)localObject2);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public TypeBindings bindingsForBeanType()
  {
    if (this._bindings == null) {
      this._bindings = new TypeBindings(this._config.getTypeFactory(), this._type);
    }
    return this._bindings;
  }
  
  public AnnotatedMethod findAnyGetter()
    throws IllegalArgumentException
  {
    Object localObject = null;
    Iterator localIterator = this._classInfo.memberMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      if (this._annotationIntrospector.hasAnyGetterAnnotation(localAnnotatedMethod))
      {
        if (localObject != null) {
          throw new IllegalArgumentException("Multiple methods with 'any-getter' annotation (" + ((AnnotatedMethod)localObject).getName() + "(), " + localAnnotatedMethod.getName() + ")");
        }
        if (!Map.class.isAssignableFrom(localAnnotatedMethod.getRawType())) {
          throw new IllegalArgumentException("Invalid 'any-getter' annotation on method " + localAnnotatedMethod.getName() + "(): return type is not instance of java.util.Map");
        }
        localObject = localAnnotatedMethod;
      }
    }
    return (AnnotatedMethod)localObject;
  }
  
  public AnnotatedMethod findAnySetter()
    throws IllegalArgumentException
  {
    Object localObject = null;
    Iterator localIterator = this._classInfo.memberMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      if (this._annotationIntrospector.hasAnySetterAnnotation(localAnnotatedMethod))
      {
        if (localObject != null) {
          throw new IllegalArgumentException("Multiple methods with 'any-setter' annotation (" + ((AnnotatedMethod)localObject).getName() + "(), " + localAnnotatedMethod.getName() + ")");
        }
        int i = localAnnotatedMethod.getParameterCount();
        if (i != 2) {
          throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + localAnnotatedMethod.getName() + "(): takes " + i + " parameters, should take 2");
        }
        localObject = localAnnotatedMethod.getParameterClass(0);
        if ((localObject != String.class) && (localObject != Object.class)) {
          throw new IllegalArgumentException("Invalid 'any-setter' annotation on method " + localAnnotatedMethod.getName() + "(): first argument not of type String or Object, but " + ((Class)localObject).getName());
        }
        localObject = localAnnotatedMethod;
      }
    }
    return (AnnotatedMethod)localObject;
  }
  
  public Map<String, AnnotatedMember> findBackReferenceProperties()
  {
    Object localObject1 = null;
    Iterator localIterator = this._classInfo.memberMethods().iterator();
    Object localObject3;
    AnnotationIntrospector.ReferenceProperty localReferenceProperty;
    while (localIterator.hasNext())
    {
      localObject3 = (AnnotatedMethod)localIterator.next();
      if (((AnnotatedMethod)localObject3).getParameterCount() == 1)
      {
        localReferenceProperty = this._annotationIntrospector.findReferenceType((AnnotatedMember)localObject3);
        if ((localReferenceProperty != null) && (localReferenceProperty.isBackReference()))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new HashMap();
          }
          localObject1 = localObject2;
          if (((HashMap)localObject2).put(localReferenceProperty.getName(), localObject3) != null) {
            throw new IllegalArgumentException("Multiple back-reference properties with name '" + localReferenceProperty.getName() + "'");
          }
        }
      }
    }
    localIterator = this._classInfo.fields().iterator();
    Object localObject2 = localObject1;
    while (localIterator.hasNext())
    {
      localObject3 = (AnnotatedField)localIterator.next();
      localReferenceProperty = this._annotationIntrospector.findReferenceType((AnnotatedMember)localObject3);
      if ((localReferenceProperty != null) && (localReferenceProperty.isBackReference()))
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new HashMap();
        }
        localObject2 = localObject1;
        if (((HashMap)localObject1).put(localReferenceProperty.getName(), localObject3) != null) {
          throw new IllegalArgumentException("Multiple back-reference properties with name '" + localReferenceProperty.getName() + "'");
        }
      }
    }
    return (Map<String, AnnotatedMember>)localObject2;
  }
  
  public List<String> findCreatorPropertyNames()
  {
    Object localObject1 = null;
    int i = 0;
    while (i < 2)
    {
      if (i == 0) {}
      for (localObject2 = getConstructors();; localObject2 = getFactoryMethods())
      {
        Iterator localIterator = ((List)localObject2).iterator();
        localObject2 = localObject1;
        AnnotatedWithParams localAnnotatedWithParams;
        int k;
        String str;
        do
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localAnnotatedWithParams = (AnnotatedWithParams)localIterator.next();
            k = localAnnotatedWithParams.getParameterCount();
          } while (k < 1);
          str = this._annotationIntrospector.findPropertyNameForParam(localAnnotatedWithParams.getParameter(0));
        } while (str == null);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList();
        }
        ((List)localObject1).add(str);
        for (int j = 1;; j++)
        {
          localObject2 = localObject1;
          if (j >= k) {
            break;
          }
          ((List)localObject1).add(this._annotationIntrospector.findPropertyNameForParam(localAnnotatedWithParams.getParameter(j)));
        }
      }
      i++;
      localObject1 = localObject2;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = Collections.emptyList();
    }
    return (List<String>)localObject2;
  }
  
  public Constructor<?> findDefaultConstructor()
  {
    Object localObject = this._classInfo.getDefaultConstructor();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((AnnotatedConstructor)localObject).getAnnotated()) {
      return (Constructor<?>)localObject;
    }
  }
  
  public LinkedHashMap<String, AnnotatedField> findDeserializableFields(VisibilityChecker<?> paramVisibilityChecker, Collection<String> paramCollection)
  {
    return _findPropertyFields(paramVisibilityChecker, paramCollection, false);
  }
  
  public Method findFactoryMethod(Class<?>... paramVarArgs)
  {
    Iterator localIterator = this._classInfo.getStaticMethods().iterator();
    AnnotatedMethod localAnnotatedMethod;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
        if (isFactoryMethod(localAnnotatedMethod))
        {
          Class localClass = localAnnotatedMethod.getParameterClass(0);
          int j = paramVarArgs.length;
          i = 0;
          label58:
          if (i < j) {
            if (!localClass.isAssignableFrom(paramVarArgs[i])) {
              break;
            }
          }
        }
      }
    }
    for (paramVarArgs = localAnnotatedMethod.getAnnotated();; paramVarArgs = null)
    {
      return paramVarArgs;
      i++;
      break label58;
      break;
    }
  }
  
  public LinkedHashMap<String, AnnotatedMethod> findGetters(VisibilityChecker<?> paramVisibilityChecker, Collection<String> paramCollection)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    PropertyNamingStrategy localPropertyNamingStrategy = this._config.getPropertyNamingStrategy();
    Iterator localIterator = this._classInfo.memberMethods().iterator();
    label137:
    label305:
    label326:
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      if (localAnnotatedMethod.getParameterCount() == 0)
      {
        Object localObject2 = this._annotationIntrospector.findGettablePropertyName(localAnnotatedMethod);
        Object localObject1;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() == 0)
          {
            localObject1 = okNameForAnyGetter(localAnnotatedMethod, localAnnotatedMethod.getName());
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = localAnnotatedMethod.getName();
            }
            localObject1 = localObject2;
            if (localPropertyNamingStrategy != null) {
              localObject1 = localPropertyNamingStrategy.nameForGetterMethod(this._config, localAnnotatedMethod, (String)localObject2);
            }
          }
          if ((paramCollection == null) || (!paramCollection.contains(localObject1)))
          {
            localObject2 = (AnnotatedMethod)localLinkedHashMap.put(localObject1, localAnnotatedMethod);
            if (localObject2 == null) {
              continue;
            }
            paramVisibilityChecker = ((AnnotatedMethod)localObject2).getFullName();
            paramCollection = localAnnotatedMethod.getFullName();
            throw new IllegalArgumentException("Conflicting getter definitions for property \"" + (String)localObject1 + "\": " + paramVisibilityChecker + " vs " + paramCollection);
          }
        }
        else
        {
          localObject1 = localAnnotatedMethod.getName();
          if (!((String)localObject1).startsWith("get")) {
            break label305;
          }
          if (!paramVisibilityChecker.isGetterVisible(localAnnotatedMethod)) {
            continue;
          }
        }
        for (localObject2 = okNameForGetter(localAnnotatedMethod, (String)localObject1);; localObject2 = okNameForIsGetter(localAnnotatedMethod, (String)localObject1))
        {
          if ((localObject2 == null) || (this._annotationIntrospector.hasAnyGetterAnnotation(localAnnotatedMethod))) {
            break label326;
          }
          localObject1 = localObject2;
          if (localPropertyNamingStrategy == null) {
            break label137;
          }
          localObject1 = localPropertyNamingStrategy.nameForGetterMethod(this._config, localAnnotatedMethod, (String)localObject2);
          break label137;
          break;
          if (!paramVisibilityChecker.isIsGetterVisible(localAnnotatedMethod)) {
            break;
          }
        }
      }
    }
    return localLinkedHashMap;
  }
  
  public AnnotatedMethod findJsonValueMethod()
  {
    Object localObject = null;
    Iterator localIterator = this._classInfo.memberMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      if (this._annotationIntrospector.hasAsValueAnnotation(localAnnotatedMethod))
      {
        if (localObject != null) {
          throw new IllegalArgumentException("Multiple methods with active 'as-value' annotation (" + ((AnnotatedMethod)localObject).getName() + "(), " + localAnnotatedMethod.getName() + ")");
        }
        if (!ClassUtil.hasGetterSignature(localAnnotatedMethod.getAnnotated())) {
          throw new IllegalArgumentException("Method " + localAnnotatedMethod.getName() + "() marked with an 'as-value' annotation, but does not have valid getter signature (non-static, takes no args, returns a value)");
        }
        localObject = localAnnotatedMethod;
      }
    }
    return (AnnotatedMethod)localObject;
  }
  
  public AnnotatedMethod findMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    return this._classInfo.findMethod(paramString, paramArrayOfClass);
  }
  
  public LinkedHashMap<String, AnnotatedField> findSerializableFields(VisibilityChecker<?> paramVisibilityChecker, Collection<String> paramCollection)
  {
    return _findPropertyFields(paramVisibilityChecker, paramCollection, true);
  }
  
  public JsonSerialize.Inclusion findSerializationInclusion(JsonSerialize.Inclusion paramInclusion)
  {
    return this._annotationIntrospector.findSerializationInclusion(this._classInfo, paramInclusion);
  }
  
  public LinkedHashMap<String, AnnotatedMethod> findSetters(VisibilityChecker<?> paramVisibilityChecker)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    PropertyNamingStrategy localPropertyNamingStrategy = this._config.getPropertyNamingStrategy();
    Iterator localIterator = this._classInfo.memberMethods().iterator();
    while (localIterator.hasNext())
    {
      AnnotatedMethod localAnnotatedMethod = (AnnotatedMethod)localIterator.next();
      if (localAnnotatedMethod.getParameterCount() == 1)
      {
        Object localObject2 = this._annotationIntrospector.findSettablePropertyName(localAnnotatedMethod);
        Object localObject1;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() == 0)
          {
            localObject1 = okNameForSetter(localAnnotatedMethod);
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = localAnnotatedMethod.getName();
            }
            localObject1 = localObject2;
            if (localPropertyNamingStrategy != null) {
              localObject1 = localPropertyNamingStrategy.nameForSetterMethod(this._config, localAnnotatedMethod, (String)localObject2);
            }
          }
        }
        for (;;)
        {
          localObject2 = (AnnotatedMethod)localLinkedHashMap.put(localObject1, localAnnotatedMethod);
          if (localObject2 == null) {
            break;
          }
          if (((AnnotatedMethod)localObject2).getDeclaringClass() != localAnnotatedMethod.getDeclaringClass()) {
            break label255;
          }
          paramVisibilityChecker = ((AnnotatedMethod)localObject2).getFullName();
          localObject2 = localAnnotatedMethod.getFullName();
          throw new IllegalArgumentException("Conflicting setter definitions for property \"" + (String)localObject1 + "\": " + paramVisibilityChecker + " vs " + (String)localObject2);
          if (!paramVisibilityChecker.isSetterVisible(localAnnotatedMethod)) {
            break;
          }
          localObject2 = okNameForSetter(localAnnotatedMethod);
          if (localObject2 == null) {
            break;
          }
          localObject1 = localObject2;
          if (localPropertyNamingStrategy != null) {
            localObject1 = localPropertyNamingStrategy.nameForSetterMethod(this._config, localAnnotatedMethod, (String)localObject2);
          }
        }
        label255:
        localLinkedHashMap.put(localObject1, localObject2);
      }
    }
    return localLinkedHashMap;
  }
  
  public Constructor<?> findSingleArgConstructor(Class<?>... paramVarArgs)
  {
    Iterator localIterator = this._classInfo.getConstructors().iterator();
    AnnotatedConstructor localAnnotatedConstructor;
    int i;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localAnnotatedConstructor = (AnnotatedConstructor)localIterator.next();
        if (localAnnotatedConstructor.getParameterCount() == 1)
        {
          Class localClass = localAnnotatedConstructor.getParameterClass(0);
          int j = paramVarArgs.length;
          i = 0;
          label58:
          if (i < j) {
            if (paramVarArgs[i] != localClass) {
              break;
            }
          }
        }
      }
    }
    for (paramVarArgs = localAnnotatedConstructor.getAnnotated();; paramVarArgs = null)
    {
      return paramVarArgs;
      i++;
      break label58;
      break;
    }
  }
  
  public Annotations getClassAnnotations()
  {
    return this._classInfo.getAnnotations();
  }
  
  public AnnotatedClass getClassInfo()
  {
    return this._classInfo;
  }
  
  public List<AnnotatedConstructor> getConstructors()
  {
    return this._classInfo.getConstructors();
  }
  
  public List<AnnotatedMethod> getFactoryMethods()
  {
    Object localObject2 = this._classInfo.getStaticMethods();
    Object localObject1;
    if (((List)localObject2).isEmpty()) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (List<AnnotatedMethod>)localObject1;
      localObject1 = new ArrayList();
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (AnnotatedMethod)localIterator.next();
        if (isFactoryMethod((AnnotatedMethod)localObject2)) {
          ((ArrayList)localObject1).add(localObject2);
        }
      }
    }
  }
  
  public boolean hasKnownClassAnnotations()
  {
    return this._classInfo.hasAnnotations();
  }
  
  public Object instantiateBean(boolean paramBoolean)
  {
    Object localObject = this._classInfo.getDefaultConstructor();
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      if (paramBoolean) {
        ((AnnotatedConstructor)localObject).fixAccess();
      }
      try
      {
        localObject = ((AnnotatedConstructor)localObject).getAnnotated().newInstance(new Object[0]);
      }
      catch (Exception localException)
      {
        Throwable localThrowable;
        while (localException.getCause() != null) {
          localThrowable = localException.getCause();
        }
        if ((localThrowable instanceof Error)) {
          throw ((Error)localThrowable);
        }
        if ((localThrowable instanceof RuntimeException)) {
          throw ((RuntimeException)localThrowable);
        }
        throw new IllegalArgumentException("Failed to instantiate bean of type " + this._classInfo.getAnnotated().getName() + ": (" + localThrowable.getClass().getName() + ") " + localThrowable.getMessage(), localThrowable);
      }
    }
  }
  
  protected boolean isCglibGetCallbacks(AnnotatedMethod paramAnnotatedMethod)
  {
    boolean bool2 = false;
    paramAnnotatedMethod = paramAnnotatedMethod.getRawType();
    boolean bool1 = bool2;
    if (paramAnnotatedMethod != null)
    {
      if (paramAnnotatedMethod.isArray()) {
        break label24;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label24:
      paramAnnotatedMethod = paramAnnotatedMethod.getComponentType().getPackage();
      bool1 = bool2;
      if (paramAnnotatedMethod != null)
      {
        paramAnnotatedMethod = paramAnnotatedMethod.getName();
        if (!paramAnnotatedMethod.startsWith("net.sf.cglib"))
        {
          bool1 = bool2;
          if (!paramAnnotatedMethod.startsWith("org.hibernate.repackage.cglib")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
  }
  
  protected boolean isFactoryMethod(AnnotatedMethod paramAnnotatedMethod)
  {
    boolean bool = false;
    Class localClass = paramAnnotatedMethod.getRawType();
    if (!getBeanClass().isAssignableFrom(localClass)) {}
    for (;;)
    {
      return bool;
      if (this._annotationIntrospector.hasCreatorAnnotation(paramAnnotatedMethod)) {
        bool = true;
      } else if ("valueOf".equals(paramAnnotatedMethod.getName())) {
        bool = true;
      }
    }
  }
  
  protected boolean isGroovyMetaClassGetter(AnnotatedMethod paramAnnotatedMethod)
  {
    boolean bool2 = false;
    paramAnnotatedMethod = paramAnnotatedMethod.getRawType();
    boolean bool1 = bool2;
    if (paramAnnotatedMethod != null)
    {
      if (!paramAnnotatedMethod.isArray()) {
        break label24;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label24:
      paramAnnotatedMethod = paramAnnotatedMethod.getPackage();
      bool1 = bool2;
      if (paramAnnotatedMethod != null)
      {
        bool1 = bool2;
        if (paramAnnotatedMethod.getName().startsWith("groovy.lang")) {
          bool1 = true;
        }
      }
    }
  }
  
  protected boolean isGroovyMetaClassSetter(AnnotatedMethod paramAnnotatedMethod)
  {
    boolean bool2 = false;
    paramAnnotatedMethod = paramAnnotatedMethod.getParameterClass(0).getPackage();
    boolean bool1 = bool2;
    if (paramAnnotatedMethod != null)
    {
      bool1 = bool2;
      if (paramAnnotatedMethod.getName().startsWith("groovy.lang")) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  protected String mangleGetterName(Annotated paramAnnotated, String paramString)
  {
    return manglePropertyName(paramString);
  }
  
  protected String mangleSetterName(Annotated paramAnnotated, String paramString)
  {
    return manglePropertyName(paramString);
  }
  
  public String okNameForAnyGetter(AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    String str2 = okNameForIsGetter(paramAnnotatedMethod, paramString);
    String str1 = str2;
    if (str2 == null) {
      str1 = okNameForGetter(paramAnnotatedMethod, paramString);
    }
    return str1;
  }
  
  public String okNameForGetter(AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString.startsWith("get"))
    {
      if (!"getCallbacks".equals(paramString)) {
        break label39;
      }
      if (!isCglibGetCallbacks(paramAnnotatedMethod)) {
        break label60;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (String)localObject1;
      label39:
      if ("getMetaClass".equals(paramString))
      {
        localObject1 = localObject2;
        if (isGroovyMetaClassGetter(paramAnnotatedMethod)) {}
      }
      else
      {
        label60:
        localObject1 = mangleGetterName(paramAnnotatedMethod, paramString.substring(3));
      }
    }
  }
  
  public String okNameForIsGetter(AnnotatedMethod paramAnnotatedMethod, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString.startsWith("is"))
    {
      localObject1 = paramAnnotatedMethod.getRawType();
      if ((localObject1 == Boolean.class) || (localObject1 == Boolean.TYPE)) {
        break label40;
      }
    }
    label40:
    for (localObject1 = localObject2;; localObject1 = mangleGetterName(paramAnnotatedMethod, paramString.substring(2))) {
      return (String)localObject1;
    }
  }
  
  public String okNameForSetter(AnnotatedMethod paramAnnotatedMethod)
  {
    Object localObject2 = null;
    String str = paramAnnotatedMethod.getName();
    Object localObject1 = localObject2;
    if (str.startsWith("set"))
    {
      str = mangleSetterName(paramAnnotatedMethod, str.substring(3));
      if (str != null) {
        break label43;
      }
      localObject1 = localObject2;
    }
    for (;;)
    {
      return (String)localObject1;
      label43:
      if ("metaClass".equals(str))
      {
        localObject1 = localObject2;
        if (isGroovyMetaClassSetter(paramAnnotatedMethod)) {}
      }
      else
      {
        localObject1 = str;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\BasicBeanDescription.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */