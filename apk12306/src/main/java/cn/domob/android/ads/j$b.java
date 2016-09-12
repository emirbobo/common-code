package cn.domob.android.ads;

import android.graphics.Color;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import org.json.JSONObject;

public class j$b
{
  public static final boolean b = true;
  public final String a = "#7f000000";
  private boolean d = true;
  private int e = Color.parseColor("#7f000000");
  
  public j$b(j paramj, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.d = paramJSONObject.optBoolean("visible", true);
      paramj = paramJSONObject.optString("color");
      if (!h.e(paramj)) {
        this.e = a(paramj);
      }
    }
  }
  
  private int a(String paramString)
  {
    try
    {
      i = Color.parseColor(paramString);
      return i;
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;)
      {
        j.i().a(paramString);
        int i = Color.parseColor("#7f000000");
      }
    }
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public int b()
  {
    return this.e;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\j$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */