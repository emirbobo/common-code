import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushSettingsCallback;
import com.arrownock.push.PushService;

final class dm
  implements Runnable
{
  dm(df paramdf, String paramString1, String paramString2, IAnPushSettingsCallback paramIAnPushSettingsCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.b);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushSettingsCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushSettingsCallback.onSuccess();
      }
      SharedPreferences.Editor localEditor = df.a(this.jdField_a_of_type_Df).getSharedPreferences(PushService.LOG_TAG, 0).edit();
      localEditor.remove("pushScheduledHour");
      localEditor.remove("pushScheduledMinue");
      localEditor.remove("pushScheduledDuration");
      localEditor.commit();
      df.a(this.jdField_a_of_type_Df);
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockPushIAnPushSettingsCallback != null) {
          this.jdField_a_of_type_ComArrownockPushIAnPushSettingsCallback.onError(localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */