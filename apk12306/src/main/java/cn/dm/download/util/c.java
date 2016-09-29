package cn.dm.download.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import cn.dm.download.bean.DownloadAppInfo;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private static final String aB = "wifi";
  private static final String aC = "ctwap";
  private static b j = new b(c.class.getSimpleName());
  
  private static int a(long paramLong1, long paramLong2)
  {
    try
    {
      i = Integer.parseInt(String.valueOf(100L * paramLong1 / paramLong2));
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b localb = j;
        localException.getMessage();
        int i = 0;
      }
    }
  }
  
  public static int a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramContext == null) {
        break label43;
      }
      i = paramContext.versionCode;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramString = j;
        new StringBuilder("通过包名获取版本号出错:").append(paramContext.getMessage());
        label43:
        int i = -1;
      }
    }
    return i;
  }
  
  public static long a(String paramString, Context paramContext)
  {
    for (;;)
    {
      try
      {
        localURL = new java/net/URL;
        localURL.<init>(paramString);
        paramString = f(paramContext);
        if (paramString == null) {
          continue;
        }
        paramString = (HttpURLConnection)localURL.openConnection(paramString);
        paramString.setRequestMethod("HEAD");
        i = paramString.getResponseCode();
        if ((i >= 200) && (i < 300)) {
          continue;
        }
        l = Constants.DownloadUrlWrong;
      }
      catch (Exception paramContext)
      {
        URL localURL;
        int i;
        paramString = j;
        paramContext.getMessage();
        long l = Constants.DownloadUrlWrong;
        continue;
      }
      return l;
      paramString = (HttpURLConnection)localURL.openConnection();
      continue;
      i = paramString.getContentLength();
      l = i;
    }
  }
  
  public static String a(Context paramContext, DownloadAppInfo paramDownloadAppInfo)
  {
    return g(paramContext) + paramDownloadAppInfo.getPkgName() + ".apk";
  }
  
  private static String d(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
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
  
  private static Cursor e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
          continue;
        }
        localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (localObject == null) {
          continue;
        }
        i = ((NetworkInfo)localObject).getType();
        if (i != 0) {
          continue;
        }
        localObject = ((NetworkInfo)localObject).getSubtypeName();
        if (localObject == null) {
          continue;
        }
        if ((localObject == null) || (!((String)localObject).equals("wifi"))) {
          continue;
        }
        paramContext = null;
      }
      catch (Exception paramContext)
      {
        int i;
        Object localObject = j;
        paramContext.getMessage();
        paramContext = null;
        continue;
      }
      return paramContext;
      localObject = "GPRS";
      continue;
      if (i == 1)
      {
        localObject = "wifi";
      }
      else
      {
        localObject = "";
        continue;
        localObject = Uri.parse("content://telephony/carriers/preferapn");
        paramContext = paramContext.getContentResolver().query((Uri)localObject, null, null, null, null);
      }
    }
  }
  
  /* Error */
  public static java.net.Proxy f(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: invokestatic 191	cn/dm/download/util/c:e	(Landroid/content/Context;)Landroid/database/Cursor;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnull +164 -> 175
    //   14: aload_0
    //   15: invokeinterface 196 1 0
    //   20: ifle +155 -> 175
    //   23: aload_0
    //   24: invokeinterface 200 1 0
    //   29: pop
    //   30: aload_0
    //   31: aload_0
    //   32: ldc -54
    //   34: invokeinterface 205 2 0
    //   39: invokeinterface 209 2 0
    //   44: astore 4
    //   46: aload_0
    //   47: aload_0
    //   48: ldc -45
    //   50: invokeinterface 205 2 0
    //   55: invokeinterface 215 2 0
    //   60: istore_1
    //   61: aload_0
    //   62: aload_0
    //   63: ldc -39
    //   65: invokeinterface 205 2 0
    //   70: invokeinterface 209 2 0
    //   75: astore 6
    //   77: aload 5
    //   79: astore_2
    //   80: aload_0
    //   81: astore_3
    //   82: aload 4
    //   84: ifnull +72 -> 156
    //   87: aload 5
    //   89: astore_2
    //   90: aload_0
    //   91: astore_3
    //   92: aload 4
    //   94: ldc -115
    //   96: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifne +57 -> 156
    //   102: aload 5
    //   104: astore_2
    //   105: aload_0
    //   106: astore_3
    //   107: iload_1
    //   108: ifeq +48 -> 156
    //   111: aload 5
    //   113: astore_2
    //   114: aload_0
    //   115: astore_3
    //   116: aload 6
    //   118: ldc 11
    //   120: invokevirtual 221	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   123: ifne +33 -> 156
    //   126: new 223	java/net/Proxy
    //   129: astore_2
    //   130: getstatic 229	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   133: astore_3
    //   134: new 231	java/net/InetSocketAddress
    //   137: astore 6
    //   139: aload 6
    //   141: aload 4
    //   143: iload_1
    //   144: invokespecial 234	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   147: aload_2
    //   148: aload_3
    //   149: aload 6
    //   151: invokespecial 237	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   154: aload_0
    //   155: astore_3
    //   156: aload_2
    //   157: astore 4
    //   159: aload_3
    //   160: ifnull +12 -> 172
    //   163: aload_3
    //   164: invokeinterface 240 1 0
    //   169: aload_2
    //   170: astore 4
    //   172: aload 4
    //   174: areturn
    //   175: aload_2
    //   176: astore 4
    //   178: aload_0
    //   179: ifnull -7 -> 172
    //   182: aload_0
    //   183: invokeinterface 240 1 0
    //   188: aload_2
    //   189: astore 4
    //   191: goto -19 -> 172
    //   194: astore_2
    //   195: getstatic 29	cn/dm/download/util/c:j	Lcn/dm/download/util/b;
    //   198: astore_3
    //   199: aload_2
    //   200: invokevirtual 53	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   203: pop
    //   204: aload 5
    //   206: astore_2
    //   207: aload_0
    //   208: astore_3
    //   209: goto -53 -> 156
    //   212: astore_2
    //   213: aconst_null
    //   214: astore_0
    //   215: getstatic 29	cn/dm/download/util/c:j	Lcn/dm/download/util/b;
    //   218: astore_3
    //   219: aload_2
    //   220: invokevirtual 241	java/lang/Error:getMessage	()Ljava/lang/String;
    //   223: pop
    //   224: aload 5
    //   226: astore_2
    //   227: aload_0
    //   228: astore_3
    //   229: goto -73 -> 156
    //   232: astore_2
    //   233: goto -18 -> 215
    //   236: astore_2
    //   237: aconst_null
    //   238: astore_0
    //   239: goto -44 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	paramContext	Context
    //   60	84	1	i	int
    //   1	188	2	localObject1	Object
    //   194	6	2	localException1	Exception
    //   206	1	2	localObject2	Object
    //   212	8	2	localError1	Error
    //   226	1	2	localObject3	Object
    //   232	1	2	localError2	Error
    //   236	1	2	localException2	Exception
    //   81	148	3	localObject4	Object
    //   44	146	4	localObject5	Object
    //   3	222	5	localObject6	Object
    //   75	75	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   14	77	194	java/lang/Exception
    //   92	102	194	java/lang/Exception
    //   116	154	194	java/lang/Exception
    //   182	188	194	java/lang/Exception
    //   5	10	212	java/lang/Error
    //   14	77	232	java/lang/Error
    //   92	102	232	java/lang/Error
    //   116	154	232	java/lang/Error
    //   182	188	232	java/lang/Error
    //   5	10	236	java/lang/Exception
  }
  
  public static String g(Context paramContext)
  {
    if (s()) {}
    for (paramContext = Environment.getExternalStorageDirectory() + File.separator + Constants.DefaultStorageFile + File.separator;; paramContext = paramContext.getFilesDir().getAbsolutePath() + File.separator + Constants.DefaultStorageFile + File.separator) {
      return paramContext;
    }
  }
  
  public static ArrayList h(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = localPackageManager.getInstalledPackages(0);
    paramContext = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return paramContext;
      }
      PackageInfo localPackageInfo = (PackageInfo)localIterator.next();
      if ((localPackageInfo.applicationInfo.flags & 0x1) == 0)
      {
        localObject = new DownloadAppInfo();
        ((DownloadAppInfo)localObject).setAppName(localPackageInfo.applicationInfo.loadLabel(localPackageManager).toString());
        ((DownloadAppInfo)localObject).setPkgName(localPackageInfo.packageName);
        ((DownloadAppInfo)localObject).setVersionCode(localPackageInfo.versionCode);
        ((DownloadAppInfo)localObject).setVersionName(localPackageInfo.versionName);
        paramContext.add(localObject);
      }
    }
  }
  
  public static long q(String paramString)
  {
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramString);
      Object localObject = j;
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("本地文件路径：");
      ((StringBuilder)localObject).append(paramString).append("  ，本地文件是否存在？").append(localFile.exists());
      l = localFile.length();
      return l;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramString = j;
        localException.getMessage();
        long l = 0L;
      }
    }
  }
  
  public static boolean r(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public static boolean s()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  public static boolean s(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {}
    for (boolean bool = paramString.delete();; bool = false) {
      return bool;
    }
  }
  
  public static boolean t(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (boolean bool = paramString.mkdirs();; bool = true) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dm\download\util\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */