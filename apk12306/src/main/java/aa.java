import com.arrownock.im.callback.AnIMGetClientsStatusCallbackData;
import com.arrownock.im.callback.IAnIMGetClientsStatusCallback;

final class aa
  implements Runnable
{
  aa(f paramf, String paramString1, String paramString2, IAnIMGetClientsStatusCallback paramIAnIMGetClientsStatusCallback) {}
  
  public final void run()
  {
    AnIMGetClientsStatusCallbackData localAnIMGetClientsStatusCallbackData = f.a(this.jdField_a_of_type_F, this.jdField_a_of_type_JavaLangString, this.b);
    if (this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetClientsStatusCallback != null)
    {
      if (!localAnIMGetClientsStatusCallbackData.isError()) {
        break label44;
      }
      this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetClientsStatusCallback.onError(localAnIMGetClientsStatusCallbackData.getException());
    }
    for (;;)
    {
      return;
      label44:
      this.jdField_a_of_type_ComArrownockImCallbackIAnIMGetClientsStatusCallback.onSuccess(localAnIMGetClientsStatusCallbackData);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */