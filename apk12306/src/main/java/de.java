import android.content.Context;
import android.content.SharedPreferences;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.AnPush;
import com.arrownock.push.AnPushStatus;
import com.arrownock.push.IAnPushCallback;
import com.arrownock.push.IAnPushRegisterAnIdCallback;
import com.arrownock.push.PushService;

public final class de
  implements IAnPushRegisterAnIdCallback
{
  public de(AnPush paramAnPush, boolean paramBoolean) {}
  
  public final void onError(ArrownockException paramArrownockException, int paramInt, String paramString)
  {
    if (paramInt >= 5)
    {
      bk.a().d(AnPush.a(), "registerInEnable failed. reason: over limit");
      if (this.jdField_a_of_type_ComArrownockPushAnPush.getCallback() != null) {
        this.jdField_a_of_type_ComArrownockPushAnPush.getCallback().statusChanged(AnPushStatus.DISABLE, new ArrownockException("registerInEnable failed.", 2002));
      }
    }
    for (;;)
    {
      return;
      AnPush.a(this.jdField_a_of_type_ComArrownockPushAnPush).a(AnPush.a(this.jdField_a_of_type_ComArrownockPushAnPush), AnPush.a(this.jdField_a_of_type_ComArrownockPushAnPush), paramString, paramInt + 1, AnPush.b(this.jdField_a_of_type_ComArrownockPushAnPush), this);
    }
  }
  
  public final void onSuccess()
  {
    bk.a().a(AnPush.a(), "registerInEnable successful in android-arrownock");
    String str = AnPush.a(this.jdField_a_of_type_ComArrownockPushAnPush).getSharedPreferences(PushService.LOG_TAG, 0).getString("deviceToken", null);
    if (((str == null) || ("".equals(str.trim()))) && (this.jdField_a_of_type_ComArrownockPushAnPush.getCallback() != null)) {
      this.jdField_a_of_type_ComArrownockPushAnPush.getCallback().statusChanged(AnPushStatus.DISABLE, new ArrownockException("Device is not registered yet", 2002));
    }
    bk.a().a("Call push service start");
    if (this.jdField_a_of_type_Boolean)
    {
      PushService.actionStartNotificationFetcher(AnPush.a(this.jdField_a_of_type_ComArrownockPushAnPush));
      PushService.actionStartCommandFetcher(AnPush.a(this.jdField_a_of_type_ComArrownockPushAnPush));
    }
    for (;;)
    {
      return;
      PushService.actionStart(AnPush.a(this.jdField_a_of_type_ComArrownockPushAnPush));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */