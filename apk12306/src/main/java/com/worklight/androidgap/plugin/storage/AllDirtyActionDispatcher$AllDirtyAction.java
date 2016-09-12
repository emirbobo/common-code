package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;
import java.util.List;
import org.json.JSONObject;

class AllDirtyActionDispatcher$AllDirtyAction
  implements DatabaseActionDispatcher.ReadableDatabaseAction<List<JSONObject>>
{
  private DatabaseActionDispatcher.Context context;
  
  static
  {
    JniLib.a(AllDirtyAction.class, 1211);
  }
  
  private AllDirtyActionDispatcher$AllDirtyAction(AllDirtyActionDispatcher paramAllDirtyActionDispatcher, DatabaseActionDispatcher.Context paramContext)
  {
    this.context = paramContext;
  }
  
  public native List<JSONObject> performAction(DatabaseSchema paramDatabaseSchema, ReadableDatabase paramReadableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\AllDirtyActionDispatcher$AllDirtyAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */