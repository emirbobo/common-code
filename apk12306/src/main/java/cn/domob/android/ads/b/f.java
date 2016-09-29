package cn.domob.android.ads.b;

import java.util.HashMap;
import java.util.Map;

class f
{
  private static cn.domob.android.i.f a = new cn.domob.android.i.f(f.class.getSimpleName());
  private static Map<String, a> b = new HashMap();
  
  static
  {
    b.put("close", new a()
    {
      public b a(Map<String, String> paramAnonymousMap, m paramAnonymousm)
      {
        return new c(paramAnonymousMap, paramAnonymousm);
      }
    });
    b.put("expand", new a()
    {
      public b a(Map<String, String> paramAnonymousMap, m paramAnonymousm)
      {
        return new d(paramAnonymousMap, paramAnonymousm);
      }
    });
    b.put("usecustomclose", new a()
    {
      public b a(Map<String, String> paramAnonymousMap, m paramAnonymousm)
      {
        return new g(paramAnonymousMap, paramAnonymousm);
      }
    });
    b.put("open", new a()
    {
      public b a(Map<String, String> paramAnonymousMap, m paramAnonymousm)
      {
        return new e(paramAnonymousMap, paramAnonymousm);
      }
    });
  }
  
  static b a(String paramString, Map<String, String> paramMap, m paramm)
  {
    a.a("Create MRAID command with:" + paramString);
    paramString = (a)b.get(paramString);
    if (paramString != null) {}
    for (paramString = paramString.a(paramMap, paramm);; paramString = null) {
      return paramString;
    }
  }
  
  private static abstract interface a
  {
    public abstract b a(Map<String, String> paramMap, m paramm);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */