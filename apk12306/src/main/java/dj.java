import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;
import com.arrownock.push.PushService;

final class dj
  implements Runnable
{
  dj(df paramdf, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, IAnPushCallback paramIAnPushCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setSilentPeriod(false, null);
      }
      SharedPreferences.Editor localEditor = df.a(this.jdField_a_of_type_Df).getSharedPreferences(PushService.LOG_TAG, 0).edit();
      localEditor.putInt("pushScheduledHour", this.jdField_a_of_type_Int);
      localEditor.putInt("pushScheduledMinue", this.jdField_b_of_type_Int);
      localEditor.putLong("pushScheduledDuration", this.c * 60 * 1000);
      localEditor.commit();
      this.jdField_a_of_type_Df.a();
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
          this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setSilentPeriod(true, localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */