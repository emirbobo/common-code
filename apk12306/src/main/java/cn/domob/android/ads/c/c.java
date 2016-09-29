package cn.domob.android.ads.c;

import cn.domob.android.i.f;

public class c
{
  private static f a = new f(c.class.getSimpleName());
  private static final float b = 300000.0F;
  
  /* Error */
  public static boolean a(android.graphics.Bitmap paramBitmap, long paramLong, String paramString)
  {
    // Byte code:
    //   0: invokestatic 41	java/util/UUID:randomUUID	()Ljava/util/UUID;
    //   3: invokevirtual 44	java/util/UUID:toString	()Ljava/lang/String;
    //   6: astore 10
    //   8: aconst_null
    //   9: astore 8
    //   11: aload_0
    //   12: ifnull +7 -> 19
    //   15: aload_3
    //   16: ifnonnull +67 -> 83
    //   19: iconst_0
    //   20: istore 6
    //   22: iconst_0
    //   23: ifeq +11 -> 34
    //   26: new 46	java/lang/NullPointerException
    //   29: dup
    //   30: invokespecial 47	java/lang/NullPointerException:<init>	()V
    //   33: athrow
    //   34: aload_0
    //   35: ifnull +22 -> 57
    //   38: aload_0
    //   39: invokevirtual 53	android/graphics/Bitmap:isRecycled	()Z
    //   42: ifne +15 -> 57
    //   45: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   48: ldc 55
    //   50: invokevirtual 57	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   53: aload_0
    //   54: invokevirtual 60	android/graphics/Bitmap:recycle	()V
    //   57: iconst_0
    //   58: ifeq +11 -> 69
    //   61: new 46	java/lang/NullPointerException
    //   64: dup
    //   65: invokespecial 47	java/lang/NullPointerException:<init>	()V
    //   68: athrow
    //   69: iload 6
    //   71: ireturn
    //   72: astore_0
    //   73: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   76: aload_0
    //   77: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   80: goto -23 -> 57
    //   83: new 65	java/net/URL
    //   86: astore 9
    //   88: aload 9
    //   90: aload_3
    //   91: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: aload 9
    //   96: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   99: checkcast 72	java/net/HttpURLConnection
    //   102: astore_3
    //   103: aload_3
    //   104: sipush 5000
    //   107: invokevirtual 76	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   110: aload_3
    //   111: iconst_1
    //   112: invokevirtual 80	java/net/HttpURLConnection:setDoInput	(Z)V
    //   115: aload_3
    //   116: iconst_1
    //   117: invokevirtual 83	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   120: aload_3
    //   121: iconst_0
    //   122: invokevirtual 86	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   125: aload_3
    //   126: ldc 88
    //   128: invokevirtual 91	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   131: aload_3
    //   132: ldc 93
    //   134: ldc 95
    //   136: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_3
    //   140: ldc 101
    //   142: ldc 103
    //   144: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: new 105	java/lang/StringBuilder
    //   150: astore 8
    //   152: aload 8
    //   154: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   157: aload_3
    //   158: ldc 108
    //   160: aload 8
    //   162: ldc 110
    //   164: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 116
    //   169: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 10
    //   174: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokevirtual 99	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: new 119	java/io/DataOutputStream
    //   186: astore 9
    //   188: aload 9
    //   190: aload_3
    //   191: invokevirtual 123	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   194: invokespecial 126	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   197: new 105	java/lang/StringBuilder
    //   200: astore 8
    //   202: aload 8
    //   204: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   207: aload 8
    //   209: ldc -128
    //   211: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 8
    //   217: aload 10
    //   219: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 8
    //   225: ldc -126
    //   227: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: new 105	java/lang/StringBuilder
    //   234: astore 11
    //   236: aload 11
    //   238: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   241: aload 8
    //   243: aload 11
    //   245: ldc -124
    //   247: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_0
    //   251: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: ldc -119
    //   256: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc -126
    //   261: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: new 105	java/lang/StringBuilder
    //   274: astore 11
    //   276: aload 11
    //   278: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   281: aload 8
    //   283: aload 11
    //   285: ldc -117
    //   287: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: ldc 103
    //   292: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc -126
    //   297: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 8
    //   309: ldc -126
    //   311: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 9
    //   317: aload 8
    //   319: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokevirtual 145	java/lang/String:getBytes	()[B
    //   325: invokevirtual 149	java/io/DataOutputStream:write	([B)V
    //   328: new 151	java/io/ByteArrayOutputStream
    //   331: astore 8
    //   333: aload 8
    //   335: invokespecial 152	java/io/ByteArrayOutputStream:<init>	()V
    //   338: ldc 9
    //   340: lload_1
    //   341: l2f
    //   342: fdiv
    //   343: ldc -103
    //   345: fmul
    //   346: f2i
    //   347: istore 5
    //   349: iload 5
    //   351: istore 4
    //   353: iload 5
    //   355: bipush 100
    //   357: if_icmple +7 -> 364
    //   360: bipush 100
    //   362: istore 4
    //   364: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   367: astore 11
    //   369: new 105	java/lang/StringBuilder
    //   372: astore 12
    //   374: aload 12
    //   376: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   379: aload 11
    //   381: aload 12
    //   383: ldc -101
    //   385: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: iload 4
    //   390: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 160	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   399: aload_0
    //   400: getstatic 166	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   403: iload 4
    //   405: aload 8
    //   407: invokevirtual 170	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   410: pop
    //   411: new 172	java/io/ByteArrayInputStream
    //   414: astore 11
    //   416: aload 11
    //   418: aload 8
    //   420: invokevirtual 175	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   423: invokespecial 177	java/io/ByteArrayInputStream:<init>	([B)V
    //   426: sipush 1024
    //   429: newarray <illegal type>
    //   431: astore 8
    //   433: aload 11
    //   435: aload 8
    //   437: invokevirtual 183	java/io/InputStream:read	([B)I
    //   440: istore 4
    //   442: iload 4
    //   444: iconst_m1
    //   445: if_icmpeq +91 -> 536
    //   448: aload 9
    //   450: aload 8
    //   452: iconst_0
    //   453: iload 4
    //   455: invokevirtual 186	java/io/DataOutputStream:write	([BII)V
    //   458: goto -25 -> 433
    //   461: astore 10
    //   463: aload_3
    //   464: astore 8
    //   466: aload 9
    //   468: astore_3
    //   469: aload 10
    //   471: astore 9
    //   473: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   476: aload 9
    //   478: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   481: iconst_0
    //   482: istore 7
    //   484: aload_3
    //   485: ifnull +7 -> 492
    //   488: aload_3
    //   489: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   492: aload_0
    //   493: ifnull +22 -> 515
    //   496: aload_0
    //   497: invokevirtual 53	android/graphics/Bitmap:isRecycled	()Z
    //   500: ifne +15 -> 515
    //   503: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   506: ldc 55
    //   508: invokevirtual 57	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   511: aload_0
    //   512: invokevirtual 60	android/graphics/Bitmap:recycle	()V
    //   515: iload 7
    //   517: istore 6
    //   519: aload 8
    //   521: ifnull -452 -> 69
    //   524: aload 8
    //   526: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   529: iload 7
    //   531: istore 6
    //   533: goto -464 -> 69
    //   536: aload 11
    //   538: invokevirtual 193	java/io/InputStream:close	()V
    //   541: aload 9
    //   543: ldc -126
    //   545: invokevirtual 145	java/lang/String:getBytes	()[B
    //   548: invokevirtual 149	java/io/DataOutputStream:write	([B)V
    //   551: new 105	java/lang/StringBuilder
    //   554: astore 8
    //   556: aload 8
    //   558: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   561: aload 9
    //   563: aload 8
    //   565: ldc -128
    //   567: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload 10
    //   572: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: ldc -128
    //   577: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc -126
    //   582: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokevirtual 145	java/lang/String:getBytes	()[B
    //   591: invokevirtual 149	java/io/DataOutputStream:write	([B)V
    //   594: aload 9
    //   596: invokevirtual 196	java/io/DataOutputStream:flush	()V
    //   599: aload_3
    //   600: invokevirtual 200	java/net/HttpURLConnection:getResponseCode	()I
    //   603: istore 4
    //   605: iload 4
    //   607: sipush 200
    //   610: if_icmplt +69 -> 679
    //   613: iload 4
    //   615: sipush 300
    //   618: if_icmpgt +61 -> 679
    //   621: aload 9
    //   623: ifnull +8 -> 631
    //   626: aload 9
    //   628: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   631: aload_0
    //   632: ifnull +22 -> 654
    //   635: aload_0
    //   636: invokevirtual 53	android/graphics/Bitmap:isRecycled	()Z
    //   639: ifne +15 -> 654
    //   642: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   645: ldc 55
    //   647: invokevirtual 57	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   650: aload_0
    //   651: invokevirtual 60	android/graphics/Bitmap:recycle	()V
    //   654: aload_3
    //   655: ifnull +7 -> 662
    //   658: aload_3
    //   659: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   662: iconst_1
    //   663: istore 6
    //   665: goto -596 -> 69
    //   668: astore_0
    //   669: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   672: aload_0
    //   673: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   676: goto -22 -> 654
    //   679: aload 9
    //   681: ifnull +8 -> 689
    //   684: aload 9
    //   686: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   689: aload_0
    //   690: ifnull +22 -> 712
    //   693: aload_0
    //   694: invokevirtual 53	android/graphics/Bitmap:isRecycled	()Z
    //   697: ifne +15 -> 712
    //   700: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   703: ldc 55
    //   705: invokevirtual 57	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   708: aload_0
    //   709: invokevirtual 60	android/graphics/Bitmap:recycle	()V
    //   712: aload_3
    //   713: ifnull +7 -> 720
    //   716: aload_3
    //   717: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   720: iconst_0
    //   721: istore 6
    //   723: goto -654 -> 69
    //   726: astore_0
    //   727: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   730: aload_0
    //   731: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   734: goto -22 -> 712
    //   737: astore_0
    //   738: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   741: aload_0
    //   742: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   745: goto -230 -> 515
    //   748: astore_3
    //   749: aconst_null
    //   750: astore 8
    //   752: aconst_null
    //   753: astore 9
    //   755: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   758: aload_3
    //   759: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   762: iconst_0
    //   763: istore 7
    //   765: aload 9
    //   767: ifnull +8 -> 775
    //   770: aload 9
    //   772: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   775: aload_0
    //   776: ifnull +22 -> 798
    //   779: aload_0
    //   780: invokevirtual 53	android/graphics/Bitmap:isRecycled	()Z
    //   783: ifne +15 -> 798
    //   786: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   789: ldc 55
    //   791: invokevirtual 57	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   794: aload_0
    //   795: invokevirtual 60	android/graphics/Bitmap:recycle	()V
    //   798: iload 7
    //   800: istore 6
    //   802: aload 8
    //   804: ifnull -735 -> 69
    //   807: aload 8
    //   809: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   812: iload 7
    //   814: istore 6
    //   816: goto -747 -> 69
    //   819: astore_0
    //   820: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   823: aload_0
    //   824: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   827: goto -29 -> 798
    //   830: astore_3
    //   831: aconst_null
    //   832: astore 8
    //   834: aconst_null
    //   835: astore 9
    //   837: aload 9
    //   839: ifnull +8 -> 847
    //   842: aload 9
    //   844: invokevirtual 189	java/io/DataOutputStream:close	()V
    //   847: aload_0
    //   848: ifnull +22 -> 870
    //   851: aload_0
    //   852: invokevirtual 53	android/graphics/Bitmap:isRecycled	()Z
    //   855: ifne +15 -> 870
    //   858: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   861: ldc 55
    //   863: invokevirtual 57	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   866: aload_0
    //   867: invokevirtual 60	android/graphics/Bitmap:recycle	()V
    //   870: aload 8
    //   872: ifnull +8 -> 880
    //   875: aload 8
    //   877: invokevirtual 192	java/net/HttpURLConnection:disconnect	()V
    //   880: aload_3
    //   881: athrow
    //   882: astore_0
    //   883: getstatic 25	cn/domob/android/ads/c/c:a	Lcn/domob/android/i/f;
    //   886: aload_0
    //   887: invokevirtual 63	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   890: goto -20 -> 870
    //   893: astore 10
    //   895: aconst_null
    //   896: astore 9
    //   898: aload_3
    //   899: astore 8
    //   901: aload 10
    //   903: astore_3
    //   904: goto -67 -> 837
    //   907: astore 10
    //   909: aload_3
    //   910: astore 8
    //   912: aload 10
    //   914: astore_3
    //   915: goto -78 -> 837
    //   918: astore 9
    //   920: aload_3
    //   921: astore 10
    //   923: aload 9
    //   925: astore_3
    //   926: aload 10
    //   928: astore 9
    //   930: goto -93 -> 837
    //   933: astore_3
    //   934: goto -97 -> 837
    //   937: astore 10
    //   939: aconst_null
    //   940: astore 9
    //   942: aload_3
    //   943: astore 8
    //   945: aload 10
    //   947: astore_3
    //   948: goto -193 -> 755
    //   951: astore 10
    //   953: aload_3
    //   954: astore 8
    //   956: aload 10
    //   958: astore_3
    //   959: goto -204 -> 755
    //   962: astore 9
    //   964: aconst_null
    //   965: astore_3
    //   966: goto -493 -> 473
    //   969: astore 9
    //   971: aload_3
    //   972: astore 8
    //   974: aconst_null
    //   975: astore_3
    //   976: goto -503 -> 473
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	979	0	paramBitmap	android.graphics.Bitmap
    //   0	979	1	paramLong	long
    //   0	979	3	paramString	String
    //   351	268	4	i	int
    //   347	11	5	j	int
    //   20	795	6	bool1	boolean
    //   482	331	7	bool2	boolean
    //   9	964	8	localObject1	Object
    //   86	811	9	localObject2	Object
    //   918	6	9	localObject3	Object
    //   928	13	9	str1	String
    //   962	1	9	localException1	Exception
    //   969	1	9	localException2	Exception
    //   6	212	10	str2	String
    //   461	110	10	localException3	Exception
    //   893	9	10	localObject4	Object
    //   907	6	10	localObject5	Object
    //   921	6	10	str3	String
    //   937	9	10	localError1	Error
    //   951	6	10	localError2	Error
    //   234	303	11	localObject6	Object
    //   372	10	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   26	34	72	java/io/IOException
    //   38	57	72	java/io/IOException
    //   197	338	461	java/lang/Exception
    //   364	433	461	java/lang/Exception
    //   433	442	461	java/lang/Exception
    //   448	458	461	java/lang/Exception
    //   536	605	461	java/lang/Exception
    //   626	631	668	java/io/IOException
    //   635	654	668	java/io/IOException
    //   684	689	726	java/io/IOException
    //   693	712	726	java/io/IOException
    //   488	492	737	java/io/IOException
    //   496	515	737	java/io/IOException
    //   83	103	748	java/lang/Error
    //   770	775	819	java/io/IOException
    //   779	798	819	java/io/IOException
    //   83	103	830	finally
    //   842	847	882	java/io/IOException
    //   851	870	882	java/io/IOException
    //   103	197	893	finally
    //   197	338	907	finally
    //   364	433	907	finally
    //   433	442	907	finally
    //   448	458	907	finally
    //   536	605	907	finally
    //   473	481	918	finally
    //   755	762	933	finally
    //   103	197	937	java/lang/Error
    //   197	338	951	java/lang/Error
    //   364	433	951	java/lang/Error
    //   433	442	951	java/lang/Error
    //   448	458	951	java/lang/Error
    //   536	605	951	java/lang/Error
    //   83	103	962	java/lang/Exception
    //   103	197	969	java/lang/Exception
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */