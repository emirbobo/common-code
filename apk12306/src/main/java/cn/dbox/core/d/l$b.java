package cn.dbox.core.d;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.Callable;

class l$b
  implements Callable<String>
{
  private String b;
  private Handler c;
  
  public l$b(l paraml, Handler paramHandler, String paramString)
  {
    this.b = paramString;
    this.c = paramHandler;
  }
  
  public String a()
    throws Exception
  {
    Message localMessage = new Message();
    localMessage.obj = l.a(this.a, this.b);
    this.c.sendMessage(localMessage);
    return this.b;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\l$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */