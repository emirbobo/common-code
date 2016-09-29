package cn.domob.android.ads;

import org.json.JSONObject;

public class j$c$a
{
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private boolean h;
  private int i;
  private boolean j;
  private boolean k;
  private int l;
  private int m;
  
  j$c$a(j.c paramc, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optString("render", "fs");
      this.c = paramJSONObject.optString("ct", null);
      this.d = paramJSONObject.optString("url", null);
      this.f = paramJSONObject.optString("content", null);
      this.e = paramJSONObject.optString("base_url", null);
      this.g = paramJSONObject.optString("o", "h");
      this.h = paramJSONObject.optBoolean("preload", true);
      this.i = paramJSONObject.optInt("timeout", 5);
      this.j = paramJSONObject.optBoolean("autoplay", false);
      this.k = paramJSONObject.optBoolean("cls_btn", true);
      this.l = paramJSONObject.optInt("width", -1);
      this.m = paramJSONObject.optInt("height", -1);
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.f;
  }
  
  public String f()
  {
    return this.g;
  }
  
  public boolean g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public boolean i()
  {
    return this.j;
  }
  
  public boolean j()
  {
    return this.k;
  }
  
  public int k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.m;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\j$c$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */