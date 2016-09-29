import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;
import com.arrownock.push.PushService;

final class dl
  implements Runnable
{
  dl(df paramdf, String paramString1, String paramString2, IAnPushCallback paramIAnPushCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.b);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.clearSilentPeriod(false, null);
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
        if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
          this.jdField_a_of_type_ComArrownockPushIAnPushCallback.clearSilentPeriod(true, localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */