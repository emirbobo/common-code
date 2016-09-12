package com.worklight.androidgap.jsonstore.database;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.util.JsonstoreUtil;
import com.worklight.androidgap.jsonstore.util.Logger;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteDatabase;

public class DatabaseManager
{
  private static final String SQL_SCHEMA = "PRAGMA table_info({0})";
  private static boolean initialized = false;
  private static final DatabaseManager instance = new DatabaseManager();
  private static final Logger logger = JsonstoreUtil.getDatabaseLogger();
  private HashMap<String, DatabaseAccessor> accessors = new HashMap();
  private SQLiteDatabase database;
  private String databaseKey;
  private String dbPath;
  
  static
  {
    JniLib.a(DatabaseManager.class, 1153);
  }
  
  public static native DatabaseManager getInstance();
  
  private native void openDatabaseIfNecessary(Context paramContext);
  
  public native boolean checkDatabaseAgainstSchema(Context paramContext, String paramString, DatabaseSchema paramDatabaseSchema);
  
  public native void clearDatabaseKey();
  
  public native void clearDbPath();
  
  public native void closeDatabase();
  
  public native int destroyDatabase(Context paramContext);
  
  public native void destroyKeychain(Context paramContext);
  
  public native void destroyPreferences(Context paramContext);
  
  public native DatabaseAccessor getDatabase(String paramString)
    throws Exception;
  
  public native String getDbPath();
  
  public native boolean isDatabaseOpen();
  
  public native boolean provisionDatabase(Context paramContext, DatabaseSchema paramDatabaseSchema, boolean paramBoolean);
  
  public native void setDatabaseKey(Context paramContext, String paramString1, String paramString2)
    throws Exception;
  
  public native void setDbPath(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\database\DatabaseManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */