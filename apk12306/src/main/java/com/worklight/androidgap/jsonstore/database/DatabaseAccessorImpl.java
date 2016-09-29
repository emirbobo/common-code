package com.worklight.androidgap.jsonstore.database;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.util.JsonstoreUtil;
import com.worklight.androidgap.jsonstore.util.Logger;
import java.util.HashSet;
import net.sqlcipher.database.SQLiteDatabase;

public class DatabaseAccessorImpl
  implements DatabaseAccessor
{
  private static final String SQL_CREATE_TABLE = "CREATE TABLE {0} ({1} INTEGER PRIMARY KEY AUTOINCREMENT, {2} {3} TEXT, {4} REAL DEFAULT 0, {5} INTEGER DEFAULT 0, {6} TEXT);";
  private static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS {0};";
  private static final String SQL_TABLE_EXISTS = "SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = \"{0}\";";
  private static final HashSet<String> ignoredSchemaNodes;
  private static final Logger logger;
  private SQLiteDatabase database;
  private ReadableDatabase readableDB;
  private DatabaseSchema schema;
  private WritableDatabase writableDB;
  
  static
  {
    JniLib.a(DatabaseAccessorImpl.class, 1152);
    ignoredSchemaNodes = new HashSet();
    logger = JsonstoreUtil.getDatabaseLogger();
    ignoredSchemaNodes.add("_deleted");
    ignoredSchemaNodes.add("_dirty");
    ignoredSchemaNodes.add("_id");
    ignoredSchemaNodes.add("json");
    ignoredSchemaNodes.add("_operation");
  }
  
  protected DatabaseAccessorImpl(SQLiteDatabase paramSQLiteDatabase, DatabaseSchema paramDatabaseSchema)
  {
    this.database = paramSQLiteDatabase;
    this.readableDB = new ReadableDatabase(paramSQLiteDatabase, paramDatabaseSchema);
    this.schema = paramDatabaseSchema;
    this.writableDB = new WritableDatabase(paramSQLiteDatabase, paramDatabaseSchema);
  }
  
  private void execSQL(String paramString, Object... paramVarArgs)
  {
    paramString = JsonstoreUtil.formatString(paramString, paramVarArgs);
    if (logger.isLoggable(3))
    {
      logger.logDebug("executing SQL on database \"" + this.schema.getName() + "\":");
      logger.logDebug("   " + paramString);
    }
    this.writableDB.getDatabase().execSQL(paramString);
  }
  
  private native String formatSchemaColumns();
  
  public native void createTable();
  
  public native void dropTable();
  
  public native SQLiteDatabase getRawDatabase();
  
  public native ReadableDatabase getReadableDatabase();
  
  public native DatabaseSchema getSchema();
  
  public native boolean getTableExists();
  
  public native WritableDatabase getWritableDatabase();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\database\DatabaseAccessorImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */