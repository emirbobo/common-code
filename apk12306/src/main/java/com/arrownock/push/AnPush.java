package com.arrownock.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.arrownock.exception.ArrownockException;
import com.bangcle.andjni.JniLib;
import df;
import dy;
import java.util.List;

public class AnPush
{
  public static final String AN_APPKEY = "com.arrownock.push.AN_APPKEY";
  public static final String MIPUSH_APPID = "com.arrownock.push.MIPUSH_APPID";
  public static final String MIPUSH_APPKEY = "com.arrownock.push.MIPUSH_APPKEY";
  public static final String MIPUSH_SERVICE_STATUS = "com.arrownock.push.MIPUSH_SERVICE_STATUS";
  private static AnPush jdField_a_of_type_ComArrownockPushAnPush;
  private static final String jdField_a_of_type_JavaLangString = AnPush.class.getName();
  private long jdField_a_of_type_Long = 900000L;
  private Context jdField_a_of_type_AndroidContentContext;
  private IAnPushCallback jdField_a_of_type_ComArrownockPushIAnPushCallback = null;
  private dy jdField_a_of_type_Dy = null;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long = 240000L;
  private String jdField_b_of_type_JavaLangString = null;
  private long jdField_c_of_type_Long = 240000L;
  private String jdField_c_of_type_JavaLangString = null;
  private String d = null;
  private String e = null;
  private String f = null;
  
  static
  {
    JniLib.a(AnPush.class, 171);
  }
  
  private AnPush(Context paramContext)
    throws ArrownockException
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Dy = new df(paramContext);
    Bundle localBundle;
    try
    {
      localBundle = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128).metaData;
      if (localBundle == null) {
        break label392;
      }
      this.jdField_b_of_type_JavaLangString = localBundle.getString("com.arrownock.push.SERVICE_TYPE");
      this.e = localBundle.getString("com.arrownock.push.gcm.SENDER_ID");
      setAppKey(localBundle.getString("com.arrownock.APP_KEY"));
      if (localBundle.containsKey("com.arrownock.push.ENABLE_MIPUSH")) {
        this.jdField_a_of_type_Boolean = localBundle.getBoolean("com.arrownock.push.ENABLE_MIPUSH");
      }
      if ((this.jdField_a_of_type_Boolean) && (b()) && ((localBundle.getString("com.arrownock.push.MIPUSH_APPID") == null) || (localBundle.getString("com.arrownock.push.MIPUSH_APPKEY") == null)))
      {
        paramContext = new java/lang/Exception;
        paramContext.<init>("MiPush APPID or APPKEY is empty.");
        throw paramContext;
      }
    }
    catch (Exception paramContext)
    {
      throw new ArrownockException("Failed to initialize SDK.", paramContext, 2001);
    }
    if (localBundle.getInt("com.arrownock.push.KEEPALIVE_INTERVAL_WIFI") == 0)
    {
      l = this.jdField_a_of_type_Long;
      this.jdField_a_of_type_Long = l;
      if (localBundle.getInt("com.arrownock.push.KEEPALIVE_INTERVAL_2G") != 0) {
        break label461;
      }
      l = this.jdField_b_of_type_Long;
      label255:
      this.jdField_b_of_type_Long = l;
      if (localBundle.getInt("com.arrownock.push.KEEPALIVE_INTERVAL_3G") != 0) {
        break label480;
      }
    }
    label392:
    label461:
    label480:
    int i;
    for (long l = this.jdField_c_of_type_Long;; l = i * 60 * 1000)
    {
      this.jdField_c_of_type_Long = l;
      paramContext = paramContext.getSharedPreferences(PushService.LOG_TAG, 0).edit();
      paramContext.putLong("intervalWiFi", this.jdField_a_of_type_Long);
      paramContext.putLong("interval2G", this.jdField_b_of_type_Long);
      paramContext.putLong("interval3G", this.jdField_c_of_type_Long);
      if (localBundle.containsKey("com.arrownock.push.MIPUSH_APPID")) {
        paramContext.putString("com.arrownock.push.MIPUSH_APPID", localBundle.getString("com.arrownock.push.MIPUSH_APPID"));
      }
      if (localBundle.containsKey("com.arrownock.push.MIPUSH_APPKEY")) {
        paramContext.putString("com.arrownock.push.MIPUSH_APPKEY", localBundle.getString("com.arrownock.push.MIPUSH_APPKEY"));
      }
      paramContext.commit();
      if (this.jdField_b_of_type_JavaLangString == null) {
        this.jdField_b_of_type_JavaLangString = "ARROWNOCK";
      }
      if (("GCM".equals(this.jdField_b_of_type_JavaLangString)) || ("ARROWNOCK".equals(this.jdField_b_of_type_JavaLangString))) {
        break label501;
      }
      throw new ArrownockException("Invalid value of com.arrownock.push.SERVICE_TYPE. Should be GCM or ARROWNOCK", 1003);
      l = localBundle.getInt("com.arrownock.push.KEEPALIVE_INTERVAL_WIFI") * 60 * 1000;
      break;
      l = localBundle.getInt("com.arrownock.push.KEEPALIVE_INTERVAL_2G") * 60 * 1000;
      break label255;
      i = localBundle.getInt("com.arrownock.push.KEEPALIVE_INTERVAL_3G");
    }
    label501:
    if (("GCM".equals(this.jdField_b_of_type_JavaLangString)) && ((this.e == null) || ("".equals(this.e.trim())))) {
      throw new ArrownockException("com.arrownock.push.gcm.SENDER_ID must be set for GCM service", 1004);
    }
    if ("ARROWNOCK".equals(this.jdField_b_of_type_JavaLangString)) {}
    try
    {
      if ((a()) && (!isConnected()) && (!b())) {
        enable();
      }
      if (isFetchingModeEnabled()) {
        startFetchingMode();
      }
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  private native void a(List<String> paramList, boolean paramBoolean)
    throws ArrownockException;
  
  private native void a(List<String> paramList, boolean paramBoolean, IAnPushRegistrationCallback paramIAnPushRegistrationCallback);
  
  private native String b();
  
  private static native boolean b();
  
  public static native AnPush getInstance(Context paramContext)
    throws ArrownockException;
  
  final native void a(Context paramContext, String paramString);
  
  public final native boolean a()
    throws ArrownockException;
  
  public native void clearMute()
    throws ArrownockException;
  
  public native void clearMute(IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  public native void clearSilentPeriod()
    throws ArrownockException;
  
  public native void clearSilentPeriod(IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  public native void disable();
  
  public native void enable()
    throws ArrownockException;
  
  public native void enable(boolean paramBoolean)
    throws ArrownockException;
  
  public native String getAnID();
  
  public native IAnPushCallback getCallback();
  
  public native String getSenderId();
  
  public native boolean isConnected();
  
  public native boolean isEnabled();
  
  public native boolean isFetchingModeEnabled();
  
  public native boolean isSecureConnection();
  
  public native void register(List<String> paramList)
    throws ArrownockException;
  
  public native void register(List<String> paramList, IAnPushRegistrationCallback paramIAnPushRegistrationCallback);
  
  public native void register(List<String> paramList, boolean paramBoolean)
    throws ArrownockException;
  
  public native void register(List<String> paramList, boolean paramBoolean, IAnPushRegistrationCallback paramIAnPushRegistrationCallback);
  
  public native void setAppKey(String paramString);
  
  public native void setBadge(int paramInt)
    throws ArrownockException;
  
  public native void setBadge(int paramInt, IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  public native void setCallback(IAnPushCallback paramIAnPushCallback);
  
  public native void setFetchingInterval(int paramInt);
  
  public native void setHosts(String paramString1, String paramString2);
  
  public native void setId(String paramString)
    throws ArrownockException;
  
  public native void setMute()
    throws ArrownockException;
  
  public native void setMute(IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  public native void setNetworkKeepalive(int paramInt);
  
  public native void setSSLCertificates(String paramString1, String paramString2, String paramString3)
    throws ArrownockException;
  
  public native void setScheduledMute(int paramInt1, int paramInt2, int paramInt3)
    throws ArrownockException;
  
  public native void setScheduledMute(int paramInt1, int paramInt2, int paramInt3, IAnPushSettingsCallback paramIAnPushSettingsCallback)
    throws ArrownockException;
  
  public native void setSecret(String paramString);
  
  public native void setSecureConnection(boolean paramBoolean);
  
  public native void setSilentPeriod(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    throws ArrownockException;
  
  public native void setSilentPeriod(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, IAnPushSettingsCallback paramIAnPushSettingsCallback);
  
  public native void startFetchingMode()
    throws ArrownockException;
  
  public native void stopCommandFetcher();
  
  public native void stopFetchingMode();
  
  public native void stopNotificationFetcher();
  
  public native void unregister()
    throws ArrownockException;
  
  public native void unregister(IAnPushRegistrationCallback paramIAnPushRegistrationCallback);
  
  public native void unregister(List<String> paramList)
    throws ArrownockException;
  
  public native void unregister(List<String> paramList, IAnPushRegistrationCallback paramIAnPushRegistrationCallback);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\push\AnPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */