package com.tl.uic;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.tl.uic.model.Screenview;
import com.tl.uic.model.ScreenviewType;
import com.tl.uic.util.ConfigurationUtil;
import com.tl.uic.util.TLUncaughtExceptionHandler;
import java.util.HashMap;
import org.apache.http.HttpResponse;

public class Tealeaf
{
  public static final String DISPLAY_LOGGING = "DisplayLogging";
  public static final String TAG = "UICAndroid";
  public static final String TLF_ADD_COOKIE_DOMAIN = "AddCookieDomain";
  public static final String TLF_ADD_COOKIE_PATH = "AddCookiePath";
  public static final String TLF_ADD_MESSAGE_TYPE_HEADER = "AddMessageTypeHeader";
  public static final String TLF_BUFFER_LIMIT = "BufferLimit";
  public static final String TLF_BUFFER_PERCENT = "BufferPercent";
  public static final String TLF_CACHED_FILE_MAX_BYTES_SIZE = "CachedFileMaxBytesSize";
  public static final String TLF_CACHED_LEVEL = "CachingLevel";
  public static final String TLF_CACHE_DIR = "TLFCache";
  public static final String TLF_COMPRESS_POST_MESSAGE = "CompressPostMessage";
  public static final String TLF_CONFIGURATION_FILENAME = "TLFConfigurableItems.properties";
  public static final String TLF_COOKIE_DOMAIN = "CookieDomain";
  public static final String TLF_COOKIE_PARAM = "CookieParam";
  public static final String TLF_COOKIE_PATH = "CookiePath";
  public static final String TLF_COOKIE_URL = "CookieUrl";
  public static final String TLF_DO_POSTS_ON_INTERVALS = "DoPostOnIntervals";
  public static final String TLF_FILTER_MESSAGE_TYPES = "FilterMessageTypes";
  public static final String TLF_HAS_CUSTOM_MASK = "HasCustomMask";
  public static final String TLF_HAS_MASKING = "HasMasking";
  public static final String TLF_HAS_TO_PERSIST_LOCAL_CACHE = "HasToPersistLocalCache";
  public static final String TLF_HEADER = "X-Tealeaf";
  public static final String TLF_KILL_SWITCH_ENABLED = "KillSwitchEnabled";
  public static final String TLF_KILL_SWITCH_MAX_NUMBER_OF_TRIES = "KillSwitchMaxNumberOfTries";
  public static final String TLF_KILL_SWITCH_TIME_INTERVAL = "KillSwitchTimeInterval";
  public static final String TLF_KILL_SWITCH_URL = "KillSwitchUrl";
  public static final String TLF_LIBRARY_VERSION = "LibraryVersion";
  public static final String TLF_LOGGING_LEVEL = "LoggingLevel";
  public static final String TLF_MANUAL_POST_ENABLED = "ManualPostEnabled";
  public static final String TLF_MASK_ID_LIST = "MaskIdList";
  public static final String TLF_MAX_STRINGS_LENGTH = "MaxStringsLength";
  public static final String TLF_MESSAGE_TYPES = "MessageTypes";
  public static final String TLF_MESSAGE_TYPE_HEADER = "MessageTypeHeader";
  public static final String TLF_MESSAGE_VERSION = "MessageVersion";
  public static final String TLF_ON_DRAWER_CLOSED = "OnDrawerClosed";
  public static final String TLF_ON_DRAWER_OPENED = "OnDrawerOpened";
  public static final String TLF_ON_FOCUS_CHANGE_IN = "OnFocusChange_In";
  public static final String TLF_ON_FOCUS_CHANGE_OUT = "OnFocusChange_Out";
  public static final String TLF_ON_GROUP_COLLAPSE = "OnGroupCollapse";
  public static final String TLF_ON_GROUP_EXPAND = "OnGroupExpand";
  public static final String TLF_POST_MESSAGE_LEVEL_CELLULAR = "PostMessageLevelCellular";
  public static final String TLF_POST_MESSAGE_LEVEL_WIFI = "PostMessageLevelWiFi";
  public static final String TLF_POST_MESSAGE_MAX_BYTES_SIZE = "PostMessageMaxBytesSize";
  public static final String TLF_POST_MESSAGE_SOCKET_TIMEOUT = "PostMessageSocketTimeout";
  public static final String TLF_POST_MESSAGE_TIMEOUT = "PostMessageTimeout";
  public static final String TLF_POST_MESSAGE_TIME_INTERVALS = "PostMessageTimeIntervals";
  public static final String TLF_POST_MESSAGE_URL = "PostMessageUrl";
  public static final String TLF_PROPERTY_HEADER = "X-Tealeaf-Property";
  public static final String TLF_RANDOM_SAMPLE_PARAM = "RandomSampleParam";
  public static final String TLF_SENSITIVE_CAPITAL_CASE_ALPHABET = "SensitiveCapitalCaseAlphabet";
  public static final String TLF_SENSITIVE_NUMBER = "SensitiveNumber";
  public static final String TLF_SENSITIVE_SMALL_CASE_ALPHABET = "SensitiveSmallCaseAlphabet";
  public static final String TLF_SENSITIVE_SYMBOL = "SensitiveSymbol";
  public static final String TLF_SESSION_HEADER = "X-Tealeaf-Session";
  public static final String TLF_TIME_INTERVAL_BETWEEN_SNAPSHOTS = "TimeIntervalBetweenSnapshots";
  public static final String TLF_USE_RANDOM_SAMPLE = "UseRandomSample";
  public static final String TLF_USE_WHITE_LIST = "UseWhiteList";
  public static final String TLF_WHITE_LIST_PARAM = "WhiteListParam";
  public static final int VERBOSE = 5;
  private static Boolean _appLoaded = Boolean.valueOf(false);
  private static int _applicationInForegroundCounter = 0;
  private static Boolean _isEnabled;
  private static volatile Tealeaf _myInstance;
  private static String additionalCookies;
  private static HashMap<String, String> additionalHeaders;
  private static Application application;
  private static Logger logger;
  private static String phoneId;
  private static TLUncaughtExceptionHandler tlUncaughtExceptionHandler;
  
  static
  {
    JniLib.a(Tealeaf.class, 1087);
    _isEnabled = Boolean.valueOf(false);
  }
  
  private Tealeaf() {}
  
  public Tealeaf(Application paramApplication)
  {
    try
    {
      application = paramApplication;
      ConfigurationUtil.init(application);
      return;
    }
    finally {}
  }
  
  public static native Boolean disable();
  
  public static native Boolean enable();
  
  public static native Boolean enable(String paramString);
  
  public static native Boolean flush();
  
  public static native String getAdditionalCookie();
  
  public static native HashMap<String, String> getAdditionalHeaders();
  
  public static native Application getApplication();
  
  public static native long getApplicationScreenviewOffset();
  
  public static native Screenview getCurrentScreenView();
  
  public static native String getCurrentSessionId();
  
  public static native String getHttpXTealeafProperty();
  
  public static native Tealeaf getInstance();
  
  public static native String getLibraryVersion();
  
  public static native String getMessageVersion();
  
  public static native String getPhoneId();
  
  public static native String getTLCookie();
  
  public static native String getTLCookie(String paramString);
  
  public static native Boolean isApplicationInBackground();
  
  public static native Boolean isEnabled();
  
  public static native Boolean logConnection(String paramString, HttpResponse paramHttpResponse, long paramLong1, long paramLong2, long paramLong3);
  
  public static native Boolean logCustomEvent(String paramString);
  
  public static native Boolean logCustomEvent(String paramString, int paramInt);
  
  public static native Boolean logCustomEvent(String paramString, HashMap<String, String> paramHashMap);
  
  public static native Boolean logCustomEvent(String paramString, HashMap<String, String> paramHashMap, int paramInt);
  
  public static native Boolean logEvent(View paramView);
  
  public static native Boolean logEvent(View paramView, String paramString);
  
  public static native Boolean logEvent(View paramView, String paramString, int paramInt);
  
  public static native Boolean logException(Throwable paramThrowable);
  
  public static native Boolean logException(Throwable paramThrowable, String paramString);
  
  public static native Boolean logException(Throwable paramThrowable, HashMap<String, String> paramHashMap);
  
  public static native Boolean logScreenview(Activity paramActivity, String paramString, ScreenviewType paramScreenviewType);
  
  public static native Boolean logScreenview(Activity paramActivity, String paramString1, ScreenviewType paramScreenviewType, String paramString2);
  
  public static native Boolean logTLLibErrorException(Throwable paramThrowable, String paramString);
  
  public static native Boolean onDestroy(Activity paramActivity, String paramString);
  
  public static native Boolean onLowMemory();
  
  public static native Boolean onPause(Activity paramActivity, String paramString);
  
  public static native Boolean onPauseNoActivityInForeground();
  
  public static native Boolean onResume(Activity paramActivity, String paramString);
  
  public static native Boolean registerFormField(View paramView, Activity paramActivity);
  
  public static native Boolean registerFormField(View paramView, Activity paramActivity, int paramInt);
  
  public static native Boolean requestManualServerPost();
  
  public static native void setAdditionalCookie(String paramString);
  
  public static native void setAdditionalHeaders(HashMap<String, String> paramHashMap);
  
  public static native void setPhoneId(String paramString);
  
  public static native void setTLCookie();
  
  public static native void setTLCookie(String paramString);
  
  public static native Boolean startSession();
  
  public static native Boolean startSession(String paramString);
  
  public static native Boolean takeScreenShot(View paramView, String paramString);
  
  public static native Boolean terminate();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\Tealeaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */