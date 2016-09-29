package net.sqlcipher.database;

import android.content.res.AssetFileDescriptor;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

public class SQLiteContentHelper
{
  public static AssetFileDescriptor getBlobColumnAsAssetFile(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
    throws FileNotFoundException
  {
    Object localObject = null;
    try
    {
      paramString = simpleQueryForBlobMemoryFile(paramSQLiteDatabase, paramString, paramArrayOfString);
      if (paramString == null)
      {
        paramSQLiteDatabase = new java/io/FileNotFoundException;
        paramSQLiteDatabase.<init>("No results.");
        throw paramSQLiteDatabase;
      }
    }
    catch (IOException paramSQLiteDatabase)
    {
      throw new FileNotFoundException(paramSQLiteDatabase.toString());
    }
    paramSQLiteDatabase = paramString.getClass();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.getDeclaredMethod("getParcelFileDescriptor", new Class[0]);
      paramSQLiteDatabase.setAccessible(true);
      paramSQLiteDatabase = (ParcelFileDescriptor)paramSQLiteDatabase.invoke(paramString, new Object[0]);
      return new AssetFileDescriptor(paramSQLiteDatabase, 0L, paramString.length());
    }
    catch (Exception paramArrayOfString)
    {
      for (;;)
      {
        paramSQLiteDatabase = new java/lang/StringBuilder;
        paramSQLiteDatabase.<init>();
        Log.i("SQLiteContentHelper", "SQLiteCursor.java: " + paramArrayOfString);
        paramSQLiteDatabase = (SQLiteDatabase)localObject;
      }
    }
  }
  
  /* Error */
  private static MemoryFile simpleQueryForBlobMemoryFile(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: aload_1
    //   8: aload_2
    //   9: invokevirtual 93	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnonnull +8 -> 22
    //   17: aload 5
    //   19: astore_0
    //   20: aload_0
    //   21: areturn
    //   22: aload_1
    //   23: invokeinterface 99 1 0
    //   28: istore_3
    //   29: iload_3
    //   30: ifne +15 -> 45
    //   33: aload 4
    //   35: astore_0
    //   36: aload_1
    //   37: invokeinterface 102 1 0
    //   42: goto -22 -> 20
    //   45: aload_1
    //   46: iconst_0
    //   47: invokeinterface 106 2 0
    //   52: astore_2
    //   53: aload 4
    //   55: astore_0
    //   56: aload_2
    //   57: ifnull -21 -> 36
    //   60: new 58	android/os/MemoryFile
    //   63: astore_0
    //   64: aload_0
    //   65: aconst_null
    //   66: aload_2
    //   67: arraylength
    //   68: invokespecial 109	android/os/MemoryFile:<init>	(Ljava/lang/String;I)V
    //   71: aload_0
    //   72: aload_2
    //   73: iconst_0
    //   74: iconst_0
    //   75: aload_2
    //   76: arraylength
    //   77: invokevirtual 113	android/os/MemoryFile:writeBytes	([BIII)V
    //   80: goto -44 -> 36
    //   83: astore_0
    //   84: aload_1
    //   85: invokeinterface 102 1 0
    //   90: aload_0
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	92	1	paramString	String
    //   0	92	2	paramArrayOfString	String[]
    //   28	2	3	bool	boolean
    //   1	53	4	localObject1	Object
    //   4	14	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   22	29	83	finally
    //   45	53	83	finally
    //   60	80	83	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteContentHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */