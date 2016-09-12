package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.table.Column;
import com.lidroid.xutils.db.table.Id;
import com.lidroid.xutils.db.table.KeyValue;
import com.lidroid.xutils.db.table.Table;
import com.lidroid.xutils.db.table.TableUtils;
import com.lidroid.xutils.exception.DbException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class SqlInfoBuilder
{
  static
  {
    JniLib.a(SqlInfoBuilder.class, 969);
  }
  
  public static native SqlInfo buildCreateTableSqlInfo(DbUtils paramDbUtils, Class<?> paramClass)
    throws DbException;
  
  private static native String buildDeleteSqlByTableName(String paramString);
  
  public static native SqlInfo buildDeleteSqlInfo(DbUtils paramDbUtils, Class<?> paramClass, WhereBuilder paramWhereBuilder)
    throws DbException;
  
  public static native SqlInfo buildDeleteSqlInfo(DbUtils paramDbUtils, Class<?> paramClass, Object paramObject)
    throws DbException;
  
  public static native SqlInfo buildDeleteSqlInfo(DbUtils paramDbUtils, Object paramObject)
    throws DbException;
  
  public static native SqlInfo buildInsertSqlInfo(DbUtils paramDbUtils, Object paramObject)
    throws DbException;
  
  public static native SqlInfo buildReplaceSqlInfo(DbUtils paramDbUtils, Object paramObject)
    throws DbException;
  
  public static SqlInfo buildUpdateSqlInfo(DbUtils paramDbUtils, Object paramObject, WhereBuilder paramWhereBuilder, String... paramVarArgs)
    throws DbException
  {
    Object localObject2 = entity2KeyValueList(paramDbUtils, paramObject);
    if (((List)localObject2).size() == 0)
    {
      paramDbUtils = null;
      return paramDbUtils;
    }
    Object localObject1 = null;
    paramDbUtils = (DbUtils)localObject1;
    if (paramVarArgs != null)
    {
      paramDbUtils = (DbUtils)localObject1;
      if (paramVarArgs.length > 0)
      {
        paramDbUtils = new HashSet(paramVarArgs.length);
        Collections.addAll(paramDbUtils, paramVarArgs);
      }
    }
    localObject1 = TableUtils.getTableName(paramObject.getClass());
    paramObject = new SqlInfo();
    paramVarArgs = new StringBuffer("UPDATE ");
    paramVarArgs.append((String)localObject1);
    paramVarArgs.append(" SET ");
    localObject2 = ((List)localObject2).iterator();
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext())
      {
        paramVarArgs.deleteCharAt(paramVarArgs.length() - 1);
        if ((paramWhereBuilder != null) && (paramWhereBuilder.getWhereItemSize() > 0)) {
          paramVarArgs.append(" WHERE ").append(paramWhereBuilder.toString());
        }
        ((SqlInfo)paramObject).setSql(paramVarArgs.toString());
        paramDbUtils = (DbUtils)paramObject;
        break;
      }
      localObject1 = (KeyValue)((Iterator)localObject2).next();
      if ((paramDbUtils == null) || (paramDbUtils.contains(((KeyValue)localObject1).key)))
      {
        paramVarArgs.append(((KeyValue)localObject1).key).append("=?,");
        ((SqlInfo)paramObject).addBindArgWithoutConverter(((KeyValue)localObject1).value);
      }
    }
  }
  
  public static SqlInfo buildUpdateSqlInfo(DbUtils paramDbUtils, Object paramObject, String... paramVarArgs)
    throws DbException
  {
    Object localObject3 = entity2KeyValueList(paramDbUtils, paramObject);
    if (((List)localObject3).size() == 0)
    {
      paramDbUtils = null;
      return paramDbUtils;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramVarArgs != null)
    {
      localObject1 = localObject2;
      if (paramVarArgs.length > 0)
      {
        localObject1 = new HashSet(paramVarArgs.length);
        Collections.addAll((Collection)localObject1, paramVarArgs);
      }
    }
    Object localObject4 = Table.get(paramDbUtils, paramObject.getClass());
    paramVarArgs = ((Table)localObject4).id;
    localObject2 = paramVarArgs.getColumnValue(paramObject);
    if (localObject2 == null) {
      throw new DbException("this entity[" + paramObject.getClass() + "]'s id value is null");
    }
    paramDbUtils = new SqlInfo();
    paramObject = new StringBuffer("UPDATE ");
    ((StringBuffer)paramObject).append(((Table)localObject4).tableName);
    ((StringBuffer)paramObject).append(" SET ");
    localObject4 = ((List)localObject3).iterator();
    for (;;)
    {
      if (!((Iterator)localObject4).hasNext())
      {
        ((StringBuffer)paramObject).deleteCharAt(((StringBuffer)paramObject).length() - 1);
        ((StringBuffer)paramObject).append(" WHERE ").append(WhereBuilder.b(paramVarArgs.getColumnName(), "=", localObject2));
        paramDbUtils.setSql(((StringBuffer)paramObject).toString());
        break;
      }
      localObject3 = (KeyValue)((Iterator)localObject4).next();
      if ((localObject1 == null) || (((HashSet)localObject1).contains(((KeyValue)localObject3).key)))
      {
        ((StringBuffer)paramObject).append(((KeyValue)localObject3).key).append("=?,");
        paramDbUtils.addBindArgWithoutConverter(((KeyValue)localObject3).value);
      }
    }
  }
  
  private static native KeyValue column2KeyValue(Object paramObject, Column paramColumn);
  
  public static native List<KeyValue> entity2KeyValueList(DbUtils paramDbUtils, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\SqlInfoBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */