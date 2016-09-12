package cn.domob.android.ads;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import cn.domob.android.c.a;
import cn.domob.android.i.f;
import java.util.Hashtable;

public class e
  extends BroadcastReceiver
{
  private static f a = new f(e.class.getSimpleName());
  private static e b;
  private static Hashtable<String, q> d;
  private e.a c;
  
  public static e a()
  {
    if (b != null) {}
    for (e locale = b;; locale = null)
    {
      return locale;
      a.e("ActionReceiver needs to be initialized first.");
    }
  }
  
  protected static void a(Context paramContext, e.a parama)
  {
    if (b == null)
    {
      b = new e();
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
  
  public void a(q paramq)
  {
    if (d == null) {
      d = new Hashtable();
    }
    String str = paramq.c();
    if (str != null) {
      d.put(str, paramq);
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
      String str;
      do
      {
        return;
        str = paramIntent.getAction();
        localObject = a;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        ((f)localObject).a("Intent: " + paramIntent.toString());
      } while (!"android.intent.action.PACKAGE_ADDED".equals(str));
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
            break label350;
          }
          if (this.c != null) {
            this.c.a((q)d.get(paramIntent));
          }
          if (!((q)d.get(paramIntent)).f()) {
            break label308;
          }
          localObject = a;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          ((f)localObject).a("Auto run the app:" + paramIntent);
          localObject = paramContext.getPackageManager().getLaunchIntentForPackage(paramIntent);
          if (localObject == null) {
            break label276;
          }
          ((Intent)localObject).setFlags(268435456);
          paramContext.startActivity((Intent)localObject);
          if (this.c != null) {
            this.c.b((q)d.get(paramIntent));
          }
          a(paramIntent);
        }
        catch (PackageManager.NameNotFoundException paramContext)
        {
          paramIntent = a;
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          paramIntent.e("系统无法找到包名对应App，请确认该包是否被安装 : " + "");
          a.a(paramContext);
        }
        paramContext = paramContext;
        a.a(paramContext);
        continue;
        continue;
        label276:
        paramContext = a;
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        paramContext.e("系统无法找到包名对应App，请确认该包是否被安装 : " + paramIntent);
        continue;
        label308:
        localObject = (Integer)a.b.get(paramIntent);
        if (localObject != null)
        {
          a.b.get(paramIntent);
          ((NotificationManager)paramContext.getSystemService("notification")).cancel(((Integer)localObject).intValue());
          continue;
          label350:
          paramContext = a;
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          paramContext.e("该包名没有被注册，不进行report : " + paramIntent);
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\E.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */