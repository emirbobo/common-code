package net.sqlcipher.database;

class SQLiteDatabase$SyncUpdateInfo
{
  String deletedTable;
  String foreignKey;
  String masterTable;
  
  SQLiteDatabase$SyncUpdateInfo(String paramString1, String paramString2, String paramString3)
  {
    this.masterTable = paramString1;
    this.deletedTable = paramString2;
    this.foreignKey = paramString3;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteDatabase$SyncUpdateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */