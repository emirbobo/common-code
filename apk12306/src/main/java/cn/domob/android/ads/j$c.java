package cn.domob.android.ads;

import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j$c
{
  private boolean A;
  private String B;
  private JSONArray C;
  private JSONObject D;
  private HashMap<String, String[]> E;
  private j.b F;
  private j.b G;
  private int H;
  private int I = -1;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private a o;
  private String p;
  private String q;
  private String r;
  private String s;
  private int t;
  private String u;
  private boolean v;
  private int[] w;
  private float x;
  private float y;
  private long z;
  
  public j$c(j paramj, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.b = paramJSONObject.optString("id", null);
      this.c = paramJSONObject.optString("image_url", null);
      this.d = paramJSONObject.optString("format", "domob");
      this.e = paramJSONObject.optString("ct", null);
      this.f = paramJSONObject.optString("url", null);
      this.g = paramJSONObject.optString("base_url", null);
      this.h = paramJSONObject.optString("content", null);
      this.i = paramJSONObject.optInt("width", 0);
      this.j = paramJSONObject.optInt("height", 0);
      this.k = paramJSONObject.optInt("adWidth", 0);
      this.l = paramJSONObject.optInt("adHeight", 0);
      c(paramJSONObject.optString("adop"));
      JSONObject localJSONObject = paramJSONObject.optJSONObject("expandable");
      if (localJSONObject != null) {
        this.o = new a(localJSONObject);
      }
      this.p = paramJSONObject.optString("click_tracker", null);
      this.q = paramJSONObject.optString("imp_tracker", null);
      this.r = paramJSONObject.optString("event_tracker", null);
      this.s = paramJSONObject.optString("tracker", null);
      this.t = paramJSONObject.optInt("animation", 1);
      this.u = paramJSONObject.optString("o", "");
      this.v = paramJSONObject.optBoolean("cls_btn", true);
      this.w = b(paramJSONObject.optString("cls_pos", null));
      this.x = paramJSONObject.optInt("imp_min", 0);
      this.x = ((float)paramJSONObject.optDouble("imp_min", 0.0D));
      this.y = ((float)paramJSONObject.optDouble("imp_cls", 0.0D));
      this.z = paramJSONObject.optLong("expire", System.currentTimeMillis() / 1000L + 172800L);
      this.A = paramJSONObject.optBoolean("rc", false);
      this.B = paramJSONObject.optString("pkg", null);
      this.C = paramJSONObject.optJSONArray("freq");
      this.D = paramJSONObject.optJSONObject("vav");
      this.E = a(paramJSONObject.optJSONObject("imp_progress"));
      this.F = new j.b(paramj, paramJSONObject.optJSONObject("border"));
      this.G = new j.b(paramj, paramJSONObject.optJSONObject("background"));
      this.H = paramJSONObject.optInt("interstitial_timeout", 10000);
    }
  }
  
  private HashMap<String, String[]> a(JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if (paramJSONObject != null) {
      try
      {
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = localIterator.next().toString();
          JSONArray localJSONArray = paramJSONObject.getJSONArray(str);
          String[] arrayOfString2 = null;
          String[] arrayOfString1 = arrayOfString2;
          if (!h.e(str))
          {
            arrayOfString1 = arrayOfString2;
            if (localJSONArray != null)
            {
              arrayOfString2 = new String[localJSONArray.length()];
              for (int i1 = 0;; i1++)
              {
                arrayOfString1 = arrayOfString2;
                if (i1 >= arrayOfString2.length) {
                  break;
                }
                arrayOfString2[i1] = localJSONArray.getString(i1);
              }
            }
          }
          localHashMap.put(str, arrayOfString1);
        }
        return localHashMap;
      }
      catch (JSONException paramJSONObject)
      {
        j.i().a(paramJSONObject);
      }
    }
  }
  
  private int[] b(String paramString)
  {
    int[] arrayOfInt = new int[2];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    tmp9_5;
    String[] arrayOfString;
    if (!h.e(paramString))
    {
      arrayOfString = paramString.split(",");
      paramString = arrayOfInt;
      if (arrayOfString != null)
      {
        paramString = arrayOfInt;
        if (arrayOfString.length != 2) {}
      }
    }
    for (;;)
    {
      try
      {
        arrayOfInt[0] = Integer.parseInt(arrayOfString[0]);
        arrayOfInt[1] = Integer.parseInt(arrayOfString[1]);
        paramString = arrayOfInt;
      }
      catch (NumberFormatException paramString)
      {
        j.i().a(paramString);
        paramString = arrayOfInt;
        continue;
      }
      return paramString;
      paramString = null;
    }
  }
  
  private void c(String paramString)
  {
    int i2 = 0;
    this.m = 0;
    this.n = 0;
    if ((!h.e(paramString)) && (paramString.contains(":")))
    {
      paramString = paramString.split(":");
      if (paramString.length != 2) {}
    }
    for (;;)
    {
      try
      {
        int i1 = Integer.parseInt(paramString[0]);
        int i3;
        j.i().a(paramString);
      }
      catch (NumberFormatException paramString)
      {
        try
        {
          i3 = Integer.parseInt(paramString[1]);
          i2 = i3;
          i3 = h.a(i1, i2);
          this.m = (i1 / i3);
          this.n = (i2 / i3);
          return;
        }
        catch (NumberFormatException paramString)
        {
          for (;;) {}
        }
        paramString = paramString;
        i1 = 0;
      }
    }
  }
  
  public long A()
  {
    return this.z;
  }
  
  public boolean B()
  {
    return this.A;
  }
  
  public String C()
  {
    return this.B;
  }
  
  public int D()
  {
    return this.I;
  }
  
  public JSONArray E()
  {
    return this.C;
  }
  
  public JSONObject F()
  {
    return this.D;
  }
  
  public HashMap<String, String[]> G()
  {
    return this.E;
  }
  
  public j.b H()
  {
    return this.F;
  }
  
  public j.b I()
  {
    return this.G;
  }
  
  public int J()
  {
    return this.H;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.I = paramInt;
  }
  
  public void a(String paramString)
  {
    this.c = paramString;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public int c()
  {
    return this.i;
  }
  
  public int d()
  {
    return this.j;
  }
  
  public String e()
  {
    return this.c;
  }
  
  public int f()
  {
    return this.k;
  }
  
  public int g()
  {
    return this.l;
  }
  
  public int h()
  {
    return this.m;
  }
  
  public int i()
  {
    return this.n;
  }
  
  public String j()
  {
    return this.f;
  }
  
  public String k()
  {
    return this.e;
  }
  
  public String l()
  {
    return this.g;
  }
  
  public String m()
  {
    return this.h;
  }
  
  public a n()
  {
    return this.o;
  }
  
  public String o()
  {
    return this.p;
  }
  
  public String p()
  {
    return this.q;
  }
  
  public String q()
  {
    return this.r;
  }
  
  public String r()
  {
    return this.s;
  }
  
  public int s()
  {
    return this.t;
  }
  
  public String t()
  {
    return this.u;
  }
  
  public boolean u()
  {
    return this.v;
  }
  
  public int[] v()
  {
    return this.w;
  }
  
  public float w()
  {
    return this.x;
  }
  
  public boolean x()
  {
    if (this.x != 0.0F) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public float y()
  {
    return this.y;
  }
  
  public boolean z()
  {
    if (this.y != 0.0F) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public class a
  {
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private boolean h;
    private int i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    
    a(JSONObject paramJSONObject)
    {
      if (paramJSONObject != null)
      {
        this.b = paramJSONObject.optString("render", "fs");
        this.c = paramJSONObject.optString("ct", null);
        this.d = paramJSONObject.optString("url", null);
        this.f = paramJSONObject.optString("content", null);
        this.e = paramJSONObject.optString("base_url", null);
        this.g = paramJSONObject.optString("o", "h");
        this.h = paramJSONObject.optBoolean("preload", true);
        this.i = paramJSONObject.optInt("timeout", 5);
        this.j = paramJSONObject.optBoolean("autoplay", false);
        this.k = paramJSONObject.optBoolean("cls_btn", true);
        this.l = paramJSONObject.optInt("width", -1);
        this.m = paramJSONObject.optInt("height", -1);
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
    
    public String c()
    {
      return this.d;
    }
    
    public String d()
    {
      return this.e;
    }
    
    public String e()
    {
      return this.f;
    }
    
    public String f()
    {
      return this.g;
    }
    
    public boolean g()
    {
      return this.h;
    }
    
    public int h()
    {
      return this.i;
    }
    
    public boolean i()
    {
      return this.j;
    }
    
    public boolean j()
    {
      return this.k;
    }
    
    public int k()
    {
      return this.l;
    }
    
    public int l()
    {
      return this.m;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\j$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */