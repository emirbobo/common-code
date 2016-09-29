import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMMessageSentCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class aq
  implements Runnable
{
  aq(f paramf, String paramString) {}
  
  public final void run()
  {
    AnIMMessageSentCallbackData localAnIMMessageSentCallbackData = new AnIMMessageSentCallbackData(true, new ArrownockException("Failed to send message, client is offline.", 3104), this.jdField_a_of_type_JavaLangString, -1L);
    f.a(this.jdField_a_of_type_F).messageSent(localAnIMMessageSentCallbackData);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */