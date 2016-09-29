package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ClassIntrospector.MixInResolver;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.map.util.ClassUtil;

public final class AnnotatedClass
  extends Annotated
{
  private static final AnnotationMap[] NO_ANNOTATION_MAPS = new AnnotationMap[0];
  protected final AnnotationIntrospector _annotationIntrospector;
  protected final Class<?> _class;
  protected AnnotationMap _classAnnotations;
  protected List<AnnotatedConstructor> _constructors;
  protected List<AnnotatedMethod> _creatorMethods;
  protected AnnotatedConstructor _defaultConstructor;
  protected List<AnnotatedField> _fields;
  protected List<AnnotatedField> _ignoredFields;
  protected List<AnnotatedMethod> _ignoredMethods;
  protected AnnotatedMethodMap _memberMethods;
  protected final ClassIntrospector.MixInResolver _mixInResolver;
  protected final Class<?> _primaryMixIn;
  protected final Collection<Class<?>> _superTypes;
  
  private AnnotatedClass(Class<?> paramClass, List<Class<?>> paramList, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    this._class = paramClass;
    this._superTypes = paramList;
    this._annotationIntrospector = paramAnnotationIntrospector;
    this._mixInResolver = paramMixInResolver;
    if (this._mixInResolver == null) {}
    for (paramClass = null;; paramClass = this._mixInResolver.findMixInClassFor(this._class))
    {
      this._primaryMixIn = paramClass;
      return;
    }
  }
  
  private AnnotationMap _emptyAnnotationMap()
  {
    return new AnnotationMap();
  }
  
  private AnnotationMap[] _emptyAnnotationMaps(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = NO_ANNOTATION_MAPS;
      return (AnnotationMap[])localObject;
    }
    AnnotationMap[] arrayOfAnnotationMap = new AnnotationMap[paramInt];
    for (int i = 0;; i++)
    {
      localObject = arrayOfAnnotationMap;
      if (i >= paramInt) {
        break;
      }
      arrayOfAnnotationMap[i] = _emptyAnnotationMap();
    }
  }
  
  private boolean _isIncludableField(Field paramField)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramField.isSynthetic()) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      int i = paramField.getModifiers();
      bool1 = bool2;
      if (!Modifier.isStatic(i))
      {
        bool1 = bool2;
        if (!Modifier.isTransient(i)) {
          bool1 = true;
        }
      }
    }
  }
  
  public static AnnotatedClass construct(Class<?> paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    paramClass = new AnnotatedClass(paramClass, ClassUtil.findSuperTypes(paramClass, null), paramAnnotationIntrospector, paramMixInResolver);
    paramClass.resolveClassAnnotations();
    return paramClass;
  }
  
  public static AnnotatedClass constructWithoutSuperTypes(Class<?> paramClass, AnnotationIntrospector paramAnnotationIntrospector, ClassIntrospector.MixInResolver paramMixInResolver)
  {
    paramClass = new AnnotatedClass(paramClass, Collections.emptyList(), paramAnnotationIntrospector, paramMixInResolver);
    paramClass.resolveClassAnnotations();
    return paramClass;
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class<?> paramClass)
  {
    if (this._mixInResolver != null) {
      _addClassMixIns(paramAnnotationMap, paramClass, this._mixInResolver.findMixInClassFor(paramClass));
    }
  }
  
  protected void _addClassMixIns(AnnotationMap paramAnnotationMap, Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2 == null) {
      return;
    }
    for (Annotation localAnnotation : paramClass2.getDeclaredAnnotations()) {
      if (this._annotationIntrospector.isHandled(localAnnotation)) {
        paramAnnotationMap.addIfNotPresent(localAnnotation);
      }
    }
    ??? = ClassUtil.findSuperTypes(paramClass2, paramClass1).iterator();
    while (((Iterator)???).hasNext()) {
      for (paramClass2 : ((Class)((Iterator)???).next()).getDeclaredAnnotations()) {
        if (this._annotationIntrospector.isHandled(paramClass2)) {
          paramAnnotationMap.addIfNotPresent(paramClass2);
        }
      }
    }
  }
  
  protected void _addConstructorMixIns(Class<?> paramClass)
  {
    Object localObject1 = null;
    if (this._constructors == null) {}
    int j;
    Constructor localConstructor;
    int k;
    for (int i = 0;; i = this._constructors.size())
    {
      Constructor[] arrayOfConstructor = paramClass.getDeclaredConstructors();
      int m = arrayOfConstructor.length;
      j = 0;
      if (j >= m) {
        return;
      }
      localConstructor = arrayOfConstructor[j];
      switch (localConstructor.getParameterTypes().length)
      {
      default: 
        paramClass = (Class<?>)localObject1;
        if (localObject1 != null) {
          break label170;
        }
        localObject1 = new MemberKey[i];
        for (k = 0;; k++)
        {
          paramClass = (Class<?>)localObject1;
          if (k >= i) {
            break;
          }
          localObject1[k] = new MemberKey(((AnnotatedConstructor)this._constructors.get(k)).getAnnotated());
        }
      }
    }
    Object localObject2 = localObject1;
    if (this._defaultConstructor != null)
    {
      _addMixOvers(localConstructor, this._defaultConstructor, false);
      localObject2 = localObject1;
    }
    for (;;)
    {
      j++;
      localObject1 = localObject2;
      break;
      label170:
      localObject1 = new MemberKey(localConstructor);
      for (k = 0;; k++)
      {
        localObject2 = paramClass;
        if (k >= i) {
          break;
        }
        if (((MemberKey)localObject1).equals(paramClass[k])) {
          break label211;
        }
      }
      label211:
      _addMixOvers(localConstructor, (AnnotatedConstructor)this._constructors.get(k), true);
      localObject2 = paramClass;
    }
  }
  
  protected void _addFactoryMixIns(Class<?> paramClass)
  {
    Object localObject1 = null;
    int k = this._creatorMethods.size();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int m = arrayOfMethod.length;
    int i = 0;
    if (i < m)
    {
      Method localMethod = arrayOfMethod[i];
      Object localObject2;
      if (!Modifier.isStatic(localMethod.getModifiers())) {
        localObject2 = localObject1;
      }
      for (;;)
      {
        i++;
        localObject1 = localObject2;
        break;
        localObject2 = localObject1;
        if (localMethod.getParameterTypes().length != 0)
        {
          paramClass = (Class<?>)localObject1;
          if (localObject1 == null)
          {
            localObject1 = new MemberKey[k];
            for (j = 0;; j++)
            {
              paramClass = (Class<?>)localObject1;
              if (j >= k) {
                break;
              }
              localObject1[j] = new MemberKey(((AnnotatedMethod)this._creatorMethods.get(j)).getAnnotated());
            }
          }
          localObject1 = new MemberKey(localMethod);
          for (int j = 0;; j++)
          {
            localObject2 = paramClass;
            if (j >= k) {
              break;
            }
            if (((MemberKey)localObject1).equals(paramClass[j])) {
              break label175;
            }
          }
          label175:
          _addMixOvers(localMethod, (AnnotatedMethod)this._creatorMethods.get(j), true);
          localObject2 = paramClass;
        }
      }
    }
  }
  
  protected void _addFieldMixIns(Class<?> paramClass, Map<String, AnnotatedField> paramMap)
  {
    paramClass = paramClass.getDeclaredFields();
    int k = paramClass.length;
    int i = 0;
    if (i < k)
    {
      Field localField = paramClass[i];
      if (!_isIncludableField(localField)) {}
      for (;;)
      {
        i++;
        break;
        AnnotatedField localAnnotatedField = (AnnotatedField)paramMap.get(localField.getName());
        if (localAnnotatedField != null) {
          for (localField : localField.getDeclaredAnnotations()) {
            if (this._annotationIntrospector.isHandled(localField)) {
              localAnnotatedField.addOrOverride(localField);
            }
          }
        }
      }
    }
  }
  
  protected void _addFields(Map<String, AnnotatedField> paramMap, Class<?> paramClass)
  {
    Object localObject = paramClass.getSuperclass();
    if (localObject != null)
    {
      _addFields(paramMap, (Class)localObject);
      localObject = paramClass.getDeclaredFields();
      int j = localObject.length;
      int i = 0;
      if (i < j)
      {
        Field localField = localObject[i];
        if (!_isIncludableField(localField)) {}
        for (;;)
        {
          i++;
          break;
          paramMap.put(localField.getName(), _constructField(localField));
        }
      }
      if (this._mixInResolver != null)
      {
        paramClass = this._mixInResolver.findMixInClassFor(paramClass);
        if (paramClass != null) {
          _addFieldMixIns(paramClass, paramMap);
        }
      }
    }
  }
  
  protected void _addMemberMethods(Class<?> paramClass1, MethodFilter paramMethodFilter, AnnotatedMethodMap paramAnnotatedMethodMap1, Class<?> paramClass2, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    if (paramClass2 != null) {
      _addMethodMixIns(paramMethodFilter, paramAnnotatedMethodMap1, paramClass2, paramAnnotatedMethodMap2);
    }
    if (paramClass1 == null) {
      return;
    }
    paramClass1 = paramClass1.getDeclaredMethods();
    int j = paramClass1.length;
    int i = 0;
    label32:
    if (i < j)
    {
      paramClass2 = paramClass1[i];
      if (_isIncludableMethod(paramClass2, paramMethodFilter)) {
        break label61;
      }
    }
    for (;;)
    {
      i++;
      break label32;
      break;
      label61:
      AnnotatedMethod localAnnotatedMethod = paramAnnotatedMethodMap1.find(paramClass2);
      if (localAnnotatedMethod == null)
      {
        localAnnotatedMethod = _constructMethod(paramClass2);
        paramAnnotatedMethodMap1.add(localAnnotatedMethod);
        paramClass2 = paramAnnotatedMethodMap2.remove(paramClass2);
        if (paramClass2 != null) {
          _addMixOvers(paramClass2.getAnnotated(), localAnnotatedMethod, false);
        }
      }
      else
      {
        _addMixUnders(paramClass2, localAnnotatedMethod);
        if ((localAnnotatedMethod.getDeclaringClass().isInterface()) && (!paramClass2.getDeclaringClass().isInterface())) {
          paramAnnotatedMethodMap1.add(localAnnotatedMethod.withMethod(paramClass2));
        }
      }
    }
  }
  
  protected void _addMethodMixIns(MethodFilter paramMethodFilter, AnnotatedMethodMap paramAnnotatedMethodMap1, Class<?> paramClass, AnnotatedMethodMap paramAnnotatedMethodMap2)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    if (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if (!_isIncludableMethod(localMethod, paramMethodFilter)) {}
      for (;;)
      {
        i++;
        break;
        paramClass = paramAnnotatedMethodMap1.find(localMethod);
        if (paramClass != null) {
          _addMixUnders(localMethod, paramClass);
        } else {
          paramAnnotatedMethodMap2.add(_constructMethod(localMethod));
        }
      }
    }
  }
  
  protected void _addMixOvers(Constructor<?> paramConstructor, AnnotatedConstructor paramAnnotatedConstructor, boolean paramBoolean)
  {
    Object localObject;
    for (localObject : paramConstructor.getDeclaredAnnotations()) {
      if (this._annotationIntrospector.isHandled((Annotation)localObject)) {
        paramAnnotatedConstructor.addOrOverride((Annotation)localObject);
      }
    }
    if (paramBoolean)
    {
      localObject = paramConstructor.getParameterAnnotations();
      ??? = 0;
      int k = localObject.length;
      while (??? < k)
      {
        paramConstructor = localObject[???];
        int m = paramConstructor.length;
        for (??? = 0; ??? < m; ???++) {
          paramAnnotatedConstructor.addOrOverrideParam(???, paramConstructor[???]);
        }
        ???++;
      }
    }
  }
  
  protected void _addMixOvers(Method paramMethod, AnnotatedMethod paramAnnotatedMethod, boolean paramBoolean)
  {
    Annotation localAnnotation;
    for (localAnnotation : paramMethod.getDeclaredAnnotations()) {
      if (this._annotationIntrospector.isHandled(localAnnotation)) {
        paramAnnotatedMethod.addOrOverride(localAnnotation);
      }
    }
    if (paramBoolean)
    {
      paramMethod = paramMethod.getParameterAnnotations();
      ??? = 0;
      int k = paramMethod.length;
      while (??? < k)
      {
        localAnnotation = paramMethod[???];
        int m = localAnnotation.length;
        for (??? = 0; ??? < m; ???++) {
          paramAnnotatedMethod.addOrOverrideParam(???, localAnnotation[???]);
        }
        ???++;
      }
    }
  }
  
  protected void _addMixUnders(Method paramMethod, AnnotatedMethod paramAnnotatedMethod)
  {
    for (paramMethod : paramMethod.getDeclaredAnnotations()) {
      if (this._annotationIntrospector.isHandled(paramMethod)) {
        paramAnnotatedMethod.addIfNotPresent(paramMethod);
      }
    }
  }
  
  protected AnnotationMap _collectRelevantAnnotations(Annotation[] paramArrayOfAnnotation)
  {
    AnnotationMap localAnnotationMap = new AnnotationMap();
    if (paramArrayOfAnnotation != null)
    {
      int j = paramArrayOfAnnotation.length;
      for (int i = 0; i < j; i++)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        if (this._annotationIntrospector.isHandled(localAnnotation)) {
          localAnnotationMap.add(localAnnotation);
        }
      }
    }
    return localAnnotationMap;
  }
  
  protected AnnotationMap[] _collectRelevantAnnotations(Annotation[][] paramArrayOfAnnotation)
  {
    int j = paramArrayOfAnnotation.length;
    AnnotationMap[] arrayOfAnnotationMap = new AnnotationMap[j];
    for (int i = 0; i < j; i++) {
      arrayOfAnnotationMap[i] = _collectRelevantAnnotations(paramArrayOfAnnotation[i]);
    }
    return arrayOfAnnotationMap;
  }
  
  protected AnnotatedConstructor _constructConstructor(Constructor<?> paramConstructor, boolean paramBoolean)
  {
    if (this._annotationIntrospector == null)
    {
      paramConstructor = new AnnotatedConstructor(paramConstructor, _emptyAnnotationMap(), _emptyAnnotationMaps(paramConstructor.getParameterTypes().length));
      return paramConstructor;
    }
    AnnotationMap localAnnotationMap = _collectRelevantAnnotations(paramConstructor.getDeclaredAnnotations());
    if (paramBoolean) {}
    for (AnnotationMap[] arrayOfAnnotationMap = null;; arrayOfAnnotationMap = _collectRelevantAnnotations(paramConstructor.getParameterAnnotations()))
    {
      paramConstructor = new AnnotatedConstructor(paramConstructor, localAnnotationMap, arrayOfAnnotationMap);
      break;
    }
  }
  
  protected AnnotatedMethod _constructCreatorMethod(Method paramMethod)
  {
    if (this._annotationIntrospector == null) {}
    for (paramMethod = new AnnotatedMethod(paramMethod, _emptyAnnotationMap(), _emptyAnnotationMaps(paramMethod.getParameterTypes().length));; paramMethod = new AnnotatedMethod(paramMethod, _collectRelevantAnnotations(paramMethod.getDeclaredAnnotations()), _collectRelevantAnnotations(paramMethod.getParameterAnnotations()))) {
      return paramMethod;
    }
  }
  
  protected AnnotatedField _constructField(Field paramField)
  {
    if (this._annotationIntrospector == null) {}
    for (paramField = new AnnotatedField(paramField, _emptyAnnotationMap());; paramField = new AnnotatedField(paramField, _collectRelevantAnnotations(paramField.getDeclaredAnnotations()))) {
      return paramField;
    }
  }
  
  protected AnnotatedMethod _constructMethod(Method paramMethod)
  {
    if (this._annotationIntrospector == null) {}
    for (paramMethod = new AnnotatedMethod(paramMethod, _emptyAnnotationMap(), null);; paramMethod = new AnnotatedMethod(paramMethod, _collectRelevantAnnotations(paramMethod.getDeclaredAnnotations()), null)) {
      return paramMethod;
    }
  }
  
  protected boolean _isIncludableMethod(Method paramMethod, MethodFilter paramMethodFilter)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramMethodFilter != null) && (!paramMethodFilter.includeMethod(paramMethod))) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!paramMethod.isSynthetic())
      {
        bool1 = bool2;
        if (!paramMethod.isBridge()) {
          bool1 = true;
        }
      }
    }
  }
  
  public Iterable<AnnotatedField> fields()
  {
    if (this._fields == null) {}
    for (List localList = Collections.emptyList();; localList = this._fields) {
      return localList;
    }
  }
  
  public AnnotatedMethod findMethod(String paramString, Class<?>[] paramArrayOfClass)
  {
    return this._memberMethods.find(paramString, paramArrayOfClass);
  }
  
  public Class<?> getAnnotated()
  {
    return this._class;
  }
  
  public <A extends Annotation> A getAnnotation(Class<A> paramClass)
  {
    if (this._classAnnotations == null) {}
    for (paramClass = null;; paramClass = this._classAnnotations.get(paramClass)) {
      return paramClass;
    }
  }
  
  public Annotations getAnnotations()
  {
    return this._classAnnotations;
  }
  
  public List<AnnotatedConstructor> getConstructors()
  {
    if (this._constructors == null) {}
    for (List localList = Collections.emptyList();; localList = this._constructors) {
      return localList;
    }
  }
  
  public AnnotatedConstructor getDefaultConstructor()
  {
    return this._defaultConstructor;
  }
  
  public int getFieldCount()
  {
    if (this._fields == null) {}
    for (int i = 0;; i = this._fields.size()) {
      return i;
    }
  }
  
  public Type getGenericType()
  {
    return this._class;
  }
  
  public int getMemberMethodCount()
  {
    return this._memberMethods.size();
  }
  
  public int getModifiers()
  {
    return this._class.getModifiers();
  }
  
  public String getName()
  {
    return this._class.getName();
  }
  
  public Class<?> getRawType()
  {
    return this._class;
  }
  
  public List<AnnotatedMethod> getStaticMethods()
  {
    if (this._creatorMethods == null) {}
    for (List localList = Collections.emptyList();; localList = this._creatorMethods) {
      return localList;
    }
  }
  
  public boolean hasAnnotations()
  {
    if (this._classAnnotations.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Iterable<AnnotatedField> ignoredFields()
  {
    if (this._ignoredFields == null) {}
    for (List localList = Collections.emptyList();; localList = this._ignoredFields) {
      return localList;
    }
  }
  
  public Iterable<AnnotatedMethod> ignoredMemberMethods()
  {
    if (this._ignoredMethods == null) {}
    for (List localList = Collections.emptyList();; localList = this._ignoredMethods) {
      return localList;
    }
  }
  
  public Iterable<AnnotatedMethod> memberMethods()
  {
    return this._memberMethods;
  }
  
  protected void resolveClassAnnotations()
  {
    this._classAnnotations = new AnnotationMap();
    if (this._primaryMixIn != null) {
      _addClassMixIns(this._classAnnotations, this._class, this._primaryMixIn);
    }
    Object localObject2;
    for (localObject2 : this._class.getDeclaredAnnotations()) {
      if (this._annotationIntrospector.isHandled((Annotation)localObject2)) {
        this._classAnnotations.addIfNotPresent((Annotation)localObject2);
      }
    }
    ??? = this._superTypes.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject2 = (Class)((Iterator)???).next();
      _addClassMixIns(this._classAnnotations, (Class)localObject2);
      for (Annotation localAnnotation : ((Class)localObject2).getDeclaredAnnotations()) {
        if (this._annotationIntrospector.isHandled(localAnnotation)) {
          this._classAnnotations.addIfNotPresent(localAnnotation);
        }
      }
    }
    _addClassMixIns(this._classAnnotations, Object.class);
  }
  
  public void resolveCreators(boolean paramBoolean)
  {
    this._constructors = null;
    Object localObject = this._class.getDeclaredConstructors();
    int j = localObject.length;
    int i = 0;
    Constructor localConstructor;
    if (i < j)
    {
      localConstructor = localObject[i];
      switch (localConstructor.getParameterTypes().length)
      {
      default: 
        if (paramBoolean)
        {
          if (this._constructors == null) {
            this._constructors = new ArrayList();
          }
          this._constructors.add(_constructConstructor(localConstructor, false));
        }
        break;
      }
      for (;;)
      {
        i++;
        break;
        this._defaultConstructor = _constructConstructor(localConstructor, true);
      }
    }
    if ((this._primaryMixIn != null) && ((this._defaultConstructor != null) || (this._constructors != null))) {
      _addConstructorMixIns(this._primaryMixIn);
    }
    if (this._annotationIntrospector != null)
    {
      if ((this._defaultConstructor != null) && (this._annotationIntrospector.isIgnorableConstructor(this._defaultConstructor))) {
        this._defaultConstructor = null;
      }
      if (this._constructors != null)
      {
        i = this._constructors.size();
        for (;;)
        {
          j = i - 1;
          if (j < 0) {
            break;
          }
          i = j;
          if (this._annotationIntrospector.isIgnorableConstructor((AnnotatedConstructor)this._constructors.get(j)))
          {
            this._constructors.remove(j);
            i = j;
          }
        }
      }
    }
    this._creatorMethods = null;
    if (paramBoolean)
    {
      localObject = this._class.getDeclaredMethods();
      j = localObject.length;
      i = 0;
      if (i < j)
      {
        localConstructor = localObject[i];
        if (!Modifier.isStatic(localConstructor.getModifiers())) {}
        for (;;)
        {
          i++;
          break;
          if (localConstructor.getParameterTypes().length >= 1)
          {
            if (this._creatorMethods == null) {
              this._creatorMethods = new ArrayList();
            }
            this._creatorMethods.add(_constructCreatorMethod(localConstructor));
          }
        }
      }
      if ((this._primaryMixIn != null) && (this._creatorMethods != null)) {
        _addFactoryMixIns(this._primaryMixIn);
      }
      if ((this._annotationIntrospector != null) && (this._creatorMethods != null))
      {
        i = this._creatorMethods.size();
        for (;;)
        {
          j = i - 1;
          if (j < 0) {
            break;
          }
          i = j;
          if (this._annotationIntrospector.isIgnorableMethod((AnnotatedMethod)this._creatorMethods.get(j)))
          {
            this._creatorMethods.remove(j);
            i = j;
          }
        }
      }
    }
  }
  
  public void resolveFields(boolean paramBoolean)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    _addFields(localLinkedHashMap, this._class);
    if (this._annotationIntrospector != null)
    {
      Iterator localIterator = localLinkedHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        AnnotatedField localAnnotatedField = (AnnotatedField)((Map.Entry)localIterator.next()).getValue();
        if (this._annotationIntrospector.isIgnorableField(localAnnotatedField))
        {
          localIterator.remove();
          if (paramBoolean) {
            this._ignoredFields = ArrayBuilders.addToList(this._ignoredFields, localAnnotatedField);
          }
        }
      }
    }
    if (localLinkedHashMap.isEmpty()) {
      this._fields = Collections.emptyList();
    }
    for (;;)
    {
      return;
      this._fields = new ArrayList(localLinkedHashMap.size());
      this._fields.addAll(localLinkedHashMap.values());
    }
  }
  
  public void resolveMemberMethods(MethodFilter paramMethodFilter, boolean paramBoolean)
  {
    this._memberMethods = new AnnotatedMethodMap();
    Object localObject2 = new AnnotatedMethodMap();
    _addMemberMethods(this._class, paramMethodFilter, this._memberMethods, this._primaryMixIn, (AnnotatedMethodMap)localObject2);
    Iterator localIterator2 = this._superTypes.iterator();
    Object localObject1;
    if (localIterator2.hasNext())
    {
      Class localClass = (Class)localIterator2.next();
      if (this._mixInResolver == null) {}
      for (localObject1 = null;; localObject1 = this._mixInResolver.findMixInClassFor(localClass))
      {
        _addMemberMethods(localClass, paramMethodFilter, this._memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
        break;
      }
    }
    if (this._mixInResolver != null)
    {
      localObject1 = this._mixInResolver.findMixInClassFor(Object.class);
      if (localObject1 != null) {
        _addMethodMixIns(paramMethodFilter, this._memberMethods, (Class)localObject1, (AnnotatedMethodMap)localObject2);
      }
    }
    if (this._annotationIntrospector != null)
    {
      if (!((AnnotatedMethodMap)localObject2).isEmpty())
      {
        paramMethodFilter = ((AnnotatedMethodMap)localObject2).iterator();
        while (paramMethodFilter.hasNext())
        {
          localObject1 = (AnnotatedMethod)paramMethodFilter.next();
          try
          {
            localObject2 = Object.class.getDeclaredMethod(((AnnotatedMethod)localObject1).getName(), ((AnnotatedMethod)localObject1).getParameterClasses());
            if (localObject2 != null)
            {
              localObject2 = _constructMethod((Method)localObject2);
              _addMixOvers(((AnnotatedMethod)localObject1).getAnnotated(), (AnnotatedMethod)localObject2, false);
              this._memberMethods.add((AnnotatedMethod)localObject2);
            }
          }
          catch (Exception localException) {}
        }
      }
      Iterator localIterator1 = this._memberMethods.iterator();
      while (localIterator1.hasNext())
      {
        paramMethodFilter = (AnnotatedMethod)localIterator1.next();
        if (this._annotationIntrospector.isIgnorableMethod(paramMethodFilter))
        {
          localIterator1.remove();
          if (paramBoolean) {
            this._ignoredMethods = ArrayBuilders.addToList(this._ignoredMethods, paramMethodFilter);
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "[AnnotedClass " + this._class.getName() + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\introspect\AnnotatedClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */