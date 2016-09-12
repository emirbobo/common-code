import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMUpdateTopicCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class i
  implements Runnable
{
  i(f paramf, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public final void run()
  {
    try
    {
      String str = this.jdField_a_of_type_F.b(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMUpdateTopicCallbackData localAnIMUpdateTopicCallbackData2 = new com/arrownock/im/callback/AnIMUpdateTopicCallbackData;
        localAnIMUpdateTopicCallbackData2.<init>(false, null, str);
        f.a(this.jdField_a_of_type_F).updateTopic(localAnIMUpdateTopicCallbackData2);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMUpdateTopicCallbackData localAnIMUpdateTopicCallbackData1 = new AnIMUpdateTopicCallbackData(true, localArrownockException, null);
          f.a(this.jdField_a_of_type_F).updateTopic(localAnIMUpdateTopicCallbackData1);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */