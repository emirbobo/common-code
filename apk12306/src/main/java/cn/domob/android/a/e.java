package cn.domob.android.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import cn.domob.android.offerwall.m;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;

public class e
{
  private static m a = new m(e.class.getSimpleName());
  private static final String b = "wifi";
  private static final String c = "ctwap";
  
  protected static String a(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      a.e(e.class.getSimpleName(), "Cannot access user's network type.  Permissions are not set.");
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        if (i == 0)
        {
          String str = paramContext.getSubtypeName();
          paramContext = str;
          if (str != null) {
            continue;
          }
          paramContext = "GPRS";
          continue;
        }
        if (i == 1)
        {
          paramContext = "wifi";
          continue;
        }
      }
      paramContext = "";
    }
  }
  
  protected static Proxy b(Context paramContext)
  {
    Object localObject1 = null;
    localObject5 = null;
    for (;;)
    {
      try
      {
        paramContext = c(paramContext);
        if (paramContext == null) {}
      }
      catch (Exception localException2)
      {
        Object localObject4;
        int i;
        String str;
        Object localObject6;
        Object localObject7;
        Object localObject2;
        paramContext = null;
        continue;
        Object localObject3 = null;
        continue;
      }
      try
      {
        if (paramContext.getCount() <= 0) {
          continue;
        }
        paramContext.moveToFirst();
        localObject4 = paramContext.getString(paramContext.getColumnIndexOrThrow("proxy"));
        i = paramContext.getInt(paramContext.getColumnIndexOrThrow("port"));
        str = paramContext.getString(paramContext.getColumnIndexOrThrow("apn"));
        localObject1 = a;
        localObject6 = e.class.getSimpleName();
        localObject7 = new java/lang/StringBuilder;
        ((StringBuilder)localObject7).<init>();
        ((m)localObject1).a(localObject6, "Proxy: " + (String)localObject4 + " port: " + i + " apnType: " + str);
        if ((localObject4 == null) || (((String)localObject4).equals("")) || (i == 0) || (str.equalsIgnoreCase("ctwap"))) {
          continue;
        }
        localObject7 = a;
        localObject6 = e.class.getSimpleName();
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        ((m)localObject7).a(localObject6, "download use proxy " + (String)localObject4 + " port:" + i);
        localObject1 = new java/net/Proxy;
        localObject7 = Proxy.Type.HTTP;
        localObject6 = new java/net/InetSocketAddress;
        ((InetSocketAddress)localObject6).<init>((String)localObject4, i);
        ((Proxy)localObject1).<init>((Proxy.Type)localObject7, (SocketAddress)localObject6);
      }
      catch (Exception localException1)
      {
        a.a(localException1);
        localObject2 = localObject5;
      }
    }
    localObject4 = localObject1;
    if (paramContext != null)
    {
      paramContext.close();
      localObject4 = localObject1;
    }
    for (;;)
    {
      return (Proxy)localObject4;
      localObject4 = localObject1;
      if (paramContext != null)
      {
        paramContext.close();
        localObject4 = localObject1;
      }
    }
  }
  
  private static Cursor c(Context paramContext)
  {
    Uri localUri = null;
    String str = a(paramContext);
    if ((str != null) && (str.equals("wifi"))) {
      a.a(e.class.getSimpleName(), "Download network is wifi, don't read apn.");
    }
    for (paramContext = localUri;; paramContext = paramContext.getContentResolver().query(localUri, null, null, null, null))
    {
      return paramContext;
      localUri = Uri.parse("content://telephony/carriers/preferapn");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */