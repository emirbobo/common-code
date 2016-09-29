import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;

final class dt
  implements Runnable
{
  dt(df paramdf, String paramString1, String paramString2, IAnPushCallback paramIAnPushCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.b, true);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setMute(false, null);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
          this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setMute(true, localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */