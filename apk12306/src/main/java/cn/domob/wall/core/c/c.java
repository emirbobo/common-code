package cn.domob.wall.core.c;

import android.content.Context;
import android.database.Cursor;
import cn.domob.wall.core.h.b;
import cn.domob.wall.core.h.d;
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
  static final String a = "GET";
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
      paramString2 = new java/net/URL;
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>();
      paramString2.<init>(paramString1 + "?" + paramString4);
      this.g = paramString2;
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
            String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("proxy"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            int i1 = localCursor.getInt(localCursor.getColumnIndexOrThrow("port"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("apn"));
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
            locald.b(this, "Current apnType is " + str2);
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
            locald.b(this, "proxy:" + str1 + "| port:" + i1);
            if (str1 != null)
            {
              localObject1 = localCursor;
              localObject3 = localCursor;
              if ((!str1.trim().equals("")) && (i1 != 0))
              {
                localObject1 = localCursor;
                localObject3 = localCursor;
                if (!str2.equalsIgnoreCase("ctwap"))
                {
                  localObject1 = localCursor;
                  localObject3 = localCursor;
                  d.b(this, "ad request use proxy");
                  localObject1 = localCursor;
                  localObject3 = localCursor;
                  a(str1, i1);
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
    //   11: getfield 123	cn/domob/wall/core/c/c:g	Ljava/net/URL;
    //   14: ifnull +854 -> 868
    //   17: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   20: astore 6
    //   22: new 112	java/lang/StringBuilder
    //   25: astore 7
    //   27: aload 7
    //   29: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   32: aload 6
    //   34: aload 7
    //   36: ldc -5
    //   38: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload_0
    //   42: getfield 123	cn/domob/wall/core/c/c:g	Ljava/net/URL;
    //   45: invokevirtual 252	java/net/URL:toString	()Ljava/lang/String;
    //   48: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 143	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   57: iconst_1
    //   58: invokestatic 258	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   61: aload_0
    //   62: getfield 176	cn/domob/wall/core/c/c:k	Ljava/net/Proxy;
    //   65: ifnull +213 -> 278
    //   68: aload_0
    //   69: aload_0
    //   70: getfield 123	cn/domob/wall/core/c/c:g	Ljava/net/URL;
    //   73: aload_0
    //   74: getfield 176	cn/domob/wall/core/c/c:k	Ljava/net/Proxy;
    //   77: invokevirtual 262	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   80: checkcast 254	java/net/HttpURLConnection
    //   83: putfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   86: aload_0
    //   87: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   90: ifnull +778 -> 868
    //   93: aload_0
    //   94: getfield 82	cn/domob/wall/core/c/c:i	Ljava/lang/String;
    //   97: ifnull +27 -> 124
    //   100: aload_0
    //   101: getfield 82	cn/domob/wall/core/c/c:i	Ljava/lang/String;
    //   104: invokevirtual 98	java/lang/String:length	()I
    //   107: ifeq +17 -> 124
    //   110: aload_0
    //   111: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   114: ldc_w 266
    //   117: aload_0
    //   118: getfield 82	cn/domob/wall/core/c/c:i	Ljava/lang/String;
    //   121: invokevirtual 270	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: aload_0
    //   125: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   128: iconst_0
    //   129: invokevirtual 273	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   132: aload_0
    //   133: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   136: aload_0
    //   137: getfield 90	cn/domob/wall/core/c/c:m	I
    //   140: invokevirtual 277	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   143: aload_0
    //   144: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   147: aload_0
    //   148: getfield 90	cn/domob/wall/core/c/c:m	I
    //   151: invokevirtual 280	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   154: aload_0
    //   155: getfield 84	cn/domob/wall/core/c/c:j	Ljava/util/HashMap;
    //   158: ifnull +160 -> 318
    //   161: aload_0
    //   162: getfield 84	cn/domob/wall/core/c/c:j	Ljava/util/HashMap;
    //   165: invokevirtual 286	java/util/HashMap:keySet	()Ljava/util/Set;
    //   168: invokeinterface 292 1 0
    //   173: astore 6
    //   175: aload 6
    //   177: invokeinterface 297 1 0
    //   182: ifeq +136 -> 318
    //   185: aload 6
    //   187: invokeinterface 301 1 0
    //   192: checkcast 94	java/lang/String
    //   195: astore_2
    //   196: aload_0
    //   197: getfield 84	cn/domob/wall/core/c/c:j	Ljava/util/HashMap;
    //   200: aload_2
    //   201: invokevirtual 305	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   204: checkcast 94	java/lang/String
    //   207: astore 7
    //   209: aload 7
    //   211: ifnull -36 -> 175
    //   214: aload_0
    //   215: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   218: aload_2
    //   219: aload 7
    //   221: invokevirtual 308	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: goto -49 -> 175
    //   227: astore 4
    //   229: aconst_null
    //   230: astore_2
    //   231: aload_2
    //   232: astore 5
    //   234: aload_3
    //   235: astore 6
    //   237: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   240: aload_0
    //   241: ldc_w 310
    //   244: invokevirtual 233	cn/domob/wall/core/h/d:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   247: aload_2
    //   248: astore 5
    //   250: aload_3
    //   251: astore 6
    //   253: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   256: aload 4
    //   258: invokevirtual 146	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
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
    //   280: getfield 123	cn/domob/wall/core/c/c:g	Ljava/net/URL;
    //   283: invokevirtual 319	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   286: checkcast 254	java/net/HttpURLConnection
    //   289: putfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
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
    //   319: getfield 86	cn/domob/wall/core/c/c:h	Ljava/lang/String;
    //   322: ldc 15
    //   324: invokevirtual 102	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   327: ifeq +214 -> 541
    //   330: aload_0
    //   331: getfield 88	cn/domob/wall/core/c/c:l	Ljava/lang/String;
    //   334: ifnull +207 -> 541
    //   337: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   340: ldc_w 321
    //   343: invokevirtual 143	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   346: aload_0
    //   347: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   350: ldc 15
    //   352: invokevirtual 324	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   355: aload_0
    //   356: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   359: iconst_1
    //   360: invokevirtual 327	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   363: aload_0
    //   364: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   367: ldc_w 329
    //   370: aload_0
    //   371: getfield 127	cn/domob/wall/core/c/c:o	Ljava/lang/String;
    //   374: invokevirtual 270	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload_0
    //   378: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   381: ldc_w 331
    //   384: aload_0
    //   385: getfield 88	cn/domob/wall/core/c/c:l	Ljava/lang/String;
    //   388: invokevirtual 98	java/lang/String:length	()I
    //   391: invokestatic 334	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   394: invokevirtual 270	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_0
    //   398: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   401: invokevirtual 338	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   404: astore 7
    //   406: new 340	java/io/BufferedWriter
    //   409: astore 6
    //   411: new 342	java/io/OutputStreamWriter
    //   414: astore_2
    //   415: aload_2
    //   416: aload 7
    //   418: invokespecial 345	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   421: aload 6
    //   423: aload_2
    //   424: sipush 4096
    //   427: invokespecial 348	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   430: aload 6
    //   432: ifnull +27 -> 459
    //   435: aload 6
    //   437: aload_0
    //   438: getfield 88	cn/domob/wall/core/c/c:l	Ljava/lang/String;
    //   441: invokevirtual 351	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   444: aload 6
    //   446: invokevirtual 354	java/io/BufferedWriter:flush	()V
    //   449: aload 6
    //   451: invokevirtual 355	java/io/BufferedWriter:close	()V
    //   454: aload 7
    //   456: invokevirtual 358	java/io/OutputStream:close	()V
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   464: invokevirtual 361	java/net/HttpURLConnection:getResponseCode	()I
    //   467: putfield 363	cn/domob/wall/core/c/c:q	I
    //   470: aload_0
    //   471: getfield 363	cn/domob/wall/core/c/c:q	I
    //   474: sipush 301
    //   477: if_icmpeq +13 -> 490
    //   480: aload_0
    //   481: getfield 363	cn/domob/wall/core/c/c:q	I
    //   484: sipush 302
    //   487: if_icmpne +73 -> 560
    //   490: new 110	java/net/URL
    //   493: astore_2
    //   494: aload_2
    //   495: aload_0
    //   496: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   499: ldc_w 365
    //   502: invokevirtual 369	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   505: invokespecial 121	java/net/URL:<init>	(Ljava/lang/String;)V
    //   508: aload_0
    //   509: aload_2
    //   510: invokevirtual 319	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   513: checkcast 254	java/net/HttpURLConnection
    //   516: putfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   519: aload_0
    //   520: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   523: iconst_0
    //   524: invokevirtual 273	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   527: aload_0
    //   528: aload_0
    //   529: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   532: invokevirtual 361	java/net/HttpURLConnection:getResponseCode	()I
    //   535: putfield 363	cn/domob/wall/core/c/c:q	I
    //   538: goto -68 -> 470
    //   541: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   544: ldc_w 371
    //   547: invokevirtual 143	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   550: aload_0
    //   551: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   554: invokevirtual 374	java/net/HttpURLConnection:connect	()V
    //   557: goto -98 -> 459
    //   560: aload_0
    //   561: getfield 363	cn/domob/wall/core/c/c:q	I
    //   564: sipush 200
    //   567: if_icmplt +293 -> 860
    //   570: aload_0
    //   571: getfield 363	cn/domob/wall/core/c/c:q	I
    //   574: sipush 304
    //   577: if_icmpgt +283 -> 860
    //   580: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   583: astore 5
    //   585: new 112	java/lang/StringBuilder
    //   588: astore_2
    //   589: aload_2
    //   590: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   593: aload 5
    //   595: aload_2
    //   596: ldc_w 376
    //   599: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_0
    //   603: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   606: invokevirtual 380	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   609: invokevirtual 383	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokevirtual 143	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   618: new 312	java/io/BufferedInputStream
    //   621: dup
    //   622: aload_0
    //   623: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   626: invokevirtual 387	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   629: sipush 4096
    //   632: invokespecial 390	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   635: astore_2
    //   636: sipush 4096
    //   639: newarray <illegal type>
    //   641: astore_3
    //   642: new 315	java/io/ByteArrayOutputStream
    //   645: astore 5
    //   647: aload 5
    //   649: sipush 4096
    //   652: invokespecial 392	java/io/ByteArrayOutputStream:<init>	(I)V
    //   655: aload_2
    //   656: aload_3
    //   657: invokevirtual 396	java/io/BufferedInputStream:read	([B)I
    //   660: istore_1
    //   661: iload_1
    //   662: iconst_m1
    //   663: if_icmpeq +24 -> 687
    //   666: aload 5
    //   668: aload_3
    //   669: iconst_0
    //   670: iload_1
    //   671: invokevirtual 399	java/io/ByteArrayOutputStream:write	([BII)V
    //   674: goto -19 -> 655
    //   677: astore 4
    //   679: aload_2
    //   680: astore_3
    //   681: aload 5
    //   683: astore_2
    //   684: goto -453 -> 231
    //   687: aload_0
    //   688: aload 5
    //   690: invokevirtual 403	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   693: putfield 405	cn/domob/wall/core/c/c:s	[B
    //   696: new 94	java/lang/String
    //   699: astore_3
    //   700: aload_3
    //   701: aload_0
    //   702: getfield 405	cn/domob/wall/core/c/c:s	[B
    //   705: ldc_w 407
    //   708: invokespecial 410	java/lang/String:<init>	([BLjava/lang/String;)V
    //   711: aload_0
    //   712: aload_3
    //   713: putfield 412	cn/domob/wall/core/c/c:r	Ljava/lang/String;
    //   716: aload_2
    //   717: astore_3
    //   718: aload 5
    //   720: astore_2
    //   721: aload_2
    //   722: astore 5
    //   724: aload_3
    //   725: astore 6
    //   727: aload_0
    //   728: getfield 264	cn/domob/wall/core/c/c:e	Ljava/net/HttpURLConnection;
    //   731: invokevirtual 415	java/net/HttpURLConnection:disconnect	()V
    //   734: aload_3
    //   735: ifnull +7 -> 742
    //   738: aload_3
    //   739: invokevirtual 313	java/io/BufferedInputStream:close	()V
    //   742: aload_2
    //   743: ifnull -466 -> 277
    //   746: aload_2
    //   747: invokevirtual 316	java/io/ByteArrayOutputStream:close	()V
    //   750: goto -473 -> 277
    //   753: astore_2
    //   754: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   757: aload_2
    //   758: invokevirtual 146	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   761: goto -484 -> 277
    //   764: astore_3
    //   765: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   768: aload_3
    //   769: invokevirtual 146	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   772: goto -30 -> 742
    //   775: astore_3
    //   776: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   779: aload_3
    //   780: invokevirtual 146	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   783: goto -514 -> 269
    //   786: astore_2
    //   787: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   790: aload_2
    //   791: invokevirtual 146	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   794: goto -517 -> 277
    //   797: astore_2
    //   798: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   801: aload_2
    //   802: invokevirtual 146	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   805: goto -499 -> 306
    //   808: astore_2
    //   809: getstatic 64	cn/domob/wall/core/c/c:d	Lcn/domob/wall/core/h/d;
    //   812: aload_2
    //   813: invokevirtual 146	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   816: goto -500 -> 316
    //   819: astore_3
    //   820: goto -522 -> 298
    //   823: astore_3
    //   824: aload 5
    //   826: astore 4
    //   828: goto -530 -> 298
    //   831: astore_3
    //   832: aload 6
    //   834: astore_2
    //   835: aload 5
    //   837: astore 4
    //   839: goto -541 -> 298
    //   842: astore 4
    //   844: aconst_null
    //   845: astore 5
    //   847: aload_2
    //   848: astore_3
    //   849: aload 5
    //   851: astore_2
    //   852: goto -621 -> 231
    //   855: astore 4
    //   857: goto -626 -> 231
    //   860: aconst_null
    //   861: astore_2
    //   862: aload 5
    //   864: astore_3
    //   865: goto -144 -> 721
    //   868: aconst_null
    //   869: astore_3
    //   870: goto -136 -> 734
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	873	0	this	c
    //   660	11	1	i1	int
    //   7	740	2	localObject1	Object
    //   753	5	2	localIOException1	java.io.IOException
    //   786	5	2	localIOException2	java.io.IOException
    //   797	5	2	localIOException3	java.io.IOException
    //   808	5	2	localIOException4	java.io.IOException
    //   834	28	2	localObject2	Object
    //   9	257	3	localObject3	Object
    //   295	22	3	localObject4	Object
    //   641	98	3	localObject5	Object
    //   764	5	3	localIOException5	java.io.IOException
    //   775	5	3	localIOException6	java.io.IOException
    //   819	1	3	localObject6	Object
    //   823	1	3	localObject7	Object
    //   831	1	3	localObject8	Object
    //   848	22	3	localObject9	Object
    //   1	1	4	localObject10	Object
    //   227	85	4	localException1	Exception
    //   677	1	4	localException2	Exception
    //   826	12	4	localObject11	Object
    //   842	1	4	localException3	Exception
    //   855	1	4	localException4	Exception
    //   4	859	5	localObject12	Object
    //   20	813	6	localObject13	Object
    //   25	430	7	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   10	86	227	java/lang/Exception
    //   86	124	227	java/lang/Exception
    //   124	175	227	java/lang/Exception
    //   175	209	227	java/lang/Exception
    //   214	224	227	java/lang/Exception
    //   278	292	227	java/lang/Exception
    //   318	430	227	java/lang/Exception
    //   435	459	227	java/lang/Exception
    //   459	470	227	java/lang/Exception
    //   470	490	227	java/lang/Exception
    //   490	538	227	java/lang/Exception
    //   541	557	227	java/lang/Exception
    //   560	636	227	java/lang/Exception
    //   10	86	295	finally
    //   86	124	295	finally
    //   124	175	295	finally
    //   175	209	295	finally
    //   214	224	295	finally
    //   278	292	295	finally
    //   318	430	295	finally
    //   435	459	295	finally
    //   459	470	295	finally
    //   470	490	295	finally
    //   490	538	295	finally
    //   541	557	295	finally
    //   560	636	295	finally
    //   655	661	677	java/lang/Exception
    //   666	674	677	java/lang/Exception
    //   687	716	677	java/lang/Exception
    //   746	750	753	java/io/IOException
    //   738	742	764	java/io/IOException
    //   265	269	775	java/io/IOException
    //   273	277	786	java/io/IOException
    //   302	306	797	java/io/IOException
    //   311	316	808	java/io/IOException
    //   636	655	819	finally
    //   655	661	823	finally
    //   666	674	823	finally
    //   687	716	823	finally
    //   237	247	831	finally
    //   253	261	831	finally
    //   727	734	831	finally
    //   636	655	842	java/lang/Exception
    //   727	734	855	java/lang/Exception
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */