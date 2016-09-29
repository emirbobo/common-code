package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;

public class FindActionDispatcher
  extends DatabaseActionDispatcher
{
  private static final String OPTION_EXACT = "exact";
  private static final String OPTION_LIMIT = "limit";
  private static final String OPTION_OFFSET = "offset";
  private static final String PARAM_OPTIONS = "options";
  private static final String PARAM_QUERY_OBJ = "queryObj";
  
  static
  {
    JniLib.a(FindActionDispatcher.class, 1225);
  }
  
  protected FindActionDispatcher()
  {
    super("find");
    addParameter("queryObj", true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.ARRAY });
    addParameter("options", false, true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  private native JSONObject getOptions(DatabaseActionDispatcher.Context paramContext);
  
  private native JSONArray getQueryObj(DatabaseActionDispatcher.Context paramContext);
  
  public native PluginResult dispatch(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  private class FindAction
    implements DatabaseActionDispatcher.ReadableDatabaseAction<JSONArray>
  {
    private Boolean exact = Boolean.valueOf(false);
    private String limit = null;
    private String offset = null;
    private JSONObject queryObj;
    
    static
    {
      JniLib.a(FindAction.class, 1224);
    }
    
    private FindAction(JSONObject paramJSONObject)
    {
      this.queryObj = paramJSONObject;
    }
    
    private native String getLimit();
    
    private native String getOffset();
    
    private native void setLimit(String paramString);
    
    private native void setOffset(String paramString);
    
    public native Boolean getExact();
    
    public native JSONArray performAction(DatabaseSchema paramDatabaseSchema, ReadableDatabase paramReadableDatabase)
      throws Throwable;
    
    public native void setExact(Boolean paramBoolean);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\FindActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */