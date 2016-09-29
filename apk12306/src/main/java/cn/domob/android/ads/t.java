package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.i.f;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

class t
{
  private static f a = new f(t.class.getSimpleName());
  private static String b = "https://api.domob.cn/d";
  private static final int g = 5;
  private static final int i = 10000;
  private b c = new b();
  private a d = new a();
  private Context e;
  private int f = 0;
  private boolean h = false;
  
  public t(Context paramContext)
  {
    this.e = paramContext;
    paramContext = localSSLContext;
    try
    {
      localSSLContext = SSLContext.getInstance("TLS");
      paramContext = localSSLContext;
      b localb = this.c;
      paramContext = localSSLContext;
      SecureRandom localSecureRandom = new java/security/SecureRandom;
      paramContext = localSSLContext;
      localSecureRandom.<init>();
      paramContext = localSSLContext;
      localSSLContext.init(null, new X509TrustManager[] { localb }, localSecureRandom);
      paramContext = localSSLContext;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      for (;;)
      {
        a.a(localGeneralSecurityException);
      }
    }
    if (paramContext != null) {
      HttpsURLConnection.setDefaultSSLSocketFactory(paramContext.getSocketFactory());
    }
    HttpsURLConnection.setDefaultHostnameVerifier(this.d);
  }
  
  /* Error */
  private String a(String paramString, int paramInt, g paramg)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_0
    //   13: iload_2
    //   14: putfield 62	cn/domob/android/ads/t:f	I
    //   17: new 109	java/lang/StringBuffer
    //   20: dup
    //   21: ldc 111
    //   23: invokespecial 112	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   26: astore 5
    //   28: new 114	java/net/URL
    //   31: astore 4
    //   33: aload 4
    //   35: getstatic 46	cn/domob/android/ads/t:b	Ljava/lang/String;
    //   38: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   41: aload 4
    //   43: invokevirtual 119	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   46: checkcast 89	javax/net/ssl/HttpsURLConnection
    //   49: astore 4
    //   51: aload 4
    //   53: iconst_1
    //   54: invokevirtual 123	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   57: aload 4
    //   59: iconst_0
    //   60: invokevirtual 126	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   63: aload 4
    //   65: iconst_1
    //   66: invokevirtual 129	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   69: aload 4
    //   71: ldc -125
    //   73: invokevirtual 134	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   76: aload 4
    //   78: ldc -120
    //   80: ldc -118
    //   82: invokevirtual 142	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 4
    //   87: sipush 10000
    //   90: invokevirtual 146	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   93: aload 4
    //   95: sipush 10000
    //   98: invokevirtual 149	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   101: aload 4
    //   103: invokevirtual 153	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   106: astore 6
    //   108: aload 6
    //   110: ifnonnull +60 -> 170
    //   113: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   116: ldc -101
    //   118: invokevirtual 157	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   121: aload 4
    //   123: ifnull +8 -> 131
    //   126: aload 4
    //   128: invokevirtual 160	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   131: aload 6
    //   133: ifnull +8 -> 141
    //   136: aload 6
    //   138: invokevirtual 164	java/io/OutputStream:close	()V
    //   141: iconst_0
    //   142: ifeq +11 -> 153
    //   145: new 166	java/lang/NullPointerException
    //   148: dup
    //   149: invokespecial 167	java/lang/NullPointerException:<init>	()V
    //   152: athrow
    //   153: iconst_0
    //   154: ifeq +11 -> 165
    //   157: new 166	java/lang/NullPointerException
    //   160: dup
    //   161: invokespecial 167	java/lang/NullPointerException:<init>	()V
    //   164: athrow
    //   165: ldc 111
    //   167: astore_1
    //   168: aload_1
    //   169: areturn
    //   170: aload 6
    //   172: aload_1
    //   173: invokevirtual 173	java/lang/String:getBytes	()[B
    //   176: invokevirtual 177	java/io/OutputStream:write	([B)V
    //   179: aload 6
    //   181: invokevirtual 180	java/io/OutputStream:flush	()V
    //   184: aload 6
    //   186: invokevirtual 164	java/io/OutputStream:close	()V
    //   189: aload 4
    //   191: invokevirtual 184	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   194: astore 8
    //   196: aload 8
    //   198: astore 7
    //   200: new 186	java/io/BufferedReader
    //   203: astore 9
    //   205: new 188	java/io/InputStreamReader
    //   208: astore 8
    //   210: aload 8
    //   212: aload 7
    //   214: invokespecial 191	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   217: aload 9
    //   219: aload 8
    //   221: invokespecial 194	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   224: aload 5
    //   226: astore 11
    //   228: aload 9
    //   230: invokevirtual 197	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   233: astore 8
    //   235: aload 8
    //   237: ifnull +113 -> 350
    //   240: aload 5
    //   242: astore 11
    //   244: aload 5
    //   246: aload 8
    //   248: invokevirtual 201	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   251: pop
    //   252: goto -28 -> 224
    //   255: astore_1
    //   256: aload 5
    //   258: astore 8
    //   260: aload 9
    //   262: astore_3
    //   263: aload 4
    //   265: astore 5
    //   267: aload 6
    //   269: astore 4
    //   271: aload_1
    //   272: astore 6
    //   274: aload 8
    //   276: astore_1
    //   277: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   280: aload 6
    //   282: invokevirtual 100	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   285: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   288: aload_0
    //   289: getfield 66	cn/domob/android/ads/t:e	Landroid/content/Context;
    //   292: ldc -53
    //   294: invokevirtual 206	cn/domob/android/i/f:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   297: aload 5
    //   299: ifnull +8 -> 307
    //   302: aload 5
    //   304: invokevirtual 160	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   307: aload 4
    //   309: ifnull +8 -> 317
    //   312: aload 4
    //   314: invokevirtual 164	java/io/OutputStream:close	()V
    //   317: aload 7
    //   319: ifnull +8 -> 327
    //   322: aload 7
    //   324: invokevirtual 209	java/io/InputStream:close	()V
    //   327: aload_1
    //   328: astore 4
    //   330: aload_3
    //   331: ifnull +10 -> 341
    //   334: aload_3
    //   335: invokevirtual 210	java/io/BufferedReader:close	()V
    //   338: aload_1
    //   339: astore 4
    //   341: aload 4
    //   343: invokevirtual 213	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   346: astore_1
    //   347: goto -179 -> 168
    //   350: aload 5
    //   352: astore 11
    //   354: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   357: astore 10
    //   359: aload 5
    //   361: astore 11
    //   363: new 215	java/lang/StringBuilder
    //   366: astore 8
    //   368: aload 5
    //   370: astore 11
    //   372: aload 8
    //   374: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   377: aload 5
    //   379: astore 11
    //   381: aload 10
    //   383: ldc -38
    //   385: aload 8
    //   387: invokestatic 224	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   390: invokevirtual 227	java/lang/Thread:getName	()Ljava/lang/String;
    //   393: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: ldc -24
    //   398: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 4
    //   403: invokevirtual 236	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   406: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   409: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokevirtual 242	cn/domob/android/i/f:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   415: aload 5
    //   417: astore 11
    //   419: aload_0
    //   420: getfield 62	cn/domob/android/ads/t:f	I
    //   423: iconst_5
    //   424: if_icmpge +1305 -> 1729
    //   427: aload 5
    //   429: astore 11
    //   431: aload 4
    //   433: invokevirtual 236	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   436: iconst_m1
    //   437: if_icmpne +1292 -> 1729
    //   440: aload 5
    //   442: astore 11
    //   444: aload_0
    //   445: aload_0
    //   446: getfield 62	cn/domob/android/ads/t:f	I
    //   449: iconst_1
    //   450: iadd
    //   451: putfield 62	cn/domob/android/ads/t:f	I
    //   454: aload 5
    //   456: astore 11
    //   458: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   461: astore 8
    //   463: aload 5
    //   465: astore 11
    //   467: new 215	java/lang/StringBuilder
    //   470: astore 10
    //   472: aload 5
    //   474: astore 11
    //   476: aload 10
    //   478: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   481: aload 5
    //   483: astore 11
    //   485: aload 8
    //   487: ldc -38
    //   489: aload 10
    //   491: ldc -12
    //   493: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: getfield 62	cn/domob/android/ads/t:f	I
    //   500: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   503: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokevirtual 242	cn/domob/android/i/f:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   509: aload 5
    //   511: astore 11
    //   513: aload_0
    //   514: aload_1
    //   515: aload_0
    //   516: getfield 62	cn/domob/android/ads/t:f	I
    //   519: aload_3
    //   520: invokespecial 246	cn/domob/android/ads/t:a	(Ljava/lang/String;ILcn/domob/android/ads/g;)Ljava/lang/String;
    //   523: astore 10
    //   525: aload 5
    //   527: astore 8
    //   529: aload 10
    //   531: ifnull +23 -> 554
    //   534: aload 5
    //   536: astore 11
    //   538: new 109	java/lang/StringBuffer
    //   541: astore 8
    //   543: aload 5
    //   545: astore 11
    //   547: aload 8
    //   549: aload 10
    //   551: invokespecial 112	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   554: aload 8
    //   556: astore 11
    //   558: aload_0
    //   559: getfield 62	cn/domob/android/ads/t:f	I
    //   562: iconst_5
    //   563: if_icmpne +23 -> 586
    //   566: aload 8
    //   568: astore 11
    //   570: aload_0
    //   571: getfield 64	cn/domob/android/ads/t:h	Z
    //   574: ifne +12 -> 586
    //   577: aload 8
    //   579: astore 11
    //   581: aload_0
    //   582: iconst_1
    //   583: putfield 64	cn/domob/android/ads/t:h	Z
    //   586: aload 8
    //   588: astore_1
    //   589: aload 4
    //   591: ifnull +8 -> 599
    //   594: aload 4
    //   596: invokevirtual 160	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   599: aload 6
    //   601: ifnull +8 -> 609
    //   604: aload 6
    //   606: invokevirtual 164	java/io/OutputStream:close	()V
    //   609: aload 7
    //   611: ifnull +8 -> 619
    //   614: aload 7
    //   616: invokevirtual 209	java/io/InputStream:close	()V
    //   619: aload 9
    //   621: ifnull +8 -> 629
    //   624: aload 9
    //   626: invokevirtual 210	java/io/BufferedReader:close	()V
    //   629: aload_1
    //   630: astore 4
    //   632: goto -291 -> 341
    //   635: astore_3
    //   636: aload_1
    //   637: astore 4
    //   639: goto -298 -> 341
    //   642: astore 10
    //   644: aconst_null
    //   645: astore 8
    //   647: aconst_null
    //   648: astore 7
    //   650: aconst_null
    //   651: astore 6
    //   653: aload 11
    //   655: astore 4
    //   657: aload 4
    //   659: astore 13
    //   661: aload 8
    //   663: astore 12
    //   665: aload 7
    //   667: astore 11
    //   669: aload 6
    //   671: astore 9
    //   673: aload_0
    //   674: getfield 62	cn/domob/android/ads/t:f	I
    //   677: iconst_5
    //   678: if_icmpge +334 -> 1012
    //   681: aload 4
    //   683: astore 13
    //   685: aload 8
    //   687: astore 12
    //   689: aload 7
    //   691: astore 11
    //   693: aload 6
    //   695: astore 9
    //   697: aload_0
    //   698: aload_0
    //   699: getfield 62	cn/domob/android/ads/t:f	I
    //   702: iconst_1
    //   703: iadd
    //   704: putfield 62	cn/domob/android/ads/t:f	I
    //   707: aload 4
    //   709: astore 13
    //   711: aload 8
    //   713: astore 12
    //   715: aload 7
    //   717: astore 11
    //   719: aload 6
    //   721: astore 9
    //   723: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   726: astore 14
    //   728: aload 4
    //   730: astore 13
    //   732: aload 8
    //   734: astore 12
    //   736: aload 7
    //   738: astore 11
    //   740: aload 6
    //   742: astore 9
    //   744: new 215	java/lang/StringBuilder
    //   747: astore 10
    //   749: aload 4
    //   751: astore 13
    //   753: aload 8
    //   755: astore 12
    //   757: aload 7
    //   759: astore 11
    //   761: aload 6
    //   763: astore 9
    //   765: aload 10
    //   767: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   770: aload 4
    //   772: astore 13
    //   774: aload 8
    //   776: astore 12
    //   778: aload 7
    //   780: astore 11
    //   782: aload 6
    //   784: astore 9
    //   786: aload 14
    //   788: ldc -38
    //   790: aload 10
    //   792: ldc -8
    //   794: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: aload_0
    //   798: getfield 62	cn/domob/android/ads/t:f	I
    //   801: invokevirtual 239	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   804: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokevirtual 242	cn/domob/android/i/f:a	(Ljava/lang/Object;Ljava/lang/String;)V
    //   810: aload 4
    //   812: astore 13
    //   814: aload 8
    //   816: astore 12
    //   818: aload 7
    //   820: astore 11
    //   822: aload 6
    //   824: astore 9
    //   826: aload_0
    //   827: aload_1
    //   828: aload_0
    //   829: getfield 62	cn/domob/android/ads/t:f	I
    //   832: aload_3
    //   833: invokespecial 246	cn/domob/android/ads/t:a	(Ljava/lang/String;ILcn/domob/android/ads/g;)Ljava/lang/String;
    //   836: astore_1
    //   837: aload_1
    //   838: ifnull +885 -> 1723
    //   841: aload 4
    //   843: astore 13
    //   845: aload 8
    //   847: astore 12
    //   849: aload 7
    //   851: astore 11
    //   853: aload 6
    //   855: astore 9
    //   857: new 109	java/lang/StringBuffer
    //   860: astore_3
    //   861: aload 4
    //   863: astore 13
    //   865: aload 8
    //   867: astore 12
    //   869: aload 7
    //   871: astore 11
    //   873: aload 6
    //   875: astore 9
    //   877: aload_3
    //   878: aload_1
    //   879: invokespecial 112	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   882: aload_3
    //   883: astore_1
    //   884: aload 4
    //   886: astore 13
    //   888: aload 8
    //   890: astore 12
    //   892: aload 7
    //   894: astore 11
    //   896: aload 6
    //   898: astore 9
    //   900: aload_0
    //   901: getfield 62	cn/domob/android/ads/t:f	I
    //   904: iconst_5
    //   905: if_icmpne +51 -> 956
    //   908: aload_3
    //   909: astore_1
    //   910: aload 4
    //   912: astore 13
    //   914: aload 8
    //   916: astore 12
    //   918: aload 7
    //   920: astore 11
    //   922: aload 6
    //   924: astore 9
    //   926: aload_0
    //   927: getfield 64	cn/domob/android/ads/t:h	Z
    //   930: ifne +26 -> 956
    //   933: aload 4
    //   935: astore 13
    //   937: aload 8
    //   939: astore 12
    //   941: aload 7
    //   943: astore 11
    //   945: aload 6
    //   947: astore 9
    //   949: aload_0
    //   950: iconst_1
    //   951: putfield 64	cn/domob/android/ads/t:h	Z
    //   954: aload_3
    //   955: astore_1
    //   956: aload 4
    //   958: ifnull +8 -> 966
    //   961: aload 4
    //   963: invokevirtual 160	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   966: aload 6
    //   968: ifnull +8 -> 976
    //   971: aload 6
    //   973: invokevirtual 164	java/io/OutputStream:close	()V
    //   976: aload 7
    //   978: ifnull +8 -> 986
    //   981: aload 7
    //   983: invokevirtual 209	java/io/InputStream:close	()V
    //   986: aload_1
    //   987: astore 4
    //   989: aload 8
    //   991: ifnull -650 -> 341
    //   994: aload 8
    //   996: invokevirtual 210	java/io/BufferedReader:close	()V
    //   999: aload_1
    //   1000: astore 4
    //   1002: goto -661 -> 341
    //   1005: astore_3
    //   1006: aload_1
    //   1007: astore 4
    //   1009: goto -668 -> 341
    //   1012: aload 4
    //   1014: astore 13
    //   1016: aload 8
    //   1018: astore 12
    //   1020: aload 7
    //   1022: astore 11
    //   1024: aload 6
    //   1026: astore 9
    //   1028: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   1031: aload 10
    //   1033: invokevirtual 100	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1036: aload 4
    //   1038: astore 13
    //   1040: aload 8
    //   1042: astore 12
    //   1044: aload 7
    //   1046: astore 11
    //   1048: aload 6
    //   1050: astore 9
    //   1052: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   1055: astore 14
    //   1057: aload 4
    //   1059: astore 13
    //   1061: aload 8
    //   1063: astore 12
    //   1065: aload 7
    //   1067: astore 11
    //   1069: aload 6
    //   1071: astore 9
    //   1073: aload_0
    //   1074: getfield 66	cn/domob/android/ads/t:e	Landroid/content/Context;
    //   1077: astore_3
    //   1078: aload 4
    //   1080: astore 13
    //   1082: aload 8
    //   1084: astore 12
    //   1086: aload 7
    //   1088: astore 11
    //   1090: aload 6
    //   1092: astore 9
    //   1094: new 215	java/lang/StringBuilder
    //   1097: astore_1
    //   1098: aload 4
    //   1100: astore 13
    //   1102: aload 8
    //   1104: astore 12
    //   1106: aload 7
    //   1108: astore 11
    //   1110: aload 6
    //   1112: astore 9
    //   1114: aload_1
    //   1115: invokespecial 216	java/lang/StringBuilder:<init>	()V
    //   1118: aload 4
    //   1120: astore 13
    //   1122: aload 8
    //   1124: astore 12
    //   1126: aload 7
    //   1128: astore 11
    //   1130: aload 6
    //   1132: astore 9
    //   1134: aload 14
    //   1136: aload_3
    //   1137: aload_1
    //   1138: ldc -6
    //   1140: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: aload 10
    //   1145: invokevirtual 253	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1148: invokevirtual 230	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokevirtual 206	cn/domob/android/i/f:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1157: aload 5
    //   1159: astore_1
    //   1160: goto -204 -> 956
    //   1163: astore 4
    //   1165: aconst_null
    //   1166: astore_3
    //   1167: aconst_null
    //   1168: astore 7
    //   1170: aconst_null
    //   1171: astore 6
    //   1173: aload 5
    //   1175: astore_1
    //   1176: aload_3
    //   1177: astore 5
    //   1179: aload 8
    //   1181: astore_3
    //   1182: aload_3
    //   1183: astore 13
    //   1185: aload 5
    //   1187: astore 12
    //   1189: aload 7
    //   1191: astore 11
    //   1193: aload 6
    //   1195: astore 9
    //   1197: getstatic 42	cn/domob/android/ads/t:a	Lcn/domob/android/i/f;
    //   1200: aload 4
    //   1202: invokevirtual 100	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1205: aload_3
    //   1206: ifnull +7 -> 1213
    //   1209: aload_3
    //   1210: invokevirtual 160	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1213: aload 6
    //   1215: ifnull +8 -> 1223
    //   1218: aload 6
    //   1220: invokevirtual 164	java/io/OutputStream:close	()V
    //   1223: aload 7
    //   1225: ifnull +8 -> 1233
    //   1228: aload 7
    //   1230: invokevirtual 209	java/io/InputStream:close	()V
    //   1233: aload_1
    //   1234: astore 4
    //   1236: aload 5
    //   1238: ifnull -897 -> 341
    //   1241: aload 5
    //   1243: invokevirtual 210	java/io/BufferedReader:close	()V
    //   1246: aload_1
    //   1247: astore 4
    //   1249: goto -908 -> 341
    //   1252: astore_3
    //   1253: aload_1
    //   1254: astore 4
    //   1256: goto -915 -> 341
    //   1259: astore_1
    //   1260: aconst_null
    //   1261: astore 4
    //   1263: aconst_null
    //   1264: astore 7
    //   1266: aconst_null
    //   1267: astore 6
    //   1269: aload 9
    //   1271: astore_3
    //   1272: aload_3
    //   1273: ifnull +7 -> 1280
    //   1276: aload_3
    //   1277: invokevirtual 160	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1280: aload 6
    //   1282: ifnull +8 -> 1290
    //   1285: aload 6
    //   1287: invokevirtual 164	java/io/OutputStream:close	()V
    //   1290: aload 7
    //   1292: ifnull +8 -> 1300
    //   1295: aload 7
    //   1297: invokevirtual 209	java/io/InputStream:close	()V
    //   1300: aload 4
    //   1302: ifnull +8 -> 1310
    //   1305: aload 4
    //   1307: invokevirtual 210	java/io/BufferedReader:close	()V
    //   1310: aload_1
    //   1311: athrow
    //   1312: astore_3
    //   1313: goto -3 -> 1310
    //   1316: astore_1
    //   1317: aconst_null
    //   1318: astore 5
    //   1320: aconst_null
    //   1321: astore 7
    //   1323: aconst_null
    //   1324: astore 6
    //   1326: aload 4
    //   1328: astore_3
    //   1329: aload 5
    //   1331: astore 4
    //   1333: goto -61 -> 1272
    //   1336: astore_1
    //   1337: aconst_null
    //   1338: astore 5
    //   1340: aconst_null
    //   1341: astore 7
    //   1343: aload 4
    //   1345: astore_3
    //   1346: aload 5
    //   1348: astore 4
    //   1350: goto -78 -> 1272
    //   1353: astore_1
    //   1354: aconst_null
    //   1355: astore 5
    //   1357: aload 4
    //   1359: astore_3
    //   1360: aload 5
    //   1362: astore 4
    //   1364: goto -92 -> 1272
    //   1367: astore_1
    //   1368: aload 4
    //   1370: astore_3
    //   1371: aload 9
    //   1373: astore 4
    //   1375: goto -103 -> 1272
    //   1378: astore_1
    //   1379: aload 4
    //   1381: astore 6
    //   1383: aload_3
    //   1384: astore 4
    //   1386: aload 5
    //   1388: astore_3
    //   1389: goto -117 -> 1272
    //   1392: astore_1
    //   1393: aload 13
    //   1395: astore_3
    //   1396: aload 12
    //   1398: astore 4
    //   1400: aload 11
    //   1402: astore 7
    //   1404: aload 9
    //   1406: astore 6
    //   1408: goto -136 -> 1272
    //   1411: astore_3
    //   1412: aconst_null
    //   1413: astore 9
    //   1415: aconst_null
    //   1416: astore 7
    //   1418: aconst_null
    //   1419: astore 8
    //   1421: aload 4
    //   1423: astore 6
    //   1425: aload 5
    //   1427: astore_1
    //   1428: aload_3
    //   1429: astore 4
    //   1431: aload 6
    //   1433: astore_3
    //   1434: aload 9
    //   1436: astore 5
    //   1438: aload 8
    //   1440: astore 6
    //   1442: goto -260 -> 1182
    //   1445: astore 7
    //   1447: aconst_null
    //   1448: astore 9
    //   1450: aconst_null
    //   1451: astore 8
    //   1453: aload 4
    //   1455: astore_3
    //   1456: aload 5
    //   1458: astore_1
    //   1459: aload 7
    //   1461: astore 4
    //   1463: aload 9
    //   1465: astore 5
    //   1467: aload 8
    //   1469: astore 7
    //   1471: goto -289 -> 1182
    //   1474: astore_3
    //   1475: aconst_null
    //   1476: astore 9
    //   1478: aload 4
    //   1480: astore 8
    //   1482: aload 5
    //   1484: astore_1
    //   1485: aload_3
    //   1486: astore 4
    //   1488: aload 8
    //   1490: astore_3
    //   1491: aload 9
    //   1493: astore 5
    //   1495: goto -313 -> 1182
    //   1498: astore 8
    //   1500: aload 4
    //   1502: astore_3
    //   1503: aload 5
    //   1505: astore_1
    //   1506: aload 8
    //   1508: astore 4
    //   1510: aload 9
    //   1512: astore 5
    //   1514: goto -332 -> 1182
    //   1517: astore 5
    //   1519: aload 4
    //   1521: astore_3
    //   1522: aload 8
    //   1524: astore_1
    //   1525: aload 5
    //   1527: astore 4
    //   1529: aload 9
    //   1531: astore 5
    //   1533: goto -351 -> 1182
    //   1536: astore 10
    //   1538: aconst_null
    //   1539: astore 8
    //   1541: aconst_null
    //   1542: astore 7
    //   1544: aconst_null
    //   1545: astore 6
    //   1547: goto -890 -> 657
    //   1550: astore 10
    //   1552: aconst_null
    //   1553: astore 8
    //   1555: aconst_null
    //   1556: astore 7
    //   1558: goto -901 -> 657
    //   1561: astore 10
    //   1563: aconst_null
    //   1564: astore 8
    //   1566: goto -909 -> 657
    //   1569: astore 10
    //   1571: aload 11
    //   1573: astore 5
    //   1575: aload 9
    //   1577: astore 8
    //   1579: goto -922 -> 657
    //   1582: astore_3
    //   1583: aload_1
    //   1584: astore 4
    //   1586: goto -1245 -> 341
    //   1589: astore 6
    //   1591: aconst_null
    //   1592: astore 4
    //   1594: aconst_null
    //   1595: astore 8
    //   1597: aload 5
    //   1599: astore_1
    //   1600: aconst_null
    //   1601: astore_3
    //   1602: aload 8
    //   1604: astore 5
    //   1606: goto -1329 -> 277
    //   1609: astore 6
    //   1611: aconst_null
    //   1612: astore 9
    //   1614: aload 4
    //   1616: astore 8
    //   1618: aload 5
    //   1620: astore_1
    //   1621: aconst_null
    //   1622: astore_3
    //   1623: aload 9
    //   1625: astore 4
    //   1627: aload 8
    //   1629: astore 5
    //   1631: goto -1354 -> 277
    //   1634: astore_3
    //   1635: aload 6
    //   1637: astore 9
    //   1639: aload 4
    //   1641: astore 8
    //   1643: aload 5
    //   1645: astore_1
    //   1646: aconst_null
    //   1647: astore 4
    //   1649: aload_3
    //   1650: astore 6
    //   1652: aload 4
    //   1654: astore_3
    //   1655: aload 9
    //   1657: astore 4
    //   1659: aload 8
    //   1661: astore 5
    //   1663: goto -1386 -> 277
    //   1666: astore_3
    //   1667: aload 6
    //   1669: astore 8
    //   1671: aload 4
    //   1673: astore 9
    //   1675: aload 5
    //   1677: astore_1
    //   1678: aconst_null
    //   1679: astore 4
    //   1681: aload_3
    //   1682: astore 6
    //   1684: aload 4
    //   1686: astore_3
    //   1687: aload 8
    //   1689: astore 4
    //   1691: aload 9
    //   1693: astore 5
    //   1695: goto -1418 -> 277
    //   1698: astore_3
    //   1699: aload 4
    //   1701: astore 5
    //   1703: aload 8
    //   1705: astore_1
    //   1706: aload 6
    //   1708: astore 4
    //   1710: aload_3
    //   1711: astore 6
    //   1713: aload 9
    //   1715: astore_3
    //   1716: goto -1439 -> 277
    //   1719: astore_1
    //   1720: goto -1555 -> 165
    //   1723: aload 5
    //   1725: astore_3
    //   1726: goto -844 -> 882
    //   1729: aload 5
    //   1731: astore_1
    //   1732: goto -1143 -> 589
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1735	0	this	t
    //   0	1735	1	paramString	String
    //   0	1735	2	paramInt	int
    //   0	1735	3	paramg	g
    //   31	1088	4	localObject1	Object
    //   1163	38	4	localThrowable1	Throwable
    //   1234	475	4	localObject2	Object
    //   26	1487	5	localObject3	Object
    //   1517	9	5	localThrowable2	Throwable
    //   1531	199	5	localObject4	Object
    //   106	1440	6	localObject5	Object
    //   1589	1	6	localMalformedURLException1	java.net.MalformedURLException
    //   1609	27	6	localMalformedURLException2	java.net.MalformedURLException
    //   1650	62	6	localg	g
    //   10	1407	7	localObject6	Object
    //   1445	15	7	localThrowable3	Throwable
    //   1469	88	7	localObject7	Object
    //   4	1485	8	localObject8	Object
    //   1498	25	8	localThrowable4	Throwable
    //   1539	165	8	localObject9	Object
    //   7	1707	9	localObject10	Object
    //   357	193	10	localObject11	Object
    //   642	1	10	localIOException1	java.io.IOException
    //   747	397	10	localStringBuilder	StringBuilder
    //   1536	1	10	localIOException2	java.io.IOException
    //   1550	1	10	localIOException3	java.io.IOException
    //   1561	1	10	localIOException4	java.io.IOException
    //   1569	1	10	localIOException5	java.io.IOException
    //   1	1571	11	localObject12	Object
    //   663	734	12	localObject13	Object
    //   659	735	13	localObject14	Object
    //   726	409	14	localf	f
    // Exception table:
    //   from	to	target	type
    //   228	235	255	java/net/MalformedURLException
    //   244	252	255	java/net/MalformedURLException
    //   354	359	255	java/net/MalformedURLException
    //   363	368	255	java/net/MalformedURLException
    //   372	377	255	java/net/MalformedURLException
    //   381	415	255	java/net/MalformedURLException
    //   419	427	255	java/net/MalformedURLException
    //   431	440	255	java/net/MalformedURLException
    //   444	454	255	java/net/MalformedURLException
    //   458	463	255	java/net/MalformedURLException
    //   467	472	255	java/net/MalformedURLException
    //   476	481	255	java/net/MalformedURLException
    //   485	509	255	java/net/MalformedURLException
    //   513	525	255	java/net/MalformedURLException
    //   538	543	255	java/net/MalformedURLException
    //   547	554	255	java/net/MalformedURLException
    //   604	609	635	java/lang/Throwable
    //   614	619	635	java/lang/Throwable
    //   624	629	635	java/lang/Throwable
    //   28	51	642	java/io/IOException
    //   971	976	1005	java/lang/Throwable
    //   981	986	1005	java/lang/Throwable
    //   994	999	1005	java/lang/Throwable
    //   28	51	1163	java/lang/Throwable
    //   1218	1223	1252	java/lang/Throwable
    //   1228	1233	1252	java/lang/Throwable
    //   1241	1246	1252	java/lang/Throwable
    //   28	51	1259	finally
    //   1285	1290	1312	java/lang/Throwable
    //   1295	1300	1312	java/lang/Throwable
    //   1305	1310	1312	java/lang/Throwable
    //   51	108	1316	finally
    //   113	121	1336	finally
    //   170	196	1336	finally
    //   200	224	1353	finally
    //   228	235	1367	finally
    //   244	252	1367	finally
    //   354	359	1367	finally
    //   363	368	1367	finally
    //   372	377	1367	finally
    //   381	415	1367	finally
    //   419	427	1367	finally
    //   431	440	1367	finally
    //   444	454	1367	finally
    //   458	463	1367	finally
    //   467	472	1367	finally
    //   476	481	1367	finally
    //   485	509	1367	finally
    //   513	525	1367	finally
    //   538	543	1367	finally
    //   547	554	1367	finally
    //   558	566	1367	finally
    //   570	577	1367	finally
    //   581	586	1367	finally
    //   277	297	1378	finally
    //   673	681	1392	finally
    //   697	707	1392	finally
    //   723	728	1392	finally
    //   744	749	1392	finally
    //   765	770	1392	finally
    //   786	810	1392	finally
    //   826	837	1392	finally
    //   857	861	1392	finally
    //   877	882	1392	finally
    //   900	908	1392	finally
    //   926	933	1392	finally
    //   949	954	1392	finally
    //   1028	1036	1392	finally
    //   1052	1057	1392	finally
    //   1073	1078	1392	finally
    //   1094	1098	1392	finally
    //   1114	1118	1392	finally
    //   1134	1157	1392	finally
    //   1197	1205	1392	finally
    //   51	108	1411	java/lang/Throwable
    //   113	121	1445	java/lang/Throwable
    //   170	196	1445	java/lang/Throwable
    //   200	224	1474	java/lang/Throwable
    //   228	235	1498	java/lang/Throwable
    //   244	252	1498	java/lang/Throwable
    //   354	359	1498	java/lang/Throwable
    //   363	368	1498	java/lang/Throwable
    //   372	377	1498	java/lang/Throwable
    //   381	415	1498	java/lang/Throwable
    //   419	427	1498	java/lang/Throwable
    //   431	440	1498	java/lang/Throwable
    //   444	454	1498	java/lang/Throwable
    //   458	463	1498	java/lang/Throwable
    //   467	472	1498	java/lang/Throwable
    //   476	481	1498	java/lang/Throwable
    //   485	509	1498	java/lang/Throwable
    //   513	525	1498	java/lang/Throwable
    //   538	543	1498	java/lang/Throwable
    //   547	554	1498	java/lang/Throwable
    //   558	566	1517	java/lang/Throwable
    //   570	577	1517	java/lang/Throwable
    //   581	586	1517	java/lang/Throwable
    //   51	108	1536	java/io/IOException
    //   113	121	1550	java/io/IOException
    //   170	196	1550	java/io/IOException
    //   200	224	1561	java/io/IOException
    //   228	235	1569	java/io/IOException
    //   244	252	1569	java/io/IOException
    //   354	359	1569	java/io/IOException
    //   363	368	1569	java/io/IOException
    //   372	377	1569	java/io/IOException
    //   381	415	1569	java/io/IOException
    //   419	427	1569	java/io/IOException
    //   431	440	1569	java/io/IOException
    //   444	454	1569	java/io/IOException
    //   458	463	1569	java/io/IOException
    //   467	472	1569	java/io/IOException
    //   476	481	1569	java/io/IOException
    //   485	509	1569	java/io/IOException
    //   513	525	1569	java/io/IOException
    //   538	543	1569	java/io/IOException
    //   547	554	1569	java/io/IOException
    //   558	566	1569	java/io/IOException
    //   570	577	1569	java/io/IOException
    //   581	586	1569	java/io/IOException
    //   312	317	1582	java/lang/Throwable
    //   322	327	1582	java/lang/Throwable
    //   334	338	1582	java/lang/Throwable
    //   28	51	1589	java/net/MalformedURLException
    //   51	108	1609	java/net/MalformedURLException
    //   113	121	1634	java/net/MalformedURLException
    //   170	196	1634	java/net/MalformedURLException
    //   200	224	1666	java/net/MalformedURLException
    //   558	566	1698	java/net/MalformedURLException
    //   570	577	1698	java/net/MalformedURLException
    //   581	586	1698	java/net/MalformedURLException
    //   136	141	1719	java/lang/Throwable
    //   145	153	1719	java/lang/Throwable
    //   157	165	1719	java/lang/Throwable
  }
  
  protected String a(String paramString, g paramg)
  {
    return a(paramString, 0, paramg);
  }
  
  class a
    implements HostnameVerifier
  {
    a() {}
    
    public boolean verify(String paramString, SSLSession paramSSLSession)
    {
      return true;
    }
  }
  
  class b
    implements X509TrustManager
  {
    b() {}
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString) {}
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return null;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */