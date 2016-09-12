package cn.domob.android.ads;

import android.content.Context;
import android.util.Log;
import cn.domob.android.e.a;
import cn.domob.android.i.d;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class j
{
  public static final String A = "content";
  public static final String B = "base_url";
  public static final String C = "o";
  public static final String D = "preload";
  public static final String E = "timeout";
  public static final String F = "autoplay";
  public static final String G = "cls_btn";
  public static final String H = "width";
  public static final String I = "height";
  public static final String J = "click_tracker";
  public static final String K = "imp_tracker";
  public static final String L = "event_tracker";
  public static final String M = "tracker";
  public static final String N = "animation";
  public static final String O = "o";
  public static final String P = "cls_btn";
  public static final String Q = "cls_pos";
  public static final String R = "imp_min";
  public static final String S = "imp_cls";
  public static final String T = "expire";
  public static final String U = "rc";
  public static final String V = "pkg";
  public static final String W = "mz_url";
  public static final String X = "vav";
  public static final String Y = "imp_progress";
  public static final String Z = "border";
  public static final String a = "/.dm/";
  public static final String aa = "background";
  public static final String ab = "color";
  public static final String ac = "visible";
  public static final String ad = "interstitial_timeout";
  public static final String ae = "code";
  public static final String af = "text";
  public static final String ag = "refresh";
  public static final String ah = "disable";
  public static final String ai = "dis_time";
  public static final String aj = "ors";
  public static final String ak = "version";
  public static final String al = "config";
  public static final String am = "freq_max";
  public static final String an = "freq_reset";
  public static final String ao = "cached_max";
  public static final String ap = "sp_timeout";
  public static final String aq = "image_url";
  private static f ar = new f(j.class.getSimpleName());
  public static final String b = "dm.file";
  public static final String c = "sid";
  public static final String d = "dmid";
  public static final String e = "cid";
  public static final String f = "ad";
  public static final String g = "error";
  public static final String h = "control";
  public static final String i = "freq";
  public static final String j = "cache";
  public static final String k = "debug";
  public static final String l = "id";
  public static final String m = "format";
  public static final String n = "width";
  public static final String o = "height";
  public static final String p = "adWidth";
  public static final String q = "adHeight";
  public static final String r = "adop";
  public static final String s = "ct";
  public static final String t = "url";
  public static final String u = "content";
  public static final String v = "base_url";
  public static final String w = "expandable";
  public static final String x = "render";
  public static final String y = "ct";
  public static final String z = "url";
  private String aA = null;
  private String as;
  private String at;
  private String au;
  private j.c av;
  private j.d aw;
  private j.a ax;
  private Context ay;
  private JSONArray az;
  
  public static j a(Context paramContext, String paramString)
  {
    j localj = new j();
    localj.ay = paramContext;
    if (localj.c(paramString)) {
      ar.a("Ad/Error response is ok.");
    }
    for (paramContext = localj;; paramContext = null) {
      return paramContext;
    }
  }
  
  public static j a(String paramString)
  {
    return a(null, paramString);
  }
  
  private boolean c(String paramString)
  {
    for (;;)
    {
      try
      {
        this.as = paramString;
        Object localObject3 = new org/json/JSONObject;
        localObject1 = new org/json/JSONTokener;
        ((JSONTokener)localObject1).<init>(paramString);
        ((JSONObject)localObject3).<init>((JSONTokener)localObject1);
        this.at = ((JSONObject)localObject3).optString("sid", null);
        d.a("/.dm/", "dm.file", ((JSONObject)localObject3).optString("dmid", null));
        this.au = ((JSONObject)localObject3).optString("cid", null);
        localObject1 = ((JSONObject)localObject3).optJSONObject("ad");
        localObject2 = ((JSONObject)localObject3).optJSONObject("error");
        paramString = ((JSONObject)localObject3).optJSONObject("control");
        this.az = ((JSONObject)localObject3).optJSONArray("cache");
        localObject3 = ((JSONObject)localObject3).optString("debug");
        if (!h.e((String)localObject3)) {
          Log.d(f.b(), (String)localObject3);
        }
        if (localObject1 == null) {
          continue;
        }
        localObject2 = new cn/domob/android/ads/j$c;
        ((j.c)localObject2).<init>(this, (JSONObject)localObject1);
        this.av = ((j.c)localObject2);
      }
      catch (Exception paramString)
      {
        Object localObject1;
        Object localObject2;
        ar.a(paramString);
        boolean bool = false;
        continue;
        ar.e("There is no ad response or error response.");
        continue;
      }
      if (paramString != null)
      {
        localObject1 = new cn/domob/android/ads/j$a;
        ((j.a)localObject1).<init>(this, paramString);
        this.ax = ((j.a)localObject1);
      }
      if (this.av != null) {
        a.a(this.ay, this.av.E());
      }
      bool = true;
      return bool;
      if (localObject2 == null) {
        continue;
      }
      localObject1 = new cn/domob/android/ads/j$d;
      ((j.d)localObject1).<init>(this, (JSONObject)localObject2);
      this.aw = ((j.d)localObject1);
    }
  }
  
  public String a()
  {
    return this.as;
  }
  
  public String b()
  {
    return this.at;
  }
  
  public void b(String paramString)
  {
    this.aA = paramString;
  }
  
  public String c()
  {
    return this.au;
  }
  
  public j.c d()
  {
    return this.av;
  }
  
  public j.d e()
  {
    return this.aw;
  }
  
  public j.a f()
  {
    return this.ax;
  }
  
  public JSONArray g()
  {
    return this.az;
  }
  
  public String h()
  {
    return this.aA;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\J.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */