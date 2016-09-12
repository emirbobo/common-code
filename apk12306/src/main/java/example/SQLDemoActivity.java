package example;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import net.sqlcipher.database.SQLiteDatabase;

public class SQLDemoActivity
  extends Activity
{
  EventDataSQLHelper eventsData;
  
  private void addEvent(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("time", Long.valueOf(System.currentTimeMillis()));
    localContentValues.put("title", paramString);
    paramSQLiteDatabase.insert("events", null, localContentValues);
  }
  
  private Cursor getEvents(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query("events", null, null, null, null, null, null);
    startManagingCursor(paramSQLiteDatabase);
    return paramSQLiteDatabase;
  }
  
  private void showEvents(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder("Saved Events:\n\n");
    while (paramCursor.moveToNext())
    {
      long l2 = paramCursor.getLong(0);
      long l1 = paramCursor.getLong(1);
      String str = paramCursor.getString(2);
      localStringBuilder.append(l2 + ": " + l1 + ": " + str + "\n");
    }
    Log.i("sqldemo", localStringBuilder.toString());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SQLiteDatabase.loadLibs(this);
    this.eventsData = new EventDataSQLHelper(this);
    paramBundle = this.eventsData.getWritableDatabase("foo123");
    for (int i = 1; i < 100; i++) {
      addEvent("Hello Android Event: " + i, paramBundle);
    }
    paramBundle.close();
    paramBundle = this.eventsData.getReadableDatabase("foo123");
    showEvents(getEvents(paramBundle));
    paramBundle.close();
  }
  
  public void onDestroy()
  {
    this.eventsData.close();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\example\SQLDemoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */