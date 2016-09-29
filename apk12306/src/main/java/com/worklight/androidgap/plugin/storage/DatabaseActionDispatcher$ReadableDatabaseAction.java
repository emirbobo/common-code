package com.worklight.androidgap.plugin.storage;

import com.worklight.androidgap.jsonstore.database.DatabaseSchema;
import com.worklight.androidgap.jsonstore.database.ReadableDatabase;

public abstract interface DatabaseActionDispatcher$ReadableDatabaseAction<T>
{
  public abstract T performAction(DatabaseSchema paramDatabaseSchema, ReadableDatabase paramReadableDatabase)
    throws Throwable;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\storage\DatabaseActionDispatcher$ReadableDatabaseAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */