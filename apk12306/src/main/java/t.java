import com.arrownock.exception.ArrownockException;
import com.arrownock.im.callback.AnIMMessageSentCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class t
  implements Runnable
{
  t(f paramf, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean) {}
  
  public final void run()
  {
    try
    {
      this.jdField_a_of_type_F.b(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, this.f, this.g, this.jdField_a_of_type_Boolean);
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        AnIMMessageSentCallbackData localAnIMMessageSentCallbackData1 = new com/arrownock/im/callback/AnIMMessageSentCallbackData;
        localAnIMMessageSentCallbackData1.<init>(false, null, this.g, -1L);
        f.a(this.jdField_a_of_type_F).messageSent(localAnIMMessageSentCallbackData1);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;)
      {
        if (f.a(this.jdField_a_of_type_F) != null)
        {
          AnIMMessageSentCallbackData localAnIMMessageSentCallbackData2 = new AnIMMessageSentCallbackData(true, localArrownockException, null, -1L);
          f.a(this.jdField_a_of_type_F).messageSent(localAnIMMessageSentCallbackData2);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */