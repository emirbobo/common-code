package com.google.android.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import com.bangcle.andjni.JniLib;
import java.util.Set;

public final class GCMRegistrar
{
  private static final String BACKOFF_MS = "backoff_ms";
  private static final int DEFAULT_BACKOFF_MS = 3000;
  public static final long DEFAULT_ON_SERVER_LIFESPAN_MS = 604800000L;
  private static final String GSF_PACKAGE = "com.google.android.gsf";
  private static final String PREFERENCES = "com.google.android.gcm";
  private static final String PROPERTY_APP_VERSION = "appVersion";
  private static final String PROPERTY_ON_SERVER = "onServer";
  private static final String PROPERTY_ON_SERVER_EXPIRATION_TIME = "onServerExpirationTime";
  private static final String PROPERTY_ON_SERVER_LIFESPAN = "onServerLifeSpan";
  private static final String PROPERTY_REG_ID = "regId";
  private static final String TAG = "GCMRegistrar";
  private static GCMBroadcastReceiver sRetryReceiver;
  
  static
  {
    JniLib.a(GCMRegistrar.class, 255);
  }
  
  private GCMRegistrar()
  {
    throw new UnsupportedOperationException();
  }
  
  public static native void checkDevice(Context paramContext);
  
  public static native void checkManifest(Context paramContext);
  
  private static native void checkReceiver(Context paramContext, Set<String> paramSet, String paramString);
  
  static native String clearRegistrationId(Context paramContext);
  
  private static native int getAppVersion(Context paramContext);
  
  static native int getBackoff(Context paramContext);
  
  static String getFlatSenderIds(String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("No senderIds");
    }
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs[0]);
    for (int i = 1; i < paramVarArgs.length; i++) {
      localStringBuilder.append(',').append(paramVarArgs[i]);
    }
    return localStringBuilder.toString();
  }
  
  private static native SharedPreferences getGCMPreferences(Context paramContext);
  
  public static native long getRegisterOnServerLifespan(Context paramContext);
  
  public static native String getRegistrationId(Context paramContext);
  
  static void internalRegister(Context paramContext, String... paramVarArgs)
  {
    String str = getFlatSenderIds(paramVarArgs);
    Log.v("GCMRegistrar", "Registering app " + paramContext.getPackageName() + " of senders " + str);
    paramVarArgs = new Intent("com.google.android.c2dm.intent.REGISTER");
    paramVarArgs.setPackage("com.google.android.gsf");
    paramVarArgs.putExtra("app", PendingIntent.getBroadcast(paramContext, 0, new Intent(), 0));
    paramVarArgs.putExtra("sender", str);
    paramContext.startService(paramVarArgs);
  }
  
  static native void internalUnregister(Context paramContext);
  
  public static native boolean isRegistered(Context paramContext);
  
  public static native boolean isRegisteredOnServer(Context paramContext);
  
  public static native void onDestroy(Context paramContext);
  
  public static void register(Context paramContext, String... paramVarArgs)
  {
    setRetryBroadcastReceiver(paramContext);
    resetBackoff(paramContext);
    internalRegister(paramContext, paramVarArgs);
  }
  
  static native void resetBackoff(Context paramContext);
  
  static native void setBackoff(Context paramContext, int paramInt);
  
  public static native void setRegisterOnServerLifespan(Context paramContext, long paramLong);
  
  public static native void setRegisteredOnServer(Context paramContext, boolean paramBoolean);
  
  static native String setRegistrationId(Context paramContext, String paramString);
  
  private static native void setRetryBroadcastReceiver(Context paramContext);
  
  public static native void unregister(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\android\gcm\GCMRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */