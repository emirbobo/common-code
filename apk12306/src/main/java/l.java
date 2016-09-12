import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.IAnIMTopicCallback;

final class l
  implements Runnable
{
  l(f paramf, String paramString1, String paramString2, String paramString3, IAnIMTopicCallback paramIAnIMTopicCallback) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.c(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMTopicCallback != null) {
        this.jdField_a_of_type_ComArrownockImCallbackIAnIMTopicCallback.onSuccess(this.b);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */