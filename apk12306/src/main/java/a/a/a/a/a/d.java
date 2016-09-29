package a.a.a.a.a;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;

class d
{
  private static d b = null;
  private static a.a c;
  private static a.b d;
  private static final String g = "/DCacheDownload/";
  private static String h = null;
  private static boolean i = false;
  private cn.domob.android.i.f a = new cn.domob.android.i.f(d.class.getSimpleName());
  private b e = new b();
  private String f = null;
  
  private String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (;;)
    {
      try
      {
        paramString = Uri.parse(paramString).getLastPathSegment();
        if ((paramString != null) && (paramString.contains(".")))
        {
          paramString = paramString.substring(paramString.lastIndexOf("."));
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        this.a.a(paramString);
      }
      paramString = null;
    }
  }
  
  protected static void a(Context paramContext, a.a parama)
  {
    if (c == null) {
      c = parama;
    }
    if (f.a().e(paramContext)) {
      d();
    }
    f.a().f(paramContext);
    b().f(paramContext);
    b().d(paramContext);
  }
  
  protected static d b()
  {
    try
    {
      if (b == null)
      {
        locald = new a/a/a/a/a/d;
        locald.<init>();
        b = locald;
      }
      d locald = b;
      return locald;
    }
    finally {}
  }
  
  protected static a.b c()
  {
    return d;
  }
  
  protected static void d()
  {
    if (c != null) {
      c.a();
    }
  }
  
  private boolean g(Context paramContext)
  {
    boolean bool;
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == -1) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.getType() == 1)) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  protected String a(Context paramContext)
  {
    if (a()) {}
    for (paramContext = Environment.getExternalStorageDirectory() + b(paramContext);; paramContext = null) {
      return paramContext;
    }
  }
  
  protected void a(a.b paramb)
  {
    if (d == null) {
      d = paramb;
    }
  }
  
  protected void a(Context paramContext, Object paramObject, int paramInt)
  {
    if ((d != null) && (paramObject != null)) {}
    try
    {
      paramObject = (a)paramObject;
      if (paramObject != null)
      {
        String str1 = ((a)paramObject).a();
        String str2 = ((a)paramObject).b();
        this.a.d(String.format("download failed errorCode: %d, groupID: %s, resourceID: %s", new Object[] { Integer.valueOf(paramInt), str1, str2 }));
        paramContext = b(paramContext, ((a)paramObject).a());
        paramContext = new e(str1, str2, paramContext[0], paramContext[1], paramContext[2]);
        if (paramContext.a())
        {
          if (paramInt != 3) {
            break label131;
          }
          d.f(paramContext);
        }
      }
      return;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        this.a.a((Throwable)paramObject);
        paramObject = null;
        continue;
        label131:
        if (paramInt == 2) {
          d.e(paramContext);
        } else if (paramInt == 1) {
          d.d(paramContext);
        } else if (paramInt == 4) {
          d.c(paramContext);
        }
      }
    }
  }
  
  protected void a(Context paramContext, Object paramObject, String paramString, long paramLong, boolean paramBoolean)
  {
    Object localObject1 = (a)paramObject;
    paramObject = ((a)localObject1).a();
    localObject1 = ((a)localObject1).b();
    this.a.a(String.format("download successfully groupid:%s  resourceID:%s  localPath:%s  fileSize: %d", new Object[] { paramObject, localObject1, paramString, Long.valueOf(paramLong) }));
    Object localObject2 = new ContentValues();
    ((ContentValues)localObject2).put("Path", paramString);
    ((ContentValues)localObject2).put("ContentLength", Long.valueOf(paramLong));
    int j = b.a(paramContext).a("resource", (ContentValues)localObject2, "Rgid = ? and Ridd = ?", new String[] { paramObject, localObject1 });
    if (j == 1)
    {
      this.a.b("update BD successfully");
      boolean bool = f.a().a(paramContext, (String)paramObject);
      if (bool) {
        f.a().c(paramContext);
      }
      if ((!paramBoolean) || (d == null) || ((!bool) && (!f.a().a(paramString, paramLong)))) {
        break label336;
      }
      localObject2 = b(paramContext, (String)paramObject);
      paramString = new e((String)paramObject, (String)localObject1, localObject2[0], localObject2[1], localObject2[2]);
      if (a((String[])localObject2))
      {
        this.a.b(String.format("send resource download success report the groupID is %s and resourceID is %s", new Object[] { paramObject, localObject1 }));
        d.a(paramString);
        if (bool)
        {
          this.a.b(String.format("send group download success report the groupID is %s", new Object[] { paramObject }));
          paramString.b = null;
          d.b(paramString);
        }
      }
    }
    for (;;)
    {
      if (!c(paramContext)) {
        d();
      }
      return;
      this.a.e("update DB failed and the affected row number is " + j);
      break;
      label336:
      this.a.d("does not meet the conditions of sending download successfully report");
    }
  }
  
  /* Error */
  protected void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 279	a/a/a/a/a/d:c	(Landroid/content/Context;)Z
    //   5: ifne +7 -> 12
    //   8: invokestatic 109	a/a/a/a/a/d:d	()V
    //   11: return
    //   12: new 291	java/lang/StringBuffer
    //   15: dup
    //   16: invokespecial 292	java/lang/StringBuffer:<init>	()V
    //   19: astore 4
    //   21: aload 4
    //   23: ldc_w 294
    //   26: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   29: pop
    //   30: aload 4
    //   32: ldc_w 299
    //   35: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   38: pop
    //   39: aload 4
    //   41: ldc -25
    //   43: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   46: pop
    //   47: aload 4
    //   49: ldc_w 301
    //   52: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   55: pop
    //   56: aload 4
    //   58: invokevirtual 302	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   61: astore 4
    //   63: aload_1
    //   64: invokestatic 245	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   67: ldc -9
    //   69: iconst_2
    //   70: anewarray 66	java/lang/String
    //   73: dup
    //   74: iconst_0
    //   75: ldc_w 304
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: ldc_w 306
    //   84: aastore
    //   85: aload 4
    //   87: iconst_2
    //   88: anewarray 66	java/lang/String
    //   91: dup
    //   92: iconst_0
    //   93: aload_2
    //   94: aastore
    //   95: dup
    //   96: iconst_1
    //   97: ldc_w 308
    //   100: aastore
    //   101: ldc_w 310
    //   104: aconst_null
    //   105: invokevirtual 313	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore 5
    //   110: aload 5
    //   112: ifnull +440 -> 552
    //   115: aload 5
    //   117: astore 4
    //   119: aload 5
    //   121: invokeinterface 318 1 0
    //   126: pop
    //   127: aload 5
    //   129: astore 4
    //   131: aload_0
    //   132: getfield 53	a/a/a/a/a/d:a	Lcn/domob/android/i/f;
    //   135: ldc_w 320
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload 5
    //   146: invokeinterface 323 1 0
    //   151: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: aastore
    //   155: invokestatic 194	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   158: invokevirtual 256	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   161: iconst_0
    //   162: istore_3
    //   163: aload 5
    //   165: astore 4
    //   167: iload_3
    //   168: aload 5
    //   170: invokeinterface 323 1 0
    //   175: if_icmpge +377 -> 552
    //   178: aload 5
    //   180: astore 4
    //   182: aload_0
    //   183: aload_1
    //   184: invokevirtual 325	a/a/a/a/a/d:e	(Landroid/content/Context;)Ljava/lang/String;
    //   187: astore 6
    //   189: aload 6
    //   191: ifnull +15 -> 206
    //   194: aload 5
    //   196: astore 4
    //   198: aload 6
    //   200: invokevirtual 70	java/lang/String:length	()I
    //   203: ifne +9 -> 212
    //   206: iinc 3 1
    //   209: goto -46 -> 163
    //   212: aload 5
    //   214: astore 4
    //   216: aload 5
    //   218: aload 5
    //   220: ldc_w 304
    //   223: invokeinterface 328 2 0
    //   228: invokeinterface 331 2 0
    //   233: astore 8
    //   235: aload 5
    //   237: astore 4
    //   239: aload 5
    //   241: aload 5
    //   243: ldc_w 306
    //   246: invokeinterface 328 2 0
    //   251: invokeinterface 331 2 0
    //   256: astore 9
    //   258: aload 5
    //   260: astore 4
    //   262: aload_0
    //   263: aload 9
    //   265: invokespecial 333	a/a/a/a/a/d:a	(Ljava/lang/String;)Ljava/lang/String;
    //   268: astore 7
    //   270: aload 7
    //   272: astore 6
    //   274: aload 7
    //   276: ifnonnull +8 -> 284
    //   279: ldc_w 335
    //   282: astore 6
    //   284: aload 5
    //   286: astore 4
    //   288: aload_0
    //   289: getfield 53	a/a/a/a/a/d:a	Lcn/domob/android/i/f;
    //   292: astore 7
    //   294: aload 5
    //   296: astore 4
    //   298: new 157	java/lang/StringBuilder
    //   301: astore 10
    //   303: aload 5
    //   305: astore 4
    //   307: aload 10
    //   309: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   312: aload 5
    //   314: astore 4
    //   316: aload 7
    //   318: aload 10
    //   320: ldc_w 337
    //   323: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 6
    //   328: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokevirtual 256	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   337: aload 5
    //   339: astore 4
    //   341: new 157	java/lang/StringBuilder
    //   344: astore 7
    //   346: aload 5
    //   348: astore 4
    //   350: aload 7
    //   352: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   355: aload 5
    //   357: astore 4
    //   359: aload 7
    //   361: aload_0
    //   362: aload_1
    //   363: invokevirtual 170	a/a/a/a/a/d:b	(Landroid/content/Context;)Ljava/lang/String;
    //   366: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: ldc_w 339
    //   372: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_2
    //   376: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc_w 339
    //   382: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload 8
    //   387: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload 6
    //   392: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: invokevirtual 176	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: astore 6
    //   400: aload 5
    //   402: astore 4
    //   404: getstatic 99	a/a/a/a/a/d:c	La/a/a/a/a/a$a;
    //   407: ifnull +92 -> 499
    //   410: aload 5
    //   412: astore 4
    //   414: aload_0
    //   415: getfield 53	a/a/a/a/a/d:a	Lcn/domob/android/i/f;
    //   418: ldc_w 341
    //   421: iconst_4
    //   422: anewarray 4	java/lang/Object
    //   425: dup
    //   426: iconst_0
    //   427: aload_2
    //   428: aastore
    //   429: dup
    //   430: iconst_1
    //   431: aload 8
    //   433: aastore
    //   434: dup
    //   435: iconst_2
    //   436: aload 9
    //   438: aastore
    //   439: dup
    //   440: iconst_3
    //   441: aload 6
    //   443: aastore
    //   444: invokestatic 194	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   447: invokevirtual 226	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   450: aload 5
    //   452: astore 4
    //   454: getstatic 99	a/a/a/a/a/d:c	La/a/a/a/a/a$a;
    //   457: astore 7
    //   459: aload 5
    //   461: astore 4
    //   463: new 8	a/a/a/a/a/d$a
    //   466: astore 10
    //   468: aload 5
    //   470: astore 4
    //   472: aload 10
    //   474: aload_0
    //   475: aload_2
    //   476: aload 8
    //   478: invokespecial 344	a/a/a/a/a/d$a:<init>	(La/a/a/a/a/d;Ljava/lang/String;Ljava/lang/String;)V
    //   481: aload 5
    //   483: astore 4
    //   485: aload 7
    //   487: aload_1
    //   488: aload 10
    //   490: aload 9
    //   492: aload 6
    //   494: invokeinterface 347 5 0
    //   499: aload 5
    //   501: astore 4
    //   503: aload 5
    //   505: invokeinterface 350 1 0
    //   510: pop
    //   511: goto -305 -> 206
    //   514: astore_1
    //   515: aload 5
    //   517: astore 4
    //   519: aload_0
    //   520: getfield 53	a/a/a/a/a/d:a	Lcn/domob/android/i/f;
    //   523: aload_1
    //   524: invokevirtual 96	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   527: aload 5
    //   529: ifnull -518 -> 11
    //   532: aload 5
    //   534: invokeinterface 353 1 0
    //   539: ifne -528 -> 11
    //   542: aload 5
    //   544: invokeinterface 356 1 0
    //   549: goto -538 -> 11
    //   552: aload 5
    //   554: ifnull -543 -> 11
    //   557: aload 5
    //   559: invokeinterface 353 1 0
    //   564: ifne -553 -> 11
    //   567: aload 5
    //   569: invokeinterface 356 1 0
    //   574: goto -563 -> 11
    //   577: astore_1
    //   578: aconst_null
    //   579: astore 4
    //   581: aload 4
    //   583: ifnull +20 -> 603
    //   586: aload 4
    //   588: invokeinterface 353 1 0
    //   593: ifne +10 -> 603
    //   596: aload 4
    //   598: invokeinterface 356 1 0
    //   603: aload_1
    //   604: athrow
    //   605: astore_1
    //   606: goto -25 -> 581
    //   609: astore_1
    //   610: aconst_null
    //   611: astore 5
    //   613: goto -98 -> 515
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	this	d
    //   0	616	1	paramContext	Context
    //   0	616	2	paramString	String
    //   162	45	3	j	int
    //   19	578	4	localObject1	Object
    //   108	504	5	localCursor	android.database.Cursor
    //   187	306	6	localObject2	Object
    //   268	218	7	localObject3	Object
    //   233	244	8	str1	String
    //   256	235	9	str2	String
    //   301	188	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   119	127	514	java/lang/Exception
    //   131	161	514	java/lang/Exception
    //   167	178	514	java/lang/Exception
    //   182	189	514	java/lang/Exception
    //   198	206	514	java/lang/Exception
    //   216	235	514	java/lang/Exception
    //   239	258	514	java/lang/Exception
    //   262	270	514	java/lang/Exception
    //   288	294	514	java/lang/Exception
    //   298	303	514	java/lang/Exception
    //   307	312	514	java/lang/Exception
    //   316	337	514	java/lang/Exception
    //   341	346	514	java/lang/Exception
    //   350	355	514	java/lang/Exception
    //   359	400	514	java/lang/Exception
    //   404	410	514	java/lang/Exception
    //   414	450	514	java/lang/Exception
    //   454	459	514	java/lang/Exception
    //   463	468	514	java/lang/Exception
    //   472	481	514	java/lang/Exception
    //   485	499	514	java/lang/Exception
    //   503	511	514	java/lang/Exception
    //   63	110	577	finally
    //   119	127	605	finally
    //   131	161	605	finally
    //   167	178	605	finally
    //   182	189	605	finally
    //   198	206	605	finally
    //   216	235	605	finally
    //   239	258	605	finally
    //   262	270	605	finally
    //   288	294	605	finally
    //   298	303	605	finally
    //   307	312	605	finally
    //   316	337	605	finally
    //   341	346	605	finally
    //   350	355	605	finally
    //   359	400	605	finally
    //   404	410	605	finally
    //   414	450	605	finally
    //   454	459	605	finally
    //   463	468	605	finally
    //   472	481	605	finally
    //   485	499	605	finally
    //   503	511	605	finally
    //   519	527	605	finally
    //   63	110	609	java/lang/Exception
  }
  
  protected boolean a()
  {
    return Environment.getExternalStorageState().equals("mounted");
  }
  
  boolean a(String[] paramArrayOfString)
  {
    boolean bool = false;
    int j = 0;
    while (j < paramArrayOfString.length) {
      if ((paramArrayOfString[j] != null) && (paramArrayOfString[j].length() > 0)) {
        j++;
      } else {
        this.a.d("the download report info can not meet the sending condition, so quit send report " + j);
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
    }
  }
  
  protected String b(Context paramContext)
  {
    if ((h == null) || (h.length() == 0)) {
      h = "/DCacheDownload/" + e(paramContext);
    }
    return h;
  }
  
  /* Error */
  String[] b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: iconst_3
    //   1: anewarray 66	java/lang/String
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 245	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   10: ldc_w 369
    //   13: iconst_3
    //   14: anewarray 66	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc_w 371
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: ldc_w 373
    //   28: aastore
    //   29: dup
    //   30: iconst_2
    //   31: ldc_w 375
    //   34: aastore
    //   35: ldc_w 377
    //   38: iconst_1
    //   39: anewarray 66	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_2
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: invokevirtual 313	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +87 -> 140
    //   56: aload_2
    //   57: astore_1
    //   58: aload_2
    //   59: invokeinterface 318 1 0
    //   64: ifeq +76 -> 140
    //   67: aload_2
    //   68: astore_1
    //   69: aload_2
    //   70: aload_2
    //   71: ldc_w 371
    //   74: invokeinterface 328 2 0
    //   79: invokeinterface 331 2 0
    //   84: astore 5
    //   86: aload_2
    //   87: astore_1
    //   88: aload_2
    //   89: aload_2
    //   90: ldc_w 373
    //   93: invokeinterface 328 2 0
    //   98: invokeinterface 331 2 0
    //   103: astore 6
    //   105: aload_2
    //   106: astore_1
    //   107: aload_2
    //   108: aload_2
    //   109: ldc_w 375
    //   112: invokeinterface 328 2 0
    //   117: invokeinterface 331 2 0
    //   122: astore_3
    //   123: aload 4
    //   125: iconst_0
    //   126: aload 5
    //   128: aastore
    //   129: aload 4
    //   131: iconst_1
    //   132: aload 6
    //   134: aastore
    //   135: aload 4
    //   137: iconst_2
    //   138: aload_3
    //   139: aastore
    //   140: aload_2
    //   141: ifnull +18 -> 159
    //   144: aload_2
    //   145: invokeinterface 353 1 0
    //   150: ifne +9 -> 159
    //   153: aload_2
    //   154: invokeinterface 356 1 0
    //   159: aload 4
    //   161: areturn
    //   162: astore_3
    //   163: aconst_null
    //   164: astore_2
    //   165: aload_2
    //   166: astore_1
    //   167: aload_0
    //   168: getfield 53	a/a/a/a/a/d:a	Lcn/domob/android/i/f;
    //   171: aload_3
    //   172: invokevirtual 96	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   175: aload_2
    //   176: ifnull -17 -> 159
    //   179: aload_2
    //   180: invokeinterface 353 1 0
    //   185: ifne -26 -> 159
    //   188: aload_2
    //   189: invokeinterface 356 1 0
    //   194: goto -35 -> 159
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +18 -> 219
    //   204: aload_1
    //   205: invokeinterface 353 1 0
    //   210: ifne +9 -> 219
    //   213: aload_1
    //   214: invokeinterface 356 1 0
    //   219: aload_2
    //   220: athrow
    //   221: astore_2
    //   222: goto -22 -> 200
    //   225: astore_3
    //   226: goto -61 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	d
    //   0	229	1	paramContext	Context
    //   0	229	2	paramString	String
    //   122	17	3	str1	String
    //   162	10	3	localException1	Exception
    //   225	1	3	localException2	Exception
    //   4	156	4	arrayOfString	String[]
    //   84	43	5	str2	String
    //   103	30	6	str3	String
    // Exception table:
    //   from	to	target	type
    //   6	52	162	java/lang/Exception
    //   6	52	197	finally
    //   58	67	221	finally
    //   69	86	221	finally
    //   88	105	221	finally
    //   107	123	221	finally
    //   167	175	221	finally
    //   58	67	225	java/lang/Exception
    //   69	86	225	java/lang/Exception
    //   88	105	225	java/lang/Exception
    //   107	123	225	java/lang/Exception
  }
  
  protected boolean c(Context paramContext)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!i)
    {
      bool1 = bool2;
      if (!f(paramContext)) {
        bool1 = false;
      }
    }
    if ((!f.a().a(paramContext)) || (c == null) || (!g(paramContext))) {
      bool1 = false;
    }
    if (bool1) {
      this.a.b("can meet condition to download resource");
    }
    for (;;)
    {
      return bool1;
      this.a.b("can not meet condition to download resource");
    }
  }
  
  /* Error */
  protected void d(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	a/a/a/a/a/d:a	Lcn/domob/android/i/f;
    //   4: ldc_w 387
    //   7: invokevirtual 256	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   10: aload_0
    //   11: aload_1
    //   12: invokevirtual 279	a/a/a/a/a/d:c	(Landroid/content/Context;)Z
    //   15: ifne +7 -> 22
    //   18: invokestatic 109	a/a/a/a/a/d:d	()V
    //   21: return
    //   22: new 291	java/lang/StringBuffer
    //   25: dup
    //   26: invokespecial 292	java/lang/StringBuffer:<init>	()V
    //   29: astore 6
    //   31: aload 6
    //   33: ldc_w 389
    //   36: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   39: pop
    //   40: aload 6
    //   42: ldc_w 391
    //   45: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   48: pop
    //   49: aload 6
    //   51: ldc_w 389
    //   54: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: pop
    //   58: aload 6
    //   60: ldc_w 393
    //   63: invokevirtual 297	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   66: pop
    //   67: aload 6
    //   69: lconst_0
    //   70: invokevirtual 396	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   73: pop
    //   74: invokestatic 402	java/lang/System:currentTimeMillis	()J
    //   77: lstore_3
    //   78: aload_1
    //   79: invokestatic 245	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   82: astore 5
    //   84: aload 6
    //   86: invokevirtual 302	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   89: astore 6
    //   91: aload 5
    //   93: ldc_w 369
    //   96: iconst_2
    //   97: anewarray 66	java/lang/String
    //   100: dup
    //   101: iconst_0
    //   102: ldc_w 294
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: ldc_w 404
    //   111: aastore
    //   112: aload 6
    //   114: iconst_1
    //   115: anewarray 66	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: lload_3
    //   121: invokestatic 407	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   124: aastore
    //   125: ldc_w 310
    //   128: aconst_null
    //   129: invokevirtual 313	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   132: astore 6
    //   134: aload 6
    //   136: ifnull +116 -> 252
    //   139: aload 6
    //   141: astore 5
    //   143: aload 6
    //   145: invokeinterface 318 1 0
    //   150: ifeq +102 -> 252
    //   153: iconst_0
    //   154: istore_2
    //   155: aload 6
    //   157: astore 5
    //   159: iload_2
    //   160: aload 6
    //   162: invokeinterface 323 1 0
    //   167: if_icmpge +85 -> 252
    //   170: aload 6
    //   172: astore 5
    //   174: iload_2
    //   175: invokestatic 104	a/a/a/a/a/f:a	()La/a/a/a/a/f;
    //   178: invokevirtual 409	a/a/a/a/a/f:b	()I
    //   181: if_icmpge +65 -> 246
    //   184: aload 6
    //   186: astore 5
    //   188: aload 6
    //   190: aload 6
    //   192: ldc_w 404
    //   195: invokeinterface 328 2 0
    //   200: invokeinterface 413 2 0
    //   205: ifne +29 -> 234
    //   208: aload 6
    //   210: astore 5
    //   212: aload_0
    //   213: aload_1
    //   214: aload 6
    //   216: aload 6
    //   218: ldc_w 294
    //   221: invokeinterface 328 2 0
    //   226: invokeinterface 331 2 0
    //   231: invokevirtual 415	a/a/a/a/a/d:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   234: aload 6
    //   236: astore 5
    //   238: aload 6
    //   240: invokeinterface 350 1 0
    //   245: pop
    //   246: iinc 2 1
    //   249: goto -94 -> 155
    //   252: aload 6
    //   254: ifnull -233 -> 21
    //   257: aload 6
    //   259: invokeinterface 353 1 0
    //   264: ifne -243 -> 21
    //   267: aload 6
    //   269: invokeinterface 356 1 0
    //   274: goto -253 -> 21
    //   277: astore_1
    //   278: aconst_null
    //   279: astore 6
    //   281: aload 6
    //   283: astore 5
    //   285: aload_0
    //   286: getfield 53	a/a/a/a/a/d:a	Lcn/domob/android/i/f;
    //   289: aload_1
    //   290: invokevirtual 96	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   293: aload 6
    //   295: ifnull -274 -> 21
    //   298: aload 6
    //   300: invokeinterface 353 1 0
    //   305: ifne -284 -> 21
    //   308: aload 6
    //   310: invokeinterface 356 1 0
    //   315: goto -294 -> 21
    //   318: astore_1
    //   319: aconst_null
    //   320: astore 5
    //   322: aload 5
    //   324: ifnull +20 -> 344
    //   327: aload 5
    //   329: invokeinterface 353 1 0
    //   334: ifne +10 -> 344
    //   337: aload 5
    //   339: invokeinterface 356 1 0
    //   344: aload_1
    //   345: athrow
    //   346: astore_1
    //   347: goto -25 -> 322
    //   350: astore_1
    //   351: goto -70 -> 281
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	d
    //   0	354	1	paramContext	Context
    //   154	93	2	j	int
    //   77	44	3	l	long
    //   82	256	5	localObject1	Object
    //   29	280	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   78	134	277	java/lang/Exception
    //   78	134	318	finally
    //   143	153	346	finally
    //   159	170	346	finally
    //   174	184	346	finally
    //   188	208	346	finally
    //   212	234	346	finally
    //   238	246	346	finally
    //   285	293	346	finally
    //   143	153	350	java/lang/Exception
    //   159	170	350	java/lang/Exception
    //   174	184	350	java/lang/Exception
    //   188	208	350	java/lang/Exception
    //   212	234	350	java/lang/Exception
    //   238	246	350	java/lang/Exception
  }
  
  String e(Context paramContext)
  {
    if ((this.f != null) && (this.f.length() > 0)) {
      paramContext = this.f;
    }
    for (;;)
    {
      return paramContext;
      try
      {
        PackageManager localPackageManager = paramContext.getPackageManager();
        if (localPackageManager != null)
        {
          paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0);
          if (paramContext != null)
          {
            this.f = paramContext.packageName;
            paramContext = this.f;
          }
        }
      }
      catch (Exception paramContext)
      {
        this.a.a(paramContext);
        paramContext = null;
      }
    }
  }
  
  protected boolean f(Context paramContext)
  {
    boolean bool = true;
    if (!i)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
      localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
      localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
      if (paramContext.getApplicationContext().registerReceiver(this.e, localIntentFilter) != null) {
        i = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  protected class a
  {
    private String b;
    private String c;
    
    public a(String paramString1, String paramString2)
    {
      this.b = paramString1;
      this.c = paramString2;
    }
    
    public String a()
    {
      return this.b;
    }
    
    public String b()
    {
      return this.c;
    }
  }
  
  class b
    extends BroadcastReceiver
  {
    b() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction()))
      {
        paramIntent = paramIntent.getParcelableExtra("networkInfo");
        if (paramIntent != null)
        {
          paramIntent = (NetworkInfo)paramIntent;
          switch (d.1.a[paramIntent.getState().ordinal()])
          {
          }
        }
      }
      for (;;)
      {
        return;
        d.a(d.this).b("detected wifi is connected");
        d.this.d(paramContext);
        continue;
        d.a(d.this).b("detected wifi is disconnected");
        d.d();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\a\a\a\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */