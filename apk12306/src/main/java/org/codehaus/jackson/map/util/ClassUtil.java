package org.codehaus.jackson.map.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ClassUtil
{
  private static void _addSuperTypes(Class<?> paramClass1, Class<?> paramClass2, Collection<Class<?>> paramCollection, boolean paramBoolean)
  {
    if ((paramClass1 == paramClass2) || (paramClass1 == null) || (paramClass1 == Object.class)) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        if (!paramCollection.contains(paramClass1)) {
          paramCollection.add(paramClass1);
        }
      }
      else
      {
        Class[] arrayOfClass = paramClass1.getInterfaces();
        int j = arrayOfClass.length;
        for (int i = 0; i < j; i++) {
          _addSuperTypes(arrayOfClass[i], paramClass2, paramCollection, true);
        }
        _addSuperTypes(paramClass1.getSuperclass(), paramClass2, paramCollection, true);
      }
    }
  }
  
  public static String canBeABeanType(Class<?> paramClass)
  {
    if (paramClass.isAnnotation()) {
      paramClass = "annotation";
    }
    for (;;)
    {
      return paramClass;
      if (paramClass.isArray()) {
        paramClass = "array";
      } else if (paramClass.isEnum()) {
        paramClass = "enum";
      } else if (paramClass.isPrimitive()) {
        paramClass = "primitive";
      } else {
        paramClass = null;
      }
    }
  }
  
  public static void checkAndFixAccess(Member paramMember)
  {
    Object localObject = (AccessibleObject)paramMember;
    try
    {
      ((AccessibleObject)localObject).setAccessible(true);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (((AccessibleObject)localObject).isAccessible()) {}
      localObject = paramMember.getDeclaringClass();
      throw new IllegalArgumentException("Can not access " + paramMember + " (from class " + ((Class)localObject).getName() + "; failed to set access: " + localSecurityException.getMessage());
    }
  }
  
  public static <T> T createInstance(Class<T> paramClass, boolean paramBoolean)
    throws IllegalArgumentException
  {
    Object localObject = findConstructor(paramClass, paramBoolean);
    if (localObject == null) {
      throw new IllegalArgumentException("Class " + paramClass.getName() + " has no default (no arg) constructor");
    }
    try
    {
      localObject = ((Constructor)localObject).newInstance(new Object[0]);
      paramClass = (Class<T>)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        unwrapAndThrowAsIAE(localException, "Failed to instantiate class " + paramClass.getName() + ", problem: " + localException.getMessage());
        paramClass = null;
      }
    }
    return paramClass;
  }
  
  public static Object defaultValue(Class<?> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      paramClass = Integer.valueOf(0);
    }
    for (;;)
    {
      return paramClass;
      if (paramClass == Long.TYPE)
      {
        paramClass = Long.valueOf(0L);
      }
      else if (paramClass == Boolean.TYPE)
      {
        paramClass = Boolean.FALSE;
      }
      else if (paramClass == Double.TYPE)
      {
        paramClass = Double.valueOf(0.0D);
      }
      else if (paramClass == Float.TYPE)
      {
        paramClass = Float.valueOf(0.0F);
      }
      else if (paramClass == Byte.TYPE)
      {
        paramClass = Byte.valueOf((byte)0);
      }
      else if (paramClass == Short.TYPE)
      {
        paramClass = Short.valueOf((short)0);
      }
      else
      {
        if (paramClass != Character.TYPE) {
          break;
        }
        paramClass = Character.valueOf('\000');
      }
    }
    throw new IllegalArgumentException("Class " + paramClass.getName() + " is not a primitive type");
  }
  
  public static <T> Constructor<T> findConstructor(Class<T> paramClass, boolean paramBoolean)
    throws IllegalArgumentException
  {
    label21:
    do
    {
      try
      {
        localObject2 = paramClass.getDeclaredConstructor(new Class[0]);
        if (!paramBoolean) {
          break label21;
        }
        checkAndFixAccess((Member)localObject2);
        localObject1 = localObject2;
      }
      catch (NoSuchMethodException paramClass)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject1 = null;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          unwrapAndThrowAsIAE(localException, "Failed to find default constructor of class " + paramClass.getName() + ", problem: " + localException.getMessage());
        }
      }
      return (Constructor<T>)localObject1;
      localObject1 = localObject2;
    } while (Modifier.isPublic(((Constructor)localObject2).getModifiers()));
    localObject2 = new java/lang/IllegalArgumentException;
    localObject1 = new java/lang/StringBuilder;
    ((StringBuilder)localObject1).<init>();
    ((IllegalArgumentException)localObject2).<init>("Default constructor for " + paramClass.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: can not instantiate type");
    throw ((Throwable)localObject2);
  }
  
  public static Class<? extends Enum<?>> findEnumType(Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (paramClass.getSuperclass() != Enum.class) {
      localObject = paramClass.getSuperclass();
    }
    return (Class<? extends Enum<?>>)localObject;
  }
  
  public static Class<? extends Enum<?>> findEnumType(Enum<?> paramEnum)
  {
    Class localClass = paramEnum.getClass();
    paramEnum = localClass;
    if (localClass.getSuperclass() != Enum.class) {
      paramEnum = localClass.getSuperclass();
    }
    return paramEnum;
  }
  
  public static Class<? extends Enum<?>> findEnumType(EnumMap<?, ?> paramEnumMap)
  {
    if (!paramEnumMap.isEmpty()) {}
    for (paramEnumMap = findEnumType((Enum)paramEnumMap.keySet().iterator().next());; paramEnumMap = EnumTypeLocator.instance.enumTypeFor(paramEnumMap)) {
      return paramEnumMap;
    }
  }
  
  public static Class<? extends Enum<?>> findEnumType(EnumSet<?> paramEnumSet)
  {
    if (!paramEnumSet.isEmpty()) {}
    for (paramEnumSet = findEnumType((Enum)paramEnumSet.iterator().next());; paramEnumSet = EnumTypeLocator.instance.enumTypeFor(paramEnumSet)) {
      return paramEnumSet;
    }
  }
  
  public static List<Class<?>> findSuperTypes(Class<?> paramClass1, Class<?> paramClass2)
  {
    return findSuperTypes(paramClass1, paramClass2, new ArrayList());
  }
  
  public static List<Class<?>> findSuperTypes(Class<?> paramClass1, Class<?> paramClass2, List<Class<?>> paramList)
  {
    _addSuperTypes(paramClass1, paramClass2, paramList, false);
    return paramList;
  }
  
  public static String getClassDescription(Object paramObject)
  {
    if (paramObject == null)
    {
      paramObject = "unknown";
      return (String)paramObject;
    }
    if ((paramObject instanceof Class)) {}
    for (paramObject = (Class)paramObject;; paramObject = paramObject.getClass())
    {
      paramObject = ((Class)paramObject).getName();
      break;
    }
  }
  
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    while (paramThrowable.getCause() != null) {
      paramThrowable = paramThrowable.getCause();
    }
    return paramThrowable;
  }
  
  public static boolean hasGetterSignature(Method paramMethod)
  {
    boolean bool2 = false;
    boolean bool1;
    if (Modifier.isStatic(paramMethod.getModifiers())) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      Class[] arrayOfClass = paramMethod.getParameterTypes();
      if (arrayOfClass != null)
      {
        bool1 = bool2;
        if (arrayOfClass.length != 0) {}
      }
      else
      {
        bool1 = bool2;
        if (Void.TYPE != paramMethod.getReturnType()) {
          bool1 = true;
        }
      }
    }
  }
  
  public static boolean isCollectionMapOrArray(Class<?> paramClass)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramClass.isArray()) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (!Collection.class.isAssignableFrom(paramClass))
      {
        bool1 = bool2;
        if (!Map.class.isAssignableFrom(paramClass)) {
          bool1 = false;
        }
      }
    }
  }
  
  public static boolean isConcrete(Class<?> paramClass)
  {
    if ((paramClass.getModifiers() & 0x600) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean isConcrete(Member paramMember)
  {
    if ((paramMember.getModifiers() & 0x600) == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String isLocalType(Class<?> paramClass)
  {
    for (;;)
    {
      try
      {
        if (paramClass.getEnclosingMethod() == null) {
          continue;
        }
        paramClass = "local/anonymous";
      }
      catch (NullPointerException paramClass)
      {
        paramClass = null;
        continue;
      }
      catch (SecurityException paramClass)
      {
        continue;
      }
      return paramClass;
      if ((paramClass.getEnclosingClass() == null) || (Modifier.isStatic(paramClass.getModifiers()))) {
        continue;
      }
      paramClass = "non-static member class";
    }
  }
  
  public static boolean isProxyType(Class<?> paramClass)
  {
    boolean bool2 = true;
    boolean bool1;
    if (Proxy.isProxyClass(paramClass)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramClass = paramClass.getName();
      bool1 = bool2;
      if (!paramClass.startsWith("net.sf.cglib.proxy."))
      {
        bool1 = bool2;
        if (!paramClass.startsWith("org.hibernate.proxy.")) {
          bool1 = false;
        }
      }
    }
  }
  
  public static void throwAsIAE(Throwable paramThrowable)
  {
    throwAsIAE(paramThrowable, paramThrowable.getMessage());
  }
  
  public static void throwAsIAE(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof RuntimeException)) {
      throw ((RuntimeException)paramThrowable);
    }
    if ((paramThrowable instanceof Error)) {
      throw ((Error)paramThrowable);
    }
    throw new IllegalArgumentException(paramString, paramThrowable);
  }
  
  public static void throwRootCause(Throwable paramThrowable)
    throws Exception
  {
    paramThrowable = getRootCause(paramThrowable);
    if ((paramThrowable instanceof Exception)) {
      throw ((Exception)paramThrowable);
    }
    throw ((Error)paramThrowable);
  }
  
  public static void unwrapAndThrowAsIAE(Throwable paramThrowable)
  {
    throwAsIAE(getRootCause(paramThrowable));
  }
  
  public static void unwrapAndThrowAsIAE(Throwable paramThrowable, String paramString)
  {
    throwAsIAE(getRootCause(paramThrowable), paramString);
  }
  
  public static Class<?> wrapperType(Class<?> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      paramClass = Integer.class;
    }
    for (;;)
    {
      return paramClass;
      if (paramClass == Long.TYPE)
      {
        paramClass = Long.class;
      }
      else if (paramClass == Boolean.TYPE)
      {
        paramClass = Boolean.class;
      }
      else if (paramClass == Double.TYPE)
      {
        paramClass = Double.class;
      }
      else if (paramClass == Float.TYPE)
      {
        paramClass = Float.class;
      }
      else if (paramClass == Byte.TYPE)
      {
        paramClass = Byte.class;
      }
      else if (paramClass == Short.TYPE)
      {
        paramClass = Short.class;
      }
      else
      {
        if (paramClass != Character.TYPE) {
          break;
        }
        paramClass = Character.class;
      }
    }
    throw new IllegalArgumentException("Class " + paramClass.getName() + " is not a primitive type");
  }
  
  private static class EnumTypeLocator
  {
    static final EnumTypeLocator instance = new EnumTypeLocator();
    private final Field enumMapTypeField = locateField(EnumMap.class, "elementType", Class.class);
    private final Field enumSetTypeField = locateField(EnumSet.class, "elementType", Class.class);
    
    private Object get(Object paramObject, Field paramField)
    {
      try
      {
        paramObject = paramField.get(paramObject);
        return paramObject;
      }
      catch (Exception paramObject)
      {
        throw new IllegalArgumentException((Throwable)paramObject);
      }
    }
    
    private static Field locateField(Class<?> paramClass1, String paramString, Class<?> paramClass2)
    {
      Object localObject = null;
      Field[] arrayOfField = paramClass1.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      paramClass1 = (Class<?>)localObject;
      if (i < j)
      {
        paramClass1 = arrayOfField[i];
        if ((!paramString.equals(paramClass1.getName())) || (paramClass1.getType() != paramClass2)) {}
      }
      else
      {
        paramString = paramClass1;
        if (paramClass1 != null) {
          break label112;
        }
        j = arrayOfField.length;
        i = 0;
        label62:
        paramString = paramClass1;
        if (i >= j) {
          break label112;
        }
        localObject = arrayOfField[i];
        paramString = paramClass1;
        if (((Field)localObject).getType() != paramClass2) {
          break label104;
        }
        if (paramClass1 == null) {
          break label101;
        }
        paramString = null;
      }
      for (;;)
      {
        return paramString;
        i++;
        break;
        label101:
        paramString = (String)localObject;
        label104:
        i++;
        paramClass1 = paramString;
        break label62;
        label112:
        if (paramString != null) {}
        try
        {
          paramString.setAccessible(true);
        }
        catch (Throwable paramClass1)
        {
          for (;;) {}
        }
      }
    }
    
    public Class<? extends Enum<?>> enumTypeFor(EnumMap<?, ?> paramEnumMap)
    {
      if (this.enumMapTypeField != null) {
        return (Class)get(paramEnumMap, this.enumMapTypeField);
      }
      throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
    }
    
    public Class<? extends Enum<?>> enumTypeFor(EnumSet<?> paramEnumSet)
    {
      if (this.enumSetTypeField != null) {
        return (Class)get(paramEnumSet, this.enumSetTypeField);
      }
      throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\ClassUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */