package org.codehaus.jackson.map.jsontype.impl;

import java.util.EnumMap;
import java.util.EnumSet;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class ClassNameIdResolver
  extends TypeIdResolverBase
{
  public ClassNameIdResolver(JavaType paramJavaType, TypeFactory paramTypeFactory)
  {
    super(paramJavaType, paramTypeFactory);
  }
  
  protected final String _idFrom(Object paramObject, Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (Enum.class.isAssignableFrom(paramClass))
    {
      localObject = paramClass;
      if (!paramClass.isEnum()) {
        localObject = paramClass.getSuperclass();
      }
    }
    localObject = ((Class)localObject).getName();
    paramClass = (Class<?>)localObject;
    if (((String)localObject).startsWith("java.util"))
    {
      if (!(paramObject instanceof EnumSet)) {
        break label71;
      }
      paramObject = ClassUtil.findEnumType((EnumSet)paramObject);
      paramClass = TypeFactory.defaultInstance().constructCollectionType(EnumSet.class, (Class)paramObject).toCanonical();
    }
    for (;;)
    {
      return paramClass;
      label71:
      if ((paramObject instanceof EnumMap))
      {
        paramObject = ClassUtil.findEnumType((EnumMap)paramObject);
        paramClass = TypeFactory.defaultInstance().constructMapType(EnumMap.class, (Class)paramObject, Object.class).toCanonical();
      }
      else
      {
        paramObject = ((String)localObject).substring(9);
        if (!((String)paramObject).startsWith(".Arrays$"))
        {
          paramClass = (Class<?>)localObject;
          if (!((String)paramObject).startsWith(".Collections$")) {}
        }
        else
        {
          paramClass = (Class<?>)localObject;
          if (((String)localObject).indexOf("List") >= 0) {
            paramClass = "java.util.ArrayList";
          }
        }
      }
    }
  }
  
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.CLASS;
  }
  
  public String idFromValue(Object paramObject)
  {
    return _idFrom(paramObject, paramObject.getClass());
  }
  
  public String idFromValueAndType(Object paramObject, Class<?> paramClass)
  {
    return _idFrom(paramObject, paramClass);
  }
  
  public void registerSubtype(Class<?> paramClass, String paramString) {}
  
  public JavaType typeFromId(String paramString)
  {
    if (paramString.indexOf('<') > 0) {
      paramString = TypeFactory.fromCanonical(paramString);
    }
    for (;;)
    {
      return paramString;
      try
      {
        Object localObject = Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
        localObject = this._typeFactory.constructSpecializedType(this._baseType, (Class)localObject);
        paramString = (String)localObject;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): no such class found");
      }
      catch (Exception localException)
      {
        throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): " + localException.getMessage(), localException);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\jsontype\impl\ClassNameIdResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */