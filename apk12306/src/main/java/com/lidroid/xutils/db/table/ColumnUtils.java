package com.lidroid.xutils.db.table;

import com.bangcle.andjni.JniLib;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;

public class ColumnUtils
{
  private static final HashSet<String> DB_PRIMITIVE_TYPES;
  
  static
  {
    JniLib.a(ColumnUtils.class, 972);
    DB_PRIMITIVE_TYPES = new HashSet(14);
    DB_PRIMITIVE_TYPES.add(Integer.TYPE.getName());
    DB_PRIMITIVE_TYPES.add(Long.TYPE.getName());
    DB_PRIMITIVE_TYPES.add(Short.TYPE.getName());
    DB_PRIMITIVE_TYPES.add(Byte.TYPE.getName());
    DB_PRIMITIVE_TYPES.add(Float.TYPE.getName());
    DB_PRIMITIVE_TYPES.add(Double.TYPE.getName());
    DB_PRIMITIVE_TYPES.add(Integer.class.getName());
    DB_PRIMITIVE_TYPES.add(Long.class.getName());
    DB_PRIMITIVE_TYPES.add(Short.class.getName());
    DB_PRIMITIVE_TYPES.add(Byte.class.getName());
    DB_PRIMITIVE_TYPES.add(Float.class.getName());
    DB_PRIMITIVE_TYPES.add(Double.class.getName());
    DB_PRIMITIVE_TYPES.add(String.class.getName());
    DB_PRIMITIVE_TYPES.add(byte[].class.getName());
  }
  
  public static native Object convert2DbColumnValueIfNeeded(Object paramObject);
  
  private static native Method getBooleanColumnGetMethod(Class<?> paramClass, String paramString);
  
  private static native Method getBooleanColumnSetMethod(Class<?> paramClass, Field paramField);
  
  public static native String getCheck(Field paramField);
  
  public static native String getColumnDefaultValue(Field paramField);
  
  public static native Method getColumnGetMethod(Class<?> paramClass, Field paramField);
  
  public static native String getColumnNameByField(Field paramField);
  
  public static native Method getColumnSetMethod(Class<?> paramClass, Field paramField);
  
  public static native Class<?> getFinderTargetEntityType(Finder paramFinder);
  
  public static native String getForeignColumnNameByField(Field paramField);
  
  public static native Class<?> getForeignEntityType(Foreign paramForeign);
  
  public static native boolean isDbPrimitiveType(Class<?> paramClass);
  
  public static native boolean isFinder(Field paramField);
  
  public static native boolean isForeign(Field paramField);
  
  public static native boolean isNotNull(Field paramField);
  
  private static native boolean isStartWithIs(String paramString);
  
  public static native boolean isTransient(Field paramField);
  
  public static native boolean isUnique(Field paramField);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\table\ColumnUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */