package cn.domob.android.offerwall;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

class k
{
  private static m a = new m(k.class.getSimpleName());
  private static final String h = "status";
  private static final String i = "refresh_interval";
  private static final String j = "results";
  private static final String k = "id";
  private static final String l = "rp_url";
  private static final String m = "name";
  private static final String n = "pkg";
  private static final String o = "file_url";
  private static final String p = "config";
  private static final String q = "autorun";
  private static final String r = "autodownload";
  private String b;
  private String c;
  private int d;
  private String e;
  private HashMap<Integer, a> f;
  private b g;
  
  protected static k a(String paramString)
  {
    k localk = new k();
    if (localk.b(paramString)) {
      a.a("OfferWall response is ok.");
    }
    for (paramString = localk;; paramString = null) {
      return paramString;
    }
  }
  
  private boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      this.b = paramString;
      Object localObject1 = new org/json/JSONObject;
      Object localObject2 = new org/json/JSONTokener;
      ((JSONTokener)localObject2).<init>(paramString);
      ((JSONObject)localObject1).<init>((JSONTokener)localObject2);
      this.c = ((JSONObject)localObject1).optString("status", null);
      this.d = ((JSONObject)localObject1).optInt("refresh_interval", 3600);
      this.e = ((JSONObject)localObject1).optString("results", null);
      paramString = ((JSONObject)localObject1).optJSONObject("config");
      localObject1 = ((JSONObject)localObject1).optJSONArray("results");
      if (localObject1 != null)
      {
        localObject2 = new java/util/HashMap;
        ((HashMap)localObject2).<init>();
        this.f = ((HashMap)localObject2);
        int i2 = ((JSONArray)localObject1).length();
        for (int i1 = 0; i1 < i2; i1++)
        {
          localObject2 = new cn/domob/android/offerwall/k$a;
          ((a)localObject2).<init>(this, ((JSONArray)localObject1).getJSONObject(i1));
          if (localObject2 != null) {
            this.f.put(Integer.valueOf(((a)localObject2).a()), localObject2);
          }
        }
      }
      if (paramString != null)
      {
        localObject1 = new cn/domob/android/offerwall/k$b;
        ((b)localObject1).<init>(this, paramString);
        this.g = ((b)localObject1);
      }
      bool = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        a.a(paramString);
      }
    }
    return bool;
  }
  
  protected String a()
  {
    return this.b;
  }
  
  protected String b()
  {
    return this.c;
  }
  
  protected int c()
  {
    return this.d;
  }
  
  protected String d()
  {
    return this.e;
  }
  
  protected HashMap<Integer, a> e()
  {
    return this.f;
  }
  
  protected b f()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DomobOfferResponse [mOriginalRespStr=").append(this.b).append(", mStatus=").append(this.c).append(", mRefreshInterval=").append(this.d).append(", mResults=").append(this.e).append(", mConfig=").append(this.g).append("]");
    return localStringBuilder.toString();
  }
  
  class a
  {
    private int b;
    private String c;
    private String d;
    private String e;
    private String f;
    
    a(JSONObject paramJSONObject)
    {
      this.b = paramJSONObject.optInt("id");
      this.c = paramJSONObject.optString("rp_url", null);
      this.d = paramJSONObject.optString("name", null);
      this.e = paramJSONObject.optString("pkg", null);
      this.f = paramJSONObject.optString("file_url", null);
    }
    
    protected int a()
    {
      return this.b;
    }
    
    protected String b()
    {
      return this.c;
    }
    
    protected String c()
    {
      return this.d;
    }
    
    protected String d()
    {
      return this.e;
    }
    
    protected String e()
    {
      return this.f;
    }
  }
  
  class b
  {
    private boolean b;
    private boolean c;
    
    b(JSONObject paramJSONObject)
    {
      this.b = paramJSONObject.optBoolean("autorun", false);
      this.c = paramJSONObject.optBoolean("autodownload", false);
    }
    
    protected boolean a()
    {
      return this.b;
    }
    
    protected boolean b()
    {
      return this.c;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OfferConfig [mAutorun=").append(this.b).append(", mAutoDownload=").append(this.c).append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */