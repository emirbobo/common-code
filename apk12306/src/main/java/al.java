import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMRemoveTopicCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class al
  implements Runnable
{
  al(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    try
    {
      String str = this.jdField_a_of_type_F.b(this.jdField_a_of_type_JavaLangString, this.b);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMRemoveTopicCallbackData localAnIMRemoveTopicCallbackData1 = new com/arrownock/im/callback/AnIMRemoveTopicCallbackData;
        localAnIMRemoveTopicCallbackData1.<init>(false, null, str);
        f.a(this.jdField_a_of_type_F).removeTopic(localAnIMRemoveTopicCallbackData1);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMRemoveTopicCallbackData localAnIMRemoveTopicCallbackData2 = new AnIMRemoveTopicCallbackData(true, localArrownockException, null);
          f.a(this.jdField_a_of_type_F).removeTopic(localAnIMRemoveTopicCallbackData2);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\al.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */