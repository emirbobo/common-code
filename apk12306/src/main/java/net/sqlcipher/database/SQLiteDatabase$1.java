package net.sqlcipher.database;

final class SQLiteDatabase$1
  implements SQLiteDatabaseHook
{
  public void postKey(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("PRAGMA cipher_default_use_hmac = on");
  }
  
  public void preKey(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("PRAGMA cipher_default_use_hmac = off");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteDatabase$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */