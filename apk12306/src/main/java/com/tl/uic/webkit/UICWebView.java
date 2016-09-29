package com.tl.uic.webkit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.bangcle.andjni.JniLib;
import java.util.Date;
import java.util.Map;
import org.apache.http.HttpResponse;

public class UICWebView
  extends WebView
{
  private long connectionInitFromSession;
  private Date endLoad;
  private HttpResponse httpResponse;
  private Date initTime;
  private long responseTime;
  private Date startLoad;
  private String url;
  
  static
  {
    JniLib.a(UICWebView.class, 1134);
  }
  
  public UICWebView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public UICWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public UICWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private native void init();
  
  public final native Date getEndLoad();
  
  public final native HttpResponse getHttpResponse();
  
  public final native Date getInitTime();
  
  public final native long getResponseTime();
  
  public final native Date getStartLoad();
  
  public native void loadData(String paramString1, String paramString2, String paramString3);
  
  @SuppressLint({"NewApi"})
  public native void loadUrl(String paramString);
  
  public final native void loadUrl(String paramString, Map<String, String> paramMap);
  
  public final native void logConnection();
  
  public final native void setEndLoad(Date paramDate);
  
  public final native void setHttpResponse(HttpResponse paramHttpResponse);
  
  public final native void setInitTime(Date paramDate);
  
  public final native void setResponseTime(long paramLong);
  
  public final native void setStartLoad(Date paramDate);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\webkit\UICWebView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */