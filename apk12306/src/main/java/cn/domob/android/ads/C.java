package cn.domob.android.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import cn.domob.android.ads.c.b;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.io.File;

final class c
{
  private static f a = new f(c.class.getSimpleName());
  
  /* Error */
  protected String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   4: astore 5
    //   6: new 35	java/lang/StringBuilder
    //   9: astore_3
    //   10: aload_3
    //   11: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   14: aload 5
    //   16: ldc 38
    //   18: aconst_null
    //   19: aload_3
    //   20: ldc 40
    //   22: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 46
    //   31: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +122 -> 166
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokeinterface 58 1 0
    //   55: ifeq +111 -> 166
    //   58: aload_3
    //   59: astore_2
    //   60: aload_3
    //   61: aload_3
    //   62: ldc 60
    //   64: invokeinterface 64 2 0
    //   69: invokeinterface 68 2 0
    //   74: astore 6
    //   76: aload_3
    //   77: astore_2
    //   78: aload_0
    //   79: aload_1
    //   80: aload 6
    //   82: invokevirtual 72	cn/domob/android/ads/c:c	(Landroid/content/Context;Ljava/lang/String;)Z
    //   85: ifeq +199 -> 284
    //   88: aload_3
    //   89: astore_2
    //   90: aload_0
    //   91: aload_1
    //   92: aload 6
    //   94: invokevirtual 75	cn/domob/android/ads/c:d	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 4
    //   99: aload_3
    //   100: astore_2
    //   101: aload 4
    //   103: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   106: ifeq +93 -> 199
    //   109: aload_3
    //   110: astore_2
    //   111: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   114: astore 7
    //   116: aload_3
    //   117: astore_2
    //   118: new 35	java/lang/StringBuilder
    //   121: astore 4
    //   123: aload_3
    //   124: astore_2
    //   125: aload 4
    //   127: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   130: aload_3
    //   131: astore_2
    //   132: aload 7
    //   134: aload 4
    //   136: ldc 83
    //   138: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 6
    //   143: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: ldc 85
    //   148: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: invokevirtual 88	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   157: aload_3
    //   158: astore_2
    //   159: aload_0
    //   160: aload_1
    //   161: aload 6
    //   163: invokevirtual 92	cn/domob/android/ads/c:f	(Landroid/content/Context;Ljava/lang/String;)V
    //   166: aload_3
    //   167: ifnull +18 -> 185
    //   170: aload_3
    //   171: invokeinterface 95 1 0
    //   176: ifne +9 -> 185
    //   179: aload_3
    //   180: invokeinterface 98 1 0
    //   185: aload 5
    //   187: ifnull +8 -> 195
    //   190: aload 5
    //   192: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_1
    //   198: areturn
    //   199: aload_3
    //   200: astore_2
    //   201: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   204: astore 7
    //   206: aload_3
    //   207: astore_2
    //   208: new 35	java/lang/StringBuilder
    //   211: astore_1
    //   212: aload_3
    //   213: astore_2
    //   214: aload_1
    //   215: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   218: aload_3
    //   219: astore_2
    //   220: aload 7
    //   222: aload_1
    //   223: ldc 103
    //   225: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload 6
    //   230: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 105
    //   235: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload 4
    //   240: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokevirtual 107	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   249: aload_3
    //   250: ifnull +18 -> 268
    //   253: aload_3
    //   254: invokeinterface 95 1 0
    //   259: ifne +9 -> 268
    //   262: aload_3
    //   263: invokeinterface 98 1 0
    //   268: aload 5
    //   270: ifnull +8 -> 278
    //   273: aload 5
    //   275: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   278: aload 4
    //   280: astore_1
    //   281: goto -84 -> 197
    //   284: aload_3
    //   285: astore_2
    //   286: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   289: ldc 109
    //   291: iconst_1
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: aload 6
    //   299: aastore
    //   300: invokestatic 115	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   303: invokevirtual 107	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   306: goto -140 -> 166
    //   309: astore_1
    //   310: aload_3
    //   311: astore_2
    //   312: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   315: aload_1
    //   316: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   319: aload_3
    //   320: ifnull +18 -> 338
    //   323: aload_3
    //   324: invokeinterface 95 1 0
    //   329: ifne +9 -> 338
    //   332: aload_3
    //   333: invokeinterface 98 1 0
    //   338: aload 5
    //   340: ifnull -145 -> 195
    //   343: aload 5
    //   345: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   348: goto -153 -> 195
    //   351: astore_1
    //   352: aconst_null
    //   353: astore_2
    //   354: aload_2
    //   355: ifnull +18 -> 373
    //   358: aload_2
    //   359: invokeinterface 95 1 0
    //   364: ifne +9 -> 373
    //   367: aload_2
    //   368: invokeinterface 98 1 0
    //   373: aload 5
    //   375: ifnull +8 -> 383
    //   378: aload 5
    //   380: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   383: aload_1
    //   384: athrow
    //   385: astore_1
    //   386: goto -32 -> 354
    //   389: astore_1
    //   390: aconst_null
    //   391: astore_3
    //   392: goto -82 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	395	0	this	c
    //   0	395	1	paramContext	Context
    //   0	395	2	paramString	String
    //   9	383	3	localObject1	Object
    //   97	182	4	localObject2	Object
    //   4	375	5	localb	b
    //   74	224	6	str	String
    //   114	107	7	localf	f
    // Exception table:
    //   from	to	target	type
    //   49	58	309	java/lang/Exception
    //   60	76	309	java/lang/Exception
    //   78	88	309	java/lang/Exception
    //   90	99	309	java/lang/Exception
    //   101	109	309	java/lang/Exception
    //   111	116	309	java/lang/Exception
    //   118	123	309	java/lang/Exception
    //   125	130	309	java/lang/Exception
    //   132	157	309	java/lang/Exception
    //   159	166	309	java/lang/Exception
    //   201	206	309	java/lang/Exception
    //   208	212	309	java/lang/Exception
    //   214	218	309	java/lang/Exception
    //   220	249	309	java/lang/Exception
    //   286	306	309	java/lang/Exception
    //   6	43	351	finally
    //   49	58	385	finally
    //   60	76	385	finally
    //   78	88	385	finally
    //   90	99	385	finally
    //   101	109	385	finally
    //   111	116	385	finally
    //   118	123	385	finally
    //   125	130	385	finally
    //   132	157	385	finally
    //   159	166	385	finally
    //   201	206	385	finally
    //   208	212	385	finally
    //   214	218	385	finally
    //   220	249	385	finally
    //   286	306	385	finally
    //   312	319	385	finally
    //   6	43	389	java/lang/Exception
  }
  
  /* Error */
  protected void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   4: astore 8
    //   6: invokestatic 125	java/lang/System:currentTimeMillis	()J
    //   9: lstore 4
    //   11: new 35	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   18: ldc 127
    //   20: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: lload 4
    //   25: invokevirtual 130	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   28: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: astore_1
    //   32: aload 8
    //   34: ldc -124
    //   36: aconst_null
    //   37: aload_1
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore 6
    //   45: aload 6
    //   47: ifnull +274 -> 321
    //   50: aload 6
    //   52: astore_1
    //   53: aload 6
    //   55: invokeinterface 136 1 0
    //   60: ifle +261 -> 321
    //   63: aload 6
    //   65: astore_1
    //   66: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   69: astore 9
    //   71: aload 6
    //   73: astore_1
    //   74: new 35	java/lang/StringBuilder
    //   77: astore 7
    //   79: aload 6
    //   81: astore_1
    //   82: aload 7
    //   84: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   87: aload 6
    //   89: astore_1
    //   90: aload 9
    //   92: aload 7
    //   94: ldc -118
    //   96: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload 6
    //   101: invokeinterface 136 1 0
    //   106: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: ldc -113
    //   111: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   120: iconst_0
    //   121: istore_2
    //   122: aload 6
    //   124: astore_1
    //   125: iload_2
    //   126: aload 6
    //   128: invokeinterface 136 1 0
    //   133: if_icmpge +199 -> 332
    //   136: aload 6
    //   138: astore_1
    //   139: aload 6
    //   141: iload_2
    //   142: invokeinterface 149 2 0
    //   147: pop
    //   148: aload 6
    //   150: astore_1
    //   151: aload 6
    //   153: ldc -105
    //   155: invokeinterface 64 2 0
    //   160: istore_3
    //   161: aload 6
    //   163: astore_1
    //   164: new 35	java/lang/StringBuilder
    //   167: astore 7
    //   169: aload 6
    //   171: astore_1
    //   172: aload 7
    //   174: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   177: aload 6
    //   179: astore_1
    //   180: aload 7
    //   182: ldc -103
    //   184: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: aload 6
    //   189: iload_3
    //   190: invokeinterface 68 2 0
    //   195: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 46
    //   200: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 9
    //   208: aload 6
    //   210: astore_1
    //   211: aload 8
    //   213: ldc -124
    //   215: aload 9
    //   217: aconst_null
    //   218: invokevirtual 156	cn/domob/android/ads/c/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   221: istore_3
    //   222: aload 6
    //   224: astore_1
    //   225: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   228: astore 7
    //   230: aload 6
    //   232: astore_1
    //   233: new 35	java/lang/StringBuilder
    //   236: astore 10
    //   238: aload 6
    //   240: astore_1
    //   241: aload 10
    //   243: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   246: aload 6
    //   248: astore_1
    //   249: aload 7
    //   251: aload 10
    //   253: ldc -98
    //   255: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload 9
    //   260: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   269: aload 6
    //   271: astore_1
    //   272: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   275: astore 7
    //   277: aload 6
    //   279: astore_1
    //   280: new 35	java/lang/StringBuilder
    //   283: astore 9
    //   285: aload 6
    //   287: astore_1
    //   288: aload 9
    //   290: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   293: aload 6
    //   295: astore_1
    //   296: aload 7
    //   298: aload 9
    //   300: ldc -96
    //   302: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: iload_3
    //   306: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   309: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   315: iinc 2 1
    //   318: goto -196 -> 122
    //   321: aload 6
    //   323: astore_1
    //   324: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   327: ldc -94
    //   329: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   332: aload 6
    //   334: ifnull +10 -> 344
    //   337: aload 6
    //   339: invokeinterface 98 1 0
    //   344: aload 8
    //   346: ifnull +8 -> 354
    //   349: aload 8
    //   351: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   354: return
    //   355: astore 7
    //   357: aconst_null
    //   358: astore 6
    //   360: aload 6
    //   362: astore_1
    //   363: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   366: aload 7
    //   368: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   371: aload 6
    //   373: astore_1
    //   374: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   377: ldc -92
    //   379: invokevirtual 166	cn/domob/android/i/f:c	(Ljava/lang/String;)V
    //   382: aload 6
    //   384: ifnull +10 -> 394
    //   387: aload 6
    //   389: invokeinterface 98 1 0
    //   394: aload 8
    //   396: ifnull -42 -> 354
    //   399: aload 8
    //   401: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   404: goto -50 -> 354
    //   407: astore 6
    //   409: aconst_null
    //   410: astore_1
    //   411: aload_1
    //   412: ifnull +9 -> 421
    //   415: aload_1
    //   416: invokeinterface 98 1 0
    //   421: aload 8
    //   423: ifnull +8 -> 431
    //   426: aload 8
    //   428: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   431: aload 6
    //   433: athrow
    //   434: astore 6
    //   436: goto -25 -> 411
    //   439: astore 7
    //   441: goto -81 -> 360
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	c
    //   0	444	1	paramContext	Context
    //   121	195	2	i	int
    //   160	146	3	j	int
    //   9	15	4	l	long
    //   43	345	6	localCursor	Cursor
    //   407	25	6	localObject1	Object
    //   434	1	6	localObject2	Object
    //   77	220	7	localObject3	Object
    //   355	12	7	localException1	Exception
    //   439	1	7	localException2	Exception
    //   4	423	8	localb	b
    //   69	230	9	localObject4	Object
    //   236	16	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   32	45	355	java/lang/Exception
    //   32	45	407	finally
    //   53	63	434	finally
    //   66	71	434	finally
    //   74	79	434	finally
    //   82	87	434	finally
    //   90	120	434	finally
    //   125	136	434	finally
    //   139	148	434	finally
    //   151	161	434	finally
    //   164	169	434	finally
    //   172	177	434	finally
    //   180	208	434	finally
    //   211	222	434	finally
    //   225	230	434	finally
    //   233	238	434	finally
    //   241	246	434	finally
    //   249	269	434	finally
    //   272	277	434	finally
    //   280	285	434	finally
    //   288	293	434	finally
    //   296	315	434	finally
    //   324	332	434	finally
    //   363	371	434	finally
    //   374	382	434	finally
    //   53	63	439	java/lang/Exception
    //   66	71	439	java/lang/Exception
    //   74	79	439	java/lang/Exception
    //   82	87	439	java/lang/Exception
    //   90	120	439	java/lang/Exception
    //   125	136	439	java/lang/Exception
    //   139	148	439	java/lang/Exception
    //   151	161	439	java/lang/Exception
    //   164	169	439	java/lang/Exception
    //   172	177	439	java/lang/Exception
    //   180	208	439	java/lang/Exception
    //   211	222	439	java/lang/Exception
    //   225	230	439	java/lang/Exception
    //   233	238	439	java/lang/Exception
    //   241	246	439	java/lang/Exception
    //   249	269	439	java/lang/Exception
    //   272	277	439	java/lang/Exception
    //   280	285	439	java/lang/Exception
    //   288	293	439	java/lang/Exception
    //   296	315	439	java/lang/Exception
    //   324	332	439	java/lang/Exception
  }
  
  protected void a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    paramContext = b.a(paramContext);
    ContentValues localContentValues = new ContentValues();
    if (paramString2 != null) {}
    try
    {
      localContentValues.put("local_path", paramString2);
      if (paramLong != 0L) {
        localContentValues.put("ts", Long.valueOf(paramLong));
      }
      if (localContentValues.size() != 0)
      {
        paramString2 = new java/lang/StringBuilder;
        paramString2.<init>();
        paramContext.a("alias_info", localContentValues, "alias= \"" + paramString1 + "\"", null);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a.a(paramString1);
        a.e("Failed to update alias info.");
        if (paramContext != null) {
          paramContext.b();
        }
      }
    }
    finally
    {
      if (paramContext != null) {
        paramContext.b();
      }
    }
  }
  
  protected void a(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject1 = a;
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>();
        ((f)localObject1).a("Delete file:" + paramString);
        if ((paramString != null) && (paramString.length() != 0))
        {
          localObject1 = new java/io/File;
          ((File)localObject1).<init>(paramString);
          if (((File)localObject1).exists())
          {
            if (!((File)localObject1).delete()) {
              continue;
            }
            localObject2 = a;
            localObject1 = new java/lang/StringBuilder;
            ((StringBuilder)localObject1).<init>();
            ((f)localObject2).a("Success to delete file " + paramString);
          }
        }
        return;
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        a.e("Error happened when deleting file " + paramString);
        a.a(localException);
        continue;
      }
      localObject1 = a;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((f)localObject1).e("Failed to delete file " + paramString);
    }
  }
  
  /* Error */
  protected boolean a(Context paramContext, K paramK)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_2
    //   4: invokevirtual 225	cn/domob/android/ads/K:g	()Z
    //   7: ifne +18 -> 25
    //   10: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   13: ldc -29
    //   15: invokevirtual 88	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   18: iload 5
    //   20: istore 4
    //   22: iload 4
    //   24: ireturn
    //   25: aload_1
    //   26: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   29: astore 7
    //   31: new 169	android/content/ContentValues
    //   34: dup
    //   35: invokespecial 170	android/content/ContentValues:<init>	()V
    //   38: astore 6
    //   40: aload 6
    //   42: ldc -105
    //   44: aload_2
    //   45: invokevirtual 229	cn/domob/android/ads/K:b	()Ljava/lang/String;
    //   48: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload 6
    //   53: ldc -25
    //   55: aload_2
    //   56: invokevirtual 233	cn/domob/android/ads/K:c	()Ljava/lang/String;
    //   59: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aload 6
    //   64: ldc -21
    //   66: aload_2
    //   67: invokevirtual 237	cn/domob/android/ads/K:d	()J
    //   70: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: invokevirtual 187	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   76: aload 6
    //   78: ldc -17
    //   80: aload_2
    //   81: invokevirtual 241	cn/domob/android/ads/K:e	()J
    //   84: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   87: invokevirtual 187	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   90: aload 6
    //   92: ldc -13
    //   94: aload_2
    //   95: invokevirtual 245	cn/domob/android/ads/K:f	()Ljava/lang/String;
    //   98: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 6
    //   103: ldc -9
    //   105: aload_2
    //   106: invokevirtual 249	cn/domob/android/ads/K:a	()Ljava/lang/String;
    //   109: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload 7
    //   114: ldc -124
    //   116: aconst_null
    //   117: aconst_null
    //   118: aconst_null
    //   119: aconst_null
    //   120: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   123: astore_2
    //   124: aload_2
    //   125: ifnull +93 -> 218
    //   128: aload_2
    //   129: astore_1
    //   130: aload_2
    //   131: invokeinterface 136 1 0
    //   136: ifle +82 -> 218
    //   139: aload_2
    //   140: astore_1
    //   141: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   144: ldc -5
    //   146: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   149: aload_2
    //   150: astore_1
    //   151: aload 7
    //   153: ldc -124
    //   155: aload 6
    //   157: aconst_null
    //   158: aconst_null
    //   159: invokevirtual 197	cn/domob/android/ads/c/b:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   162: istore_3
    //   163: aload_2
    //   164: astore_1
    //   165: aload_2
    //   166: invokeinterface 95 1 0
    //   171: ifne +11 -> 182
    //   174: aload_2
    //   175: astore_1
    //   176: aload_2
    //   177: invokeinterface 98 1 0
    //   182: iload_3
    //   183: ifge +29 -> 212
    //   186: iconst_0
    //   187: istore 4
    //   189: aload_2
    //   190: ifnull +9 -> 199
    //   193: aload_2
    //   194: invokeinterface 98 1 0
    //   199: aload 7
    //   201: ifnull +8 -> 209
    //   204: aload 7
    //   206: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   209: goto -187 -> 22
    //   212: iconst_1
    //   213: istore 4
    //   215: goto -26 -> 189
    //   218: aload_2
    //   219: astore_1
    //   220: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   223: ldc -3
    //   225: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   228: aload_2
    //   229: astore_1
    //   230: aload 7
    //   232: ldc -124
    //   234: aload 6
    //   236: invokevirtual 256	cn/domob/android/ads/c/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)Z
    //   239: istore 4
    //   241: iload 4
    //   243: istore 5
    //   245: aload_2
    //   246: ifnull +9 -> 255
    //   249: aload_2
    //   250: invokeinterface 98 1 0
    //   255: iload 5
    //   257: istore 4
    //   259: aload 7
    //   261: ifnull -239 -> 22
    //   264: aload 7
    //   266: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   269: iload 5
    //   271: istore 4
    //   273: goto -251 -> 22
    //   276: astore 6
    //   278: aconst_null
    //   279: astore_2
    //   280: aload_2
    //   281: astore_1
    //   282: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   285: aload 6
    //   287: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   290: aload_2
    //   291: astore_1
    //   292: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   295: ldc_w 258
    //   298: invokevirtual 88	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   301: aload_2
    //   302: ifnull +9 -> 311
    //   305: aload_2
    //   306: invokeinterface 98 1 0
    //   311: iload 5
    //   313: istore 4
    //   315: aload 7
    //   317: ifnull -295 -> 22
    //   320: aload 7
    //   322: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   325: iload 5
    //   327: istore 4
    //   329: goto -307 -> 22
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: aload_1
    //   336: ifnull +9 -> 345
    //   339: aload_1
    //   340: invokeinterface 98 1 0
    //   345: aload 7
    //   347: ifnull +8 -> 355
    //   350: aload 7
    //   352: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   355: aload_2
    //   356: athrow
    //   357: astore_2
    //   358: goto -23 -> 335
    //   361: astore 6
    //   363: goto -83 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	this	c
    //   0	366	1	paramContext	Context
    //   0	366	2	paramK	K
    //   162	21	3	i	int
    //   20	308	4	bool1	boolean
    //   1	325	5	bool2	boolean
    //   38	197	6	localContentValues	ContentValues
    //   276	10	6	localException1	Exception
    //   361	1	6	localException2	Exception
    //   29	322	7	localb	b
    // Exception table:
    //   from	to	target	type
    //   112	124	276	java/lang/Exception
    //   112	124	332	finally
    //   130	139	357	finally
    //   141	149	357	finally
    //   151	163	357	finally
    //   165	174	357	finally
    //   176	182	357	finally
    //   220	228	357	finally
    //   230	241	357	finally
    //   282	290	357	finally
    //   292	301	357	finally
    //   130	139	361	java/lang/Exception
    //   141	149	361	java/lang/Exception
    //   151	163	361	java/lang/Exception
    //   165	174	361	java/lang/Exception
    //   176	182	361	java/lang/Exception
    //   220	228	361	java/lang/Exception
    //   230	241	361	java/lang/Exception
  }
  
  protected boolean a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    boolean bool2 = true;
    localb = b.a(paramContext);
    localObject1 = localObject2;
    paramContext = (Context)localObject3;
    for (;;)
    {
      try
      {
        paramString1 = String.format("SELECT * FROM %s WHERE %s=\"%s\" AND %s=\"%s\"", new Object[] { "creative_alias", "creative_id", paramString1, "alias", paramString2 });
        localObject1 = localObject2;
        paramContext = (Context)localObject3;
        paramString2 = a;
        localObject1 = localObject2;
        paramContext = (Context)localObject3;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localObject1 = localObject2;
        paramContext = (Context)localObject3;
        localStringBuilder.<init>();
        localObject1 = localObject2;
        paramContext = (Context)localObject3;
        paramString2.a("isCreativeHasAlias sql:" + paramString1);
        localObject1 = localObject2;
        paramContext = (Context)localObject3;
        paramString1 = localb.a(paramString1, null);
        if (paramString1 != null)
        {
          localObject1 = paramString1;
          paramContext = paramString1;
          int i = paramString1.getCount();
          if (i > 0)
          {
            if ((paramString1 != null) && (!paramString1.isClosed())) {
              paramString1.close();
            }
            bool1 = bool2;
            if (localb != null)
            {
              localb.b();
              bool1 = bool2;
            }
            return bool1;
          }
        }
      }
      catch (Exception paramString1)
      {
        boolean bool1;
        paramContext = (Context)localObject1;
        a.a(paramString1);
        if ((localObject1 == null) || (((Cursor)localObject1).isClosed())) {
          continue;
        }
        ((Cursor)localObject1).close();
        if (localb == null) {
          continue;
        }
        localb.b();
        continue;
      }
      finally
      {
        if ((paramContext == null) || (paramContext.isClosed())) {
          continue;
        }
        paramContext.close();
        if (localb == null) {
          continue;
        }
        localb.b();
      }
      bool1 = false;
    }
  }
  
  /* Error */
  protected K b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   6: astore 5
    //   8: aload 5
    //   10: ldc -124
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnull +213 -> 234
    //   24: aload_1
    //   25: invokeinterface 136 1 0
    //   30: ifle +204 -> 234
    //   33: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   36: astore_3
    //   37: new 35	java/lang/StringBuilder
    //   40: astore_2
    //   41: aload_2
    //   42: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   45: aload_3
    //   46: aload_2
    //   47: ldc_w 271
    //   50: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: invokeinterface 136 1 0
    //   59: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc_w 273
    //   65: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokeinterface 58 1 0
    //   80: pop
    //   81: new 222	cn/domob/android/ads/K
    //   84: astore_3
    //   85: aload_3
    //   86: invokespecial 274	cn/domob/android/ads/K:<init>	()V
    //   89: aload_3
    //   90: aload_1
    //   91: aload_1
    //   92: ldc -105
    //   94: invokeinterface 64 2 0
    //   99: invokeinterface 68 2 0
    //   104: invokevirtual 275	cn/domob/android/ads/K:b	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: aload_1
    //   109: aload_1
    //   110: ldc -25
    //   112: invokeinterface 64 2 0
    //   117: invokeinterface 68 2 0
    //   122: invokevirtual 276	cn/domob/android/ads/K:c	(Ljava/lang/String;)V
    //   125: aload_3
    //   126: aload_1
    //   127: aload_1
    //   128: ldc -21
    //   130: invokeinterface 64 2 0
    //   135: invokeinterface 280 2 0
    //   140: invokevirtual 283	cn/domob/android/ads/K:a	(J)V
    //   143: aload_3
    //   144: aload_1
    //   145: aload_1
    //   146: ldc -17
    //   148: invokeinterface 64 2 0
    //   153: invokeinterface 280 2 0
    //   158: invokevirtual 285	cn/domob/android/ads/K:b	(J)V
    //   161: aload_3
    //   162: aload_1
    //   163: aload_1
    //   164: ldc -13
    //   166: invokeinterface 64 2 0
    //   171: invokeinterface 68 2 0
    //   176: invokevirtual 287	cn/domob/android/ads/K:d	(Ljava/lang/String;)V
    //   179: aload_3
    //   180: aload_1
    //   181: aload_1
    //   182: ldc -9
    //   184: invokeinterface 64 2 0
    //   189: invokeinterface 68 2 0
    //   194: invokevirtual 288	cn/domob/android/ads/K:a	(Ljava/lang/String;)V
    //   197: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   200: ldc_w 290
    //   203: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   206: aload_3
    //   207: astore_2
    //   208: aload_1
    //   209: ifnull +9 -> 218
    //   212: aload_1
    //   213: invokeinterface 98 1 0
    //   218: aload_2
    //   219: astore_3
    //   220: aload 5
    //   222: ifnull +131 -> 353
    //   225: aload 5
    //   227: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   230: aload_2
    //   231: astore_1
    //   232: aload_1
    //   233: areturn
    //   234: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   237: ldc_w 292
    //   240: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   243: aconst_null
    //   244: astore_2
    //   245: goto -37 -> 208
    //   248: astore_3
    //   249: aconst_null
    //   250: astore_1
    //   251: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   254: aload_3
    //   255: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   258: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   261: ldc_w 294
    //   264: invokevirtual 88	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   267: aload_2
    //   268: ifnull +9 -> 277
    //   271: aload_2
    //   272: invokeinterface 98 1 0
    //   277: aload_1
    //   278: astore_3
    //   279: aload 5
    //   281: ifnull +72 -> 353
    //   284: aload 5
    //   286: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   289: goto -57 -> 232
    //   292: astore_2
    //   293: aconst_null
    //   294: astore_1
    //   295: aload_1
    //   296: ifnull +9 -> 305
    //   299: aload_1
    //   300: invokeinterface 98 1 0
    //   305: aload 5
    //   307: ifnull +8 -> 315
    //   310: aload 5
    //   312: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   315: aload_2
    //   316: athrow
    //   317: astore_2
    //   318: goto -23 -> 295
    //   321: astore_3
    //   322: aload_2
    //   323: astore_1
    //   324: aload_3
    //   325: astore_2
    //   326: goto -31 -> 295
    //   329: astore_3
    //   330: aconst_null
    //   331: astore 4
    //   333: aload_1
    //   334: astore_2
    //   335: aload 4
    //   337: astore_1
    //   338: goto -87 -> 251
    //   341: astore 4
    //   343: aload_1
    //   344: astore_2
    //   345: aload_3
    //   346: astore_1
    //   347: aload 4
    //   349: astore_3
    //   350: goto -99 -> 251
    //   353: aload_3
    //   354: astore_1
    //   355: goto -123 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	358	0	this	c
    //   0	358	1	paramContext	Context
    //   1	271	2	localObject1	Object
    //   292	24	2	localObject2	Object
    //   317	6	2	localObject3	Object
    //   325	20	2	localObject4	Object
    //   36	184	3	localObject5	Object
    //   248	7	3	localException1	Exception
    //   278	1	3	localContext	Context
    //   321	4	3	localObject6	Object
    //   329	17	3	localException2	Exception
    //   349	5	3	localObject7	Object
    //   331	5	4	localObject8	Object
    //   341	7	4	localException3	Exception
    //   6	305	5	localb	b
    // Exception table:
    //   from	to	target	type
    //   8	20	248	java/lang/Exception
    //   8	20	292	finally
    //   24	89	317	finally
    //   89	206	317	finally
    //   234	243	317	finally
    //   251	267	321	finally
    //   24	89	329	java/lang/Exception
    //   234	243	329	java/lang/Exception
    //   89	206	341	java/lang/Exception
  }
  
  /* Error */
  protected String b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   6: astore 4
    //   8: new 35	java/lang/StringBuilder
    //   11: astore_1
    //   12: aload_1
    //   13: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   16: aload 4
    //   18: ldc -64
    //   20: aconst_null
    //   21: aload_1
    //   22: ldc -62
    //   24: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_2
    //   28: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: ldc 46
    //   33: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: aconst_null
    //   40: aconst_null
    //   41: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +73 -> 119
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: invokeinterface 136 1 0
    //   57: ifle +62 -> 119
    //   60: aload_2
    //   61: astore_1
    //   62: aload_2
    //   63: invokeinterface 58 1 0
    //   68: pop
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_2
    //   73: ldc -84
    //   75: invokeinterface 64 2 0
    //   80: invokeinterface 68 2 0
    //   85: astore_3
    //   86: aload_2
    //   87: ifnull +18 -> 105
    //   90: aload_2
    //   91: invokeinterface 95 1 0
    //   96: ifne +9 -> 105
    //   99: aload_2
    //   100: invokeinterface 98 1 0
    //   105: aload 4
    //   107: ifnull +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   115: aload_3
    //   116: astore_1
    //   117: aload_1
    //   118: areturn
    //   119: aload_2
    //   120: ifnull +18 -> 138
    //   123: aload_2
    //   124: invokeinterface 95 1 0
    //   129: ifne +9 -> 138
    //   132: aload_2
    //   133: invokeinterface 98 1 0
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   148: aconst_null
    //   149: astore_1
    //   150: goto -33 -> 117
    //   153: astore_3
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: astore_1
    //   158: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   161: aload_3
    //   162: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   165: aload_2
    //   166: ifnull +18 -> 184
    //   169: aload_2
    //   170: invokeinterface 95 1 0
    //   175: ifne +9 -> 184
    //   178: aload_2
    //   179: invokeinterface 98 1 0
    //   184: aload 4
    //   186: ifnull -38 -> 148
    //   189: aload 4
    //   191: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   194: goto -46 -> 148
    //   197: astore_2
    //   198: aload_3
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +18 -> 219
    //   204: aload_1
    //   205: invokeinterface 95 1 0
    //   210: ifne +9 -> 219
    //   213: aload_1
    //   214: invokeinterface 98 1 0
    //   219: aload 4
    //   221: ifnull +8 -> 229
    //   224: aload 4
    //   226: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   229: aload_2
    //   230: athrow
    //   231: astore_2
    //   232: goto -32 -> 200
    //   235: astore_3
    //   236: goto -80 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	c
    //   0	239	1	paramContext	Context
    //   0	239	2	paramString	String
    //   1	115	3	str	String
    //   153	46	3	localException1	Exception
    //   235	1	3	localException2	Exception
    //   6	219	4	localb	b
    // Exception table:
    //   from	to	target	type
    //   8	45	153	java/lang/Exception
    //   8	45	197	finally
    //   51	60	231	finally
    //   62	69	231	finally
    //   71	86	231	finally
    //   158	165	231	finally
    //   51	60	235	java/lang/Exception
    //   62	69	235	java/lang/Exception
    //   71	86	235	java/lang/Exception
  }
  
  protected void b(Context paramContext, String paramString1, String paramString2)
  {
    if (!h.e(paramString1)) {
      paramContext = b.a(paramContext);
    }
    try
    {
      ContentValues localContentValues = new android/content/ContentValues;
      localContentValues.<init>();
      localContentValues.put("alias", paramString1);
      if (paramString2 != null) {
        localContentValues.put("local_path", paramString2);
      }
      localContentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
      paramContext.a("alias_info", localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a.a(paramString1);
        a.e("Failed to insert alias info.");
        if (paramContext != null) {
          paramContext.b();
        }
      }
    }
    finally
    {
      if (paramContext != null) {
        paramContext.b();
      }
    }
  }
  
  protected void c(Context paramContext)
  {
    paramContext = b.a(paramContext);
    paramContext.a("domob_splash_ad_cache_res", null, null);
    paramContext.a("creative_alias", null, null);
    if (paramContext != null) {
      paramContext.b();
    }
  }
  
  protected void c(Context paramContext, String paramString1, String paramString2)
  {
    if ((!h.e(paramString1)) && (!h.e(paramString2))) {
      paramContext = b.a(paramContext);
    }
    try
    {
      ContentValues localContentValues = new android/content/ContentValues;
      localContentValues.<init>();
      localContentValues.put("alias", paramString1);
      localContentValues.put("creative_id", paramString2);
      paramContext.a("creative_alias", localContentValues);
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a.a(paramString1);
        a.e("Failed to insert creative-alias.");
        if (paramContext != null) {
          paramContext.b();
        }
      }
    }
    finally
    {
      if (paramContext != null) {
        paramContext.b();
      }
    }
  }
  
  /* Error */
  protected boolean c(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   7: astore 6
    //   9: new 35	java/lang/StringBuilder
    //   12: astore 5
    //   14: aload 5
    //   16: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   19: aload 6
    //   21: ldc -64
    //   23: aconst_null
    //   24: aload 5
    //   26: ldc -62
    //   28: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: aload_2
    //   32: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 46
    //   37: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: aconst_null
    //   44: aconst_null
    //   45: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +74 -> 126
    //   55: aload 5
    //   57: astore 4
    //   59: aload 5
    //   61: invokeinterface 136 1 0
    //   66: ifle +60 -> 126
    //   69: aload 5
    //   71: astore 4
    //   73: aload 5
    //   75: invokeinterface 98 1 0
    //   80: aload 5
    //   82: astore 4
    //   84: aload_0
    //   85: aload_1
    //   86: aload_2
    //   87: invokevirtual 306	cn/domob/android/ads/c:e	(Landroid/content/Context;Ljava/lang/String;)V
    //   90: aload 5
    //   92: ifnull +20 -> 112
    //   95: aload 5
    //   97: invokeinterface 95 1 0
    //   102: ifne +10 -> 112
    //   105: aload 5
    //   107: invokeinterface 98 1 0
    //   112: aload 6
    //   114: ifnull +8 -> 122
    //   117: aload 6
    //   119: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   122: iconst_1
    //   123: istore_3
    //   124: iload_3
    //   125: ireturn
    //   126: aload 5
    //   128: ifnull +20 -> 148
    //   131: aload 5
    //   133: invokeinterface 95 1 0
    //   138: ifne +10 -> 148
    //   141: aload 5
    //   143: invokeinterface 98 1 0
    //   148: aload 6
    //   150: ifnull +8 -> 158
    //   153: aload 6
    //   155: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -36 -> 124
    //   163: astore_1
    //   164: aconst_null
    //   165: astore 5
    //   167: aload 5
    //   169: astore 4
    //   171: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   174: aload_1
    //   175: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   178: aload 5
    //   180: ifnull +20 -> 200
    //   183: aload 5
    //   185: invokeinterface 95 1 0
    //   190: ifne +10 -> 200
    //   193: aload 5
    //   195: invokeinterface 98 1 0
    //   200: aload 6
    //   202: ifnull -44 -> 158
    //   205: aload 6
    //   207: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   210: goto -52 -> 158
    //   213: astore_1
    //   214: aload 4
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +18 -> 236
    //   221: aload_2
    //   222: invokeinterface 95 1 0
    //   227: ifne +9 -> 236
    //   230: aload_2
    //   231: invokeinterface 98 1 0
    //   236: aload 6
    //   238: ifnull +8 -> 246
    //   241: aload 6
    //   243: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   246: aload_1
    //   247: athrow
    //   248: astore_1
    //   249: aload 4
    //   251: astore_2
    //   252: goto -35 -> 217
    //   255: astore_1
    //   256: goto -89 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	c
    //   0	259	1	paramContext	Context
    //   0	259	2	paramString	String
    //   123	37	3	bool	boolean
    //   1	249	4	localObject1	Object
    //   12	182	5	localObject2	Object
    //   7	235	6	localb	b
    // Exception table:
    //   from	to	target	type
    //   9	50	163	java/lang/Exception
    //   9	50	213	finally
    //   59	69	248	finally
    //   73	80	248	finally
    //   84	90	248	finally
    //   171	178	248	finally
    //   59	69	255	java/lang/Exception
    //   73	80	255	java/lang/Exception
    //   84	90	255	java/lang/Exception
  }
  
  protected String d(Context paramContext, String paramString)
  {
    String str2 = b(paramContext, paramString);
    if ((str2 == null) || (str2.length() == 0)) {
      a.a(String.format("Alias %s is in DB but the local path is null.", new Object[] { paramString }));
    }
    for (;;)
    {
      String str1 = null;
      do
      {
        return str1;
        str1 = str2;
      } while (new File(str2).exists());
      f(paramContext, paramString);
    }
  }
  
  /* Error */
  protected void d(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   4: astore 11
    //   6: aload 11
    //   8: ldc -64
    //   10: iconst_3
    //   11: anewarray 111	java/lang/String
    //   14: dup
    //   15: iconst_0
    //   16: ldc 60
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: ldc -84
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc -78
    //   28: aastore
    //   29: aconst_null
    //   30: aconst_null
    //   31: ldc -78
    //   33: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 10
    //   38: aload 10
    //   40: ifnull +309 -> 349
    //   43: aload 10
    //   45: astore 9
    //   47: aload 10
    //   49: invokeinterface 136 1 0
    //   54: istore_2
    //   55: aload 10
    //   57: astore 9
    //   59: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   62: astore 12
    //   64: aload 10
    //   66: astore 9
    //   68: new 35	java/lang/StringBuilder
    //   71: astore 13
    //   73: aload 10
    //   75: astore 9
    //   77: aload 13
    //   79: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   82: aload 10
    //   84: astore 9
    //   86: aload 12
    //   88: aload 13
    //   90: ldc_w 312
    //   93: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: iload_2
    //   97: invokevirtual 141	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   100: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 107	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   106: iload_2
    //   107: bipush 10
    //   109: if_icmple +279 -> 388
    //   112: iload_2
    //   113: bipush 10
    //   115: isub
    //   116: istore_3
    //   117: aload 10
    //   119: astore 9
    //   121: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   124: ldc_w 314
    //   127: iconst_3
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: iload_2
    //   134: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: bipush 10
    //   142: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: iload_3
    //   149: invokestatic 319	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: invokestatic 115	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   156: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   159: aload 10
    //   161: astore 9
    //   163: aload 10
    //   165: invokeinterface 58 1 0
    //   170: pop
    //   171: iconst_0
    //   172: istore_2
    //   173: iload_2
    //   174: iload_3
    //   175: if_icmpge +161 -> 336
    //   178: aload 10
    //   180: astore 9
    //   182: aload 10
    //   184: ldc 60
    //   186: invokeinterface 64 2 0
    //   191: istore 4
    //   193: aload 10
    //   195: astore 9
    //   197: aload 10
    //   199: ldc -84
    //   201: invokeinterface 64 2 0
    //   206: istore 6
    //   208: aload 10
    //   210: astore 9
    //   212: aload 10
    //   214: ldc -78
    //   216: invokeinterface 64 2 0
    //   221: istore 5
    //   223: aload 10
    //   225: astore 9
    //   227: aload 10
    //   229: iload 4
    //   231: invokeinterface 68 2 0
    //   236: astore 13
    //   238: aload 10
    //   240: astore 9
    //   242: aload 10
    //   244: iload 6
    //   246: invokeinterface 68 2 0
    //   251: astore 12
    //   253: aload 10
    //   255: astore 9
    //   257: aload 10
    //   259: iload 5
    //   261: invokeinterface 280 2 0
    //   266: lstore 7
    //   268: aload 10
    //   270: astore 9
    //   272: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   275: ldc_w 321
    //   278: iconst_2
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload 13
    //   286: aastore
    //   287: dup
    //   288: iconst_1
    //   289: lload 7
    //   291: invokestatic 184	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   294: aastore
    //   295: invokestatic 115	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   298: invokevirtual 107	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   301: aload 10
    //   303: astore 9
    //   305: aload_0
    //   306: aload 12
    //   308: invokevirtual 322	cn/domob/android/ads/c:a	(Ljava/lang/String;)V
    //   311: aload 10
    //   313: astore 9
    //   315: aload_0
    //   316: aload_1
    //   317: aload 13
    //   319: invokevirtual 92	cn/domob/android/ads/c:f	(Landroid/content/Context;Ljava/lang/String;)V
    //   322: aload 10
    //   324: astore 9
    //   326: aload 10
    //   328: invokeinterface 325 1 0
    //   333: ifne +49 -> 382
    //   336: aload 10
    //   338: astore 9
    //   340: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   343: ldc_w 327
    //   346: invokevirtual 107	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   349: aload 10
    //   351: ifnull +20 -> 371
    //   354: aload 10
    //   356: invokeinterface 95 1 0
    //   361: ifne +10 -> 371
    //   364: aload 10
    //   366: invokeinterface 98 1 0
    //   371: aload 11
    //   373: ifnull +8 -> 381
    //   376: aload 11
    //   378: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   381: return
    //   382: iinc 2 1
    //   385: goto -212 -> 173
    //   388: aload 10
    //   390: astore 9
    //   392: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   395: ldc_w 329
    //   398: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   401: goto -52 -> 349
    //   404: astore_1
    //   405: aload 10
    //   407: astore 9
    //   409: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   412: aload_1
    //   413: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   416: aload 10
    //   418: astore 9
    //   420: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   423: ldc_w 331
    //   426: invokevirtual 88	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   429: aload 10
    //   431: ifnull +20 -> 451
    //   434: aload 10
    //   436: invokeinterface 95 1 0
    //   441: ifne +10 -> 451
    //   444: aload 10
    //   446: invokeinterface 98 1 0
    //   451: aload 11
    //   453: ifnull -72 -> 381
    //   456: aload 11
    //   458: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   461: goto -80 -> 381
    //   464: astore_1
    //   465: aconst_null
    //   466: astore 9
    //   468: aload 9
    //   470: ifnull +20 -> 490
    //   473: aload 9
    //   475: invokeinterface 95 1 0
    //   480: ifne +10 -> 490
    //   483: aload 9
    //   485: invokeinterface 98 1 0
    //   490: aload 11
    //   492: ifnull +8 -> 500
    //   495: aload 11
    //   497: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   500: aload_1
    //   501: athrow
    //   502: astore_1
    //   503: goto -35 -> 468
    //   506: astore_1
    //   507: aconst_null
    //   508: astore 10
    //   510: goto -105 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	c
    //   0	513	1	paramContext	Context
    //   54	329	2	i	int
    //   116	60	3	j	int
    //   191	39	4	k	int
    //   221	39	5	m	int
    //   206	39	6	n	int
    //   266	24	7	l	long
    //   45	439	9	localCursor1	Cursor
    //   36	473	10	localCursor2	Cursor
    //   4	492	11	localb	b
    //   62	245	12	localObject1	Object
    //   71	247	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   47	55	404	java/lang/Exception
    //   59	64	404	java/lang/Exception
    //   68	73	404	java/lang/Exception
    //   77	82	404	java/lang/Exception
    //   86	106	404	java/lang/Exception
    //   121	159	404	java/lang/Exception
    //   163	171	404	java/lang/Exception
    //   182	193	404	java/lang/Exception
    //   197	208	404	java/lang/Exception
    //   212	223	404	java/lang/Exception
    //   227	238	404	java/lang/Exception
    //   242	253	404	java/lang/Exception
    //   257	268	404	java/lang/Exception
    //   272	301	404	java/lang/Exception
    //   305	311	404	java/lang/Exception
    //   315	322	404	java/lang/Exception
    //   326	336	404	java/lang/Exception
    //   340	349	404	java/lang/Exception
    //   392	401	404	java/lang/Exception
    //   6	38	464	finally
    //   47	55	502	finally
    //   59	64	502	finally
    //   68	73	502	finally
    //   77	82	502	finally
    //   86	106	502	finally
    //   121	159	502	finally
    //   163	171	502	finally
    //   182	193	502	finally
    //   197	208	502	finally
    //   212	223	502	finally
    //   227	238	502	finally
    //   242	253	502	finally
    //   257	268	502	finally
    //   272	301	502	finally
    //   305	311	502	finally
    //   315	322	502	finally
    //   326	336	502	finally
    //   340	349	502	finally
    //   392	401	502	finally
    //   409	416	502	finally
    //   420	429	502	finally
    //   6	38	506	java/lang/Exception
  }
  
  /* Error */
  public boolean d(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 33	cn/domob/android/ads/c/b:a	(Landroid/content/Context;)Lcn/domob/android/ads/c/b;
    //   4: astore 7
    //   6: new 169	android/content/ContentValues
    //   9: dup
    //   10: invokespecial 170	android/content/ContentValues:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: ldc_w 263
    //   20: aload_2
    //   21: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload 8
    //   26: ldc 60
    //   28: aload_3
    //   29: invokevirtual 176	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload 7
    //   34: ldc 38
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 52	cn/domob/android/ads/c/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   43: astore_2
    //   44: aload_2
    //   45: ifnull +93 -> 138
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: invokeinterface 136 1 0
    //   56: ifle +82 -> 138
    //   59: aload_2
    //   60: astore_1
    //   61: aload 7
    //   63: ldc 38
    //   65: aload 8
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokevirtual 197	cn/domob/android/ads/c/b:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   72: istore 4
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: invokeinterface 95 1 0
    //   82: ifne +11 -> 93
    //   85: aload_2
    //   86: astore_1
    //   87: aload_2
    //   88: invokeinterface 98 1 0
    //   93: iload 4
    //   95: ifge +37 -> 132
    //   98: iconst_0
    //   99: istore 6
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: invokeinterface 98 1 0
    //   111: iload 6
    //   113: istore 5
    //   115: aload 7
    //   117: ifnull +12 -> 129
    //   120: aload 7
    //   122: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   125: iload 6
    //   127: istore 5
    //   129: iload 5
    //   131: ireturn
    //   132: iconst_1
    //   133: istore 6
    //   135: goto -34 -> 101
    //   138: aload_2
    //   139: astore_1
    //   140: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   143: ldc -3
    //   145: invokevirtual 145	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   148: aload_2
    //   149: astore_1
    //   150: aload 7
    //   152: ldc 38
    //   154: aload 8
    //   156: invokevirtual 256	cn/domob/android/ads/c/b:a	(Ljava/lang/String;Landroid/content/ContentValues;)Z
    //   159: istore 6
    //   161: aload_2
    //   162: ifnull +9 -> 171
    //   165: aload_2
    //   166: invokeinterface 98 1 0
    //   171: iload 6
    //   173: istore 5
    //   175: aload 7
    //   177: ifnull -48 -> 129
    //   180: aload 7
    //   182: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   185: iload 6
    //   187: istore 5
    //   189: goto -60 -> 129
    //   192: astore_3
    //   193: aconst_null
    //   194: astore_2
    //   195: aload_2
    //   196: astore_1
    //   197: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   200: aload_3
    //   201: invokevirtual 118	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   204: aload_2
    //   205: astore_1
    //   206: getstatic 22	cn/domob/android/ads/c:a	Lcn/domob/android/i/f;
    //   209: ldc_w 258
    //   212: invokevirtual 88	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   215: aload_2
    //   216: ifnull +9 -> 225
    //   219: aload_2
    //   220: invokeinterface 98 1 0
    //   225: aload 7
    //   227: ifnull +8 -> 235
    //   230: aload 7
    //   232: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   235: iconst_0
    //   236: istore 5
    //   238: goto -109 -> 129
    //   241: astore_2
    //   242: aconst_null
    //   243: astore_1
    //   244: aload_1
    //   245: ifnull +9 -> 254
    //   248: aload_1
    //   249: invokeinterface 98 1 0
    //   254: aload 7
    //   256: ifnull +8 -> 264
    //   259: aload 7
    //   261: invokevirtual 101	cn/domob/android/ads/c/b:b	()V
    //   264: aload_2
    //   265: athrow
    //   266: astore_2
    //   267: goto -23 -> 244
    //   270: astore_3
    //   271: goto -76 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	this	c
    //   0	274	1	paramContext	Context
    //   0	274	2	paramString1	String
    //   0	274	3	paramString2	String
    //   72	22	4	i	int
    //   113	124	5	bool1	boolean
    //   99	87	6	bool2	boolean
    //   4	256	7	localb	b
    //   13	142	8	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   32	44	192	java/lang/Exception
    //   32	44	241	finally
    //   50	59	266	finally
    //   61	74	266	finally
    //   76	85	266	finally
    //   87	93	266	finally
    //   140	148	266	finally
    //   150	161	266	finally
    //   197	204	266	finally
    //   206	215	266	finally
    //   50	59	270	java/lang/Exception
    //   61	74	270	java/lang/Exception
    //   76	85	270	java/lang/Exception
    //   87	93	270	java/lang/Exception
    //   140	148	270	java/lang/Exception
    //   150	161	270	java/lang/Exception
  }
  
  protected void e(Context paramContext, String paramString)
  {
    if (!h.e(paramString)) {
      a(paramContext, paramString, null, System.currentTimeMillis());
    }
  }
  
  protected void f(Context paramContext, String paramString)
  {
    if (!h.e(paramString))
    {
      a.a("Delete alias:" + paramString);
      paramContext = b.a(paramContext);
    }
    try
    {
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramContext.a("alias_info", "alias= \"" + paramString + "\"", null);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        a.a(paramString);
        a.e("Failed to delete alias info.");
        if (paramContext != null) {
          paramContext.b();
        }
      }
    }
    finally
    {
      if (paramContext != null) {
        paramContext.b();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\C.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */