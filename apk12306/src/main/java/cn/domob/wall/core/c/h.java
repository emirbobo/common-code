package cn.domob.wall.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.domob.wall.core.h.d;

public class h
{
  static h a;
  private static d b = new d(h.class.getSimpleName());
  private static final String c = "timestamp";
  private static final String d = "requestTimestamp";
  private static final String e = "cookieid";
  private static final String f = "ad_cookieid";
  
  static h a()
  {
    try
    {
      if (a == null)
      {
        localh = new cn/domob/wall/core/c/h;
        localh.<init>();
        a = localh;
      }
      h localh = a;
      return localh;
    }
    finally {}
  }
  
  long a(Context paramContext)
  {
    long l = paramContext.getSharedPreferences("timestamp", 0).getLong("requestTimestamp", 0L);
    b.b(String.format("Query  data from SharedPreferences  key=%s  value=%s", new Object[] { "requestTimestamp", Long.valueOf(l) }));
    return l;
  }
  
  void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("cookieid", 0).edit();
    paramContext.putString("ad_cookieid", paramString);
    paramContext.commit();
    b.b(String.format("The SharedPreferences stored data key = %s  cookieid = %s", new Object[] { "ad_cookieid", paramString }));
  }
  
  void b(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("timestamp", 0).edit();
    paramContext.putLong("requestTimestamp", System.currentTimeMillis() / 1000L);
    paramContext.commit();
    b.b(String.format("The SharedPreferences stored data key = %s  timestamp = %s", new Object[] { "requestTimestamp", Long.valueOf(System.currentTimeMillis()) }));
  }
  
  String c(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("cookieid", 0).getString("ad_cookieid", "");
    b.b(String.format("Query  data from SharedPreferences  key=%s  value=%s", new Object[] { "ad_cookieid", paramContext }));
    return paramContext;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */