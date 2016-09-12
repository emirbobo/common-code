package cn.domob.wall.core.bean;

import cn.domob.wall.core.e.b;
import cn.domob.wall.core.h.d;
import cn.domob.wall.core.h.f;
import org.json.JSONObject;

public class AdExtend
{
  d a = new d(AdExtend.class.getSimpleName());
  private String b;
  private String c;
  private boolean d;
  private String e;
  private String f;
  
  public AdExtend(JSONObject paramJSONObject)
    throws b
  {
    if (paramJSONObject != null) {
      try
      {
        this.b = paramJSONObject.getString("label");
        this.c = paramJSONObject.getString("url");
        this.e = paramJSONObject.getString("id");
        this.f = paramJSONObject.getString("tr");
        this.d = paramJSONObject.optBoolean("preload", Boolean.FALSE.booleanValue());
        paramJSONObject = this.a;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        paramJSONObject.b("adExtendJsonObject: " + toString());
        if ((f.g(this.e)) || (f.g(this.b)) || (f.g(this.f)) || (f.g(this.c)))
        {
          paramJSONObject = new cn/domob/wall/core/e/b;
          paramJSONObject.<init>();
          throw paramJSONObject;
        }
      }
      catch (Exception paramJSONObject)
      {
        this.a.a(paramJSONObject);
        throw new b(String.format("ParseAdExtendRespException: %s", new Object[] { toString() }));
      }
    }
  }
  
  public String getmId()
  {
    return this.e;
  }
  
  public String getmLabel()
  {
    return this.b;
  }
  
  public String getmTr()
  {
    return this.f;
  }
  
  public String getmUrl()
  {
    return this.c;
  }
  
  public boolean ismPreload()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "AdExtend [mLogger=" + this.a + ", mLabel=" + this.b + ", mUrl=" + this.c + ", mPreload=" + this.d + ", mId=" + this.e + ", mTr=" + this.f + "]";
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\bean\AdExtend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */