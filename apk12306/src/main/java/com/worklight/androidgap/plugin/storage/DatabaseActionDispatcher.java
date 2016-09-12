package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseAccessorImpl;
import com.worklight.androidgap.jsonstore.database.DatabaseManager;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class DatabaseActionDispatcher
  extends BaseActionDispatcher
{
  private static final String PARAM_DBNAME = "dbName";
  
  public DatabaseActionDispatcher(String paramString)
  {
    super(paramString);
    addParameter("dbName", true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
  }
  
  public PluginResult dispatch(BaseActionDispatcher.Context paramContext)
    throws Throwable
  {
    paramContext = new Context(paramContext, null);
    if (!DatabaseManager.getInstance().isDatabaseOpen()) {}
    for (paramContext = new PluginResult(PluginResult.Status.ERROR, -50);; paramContext = dispatch(paramContext))
    {
      return paramContext;
      paramContext.initialize();
    }
  }
  
  public abstract PluginResult dispatch(Context paramContext)
    throws Throwable;
  
  public static class Context
    extends BaseActionDispatcher.Context
  {
    private DatabaseAccessorImpl dbAccessor;
    private String dbName;
    private BaseActionDispatcher.Context parentContext;
    
    static
    {
      JniLib.a(Context.class, 1218);
    }
    
    private Context(BaseActionDispatcher.Context paramContext)
    {
      super();
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
  
  public static abstract interface ReadableDatabaseAction<T>
  {
    public abstract T performAction(DatabaseSchema paramDatabaseSchema, ReadableDatabase paramReadableDatabase)
      throws Throwable;
  }
  
  public static abstract interface WritableDatabaseAction<T>
  {
    public abstract T performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
      throws Throwable;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DatabaseActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */