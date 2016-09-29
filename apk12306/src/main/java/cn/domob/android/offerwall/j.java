package cn.domob.android.offerwall;

import android.content.Context;
import android.util.Log;
import java.util.HashMap;
import java.util.Locale;

class j
  implements e.a
{
  private static final String A = "cid";
  private static final String B = "json_data";
  private static final String C = "UTF-8";
  private static final String D = "zh-cn";
  private static m a = new m(j.class.getSimpleName());
  private static final String d = "http://duomeng.cn/api/12306/";
  private static final String e = "rt";
  private static final String f = "ts";
  private static final String g = "ua";
  private static final String h = "ipb";
  private static final String i = "idv";
  private static final String j = "sdk";
  private static final String k = "v";
  private static final String l = "l";
  private static final String m = "f";
  private static final String n = "e";
  private static final String o = "so";
  private static final String p = "sw";
  private static final String q = "sh";
  private static final String r = "sd";
  private static final String s = "pb[identifier]";
  private static final String t = "pb[version]";
  private static final String u = "d[coord]";
  private static final String v = "d[coord_timestamp]";
  private static final String w = "d[pc]";
  private static final String x = "d[dob]";
  private static final String y = "d[gender]";
  private static final String z = "network";
  private Context b;
  private a c;
  
  j(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private String a()
  {
    HashMap localHashMap = b();
    if (localHashMap != null) {
      localHashMap.putAll(c());
    }
    return l.a(localHashMap);
  }
  
  private HashMap<String, String> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("sdk", String.valueOf(6));
    localHashMap.put("rt", String.valueOf(1));
    localHashMap.put("ts", String.valueOf(System.currentTimeMillis()));
    String str = f.e(this.b);
    Object localObject = str;
    if (str == null) {
      localObject = "Android,,,,,,,,";
    }
    localHashMap.put("ua", localObject);
    localObject = DomobOfferWallSetting.a();
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localHashMap.put("ipb", localObject);
      localHashMap.put("idv", f.f(this.b));
      localHashMap.put("v", "020000-android-20120726");
      str = Locale.getDefault().getLanguage();
      if (str == null) {
        break label388;
      }
      localObject = new StringBuffer();
      ((StringBuffer)localObject).append(str.toLowerCase());
      str = Locale.getDefault().getCountry();
      if (str != null)
      {
        ((StringBuffer)localObject).append("-");
        ((StringBuffer)localObject).append(str.toLowerCase());
      }
    }
    label388:
    for (localObject = ((StringBuffer)localObject).toString();; localObject = "zh-cn")
    {
      localHashMap.put("l", localObject);
      localHashMap.put("f", "json_data");
      localHashMap.put("e", "UTF-8");
      str = DomobOfferWallSetting.b();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      if (localObject != null) {
        localHashMap.put("cid", localObject);
      }
      localHashMap.put("so", f.r(this.b));
      localHashMap.put("sw", String.valueOf(f.w(this.b)));
      localHashMap.put("sh", String.valueOf(f.x(this.b)));
      localHashMap.put("sd", String.valueOf(f.t(this.b)));
      localHashMap.put("pb[identifier]", f.a(this.b));
      localHashMap.put("pb[version]", String.valueOf(f.b(this.b)));
      localObject = f.A(this.b);
      if (localObject != null)
      {
        localHashMap.put("d[coord]", localObject);
        localHashMap.put("d[coord_timestamp]", String.valueOf(f.e()));
      }
      localObject = f.o(this.b);
      if (localObject != null) {
        localHashMap.put("network", localObject);
      }
      return localHashMap;
      Log.e("DomobSDK", "publisher id is null or empty!");
      break;
    }
  }
  
  private HashMap<String, String> c()
  {
    HashMap localHashMap = new HashMap();
    String str = DomobOfferWallSetting.c();
    if ((str != null) && (str.length() > 0)) {
      localHashMap.put("d[pc]", str);
    }
    str = DomobOfferWallSetting.d();
    if ((str != null) && (str.length() > 0)) {
      localHashMap.put("d[dob]", str);
    }
    str = DomobOfferWallSetting.e();
    if ((str != null) && (str.length() > 0)) {
      localHashMap.put("d[gender]", str);
    }
    return localHashMap;
  }
  
  public void a(e parame)
  {
    Object localObject = null;
    if (parame != null)
    {
      parame = parame.e();
      if ((parame != null) && (parame.length() != 0))
      {
        a.a("Ad resp string:" + parame);
        parame = k.a(parame);
        if (this.c != null) {
          this.c.a(parame);
        }
      }
    }
    for (;;)
    {
      return;
      a.e("Ad respStr is null.");
      parame = (e)localObject;
      break;
      a.e("Connection error.");
      if (this.c != null) {
        this.c.a(null);
      }
    }
  }
  
  void a(a parama)
  {
    this.c = parama;
    parama = a();
    a.b("Request params: " + parama);
    new e(this.b, "http://duomeng.cn/api/12306/", parama, this).b();
  }
  
  static abstract interface a
  {
    public abstract void a(k paramk);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */