import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import com.arrownock.exception.ArrownockException;
import com.arrownock.push.AnPush;
import com.arrownock.push.AnPushStatus;
import com.arrownock.push.IAnPushCallback;
import com.arrownock.push.PushService;
import org.json.JSONException;
import org.json.JSONObject;

public final class ep
  implements dz
{
  private ep(PushService paramPushService) {}
  
  private static AnPushStatus a()
  {
    if ((PushService.a() != null) && (ea.d.equals(PushService.a().a))) {}
    for (AnPushStatus localAnPushStatus = AnPushStatus.ENABLE;; localAnPushStatus = AnPushStatus.DISABLE) {
      return localAnPushStatus;
    }
  }
  
  public final void a()
  {
    bk.a().b(PushService.LOGGER_TAG, "Push service connected");
    SharedPreferences.Editor localEditor = PushService.a(this.a).edit();
    localEditor.putLong("retryInterval", 2500L);
    localEditor.putInt("pushHostRetrytime", 0);
    localEditor.commit();
    PushService.a(this.a, System.currentTimeMillis());
    PushService.c(this.a);
    PushService.b(this.a);
  }
  
  public final void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    for (;;)
    {
      return;
      Log.d(PushService.LOGGER_TAG, "New message arrived. Creating wakelock.");
      PowerManager.WakeLock localWakeLock = ((PowerManager)this.a.getSystemService("power")).newWakeLock(1, "anPush");
      localWakeLock.acquire();
      try
      {
        JSONObject localJSONObject1 = new org/json/JSONObject;
        localJSONObject1.<init>(paramString);
        paramString = localJSONObject1;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          JSONObject localJSONObject2 = new JSONObject();
          JSONObject localJSONObject3 = new JSONObject();
          try
          {
            localJSONObject3.put("alert", paramString);
            localJSONObject2.put("android", localJSONObject3);
            paramString = localJSONObject2;
          }
          catch (JSONException paramString)
          {
            paramString = localJSONObject2;
          }
        }
      }
      PushService.a(this.a, paramString);
      PushService.b(this.a);
      localWakeLock.release();
      Log.d(PushService.LOGGER_TAG, "Releasing wakelock.");
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if ("keepalive".equals(paramString1)) {
      Log.d(PushService.LOGGER_TAG, "send keepalive complete");
    }
  }
  
  public final void a(String paramString, Throwable paramThrowable)
  {
    if ("keepalive".equals(paramString)) {
      Log.d(PushService.LOGGER_TAG, "send keepalive failed");
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    bk.a().a(PushService.LOGGER_TAG, "General Problem occured. Exception Type: " + paramThrowable.getClass().getName() + "; Exception Message: " + paramThrowable.getMessage(), paramThrowable);
  }
  
  public final void b()
  {
    try
    {
      AnPush localAnPush = AnPush.getInstance(this.a.getApplicationContext());
      if ((localAnPush != null) && (localAnPush.getCallback() != null)) {
        localAnPush.getCallback().statusChanged(AnPushStatus.ENABLE, null);
      }
      return;
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;) {}
    }
  }
  
  public final void b(Throwable paramThrowable)
  {
    try
    {
      paramThrowable = AnPush.getInstance(this.a.getApplicationContext());
      if ((paramThrowable != null) && (paramThrowable.getCallback() != null)) {
        paramThrowable.getCallback().statusChanged(a(), null);
      }
    }
    catch (ArrownockException paramThrowable)
    {
      for (;;) {}
    }
    bk.a().b(PushService.LOGGER_TAG, "Push service disonnected");
    if (PushService.a(this.a)) {
      Log.w(PushService.LOGGER_TAG, "Push Service status:" + PushService.a(this.a));
    }
    PushService.d(this.a);
  }
  
  public final void c(Throwable paramThrowable)
  {
    try
    {
      Object localObject = AnPush.getInstance(this.a.getApplicationContext());
      if ((localObject != null) && (((AnPush)localObject).getCallback() != null))
      {
        IAnPushCallback localIAnPushCallback = ((AnPush)localObject).getCallback();
        localObject = a();
        ArrownockException localArrownockException2 = new com/arrownock/exception/ArrownockException;
        localArrownockException2.<init>(paramThrowable.getMessage(), 3002);
        localIAnPushCallback.statusChanged((AnPushStatus)localObject, localArrownockException2);
      }
    }
    catch (ArrownockException localArrownockException1)
    {
      for (;;) {}
    }
    bk.a().a(PushService.LOGGER_TAG, "Failed to connect to push server. Exception Type: " + paramThrowable.getClass().getName() + "; Exception Message: " + paramThrowable.getMessage(), paramThrowable);
    if ((PushService.b(this.a)) && (PushService.c(this.a))) {
      this.a.scheduleReconnect(PushService.a(this.a));
    }
  }
  
  public final void d(Throwable paramThrowable)
  {
    try
    {
      Object localObject = AnPush.getInstance(this.a.getApplicationContext());
      if ((localObject != null) && (((AnPush)localObject).getCallback() != null))
      {
        IAnPushCallback localIAnPushCallback = ((AnPush)localObject).getCallback();
        AnPushStatus localAnPushStatus = a();
        localObject = new com/arrownock/exception/ArrownockException;
        ((ArrownockException)localObject).<init>(paramThrowable.getMessage(), 3003);
        localIAnPushCallback.statusChanged(localAnPushStatus, (ArrownockException)localObject);
      }
    }
    catch (ArrownockException localArrownockException)
    {
      for (;;) {}
    }
    bk.a().a(PushService.LOGGER_TAG, "Failed to disconnect from push server. Exception Type: " + paramThrowable.getClass().getName() + "; Exception Message: " + paramThrowable.getMessage(), paramThrowable);
  }
  
  public final void e(Throwable paramThrowable)
  {
    try
    {
      Object localObject = AnPush.getInstance(this.a.getApplicationContext());
      if ((localObject != null) && (((AnPush)localObject).getCallback() != null))
      {
        IAnPushCallback localIAnPushCallback = ((AnPush)localObject).getCallback();
        localObject = a();
        ArrownockException localArrownockException = new com/arrownock/exception/ArrownockException;
        localArrownockException.<init>(paramThrowable.getMessage(), 3002);
        localIAnPushCallback.statusChanged((AnPushStatus)localObject, localArrownockException);
      }
      return;
    }
    catch (ArrownockException paramThrowable)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */