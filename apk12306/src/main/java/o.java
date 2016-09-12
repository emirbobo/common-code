import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMBindAnPushServiceCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class o
  implements Runnable
{
  o(f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, true);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMBindAnPushServiceCallbackData localAnIMBindAnPushServiceCallbackData1 = new com/arrownock/im/callback/AnIMBindAnPushServiceCallbackData;
        localAnIMBindAnPushServiceCallbackData1.<init>(false, null);
        f.a(this.jdField_a_of_type_F).bindAnPushService(localAnIMBindAnPushServiceCallbackData1);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMBindAnPushServiceCallbackData localAnIMBindAnPushServiceCallbackData2 = new AnIMBindAnPushServiceCallbackData(true, localArrownockException);
          f.a(this.jdField_a_of_type_F).bindAnPushService(localAnIMBindAnPushServiceCallbackData2);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */