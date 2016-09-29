package cn.dbox.core.c;

import cn.dbox.core.h.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class b
{
  private static d c = new d(b.class.getSimpleName());
  a a;
  private JSONArray b = new JSONArray();
  
  public b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      JSONTokener localJSONTokener = new org/json/JSONTokener;
      localJSONTokener.<init>(paramString);
      localJSONObject.<init>(localJSONTokener);
      this.b = localJSONObject.optJSONArray("turnoff");
      paramString = new cn/dbox/core/c/b$a;
      paramString.<init>(this, localJSONObject.optJSONObject("req_urls"));
      this.a = paramString;
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        c.e("Config resp is not in JSONObject");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        c.a(paramString);
      }
    }
  }
  
  private ArrayList<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (;;)
    {
      if (i < paramJSONArray.length()) {
        try
        {
          localArrayList.add(paramJSONArray.getString(i));
          i++;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            c.a(localJSONException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<String> a()
  {
    return a(this.b);
  }
  
  public a b()
  {
    return this.a;
  }
  
  public String toString()
  {
    return "ConfigResponse [mDisabledParamsValue=" + this.b + ", mReportUrl=" + this.a + "]";
  }
  
  public class a
  {
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    
    public a(JSONObject paramJSONObject)
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */