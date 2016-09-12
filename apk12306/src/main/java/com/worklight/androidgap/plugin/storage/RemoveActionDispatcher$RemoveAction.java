package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class RemoveActionDispatcher$RemoveAction
  implements DatabaseActionDispatcher.WritableDatabaseAction<Object>
{
  private boolean exact;
  private boolean isErase;
  private LinkedList<JSONObject> objs;
  
  static
  {
    JniLib.a(RemoveAction.class, 1234);
  }
  
  private RemoveActionDispatcher$RemoveAction(RemoveActionDispatcher paramRemoveActionDispatcher, JSONArray paramJSONArray, boolean paramBoolean1, boolean paramBoolean2)
    throws JSONException
  {
    this(paramRemoveActionDispatcher, paramBoolean1, paramBoolean2);
    int j = paramJSONArray.length();
    for (int i = 0; i < j; i++) {
      this.objs.add(paramJSONArray.getJSONObject(i));
    }
  }
  
  private RemoveActionDispatcher$RemoveAction(RemoveActionDispatcher paramRemoveActionDispatcher, JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramRemoveActionDispatcher, paramBoolean1, paramBoolean2);
    this.objs.add(paramJSONObject);
  }
  
  private RemoveActionDispatcher$RemoveAction(RemoveActionDispatcher paramRemoveActionDispatcher, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.isErase = paramBoolean1;
    this.exact = paramBoolean2;
    this.objs = new LinkedList();
  }
  
  public native Object performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\RemoveActionDispatcher$RemoveAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */