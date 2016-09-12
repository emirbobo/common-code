package cn.dbox.core.bean;

import org.json.JSONObject;

public class h
{
  private int a;
  private String b;
  
  public h(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("code", 0);
    this.b = paramJSONObject.optString("text", null);
  }
  
  public int a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */