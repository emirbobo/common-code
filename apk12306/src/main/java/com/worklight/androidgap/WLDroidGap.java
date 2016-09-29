package com.worklight.androidgap;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.plugin.WLOptionsMenu;
import com.worklight.common.Logger;
import com.worklight.common.WLConfig;
import java.text.DecimalFormat;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.DroidGap;
import org.json.JSONException;
import org.json.JSONObject;

public class WLDroidGap
  extends DroidGap
  implements WLDroidGapListener
{
  private static final String ANDROID_ASSET = "/android_asset";
  private static final String CLEAR_CACHE_NEXT_LOAD = "com.worklight.clearCacheNextLoad";
  public static final String DIRECT_UPDATE_RESULT = "directUpdateResult";
  private static final String ENABLE_SETTINGS_FLAG = "enableSettings";
  public static final String EXIT_ON_SKIN_LOADER = "exitOnSkinLoader";
  private static final String NATIVE_EMPTY_APP_HTML = "NativeEmptyApp.html";
  public static final String RESOURCES_CHECKSUM_PREF_KEY = "wlResourcesChecksum";
  public static final String SKIN_LOADER_HTML = "skinLoader.html";
  public static final String SKIN_NAME_PREF_KEY = "wlSkinName";
  public static final String WL_DEFAULT_SERVER_URL = "WLDefaultServerURL";
  private static final String WL_IS_EXTERNAL_WEBRESOURCES = "WLIsExternalWebResources";
  private static boolean isForegound = false;
  private static final Logger logger;
  private static WLConfig wlConfig;
  private String absolutePathToExternalAppFiles;
  private boolean fatalErrorOccurred = false;
  private PrepareClientAsyncTask longPrepareTask;
  private WLOptionsMenu optionsMenu = null;
  
  static
  {
    JniLib.a(WLDroidGap.class, 9);
    logger = Logger.getInstance(WLDroidGap.class.getName());
  }
  
  private native void doPrepareAssetsWork();
  
  public static native WLConfig getWLConfig();
  
  private native boolean isClearCacheNextLoad();
  
  private native boolean isExternalWebResources();
  
  public static native boolean isForeGround();
  
  private native void removeSessionCookies(CordovaWebView paramCordovaWebView);
  
  private native void setClearCacheNextLoad(boolean paramBoolean);
  
  private static native void setForeGround(boolean paramBoolean);
  
  private native void testResourcesChecksum();
  
  protected native void bindBrowser(CordovaWebView paramCordovaWebView);
  
  protected native void bindBrowser(CordovaWebView paramCordovaWebView, boolean paramBoolean);
  
  public native String getAbsolutePathToExternalAppFiles();
  
  public native String getAbsolutePathToExternalWWWAppFiles();
  
  public native String getAppWebUrl(String paramString);
  
  protected native String getIntentDataInJSONFormat(Intent paramIntent);
  
  public native String getLocalStorageRoot();
  
  public native String getWebMainFilePath();
  
  public native String getWebResourcesUrl();
  
  public native String getWebUrl();
  
  public native void init();
  
  public native void loadUrl(String paramString);
  
  public native void loadUrl(String paramString, boolean paramBoolean);
  
  protected native void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public native void onCreate(Bundle paramBundle);
  
  public native boolean onCreateOptionsMenu(Menu paramMenu);
  
  public native void onDestroy();
  
  protected native void onNewIntent(Intent paramIntent);
  
  public native boolean onOptionsItemSelected(MenuItem paramMenuItem);
  
  public native void onPause();
  
  public native boolean onPrepareOptionsMenu(Menu paramMenu);
  
  public native void onResume();
  
  public native void onWLInitCompleted(Bundle paramBundle);
  
  @JavascriptInterface
  public native void removeSplashScreen();
  
  public native void setClearCacheNextLoad();
  
  public native void setExternalWebResources(boolean paramBoolean);
  
  public class PrepackagedAssetsManager
  {
    private static final String APP_INSTALL_TIME_KEY = "appInstallTime";
    private static final String RESOURCES_ZIP = "resources.zip";
    private long appInstallTime = -1L;
    
    static
    {
      JniLib.a(PrepackagedAssetsManager.class, 1146);
    }
    
    public PrepackagedAssetsManager() {}
    
    private native void copyPrepackagedAssetsToLocalCopyIfNeeded();
    
    private native void deleteOldAssets();
    
    private native void handleNotEnoughSpace(Long paramLong, long paramLong1);
    
    private native boolean isNewInstallOrUpgrade();
    
    private native boolean isResourcesZippedInBundle();
    
    private native void setNewInstallTime();
    
    private native boolean unzipAssetsToLocalCopy();
    
    class Checksum
      implements Comparable<Checksum>
    {
      private String checksum;
      private Long date;
      private String machine;
      
      static
      {
        JniLib.a(Checksum.class, 1145);
      }
      
      public Checksum(JSONObject paramJSONObject)
        throws JSONException
      {
        this.checksum = paramJSONObject.getString("checksum");
        this.date = Long.valueOf(paramJSONObject.getLong("date"));
        this.machine = paramJSONObject.getString("machine");
      }
      
      public native int compareTo(Checksum paramChecksum);
      
      public native String getChecksum();
      
      public native Long getDate();
      
      public native String getMachine();
    }
  }
  
  private class PrepareClientAsyncTask
    extends AsyncTask<Bundle, Void, Bundle>
  {
    static
    {
      JniLib.a(PrepareClientAsyncTask.class, 1147);
    }
    
    private PrepareClientAsyncTask() {}
    
    protected Bundle doInBackground(Bundle... paramVarArgs)
    {
      WLDroidGap.this.doPrepareAssetsWork();
      return paramVarArgs[0];
    }
    
    protected native void onPostExecute(Bundle paramBundle);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\WLDroidGap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */