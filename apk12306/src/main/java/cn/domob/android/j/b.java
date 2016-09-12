package cn.domob.android.j;

import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private static final String A = "full";
  private static final String B = "mute";
  private static final String C = "btn_space";
  private static final String D = "btn_show";
  private static final String E = "btns";
  private static final String F = "id";
  private static final String G = "type";
  private static final String H = "index";
  private static final String I = "action";
  private static final String J = "images";
  private static final String K = "tracker";
  private static final String L = "本视频已在Wi-Fi环境加载";
  private static final boolean M = true;
  private static final boolean N = true;
  private static final boolean O = false;
  private static final boolean P = false;
  private static final long Q = 0L;
  private static final int R = 0;
  private static final int S = 1;
  private static final int T = 0;
  private static int[] U = { 0, 0 };
  protected static final int a = 0;
  protected static final int b = 1;
  protected static final int c = 2;
  protected static final int d = 0;
  protected static final int e = 1;
  protected static final int f = 2;
  protected static final String g = "goto";
  protected static final String h = "replay";
  protected static final String i = "download";
  protected static final String j = "custom";
  private static f k = new f(b.class.getSimpleName());
  private static final String l = "auto_close";
  private static final String m = "auto_close_delay";
  private static final String n = "detail";
  private static final String o = "detail_preload";
  private static final String p = "ui";
  private static final String q = "play_min";
  private static final String r = "countdown";
  private static final String s = "prompt";
  private static final String t = "logo";
  private static final String u = "close";
  private static final String v = "actions";
  private static final String w = "visible";
  private static final String x = "offset";
  private static final String y = "content";
  private static final String z = "status";
  private boolean V = true;
  private long W = 0L;
  private boolean X = false;
  private int Y = 0;
  private String Z;
  private a aa;
  
  public b(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    if (paramJSONObject != null)
    {
      this.V = paramJSONObject.optBoolean("auto_close", true);
      this.W = paramJSONObject.optLong("auto_close_delay", 0L);
      this.Z = paramJSONObject.optString("detail");
      this.X = paramJSONObject.optBoolean("detail_preload", false);
      this.Y = paramJSONObject.optInt("play_min", 0);
      localJSONObject = paramJSONObject.optJSONObject("ui");
    }
    this.aa = new a(localJSONObject);
  }
  
  protected boolean a()
  {
    return this.V;
  }
  
  protected long b()
  {
    return this.W;
  }
  
  public String c()
  {
    return this.Z;
  }
  
  protected boolean d()
  {
    return this.X;
  }
  
  protected a e()
  {
    return this.aa;
  }
  
  protected int f()
  {
    return this.Y;
  }
  
  protected b.a.a g()
  {
    return e().j();
  }
  
  protected class a
  {
    private boolean b = true;
    private int[] c = b.h();
    private boolean d = true;
    private int[] e = b.h();
    private String f = "本视频已在Wi-Fi环境加载";
    private boolean g = true;
    private int[] h = b.h();
    private boolean i = true;
    private int[] j = b.h();
    private a k;
    
    a(JSONObject paramJSONObject)
    {
      this$1 = null;
      if (paramJSONObject != null)
      {
        this$1 = paramJSONObject.optJSONObject("countdown");
        if (b.this != null)
        {
          this.b = b.this.optBoolean("visible", true);
          this.c = a(b.this);
        }
        this$1 = paramJSONObject.optJSONObject("prompt");
        if (b.this != null)
        {
          this.d = b.this.optBoolean("visible", true);
          this.e = a(b.this);
          this.f = b.this.optString("content", "本视频已在Wi-Fi环境加载");
        }
        this$1 = paramJSONObject.optJSONObject("logo");
        if (b.this != null)
        {
          this.g = b.this.optBoolean("visible", true);
          this.h = a(b.this);
        }
        this$1 = paramJSONObject.optJSONObject("close");
        if (b.this != null)
        {
          this.i = b.this.optBoolean("visible", true);
          this.j = a(b.this);
        }
        this$1 = paramJSONObject.optJSONObject("actions");
      }
      this.k = new a(b.this);
    }
    
    private int[] a(JSONObject paramJSONObject)
    {
      JSONArray localJSONArray = paramJSONObject.optJSONArray("offset");
      if ((localJSONArray != null) && (localJSONArray.length() == 2))
      {
        paramJSONObject = new int[2];
        int m = 0;
        for (;;)
        {
          if (m < localJSONArray.length()) {
            try
            {
              paramJSONObject[m] = localJSONArray.getInt(m);
              m++;
            }
            catch (JSONException paramJSONObject)
            {
              b.i().a(paramJSONObject);
              paramJSONObject = b.h();
            }
          }
        }
      }
      for (;;)
      {
        return paramJSONObject;
        continue;
        paramJSONObject = b.h();
      }
    }
    
    protected boolean a()
    {
      return this.b;
    }
    
    protected int[] b()
    {
      return this.c;
    }
    
    protected boolean c()
    {
      return this.d;
    }
    
    protected int[] d()
    {
      return this.e;
    }
    
    protected String e()
    {
      return this.f;
    }
    
    protected boolean f()
    {
      return this.g;
    }
    
    protected int[] g()
    {
      return this.h;
    }
    
    protected boolean h()
    {
      return this.i;
    }
    
    protected int[] i()
    {
      return this.j;
    }
    
    protected a j()
    {
      return this.k;
    }
    
    class a
    {
      private int b = 0;
      private boolean c = true;
      private boolean d = true;
      private boolean e = true;
      private boolean f = false;
      private int g = 0;
      private int h = 1;
      private ArrayList<a> i = new ArrayList();
      
      a(JSONObject paramJSONObject)
      {
        if (paramJSONObject != null)
        {
          this.b = paramJSONObject.optInt("status", 0);
          if ((this.b != 0) && (this.b != 1) && (this.b != 2)) {
            this.b = 0;
          }
          this$1 = paramJSONObject.optJSONObject("full");
          int j;
          if (b.a.this != null)
          {
            this.c = b.a.this.optBoolean("visible", true);
            if (1 != b.a.this.optInt("status", 0))
            {
              bool1 = true;
              this.d = bool1;
            }
          }
          else
          {
            this$1 = paramJSONObject.optJSONObject("mute");
            if (b.a.this != null)
            {
              this.e = b.a.this.optBoolean("visible", true);
              this.g = b.a.this.optInt("status", 0);
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
            this$1 = paramJSONObject.optJSONArray("btns");
            if (b.a.this == null) {
              return;
            }
            j = k;
            while (j < b.a.this.length()) {
              try
              {
                a locala = new cn/domob/android/j/b$a$a$a;
                locala.<init>(this, b.a.this.getJSONObject(j));
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
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */