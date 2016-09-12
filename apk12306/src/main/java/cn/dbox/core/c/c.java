package cn.dbox.core.c;

import android.content.Context;
import android.database.Cursor;
import cn.dbox.core.h.b;
import cn.dbox.core.h.d;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;

public class c
  implements Runnable
{
  public static final String a = "GET";
  public static final String b = "POST";
  public static final int c = 20000;
  private static d d = new d(c.class.getSimpleName());
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
  
  public c(Context paramContext, String paramString, a parama)
  {
    this(paramContext, paramString, null, null, "GET", null, 20000, parama);
  }
  
  public c(Context paramContext, String paramString1, String paramString2, a parama)
  {
    this(paramContext, paramString1, null, null, "POST", paramString2, 20000, parama);
  }
  
  public c(Context paramContext, String paramString1, String paramString2, HashMap<String, String> paramHashMap, String paramString3, String paramString4, int paramInt, a parama)
  {
    this.f = paramContext;
    this.i = paramString2;
    this.j = paramHashMap;
    this.h = paramString3;
    this.l = paramString4;
    this.m = paramInt;
    this.n = parama;
    if (this.f == null) {}
    try
    {
      if (this.h == null) {
        this.h = "GET";
      }
      if ((paramString1 == null) || (paramString1.length() == 0)) {
        break label252;
      }
      if ((!this.h.equals("GET")) || (paramString4 == null)) {
        break label235;
      }
      if (paramString1.indexOf("?") != -1) {
        break label159;
      }
      paramContext = new java/net/URL;
      paramString2 = new java/lang/StringBuilder;
      paramString2.<init>();
      paramContext.<init>(paramString1 + "?" + paramString4);
      this.g = paramContext;
    }
    catch (MalformedURLException paramContext)
    {
      try
      {
        for (;;)
        {
          h();
          return;
          paramString2 = new java/net/URL;
          paramContext = new java/lang/StringBuilder;
          paramContext.<init>();
          paramString2.<init>(paramString1 + "&" + paramString4);
          this.g = paramString2;
          continue;
          paramContext = paramContext;
          d.e("Invalid URL string:" + paramString1 + ". Failed to init connector.");
          continue;
          paramContext = new java/net/URL;
          paramContext.<init>(paramString1);
          this.g = paramContext;
        }
        d.e("Request URL is null or empty.");
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          d.b("get error when dealing with apn");
          d.a(paramContext);
        }
      }
      catch (Error paramContext)
      {
        for (;;)
        {
          d.b("get error when dealing with apn");
          d.a(paramContext);
        }
      }
    }
    if (this.l != null) {
      this.o = "application/x-www-form-urlencoded";
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
        Cursor localCursor = b.t(this.f);
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
            d locald = d;
            localObject1 = localCursor;
            localObject3 = localCursor;
            StringBuilder localStringBuilder = new java/lang/StringBuilder;
            localObject1 = localCursor;
            localObject3 = localCursor;
            localStringBuilder.<init>();
            localObject1 = localCursor;
            localObject3 = localCursor;
            locald.b(this, "Current apnType is " + str1);
            localObject1 = localCursor;
            localObject3 = localCursor;
            locald = d;
            localObject1 = localCursor;
            localObject3 = localCursor;
            localStringBuilder = new java/lang/StringBuilder;
            localObject1 = localCursor;
            localObject3 = localCursor;
            localStringBuilder.<init>();
            localObject1 = localCursor;
            localObject3 = localCursor;
            locald.b(this, "proxy:" + str2 + "| port:" + i1);
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
        d.e(this, "获取APN失败");
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
  
  public String a()
  {
    return this.p;
  }
  
  public void a(String paramString)
  {
    this.p = paramString;
  }
  
  public void b()
  {
    d.a(this, "Do HTTP connection.");
    new Thread(this).start();
  }
  
  /* Error */
  public void c()
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
    //   11: getfield 123	cn/dbox/core/c/c:g	Ljava/net/URL;
    //   14: ifnull +851 -> 865
    //   17: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   20: astore 7
    //   22: new 112	java/lang/StringBuilder
    //   25: astore 6
    //   27: aload 6
    //   29: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   32: aload 7
    //   34: aload 6
    //   36: ldc -5
    //   38: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 123	cn/dbox/core/c/c:g	Ljava/net/URL;
    //   45: invokevirtual 252	java/net/URL:toString	()Ljava/lang/String;
    //   48: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 143	cn/dbox/core/h/d:b	(Ljava/lang/String;)V
    //   57: iconst_1
    //   58: invokestatic 258	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   61: aload_0
    //   62: getfield 176	cn/dbox/core/c/c:k	Ljava/net/Proxy;
    //   65: ifnull +213 -> 278
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 123	cn/dbox/core/c/c:g	Ljava/net/URL;
    //   73: aload_0
    //   74: getfield 176	cn/dbox/core/c/c:k	Ljava/net/Proxy;
    //   77: invokevirtual 262	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   80: checkcast 254	java/net/HttpURLConnection
    //   83: putfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   86: aload_0
    //   87: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   90: ifnull +775 -> 865
    //   93: aload_0
    //   94: getfield 82	cn/dbox/core/c/c:i	Ljava/lang/String;
    //   97: ifnull +27 -> 124
    //   100: aload_0
    //   101: getfield 82	cn/dbox/core/c/c:i	Ljava/lang/String;
    //   104: invokevirtual 98	java/lang/String:length	()I
    //   107: ifeq +17 -> 124
    //   110: aload_0
    //   111: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   114: ldc_w 266
    //   117: aload_0
    //   118: getfield 82	cn/dbox/core/c/c:i	Ljava/lang/String;
    //   121: invokevirtual 270	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   128: iconst_0
    //   129: invokevirtual 273	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   132: aload_0
    //   133: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   136: aload_0
    //   137: getfield 90	cn/dbox/core/c/c:m	I
    //   140: invokevirtual 277	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   143: aload_0
    //   144: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   147: aload_0
    //   148: getfield 90	cn/dbox/core/c/c:m	I
    //   151: invokevirtual 280	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   154: aload_0
    //   155: getfield 84	cn/dbox/core/c/c:j	Ljava/util/HashMap;
    //   158: ifnull +160 -> 318
    //   161: aload_0
    //   162: getfield 84	cn/dbox/core/c/c:j	Ljava/util/HashMap;
    //   165: invokevirtual 286	java/util/HashMap:keySet	()Ljava/util/Set;
    //   168: invokeinterface 292 1 0
    //   173: astore 6
    //   175: aload 6
    //   177: invokeinterface 297 1 0
    //   182: ifeq +136 -> 318
    //   185: aload 6
    //   187: invokeinterface 301 1 0
    //   192: checkcast 94	java/lang/String
    //   195: astore 7
    //   197: aload_0
    //   198: getfield 84	cn/dbox/core/c/c:j	Ljava/util/HashMap;
    //   201: aload 7
    //   203: invokevirtual 305	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   206: checkcast 94	java/lang/String
    //   209: astore_2
    //   210: aload_2
    //   211: ifnull -36 -> 175
    //   214: aload_0
    //   215: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   218: aload 7
    //   220: aload_2
    //   221: invokevirtual 308	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: goto -49 -> 175
    //   227: astore 4
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: astore 5
    //   234: aload_3
    //   235: astore 6
    //   237: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   240: aload_0
    //   241: ldc_w 310
    //   244: invokevirtual 233	cn/dbox/core/h/d:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   247: aload_2
    //   248: astore 5
    //   250: aload_3
    //   251: astore 6
    //   253: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   256: aload 4
    //   258: invokevirtual 146	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   261: aload_3
    //   262: ifnull +7 -> 269
    //   265: aload_3
    //   266: invokevirtual 313	java/io/BufferedInputStream:close	()V
    //   269: aload_2
    //   270: ifnull +7 -> 277
    //   273: aload_2
    //   274: invokevirtual 316	java/io/ByteArrayOutputStream:close	()V
    //   277: return
    //   278: aload_0
    //   279: aload_0
    //   280: getfield 123	cn/dbox/core/c/c:g	Ljava/net/URL;
    //   283: invokevirtual 319	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   286: checkcast 254	java/net/HttpURLConnection
    //   289: putfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   292: goto -206 -> 86
    //   295: astore_3
    //   296: aconst_null
    //   297: astore_2
    //   298: aload_2
    //   299: ifnull +7 -> 306
    //   302: aload_2
    //   303: invokevirtual 313	java/io/BufferedInputStream:close	()V
    //   306: aload 4
    //   308: ifnull +8 -> 316
    //   311: aload 4
    //   313: invokevirtual 316	java/io/ByteArrayOutputStream:close	()V
    //   316: aload_3
    //   317: athrow
    //   318: aload_0
    //   319: getfield 86	cn/dbox/core/c/c:h	Ljava/lang/String;
    //   322: ldc 15
    //   324: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +211 -> 538
    //   330: aload_0
    //   331: getfield 88	cn/dbox/core/c/c:l	Ljava/lang/String;
    //   334: ifnull +204 -> 538
    //   337: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   340: ldc_w 321
    //   343: invokevirtual 143	cn/dbox/core/h/d:b	(Ljava/lang/String;)V
    //   346: aload_0
    //   347: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   350: ldc 15
    //   352: invokevirtual 324	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   355: aload_0
    //   356: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   359: iconst_1
    //   360: invokevirtual 327	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   363: aload_0
    //   364: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   367: ldc_w 329
    //   370: aload_0
    //   371: getfield 127	cn/dbox/core/c/c:o	Ljava/lang/String;
    //   374: invokevirtual 270	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   381: ldc_w 331
    //   384: aload_0
    //   385: getfield 88	cn/dbox/core/c/c:l	Ljava/lang/String;
    //   388: invokevirtual 98	java/lang/String:length	()I
    //   391: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   394: invokevirtual 270	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_0
    //   398: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   401: invokevirtual 338	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   404: astore 7
    //   406: new 340	java/io/BufferedWriter
    //   409: astore_2
    //   410: new 342	java/io/OutputStreamWriter
    //   413: astore 6
    //   415: aload 6
    //   417: aload 7
    //   419: invokespecial 345	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   422: aload_2
    //   423: aload 6
    //   425: sipush 4096
    //   428: invokespecial 348	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   431: aload_2
    //   432: ifnull +24 -> 456
    //   435: aload_2
    //   436: aload_0
    //   437: getfield 88	cn/dbox/core/c/c:l	Ljava/lang/String;
    //   440: invokevirtual 351	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   443: aload_2
    //   444: invokevirtual 354	java/io/BufferedWriter:flush	()V
    //   447: aload_2
    //   448: invokevirtual 355	java/io/BufferedWriter:close	()V
    //   451: aload 7
    //   453: invokevirtual 358	java/io/OutputStream:close	()V
    //   456: aload_0
    //   457: aload_0
    //   458: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   461: invokevirtual 361	java/net/HttpURLConnection:getResponseCode	()I
    //   464: putfield 363	cn/dbox/core/c/c:q	I
    //   467: aload_0
    //   468: getfield 363	cn/dbox/core/c/c:q	I
    //   471: sipush 301
    //   474: if_icmpeq +13 -> 487
    //   477: aload_0
    //   478: getfield 363	cn/dbox/core/c/c:q	I
    //   481: sipush 302
    //   484: if_icmpne +73 -> 557
    //   487: new 110	java/net/URL
    //   490: astore_2
    //   491: aload_2
    //   492: aload_0
    //   493: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   496: ldc_w 365
    //   499: invokevirtual 369	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   502: invokespecial 121	java/net/URL:<init>	(Ljava/lang/String;)V
    //   505: aload_0
    //   506: aload_2
    //   507: invokevirtual 319	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   510: checkcast 254	java/net/HttpURLConnection
    //   513: putfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   516: aload_0
    //   517: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   520: iconst_0
    //   521: invokevirtual 273	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   524: aload_0
    //   525: aload_0
    //   526: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   529: invokevirtual 361	java/net/HttpURLConnection:getResponseCode	()I
    //   532: putfield 363	cn/dbox/core/c/c:q	I
    //   535: goto -68 -> 467
    //   538: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   541: ldc_w 371
    //   544: invokevirtual 143	cn/dbox/core/h/d:b	(Ljava/lang/String;)V
    //   547: aload_0
    //   548: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   551: invokevirtual 374	java/net/HttpURLConnection:connect	()V
    //   554: goto -98 -> 456
    //   557: aload_0
    //   558: getfield 363	cn/dbox/core/c/c:q	I
    //   561: sipush 200
    //   564: if_icmplt +293 -> 857
    //   567: aload_0
    //   568: getfield 363	cn/dbox/core/c/c:q	I
    //   571: sipush 304
    //   574: if_icmpgt +283 -> 857
    //   577: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   580: astore 5
    //   582: new 112	java/lang/StringBuilder
    //   585: astore_2
    //   586: aload_2
    //   587: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   590: aload 5
    //   592: aload_2
    //   593: ldc_w 376
    //   596: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_0
    //   600: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   603: invokevirtual 380	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   606: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   609: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokevirtual 143	cn/dbox/core/h/d:b	(Ljava/lang/String;)V
    //   615: new 312	java/io/BufferedInputStream
    //   618: dup
    //   619: aload_0
    //   620: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   623: invokevirtual 387	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   626: sipush 4096
    //   629: invokespecial 390	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   632: astore_2
    //   633: sipush 4096
    //   636: newarray <illegal type>
    //   638: astore_3
    //   639: new 315	java/io/ByteArrayOutputStream
    //   642: astore 5
    //   644: aload 5
    //   646: sipush 4096
    //   649: invokespecial 392	java/io/ByteArrayOutputStream:<init>	(I)V
    //   652: aload_2
    //   653: aload_3
    //   654: invokevirtual 396	java/io/BufferedInputStream:read	([B)I
    //   657: istore_1
    //   658: iload_1
    //   659: iconst_m1
    //   660: if_icmpeq +24 -> 684
    //   663: aload 5
    //   665: aload_3
    //   666: iconst_0
    //   667: iload_1
    //   668: invokevirtual 399	java/io/ByteArrayOutputStream:write	([BII)V
    //   671: goto -19 -> 652
    //   674: astore 4
    //   676: aload_2
    //   677: astore_3
    //   678: aload 5
    //   680: astore_2
    //   681: goto -450 -> 231
    //   684: aload_0
    //   685: aload 5
    //   687: invokevirtual 403	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   690: putfield 405	cn/dbox/core/c/c:s	[B
    //   693: new 94	java/lang/String
    //   696: astore_3
    //   697: aload_3
    //   698: aload_0
    //   699: getfield 405	cn/dbox/core/c/c:s	[B
    //   702: ldc_w 407
    //   705: invokespecial 410	java/lang/String:<init>	([BLjava/lang/String;)V
    //   708: aload_0
    //   709: aload_3
    //   710: putfield 412	cn/dbox/core/c/c:r	Ljava/lang/String;
    //   713: aload_2
    //   714: astore_3
    //   715: aload 5
    //   717: astore_2
    //   718: aload_2
    //   719: astore 5
    //   721: aload_3
    //   722: astore 6
    //   724: aload_0
    //   725: getfield 264	cn/dbox/core/c/c:e	Ljava/net/HttpURLConnection;
    //   728: invokevirtual 415	java/net/HttpURLConnection:disconnect	()V
    //   731: aload_3
    //   732: ifnull +7 -> 739
    //   735: aload_3
    //   736: invokevirtual 313	java/io/BufferedInputStream:close	()V
    //   739: aload_2
    //   740: ifnull -463 -> 277
    //   743: aload_2
    //   744: invokevirtual 316	java/io/ByteArrayOutputStream:close	()V
    //   747: goto -470 -> 277
    //   750: astore_2
    //   751: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   754: aload_2
    //   755: invokevirtual 146	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   758: goto -481 -> 277
    //   761: astore_3
    //   762: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   765: aload_3
    //   766: invokevirtual 146	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   769: goto -30 -> 739
    //   772: astore_3
    //   773: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   776: aload_3
    //   777: invokevirtual 146	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   780: goto -511 -> 269
    //   783: astore_2
    //   784: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   787: aload_2
    //   788: invokevirtual 146	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   791: goto -514 -> 277
    //   794: astore_2
    //   795: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   798: aload_2
    //   799: invokevirtual 146	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   802: goto -496 -> 306
    //   805: astore_2
    //   806: getstatic 64	cn/dbox/core/c/c:d	Lcn/dbox/core/h/d;
    //   809: aload_2
    //   810: invokevirtual 146	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   813: goto -497 -> 316
    //   816: astore_3
    //   817: goto -519 -> 298
    //   820: astore_3
    //   821: aload 5
    //   823: astore 4
    //   825: goto -527 -> 298
    //   828: astore_3
    //   829: aload 6
    //   831: astore_2
    //   832: aload 5
    //   834: astore 4
    //   836: goto -538 -> 298
    //   839: astore 4
    //   841: aconst_null
    //   842: astore 5
    //   844: aload_2
    //   845: astore_3
    //   846: aload 5
    //   848: astore_2
    //   849: goto -618 -> 231
    //   852: astore 4
    //   854: goto -623 -> 231
    //   857: aconst_null
    //   858: astore_2
    //   859: aload 5
    //   861: astore_3
    //   862: goto -144 -> 718
    //   865: aconst_null
    //   866: astore_3
    //   867: goto -136 -> 731
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	c
    //   657	11	1	i1	int
    //   7	737	2	localObject1	Object
    //   750	5	2	localIOException1	java.io.IOException
    //   783	5	2	localIOException2	java.io.IOException
    //   794	5	2	localIOException3	java.io.IOException
    //   805	5	2	localIOException4	java.io.IOException
    //   831	28	2	localObject2	Object
    //   9	257	3	localObject3	Object
    //   295	22	3	localObject4	Object
    //   638	98	3	localObject5	Object
    //   761	5	3	localIOException5	java.io.IOException
    //   772	5	3	localIOException6	java.io.IOException
    //   816	1	3	localObject6	Object
    //   820	1	3	localObject7	Object
    //   828	1	3	localObject8	Object
    //   845	22	3	localObject9	Object
    //   1	1	4	localObject10	Object
    //   227	85	4	localException1	Exception
    //   674	1	4	localException2	Exception
    //   823	12	4	localObject11	Object
    //   839	1	4	localException3	Exception
    //   852	1	4	localException4	Exception
    //   4	856	5	localObject12	Object
    //   25	805	6	localObject13	Object
    //   20	432	7	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   10	86	227	java/lang/Exception
    //   86	124	227	java/lang/Exception
    //   124	175	227	java/lang/Exception
    //   175	210	227	java/lang/Exception
    //   214	224	227	java/lang/Exception
    //   278	292	227	java/lang/Exception
    //   318	431	227	java/lang/Exception
    //   435	456	227	java/lang/Exception
    //   456	467	227	java/lang/Exception
    //   467	487	227	java/lang/Exception
    //   487	535	227	java/lang/Exception
    //   538	554	227	java/lang/Exception
    //   557	633	227	java/lang/Exception
    //   10	86	295	finally
    //   86	124	295	finally
    //   124	175	295	finally
    //   175	210	295	finally
    //   214	224	295	finally
    //   278	292	295	finally
    //   318	431	295	finally
    //   435	456	295	finally
    //   456	467	295	finally
    //   467	487	295	finally
    //   487	535	295	finally
    //   538	554	295	finally
    //   557	633	295	finally
    //   652	658	674	java/lang/Exception
    //   663	671	674	java/lang/Exception
    //   684	713	674	java/lang/Exception
    //   743	747	750	java/io/IOException
    //   735	739	761	java/io/IOException
    //   265	269	772	java/io/IOException
    //   273	277	783	java/io/IOException
    //   302	306	794	java/io/IOException
    //   311	316	805	java/io/IOException
    //   633	652	816	finally
    //   652	658	820	finally
    //   663	671	820	finally
    //   684	713	820	finally
    //   237	247	828	finally
    //   253	261	828	finally
    //   724	731	828	finally
    //   633	652	839	java/lang/Exception
    //   724	731	852	java/lang/Exception
  }
  
  public byte[] d()
  {
    return this.s;
  }
  
  public String e()
  {
    return this.r;
  }
  
  public int f()
  {
    return this.q;
  }
  
  public String g()
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
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */