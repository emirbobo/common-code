package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.HashMap;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;
import org.apache.commons.codec.binary.Hex;

public class DatabaseUtils
{
  private static final boolean DEBUG = false;
  private static final boolean LOCAL_LOGV = false;
  private static final String TAG = "DatabaseUtils";
  private static final String[] countProjection = { "count(*)" };
  private static Collator mColl = null;
  
  public static void appendEscapedSQLString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int j = paramString.length();
      for (int i = 0; i < j; i++)
      {
        char c = paramString.charAt(i);
        if (c == '\'') {
          paramStringBuilder.append('\'');
        }
        paramStringBuilder.append(c);
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }
  
  public static final void appendValueToSql(StringBuilder paramStringBuilder, Object paramObject)
  {
    if (paramObject == null) {
      paramStringBuilder.append("NULL");
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {
          paramStringBuilder.append('1');
        } else {
          paramStringBuilder.append('0');
        }
      }
      else {
        appendEscapedSQLString(paramStringBuilder, paramObject.toString());
      }
    }
  }
  
  public static void bindObjectToProgram(SQLiteProgram paramSQLiteProgram, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      paramSQLiteProgram.bindNull(paramInt);
    }
    for (;;)
    {
      return;
      if (((paramObject instanceof Double)) || ((paramObject instanceof Float))) {
        paramSQLiteProgram.bindDouble(paramInt, ((Number)paramObject).doubleValue());
      } else if ((paramObject instanceof Number)) {
        paramSQLiteProgram.bindLong(paramInt, ((Number)paramObject).longValue());
      } else if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue()) {
          paramSQLiteProgram.bindLong(paramInt, 1L);
        } else {
          paramSQLiteProgram.bindLong(paramInt, 0L);
        }
      }
      else if ((paramObject instanceof byte[])) {
        paramSQLiteProgram.bindBlob(paramInt, (byte[])paramObject);
      } else {
        paramSQLiteProgram.bindString(paramInt, paramObject.toString());
      }
    }
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString2 = paramString1;
      } else {
        paramString2 = "(" + paramString1 + ") AND (" + paramString2 + ")";
      }
    }
  }
  
  public static void cursorDoubleToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString2, Double.valueOf(paramCursor.getDouble(i)));
    }
    for (;;)
    {
      return;
      paramContentValues.put(paramString2, (Double)null);
    }
  }
  
  public static void cursorDoubleToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Double.valueOf(paramCursor.getDouble(i)));
    }
  }
  
  public static void cursorDoubleToCursorValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorDoubleToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorFloatToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Float.valueOf(paramCursor.getFloat(i)));
    }
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorIntToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString2, Integer.valueOf(paramCursor.getInt(i)));
    }
    for (;;)
    {
      return;
      paramContentValues.put(paramString2, (Integer)null);
    }
  }
  
  public static void cursorIntToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Integer.valueOf(paramCursor.getInt(i)));
    }
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorLongToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString2, Long.valueOf(paramCursor.getLong(i)));
    }
    for (;;)
    {
      return;
      paramContentValues.put(paramString2, (Long)null);
    }
  }
  
  public static void cursorLongToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(i)));
    }
  }
  
  public static void cursorRowToContentValues(Cursor paramCursor, ContentValues paramContentValues)
  {
    AbstractWindowedCursor localAbstractWindowedCursor;
    String[] arrayOfString;
    int i;
    if ((paramCursor instanceof AbstractWindowedCursor))
    {
      localAbstractWindowedCursor = (AbstractWindowedCursor)paramCursor;
      arrayOfString = paramCursor.getColumnNames();
      int j = arrayOfString.length;
      i = 0;
      label27:
      if (i >= j) {
        return;
      }
      if ((localAbstractWindowedCursor == null) || (!localAbstractWindowedCursor.isBlob(i))) {
        break label73;
      }
      paramContentValues.put(arrayOfString[i], paramCursor.getBlob(i));
    }
    for (;;)
    {
      i++;
      break label27;
      localAbstractWindowedCursor = null;
      break;
      label73:
      paramContentValues.put(arrayOfString[i], paramCursor.getString(i));
    }
  }
  
  public static void cursorShortToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Short.valueOf(paramCursor.getShort(i)));
    }
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorStringToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    paramContentValues.put(paramString2, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString1)));
  }
  
  public static void cursorStringToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, paramCursor.getString(i));
    }
  }
  
  public static void cursorStringToInsertHelper(Cursor paramCursor, String paramString, InsertHelper paramInsertHelper, int paramInt)
  {
    paramInsertHelper.bind(paramInt, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString)));
  }
  
  public static void dumpCurrentRow(Cursor paramCursor)
  {
    dumpCurrentRow(paramCursor, System.out);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, PrintStream paramPrintStream)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    paramPrintStream.println("" + paramCursor.getPosition() + " {");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          String str1 = paramCursor.getString(i);
          paramPrintStream.println("   " + arrayOfString[i] + '=' + str1);
          i++;
        }
        catch (SQLiteException localSQLiteException)
        {
          for (;;)
          {
            String str2 = "<unprintable>";
          }
        }
      }
    }
    paramPrintStream.println("}");
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    paramStringBuilder.append("" + paramCursor.getPosition() + " {\n");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          String str1 = paramCursor.getString(i);
          paramStringBuilder.append("   " + arrayOfString[i] + '=' + str1 + "\n");
          i++;
        }
        catch (SQLiteException localSQLiteException)
        {
          for (;;)
          {
            String str2 = "<unprintable>";
          }
        }
      }
    }
    paramStringBuilder.append("}\n");
  }
  
  public static String dumpCurrentRowToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCurrentRow(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static void dumpCursor(Cursor paramCursor)
  {
    dumpCursor(paramCursor, System.out);
  }
  
  public static void dumpCursor(Cursor paramCursor, PrintStream paramPrintStream)
  {
    paramPrintStream.println(">>>>> Dumping cursor " + paramCursor);
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramPrintStream);
      }
      paramCursor.moveToPosition(i);
    }
    paramPrintStream.println("<<<<<");
  }
  
  public static void dumpCursor(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(">>>>> Dumping cursor " + paramCursor + "\n");
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramStringBuilder);
      }
      paramCursor.moveToPosition(i);
    }
    paramStringBuilder.append("<<<<<\n");
  }
  
  public static String dumpCursorToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCursor(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static String getCollationKey(String paramString)
  {
    byte[] arrayOfByte = getCollationKeyInBytes(paramString);
    try
    {
      paramString = new java/lang/String;
      paramString.<init>(arrayOfByte, 0, getKeyLen(arrayOfByte), "ISO8859_1");
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "";
      }
    }
  }
  
  private static byte[] getCollationKeyInBytes(String paramString)
  {
    if (mColl == null)
    {
      mColl = Collator.getInstance();
      mColl.setStrength(0);
    }
    return mColl.getCollationKey(paramString).toByteArray();
  }
  
  public static String getHexCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    return new String(Hex.encodeHex(paramString), 0, getKeyLen(paramString) * 2);
  }
  
  private static int getKeyLen(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 0) {}
    for (int i = paramArrayOfByte.length;; i = paramArrayOfByte.length - 1) {
      return i;
    }
  }
  
  public static long longForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      long l = longForQuery(paramSQLiteDatabase, paramArrayOfString);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static long longForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++) {
        bindObjectToProgram(paramSQLiteStatement, i + 1, paramArrayOfString[i]);
      }
    }
    return paramSQLiteStatement.simpleQueryForLong();
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramString = paramSQLiteDatabase.query(paramString, countProjection, null, null, null, null, null);
    try
    {
      paramString.moveToFirst();
      long l = paramString.getLong(0);
      return l;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static final void readExceptionFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == 0) {}
    for (;;)
    {
      return;
      readExceptionFromParcel(paramParcel, paramParcel.readString(), i);
    }
  }
  
  private static final void readExceptionFromParcel(Parcel paramParcel, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramParcel.readException(paramInt, paramString);
      return;
    case 2: 
      throw new IllegalArgumentException(paramString);
    case 3: 
      throw new UnsupportedOperationException(paramString);
    case 4: 
      throw new SQLiteAbortException(paramString);
    case 5: 
      throw new SQLiteConstraintException(paramString);
    case 6: 
      throw new SQLiteDatabaseCorruptException(paramString);
    case 7: 
      throw new SQLiteFullException(paramString);
    case 8: 
      throw new SQLiteDiskIOException(paramString);
    }
    throw new SQLiteException(paramString);
  }
  
  public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel paramParcel)
    throws FileNotFoundException
  {
    int i = paramParcel.readInt();
    if (i == 0) {}
    for (;;)
    {
      return;
      String str = paramParcel.readString();
      if (i == 1) {
        throw new FileNotFoundException(str);
      }
      readExceptionFromParcel(paramParcel, str, i);
    }
  }
  
  public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel paramParcel)
    throws OperationApplicationException
  {
    int i = paramParcel.readInt();
    if (i == 0) {}
    for (;;)
    {
      return;
      String str = paramParcel.readString();
      if (i == 10) {
        throw new OperationApplicationException(str);
      }
      readExceptionFromParcel(paramParcel, str, i);
    }
  }
  
  public static String sqlEscapeString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendEscapedSQLString(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public static String stringForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      paramString = stringForQuery(paramSQLiteDatabase, paramArrayOfString);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String stringForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      for (int i = 0; i < j; i++) {
        bindObjectToProgram(paramSQLiteStatement, i + 1, paramArrayOfString[i]);
      }
    }
    return paramSQLiteStatement.simpleQueryForString();
  }
  
  public static final void writeExceptionToParcel(Parcel paramParcel, Exception paramException)
  {
    int j = 1;
    int i;
    if ((paramException instanceof FileNotFoundException))
    {
      i = 1;
      j = 0;
      paramParcel.writeInt(i);
      paramParcel.writeString(paramException.getMessage());
      if (j != 0) {
        Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
      }
    }
    for (;;)
    {
      return;
      if ((paramException instanceof IllegalArgumentException))
      {
        i = 2;
        break;
      }
      if ((paramException instanceof UnsupportedOperationException))
      {
        i = 3;
        break;
      }
      if ((paramException instanceof SQLiteAbortException))
      {
        i = 4;
        break;
      }
      if ((paramException instanceof SQLiteConstraintException))
      {
        i = 5;
        break;
      }
      if ((paramException instanceof SQLiteDatabaseCorruptException))
      {
        i = 6;
        break;
      }
      if ((paramException instanceof SQLiteFullException))
      {
        i = 7;
        break;
      }
      if ((paramException instanceof SQLiteDiskIOException))
      {
        i = 8;
        break;
      }
      if ((paramException instanceof SQLiteException))
      {
        i = 9;
        break;
      }
      if ((paramException instanceof OperationApplicationException))
      {
        i = 10;
        break;
      }
      paramParcel.writeException(paramException);
      Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
    }
  }
  
  public static class InsertHelper
  {
    public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
    public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    private HashMap<String, Integer> mColumns;
    private final SQLiteDatabase mDb;
    private String mInsertSQL = null;
    private SQLiteStatement mInsertStatement = null;
    private SQLiteStatement mPreparedStatement = null;
    private SQLiteStatement mReplaceStatement = null;
    private final String mTableName;
    
    public InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      this.mDb = paramSQLiteDatabase;
      this.mTableName = paramString;
    }
    
    private void buildSQL()
      throws SQLException
    {
      StringBuilder localStringBuilder2 = new StringBuilder(128);
      localStringBuilder2.append("INSERT INTO ");
      localStringBuilder2.append(this.mTableName);
      localStringBuilder2.append(" (");
      StringBuilder localStringBuilder1 = new StringBuilder(128);
      localStringBuilder1.append("VALUES (");
      int i = 1;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      Object localObject4;
      for (;;)
      {
        try
        {
          Object localObject5 = this.mDb;
          localObject1 = localObject2;
          localObject4 = new java/lang/StringBuilder;
          localObject1 = localObject2;
          ((StringBuilder)localObject4).<init>();
          localObject1 = localObject2;
          localObject4 = ((SQLiteDatabase)localObject5).rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);
          localObject1 = localObject4;
          localObject2 = new java/util/HashMap;
          localObject1 = localObject4;
          ((HashMap)localObject2).<init>(((Cursor)localObject4).getCount());
          localObject1 = localObject4;
          this.mColumns = ((HashMap)localObject2);
          localObject1 = localObject4;
          if (!((Cursor)localObject4).moveToNext()) {
            break;
          }
          localObject1 = localObject4;
          localObject2 = ((Cursor)localObject4).getString(1);
          localObject1 = localObject4;
          localObject5 = ((Cursor)localObject4).getString(4);
          localObject1 = localObject4;
          this.mColumns.put(localObject2, Integer.valueOf(i));
          localObject1 = localObject4;
          localStringBuilder2.append("'");
          localObject1 = localObject4;
          localStringBuilder2.append((String)localObject2);
          localObject1 = localObject4;
          localStringBuilder2.append("'");
          if (localObject5 == null)
          {
            localObject1 = localObject4;
            localStringBuilder1.append("?");
            localObject1 = localObject4;
            if (i == ((Cursor)localObject4).getCount())
            {
              localObject2 = ") ";
              localObject1 = localObject4;
              localStringBuilder2.append((String)localObject2);
              localObject1 = localObject4;
              if (i != ((Cursor)localObject4).getCount()) {
                break label362;
              }
              localObject2 = ");";
              localObject1 = localObject4;
              localStringBuilder1.append((String)localObject2);
              i++;
            }
          }
          else
          {
            localObject1 = localObject4;
            localStringBuilder1.append("COALESCE(?, ");
            localObject1 = localObject4;
            localStringBuilder1.append((String)localObject5);
            localObject1 = localObject4;
            localStringBuilder1.append(")");
            continue;
          }
          str = ", ";
        }
        finally
        {
          if (localObject1 != null) {
            ((Cursor)localObject1).close();
          }
        }
        continue;
        label362:
        String str = ", ";
      }
      if (localObject4 != null) {
        ((Cursor)localObject4).close();
      }
      localStringBuilder2.append(localStringBuilder1);
      this.mInsertSQL = localStringBuilder2.toString();
    }
    
    private SQLiteStatement getStatement(boolean paramBoolean)
      throws SQLException
    {
      if (paramBoolean) {
        if (this.mReplaceStatement == null)
        {
          if (this.mInsertSQL == null) {
            buildSQL();
          }
          localObject = "INSERT OR REPLACE" + this.mInsertSQL.substring(6);
          this.mReplaceStatement = this.mDb.compileStatement((String)localObject);
        }
      }
      for (Object localObject = this.mReplaceStatement;; localObject = this.mInsertStatement)
      {
        return (SQLiteStatement)localObject;
        if (this.mInsertStatement == null)
        {
          if (this.mInsertSQL == null) {
            buildSQL();
          }
          this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
        }
      }
    }
    
    /* Error */
    private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: iload_2
      //   4: invokespecial 142	net/sqlcipher/DatabaseUtils$InsertHelper:getStatement	(Z)Lnet/sqlcipher/database/SQLiteStatement;
      //   7: astore 6
      //   9: aload 6
      //   11: invokevirtual 147	net/sqlcipher/database/SQLiteStatement:clearBindings	()V
      //   14: aload_1
      //   15: invokevirtual 153	android/content/ContentValues:valueSet	()Ljava/util/Set;
      //   18: invokeinterface 159 1 0
      //   23: astore 7
      //   25: aload 7
      //   27: invokeinterface 164 1 0
      //   32: ifeq +98 -> 130
      //   35: aload 7
      //   37: invokeinterface 168 1 0
      //   42: checkcast 170	java/util/Map$Entry
      //   45: astore 5
      //   47: aload 6
      //   49: aload_0
      //   50: aload 5
      //   52: invokeinterface 173 1 0
      //   57: checkcast 131	java/lang/String
      //   60: invokevirtual 177	net/sqlcipher/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
      //   63: aload 5
      //   65: invokeinterface 180 1 0
      //   70: invokestatic 184	net/sqlcipher/DatabaseUtils:bindObjectToProgram	(Lnet/sqlcipher/database/SQLiteProgram;ILjava/lang/Object;)V
      //   73: goto -48 -> 25
      //   76: astore 6
      //   78: new 47	java/lang/StringBuilder
      //   81: astore 5
      //   83: aload 5
      //   85: invokespecial 61	java/lang/StringBuilder:<init>	()V
      //   88: ldc -70
      //   90: aload 5
      //   92: ldc -68
      //   94: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: aload_1
      //   98: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   101: ldc -63
      //   103: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   106: aload_0
      //   107: getfield 41	net/sqlcipher/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   110: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   113: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   116: aload 6
      //   118: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   121: pop
      //   122: ldc2_w 200
      //   125: lstore_3
      //   126: aload_0
      //   127: monitorexit
      //   128: lload_3
      //   129: lreturn
      //   130: aload 6
      //   132: invokevirtual 205	net/sqlcipher/database/SQLiteStatement:executeInsert	()J
      //   135: lstore_3
      //   136: goto -10 -> 126
      //   139: astore_1
      //   140: aload_0
      //   141: monitorexit
      //   142: aload_1
      //   143: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	144	0	this	InsertHelper
      //   0	144	1	paramContentValues	ContentValues
      //   0	144	2	paramBoolean	boolean
      //   125	11	3	l	long
      //   45	46	5	localObject	Object
      //   7	41	6	localSQLiteStatement	SQLiteStatement
      //   76	55	6	localSQLException	SQLException
      //   23	13	7	localIterator	java.util.Iterator
      // Exception table:
      //   from	to	target	type
      //   2	25	76	net/sqlcipher/SQLException
      //   25	73	76	net/sqlcipher/SQLException
      //   130	136	76	net/sqlcipher/SQLException
      //   2	25	139	finally
      //   25	73	139	finally
      //   78	122	139	finally
      //   130	136	139	finally
    }
    
    public void bind(int paramInt, double paramDouble)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramDouble);
    }
    
    public void bind(int paramInt, float paramFloat)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramFloat);
    }
    
    public void bind(int paramInt1, int paramInt2)
    {
      this.mPreparedStatement.bindLong(paramInt1, paramInt2);
    }
    
    public void bind(int paramInt, long paramLong)
    {
      this.mPreparedStatement.bindLong(paramInt, paramLong);
    }
    
    public void bind(int paramInt, String paramString)
    {
      if (paramString == null) {
        this.mPreparedStatement.bindNull(paramInt);
      }
      for (;;)
      {
        return;
        this.mPreparedStatement.bindString(paramInt, paramString);
      }
    }
    
    public void bind(int paramInt, boolean paramBoolean)
    {
      SQLiteStatement localSQLiteStatement = this.mPreparedStatement;
      if (paramBoolean) {}
      for (long l = 1L;; l = 0L)
      {
        localSQLiteStatement.bindLong(paramInt, l);
        return;
      }
    }
    
    public void bind(int paramInt, byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte == null) {
        this.mPreparedStatement.bindNull(paramInt);
      }
      for (;;)
      {
        return;
        this.mPreparedStatement.bindBlob(paramInt, paramArrayOfByte);
      }
    }
    
    public void bindNull(int paramInt)
    {
      this.mPreparedStatement.bindNull(paramInt);
    }
    
    public void close()
    {
      if (this.mInsertStatement != null)
      {
        this.mInsertStatement.close();
        this.mInsertStatement = null;
      }
      if (this.mReplaceStatement != null)
      {
        this.mReplaceStatement.close();
        this.mReplaceStatement = null;
      }
      this.mInsertSQL = null;
      this.mColumns = null;
    }
    
    public long execute()
    {
      if (this.mPreparedStatement == null) {
        throw new IllegalStateException("you must prepare this inserter before calling execute");
      }
      try
      {
        l = this.mPreparedStatement.executeInsert();
        return l;
      }
      catch (SQLException localSQLException)
      {
        for (;;)
        {
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          Log.e("DatabaseUtils", "Error executing InsertHelper with table " + this.mTableName, localSQLException);
          long l = -1L;
        }
      }
      finally
      {
        this.mPreparedStatement = null;
      }
    }
    
    public int getColumnIndex(String paramString)
    {
      getStatement(false);
      Integer localInteger = (Integer)this.mColumns.get(paramString);
      if (localInteger == null) {
        throw new IllegalArgumentException("column '" + paramString + "' is invalid");
      }
      return localInteger.intValue();
    }
    
    public long insert(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, false);
    }
    
    public void prepareForInsert()
    {
      this.mPreparedStatement = getStatement(false);
      this.mPreparedStatement.clearBindings();
    }
    
    public void prepareForReplace()
    {
      this.mPreparedStatement = getStatement(true);
      this.mPreparedStatement.clearBindings();
    }
    
    public long replace(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, true);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\DatabaseUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */