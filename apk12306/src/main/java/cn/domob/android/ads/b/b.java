package cn.domob.android.ads.b;

import java.util.Map;

abstract class b
{
  protected Map<String, String> a;
  protected m b;
  
  b(Map<String, String> paramMap, m paramm)
  {
    this.a = paramMap;
    this.b = paramm;
  }
  
  protected int a(String paramString)
  {
    paramString = (String)this.a.get(paramString);
    int i;
    if (paramString == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        i = Integer.parseInt(paramString, 10);
      }
      catch (NumberFormatException paramString)
      {
        i = -1;
      }
    }
  }
  
  abstract void a();
  
  protected String b(String paramString)
  {
    return (String)this.a.get(paramString);
  }
  
  protected float c(String paramString)
  {
    float f;
    if ((String)this.a.get(paramString) == null) {
      f = 0.0F;
    }
    for (;;)
    {
      return f;
      try
      {
        f = Float.parseFloat(paramString);
      }
      catch (NumberFormatException paramString)
      {
        f = 0.0F;
      }
    }
  }
  
  protected boolean d(String paramString)
  {
    return "true".equals(this.a.get(paramString));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */