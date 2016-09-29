import com.arrownock.exception.ArrownockException;
import com.arrownock.push.AnPush;
import com.arrownock.push.AnPushStatus;
import com.arrownock.push.IAnPushCallback;
import com.arrownock.push.IAnPushRegisterAnIdCallback;
import com.xiaomi.mipush.sdk.MiPushClient;

public final class dd
  implements IAnPushRegisterAnIdCallback
{
  public dd(AnPush paramAnPush) {}
  
  public final void onError(ArrownockException paramArrownockException, int paramInt, String paramString)
  {
    if (paramInt >= 5)
    {
      bk.a().d(AnPush.a(), "registerInEnable failed. reason: over limit");
      if (this.a.getCallback() != null) {
        this.a.getCallback().statusChanged(AnPushStatus.DISABLE, new ArrownockException("registerInEnable failed.", 2003));
      }
    }
    for (;;)
    {
      return;
      AnPush.a(this.a).a(AnPush.a(this.a), AnPush.a(this.a), paramString, paramInt + 1, AnPush.b(this.a), this);
    }
  }
  
  public final void onSuccess()
  {
    bk.a().a(AnPush.a(), "registerInEnable successful in android-mipush");
    MiPushClient.resumePush(AnPush.a(this.a), null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */