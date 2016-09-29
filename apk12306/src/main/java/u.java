import com.arrownock.im.callback.AnIMGetTopicInfoCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class u
  implements Runnable
{
  u(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AnIMGetTopicInfoCallbackData localAnIMGetTopicInfoCallbackData = f.a(this.jdField_a_of_type_F, this.jdField_a_of_type_JavaLangString, this.b);
    if (f.a(this.jdField_a_of_type_F) != null) {
      f.a(this.jdField_a_of_type_F).getTopicInfo(localAnIMGetTopicInfoCallbackData);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */