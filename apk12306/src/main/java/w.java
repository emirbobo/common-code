import com.arrownock.im.callback.AnIMGetSessionInfoCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class w
  implements Runnable
{
  w(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AnIMGetSessionInfoCallbackData localAnIMGetSessionInfoCallbackData = this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b);
    if (f.a(this.jdField_a_of_type_F) != null) {
      f.a(this.jdField_a_of_type_F).getSessionInfo(localAnIMGetSessionInfoCallbackData);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */