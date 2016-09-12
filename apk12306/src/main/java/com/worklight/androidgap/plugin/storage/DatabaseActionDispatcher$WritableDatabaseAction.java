package com.worklight.androidgap.plugin.storage;

import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.WritableDatabase;

public abstract interface DatabaseActionDispatcher$WritableDatabaseAction<T>
{
  public abstract T performAction(DatabaseSchema paramDatabaseSchema, WritableDatabase paramWritableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DatabaseActionDispatcher$WritableDatabaseAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */