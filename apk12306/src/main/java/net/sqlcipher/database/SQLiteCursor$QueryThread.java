package net.sqlcipher.database;

import android.os.Process;
import java.util.concurrent.locks.ReentrantLock;
import net.sqlcipher.CursorWindow;

final class SQLiteCursor$QueryThread
  implements Runnable
{
  private final int mThreadState;
  
  SQLiteCursor$QueryThread(SQLiteCursor paramSQLiteCursor, int paramInt)
  {
    this.mThreadState = paramInt;
  }
  
  private void sendMessage()
  {
    if (this.this$0.mNotificationHandler != null)
    {
      this.this$0.mNotificationHandler.sendEmptyMessage(1);
      SQLiteCursor.access$002(this.this$0, false);
    }
    for (;;)
    {
      return;
      SQLiteCursor.access$002(this.this$0, true);
    }
  }
  
  public void run()
  {
    Object localObject1 = SQLiteCursor.access$100(this.this$0);
    Process.setThreadPriority(Process.myTid(), 10);
    SQLiteCursor.access$200(this.this$0).lock();
    if (SQLiteCursor.access$300(this.this$0) != this.mThreadState)
    {
      SQLiteCursor.access$200(this.this$0).unlock();
      label50:
      return;
    }
    for (;;)
    {
      try
      {
        int i = SQLiteCursor.access$600(this.this$0).fillWindow((CursorWindow)localObject1, SQLiteCursor.access$400(this.this$0), SQLiteCursor.access$500(this.this$0));
        if (i == 0) {
          break label171;
        }
        if (i == -1)
        {
          SQLiteCursor.access$512(this.this$0, SQLiteCursor.access$400(this.this$0));
          sendMessage();
          SQLiteCursor.access$200(this.this$0).unlock();
          break;
        }
        SQLiteCursor.access$502(this.this$0, i);
        sendMessage();
        localObject1 = SQLiteCursor.access$200(this.this$0);
      }
      catch (Exception localException)
      {
        ReentrantLock localReentrantLock1 = SQLiteCursor.access$200(this.this$0);
        continue;
      }
      finally
      {
        SQLiteCursor.access$200(this.this$0).unlock();
      }
      ((ReentrantLock)localObject1).unlock();
      break label50;
      label171:
      ReentrantLock localReentrantLock2 = SQLiteCursor.access$200(this.this$0);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\SQLiteCursor$QueryThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */