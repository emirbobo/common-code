package cn.domob.android.ads;

import org.json.JSONObject;

public class j$d
{
  private int b;
  private String c;
  
  public j$d(j paramj, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optInt("code", 0);
      this.c = paramJSONObject.optString("text", null);
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\j$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */