package example;

import android.content.Context;
import android.util.Log;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;

public class EventDataSQLHelper
  extends SQLiteOpenHelper
{
  private static final String DATABASE_NAME = "events.db";
  private static final int DATABASE_VERSION = 1;
  public static final String TABLE = "events";
  public static final String TIME = "time";
  public static final String TITLE = "title";
  
  public EventDataSQLHelper(Context paramContext)
  {
    super(paramContext, "events.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.d("EventsData", "onCreate: " + "create table events( _id integer primary key autoincrement, time integer, title text not null);");
    paramSQLiteDatabase.execSQL("create table events( _id integer primary key autoincrement, time integer, title text not null);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= paramInt2) {}
    for (;;)
    {
      return;
      String str = null;
      if (paramInt1 == 1) {
        str = "alter table events add note text;";
      }
      if (paramInt1 == 2) {
        str = "";
      }
      Log.d("EventsData", "onUpgrade\t: " + str);
      if (str != null) {
        paramSQLiteDatabase.execSQL(str);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\example\EventDataSQLHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */