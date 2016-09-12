package cn.domob.android.offerwall;

import org.json.JSONObject;

class k$a
{
  private int b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  k$a(k paramk, JSONObject paramJSONObject)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\k$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */