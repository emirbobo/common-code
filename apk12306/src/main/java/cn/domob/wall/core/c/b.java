package cn.domob.wall.core.c;

import cn.domob.wall.core.h.d;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class b
{
  private static d b = new d(b.class.getSimpleName());
  private JSONArray a = new JSONArray();
  
  public b(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      JSONTokener localJSONTokener = new org/json/JSONTokener;
      localJSONTokener.<init>(paramString);
      localJSONObject.<init>(localJSONTokener);
      this.a = localJSONObject.optJSONArray("turnoff");
      return;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        b.e("Config resp is not in JSONObject");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        b.a(paramString);
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
            b.a(localJSONException);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ArrayList<String> a()
  {
    return a(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */