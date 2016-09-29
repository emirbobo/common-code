import com.arrownock.exception.ArrownockException;
import com.arrownock.im.AnIMStatus;
import com.arrownock.im.callback.AnIMStatusUpdateCallbackData;
import com.arrownock.im.callback.IAnIMCallback;

final class ac
  implements Runnable
{
  ac(f paramf, String paramString1, String paramString2) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        localObject2 = this.jdField_a_of_type_F.a(this.jdField_a_of_type_JavaLangString);
        if ((localObject2 != null) && (((cp)localObject2).a != null) && (!"".equals(((cp)localObject2).a)))
        {
          localObject1 = (String)((cp)localObject2).a;
          int i = ((Integer)((cp)localObject2).b).intValue();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("ANIM/");
          localObject3 = this.jdField_a_of_type_JavaLangString + '/' + this.b;
          localObject2 = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_F.a((String)localObject1, i, (String)localObject3, (String)localObject2, f.a(this.jdField_a_of_type_F));
          return;
        }
      }
      catch (ArrownockException localArrownockException)
      {
        Object localObject2;
        Object localObject1;
        Object localObject3;
        AnIMStatusUpdateCallbackData localAnIMStatusUpdateCallbackData = new AnIMStatusUpdateCallbackData(this.jdField_a_of_type_F.a(), localArrownockException);
        if (f.a(this.jdField_a_of_type_F) == null) {
          continue;
        }
        f.a(this.jdField_a_of_type_F).statusUpdate(localAnIMStatusUpdateCallbackData);
        continue;
      }
      if (f.a(this.jdField_a_of_type_F) != null)
      {
        localObject3 = new com/arrownock/im/callback/AnIMStatusUpdateCallbackData;
        localObject2 = this.jdField_a_of_type_F.a();
        localObject1 = new com/arrownock/exception/ArrownockException;
        ((ArrownockException)localObject1).<init>("Failed to get server info", 3101);
        ((AnIMStatusUpdateCallbackData)localObject3).<init>((AnIMStatus)localObject2, (ArrownockException)localObject1);
        f.a(this.jdField_a_of_type_F).statusUpdate((AnIMStatusUpdateCallbackData)localObject3);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */