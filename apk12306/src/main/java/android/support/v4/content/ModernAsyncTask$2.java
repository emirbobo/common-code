package android.support.v4.content;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class ModernAsyncTask$2
  extends ModernAsyncTask.WorkerRunnable<Params, Result>
{
  ModernAsyncTask$2(ModernAsyncTask paramModernAsyncTask)
  {
    super(null);
  }
  
  public Result call()
    throws Exception
  {
    ModernAsyncTask.access$200(this.this$0).set(true);
    Process.setThreadPriority(10);
    return (Result)ModernAsyncTask.access$300(this.this$0, this.this$0.doInBackground(this.mParams));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\android\support\v4\content\ModernAsyncTask$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */