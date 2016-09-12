package cn.domob.android.ads.b;

import cn.domob.android.i.f;

abstract class j
{
  private static f a = new f(j.class.getSimpleName());
  
  private String a(String paramString)
  {
    if (paramString != null) {}
    for (paramString = paramString.replaceAll("[^a-zA-Z0-9_,:\\s\\{\\}\\'\\\"]", "");; paramString = "") {
      return paramString;
    }
  }
  
  public abstract String a();
  
  public String toString()
  {
    String str = a(a());
    a.a("MRAID property:" + str);
    return str;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */