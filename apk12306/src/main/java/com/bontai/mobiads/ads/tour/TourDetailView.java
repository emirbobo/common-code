package com.bontai.mobiads.ads.tour;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.ADDialog;

public class TourDetailView
  extends RelativeLayout
{
  private ImageView backIV;
  private Context context;
  private Drawable drawableForward;
  private Drawable drawableForwardOff;
  private Drawable drawablePreview;
  private Drawable drawablePreviewOff;
  private ImageView forwardIV;
  private WebView mWebView;
  private ProgressBar progressBar;
  private String targetUrl;
  private ADDialog tourDetailDialog;
  private TextView tvTitle;
  
  static
  {
    JniLib.a(TourDetailView.class, 238);
  }
  
  public TourDetailView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TourDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.context = paramContext;
  }
  
  private native void dismissTourDetail();
  
  public native void action(View paramView);
  
  public native void back(View paramView);
  
  public native void dealMainpage(View paramView);
  
  public native void exit(View paramView);
  
  public native void forward(View paramView);
  
  public native String getTargetUrl();
  
  public native void jumpTourDetailView();
  
  @SuppressLint({"NewApi"})
  public native void refresh(View paramView);
  
  public native void setTargetUrl(String paramString);
  
  private class MyWebViewDownLoadListener
    implements DownloadListener
  {
    static
    {
      JniLib.a(MyWebViewDownLoadListener.class, 236);
    }
    
    private MyWebViewDownLoadListener() {}
    
    public native void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
  }
  
  public class xWebChromeClient
    extends WebChromeClient
  {
    static
    {
      JniLib.a(xWebChromeClient.class, 237);
    }
    
    public xWebChromeClient() {}
    
    public native void onProgressChanged(WebView paramWebView, int paramInt);
    
    public native void onReceivedTitle(WebView paramWebView, String paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\tour\TourDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */