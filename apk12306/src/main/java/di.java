import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushSettingsCallback;

final class di
  implements Runnable
{
  di(df paramdf, String paramString1, String paramString2, IAnPushSettingsCallback paramIAnPushSettingsCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.b, false);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushSettingsCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushSettingsCallback.onSuccess();
      }
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */