package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;

class SimpleQueryActionDispatcher$SimpleQueryAction
  implements DatabaseActionDispatcher.ReadableDatabaseAction<Integer>
{
  private DatabaseActionDispatcher.Context context;
  
  static
  {
    JniLib.a(SimpleQueryAction.class, 1238);
  }
  
  private SimpleQueryActionDispatcher$SimpleQueryAction(SimpleQueryActionDispatcher paramSimpleQueryActionDispatcher, DatabaseActionDispatcher.Context paramContext)
  {
    this.context = paramContext;
  }
  
  public native Integer performAction(DatabaseSchema paramDatabaseSchema, ReadableDatabase paramReadableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\SimpleQueryActionDispatcher$SimpleQueryAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */