package com.arrownock.push;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import com.bangcle.andjni.JniLib;
import ej;
import ji;

public class PushService
  extends Service
{
  public static final String ACTION_MSG_ARRIVAL;
  public static int DEFAULT_FETCH_INTERVAL = 0;
  public static String LOGGER_TAG;
  public static final String LOG_TAG;
  public static final String PREF_ALREADY_REGISTER = "hasAlreadyRegistered";
  public static final String PREF_API_HOST = "apiHost";
  public static final String PREF_API_SECRET = "apiSecret";
  public static final String PREF_CLIENT_CERT = "clientCert";
  public static final String PREF_CLIENT_KEY = "clientKey";
  public static final String PREF_DEVICE_ID = "ANID";
  public static final String PREF_DEVICE_TOKEN = "deviceToken";
  public static final String PREF_DS_HOST = "dsHost";
  public static final String PREF_ENABLED = "isEnabled";
  public static final String PREF_FETCH_COMMAND_INTERVAL = "fetchCommandInterval";
  public static final String PREF_FETCH_COMMAND_ON = "fetchCommandOn";
  public static final String PREF_FETCH_NOTIFICATION_INTERVAL = "fetchNotificationInterval";
  public static final String PREF_FETCH_NOTIFICATION_ON = "fetchNotificationOn";
  public static final String PREF_INTERVAL_2G = "interval2G";
  public static final String PREF_INTERVAL_3G = "interval3G";
  public static final String PREF_INTERVAL_WIFI = "intervalWiFi";
  public static final String PREF_KEEPALIVE = "networkKeepalive";
  public static final String PREF_LATEST_ONLINE_COMMAND_TIMESTAMP = "latestOnlineCommandTimestamp";
  public static final String PREF_PUSH_HOST = "pushHost";
  public static final String PREF_PUSH_HOST_EXPIRATION = "pushHostExpiration";
  public static final String PREF_PUSH_HOST_RETRYTIME = "pushHostRetrytime";
  public static final String PREF_PUSH_PORT = "pushPort";
  public static final String PREF_PUSH_SCHEDULED_DURATION = "pushScheduledDuration";
  public static final String PREF_PUSH_SCHEDULED_HOUR = "pushScheduledHour";
  public static final String PREF_PUSH_SCHEDULED_MINUTE = "pushScheduledMinue";
  public static final String PREF_RETRY = "retryInterval";
  public static final String PREF_SECURE_CONNECTION = "secureConnection";
  public static final String PREF_SERVER_CERT = "serverCert";
  protected static int a;
  private static ji jdField_a_of_type_Ji;
  protected static int b;
  private static int c = 20001;
  private long jdField_a_of_type_Long;
  private PendingIntent jdField_a_of_type_AndroidAppPendingIntent = null;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ej(this);
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private boolean jdField_a_of_type_Boolean;
  private long b;
  
  static
  {
    JniLib.a(PushService.class, 176);
    LOG_TAG = PushService.class.getName();
    LOGGER_TAG = PushService.class.getName();
    ACTION_MSG_ARRIVAL = PushService.class.getName() + ".MSG_ARRIVAL";
    DEFAULT_FETCH_INTERVAL = 7200;
    jdField_a_of_type_Int = 10000;
    jdField_b_of_type_Int = 20000;
  }
  
  public PushService()
  {
    this.jdField_b_of_type_Long = 240000L;
  }
  
  private native int a();
  
  private native void a();
  
  private native void a(String paramString, int paramInt);
  
  private native void a(boolean paramBoolean);
  
  private native boolean a();
  
  public static native void actionCheckStart(Context paramContext);
  
  public static native void actionConnectivityChanged(Context paramContext);
  
  public static native void actionPing(Context paramContext);
  
  public static native void actionRestart(Context paramContext);
  
  public static native void actionSetInterval(Context paramContext, int paramInt);
  
  public static native void actionStart(Context paramContext);
  
  public static native void actionStartCommandFetcher(Context paramContext);
  
  public static native void actionStartNotificationFetcher(Context paramContext);
  
  public static native void actionStop(Context paramContext);
  
  public static native void actionStopCommandFetcher(Context paramContext);
  
  public static native void actionStopNotificationFetcher(Context paramContext);
  
  private native void b();
  
  private native void b(boolean paramBoolean);
  
  private native boolean b();
  
  private native void c();
  
  private native void d();
  
  private native void e();
  
  private native void f();
  
  private native void g();
  
  private native void h();
  
  private native void i();
  
  public static native boolean isEnabled();
  
  private native void j();
  
  private native void k();
  
  public native void cancelReconnect();
  
  public native IBinder onBind(Intent paramIntent);
  
  public native void onCreate();
  
  public native void onDestroy();
  
  public native void onStart(Intent paramIntent, int paramInt);
  
  public native int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2);
  
  public native void onTaskRemoved(Intent paramIntent);
  
  public native void scheduleReconnect(long paramLong);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\PushService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */