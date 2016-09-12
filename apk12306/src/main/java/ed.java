import android.content.Context;
import android.content.SharedPreferences;
import com.arrownock.push.PushCommandFetcher;
import org.json.JSONArray;

public final class ed
  implements Runnable
{
  public ed(Context paramContext, String paramString, ee paramee, int paramInt) {}
  
  public final void run()
  {
    try
    {
      Object localObject1 = new df;
      ((df)localObject1).<init>(this.jdField_a_of_type_AndroidContentContext);
      Object localObject2 = ((dy)localObject1).b(this.jdField_a_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_Ee;
      if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
      {
        bk localbk = bk.a();
        Object localObject3 = PushCommandFetcher.class.getName();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("Got push commands: ");
        localbk.a((String)localObject3, ((JSONArray)localObject2).length());
        localObject3 = ((ee)localObject1).jdField_a_of_type_ComArrownockPushPushCommandFetcher;
        PushCommandFetcher.a((JSONArray)localObject2, ((ee)localObject1).jdField_a_of_type_AndroidContentContext);
      }
      for (;;)
      {
        return;
        bk.a().a(PushCommandFetcher.class.getName(), "Got offline push commands: 0");
        continue;
        try
        {
          Thread.sleep(5000L);
          localObject2 = this.jdField_a_of_type_Ee;
          int i = this.jdField_a_of_type_Int;
          if (i < 5)
          {
            if (((ee)localObject2).jdField_a_of_type_AndroidContentSharedPreferences.getString("fetchCommandOn", null) == null) {
              continue;
            }
            PushCommandFetcher localPushCommandFetcher = ((ee)localObject2).jdField_a_of_type_ComArrownockPushPushCommandFetcher;
            PushCommandFetcher.a(((ee)localObject2).jdField_a_of_type_JavaLangString, ((ee)localObject2).jdField_a_of_type_AndroidContentContext, i + 1, (ee)localObject2);
            continue;
          }
          bk.a().d(PushCommandFetcher.class.getName(), "Failed to fetch commands after " + i + " retry");
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;) {}
        }
      }
    }
    catch (Exception localException)
    {
      bk.a().d(PushCommandFetcher.class.getName(), "Failed to fetch commands: " + localException.getMessage() + "; retry = " + this.jdField_a_of_type_Int);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */