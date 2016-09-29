package com.lidroid.xutils.db.sqlite;

import com.bangcle.andjni.JniLib;

public class DbModelSelector
{
  private String[] columnExpressions;
  private String groupByColumnName;
  private WhereBuilder having;
  private Selector selector;
  
  static
  {
    JniLib.a(DbModelSelector.class, 963);
  }
  
  protected DbModelSelector(Selector paramSelector, String paramString)
  {
    this.selector = paramSelector;
    this.groupByColumnName = paramString;
  }
  
  protected DbModelSelector(Selector paramSelector, String[] paramArrayOfString)
  {
    this.selector = paramSelector;
    this.columnExpressions = paramArrayOfString;
  }
  
  private DbModelSelector(Class<?> paramClass)
  {
    this.selector = Selector.from(paramClass);
  }
  
  public static native DbModelSelector from(Class<?> paramClass);
  
  public native DbModelSelector and(WhereBuilder paramWhereBuilder);
  
  public native DbModelSelector and(String paramString1, String paramString2, Object paramObject);
  
  public native DbModelSelector expr(String paramString);
  
  public native DbModelSelector expr(String paramString1, String paramString2, Object paramObject);
  
  public native Class<?> getEntityType();
  
  public native DbModelSelector groupBy(String paramString);
  
  public native DbModelSelector having(WhereBuilder paramWhereBuilder);
  
  public native DbModelSelector limit(int paramInt);
  
  public native DbModelSelector offset(int paramInt);
  
  public native DbModelSelector or(WhereBuilder paramWhereBuilder);
  
  public native DbModelSelector or(String paramString1, String paramString2, Object paramObject);
  
  public native DbModelSelector orderBy(String paramString);
  
  public native DbModelSelector orderBy(String paramString, boolean paramBoolean);
  
  public DbModelSelector select(String... paramVarArgs)
  {
    this.columnExpressions = paramVarArgs;
    return this;
  }
  
  public native String toString();
  
  public native DbModelSelector where(WhereBuilder paramWhereBuilder);
  
  public native DbModelSelector where(String paramString1, String paramString2, Object paramObject);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\db\sqlite\DbModelSelector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */