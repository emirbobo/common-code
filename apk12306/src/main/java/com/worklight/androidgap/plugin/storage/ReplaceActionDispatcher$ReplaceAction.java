package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ReplaceActionDispatcher$ReplaceAction
  implements DatabaseActionDispatcher.WritableDatabaseAction<Object>
{
  private boolean isRefresh;
  private LinkedList<JSONObject> objs;
  
  static
  {
    JniLib.a(ReplaceAction.class, 1236);
  }
  
  private ReplaceActionDispatcher$ReplaceAction(ReplaceActionDispatcher paramReplaceActionDispatcher, JSONArray paramJSONArray, boolean paramBoolean)
    throws JSONException
  {
    this(paramReplaceActionDispatcher, paramBoolean);
    int j = paramJSONArray.length();
    for (int i = 0; i < j; i++) {
      this.objs.add(paramJSONArray.getJSONObject(i));
    }
  }
  
  private ReplaceActionDispatcher$ReplaceAction(ReplaceActionDispatcher paramReplaceActionDispatcher, JSONObject paramJSONObject, boolean paramBoolean)
  {
    this(paramReplaceActionDispatcher, paramBoolean);
    this.objs.add(paramJSONObject);
  }
  
  private ReplaceActionDispatcher$ReplaceAction(ReplaceActionDispatcher paramReplaceActionDispatcher, boolean paramBoolean)
  {
    this.isRefresh = paramBoolean;
    this.objs = new LinkedList();
  }
  
  public native Object performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\ReplaceActionDispatcher$ReplaceAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */