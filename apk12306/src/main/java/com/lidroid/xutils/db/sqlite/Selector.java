package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.db.table.TableUtils;
import java.util.List;

public class Selector
{
  protected Class<?> entityType;
  protected int limit = 0;
  protected int offset = 0;
  protected List<OrderBy> orderByList;
  protected String tableName;
  protected WhereBuilder whereBuilder;
  
  static
  {
    JniLib.a(Selector.class, 967);
  }
  
  private Selector(Class<?> paramClass)
  {
    this.entityType = paramClass;
    this.tableName = TableUtils.getTableName(paramClass);
  }
  
  public static native Selector from(Class<?> paramClass);
  
  public native Selector and(WhereBuilder paramWhereBuilder);
  
  public native Selector and(String paramString1, String paramString2, Object paramObject);
  
  public native Selector expr(String paramString);
  
  public native Selector expr(String paramString1, String paramString2, Object paramObject);
  
  public native Class<?> getEntityType();
  
  public native DbModelSelector groupBy(String paramString);
  
  public native Selector limit(int paramInt);
  
  public native Selector offset(int paramInt);
  
  public native Selector or(WhereBuilder paramWhereBuilder);
  
  public native Selector or(String paramString1, String paramString2, Object paramObject);
  
  public native Selector orderBy(String paramString);
  
  public native Selector orderBy(String paramString, boolean paramBoolean);
  
  public DbModelSelector select(String... paramVarArgs)
  {
    return new DbModelSelector(this, paramVarArgs);
  }
  
  public native String toString();
  
  public native Selector where(WhereBuilder paramWhereBuilder);
  
  public native Selector where(String paramString1, String paramString2, Object paramObject);
  
  protected class OrderBy
  {
    private String columnName;
    private boolean desc;
    
    static
    {
      JniLib.a(OrderBy.class, 966);
    }
    
    public OrderBy(String paramString)
    {
      this.columnName = paramString;
    }
    
    public OrderBy(String paramString, boolean paramBoolean)
    {
      this.columnName = paramString;
      this.desc = paramBoolean;
    }
    
    public native String toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\Selector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */