import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMGetClientIdCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class g
  implements Runnable
{
  g(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    try
    {
      String str = this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMGetClientIdCallbackData localAnIMGetClientIdCallbackData1 = new com/arrownock/im/callback/AnIMGetClientIdCallbackData;
        localAnIMGetClientIdCallbackData1.<init>(false, null, str);
        f.a(this.jdField_a_of_type_F).getClientId(localAnIMGetClientIdCallbackData1);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMGetClientIdCallbackData localAnIMGetClientIdCallbackData2 = new AnIMGetClientIdCallbackData(true, localArrownockException, null);
          f.a(this.jdField_a_of_type_F).getClientId(localAnIMGetClientIdCallbackData2);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */