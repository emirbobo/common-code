package cn.domob.android.ads;

import cn.domob.android.i.f;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

class p
{
  private static f c = new f(p.class.getSimpleName());
  private final String a = "turnoff";
  private JSONArray b = new JSONArray();
  
  public p(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      JSONTokener localJSONTokener = new org/json/JSONTokener;
      localJSONTokener.<init>(paramString);
      localJSONObject.<init>(localJSONTokener);
      this.b = localJSONObject.optJSONArray("turnoff");
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        c.b("Config resp is not in JSONObject");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  private ArrayList<String> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramJSONArray != null) && (!"".equals(paramJSONArray)))
    {
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
              localJSONException.printStackTrace();
            }
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */