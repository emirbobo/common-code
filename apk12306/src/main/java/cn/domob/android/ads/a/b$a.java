package cn.domob.android.ads.a;

import android.net.Uri;
import cn.domob.android.ads.a;
import cn.domob.android.ads.a.a;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.util.HashMap;

class b$a
  implements a.a
{
  b$a(b paramb) {}
  
  public void a(a parama, String paramString)
  {
    b.b().b("Activity WebView 拦截到 URL：" + paramString);
    parama = Uri.parse(paramString);
    paramString = parama.getHost();
    if (paramString.equals("picture"))
    {
      int i = Integer.parseInt((String)h.a(parama.getEncodedQuery()).get("src"));
      b.a(this.a, parama, i);
    }
    for (;;)
    {
      return;
      if (paramString.equals("submit"))
      {
        Object localObject = h.a(parama.getEncodedQuery());
        paramString = (String)((HashMap)localObject).get("name");
        String str = (String)((HashMap)localObject).get("local");
        parama = (String)((HashMap)localObject).get("url");
        localObject = (String)((HashMap)localObject).get("cb");
        b.a(this.a, paramString, str, parama, (String)localObject);
      }
      else
      {
        b.b().e("Handle unknown action : " + paramString + " in activity");
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\b$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */