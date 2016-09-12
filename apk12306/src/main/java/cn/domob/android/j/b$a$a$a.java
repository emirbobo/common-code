package cn.domob.android.j;

import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b$a$a$a
{
  private String b;
  private String c;
  private int d = 0;
  private String e;
  private String[] f;
  private String[] g;
  
  b$a$a$a(b.a.a parama, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optString("id");
      this.c = paramJSONObject.optString("type");
      this.d = paramJSONObject.optInt("index", 0);
      this.e = paramJSONObject.optString("action");
      this.f = a(paramJSONObject.optJSONArray("images"));
      if (this.f.length != 2) {
        this.f = null;
      }
      this.g = a(paramJSONObject.optJSONArray("tracker"));
    }
  }
  
  private String[] a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null) {
      for (int i = 0;; i++)
      {
        if (i >= paramJSONArray.length()) {
          break label68;
        }
        Object localObject = null;
        try
        {
          String str = paramJSONArray.getString(i);
          localObject = str;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            b.i().a(localJSONException);
          }
        }
        if (!h.e((String)localObject)) {
          localArrayList.add(localObject);
        }
      }
    }
    label68:
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  protected String a()
  {
    return this.b;
  }
  
  protected String b()
  {
    return this.c;
  }
  
  protected int c()
  {
    return this.d;
  }
  
  protected String d()
  {
    return this.e;
  }
  
  protected String[] e()
  {
    return this.f;
  }
  
  protected String[] f()
  {
    return this.g;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\b$a$a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */