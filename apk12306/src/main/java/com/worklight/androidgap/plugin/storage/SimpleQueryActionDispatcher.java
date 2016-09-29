package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;
import com.worklight.androidgap.jsonstore.util.Logger;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

public abstract class SimpleQueryActionDispatcher
  extends DatabaseActionDispatcher
{
  public SimpleQueryActionDispatcher(String paramString)
  {
    super(paramString);
  }
  
  public PluginResult dispatch(DatabaseActionDispatcher.Context paramContext)
    throws Throwable
  {
    int j = -1;
    try
    {
      SimpleQueryAction localSimpleQueryAction = new com/worklight/androidgap/plugin/storage/SimpleQueryActionDispatcher$SimpleQueryAction;
      localSimpleQueryAction.<init>(this, paramContext, null);
      i = ((Integer)paramContext.performReadableDatabaseAction(localSimpleQueryAction)).intValue();
      i = getModifiedResultValue(i);
      logResult(paramContext, i);
      return new PluginResult(PluginResult.Status.OK, i);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i = j;
        if (this.logger.isLoggable(6))
        {
          this.logger.logError("error occurred while performing query:");
          this.logger.logError("   " + getFormattedQuery(paramContext), localThrowable);
          i = j;
        }
      }
    }
  }
  
  protected abstract String getFormattedQuery(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  protected int getModifiedResultValue(int paramInt)
  {
    return paramInt;
  }
  
  protected int getNotFoundResultValue()
  {
    return -1;
  }
  
  protected void logResult(DatabaseActionDispatcher.Context paramContext, int paramInt)
    throws Throwable
  {}
  
  private class SimpleQueryAction
    implements DatabaseActionDispatcher.ReadableDatabaseAction<Integer>
  {
    private DatabaseActionDispatcher.Context context;
    
    static
    {
      JniLib.a(SimpleQueryAction.class, 1238);
    }
    
    private SimpleQueryAction(DatabaseActionDispatcher.Context paramContext)
    {
      this.context = paramContext;
    }
    
    public native Integer performAction(DatabaseSchema paramDatabaseSchema, ReadableDatabase paramReadableDatabase)
      throws Throwable;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\SimpleQueryActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */