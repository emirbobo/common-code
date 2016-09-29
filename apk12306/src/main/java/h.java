import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.IAnIMTopicCallback;

final class h
  implements Runnable
{
  h(f paramf, String paramString1, String paramString2, String paramString3, String paramString4, IAnIMTopicCallback paramIAnIMTopicCallback) {}
  
  public final void run()
  {
    try
    {
      String str = this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */