package com.worklight.androidgap.jsonstore.database;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.util.JsonstoreUtil;
import com.worklight.androidgap.jsonstore.util.Logger;
import net.sqlcipher.database.SQLiteDatabase;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadableDatabase
{
  private static final String SQL_AND = " AND ";
  private static final String SQL_EQ = " = ?";
  private static final String SQL_FIND = "SELECT {0} FROM {1};";
  private static final String SQL_FIND_BY_ID = "SELECT {0}, {1} FROM {2} WHERE {3} AND _deleted = 0";
  private static final String SQL_FIND_OP = "SELECT {0} FROM {1} WHERE {2} LIKE ?";
  private static final String SQL_FIND_WHERE = "SELECT {0} FROM {1} WHERE {2};";
  private static final String SQL_FIND_WHERE_WITH_LIMIT = "SELECT {0} FROM {1} WHERE {2} LIMIT {3};";
  private static final String SQL_FIND_WHERE_WITH_LIMIT_AND_OFFSET = "SELECT {0} FROM {1} WHERE {2} LIMIT {3} OFFSET {4};";
  private static final String SQL_FIND_WHERE_WITH_NEGATIVE_LIMIT = "SELECT {0} FROM {1} WHERE {2} ORDER BY {3} DESC LIMIT {4};";
  private static final String SQL_LIKE = " LIKE ?";
  private static final String SQL_OR = " OR ";
  private SQLiteDatabase database;
  protected Logger logger;
  private DatabaseSchema schema;
  
  static
  {
    JniLib.a(ReadableDatabase.class, 1155);
  }
  
  protected ReadableDatabase(SQLiteDatabase paramSQLiteDatabase, DatabaseSchema paramDatabaseSchema)
  {
    this.database = paramSQLiteDatabase;
    this.logger = JsonstoreUtil.getDatabaseLogger();
    this.schema = paramDatabaseSchema;
  }
  
  public Cursor findByIds(int... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String[] arrayOfString = new String[paramVarArgs.length];
    for (int i = 0; i < paramVarArgs.length; i++)
    {
      localStringBuilder.append("_id");
      localStringBuilder.append(" = ?");
      if (i < paramVarArgs.length - 1) {
        localStringBuilder.append(" OR ");
      }
      arrayOfString[i] = ("" + paramVarArgs[i]);
    }
    return rawQuery(JsonstoreUtil.formatString("SELECT {0}, {1} FROM {2} WHERE {3} AND _deleted = 0", new Object[] { "_id", "json", this.schema.getName(), localStringBuilder.toString() }), arrayOfString);
  }
  
  protected native String findOperationForObjectById(int paramInt);
  
  public native Cursor findUsingQueryObject(JSONObject paramJSONObject, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString1, String paramString2, Boolean paramBoolean)
    throws JSONException;
  
  protected native SQLiteDatabase getDatabase();
  
  protected native DatabaseSchema getSchema();
  
  public native Cursor rawQuery(String paramString, String[] paramArrayOfString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\database\ReadableDatabase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */