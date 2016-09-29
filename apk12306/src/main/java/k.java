import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMAddClientsCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class k
  implements Runnable
{
  k(f paramf, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.c(this.jdField_a_of_type_JavaLangString, this.b, this.c);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMAddClientsCallbackData localAnIMAddClientsCallbackData1 = new com/arrownock/im/callback/AnIMAddClientsCallbackData;
        localAnIMAddClientsCallbackData1.<init>(false, null);
        f.a(this.jdField_a_of_type_F).addClientsToTopic(localAnIMAddClientsCallbackData1);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMAddClientsCallbackData localAnIMAddClientsCallbackData2 = new AnIMAddClientsCallbackData(true, localArrownockException);
          f.a(this.jdField_a_of_type_F).addClientsToTopic(localAnIMAddClientsCallbackData2);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */