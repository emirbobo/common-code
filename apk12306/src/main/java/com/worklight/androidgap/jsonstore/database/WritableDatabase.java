package com.worklight.androidgap.jsonstore.database;

import com.bangcle.andjni.JniLib;
import java.util.Map;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public class WritableDatabase
  extends ReadableDatabase
{
  private static final String SQL_AND = " AND";
  private static final String SQL_DELETE = "DELETE FROM {0} WHERE {1};";
  private static final String SQL_INSERT = "INSERT INTO {0} ({1}) VALUES ({2});";
  private static final String SQL_UPDATE = "UPDATE {0} SET {1}{2};";
  private static final String SQL_WHERE = " WHERE";
  
  static
  {
    JniLib.a(WritableDatabase.class, 1156);
  }
  
  protected WritableDatabase(SQLiteDatabase paramSQLiteDatabase, DatabaseSchema paramDatabaseSchema)
  {
    super(paramSQLiteDatabase, paramDatabaseSchema);
  }
  
  public native int delete(String[] paramArrayOfString, Object[] paramArrayOfObject);
  
  public native int deleteIfRequired(JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException;
  
  public native long insert(String paramString, String[] paramArrayOfString, Object[] paramArrayOfObject);
  
  public native long insert(Map<String, Object> paramMap);
  
  public native int update(Map<String, Object> paramMap1, Map<String, Object> paramMap2);
  
  public native int update(JSONObject paramJSONObject, boolean paramBoolean)
    throws Throwable;
  
  public native int update(String[] paramArrayOfString, Object[] paramArrayOfObject, Map<String, Object> paramMap);
  
  public native int update(String[] paramArrayOfString, Object[] paramArrayOfObject, JSONObject paramJSONObject)
    throws JSONException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\database\WritableDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */