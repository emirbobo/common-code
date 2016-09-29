package cn.domob.android.ads.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import android.widget.VideoView;
import cn.domob.android.b.a;
import cn.domob.android.i.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class d
{
  private static final String A = "domob_banner.png";
  private static final String B = "domob_exit.png";
  private static final String C = "domob_exit_on.png";
  private static final String D = "domob_loading.png";
  private static final String E = "domob_next_off.png";
  private static final String F = "domob_next.png";
  private static final String G = "domob_next_on.png";
  private static final String H = "domob_out.png";
  private static final String I = "domob_out_on.png";
  private static final String J = "domob_preview_off.png";
  private static final String K = "domob_preview.png";
  private static final String L = "domob_preview_on.png";
  private static final String M = "domob_refresh.png";
  private static final String N = "domob_refresh_on.png";
  private static final int O = 35;
  private static final int P = 35;
  private static final int Q = 45;
  private static final int R = 500;
  private static final String[] S = { ".mp4", ".3gp", ".asf", ".avi", ".m4u", ".m4v", ".mov", ".mp4", ".mpe", ".mpeg", ".mpg", ".mpg4" };
  private static f a = new f(d.class.getSimpleName());
  private static final String w = "domob";
  private static final String x = "close";
  private static final String y = "inapp";
  private static final String z = "url";
  private WebView b;
  private String c = null;
  private Context d = null;
  private String e;
  private Dialog f = null;
  private b g;
  private Handler h = new Handler();
  private RelativeLayout i;
  private float j = 1.0F;
  private View k;
  private ImageButton l;
  private ImageButton m;
  private ImageButton n;
  private ImageButton o;
  private ImageButton p;
  private ImageView q;
  private RotateAnimation r;
  private Animation s;
  private Animation t;
  private boolean u = false;
  private boolean v = false;
  
  public d(Context paramContext, String paramString1, String paramString2, b paramb)
  {
    a.a(this, "Initialize DomobLandingPageBuilder");
    this.d = paramContext;
    this.j = a.t(this.d);
    this.b = new WebView(this.d);
    this.c = paramString1;
    this.e = paramString2;
    this.g = paramb;
    try
    {
      this.k = d();
      e();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
  }
  
  private Drawable a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new android/graphics/drawable/BitmapDrawable;
      ClassLoader localClassLoader = getClass().getClassLoader();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramContext.<init>(BitmapFactory.decodeStream(localClassLoader.getResourceAsStream("assets/" + paramString)));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
        a.e("Failed to load source file:" + paramString);
        paramContext = null;
      }
    }
  }
  
  private LinearLayout a(String paramString, ImageButton paramImageButton)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    paramImageButton.setBackgroundDrawable(a(this.d, paramString));
    paramImageButton.setLayoutParams(new LinearLayout.LayoutParams((int)(this.j * 35.0F), (int)(this.j * 35.0F)));
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0F));
    localLinearLayout.setGravity(17);
    localLinearLayout.addView(paramImageButton);
    return localLinearLayout;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int i1 = Integer.toBinaryString(paramInt2).length() - 1;
    if ((paramInt1 >>> i1) % 2 == (paramInt2 >>> i1) % 2) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private View d()
    throws IOException
  {
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundDrawable(a(this.d, "domob_banner.png"));
    localLinearLayout.addView(j());
    localLinearLayout.addView(l());
    localLinearLayout.addView(p());
    localLinearLayout.addView(n());
    localLinearLayout.addView(h());
    return localLinearLayout;
  }
  
  private void e()
    throws IOException
  {
    this.q = new ImageView(this.d);
    this.q.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeStream(getClass().getClassLoader().getResourceAsStream("assets/domob_loading.png"))));
    this.q.setVisibility(8);
    this.r = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.r.setDuration(1000L);
    this.r.setInterpolator(new LinearInterpolator());
    this.r.setRepeatCount(-1);
  }
  
  private boolean f()
  {
    if ((this.d instanceof Activity)) {}
    for (boolean bool = a(((Activity)this.d).getWindow().getAttributes().flags, 1024);; bool = false) {
      return bool;
    }
  }
  
  private WebView g()
  {
    s();
    this.b.setVisibility(0);
    this.b.getSettings().setJavaScriptEnabled(true);
    this.b.getSettings().setPluginState(WebSettings.PluginState.ON);
    this.b.getSettings().setGeolocationEnabled(true);
    this.b.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.b.getSettings().setUseWideViewPort(true);
    this.b.getSettings().setLoadWithOverviewMode(true);
    this.b.getSettings().setDomStorageEnabled(true);
    this.b.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, final String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        paramAnonymousString2 = paramAnonymousString1.substring(paramAnonymousString1.lastIndexOf("."));
        d.b().a(d.this, paramAnonymousString1 + "----on Download start:" + paramAnonymousString2);
        if (Arrays.asList(d.c()).contains(paramAnonymousString2))
        {
          paramAnonymousString2 = null;
          if ((d.e(d.this) instanceof Activity)) {
            paramAnonymousString2 = (Activity)d.e(d.this);
          }
          if ((paramAnonymousString2 == null) || (!paramAnonymousString2.isFinishing()))
          {
            d.a(d.this, true);
            d.f(d.this);
            Toast.makeText(d.e(d.this), "Loading video...", 0).show();
            paramAnonymousString2 = new Dialog(d.e(d.this), 16973831);
            paramAnonymousString2.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                d.b().b(d.this, "Video dialog dismissed.");
                d.a(d.this, false);
                d.g(d.this);
                if (d.h(d.this) == null) {
                  d.i(d.this);
                }
              }
            });
            paramAnonymousString3 = new VideoView(d.e(d.this));
            paramAnonymousString3.setVideoURI(Uri.parse(paramAnonymousString1));
            paramAnonymousString1 = new MediaController(d.e(d.this));
            paramAnonymousString1.setMediaPlayer(paramAnonymousString3);
            paramAnonymousString1.setAnchorView(paramAnonymousString3);
            paramAnonymousString3.setMediaController(paramAnonymousString1);
            paramAnonymousString3.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public boolean onError(MediaPlayer paramAnonymous2MediaPlayer, int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                d.b().e(d.this, "Video play error.");
                return false;
              }
            });
            paramAnonymousString3.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
            {
              public void onCompletion(MediaPlayer paramAnonymous2MediaPlayer)
              {
                paramAnonymousString2.dismiss();
              }
            });
            paramAnonymousString4 = new RelativeLayout(d.e(d.this));
            paramAnonymousString4.setBackgroundColor(-16777216);
            paramAnonymousString4.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            paramAnonymousString1 = new RelativeLayout.LayoutParams(-1, -1);
            paramAnonymousString1.addRule(13);
            paramAnonymousString4.addView(paramAnonymousString3, paramAnonymousString1);
            paramAnonymousString2.setContentView(paramAnonymousString4);
            paramAnonymousString2.show();
            paramAnonymousString3.start();
            paramAnonymousString3.requestFocus();
          }
        }
        for (;;)
        {
          return;
          d.b().b("should not alert a dialog now");
          continue;
          if (d.c(d.this) != null) {
            d.c(d.this).a(paramAnonymousString1, d.h(d.this));
          }
        }
      }
    });
    this.b.setWebViewClient(new a());
    this.b.setWebChromeClient(new WebChromeClient()
    {
      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        super.onGeolocationPermissionsShowPrompt(paramAnonymousString, paramAnonymousCallback);
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }
      
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        d.j(d.this);
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
      }
    });
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(12);
    this.b.setLayoutParams(localLayoutParams);
    this.b.loadUrl(this.c);
    return this.b;
  }
  
  private LinearLayout h()
  {
    this.p = new ImageButton(this.d);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.j * 35.0F), (int)(this.j * 35.0F));
    this.p.setLayoutParams(localLayoutParams);
    this.p.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        d.i(d.this);
      }
    });
    this.p.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          d.k(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_exit_on.png"));
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            d.k(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_exit.png"));
          }
        }
      }
    });
    return a("domob_exit.png", this.p);
  }
  
  private void i()
  {
    this.t = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.t.setDuration(500L);
    this.i.startAnimation(this.t);
    this.h.postDelayed(new Runnable()
    {
      public void run()
      {
        d.l(d.this).dismiss();
      }
    }, 500L);
  }
  
  private LinearLayout j()
  {
    this.l = new ImageButton(this.d);
    Object localObject = new LinearLayout.LayoutParams((int)(this.j * 35.0F), (int)(this.j * 35.0F));
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.b.canGoBack()) {}
    for (localObject = "domob_preview.png";; localObject = "domob_preview_off.png")
    {
      this.l.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          d.m(d.this);
        }
      });
      this.l.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (d.a(d.this).canGoBack())
          {
            if (paramAnonymousMotionEvent.getAction() != 0) {
              break label48;
            }
            d.n(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_preview_on.png"));
          }
          for (;;)
          {
            return false;
            label48:
            if (paramAnonymousMotionEvent.getAction() == 1) {
              d.n(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_preview.png"));
            }
          }
        }
      });
      return a((String)localObject, this.l);
    }
  }
  
  private void k()
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      if (this.b.canGoBack())
      {
        this.b.goBack();
        r();
      }
    }
  }
  
  private LinearLayout l()
  {
    this.m = new ImageButton(this.d);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.j * 35.0F), (int)(this.j * 35.0F));
    this.m.setLayoutParams(localLayoutParams);
    this.m.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        d.o(d.this);
      }
    });
    this.m.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (d.a(d.this).canGoForward())
        {
          if (paramAnonymousMotionEvent.getAction() != 0) {
            break label48;
          }
          d.p(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_next_on.png"));
        }
        for (;;)
        {
          return false;
          label48:
          if (paramAnonymousMotionEvent.getAction() == 1) {
            d.p(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_next.png"));
          }
        }
      }
    });
    return a("domob_next_off.png", this.m);
  }
  
  private void m()
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      if (this.b.canGoForward())
      {
        this.b.goForward();
        r();
      }
    }
  }
  
  private LinearLayout n()
  {
    this.n = new ImageButton(this.d);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.j * 35.0F), (int)(this.j * 35.0F));
    this.n.setLayoutParams(localLayoutParams);
    this.n.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          d.q(d.this);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            d.b().e(this, "intent " + d.r(d.this) + " error");
          }
        }
      }
    });
    this.n.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          d.s(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_out_on.png"));
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            d.s(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_out.png"));
          }
        }
      }
    });
    return a("domob_out.png", this.n);
  }
  
  private void o()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.c));
    this.d.startActivity(localIntent);
  }
  
  private LinearLayout p()
  {
    this.o = new ImageButton(this.d);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.j * 35.0F), (int)(this.j * 35.0F));
    this.o.setLayoutParams(localLayoutParams);
    this.o.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          d.t(d.this);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            d.b().e(this, "intent " + d.r(d.this) + " error");
          }
        }
      }
    });
    this.o.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          d.u(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_refresh_on.png"));
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            d.u(d.this).setBackgroundDrawable(d.a(d.this, d.e(d.this), "domob_refresh.png"));
          }
        }
      }
    });
    return a("domob_refresh.png", this.o);
  }
  
  private void q()
  {
    if (this.b == null) {}
    for (;;)
    {
      return;
      this.b.reload();
    }
  }
  
  private void r()
  {
    if (this.b.canGoBack())
    {
      this.l.setBackgroundDrawable(a(this.d, "domob_preview.png"));
      if (!this.b.canGoForward()) {
        break label75;
      }
      this.m.setBackgroundDrawable(a(this.d, "domob_next.png"));
    }
    for (;;)
    {
      return;
      this.l.setBackgroundDrawable(a(this.d, "domob_preview_off.png"));
      break;
      label75:
      this.m.setBackgroundDrawable(a(this.d, "domob_next_off.png"));
    }
  }
  
  private void s()
  {
    int i2 = 1;
    int i1;
    if (this.q != null)
    {
      i1 = 1;
      if (this.q == null) {
        break label49;
      }
    }
    for (;;)
    {
      if ((i1 & i2) != 0)
      {
        this.q.setVisibility(0);
        this.q.startAnimation(this.r);
      }
      return;
      i1 = 0;
      break;
      label49:
      i2 = 0;
    }
  }
  
  private void t()
  {
    int i3 = 1;
    int i1;
    int i2;
    if (this.q != null)
    {
      i1 = 1;
      if (this.q == null) {
        break label57;
      }
      i2 = 1;
      label20:
      if (this.v) {
        break label62;
      }
    }
    for (;;)
    {
      if ((i1 & i2 & i3) != 0)
      {
        this.q.clearAnimation();
        this.q.setVisibility(8);
      }
      return;
      i1 = 0;
      break;
      label57:
      i2 = 0;
      break label20;
      label62:
      i3 = 0;
    }
  }
  
  public Dialog a()
    throws Exception
  {
    a.a(this, "Start to build FS/RFS landingpage");
    this.i = new RelativeLayout(this.d);
    this.i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.i.addView(g());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.i.addView(this.q, localLayoutParams);
    if (f())
    {
      this.f = new Dialog(this.d, 16973841);
      ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).bottomMargin = ((int)(this.j * 45.0F));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.j * 45.0F));
      localLayoutParams.addRule(12);
      this.i.addView(this.k, localLayoutParams);
    }
    for (;;)
    {
      this.s = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      this.s.setDuration(500L);
      this.i.startAnimation(this.s);
      this.f.getWindow().getAttributes().dimAmount = 0.5F;
      this.f.getWindow().setFlags(2, 2);
      this.f.setContentView(this.i);
      this.f.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          d.b(d.this).removeView(d.a(d.this));
          if (d.c(d.this) != null) {
            d.c(d.this).u();
          }
          if ((!d.d(d.this)) && (d.c(d.this) != null)) {
            d.c(d.this).t();
          }
        }
      });
      return this.f;
      this.f = new Dialog(this.d, 16973840);
      ((RelativeLayout.LayoutParams)this.b.getLayoutParams()).bottomMargin = ((int)(this.j * 45.0F));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.j * 45.0F));
      localLayoutParams.addRule(12);
      this.i.addView(this.k, localLayoutParams);
    }
  }
  
  class a
    extends WebViewClient
  {
    a() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      d.b().a("onPageFinished with URL:" + paramString);
      d.b(d.this, true);
      if (d.c(d.this) != null) {
        d.c(d.this).r();
      }
      d.g(d.this);
      d.j(d.this);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      d.b().a("onPageStarted with URL:" + paramString);
      d.f(d.this);
      d.j(d.this);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (d.c(d.this) != null) {
        d.c(d.this).s();
      }
      d.b().e(d.this, String.format("WebView ReceivedError, errorCode=%d, description=%s, failingUrl=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }));
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      d.b().a("Override URL loading in landing page:" + paramString);
      Object localObject2;
      Object localObject1;
      if (paramString.startsWith("domob"))
      {
        localObject2 = Uri.parse(paramString);
        localObject1 = ((Uri)localObject2).getHost();
        if (((String)localObject1).equals("close")) {
          d.i(d.this);
        }
      }
      label186:
      for (;;)
      {
        return true;
        if (((String)localObject1).equals("inapp")) {
          localObject1 = null;
        }
        try
        {
          localObject2 = ((Uri)localObject2).getQueryParameter("url");
          localObject1 = localObject2;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            d.b().e("Error happened during loading Landing Page.");
            d.b().a(localException);
          }
        }
        d.b().a("Load landing page with URL:" + (String)localObject1);
        paramWebView.loadUrl((String)localObject1);
        for (;;)
        {
          if (d.c(d.this) == null) {
            break label186;
          }
          d.c(d.this).a(paramString, d.a(d.this));
          break;
          if (paramString.startsWith("http")) {
            paramWebView.loadUrl(paramString);
          }
        }
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString, WebView paramWebView);
    
    public abstract void a(String paramString1, String paramString2);
    
    public abstract void r();
    
    public abstract void s();
    
    public abstract void t();
    
    public abstract void u();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */