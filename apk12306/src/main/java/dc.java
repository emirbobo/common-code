import com.arrownock.exception.ArrownockException;
import com.arrownock.push.AnPush;
import com.arrownock.push.AnPushStatus;
import com.arrownock.push.IAnPushCallback;
import com.arrownock.push.IAnPushRegisterAnIdCallback;

public final class dc
  implements IAnPushRegisterAnIdCallback
{
  public dc(AnPush paramAnPush) {}
  
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
    bk.a().a(AnPush.a(), "registerInEnable successful in android-gcm");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */