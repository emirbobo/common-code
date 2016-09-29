import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.IAnIMTopicCallback;

final class am
  implements Runnable
{
  am(f paramf, String paramString1, String paramString2, IAnIMTopicCallback paramIAnIMTopicCallback) {}
  
  public final void run()
  {
    try
    {
      String str = this.jdField_a_of_type_F.b(this.jdField_a_of_type_JavaLangString, this.b);
      if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMTopicCallback != null) {
        this.jdField_a_of_type_ComArrownockImCallbackIAnIMTopicCallback.onSuccess(str);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMTopicCallback != null) {
          this.jdField_a_of_type_ComArrownockImCallbackIAnIMTopicCallback.onError(localArrownockException);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */