import com.arrownock.im.callback.AnIMGetTopicInfoCallbackData;
import com.arrownock.im.callback.IAnIMGetTopicInfoCallback;

final class v
  implements Runnable
{
  v(f paramf, String paramString1, String paramString2, IAnIMGetTopicInfoCallback paramIAnIMGetTopicInfoCallback) {}
  
  public final void run()
  {
    AnIMGetTopicInfoCallbackData localAnIMGetTopicInfoCallbackData = f.a(this.jdField_a_of_type_F, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetTopicInfoCallback != null)
    {
      if (!localAnIMGetTopicInfoCallbackData.isError()) {
        break label44;
      }
      this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetTopicInfoCallback.onError(localAnIMGetTopicInfoCallbackData.getException());
    }
    for (;;)
    {
      return;
      label44:
      this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetTopicInfoCallback.onSuccess(localAnIMGetTopicInfoCallbackData);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */