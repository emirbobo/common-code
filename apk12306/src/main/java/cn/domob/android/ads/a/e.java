package cn.domob.android.ads.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import cn.domob.android.i.f;

public class e
  extends cn.domob.android.ads.a
{
  private static f d = new f(e.class.getSimpleName());
  private String e;
  
  public e(Context paramContext, String paramString, int paramInt)
  {
    super(paramContext, paramInt);
    d.a("Initiate DomobWebView with ID = " + paramString);
    this.e = paramString;
  }
  
  protected static String a(Context paramContext, String paramString)
  {
    String str2 = Build.MODEL;
    String str1 = "1.5";
    if (Build.VERSION.RELEASE.length() > 0) {
      str1 = Build.VERSION.RELEASE;
    }
    paramContext = String.format("<script>var SDK_VERSION = '%s'; var DEVICE = '%s'; var OS = '%s'; var OS_VERSION = '%s'; var CARRIER = '%s'; var NETWORK = '%s';</script>", new Object[] { "040602", str2, "android", str1, cn.domob.android.b.a.q(paramContext), cn.domob.android.b.a.o(paramContext) });
    return paramContext + paramString;
  }
  
  public String a(String paramString, String[] paramArrayOfString)
  {
    return super.a(a(getContext(), paramString), new String[] { "domob.js" });
  }
  
  protected String d()
  {
    if (this.e == null) {
      this.e = "NO_ID";
    }
    return this.e;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */