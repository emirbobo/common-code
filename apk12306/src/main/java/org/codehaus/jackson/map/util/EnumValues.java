package org.codehaus.jackson.map.util;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.io.SerializedString;
import org.codehaus.jackson.map.AnnotationIntrospector;

public final class EnumValues
{
  private final EnumMap<?, SerializedString> _values;
  
  private EnumValues(Map<Enum<?>, SerializedString> paramMap)
  {
    this._values = new EnumMap(paramMap);
  }
  
  public static EnumValues construct(Class<Enum<?>> paramClass, AnnotationIntrospector paramAnnotationIntrospector)
  {
    return constructFromName(paramClass, paramAnnotationIntrospector);
  }
  
  public static EnumValues constructFromName(Class<Enum<?>> paramClass, AnnotationIntrospector paramAnnotationIntrospector)
  {
    Enum[] arrayOfEnum = (Enum[])ClassUtil.findEnumType(paramClass).getEnumConstants();
    if (arrayOfEnum != null)
    {
      HashMap localHashMap = new HashMap();
      int j = arrayOfEnum.length;
      for (int i = 0; i < j; i++)
      {
        paramClass = arrayOfEnum[i];
        localHashMap.put(paramClass, new SerializedString(paramAnnotationIntrospector.findEnumValue(paramClass)));
      }
      return new EnumValues(localHashMap);
    }
    throw new IllegalArgumentException("Can not determine enum constants for Class " + paramClass.getName());
  }
  
  public static EnumValues constructFromToString(Class<Enum<?>> paramClass, AnnotationIntrospector paramAnnotationIntrospector)
  {
    paramAnnotationIntrospector = (Enum[])ClassUtil.findEnumType(paramClass).getEnumConstants();
    if (paramAnnotationIntrospector != null)
    {
      HashMap localHashMap = new HashMap();
      int j = paramAnnotationIntrospector.length;
      for (int i = 0; i < j; i++)
      {
        paramClass = paramAnnotationIntrospector[i];
        localHashMap.put(paramClass, new SerializedString(paramClass.toString()));
      }
      return new EnumValues(localHashMap);
    }
    throw new IllegalArgumentException("Can not determine enum constants for Class " + paramClass.getName());
  }
  
  public SerializedString serializedValueFor(Enum<?> paramEnum)
  {
    return (SerializedString)this._values.get(paramEnum);
  }
  
  @Deprecated
  public String valueFor(Enum<?> paramEnum)
  {
    paramEnum = (SerializedString)this._values.get(paramEnum);
    if (paramEnum == null) {}
    for (paramEnum = null;; paramEnum = paramEnum.getValue()) {
      return paramEnum;
    }
  }
  
  public Collection<SerializedString> values()
  {
    return this._values.values();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\map\util\EnumValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */