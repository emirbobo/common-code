package org.codehaus.jackson.map.type;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.util.ArrayBuilders;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

public final class TypeFactory
{
  private static final JavaType[] NO_TYPES = new JavaType[0];
  @Deprecated
  public static final TypeFactory instance = new TypeFactory();
  protected final TypeModifier[] _modifiers;
  protected final TypeParser _parser;
  
  private TypeFactory()
  {
    this._parser = new TypeParser(this);
    this._modifiers = null;
  }
  
  protected TypeFactory(TypeParser paramTypeParser, TypeModifier[] paramArrayOfTypeModifier)
  {
    this._parser = paramTypeParser;
    this._modifiers = paramArrayOfTypeModifier;
  }
  
  private JavaType _collectionType(Class<?> paramClass)
  {
    JavaType[] arrayOfJavaType = findTypeParameters(paramClass, Collection.class);
    if (arrayOfJavaType == null) {}
    for (paramClass = CollectionType.construct(paramClass, _unknownType());; paramClass = CollectionType.construct(paramClass, arrayOfJavaType[0]))
    {
      return paramClass;
      if (arrayOfJavaType.length != 1) {
        throw new IllegalArgumentException("Strange Collection type " + paramClass.getName() + ": can not determine type parameters");
      }
    }
  }
  
  protected static HierarchicType _findSuperClassChain(Type paramType, Class<?> paramClass)
  {
    paramType = new HierarchicType(paramType);
    Object localObject = paramType.getRawClass();
    if (localObject == paramClass) {}
    for (;;)
    {
      return paramType;
      localObject = ((Class)localObject).getGenericSuperclass();
      if (localObject != null)
      {
        paramClass = _findSuperClassChain((Type)localObject, paramClass);
        if (paramClass != null)
        {
          paramClass.setSubType(paramType);
          paramType.setSuperType(paramClass);
          continue;
        }
      }
      paramType = null;
    }
  }
  
  protected static HierarchicType _findSuperInterfaceChain(Type paramType, Class<?> paramClass)
  {
    paramType = new HierarchicType(paramType);
    Object localObject = paramType.getRawClass();
    if (localObject == paramClass) {}
    for (;;)
    {
      return paramType;
      Type[] arrayOfType = ((Class)localObject).getGenericInterfaces();
      if (arrayOfType != null)
      {
        int j = arrayOfType.length;
        for (int i = 0;; i++)
        {
          if (i >= j) {
            break label82;
          }
          HierarchicType localHierarchicType = _findSuperInterfaceChain(arrayOfType[i], paramClass);
          if (localHierarchicType != null)
          {
            localHierarchicType.setSubType(paramType);
            paramType.setSuperType(localHierarchicType);
            break;
          }
        }
      }
      label82:
      localObject = ((Class)localObject).getGenericSuperclass();
      if (localObject != null)
      {
        paramClass = _findSuperInterfaceChain((Type)localObject, paramClass);
        if (paramClass != null)
        {
          paramClass.setSubType(paramType);
          paramType.setSuperType(paramClass);
          continue;
        }
      }
      paramType = null;
    }
  }
  
  protected static HierarchicType _findSuperTypeChain(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (paramClass2.isInterface()) {}
    for (paramClass1 = _findSuperInterfaceChain(paramClass1, paramClass2);; paramClass1 = _findSuperClassChain(paramClass1, paramClass2)) {
      return paramClass1;
    }
  }
  
  private JavaType _mapType(Class<?> paramClass)
  {
    JavaType[] arrayOfJavaType = findTypeParameters(paramClass, Map.class);
    if (arrayOfJavaType == null) {}
    for (paramClass = MapType.construct(paramClass, _unknownType(), _unknownType());; paramClass = MapType.construct(paramClass, arrayOfJavaType[0], arrayOfJavaType[1]))
    {
      return paramClass;
      if (arrayOfJavaType.length != 2) {
        throw new IllegalArgumentException("Strange Map type " + paramClass.getName() + ": can not determine type parameters");
      }
    }
  }
  
  @Deprecated
  public static JavaType arrayType(Class<?> paramClass)
  {
    return instance.constructArrayType(instance.constructType(paramClass));
  }
  
  @Deprecated
  public static JavaType arrayType(JavaType paramJavaType)
  {
    return instance.constructArrayType(paramJavaType);
  }
  
  @Deprecated
  public static JavaType collectionType(Class<? extends Collection> paramClass, Class<?> paramClass1)
  {
    return instance.constructCollectionType(paramClass, instance.constructType(paramClass1));
  }
  
  @Deprecated
  public static JavaType collectionType(Class<? extends Collection> paramClass, JavaType paramJavaType)
  {
    return instance.constructCollectionType(paramClass, paramJavaType);
  }
  
  public static TypeFactory defaultInstance()
  {
    return instance;
  }
  
  @Deprecated
  public static JavaType fastSimpleType(Class<?> paramClass)
  {
    return instance.uncheckedSimpleType(paramClass);
  }
  
  @Deprecated
  public static JavaType[] findParameterTypes(Class<?> paramClass1, Class<?> paramClass2)
  {
    return instance.findTypeParameters(paramClass1, paramClass2);
  }
  
  @Deprecated
  public static JavaType[] findParameterTypes(Class<?> paramClass1, Class<?> paramClass2, TypeBindings paramTypeBindings)
  {
    return instance.findTypeParameters(paramClass1, paramClass2, paramTypeBindings);
  }
  
  @Deprecated
  public static JavaType[] findParameterTypes(JavaType paramJavaType, Class<?> paramClass)
  {
    return instance.findTypeParameters(paramJavaType, paramClass);
  }
  
  public static JavaType fromCanonical(String paramString)
    throws IllegalArgumentException
  {
    return instance.constructFromCanonical(paramString);
  }
  
  @Deprecated
  public static JavaType fromClass(Class<?> paramClass)
  {
    return instance._fromClass(paramClass, null);
  }
  
  @Deprecated
  public static JavaType fromType(Type paramType)
  {
    return instance._constructType(paramType, null);
  }
  
  @Deprecated
  public static JavaType fromTypeReference(TypeReference<?> paramTypeReference)
  {
    return type(paramTypeReference.getType());
  }
  
  @Deprecated
  public static JavaType mapType(Class<? extends Map> paramClass, Class<?> paramClass1, Class<?> paramClass2)
  {
    return instance.constructMapType(paramClass, type(paramClass1), instance.constructType(paramClass2));
  }
  
  @Deprecated
  public static JavaType mapType(Class<? extends Map> paramClass, JavaType paramJavaType1, JavaType paramJavaType2)
  {
    return instance.constructMapType(paramClass, paramJavaType1, paramJavaType2);
  }
  
  @Deprecated
  public static JavaType parametricType(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    return instance.constructParametricType(paramClass, paramVarArgs);
  }
  
  @Deprecated
  public static JavaType parametricType(Class<?> paramClass, JavaType... paramVarArgs)
  {
    return instance.constructParametricType(paramClass, paramVarArgs);
  }
  
  public static Class<?> rawClass(Type paramType)
  {
    if ((paramType instanceof Class)) {}
    for (paramType = (Class)paramType;; paramType = defaultInstance().constructType(paramType).getRawClass()) {
      return paramType;
    }
  }
  
  @Deprecated
  public static JavaType specialize(JavaType paramJavaType, Class<?> paramClass)
  {
    return instance.constructSpecializedType(paramJavaType, paramClass);
  }
  
  @Deprecated
  public static JavaType type(Type paramType)
  {
    return instance._constructType(paramType, null);
  }
  
  @Deprecated
  public static JavaType type(Type paramType, Class<?> paramClass)
  {
    return instance.constructType(paramType, paramClass);
  }
  
  @Deprecated
  public static JavaType type(Type paramType, TypeBindings paramTypeBindings)
  {
    return instance._constructType(paramType, paramTypeBindings);
  }
  
  @Deprecated
  public static JavaType type(Type paramType, JavaType paramJavaType)
  {
    return instance.constructType(paramType, paramJavaType);
  }
  
  @Deprecated
  public static JavaType type(TypeReference<?> paramTypeReference)
  {
    return instance.constructType(paramTypeReference.getType());
  }
  
  public static JavaType unknownType()
  {
    return defaultInstance()._unknownType();
  }
  
  public JavaType _constructType(Type paramType, TypeBindings paramTypeBindings)
  {
    Object localObject2;
    Object localObject1;
    if ((paramType instanceof Class))
    {
      localObject2 = (Class)paramType;
      localObject1 = paramTypeBindings;
      if (paramTypeBindings == null) {
        localObject1 = new TypeBindings(this, (Class)localObject2);
      }
      localObject2 = _fromClass((Class)localObject2, (TypeBindings)localObject1);
      paramTypeBindings = (TypeBindings)localObject1;
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (this._modifiers == null) {
        break label230;
      }
      localObject2 = localObject1;
      if (((JavaType)localObject1).isContainerType()) {
        break label230;
      }
      TypeModifier[] arrayOfTypeModifier = this._modifiers;
      int j = arrayOfTypeModifier.length;
      for (int i = 0;; i++)
      {
        localObject2 = localObject1;
        if (i >= j) {
          break;
        }
        localObject1 = arrayOfTypeModifier[i].modifyType((JavaType)localObject1, paramType, paramTypeBindings, this);
      }
      if ((paramType instanceof ParameterizedType))
      {
        localObject1 = _fromParamType((ParameterizedType)paramType, paramTypeBindings);
      }
      else if ((paramType instanceof GenericArrayType))
      {
        localObject1 = _fromArrayType((GenericArrayType)paramType, paramTypeBindings);
      }
      else if ((paramType instanceof TypeVariable))
      {
        localObject1 = _fromVariable((TypeVariable)paramType, paramTypeBindings);
      }
      else
      {
        if (!(paramType instanceof WildcardType)) {
          break;
        }
        localObject1 = _fromWildcard((WildcardType)paramType, paramTypeBindings);
      }
    }
    throw new IllegalArgumentException("Unrecognized Type: " + paramType.toString());
    label230:
    return (JavaType)localObject2;
  }
  
  protected JavaType _fromArrayType(GenericArrayType paramGenericArrayType, TypeBindings paramTypeBindings)
  {
    return ArrayType.construct(_constructType(paramGenericArrayType.getGenericComponentType(), paramTypeBindings));
  }
  
  protected JavaType _fromClass(Class<?> paramClass, TypeBindings paramTypeBindings)
  {
    if (paramClass.isArray()) {
      paramClass = ArrayType.construct(_constructType(paramClass.getComponentType(), null));
    }
    for (;;)
    {
      return paramClass;
      if (paramClass.isEnum()) {
        paramClass = new SimpleType(paramClass);
      } else if (Map.class.isAssignableFrom(paramClass)) {
        paramClass = _mapType(paramClass);
      } else if (Collection.class.isAssignableFrom(paramClass)) {
        paramClass = _collectionType(paramClass);
      } else {
        paramClass = new SimpleType(paramClass);
      }
    }
  }
  
  protected JavaType _fromParamType(ParameterizedType paramParameterizedType, TypeBindings paramTypeBindings)
  {
    Class localClass = (Class)paramParameterizedType.getRawType();
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    if (arrayOfType == null) {}
    for (int i = 0; i == 0; i = arrayOfType.length)
    {
      paramParameterizedType = NO_TYPES;
      if (!Map.class.isAssignableFrom(localClass)) {
        break label173;
      }
      paramParameterizedType = findTypeParameters(constructSimpleType(localClass, paramParameterizedType), Map.class);
      if (paramParameterizedType.length == 2) {
        break label159;
      }
      throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
    }
    JavaType[] arrayOfJavaType = new JavaType[i];
    for (int j = 0;; j++)
    {
      paramParameterizedType = arrayOfJavaType;
      if (j >= i) {
        break;
      }
      arrayOfJavaType[j] = _constructType(arrayOfType[j], paramTypeBindings);
    }
    label159:
    paramParameterizedType = MapType.construct(localClass, paramParameterizedType[0], paramParameterizedType[1]);
    for (;;)
    {
      return paramParameterizedType;
      label173:
      if (Collection.class.isAssignableFrom(localClass))
      {
        paramParameterizedType = findTypeParameters(constructSimpleType(localClass, paramParameterizedType), Collection.class);
        if (paramParameterizedType.length != 1) {
          throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + localClass.getName() + " (found " + paramParameterizedType.length + ")");
        }
        paramParameterizedType = CollectionType.construct(localClass, paramParameterizedType[0]);
      }
      else if (i == 0)
      {
        paramParameterizedType = new SimpleType(localClass);
      }
      else
      {
        paramParameterizedType = constructSimpleType(localClass, paramParameterizedType);
      }
    }
  }
  
  protected JavaType _fromParameterizedClass(Class<?> paramClass, List<JavaType> paramList)
  {
    if (paramClass.isArray()) {
      paramClass = ArrayType.construct(_constructType(paramClass.getComponentType(), null));
    }
    for (;;)
    {
      return paramClass;
      if (paramClass.isEnum())
      {
        paramClass = new SimpleType(paramClass);
      }
      else if (Map.class.isAssignableFrom(paramClass))
      {
        if (paramList.size() > 0)
        {
          JavaType localJavaType = (JavaType)paramList.get(0);
          if (paramList.size() >= 2) {}
          for (paramList = (JavaType)paramList.get(1);; paramList = _unknownType())
          {
            paramClass = MapType.construct(paramClass, localJavaType, paramList);
            break;
          }
        }
        paramClass = _mapType(paramClass);
      }
      else if (Collection.class.isAssignableFrom(paramClass))
      {
        if (paramList.size() >= 1) {
          paramClass = CollectionType.construct(paramClass, (JavaType)paramList.get(0));
        } else {
          paramClass = _collectionType(paramClass);
        }
      }
      else if (paramList.size() == 0)
      {
        paramClass = new SimpleType(paramClass);
      }
      else
      {
        paramClass = constructSimpleType(paramClass, (JavaType[])paramList.toArray(new JavaType[paramList.size()]));
      }
    }
  }
  
  protected JavaType _fromVariable(TypeVariable<?> paramTypeVariable, TypeBindings paramTypeBindings)
  {
    Object localObject;
    if (paramTypeBindings == null) {
      localObject = _unknownType();
    }
    for (;;)
    {
      return (JavaType)localObject;
      String str = paramTypeVariable.getName();
      JavaType localJavaType = paramTypeBindings.findType(str);
      localObject = localJavaType;
      if (localJavaType == null)
      {
        paramTypeVariable = paramTypeVariable.getBounds();
        paramTypeBindings._addPlaceholder(str);
        localObject = _constructType(paramTypeVariable[0], paramTypeBindings);
      }
    }
  }
  
  protected JavaType _fromWildcard(WildcardType paramWildcardType, TypeBindings paramTypeBindings)
  {
    return _constructType(paramWildcardType.getUpperBounds()[0], paramTypeBindings);
  }
  
  protected JavaType _resolveVariableViaSubTypes(HierarchicType paramHierarchicType, String paramString, TypeBindings paramTypeBindings)
  {
    int i;
    if ((paramHierarchicType != null) && (paramHierarchicType.isGeneric()))
    {
      TypeVariable[] arrayOfTypeVariable = paramHierarchicType.getRawClass().getTypeParameters();
      i = 0;
      int j = arrayOfTypeVariable.length;
      if (i < j) {
        if (paramString.equals(arrayOfTypeVariable[i].getName()))
        {
          paramString = paramHierarchicType.asGeneric().getActualTypeArguments()[i];
          if ((paramString instanceof TypeVariable)) {
            paramHierarchicType = _resolveVariableViaSubTypes(paramHierarchicType.getSubType(), ((TypeVariable)paramString).getName(), paramTypeBindings);
          }
        }
      }
    }
    for (;;)
    {
      return paramHierarchicType;
      paramHierarchicType = _constructType(paramString, paramTypeBindings);
      continue;
      i++;
      break;
      paramHierarchicType = _unknownType();
    }
  }
  
  protected JavaType _unknownType()
  {
    return new SimpleType(Object.class, null, null);
  }
  
  protected ArrayType constructArrayType(Class<?> paramClass)
  {
    return ArrayType.construct(_constructType(paramClass, null));
  }
  
  protected ArrayType constructArrayType(JavaType paramJavaType)
  {
    return ArrayType.construct(paramJavaType);
  }
  
  public CollectionLikeType constructCollectionLikeType(Class<?> paramClass1, Class<?> paramClass2)
  {
    return CollectionLikeType.construct(paramClass1, constructType(paramClass2));
  }
  
  public CollectionLikeType constructCollectionLikeType(Class<?> paramClass, JavaType paramJavaType)
  {
    return CollectionLikeType.construct(paramClass, paramJavaType);
  }
  
  public CollectionType constructCollectionType(Class<? extends Collection> paramClass, Class<?> paramClass1)
  {
    return CollectionType.construct(paramClass, constructType(paramClass1));
  }
  
  public CollectionType constructCollectionType(Class<? extends Collection> paramClass, JavaType paramJavaType)
  {
    return CollectionType.construct(paramClass, paramJavaType);
  }
  
  public JavaType constructFromCanonical(String paramString)
    throws IllegalArgumentException
  {
    return this._parser.parse(paramString);
  }
  
  public MapLikeType constructMapLikeType(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    return MapType.construct(paramClass1, constructType(paramClass2), constructType(paramClass3));
  }
  
  public MapLikeType constructMapLikeType(Class<?> paramClass, JavaType paramJavaType1, JavaType paramJavaType2)
  {
    return MapLikeType.construct(paramClass, paramJavaType1, paramJavaType2);
  }
  
  public MapType constructMapType(Class<? extends Map> paramClass, Class<?> paramClass1, Class<?> paramClass2)
  {
    return MapType.construct(paramClass, constructType(paramClass1), constructType(paramClass2));
  }
  
  public MapType constructMapType(Class<? extends Map> paramClass, JavaType paramJavaType1, JavaType paramJavaType2)
  {
    return MapType.construct(paramClass, paramJavaType1, paramJavaType2);
  }
  
  public JavaType constructParametricType(Class<?> paramClass, Class<?>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    JavaType[] arrayOfJavaType = new JavaType[j];
    for (int i = 0; i < j; i++) {
      arrayOfJavaType[i] = _fromClass(paramVarArgs[i], null);
    }
    return constructParametricType(paramClass, arrayOfJavaType);
  }
  
  public JavaType constructParametricType(Class<?> paramClass, JavaType... paramVarArgs)
  {
    if (paramClass.isArray())
    {
      if (paramVarArgs.length != 1) {
        throw new IllegalArgumentException("Need exactly 1 parameter type for arrays (" + paramClass.getName() + ")");
      }
      paramClass = constructArrayType(paramVarArgs[0]);
    }
    for (;;)
    {
      return paramClass;
      if (Map.class.isAssignableFrom(paramClass))
      {
        if (paramVarArgs.length != 2) {
          throw new IllegalArgumentException("Need exactly 2 parameter types for Map types (" + paramClass.getName() + ")");
        }
        paramClass = constructMapType(paramClass, paramVarArgs[0], paramVarArgs[1]);
      }
      else if (Collection.class.isAssignableFrom(paramClass))
      {
        if (paramVarArgs.length != 1) {
          throw new IllegalArgumentException("Need exactly 1 parameter type for Collection types (" + paramClass.getName() + ")");
        }
        paramClass = constructCollectionType(paramClass, paramVarArgs[0]);
      }
      else
      {
        paramClass = constructSimpleType(paramClass, paramVarArgs);
      }
    }
  }
  
  public JavaType constructSimpleType(Class<?> paramClass, JavaType[] paramArrayOfJavaType)
  {
    TypeVariable[] arrayOfTypeVariable = paramClass.getTypeParameters();
    if (arrayOfTypeVariable.length != paramArrayOfJavaType.length) {
      throw new IllegalArgumentException("Parameter type mismatch for " + paramClass.getName() + ": expected " + arrayOfTypeVariable.length + " parameters, was given " + paramArrayOfJavaType.length);
    }
    String[] arrayOfString = new String[arrayOfTypeVariable.length];
    int i = 0;
    int j = arrayOfTypeVariable.length;
    while (i < j)
    {
      arrayOfString[i] = arrayOfTypeVariable[i].getName();
      i++;
    }
    return new SimpleType(paramClass, arrayOfString, paramArrayOfJavaType);
  }
  
  public JavaType constructSpecializedType(JavaType paramJavaType, Class<?> paramClass)
  {
    Object localObject;
    if (((paramJavaType instanceof SimpleType)) && ((paramClass.isArray()) || (Map.class.isAssignableFrom(paramClass)) || (Collection.class.isAssignableFrom(paramClass))))
    {
      if (!paramJavaType.getRawClass().isAssignableFrom(paramClass)) {
        throw new IllegalArgumentException("Class " + paramClass.getClass().getName() + " not subtype of " + paramJavaType);
      }
      paramClass = instance._fromClass(paramClass, new TypeBindings(this, paramJavaType.getRawClass()));
      localObject = paramJavaType.getValueHandler();
      if (localObject != null) {
        paramClass.setValueHandler(localObject);
      }
      localObject = paramJavaType.getTypeHandler();
      paramJavaType = paramClass;
      if (localObject == null) {}
    }
    for (paramJavaType = paramClass.withTypeHandler(localObject);; paramJavaType = paramJavaType.narrowBy(paramClass)) {
      return paramJavaType;
    }
  }
  
  public JavaType constructType(Type paramType)
  {
    return _constructType(paramType, null);
  }
  
  public JavaType constructType(Type paramType, Class<?> paramClass)
  {
    return _constructType(paramType, new TypeBindings(this, paramClass));
  }
  
  public JavaType constructType(Type paramType, TypeBindings paramTypeBindings)
  {
    return _constructType(paramType, paramTypeBindings);
  }
  
  public JavaType constructType(Type paramType, JavaType paramJavaType)
  {
    return _constructType(paramType, new TypeBindings(this, paramJavaType));
  }
  
  public JavaType constructType(TypeReference<?> paramTypeReference)
  {
    return _constructType(paramTypeReference.getType(), null);
  }
  
  public JavaType[] findTypeParameters(Class<?> paramClass1, Class<?> paramClass2)
  {
    return findTypeParameters(paramClass1, paramClass2, new TypeBindings(this, paramClass1));
  }
  
  public JavaType[] findTypeParameters(Class<?> paramClass1, Class<?> paramClass2, TypeBindings paramTypeBindings)
  {
    Object localObject1 = _findSuperTypeChain(paramClass1, paramClass2);
    if (localObject1 == null) {
      throw new IllegalArgumentException("Class " + paramClass1.getName() + " is not a subtype of " + paramClass2.getName());
    }
    paramClass1 = (Class<?>)localObject1;
    while (paramClass1.getSuperType() != null)
    {
      paramClass1 = paramClass1.getSuperType();
      Object localObject2 = paramClass1.getRawClass();
      paramClass2 = new TypeBindings(this, (Class)localObject2);
      if (paramClass1.isGeneric())
      {
        localObject1 = paramClass1.asGeneric().getActualTypeArguments();
        localObject2 = ((Class)localObject2).getTypeParameters();
        int j = localObject1.length;
        for (int i = 0; i < j; i++) {
          paramClass2.addBinding(localObject2[i].getName(), instance._constructType(localObject1[i], paramTypeBindings));
        }
      }
      paramTypeBindings = paramClass2;
    }
    if (!paramClass1.isGeneric()) {}
    for (paramClass1 = null;; paramClass1 = paramTypeBindings.typesAsArray()) {
      return paramClass1;
    }
  }
  
  public JavaType[] findTypeParameters(JavaType paramJavaType, Class<?> paramClass)
  {
    Object localObject = paramJavaType.getRawClass();
    int j;
    if (localObject == paramClass)
    {
      j = paramJavaType.containedTypeCount();
      if (j == 0) {
        paramClass = null;
      }
    }
    for (;;)
    {
      return paramClass;
      localObject = new JavaType[j];
      for (int i = 0;; i++)
      {
        paramClass = (Class<?>)localObject;
        if (i >= j) {
          break;
        }
        localObject[i] = paramJavaType.containedType(i);
      }
      paramClass = findTypeParameters((Class)localObject, paramClass, new TypeBindings(this, paramJavaType));
    }
  }
  
  public JavaType uncheckedSimpleType(Class<?> paramClass)
  {
    return new SimpleType(paramClass, null, null);
  }
  
  public TypeFactory withModifier(TypeModifier paramTypeModifier)
  {
    if (this._modifiers == null) {}
    for (paramTypeModifier = new TypeFactory(this._parser, new TypeModifier[] { paramTypeModifier });; paramTypeModifier = new TypeFactory(this._parser, (TypeModifier[])ArrayBuilders.insertInListNoDup(this._modifiers, paramTypeModifier))) {
      return paramTypeModifier;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\type\TypeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */