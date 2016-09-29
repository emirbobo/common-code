import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.IAnIMGetClientIdCallback;

final class r
  implements Runnable
{
  r(f paramf, String paramString1, String paramString2, IAnIMGetClientIdCallback paramIAnIMGetClientIdCallback) {}
  
  public final void run()
  {
    try
    {
      String str = this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b);
      if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetClientIdCallback != null) {
        this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetClientIdCallback.onSuccess(str);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetClientIdCallback != null) {
          this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetClientIdCallback.onError(localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */