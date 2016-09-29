package cn.domob.android.c;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import cn.domob.android.i.f;

public class d
{
  private static f a = new f(d.class.getSimpleName());
  private static final String b = "wifi";
  private static final String c = "ctwap";
  
  protected static String a(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1)
    {
      a.e(d.class.getSimpleName(), "Cannot access user's network type.  Permissions are not set.");
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
    //   6: invokestatic 80	cn/domob/android/c/d:c	(Landroid/content/Context;)Landroid/database/Cursor;
    //   9: astore_0
    //   10: aload_0
    //   11: ifnull +247 -> 258
    //   14: aload_0
    //   15: invokeinterface 85 1 0
    //   20: ifle +238 -> 258
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
    //   74: astore 5
    //   76: getstatic 29	cn/domob/android/c/d:a	Lcn/domob/android/i/f;
    //   79: astore 7
    //   81: ldc 2
    //   83: invokevirtual 23	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   86: astore_2
    //   87: new 108	java/lang/StringBuilder
    //   90: astore 6
    //   92: aload 6
    //   94: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   97: aload 7
    //   99: aload_2
    //   100: aload 6
    //   102: ldc 111
    //   104: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_3
    //   108: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 117
    //   113: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: iload_1
    //   117: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc 122
    //   122: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokevirtual 127	cn/domob/android/i/f:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   136: aload_3
    //   137: ifnull +178 -> 315
    //   140: aload_3
    //   141: ldc 49
    //   143: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +169 -> 315
    //   149: iload_1
    //   150: ifeq +165 -> 315
    //   153: aload 5
    //   155: ldc 13
    //   157: invokevirtual 137	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: ifne +155 -> 315
    //   163: getstatic 29	cn/domob/android/c/d:a	Lcn/domob/android/i/f;
    //   166: astore 5
    //   168: ldc 2
    //   170: invokevirtual 23	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   173: astore_2
    //   174: new 108	java/lang/StringBuilder
    //   177: astore 6
    //   179: aload 6
    //   181: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   184: aload 5
    //   186: aload_2
    //   187: aload 6
    //   189: ldc -117
    //   191: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_3
    //   195: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc -115
    //   200: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: iload_1
    //   204: invokevirtual 120	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   207: invokevirtual 125	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 127	cn/domob/android/i/f:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   213: new 143	java/net/Proxy
    //   216: astore_2
    //   217: getstatic 149	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   220: astore 6
    //   222: new 151	java/net/InetSocketAddress
    //   225: astore 5
    //   227: aload 5
    //   229: aload_3
    //   230: iload_1
    //   231: invokespecial 154	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   234: aload_2
    //   235: aload 6
    //   237: aload 5
    //   239: invokespecial 157	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   242: aload_2
    //   243: astore_3
    //   244: aload_0
    //   245: ifnull +11 -> 256
    //   248: aload_0
    //   249: invokeinterface 160 1 0
    //   254: aload_2
    //   255: astore_3
    //   256: aload_3
    //   257: areturn
    //   258: aload_2
    //   259: astore_3
    //   260: aload_0
    //   261: ifnull -5 -> 256
    //   264: aload_0
    //   265: invokeinterface 160 1 0
    //   270: aload_2
    //   271: astore_3
    //   272: goto -16 -> 256
    //   275: astore_2
    //   276: getstatic 29	cn/domob/android/c/d:a	Lcn/domob/android/i/f;
    //   279: aload_2
    //   280: invokevirtual 163	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   283: aload 4
    //   285: astore_2
    //   286: goto -44 -> 242
    //   289: astore_2
    //   290: aconst_null
    //   291: astore_0
    //   292: getstatic 29	cn/domob/android/c/d:a	Lcn/domob/android/i/f;
    //   295: aload_2
    //   296: invokevirtual 163	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   299: aload 4
    //   301: astore_2
    //   302: goto -60 -> 242
    //   305: astore_2
    //   306: goto -14 -> 292
    //   309: astore_2
    //   310: aconst_null
    //   311: astore_0
    //   312: goto -36 -> 276
    //   315: aconst_null
    //   316: astore_2
    //   317: goto -75 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   59	172	1	i	int
    //   1	270	2	localObject1	Object
    //   275	5	2	localException1	Exception
    //   285	1	2	localObject2	Object
    //   289	7	2	localError1	Error
    //   301	1	2	localObject3	Object
    //   305	1	2	localError2	Error
    //   309	1	2	localException2	Exception
    //   316	1	2	localObject4	Object
    //   44	228	3	localObject5	Object
    //   3	297	4	localObject6	Object
    //   74	164	5	localObject7	Object
    //   90	146	6	localObject8	Object
    //   79	19	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   14	136	275	java/lang/Exception
    //   140	149	275	java/lang/Exception
    //   153	242	275	java/lang/Exception
    //   264	270	275	java/lang/Exception
    //   5	10	289	java/lang/Error
    //   14	136	305	java/lang/Error
    //   140	149	305	java/lang/Error
    //   153	242	305	java/lang/Error
    //   264	270	305	java/lang/Error
    //   5	10	309	java/lang/Exception
  }
  
  private static Cursor c(Context paramContext)
  {
    Uri localUri = null;
    String str = a(paramContext);
    if ((str != null) && (str.equals("wifi"))) {
      a.a(d.class.getSimpleName(), "Download network is wifi, don't read apn.");
    }
    for (paramContext = localUri;; paramContext = paramContext.getContentResolver().query(localUri, null, null, null, null))
    {
      return paramContext;
      localUri = Uri.parse("content://telephony/carriers/preferapn");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */