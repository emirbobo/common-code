import android.content.Context;
import android.util.Log;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.PushService;

public final class em
  implements Runnable
{
  public em(Context paramContext, String paramString, eo parameo) {}
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        Object localObject = new df;
        ((df)localObject).<init>(this.jdField_a_of_type_AndroidContentContext);
        cp localcp = ((dy)localObject).a(this.jdField_a_of_type_JavaLangString);
        if ((localcp == null) || (localcp.a == null) || ("".equals(localcp.a))) {
          continue;
        }
        localeo = this.jdField_a_of_type_Eo;
        localObject = (String)localcp.a;
        int i = ((Integer)localcp.b).intValue();
        if ((localObject != null) && (!"".equals(((String)localObject).trim())))
        {
          PushService.a(localeo.a, (String)localObject, i);
          return;
        }
      }
      catch (ArrownockException localArrownockException)
      {
        eo localeo;
        this.jdField_a_of_type_Eo.a(localArrownockException);
        continue;
        Log.w(PushService.LOGGER_TAG, "Push server is null.");
        continue;
      }
      bk.a().d(PushService.LOGGER_TAG, "Cannot find push server.");
      localeo.a.scheduleReconnect(PushService.a(localeo.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\em.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */