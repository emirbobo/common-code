package com.worklight.androidgap.plugin.storage;

import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;

class MarkCleanActionDispatcher$MarkCleanAction
  implements DatabaseActionDispatcher.WritableDatabaseAction<Integer>
{
  private int id;
  private String operation;
  
  static
  {
    JniLib.a(MarkCleanAction.class, 1231);
  }
  
  private MarkCleanActionDispatcher$MarkCleanAction(MarkCleanActionDispatcher paramMarkCleanActionDispatcher, int paramInt, String paramString)
  {
    this.id = paramInt;
    this.operation = paramString;
  }
  
  public native Integer performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\MarkCleanActionDispatcher$MarkCleanAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */