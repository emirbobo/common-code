import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushSettingsCallback;

final class dw
  implements Runnable
{
  dw(df paramdf, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, IAnPushSettingsCallback paramIAnPushSettingsCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */