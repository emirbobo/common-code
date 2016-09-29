import com.arrownock.im.callback.AnIMGetClientsStatusCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class ab
  implements Runnable
{
  ab(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AnIMGetClientsStatusCallbackData localAnIMGetClientsStatusCallbackData = f.b(this.jdField_a_of_type_F, this.jdField_a_of_type_JavaLangString, this.b);
    f.a(this.jdField_a_of_type_F).getClientsStatus(localAnIMGetClientsStatusCallbackData);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */