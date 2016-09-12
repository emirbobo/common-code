package com.tl.uic.util;

import android.os.AsyncTask;
import com.bangcle.andjni.JniLib;
import com.tl.uic.webkit.UICWebView;
import java.util.Date;
import java.util.Map;
import org.apache.http.HttpResponse;

public class LoadUrlTask
  extends AsyncTask<String, Void, HttpResponse>
{
  private static final int BUFFER_SIZE = 8192;
  private final Map<String, String> extraHeaders;
  private String urlToLoad;
  private final UICWebView webView;
  
  static
  {
    JniLib.a(LoadUrlTask.class, 1121);
  }
  
  public LoadUrlTask(UICWebView paramUICWebView, Map<String, String> paramMap)
  {
    this.webView = paramUICWebView;
    this.extraHeaders = paramMap;
    this.webView.setInitTime(new Date());
  }
  
  private native HttpResponse doRequest(String paramString);
  
  protected final HttpResponse doInBackground(String... paramVarArgs)
  {
    this.urlToLoad = paramVarArgs[0];
    return doRequest(this.urlToLoad);
  }
  
  protected final native void onPostExecute(HttpResponse paramHttpResponse);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\LoadUrlTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */