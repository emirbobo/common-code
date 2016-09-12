package cn.domob.android.offerwall;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import cn.domob.android.a.a;
import java.util.Hashtable;

public class d
  extends BroadcastReceiver
{
  private static m a = new m(d.class.getSimpleName());
  private static d b;
  private static a c;
  private static Hashtable<String, g> d;
  
  protected static d a()
  {
    if (b != null) {}
    for (d locald = b;; locald = null)
    {
      return locald;
      a.e("ActionReceiver needs to be initialized first.");
    }
  }
  
  protected static void a(Context paramContext, a parama)
  {
    if (b == null)
    {
      b = new d();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
      localIntentFilter.addDataScheme("package");
      paramContext.getApplicationContext().registerReceiver(b, localIntentFilter);
      c = parama;
      a.b("Finish to init action receiver.");
    }
    for (;;)
    {
      return;
      a.b("Action receiver has already been initialized.");
    }
  }
  
  protected void a(g paramg)
  {
    if (d == null) {
      d = new Hashtable();
    }
    String str = paramg.c();
    if (str != null) {
      d.put(str, paramg);
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
        localObject = paramIntent.getAction();
        m localm = a;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localm.a("Intent: " + paramIntent.toString());
      } while (!"android.intent.action.PACKAGE_ADDED".equals(localObject));
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
            break label214;
          }
          if (c != null) {
            c.a((g)d.get(paramIntent));
          }
          localObject = (Integer)a.b.get(paramIntent);
          if (localObject != null)
          {
            a.b.get(paramIntent);
            ((NotificationManager)paramContext.getSystemService("notification")).cancel(((Integer)localObject).intValue());
          }
          a(paramIntent);
        }
        catch (PackageManager.NameNotFoundException paramIntent)
        {
          paramContext = a;
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>();
          paramContext.e("系统无法找到包名对应App，请确认该包是否被安装 : " + "");
          a.a(paramIntent);
        }
        paramContext = paramContext;
        a.a(paramContext);
        continue;
        continue;
        label214:
        paramContext = a;
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        paramContext.e("该包名没有被注册，不进行report : " + paramIntent);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a(g paramg);
    
    public abstract void b(g paramg);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */