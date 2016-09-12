package cn.domob.wall.core.download;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.d;
import java.util.Hashtable;

public class a
  extends BroadcastReceiver
{
  private static d a = new d(a.class.getSimpleName());
  private static a b;
  private static Hashtable<String, AdInfo> d;
  private a c;
  
  public static a a()
  {
    if (b != null) {}
    for (a locala = b;; locala = null)
    {
      return locala;
      a.e("ActionReceiver needs to be initialized first.");
    }
  }
  
  public static void a(Context paramContext, a parama)
  {
    if (b == null)
    {
      b = new a();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addDataScheme("package");
      paramContext.getApplicationContext().registerReceiver(b, localIntentFilter);
      b.c = parama;
      a.b("Finish to init action receiver.");
    }
    for (;;)
    {
      return;
      a.b("Action receiver has already been initialized.");
    }
  }
  
  public void a(AdInfo paramAdInfo)
  {
    if (d == null) {
      d = new Hashtable();
    }
    String str = paramAdInfo.getAdPackageName();
    if (str != null) {
      d.put(str, paramAdInfo);
    }
    for (;;)
    {
      return;
      a.e("There is no package name in ad response.");
    }
  }
  
  protected void a(String paramString)
  {
    if (d == null) {
      d = new Hashtable();
    }
    if (d.containsKey(paramString))
    {
      a.a("Remove info : " + d.get(paramString));
      d.remove(paramString);
    }
    for (;;)
    {
      return;
      a.e("There is no key like " + paramString + " in regPkgTalbe.");
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (d == null) {}
      do
      {
        return;
        localObject2 = paramIntent.getAction();
        d locald = a;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        locald.a("Intent: " + paramIntent.toString());
      } while (!"android.intent.action.PACKAGE_ADDED".equals(localObject2));
      paramIntent = paramIntent.getDataString().substring(8);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        try
        {
          paramIntent = paramContext.getPackageManager().getPackageInfo(paramIntent, 0).packageName;
          if (!d.containsKey(paramIntent)) {
            break label342;
          }
          if (this.c != null) {
            this.c.t((AdInfo)d.get(paramIntent));
          }
          if (d.get(paramIntent) == null) {
            break label300;
          }
          Object localObject2 = a;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((d)localObject2).a("Auto run the app:" + paramIntent);
          localObject1 = paramContext.getPackageManager().getLaunchIntentForPackage(paramIntent);
          if (localObject1 == null) {
            break label268;
          }
          ((Intent)localObject1).setFlags(268435456);
          paramContext.startActivity((Intent)localObject1);
          if (this.c != null) {
            this.c.u((AdInfo)d.get(paramIntent));
          }
          a(paramIntent);
        }
        catch (PackageManager.NameNotFoundException paramIntent)
        {
          localObject1 = a;
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          ((d)localObject1).e("系统无法找到包名对应App，请确认该包是否被安装 : " + "");
          a.a(paramIntent);
        }
        paramContext = paramContext;
        a.a(paramContext);
        continue;
        continue;
        label268:
        Object localObject1 = a;
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>();
        ((d)localObject1).e("系统无法找到包名对应App，请确认该包是否被安装 : " + paramIntent);
        continue;
        label300:
        localObject1 = (Integer)b.b.get(paramIntent);
        if (localObject1 != null)
        {
          b.b.get(paramIntent);
          ((NotificationManager)paramContext.getSystemService("notification")).cancel(((Integer)localObject1).intValue());
          continue;
          label342:
          paramContext = a;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          paramContext.e("该包名没有被注册，不进行report : " + paramIntent);
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void t(AdInfo paramAdInfo);
    
    public abstract void u(AdInfo paramAdInfo);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */