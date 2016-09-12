package cn.domob.android.ads.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Vibrator;
import android.util.Log;
import android.webkit.WebView;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import cn.domob.android.ads.DomobActivity;
import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.E;
import cn.domob.android.ads.a.b;
import cn.domob.android.ads.e.a;
import cn.domob.android.ads.j;
import cn.domob.android.ads.j.c;
import cn.domob.android.ads.j.c.a;
import cn.domob.android.ads.k;
import cn.domob.android.ads.n;
import cn.domob.android.ads.q;
import cn.domob.android.ads.q.a;
import cn.domob.android.ads.v.a;
import cn.domob.android.ads.v.d;
import cn.domob.android.ads.w;
import cn.domob.android.ads.w.c;
import cn.domob.android.ads.w.h;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;

public class c
  extends n
  implements a.a, d.b, e.a, q.a
{
  private static final String A = "rt";
  private static final String B = "pattern";
  private static final String C = "url";
  private static final String D = "clk";
  private static final String E = "imp";
  private static final String F = "event";
  private static final String G = "visit";
  private static final String H = "url";
  private static final String I = "phase";
  private static final String J = "wtai://wp/mc;";
  private static final String K = "banner";
  private static final String L = "expandable";
  private static final String M = "tc";
  public static final String h = "domob";
  public static final String i = "cache";
  public static final String j = "groupID";
  public static final String k = "resourceID";
  public static final String l = "downloadUrl";
  private static f m = new f(c.class.getSimpleName());
  private static final String s = "report";
  private static final String t = "custom";
  private static final String u = "expand";
  private static final String v = "close";
  private static final String w = "form";
  private static final String x = "fetch";
  private static final String y = "url";
  private static final String z = "name";
  private cn.domob.android.f.g N;
  protected Handler g = new Handler(Looper.getMainLooper());
  private e n;
  private v.a o;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  
  public c(Context paramContext, k paramk, j paramj, cn.domob.android.ads.g paramg)
  {
    super(paramContext, paramk, paramj, paramg);
    m.b("New DomobHTMLAdAdapter instance.");
  }
  
  private String a(Uri paramUri, String paramString)
  {
    try
    {
      paramUri = paramUri.getQueryParameter(paramString);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      for (;;)
      {
        m.a(paramUri);
        paramUri = null;
      }
    }
  }
  
  private void a(Uri paramUri)
    throws Exception
  {
    paramUri = paramUri.getQueryParameter("tc");
    if ((paramUri == null) || (paramUri.equals("true"))) {
      p();
    }
  }
  
  private void a(final e parame, j.c.a parama, boolean paramBoolean)
  {
    int i2 = parama.h();
    int i1;
    String str;
    if (i2 < 0)
    {
      i1 = 5;
      m.a("Expandable timeout = " + i1);
      parame.a(i1);
      if (paramBoolean) {
        parame.a(new a.b()
        {
          public void a(cn.domob.android.ads.a paramAnonymousa)
          {
            c.v().b("Both banner and expandable part are ok in current creative. Show Ad.");
            c.l(c.this);
            if (c.m(c.this).d().n().i()) {
              c.a(c.this, c.n(c.this).d().n());
            }
          }
          
          public void b(cn.domob.android.ads.a paramAnonymousa)
          {
            c.v().e("FAILED to load domob expandable view.");
            c.d(c.this, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Expandable part load failed.");
          }
          
          public void c(cn.domob.android.ads.a paramAnonymousa)
          {
            c.v().a("Timeout while loading expandable part. Show AD.");
            c.k(c.this);
          }
        });
      }
      parame.a(new cn.domob.android.ads.a.a()
      {
        public void a(cn.domob.android.ads.a paramAnonymousa, String paramAnonymousString)
        {
          if ((paramAnonymousString.startsWith("domob")) && (Uri.parse(paramAnonymousString).getHost().equals("close"))) {
            c.o(c.this);
          }
          for (;;)
          {
            return;
            c.this.a(parame, paramAnonymousString, false);
          }
        }
      });
      str = parama.b();
      if (!h.e(str)) {
        break label137;
      }
      m.e("Content type of expandable is null or empty.");
      a(DomobAdManager.ErrorCode.INTERNAL_ERROR, "Content type of expandable is null or empty.");
    }
    for (;;)
    {
      return;
      i1 = i2;
      if (i2 <= this.d.y()) {
        break;
      }
      i1 = this.d.y();
      break;
      label137:
      if (str.equals("url"))
      {
        parama = parama.c();
        m.a("Get an DomobWebView instance for EXPANDABLE and load with URL:" + parama);
        parame.a(parama, null);
      }
      else if (str.equals("content"))
      {
        str = parama.d();
        parama = parama.e();
        m.a(String.format("Get an DomobWebView instance for EXPANDABLE and load data = [%s] with base URL=[%s]", new Object[] { parama, str }));
        parame.a(str, parama);
      }
    }
  }
  
  private void a(j.c.a parama)
  {
    int i2 = -1;
    m.a("Show expandable part of current creative.");
    if (this.n != null) {
      if (parama.k() == -1) {
        break label177;
      }
    }
    label177:
    for (int i1 = (int)(parama.k() * cn.domob.android.b.a.t(this.a));; i1 = -1)
    {
      if (parama.l() != -1) {
        i2 = (int)(parama.l() * cn.domob.android.b.a.t(this.a));
      }
      m.a(String.format("Expandable size is: %d * %d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) }));
      this.o = new v.a(this.a).a(i1, i2).a(false, false, false, true).a(parama.j()).a(new v.d()
      {
        public void a()
        {
          if (c.h(c.this) != null) {
            c.h(c.this).loadUrl("javascript:(window.domobjs && window.domobjs.onDismiss) ? domobjs.onDismiss() : null");
          }
          c.p(c.this);
        }
      });
      this.o.a(this.n);
      this.n.loadUrl("javascript:(window.domobjs && window.domobjs.onViewable) ? domobjs.onViewable() : null");
      j();
      for (;;)
      {
        return;
        m.e("Expandable part is null.");
      }
    }
  }
  
  private void a(String paramString, q paramq)
  {
    w localw = new w(this.a, this.d.n());
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.a = paramq.a().d().r();
    localc.d = paramq.c();
    localc.e = paramq.d();
    localc.f = paramq.e();
    localw.a(paramq.a().d().q(), w.h.b, paramString, localc, null);
  }
  
  private Uri b(Uri paramUri)
  {
    String str1;
    Object localObject;
    if (paramUri != null)
    {
      str1 = a(paramUri, "url");
      localObject = paramUri;
      if (str1 != null)
      {
        if (str1.startsWith("domob")) {
          break label37;
        }
        localObject = paramUri;
      }
    }
    for (;;)
    {
      return (Uri)localObject;
      label37:
      boolean bool;
      label50:
      String str3;
      String str2;
      int i1;
      label82:
      String str4;
      if (a(paramUri, "auto_run") == null)
      {
        bool = false;
        str3 = a(paramUri, "name");
        str2 = a(paramUri, "pkg");
        if (a(paramUri, "vc") != null) {
          break label346;
        }
        i1 = 1;
        str4 = a(paramUri, "vn");
        localObject = a(this.a, str1, "cache");
        paramUri = (String)((HashMap)localObject).get("groupID");
        String str5 = (String)((HashMap)localObject).get("resourceID");
        localObject = (String)((HashMap)localObject).get("downloadUrl");
        paramUri = a.a.a.a.a.a.a(this.a, paramUri, str5);
        if ((paramUri == null) || (h.e(paramUri.a()))) {
          break label364;
        }
        paramUri = "alreadyDownload:" + paramUri.a();
      }
      for (;;)
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("url", paramUri);
        ((HashMap)localObject).put("auto_run", String.valueOf(bool));
        ((HashMap)localObject).put("name", str3);
        ((HashMap)localObject).put("pkg", str2);
        ((HashMap)localObject).put("vc", String.valueOf(i1));
        ((HashMap)localObject).put("vn", str4);
        paramUri = h.a((HashMap)localObject);
        paramUri = "domob://download/?" + paramUri;
        m.b("download params: " + paramUri);
        localObject = Uri.parse(paramUri);
        break;
        bool = Boolean.valueOf(a(paramUri, "auto_run")).booleanValue();
        break label50;
        label346:
        i1 = Integer.valueOf(a(paramUri, "vc")).intValue();
        break label82;
        label364:
        paramUri = (Uri)localObject;
        if (h.e((String)localObject)) {
          paramUri = str1;
        }
      }
      localObject = null;
    }
  }
  
  private void b(String paramString)
  {
    b(paramString, null);
  }
  
  private void b(String paramString1, String paramString2)
  {
    w localw = new w(this.a, this.d.n());
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.a = this.c.d().r();
    if (paramString2 != null) {
      localc.h = paramString2;
    }
    localw.a(this.c.d().q(), w.h.c, paramString1, localc, null);
  }
  
  private void c(String paramString)
  {
    w localw = new w(this.a, this.d.n());
    localw.getClass();
    w.c localc = new w.c(localw);
    localc.a = this.c.d().r();
    localw.a(this.c.d().q(), w.h.h, paramString, localc, null);
  }
  
  private void n()
  {
    final j.c localc = this.c.d();
    this.g.post(new Runnable()
    {
      public void run()
      {
        e locale = new e(c.a(c.this), "banner", 0);
        locale.setLayoutParams(new FrameLayout.LayoutParams(c.b(c.this).a(), c.c(c.this).b()));
        c.a(c.this, locale);
        if (c.d(c.this).G()) {
          locale.a(c.e(c.this).d().J() / 1000);
        }
        locale.a(new a.b()
        {
          public void a(cn.domob.android.ads.a paramAnonymous2a)
          {
            c.v().a("Finished to load domob banner view.");
            paramAnonymous2a = c.f(c.this).d().n();
            if (paramAnonymous2a != null)
            {
              c.a(c.this, new e(c.g(c.this), "expandable", 0));
              c.v().b("There is expandable part in current creative.");
              c.a(c.this, c.h(c.this), paramAnonymous2a, paramAnonymous2a.g());
              if (!paramAnonymous2a.g()) {}
            }
            label147:
            for (;;)
            {
              return;
              c.v().b("Expandable preload is disabled in current creative. Show Ad.");
              for (;;)
              {
                if (c.i(c.this).G()) {
                  break label147;
                }
                c.j(c.this);
                break;
                c.v().b("Banner is ready and there is no expandable part in current creative. Show Ad.");
              }
            }
          }
          
          public void b(cn.domob.android.ads.a paramAnonymous2a)
          {
            c.v().e("FAILED to load domob banner view.");
            c.b(c.this, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load failed.");
          }
          
          public void c(cn.domob.android.ads.a paramAnonymous2a)
          {
            c.a(c.this, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load timeout.");
          }
        });
        locale.a(new cn.domob.android.ads.a.a()
        {
          public void a(cn.domob.android.ads.a paramAnonymous2a, String paramAnonymous2String)
          {
            c.v().b("Banner BaseWebView 拦截到 URL：" + paramAnonymous2String);
            c.this.a(paramAnonymous2a, paramAnonymous2String, true);
          }
        });
        String str = localc.k();
        if ((str != null) && (str.length() != 0)) {
          if (str.equals("url"))
          {
            c.v().a("Get an DomobWebView instance and load with URL:" + localc.j());
            locale.a(localc.j(), null);
          }
        }
        for (;;)
        {
          return;
          if (str.equals("content"))
          {
            c.v().a(String.format("Get an DomobWebView instance and load data = [%s] with base URL=[%s]", new Object[] { localc.m(), localc.l() }));
            locale.a(localc.l(), localc.m());
            continue;
            c.v().e("Content type is not available.");
            c.c(c.this, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Content type is illegal.");
          }
        }
      }
    });
  }
  
  private void o()
  {
    if (this.o != null) {
      this.o.a();
    }
  }
  
  private void p()
  {
    this.d.a(this.c);
    h();
  }
  
  private boolean q()
  {
    if ((!this.p) && (!this.r) && (!this.q)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void w()
  {
    this.p = false;
    this.q = false;
    this.r = false;
  }
  
  public HashMap<String, String> a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = new HashMap();
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (;;)
    {
      return paramContext;
      paramString1 = Uri.parse(paramString1);
      String str2 = paramString1.getScheme();
      String str1 = paramString1.getHost();
      if ((str2 != null) && ("domob".equals(str2)) && (str1 != null) && (paramString2.equals(str1)))
      {
        str1 = paramString1.getQueryParameter("rgid");
        paramString2 = paramString1.getQueryParameter("rid");
        paramString1 = paramString1.getQueryParameter("url");
        paramContext.put("groupID", str1);
        paramContext.put("resourceID", paramString2);
        paramContext.put("downloadUrl", paramString1);
      }
    }
  }
  
  public void a()
  {
    m.b("Start to load DomobHTML adapter.");
    n();
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(q paramq)
  {
    a("install_success", paramq);
  }
  
  public void a(String paramString, WebView paramWebView)
  {
    for (;;)
    {
      try
      {
        if (this.c.d().B()) {
          b("lp_url", paramString);
        }
        localObject = URI.create(paramString);
        str = ((URI)localObject).getScheme();
        localObject = ((URI)localObject).getHost();
        if (h.e(str)) {
          return;
        }
      }
      catch (Exception paramString)
      {
        Object localObject;
        String str;
        m.e("Error while parsing landingpage URL.");
        m.a(paramString);
        continue;
      }
      if (((!str.equals("domob")) || (h.e((String)localObject)) || (!((String)localObject).equals("inapp"))) && (!str.startsWith("http"))) {
        a(paramWebView, paramString, false);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    m.a(String.format("LandingPage 内下载，地址为%s，infoURL为%s", new Object[] { paramString1, paramString2 }));
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (paramString2.length() != 0)
        {
          localObject = h.a(Uri.parse(paramString2).getEncodedQuery());
          if (((HashMap)localObject).containsKey("url")) {
            ((HashMap)localObject).put("url", paramString1);
          }
          localObject = h.a((HashMap)localObject);
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localObject = "domob://download?" + (String)localObject;
          b(null, (String)localObject, false);
          return;
        }
      }
      catch (Exception localException)
      {
        Object localObject;
        m.e(String.format("解析LandingPage中下载出现错误，地址为%s，infoURL为%s", new Object[] { paramString1, paramString2 }));
        continue;
      }
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = "domob://download?url=" + URLEncoder.encode(paramString1, "UTF-8");
    }
  }
  
  public void a(HashMap<String, String> paramHashMap, String paramString, long paramLong)
  {
    this.d.a(this.c, paramHashMap, paramString, "s", paramLong, null, this.f);
  }
  
  public boolean a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    try
    {
      if (paramString.startsWith("domob"))
      {
        if (!"domob".equals(Uri.parse(paramString).getScheme())) {
          break label190;
        }
        m.a("Scheme domob action.");
        paramBoolean = b(paramWebView, paramString, paramBoolean);
      }
      for (;;)
      {
        return paramBoolean;
        if ((!paramString.startsWith("http")) && (!paramString.startsWith("tel:")) && (!paramString.startsWith("voicemail:")) && (!paramString.startsWith("sms:")) && (!paramString.startsWith("mailto:")) && (!paramString.startsWith("geo:")) && (!paramString.startsWith("wtai://wp/mc;"))) {
          break;
        }
        m.a("Handle other phone intents.");
        if (paramBoolean) {
          p();
        }
        if (paramString.startsWith("http"))
        {
          localObject = cn.domob.android.i.c.a(this.a, Uri.parse(paramString));
          paramWebView = (WebView)localObject;
          if (localObject == null)
          {
            paramWebView = new android/content/Intent;
            paramWebView.<init>("android.intent.action.VIEW", Uri.parse(paramString));
          }
          l();
          this.a.startActivity(paramWebView);
        }
        for (;;)
        {
          label190:
          paramBoolean = true;
          break;
          paramWebView = new android/content/Intent;
          paramWebView.<init>("android.intent.action.VIEW", Uri.parse(paramString));
          paramWebView.addFlags(268435456);
          if (paramString.startsWith("wtai://wp/mc;"))
          {
            m.a("Create intent for: wtai://wp/mc;");
            paramWebView = new android/content/Intent;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            paramWebView.<init>("android.intent.action.VIEW", Uri.parse("tel:" + paramString.substring("wtai://wp/mc;".length())));
          }
          try
          {
            this.a.startActivity(paramWebView);
            l();
          }
          catch (ActivityNotFoundException paramWebView)
          {
            localObject = f.b();
            paramWebView = new java/lang/StringBuilder;
            paramWebView.<init>();
            Log.w((String)localObject, "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
            paramBoolean = bool;
          }
        }
      }
    }
    catch (Exception paramWebView)
    {
      for (;;)
      {
        Object localObject;
        m.e("Exception in click.");
        m.a(paramWebView);
        paramBoolean = bool;
        continue;
        m.a("Handle unknown intents.");
        l();
        if (paramBoolean) {
          p();
        }
        paramWebView = new android/content/Intent;
        paramWebView.<init>("android.intent.action.VIEW", Uri.parse(paramString));
        paramWebView.addFlags(268435456);
        try
        {
          this.a.startActivity(paramWebView);
          l();
        }
        catch (ActivityNotFoundException paramWebView)
        {
          paramWebView = f.b();
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          Log.w(paramWebView, "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
        }
      }
    }
  }
  
  public void a_()
  {
    c("la_success");
    l();
  }
  
  public void a_(String paramString)
  {
    if (a(null, paramString, false)) {
      c("la_failsafe_success");
    }
    for (;;)
    {
      return;
      c("la_failsafe_failed");
    }
  }
  
  public void b(q paramq)
  {
    a("run", paramq);
  }
  
  protected boolean b(WebView paramWebView, String paramString, boolean paramBoolean)
    throws Exception
  {
    paramWebView = Uri.parse(paramString);
    String str = paramWebView.getHost();
    Object localObject;
    if ("inapp".equals(str))
    {
      if (paramBoolean) {
        a(paramWebView);
      }
      localObject = paramWebView.getQueryParameter("url");
      m.a("Open landing page with URL:" + (String)localObject);
      paramWebView = i();
      if (paramWebView != null)
      {
        w();
        new d(paramWebView, (String)localObject, paramString, this).a().show();
        ((Activity)paramWebView).runOnUiThread(new Runnable()
        {
          public void run()
          {
            c.q(c.this);
          }
        });
      }
    }
    for (;;)
    {
      a(str);
      paramBoolean = true;
      for (;;)
      {
        label120:
        return paramBoolean;
        if ("download".equals(str))
        {
          if (paramBoolean) {
            a(paramWebView);
          }
          paramString = paramWebView.getQueryParameter("url");
          paramWebView = b(paramWebView);
          if (paramWebView == null) {
            break;
          }
          new q(this.a, paramWebView, this.c, this).i();
          m.b("Download app with URL:" + paramString);
          break;
        }
        if ("launch".equals(str))
        {
          if (paramBoolean) {
            a(paramWebView);
          }
          new a(this.a, paramWebView, this).a();
          break;
        }
        if ("expand".equals(str))
        {
          if (paramBoolean) {
            a(paramWebView);
          }
          if (this.c.d().n() != null)
          {
            m.a("Expandable part url:" + this.c.d().n().c());
            m.a("Expandable part base and content:" + this.c.d().n().d() + " || " + this.c.d().n().e());
            a(this.c.d().n());
            break;
          }
          m.e("广告应答无Expandable部分，无法进行expand action。");
          paramBoolean = false;
          continue;
        }
        if (!"report".equals(str)) {
          break label736;
        }
        paramString = paramWebView.getPath();
        if ((paramString != null) && (paramString.indexOf("/") != -1)) {
          break label452;
        }
        m.e("There is no report type.");
        paramBoolean = false;
      }
      label452:
      paramString = paramString.substring(1);
      if (paramString.equals("imp"))
      {
        paramString = h.a(paramWebView.getEncodedQuery());
        paramWebView = "s";
        if (paramString.containsKey("phase"))
        {
          paramWebView = (String)paramString.get("phase");
          paramString.remove("phase");
        }
        this.d.a(this.c, paramString, paramWebView, "ac", 0L, null);
      }
      else if ("event".equals(paramString))
      {
        paramString = h.a(paramWebView.getEncodedQuery());
        paramWebView = this.c.d().q();
        if (paramString.containsKey("url"))
        {
          paramWebView = (String)paramString.get("url");
          paramString.remove("url");
        }
        localObject = new w(this.a, this.d.n());
        localObject.getClass();
        w.c localc = new w.c((w)localObject);
        localc.a = this.c.d().r();
        localc.b = "ac";
        ((w)localObject).a(paramWebView, null, null, localc, paramString);
      }
      else if ("clk".equals(paramString))
      {
        paramWebView = paramWebView.getEncodedQuery();
        this.d.a(this.c, h.a(paramWebView), "ac");
        h();
      }
      else if ("visit".equals(paramString))
      {
        paramWebView = paramWebView.getQueryParameter("url");
        cn.domob.android.f.c.a().a(this.a, paramWebView, null);
      }
      else
      {
        m.e("Unknown reprot type.");
        continue;
        label736:
        if ("close".equals(str))
        {
          m();
        }
        else if (!"custom".equals(str))
        {
          if (!"form".equals(str)) {
            break;
          }
          if (paramBoolean) {
            a(paramWebView);
          }
          paramString = (String)h.a(paramWebView.getEncodedQuery()).get("url");
          paramWebView = new Intent();
          paramWebView.setClass(this.a, DomobActivity.class);
          paramWebView.putExtra("DomobActivityType", 5);
          paramWebView.putExtra("webview_url", paramString);
          i().startActivity(paramWebView);
        }
      }
    }
    if ("fetch".equals(str))
    {
      if (paramBoolean) {
        a(paramWebView);
      }
      localObject = h.a(paramWebView.getEncodedQuery());
      paramWebView = (String)((HashMap)localObject).get("url");
      paramString = (String)((HashMap)localObject).get("name");
      localObject = (String)((HashMap)localObject).get("rt");
      if (!h.b((String)localObject)) {
        break label1186;
      }
    }
    label1186:
    for (int i1 = Integer.parseInt((String)localObject);; i1 = 1)
    {
      q.a(paramWebView, paramString, i1, this.a);
      break;
      if ("vibrate".equals(str))
      {
        if (!cn.domob.android.b.a.F(this.a))
        {
          m.d("Vibration function can not be achieved, because there is no authority or device does not support");
          paramBoolean = false;
          break label120;
        }
        paramWebView = (String)h.a(paramWebView.getEncodedQuery()).get("pattern");
        if ((paramWebView != null) && (!paramWebView.equals("")))
        {
          paramWebView = paramWebView.split(",");
          paramString = new long[paramWebView.length];
          i1 = 0;
          try
          {
            while (i1 < paramWebView.length)
            {
              paramString[i1] = Long.parseLong(paramWebView[i1]);
              i1++;
            }
            ((Vibrator)this.a.getSystemService("vibrator")).vibrate(paramString, -1);
          }
          catch (Exception paramWebView)
          {
            m.e("action vibrate, parse data error or other");
            paramBoolean = false;
          }
          break label120;
        }
        m.e("action vibrate, pattern is empty");
        break;
      }
      if ("video".equals(str))
      {
        if (paramBoolean) {
          a(paramWebView);
        }
        new E(this, paramString).a();
        break;
      }
      if ("loadSuccess".equals(str))
      {
        if (!this.d.G()) {
          break;
        }
        g();
        break;
      }
      m.e("Handle unknown action : " + str);
      paramBoolean = false;
      break label120;
    }
  }
  
  public void b_()
  {
    c("la_failed");
  }
  
  public void c(q paramq)
  {
    a("download_finish", paramq);
  }
  
  public void d()
  {
    if ((this.f != null) && ((this.f instanceof cn.domob.android.ads.a))) {
      ((cn.domob.android.ads.a)this.f).loadUrl("javascript:(window.domobjs && window.domobjs.onViewable) ? domobjs.onViewable() : null");
    }
  }
  
  public void d(q paramq)
  {
    a("download_failed", paramq);
  }
  
  public void e()
  {
    if ((this.f != null) && ((this.f instanceof cn.domob.android.ads.a))) {
      ((cn.domob.android.ads.a)this.f).loadUrl("javascript:(window.domobjs && window.domobjs.onDismiss) ? domobjs.onDismiss() : null");
    }
  }
  
  public void e(q paramq)
  {
    a("download_start", paramq);
  }
  
  public void f()
  {
    m.a("Destroy DomobWebViews.");
    if ((this.f != null) && ((this.f instanceof cn.domob.android.ads.a)))
    {
      ((cn.domob.android.ads.a)this.f).destroy();
      this.f = null;
    }
    if (this.n != null)
    {
      this.n.destroy();
      this.n = null;
    }
  }
  
  public void f(q paramq)
  {
    a("download_cancel", paramq);
  }
  
  public void g(q paramq)
  {
    a("download_repeat", paramq);
    if (this.a != null) {
      ((Activity)this.a).runOnUiThread(new Runnable()
      {
        public void run()
        {
          Toast.makeText(c.s(c.this), "应用正在下载", 0).show();
        }
      });
    }
  }
  
  public void h(q paramq) {}
  
  public void i(q paramq)
  {
    a("download_md5_failed", paramq);
  }
  
  public void j(q paramq)
  {
    cn.domob.android.ads.e.a().a(paramq);
  }
  
  public void r()
  {
    if (q())
    {
      b("load_success");
      this.p = true;
    }
  }
  
  public void s()
  {
    if (q())
    {
      b("load_failed");
      this.r = true;
    }
  }
  
  public void t()
  {
    if (q())
    {
      b("load_cancel");
      this.q = true;
    }
  }
  
  public void u()
  {
    ((Activity)this.a).runOnUiThread(new Runnable()
    {
      public void run()
      {
        c.r(c.this);
      }
    });
    b("close_lp");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */