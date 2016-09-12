package org.apache.cordova;

import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import org.apache.cordova.api.LOG;

public class InAppBrowser$InAppChromeClient
  extends WebChromeClient
{
  public InAppBrowser$InAppChromeClient(InAppBrowser paramInAppBrowser) {}
  
  public void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    LOG.d("InAppBrowser", "onExceededDatabaseQuota estimatedSize: %d  currentQuota: %d  totalUsedQuota: %d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1), Long.valueOf(paramLong3) });
    if (paramLong2 < InAppBrowser.access$1000(this.this$0))
    {
      LOG.d("InAppBrowser", "calling quotaUpdater.updateQuota newQuota: %d", new Object[] { Long.valueOf(paramLong2) });
      paramQuotaUpdater.updateQuota(paramLong2);
    }
    for (;;)
    {
      return;
      paramQuotaUpdater.updateQuota(paramLong1);
    }
  }
  
  public void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    super.onGeolocationPermissionsShowPrompt(paramString, paramCallback);
    paramCallback.invoke(paramString, true, false);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\InAppBrowser$InAppChromeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */