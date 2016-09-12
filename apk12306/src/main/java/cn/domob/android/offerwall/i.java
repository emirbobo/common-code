package cn.domob.android.offerwall;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class i
{
  static final String a = "http://duomeng.cn/api/12306/rp";
  private static m b = new m(i.class.getSimpleName());
  private static final String c = "ua";
  private static final String d = "ipb";
  private static final String e = "jstr";
  private static final String f = "type";
  private static final String g = "id";
  private static final String h = "idtype";
  private static final String i = "ts";
  
  static void a(Context paramContext, a parama)
  {
    try
    {
      String str = b(paramContext, parama);
      Object localObject1 = b;
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((m)localObject1).b("Report params: " + str);
      if (l.e(str)) {
        b.e("Report params is null or empty.");
      }
      for (;;)
      {
        return;
        localObject1 = new cn/domob/android/offerwall/e;
        localObject2 = parama.c;
        e.a local1 = new cn/domob/android/offerwall/i$1;
        local1.<init>(parama);
        ((e)localObject1).<init>(paramContext, (String)localObject2, str, local1);
        ((e)localObject1).b();
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        b.e("Error happened while reporting.");
        b.a(paramContext);
      }
    }
  }
  
  private static String b(Context paramContext, a parama)
  {
    String str1;
    String str2;
    JSONArray localJSONArray;
    JSONObject localJSONObject;
    try
    {
      str1 = f.e(paramContext);
      str2 = DomobOfferWallSetting.a();
      localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>();
      localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("type", parama.a);
      paramContext = new org/json/JSONArray;
      paramContext.<init>();
      Iterator localIterator = parama.b.iterator();
      while (localIterator.hasNext())
      {
        paramContext.put((String)localIterator.next());
        continue;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      b.e("Error happened while building report params.");
      b.a(paramContext);
      paramContext = null;
    }
    for (;;)
    {
      localJSONObject.put("id", paramContext);
      paramContext = "app";
      if (parama.a == "installed") {
        paramContext = "pkg";
      }
      localJSONObject.put("idtype", paramContext);
      localJSONObject.put("ts", String.valueOf(System.currentTimeMillis()));
      localJSONArray.put(localJSONObject);
      parama = localJSONArray.toString();
      paramContext = new java/util/HashMap;
      paramContext.<init>();
      paramContext.put("ua", str1);
      paramContext.put("ipb", str2);
      paramContext.put("jstr", parama);
      paramContext = l.a(paramContext);
    }
  }
  
  static class a
  {
    String a;
    ArrayList<String> b = new ArrayList();
    String c;
  }
  
  class b
  {
    static final String a = "show_list";
    static final String b = "show_detail";
    static final String c = "download";
    static final String d = "download_finish";
    static final String e = "close_list";
    static final String f = "installed";
    static final String g = "run";
    
    b() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */