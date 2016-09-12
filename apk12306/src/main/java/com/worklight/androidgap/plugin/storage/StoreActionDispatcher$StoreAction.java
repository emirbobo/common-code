package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class StoreActionDispatcher$StoreAction
  implements DatabaseActionDispatcher.WritableDatabaseAction<Integer>
{
  private JSONObject addIndexes;
  private boolean isAdd;
  private LinkedList<JSONObject> objs;
  
  static
  {
    JniLib.a(StoreAction.class, 1239);
  }
  
  private StoreActionDispatcher$StoreAction(StoreActionDispatcher paramStoreActionDispatcher, JSONArray paramJSONArray, boolean paramBoolean, JSONObject paramJSONObject)
    throws JSONException
  {
    this(paramStoreActionDispatcher, paramBoolean, paramJSONObject);
    int j = paramJSONArray.length();
    for (int i = 0; i < j; i++) {
      this.objs.add(paramJSONArray.getJSONObject(i));
    }
  }
  
  private StoreActionDispatcher$StoreAction(StoreActionDispatcher paramStoreActionDispatcher, JSONObject paramJSONObject1, boolean paramBoolean, JSONObject paramJSONObject2)
  {
    this(paramStoreActionDispatcher, paramBoolean, paramJSONObject2);
    this.objs.add(paramJSONObject1);
  }
  
  private StoreActionDispatcher$StoreAction(StoreActionDispatcher paramStoreActionDispatcher, boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.addIndexes = paramJSONObject;
    this.isAdd = paramBoolean;
    this.objs = new LinkedList();
  }
  
  public native Integer performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\StoreActionDispatcher$StoreAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */