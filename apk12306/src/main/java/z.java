import com.arrownock.im.callback.AnIMGetClientsStatusCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class z
  implements Runnable
{
  z(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AnIMGetClientsStatusCallbackData localAnIMGetClientsStatusCallbackData = f.a(this.jdField_a_of_type_F, this.jdField_a_of_type_JavaLangString, this.b);
    if (f.a(this.jdField_a_of_type_F) != null) {
      f.a(this.jdField_a_of_type_F).getClientsStatus(localAnIMGetClientsStatusCallbackData);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */