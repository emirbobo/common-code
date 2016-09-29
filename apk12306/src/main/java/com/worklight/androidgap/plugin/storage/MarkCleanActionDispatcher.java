package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;

public class MarkCleanActionDispatcher
  extends DatabaseActionDispatcher
{
  private static final String PARAM_DOCS = "docs";
  private static final String PARAM_OPTIONS = "options";
  
  static
  {
    JniLib.a(MarkCleanActionDispatcher.class, 1232);
  }
  
  protected MarkCleanActionDispatcher()
  {
    super("markClean");
    addParameter("docs", true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.ARRAY });
    addParameter("options", false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  private native JSONArray getDocs(DatabaseActionDispatcher.Context paramContext);
  
  public native PluginResult dispatch(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  private class MarkCleanAction
    implements DatabaseActionDispatcher.WritableDatabaseAction<Integer>
  {
    private int id;
    private String operation;
    
    static
    {
      JniLib.a(MarkCleanAction.class, 1231);
    }
    
    private MarkCleanAction(int paramInt, String paramString)
    {
      this.id = paramInt;
      this.operation = paramString;
    }
    
    public native Integer performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
      throws Throwable;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\MarkCleanActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */