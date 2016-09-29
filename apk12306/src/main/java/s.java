import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.IAnIMPushBindingCallback;

final class s
  implements Runnable
{
  s(f paramf, String paramString1, String paramString2, IAnIMPushBindingCallback paramIAnIMPushBindingCallback) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b, null, null, null, false);
      if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMPushBindingCallback != null) {
        this.jdField_a_of_type_ComArrownockImCallbackIAnIMPushBindingCallback.onSuccess();
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMPushBindingCallback != null) {
          this.jdField_a_of_type_ComArrownockImCallbackIAnIMPushBindingCallback.onError(localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */