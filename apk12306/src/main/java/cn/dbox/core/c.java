package cn.dbox.core;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cn.dbox.core.bean.g;
import cn.dbox.core.bean.g.a;
import cn.dbox.core.c.b.a;
import cn.dbox.core.c.d.a;
import cn.dbox.core.c.e;
import cn.dbox.core.h.f;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c
{
  private static cn.dbox.core.h.d e = new cn.dbox.core.h.d(c.class.getSimpleName());
  private static final String r = "cn.domob.ui.main.DViewManager";
  private static final String s = "showWall";
  private static final String t = "preLoad";
  String a;
  b.a b;
  HashMap<String, cn.dbox.core.bean.d> c = new HashMap();
  String d = "16:5";
  private Context f;
  private b.l g;
  private b.m h;
  private boolean i = false;
  private String j = null;
  private String k = null;
  private String l = null;
  private String m = null;
  private String n = null;
  private boolean o = false;
  private ExecutorService p;
  private String q;
  private Object u = null;
  private Method v = null;
  private Method w = null;
  
  c(Context paramContext, String paramString1, String paramString2)
  {
    this.f = paramContext;
    this.k = paramString2;
    this.j = paramString1;
    this.p = Executors.newSingleThreadExecutor();
  }
  
  private boolean v()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!this.o)
    {
      if ((f.g(this.j)) || (f.g(this.k))) {
        break label63;
      }
      if (f.a(this.f))
      {
        this.o = true;
        bool1 = bool2;
      }
    }
    else
    {
      return bool1;
    }
    Log.w("DrwSDK", "Permission denied.");
    for (;;)
    {
      bool1 = false;
      break;
      label63:
      Log.w("DrwSDK", "Please set your publisherID and placementID first.");
    }
  }
  
  public String a()
  {
    return this.j;
  }
  
  public String a(String paramString, int paramInt)
  {
    if (paramInt == 0) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      if (this.c.containsKey(paramString))
      {
        Object localObject = (cn.dbox.core.bean.d)this.c.get(paramString);
        ArrayList localArrayList = ((cn.dbox.core.bean.d)localObject).i();
        e.b("adContainerName:" + paramString + "ids:" + localArrayList);
        int i2 = ((cn.dbox.core.bean.d)localObject).h();
        e.b("Number each page display ads:" + i2);
        if (localArrayList.size() >= i2 * paramInt)
        {
          if (localArrayList.size() < i2 * paramInt + i2)
          {
            localObject = "";
            for (paramInt = i2 * paramInt;; paramInt++)
            {
              paramString = (String)localObject;
              if (paramInt >= localArrayList.size()) {
                break;
              }
              localObject = (String)localObject + (String)localArrayList.get(paramInt) + ",";
            }
          }
          localObject = "";
          for (int i1 = i2 * paramInt;; i1++)
          {
            paramString = (String)localObject;
            if (i1 >= i2 * paramInt + i2) {
              break;
            }
            localObject = (String)localObject + (String)localArrayList.get(i1) + ",";
          }
        }
        paramString = null;
      }
      else
      {
        paramString = "";
      }
    }
  }
  
  public void a(b.l paraml)
  {
    this.g = paraml;
  }
  
  public void a(b.m paramm)
  {
    this.h = paramm;
  }
  
  public void a(b.a parama)
  {
    this.b = parama;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(final String paramString1, final int paramInt, String paramString2)
  {
    if (!v()) {}
    for (;;)
    {
      return;
      if (this.i)
      {
        e.d("requestDataAsynting....");
      }
      else
      {
        this.i = true;
        new Thread()
        {
          public void run()
          {
            for (;;)
            {
              try
              {
                Object localObject;
                if (!cn.dbox.core.c.a.a)
                {
                  localObject = new cn/dbox/core/c/a;
                  ((cn.dbox.core.c.a)localObject).<init>(c.this);
                  ((cn.dbox.core.c.a)localObject).a();
                }
                localHashMap = new java/util/HashMap;
                localHashMap.<init>();
                if (paramString1 == null)
                {
                  c.u().b("adContainerName:wall");
                  localObject = new cn/dbox/core/c/d;
                  ((cn.dbox.core.c.d)localObject).<init>(c.this);
                  d.a local1 = new cn/dbox/core/c$1$1;
                  local1.<init>(this);
                  ((cn.dbox.core.c.d)localObject).a(local1, localHashMap);
                  return;
                }
              }
              catch (cn.dbox.core.e.a locala)
              {
                HashMap localHashMap;
                c.u().d("Config request is ongoing, Thread will sleep 1 seconds, and then restart to request");
                continue;
              }
              catch (Exception localException)
              {
                c.u().a(localException);
                c.a(c.this, false);
                continue;
              }
              localHashMap.put("acid", paramString1);
              if (paramInt != 0)
              {
                c.this.a = c.this.a(paramString1, paramInt);
                localHashMap.put("ids", paramString1);
              }
            }
          }
        }.start();
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.m = paramString2;
    this.l = paramString1;
    if (f.a(this)) {
      r();
    }
  }
  
  public void a(String paramString, ArrayList<cn.dbox.core.bean.a> paramArrayList) {}
  
  public String b()
  {
    return this.k;
  }
  
  public String c()
  {
    return this.l;
  }
  
  public String d()
  {
    return this.m;
  }
  
  public String e()
  {
    return this.n;
  }
  
  public Context f()
  {
    return this.f;
  }
  
  public ExecutorService g()
  {
    return this.p;
  }
  
  public b.a h()
  {
    return this.b;
  }
  
  public String i()
  {
    String str;
    if (b.c().equals("online")) {
      str = f.f(cn.dbox.core.b.a.j);
    }
    for (;;)
    {
      return str;
      if (b.c().equals("offline")) {
        str = f.f(cn.dbox.core.b.a.p);
      } else {
        str = b.c();
      }
    }
  }
  
  public String j()
  {
    String str;
    if (this.b != null) {
      str = this.b.c();
    }
    for (;;)
    {
      return str;
      if (b.c().equals("online")) {
        str = f.f(cn.dbox.core.b.a.l);
      } else if (b.c().equals("offline")) {
        str = f.f(cn.dbox.core.b.a.r);
      } else {
        str = f.f(cn.dbox.core.b.a.l);
      }
    }
  }
  
  public String k()
  {
    return this.q;
  }
  
  public String l()
  {
    String str;
    if (this.b != null) {
      str = this.b.b();
    }
    for (;;)
    {
      return str;
      if (b.c().equals("online")) {
        str = f.f(cn.dbox.core.b.a.m);
      } else if (b.c().equals("offline")) {
        str = f.f(cn.dbox.core.b.a.s);
      } else {
        str = f.f(cn.dbox.core.b.a.m);
      }
    }
  }
  
  public String m()
  {
    String str;
    if (this.b != null)
    {
      str = this.b.a();
      if (TextUtils.isEmpty(str)) {}
    }
    for (;;)
    {
      return str;
      str = "http://srp.12306.moxz.net/rp";
    }
  }
  
  public String n()
  {
    String str;
    if (this.b != null) {
      str = this.b.d();
    }
    for (;;)
    {
      return str;
      if (b.c().equals("online")) {
        str = f.f(cn.dbox.core.b.a.k);
      } else if (b.c().equals("offline")) {
        str = f.f(cn.dbox.core.b.a.q);
      } else {
        str = f.f(cn.dbox.core.b.a.k);
      }
    }
  }
  
  public String o()
  {
    String str;
    if (this.b != null) {
      str = this.b.e();
    }
    for (;;)
    {
      return str;
      if (b.c().equals("online")) {
        str = f.f(cn.dbox.core.b.a.n);
      } else if (b.c().equals("offline")) {
        str = f.f(cn.dbox.core.b.a.t);
      } else {
        str = f.f(cn.dbox.core.b.a.n);
      }
    }
  }
  
  public String p()
  {
    String str;
    if (this.b != null) {
      str = this.b.f();
    }
    for (;;)
    {
      return str;
      if (b.c().equals("online")) {
        str = f.f(cn.dbox.core.b.a.o);
      } else if (b.c().equals("offline")) {
        str = f.f(cn.dbox.core.b.a.u);
      } else {
        str = f.f(cn.dbox.core.b.a.o);
      }
    }
  }
  
  public String q()
  {
    return this.d;
  }
  
  public void r()
  {
    try
    {
      Class localClass = Class.forName("cn.domob.ui.main.DViewManager");
      Object localObject = localClass.getConstructors();
      String str1 = null;
      for (int i1 = 0; i1 < localObject.length; i1++) {
        if (localObject[i1].getParameterAnnotations().length > 0) {
          str1 = localObject[i1];
        }
      }
      localObject = str1.getParameterTypes();
      Context localContext = this.f;
      String str2 = this.l;
      str1 = this.m;
      this.u = localClass.getConstructor((Class[])localObject).newInstance(new Object[] { localContext, str2, str1 });
      this.v = localClass.getMethod("showWall", new Class[0]);
      this.w = localClass.getMethod("preLoad", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        localError.printStackTrace();
      }
    }
  }
  
  public void s()
  {
    if (((this.u == null) || (this.w == null)) && (f.a(this))) {
      r();
    }
    try
    {
      if ((this.w != null) && (this.u != null)) {
        this.w.invoke(this.u, new Object[0]);
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        localError.printStackTrace();
      }
    }
  }
  
  public void t()
  {
    if (((this.u == null) || (this.v == null)) && (f.a(this))) {
      r();
    }
    try
    {
      if ((this.v != null) && (this.u != null)) {
        this.v.invoke(this.u, new Object[0]);
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    catch (Error localError)
    {
      for (;;)
      {
        localError.printStackTrace();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */