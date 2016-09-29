package cn.domob.android.j;

import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class b$a$a
{
  private int b = 0;
  private boolean c = true;
  private boolean d = true;
  private boolean e = true;
  private boolean f = false;
  private int g = 0;
  private int h = 1;
  private ArrayList<a> i = new ArrayList();
  
  b$a$a(b.a parama, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optInt("status", 0);
      if ((this.b != 0) && (this.b != 1) && (this.b != 2)) {
        this.b = 0;
      }
      parama = paramJSONObject.optJSONObject("full");
      int j;
      if (parama != null)
      {
        this.c = parama.optBoolean("visible", true);
        if (1 != parama.optInt("status", 0))
        {
          bool1 = true;
          this.d = bool1;
        }
      }
      else
      {
        parama = paramJSONObject.optJSONObject("mute");
        if (parama != null)
        {
          this.e = parama.optBoolean("visible", true);
          this.g = parama.optInt("status", 0);
          if ((this.g != 0) && (this.g != 1) && (this.g != 2)) {
            this.g = 0;
          }
        }
        this.h = paramJSONObject.optInt("btn_space", 1);
        if (this.h >= 0) {
          break label359;
        }
        j = 1;
        label227:
        this.h = j;
        if (paramJSONObject.optInt("btn_show", 0) != 1) {
          break label367;
        }
      }
      label359:
      label367:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.f = bool1;
        parama = paramJSONObject.optJSONArray("btns");
        if (parama == null) {
          return;
        }
        j = k;
        while (j < parama.length()) {
          try
          {
            a locala = new cn/domob/android/j/b$a$a$a;
            locala.<init>(this, parama.getJSONObject(j));
            paramJSONObject = locala.b();
            if ((paramJSONObject != null) && ((paramJSONObject.equals("goto")) || (paramJSONObject.equals("replay")) || (paramJSONObject.equals("download")) || (paramJSONObject.equals("custom")))) {
              this.i.add(locala);
            }
            j++;
          }
          catch (JSONException paramJSONObject)
          {
            for (;;)
            {
              b.i().a(paramJSONObject);
            }
          }
        }
        bool1 = false;
        break;
        j = this.h;
        break label227;
      }
    }
  }
  
  protected int a()
  {
    return this.b;
  }
  
  protected boolean b()
  {
    return this.c;
  }
  
  protected boolean c()
  {
    return this.d;
  }
  
  protected boolean d()
  {
    return this.e;
  }
  
  protected int e()
  {
    return this.g;
  }
  
  protected int f()
  {
    return this.h;
  }
  
  protected boolean g()
  {
    return this.f;
  }
  
  protected ArrayList<a> h()
  {
    return this.i;
  }
  
  class a
  {
    private String b;
    private String c;
    private int d = 0;
    private String e;
    private String[] f;
    private String[] g;
    
    a(JSONObject paramJSONObject)
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\b$a$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */