package cn.domob.android.offerwall;

import android.content.Context;
import android.database.Cursor;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;

class e
  implements Runnable
{
  static final String a = "GET";
  static final String b = "POST";
  static final int c = 20000;
  private static m d = new m(e.class.getSimpleName());
  private static final int t = 4096;
  private static final String u = "ctwap";
  private HttpURLConnection e;
  private Context f;
  private URL g;
  private String h;
  private String i;
  private HashMap<String, String> j;
  private Proxy k;
  private String l;
  private int m;
  private a n;
  private String o;
  private String p;
  private int q;
  private String r;
  private byte[] s;
  
  e(Context paramContext, String paramString, a parama)
  {
    this(paramContext, paramString, null, null, "GET", null, 20000, parama);
  }
  
  e(Context paramContext, String paramString1, String paramString2, a parama)
  {
    this(paramContext, paramString1, null, null, "POST", paramString2, 20000, parama);
  }
  
  e(Context paramContext, String paramString1, String paramString2, HashMap<String, String> paramHashMap, String paramString3, String paramString4, int paramInt, a parama)
  {
    this.f = paramContext;
    this.i = paramString2;
    this.j = paramHashMap;
    this.h = paramString3;
    this.l = paramString4;
    this.m = paramInt;
    this.n = parama;
    for (;;)
    {
      try
      {
        if (this.h == null) {
          this.h = "GET";
        }
        if ((paramString1 == null) || (paramString1.length() == 0)) {
          continue;
        }
        if ((!this.h.equals("GET")) || (paramString4 == null)) {
          continue;
        }
        if (paramString1.indexOf("?") != -1) {
          continue;
        }
        paramString2 = new java/net/URL;
        paramContext = new java/lang/StringBuilder;
        paramContext.<init>();
        paramString2.<init>(paramString1 + "?" + paramString4);
        this.g = paramString2;
      }
      catch (MalformedURLException paramContext)
      {
        d.e("Invalid URL string:" + paramString1 + ". Failed to init connector.");
        continue;
        paramContext = new java/net/URL;
        paramContext.<init>(paramString1);
        this.g = paramContext;
        continue;
        d.e("Request URL is null or empty.");
        continue;
      }
      if (this.l != null) {
        this.o = "application/x-www-form-urlencoded";
      }
      h();
      return;
      paramContext = new java/net/URL;
      paramString2 = new java/lang/StringBuilder;
      paramString2.<init>();
      paramContext.<init>(paramString1 + "&" + paramString4);
      this.g = paramContext;
    }
  }
  
  private final void a(String paramString, int paramInt)
  {
    d.b(this, "setProxy -- proxy:" + paramString + "| port:" + paramInt);
    this.k = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString, paramInt));
  }
  
  private void h()
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      Object localObject3 = null;
      Object localObject1 = null;
      try
      {
        Cursor localCursor = f.z(this.f);
        if (localCursor != null)
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          if (localCursor.getCount() > 0)
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            localCursor.moveToFirst();
            localObject1 = localCursor;
            localObject3 = localCursor;
            String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("proxy"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            int i1 = localCursor.getInt(localCursor.getColumnIndexOrThrow("port"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("apn"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            m localm = d;
            localObject1 = localCursor;
            localObject3 = localCursor;
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localObject1 = localCursor;
            localObject3 = localCursor;
            localStringBuilder.<init>();
            localObject1 = localCursor;
            localObject3 = localCursor;
            localm.b(this, "Current apnType is " + str1);
            localObject1 = localCursor;
            localObject3 = localCursor;
            localm = d;
            localObject1 = localCursor;
            localObject3 = localCursor;
            localStringBuilder = new java/lang/StringBuilder;
            localObject1 = localCursor;
            localObject3 = localCursor;
            localStringBuilder.<init>();
            localObject1 = localCursor;
            localObject3 = localCursor;
            localm.b(this, "proxy:" + str2 + "| port:" + i1);
            if (str2 != null)
            {
              localObject1 = localCursor;
              localObject3 = localCursor;
              if ((!str2.trim().equals("")) && (i1 != 0))
              {
                localObject1 = localCursor;
                localObject3 = localCursor;
                if (!str1.equalsIgnoreCase("ctwap"))
                {
                  localObject1 = localCursor;
                  localObject3 = localCursor;
                  d.b(this, "ad request use proxy");
                  localObject1 = localCursor;
                  localObject3 = localCursor;
                  a(str2, i1);
                }
              }
            }
          }
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject3 = localObject1;
        d.e(this, "获取APN失败。");
        localObject3 = localObject1;
        d.a(localIllegalArgumentException);
        if (localObject1 == null) {
          continue;
        }
        ((Cursor)localObject1).close();
      }
      finally
      {
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
      }
    }
  }
  
  protected String a()
  {
    return this.p;
  }
  
  protected void a(String paramString)
  {
    this.p = paramString;
  }
  
  protected void b()
  {
    d.a(this, "Do HTTP connection.");
    new Thread(this).start();
  }
  
  /* Error */
  protected void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 119	cn/domob/android/offerwall/e:g	Ljava/net/URL;
    //   14: ifnull +847 -> 861
    //   17: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   20: astore 7
    //   22: new 108	java/lang/StringBuilder
    //   25: astore 6
    //   27: aload 6
    //   29: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   32: aload 7
    //   34: aload 6
    //   36: ldc -10
    //   38: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 119	cn/domob/android/offerwall/e:g	Ljava/net/URL;
    //   45: invokevirtual 247	java/net/URL:toString	()Ljava/lang/String;
    //   48: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 249	cn/domob/android/offerwall/m:b	(Ljava/lang/String;)V
    //   57: iconst_1
    //   58: invokestatic 255	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   61: aload_0
    //   62: getfield 165	cn/domob/android/offerwall/e:k	Ljava/net/Proxy;
    //   65: ifnull +213 -> 278
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 119	cn/domob/android/offerwall/e:g	Ljava/net/URL;
    //   73: aload_0
    //   74: getfield 165	cn/domob/android/offerwall/e:k	Ljava/net/Proxy;
    //   77: invokevirtual 259	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   80: checkcast 251	java/net/HttpURLConnection
    //   83: putfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   86: aload_0
    //   87: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   90: ifnull +771 -> 861
    //   93: aload_0
    //   94: getfield 78	cn/domob/android/offerwall/e:i	Ljava/lang/String;
    //   97: ifnull +27 -> 124
    //   100: aload_0
    //   101: getfield 78	cn/domob/android/offerwall/e:i	Ljava/lang/String;
    //   104: invokevirtual 94	java/lang/String:length	()I
    //   107: ifeq +17 -> 124
    //   110: aload_0
    //   111: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   114: ldc_w 263
    //   117: aload_0
    //   118: getfield 78	cn/domob/android/offerwall/e:i	Ljava/lang/String;
    //   121: invokevirtual 267	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   128: iconst_1
    //   129: invokevirtual 270	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   132: aload_0
    //   133: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   136: aload_0
    //   137: getfield 86	cn/domob/android/offerwall/e:m	I
    //   140: invokevirtual 274	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   143: aload_0
    //   144: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   147: aload_0
    //   148: getfield 86	cn/domob/android/offerwall/e:m	I
    //   151: invokevirtual 277	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   154: aload_0
    //   155: getfield 80	cn/domob/android/offerwall/e:j	Ljava/util/HashMap;
    //   158: ifnull +160 -> 318
    //   161: aload_0
    //   162: getfield 80	cn/domob/android/offerwall/e:j	Ljava/util/HashMap;
    //   165: invokevirtual 283	java/util/HashMap:keySet	()Ljava/util/Set;
    //   168: invokeinterface 289 1 0
    //   173: astore_2
    //   174: aload_2
    //   175: invokeinterface 294 1 0
    //   180: ifeq +138 -> 318
    //   183: aload_2
    //   184: invokeinterface 298 1 0
    //   189: checkcast 90	java/lang/String
    //   192: astore 7
    //   194: aload_0
    //   195: getfield 80	cn/domob/android/offerwall/e:j	Ljava/util/HashMap;
    //   198: aload 7
    //   200: invokevirtual 302	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   203: checkcast 90	java/lang/String
    //   206: astore 6
    //   208: aload 6
    //   210: ifnull -36 -> 174
    //   213: aload_0
    //   214: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   217: aload 7
    //   219: aload 6
    //   221: invokevirtual 305	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: goto -50 -> 174
    //   227: astore 4
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: astore 5
    //   234: aload_3
    //   235: astore 6
    //   237: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   240: aload_0
    //   241: ldc_w 307
    //   244: invokevirtual 223	cn/domob/android/offerwall/m:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   247: aload_2
    //   248: astore 5
    //   250: aload_3
    //   251: astore 6
    //   253: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   256: aload 4
    //   258: invokevirtual 226	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   261: aload_3
    //   262: ifnull +7 -> 269
    //   265: aload_3
    //   266: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 313	java/io/ByteArrayOutputStream:close	()V
    //   277: return
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 119	cn/domob/android/offerwall/e:g	Ljava/net/URL;
    //   283: invokevirtual 316	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   286: checkcast 251	java/net/HttpURLConnection
    //   289: putfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   292: goto -206 -> 86
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_2
    //   298: aload_2
    //   299: ifnull +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   306: aload 4
    //   308: ifnull +8 -> 316
    //   311: aload 4
    //   313: invokevirtual 313	java/io/ByteArrayOutputStream:close	()V
    //   316: aload_3
    //   317: athrow
    //   318: aload_0
    //   319: getfield 82	cn/domob/android/offerwall/e:h	Ljava/lang/String;
    //   322: ldc 15
    //   324: invokevirtual 98	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +206 -> 533
    //   330: aload_0
    //   331: getfield 84	cn/domob/android/offerwall/e:l	Ljava/lang/String;
    //   334: ifnull +199 -> 533
    //   337: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   340: ldc_w 318
    //   343: invokevirtual 249	cn/domob/android/offerwall/m:b	(Ljava/lang/String;)V
    //   346: aload_0
    //   347: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   350: ldc 15
    //   352: invokevirtual 321	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   355: aload_0
    //   356: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   359: iconst_1
    //   360: invokevirtual 324	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   363: aload_0
    //   364: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   367: ldc_w 326
    //   370: aload_0
    //   371: getfield 123	cn/domob/android/offerwall/e:o	Ljava/lang/String;
    //   374: invokevirtual 267	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   381: ldc_w 328
    //   384: aload_0
    //   385: getfield 84	cn/domob/android/offerwall/e:l	Ljava/lang/String;
    //   388: invokevirtual 94	java/lang/String:length	()I
    //   391: invokestatic 331	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   394: invokevirtual 267	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_0
    //   398: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   401: invokevirtual 335	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   404: astore_2
    //   405: new 337	java/io/BufferedWriter
    //   408: astore 6
    //   410: new 339	java/io/OutputStreamWriter
    //   413: astore 7
    //   415: aload 7
    //   417: aload_2
    //   418: invokespecial 342	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   421: aload 6
    //   423: aload 7
    //   425: sipush 4096
    //   428: invokespecial 345	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   431: aload 6
    //   433: ifnull +26 -> 459
    //   436: aload 6
    //   438: aload_0
    //   439: getfield 84	cn/domob/android/offerwall/e:l	Ljava/lang/String;
    //   442: invokevirtual 348	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   445: aload 6
    //   447: invokevirtual 351	java/io/BufferedWriter:flush	()V
    //   450: aload 6
    //   452: invokevirtual 352	java/io/BufferedWriter:close	()V
    //   455: aload_2
    //   456: invokevirtual 355	java/io/OutputStream:close	()V
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   464: invokevirtual 358	java/net/HttpURLConnection:getResponseCode	()I
    //   467: putfield 360	cn/domob/android/offerwall/e:q	I
    //   470: aload_0
    //   471: getfield 360	cn/domob/android/offerwall/e:q	I
    //   474: sipush 301
    //   477: if_icmpeq +13 -> 490
    //   480: aload_0
    //   481: getfield 360	cn/domob/android/offerwall/e:q	I
    //   484: sipush 302
    //   487: if_icmpne +65 -> 552
    //   490: new 106	java/net/URL
    //   493: astore_2
    //   494: aload_2
    //   495: aload_0
    //   496: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   499: ldc_w 362
    //   502: invokevirtual 366	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   505: invokespecial 117	java/net/URL:<init>	(Ljava/lang/String;)V
    //   508: aload_0
    //   509: aload_2
    //   510: invokevirtual 316	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   513: checkcast 251	java/net/HttpURLConnection
    //   516: putfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   519: aload_0
    //   520: aload_0
    //   521: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   524: invokevirtual 358	java/net/HttpURLConnection:getResponseCode	()I
    //   527: putfield 360	cn/domob/android/offerwall/e:q	I
    //   530: goto -60 -> 470
    //   533: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   536: ldc_w 368
    //   539: invokevirtual 249	cn/domob/android/offerwall/m:b	(Ljava/lang/String;)V
    //   542: aload_0
    //   543: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   546: invokevirtual 371	java/net/HttpURLConnection:connect	()V
    //   549: goto -90 -> 459
    //   552: aload_0
    //   553: getfield 360	cn/domob/android/offerwall/e:q	I
    //   556: sipush 200
    //   559: if_icmplt +294 -> 853
    //   562: aload_0
    //   563: getfield 360	cn/domob/android/offerwall/e:q	I
    //   566: sipush 304
    //   569: if_icmpgt +284 -> 853
    //   572: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   575: astore_2
    //   576: new 108	java/lang/StringBuilder
    //   579: astore 5
    //   581: aload 5
    //   583: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   586: aload_2
    //   587: aload 5
    //   589: ldc_w 373
    //   592: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_0
    //   596: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   599: invokevirtual 377	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   602: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   605: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   608: invokevirtual 249	cn/domob/android/offerwall/m:b	(Ljava/lang/String;)V
    //   611: new 309	java/io/BufferedInputStream
    //   614: dup
    //   615: aload_0
    //   616: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   619: invokevirtual 384	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   622: sipush 4096
    //   625: invokespecial 387	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   628: astore_2
    //   629: sipush 4096
    //   632: newarray <illegal type>
    //   634: astore_3
    //   635: new 312	java/io/ByteArrayOutputStream
    //   638: astore 5
    //   640: aload 5
    //   642: sipush 4096
    //   645: invokespecial 389	java/io/ByteArrayOutputStream:<init>	(I)V
    //   648: aload_2
    //   649: aload_3
    //   650: invokevirtual 393	java/io/BufferedInputStream:read	([B)I
    //   653: istore_1
    //   654: iload_1
    //   655: iconst_m1
    //   656: if_icmpeq +24 -> 680
    //   659: aload 5
    //   661: aload_3
    //   662: iconst_0
    //   663: iload_1
    //   664: invokevirtual 396	java/io/ByteArrayOutputStream:write	([BII)V
    //   667: goto -19 -> 648
    //   670: astore 4
    //   672: aload_2
    //   673: astore_3
    //   674: aload 5
    //   676: astore_2
    //   677: goto -446 -> 231
    //   680: aload_0
    //   681: aload 5
    //   683: invokevirtual 400	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   686: putfield 402	cn/domob/android/offerwall/e:s	[B
    //   689: new 90	java/lang/String
    //   692: astore_3
    //   693: aload_3
    //   694: aload_0
    //   695: getfield 402	cn/domob/android/offerwall/e:s	[B
    //   698: ldc_w 404
    //   701: invokespecial 407	java/lang/String:<init>	([BLjava/lang/String;)V
    //   704: aload_0
    //   705: aload_3
    //   706: putfield 409	cn/domob/android/offerwall/e:r	Ljava/lang/String;
    //   709: aload_2
    //   710: astore_3
    //   711: aload 5
    //   713: astore_2
    //   714: aload_2
    //   715: astore 5
    //   717: aload_3
    //   718: astore 6
    //   720: aload_0
    //   721: getfield 261	cn/domob/android/offerwall/e:e	Ljava/net/HttpURLConnection;
    //   724: invokevirtual 412	java/net/HttpURLConnection:disconnect	()V
    //   727: aload_3
    //   728: ifnull +7 -> 735
    //   731: aload_3
    //   732: invokevirtual 310	java/io/BufferedInputStream:close	()V
    //   735: aload_2
    //   736: ifnull -459 -> 277
    //   739: aload_2
    //   740: invokevirtual 313	java/io/ByteArrayOutputStream:close	()V
    //   743: goto -466 -> 277
    //   746: astore_2
    //   747: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   750: aload_2
    //   751: invokevirtual 226	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   754: goto -477 -> 277
    //   757: astore_3
    //   758: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   761: aload_3
    //   762: invokevirtual 226	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   765: goto -30 -> 735
    //   768: astore_3
    //   769: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   772: aload_3
    //   773: invokevirtual 226	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   776: goto -507 -> 269
    //   779: astore_2
    //   780: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   783: aload_2
    //   784: invokevirtual 226	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   787: goto -510 -> 277
    //   790: astore_2
    //   791: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   794: aload_2
    //   795: invokevirtual 226	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   798: goto -492 -> 306
    //   801: astore_2
    //   802: getstatic 64	cn/domob/android/offerwall/e:d	Lcn/domob/android/offerwall/m;
    //   805: aload_2
    //   806: invokevirtual 226	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   809: goto -493 -> 316
    //   812: astore_3
    //   813: goto -515 -> 298
    //   816: astore_3
    //   817: aload 5
    //   819: astore 4
    //   821: goto -523 -> 298
    //   824: astore_3
    //   825: aload 6
    //   827: astore_2
    //   828: aload 5
    //   830: astore 4
    //   832: goto -534 -> 298
    //   835: astore 4
    //   837: aconst_null
    //   838: astore 5
    //   840: aload_2
    //   841: astore_3
    //   842: aload 5
    //   844: astore_2
    //   845: goto -614 -> 231
    //   848: astore 4
    //   850: goto -619 -> 231
    //   853: aconst_null
    //   854: astore_2
    //   855: aload 5
    //   857: astore_3
    //   858: goto -144 -> 714
    //   861: aconst_null
    //   862: astore_3
    //   863: goto -136 -> 727
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	866	0	this	e
    //   653	11	1	i1	int
    //   7	733	2	localObject1	Object
    //   746	5	2	localIOException1	java.io.IOException
    //   779	5	2	localIOException2	java.io.IOException
    //   790	5	2	localIOException3	java.io.IOException
    //   801	5	2	localIOException4	java.io.IOException
    //   827	28	2	localObject2	Object
    //   9	257	3	localObject3	Object
    //   295	22	3	localObject4	Object
    //   634	98	3	localObject5	Object
    //   757	5	3	localIOException5	java.io.IOException
    //   768	5	3	localIOException6	java.io.IOException
    //   812	1	3	localObject6	Object
    //   816	1	3	localObject7	Object
    //   824	1	3	localObject8	Object
    //   841	22	3	localObject9	Object
    //   1	1	4	localObject10	Object
    //   227	85	4	localException1	Exception
    //   670	1	4	localException2	Exception
    //   819	12	4	localObject11	Object
    //   835	1	4	localException3	Exception
    //   848	1	4	localException4	Exception
    //   4	852	5	localObject12	Object
    //   25	801	6	localObject13	Object
    //   20	404	7	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   10	86	227	java/lang/Exception
    //   86	124	227	java/lang/Exception
    //   124	174	227	java/lang/Exception
    //   174	208	227	java/lang/Exception
    //   213	224	227	java/lang/Exception
    //   278	292	227	java/lang/Exception
    //   318	431	227	java/lang/Exception
    //   436	459	227	java/lang/Exception
    //   459	470	227	java/lang/Exception
    //   470	490	227	java/lang/Exception
    //   490	530	227	java/lang/Exception
    //   533	549	227	java/lang/Exception
    //   552	629	227	java/lang/Exception
    //   10	86	295	finally
    //   86	124	295	finally
    //   124	174	295	finally
    //   174	208	295	finally
    //   213	224	295	finally
    //   278	292	295	finally
    //   318	431	295	finally
    //   436	459	295	finally
    //   459	470	295	finally
    //   470	490	295	finally
    //   490	530	295	finally
    //   533	549	295	finally
    //   552	629	295	finally
    //   648	654	670	java/lang/Exception
    //   659	667	670	java/lang/Exception
    //   680	709	670	java/lang/Exception
    //   739	743	746	java/io/IOException
    //   731	735	757	java/io/IOException
    //   265	269	768	java/io/IOException
    //   273	277	779	java/io/IOException
    //   302	306	790	java/io/IOException
    //   311	316	801	java/io/IOException
    //   629	648	812	finally
    //   648	654	816	finally
    //   659	667	816	finally
    //   680	709	816	finally
    //   237	247	824	finally
    //   253	261	824	finally
    //   720	727	824	finally
    //   629	648	835	java/lang/Exception
    //   720	727	848	java/lang/Exception
  }
  
  protected byte[] d()
  {
    return this.s;
  }
  
  protected String e()
  {
    return this.r;
  }
  
  protected int f()
  {
    return this.q;
  }
  
  protected String g()
  {
    return this.l;
  }
  
  public void run()
  {
    c();
    if (this.n != null) {
      this.n.a(this);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(e parame);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */