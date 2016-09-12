import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMUnbindAnPushServiceCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class q
  implements Runnable
{
  q(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b, null, null, null, false);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMUnbindAnPushServiceCallbackData localAnIMUnbindAnPushServiceCallbackData1 = new com/arrownock/im/callback/AnIMUnbindAnPushServiceCallbackData;
        localAnIMUnbindAnPushServiceCallbackData1.<init>(false, null);
        f.a(this.jdField_a_of_type_F).unbindAnPushService(localAnIMUnbindAnPushServiceCallbackData1);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMUnbindAnPushServiceCallbackData localAnIMUnbindAnPushServiceCallbackData2 = new AnIMUnbindAnPushServiceCallbackData(true, localArrownockException);
          f.a(this.jdField_a_of_type_F).unbindAnPushService(localAnIMUnbindAnPushServiceCallbackData2);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */