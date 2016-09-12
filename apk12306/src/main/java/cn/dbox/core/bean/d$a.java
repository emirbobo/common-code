package cn.dbox.core.bean;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d$a
{
  private int b;
  private ArrayList<String> c;
  private ArrayList<a> d;
  
  public d$a(d paramd, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optInt("interval");
      this.c = new ArrayList();
      try
      {
        paramd = new org/json/JSONArray;
        paramd.<init>(paramJSONObject.getString("adids"));
        int i = 0;
        for (;;)
        {
          int j = paramd.length();
          if (i < j) {
            try
            {
              this.c.add(paramd.getString(i));
              i++;
            }
            catch (JSONException paramJSONObject)
            {
              for (;;)
              {
                d.m().a(paramJSONObject);
              }
            }
          }
        }
        return;
      }
      catch (JSONException paramd)
      {
        d.m().b(paramd.toString());
      }
    }
  }
  
  public int a()
  {
    return this.b;
  }
  
  public void a(ArrayList<a> paramArrayList)
  {
    this.d = paramArrayList;
  }
  
  public ArrayList<String> b()
  {
    return this.c;
  }
  
  public ArrayList<a> c()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "ContainerInfoHeader [mInterval=" + this.b + ", mContainerHeaderAdids=" + this.c + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\bean\d$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */