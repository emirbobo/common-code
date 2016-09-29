package cn.domob.wall.core.c;

import android.content.Context;
import cn.domob.wall.core.bean.a;
import cn.domob.wall.core.h.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class f
{
  private static d a = new d(f.class.getSimpleName());
  private static final String e = "error";
  private String b;
  private String c;
  private a d;
  private List<String> f = new ArrayList();
  
  private boolean b(Context paramContext, String paramString)
  {
    boolean bool = false;
    JSONObject localJSONObject;
    try
    {
      localJSONObject = new org/json/JSONObject;
      Object localObject = new org/json/JSONTokener;
      ((JSONTokener)localObject).<init>(paramString);
      localJSONObject.<init>((JSONTokener)localObject);
      this.b = localJSONObject.optString("sid", "");
      this.c = localJSONObject.optString("cid", "");
      if ((this.c != null) && (!this.c.equals(""))) {
        h.a().a(paramContext, this.c);
      }
      try
      {
        paramContext = new org/json/JSONArray;
        paramContext.<init>(localJSONObject.getString("hotword"));
        if (paramContext == null) {
          break label210;
        }
        i = 0;
        int j = paramContext.length();
        if (i >= j) {
          break label218;
        }
      }
      catch (JSONException paramContext)
      {
        try
        {
          for (;;)
          {
            int i;
            paramString = a;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            paramString.b("hotword:" + paramContext.getString(i));
            this.f.add(paramContext.getString(i));
            i++;
          }
          paramContext = paramContext;
          a.b(paramContext.toString());
          paramContext = null;
        }
        catch (JSONException paramString)
        {
          for (;;)
          {
            a.a(paramString);
          }
        }
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      a.a(paramContext);
    }
    for (;;)
    {
      label210:
      a.d("Screenshot of the page with details of the ad is empty");
      label218:
      paramContext = localJSONObject.optJSONObject("error");
      if (paramContext != null)
      {
        paramString = new cn/domob/wall/core/bean/a;
        paramString.<init>(paramContext);
        this.d = paramString;
      }
      bool = true;
    }
  }
  
  f a(Context paramContext, String paramString)
  {
    f localf = new f();
    if (localf.b(paramContext, paramString)) {
      a.a("Ad/Error response is ok.");
    }
    for (paramContext = localf;; paramContext = null) {
      return paramContext;
    }
  }
  
  String a()
  {
    return this.b;
  }
  
  a b()
  {
    return this.d;
  }
  
  public List<String> c()
  {
    return this.f;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */