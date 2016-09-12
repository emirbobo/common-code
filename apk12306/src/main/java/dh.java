import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;

final class dh
  implements Runnable
{
  dh(df paramdf, String paramString1, String paramString2, IAnPushCallback paramIAnPushCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.b, false);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.clearMute(false, null);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
          this.jdField_a_of_type_ComArrownockPushIAnPushCallback.clearMute(true, localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */