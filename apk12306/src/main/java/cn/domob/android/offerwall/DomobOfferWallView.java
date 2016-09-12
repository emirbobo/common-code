package cn.domob.android.offerwall;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.net.URI;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class DomobOfferWallView
  extends RelativeLayout
{
  private static m a = new m(DomobOfferWallView.class.getSimpleName());
  private String b;
  private a c;
  private h d;
  private DomobOfferWallListener e;
  private boolean f = false;
  private boolean g = false;
  
  public DomobOfferWallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DomobOfferWallView(Context paramContext, String paramString)
  {
    super(paramContext);
    a.b("New instance of DomobOfferWallView.");
    setBackgroundColor(0);
    this.b = paramString;
    this.c = new a(paramContext, 0);
    c();
    this.c.loadUrl("file:///android_asset/index.html");
    addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    this.d = new h(this);
    Log.i("DomobSDK", "Current SDK version is " + l.a());
    Log.i("DomobSDK", "Publisher ID is set as " + this.b);
    Log.i("DomobSDK", "Application Package Name is " + f.a(paramContext));
    DomobOfferWallSetting.a(this.b);
  }
  
  private void b(final String paramString)
  {
    ((Activity)getContext()).runOnUiThread(new Runnable()
    {
      public void run()
      {
        DomobOfferWallView.b(DomobOfferWallView.this).a(String.format("domob.failed(%s)", new Object[] { paramString }));
        DomobOfferWallView.b(DomobOfferWallView.this).invalidate();
        if ("404".equals(paramString)) {
          if (DomobOfferWallView.c(DomobOfferWallView.this) != null) {
            DomobOfferWallView.c(DomobOfferWallView.this).onOfferWallLoadFinished(DomobOfferWallView.this);
          }
        }
        for (;;)
        {
          return;
          if (DomobOfferWallView.c(DomobOfferWallView.this) != null) {
            DomobOfferWallView.c(DomobOfferWallView.this).onOfferWallLoadFailed(DomobOfferWallView.this);
          }
        }
      }
    });
  }
  
  private void c()
  {
    this.c.a(new a.a()
    {
      public void a(a paramAnonymousa, String paramAnonymousString)
      {
        DomobOfferWallView.b().b("Intercepted URL: " + paramAnonymousString);
        if (!l.e(paramAnonymousString))
        {
          paramAnonymousa = URI.create(paramAnonymousString);
          if ("domob".equals(paramAnonymousa.getScheme()))
          {
            if (!"click".equals(paramAnonymousa.getHost())) {
              break label179;
            }
            paramAnonymousa = URLEncodedUtils.parse(paramAnonymousa, "UTF-8");
            if ((paramAnonymousa == null) || (paramAnonymousa.get(0) == null) || (!"id".equals(((NameValuePair)paramAnonymousa.get(0)).getName()))) {}
          }
        }
        for (;;)
        {
          int i;
          try
          {
            i = Integer.valueOf(((NameValuePair)paramAnonymousa.get(0)).getValue()).intValue();
            paramAnonymousString = DomobOfferWallView.b();
            paramAnonymousa = new java/lang/StringBuilder;
            paramAnonymousa.<init>();
            paramAnonymousString.b("Item was clicked with app id: " + i);
            DomobOfferWallView.a(DomobOfferWallView.this).b(i);
            return;
          }
          catch (Exception paramAnonymousa)
          {
            DomobOfferWallView.b().a(paramAnonymousa);
            continue;
          }
          label179:
          if ("download".equals(paramAnonymousa.getHost()))
          {
            paramAnonymousa = URLEncodedUtils.parse(paramAnonymousa, "UTF-8");
            if ((paramAnonymousa != null) && (paramAnonymousa.get(0) != null) && ("id".equals(((NameValuePair)paramAnonymousa.get(0)).getName()))) {
              try
              {
                i = Integer.valueOf(((NameValuePair)paramAnonymousa.get(0)).getValue()).intValue();
                DomobOfferWallView.b().b(String.format("Item with ID = %d is about to be downloaded.", new Object[] { Integer.valueOf(i) }));
                DomobOfferWallView.a(DomobOfferWallView.this).a(i);
              }
              catch (Exception paramAnonymousa)
              {
                DomobOfferWallView.b().a(paramAnonymousa);
              }
            } else {
              DomobOfferWallView.b().e("Cannot search download info without id.");
            }
          }
          else if ("refresh".equals(paramAnonymousa.getHost()))
          {
            DomobOfferWallView.b().b("Called refresh from web page. Load offer wall again.");
            DomobOfferWallView.this.loadOfferWall();
          }
        }
      }
    });
  }
  
  private void d()
  {
    boolean bool1 = true;
    m localm = a;
    boolean bool2 = this.g;
    boolean bool3 = this.f;
    if (getVisibility() == 0) {}
    for (;;)
    {
      localm.b(String.format("In tryReportShowList: mIsViewOnWindow=%s, mViewHasData=%s, is visible=%s", new Object[] { String.valueOf(bool2), String.valueOf(bool3), String.valueOf(bool1) }));
      if ((this.g) && (this.f) && (getVisibility() == 0)) {
        this.d.b();
      }
      return;
      bool1 = false;
    }
  }
  
  private void e()
  {
    if ((!this.g) && (this.f)) {
      this.d.c();
    }
  }
  
  protected void a()
  {
    b("");
  }
  
  protected void a(final String paramString)
  {
    ((Activity)getContext()).runOnUiThread(new Runnable()
    {
      public void run()
      {
        DomobOfferWallView.b(DomobOfferWallView.this).a(String.format("domob.setData(%s)", new Object[] { paramString }));
        DomobOfferWallView.b(DomobOfferWallView.this).invalidate();
        if (DomobOfferWallView.c(DomobOfferWallView.this) != null) {
          DomobOfferWallView.c(DomobOfferWallView.this).onOfferWallLoadFinished(DomobOfferWallView.this);
        }
      }
    });
    this.f = true;
    d();
  }
  
  public void loadOfferWall()
  {
    a.b("Start to load Domob offer wall.");
    this.f = false;
    if (f.a(4, false)) {
      this.d.a();
    }
    for (;;)
    {
      if (this.e != null) {
        this.e.onOfferWallLoadStart(this);
      }
      return;
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          DomobOfferWallView.a(DomobOfferWallView.this, "404");
        }
      }, 1000L);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a.b("Offer Wall View is attached to window.");
    invalidate();
    this.g = true;
    d();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a.b("Offer Wall View is detached from window.");
    this.g = false;
    e();
  }
  
  public void setOfferWallListener(DomobOfferWallListener paramDomobOfferWallListener)
  {
    this.e = paramDomobOfferWallListener;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\DomobOfferWallView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */