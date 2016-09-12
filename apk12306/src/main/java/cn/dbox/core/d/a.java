package cn.dbox.core.d;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import cn.dbox.core.h.d;
import java.util.Hashtable;

public class a
  extends BroadcastReceiver
{
  private static d a = new d(a.class.getSimpleName());
  private static a b;
  private static Hashtable<String, cn.dbox.core.bean.a> d;
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
  
  public void a(cn.dbox.core.bean.a parama)
  {
    if (d == null) {
      d = new Hashtable();
    }
    String str = parama.a();
    if (str != null) {
      d.put(str, parama);
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
        locald = a;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        locald.a("Intent: " + paramIntent.toString());
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
          if (this.c != null) {
            this.c.n((cn.dbox.core.bean.a)d.get(paramIntent));
          }
          if (d.get(paramIntent) == null) {
            break label290;
          }
          d locald = a;
          Object localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          locald.a("Auto run the app:" + paramIntent);
          localObject1 = paramContext.getPackageManager().getLaunchIntentForPackage(paramIntent);
          if (localObject1 == null) {
            break label258;
          }
          ((Intent)localObject1).setFlags(268435456);
          paramContext.startActivity((Intent)localObject1);
          if (this.c != null) {
            this.c.o((cn.dbox.core.bean.a)d.get(paramIntent));
          }
          a(paramIntent);
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          paramIntent = a;
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          paramIntent.e("系统无法找到包名对应App，请确认该包是否被安装 : " + "");
          a.a(localNameNotFoundException);
        }
        paramContext = paramContext;
        a.a(paramContext);
        continue;
        continue;
        label258:
        paramContext = a;
        Object localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        paramContext.e("系统无法找到包名对应App，请确认该包是否被安装 : " + paramIntent);
        continue;
        label290:
        localObject2 = (Integer)b.b.get(paramIntent);
        if (localObject2 != null)
        {
          b.b.get(paramIntent);
          ((NotificationManager)paramContext.getSystemService("notification")).cancel(((Integer)localObject2).intValue());
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void n(cn.dbox.core.bean.a parama);
    
    public abstract void o(cn.dbox.core.bean.a parama);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */