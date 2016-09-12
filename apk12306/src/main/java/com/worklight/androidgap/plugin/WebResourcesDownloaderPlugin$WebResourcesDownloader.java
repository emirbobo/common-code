package com.worklight.androidgap.plugin;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.bangcle.andjni.JniLib;
import com.worklight.androidgap.WLDroidGap;
import com.worklight.common.WLConfig;
import com.worklight.common.WLUtils;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;

public class WebResourcesDownloaderPlugin$WebResourcesDownloader
  extends AsyncTask<Void, Integer, String>
{
  private static final String CONTENT_TYPE_APPLICATION_ZIP = "application/zip";
  private static final String DOWNLOADED_ZIP_FILE_NAME = "assets.zip";
  private static final int HONEYCOMB = 11;
  private String cookies;
  private String downloadingMessage;
  private String instanceAuthId = null;
  private boolean isDirectUpdateSuccess = true;
  private ProgressDialog progressDialog;
  private boolean shouldUpdateSilently = false;
  private String skinName;
  private String url = null;
  private WLConfig wlConfig;
  private WLDroidGap wlDroidGap;
  
  static
  {
    JniLib.a(WebResourcesDownloader.class, 1206);
  }
  
  public WebResourcesDownloaderPlugin$WebResourcesDownloader(WebResourcesDownloaderPlugin paramWebResourcesDownloaderPlugin, WLDroidGap paramWLDroidGap, String paramString1, String paramString2, boolean paramBoolean, String paramString3, String paramString4, String paramString5)
  {
    this.wlDroidGap = paramWLDroidGap;
    this.wlConfig = new WLConfig(this.wlDroidGap);
    this.cookies = paramString1;
    this.instanceAuthId = paramString2;
    this.downloadingMessage = WLUtils.getResourceString(paramString3, paramWLDroidGap);
    this.skinName = paramString5;
    this.url = paramString4;
    this.shouldUpdateSilently = paramBoolean;
  }
  
  private native void createProgressDialog();
  
  private native void downloadZipFile()
    throws IOException;
  
  private native void extractZipFile(String paramString1, String paramString2)
    throws IOException;
  
  private native String handleUpdateException(String paramString1, String paramString2, int paramInt);
  
  private native void processZipFile()
    throws IOException;
  
  private native String runDirectUpdate();
  
  private native HttpResponse sendRequest()
    throws ClientProtocolException, IOException;
  
  protected String doInBackground(Void... paramVarArgs)
  {
    return runDirectUpdate();
  }
  
  protected native void onPostExecute(String paramString);
  
  protected native void onPreExecute();
  
  protected void onProgressUpdate(Integer... paramVarArgs)
  {
    this.progressDialog.setProgress(paramVarArgs[0].intValue());
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\androidgap\plugin\WebResourcesDownloaderPlugin$WebResourcesDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */