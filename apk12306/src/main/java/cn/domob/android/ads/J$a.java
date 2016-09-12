package cn.domob.android.ads;

import java.util.HashMap;
import org.json.JSONObject;

public class j$a
{
  private boolean b = false;
  private int c;
  private boolean d;
  private int e;
  private String f;
  private String g;
  
  public j$a(j paramj, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      if (paramJSONObject.has("refresh"))
      {
        this.c = paramJSONObject.optInt("refresh");
        this.b = true;
      }
      this.d = paramJSONObject.optBoolean("disable", false);
      this.e = paramJSONObject.optInt("dis_time", 0);
      Object localObject = paramJSONObject.optJSONObject("ors");
      if (localObject != null)
      {
        this.f = ((JSONObject)localObject).optString("version", "1");
        this.g = ((JSONObject)localObject).optString("config", "{\"com.admogo.AdMogoLayout\":\"1\",\"com.guohead.sdk.GHView\":\"2\",\"com.adview.AdViewLayout\":\"3\",\"appfactory.cn.adplatform.AdSageLayout\":\"4\"}");
      }
      int i = paramJSONObject.optInt("sp_timeout", -1);
      if ((i > -1) && (j.a(paramj) != null))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("timeout", Integer.valueOf(i));
        new cn.domob.android.ads.c.a(j.a(paramj), "domob_config").a((HashMap)localObject);
      }
      cn.domob.android.e.a.a(paramJSONObject.optInt("freq_max", 20));
      if (paramJSONObject.optBoolean("freq_reset", false)) {
        cn.domob.android.e.a.b(j.a(paramj));
      }
      i = paramJSONObject.optInt("cached_max", 20);
      a.a.a.a.a.a.a(j.a(paramj), i);
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public boolean d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\J$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */