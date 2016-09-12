import com.arrownock.im.callback.AnIMGetTopicListCallbackData;
import com.arrownock.im.callback.IAnIMGetTopicListCallback;

final class af
  implements Runnable
{
  af(f paramf, String paramString1, String paramString2, IAnIMGetTopicListCallback paramIAnIMGetTopicListCallback) {}
  
  public final void run()
  {
    AnIMGetTopicListCallbackData localAnIMGetTopicListCallbackData = f.a(this.jdField_a_of_type_F, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetTopicListCallback != null)
    {
      if (!localAnIMGetTopicListCallbackData.isError()) {
        break label44;
      }
      this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetTopicListCallback.onError(localAnIMGetTopicListCallbackData.getException());
    }
    for (;;)
    {
      return;
      label44:
      this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetTopicListCallback.onSuccess(localAnIMGetTopicListCallbackData);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */