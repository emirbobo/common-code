import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMRemoveClientsCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class m
  implements Runnable
{
  m(f paramf, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.e(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMRemoveClientsCallbackData localAnIMRemoveClientsCallbackData1 = new com/arrownock/im/callback/AnIMRemoveClientsCallbackData;
        localAnIMRemoveClientsCallbackData1.<init>(false, null);
        f.a(this.jdField_a_of_type_F).removeClientsFromTopic(localAnIMRemoveClientsCallbackData1);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMRemoveClientsCallbackData localAnIMRemoveClientsCallbackData2 = new AnIMRemoveClientsCallbackData(true, localArrownockException);
          f.a(this.jdField_a_of_type_F).removeClientsFromTopic(localAnIMRemoveClientsCallbackData2);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */