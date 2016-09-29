package com.lidroid.xutils.db.converter;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.sqlite.ColumnDbType;
import java.util.concurrent.ConcurrentHashMap;

public class ColumnConverterFactory
{
  private static final ConcurrentHashMap<String, ColumnConverter> columnType_columnConverter_map;
  
  static
  {
    JniLib.a(ColumnConverterFactory.class, 951);
    columnType_columnConverter_map = new ConcurrentHashMap();
    Object localObject = new BooleanColumnConverter();
    columnType_columnConverter_map.put(Boolean.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Boolean.class.getName(), localObject);
    localObject = new ByteArrayColumnConverter();
    columnType_columnConverter_map.put(byte[].class.getName(), localObject);
    localObject = new ByteColumnConverter();
    columnType_columnConverter_map.put(Byte.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Byte.class.getName(), localObject);
    localObject = new CharColumnConverter();
    columnType_columnConverter_map.put(Character.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Character.class.getName(), localObject);
    localObject = new DateColumnConverter();
    columnType_columnConverter_map.put(java.util.Date.class.getName(), localObject);
    localObject = new DoubleColumnConverter();
    columnType_columnConverter_map.put(Double.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Double.class.getName(), localObject);
    localObject = new FloatColumnConverter();
    columnType_columnConverter_map.put(Float.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Float.class.getName(), localObject);
    localObject = new IntegerColumnConverter();
    columnType_columnConverter_map.put(Integer.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Integer.class.getName(), localObject);
    localObject = new LongColumnConverter();
    columnType_columnConverter_map.put(Long.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Long.class.getName(), localObject);
    localObject = new ShortColumnConverter();
    columnType_columnConverter_map.put(Short.TYPE.getName(), localObject);
    columnType_columnConverter_map.put(Short.class.getName(), localObject);
    localObject = new SqlDateColumnConverter();
    columnType_columnConverter_map.put(java.sql.Date.class.getName(), localObject);
    localObject = new StringColumnConverter();
    columnType_columnConverter_map.put(String.class.getName(), localObject);
  }
  
  public static native ColumnConverter getColumnConverter(Class paramClass);
  
  public static native ColumnDbType getDbColumnType(Class paramClass);
  
  public static native boolean isSupportColumnConverter(Class paramClass);
  
  public static native void registerColumnConverter(Class paramClass, ColumnConverter paramColumnConverter);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\converter\ColumnConverterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */