package cn.dbox.core.bean;

import cn.dbox.core.h.d;
import org.json.JSONObject;

public class g
{
  private static d a = new d(g.class.getSimpleName());
  private String b;
  private a c;
  
  public g(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      this.b = paramJSONObject.optString("layout");
      a locala = new cn/dbox/core/bean/g$a;
      locala.<init>(this, paramJSONObject.optJSONObject("entry"));
      this.c = locala;
      return;
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        a.a(paramJSONObject);
      }
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public a b()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "ControlInfo [mLayout=" + this.b + ", mSEControlEntry=" + this.c + "]";
  }
  
  public class a
  {
    private String b;
    private String c;
    
    public a(JSONObject paramJSONObject)
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */