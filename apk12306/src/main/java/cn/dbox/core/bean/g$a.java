package cn.dbox.core.bean;

import org.json.JSONObject;

public class g$a
{
  private String b;
  private String c;
  
  public g$a(g paramg, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optString("remind");
      this.c = paramJSONObject.optString("tracker");
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
  
  public String toString()
  {
    return "SEControlEntry [mRemind=" + this.b + ", mTracker=" + this.c + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\g$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */