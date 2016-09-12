package cn.domob.android.g.a;

import cn.domob.android.f.e;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

class b
  implements Runnable
{
  private static cn.domob.android.i.f a = new cn.domob.android.i.f(b.class.getSimpleName());
  private static final String b = "sid";
  private static final long c = 0L;
  private static volatile boolean d = false;
  private static long e = 0L;
  private static boolean f = false;
  private static int l = 0;
  private String g;
  private boolean h;
  private a.a i = null;
  private c j;
  private e k;
  
  b(c paramc)
  {
    this.j = paramc;
  }
  
  private Map<String, String> a(c paramc)
  {
    Map localMap = d.a(paramc.g(), paramc.b());
    if (paramc.f() != null)
    {
      Iterator localIterator = paramc.f().entrySet().iterator();
      while (localIterator.hasNext())
      {
        paramc = (Map.Entry)localIterator.next();
        localMap.put(paramc.getKey(), paramc.getValue());
      }
    }
    a.b("complete request parameter is " + localMap.toString());
    return localMap;
  }
  
  private void a(String paramString)
  {
    this.g = b(paramString);
    a.b(String.format("try to use the new url(%s) to connect again", new Object[] { this.g }));
    d();
  }
  
  protected static boolean a()
  {
    return d;
  }
  
  private String b(String paramString)
  {
    String str;
    do
    {
      str = cn.domob.android.i.h.a(5);
    } while (!str.matches(".*\\d.*"));
    paramString = "http://" + str + "." + paramString;
    a.b(String.format("create new url(%s) for detect", new Object[] { paramString }));
    return paramString;
  }
  
  private void b()
  {
    String str = c();
    if (!cn.domob.android.i.h.e(str)) {
      a(str);
    }
  }
  
  private String c()
  {
    Object localObject;
    if (this.j.d() > 0)
    {
      localObject = this.j.c();
      if ((localObject != null) && (localObject.length > 0)) {
        if (l + 1 <= localObject.length * this.j.d())
        {
          int n = (l + 1) / this.j.d();
          if ((l + 1) % this.j.d() > 0) {}
          for (int m = 1;; m = 0)
          {
            m = m + n - 1;
            if ((m >= localObject.length) || (m < 0)) {
              break;
            }
            localObject = localObject[m];
            return (String)localObject;
          }
          a.e(String.format("logical error, index(%d) out of array", new Object[] { Integer.valueOf(m) }));
        }
      }
    }
    for (;;)
    {
      localObject = null;
      break;
      a.d(String.format("all domains has failed, detected failed times is %d", new Object[] { Integer.valueOf(l) }));
      continue;
      a.e("domain array is null or length is zero");
      continue;
      a.e("Each domain can try to detect the number is not greater than 0");
    }
  }
  
  private boolean c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!cn.domob.android.i.h.e(paramString)) {}
    try
    {
      localObject1 = new org/json/JSONObject;
      JSONTokener localJSONTokener = new org/json/JSONTokener;
      localJSONTokener.<init>(paramString);
      ((JSONObject)localObject1).<init>(localJSONTokener);
      paramString = (String)localObject1;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        a.a(paramString);
        paramString = null;
        continue;
        boolean bool = false;
        continue;
        a.b("connect response not contain sid");
      }
    }
    localObject1 = localObject2;
    if (paramString != null) {
      localObject1 = paramString.optString("sid", null);
    }
    if (!cn.domob.android.i.h.e((String)localObject1))
    {
      bool = true;
      if (!bool) {
        break label92;
      }
      a.b("connect response contain sid");
      return bool;
    }
  }
  
  private void d()
  {
    if (this.j.h()) {
      j();
    }
    if (cn.domob.android.i.c.l(this.j.g())) {
      if (c(f()))
      {
        this.h = true;
        a.b("found available url: " + this.g);
      }
    }
    for (;;)
    {
      return;
      h();
      i();
      if (!f)
      {
        b();
        continue;
        this.i = a.a.a;
      }
    }
  }
  
  private boolean e()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (e > 0L)
    {
      bool1 = bool2;
      if (e + this.j.e() < System.currentTimeMillis())
      {
        a.b("all domains failed has been timeout, so reset varable, detect again");
        f = false;
        l = 0;
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private String f()
  {
    a.b("do sync connect");
    cn.domob.android.f.h localh = cn.domob.android.f.c.a().a(g());
    String str = null;
    if (localh != null) {
      str = localh.e();
    }
    a.b("connect response String: " + str);
    return str;
  }
  
  private e g()
  {
    if (this.k == null)
    {
      this.k = new e();
      this.k.a(this.j.g());
      this.k.c("GET");
      this.k.a(true);
    }
    this.k.a(new cn.domob.android.f.f(a(this.j)));
    this.k.a(this.g);
    return this.k;
  }
  
  private int h()
  {
    l += 1;
    a.b(String.format("detect failed, total failed time is %d", new Object[] { Integer.valueOf(l) }));
    return l;
  }
  
  private void i()
  {
    if ((this.j.c() != null) && (this.j.d() > 0) && (l >= this.j.c().length * this.j.d()))
    {
      f = true;
      e = System.currentTimeMillis();
      a.d("all domains have been masked");
    }
  }
  
  private void j()
  {
    int m = k();
    a.b(String.format("thread sleep %d millisecond", new Object[] { Integer.valueOf(m) }));
    long l1 = m;
    try
    {
      Thread.sleep(l1);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        a.a(localInterruptedException);
      }
    }
  }
  
  private int k()
  {
    return new Random().nextInt(1000);
  }
  
  public void run()
  {
    a.b("start multi domain detect");
    d = true;
    this.h = false;
    if (cn.domob.android.i.c.l(this.j.g())) {
      if (f) {
        if (e())
        {
          b();
          if (this.j.a() != null)
          {
            if (f) {
              this.i = a.a.b;
            }
            a.b("multi domain detect finished");
            if (!this.h) {
              break label175;
            }
            a.b("found available domain: " + this.g);
            this.j.a().a(this.g);
          }
        }
      }
    }
    for (;;)
    {
      d = false;
      return;
      a.b("all domain has been detected failed, and allow detecting time is not reaching");
      break;
      b();
      break;
      this.i = a.a.a;
      a.b("network is not available, so finish detecting");
      break;
      label175:
      a.b("not found available domain");
      this.j.a().a(this.i);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\g\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */