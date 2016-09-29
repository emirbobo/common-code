package cn.domob.wall.core.a;

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
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
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
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.e;
import cn.domob.wall.core.h.f;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class b
{
  private static final String A = "a_banner.png";
  private static final String B = "a_exit.png";
  private static final String C = "a_exit_on.png";
  private static final String D = "a_loading.png";
  private static final String E = "a_next_off.png";
  private static final String F = "a_next.png";
  private static final String G = "a_next_on.png";
  private static final String H = "a_out.png";
  private static final String I = "a_out_on.png";
  private static final String J = "a_preview_off.png";
  private static final String K = "a_preview.png";
  private static final String L = "a_preview_on.png";
  private static final String M = "a_refresh.png";
  private static final String N = "a_refresh_on.png";
  private static final int O = 35;
  private static final int P = 35;
  private static final int Q = 45;
  private static final int R = 500;
  private static final String[] S = { ".mp4", ".3gp", ".asf", ".avi", ".m4u", ".m4v", ".mov", ".mp4", ".mpe", ".mpeg", ".mpg", ".mpg4" };
  private static d b = new d(b.class.getSimpleName());
  private static final String x = "close";
  private static final String y = "inapp";
  private static final String z = "url";
  AdInfo a;
  private WebView c;
  private String d = null;
  private Context e = null;
  private String f;
  private Dialog g = null;
  private a h;
  private Handler i = new Handler();
  private RelativeLayout j;
  private float k = 1.0F;
  private View l;
  private ImageButton m;
  private ImageButton n;
  private ImageButton o;
  private ImageButton p;
  private ImageButton q;
  private ImageView r;
  private RotateAnimation s;
  private Animation t;
  private Animation u;
  private boolean v = false;
  private boolean w = false;
  
  public b(Context paramContext, String paramString1, String paramString2, a parama, AdInfo paramAdInfo)
  {
    this.a = paramAdInfo;
    b.a(this, "Initialize LandingPageBuilder");
    this.e = paramContext;
    this.k = e.s(this.e);
    this.c = new WebView(this.e);
    this.d = paramString1;
    this.f = paramString2;
    this.h = parama;
    try
    {
      this.l = d();
      e();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        b.a(paramContext);
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
        b.a(paramContext);
        b.e("Failed to load source file:" + paramString);
        paramContext = null;
      }
    }
  }
  
  private LinearLayout a(String paramString, ImageButton paramImageButton)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    paramImageButton.setBackgroundDrawable(a(this.e, paramString));
    paramImageButton.setLayoutParams(new LinearLayout.LayoutParams((int)(this.k * 35.0F), (int)(this.k * 35.0F)));
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
    LinearLayout localLinearLayout = new LinearLayout(this.e);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(17);
    localLinearLayout.setBackgroundDrawable(a(this.e, "a_banner.png"));
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
    this.r = new ImageView(this.e);
    this.r.setBackgroundDrawable(new BitmapDrawable(BitmapFactory.decodeStream(getClass().getClassLoader().getResourceAsStream("assets/a_loading.png"))));
    this.r.setVisibility(8);
    this.s = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.s.setDuration(1000L);
    this.s.setInterpolator(new LinearInterpolator());
    this.s.setRepeatCount(-1);
  }
  
  private boolean f()
  {
    if ((this.e instanceof Activity)) {}
    for (boolean bool = a(((Activity)this.e).getWindow().getAttributes().flags, 1024);; bool = false) {
      return bool;
    }
  }
  
  private WebView g()
  {
    s();
    this.c.setVisibility(0);
    this.c.getSettings().setJavaScriptEnabled(true);
    this.c.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.c.getSettings().setUseWideViewPort(true);
    this.c.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, final String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        paramAnonymousString2 = paramAnonymousString1.substring(paramAnonymousString1.lastIndexOf("."));
        b.b().a(b.this, paramAnonymousString1 + "----on Download start:" + paramAnonymousString2);
        if (Arrays.asList(b.c()).contains(paramAnonymousString2))
        {
          paramAnonymousString2 = null;
          if ((b.e(b.this) instanceof Activity)) {
            paramAnonymousString2 = (Activity)b.e(b.this);
          }
          if ((paramAnonymousString2 == null) || (!paramAnonymousString2.isFinishing()))
          {
            b.a(b.this, true);
            b.f(b.this);
            Toast.makeText(b.e(b.this), "Loading video...", 0).show();
            paramAnonymousString2 = new Dialog(b.e(b.this), 16973831);
            paramAnonymousString2.setOnDismissListener(new DialogInterface.OnDismissListener()
            {
              public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
              {
                b.b().b(b.this, "Video dialog dismissed.");
                b.a(b.this, false);
                b.g(b.this);
                if (b.h(b.this) == null) {
                  b.i(b.this);
                }
              }
            });
            paramAnonymousString3 = new VideoView(b.e(b.this));
            paramAnonymousString3.setVideoURI(Uri.parse(paramAnonymousString1));
            paramAnonymousString1 = new MediaController(b.e(b.this));
            paramAnonymousString1.setMediaPlayer(paramAnonymousString3);
            paramAnonymousString1.setAnchorView(paramAnonymousString3);
            paramAnonymousString3.setMediaController(paramAnonymousString1);
            paramAnonymousString3.setOnErrorListener(new MediaPlayer.OnErrorListener()
            {
              public boolean onError(MediaPlayer paramAnonymous2MediaPlayer, int paramAnonymous2Int1, int paramAnonymous2Int2)
              {
                b.b().e(b.this, "Video play error.");
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
            paramAnonymousString1 = new RelativeLayout(b.e(b.this));
            paramAnonymousString1.setBackgroundColor(-16777216);
            paramAnonymousString1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            paramAnonymousString4 = new RelativeLayout.LayoutParams(-1, -1);
            paramAnonymousString4.addRule(13);
            paramAnonymousString1.addView(paramAnonymousString3, paramAnonymousString4);
            paramAnonymousString2.setContentView(paramAnonymousString1);
            paramAnonymousString2.show();
            paramAnonymousString3.start();
            paramAnonymousString3.requestFocus();
          }
        }
        for (;;)
        {
          return;
          b.b().b("should not alert a dialog now");
          continue;
          if (b.c(b.this) != null) {
            b.c(b.this).a(paramAnonymousString1, b.h(b.this), b.this.a);
          }
        }
      }
    });
    this.c.setWebViewClient(new b());
    this.c.setWebChromeClient(new WebChromeClient()
    {
      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        b.j(b.this);
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
      }
    });
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(12);
    this.c.setLayoutParams(localLayoutParams);
    this.c.loadUrl(this.d);
    return this.c;
  }
  
  private LinearLayout h()
  {
    this.q = new ImageButton(this.e);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.k * 35.0F), (int)(this.k * 35.0F));
    this.q.setLayoutParams(localLayoutParams);
    this.q.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        b.i(b.this);
      }
    });
    this.q.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          b.k(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_exit_on.png"));
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            b.k(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_exit.png"));
          }
        }
      }
    });
    return a("a_exit.png", this.q);
  }
  
  private void i()
  {
    this.u = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    this.u.setDuration(500L);
    this.j.startAnimation(this.u);
    this.i.postDelayed(new Runnable()
    {
      public void run()
      {
        b.l(b.this).dismiss();
      }
    }, 500L);
  }
  
  private LinearLayout j()
  {
    this.m = new ImageButton(this.e);
    Object localObject = new LinearLayout.LayoutParams((int)(this.k * 35.0F), (int)(this.k * 35.0F));
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    if (this.c.canGoBack()) {}
    for (localObject = "a_preview.png";; localObject = "a_preview_off.png")
    {
      this.m.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          b.m(b.this);
        }
      });
      this.m.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if (b.a(b.this).canGoBack())
          {
            if (paramAnonymousMotionEvent.getAction() != 0) {
              break label48;
            }
            b.n(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_preview_on.png"));
          }
          for (;;)
          {
            return false;
            label48:
            if (paramAnonymousMotionEvent.getAction() == 1) {
              b.n(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_preview.png"));
            }
          }
        }
      });
      return a((String)localObject, this.m);
    }
  }
  
  private void k()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      if (this.c.canGoBack())
      {
        this.c.goBack();
        r();
      }
    }
  }
  
  private LinearLayout l()
  {
    this.n = new ImageButton(this.e);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.k * 35.0F), (int)(this.k * 35.0F));
    this.n.setLayoutParams(localLayoutParams);
    this.n.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        b.o(b.this);
      }
    });
    this.n.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (b.a(b.this).canGoForward())
        {
          if (paramAnonymousMotionEvent.getAction() != 0) {
            break label48;
          }
          b.p(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_next_on.png"));
        }
        for (;;)
        {
          return false;
          label48:
          if (paramAnonymousMotionEvent.getAction() == 1) {
            b.p(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_next.png"));
          }
        }
      }
    });
    return a("a_next_off.png", this.n);
  }
  
  private void m()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      if (this.c.canGoForward())
      {
        this.c.goForward();
        r();
      }
    }
  }
  
  private LinearLayout n()
  {
    this.o = new ImageButton(this.e);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.k * 35.0F), (int)(this.k * 35.0F));
    this.o.setLayoutParams(localLayoutParams);
    this.o.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          b.q(b.this);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            b.b().e(this, "intent " + b.r(b.this) + " error");
          }
        }
      }
    });
    this.o.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          b.s(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_out_on.png"));
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            b.s(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_out.png"));
          }
        }
      }
    });
    return a("a_out.png", this.o);
  }
  
  private void o()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(this.d));
    this.e.startActivity(localIntent);
  }
  
  private LinearLayout p()
  {
    this.p = new ImageButton(this.e);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams((int)(this.k * 35.0F), (int)(this.k * 35.0F));
    this.p.setLayoutParams(localLayoutParams);
    this.p.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          b.t(b.this);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            b.b().e(this, "intent " + b.r(b.this) + " error");
          }
        }
      }
    });
    this.p.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          b.u(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_refresh_on.png"));
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            b.u(b.this).setBackgroundDrawable(b.a(b.this, b.e(b.this), "a_refresh.png"));
          }
        }
      }
    });
    return a("a_refresh.png", this.p);
  }
  
  private void q()
  {
    if (this.c == null) {}
    for (;;)
    {
      return;
      this.c.reload();
    }
  }
  
  private void r()
  {
    if (this.c.canGoBack())
    {
      this.m.setBackgroundDrawable(a(this.e, "a_preview.png"));
      if (!this.c.canGoForward()) {
        break label75;
      }
      this.n.setBackgroundDrawable(a(this.e, "a_next.png"));
    }
    for (;;)
    {
      return;
      this.m.setBackgroundDrawable(a(this.e, "a_preview_off.png"));
      break;
      label75:
      this.n.setBackgroundDrawable(a(this.e, "a_next_off.png"));
    }
  }
  
  private void s()
  {
    int i2 = 1;
    int i1;
    if (this.r != null)
    {
      i1 = 1;
      if (this.r == null) {
        break label49;
      }
    }
    for (;;)
    {
      if ((i1 & i2) != 0)
      {
        this.r.setVisibility(0);
        this.r.startAnimation(this.s);
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
    if (this.r != null)
    {
      i1 = 1;
      if (this.r == null) {
        break label57;
      }
      i2 = 1;
      label20:
      if (this.w) {
        break label62;
      }
    }
    for (;;)
    {
      if ((i1 & i2 & i3) != 0)
      {
        this.r.clearAnimation();
        this.r.setVisibility(8);
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
    b.a(this, "Start to build FS/RFS landingpage");
    this.j = new RelativeLayout(this.e);
    this.j.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.j.addView(g());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.j.addView(this.r, localLayoutParams);
    if (f())
    {
      this.g = new Dialog(this.e, 16973841);
      ((RelativeLayout.LayoutParams)this.c.getLayoutParams()).bottomMargin = ((int)(this.k * 45.0F));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.k * 45.0F));
      localLayoutParams.addRule(12);
      this.j.addView(this.l, localLayoutParams);
    }
    for (;;)
    {
      this.t = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      this.t.setDuration(500L);
      this.j.startAnimation(this.t);
      this.g.getWindow().getAttributes().dimAmount = 0.5F;
      this.g.getWindow().setFlags(2, 2);
      this.g.setContentView(this.j);
      this.g.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          b.b(b.this).removeView(b.a(b.this));
          if (b.c(b.this) != null) {
            b.c(b.this).l(b.this.a);
          }
          if ((!b.d(b.this)) && (b.c(b.this) != null)) {
            b.c(b.this).k(b.this.a);
          }
        }
      });
      return this.g;
      this.g = new Dialog(this.e, 16973840);
      ((RelativeLayout.LayoutParams)this.c.getLayoutParams()).bottomMargin = ((int)(this.k * 45.0F));
      localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(this.k * 45.0F));
      localLayoutParams.addRule(12);
      this.j.addView(this.l, localLayoutParams);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, WebView paramWebView, AdInfo paramAdInfo);
    
    public abstract void a(String paramString1, String paramString2, AdInfo paramAdInfo);
    
    public abstract void i(AdInfo paramAdInfo);
    
    public abstract void j(AdInfo paramAdInfo);
    
    public abstract void k(AdInfo paramAdInfo);
    
    public abstract void l(AdInfo paramAdInfo);
  }
  
  class b
    extends WebViewClient
  {
    b() {}
    
    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      b.b().a("onPageFinished with URL:" + paramString);
      b.b(b.this, true);
      if (b.c(b.this) != null) {
        b.c(b.this).i(b.this.a);
      }
      b.g(b.this);
      b.j(b.this);
    }
    
    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      b.b().a("onPageStarted with URL:" + paramString);
      b.f(b.this);
      b.j(b.this);
    }
    
    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      if (b.c(b.this) != null) {
        b.c(b.this).j(b.this.a);
      }
      b.b().e(b.this, String.format("WebView ReceivedError, errorCode=%d, description=%s, failingUrl=%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 }));
    }
    
    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      b.b().a("Override URL loading in landing page:" + paramString);
      Object localObject2;
      Object localObject1;
      if (paramString.startsWith(f.a()))
      {
        localObject2 = Uri.parse(paramString);
        localObject1 = ((Uri)localObject2).getHost();
        if (((String)localObject1).equals("close")) {
          b.i(b.this);
        }
      }
      label194:
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
            b.b().e("Error happened during loading Landing Page.");
            b.b().a(localException);
          }
        }
        b.b().a("Load landing page with URL:" + (String)localObject1);
        paramWebView.loadUrl((String)localObject1);
        for (;;)
        {
          if (b.c(b.this) == null) {
            break label194;
          }
          b.c(b.this).a(paramString, b.a(b.this), b.this.a);
          break;
          if (paramString.startsWith("http")) {
            paramWebView.loadUrl(paramString);
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */