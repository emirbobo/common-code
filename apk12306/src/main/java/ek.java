import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.arrownock.push.PushService;

public final class ek
  implements Runnable
{
  public ek(PushService paramPushService) {}
  
  public final void run()
  {
    PowerManager.WakeLock localWakeLock = ((PowerManager)this.a.getSystemService("power")).newWakeLock(1, "anPush");
    localWakeLock.acquire();
    Log.d(PushService.LOGGER_TAG, "start to send keepAlive");
    ji localji = PushService.a();
    localji.a("keepalive", "keepalive/" + localji.a, "keepalive", false, 2);
    Log.d(PushService.LOGGER_TAG, "finish send keepAlive. releasing wakelock");
    localWakeLock.release();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */