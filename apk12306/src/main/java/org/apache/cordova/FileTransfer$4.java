package org.apache.cordova;

import java.net.URL;
import org.json.JSONObject;

class FileTransfer$4
  implements Runnable
{
  FileTransfer$4(FileTransfer paramFileTransfer, FileTransfer.RequestContext paramRequestContext, String paramString1, boolean paramBoolean1, boolean paramBoolean2, URL paramURL, String paramString2, JSONObject paramJSONObject, String paramString3) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4: getfield 64	org/apache/cordova/FileTransfer$RequestContext:aborted	Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: aconst_null
    //   12: astore 28
    //   14: aconst_null
    //   15: astore 30
    //   17: aconst_null
    //   18: astore 32
    //   20: aconst_null
    //   21: astore 33
    //   23: aconst_null
    //   24: astore 4
    //   26: aconst_null
    //   27: astore 34
    //   29: aconst_null
    //   30: astore 35
    //   32: aconst_null
    //   33: astore 36
    //   35: aconst_null
    //   36: astore 37
    //   38: aconst_null
    //   39: astore 38
    //   41: aconst_null
    //   42: astore 7
    //   44: aconst_null
    //   45: astore 39
    //   47: aconst_null
    //   48: astore 40
    //   50: aconst_null
    //   51: astore 41
    //   53: aconst_null
    //   54: astore 42
    //   56: aconst_null
    //   57: astore 43
    //   59: aconst_null
    //   60: astore 8
    //   62: aconst_null
    //   63: astore 21
    //   65: aconst_null
    //   66: astore 23
    //   68: aconst_null
    //   69: astore 25
    //   71: aconst_null
    //   72: astore 10
    //   74: aconst_null
    //   75: astore 20
    //   77: aconst_null
    //   78: astore 31
    //   80: aconst_null
    //   81: astore 29
    //   83: aload 4
    //   85: astore 22
    //   87: aload 34
    //   89: astore 13
    //   91: aload 39
    //   93: astore 12
    //   95: aload 28
    //   97: astore 24
    //   99: aload 35
    //   101: astore 15
    //   103: aload 40
    //   105: astore 14
    //   107: aload 30
    //   109: astore 26
    //   111: aload 36
    //   113: astore 19
    //   115: aload 41
    //   117: astore 18
    //   119: aload 32
    //   121: astore 27
    //   123: aload 37
    //   125: astore 17
    //   127: aload 42
    //   129: astore 16
    //   131: aload 33
    //   133: astore 9
    //   135: aload 38
    //   137: astore 5
    //   139: aload 43
    //   141: astore 6
    //   143: aload_0
    //   144: getfield 30	org/apache/cordova/FileTransfer$4:this$0	Lorg/apache/cordova/FileTransfer;
    //   147: aload_0
    //   148: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   151: invokestatic 68	org/apache/cordova/FileTransfer:access$800	(Lorg/apache/cordova/FileTransfer;Ljava/lang/String;)Ljava/io/File;
    //   154: astore 11
    //   156: aload 4
    //   158: astore 22
    //   160: aload 11
    //   162: astore 20
    //   164: aload 34
    //   166: astore 13
    //   168: aload 39
    //   170: astore 12
    //   172: aload 28
    //   174: astore 24
    //   176: aload 11
    //   178: astore 21
    //   180: aload 35
    //   182: astore 15
    //   184: aload 40
    //   186: astore 14
    //   188: aload 30
    //   190: astore 26
    //   192: aload 11
    //   194: astore 23
    //   196: aload 36
    //   198: astore 19
    //   200: aload 41
    //   202: astore 18
    //   204: aload 32
    //   206: astore 27
    //   208: aload 11
    //   210: astore 25
    //   212: aload 37
    //   214: astore 17
    //   216: aload 42
    //   218: astore 16
    //   220: aload 33
    //   222: astore 9
    //   224: aload 11
    //   226: astore 10
    //   228: aload 38
    //   230: astore 5
    //   232: aload 43
    //   234: astore 6
    //   236: aload_0
    //   237: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   240: aload 11
    //   242: putfield 72	org/apache/cordova/FileTransfer$RequestContext:targetFile	Ljava/io/File;
    //   245: aload 4
    //   247: astore 22
    //   249: aload 11
    //   251: astore 20
    //   253: aload 34
    //   255: astore 13
    //   257: aload 39
    //   259: astore 12
    //   261: aload 28
    //   263: astore 24
    //   265: aload 11
    //   267: astore 21
    //   269: aload 35
    //   271: astore 15
    //   273: aload 40
    //   275: astore 14
    //   277: aload 30
    //   279: astore 26
    //   281: aload 11
    //   283: astore 23
    //   285: aload 36
    //   287: astore 19
    //   289: aload 41
    //   291: astore 18
    //   293: aload 32
    //   295: astore 27
    //   297: aload 11
    //   299: astore 25
    //   301: aload 37
    //   303: astore 17
    //   305: aload 42
    //   307: astore 16
    //   309: aload 33
    //   311: astore 9
    //   313: aload 11
    //   315: astore 10
    //   317: aload 38
    //   319: astore 5
    //   321: aload 43
    //   323: astore 6
    //   325: aload 11
    //   327: invokevirtual 78	java/io/File:getParentFile	()Ljava/io/File;
    //   330: invokevirtual 82	java/io/File:mkdirs	()Z
    //   333: pop
    //   334: aload 4
    //   336: astore 22
    //   338: aload 11
    //   340: astore 20
    //   342: aload 34
    //   344: astore 13
    //   346: aload 39
    //   348: astore 12
    //   350: aload 28
    //   352: astore 24
    //   354: aload 11
    //   356: astore 21
    //   358: aload 35
    //   360: astore 15
    //   362: aload 40
    //   364: astore 14
    //   366: aload 30
    //   368: astore 26
    //   370: aload 11
    //   372: astore 23
    //   374: aload 36
    //   376: astore 19
    //   378: aload 41
    //   380: astore 18
    //   382: aload 32
    //   384: astore 27
    //   386: aload 11
    //   388: astore 25
    //   390: aload 37
    //   392: astore 17
    //   394: aload 42
    //   396: astore 16
    //   398: aload 33
    //   400: astore 9
    //   402: aload 11
    //   404: astore 10
    //   406: aload 38
    //   408: astore 5
    //   410: aload 43
    //   412: astore 6
    //   414: aload_0
    //   415: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   418: ifeq +2332 -> 2750
    //   421: aload 4
    //   423: astore 22
    //   425: aload 11
    //   427: astore 20
    //   429: aload 34
    //   431: astore 13
    //   433: aload 39
    //   435: astore 12
    //   437: aload 28
    //   439: astore 24
    //   441: aload 11
    //   443: astore 21
    //   445: aload 35
    //   447: astore 15
    //   449: aload 40
    //   451: astore 14
    //   453: aload 30
    //   455: astore 26
    //   457: aload 11
    //   459: astore 23
    //   461: aload 36
    //   463: astore 19
    //   465: aload 41
    //   467: astore 18
    //   469: aload 32
    //   471: astore 27
    //   473: aload 11
    //   475: astore 25
    //   477: aload 37
    //   479: astore 17
    //   481: aload 42
    //   483: astore 16
    //   485: aload 33
    //   487: astore 9
    //   489: aload 11
    //   491: astore 10
    //   493: aload 38
    //   495: astore 5
    //   497: aload 43
    //   499: astore 6
    //   501: aload_0
    //   502: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   505: ifne +1884 -> 2389
    //   508: aload 4
    //   510: astore 22
    //   512: aload 11
    //   514: astore 20
    //   516: aload 34
    //   518: astore 13
    //   520: aload 39
    //   522: astore 12
    //   524: aload 28
    //   526: astore 24
    //   528: aload 11
    //   530: astore 21
    //   532: aload 35
    //   534: astore 15
    //   536: aload 40
    //   538: astore 14
    //   540: aload 30
    //   542: astore 26
    //   544: aload 11
    //   546: astore 23
    //   548: aload 36
    //   550: astore 19
    //   552: aload 41
    //   554: astore 18
    //   556: aload 32
    //   558: astore 27
    //   560: aload 11
    //   562: astore 25
    //   564: aload 37
    //   566: astore 17
    //   568: aload 42
    //   570: astore 16
    //   572: aload 33
    //   574: astore 9
    //   576: aload 11
    //   578: astore 10
    //   580: aload 38
    //   582: astore 5
    //   584: aload 43
    //   586: astore 6
    //   588: aload_0
    //   589: getfield 40	org/apache/cordova/FileTransfer$4:val$url	Ljava/net/URL;
    //   592: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   595: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   598: astore 4
    //   600: aload 4
    //   602: astore 22
    //   604: aload 11
    //   606: astore 20
    //   608: aload 7
    //   610: astore 13
    //   612: aload 8
    //   614: astore 12
    //   616: aload 4
    //   618: astore 24
    //   620: aload 11
    //   622: astore 21
    //   624: aload 7
    //   626: astore 15
    //   628: aload 8
    //   630: astore 14
    //   632: aload 4
    //   634: astore 26
    //   636: aload 11
    //   638: astore 23
    //   640: aload 7
    //   642: astore 19
    //   644: aload 8
    //   646: astore 18
    //   648: aload 4
    //   650: astore 27
    //   652: aload 11
    //   654: astore 25
    //   656: aload 7
    //   658: astore 17
    //   660: aload 8
    //   662: astore 16
    //   664: aload 4
    //   666: astore 9
    //   668: aload 11
    //   670: astore 10
    //   672: aload 7
    //   674: astore 5
    //   676: aload 8
    //   678: astore 6
    //   680: aload 4
    //   682: instanceof 92
    //   685: ifeq +93 -> 778
    //   688: aload 4
    //   690: astore 22
    //   692: aload 11
    //   694: astore 20
    //   696: aload 7
    //   698: astore 13
    //   700: aload 8
    //   702: astore 12
    //   704: aload 4
    //   706: astore 24
    //   708: aload 11
    //   710: astore 21
    //   712: aload 7
    //   714: astore 15
    //   716: aload 8
    //   718: astore 14
    //   720: aload 4
    //   722: astore 26
    //   724: aload 11
    //   726: astore 23
    //   728: aload 7
    //   730: astore 19
    //   732: aload 8
    //   734: astore 18
    //   736: aload 4
    //   738: astore 27
    //   740: aload 11
    //   742: astore 25
    //   744: aload 7
    //   746: astore 17
    //   748: aload 8
    //   750: astore 16
    //   752: aload 4
    //   754: astore 9
    //   756: aload 11
    //   758: astore 10
    //   760: aload 7
    //   762: astore 5
    //   764: aload 8
    //   766: astore 6
    //   768: aload 4
    //   770: checkcast 92	java/net/HttpURLConnection
    //   773: ldc 94
    //   775: invokevirtual 98	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   778: aload 4
    //   780: astore 22
    //   782: aload 11
    //   784: astore 20
    //   786: aload 7
    //   788: astore 13
    //   790: aload 8
    //   792: astore 12
    //   794: aload 4
    //   796: astore 24
    //   798: aload 11
    //   800: astore 21
    //   802: aload 7
    //   804: astore 15
    //   806: aload 8
    //   808: astore 14
    //   810: aload 4
    //   812: astore 26
    //   814: aload 11
    //   816: astore 23
    //   818: aload 7
    //   820: astore 19
    //   822: aload 8
    //   824: astore 18
    //   826: aload 4
    //   828: astore 27
    //   830: aload 11
    //   832: astore 25
    //   834: aload 7
    //   836: astore 17
    //   838: aload 8
    //   840: astore 16
    //   842: aload 4
    //   844: astore 9
    //   846: aload 11
    //   848: astore 10
    //   850: aload 7
    //   852: astore 5
    //   854: aload 8
    //   856: astore 6
    //   858: invokestatic 104	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   861: aload_0
    //   862: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   865: invokevirtual 108	android/webkit/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   868: astore 28
    //   870: aload 28
    //   872: ifnull +92 -> 964
    //   875: aload 4
    //   877: astore 22
    //   879: aload 11
    //   881: astore 20
    //   883: aload 7
    //   885: astore 13
    //   887: aload 8
    //   889: astore 12
    //   891: aload 4
    //   893: astore 24
    //   895: aload 11
    //   897: astore 21
    //   899: aload 7
    //   901: astore 15
    //   903: aload 8
    //   905: astore 14
    //   907: aload 4
    //   909: astore 26
    //   911: aload 11
    //   913: astore 23
    //   915: aload 7
    //   917: astore 19
    //   919: aload 8
    //   921: astore 18
    //   923: aload 4
    //   925: astore 27
    //   927: aload 11
    //   929: astore 25
    //   931: aload 7
    //   933: astore 17
    //   935: aload 8
    //   937: astore 16
    //   939: aload 4
    //   941: astore 9
    //   943: aload 11
    //   945: astore 10
    //   947: aload 7
    //   949: astore 5
    //   951: aload 8
    //   953: astore 6
    //   955: aload 4
    //   957: ldc 110
    //   959: aload 28
    //   961: invokevirtual 116	java/net/URLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   964: aload 4
    //   966: astore 22
    //   968: aload 11
    //   970: astore 20
    //   972: aload 7
    //   974: astore 13
    //   976: aload 8
    //   978: astore 12
    //   980: aload 4
    //   982: astore 24
    //   984: aload 11
    //   986: astore 21
    //   988: aload 7
    //   990: astore 15
    //   992: aload 8
    //   994: astore 14
    //   996: aload 4
    //   998: astore 26
    //   1000: aload 11
    //   1002: astore 23
    //   1004: aload 7
    //   1006: astore 19
    //   1008: aload 8
    //   1010: astore 18
    //   1012: aload 4
    //   1014: astore 27
    //   1016: aload 11
    //   1018: astore 25
    //   1020: aload 7
    //   1022: astore 17
    //   1024: aload 8
    //   1026: astore 16
    //   1028: aload 4
    //   1030: astore 9
    //   1032: aload 11
    //   1034: astore 10
    //   1036: aload 7
    //   1038: astore 5
    //   1040: aload 8
    //   1042: astore 6
    //   1044: aload_0
    //   1045: getfield 44	org/apache/cordova/FileTransfer$4:val$headers	Lorg/json/JSONObject;
    //   1048: ifnull +92 -> 1140
    //   1051: aload 4
    //   1053: astore 22
    //   1055: aload 11
    //   1057: astore 20
    //   1059: aload 7
    //   1061: astore 13
    //   1063: aload 8
    //   1065: astore 12
    //   1067: aload 4
    //   1069: astore 24
    //   1071: aload 11
    //   1073: astore 21
    //   1075: aload 7
    //   1077: astore 15
    //   1079: aload 8
    //   1081: astore 14
    //   1083: aload 4
    //   1085: astore 26
    //   1087: aload 11
    //   1089: astore 23
    //   1091: aload 7
    //   1093: astore 19
    //   1095: aload 8
    //   1097: astore 18
    //   1099: aload 4
    //   1101: astore 27
    //   1103: aload 11
    //   1105: astore 25
    //   1107: aload 7
    //   1109: astore 17
    //   1111: aload 8
    //   1113: astore 16
    //   1115: aload 4
    //   1117: astore 9
    //   1119: aload 11
    //   1121: astore 10
    //   1123: aload 7
    //   1125: astore 5
    //   1127: aload 8
    //   1129: astore 6
    //   1131: aload 4
    //   1133: aload_0
    //   1134: getfield 44	org/apache/cordova/FileTransfer$4:val$headers	Lorg/json/JSONObject;
    //   1137: invokestatic 120	org/apache/cordova/FileTransfer:access$200	(Ljava/net/URLConnection;Lorg/json/JSONObject;)V
    //   1140: aload 4
    //   1142: astore 22
    //   1144: aload 11
    //   1146: astore 20
    //   1148: aload 7
    //   1150: astore 13
    //   1152: aload 8
    //   1154: astore 12
    //   1156: aload 4
    //   1158: astore 24
    //   1160: aload 11
    //   1162: astore 21
    //   1164: aload 7
    //   1166: astore 15
    //   1168: aload 8
    //   1170: astore 14
    //   1172: aload 4
    //   1174: astore 26
    //   1176: aload 11
    //   1178: astore 23
    //   1180: aload 7
    //   1182: astore 19
    //   1184: aload 8
    //   1186: astore 18
    //   1188: aload 4
    //   1190: astore 27
    //   1192: aload 11
    //   1194: astore 25
    //   1196: aload 7
    //   1198: astore 17
    //   1200: aload 8
    //   1202: astore 16
    //   1204: aload 4
    //   1206: astore 9
    //   1208: aload 11
    //   1210: astore 10
    //   1212: aload 7
    //   1214: astore 5
    //   1216: aload 8
    //   1218: astore 6
    //   1220: aload 4
    //   1222: invokevirtual 123	java/net/URLConnection:connect	()V
    //   1225: aload 4
    //   1227: astore 22
    //   1229: aload 11
    //   1231: astore 20
    //   1233: aload 7
    //   1235: astore 13
    //   1237: aload 8
    //   1239: astore 12
    //   1241: aload 4
    //   1243: astore 24
    //   1245: aload 11
    //   1247: astore 21
    //   1249: aload 7
    //   1251: astore 15
    //   1253: aload 8
    //   1255: astore 14
    //   1257: aload 4
    //   1259: astore 26
    //   1261: aload 11
    //   1263: astore 23
    //   1265: aload 7
    //   1267: astore 19
    //   1269: aload 8
    //   1271: astore 18
    //   1273: aload 4
    //   1275: astore 27
    //   1277: aload 11
    //   1279: astore 25
    //   1281: aload 7
    //   1283: astore 17
    //   1285: aload 8
    //   1287: astore 16
    //   1289: aload 4
    //   1291: astore 9
    //   1293: aload 11
    //   1295: astore 10
    //   1297: aload 7
    //   1299: astore 5
    //   1301: aload 8
    //   1303: astore 6
    //   1305: new 125	java/lang/StringBuilder
    //   1308: astore 28
    //   1310: aload 4
    //   1312: astore 22
    //   1314: aload 11
    //   1316: astore 20
    //   1318: aload 7
    //   1320: astore 13
    //   1322: aload 8
    //   1324: astore 12
    //   1326: aload 4
    //   1328: astore 24
    //   1330: aload 11
    //   1332: astore 21
    //   1334: aload 7
    //   1336: astore 15
    //   1338: aload 8
    //   1340: astore 14
    //   1342: aload 4
    //   1344: astore 26
    //   1346: aload 11
    //   1348: astore 23
    //   1350: aload 7
    //   1352: astore 19
    //   1354: aload 8
    //   1356: astore 18
    //   1358: aload 4
    //   1360: astore 27
    //   1362: aload 11
    //   1364: astore 25
    //   1366: aload 7
    //   1368: astore 17
    //   1370: aload 8
    //   1372: astore 16
    //   1374: aload 4
    //   1376: astore 9
    //   1378: aload 11
    //   1380: astore 10
    //   1382: aload 7
    //   1384: astore 5
    //   1386: aload 8
    //   1388: astore 6
    //   1390: aload 28
    //   1392: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1395: aload 4
    //   1397: astore 22
    //   1399: aload 11
    //   1401: astore 20
    //   1403: aload 7
    //   1405: astore 13
    //   1407: aload 8
    //   1409: astore 12
    //   1411: aload 4
    //   1413: astore 24
    //   1415: aload 11
    //   1417: astore 21
    //   1419: aload 7
    //   1421: astore 15
    //   1423: aload 8
    //   1425: astore 14
    //   1427: aload 4
    //   1429: astore 26
    //   1431: aload 11
    //   1433: astore 23
    //   1435: aload 7
    //   1437: astore 19
    //   1439: aload 8
    //   1441: astore 18
    //   1443: aload 4
    //   1445: astore 27
    //   1447: aload 11
    //   1449: astore 25
    //   1451: aload 7
    //   1453: astore 17
    //   1455: aload 8
    //   1457: astore 16
    //   1459: aload 4
    //   1461: astore 9
    //   1463: aload 11
    //   1465: astore 10
    //   1467: aload 7
    //   1469: astore 5
    //   1471: aload 8
    //   1473: astore 6
    //   1475: ldc -128
    //   1477: aload 28
    //   1479: ldc -126
    //   1481: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: aload_0
    //   1485: getfield 40	org/apache/cordova/FileTransfer$4:val$url	Ljava/net/URL;
    //   1488: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1491: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1494: invokestatic 147	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   1497: pop
    //   1498: aload 4
    //   1500: astore 22
    //   1502: aload 11
    //   1504: astore 20
    //   1506: aload 7
    //   1508: astore 13
    //   1510: aload 8
    //   1512: astore 12
    //   1514: aload 4
    //   1516: astore 24
    //   1518: aload 11
    //   1520: astore 21
    //   1522: aload 7
    //   1524: astore 15
    //   1526: aload 8
    //   1528: astore 14
    //   1530: aload 4
    //   1532: astore 26
    //   1534: aload 11
    //   1536: astore 23
    //   1538: aload 7
    //   1540: astore 19
    //   1542: aload 8
    //   1544: astore 18
    //   1546: aload 4
    //   1548: astore 27
    //   1550: aload 11
    //   1552: astore 25
    //   1554: aload 7
    //   1556: astore 17
    //   1558: aload 8
    //   1560: astore 16
    //   1562: aload 4
    //   1564: astore 9
    //   1566: aload 11
    //   1568: astore 10
    //   1570: aload 7
    //   1572: astore 5
    //   1574: aload 8
    //   1576: astore 6
    //   1578: new 149	org/apache/cordova/FileProgressResult
    //   1581: astore 32
    //   1583: aload 4
    //   1585: astore 22
    //   1587: aload 11
    //   1589: astore 20
    //   1591: aload 7
    //   1593: astore 13
    //   1595: aload 8
    //   1597: astore 12
    //   1599: aload 4
    //   1601: astore 24
    //   1603: aload 11
    //   1605: astore 21
    //   1607: aload 7
    //   1609: astore 15
    //   1611: aload 8
    //   1613: astore 14
    //   1615: aload 4
    //   1617: astore 26
    //   1619: aload 11
    //   1621: astore 23
    //   1623: aload 7
    //   1625: astore 19
    //   1627: aload 8
    //   1629: astore 18
    //   1631: aload 4
    //   1633: astore 27
    //   1635: aload 11
    //   1637: astore 25
    //   1639: aload 7
    //   1641: astore 17
    //   1643: aload 8
    //   1645: astore 16
    //   1647: aload 4
    //   1649: astore 9
    //   1651: aload 11
    //   1653: astore 10
    //   1655: aload 7
    //   1657: astore 5
    //   1659: aload 8
    //   1661: astore 6
    //   1663: aload 32
    //   1665: invokespecial 150	org/apache/cordova/FileProgressResult:<init>	()V
    //   1668: aload 4
    //   1670: astore 22
    //   1672: aload 11
    //   1674: astore 20
    //   1676: aload 7
    //   1678: astore 13
    //   1680: aload 8
    //   1682: astore 12
    //   1684: aload 4
    //   1686: astore 24
    //   1688: aload 11
    //   1690: astore 21
    //   1692: aload 7
    //   1694: astore 15
    //   1696: aload 8
    //   1698: astore 14
    //   1700: aload 4
    //   1702: astore 26
    //   1704: aload 11
    //   1706: astore 23
    //   1708: aload 7
    //   1710: astore 19
    //   1712: aload 8
    //   1714: astore 18
    //   1716: aload 4
    //   1718: astore 27
    //   1720: aload 11
    //   1722: astore 25
    //   1724: aload 7
    //   1726: astore 17
    //   1728: aload 8
    //   1730: astore 16
    //   1732: aload 4
    //   1734: astore 9
    //   1736: aload 11
    //   1738: astore 10
    //   1740: aload 7
    //   1742: astore 5
    //   1744: aload 8
    //   1746: astore 6
    //   1748: aload 4
    //   1750: invokevirtual 153	java/net/URLConnection:getContentEncoding	()Ljava/lang/String;
    //   1753: ifnonnull +180 -> 1933
    //   1756: aload 4
    //   1758: astore 22
    //   1760: aload 11
    //   1762: astore 20
    //   1764: aload 7
    //   1766: astore 13
    //   1768: aload 8
    //   1770: astore 12
    //   1772: aload 4
    //   1774: astore 24
    //   1776: aload 11
    //   1778: astore 21
    //   1780: aload 7
    //   1782: astore 15
    //   1784: aload 8
    //   1786: astore 14
    //   1788: aload 4
    //   1790: astore 26
    //   1792: aload 11
    //   1794: astore 23
    //   1796: aload 7
    //   1798: astore 19
    //   1800: aload 8
    //   1802: astore 18
    //   1804: aload 4
    //   1806: astore 27
    //   1808: aload 11
    //   1810: astore 25
    //   1812: aload 7
    //   1814: astore 17
    //   1816: aload 8
    //   1818: astore 16
    //   1820: aload 4
    //   1822: astore 9
    //   1824: aload 11
    //   1826: astore 10
    //   1828: aload 7
    //   1830: astore 5
    //   1832: aload 8
    //   1834: astore 6
    //   1836: aload 32
    //   1838: iconst_1
    //   1839: invokevirtual 157	org/apache/cordova/FileProgressResult:setLengthComputable	(Z)V
    //   1842: aload 4
    //   1844: astore 22
    //   1846: aload 11
    //   1848: astore 20
    //   1850: aload 7
    //   1852: astore 13
    //   1854: aload 8
    //   1856: astore 12
    //   1858: aload 4
    //   1860: astore 24
    //   1862: aload 11
    //   1864: astore 21
    //   1866: aload 7
    //   1868: astore 15
    //   1870: aload 8
    //   1872: astore 14
    //   1874: aload 4
    //   1876: astore 26
    //   1878: aload 11
    //   1880: astore 23
    //   1882: aload 7
    //   1884: astore 19
    //   1886: aload 8
    //   1888: astore 18
    //   1890: aload 4
    //   1892: astore 27
    //   1894: aload 11
    //   1896: astore 25
    //   1898: aload 7
    //   1900: astore 17
    //   1902: aload 8
    //   1904: astore 16
    //   1906: aload 4
    //   1908: astore 9
    //   1910: aload 11
    //   1912: astore 10
    //   1914: aload 7
    //   1916: astore 5
    //   1918: aload 8
    //   1920: astore 6
    //   1922: aload 32
    //   1924: aload 4
    //   1926: invokevirtual 161	java/net/URLConnection:getContentLength	()I
    //   1929: i2l
    //   1930: invokevirtual 165	org/apache/cordova/FileProgressResult:setTotal	(J)V
    //   1933: aconst_null
    //   1934: astore 6
    //   1936: aconst_null
    //   1937: astore 5
    //   1939: aload 4
    //   1941: invokestatic 169	org/apache/cordova/FileTransfer:access$500	(Ljava/net/URLConnection;)Ljava/io/InputStream;
    //   1944: astore 28
    //   1946: aload 28
    //   1948: astore 5
    //   1950: new 171	java/io/FileOutputStream
    //   1953: astore 30
    //   1955: aload 28
    //   1957: astore 5
    //   1959: aload 30
    //   1961: aload 11
    //   1963: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   1966: aload_0
    //   1967: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   1970: astore 5
    //   1972: aload 5
    //   1974: monitorenter
    //   1975: aload_0
    //   1976: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   1979: getfield 64	org/apache/cordova/FileTransfer$RequestContext:aborted	Z
    //   1982: ifeq +860 -> 2842
    //   1985: aload 5
    //   1987: monitorexit
    //   1988: aload 4
    //   1990: astore 22
    //   1992: aload 11
    //   1994: astore 20
    //   1996: aload 7
    //   1998: astore 13
    //   2000: aload 8
    //   2002: astore 12
    //   2004: aload 4
    //   2006: astore 24
    //   2008: aload 11
    //   2010: astore 21
    //   2012: aload 7
    //   2014: astore 15
    //   2016: aload 8
    //   2018: astore 14
    //   2020: aload 4
    //   2022: astore 26
    //   2024: aload 11
    //   2026: astore 23
    //   2028: aload 7
    //   2030: astore 19
    //   2032: aload 8
    //   2034: astore 18
    //   2036: aload 4
    //   2038: astore 27
    //   2040: aload 11
    //   2042: astore 25
    //   2044: aload 7
    //   2046: astore 17
    //   2048: aload 8
    //   2050: astore 16
    //   2052: aload 4
    //   2054: astore 9
    //   2056: aload 11
    //   2058: astore 10
    //   2060: aload 7
    //   2062: astore 5
    //   2064: aload 8
    //   2066: astore 6
    //   2068: aload_0
    //   2069: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   2072: aconst_null
    //   2073: putfield 178	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   2076: aload 4
    //   2078: astore 22
    //   2080: aload 11
    //   2082: astore 20
    //   2084: aload 7
    //   2086: astore 13
    //   2088: aload 8
    //   2090: astore 12
    //   2092: aload 4
    //   2094: astore 24
    //   2096: aload 11
    //   2098: astore 21
    //   2100: aload 7
    //   2102: astore 15
    //   2104: aload 8
    //   2106: astore 14
    //   2108: aload 4
    //   2110: astore 26
    //   2112: aload 11
    //   2114: astore 23
    //   2116: aload 7
    //   2118: astore 19
    //   2120: aload 8
    //   2122: astore 18
    //   2124: aload 4
    //   2126: astore 27
    //   2128: aload 11
    //   2130: astore 25
    //   2132: aload 7
    //   2134: astore 17
    //   2136: aload 8
    //   2138: astore 16
    //   2140: aload 4
    //   2142: astore 9
    //   2144: aload 11
    //   2146: astore 10
    //   2148: aload 7
    //   2150: astore 5
    //   2152: aload 8
    //   2154: astore 6
    //   2156: aload 28
    //   2158: invokestatic 182	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   2161: aload 4
    //   2163: astore 22
    //   2165: aload 11
    //   2167: astore 20
    //   2169: aload 7
    //   2171: astore 13
    //   2173: aload 8
    //   2175: astore 12
    //   2177: aload 4
    //   2179: astore 24
    //   2181: aload 11
    //   2183: astore 21
    //   2185: aload 7
    //   2187: astore 15
    //   2189: aload 8
    //   2191: astore 14
    //   2193: aload 4
    //   2195: astore 26
    //   2197: aload 11
    //   2199: astore 23
    //   2201: aload 7
    //   2203: astore 19
    //   2205: aload 8
    //   2207: astore 18
    //   2209: aload 4
    //   2211: astore 27
    //   2213: aload 11
    //   2215: astore 25
    //   2217: aload 7
    //   2219: astore 17
    //   2221: aload 8
    //   2223: astore 16
    //   2225: aload 4
    //   2227: astore 9
    //   2229: aload 11
    //   2231: astore 10
    //   2233: aload 7
    //   2235: astore 5
    //   2237: aload 8
    //   2239: astore 6
    //   2241: aload 30
    //   2243: invokestatic 182	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   2246: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   2249: astore 5
    //   2251: aload 5
    //   2253: monitorenter
    //   2254: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   2257: aload_0
    //   2258: getfield 46	org/apache/cordova/FileTransfer$4:val$objectId	Ljava/lang/String;
    //   2261: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2264: pop
    //   2265: aload 5
    //   2267: monitorexit
    //   2268: aload 4
    //   2270: ifnull +38 -> 2308
    //   2273: aload_0
    //   2274: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   2277: ifeq +31 -> 2308
    //   2280: aload_0
    //   2281: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   2284: ifeq +24 -> 2308
    //   2287: aload 4
    //   2289: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   2292: astore 5
    //   2294: aload 5
    //   2296: aload 7
    //   2298: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   2301: aload 5
    //   2303: aload 8
    //   2305: invokevirtual 200	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   2308: aload 29
    //   2310: astore 6
    //   2312: iconst_0
    //   2313: ifne +31 -> 2344
    //   2316: new 202	org/apache/cordova/api/PluginResult
    //   2319: dup
    //   2320: getstatic 208	org/apache/cordova/api/PluginResult$Status:ERROR	Lorg/apache/cordova/api/PluginResult$Status;
    //   2323: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   2326: aload_0
    //   2327: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   2330: aload_0
    //   2331: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   2334: aload 4
    //   2336: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   2339: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   2342: astore 6
    //   2344: aload 6
    //   2346: invokevirtual 222	org/apache/cordova/api/PluginResult:getStatus	()I
    //   2349: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   2352: invokevirtual 228	org/apache/cordova/api/PluginResult$Status:ordinal	()I
    //   2355: if_icmpeq +14 -> 2369
    //   2358: aload 11
    //   2360: ifnull +9 -> 2369
    //   2363: aload 11
    //   2365: invokevirtual 231	java/io/File:delete	()Z
    //   2368: pop
    //   2369: aload_0
    //   2370: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   2373: astore 5
    //   2375: aload 6
    //   2377: astore 4
    //   2379: aload 5
    //   2381: aload 4
    //   2383: invokevirtual 235	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   2386: goto -2376 -> 10
    //   2389: aload 4
    //   2391: astore 22
    //   2393: aload 11
    //   2395: astore 20
    //   2397: aload 34
    //   2399: astore 13
    //   2401: aload 39
    //   2403: astore 12
    //   2405: aload 28
    //   2407: astore 24
    //   2409: aload 11
    //   2411: astore 21
    //   2413: aload 35
    //   2415: astore 15
    //   2417: aload 40
    //   2419: astore 14
    //   2421: aload 30
    //   2423: astore 26
    //   2425: aload 11
    //   2427: astore 23
    //   2429: aload 36
    //   2431: astore 19
    //   2433: aload 41
    //   2435: astore 18
    //   2437: aload 32
    //   2439: astore 27
    //   2441: aload 11
    //   2443: astore 25
    //   2445: aload 37
    //   2447: astore 17
    //   2449: aload 42
    //   2451: astore 16
    //   2453: aload 33
    //   2455: astore 9
    //   2457: aload 11
    //   2459: astore 10
    //   2461: aload 38
    //   2463: astore 5
    //   2465: aload 43
    //   2467: astore 6
    //   2469: aload_0
    //   2470: getfield 40	org/apache/cordova/FileTransfer$4:val$url	Ljava/net/URL;
    //   2473: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   2476: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   2479: astore 44
    //   2481: aload 4
    //   2483: astore 22
    //   2485: aload 11
    //   2487: astore 20
    //   2489: aload 34
    //   2491: astore 13
    //   2493: aload 39
    //   2495: astore 12
    //   2497: aload 28
    //   2499: astore 24
    //   2501: aload 11
    //   2503: astore 21
    //   2505: aload 35
    //   2507: astore 15
    //   2509: aload 40
    //   2511: astore 14
    //   2513: aload 30
    //   2515: astore 26
    //   2517: aload 11
    //   2519: astore 23
    //   2521: aload 36
    //   2523: astore 19
    //   2525: aload 41
    //   2527: astore 18
    //   2529: aload 32
    //   2531: astore 27
    //   2533: aload 11
    //   2535: astore 25
    //   2537: aload 37
    //   2539: astore 17
    //   2541: aload 42
    //   2543: astore 16
    //   2545: aload 33
    //   2547: astore 9
    //   2549: aload 11
    //   2551: astore 10
    //   2553: aload 38
    //   2555: astore 5
    //   2557: aload 43
    //   2559: astore 6
    //   2561: aload 44
    //   2563: invokestatic 239	org/apache/cordova/FileTransfer:access$000	(Ljavax/net/ssl/HttpsURLConnection;)Ljavax/net/ssl/SSLSocketFactory;
    //   2566: astore 8
    //   2568: aload 4
    //   2570: astore 22
    //   2572: aload 11
    //   2574: astore 20
    //   2576: aload 34
    //   2578: astore 13
    //   2580: aload 8
    //   2582: astore 12
    //   2584: aload 28
    //   2586: astore 24
    //   2588: aload 11
    //   2590: astore 21
    //   2592: aload 35
    //   2594: astore 15
    //   2596: aload 8
    //   2598: astore 14
    //   2600: aload 30
    //   2602: astore 26
    //   2604: aload 11
    //   2606: astore 23
    //   2608: aload 36
    //   2610: astore 19
    //   2612: aload 8
    //   2614: astore 18
    //   2616: aload 32
    //   2618: astore 27
    //   2620: aload 11
    //   2622: astore 25
    //   2624: aload 37
    //   2626: astore 17
    //   2628: aload 8
    //   2630: astore 16
    //   2632: aload 33
    //   2634: astore 9
    //   2636: aload 11
    //   2638: astore 10
    //   2640: aload 38
    //   2642: astore 5
    //   2644: aload 8
    //   2646: astore 6
    //   2648: aload 44
    //   2650: invokevirtual 243	javax/net/ssl/HttpsURLConnection:getHostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   2653: astore 7
    //   2655: aload 4
    //   2657: astore 22
    //   2659: aload 11
    //   2661: astore 20
    //   2663: aload 7
    //   2665: astore 13
    //   2667: aload 8
    //   2669: astore 12
    //   2671: aload 28
    //   2673: astore 24
    //   2675: aload 11
    //   2677: astore 21
    //   2679: aload 7
    //   2681: astore 15
    //   2683: aload 8
    //   2685: astore 14
    //   2687: aload 30
    //   2689: astore 26
    //   2691: aload 11
    //   2693: astore 23
    //   2695: aload 7
    //   2697: astore 19
    //   2699: aload 8
    //   2701: astore 18
    //   2703: aload 32
    //   2705: astore 27
    //   2707: aload 11
    //   2709: astore 25
    //   2711: aload 7
    //   2713: astore 17
    //   2715: aload 8
    //   2717: astore 16
    //   2719: aload 33
    //   2721: astore 9
    //   2723: aload 11
    //   2725: astore 10
    //   2727: aload 7
    //   2729: astore 5
    //   2731: aload 8
    //   2733: astore 6
    //   2735: aload 44
    //   2737: invokestatic 246	org/apache/cordova/FileTransfer:access$100	()Ljavax/net/ssl/HostnameVerifier;
    //   2740: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   2743: aload 44
    //   2745: astore 4
    //   2747: goto -2147 -> 600
    //   2750: aload 4
    //   2752: astore 22
    //   2754: aload 11
    //   2756: astore 20
    //   2758: aload 34
    //   2760: astore 13
    //   2762: aload 39
    //   2764: astore 12
    //   2766: aload 28
    //   2768: astore 24
    //   2770: aload 11
    //   2772: astore 21
    //   2774: aload 35
    //   2776: astore 15
    //   2778: aload 40
    //   2780: astore 14
    //   2782: aload 30
    //   2784: astore 26
    //   2786: aload 11
    //   2788: astore 23
    //   2790: aload 36
    //   2792: astore 19
    //   2794: aload 41
    //   2796: astore 18
    //   2798: aload 32
    //   2800: astore 27
    //   2802: aload 11
    //   2804: astore 25
    //   2806: aload 37
    //   2808: astore 17
    //   2810: aload 42
    //   2812: astore 16
    //   2814: aload 33
    //   2816: astore 9
    //   2818: aload 11
    //   2820: astore 10
    //   2822: aload 38
    //   2824: astore 5
    //   2826: aload 43
    //   2828: astore 6
    //   2830: aload_0
    //   2831: getfield 40	org/apache/cordova/FileTransfer$4:val$url	Ljava/net/URL;
    //   2834: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   2837: astore 4
    //   2839: goto -2239 -> 600
    //   2842: aload_0
    //   2843: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   2846: aload 28
    //   2848: putfield 178	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   2851: aload 5
    //   2853: monitorexit
    //   2854: sipush 16384
    //   2857: newarray <illegal type>
    //   2859: astore 5
    //   2861: lconst_0
    //   2862: lstore_2
    //   2863: aload 28
    //   2865: aload 5
    //   2867: invokevirtual 252	java/io/InputStream:read	([B)I
    //   2870: istore_1
    //   2871: iload_1
    //   2872: ifle +634 -> 3506
    //   2875: aload 30
    //   2877: aload 5
    //   2879: iconst_0
    //   2880: iload_1
    //   2881: invokevirtual 256	java/io/FileOutputStream:write	([BII)V
    //   2884: lload_2
    //   2885: iload_1
    //   2886: i2l
    //   2887: ladd
    //   2888: lstore_2
    //   2889: aload 32
    //   2891: lload_2
    //   2892: invokevirtual 259	org/apache/cordova/FileProgressResult:setLoaded	(J)V
    //   2895: new 202	org/apache/cordova/api/PluginResult
    //   2898: astore 6
    //   2900: aload 6
    //   2902: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   2905: aload 32
    //   2907: invokevirtual 263	org/apache/cordova/FileProgressResult:toJSONObject	()Lorg/json/JSONObject;
    //   2910: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   2913: aload 6
    //   2915: iconst_1
    //   2916: invokevirtual 266	org/apache/cordova/api/PluginResult:setKeepCallback	(Z)V
    //   2919: aload_0
    //   2920: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   2923: aload 6
    //   2925: invokevirtual 235	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   2928: goto -65 -> 2863
    //   2931: astore 29
    //   2933: aload 4
    //   2935: astore 22
    //   2937: aload 11
    //   2939: astore 20
    //   2941: aload 7
    //   2943: astore 13
    //   2945: aload 8
    //   2947: astore 12
    //   2949: aload 4
    //   2951: astore 24
    //   2953: aload 11
    //   2955: astore 21
    //   2957: aload 7
    //   2959: astore 15
    //   2961: aload 8
    //   2963: astore 14
    //   2965: aload 4
    //   2967: astore 26
    //   2969: aload 11
    //   2971: astore 23
    //   2973: aload 7
    //   2975: astore 19
    //   2977: aload 8
    //   2979: astore 18
    //   2981: aload 4
    //   2983: astore 27
    //   2985: aload 11
    //   2987: astore 25
    //   2989: aload 7
    //   2991: astore 17
    //   2993: aload 8
    //   2995: astore 16
    //   2997: aload 4
    //   2999: astore 9
    //   3001: aload 11
    //   3003: astore 10
    //   3005: aload 7
    //   3007: astore 5
    //   3009: aload 8
    //   3011: astore 6
    //   3013: aload_0
    //   3014: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   3017: aconst_null
    //   3018: putfield 178	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   3021: aload 4
    //   3023: astore 22
    //   3025: aload 11
    //   3027: astore 20
    //   3029: aload 7
    //   3031: astore 13
    //   3033: aload 8
    //   3035: astore 12
    //   3037: aload 4
    //   3039: astore 24
    //   3041: aload 11
    //   3043: astore 21
    //   3045: aload 7
    //   3047: astore 15
    //   3049: aload 8
    //   3051: astore 14
    //   3053: aload 4
    //   3055: astore 26
    //   3057: aload 11
    //   3059: astore 23
    //   3061: aload 7
    //   3063: astore 19
    //   3065: aload 8
    //   3067: astore 18
    //   3069: aload 4
    //   3071: astore 27
    //   3073: aload 11
    //   3075: astore 25
    //   3077: aload 7
    //   3079: astore 17
    //   3081: aload 8
    //   3083: astore 16
    //   3085: aload 4
    //   3087: astore 9
    //   3089: aload 11
    //   3091: astore 10
    //   3093: aload 7
    //   3095: astore 5
    //   3097: aload 8
    //   3099: astore 6
    //   3101: aload 28
    //   3103: invokestatic 182	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   3106: aload 4
    //   3108: astore 22
    //   3110: aload 11
    //   3112: astore 20
    //   3114: aload 7
    //   3116: astore 13
    //   3118: aload 8
    //   3120: astore 12
    //   3122: aload 4
    //   3124: astore 24
    //   3126: aload 11
    //   3128: astore 21
    //   3130: aload 7
    //   3132: astore 15
    //   3134: aload 8
    //   3136: astore 14
    //   3138: aload 4
    //   3140: astore 26
    //   3142: aload 11
    //   3144: astore 23
    //   3146: aload 7
    //   3148: astore 19
    //   3150: aload 8
    //   3152: astore 18
    //   3154: aload 4
    //   3156: astore 27
    //   3158: aload 11
    //   3160: astore 25
    //   3162: aload 7
    //   3164: astore 17
    //   3166: aload 8
    //   3168: astore 16
    //   3170: aload 4
    //   3172: astore 9
    //   3174: aload 11
    //   3176: astore 10
    //   3178: aload 7
    //   3180: astore 5
    //   3182: aload 8
    //   3184: astore 6
    //   3186: aload 30
    //   3188: invokestatic 182	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   3191: aload 4
    //   3193: astore 22
    //   3195: aload 11
    //   3197: astore 20
    //   3199: aload 7
    //   3201: astore 13
    //   3203: aload 8
    //   3205: astore 12
    //   3207: aload 4
    //   3209: astore 24
    //   3211: aload 11
    //   3213: astore 21
    //   3215: aload 7
    //   3217: astore 15
    //   3219: aload 8
    //   3221: astore 14
    //   3223: aload 4
    //   3225: astore 26
    //   3227: aload 11
    //   3229: astore 23
    //   3231: aload 7
    //   3233: astore 19
    //   3235: aload 8
    //   3237: astore 18
    //   3239: aload 4
    //   3241: astore 27
    //   3243: aload 11
    //   3245: astore 25
    //   3247: aload 7
    //   3249: astore 17
    //   3251: aload 8
    //   3253: astore 16
    //   3255: aload 4
    //   3257: astore 9
    //   3259: aload 11
    //   3261: astore 10
    //   3263: aload 7
    //   3265: astore 5
    //   3267: aload 8
    //   3269: astore 6
    //   3271: aload 29
    //   3273: athrow
    //   3274: astore 7
    //   3276: aload 22
    //   3278: astore 9
    //   3280: aload 20
    //   3282: astore 10
    //   3284: aload 13
    //   3286: astore 5
    //   3288: aload 12
    //   3290: astore 6
    //   3292: getstatic 269	org/apache/cordova/FileTransfer:FILE_NOT_FOUND_ERR	I
    //   3295: aload_0
    //   3296: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   3299: aload_0
    //   3300: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   3303: aload 22
    //   3305: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   3308: astore 4
    //   3310: aload 22
    //   3312: astore 9
    //   3314: aload 20
    //   3316: astore 10
    //   3318: aload 13
    //   3320: astore 5
    //   3322: aload 12
    //   3324: astore 6
    //   3326: ldc -128
    //   3328: aload 4
    //   3330: invokevirtual 272	org/json/JSONObject:toString	()Ljava/lang/String;
    //   3333: aload 7
    //   3335: invokestatic 276	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   3338: pop
    //   3339: aload 22
    //   3341: astore 9
    //   3343: aload 20
    //   3345: astore 10
    //   3347: aload 13
    //   3349: astore 5
    //   3351: aload 12
    //   3353: astore 6
    //   3355: new 202	org/apache/cordova/api/PluginResult
    //   3358: dup
    //   3359: getstatic 279	org/apache/cordova/api/PluginResult$Status:IO_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   3362: aload 4
    //   3364: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   3367: astore 4
    //   3369: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   3372: astore 5
    //   3374: aload 5
    //   3376: monitorenter
    //   3377: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   3380: aload_0
    //   3381: getfield 46	org/apache/cordova/FileTransfer$4:val$objectId	Ljava/lang/String;
    //   3384: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3387: pop
    //   3388: aload 5
    //   3390: monitorexit
    //   3391: aload 22
    //   3393: ifnull +38 -> 3431
    //   3396: aload_0
    //   3397: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   3400: ifeq +31 -> 3431
    //   3403: aload_0
    //   3404: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   3407: ifeq +24 -> 3431
    //   3410: aload 22
    //   3412: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   3415: astore 5
    //   3417: aload 5
    //   3419: aload 13
    //   3421: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   3424: aload 5
    //   3426: aload 12
    //   3428: invokevirtual 200	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   3431: aload 4
    //   3433: ifnonnull +1773 -> 5206
    //   3436: new 202	org/apache/cordova/api/PluginResult
    //   3439: dup
    //   3440: getstatic 208	org/apache/cordova/api/PluginResult$Status:ERROR	Lorg/apache/cordova/api/PluginResult$Status;
    //   3443: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   3446: aload_0
    //   3447: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   3450: aload_0
    //   3451: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   3454: aload 22
    //   3456: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   3459: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   3462: astore 4
    //   3464: aload 4
    //   3466: invokevirtual 222	org/apache/cordova/api/PluginResult:getStatus	()I
    //   3469: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   3472: invokevirtual 228	org/apache/cordova/api/PluginResult$Status:ordinal	()I
    //   3475: if_icmpeq +14 -> 3489
    //   3478: aload 20
    //   3480: ifnull +9 -> 3489
    //   3483: aload 20
    //   3485: invokevirtual 231	java/io/File:delete	()Z
    //   3488: pop
    //   3489: aload_0
    //   3490: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   3493: astore 5
    //   3495: goto -1116 -> 2379
    //   3498: astore 6
    //   3500: aload 5
    //   3502: monitorexit
    //   3503: aload 6
    //   3505: athrow
    //   3506: aload 4
    //   3508: astore 22
    //   3510: aload 11
    //   3512: astore 20
    //   3514: aload 7
    //   3516: astore 13
    //   3518: aload 8
    //   3520: astore 12
    //   3522: aload 4
    //   3524: astore 24
    //   3526: aload 11
    //   3528: astore 21
    //   3530: aload 7
    //   3532: astore 15
    //   3534: aload 8
    //   3536: astore 14
    //   3538: aload 4
    //   3540: astore 26
    //   3542: aload 11
    //   3544: astore 23
    //   3546: aload 7
    //   3548: astore 19
    //   3550: aload 8
    //   3552: astore 18
    //   3554: aload 4
    //   3556: astore 27
    //   3558: aload 11
    //   3560: astore 25
    //   3562: aload 7
    //   3564: astore 17
    //   3566: aload 8
    //   3568: astore 16
    //   3570: aload 4
    //   3572: astore 9
    //   3574: aload 11
    //   3576: astore 10
    //   3578: aload 7
    //   3580: astore 5
    //   3582: aload 8
    //   3584: astore 6
    //   3586: aload_0
    //   3587: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   3590: aconst_null
    //   3591: putfield 178	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   3594: aload 4
    //   3596: astore 22
    //   3598: aload 11
    //   3600: astore 20
    //   3602: aload 7
    //   3604: astore 13
    //   3606: aload 8
    //   3608: astore 12
    //   3610: aload 4
    //   3612: astore 24
    //   3614: aload 11
    //   3616: astore 21
    //   3618: aload 7
    //   3620: astore 15
    //   3622: aload 8
    //   3624: astore 14
    //   3626: aload 4
    //   3628: astore 26
    //   3630: aload 11
    //   3632: astore 23
    //   3634: aload 7
    //   3636: astore 19
    //   3638: aload 8
    //   3640: astore 18
    //   3642: aload 4
    //   3644: astore 27
    //   3646: aload 11
    //   3648: astore 25
    //   3650: aload 7
    //   3652: astore 17
    //   3654: aload 8
    //   3656: astore 16
    //   3658: aload 4
    //   3660: astore 9
    //   3662: aload 11
    //   3664: astore 10
    //   3666: aload 7
    //   3668: astore 5
    //   3670: aload 8
    //   3672: astore 6
    //   3674: aload 28
    //   3676: invokestatic 182	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   3679: aload 4
    //   3681: astore 22
    //   3683: aload 11
    //   3685: astore 20
    //   3687: aload 7
    //   3689: astore 13
    //   3691: aload 8
    //   3693: astore 12
    //   3695: aload 4
    //   3697: astore 24
    //   3699: aload 11
    //   3701: astore 21
    //   3703: aload 7
    //   3705: astore 15
    //   3707: aload 8
    //   3709: astore 14
    //   3711: aload 4
    //   3713: astore 26
    //   3715: aload 11
    //   3717: astore 23
    //   3719: aload 7
    //   3721: astore 19
    //   3723: aload 8
    //   3725: astore 18
    //   3727: aload 4
    //   3729: astore 27
    //   3731: aload 11
    //   3733: astore 25
    //   3735: aload 7
    //   3737: astore 17
    //   3739: aload 8
    //   3741: astore 16
    //   3743: aload 4
    //   3745: astore 9
    //   3747: aload 11
    //   3749: astore 10
    //   3751: aload 7
    //   3753: astore 5
    //   3755: aload 8
    //   3757: astore 6
    //   3759: aload 30
    //   3761: invokestatic 182	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   3764: aload 4
    //   3766: astore 22
    //   3768: aload 11
    //   3770: astore 20
    //   3772: aload 7
    //   3774: astore 13
    //   3776: aload 8
    //   3778: astore 12
    //   3780: aload 4
    //   3782: astore 24
    //   3784: aload 11
    //   3786: astore 21
    //   3788: aload 7
    //   3790: astore 15
    //   3792: aload 8
    //   3794: astore 14
    //   3796: aload 4
    //   3798: astore 26
    //   3800: aload 11
    //   3802: astore 23
    //   3804: aload 7
    //   3806: astore 19
    //   3808: aload 8
    //   3810: astore 18
    //   3812: aload 4
    //   3814: astore 27
    //   3816: aload 11
    //   3818: astore 25
    //   3820: aload 7
    //   3822: astore 17
    //   3824: aload 8
    //   3826: astore 16
    //   3828: aload 4
    //   3830: astore 9
    //   3832: aload 11
    //   3834: astore 10
    //   3836: aload 7
    //   3838: astore 5
    //   3840: aload 8
    //   3842: astore 6
    //   3844: new 125	java/lang/StringBuilder
    //   3847: astore 28
    //   3849: aload 4
    //   3851: astore 22
    //   3853: aload 11
    //   3855: astore 20
    //   3857: aload 7
    //   3859: astore 13
    //   3861: aload 8
    //   3863: astore 12
    //   3865: aload 4
    //   3867: astore 24
    //   3869: aload 11
    //   3871: astore 21
    //   3873: aload 7
    //   3875: astore 15
    //   3877: aload 8
    //   3879: astore 14
    //   3881: aload 4
    //   3883: astore 26
    //   3885: aload 11
    //   3887: astore 23
    //   3889: aload 7
    //   3891: astore 19
    //   3893: aload 8
    //   3895: astore 18
    //   3897: aload 4
    //   3899: astore 27
    //   3901: aload 11
    //   3903: astore 25
    //   3905: aload 7
    //   3907: astore 17
    //   3909: aload 8
    //   3911: astore 16
    //   3913: aload 4
    //   3915: astore 9
    //   3917: aload 11
    //   3919: astore 10
    //   3921: aload 7
    //   3923: astore 5
    //   3925: aload 8
    //   3927: astore 6
    //   3929: aload 28
    //   3931: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   3934: aload 4
    //   3936: astore 22
    //   3938: aload 11
    //   3940: astore 20
    //   3942: aload 7
    //   3944: astore 13
    //   3946: aload 8
    //   3948: astore 12
    //   3950: aload 4
    //   3952: astore 24
    //   3954: aload 11
    //   3956: astore 21
    //   3958: aload 7
    //   3960: astore 15
    //   3962: aload 8
    //   3964: astore 14
    //   3966: aload 4
    //   3968: astore 26
    //   3970: aload 11
    //   3972: astore 23
    //   3974: aload 7
    //   3976: astore 19
    //   3978: aload 8
    //   3980: astore 18
    //   3982: aload 4
    //   3984: astore 27
    //   3986: aload 11
    //   3988: astore 25
    //   3990: aload 7
    //   3992: astore 17
    //   3994: aload 8
    //   3996: astore 16
    //   3998: aload 4
    //   4000: astore 9
    //   4002: aload 11
    //   4004: astore 10
    //   4006: aload 7
    //   4008: astore 5
    //   4010: aload 8
    //   4012: astore 6
    //   4014: ldc -128
    //   4016: aload 28
    //   4018: ldc_w 281
    //   4021: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4024: aload_0
    //   4025: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   4028: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4031: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4034: invokestatic 147	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   4037: pop
    //   4038: aload 4
    //   4040: astore 22
    //   4042: aload 11
    //   4044: astore 20
    //   4046: aload 7
    //   4048: astore 13
    //   4050: aload 8
    //   4052: astore 12
    //   4054: aload 4
    //   4056: astore 24
    //   4058: aload 11
    //   4060: astore 21
    //   4062: aload 7
    //   4064: astore 15
    //   4066: aload 8
    //   4068: astore 14
    //   4070: aload 4
    //   4072: astore 26
    //   4074: aload 11
    //   4076: astore 23
    //   4078: aload 7
    //   4080: astore 19
    //   4082: aload 8
    //   4084: astore 18
    //   4086: aload 4
    //   4088: astore 27
    //   4090: aload 11
    //   4092: astore 25
    //   4094: aload 7
    //   4096: astore 17
    //   4098: aload 8
    //   4100: astore 16
    //   4102: aload 4
    //   4104: astore 9
    //   4106: aload 11
    //   4108: astore 10
    //   4110: aload 7
    //   4112: astore 5
    //   4114: aload 8
    //   4116: astore 6
    //   4118: aload 11
    //   4120: invokestatic 287	org/apache/cordova/FileUtils:getEntry	(Ljava/io/File;)Lorg/json/JSONObject;
    //   4123: astore 28
    //   4125: aload 4
    //   4127: astore 22
    //   4129: aload 11
    //   4131: astore 20
    //   4133: aload 7
    //   4135: astore 13
    //   4137: aload 8
    //   4139: astore 12
    //   4141: aload 4
    //   4143: astore 24
    //   4145: aload 11
    //   4147: astore 21
    //   4149: aload 7
    //   4151: astore 15
    //   4153: aload 8
    //   4155: astore 14
    //   4157: aload 4
    //   4159: astore 26
    //   4161: aload 11
    //   4163: astore 23
    //   4165: aload 7
    //   4167: astore 19
    //   4169: aload 8
    //   4171: astore 18
    //   4173: aload 4
    //   4175: astore 27
    //   4177: aload 11
    //   4179: astore 25
    //   4181: aload 7
    //   4183: astore 17
    //   4185: aload 8
    //   4187: astore 16
    //   4189: aload 4
    //   4191: astore 9
    //   4193: aload 11
    //   4195: astore 10
    //   4197: aload 7
    //   4199: astore 5
    //   4201: aload 8
    //   4203: astore 6
    //   4205: new 202	org/apache/cordova/api/PluginResult
    //   4208: dup
    //   4209: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   4212: aload 28
    //   4214: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4217: astore 28
    //   4219: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4222: astore 5
    //   4224: aload 5
    //   4226: monitorenter
    //   4227: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4230: aload_0
    //   4231: getfield 46	org/apache/cordova/FileTransfer$4:val$objectId	Ljava/lang/String;
    //   4234: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4237: pop
    //   4238: aload 5
    //   4240: monitorexit
    //   4241: aload 4
    //   4243: ifnull +38 -> 4281
    //   4246: aload_0
    //   4247: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   4250: ifeq +31 -> 4281
    //   4253: aload_0
    //   4254: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   4257: ifeq +24 -> 4281
    //   4260: aload 4
    //   4262: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   4265: astore 5
    //   4267: aload 5
    //   4269: aload 7
    //   4271: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   4274: aload 5
    //   4276: aload 8
    //   4278: invokevirtual 200	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   4281: aload 28
    //   4283: ifnonnull +907 -> 5190
    //   4286: new 202	org/apache/cordova/api/PluginResult
    //   4289: dup
    //   4290: getstatic 208	org/apache/cordova/api/PluginResult$Status:ERROR	Lorg/apache/cordova/api/PluginResult$Status;
    //   4293: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   4296: aload_0
    //   4297: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   4300: aload_0
    //   4301: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   4304: aload 4
    //   4306: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   4309: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4312: astore 4
    //   4314: aload 4
    //   4316: invokevirtual 222	org/apache/cordova/api/PluginResult:getStatus	()I
    //   4319: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   4322: invokevirtual 228	org/apache/cordova/api/PluginResult$Status:ordinal	()I
    //   4325: if_icmpeq +14 -> 4339
    //   4328: aload 11
    //   4330: ifnull +9 -> 4339
    //   4333: aload 11
    //   4335: invokevirtual 231	java/io/File:delete	()Z
    //   4338: pop
    //   4339: aload_0
    //   4340: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4343: astore 5
    //   4345: goto -1966 -> 2379
    //   4348: astore 7
    //   4350: aload 24
    //   4352: astore 9
    //   4354: aload 21
    //   4356: astore 10
    //   4358: aload 15
    //   4360: astore 5
    //   4362: aload 14
    //   4364: astore 6
    //   4366: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   4369: aload_0
    //   4370: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   4373: aload_0
    //   4374: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   4377: aload 24
    //   4379: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   4382: astore 4
    //   4384: aload 24
    //   4386: astore 9
    //   4388: aload 21
    //   4390: astore 10
    //   4392: aload 15
    //   4394: astore 5
    //   4396: aload 14
    //   4398: astore 6
    //   4400: ldc -128
    //   4402: aload 4
    //   4404: invokevirtual 272	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4407: aload 7
    //   4409: invokestatic 276	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   4412: pop
    //   4413: aload 24
    //   4415: astore 9
    //   4417: aload 21
    //   4419: astore 10
    //   4421: aload 15
    //   4423: astore 5
    //   4425: aload 14
    //   4427: astore 6
    //   4429: new 202	org/apache/cordova/api/PluginResult
    //   4432: dup
    //   4433: getstatic 279	org/apache/cordova/api/PluginResult$Status:IO_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   4436: aload 4
    //   4438: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4441: astore 4
    //   4443: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4446: astore 5
    //   4448: aload 5
    //   4450: monitorenter
    //   4451: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4454: aload_0
    //   4455: getfield 46	org/apache/cordova/FileTransfer$4:val$objectId	Ljava/lang/String;
    //   4458: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4461: pop
    //   4462: aload 5
    //   4464: monitorexit
    //   4465: aload 24
    //   4467: ifnull +38 -> 4505
    //   4470: aload_0
    //   4471: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   4474: ifeq +31 -> 4505
    //   4477: aload_0
    //   4478: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   4481: ifeq +24 -> 4505
    //   4484: aload 24
    //   4486: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   4489: astore 5
    //   4491: aload 5
    //   4493: aload 15
    //   4495: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   4498: aload 5
    //   4500: aload 14
    //   4502: invokevirtual 200	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   4505: aload 4
    //   4507: ifnonnull +696 -> 5203
    //   4510: new 202	org/apache/cordova/api/PluginResult
    //   4513: dup
    //   4514: getstatic 208	org/apache/cordova/api/PluginResult$Status:ERROR	Lorg/apache/cordova/api/PluginResult$Status;
    //   4517: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   4520: aload_0
    //   4521: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   4524: aload_0
    //   4525: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   4528: aload 24
    //   4530: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   4533: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4536: astore 4
    //   4538: aload 4
    //   4540: invokevirtual 222	org/apache/cordova/api/PluginResult:getStatus	()I
    //   4543: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   4546: invokevirtual 228	org/apache/cordova/api/PluginResult$Status:ordinal	()I
    //   4549: if_icmpeq +14 -> 4563
    //   4552: aload 21
    //   4554: ifnull +9 -> 4563
    //   4557: aload 21
    //   4559: invokevirtual 231	java/io/File:delete	()Z
    //   4562: pop
    //   4563: aload_0
    //   4564: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4567: astore 5
    //   4569: goto -2190 -> 2379
    //   4572: astore 4
    //   4574: aload 26
    //   4576: astore 9
    //   4578: aload 23
    //   4580: astore 10
    //   4582: aload 19
    //   4584: astore 5
    //   4586: aload 18
    //   4588: astore 6
    //   4590: ldc -128
    //   4592: aload 4
    //   4594: invokevirtual 290	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   4597: aload 4
    //   4599: invokestatic 276	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   4602: pop
    //   4603: aload 26
    //   4605: astore 9
    //   4607: aload 23
    //   4609: astore 10
    //   4611: aload 19
    //   4613: astore 5
    //   4615: aload 18
    //   4617: astore 6
    //   4619: new 202	org/apache/cordova/api/PluginResult
    //   4622: dup
    //   4623: getstatic 293	org/apache/cordova/api/PluginResult$Status:JSON_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   4626: invokespecial 296	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;)V
    //   4629: astore 4
    //   4631: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4634: astore 5
    //   4636: aload 5
    //   4638: monitorenter
    //   4639: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4642: aload_0
    //   4643: getfield 46	org/apache/cordova/FileTransfer$4:val$objectId	Ljava/lang/String;
    //   4646: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4649: pop
    //   4650: aload 5
    //   4652: monitorexit
    //   4653: aload 26
    //   4655: ifnull +38 -> 4693
    //   4658: aload_0
    //   4659: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   4662: ifeq +31 -> 4693
    //   4665: aload_0
    //   4666: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   4669: ifeq +24 -> 4693
    //   4672: aload 26
    //   4674: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   4677: astore 5
    //   4679: aload 5
    //   4681: aload 19
    //   4683: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   4686: aload 5
    //   4688: aload 18
    //   4690: invokevirtual 200	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   4693: aload 4
    //   4695: ifnonnull +505 -> 5200
    //   4698: new 202	org/apache/cordova/api/PluginResult
    //   4701: dup
    //   4702: getstatic 208	org/apache/cordova/api/PluginResult$Status:ERROR	Lorg/apache/cordova/api/PluginResult$Status;
    //   4705: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   4708: aload_0
    //   4709: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   4712: aload_0
    //   4713: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   4716: aload 26
    //   4718: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   4721: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4724: astore 4
    //   4726: aload 4
    //   4728: invokevirtual 222	org/apache/cordova/api/PluginResult:getStatus	()I
    //   4731: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   4734: invokevirtual 228	org/apache/cordova/api/PluginResult$Status:ordinal	()I
    //   4737: if_icmpeq +14 -> 4751
    //   4740: aload 23
    //   4742: ifnull +9 -> 4751
    //   4745: aload 23
    //   4747: invokevirtual 231	java/io/File:delete	()Z
    //   4750: pop
    //   4751: aload_0
    //   4752: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4755: astore 5
    //   4757: goto -2378 -> 2379
    //   4760: astore 7
    //   4762: aload 27
    //   4764: astore 9
    //   4766: aload 25
    //   4768: astore 10
    //   4770: aload 17
    //   4772: astore 5
    //   4774: aload 16
    //   4776: astore 6
    //   4778: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   4781: aload_0
    //   4782: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   4785: aload_0
    //   4786: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   4789: aload 27
    //   4791: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   4794: astore 4
    //   4796: aload 27
    //   4798: astore 9
    //   4800: aload 25
    //   4802: astore 10
    //   4804: aload 17
    //   4806: astore 5
    //   4808: aload 16
    //   4810: astore 6
    //   4812: ldc -128
    //   4814: aload 4
    //   4816: invokevirtual 272	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4819: aload 7
    //   4821: invokestatic 276	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   4824: pop
    //   4825: aload 27
    //   4827: astore 9
    //   4829: aload 25
    //   4831: astore 10
    //   4833: aload 17
    //   4835: astore 5
    //   4837: aload 16
    //   4839: astore 6
    //   4841: new 202	org/apache/cordova/api/PluginResult
    //   4844: dup
    //   4845: getstatic 279	org/apache/cordova/api/PluginResult$Status:IO_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   4848: aload 4
    //   4850: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4853: astore 4
    //   4855: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4858: astore 5
    //   4860: aload 5
    //   4862: monitorenter
    //   4863: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4866: aload_0
    //   4867: getfield 46	org/apache/cordova/FileTransfer$4:val$objectId	Ljava/lang/String;
    //   4870: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4873: pop
    //   4874: aload 5
    //   4876: monitorexit
    //   4877: aload 27
    //   4879: ifnull +38 -> 4917
    //   4882: aload_0
    //   4883: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   4886: ifeq +31 -> 4917
    //   4889: aload_0
    //   4890: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   4893: ifeq +24 -> 4917
    //   4896: aload 27
    //   4898: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   4901: astore 5
    //   4903: aload 5
    //   4905: aload 17
    //   4907: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   4910: aload 5
    //   4912: aload 16
    //   4914: invokevirtual 200	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   4917: aload 4
    //   4919: ifnonnull +278 -> 5197
    //   4922: new 202	org/apache/cordova/api/PluginResult
    //   4925: dup
    //   4926: getstatic 208	org/apache/cordova/api/PluginResult$Status:ERROR	Lorg/apache/cordova/api/PluginResult$Status;
    //   4929: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   4932: aload_0
    //   4933: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   4936: aload_0
    //   4937: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   4940: aload 27
    //   4942: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   4945: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4948: astore 4
    //   4950: aload 4
    //   4952: invokevirtual 222	org/apache/cordova/api/PluginResult:getStatus	()I
    //   4955: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   4958: invokevirtual 228	org/apache/cordova/api/PluginResult$Status:ordinal	()I
    //   4961: if_icmpeq +14 -> 4975
    //   4964: aload 25
    //   4966: ifnull +9 -> 4975
    //   4969: aload 25
    //   4971: invokevirtual 231	java/io/File:delete	()Z
    //   4974: pop
    //   4975: aload_0
    //   4976: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4979: astore 5
    //   4981: goto -2602 -> 2379
    //   4984: astore 7
    //   4986: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4989: astore 4
    //   4991: aload 4
    //   4993: monitorenter
    //   4994: invokestatic 186	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4997: aload_0
    //   4998: getfield 46	org/apache/cordova/FileTransfer$4:val$objectId	Ljava/lang/String;
    //   5001: invokevirtual 192	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5004: pop
    //   5005: aload 4
    //   5007: monitorexit
    //   5008: aload 9
    //   5010: ifnull +38 -> 5048
    //   5013: aload_0
    //   5014: getfield 38	org/apache/cordova/FileTransfer$4:val$trustEveryone	Z
    //   5017: ifeq +31 -> 5048
    //   5020: aload_0
    //   5021: getfield 36	org/apache/cordova/FileTransfer$4:val$useHttps	Z
    //   5024: ifeq +24 -> 5048
    //   5027: aload 9
    //   5029: checkcast 90	javax/net/ssl/HttpsURLConnection
    //   5032: astore 4
    //   5034: aload 4
    //   5036: aload 5
    //   5038: invokevirtual 196	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   5041: aload 4
    //   5043: aload 6
    //   5045: invokevirtual 200	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   5048: aload 31
    //   5050: astore 4
    //   5052: iconst_0
    //   5053: ifne +31 -> 5084
    //   5056: new 202	org/apache/cordova/api/PluginResult
    //   5059: dup
    //   5060: getstatic 208	org/apache/cordova/api/PluginResult$Status:ERROR	Lorg/apache/cordova/api/PluginResult$Status;
    //   5063: getstatic 212	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   5066: aload_0
    //   5067: getfield 42	org/apache/cordova/FileTransfer$4:val$source	Ljava/lang/String;
    //   5070: aload_0
    //   5071: getfield 34	org/apache/cordova/FileTransfer$4:val$target	Ljava/lang/String;
    //   5074: aload 9
    //   5076: invokestatic 216	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   5079: invokespecial 219	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   5082: astore 4
    //   5084: aload 4
    //   5086: invokevirtual 222	org/apache/cordova/api/PluginResult:getStatus	()I
    //   5089: getstatic 225	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   5092: invokevirtual 228	org/apache/cordova/api/PluginResult$Status:ordinal	()I
    //   5095: if_icmpeq +14 -> 5109
    //   5098: aload 10
    //   5100: ifnull +9 -> 5109
    //   5103: aload 10
    //   5105: invokevirtual 231	java/io/File:delete	()Z
    //   5108: pop
    //   5109: aload_0
    //   5110: getfield 32	org/apache/cordova/FileTransfer$4:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   5113: aload 4
    //   5115: invokevirtual 235	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   5118: aload 7
    //   5120: athrow
    //   5121: astore 5
    //   5123: aload 4
    //   5125: monitorexit
    //   5126: aload 5
    //   5128: athrow
    //   5129: astore 4
    //   5131: aload 5
    //   5133: monitorexit
    //   5134: aload 4
    //   5136: athrow
    //   5137: astore 4
    //   5139: aload 5
    //   5141: monitorexit
    //   5142: aload 4
    //   5144: athrow
    //   5145: astore 4
    //   5147: aload 5
    //   5149: monitorexit
    //   5150: aload 4
    //   5152: athrow
    //   5153: astore 4
    //   5155: aload 5
    //   5157: monitorexit
    //   5158: aload 4
    //   5160: athrow
    //   5161: astore 4
    //   5163: aload 5
    //   5165: monitorexit
    //   5166: aload 4
    //   5168: athrow
    //   5169: astore 4
    //   5171: aload 5
    //   5173: monitorexit
    //   5174: aload 4
    //   5176: athrow
    //   5177: astore 29
    //   5179: aload 5
    //   5181: astore 28
    //   5183: aload 6
    //   5185: astore 30
    //   5187: goto -2254 -> 2933
    //   5190: aload 28
    //   5192: astore 4
    //   5194: goto -880 -> 4314
    //   5197: goto -247 -> 4950
    //   5200: goto -474 -> 4726
    //   5203: goto -665 -> 4538
    //   5206: goto -1742 -> 3464
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5209	0	this	4
    //   2870	16	1	i	int
    //   2862	30	2	l	long
    //   24	4515	4	localObject1	Object
    //   4572	26	4	localJSONException	org.json.JSONException
    //   5129	6	4	localObject3	Object
    //   5137	6	4	localObject4	Object
    //   5145	6	4	localObject5	Object
    //   5153	6	4	localObject6	Object
    //   5161	6	4	localObject7	Object
    //   5169	6	4	localObject8	Object
    //   5192	1	4	localObject9	Object
    //   5121	59	5	localObject11	Object
    //   141	3213	6	localObject12	Object
    //   3498	6	6	localObject13	Object
    //   3584	1600	6	localObject14	Object
    //   42	3222	7	localHostnameVerifier	javax.net.ssl.HostnameVerifier
    //   3274	996	7	localFileNotFoundException	java.io.FileNotFoundException
    //   4348	60	7	localIOException	java.io.IOException
    //   4760	60	7	localThrowable	Throwable
    //   4984	135	7	localObject15	Object
    //   60	4217	8	localSSLSocketFactory	javax.net.ssl.SSLSocketFactory
    //   133	4942	9	localObject16	Object
    //   72	5032	10	localObject17	Object
    //   154	4180	11	localFile	java.io.File
    //   93	4047	12	localObject18	Object
    //   89	4047	13	localObject19	Object
    //   105	4396	14	localObject20	Object
    //   101	4393	15	localObject21	Object
    //   129	4784	16	localObject22	Object
    //   125	4781	17	localObject23	Object
    //   117	4572	18	localObject24	Object
    //   113	4569	19	localObject25	Object
    //   75	4057	20	localObject26	Object
    //   63	4495	21	localObject27	Object
    //   85	4043	22	localObject28	Object
    //   66	4680	23	localObject29	Object
    //   97	4432	24	localObject30	Object
    //   69	4901	25	localObject31	Object
    //   109	4608	26	localObject32	Object
    //   121	4820	27	localObject33	Object
    //   12	5179	28	localObject34	Object
    //   81	2228	29	localObject35	Object
    //   2931	341	29	localObject36	Object
    //   5177	1	29	localObject37	Object
    //   15	5171	30	localObject38	Object
    //   78	4971	31	localObject39	Object
    //   18	2888	32	localFileProgressResult	FileProgressResult
    //   21	2794	33	localObject40	Object
    //   27	2732	34	localObject41	Object
    //   30	2745	35	localObject42	Object
    //   33	2758	36	localObject43	Object
    //   36	2771	37	localObject44	Object
    //   39	2784	38	localObject45	Object
    //   45	2718	39	localObject46	Object
    //   48	2731	40	localObject47	Object
    //   51	2744	41	localObject48	Object
    //   54	2757	42	localObject49	Object
    //   57	2770	43	localObject50	Object
    //   2479	265	44	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    // Exception table:
    //   from	to	target	type
    //   1966	1975	2931	finally
    //   2854	2861	2931	finally
    //   2863	2871	2931	finally
    //   2875	2884	2931	finally
    //   2889	2928	2931	finally
    //   3503	3506	2931	finally
    //   143	156	3274	java/io/FileNotFoundException
    //   236	245	3274	java/io/FileNotFoundException
    //   325	334	3274	java/io/FileNotFoundException
    //   414	421	3274	java/io/FileNotFoundException
    //   501	508	3274	java/io/FileNotFoundException
    //   588	600	3274	java/io/FileNotFoundException
    //   680	688	3274	java/io/FileNotFoundException
    //   768	778	3274	java/io/FileNotFoundException
    //   858	870	3274	java/io/FileNotFoundException
    //   955	964	3274	java/io/FileNotFoundException
    //   1044	1051	3274	java/io/FileNotFoundException
    //   1131	1140	3274	java/io/FileNotFoundException
    //   1220	1225	3274	java/io/FileNotFoundException
    //   1305	1310	3274	java/io/FileNotFoundException
    //   1390	1395	3274	java/io/FileNotFoundException
    //   1475	1498	3274	java/io/FileNotFoundException
    //   1578	1583	3274	java/io/FileNotFoundException
    //   1663	1668	3274	java/io/FileNotFoundException
    //   1748	1756	3274	java/io/FileNotFoundException
    //   1836	1842	3274	java/io/FileNotFoundException
    //   1922	1933	3274	java/io/FileNotFoundException
    //   2068	2076	3274	java/io/FileNotFoundException
    //   2156	2161	3274	java/io/FileNotFoundException
    //   2241	2246	3274	java/io/FileNotFoundException
    //   2469	2481	3274	java/io/FileNotFoundException
    //   2561	2568	3274	java/io/FileNotFoundException
    //   2648	2655	3274	java/io/FileNotFoundException
    //   2735	2743	3274	java/io/FileNotFoundException
    //   2830	2839	3274	java/io/FileNotFoundException
    //   3013	3021	3274	java/io/FileNotFoundException
    //   3101	3106	3274	java/io/FileNotFoundException
    //   3186	3191	3274	java/io/FileNotFoundException
    //   3271	3274	3274	java/io/FileNotFoundException
    //   3586	3594	3274	java/io/FileNotFoundException
    //   3674	3679	3274	java/io/FileNotFoundException
    //   3759	3764	3274	java/io/FileNotFoundException
    //   3844	3849	3274	java/io/FileNotFoundException
    //   3929	3934	3274	java/io/FileNotFoundException
    //   4014	4038	3274	java/io/FileNotFoundException
    //   4118	4125	3274	java/io/FileNotFoundException
    //   4205	4219	3274	java/io/FileNotFoundException
    //   1975	1988	3498	finally
    //   2842	2854	3498	finally
    //   3500	3503	3498	finally
    //   143	156	4348	java/io/IOException
    //   236	245	4348	java/io/IOException
    //   325	334	4348	java/io/IOException
    //   414	421	4348	java/io/IOException
    //   501	508	4348	java/io/IOException
    //   588	600	4348	java/io/IOException
    //   680	688	4348	java/io/IOException
    //   768	778	4348	java/io/IOException
    //   858	870	4348	java/io/IOException
    //   955	964	4348	java/io/IOException
    //   1044	1051	4348	java/io/IOException
    //   1131	1140	4348	java/io/IOException
    //   1220	1225	4348	java/io/IOException
    //   1305	1310	4348	java/io/IOException
    //   1390	1395	4348	java/io/IOException
    //   1475	1498	4348	java/io/IOException
    //   1578	1583	4348	java/io/IOException
    //   1663	1668	4348	java/io/IOException
    //   1748	1756	4348	java/io/IOException
    //   1836	1842	4348	java/io/IOException
    //   1922	1933	4348	java/io/IOException
    //   2068	2076	4348	java/io/IOException
    //   2156	2161	4348	java/io/IOException
    //   2241	2246	4348	java/io/IOException
    //   2469	2481	4348	java/io/IOException
    //   2561	2568	4348	java/io/IOException
    //   2648	2655	4348	java/io/IOException
    //   2735	2743	4348	java/io/IOException
    //   2830	2839	4348	java/io/IOException
    //   3013	3021	4348	java/io/IOException
    //   3101	3106	4348	java/io/IOException
    //   3186	3191	4348	java/io/IOException
    //   3271	3274	4348	java/io/IOException
    //   3586	3594	4348	java/io/IOException
    //   3674	3679	4348	java/io/IOException
    //   3759	3764	4348	java/io/IOException
    //   3844	3849	4348	java/io/IOException
    //   3929	3934	4348	java/io/IOException
    //   4014	4038	4348	java/io/IOException
    //   4118	4125	4348	java/io/IOException
    //   4205	4219	4348	java/io/IOException
    //   143	156	4572	org/json/JSONException
    //   236	245	4572	org/json/JSONException
    //   325	334	4572	org/json/JSONException
    //   414	421	4572	org/json/JSONException
    //   501	508	4572	org/json/JSONException
    //   588	600	4572	org/json/JSONException
    //   680	688	4572	org/json/JSONException
    //   768	778	4572	org/json/JSONException
    //   858	870	4572	org/json/JSONException
    //   955	964	4572	org/json/JSONException
    //   1044	1051	4572	org/json/JSONException
    //   1131	1140	4572	org/json/JSONException
    //   1220	1225	4572	org/json/JSONException
    //   1305	1310	4572	org/json/JSONException
    //   1390	1395	4572	org/json/JSONException
    //   1475	1498	4572	org/json/JSONException
    //   1578	1583	4572	org/json/JSONException
    //   1663	1668	4572	org/json/JSONException
    //   1748	1756	4572	org/json/JSONException
    //   1836	1842	4572	org/json/JSONException
    //   1922	1933	4572	org/json/JSONException
    //   2068	2076	4572	org/json/JSONException
    //   2156	2161	4572	org/json/JSONException
    //   2241	2246	4572	org/json/JSONException
    //   2469	2481	4572	org/json/JSONException
    //   2561	2568	4572	org/json/JSONException
    //   2648	2655	4572	org/json/JSONException
    //   2735	2743	4572	org/json/JSONException
    //   2830	2839	4572	org/json/JSONException
    //   3013	3021	4572	org/json/JSONException
    //   3101	3106	4572	org/json/JSONException
    //   3186	3191	4572	org/json/JSONException
    //   3271	3274	4572	org/json/JSONException
    //   3586	3594	4572	org/json/JSONException
    //   3674	3679	4572	org/json/JSONException
    //   3759	3764	4572	org/json/JSONException
    //   3844	3849	4572	org/json/JSONException
    //   3929	3934	4572	org/json/JSONException
    //   4014	4038	4572	org/json/JSONException
    //   4118	4125	4572	org/json/JSONException
    //   4205	4219	4572	org/json/JSONException
    //   143	156	4760	java/lang/Throwable
    //   236	245	4760	java/lang/Throwable
    //   325	334	4760	java/lang/Throwable
    //   414	421	4760	java/lang/Throwable
    //   501	508	4760	java/lang/Throwable
    //   588	600	4760	java/lang/Throwable
    //   680	688	4760	java/lang/Throwable
    //   768	778	4760	java/lang/Throwable
    //   858	870	4760	java/lang/Throwable
    //   955	964	4760	java/lang/Throwable
    //   1044	1051	4760	java/lang/Throwable
    //   1131	1140	4760	java/lang/Throwable
    //   1220	1225	4760	java/lang/Throwable
    //   1305	1310	4760	java/lang/Throwable
    //   1390	1395	4760	java/lang/Throwable
    //   1475	1498	4760	java/lang/Throwable
    //   1578	1583	4760	java/lang/Throwable
    //   1663	1668	4760	java/lang/Throwable
    //   1748	1756	4760	java/lang/Throwable
    //   1836	1842	4760	java/lang/Throwable
    //   1922	1933	4760	java/lang/Throwable
    //   2068	2076	4760	java/lang/Throwable
    //   2156	2161	4760	java/lang/Throwable
    //   2241	2246	4760	java/lang/Throwable
    //   2469	2481	4760	java/lang/Throwable
    //   2561	2568	4760	java/lang/Throwable
    //   2648	2655	4760	java/lang/Throwable
    //   2735	2743	4760	java/lang/Throwable
    //   2830	2839	4760	java/lang/Throwable
    //   3013	3021	4760	java/lang/Throwable
    //   3101	3106	4760	java/lang/Throwable
    //   3186	3191	4760	java/lang/Throwable
    //   3271	3274	4760	java/lang/Throwable
    //   3586	3594	4760	java/lang/Throwable
    //   3674	3679	4760	java/lang/Throwable
    //   3759	3764	4760	java/lang/Throwable
    //   3844	3849	4760	java/lang/Throwable
    //   3929	3934	4760	java/lang/Throwable
    //   4014	4038	4760	java/lang/Throwable
    //   4118	4125	4760	java/lang/Throwable
    //   4205	4219	4760	java/lang/Throwable
    //   143	156	4984	finally
    //   236	245	4984	finally
    //   325	334	4984	finally
    //   414	421	4984	finally
    //   501	508	4984	finally
    //   588	600	4984	finally
    //   680	688	4984	finally
    //   768	778	4984	finally
    //   858	870	4984	finally
    //   955	964	4984	finally
    //   1044	1051	4984	finally
    //   1131	1140	4984	finally
    //   1220	1225	4984	finally
    //   1305	1310	4984	finally
    //   1390	1395	4984	finally
    //   1475	1498	4984	finally
    //   1578	1583	4984	finally
    //   1663	1668	4984	finally
    //   1748	1756	4984	finally
    //   1836	1842	4984	finally
    //   1922	1933	4984	finally
    //   2068	2076	4984	finally
    //   2156	2161	4984	finally
    //   2241	2246	4984	finally
    //   2469	2481	4984	finally
    //   2561	2568	4984	finally
    //   2648	2655	4984	finally
    //   2735	2743	4984	finally
    //   2830	2839	4984	finally
    //   3013	3021	4984	finally
    //   3101	3106	4984	finally
    //   3186	3191	4984	finally
    //   3271	3274	4984	finally
    //   3292	3310	4984	finally
    //   3326	3339	4984	finally
    //   3355	3369	4984	finally
    //   3586	3594	4984	finally
    //   3674	3679	4984	finally
    //   3759	3764	4984	finally
    //   3844	3849	4984	finally
    //   3929	3934	4984	finally
    //   4014	4038	4984	finally
    //   4118	4125	4984	finally
    //   4205	4219	4984	finally
    //   4366	4384	4984	finally
    //   4400	4413	4984	finally
    //   4429	4443	4984	finally
    //   4590	4603	4984	finally
    //   4619	4631	4984	finally
    //   4778	4796	4984	finally
    //   4812	4825	4984	finally
    //   4841	4855	4984	finally
    //   4994	5008	5121	finally
    //   5123	5126	5121	finally
    //   3377	3391	5129	finally
    //   5131	5134	5129	finally
    //   4451	4465	5137	finally
    //   5139	5142	5137	finally
    //   4639	4653	5145	finally
    //   5147	5150	5145	finally
    //   4863	4877	5153	finally
    //   5155	5158	5153	finally
    //   2254	2268	5161	finally
    //   5163	5166	5161	finally
    //   4227	4241	5169	finally
    //   5171	5174	5169	finally
    //   1939	1946	5177	finally
    //   1950	1955	5177	finally
    //   1959	1966	5177	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileTransfer$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */