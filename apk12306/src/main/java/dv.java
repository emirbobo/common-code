import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;

final class dv
  implements Runnable
{
  dv(df paramdf, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, IAnPushCallback paramIAnPushCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setScheduledMute(false, null);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
          this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setScheduledMute(true, localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */