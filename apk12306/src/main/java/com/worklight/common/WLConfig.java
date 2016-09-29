package com.worklight.common;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class WLConfig
{
  public static final String ENABLE_SETTINGS = "enableSettings";
  private static final String IGNORED_FILE_EXTENSIONS = "ignoredFileExtensions";
  public static final String WL_APP_ID = "wlAppId";
  public static final String WL_APP_VERSION = "wlAppVersion";
  public static final String WL_CLIENT_PROPS_NAME = "wlclient.properties";
  private static final String WL_ENVIRONMENT = "wlEnvironment";
  public static final String WL_GCM_SENDER = "GcmSenderId";
  public static final String WL_MAIN_FILE_PATH = "wlMainFilePath";
  public static final String WL_PLATFORM_VERSION = "wlPlatformVersion";
  private static final String WL_PREFS = "WLPrefs";
  public static final String WL_SERVER_CONTEXT = "wlServerContext";
  public static final String WL_SERVER_HOST = "wlServerHost";
  public static final String WL_SERVER_PORT = "wlServerPort";
  public static final String WL_SERVER_PROTOCOL = "wlServerProtocol";
  private static final String WL_TEST_WEB_RESOURCES_CHECKSUM = "testWebResourcesChecksum";
  public static final String WL_WEB_RESOURCES_UNPACKD_SIZE = "webResourcesSize";
  public static final String WL_X_VERSION_HEADER = "x-wl-app-version";
  private SharedPreferences prefs = null;
  private Properties wlProperties = new Properties();
  
  static
  {
    JniLib.a(WLConfig.class, 1258);
  }
  
  public WLConfig(Activity paramActivity)
  {
    this(paramActivity.getApplication());
  }
  
  public WLConfig(Context paramContext)
  {
    try
    {
      this.wlProperties.load(paramContext.getAssets().open("wlclient.properties"));
      this.prefs = paramContext.getSharedPreferences("WLPrefs", 0);
      return;
    }
    catch (IOException paramContext)
    {
      throw new RuntimeException("WLConfig(): Can't load wlclient.properties file");
    }
  }
  
  private native String getPropertyOrPref(String paramString1, String paramString2);
  
  public native String getAppId();
  
  public native URL getAppURL();
  
  public native String getApplicationVersion();
  
  public native String getContext();
  
  public native String getDefaultRootUrl();
  
  public native String getGCMSender();
  
  public native String getHost();
  
  public native String getMainFileFromDescriptor();
  
  public native String[] getMediaExtensions();
  
  public native String getPlatformVersion();
  
  public native String getPort();
  
  public native String getProtocol();
  
  public native String getRootURL();
  
  public native String getSettingsFlag();
  
  public native String getTestWebResourcesChecksumFlag();
  
  public native String getWLEnvironment();
  
  public native String getWebResourcesUnpackedSize();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\WLConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */