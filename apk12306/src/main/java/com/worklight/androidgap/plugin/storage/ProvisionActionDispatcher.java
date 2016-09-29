package com.worklight.androidgap.plugin.storage;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import org.apache.cordova.api.PluginResult;
import org.json.JSONObject;

public class ProvisionActionDispatcher
  extends BaseActionDispatcher
{
  private static final String OPTION_ADD_INDEXES = "additionalSearchFields";
  private static final String OPTION_DROP_COLLECTION = "dropCollection";
  private static final String OPTION_FIPS_ENABLED = "fipsEnabled";
  private static final String OPTION_PASSWORD = "collectionPassword";
  private static final String OPTION_USERNAME = "username";
  private static final String PARAM_DBNAME = "dbName";
  private static final String PARAM_OPTIONS = "options";
  private static final String PARAM_SCHEMA = "schema";
  
  static
  {
    JniLib.a(ProvisionActionDispatcher.class, 1233);
  }
  
  protected ProvisionActionDispatcher()
  {
    super("provision");
    addParameter("dbName", true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.STRING });
    addParameter("schema", true, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
    addParameter("options", true, false, new BaseActionDispatcher.ParameterType[] { BaseActionDispatcher.ParameterType.OBJECT });
  }
  
  private native void checkVersionMigration(Context paramContext)
    throws Throwable;
  
  private native String getDatabaseName(BaseActionDispatcher.Context paramContext);
  
  private native JSONObject getOptions(BaseActionDispatcher.Context paramContext);
  
  private native JSONObject getSchema(BaseActionDispatcher.Context paramContext, JSONObject paramJSONObject)
    throws Throwable;
  
  private native boolean isSchemaMismatched(String paramString, DatabaseSchema paramDatabaseSchema, BaseActionDispatcher.Context paramContext);
  
  public native PluginResult dispatch(BaseActionDispatcher.Context paramContext)
    throws Throwable;
  
  class CloseAllException
    extends Exception
  {
    private static final long serialVersionUID = 1L;
    
    public CloseAllException() {}
    
    public CloseAllException(String paramString)
    {
      super();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\ProvisionActionDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */