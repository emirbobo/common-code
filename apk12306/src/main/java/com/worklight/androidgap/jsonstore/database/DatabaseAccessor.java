package com.worklight.androidgap.jsonstore.database;

import net.sqlcipher.database.SQLiteDatabase;

public abstract interface DatabaseAccessor
{
  public abstract SQLiteDatabase getRawDatabase();
  
  public abstract ReadableDatabase getReadableDatabase();
  
  public abstract DatabaseSchema getSchema();
  
  public abstract WritableDatabase getWritableDatabase();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\jsonstore\database\DatabaseAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */