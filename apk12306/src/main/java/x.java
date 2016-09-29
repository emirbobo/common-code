import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.IAnIMHistoryCallback;

final class x
  implements Runnable
{
  x(f paramf, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, boolean paramBoolean, IAnIMHistoryCallback paramIAnIMHistoryCallback) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.b(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComArrownockImCallbackIAnIMHistoryCallback);
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMHistoryCallback != null) {
          this.jdField_a_of_type_ComArrownockImCallbackIAnIMHistoryCallback.onError(localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */