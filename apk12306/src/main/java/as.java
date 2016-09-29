import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMCreateTopicCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class as
  implements Runnable
{
  as(f paramf, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    try
    {
      String str = this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMCreateTopicCallbackData localAnIMCreateTopicCallbackData2 = new com/arrownock/im/callback/AnIMCreateTopicCallbackData;
        localAnIMCreateTopicCallbackData2.<init>(false, null, str);
        f.a(this.jdField_a_of_type_F).createTopic(localAnIMCreateTopicCallbackData2);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMCreateTopicCallbackData localAnIMCreateTopicCallbackData1 = new AnIMCreateTopicCallbackData(true, localArrownockException, null);
          f.a(this.jdField_a_of_type_F).createTopic(localAnIMCreateTopicCallbackData1);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\as.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */