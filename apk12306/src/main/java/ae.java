import com.arrownock.im.callback.AnIMGetTopicListCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class ae
  implements Runnable
{
  ae(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AnIMGetTopicListCallbackData localAnIMGetTopicListCallbackData = f.a(this.jdField_a_of_type_F, this.jdField_a_of_type_JavaLangString, this.b);
    if (f.a(this.jdField_a_of_type_F) != null) {
      f.a(this.jdField_a_of_type_F).getTopicList(localAnIMGetTopicListCallbackData);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */