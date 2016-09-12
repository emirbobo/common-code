package cn.dbox.core;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Vibrator;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;
import cn.dbox.core.a.b;
import cn.dbox.core.a.c.b;
import cn.dbox.core.bean.Entrance.EntryReportType;
import cn.dbox.core.d.e.a;
import cn.dbox.core.h.f;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class a
  implements cn.dbox.core.a.a.a, c.b, cn.dbox.core.d.a.a, e.a
{
  public static final String a = "vibrate";
  public static final String b = "adwall";
  private static cn.dbox.core.h.d c = new cn.dbox.core.h.d(a.class.getSimpleName());
  private static final String j = "wtai://wp/mc;";
  private static final String k = "report";
  private static final String l = "imp";
  private static final String m = "event";
  private static final String n = "clk";
  private static final String o = "visit";
  private static final String p = "phase";
  private static final String q = "url";
  private static final String r = "pattern";
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private c g;
  private Context h;
  private boolean i = false;
  private b.j s;
  
  a(Context paramContext, c paramc)
  {
    this.g = paramc;
    this.h = paramContext;
  }
  
  private void a()
  {
    this.d = false;
    this.e = false;
    this.f = false;
  }
  
  public static HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      String[] arrayOfString1 = paramString.split("&");
      int i2 = arrayOfString1.length;
      int i1 = 0;
      for (;;)
      {
        if (i1 < i2)
        {
          String[] arrayOfString2 = arrayOfString1[i1].split("=");
          try
          {
            if (arrayOfString2.length == 2) {
              localHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
            }
            for (;;)
            {
              i1++;
              break;
              localHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              c.a(localUnsupportedEncodingException);
              c.e("URL decode params String error:" + paramString);
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  private boolean b()
  {
    if ((!this.d) && (!this.f) && (!this.e)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean b(cn.dbox.core.bean.a parama, String paramString)
    throws Exception
  {
    Object localObject = Uri.parse(paramString);
    String str = ((Uri)localObject).getHost();
    label118:
    label177:
    boolean bool;
    if (str.equals("inapp"))
    {
      c.b("overrideUri=" + localObject);
      str = URLDecoder.decode(((Uri)localObject).getQueryParameter("url"), "UTF-8");
      c.a("Open landing page with URL:" + str);
      paramString = ((Uri)localObject).getQueryParameter("mode");
      if (paramString == null)
      {
        paramString = "push";
        if (!"present".equals(paramString)) {
          break label193;
        }
        localObject = cn.dbox.core.a.b.a.c;
        c.a("Open landing page with type:" + paramString);
        paramString = this.h;
        if (paramString != null)
        {
          a();
          new b(paramString, str, null, this, parama, (cn.dbox.core.a.b.a)localObject).a().show();
        }
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      paramString = URLDecoder.decode(paramString, "UTF-8");
      break;
      label193:
      localObject = cn.dbox.core.a.b.a.b;
      break label118;
      if (str.equals("download"))
      {
        if (!this.i)
        {
          cn.dbox.core.d.a.a(this.h, this);
          this.i = true;
        }
        paramString = ((Uri)localObject).getQueryParameter("url");
        str = ((Uri)localObject).getQueryParameter("pkg");
        parama.a(str);
        c.b("downloadURL:" + paramString + "pkg:" + str);
        paramString = URLDecoder.decode(paramString, "UTF-8");
        new cn.dbox.core.d.e(this.h, (Uri)localObject, parama, this).a(this.h);
        c.b("Download app with URL:" + paramString);
        break label177;
      }
      if (str.equals("launch"))
      {
        new cn.dbox.core.a.a(this.h, (Uri)localObject, this, parama).a();
        break label177;
      }
      if (paramString.startsWith("http"))
      {
        localObject = f.a(this.h, Uri.parse(paramString));
        parama = (cn.dbox.core.bean.a)localObject;
        if (localObject == null) {
          parama = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        }
        this.h.startActivity(parama);
        if (this.s == null) {
          break label177;
        }
        this.s.a();
        break label177;
      }
      if ((paramString.startsWith("tel:")) || (paramString.startsWith("voicemail:")) || (paramString.startsWith("sms:")) || (paramString.startsWith("mailto:")) || (paramString.startsWith("geo:")) || (paramString.startsWith("wtai://wp/mc;")))
      {
        parama = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        parama.addFlags(268435456);
        if (paramString.startsWith("wtai://wp/mc;"))
        {
          c.a("Create intent for: wtai://wp/mc;");
          parama = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + paramString.substring("wtai://wp/mc;".length())));
        }
        try
        {
          this.h.startActivity(parama);
          if (this.s == null) {
            break label177;
          }
          this.s.a();
        }
        catch (ActivityNotFoundException parama)
        {
          Log.w("ClickAction", "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
          bool = false;
        }
        continue;
      }
      if ("report".equals(str))
      {
        paramString = ((Uri)localObject).getPath();
        if ((paramString == null) || (paramString.indexOf("/") == -1))
        {
          c.e("There is no report type.");
          bool = false;
          continue;
        }
        paramString = paramString.substring(1);
        if (paramString.equals("imp"))
        {
          localObject = f.b(((Uri)localObject).getEncodedQuery());
          paramString = "s";
          if (((HashMap)localObject).containsKey("phase"))
          {
            paramString = (String)((HashMap)localObject).get("phase");
            ((HashMap)localObject).remove("phase");
          }
          ((HashMap)localObject).put("phase", paramString);
          cn.dbox.core.f.a.a().a(this.g, parama, (HashMap)localObject, "ac", this.g.l());
          break label177;
        }
        if ("event".equals(paramString))
        {
          localObject = f.b(((Uri)localObject).getEncodedQuery());
          paramString = this.g.n();
          if (((HashMap)localObject).containsKey("url"))
          {
            paramString = (String)((HashMap)localObject).get("url");
            ((HashMap)localObject).remove("url");
          }
          cn.dbox.core.f.a.a().a(this.g, parama, (HashMap)localObject, "ac", paramString);
          break label177;
        }
        if ("clk".equals(paramString))
        {
          paramString = ((Uri)localObject).getEncodedQuery();
          cn.dbox.core.f.a.a().a(this.g, parama, b(paramString), "ac", this.g.j());
          break label177;
        }
        if ("visit".equals(paramString))
        {
          parama = ((Uri)localObject).getQueryParameter("url");
          cn.dbox.core.f.a.a().a(this.h, parama, null);
          break label177;
        }
        c.e("Unknown reprot type.");
        break label177;
      }
      if ("vibrate".equals(str))
      {
        if (!cn.dbox.core.h.e.G(this.h))
        {
          c.d("Vibration function can not be achieved, because there is no authority or device does not support");
          bool = false;
          continue;
        }
        parama = (String)f.b(((Uri)localObject).getEncodedQuery()).get("pattern");
        if ((parama != null) && (!parama.equals("")))
        {
          paramString = parama.split(",");
          parama = new long[paramString.length];
          int i1 = 0;
          try
          {
            while (i1 < paramString.length)
            {
              parama[i1] = Long.parseLong(paramString[i1]);
              i1++;
            }
            ((Vibrator)this.h.getSystemService("vibrator")).vibrate(parama, -1);
          }
          catch (Exception parama)
          {
            c.e("action vibrate, parse data error or other");
            bool = false;
          }
          continue;
        }
        c.e("action vibrate, pattern is empty");
        break label177;
      }
      if ("adwall".equals(str))
      {
        try
        {
          if (!f.a(this.g)) {
            break label177;
          }
          this.g.t();
        }
        catch (Exception parama)
        {
          c.a(parama);
        }
        catch (Error parama)
        {
          c.a(parama);
        }
        break label177;
      }
      c.e("Handle unknown action : " + str);
      bool = false;
    }
  }
  
  public void a(b.f paramf, cn.dbox.core.bean.d paramd, b.e parame)
  {
    cn.dbox.core.f.a.a().a(this.g, paramf, paramd, parame);
  }
  
  public void a(b.j paramj)
  {
    this.s = paramj;
  }
  
  public void a(b.o paramo, String paramString1, String paramString2)
  {
    cn.dbox.core.f.a.a().a(this.g, paramo, paramString1, paramString2);
  }
  
  public void a(Entrance.EntryReportType paramEntryReportType)
  {
    cn.dbox.core.f.a.a().b(this.g, paramEntryReportType);
  }
  
  void a(cn.dbox.core.bean.a parama)
  {
    a(parama, null);
  }
  
  public void a(cn.dbox.core.bean.a parama, b.a parama1, b.d paramd)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, parama1, paramd);
  }
  
  public void a(cn.dbox.core.bean.a parama, b.b paramb)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, paramb);
  }
  
  public void a(cn.dbox.core.bean.d paramd, b.b paramb)
  {
    cn.dbox.core.f.a.a().a(this.g, paramd, paramb);
  }
  
  public void a(String paramString)
  {
    cn.dbox.core.f.a.a().a(this.g, paramString);
  }
  
  public void a(String paramString, WebView paramWebView, cn.dbox.core.bean.a parama)
  {
    try
    {
      Object localObject = URI.create(paramString);
      paramWebView = ((URI)localObject).getScheme();
      localObject = ((URI)localObject).getHost();
      if (f.a(paramWebView)) {}
      for (;;)
      {
        return;
        if (((!paramWebView.equals("domob")) || (f.a((String)localObject)) || (!((String)localObject).equals("inapp"))) && (!paramWebView.startsWith("http"))) {
          b(parama, paramString);
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.e("Error while parsing landingpage URL.");
        c.a(paramString);
      }
    }
  }
  
  public void a(String paramString1, b.b paramb, String paramString2)
  {
    cn.dbox.core.f.a.a().a(this.g, paramString1, paramb, paramString2);
  }
  
  public void a(String paramString, cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.i.c, paramString);
  }
  
  public void a(String paramString1, String paramString2, cn.dbox.core.bean.a parama)
  {
    c.a(String.format("LandingPage 内下载，地址为%s，infoURL为%s", new Object[] { paramString1, paramString2 }));
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (paramString2.length() != 0)
        {
          localObject = f.b(Uri.parse(paramString2).getQuery());
          if (((HashMap)localObject).containsKey("url")) {
            ((HashMap)localObject).put("url", paramString1);
          }
          localObject = f.a((HashMap)localObject);
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localObject = f.a() + "://download?" + (String)localObject;
          b(parama, (String)localObject);
          return;
        }
      }
      catch (Exception parama)
      {
        Object localObject;
        c.e(String.format("解析LandingPage中下载出现错误，地址为%s，infoURL为%s", new Object[] { paramString1, paramString2 }));
        continue;
      }
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = f.a() + "://download?url=" + URLEncoder.encode(paramString1, "UTF-8");
    }
  }
  
  public void a(ArrayList<cn.dbox.core.bean.a> paramArrayList, String paramString)
  {
    cn.dbox.core.f.a.a().a(this.g, paramArrayList, paramString);
  }
  
  public boolean a(cn.dbox.core.bean.a parama, String paramString)
  {
    boolean bool1 = false;
    if (parama != null) {}
    for (Object localObject = parama.m();; localObject = null)
    {
      if (paramString != null) {}
      for (;;)
      {
        try
        {
          if (!paramString.startsWith(f.a())) {
            continue;
          }
          String str = Uri.parse(paramString).getScheme();
          if (!f.a().equals(str)) {
            continue;
          }
          localObject = c;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          ((cn.dbox.core.h.d)localObject).a("Scheme xxx action scheme =" + str);
          bool2 = b(parama, paramString);
          bool1 = bool2;
        }
        catch (Exception parama)
        {
          boolean bool2;
          c.e("Exception in click.");
          c.a(parama);
          continue;
          c.a("Handle unknown intents.");
          parama = new android/content/Intent;
          parama.<init>("android.intent.action.VIEW", Uri.parse(paramString));
          parama.addFlags(268435456);
          try
          {
            this.h.startActivity(parama);
            if (this.s == null) {
              continue;
            }
            this.s.a();
          }
          catch (ActivityNotFoundException parama)
          {
            parama = new java/lang/StringBuilder;
            parama.<init>();
            Log.w("ClickAction", "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
          }
          continue;
        }
        return bool1;
        bool2 = paramString.startsWith("http");
        if (bool2)
        {
          try
          {
            parama = f.a(this.h, Uri.parse(paramString));
            localObject = parama;
            if (parama == null)
            {
              localObject = new android/content/Intent;
              ((Intent)localObject).<init>("android.intent.action.VIEW", Uri.parse(paramString));
            }
            this.h.startActivity((Intent)localObject);
            if (this.s != null) {
              this.s.a();
            }
            bool1 = true;
          }
          catch (Exception parama)
          {
            c.a(parama);
            parama = null;
            continue;
          }
        }
        else if ((paramString.startsWith("tel:")) || (paramString.startsWith("voicemail:")) || (paramString.startsWith("sms:")) || (paramString.startsWith("mailto:")) || (paramString.startsWith("geo:")) || (paramString.startsWith("wtai://wp/mc;")))
        {
          parama = new android/content/Intent;
          parama.<init>("android.intent.action.VIEW", Uri.parse(paramString));
          parama.addFlags(268435456);
          if (paramString.startsWith("wtai://wp/mc;"))
          {
            c.a("Create intent for: wtai://wp/mc;");
            parama = new android/content/Intent;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            parama.<init>("android.intent.action.VIEW", Uri.parse("tel:" + paramString.substring("wtai://wp/mc;".length())));
          }
          try
          {
            this.h.startActivity(parama);
            if (this.s == null) {
              continue;
            }
            this.s.a();
          }
          catch (ActivityNotFoundException parama)
          {
            parama = new java/lang/StringBuilder;
            parama.<init>();
            Log.w("ClickAction", "Could not handle intent with URI: " + paramString + ". Is this intent unsupported on your phone?");
          }
        }
        else
        {
          paramString = (String)localObject;
        }
      }
    }
  }
  
  public void b(Entrance.EntryReportType paramEntryReportType)
  {
    cn.dbox.core.f.a.a().a(this.g, paramEntryReportType);
  }
  
  public void b(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.i.b, null);
    if (this.s != null) {
      this.s.a();
    }
  }
  
  public void b(String paramString, cn.dbox.core.bean.a parama)
  {
    try
    {
      if (b(parama, paramString)) {
        cn.dbox.core.f.a.a().a(this.g, parama, b.i.d, paramString);
      }
      for (;;)
      {
        return;
        cn.dbox.core.f.a.a().a(this.g, parama, b.i.e, paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.a(paramString);
      }
    }
  }
  
  public void c(cn.dbox.core.bean.a parama)
  {
    if (b())
    {
      cn.dbox.core.f.a.a().a(this.g, parama, b.b.b);
      this.d = true;
    }
  }
  
  public void d(cn.dbox.core.bean.a parama)
  {
    if (b())
    {
      cn.dbox.core.f.a.a().a(this.g, parama, b.b.c);
      this.f = true;
    }
  }
  
  public void e(cn.dbox.core.bean.a parama)
  {
    if (b())
    {
      cn.dbox.core.f.a.a().a(this.g, parama, b.b.d);
      this.e = true;
    }
  }
  
  public void f(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.b.e);
  }
  
  public void g(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.g.d);
  }
  
  public void h(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.g.e);
  }
  
  public void i(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.g.b);
  }
  
  public void j(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.g.f);
  }
  
  public void k(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.g.c);
    if (this.h != null) {
      ((Activity)this.h).runOnUiThread(new Runnable()
      {
        public void run()
        {
          Toast.makeText(a.a(a.this), "应用正在下载", 0).show();
        }
      });
    }
  }
  
  public void l(cn.dbox.core.bean.a parama) {}
  
  public void m(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.d.a.a().a(parama);
  }
  
  public void n(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.g.g);
  }
  
  public void o(cn.dbox.core.bean.a parama)
  {
    cn.dbox.core.f.a.a().a(this.g, parama, b.g.h);
  }
  
  public class a
  {
    public static final String a = "s";
    public static final String b = "m";
    public static final String c = "f";
    public static final String d = "p";
    
    public a() {}
  }
  
  public class b
  {
    public static final String a = "s";
    public static final String b = "ac";
    
    public b() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */