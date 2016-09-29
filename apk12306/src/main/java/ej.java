import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arrownock.push.PushService;

public final class ej
  extends BroadcastReceiver
{
  public ej(PushService paramPushService) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    PushService.a(this.a);
    PushService.b(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ej.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */