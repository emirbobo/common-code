import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.arrownock.push.PushNotificationFetcher;
import com.arrownock.push.PushService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ef
  implements Runnable
{
  public ef(Context paramContext, String paramString, eg parameg, int paramInt) {}
  
  public final void run()
  {
    try
    {
      localObject1 = new df;
      ((df)localObject1).<init>(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = ((dy)localObject1).a(this.jdField_a_of_type_JavaLangString);
      localeg = this.jdField_a_of_type_Eg;
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label312;
      }
      localObject1 = bk.a();
      localObject3 = PushNotificationFetcher.class.getName();
      localObject4 = new java/lang/StringBuilder;
      ((StringBuilder)localObject4).<init>("Got offline push notifications: ");
      ((bk)localObject1).a((String)localObject3, ((JSONArray)localObject2).length());
      bk.a().a(PushNotificationFetcher.class.getName(), "Acquiring wakelock...");
      localObject3 = localeg.jdField_a_of_type_AndroidContentContext;
      localObject1 = localeg.jdField_a_of_type_AndroidContentContext;
      localObject3 = ((PowerManager)((Context)localObject3).getSystemService("power")).newWakeLock(1, "anPush.notification");
      ((PowerManager.WakeLock)localObject3).acquire();
      i = 0;
    }
    catch (Exception localJSONException2)
    {
      try
      {
        int j;
        localObject4 = ((JSONArray)localObject2).getJSONObject(i);
        if (localObject4 == null) {
          break label236;
        }
        localObject1 = ((JSONObject)localObject4).getString("message");
        if (localObject1 == null) {
          break label236;
        }
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          eg localeg;
          Object localObject1 = new org/json/JSONObject;
          ((JSONObject)localObject1).<init>(((JSONObject)localObject4).getString("message"));
          localObject4 = new android/content/Intent;
          ((Intent)localObject4).<init>(PushService.ACTION_MSG_ARRIVAL);
          ((Intent)localObject4).setPackage(localeg.jdField_a_of_type_AndroidContentContext.getPackageName());
          ((Intent)localObject4).putExtra("payload", ((JSONObject)localObject1).toString());
          localeg.jdField_a_of_type_AndroidContentContext.sendBroadcast((Intent)localObject4);
          label236:
          i++;
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            Object localObject4;
            int i;
            JSONObject localJSONObject1 = new org/json/JSONObject;
            localJSONObject1.<init>();
            JSONObject localJSONObject2 = new org/json/JSONObject;
            localJSONObject2.<init>();
            try
            {
              localJSONObject2.put("alert", ((JSONObject)localObject4).getString("message"));
              localJSONObject1.put("android", localJSONObject2);
            }
            catch (JSONException localJSONException3) {}
            continue;
            ((PowerManager.WakeLock)localObject3).release();
            bk.a().a(PushNotificationFetcher.class.getName(), "Wakelock released");
            for (;;)
            {
              return;
              bk.a().a(PushNotificationFetcher.class.getName(), "Got offline push notifications: 0");
              continue;
              localException1 = localException1;
              bk.a().d(PushNotificationFetcher.class.getName(), "Failed to fetch notifications: " + localException1.getMessage() + "; retry = " + this.jdField_a_of_type_Int);
              try
              {
                Thread.sleep(5000L);
                localObject2 = this.jdField_a_of_type_Eg;
                i = this.jdField_a_of_type_Int;
                if (i < 5)
                {
                  if (((eg)localObject2).jdField_a_of_type_AndroidContentSharedPreferences.getString("fetchNotificationOn", null) != null)
                  {
                    PushNotificationFetcher localPushNotificationFetcher = ((eg)localObject2).jdField_a_of_type_ComArrownockPushPushNotificationFetcher;
                    PushNotificationFetcher.a(((eg)localObject2).jdField_a_of_type_JavaLangString, ((eg)localObject2).jdField_a_of_type_AndroidContentContext, i + 1, (eg)localObject2);
                  }
                }
                else {
                  bk.a().d(PushNotificationFetcher.class.getName(), "Failed to fetch notifications after " + i + " retry");
                }
              }
              catch (InterruptedException localInterruptedException)
              {
                for (;;) {}
              }
            }
            localJSONException2 = localJSONException2;
          }
        }
        catch (Exception localException2)
        {
          label312:
          for (;;) {}
        }
      }
    }
    j = ((JSONArray)localObject2).length();
    if (i >= j) {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */