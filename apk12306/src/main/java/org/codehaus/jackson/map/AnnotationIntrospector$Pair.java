package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.annotate.JsonSerialize.Typing;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.AnnotatedConstructor;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.AnnotatedParameter;
import org.codehaus.jackson.map.introspect.VisibilityChecker;
import org.codehaus.jackson.map.jsontype.NamedType;
import org.codehaus.jackson.map.jsontype.TypeResolverBuilder;
import org.codehaus.jackson.type.JavaType;

public class AnnotationIntrospector$Pair
  extends AnnotationIntrospector
{
  protected final AnnotationIntrospector _primary;
  protected final AnnotationIntrospector _secondary;
  
  public AnnotationIntrospector$Pair(AnnotationIntrospector paramAnnotationIntrospector1, AnnotationIntrospector paramAnnotationIntrospector2)
  {
    this._primary = paramAnnotationIntrospector1;
    this._secondary = paramAnnotationIntrospector2;
  }
  
  public static AnnotationIntrospector create(AnnotationIntrospector paramAnnotationIntrospector1, AnnotationIntrospector paramAnnotationIntrospector2)
  {
    if (paramAnnotationIntrospector1 == null) {}
    for (;;)
    {
      return paramAnnotationIntrospector2;
      if (paramAnnotationIntrospector2 == null) {
        paramAnnotationIntrospector2 = paramAnnotationIntrospector1;
      } else {
        paramAnnotationIntrospector2 = new Pair(paramAnnotationIntrospector1, paramAnnotationIntrospector2);
      }
    }
  }
  
  public Collection<AnnotationIntrospector> allIntrospectors()
  {
    return allIntrospectors(new ArrayList());
  }
  
  public Collection<AnnotationIntrospector> allIntrospectors(Collection<AnnotationIntrospector> paramCollection)
  {
    this._primary.allIntrospectors(paramCollection);
    this._secondary.allIntrospectors(paramCollection);
    return paramCollection;
  }
  
  public VisibilityChecker<?> findAutoDetectVisibility(AnnotatedClass paramAnnotatedClass, VisibilityChecker<?> paramVisibilityChecker)
  {
    paramVisibilityChecker = this._secondary.findAutoDetectVisibility(paramAnnotatedClass, paramVisibilityChecker);
    return this._primary.findAutoDetectVisibility(paramAnnotatedClass, paramVisibilityChecker);
  }
  
  public Boolean findCachability(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.findCachability(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.findCachability(paramAnnotatedClass);
    }
    return localBoolean1;
  }
  
  public Class<? extends JsonDeserializer<?>> findContentDeserializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findContentDeserializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonDeserializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findContentDeserializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public Class<? extends JsonSerializer<?>> findContentSerializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findContentSerializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonSerializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findContentSerializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public String findDeserializablePropertyName(AnnotatedField paramAnnotatedField)
  {
    String str = this._primary.findDeserializablePropertyName(paramAnnotatedField);
    Object localObject;
    if (str == null) {
      localObject = this._secondary.findDeserializablePropertyName(paramAnnotatedField);
    }
    for (;;)
    {
      return (String)localObject;
      localObject = str;
      if (str.length() == 0)
      {
        paramAnnotatedField = this._secondary.findDeserializablePropertyName(paramAnnotatedField);
        localObject = str;
        if (paramAnnotatedField != null) {
          localObject = paramAnnotatedField;
        }
      }
    }
  }
  
  public Class<?> findDeserializationContentType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    Class localClass2 = this._primary.findDeserializationContentType(paramAnnotated, paramJavaType, paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findDeserializationContentType(paramAnnotated, paramJavaType, paramString);
    }
    return localClass1;
  }
  
  public Class<?> findDeserializationKeyType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    Class localClass2 = this._primary.findDeserializationKeyType(paramAnnotated, paramJavaType, paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findDeserializationKeyType(paramAnnotated, paramJavaType, paramString);
    }
    return localClass1;
  }
  
  public Class<?> findDeserializationType(Annotated paramAnnotated, JavaType paramJavaType, String paramString)
  {
    Class localClass2 = this._primary.findDeserializationType(paramAnnotated, paramJavaType, paramString);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findDeserializationType(paramAnnotated, paramJavaType, paramString);
    }
    return localClass1;
  }
  
  public Object findDeserializer(Annotated paramAnnotated)
  {
    Object localObject2 = this._primary.findDeserializer(paramAnnotated);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findDeserializer(paramAnnotated);
    }
    return localObject1;
  }
  
  public Object findDeserializer(Annotated paramAnnotated, BeanProperty paramBeanProperty)
  {
    Object localObject2 = this._primary.findDeserializer(paramAnnotated, paramBeanProperty);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findDeserializer(paramAnnotated, paramBeanProperty);
    }
    return localObject1;
  }
  
  public String findEnumValue(Enum<?> paramEnum)
  {
    String str2 = this._primary.findEnumValue(paramEnum);
    String str1 = str2;
    if (str2 == null) {
      str1 = this._secondary.findEnumValue(paramEnum);
    }
    return str1;
  }
  
  public Object findFilterId(AnnotatedClass paramAnnotatedClass)
  {
    Object localObject2 = this._primary.findFilterId(paramAnnotatedClass);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findFilterId(paramAnnotatedClass);
    }
    return localObject1;
  }
  
  public String findGettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    String str = this._primary.findGettablePropertyName(paramAnnotatedMethod);
    Object localObject;
    if (str == null) {
      localObject = this._secondary.findGettablePropertyName(paramAnnotatedMethod);
    }
    for (;;)
    {
      return (String)localObject;
      localObject = str;
      if (str.length() == 0)
      {
        paramAnnotatedMethod = this._secondary.findGettablePropertyName(paramAnnotatedMethod);
        localObject = str;
        if (paramAnnotatedMethod != null) {
          localObject = paramAnnotatedMethod;
        }
      }
    }
  }
  
  public Boolean findIgnoreUnknownProperties(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.findIgnoreUnknownProperties(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.findIgnoreUnknownProperties(paramAnnotatedClass);
    }
    return localBoolean1;
  }
  
  public Class<? extends KeyDeserializer> findKeyDeserializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findKeyDeserializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != KeyDeserializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findKeyDeserializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public Class<? extends JsonSerializer<?>> findKeySerializer(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findKeySerializer(paramAnnotated);
    Class localClass1;
    if (localClass2 != null)
    {
      localClass1 = localClass2;
      if (localClass2 != JsonSerializer.None.class) {}
    }
    else
    {
      localClass1 = this._secondary.findKeySerializer(paramAnnotated);
    }
    return localClass1;
  }
  
  public String[] findPropertiesToIgnore(AnnotatedClass paramAnnotatedClass)
  {
    String[] arrayOfString2 = this._primary.findPropertiesToIgnore(paramAnnotatedClass);
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null) {
      arrayOfString1 = this._secondary.findPropertiesToIgnore(paramAnnotatedClass);
    }
    return arrayOfString1;
  }
  
  public TypeResolverBuilder<?> findPropertyContentTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    TypeResolverBuilder localTypeResolverBuilder2 = this._primary.findPropertyContentTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    TypeResolverBuilder localTypeResolverBuilder1 = localTypeResolverBuilder2;
    if (localTypeResolverBuilder2 == null) {
      localTypeResolverBuilder1 = this._secondary.findPropertyContentTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    }
    return localTypeResolverBuilder1;
  }
  
  public String findPropertyNameForParam(AnnotatedParameter paramAnnotatedParameter)
  {
    String str2 = this._primary.findPropertyNameForParam(paramAnnotatedParameter);
    String str1 = str2;
    if (str2 == null) {
      str1 = this._secondary.findPropertyNameForParam(paramAnnotatedParameter);
    }
    return str1;
  }
  
  public TypeResolverBuilder<?> findPropertyTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedMember paramAnnotatedMember, JavaType paramJavaType)
  {
    TypeResolverBuilder localTypeResolverBuilder2 = this._primary.findPropertyTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    TypeResolverBuilder localTypeResolverBuilder1 = localTypeResolverBuilder2;
    if (localTypeResolverBuilder2 == null) {
      localTypeResolverBuilder1 = this._secondary.findPropertyTypeResolver(paramMapperConfig, paramAnnotatedMember, paramJavaType);
    }
    return localTypeResolverBuilder1;
  }
  
  public AnnotationIntrospector.ReferenceProperty findReferenceType(AnnotatedMember paramAnnotatedMember)
  {
    AnnotationIntrospector.ReferenceProperty localReferenceProperty2 = this._primary.findReferenceType(paramAnnotatedMember);
    AnnotationIntrospector.ReferenceProperty localReferenceProperty1 = localReferenceProperty2;
    if (localReferenceProperty2 == null) {
      localReferenceProperty1 = this._secondary.findReferenceType(paramAnnotatedMember);
    }
    return localReferenceProperty1;
  }
  
  public String findRootName(AnnotatedClass paramAnnotatedClass)
  {
    String str = this._primary.findRootName(paramAnnotatedClass);
    Object localObject;
    if (str == null) {
      localObject = this._secondary.findRootName(paramAnnotatedClass);
    }
    for (;;)
    {
      return (String)localObject;
      localObject = str;
      if (str.length() <= 0)
      {
        paramAnnotatedClass = this._secondary.findRootName(paramAnnotatedClass);
        localObject = str;
        if (paramAnnotatedClass != null) {
          localObject = paramAnnotatedClass;
        }
      }
    }
  }
  
  public String findSerializablePropertyName(AnnotatedField paramAnnotatedField)
  {
    String str = this._primary.findSerializablePropertyName(paramAnnotatedField);
    Object localObject;
    if (str == null) {
      localObject = this._secondary.findSerializablePropertyName(paramAnnotatedField);
    }
    for (;;)
    {
      return (String)localObject;
      localObject = str;
      if (str.length() == 0)
      {
        paramAnnotatedField = this._secondary.findSerializablePropertyName(paramAnnotatedField);
        localObject = str;
        if (paramAnnotatedField != null) {
          localObject = paramAnnotatedField;
        }
      }
    }
  }
  
  public Class<?> findSerializationContentType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    Class localClass2 = this._primary.findSerializationContentType(paramAnnotated, paramJavaType);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findSerializationContentType(paramAnnotated, paramJavaType);
    }
    return localClass1;
  }
  
  public JsonSerialize.Inclusion findSerializationInclusion(Annotated paramAnnotated, JsonSerialize.Inclusion paramInclusion)
  {
    paramInclusion = this._secondary.findSerializationInclusion(paramAnnotated, paramInclusion);
    return this._primary.findSerializationInclusion(paramAnnotated, paramInclusion);
  }
  
  public Class<?> findSerializationKeyType(Annotated paramAnnotated, JavaType paramJavaType)
  {
    Class localClass2 = this._primary.findSerializationKeyType(paramAnnotated, paramJavaType);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findSerializationKeyType(paramAnnotated, paramJavaType);
    }
    return localClass1;
  }
  
  public String[] findSerializationPropertyOrder(AnnotatedClass paramAnnotatedClass)
  {
    String[] arrayOfString2 = this._primary.findSerializationPropertyOrder(paramAnnotatedClass);
    String[] arrayOfString1 = arrayOfString2;
    if (arrayOfString2 == null) {
      arrayOfString1 = this._secondary.findSerializationPropertyOrder(paramAnnotatedClass);
    }
    return arrayOfString1;
  }
  
  public Boolean findSerializationSortAlphabetically(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.findSerializationSortAlphabetically(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.findSerializationSortAlphabetically(paramAnnotatedClass);
    }
    return localBoolean1;
  }
  
  public Class<?> findSerializationType(Annotated paramAnnotated)
  {
    Class localClass2 = this._primary.findSerializationType(paramAnnotated);
    Class localClass1 = localClass2;
    if (localClass2 == null) {
      localClass1 = this._secondary.findSerializationType(paramAnnotated);
    }
    return localClass1;
  }
  
  public JsonSerialize.Typing findSerializationTyping(Annotated paramAnnotated)
  {
    JsonSerialize.Typing localTyping2 = this._primary.findSerializationTyping(paramAnnotated);
    JsonSerialize.Typing localTyping1 = localTyping2;
    if (localTyping2 == null) {
      localTyping1 = this._secondary.findSerializationTyping(paramAnnotated);
    }
    return localTyping1;
  }
  
  public Class<?>[] findSerializationViews(Annotated paramAnnotated)
  {
    Class[] arrayOfClass2 = this._primary.findSerializationViews(paramAnnotated);
    Class[] arrayOfClass1 = arrayOfClass2;
    if (arrayOfClass2 == null) {
      arrayOfClass1 = this._secondary.findSerializationViews(paramAnnotated);
    }
    return arrayOfClass1;
  }
  
  public Object findSerializer(Annotated paramAnnotated)
  {
    Object localObject2 = this._primary.findSerializer(paramAnnotated);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findSerializer(paramAnnotated);
    }
    return localObject1;
  }
  
  public Object findSerializer(Annotated paramAnnotated, BeanProperty paramBeanProperty)
  {
    Object localObject2 = this._primary.findSerializer(paramAnnotated, paramBeanProperty);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this._secondary.findSerializer(paramAnnotated, paramBeanProperty);
    }
    return localObject1;
  }
  
  public String findSettablePropertyName(AnnotatedMethod paramAnnotatedMethod)
  {
    String str = this._primary.findSettablePropertyName(paramAnnotatedMethod);
    Object localObject;
    if (str == null) {
      localObject = this._secondary.findSettablePropertyName(paramAnnotatedMethod);
    }
    for (;;)
    {
      return (String)localObject;
      localObject = str;
      if (str.length() == 0)
      {
        paramAnnotatedMethod = this._secondary.findSettablePropertyName(paramAnnotatedMethod);
        localObject = str;
        if (paramAnnotatedMethod != null) {
          localObject = paramAnnotatedMethod;
        }
      }
    }
  }
  
  public List<NamedType> findSubtypes(Annotated paramAnnotated)
  {
    List localList1 = this._primary.findSubtypes(paramAnnotated);
    List localList2 = this._secondary.findSubtypes(paramAnnotated);
    if ((localList1 == null) || (localList1.isEmpty())) {
      paramAnnotated = localList2;
    }
    for (;;)
    {
      return paramAnnotated;
      if ((localList2 == null) || (localList2.isEmpty()))
      {
        paramAnnotated = localList1;
      }
      else
      {
        paramAnnotated = new ArrayList(localList1.size() + localList2.size());
        paramAnnotated.addAll(localList1);
        paramAnnotated.addAll(localList2);
      }
    }
  }
  
  public String findTypeName(AnnotatedClass paramAnnotatedClass)
  {
    String str2 = this._primary.findTypeName(paramAnnotatedClass);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (str2.length() != 0) {}
    }
    else
    {
      str1 = this._secondary.findTypeName(paramAnnotatedClass);
    }
    return str1;
  }
  
  public TypeResolverBuilder<?> findTypeResolver(MapperConfig<?> paramMapperConfig, AnnotatedClass paramAnnotatedClass, JavaType paramJavaType)
  {
    TypeResolverBuilder localTypeResolverBuilder2 = this._primary.findTypeResolver(paramMapperConfig, paramAnnotatedClass, paramJavaType);
    TypeResolverBuilder localTypeResolverBuilder1 = localTypeResolverBuilder2;
    if (localTypeResolverBuilder2 == null) {
      localTypeResolverBuilder1 = this._secondary.findTypeResolver(paramMapperConfig, paramAnnotatedClass, paramJavaType);
    }
    return localTypeResolverBuilder1;
  }
  
  public boolean hasAnyGetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    if ((this._primary.hasAnyGetterAnnotation(paramAnnotatedMethod)) || (this._secondary.hasAnyGetterAnnotation(paramAnnotatedMethod))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasAnySetterAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    if ((this._primary.hasAnySetterAnnotation(paramAnnotatedMethod)) || (this._secondary.hasAnySetterAnnotation(paramAnnotatedMethod))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasAsValueAnnotation(AnnotatedMethod paramAnnotatedMethod)
  {
    if ((this._primary.hasAsValueAnnotation(paramAnnotatedMethod)) || (this._secondary.hasAsValueAnnotation(paramAnnotatedMethod))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean hasCreatorAnnotation(Annotated paramAnnotated)
  {
    if ((this._primary.hasCreatorAnnotation(paramAnnotated)) || (this._secondary.hasCreatorAnnotation(paramAnnotated))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isHandled(Annotation paramAnnotation)
  {
    if ((this._primary.isHandled(paramAnnotation)) || (this._secondary.isHandled(paramAnnotation))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isIgnorableConstructor(AnnotatedConstructor paramAnnotatedConstructor)
  {
    if ((this._primary.isIgnorableConstructor(paramAnnotatedConstructor)) || (this._secondary.isIgnorableConstructor(paramAnnotatedConstructor))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isIgnorableField(AnnotatedField paramAnnotatedField)
  {
    if ((this._primary.isIgnorableField(paramAnnotatedField)) || (this._secondary.isIgnorableField(paramAnnotatedField))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean isIgnorableMethod(AnnotatedMethod paramAnnotatedMethod)
  {
    if ((this._primary.isIgnorableMethod(paramAnnotatedMethod)) || (this._secondary.isIgnorableMethod(paramAnnotatedMethod))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public Boolean isIgnorableType(AnnotatedClass paramAnnotatedClass)
  {
    Boolean localBoolean2 = this._primary.isIgnorableType(paramAnnotatedClass);
    Boolean localBoolean1 = localBoolean2;
    if (localBoolean2 == null) {
      localBoolean1 = this._secondary.isIgnorableType(paramAnnotatedClass);
    }
    return localBoolean1;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\AnnotationIntrospector$Pair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */