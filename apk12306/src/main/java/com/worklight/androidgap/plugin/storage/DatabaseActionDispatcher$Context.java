package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseAccessorImpl;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import org.json.JSONArray;
import org.json.JSONObject;

public class DatabaseActionDispatcher$Context
  extends BaseActionDispatcher.Context
{
  private DatabaseAccessorImpl dbAccessor;
  private String dbName;
  private BaseActionDispatcher.Context parentContext;
  
  static
  {
    JniLib.a(Context.class, 1218);
  }
  
  private DatabaseActionDispatcher$Context(BaseActionDispatcher.Context paramContext)
  {
    super(paramContext.getCordovaContext());
    this.parentContext = paramContext;
  }
  
  private native DatabaseAccessorImpl getDatabaseAccessor()
    throws Throwable;
  
  private native void initialize()
    throws Throwable;
  
  public native void clearDatabase()
    throws Throwable;
  
  public native JSONArray getArrayParameter(String paramString);
  
  public native String getDatabaseName();
  
  public native DatabaseSchema getDatabaseSchema();
  
  public native float getFloatParameter(String paramString);
  
  public native int getIntParameter(String paramString);
  
  public native JSONObject getObjectParameter(String paramString);
  
  public native String getStringParameter(String paramString);
  
  public native Object getUntypedParameter(String paramString);
  
  public native <T> T performReadableDatabaseAction(DatabaseActionDispatcher.ReadableDatabaseAction<T> paramReadableDatabaseAction)
    throws Throwable;
  
  public native <T> T performWritableDatabaseAction(DatabaseActionDispatcher.WritableDatabaseAction<T> paramWritableDatabaseAction)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DatabaseActionDispatcher$Context.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */