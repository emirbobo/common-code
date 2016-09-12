package cn.domob.wall.core.download;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.Callable;

class k$b
  implements Callable<String>
{
  private String b;
  private Handler c;
  
  public k$b(k paramk, Handler paramHandler, String paramString)
  {
    this.b = paramString;
    this.c = paramHandler;
  }
  
  public String a()
    throws Exception
  {
    Message localMessage = new Message();
    localMessage.obj = k.a(this.a, this.b);
    this.c.sendMessage(localMessage);
    return this.b;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\k$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */