package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;
import java.util.LinkedList;
import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StoreActionDispatcher
  extends DatabaseActionDispatcher
{
  private static final String OPTION_ADD_INDEXES = "additionalSearchFields";
  private static final String OPTION_IS_ADD = "isAdd";
  private static final String OPTION_IS_ARRAY = "isArray";
  private static final String PARAM_DATA = "data";
  private static final String PARAM_OPTIONS = "options";
  
  static
  {
    JniLib.a(StoreActionDispatcher.class, 1240);
  }
  
  protected StoreActionDispatcher()
  {
    super("store");
    addParameter("data", true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.ARRAY, BaseActionDispatcher.ParameterType.OBJECT });
    addParameter("options", false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  private native Object getData(DatabaseActionDispatcher.Context paramContext);
  
  private native JSONObject getOptions(DatabaseActionDispatcher.Context paramContext);
  
  public native PluginResult dispatch(DatabaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  private class StoreAction
    implements DatabaseActionDispatcher.WritableDatabaseAction<Integer>
  {
    private JSONObject addIndexes;
    private boolean isAdd;
    private LinkedList<JSONObject> objs;
    
    static
    {
      JniLib.a(StoreAction.class, 1239);
    }
    
    private StoreAction(JSONArray paramJSONArray, boolean paramBoolean, JSONObject paramJSONObject)
      throws JSONException
    {
      this(paramBoolean, paramJSONObject);
      int j = paramJSONArray.length();
      for (int i = 0; i < j; i++) {
        this.objs.add(paramJSONArray.getJSONObject(i));
      }
    }
    
    private StoreAction(JSONObject paramJSONObject1, boolean paramBoolean, JSONObject paramJSONObject2)
    {
      this(paramBoolean, paramJSONObject2);
      this.objs.add(paramJSONObject1);
    }
    
    private StoreAction(boolean paramBoolean, JSONObject paramJSONObject)
    {
      this.addIndexes = paramJSONObject;
      this.isAdd = paramBoolean;
      this.objs = new LinkedList();
    }
    
    public native Integer performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
      throws Throwable;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\StoreActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */