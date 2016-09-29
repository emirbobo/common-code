package cn.domob.wall.core;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;
import cn.domob.wall.core.a.b.a;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.bean.AdInfo.AdStyle;
import cn.domob.wall.core.bean.AdInfo.ClickActionType;
import cn.domob.wall.core.download.d.a;
import cn.domob.wall.core.f.b.j;
import cn.domob.wall.core.f.b.k;
import cn.domob.wall.core.f.b.m;
import cn.domob.wall.core.h.f;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class a
  implements cn.domob.wall.core.a.a.a, b.a, cn.domob.wall.core.download.a.a, d.a
{
  private static cn.domob.wall.core.h.d a = new cn.domob.wall.core.h.d(a.class.getSimpleName());
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  private b e;
  private Context f;
  private boolean g = false;
  
  a(Context paramContext, b paramb)
  {
    this.e = paramb;
    this.f = paramContext;
  }
  
  private void a()
  {
    this.b = false;
    this.c = false;
    this.d = false;
  }
  
  private boolean a(AdInfo paramAdInfo, String paramString)
    throws Exception
  {
    Object localObject = Uri.parse(paramString);
    String str = ((Uri)localObject).getHost();
    if (str.equals("inapp"))
    {
      a.b("overrideUri=" + localObject);
      paramString = URLDecoder.decode(((Uri)localObject).getQueryParameter("url"), "UTF-8");
      a.a("Open landing page with URL:" + paramString);
      localObject = this.f;
      if (localObject != null)
      {
        a();
        new cn.domob.wall.core.a.b((Context)localObject, paramString, null, this, paramAdInfo).a().show();
      }
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (str.equals("download"))
      {
        if (!this.g)
        {
          cn.domob.wall.core.download.a.a(this.f, this);
          this.g = true;
        }
        paramString = URLDecoder.decode(((Uri)localObject).getQueryParameter("url"), "UTF-8");
        new cn.domob.wall.core.download.d(this.f, (Uri)localObject, paramAdInfo, this).a(this.f);
        a.b("Download app with URL:" + paramString);
        break;
      }
      if (str.equals("launch"))
      {
        new cn.domob.wall.core.a.a(this.f, (Uri)localObject, this, paramAdInfo).a();
        break;
      }
      if (paramString.startsWith("http"))
      {
        localObject = f.a(this.f, Uri.parse(paramString));
        paramAdInfo = (AdInfo)localObject;
        if (localObject == null) {
          paramAdInfo = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        }
        this.f.startActivity(paramAdInfo);
        break;
      }
      a.e("Handle unknown action : " + str);
    }
  }
  
  private boolean b()
  {
    if ((!this.b) && (!this.d) && (!this.c)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private b.k v(AdInfo paramAdInfo)
  {
    paramAdInfo = paramAdInfo.getAdStyle();
    if (paramAdInfo == AdInfo.AdStyle.BANNER) {
      paramAdInfo = b.k.b;
    }
    for (;;)
    {
      return paramAdInfo;
      if ((paramAdInfo == AdInfo.AdStyle.HOUSE_AD) || (paramAdInfo == AdInfo.AdStyle.XX))
      {
        paramAdInfo = b.k.c;
      }
      else
      {
        a.e("ad style error: " + paramAdInfo);
        paramAdInfo = b.k.a;
      }
    }
  }
  
  void a(DService.EWallReportType paramEWallReportType)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramEWallReportType, null);
  }
  
  void a(DService.ReportUserActionType paramReportUserActionType)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramReportUserActionType);
  }
  
  void a(AdInfo paramAdInfo)
  {
    g(paramAdInfo);
  }
  
  void a(AdInfo paramAdInfo, DService.ReportDownLoadType paramReportDownLoadType)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, paramReportDownLoadType);
  }
  
  public void a(String paramString, WebView paramWebView, AdInfo paramAdInfo) {}
  
  public void a(String paramString, AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.m.c, paramString);
  }
  
  public void a(String paramString1, String paramString2, AdInfo paramAdInfo)
  {
    a.a(String.format("LandingPage 内下载，地址为%s，infoURL为%s", new Object[] { paramString1, paramString2 }));
    if (paramString2 != null) {}
    for (;;)
    {
      try
      {
        if (paramString2.length() != 0)
        {
          localObject = f.b(Uri.parse(paramString2).getQuery());
          if (((HashMap)localObject).containsKey("url")) {
            ((HashMap)localObject).put("url", paramString1);
          }
          String str = f.a((HashMap)localObject);
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          localObject = f.a() + "://download?" + str;
          a(paramAdInfo, (String)localObject);
          return;
        }
      }
      catch (Exception paramAdInfo)
      {
        Object localObject;
        a.e(String.format("解析LandingPage中下载出现错误，地址为%s，infoURL为%s", new Object[] { paramString1, paramString2 }));
        continue;
      }
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = f.a() + "://download?url=" + URLEncoder.encode(paramString1, "UTF-8");
    }
  }
  
  void a(ArrayList<AdInfo> paramArrayList)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramArrayList);
  }
  
  void b(AdInfo paramAdInfo)
  {
    g(paramAdInfo);
  }
  
  public void b(String paramString, AdInfo paramAdInfo)
  {
    try
    {
      if (a(paramAdInfo, paramString)) {
        cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.m.d, paramString);
      }
      for (;;)
      {
        return;
        cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.m.e, paramString);
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        a.a(paramString);
      }
    }
  }
  
  void c(AdInfo paramAdInfo)
  {
    if (paramAdInfo.isAdActualPositionAvailable()) {
      if ((!paramAdInfo.getAdActionType().equals(AdInfo.ClickActionType.DOWNLOAD)) || (!paramAdInfo.isShowDetail())) {}
    }
    for (;;)
    {
      return;
      g(paramAdInfo);
      continue;
      Log.w("DrwSDK", "Please implement the method setAdActualPosition(int position) of AdInfo, otherwise it is impossible to achieve onClickWallItem(AdInfo itemInfo)");
    }
  }
  
  void d(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.k.e);
  }
  
  void e(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.k.d);
  }
  
  void f(AdInfo paramAdInfo)
  {
    if (paramAdInfo.isAdActualPositionAvailable()) {
      cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, v(paramAdInfo));
    }
    for (;;)
    {
      return;
      Log.w("DrwSDK", "Please implement the method setAdActualPosition(int position) of AdInfo, otherwise it is impossible to achieve onClickWallItem(AdInfo itemInfo)");
    }
  }
  
  boolean g(AdInfo paramAdInfo)
  {
    String str1 = paramAdInfo.getAdActionURL();
    try
    {
      Object localObject;
      if (str1.startsWith(f.a()))
      {
        String str2 = Uri.parse(str1).getScheme();
        if (!f.a().equals(str2)) {
          break label134;
        }
        localObject = a;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        ((cn.domob.wall.core.h.d)localObject).a("Scheme xxx action scheme =" + str2);
      }
      label134:
      for (bool = a(paramAdInfo, str1);; bool = true)
      {
        return bool;
        if (str1.startsWith("http"))
        {
          localObject = f.a(this.f, Uri.parse(str1));
          paramAdInfo = (AdInfo)localObject;
          if (localObject == null)
          {
            paramAdInfo = new android/content/Intent;
            paramAdInfo.<init>("android.intent.action.VIEW", Uri.parse(str1));
          }
          this.f.startActivity(paramAdInfo);
        }
      }
    }
    catch (Exception paramAdInfo)
    {
      for (;;)
      {
        a.e("Exception in click.");
        a.a(paramAdInfo);
        boolean bool = false;
      }
    }
  }
  
  public void h(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.m.b, null);
  }
  
  public void i(AdInfo paramAdInfo)
  {
    if (b())
    {
      cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.j.b);
      this.b = true;
    }
  }
  
  public void j(AdInfo paramAdInfo)
  {
    if (b())
    {
      cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.j.c);
      this.d = true;
    }
  }
  
  public void k(AdInfo paramAdInfo)
  {
    if (b())
    {
      cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.j.d);
      this.c = true;
    }
  }
  
  public void l(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, b.j.e);
  }
  
  public void m(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, DService.ReportDownLoadType.DL_FINISH);
  }
  
  public void n(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, DService.ReportDownLoadType.DL_FAILED);
  }
  
  public void o(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, DService.ReportDownLoadType.DL_START);
  }
  
  public void p(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, DService.ReportDownLoadType.DL_CANCEL);
  }
  
  public void q(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, DService.ReportDownLoadType.DL_REPEAT);
    if (this.f != null) {
      ((Activity)this.f).runOnUiThread(new Runnable()
      {
        public void run()
        {
          Toast.makeText(a.a(a.this), "应用正在下载", 0).show();
        }
      });
    }
  }
  
  public void r(AdInfo paramAdInfo) {}
  
  public void s(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.download.a.a().a(paramAdInfo);
  }
  
  public void t(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, DService.ReportDownLoadType.INSTALL_SUCCESS);
  }
  
  public void u(AdInfo paramAdInfo)
  {
    cn.domob.wall.core.f.a.a().a(this.e, paramAdInfo, DService.ReportDownLoadType.AUTO_RUN);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */