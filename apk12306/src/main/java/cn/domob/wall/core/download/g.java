package cn.domob.wall.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import cn.domob.wall.core.h.d;

public class g
{
  private static d a = new d(g.class.getSimpleName());
  private static final String b = "wifi";
  private static final String c = "ctwap";
  
  protected static String a(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      a.e(g.class.getSimpleName(), "Cannot access user's network type.  Permissions are not set.");
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
  
  /* Error */
  protected static java.net.Proxy b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokestatic 80	cn/domob/wall/core/download/g:c	(Landroid/content/Context;)Landroid/database/Cursor;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnull +246 -> 257
    //   14: aload_0
    //   15: invokeinterface 85 1 0
    //   20: ifle +237 -> 257
    //   23: aload_0
    //   24: invokeinterface 89 1 0
    //   29: pop
    //   30: aload_0
    //   31: aload_0
    //   32: ldc 91
    //   34: invokeinterface 94 2 0
    //   39: invokeinterface 98 2 0
    //   44: astore_3
    //   45: aload_0
    //   46: aload_0
    //   47: ldc 100
    //   49: invokeinterface 94 2 0
    //   54: invokeinterface 104 2 0
    //   59: istore_1
    //   60: aload_0
    //   61: aload_0
    //   62: ldc 106
    //   64: invokeinterface 94 2 0
    //   69: invokeinterface 98 2 0
    //   74: astore_2
    //   75: getstatic 29	cn/domob/wall/core/download/g:a	Lcn/domob/wall/core/h/d;
    //   78: astore 7
    //   80: ldc 2
    //   82: invokevirtual 23	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   85: astore 6
    //   87: new 108	java/lang/StringBuilder
    //   90: astore 5
    //   92: aload 5
    //   94: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   97: aload 7
    //   99: aload 6
    //   101: aload 5
    //   103: ldc 111
    //   105: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_3
    //   109: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 117
    //   114: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: iload_1
    //   118: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   121: ldc 122
    //   123: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_2
    //   127: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 127	cn/domob/wall/core/h/d:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   136: aload_3
    //   137: ifnull +177 -> 314
    //   140: aload_3
    //   141: ldc 49
    //   143: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +168 -> 314
    //   149: iload_1
    //   150: ifeq +164 -> 314
    //   153: aload_2
    //   154: ldc 13
    //   156: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   159: ifne +155 -> 314
    //   162: getstatic 29	cn/domob/wall/core/download/g:a	Lcn/domob/wall/core/h/d;
    //   165: astore_2
    //   166: ldc 2
    //   168: invokevirtual 23	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   171: astore 5
    //   173: new 108	java/lang/StringBuilder
    //   176: astore 6
    //   178: aload 6
    //   180: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   183: aload_2
    //   184: aload 5
    //   186: aload 6
    //   188: ldc -117
    //   190: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_3
    //   194: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: ldc -115
    //   199: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload_1
    //   203: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokevirtual 127	cn/domob/wall/core/h/d:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   212: new 143	java/net/Proxy
    //   215: astore_2
    //   216: getstatic 149	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   219: astore 5
    //   221: new 151	java/net/InetSocketAddress
    //   224: astore 6
    //   226: aload 6
    //   228: aload_3
    //   229: iload_1
    //   230: invokespecial 154	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   233: aload_2
    //   234: aload 5
    //   236: aload 6
    //   238: invokespecial 157	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   241: aload_2
    //   242: astore_3
    //   243: aload_0
    //   244: ifnull +11 -> 255
    //   247: aload_0
    //   248: invokeinterface 160 1 0
    //   253: aload_2
    //   254: astore_3
    //   255: aload_3
    //   256: areturn
    //   257: aload_2
    //   258: astore_3
    //   259: aload_0
    //   260: ifnull -5 -> 255
    //   263: aload_0
    //   264: invokeinterface 160 1 0
    //   269: aload_2
    //   270: astore_3
    //   271: goto -16 -> 255
    //   274: astore_2
    //   275: getstatic 29	cn/domob/wall/core/download/g:a	Lcn/domob/wall/core/h/d;
    //   278: aload_2
    //   279: invokevirtual 163	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   282: aload 4
    //   284: astore_2
    //   285: goto -44 -> 241
    //   288: astore_2
    //   289: aconst_null
    //   290: astore_0
    //   291: getstatic 29	cn/domob/wall/core/download/g:a	Lcn/domob/wall/core/h/d;
    //   294: aload_2
    //   295: invokevirtual 163	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   298: aload 4
    //   300: astore_2
    //   301: goto -60 -> 241
    //   304: astore_2
    //   305: goto -14 -> 291
    //   308: astore_2
    //   309: aconst_null
    //   310: astore_0
    //   311: goto -36 -> 275
    //   314: aconst_null
    //   315: astore_2
    //   316: goto -75 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramContext	Context
    //   59	171	1	i	int
    //   1	269	2	localObject1	Object
    //   274	5	2	localException1	Exception
    //   284	1	2	localObject2	Object
    //   288	7	2	localError1	Error
    //   300	1	2	localObject3	Object
    //   304	1	2	localError2	Error
    //   308	1	2	localException2	Exception
    //   315	1	2	localObject4	Object
    //   44	227	3	localObject5	Object
    //   3	296	4	localObject6	Object
    //   90	145	5	localObject7	Object
    //   85	152	6	localObject8	Object
    //   78	20	7	locald	d
    // Exception table:
    //   from	to	target	type
    //   14	136	274	java/lang/Exception
    //   140	149	274	java/lang/Exception
    //   153	241	274	java/lang/Exception
    //   263	269	274	java/lang/Exception
    //   5	10	288	java/lang/Error
    //   14	136	304	java/lang/Error
    //   140	149	304	java/lang/Error
    //   153	241	304	java/lang/Error
    //   263	269	304	java/lang/Error
    //   5	10	308	java/lang/Exception
  }
  
  private static Cursor c(Context paramContext)
  {
    Uri localUri = null;
    String str = a(paramContext);
    if ((str != null) && (str.equals("wifi"))) {
      a.a(g.class.getSimpleName(), "Download network is wifi, don't read apn.");
    }
    for (paramContext = localUri;; paramContext = paramContext.getContentResolver().query(localUri, null, null, null, null))
    {
      return paramContext;
      localUri = Uri.parse("content://telephony/carriers/preferapn");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\download\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */