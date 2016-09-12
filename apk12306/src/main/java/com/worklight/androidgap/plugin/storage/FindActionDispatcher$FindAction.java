package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;
import org.json.JSONArray;
import org.json.JSONObject;

class FindActionDispatcher$FindAction
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
  
  private FindActionDispatcher$FindAction(FindActionDispatcher paramFindActionDispatcher, JSONObject paramJSONObject)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\FindActionDispatcher$FindAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */