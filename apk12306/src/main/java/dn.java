import com.arrownock.exception.ArrownockException;
import com.arrownock.push.IAnPushCallback;

final class dn
  implements Runnable
{
  dn(df paramdf, String paramString1, String paramString2, int paramInt, IAnPushCallback paramIAnPushCallback) {}
  
  public final void run()
  {
    try
    {
      df.a(this.jdField_a_of_type_Df, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
        this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setBadge(false, null);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockPushIAnPushCallback != null) {
          this.jdField_a_of_type_ComArrownockPushIAnPushCallback.setBadge(true, localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\dn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */