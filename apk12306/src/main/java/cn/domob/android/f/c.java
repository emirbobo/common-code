package cn.domob.android.f;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class c
{
  private static volatile c a = null;
  private ThreadPoolExecutor b = (ThreadPoolExecutor)Executors.newCachedThreadPool();
  private final Map<Context, List<WeakReference<Future<?>>>> c = new WeakHashMap();
  private final Map<String, String> d = new HashMap();
  
  public static c a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        c localc = new cn/domob/android/f/c;
        localc.<init>();
        a = localc;
      }
      return a;
    }
    finally {}
  }
  
  public static String a(String paramString, f paramf)
  {
    String str = paramString;
    if (paramf != null)
    {
      paramf = paramf.b();
      if (paramString.indexOf("?") != -1) {
        break label47;
      }
    }
    label47:
    for (str = paramString + "?" + paramf;; str = paramString + "&" + paramf) {
      return str;
    }
  }
  
  private h b(e parame)
  {
    Object localObject = new d(parame);
    Context localContext = parame.a();
    if (parame.e()) {}
    for (parame = ((d)localObject).a();; parame = null)
    {
      return parame;
      Future localFuture = this.b.submit((Runnable)localObject);
      if (localContext != null)
      {
        localObject = (List)this.c.get(localContext);
        parame = (e)localObject;
        if (localObject == null)
        {
          parame = new LinkedList();
          this.c.put(localContext, parame);
        }
        parame.add(new WeakReference(localFuture));
      }
    }
  }
  
  public h a(Context paramContext, String paramString)
  {
    e locale = new e();
    locale.a(paramContext);
    locale.a(paramString);
    locale.c("GET");
    locale.a(true);
    return a(locale);
  }
  
  public h a(e parame)
  {
    return b(parame);
  }
  
  public void a(Context paramContext, String paramString, f paramf, g paramg)
  {
    paramContext = new e();
    paramContext.a(paramString);
    paramContext.c("GET");
    paramContext.a(paramg);
    a(paramContext);
  }
  
  public void a(Context paramContext, String paramString, g paramg)
  {
    paramContext = new e();
    paramContext.a(paramString);
    paramContext.a(paramg);
    paramContext.c("GET");
    a(paramContext);
  }
  
  public void a(Context paramContext, String paramString1, g paramg, String paramString2)
  {
    paramContext = new e();
    paramContext.a(paramString1);
    paramContext.a(paramg);
    paramContext.b(paramString2);
    paramContext.c("GET");
    a(paramContext);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    Object localObject = (List)this.c.get(paramContext);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Future localFuture = (Future)((WeakReference)((Iterator)localObject).next()).get();
        if (localFuture != null) {
          localFuture.cancel(paramBoolean);
        }
      }
    }
    this.c.remove(paramContext);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.d.put(paramString1, paramString2);
  }
  
  public void a(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this.b = paramThreadPoolExecutor;
  }
  
  public void b(Context paramContext, String paramString, f paramf, g paramg)
  {
    e locale = new e();
    locale.a(paramContext);
    locale.a(paramString);
    locale.a(paramf);
    locale.a(paramg);
    a(locale);
  }
  
  public void c(Context paramContext, String paramString, f paramf, g paramg)
  {
    e locale = new e();
    locale.a(paramContext);
    locale.a(paramString);
    locale.a(paramf);
    locale.a(paramg);
    locale.b(true);
    a(locale);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */