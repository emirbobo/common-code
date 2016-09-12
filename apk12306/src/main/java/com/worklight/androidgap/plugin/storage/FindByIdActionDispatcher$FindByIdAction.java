package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;
import org.json.JSONArray;

class FindByIdActionDispatcher$FindByIdAction
  implements DatabaseActionDispatcher.ReadableDatabaseAction<JSONArray>
{
  private JSONArray ids;
  
  static
  {
    JniLib.a(FindByIdAction.class, 1226);
  }
  
  private FindByIdActionDispatcher$FindByIdAction(FindByIdActionDispatcher paramFindByIdActionDispatcher, JSONArray paramJSONArray)
  {
    this.ids = paramJSONArray;
  }
  
  public native JSONArray performAction(DatabaseSchema paramDatabaseSchema, ReadableDatabase paramReadableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\FindByIdActionDispatcher$FindByIdAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */