package cn.dbox.core.c;

import org.json.JSONObject;

public class b$a
{
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  public b$a(b paramb, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optString("irp");
      this.c = paramJSONObject.optString("crp");
      this.d = paramJSONObject.optString("erp");
      this.e = paramJSONObject.optString("error");
      this.f = paramJSONObject.optString("feedback");
      this.g = paramJSONObject.optString("srp");
    }
  }
  
  public String a()
  {
    return this.g;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String toString()
  {
    return "ReportUrl [irp=" + this.b + ", crp=" + this.c + ", erp=" + this.d + ", error=" + this.e + ", feedback=" + this.f + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c\b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */