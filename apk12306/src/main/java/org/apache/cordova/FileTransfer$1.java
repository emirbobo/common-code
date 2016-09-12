package org.apache.cordova;

import java.net.URL;
import org.json.JSONObject;

class FileTransfer$1
  implements Runnable
{
  FileTransfer$1(FileTransfer paramFileTransfer, FileTransfer.RequestContext paramRequestContext, boolean paramBoolean1, boolean paramBoolean2, URL paramURL, String paramString1, JSONObject paramJSONObject1, JSONObject paramJSONObject2, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean3, String paramString6) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4: getfield 79	org/apache/cordova/FileTransfer$RequestContext:aborted	Z
    //   7: ifeq +4 -> 11
    //   10: return
    //   11: aconst_null
    //   12: astore 31
    //   14: aconst_null
    //   15: astore 32
    //   17: aconst_null
    //   18: astore 33
    //   20: aconst_null
    //   21: astore 34
    //   23: aconst_null
    //   24: astore 13
    //   26: aconst_null
    //   27: astore 35
    //   29: aconst_null
    //   30: astore 36
    //   32: aconst_null
    //   33: astore 37
    //   35: aconst_null
    //   36: astore 38
    //   38: aconst_null
    //   39: astore 39
    //   41: aconst_null
    //   42: astore 16
    //   44: aconst_null
    //   45: astore 41
    //   47: aconst_null
    //   48: astore 42
    //   50: aconst_null
    //   51: astore 43
    //   53: aconst_null
    //   54: astore 44
    //   56: aconst_null
    //   57: astore 45
    //   59: aconst_null
    //   60: astore 17
    //   62: iconst_0
    //   63: istore 6
    //   65: iconst_0
    //   66: istore 5
    //   68: iconst_m1
    //   69: istore_1
    //   70: aload 13
    //   72: astore 28
    //   74: aload 35
    //   76: astore 22
    //   78: aload 41
    //   80: astore 23
    //   82: aload 31
    //   84: astore 27
    //   86: iload_1
    //   87: istore 4
    //   89: aload 36
    //   91: astore 20
    //   93: aload 42
    //   95: astore 19
    //   97: iload 6
    //   99: istore_3
    //   100: aload 32
    //   102: astore 30
    //   104: aload 37
    //   106: astore 26
    //   108: aload 43
    //   110: astore 25
    //   112: aload 33
    //   114: astore 29
    //   116: aload 38
    //   118: astore 21
    //   120: aload 44
    //   122: astore 24
    //   124: aload 34
    //   126: astore 18
    //   128: aload 39
    //   130: astore 14
    //   132: aload 45
    //   134: astore 15
    //   136: new 81	org/apache/cordova/FileUploadResult
    //   139: astore 46
    //   141: aload 13
    //   143: astore 28
    //   145: aload 35
    //   147: astore 22
    //   149: aload 41
    //   151: astore 23
    //   153: aload 31
    //   155: astore 27
    //   157: iload_1
    //   158: istore 4
    //   160: aload 36
    //   162: astore 20
    //   164: aload 42
    //   166: astore 19
    //   168: iload 6
    //   170: istore_3
    //   171: aload 32
    //   173: astore 30
    //   175: aload 37
    //   177: astore 26
    //   179: aload 43
    //   181: astore 25
    //   183: aload 33
    //   185: astore 29
    //   187: aload 38
    //   189: astore 21
    //   191: aload 44
    //   193: astore 24
    //   195: aload 34
    //   197: astore 18
    //   199: aload 39
    //   201: astore 14
    //   203: aload 45
    //   205: astore 15
    //   207: aload 46
    //   209: invokespecial 82	org/apache/cordova/FileUploadResult:<init>	()V
    //   212: aload 13
    //   214: astore 28
    //   216: aload 35
    //   218: astore 22
    //   220: aload 41
    //   222: astore 23
    //   224: aload 31
    //   226: astore 27
    //   228: iload_1
    //   229: istore 4
    //   231: aload 36
    //   233: astore 20
    //   235: aload 42
    //   237: astore 19
    //   239: iload 6
    //   241: istore_3
    //   242: aload 32
    //   244: astore 30
    //   246: aload 37
    //   248: astore 26
    //   250: aload 43
    //   252: astore 25
    //   254: aload 33
    //   256: astore 29
    //   258: aload 38
    //   260: astore 21
    //   262: aload 44
    //   264: astore 24
    //   266: aload 34
    //   268: astore 18
    //   270: aload 39
    //   272: astore 14
    //   274: aload 45
    //   276: astore 15
    //   278: new 84	org/apache/cordova/FileProgressResult
    //   281: astore 47
    //   283: aload 13
    //   285: astore 28
    //   287: aload 35
    //   289: astore 22
    //   291: aload 41
    //   293: astore 23
    //   295: aload 31
    //   297: astore 27
    //   299: iload_1
    //   300: istore 4
    //   302: aload 36
    //   304: astore 20
    //   306: aload 42
    //   308: astore 19
    //   310: iload 6
    //   312: istore_3
    //   313: aload 32
    //   315: astore 30
    //   317: aload 37
    //   319: astore 26
    //   321: aload 43
    //   323: astore 25
    //   325: aload 33
    //   327: astore 29
    //   329: aload 38
    //   331: astore 21
    //   333: aload 44
    //   335: astore 24
    //   337: aload 34
    //   339: astore 18
    //   341: aload 39
    //   343: astore 14
    //   345: aload 45
    //   347: astore 15
    //   349: aload 47
    //   351: invokespecial 85	org/apache/cordova/FileProgressResult:<init>	()V
    //   354: aload 13
    //   356: astore 28
    //   358: aload 35
    //   360: astore 22
    //   362: aload 41
    //   364: astore 23
    //   366: aload 31
    //   368: astore 27
    //   370: iload_1
    //   371: istore 4
    //   373: aload 36
    //   375: astore 20
    //   377: aload 42
    //   379: astore 19
    //   381: iload 6
    //   383: istore_3
    //   384: aload 32
    //   386: astore 30
    //   388: aload 37
    //   390: astore 26
    //   392: aload 43
    //   394: astore 25
    //   396: aload 33
    //   398: astore 29
    //   400: aload 38
    //   402: astore 21
    //   404: aload 44
    //   406: astore 24
    //   408: aload 34
    //   410: astore 18
    //   412: aload 39
    //   414: astore 14
    //   416: aload 45
    //   418: astore 15
    //   420: aload_0
    //   421: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   424: ifeq +3935 -> 4359
    //   427: aload 13
    //   429: astore 28
    //   431: aload 35
    //   433: astore 22
    //   435: aload 41
    //   437: astore 23
    //   439: aload 31
    //   441: astore 27
    //   443: iload_1
    //   444: istore 4
    //   446: aload 36
    //   448: astore 20
    //   450: aload 42
    //   452: astore 19
    //   454: iload 6
    //   456: istore_3
    //   457: aload 32
    //   459: astore 30
    //   461: aload 37
    //   463: astore 26
    //   465: aload 43
    //   467: astore 25
    //   469: aload 33
    //   471: astore 29
    //   473: aload 38
    //   475: astore 21
    //   477: aload 44
    //   479: astore 24
    //   481: aload 34
    //   483: astore 18
    //   485: aload 39
    //   487: astore 14
    //   489: aload 45
    //   491: astore 15
    //   493: aload_0
    //   494: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   497: ifne +3557 -> 4054
    //   500: aload 13
    //   502: astore 28
    //   504: aload 35
    //   506: astore 22
    //   508: aload 41
    //   510: astore 23
    //   512: aload 31
    //   514: astore 27
    //   516: iload_1
    //   517: istore 4
    //   519: aload 36
    //   521: astore 20
    //   523: aload 42
    //   525: astore 19
    //   527: iload 6
    //   529: istore_3
    //   530: aload 32
    //   532: astore 30
    //   534: aload 37
    //   536: astore 26
    //   538: aload 43
    //   540: astore 25
    //   542: aload 33
    //   544: astore 29
    //   546: aload 38
    //   548: astore 21
    //   550: aload 44
    //   552: astore 24
    //   554: aload 34
    //   556: astore 18
    //   558: aload 39
    //   560: astore 14
    //   562: aload 45
    //   564: astore 15
    //   566: aload_0
    //   567: getfield 43	org/apache/cordova/FileTransfer$1:val$url	Ljava/net/URL;
    //   570: invokevirtual 91	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   573: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   576: astore 13
    //   578: aload 13
    //   580: astore 28
    //   582: aload 16
    //   584: astore 22
    //   586: aload 17
    //   588: astore 23
    //   590: aload 13
    //   592: astore 27
    //   594: iload_1
    //   595: istore 4
    //   597: aload 16
    //   599: astore 20
    //   601: aload 17
    //   603: astore 19
    //   605: iload 6
    //   607: istore_3
    //   608: aload 13
    //   610: astore 30
    //   612: aload 16
    //   614: astore 26
    //   616: aload 17
    //   618: astore 25
    //   620: aload 13
    //   622: astore 29
    //   624: aload 16
    //   626: astore 21
    //   628: aload 17
    //   630: astore 24
    //   632: aload 13
    //   634: astore 18
    //   636: aload 16
    //   638: astore 14
    //   640: aload 17
    //   642: astore 15
    //   644: aload 13
    //   646: iconst_1
    //   647: invokevirtual 99	java/net/HttpURLConnection:setDoInput	(Z)V
    //   650: aload 13
    //   652: astore 28
    //   654: aload 16
    //   656: astore 22
    //   658: aload 17
    //   660: astore 23
    //   662: aload 13
    //   664: astore 27
    //   666: iload_1
    //   667: istore 4
    //   669: aload 16
    //   671: astore 20
    //   673: aload 17
    //   675: astore 19
    //   677: iload 6
    //   679: istore_3
    //   680: aload 13
    //   682: astore 30
    //   684: aload 16
    //   686: astore 26
    //   688: aload 17
    //   690: astore 25
    //   692: aload 13
    //   694: astore 29
    //   696: aload 16
    //   698: astore 21
    //   700: aload 17
    //   702: astore 24
    //   704: aload 13
    //   706: astore 18
    //   708: aload 16
    //   710: astore 14
    //   712: aload 17
    //   714: astore 15
    //   716: aload 13
    //   718: iconst_1
    //   719: invokevirtual 102	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   722: aload 13
    //   724: astore 28
    //   726: aload 16
    //   728: astore 22
    //   730: aload 17
    //   732: astore 23
    //   734: aload 13
    //   736: astore 27
    //   738: iload_1
    //   739: istore 4
    //   741: aload 16
    //   743: astore 20
    //   745: aload 17
    //   747: astore 19
    //   749: iload 6
    //   751: istore_3
    //   752: aload 13
    //   754: astore 30
    //   756: aload 16
    //   758: astore 26
    //   760: aload 17
    //   762: astore 25
    //   764: aload 13
    //   766: astore 29
    //   768: aload 16
    //   770: astore 21
    //   772: aload 17
    //   774: astore 24
    //   776: aload 13
    //   778: astore 18
    //   780: aload 16
    //   782: astore 14
    //   784: aload 17
    //   786: astore 15
    //   788: aload 13
    //   790: iconst_0
    //   791: invokevirtual 105	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   794: aload 13
    //   796: astore 28
    //   798: aload 16
    //   800: astore 22
    //   802: aload 17
    //   804: astore 23
    //   806: aload 13
    //   808: astore 27
    //   810: iload_1
    //   811: istore 4
    //   813: aload 16
    //   815: astore 20
    //   817: aload 17
    //   819: astore 19
    //   821: iload 6
    //   823: istore_3
    //   824: aload 13
    //   826: astore 30
    //   828: aload 16
    //   830: astore 26
    //   832: aload 17
    //   834: astore 25
    //   836: aload 13
    //   838: astore 29
    //   840: aload 16
    //   842: astore 21
    //   844: aload 17
    //   846: astore 24
    //   848: aload 13
    //   850: astore 18
    //   852: aload 16
    //   854: astore 14
    //   856: aload 17
    //   858: astore 15
    //   860: aload 13
    //   862: ldc 107
    //   864: invokevirtual 111	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   867: aload 13
    //   869: astore 28
    //   871: aload 16
    //   873: astore 22
    //   875: aload 17
    //   877: astore 23
    //   879: aload 13
    //   881: astore 27
    //   883: iload_1
    //   884: istore 4
    //   886: aload 16
    //   888: astore 20
    //   890: aload 17
    //   892: astore 19
    //   894: iload 6
    //   896: istore_3
    //   897: aload 13
    //   899: astore 30
    //   901: aload 16
    //   903: astore 26
    //   905: aload 17
    //   907: astore 25
    //   909: aload 13
    //   911: astore 29
    //   913: aload 16
    //   915: astore 21
    //   917: aload 17
    //   919: astore 24
    //   921: aload 13
    //   923: astore 18
    //   925: aload 16
    //   927: astore 14
    //   929: aload 17
    //   931: astore 15
    //   933: aload 13
    //   935: ldc 113
    //   937: ldc 115
    //   939: invokevirtual 119	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   942: aload 13
    //   944: astore 28
    //   946: aload 16
    //   948: astore 22
    //   950: aload 17
    //   952: astore 23
    //   954: aload 13
    //   956: astore 27
    //   958: iload_1
    //   959: istore 4
    //   961: aload 16
    //   963: astore 20
    //   965: aload 17
    //   967: astore 19
    //   969: iload 6
    //   971: istore_3
    //   972: aload 13
    //   974: astore 30
    //   976: aload 16
    //   978: astore 26
    //   980: aload 17
    //   982: astore 25
    //   984: aload 13
    //   986: astore 29
    //   988: aload 16
    //   990: astore 21
    //   992: aload 17
    //   994: astore 24
    //   996: aload 13
    //   998: astore 18
    //   1000: aload 16
    //   1002: astore 14
    //   1004: aload 17
    //   1006: astore 15
    //   1008: invokestatic 125	android/webkit/CookieManager:getInstance	()Landroid/webkit/CookieManager;
    //   1011: aload_0
    //   1012: getfield 45	org/apache/cordova/FileTransfer$1:val$target	Ljava/lang/String;
    //   1015: invokevirtual 129	android/webkit/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: astore 31
    //   1020: aload 31
    //   1022: ifnull +78 -> 1100
    //   1025: aload 13
    //   1027: astore 28
    //   1029: aload 16
    //   1031: astore 22
    //   1033: aload 17
    //   1035: astore 23
    //   1037: aload 13
    //   1039: astore 27
    //   1041: iload_1
    //   1042: istore 4
    //   1044: aload 16
    //   1046: astore 20
    //   1048: aload 17
    //   1050: astore 19
    //   1052: iload 6
    //   1054: istore_3
    //   1055: aload 13
    //   1057: astore 30
    //   1059: aload 16
    //   1061: astore 26
    //   1063: aload 17
    //   1065: astore 25
    //   1067: aload 13
    //   1069: astore 29
    //   1071: aload 16
    //   1073: astore 21
    //   1075: aload 17
    //   1077: astore 24
    //   1079: aload 13
    //   1081: astore 18
    //   1083: aload 16
    //   1085: astore 14
    //   1087: aload 17
    //   1089: astore 15
    //   1091: aload 13
    //   1093: ldc -125
    //   1095: aload 31
    //   1097: invokevirtual 119	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1100: aload 13
    //   1102: astore 28
    //   1104: aload 16
    //   1106: astore 22
    //   1108: aload 17
    //   1110: astore 23
    //   1112: aload 13
    //   1114: astore 27
    //   1116: iload_1
    //   1117: istore 4
    //   1119: aload 16
    //   1121: astore 20
    //   1123: aload 17
    //   1125: astore 19
    //   1127: iload 6
    //   1129: istore_3
    //   1130: aload 13
    //   1132: astore 30
    //   1134: aload 16
    //   1136: astore 26
    //   1138: aload 17
    //   1140: astore 25
    //   1142: aload 13
    //   1144: astore 29
    //   1146: aload 16
    //   1148: astore 21
    //   1150: aload 17
    //   1152: astore 24
    //   1154: aload 13
    //   1156: astore 18
    //   1158: aload 16
    //   1160: astore 14
    //   1162: aload 17
    //   1164: astore 15
    //   1166: aload_0
    //   1167: getfield 47	org/apache/cordova/FileTransfer$1:val$headers	Lorg/json/JSONObject;
    //   1170: ifnull +78 -> 1248
    //   1173: aload 13
    //   1175: astore 28
    //   1177: aload 16
    //   1179: astore 22
    //   1181: aload 17
    //   1183: astore 23
    //   1185: aload 13
    //   1187: astore 27
    //   1189: iload_1
    //   1190: istore 4
    //   1192: aload 16
    //   1194: astore 20
    //   1196: aload 17
    //   1198: astore 19
    //   1200: iload 6
    //   1202: istore_3
    //   1203: aload 13
    //   1205: astore 30
    //   1207: aload 16
    //   1209: astore 26
    //   1211: aload 17
    //   1213: astore 25
    //   1215: aload 13
    //   1217: astore 29
    //   1219: aload 16
    //   1221: astore 21
    //   1223: aload 17
    //   1225: astore 24
    //   1227: aload 13
    //   1229: astore 18
    //   1231: aload 16
    //   1233: astore 14
    //   1235: aload 17
    //   1237: astore 15
    //   1239: aload 13
    //   1241: aload_0
    //   1242: getfield 47	org/apache/cordova/FileTransfer$1:val$headers	Lorg/json/JSONObject;
    //   1245: invokestatic 135	org/apache/cordova/FileTransfer:access$200	(Ljava/net/URLConnection;Lorg/json/JSONObject;)V
    //   1248: aload 13
    //   1250: astore 28
    //   1252: aload 16
    //   1254: astore 22
    //   1256: aload 17
    //   1258: astore 23
    //   1260: aload 13
    //   1262: astore 27
    //   1264: iload_1
    //   1265: istore 4
    //   1267: aload 16
    //   1269: astore 20
    //   1271: aload 17
    //   1273: astore 19
    //   1275: iload 6
    //   1277: istore_3
    //   1278: aload 13
    //   1280: astore 30
    //   1282: aload 16
    //   1284: astore 26
    //   1286: aload 17
    //   1288: astore 25
    //   1290: aload 13
    //   1292: astore 29
    //   1294: aload 16
    //   1296: astore 21
    //   1298: aload 17
    //   1300: astore 24
    //   1302: aload 13
    //   1304: astore 18
    //   1306: aload 16
    //   1308: astore 14
    //   1310: aload 17
    //   1312: astore 15
    //   1314: new 137	java/lang/StringBuilder
    //   1317: astore 31
    //   1319: aload 13
    //   1321: astore 28
    //   1323: aload 16
    //   1325: astore 22
    //   1327: aload 17
    //   1329: astore 23
    //   1331: aload 13
    //   1333: astore 27
    //   1335: iload_1
    //   1336: istore 4
    //   1338: aload 16
    //   1340: astore 20
    //   1342: aload 17
    //   1344: astore 19
    //   1346: iload 6
    //   1348: istore_3
    //   1349: aload 13
    //   1351: astore 30
    //   1353: aload 16
    //   1355: astore 26
    //   1357: aload 17
    //   1359: astore 25
    //   1361: aload 13
    //   1363: astore 29
    //   1365: aload 16
    //   1367: astore 21
    //   1369: aload 17
    //   1371: astore 24
    //   1373: aload 13
    //   1375: astore 18
    //   1377: aload 16
    //   1379: astore 14
    //   1381: aload 17
    //   1383: astore 15
    //   1385: aload 31
    //   1387: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   1390: aload 13
    //   1392: astore 28
    //   1394: aload 16
    //   1396: astore 22
    //   1398: aload 17
    //   1400: astore 23
    //   1402: aload 13
    //   1404: astore 27
    //   1406: iload_1
    //   1407: istore 4
    //   1409: aload 16
    //   1411: astore 20
    //   1413: aload 17
    //   1415: astore 19
    //   1417: iload 6
    //   1419: istore_3
    //   1420: aload 13
    //   1422: astore 29
    //   1424: aload 16
    //   1426: astore 21
    //   1428: aload 17
    //   1430: astore 24
    //   1432: aload 13
    //   1434: astore 18
    //   1436: aload 16
    //   1438: astore 14
    //   1440: aload 17
    //   1442: astore 15
    //   1444: aload_0
    //   1445: getfield 49	org/apache/cordova/FileTransfer$1:val$params	Lorg/json/JSONObject;
    //   1448: invokevirtual 144	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   1451: astore 25
    //   1453: aload 13
    //   1455: astore 28
    //   1457: aload 16
    //   1459: astore 22
    //   1461: aload 17
    //   1463: astore 23
    //   1465: aload 13
    //   1467: astore 27
    //   1469: iload_1
    //   1470: istore 4
    //   1472: aload 16
    //   1474: astore 20
    //   1476: aload 17
    //   1478: astore 19
    //   1480: iload 6
    //   1482: istore_3
    //   1483: aload 13
    //   1485: astore 29
    //   1487: aload 16
    //   1489: astore 21
    //   1491: aload 17
    //   1493: astore 24
    //   1495: aload 13
    //   1497: astore 18
    //   1499: aload 16
    //   1501: astore 14
    //   1503: aload 17
    //   1505: astore 15
    //   1507: aload 25
    //   1509: invokeinterface 150 1 0
    //   1514: ifeq +565 -> 2079
    //   1517: aload 13
    //   1519: astore 28
    //   1521: aload 16
    //   1523: astore 22
    //   1525: aload 17
    //   1527: astore 23
    //   1529: aload 13
    //   1531: astore 27
    //   1533: iload_1
    //   1534: istore 4
    //   1536: aload 16
    //   1538: astore 20
    //   1540: aload 17
    //   1542: astore 19
    //   1544: iload 6
    //   1546: istore_3
    //   1547: aload 13
    //   1549: astore 29
    //   1551: aload 16
    //   1553: astore 21
    //   1555: aload 17
    //   1557: astore 24
    //   1559: aload 13
    //   1561: astore 18
    //   1563: aload 16
    //   1565: astore 14
    //   1567: aload 17
    //   1569: astore 15
    //   1571: aload 25
    //   1573: invokeinterface 154 1 0
    //   1578: astore 26
    //   1580: aload 13
    //   1582: astore 28
    //   1584: aload 16
    //   1586: astore 22
    //   1588: aload 17
    //   1590: astore 23
    //   1592: aload 13
    //   1594: astore 27
    //   1596: iload_1
    //   1597: istore 4
    //   1599: aload 16
    //   1601: astore 20
    //   1603: aload 17
    //   1605: astore 19
    //   1607: iload 6
    //   1609: istore_3
    //   1610: aload 13
    //   1612: astore 29
    //   1614: aload 16
    //   1616: astore 21
    //   1618: aload 17
    //   1620: astore 24
    //   1622: aload 13
    //   1624: astore 18
    //   1626: aload 16
    //   1628: astore 14
    //   1630: aload 17
    //   1632: astore 15
    //   1634: aload 26
    //   1636: invokestatic 160	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1639: ldc -94
    //   1641: invokevirtual 166	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1644: ifne -191 -> 1453
    //   1647: aload 13
    //   1649: astore 28
    //   1651: aload 16
    //   1653: astore 22
    //   1655: aload 17
    //   1657: astore 23
    //   1659: aload 13
    //   1661: astore 27
    //   1663: iload_1
    //   1664: istore 4
    //   1666: aload 16
    //   1668: astore 20
    //   1670: aload 17
    //   1672: astore 19
    //   1674: iload 6
    //   1676: istore_3
    //   1677: aload 13
    //   1679: astore 29
    //   1681: aload 16
    //   1683: astore 21
    //   1685: aload 17
    //   1687: astore 24
    //   1689: aload 13
    //   1691: astore 18
    //   1693: aload 16
    //   1695: astore 14
    //   1697: aload 17
    //   1699: astore 15
    //   1701: aload 31
    //   1703: ldc -88
    //   1705: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1708: ldc -82
    //   1710: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: ldc -80
    //   1715: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1718: pop
    //   1719: aload 13
    //   1721: astore 28
    //   1723: aload 16
    //   1725: astore 22
    //   1727: aload 17
    //   1729: astore 23
    //   1731: aload 13
    //   1733: astore 27
    //   1735: iload_1
    //   1736: istore 4
    //   1738: aload 16
    //   1740: astore 20
    //   1742: aload 17
    //   1744: astore 19
    //   1746: iload 6
    //   1748: istore_3
    //   1749: aload 13
    //   1751: astore 29
    //   1753: aload 16
    //   1755: astore 21
    //   1757: aload 17
    //   1759: astore 24
    //   1761: aload 13
    //   1763: astore 18
    //   1765: aload 16
    //   1767: astore 14
    //   1769: aload 17
    //   1771: astore 15
    //   1773: aload 31
    //   1775: ldc -78
    //   1777: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: aload 26
    //   1782: invokevirtual 182	java/lang/Object:toString	()Ljava/lang/String;
    //   1785: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: bipush 34
    //   1790: invokevirtual 185	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   1793: pop
    //   1794: aload 13
    //   1796: astore 28
    //   1798: aload 16
    //   1800: astore 22
    //   1802: aload 17
    //   1804: astore 23
    //   1806: aload 13
    //   1808: astore 27
    //   1810: iload_1
    //   1811: istore 4
    //   1813: aload 16
    //   1815: astore 20
    //   1817: aload 17
    //   1819: astore 19
    //   1821: iload 6
    //   1823: istore_3
    //   1824: aload 13
    //   1826: astore 29
    //   1828: aload 16
    //   1830: astore 21
    //   1832: aload 17
    //   1834: astore 24
    //   1836: aload 13
    //   1838: astore 18
    //   1840: aload 16
    //   1842: astore 14
    //   1844: aload 17
    //   1846: astore 15
    //   1848: aload 31
    //   1850: ldc -80
    //   1852: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: ldc -80
    //   1857: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1860: pop
    //   1861: aload 13
    //   1863: astore 28
    //   1865: aload 16
    //   1867: astore 22
    //   1869: aload 17
    //   1871: astore 23
    //   1873: aload 13
    //   1875: astore 27
    //   1877: iload_1
    //   1878: istore 4
    //   1880: aload 16
    //   1882: astore 20
    //   1884: aload 17
    //   1886: astore 19
    //   1888: iload 6
    //   1890: istore_3
    //   1891: aload 13
    //   1893: astore 29
    //   1895: aload 16
    //   1897: astore 21
    //   1899: aload 17
    //   1901: astore 24
    //   1903: aload 13
    //   1905: astore 18
    //   1907: aload 16
    //   1909: astore 14
    //   1911: aload 17
    //   1913: astore 15
    //   1915: aload 31
    //   1917: aload_0
    //   1918: getfield 49	org/apache/cordova/FileTransfer$1:val$params	Lorg/json/JSONObject;
    //   1921: aload 26
    //   1923: invokevirtual 182	java/lang/Object:toString	()Ljava/lang/String;
    //   1926: invokevirtual 188	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1929: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: pop
    //   1933: aload 13
    //   1935: astore 28
    //   1937: aload 16
    //   1939: astore 22
    //   1941: aload 17
    //   1943: astore 23
    //   1945: aload 13
    //   1947: astore 27
    //   1949: iload_1
    //   1950: istore 4
    //   1952: aload 16
    //   1954: astore 20
    //   1956: aload 17
    //   1958: astore 19
    //   1960: iload 6
    //   1962: istore_3
    //   1963: aload 13
    //   1965: astore 29
    //   1967: aload 16
    //   1969: astore 21
    //   1971: aload 17
    //   1973: astore 24
    //   1975: aload 13
    //   1977: astore 18
    //   1979: aload 16
    //   1981: astore 14
    //   1983: aload 17
    //   1985: astore 15
    //   1987: aload 31
    //   1989: ldc -80
    //   1991: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1994: pop
    //   1995: goto -542 -> 1453
    //   1998: astore 32
    //   2000: aload 13
    //   2002: astore 28
    //   2004: aload 16
    //   2006: astore 22
    //   2008: aload 17
    //   2010: astore 23
    //   2012: aload 13
    //   2014: astore 27
    //   2016: iload_1
    //   2017: istore 4
    //   2019: aload 16
    //   2021: astore 20
    //   2023: aload 17
    //   2025: astore 19
    //   2027: iload 6
    //   2029: istore_3
    //   2030: aload 13
    //   2032: astore 30
    //   2034: aload 16
    //   2036: astore 26
    //   2038: aload 17
    //   2040: astore 25
    //   2042: aload 13
    //   2044: astore 29
    //   2046: aload 16
    //   2048: astore 21
    //   2050: aload 17
    //   2052: astore 24
    //   2054: aload 13
    //   2056: astore 18
    //   2058: aload 16
    //   2060: astore 14
    //   2062: aload 17
    //   2064: astore 15
    //   2066: ldc -66
    //   2068: aload 32
    //   2070: invokevirtual 193	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   2073: aload 32
    //   2075: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   2078: pop
    //   2079: aload 13
    //   2081: astore 28
    //   2083: aload 16
    //   2085: astore 22
    //   2087: aload 17
    //   2089: astore 23
    //   2091: aload 13
    //   2093: astore 27
    //   2095: iload_1
    //   2096: istore 4
    //   2098: aload 16
    //   2100: astore 20
    //   2102: aload 17
    //   2104: astore 19
    //   2106: iload 6
    //   2108: istore_3
    //   2109: aload 13
    //   2111: astore 30
    //   2113: aload 16
    //   2115: astore 26
    //   2117: aload 17
    //   2119: astore 25
    //   2121: aload 13
    //   2123: astore 29
    //   2125: aload 16
    //   2127: astore 21
    //   2129: aload 17
    //   2131: astore 24
    //   2133: aload 13
    //   2135: astore 18
    //   2137: aload 16
    //   2139: astore 14
    //   2141: aload 17
    //   2143: astore 15
    //   2145: aload 31
    //   2147: ldc -88
    //   2149: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: ldc -82
    //   2154: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: ldc -80
    //   2159: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2162: pop
    //   2163: aload 13
    //   2165: astore 28
    //   2167: aload 16
    //   2169: astore 22
    //   2171: aload 17
    //   2173: astore 23
    //   2175: aload 13
    //   2177: astore 27
    //   2179: iload_1
    //   2180: istore 4
    //   2182: aload 16
    //   2184: astore 20
    //   2186: aload 17
    //   2188: astore 19
    //   2190: iload 6
    //   2192: istore_3
    //   2193: aload 13
    //   2195: astore 30
    //   2197: aload 16
    //   2199: astore 26
    //   2201: aload 17
    //   2203: astore 25
    //   2205: aload 13
    //   2207: astore 29
    //   2209: aload 16
    //   2211: astore 21
    //   2213: aload 17
    //   2215: astore 24
    //   2217: aload 13
    //   2219: astore 18
    //   2221: aload 16
    //   2223: astore 14
    //   2225: aload 17
    //   2227: astore 15
    //   2229: aload 31
    //   2231: ldc -78
    //   2233: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2236: aload_0
    //   2237: getfield 51	org/apache/cordova/FileTransfer$1:val$fileKey	Ljava/lang/String;
    //   2240: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: ldc -55
    //   2245: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: pop
    //   2249: aload 13
    //   2251: astore 28
    //   2253: aload 16
    //   2255: astore 22
    //   2257: aload 17
    //   2259: astore 23
    //   2261: aload 13
    //   2263: astore 27
    //   2265: iload_1
    //   2266: istore 4
    //   2268: aload 16
    //   2270: astore 20
    //   2272: aload 17
    //   2274: astore 19
    //   2276: iload 6
    //   2278: istore_3
    //   2279: aload 13
    //   2281: astore 30
    //   2283: aload 16
    //   2285: astore 26
    //   2287: aload 17
    //   2289: astore 25
    //   2291: aload 13
    //   2293: astore 29
    //   2295: aload 16
    //   2297: astore 21
    //   2299: aload 17
    //   2301: astore 24
    //   2303: aload 13
    //   2305: astore 18
    //   2307: aload 16
    //   2309: astore 14
    //   2311: aload 17
    //   2313: astore 15
    //   2315: aload 31
    //   2317: ldc -53
    //   2319: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2322: aload_0
    //   2323: getfield 53	org/apache/cordova/FileTransfer$1:val$fileName	Ljava/lang/String;
    //   2326: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2329: bipush 34
    //   2331: invokevirtual 185	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   2334: ldc -80
    //   2336: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: pop
    //   2340: aload 13
    //   2342: astore 28
    //   2344: aload 16
    //   2346: astore 22
    //   2348: aload 17
    //   2350: astore 23
    //   2352: aload 13
    //   2354: astore 27
    //   2356: iload_1
    //   2357: istore 4
    //   2359: aload 16
    //   2361: astore 20
    //   2363: aload 17
    //   2365: astore 19
    //   2367: iload 6
    //   2369: istore_3
    //   2370: aload 13
    //   2372: astore 30
    //   2374: aload 16
    //   2376: astore 26
    //   2378: aload 17
    //   2380: astore 25
    //   2382: aload 13
    //   2384: astore 29
    //   2386: aload 16
    //   2388: astore 21
    //   2390: aload 17
    //   2392: astore 24
    //   2394: aload 13
    //   2396: astore 18
    //   2398: aload 16
    //   2400: astore 14
    //   2402: aload 17
    //   2404: astore 15
    //   2406: aload 31
    //   2408: ldc -51
    //   2410: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2413: aload_0
    //   2414: getfield 55	org/apache/cordova/FileTransfer$1:val$mimeType	Ljava/lang/String;
    //   2417: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2420: ldc -80
    //   2422: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2425: ldc -80
    //   2427: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2430: pop
    //   2431: aload 13
    //   2433: astore 28
    //   2435: aload 16
    //   2437: astore 22
    //   2439: aload 17
    //   2441: astore 23
    //   2443: aload 13
    //   2445: astore 27
    //   2447: iload_1
    //   2448: istore 4
    //   2450: aload 16
    //   2452: astore 20
    //   2454: aload 17
    //   2456: astore 19
    //   2458: iload 6
    //   2460: istore_3
    //   2461: aload 13
    //   2463: astore 30
    //   2465: aload 16
    //   2467: astore 26
    //   2469: aload 17
    //   2471: astore 25
    //   2473: aload 13
    //   2475: astore 29
    //   2477: aload 16
    //   2479: astore 21
    //   2481: aload 17
    //   2483: astore 24
    //   2485: aload 13
    //   2487: astore 18
    //   2489: aload 16
    //   2491: astore 14
    //   2493: aload 17
    //   2495: astore 15
    //   2497: aload 31
    //   2499: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2502: ldc -48
    //   2504: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   2507: astore 35
    //   2509: aload 13
    //   2511: astore 28
    //   2513: aload 16
    //   2515: astore 22
    //   2517: aload 17
    //   2519: astore 23
    //   2521: aload 13
    //   2523: astore 27
    //   2525: iload_1
    //   2526: istore 4
    //   2528: aload 16
    //   2530: astore 20
    //   2532: aload 17
    //   2534: astore 19
    //   2536: iload 6
    //   2538: istore_3
    //   2539: aload 13
    //   2541: astore 30
    //   2543: aload 16
    //   2545: astore 26
    //   2547: aload 17
    //   2549: astore 25
    //   2551: aload 13
    //   2553: astore 29
    //   2555: aload 16
    //   2557: astore 21
    //   2559: aload 17
    //   2561: astore 24
    //   2563: aload 13
    //   2565: astore 18
    //   2567: aload 16
    //   2569: astore 14
    //   2571: aload 17
    //   2573: astore 15
    //   2575: ldc -42
    //   2577: ldc -48
    //   2579: invokevirtual 212	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   2582: astore 34
    //   2584: aload 13
    //   2586: astore 28
    //   2588: aload 16
    //   2590: astore 22
    //   2592: aload 17
    //   2594: astore 23
    //   2596: aload 13
    //   2598: astore 27
    //   2600: iload_1
    //   2601: istore 4
    //   2603: aload 16
    //   2605: astore 20
    //   2607: aload 17
    //   2609: astore 19
    //   2611: iload 6
    //   2613: istore_3
    //   2614: aload 13
    //   2616: astore 30
    //   2618: aload 16
    //   2620: astore 26
    //   2622: aload 17
    //   2624: astore 25
    //   2626: aload 13
    //   2628: astore 29
    //   2630: aload 16
    //   2632: astore 21
    //   2634: aload 17
    //   2636: astore 24
    //   2638: aload 13
    //   2640: astore 18
    //   2642: aload 16
    //   2644: astore 14
    //   2646: aload 17
    //   2648: astore 15
    //   2650: aload_0
    //   2651: getfield 35	org/apache/cordova/FileTransfer$1:this$0	Lorg/apache/cordova/FileTransfer;
    //   2654: aload_0
    //   2655: getfield 57	org/apache/cordova/FileTransfer$1:val$source	Ljava/lang/String;
    //   2658: invokestatic 218	org/apache/cordova/FileTransfer:access$300	(Lorg/apache/cordova/FileTransfer;Ljava/lang/String;)Ljava/io/InputStream;
    //   2661: astore 33
    //   2663: aload 13
    //   2665: astore 28
    //   2667: aload 16
    //   2669: astore 22
    //   2671: aload 17
    //   2673: astore 23
    //   2675: aload 13
    //   2677: astore 27
    //   2679: iload_1
    //   2680: istore 4
    //   2682: aload 16
    //   2684: astore 20
    //   2686: aload 17
    //   2688: astore 19
    //   2690: iload 6
    //   2692: istore_3
    //   2693: aload 13
    //   2695: astore 30
    //   2697: aload 16
    //   2699: astore 26
    //   2701: aload 17
    //   2703: astore 25
    //   2705: aload 13
    //   2707: astore 29
    //   2709: aload 16
    //   2711: astore 21
    //   2713: aload 17
    //   2715: astore 24
    //   2717: aload 13
    //   2719: astore 18
    //   2721: aload 16
    //   2723: astore 14
    //   2725: aload 17
    //   2727: astore 15
    //   2729: aload 35
    //   2731: arraylength
    //   2732: istore 8
    //   2734: aload 13
    //   2736: astore 28
    //   2738: aload 16
    //   2740: astore 22
    //   2742: aload 17
    //   2744: astore 23
    //   2746: aload 13
    //   2748: astore 27
    //   2750: iload_1
    //   2751: istore 4
    //   2753: aload 16
    //   2755: astore 20
    //   2757: aload 17
    //   2759: astore 19
    //   2761: iload 6
    //   2763: istore_3
    //   2764: aload 13
    //   2766: astore 30
    //   2768: aload 16
    //   2770: astore 26
    //   2772: aload 17
    //   2774: astore 25
    //   2776: aload 13
    //   2778: astore 29
    //   2780: aload 16
    //   2782: astore 21
    //   2784: aload 17
    //   2786: astore 24
    //   2788: aload 13
    //   2790: astore 18
    //   2792: aload 16
    //   2794: astore 14
    //   2796: aload 17
    //   2798: astore 15
    //   2800: aload 34
    //   2802: arraylength
    //   2803: istore 7
    //   2805: iload_1
    //   2806: istore_2
    //   2807: aload 13
    //   2809: astore 28
    //   2811: aload 16
    //   2813: astore 22
    //   2815: aload 17
    //   2817: astore 23
    //   2819: aload 13
    //   2821: astore 27
    //   2823: iload_1
    //   2824: istore 4
    //   2826: aload 16
    //   2828: astore 20
    //   2830: aload 17
    //   2832: astore 19
    //   2834: iload 6
    //   2836: istore_3
    //   2837: aload 13
    //   2839: astore 30
    //   2841: aload 16
    //   2843: astore 26
    //   2845: aload 17
    //   2847: astore 25
    //   2849: aload 13
    //   2851: astore 29
    //   2853: aload 16
    //   2855: astore 21
    //   2857: aload 17
    //   2859: astore 24
    //   2861: aload 13
    //   2863: astore 18
    //   2865: aload 16
    //   2867: astore 14
    //   2869: aload 17
    //   2871: astore 15
    //   2873: aload 33
    //   2875: instanceof 220
    //   2878: ifeq +233 -> 3111
    //   2881: aload 13
    //   2883: astore 28
    //   2885: aload 16
    //   2887: astore 22
    //   2889: aload 17
    //   2891: astore 23
    //   2893: aload 13
    //   2895: astore 27
    //   2897: iload_1
    //   2898: istore 4
    //   2900: aload 16
    //   2902: astore 20
    //   2904: aload 17
    //   2906: astore 19
    //   2908: iload 6
    //   2910: istore_3
    //   2911: aload 13
    //   2913: astore 30
    //   2915: aload 16
    //   2917: astore 26
    //   2919: aload 17
    //   2921: astore 25
    //   2923: aload 13
    //   2925: astore 29
    //   2927: aload 16
    //   2929: astore 21
    //   2931: aload 17
    //   2933: astore 24
    //   2935: aload 13
    //   2937: astore 18
    //   2939: aload 16
    //   2941: astore 14
    //   2943: aload 17
    //   2945: astore 15
    //   2947: aload 33
    //   2949: checkcast 220	java/io/FileInputStream
    //   2952: invokevirtual 224	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   2955: invokevirtual 230	java/nio/channels/FileChannel:size	()J
    //   2958: l2i
    //   2959: iload 8
    //   2961: iload 7
    //   2963: iadd
    //   2964: iadd
    //   2965: istore_2
    //   2966: aload 13
    //   2968: astore 28
    //   2970: aload 16
    //   2972: astore 22
    //   2974: aload 17
    //   2976: astore 23
    //   2978: aload 13
    //   2980: astore 27
    //   2982: iload_2
    //   2983: istore 4
    //   2985: aload 16
    //   2987: astore 20
    //   2989: aload 17
    //   2991: astore 19
    //   2993: iload 6
    //   2995: istore_3
    //   2996: aload 13
    //   2998: astore 30
    //   3000: aload 16
    //   3002: astore 26
    //   3004: aload 17
    //   3006: astore 25
    //   3008: aload 13
    //   3010: astore 29
    //   3012: aload 16
    //   3014: astore 21
    //   3016: aload 17
    //   3018: astore 24
    //   3020: aload 13
    //   3022: astore 18
    //   3024: aload 16
    //   3026: astore 14
    //   3028: aload 17
    //   3030: astore 15
    //   3032: aload 47
    //   3034: iconst_1
    //   3035: invokevirtual 233	org/apache/cordova/FileProgressResult:setLengthComputable	(Z)V
    //   3038: aload 13
    //   3040: astore 28
    //   3042: aload 16
    //   3044: astore 22
    //   3046: aload 17
    //   3048: astore 23
    //   3050: aload 13
    //   3052: astore 27
    //   3054: iload_2
    //   3055: istore 4
    //   3057: aload 16
    //   3059: astore 20
    //   3061: aload 17
    //   3063: astore 19
    //   3065: iload 6
    //   3067: istore_3
    //   3068: aload 13
    //   3070: astore 30
    //   3072: aload 16
    //   3074: astore 26
    //   3076: aload 17
    //   3078: astore 25
    //   3080: aload 13
    //   3082: astore 29
    //   3084: aload 16
    //   3086: astore 21
    //   3088: aload 17
    //   3090: astore 24
    //   3092: aload 13
    //   3094: astore 18
    //   3096: aload 16
    //   3098: astore 14
    //   3100: aload 17
    //   3102: astore 15
    //   3104: aload 47
    //   3106: iload_2
    //   3107: i2l
    //   3108: invokevirtual 237	org/apache/cordova/FileProgressResult:setTotal	(J)V
    //   3111: aload 13
    //   3113: astore 28
    //   3115: aload 16
    //   3117: astore 22
    //   3119: aload 17
    //   3121: astore 23
    //   3123: aload 13
    //   3125: astore 27
    //   3127: iload_2
    //   3128: istore 4
    //   3130: aload 16
    //   3132: astore 20
    //   3134: aload 17
    //   3136: astore 19
    //   3138: iload 6
    //   3140: istore_3
    //   3141: aload 13
    //   3143: astore 30
    //   3145: aload 16
    //   3147: astore 26
    //   3149: aload 17
    //   3151: astore 25
    //   3153: aload 13
    //   3155: astore 29
    //   3157: aload 16
    //   3159: astore 21
    //   3161: aload 17
    //   3163: astore 24
    //   3165: aload 13
    //   3167: astore 18
    //   3169: aload 16
    //   3171: astore 14
    //   3173: aload 17
    //   3175: astore 15
    //   3177: new 137	java/lang/StringBuilder
    //   3180: astore 31
    //   3182: aload 13
    //   3184: astore 28
    //   3186: aload 16
    //   3188: astore 22
    //   3190: aload 17
    //   3192: astore 23
    //   3194: aload 13
    //   3196: astore 27
    //   3198: iload_2
    //   3199: istore 4
    //   3201: aload 16
    //   3203: astore 20
    //   3205: aload 17
    //   3207: astore 19
    //   3209: iload 6
    //   3211: istore_3
    //   3212: aload 13
    //   3214: astore 30
    //   3216: aload 16
    //   3218: astore 26
    //   3220: aload 17
    //   3222: astore 25
    //   3224: aload 13
    //   3226: astore 29
    //   3228: aload 16
    //   3230: astore 21
    //   3232: aload 17
    //   3234: astore 24
    //   3236: aload 13
    //   3238: astore 18
    //   3240: aload 16
    //   3242: astore 14
    //   3244: aload 17
    //   3246: astore 15
    //   3248: aload 31
    //   3250: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   3253: aload 13
    //   3255: astore 28
    //   3257: aload 16
    //   3259: astore 22
    //   3261: aload 17
    //   3263: astore 23
    //   3265: aload 13
    //   3267: astore 27
    //   3269: iload_2
    //   3270: istore 4
    //   3272: aload 16
    //   3274: astore 20
    //   3276: aload 17
    //   3278: astore 19
    //   3280: iload 6
    //   3282: istore_3
    //   3283: aload 13
    //   3285: astore 30
    //   3287: aload 16
    //   3289: astore 26
    //   3291: aload 17
    //   3293: astore 25
    //   3295: aload 13
    //   3297: astore 29
    //   3299: aload 16
    //   3301: astore 21
    //   3303: aload 17
    //   3305: astore 24
    //   3307: aload 13
    //   3309: astore 18
    //   3311: aload 16
    //   3313: astore 14
    //   3315: aload 17
    //   3317: astore 15
    //   3319: ldc -66
    //   3321: aload 31
    //   3323: ldc -17
    //   3325: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3328: iload_2
    //   3329: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3332: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3335: invokestatic 246	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   3338: pop
    //   3339: aload 13
    //   3341: astore 28
    //   3343: aload 16
    //   3345: astore 22
    //   3347: aload 17
    //   3349: astore 23
    //   3351: aload 13
    //   3353: astore 27
    //   3355: iload_2
    //   3356: istore 4
    //   3358: aload 16
    //   3360: astore 20
    //   3362: aload 17
    //   3364: astore 19
    //   3366: iload 6
    //   3368: istore_3
    //   3369: aload 13
    //   3371: astore 30
    //   3373: aload 16
    //   3375: astore 26
    //   3377: aload 17
    //   3379: astore 25
    //   3381: aload 13
    //   3383: astore 29
    //   3385: aload 16
    //   3387: astore 21
    //   3389: aload 17
    //   3391: astore 24
    //   3393: aload 13
    //   3395: astore 18
    //   3397: aload 16
    //   3399: astore 14
    //   3401: aload 17
    //   3403: astore 15
    //   3405: aload_0
    //   3406: getfield 59	org/apache/cordova/FileTransfer$1:val$chunkedMode	Z
    //   3409: ifeq +1031 -> 4440
    //   3412: aload 13
    //   3414: astore 28
    //   3416: aload 16
    //   3418: astore 22
    //   3420: aload 17
    //   3422: astore 23
    //   3424: aload 13
    //   3426: astore 27
    //   3428: iload_2
    //   3429: istore 4
    //   3431: aload 16
    //   3433: astore 20
    //   3435: aload 17
    //   3437: astore 19
    //   3439: iload 6
    //   3441: istore_3
    //   3442: aload 13
    //   3444: astore 30
    //   3446: aload 16
    //   3448: astore 26
    //   3450: aload 17
    //   3452: astore 25
    //   3454: aload 13
    //   3456: astore 29
    //   3458: aload 16
    //   3460: astore 21
    //   3462: aload 17
    //   3464: astore 24
    //   3466: aload 13
    //   3468: astore 18
    //   3470: aload 16
    //   3472: astore 14
    //   3474: aload 17
    //   3476: astore 15
    //   3478: getstatic 252	android/os/Build$VERSION:SDK_INT	I
    //   3481: bipush 8
    //   3483: if_icmplt +76 -> 3559
    //   3486: aload 13
    //   3488: astore 28
    //   3490: aload 16
    //   3492: astore 22
    //   3494: aload 17
    //   3496: astore 23
    //   3498: aload 13
    //   3500: astore 27
    //   3502: iload_2
    //   3503: istore 4
    //   3505: aload 16
    //   3507: astore 20
    //   3509: aload 17
    //   3511: astore 19
    //   3513: iload 6
    //   3515: istore_3
    //   3516: aload 13
    //   3518: astore 30
    //   3520: aload 16
    //   3522: astore 26
    //   3524: aload 17
    //   3526: astore 25
    //   3528: aload 13
    //   3530: astore 29
    //   3532: aload 16
    //   3534: astore 21
    //   3536: aload 17
    //   3538: astore 24
    //   3540: aload 13
    //   3542: astore 18
    //   3544: aload 16
    //   3546: astore 14
    //   3548: aload 17
    //   3550: astore 15
    //   3552: aload_0
    //   3553: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   3556: ifeq +884 -> 4440
    //   3559: iconst_1
    //   3560: istore_1
    //   3561: iload_1
    //   3562: ifne +8 -> 3570
    //   3565: iload_2
    //   3566: iconst_m1
    //   3567: if_icmpne +878 -> 4445
    //   3570: iconst_1
    //   3571: istore_1
    //   3572: iload_1
    //   3573: ifeq +877 -> 4450
    //   3576: aload 13
    //   3578: astore 28
    //   3580: aload 16
    //   3582: astore 22
    //   3584: aload 17
    //   3586: astore 23
    //   3588: aload 13
    //   3590: astore 27
    //   3592: iload_2
    //   3593: istore 4
    //   3595: aload 16
    //   3597: astore 20
    //   3599: aload 17
    //   3601: astore 19
    //   3603: iload 6
    //   3605: istore_3
    //   3606: aload 13
    //   3608: astore 30
    //   3610: aload 16
    //   3612: astore 26
    //   3614: aload 17
    //   3616: astore 25
    //   3618: aload 13
    //   3620: astore 29
    //   3622: aload 16
    //   3624: astore 21
    //   3626: aload 17
    //   3628: astore 24
    //   3630: aload 13
    //   3632: astore 18
    //   3634: aload 16
    //   3636: astore 14
    //   3638: aload 17
    //   3640: astore 15
    //   3642: aload 13
    //   3644: sipush 16384
    //   3647: invokevirtual 256	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   3650: aload 13
    //   3652: astore 28
    //   3654: aload 16
    //   3656: astore 22
    //   3658: aload 17
    //   3660: astore 23
    //   3662: aload 13
    //   3664: astore 27
    //   3666: iload_2
    //   3667: istore 4
    //   3669: aload 16
    //   3671: astore 20
    //   3673: aload 17
    //   3675: astore 19
    //   3677: iload 6
    //   3679: istore_3
    //   3680: aload 13
    //   3682: astore 30
    //   3684: aload 16
    //   3686: astore 26
    //   3688: aload 17
    //   3690: astore 25
    //   3692: aload 13
    //   3694: astore 29
    //   3696: aload 16
    //   3698: astore 21
    //   3700: aload 17
    //   3702: astore 24
    //   3704: aload 13
    //   3706: astore 18
    //   3708: aload 16
    //   3710: astore 14
    //   3712: aload 17
    //   3714: astore 15
    //   3716: aload 13
    //   3718: ldc_w 258
    //   3721: ldc_w 260
    //   3724: invokevirtual 119	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   3727: aload 13
    //   3729: astore 28
    //   3731: aload 16
    //   3733: astore 22
    //   3735: aload 17
    //   3737: astore 23
    //   3739: aload 13
    //   3741: astore 27
    //   3743: iload_2
    //   3744: istore 4
    //   3746: aload 16
    //   3748: astore 20
    //   3750: aload 17
    //   3752: astore 19
    //   3754: iload 6
    //   3756: istore_3
    //   3757: aload 13
    //   3759: astore 30
    //   3761: aload 16
    //   3763: astore 26
    //   3765: aload 17
    //   3767: astore 25
    //   3769: aload 13
    //   3771: astore 29
    //   3773: aload 16
    //   3775: astore 21
    //   3777: aload 17
    //   3779: astore 24
    //   3781: aload 13
    //   3783: astore 18
    //   3785: aload 16
    //   3787: astore 14
    //   3789: aload 17
    //   3791: astore 15
    //   3793: aload 13
    //   3795: invokevirtual 263	java/net/HttpURLConnection:connect	()V
    //   3798: aconst_null
    //   3799: astore 31
    //   3801: iload 5
    //   3803: istore_1
    //   3804: aload 13
    //   3806: invokevirtual 267	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   3809: astore 32
    //   3811: aload 32
    //   3813: astore 31
    //   3815: iload 5
    //   3817: istore_1
    //   3818: aload_0
    //   3819: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   3822: astore 14
    //   3824: aload 32
    //   3826: astore 31
    //   3828: iload 5
    //   3830: istore_1
    //   3831: aload 14
    //   3833: monitorenter
    //   3834: aload_0
    //   3835: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   3838: getfield 79	org/apache/cordova/FileTransfer$RequestContext:aborted	Z
    //   3841: ifeq +890 -> 4731
    //   3844: aload 14
    //   3846: monitorexit
    //   3847: aload 13
    //   3849: astore 28
    //   3851: aload 16
    //   3853: astore 22
    //   3855: aload 17
    //   3857: astore 23
    //   3859: aload 13
    //   3861: astore 27
    //   3863: iload_2
    //   3864: istore 4
    //   3866: aload 16
    //   3868: astore 20
    //   3870: aload 17
    //   3872: astore 19
    //   3874: iload 6
    //   3876: istore_3
    //   3877: aload 13
    //   3879: astore 30
    //   3881: aload 16
    //   3883: astore 26
    //   3885: aload 17
    //   3887: astore 25
    //   3889: aload 13
    //   3891: astore 29
    //   3893: aload 16
    //   3895: astore 21
    //   3897: aload 17
    //   3899: astore 24
    //   3901: aload 13
    //   3903: astore 18
    //   3905: aload 16
    //   3907: astore 14
    //   3909: aload 17
    //   3911: astore 15
    //   3913: aload 33
    //   3915: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   3918: aload 13
    //   3920: astore 28
    //   3922: aload 16
    //   3924: astore 22
    //   3926: aload 17
    //   3928: astore 23
    //   3930: aload 13
    //   3932: astore 27
    //   3934: iload_2
    //   3935: istore 4
    //   3937: aload 16
    //   3939: astore 20
    //   3941: aload 17
    //   3943: astore 19
    //   3945: iload 6
    //   3947: istore_3
    //   3948: aload 13
    //   3950: astore 30
    //   3952: aload 16
    //   3954: astore 26
    //   3956: aload 17
    //   3958: astore 25
    //   3960: aload 13
    //   3962: astore 29
    //   3964: aload 16
    //   3966: astore 21
    //   3968: aload 17
    //   3970: astore 24
    //   3972: aload 13
    //   3974: astore 18
    //   3976: aload 16
    //   3978: astore 14
    //   3980: aload 17
    //   3982: astore 15
    //   3984: aload 32
    //   3986: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   3989: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   3992: astore 14
    //   3994: aload 14
    //   3996: monitorenter
    //   3997: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4000: aload_0
    //   4001: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   4004: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4007: pop
    //   4008: aload 14
    //   4010: monitorexit
    //   4011: aload 13
    //   4013: ifnull -4003 -> 10
    //   4016: aload_0
    //   4017: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   4020: ifeq -4010 -> 10
    //   4023: aload_0
    //   4024: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   4027: ifeq -4017 -> 10
    //   4030: aload 13
    //   4032: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   4035: astore 13
    //   4037: aload 13
    //   4039: aload 16
    //   4041: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   4044: aload 13
    //   4046: aload 17
    //   4048: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   4051: goto -4041 -> 10
    //   4054: aload 13
    //   4056: astore 28
    //   4058: aload 35
    //   4060: astore 22
    //   4062: aload 41
    //   4064: astore 23
    //   4066: aload 31
    //   4068: astore 27
    //   4070: iload_1
    //   4071: istore 4
    //   4073: aload 36
    //   4075: astore 20
    //   4077: aload 42
    //   4079: astore 19
    //   4081: iload 6
    //   4083: istore_3
    //   4084: aload 32
    //   4086: astore 30
    //   4088: aload 37
    //   4090: astore 26
    //   4092: aload 43
    //   4094: astore 25
    //   4096: aload 33
    //   4098: astore 29
    //   4100: aload 38
    //   4102: astore 21
    //   4104: aload 44
    //   4106: astore 24
    //   4108: aload 34
    //   4110: astore 18
    //   4112: aload 39
    //   4114: astore 14
    //   4116: aload 45
    //   4118: astore 15
    //   4120: aload_0
    //   4121: getfield 43	org/apache/cordova/FileTransfer$1:val$url	Ljava/net/URL;
    //   4124: invokevirtual 91	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   4127: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   4130: astore 40
    //   4132: aload 13
    //   4134: astore 28
    //   4136: aload 35
    //   4138: astore 22
    //   4140: aload 41
    //   4142: astore 23
    //   4144: aload 31
    //   4146: astore 27
    //   4148: iload_1
    //   4149: istore 4
    //   4151: aload 36
    //   4153: astore 20
    //   4155: aload 42
    //   4157: astore 19
    //   4159: iload 6
    //   4161: istore_3
    //   4162: aload 32
    //   4164: astore 30
    //   4166: aload 37
    //   4168: astore 26
    //   4170: aload 43
    //   4172: astore 25
    //   4174: aload 33
    //   4176: astore 29
    //   4178: aload 38
    //   4180: astore 21
    //   4182: aload 44
    //   4184: astore 24
    //   4186: aload 34
    //   4188: astore 18
    //   4190: aload 39
    //   4192: astore 14
    //   4194: aload 45
    //   4196: astore 15
    //   4198: aload 40
    //   4200: invokestatic 293	org/apache/cordova/FileTransfer:access$000	(Ljavax/net/ssl/HttpsURLConnection;)Ljavax/net/ssl/SSLSocketFactory;
    //   4203: astore 17
    //   4205: aload 13
    //   4207: astore 28
    //   4209: aload 35
    //   4211: astore 22
    //   4213: aload 17
    //   4215: astore 23
    //   4217: aload 31
    //   4219: astore 27
    //   4221: iload_1
    //   4222: istore 4
    //   4224: aload 36
    //   4226: astore 20
    //   4228: aload 17
    //   4230: astore 19
    //   4232: iload 6
    //   4234: istore_3
    //   4235: aload 32
    //   4237: astore 30
    //   4239: aload 37
    //   4241: astore 26
    //   4243: aload 17
    //   4245: astore 25
    //   4247: aload 33
    //   4249: astore 29
    //   4251: aload 38
    //   4253: astore 21
    //   4255: aload 17
    //   4257: astore 24
    //   4259: aload 34
    //   4261: astore 18
    //   4263: aload 39
    //   4265: astore 14
    //   4267: aload 17
    //   4269: astore 15
    //   4271: aload 40
    //   4273: invokevirtual 297	javax/net/ssl/HttpsURLConnection:getHostnameVerifier	()Ljavax/net/ssl/HostnameVerifier;
    //   4276: astore 16
    //   4278: aload 13
    //   4280: astore 28
    //   4282: aload 16
    //   4284: astore 22
    //   4286: aload 17
    //   4288: astore 23
    //   4290: aload 31
    //   4292: astore 27
    //   4294: iload_1
    //   4295: istore 4
    //   4297: aload 16
    //   4299: astore 20
    //   4301: aload 17
    //   4303: astore 19
    //   4305: iload 6
    //   4307: istore_3
    //   4308: aload 32
    //   4310: astore 30
    //   4312: aload 16
    //   4314: astore 26
    //   4316: aload 17
    //   4318: astore 25
    //   4320: aload 33
    //   4322: astore 29
    //   4324: aload 16
    //   4326: astore 21
    //   4328: aload 17
    //   4330: astore 24
    //   4332: aload 34
    //   4334: astore 18
    //   4336: aload 16
    //   4338: astore 14
    //   4340: aload 17
    //   4342: astore 15
    //   4344: aload 40
    //   4346: invokestatic 300	org/apache/cordova/FileTransfer:access$100	()Ljavax/net/ssl/HostnameVerifier;
    //   4349: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   4352: aload 40
    //   4354: astore 13
    //   4356: goto -3778 -> 578
    //   4359: aload 13
    //   4361: astore 28
    //   4363: aload 35
    //   4365: astore 22
    //   4367: aload 41
    //   4369: astore 23
    //   4371: aload 31
    //   4373: astore 27
    //   4375: iload_1
    //   4376: istore 4
    //   4378: aload 36
    //   4380: astore 20
    //   4382: aload 42
    //   4384: astore 19
    //   4386: iload 6
    //   4388: istore_3
    //   4389: aload 32
    //   4391: astore 30
    //   4393: aload 37
    //   4395: astore 26
    //   4397: aload 43
    //   4399: astore 25
    //   4401: aload 33
    //   4403: astore 29
    //   4405: aload 38
    //   4407: astore 21
    //   4409: aload 44
    //   4411: astore 24
    //   4413: aload 34
    //   4415: astore 18
    //   4417: aload 39
    //   4419: astore 14
    //   4421: aload 45
    //   4423: astore 15
    //   4425: aload_0
    //   4426: getfield 43	org/apache/cordova/FileTransfer$1:val$url	Ljava/net/URL;
    //   4429: invokevirtual 91	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   4432: checkcast 95	java/net/HttpURLConnection
    //   4435: astore 13
    //   4437: goto -3859 -> 578
    //   4440: iconst_0
    //   4441: istore_1
    //   4442: goto -881 -> 3561
    //   4445: iconst_0
    //   4446: istore_1
    //   4447: goto -875 -> 3572
    //   4450: aload 13
    //   4452: astore 28
    //   4454: aload 16
    //   4456: astore 22
    //   4458: aload 17
    //   4460: astore 23
    //   4462: aload 13
    //   4464: astore 27
    //   4466: iload_2
    //   4467: istore 4
    //   4469: aload 16
    //   4471: astore 20
    //   4473: aload 17
    //   4475: astore 19
    //   4477: iload 6
    //   4479: istore_3
    //   4480: aload 13
    //   4482: astore 30
    //   4484: aload 16
    //   4486: astore 26
    //   4488: aload 17
    //   4490: astore 25
    //   4492: aload 13
    //   4494: astore 29
    //   4496: aload 16
    //   4498: astore 21
    //   4500: aload 17
    //   4502: astore 24
    //   4504: aload 13
    //   4506: astore 18
    //   4508: aload 16
    //   4510: astore 14
    //   4512: aload 17
    //   4514: astore 15
    //   4516: aload 13
    //   4518: iload_2
    //   4519: invokevirtual 303	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   4522: goto -795 -> 3727
    //   4525: astore 16
    //   4527: aload 28
    //   4529: astore 18
    //   4531: aload 22
    //   4533: astore 14
    //   4535: aload 23
    //   4537: astore 15
    //   4539: getstatic 306	org/apache/cordova/FileTransfer:FILE_NOT_FOUND_ERR	I
    //   4542: aload_0
    //   4543: getfield 57	org/apache/cordova/FileTransfer$1:val$source	Ljava/lang/String;
    //   4546: aload_0
    //   4547: getfield 45	org/apache/cordova/FileTransfer$1:val$target	Ljava/lang/String;
    //   4550: aload 28
    //   4552: invokestatic 310	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   4555: astore 13
    //   4557: aload 28
    //   4559: astore 18
    //   4561: aload 22
    //   4563: astore 14
    //   4565: aload 23
    //   4567: astore 15
    //   4569: ldc -66
    //   4571: aload 13
    //   4573: invokevirtual 311	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4576: aload 16
    //   4578: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   4581: pop
    //   4582: aload 28
    //   4584: astore 18
    //   4586: aload 22
    //   4588: astore 14
    //   4590: aload 23
    //   4592: astore 15
    //   4594: aload_0
    //   4595: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4598: astore 17
    //   4600: aload 28
    //   4602: astore 18
    //   4604: aload 22
    //   4606: astore 14
    //   4608: aload 23
    //   4610: astore 15
    //   4612: new 313	org/apache/cordova/api/PluginResult
    //   4615: astore 16
    //   4617: aload 28
    //   4619: astore 18
    //   4621: aload 22
    //   4623: astore 14
    //   4625: aload 23
    //   4627: astore 15
    //   4629: aload 16
    //   4631: getstatic 319	org/apache/cordova/api/PluginResult$Status:IO_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   4634: aload 13
    //   4636: invokespecial 322	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   4639: aload 28
    //   4641: astore 18
    //   4643: aload 22
    //   4645: astore 14
    //   4647: aload 23
    //   4649: astore 15
    //   4651: aload 17
    //   4653: aload 16
    //   4655: invokevirtual 326	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   4658: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4661: astore 13
    //   4663: aload 13
    //   4665: monitorenter
    //   4666: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   4669: aload_0
    //   4670: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   4673: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4676: pop
    //   4677: aload 13
    //   4679: monitorexit
    //   4680: aload 28
    //   4682: ifnull -4672 -> 10
    //   4685: aload_0
    //   4686: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   4689: ifeq -4679 -> 10
    //   4692: aload_0
    //   4693: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   4696: ifeq -4686 -> 10
    //   4699: aload 28
    //   4701: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   4704: astore 13
    //   4706: aload 13
    //   4708: aload 22
    //   4710: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   4713: aload 13
    //   4715: aload 23
    //   4717: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   4720: goto -4710 -> 10
    //   4723: astore 13
    //   4725: aload 14
    //   4727: monitorexit
    //   4728: aload 13
    //   4730: athrow
    //   4731: aload_0
    //   4732: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   4735: aload 32
    //   4737: putfield 330	org/apache/cordova/FileTransfer$RequestContext:currentOutputStream	Ljava/io/OutputStream;
    //   4740: aload 14
    //   4742: monitorexit
    //   4743: aload 32
    //   4745: astore 31
    //   4747: iload 5
    //   4749: istore_1
    //   4750: aload 32
    //   4752: aload 35
    //   4754: invokevirtual 336	java/io/OutputStream:write	([B)V
    //   4757: aload 32
    //   4759: astore 31
    //   4761: iload 5
    //   4763: istore_1
    //   4764: iconst_0
    //   4765: aload 35
    //   4767: arraylength
    //   4768: iadd
    //   4769: istore_3
    //   4770: aload 32
    //   4772: astore 31
    //   4774: iload_3
    //   4775: istore_1
    //   4776: aload 33
    //   4778: invokevirtual 342	java/io/InputStream:available	()I
    //   4781: sipush 16384
    //   4784: invokestatic 348	java/lang/Math:min	(II)I
    //   4787: istore 4
    //   4789: aload 32
    //   4791: astore 31
    //   4793: iload_3
    //   4794: istore_1
    //   4795: iload 4
    //   4797: newarray <illegal type>
    //   4799: astore 14
    //   4801: aload 32
    //   4803: astore 31
    //   4805: iload_3
    //   4806: istore_1
    //   4807: aload 33
    //   4809: aload 14
    //   4811: iconst_0
    //   4812: iload 4
    //   4814: invokevirtual 352	java/io/InputStream:read	([BII)I
    //   4817: istore 4
    //   4819: lconst_0
    //   4820: lstore 11
    //   4822: iload 4
    //   4824: ifle +733 -> 5557
    //   4827: aload 32
    //   4829: astore 31
    //   4831: iload_3
    //   4832: istore_1
    //   4833: aload 46
    //   4835: iload_3
    //   4836: i2l
    //   4837: invokevirtual 355	org/apache/cordova/FileUploadResult:setBytesSent	(J)V
    //   4840: aload 32
    //   4842: astore 31
    //   4844: iload_3
    //   4845: istore_1
    //   4846: aload 32
    //   4848: aload 14
    //   4850: iconst_0
    //   4851: iload 4
    //   4853: invokevirtual 358	java/io/OutputStream:write	([BII)V
    //   4856: iload_3
    //   4857: iload 4
    //   4859: iadd
    //   4860: istore_3
    //   4861: lload 11
    //   4863: lstore 9
    //   4865: iload_3
    //   4866: i2l
    //   4867: ldc2_w 359
    //   4870: lload 11
    //   4872: ladd
    //   4873: lcmp
    //   4874: ifle +72 -> 4946
    //   4877: iload_3
    //   4878: i2l
    //   4879: lstore 9
    //   4881: aload 32
    //   4883: astore 31
    //   4885: iload_3
    //   4886: istore_1
    //   4887: new 137	java/lang/StringBuilder
    //   4890: astore 15
    //   4892: aload 32
    //   4894: astore 31
    //   4896: iload_3
    //   4897: istore_1
    //   4898: aload 15
    //   4900: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   4903: aload 32
    //   4905: astore 31
    //   4907: iload_3
    //   4908: istore_1
    //   4909: ldc -66
    //   4911: aload 15
    //   4913: ldc_w 362
    //   4916: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4919: iload_3
    //   4920: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4923: ldc_w 364
    //   4926: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4929: iload_2
    //   4930: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4933: ldc_w 366
    //   4936: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4939: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4942: invokestatic 246	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   4945: pop
    //   4946: aload 32
    //   4948: astore 31
    //   4950: iload_3
    //   4951: istore_1
    //   4952: aload 33
    //   4954: aload 14
    //   4956: iconst_0
    //   4957: aload 33
    //   4959: invokevirtual 342	java/io/InputStream:available	()I
    //   4962: sipush 16384
    //   4965: invokestatic 348	java/lang/Math:min	(II)I
    //   4968: invokevirtual 352	java/io/InputStream:read	([BII)I
    //   4971: istore 4
    //   4973: aload 32
    //   4975: astore 31
    //   4977: iload_3
    //   4978: istore_1
    //   4979: aload 47
    //   4981: iload_3
    //   4982: i2l
    //   4983: invokevirtual 369	org/apache/cordova/FileProgressResult:setLoaded	(J)V
    //   4986: aload 32
    //   4988: astore 31
    //   4990: iload_3
    //   4991: istore_1
    //   4992: new 313	org/apache/cordova/api/PluginResult
    //   4995: astore 15
    //   4997: aload 32
    //   4999: astore 31
    //   5001: iload_3
    //   5002: istore_1
    //   5003: aload 15
    //   5005: getstatic 372	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   5008: aload 47
    //   5010: invokevirtual 376	org/apache/cordova/FileProgressResult:toJSONObject	()Lorg/json/JSONObject;
    //   5013: invokespecial 322	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   5016: aload 32
    //   5018: astore 31
    //   5020: iload_3
    //   5021: istore_1
    //   5022: aload 15
    //   5024: iconst_1
    //   5025: invokevirtual 379	org/apache/cordova/api/PluginResult:setKeepCallback	(Z)V
    //   5028: aload 32
    //   5030: astore 31
    //   5032: iload_3
    //   5033: istore_1
    //   5034: aload_0
    //   5035: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   5038: aload 15
    //   5040: invokevirtual 326	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   5043: lload 9
    //   5045: lstore 11
    //   5047: goto -225 -> 4822
    //   5050: astore 32
    //   5052: aload 13
    //   5054: astore 28
    //   5056: aload 16
    //   5058: astore 22
    //   5060: aload 17
    //   5062: astore 23
    //   5064: aload 13
    //   5066: astore 27
    //   5068: iload_2
    //   5069: istore 4
    //   5071: aload 16
    //   5073: astore 20
    //   5075: aload 17
    //   5077: astore 19
    //   5079: iload_1
    //   5080: istore_3
    //   5081: aload 13
    //   5083: astore 30
    //   5085: aload 16
    //   5087: astore 26
    //   5089: aload 17
    //   5091: astore 25
    //   5093: aload 13
    //   5095: astore 29
    //   5097: aload 16
    //   5099: astore 21
    //   5101: aload 17
    //   5103: astore 24
    //   5105: aload 13
    //   5107: astore 18
    //   5109: aload 16
    //   5111: astore 14
    //   5113: aload 17
    //   5115: astore 15
    //   5117: aload 33
    //   5119: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   5122: aload 13
    //   5124: astore 28
    //   5126: aload 16
    //   5128: astore 22
    //   5130: aload 17
    //   5132: astore 23
    //   5134: aload 13
    //   5136: astore 27
    //   5138: iload_2
    //   5139: istore 4
    //   5141: aload 16
    //   5143: astore 20
    //   5145: aload 17
    //   5147: astore 19
    //   5149: iload_1
    //   5150: istore_3
    //   5151: aload 13
    //   5153: astore 30
    //   5155: aload 16
    //   5157: astore 26
    //   5159: aload 17
    //   5161: astore 25
    //   5163: aload 13
    //   5165: astore 29
    //   5167: aload 16
    //   5169: astore 21
    //   5171: aload 17
    //   5173: astore 24
    //   5175: aload 13
    //   5177: astore 18
    //   5179: aload 16
    //   5181: astore 14
    //   5183: aload 17
    //   5185: astore 15
    //   5187: aload 31
    //   5189: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   5192: aload 13
    //   5194: astore 28
    //   5196: aload 16
    //   5198: astore 22
    //   5200: aload 17
    //   5202: astore 23
    //   5204: aload 13
    //   5206: astore 27
    //   5208: iload_2
    //   5209: istore 4
    //   5211: aload 16
    //   5213: astore 20
    //   5215: aload 17
    //   5217: astore 19
    //   5219: iload_1
    //   5220: istore_3
    //   5221: aload 13
    //   5223: astore 30
    //   5225: aload 16
    //   5227: astore 26
    //   5229: aload 17
    //   5231: astore 25
    //   5233: aload 13
    //   5235: astore 29
    //   5237: aload 16
    //   5239: astore 21
    //   5241: aload 17
    //   5243: astore 24
    //   5245: aload 13
    //   5247: astore 18
    //   5249: aload 16
    //   5251: astore 14
    //   5253: aload 17
    //   5255: astore 15
    //   5257: aload 32
    //   5259: athrow
    //   5260: astore 16
    //   5262: aload 27
    //   5264: astore 18
    //   5266: aload 20
    //   5268: astore 14
    //   5270: aload 19
    //   5272: astore 15
    //   5274: getstatic 382	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   5277: aload_0
    //   5278: getfield 57	org/apache/cordova/FileTransfer$1:val$source	Ljava/lang/String;
    //   5281: aload_0
    //   5282: getfield 45	org/apache/cordova/FileTransfer$1:val$target	Ljava/lang/String;
    //   5285: aload 27
    //   5287: invokestatic 310	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   5290: astore 13
    //   5292: aload 27
    //   5294: astore 18
    //   5296: aload 20
    //   5298: astore 14
    //   5300: aload 19
    //   5302: astore 15
    //   5304: ldc -66
    //   5306: aload 13
    //   5308: invokevirtual 311	org/json/JSONObject:toString	()Ljava/lang/String;
    //   5311: aload 16
    //   5313: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   5316: pop
    //   5317: aload 27
    //   5319: astore 18
    //   5321: aload 20
    //   5323: astore 14
    //   5325: aload 19
    //   5327: astore 15
    //   5329: new 137	java/lang/StringBuilder
    //   5332: astore 16
    //   5334: aload 27
    //   5336: astore 18
    //   5338: aload 20
    //   5340: astore 14
    //   5342: aload 19
    //   5344: astore 15
    //   5346: aload 16
    //   5348: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   5351: aload 27
    //   5353: astore 18
    //   5355: aload 20
    //   5357: astore 14
    //   5359: aload 19
    //   5361: astore 15
    //   5363: ldc -66
    //   5365: aload 16
    //   5367: ldc_w 384
    //   5370: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5373: iload_3
    //   5374: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5377: ldc_w 364
    //   5380: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5383: iload 4
    //   5385: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5388: ldc_w 386
    //   5391: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5394: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5397: invokestatic 388	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   5400: pop
    //   5401: aload 27
    //   5403: astore 18
    //   5405: aload 20
    //   5407: astore 14
    //   5409: aload 19
    //   5411: astore 15
    //   5413: aload_0
    //   5414: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   5417: astore 16
    //   5419: aload 27
    //   5421: astore 18
    //   5423: aload 20
    //   5425: astore 14
    //   5427: aload 19
    //   5429: astore 15
    //   5431: new 313	org/apache/cordova/api/PluginResult
    //   5434: astore 17
    //   5436: aload 27
    //   5438: astore 18
    //   5440: aload 20
    //   5442: astore 14
    //   5444: aload 19
    //   5446: astore 15
    //   5448: aload 17
    //   5450: getstatic 319	org/apache/cordova/api/PluginResult$Status:IO_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   5453: aload 13
    //   5455: invokespecial 322	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   5458: aload 27
    //   5460: astore 18
    //   5462: aload 20
    //   5464: astore 14
    //   5466: aload 19
    //   5468: astore 15
    //   5470: aload 16
    //   5472: aload 17
    //   5474: invokevirtual 326	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   5477: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   5480: astore 13
    //   5482: aload 13
    //   5484: monitorenter
    //   5485: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   5488: aload_0
    //   5489: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   5492: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5495: pop
    //   5496: aload 13
    //   5498: monitorexit
    //   5499: aload 27
    //   5501: ifnull -5491 -> 10
    //   5504: aload_0
    //   5505: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   5508: ifeq -5498 -> 10
    //   5511: aload_0
    //   5512: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   5515: ifeq -5505 -> 10
    //   5518: aload 27
    //   5520: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   5523: astore 13
    //   5525: aload 13
    //   5527: aload 20
    //   5529: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   5532: aload 13
    //   5534: aload 19
    //   5536: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   5539: goto -5529 -> 10
    //   5542: astore 15
    //   5544: aload 14
    //   5546: monitorexit
    //   5547: aload 32
    //   5549: astore 31
    //   5551: iload 5
    //   5553: istore_1
    //   5554: aload 15
    //   5556: athrow
    //   5557: aload 32
    //   5559: astore 31
    //   5561: iload_3
    //   5562: istore_1
    //   5563: aload 32
    //   5565: aload 34
    //   5567: invokevirtual 336	java/io/OutputStream:write	([B)V
    //   5570: aload 32
    //   5572: astore 31
    //   5574: iload_3
    //   5575: istore_1
    //   5576: iload_3
    //   5577: aload 34
    //   5579: arraylength
    //   5580: iadd
    //   5581: istore 5
    //   5583: aload 32
    //   5585: astore 31
    //   5587: iload 5
    //   5589: istore_1
    //   5590: aload 32
    //   5592: invokevirtual 391	java/io/OutputStream:flush	()V
    //   5595: aload 13
    //   5597: astore 28
    //   5599: aload 16
    //   5601: astore 22
    //   5603: aload 17
    //   5605: astore 23
    //   5607: aload 13
    //   5609: astore 27
    //   5611: iload_2
    //   5612: istore 4
    //   5614: aload 16
    //   5616: astore 20
    //   5618: aload 17
    //   5620: astore 19
    //   5622: iload 5
    //   5624: istore_3
    //   5625: aload 13
    //   5627: astore 30
    //   5629: aload 16
    //   5631: astore 26
    //   5633: aload 17
    //   5635: astore 25
    //   5637: aload 13
    //   5639: astore 29
    //   5641: aload 16
    //   5643: astore 21
    //   5645: aload 17
    //   5647: astore 24
    //   5649: aload 13
    //   5651: astore 18
    //   5653: aload 16
    //   5655: astore 14
    //   5657: aload 17
    //   5659: astore 15
    //   5661: aload 33
    //   5663: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   5666: aload 13
    //   5668: astore 28
    //   5670: aload 16
    //   5672: astore 22
    //   5674: aload 17
    //   5676: astore 23
    //   5678: aload 13
    //   5680: astore 27
    //   5682: iload_2
    //   5683: istore 4
    //   5685: aload 16
    //   5687: astore 20
    //   5689: aload 17
    //   5691: astore 19
    //   5693: iload 5
    //   5695: istore_3
    //   5696: aload 13
    //   5698: astore 30
    //   5700: aload 16
    //   5702: astore 26
    //   5704: aload 17
    //   5706: astore 25
    //   5708: aload 13
    //   5710: astore 29
    //   5712: aload 16
    //   5714: astore 21
    //   5716: aload 17
    //   5718: astore 24
    //   5720: aload 13
    //   5722: astore 18
    //   5724: aload 16
    //   5726: astore 14
    //   5728: aload 17
    //   5730: astore 15
    //   5732: aload 32
    //   5734: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   5737: aload 13
    //   5739: astore 28
    //   5741: aload 16
    //   5743: astore 22
    //   5745: aload 17
    //   5747: astore 23
    //   5749: aload 13
    //   5751: astore 27
    //   5753: iload_2
    //   5754: istore 4
    //   5756: aload 16
    //   5758: astore 20
    //   5760: aload 17
    //   5762: astore 19
    //   5764: iload 5
    //   5766: istore_3
    //   5767: aload 13
    //   5769: astore 30
    //   5771: aload 16
    //   5773: astore 26
    //   5775: aload 17
    //   5777: astore 25
    //   5779: aload 13
    //   5781: astore 29
    //   5783: aload 16
    //   5785: astore 21
    //   5787: aload 17
    //   5789: astore 24
    //   5791: aload 13
    //   5793: astore 18
    //   5795: aload 16
    //   5797: astore 14
    //   5799: aload 17
    //   5801: astore 15
    //   5803: aload_0
    //   5804: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   5807: aconst_null
    //   5808: putfield 330	org/apache/cordova/FileTransfer$RequestContext:currentOutputStream	Ljava/io/OutputStream;
    //   5811: aload 13
    //   5813: astore 28
    //   5815: aload 16
    //   5817: astore 22
    //   5819: aload 17
    //   5821: astore 23
    //   5823: aload 13
    //   5825: astore 27
    //   5827: iload_2
    //   5828: istore 4
    //   5830: aload 16
    //   5832: astore 20
    //   5834: aload 17
    //   5836: astore 19
    //   5838: iload 5
    //   5840: istore_3
    //   5841: aload 13
    //   5843: astore 30
    //   5845: aload 16
    //   5847: astore 26
    //   5849: aload 17
    //   5851: astore 25
    //   5853: aload 13
    //   5855: astore 29
    //   5857: aload 16
    //   5859: astore 21
    //   5861: aload 17
    //   5863: astore 24
    //   5865: aload 13
    //   5867: astore 18
    //   5869: aload 16
    //   5871: astore 14
    //   5873: aload 17
    //   5875: astore 15
    //   5877: new 137	java/lang/StringBuilder
    //   5880: astore 31
    //   5882: aload 13
    //   5884: astore 28
    //   5886: aload 16
    //   5888: astore 22
    //   5890: aload 17
    //   5892: astore 23
    //   5894: aload 13
    //   5896: astore 27
    //   5898: iload_2
    //   5899: istore 4
    //   5901: aload 16
    //   5903: astore 20
    //   5905: aload 17
    //   5907: astore 19
    //   5909: iload 5
    //   5911: istore_3
    //   5912: aload 13
    //   5914: astore 30
    //   5916: aload 16
    //   5918: astore 26
    //   5920: aload 17
    //   5922: astore 25
    //   5924: aload 13
    //   5926: astore 29
    //   5928: aload 16
    //   5930: astore 21
    //   5932: aload 17
    //   5934: astore 24
    //   5936: aload 13
    //   5938: astore 18
    //   5940: aload 16
    //   5942: astore 14
    //   5944: aload 17
    //   5946: astore 15
    //   5948: aload 31
    //   5950: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   5953: aload 13
    //   5955: astore 28
    //   5957: aload 16
    //   5959: astore 22
    //   5961: aload 17
    //   5963: astore 23
    //   5965: aload 13
    //   5967: astore 27
    //   5969: iload_2
    //   5970: istore 4
    //   5972: aload 16
    //   5974: astore 20
    //   5976: aload 17
    //   5978: astore 19
    //   5980: iload 5
    //   5982: istore_3
    //   5983: aload 13
    //   5985: astore 30
    //   5987: aload 16
    //   5989: astore 26
    //   5991: aload 17
    //   5993: astore 25
    //   5995: aload 13
    //   5997: astore 29
    //   5999: aload 16
    //   6001: astore 21
    //   6003: aload 17
    //   6005: astore 24
    //   6007: aload 13
    //   6009: astore 18
    //   6011: aload 16
    //   6013: astore 14
    //   6015: aload 17
    //   6017: astore 15
    //   6019: ldc -66
    //   6021: aload 31
    //   6023: ldc_w 393
    //   6026: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6029: iload 5
    //   6031: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6034: ldc_w 364
    //   6037: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6040: iload_2
    //   6041: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6044: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6047: invokestatic 246	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   6050: pop
    //   6051: aload 13
    //   6053: astore 28
    //   6055: aload 16
    //   6057: astore 22
    //   6059: aload 17
    //   6061: astore 23
    //   6063: aload 13
    //   6065: astore 27
    //   6067: iload_2
    //   6068: istore 4
    //   6070: aload 16
    //   6072: astore 20
    //   6074: aload 17
    //   6076: astore 19
    //   6078: iload 5
    //   6080: istore_3
    //   6081: aload 13
    //   6083: astore 30
    //   6085: aload 16
    //   6087: astore 26
    //   6089: aload 17
    //   6091: astore 25
    //   6093: aload 13
    //   6095: astore 29
    //   6097: aload 16
    //   6099: astore 21
    //   6101: aload 17
    //   6103: astore 24
    //   6105: aload 13
    //   6107: astore 18
    //   6109: aload 16
    //   6111: astore 14
    //   6113: aload 17
    //   6115: astore 15
    //   6117: aload 13
    //   6119: invokevirtual 396	java/net/HttpURLConnection:getResponseCode	()I
    //   6122: istore_1
    //   6123: aload 13
    //   6125: astore 28
    //   6127: aload 16
    //   6129: astore 22
    //   6131: aload 17
    //   6133: astore 23
    //   6135: aload 13
    //   6137: astore 27
    //   6139: iload_2
    //   6140: istore 4
    //   6142: aload 16
    //   6144: astore 20
    //   6146: aload 17
    //   6148: astore 19
    //   6150: iload 5
    //   6152: istore_3
    //   6153: aload 13
    //   6155: astore 30
    //   6157: aload 16
    //   6159: astore 26
    //   6161: aload 17
    //   6163: astore 25
    //   6165: aload 13
    //   6167: astore 29
    //   6169: aload 16
    //   6171: astore 21
    //   6173: aload 17
    //   6175: astore 24
    //   6177: aload 13
    //   6179: astore 18
    //   6181: aload 16
    //   6183: astore 14
    //   6185: aload 17
    //   6187: astore 15
    //   6189: new 137	java/lang/StringBuilder
    //   6192: astore 31
    //   6194: aload 13
    //   6196: astore 28
    //   6198: aload 16
    //   6200: astore 22
    //   6202: aload 17
    //   6204: astore 23
    //   6206: aload 13
    //   6208: astore 27
    //   6210: iload_2
    //   6211: istore 4
    //   6213: aload 16
    //   6215: astore 20
    //   6217: aload 17
    //   6219: astore 19
    //   6221: iload 5
    //   6223: istore_3
    //   6224: aload 13
    //   6226: astore 30
    //   6228: aload 16
    //   6230: astore 26
    //   6232: aload 17
    //   6234: astore 25
    //   6236: aload 13
    //   6238: astore 29
    //   6240: aload 16
    //   6242: astore 21
    //   6244: aload 17
    //   6246: astore 24
    //   6248: aload 13
    //   6250: astore 18
    //   6252: aload 16
    //   6254: astore 14
    //   6256: aload 17
    //   6258: astore 15
    //   6260: aload 31
    //   6262: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   6265: aload 13
    //   6267: astore 28
    //   6269: aload 16
    //   6271: astore 22
    //   6273: aload 17
    //   6275: astore 23
    //   6277: aload 13
    //   6279: astore 27
    //   6281: iload_2
    //   6282: istore 4
    //   6284: aload 16
    //   6286: astore 20
    //   6288: aload 17
    //   6290: astore 19
    //   6292: iload 5
    //   6294: istore_3
    //   6295: aload 13
    //   6297: astore 30
    //   6299: aload 16
    //   6301: astore 26
    //   6303: aload 17
    //   6305: astore 25
    //   6307: aload 13
    //   6309: astore 29
    //   6311: aload 16
    //   6313: astore 21
    //   6315: aload 17
    //   6317: astore 24
    //   6319: aload 13
    //   6321: astore 18
    //   6323: aload 16
    //   6325: astore 14
    //   6327: aload 17
    //   6329: astore 15
    //   6331: ldc -66
    //   6333: aload 31
    //   6335: ldc_w 398
    //   6338: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6341: iload_1
    //   6342: invokevirtual 242	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6345: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6348: invokestatic 246	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   6351: pop
    //   6352: aload 13
    //   6354: astore 28
    //   6356: aload 16
    //   6358: astore 22
    //   6360: aload 17
    //   6362: astore 23
    //   6364: aload 13
    //   6366: astore 27
    //   6368: iload_2
    //   6369: istore 4
    //   6371: aload 16
    //   6373: astore 20
    //   6375: aload 17
    //   6377: astore 19
    //   6379: iload 5
    //   6381: istore_3
    //   6382: aload 13
    //   6384: astore 30
    //   6386: aload 16
    //   6388: astore 26
    //   6390: aload 17
    //   6392: astore 25
    //   6394: aload 13
    //   6396: astore 29
    //   6398: aload 16
    //   6400: astore 21
    //   6402: aload 17
    //   6404: astore 24
    //   6406: aload 13
    //   6408: astore 18
    //   6410: aload 16
    //   6412: astore 14
    //   6414: aload 17
    //   6416: astore 15
    //   6418: new 137	java/lang/StringBuilder
    //   6421: astore 31
    //   6423: aload 13
    //   6425: astore 28
    //   6427: aload 16
    //   6429: astore 22
    //   6431: aload 17
    //   6433: astore 23
    //   6435: aload 13
    //   6437: astore 27
    //   6439: iload_2
    //   6440: istore 4
    //   6442: aload 16
    //   6444: astore 20
    //   6446: aload 17
    //   6448: astore 19
    //   6450: iload 5
    //   6452: istore_3
    //   6453: aload 13
    //   6455: astore 30
    //   6457: aload 16
    //   6459: astore 26
    //   6461: aload 17
    //   6463: astore 25
    //   6465: aload 13
    //   6467: astore 29
    //   6469: aload 16
    //   6471: astore 21
    //   6473: aload 17
    //   6475: astore 24
    //   6477: aload 13
    //   6479: astore 18
    //   6481: aload 16
    //   6483: astore 14
    //   6485: aload 17
    //   6487: astore 15
    //   6489: aload 31
    //   6491: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   6494: aload 13
    //   6496: astore 28
    //   6498: aload 16
    //   6500: astore 22
    //   6502: aload 17
    //   6504: astore 23
    //   6506: aload 13
    //   6508: astore 27
    //   6510: iload_2
    //   6511: istore 4
    //   6513: aload 16
    //   6515: astore 20
    //   6517: aload 17
    //   6519: astore 19
    //   6521: iload 5
    //   6523: istore_3
    //   6524: aload 13
    //   6526: astore 30
    //   6528: aload 16
    //   6530: astore 26
    //   6532: aload 17
    //   6534: astore 25
    //   6536: aload 13
    //   6538: astore 29
    //   6540: aload 16
    //   6542: astore 21
    //   6544: aload 17
    //   6546: astore 24
    //   6548: aload 13
    //   6550: astore 18
    //   6552: aload 16
    //   6554: astore 14
    //   6556: aload 17
    //   6558: astore 15
    //   6560: ldc -66
    //   6562: aload 31
    //   6564: ldc_w 400
    //   6567: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6570: aload 13
    //   6572: invokevirtual 404	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   6575: invokevirtual 407	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   6578: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6581: invokestatic 246	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   6584: pop
    //   6585: aconst_null
    //   6586: astore 31
    //   6588: aload 13
    //   6590: invokestatic 411	org/apache/cordova/FileTransfer:access$500	(Ljava/net/URLConnection;)Ljava/io/InputStream;
    //   6593: astore 32
    //   6595: aload 32
    //   6597: astore 31
    //   6599: aload_0
    //   6600: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   6603: astore 14
    //   6605: aload 32
    //   6607: astore 31
    //   6609: aload 14
    //   6611: monitorenter
    //   6612: aload_0
    //   6613: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   6616: getfield 79	org/apache/cordova/FileTransfer$RequestContext:aborted	Z
    //   6619: ifeq +224 -> 6843
    //   6622: aload 14
    //   6624: monitorexit
    //   6625: aload 13
    //   6627: astore 28
    //   6629: aload 16
    //   6631: astore 22
    //   6633: aload 17
    //   6635: astore 23
    //   6637: aload 13
    //   6639: astore 27
    //   6641: iload_2
    //   6642: istore 4
    //   6644: aload 16
    //   6646: astore 20
    //   6648: aload 17
    //   6650: astore 19
    //   6652: iload 5
    //   6654: istore_3
    //   6655: aload 13
    //   6657: astore 30
    //   6659: aload 16
    //   6661: astore 26
    //   6663: aload 17
    //   6665: astore 25
    //   6667: aload 13
    //   6669: astore 29
    //   6671: aload 16
    //   6673: astore 21
    //   6675: aload 17
    //   6677: astore 24
    //   6679: aload 13
    //   6681: astore 18
    //   6683: aload 16
    //   6685: astore 14
    //   6687: aload 17
    //   6689: astore 15
    //   6691: aload_0
    //   6692: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   6695: aconst_null
    //   6696: putfield 415	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   6699: aload 13
    //   6701: astore 28
    //   6703: aload 16
    //   6705: astore 22
    //   6707: aload 17
    //   6709: astore 23
    //   6711: aload 13
    //   6713: astore 27
    //   6715: iload_2
    //   6716: istore 4
    //   6718: aload 16
    //   6720: astore 20
    //   6722: aload 17
    //   6724: astore 19
    //   6726: iload 5
    //   6728: istore_3
    //   6729: aload 13
    //   6731: astore 30
    //   6733: aload 16
    //   6735: astore 26
    //   6737: aload 17
    //   6739: astore 25
    //   6741: aload 13
    //   6743: astore 29
    //   6745: aload 16
    //   6747: astore 21
    //   6749: aload 17
    //   6751: astore 24
    //   6753: aload 13
    //   6755: astore 18
    //   6757: aload 16
    //   6759: astore 14
    //   6761: aload 17
    //   6763: astore 15
    //   6765: aload 32
    //   6767: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   6770: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   6773: astore 14
    //   6775: aload 14
    //   6777: monitorenter
    //   6778: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   6781: aload_0
    //   6782: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   6785: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6788: pop
    //   6789: aload 14
    //   6791: monitorexit
    //   6792: aload 13
    //   6794: ifnull -6784 -> 10
    //   6797: aload_0
    //   6798: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   6801: ifeq -6791 -> 10
    //   6804: aload_0
    //   6805: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   6808: ifeq -6798 -> 10
    //   6811: aload 13
    //   6813: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   6816: astore 13
    //   6818: aload 13
    //   6820: aload 16
    //   6822: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   6825: aload 13
    //   6827: aload 17
    //   6829: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   6832: goto -6822 -> 10
    //   6835: astore 13
    //   6837: aload 14
    //   6839: monitorexit
    //   6840: aload 13
    //   6842: athrow
    //   6843: aload_0
    //   6844: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   6847: aload 32
    //   6849: putfield 415	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   6852: aload 14
    //   6854: monitorexit
    //   6855: aload 32
    //   6857: astore 31
    //   6859: new 417	java/io/ByteArrayOutputStream
    //   6862: astore 14
    //   6864: aload 32
    //   6866: astore 31
    //   6868: aload 14
    //   6870: sipush 1024
    //   6873: aload 13
    //   6875: invokevirtual 420	java/net/HttpURLConnection:getContentLength	()I
    //   6878: invokestatic 423	java/lang/Math:max	(II)I
    //   6881: invokespecial 425	java/io/ByteArrayOutputStream:<init>	(I)V
    //   6884: aload 32
    //   6886: astore 31
    //   6888: sipush 1024
    //   6891: newarray <illegal type>
    //   6893: astore 15
    //   6895: aload 32
    //   6897: astore 31
    //   6899: aload 32
    //   6901: aload 15
    //   6903: invokevirtual 428	java/io/InputStream:read	([B)I
    //   6906: istore_3
    //   6907: iload_3
    //   6908: ifle +413 -> 7321
    //   6911: aload 32
    //   6913: astore 31
    //   6915: aload 14
    //   6917: aload 15
    //   6919: iconst_0
    //   6920: iload_3
    //   6921: invokevirtual 429	java/io/ByteArrayOutputStream:write	([BII)V
    //   6924: goto -29 -> 6895
    //   6927: astore 32
    //   6929: aload 13
    //   6931: astore 28
    //   6933: aload 16
    //   6935: astore 22
    //   6937: aload 17
    //   6939: astore 23
    //   6941: aload 13
    //   6943: astore 27
    //   6945: iload_2
    //   6946: istore 4
    //   6948: aload 16
    //   6950: astore 20
    //   6952: aload 17
    //   6954: astore 19
    //   6956: iload 5
    //   6958: istore_3
    //   6959: aload 13
    //   6961: astore 30
    //   6963: aload 16
    //   6965: astore 26
    //   6967: aload 17
    //   6969: astore 25
    //   6971: aload 13
    //   6973: astore 29
    //   6975: aload 16
    //   6977: astore 21
    //   6979: aload 17
    //   6981: astore 24
    //   6983: aload 13
    //   6985: astore 18
    //   6987: aload 16
    //   6989: astore 14
    //   6991: aload 17
    //   6993: astore 15
    //   6995: aload_0
    //   6996: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   6999: aconst_null
    //   7000: putfield 415	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   7003: aload 13
    //   7005: astore 28
    //   7007: aload 16
    //   7009: astore 22
    //   7011: aload 17
    //   7013: astore 23
    //   7015: aload 13
    //   7017: astore 27
    //   7019: iload_2
    //   7020: istore 4
    //   7022: aload 16
    //   7024: astore 20
    //   7026: aload 17
    //   7028: astore 19
    //   7030: iload 5
    //   7032: istore_3
    //   7033: aload 13
    //   7035: astore 30
    //   7037: aload 16
    //   7039: astore 26
    //   7041: aload 17
    //   7043: astore 25
    //   7045: aload 13
    //   7047: astore 29
    //   7049: aload 16
    //   7051: astore 21
    //   7053: aload 17
    //   7055: astore 24
    //   7057: aload 13
    //   7059: astore 18
    //   7061: aload 16
    //   7063: astore 14
    //   7065: aload 17
    //   7067: astore 15
    //   7069: aload 31
    //   7071: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   7074: aload 13
    //   7076: astore 28
    //   7078: aload 16
    //   7080: astore 22
    //   7082: aload 17
    //   7084: astore 23
    //   7086: aload 13
    //   7088: astore 27
    //   7090: iload_2
    //   7091: istore 4
    //   7093: aload 16
    //   7095: astore 20
    //   7097: aload 17
    //   7099: astore 19
    //   7101: iload 5
    //   7103: istore_3
    //   7104: aload 13
    //   7106: astore 30
    //   7108: aload 16
    //   7110: astore 26
    //   7112: aload 17
    //   7114: astore 25
    //   7116: aload 13
    //   7118: astore 29
    //   7120: aload 16
    //   7122: astore 21
    //   7124: aload 17
    //   7126: astore 24
    //   7128: aload 13
    //   7130: astore 18
    //   7132: aload 16
    //   7134: astore 14
    //   7136: aload 17
    //   7138: astore 15
    //   7140: aload 32
    //   7142: athrow
    //   7143: astore 13
    //   7145: aload 30
    //   7147: astore 18
    //   7149: aload 26
    //   7151: astore 14
    //   7153: aload 25
    //   7155: astore 15
    //   7157: ldc -66
    //   7159: aload 13
    //   7161: invokevirtual 193	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   7164: aload 13
    //   7166: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   7169: pop
    //   7170: aload 30
    //   7172: astore 18
    //   7174: aload 26
    //   7176: astore 14
    //   7178: aload 25
    //   7180: astore 15
    //   7182: aload_0
    //   7183: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   7186: astore 13
    //   7188: aload 30
    //   7190: astore 18
    //   7192: aload 26
    //   7194: astore 14
    //   7196: aload 25
    //   7198: astore 15
    //   7200: new 313	org/apache/cordova/api/PluginResult
    //   7203: astore 16
    //   7205: aload 30
    //   7207: astore 18
    //   7209: aload 26
    //   7211: astore 14
    //   7213: aload 25
    //   7215: astore 15
    //   7217: aload 16
    //   7219: getstatic 432	org/apache/cordova/api/PluginResult$Status:JSON_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   7222: invokespecial 435	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;)V
    //   7225: aload 30
    //   7227: astore 18
    //   7229: aload 26
    //   7231: astore 14
    //   7233: aload 25
    //   7235: astore 15
    //   7237: aload 13
    //   7239: aload 16
    //   7241: invokevirtual 326	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   7244: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   7247: astore 13
    //   7249: aload 13
    //   7251: monitorenter
    //   7252: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   7255: aload_0
    //   7256: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   7259: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   7262: pop
    //   7263: aload 13
    //   7265: monitorexit
    //   7266: aload 30
    //   7268: ifnull -7258 -> 10
    //   7271: aload_0
    //   7272: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   7275: ifeq -7265 -> 10
    //   7278: aload_0
    //   7279: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   7282: ifeq -7272 -> 10
    //   7285: aload 30
    //   7287: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   7290: astore 13
    //   7292: aload 13
    //   7294: aload 26
    //   7296: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   7299: aload 13
    //   7301: aload 25
    //   7303: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   7306: goto -7296 -> 10
    //   7309: astore 15
    //   7311: aload 14
    //   7313: monitorexit
    //   7314: aload 32
    //   7316: astore 31
    //   7318: aload 15
    //   7320: athrow
    //   7321: aload 32
    //   7323: astore 31
    //   7325: aload 14
    //   7327: ldc -48
    //   7329: invokevirtual 437	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   7332: astore 33
    //   7334: aload 13
    //   7336: astore 28
    //   7338: aload 16
    //   7340: astore 22
    //   7342: aload 17
    //   7344: astore 23
    //   7346: aload 13
    //   7348: astore 27
    //   7350: iload_2
    //   7351: istore 4
    //   7353: aload 16
    //   7355: astore 20
    //   7357: aload 17
    //   7359: astore 19
    //   7361: iload 5
    //   7363: istore_3
    //   7364: aload 13
    //   7366: astore 30
    //   7368: aload 16
    //   7370: astore 26
    //   7372: aload 17
    //   7374: astore 25
    //   7376: aload 13
    //   7378: astore 29
    //   7380: aload 16
    //   7382: astore 21
    //   7384: aload 17
    //   7386: astore 24
    //   7388: aload 13
    //   7390: astore 18
    //   7392: aload 16
    //   7394: astore 14
    //   7396: aload 17
    //   7398: astore 15
    //   7400: aload_0
    //   7401: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   7404: aconst_null
    //   7405: putfield 415	org/apache/cordova/FileTransfer$RequestContext:currentInputStream	Ljava/io/InputStream;
    //   7408: aload 13
    //   7410: astore 28
    //   7412: aload 16
    //   7414: astore 22
    //   7416: aload 17
    //   7418: astore 23
    //   7420: aload 13
    //   7422: astore 27
    //   7424: iload_2
    //   7425: istore 4
    //   7427: aload 16
    //   7429: astore 20
    //   7431: aload 17
    //   7433: astore 19
    //   7435: iload 5
    //   7437: istore_3
    //   7438: aload 13
    //   7440: astore 30
    //   7442: aload 16
    //   7444: astore 26
    //   7446: aload 17
    //   7448: astore 25
    //   7450: aload 13
    //   7452: astore 29
    //   7454: aload 16
    //   7456: astore 21
    //   7458: aload 17
    //   7460: astore 24
    //   7462: aload 13
    //   7464: astore 18
    //   7466: aload 16
    //   7468: astore 14
    //   7470: aload 17
    //   7472: astore 15
    //   7474: aload 32
    //   7476: invokestatic 271	org/apache/cordova/FileTransfer:access$400	(Ljava/io/Closeable;)V
    //   7479: aload 13
    //   7481: astore 28
    //   7483: aload 16
    //   7485: astore 22
    //   7487: aload 17
    //   7489: astore 23
    //   7491: aload 13
    //   7493: astore 27
    //   7495: iload_2
    //   7496: istore 4
    //   7498: aload 16
    //   7500: astore 20
    //   7502: aload 17
    //   7504: astore 19
    //   7506: iload 5
    //   7508: istore_3
    //   7509: aload 13
    //   7511: astore 30
    //   7513: aload 16
    //   7515: astore 26
    //   7517: aload 17
    //   7519: astore 25
    //   7521: aload 13
    //   7523: astore 29
    //   7525: aload 16
    //   7527: astore 21
    //   7529: aload 17
    //   7531: astore 24
    //   7533: aload 13
    //   7535: astore 18
    //   7537: aload 16
    //   7539: astore 14
    //   7541: aload 17
    //   7543: astore 15
    //   7545: ldc -66
    //   7547: ldc_w 439
    //   7550: invokestatic 246	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   7553: pop
    //   7554: aload 13
    //   7556: astore 28
    //   7558: aload 16
    //   7560: astore 22
    //   7562: aload 17
    //   7564: astore 23
    //   7566: aload 13
    //   7568: astore 27
    //   7570: iload_2
    //   7571: istore 4
    //   7573: aload 16
    //   7575: astore 20
    //   7577: aload 17
    //   7579: astore 19
    //   7581: iload 5
    //   7583: istore_3
    //   7584: aload 13
    //   7586: astore 30
    //   7588: aload 16
    //   7590: astore 26
    //   7592: aload 17
    //   7594: astore 25
    //   7596: aload 13
    //   7598: astore 29
    //   7600: aload 16
    //   7602: astore 21
    //   7604: aload 17
    //   7606: astore 24
    //   7608: aload 13
    //   7610: astore 18
    //   7612: aload 16
    //   7614: astore 14
    //   7616: aload 17
    //   7618: astore 15
    //   7620: ldc -66
    //   7622: aload 33
    //   7624: iconst_0
    //   7625: sipush 256
    //   7628: aload 33
    //   7630: invokevirtual 442	java/lang/String:length	()I
    //   7633: invokestatic 348	java/lang/Math:min	(II)I
    //   7636: invokevirtual 446	java/lang/String:substring	(II)Ljava/lang/String;
    //   7639: invokestatic 246	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   7642: pop
    //   7643: aload 13
    //   7645: astore 28
    //   7647: aload 16
    //   7649: astore 22
    //   7651: aload 17
    //   7653: astore 23
    //   7655: aload 13
    //   7657: astore 27
    //   7659: iload_2
    //   7660: istore 4
    //   7662: aload 16
    //   7664: astore 20
    //   7666: aload 17
    //   7668: astore 19
    //   7670: iload 5
    //   7672: istore_3
    //   7673: aload 13
    //   7675: astore 30
    //   7677: aload 16
    //   7679: astore 26
    //   7681: aload 17
    //   7683: astore 25
    //   7685: aload 13
    //   7687: astore 29
    //   7689: aload 16
    //   7691: astore 21
    //   7693: aload 17
    //   7695: astore 24
    //   7697: aload 13
    //   7699: astore 18
    //   7701: aload 16
    //   7703: astore 14
    //   7705: aload 17
    //   7707: astore 15
    //   7709: aload 46
    //   7711: iload_1
    //   7712: invokevirtual 449	org/apache/cordova/FileUploadResult:setResponseCode	(I)V
    //   7715: aload 13
    //   7717: astore 28
    //   7719: aload 16
    //   7721: astore 22
    //   7723: aload 17
    //   7725: astore 23
    //   7727: aload 13
    //   7729: astore 27
    //   7731: iload_2
    //   7732: istore 4
    //   7734: aload 16
    //   7736: astore 20
    //   7738: aload 17
    //   7740: astore 19
    //   7742: iload 5
    //   7744: istore_3
    //   7745: aload 13
    //   7747: astore 30
    //   7749: aload 16
    //   7751: astore 26
    //   7753: aload 17
    //   7755: astore 25
    //   7757: aload 13
    //   7759: astore 29
    //   7761: aload 16
    //   7763: astore 21
    //   7765: aload 17
    //   7767: astore 24
    //   7769: aload 13
    //   7771: astore 18
    //   7773: aload 16
    //   7775: astore 14
    //   7777: aload 17
    //   7779: astore 15
    //   7781: aload 46
    //   7783: aload 33
    //   7785: invokevirtual 452	org/apache/cordova/FileUploadResult:setResponse	(Ljava/lang/String;)V
    //   7788: aload 13
    //   7790: astore 28
    //   7792: aload 16
    //   7794: astore 22
    //   7796: aload 17
    //   7798: astore 23
    //   7800: aload 13
    //   7802: astore 27
    //   7804: iload_2
    //   7805: istore 4
    //   7807: aload 16
    //   7809: astore 20
    //   7811: aload 17
    //   7813: astore 19
    //   7815: iload 5
    //   7817: istore_3
    //   7818: aload 13
    //   7820: astore 30
    //   7822: aload 16
    //   7824: astore 26
    //   7826: aload 17
    //   7828: astore 25
    //   7830: aload 13
    //   7832: astore 29
    //   7834: aload 16
    //   7836: astore 21
    //   7838: aload 17
    //   7840: astore 24
    //   7842: aload 13
    //   7844: astore 18
    //   7846: aload 16
    //   7848: astore 14
    //   7850: aload 17
    //   7852: astore 15
    //   7854: aload_0
    //   7855: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   7858: astore 31
    //   7860: aload 13
    //   7862: astore 28
    //   7864: aload 16
    //   7866: astore 22
    //   7868: aload 17
    //   7870: astore 23
    //   7872: aload 13
    //   7874: astore 27
    //   7876: iload_2
    //   7877: istore 4
    //   7879: aload 16
    //   7881: astore 20
    //   7883: aload 17
    //   7885: astore 19
    //   7887: iload 5
    //   7889: istore_3
    //   7890: aload 13
    //   7892: astore 30
    //   7894: aload 16
    //   7896: astore 26
    //   7898: aload 17
    //   7900: astore 25
    //   7902: aload 13
    //   7904: astore 29
    //   7906: aload 16
    //   7908: astore 21
    //   7910: aload 17
    //   7912: astore 24
    //   7914: aload 13
    //   7916: astore 18
    //   7918: aload 16
    //   7920: astore 14
    //   7922: aload 17
    //   7924: astore 15
    //   7926: new 313	org/apache/cordova/api/PluginResult
    //   7929: astore 32
    //   7931: aload 13
    //   7933: astore 28
    //   7935: aload 16
    //   7937: astore 22
    //   7939: aload 17
    //   7941: astore 23
    //   7943: aload 13
    //   7945: astore 27
    //   7947: iload_2
    //   7948: istore 4
    //   7950: aload 16
    //   7952: astore 20
    //   7954: aload 17
    //   7956: astore 19
    //   7958: iload 5
    //   7960: istore_3
    //   7961: aload 13
    //   7963: astore 30
    //   7965: aload 16
    //   7967: astore 26
    //   7969: aload 17
    //   7971: astore 25
    //   7973: aload 13
    //   7975: astore 29
    //   7977: aload 16
    //   7979: astore 21
    //   7981: aload 17
    //   7983: astore 24
    //   7985: aload 13
    //   7987: astore 18
    //   7989: aload 16
    //   7991: astore 14
    //   7993: aload 17
    //   7995: astore 15
    //   7997: aload 32
    //   7999: getstatic 372	org/apache/cordova/api/PluginResult$Status:OK	Lorg/apache/cordova/api/PluginResult$Status;
    //   8002: aload 46
    //   8004: invokevirtual 453	org/apache/cordova/FileUploadResult:toJSONObject	()Lorg/json/JSONObject;
    //   8007: invokespecial 322	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   8010: aload 13
    //   8012: astore 28
    //   8014: aload 16
    //   8016: astore 22
    //   8018: aload 17
    //   8020: astore 23
    //   8022: aload 13
    //   8024: astore 27
    //   8026: iload_2
    //   8027: istore 4
    //   8029: aload 16
    //   8031: astore 20
    //   8033: aload 17
    //   8035: astore 19
    //   8037: iload 5
    //   8039: istore_3
    //   8040: aload 13
    //   8042: astore 30
    //   8044: aload 16
    //   8046: astore 26
    //   8048: aload 17
    //   8050: astore 25
    //   8052: aload 13
    //   8054: astore 29
    //   8056: aload 16
    //   8058: astore 21
    //   8060: aload 17
    //   8062: astore 24
    //   8064: aload 13
    //   8066: astore 18
    //   8068: aload 16
    //   8070: astore 14
    //   8072: aload 17
    //   8074: astore 15
    //   8076: aload 31
    //   8078: aload 32
    //   8080: invokevirtual 326	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   8083: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   8086: astore 14
    //   8088: aload 14
    //   8090: monitorenter
    //   8091: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   8094: aload_0
    //   8095: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   8098: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8101: pop
    //   8102: aload 14
    //   8104: monitorexit
    //   8105: aload 13
    //   8107: ifnull -8097 -> 10
    //   8110: aload_0
    //   8111: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   8114: ifeq -8104 -> 10
    //   8117: aload_0
    //   8118: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   8121: ifeq -8111 -> 10
    //   8124: aload 13
    //   8126: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   8129: astore 13
    //   8131: aload 13
    //   8133: aload 16
    //   8135: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   8138: aload 13
    //   8140: aload 17
    //   8142: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   8145: goto -8135 -> 10
    //   8148: astore 13
    //   8150: aload 14
    //   8152: monitorexit
    //   8153: aload 13
    //   8155: athrow
    //   8156: astore 14
    //   8158: aload 13
    //   8160: monitorexit
    //   8161: aload 14
    //   8163: athrow
    //   8164: astore 14
    //   8166: aload 13
    //   8168: monitorexit
    //   8169: aload 14
    //   8171: athrow
    //   8172: astore 14
    //   8174: aload 13
    //   8176: monitorexit
    //   8177: aload 14
    //   8179: athrow
    //   8180: astore 16
    //   8182: aload 29
    //   8184: astore 18
    //   8186: aload 21
    //   8188: astore 14
    //   8190: aload 24
    //   8192: astore 15
    //   8194: getstatic 382	org/apache/cordova/FileTransfer:CONNECTION_ERR	I
    //   8197: aload_0
    //   8198: getfield 57	org/apache/cordova/FileTransfer$1:val$source	Ljava/lang/String;
    //   8201: aload_0
    //   8202: getfield 45	org/apache/cordova/FileTransfer$1:val$target	Ljava/lang/String;
    //   8205: aload 29
    //   8207: invokestatic 310	org/apache/cordova/FileTransfer:access$600	(ILjava/lang/String;Ljava/lang/String;Ljava/net/URLConnection;)Lorg/json/JSONObject;
    //   8210: astore 13
    //   8212: aload 29
    //   8214: astore 18
    //   8216: aload 21
    //   8218: astore 14
    //   8220: aload 24
    //   8222: astore 15
    //   8224: ldc -66
    //   8226: aload 13
    //   8228: invokevirtual 311	org/json/JSONObject:toString	()Ljava/lang/String;
    //   8231: aload 16
    //   8233: invokestatic 199	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   8236: pop
    //   8237: aload 29
    //   8239: astore 18
    //   8241: aload 21
    //   8243: astore 14
    //   8245: aload 24
    //   8247: astore 15
    //   8249: aload_0
    //   8250: getfield 37	org/apache/cordova/FileTransfer$1:val$context	Lorg/apache/cordova/FileTransfer$RequestContext;
    //   8253: astore 17
    //   8255: aload 29
    //   8257: astore 18
    //   8259: aload 21
    //   8261: astore 14
    //   8263: aload 24
    //   8265: astore 15
    //   8267: new 313	org/apache/cordova/api/PluginResult
    //   8270: astore 16
    //   8272: aload 29
    //   8274: astore 18
    //   8276: aload 21
    //   8278: astore 14
    //   8280: aload 24
    //   8282: astore 15
    //   8284: aload 16
    //   8286: getstatic 319	org/apache/cordova/api/PluginResult$Status:IO_EXCEPTION	Lorg/apache/cordova/api/PluginResult$Status;
    //   8289: aload 13
    //   8291: invokespecial 322	org/apache/cordova/api/PluginResult:<init>	(Lorg/apache/cordova/api/PluginResult$Status;Lorg/json/JSONObject;)V
    //   8294: aload 29
    //   8296: astore 18
    //   8298: aload 21
    //   8300: astore 14
    //   8302: aload 24
    //   8304: astore 15
    //   8306: aload 17
    //   8308: aload 16
    //   8310: invokevirtual 326	org/apache/cordova/FileTransfer$RequestContext:sendPluginResult	(Lorg/apache/cordova/api/PluginResult;)V
    //   8313: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   8316: astore 13
    //   8318: aload 13
    //   8320: monitorenter
    //   8321: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   8324: aload_0
    //   8325: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   8328: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8331: pop
    //   8332: aload 13
    //   8334: monitorexit
    //   8335: aload 29
    //   8337: ifnull -8327 -> 10
    //   8340: aload_0
    //   8341: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   8344: ifeq -8334 -> 10
    //   8347: aload_0
    //   8348: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   8351: ifeq -8341 -> 10
    //   8354: aload 29
    //   8356: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   8359: astore 13
    //   8361: aload 13
    //   8363: aload 21
    //   8365: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   8368: aload 13
    //   8370: aload 24
    //   8372: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   8375: goto -8365 -> 10
    //   8378: astore 14
    //   8380: aload 13
    //   8382: monitorexit
    //   8383: aload 14
    //   8385: athrow
    //   8386: astore 16
    //   8388: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   8391: astore 13
    //   8393: aload 13
    //   8395: monitorenter
    //   8396: invokestatic 275	org/apache/cordova/FileTransfer:access$700	()Ljava/util/HashMap;
    //   8399: aload_0
    //   8400: getfield 61	org/apache/cordova/FileTransfer$1:val$objectId	Ljava/lang/String;
    //   8403: invokevirtual 281	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8406: pop
    //   8407: aload 13
    //   8409: monitorexit
    //   8410: aload 18
    //   8412: ifnull +38 -> 8450
    //   8415: aload_0
    //   8416: getfield 41	org/apache/cordova/FileTransfer$1:val$trustEveryone	Z
    //   8419: ifeq +31 -> 8450
    //   8422: aload_0
    //   8423: getfield 39	org/apache/cordova/FileTransfer$1:val$useHttps	Z
    //   8426: ifeq +24 -> 8450
    //   8429: aload 18
    //   8431: checkcast 93	javax/net/ssl/HttpsURLConnection
    //   8434: astore 13
    //   8436: aload 13
    //   8438: aload 14
    //   8440: invokevirtual 285	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   8443: aload 13
    //   8445: aload 15
    //   8447: invokevirtual 289	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   8450: aload 16
    //   8452: athrow
    //   8453: astore 14
    //   8455: aload 13
    //   8457: monitorexit
    //   8458: aload 14
    //   8460: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8461	0	this	1
    //   69	7643	1	i	int
    //   2806	5221	2	j	int
    //   99	7941	3	k	int
    //   87	7941	4	m	int
    //   66	7972	5	n	int
    //   63	4415	6	i1	int
    //   2803	161	7	i2	int
    //   2732	232	8	i3	int
    //   4863	181	9	l1	long
    //   4820	226	11	l2	long
    //   24	4690	13	localObject1	Object
    //   4723	523	13	localObject2	Object
    //   5290	1536	13	localObject3	Object
    //   6835	294	13	localObject4	Object
    //   7143	22	13	localJSONException1	org.json.JSONException
    //   8148	27	13	localObject6	Object
    //   8156	6	14	localObject9	Object
    //   8164	6	14	localObject10	Object
    //   8172	6	14	localObject11	Object
    //   8188	113	14	localObject12	Object
    //   8378	61	14	localHostnameVerifier1	javax.net.ssl.HostnameVerifier
    //   8453	6	14	localObject13	Object
    //   134	5335	15	localObject14	Object
    //   5542	13	15	localObject15	Object
    //   5659	1577	15	localObject16	Object
    //   7309	10	15	localObject17	Object
    //   7398	1048	15	localObject18	Object
    //   42	4467	16	localHostnameVerifier2	javax.net.ssl.HostnameVerifier
    //   4525	52	16	localFileNotFoundException	java.io.FileNotFoundException
    //   4615	635	16	localPluginResult1	org.apache.cordova.api.PluginResult
    //   5260	52	16	localIOException	java.io.IOException
    //   5332	2802	16	localObject19	Object
    //   8180	52	16	localThrowable	Throwable
    //   8270	39	16	localPluginResult2	org.apache.cordova.api.PluginResult
    //   8386	65	16	localObject20	Object
    //   60	8247	17	localObject21	Object
    //   126	8304	18	localObject22	Object
    //   95	7941	19	localObject23	Object
    //   91	7941	20	localObject24	Object
    //   118	8246	21	localObject25	Object
    //   76	7941	22	localObject26	Object
    //   80	7941	23	localObject27	Object
    //   122	8249	24	localObject28	Object
    //   110	7941	25	localObject29	Object
    //   106	7941	26	localObject30	Object
    //   84	7941	27	localObject31	Object
    //   72	7941	28	localObject32	Object
    //   114	8241	29	localObject33	Object
    //   102	7941	30	localObject34	Object
    //   12	8065	31	localObject35	Object
    //   15	516	32	localObject36	Object
    //   1998	76	32	localJSONException2	org.json.JSONException
    //   3809	1220	32	localOutputStream	java.io.OutputStream
    //   5050	683	32	localCloseable1	java.io.Closeable
    //   6593	319	32	localInputStream	java.io.InputStream
    //   6927	548	32	localCloseable2	java.io.Closeable
    //   7929	150	32	localPluginResult3	org.apache.cordova.api.PluginResult
    //   18	7766	33	localObject37	Object
    //   21	5557	34	arrayOfByte1	byte[]
    //   27	4739	35	arrayOfByte2	byte[]
    //   30	4349	36	localObject38	Object
    //   33	4361	37	localObject39	Object
    //   36	4370	38	localObject40	Object
    //   39	4379	39	localObject41	Object
    //   4130	223	40	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   45	4323	41	localObject42	Object
    //   48	4335	42	localObject43	Object
    //   51	4347	43	localObject44	Object
    //   54	4356	44	localObject45	Object
    //   57	4365	45	localObject46	Object
    //   139	7864	46	localFileUploadResult	FileUploadResult
    //   281	4728	47	localFileProgressResult	FileProgressResult
    // Exception table:
    //   from	to	target	type
    //   1444	1453	1998	org/json/JSONException
    //   1507	1517	1998	org/json/JSONException
    //   1571	1580	1998	org/json/JSONException
    //   1634	1647	1998	org/json/JSONException
    //   1701	1719	1998	org/json/JSONException
    //   1773	1794	1998	org/json/JSONException
    //   1848	1861	1998	org/json/JSONException
    //   1915	1933	1998	org/json/JSONException
    //   1987	1995	1998	org/json/JSONException
    //   136	141	4525	java/io/FileNotFoundException
    //   207	212	4525	java/io/FileNotFoundException
    //   278	283	4525	java/io/FileNotFoundException
    //   349	354	4525	java/io/FileNotFoundException
    //   420	427	4525	java/io/FileNotFoundException
    //   493	500	4525	java/io/FileNotFoundException
    //   566	578	4525	java/io/FileNotFoundException
    //   644	650	4525	java/io/FileNotFoundException
    //   716	722	4525	java/io/FileNotFoundException
    //   788	794	4525	java/io/FileNotFoundException
    //   860	867	4525	java/io/FileNotFoundException
    //   933	942	4525	java/io/FileNotFoundException
    //   1008	1020	4525	java/io/FileNotFoundException
    //   1091	1100	4525	java/io/FileNotFoundException
    //   1166	1173	4525	java/io/FileNotFoundException
    //   1239	1248	4525	java/io/FileNotFoundException
    //   1314	1319	4525	java/io/FileNotFoundException
    //   1385	1390	4525	java/io/FileNotFoundException
    //   1444	1453	4525	java/io/FileNotFoundException
    //   1507	1517	4525	java/io/FileNotFoundException
    //   1571	1580	4525	java/io/FileNotFoundException
    //   1634	1647	4525	java/io/FileNotFoundException
    //   1701	1719	4525	java/io/FileNotFoundException
    //   1773	1794	4525	java/io/FileNotFoundException
    //   1848	1861	4525	java/io/FileNotFoundException
    //   1915	1933	4525	java/io/FileNotFoundException
    //   1987	1995	4525	java/io/FileNotFoundException
    //   2066	2079	4525	java/io/FileNotFoundException
    //   2145	2163	4525	java/io/FileNotFoundException
    //   2229	2249	4525	java/io/FileNotFoundException
    //   2315	2340	4525	java/io/FileNotFoundException
    //   2406	2431	4525	java/io/FileNotFoundException
    //   2497	2509	4525	java/io/FileNotFoundException
    //   2575	2584	4525	java/io/FileNotFoundException
    //   2650	2663	4525	java/io/FileNotFoundException
    //   2729	2734	4525	java/io/FileNotFoundException
    //   2800	2805	4525	java/io/FileNotFoundException
    //   2873	2881	4525	java/io/FileNotFoundException
    //   2947	2966	4525	java/io/FileNotFoundException
    //   3032	3038	4525	java/io/FileNotFoundException
    //   3104	3111	4525	java/io/FileNotFoundException
    //   3177	3182	4525	java/io/FileNotFoundException
    //   3248	3253	4525	java/io/FileNotFoundException
    //   3319	3339	4525	java/io/FileNotFoundException
    //   3405	3412	4525	java/io/FileNotFoundException
    //   3478	3486	4525	java/io/FileNotFoundException
    //   3552	3559	4525	java/io/FileNotFoundException
    //   3642	3650	4525	java/io/FileNotFoundException
    //   3716	3727	4525	java/io/FileNotFoundException
    //   3793	3798	4525	java/io/FileNotFoundException
    //   3913	3918	4525	java/io/FileNotFoundException
    //   3984	3989	4525	java/io/FileNotFoundException
    //   4120	4132	4525	java/io/FileNotFoundException
    //   4198	4205	4525	java/io/FileNotFoundException
    //   4271	4278	4525	java/io/FileNotFoundException
    //   4344	4352	4525	java/io/FileNotFoundException
    //   4425	4437	4525	java/io/FileNotFoundException
    //   4516	4522	4525	java/io/FileNotFoundException
    //   5117	5122	4525	java/io/FileNotFoundException
    //   5187	5192	4525	java/io/FileNotFoundException
    //   5257	5260	4525	java/io/FileNotFoundException
    //   5661	5666	4525	java/io/FileNotFoundException
    //   5732	5737	4525	java/io/FileNotFoundException
    //   5803	5811	4525	java/io/FileNotFoundException
    //   5877	5882	4525	java/io/FileNotFoundException
    //   5948	5953	4525	java/io/FileNotFoundException
    //   6019	6051	4525	java/io/FileNotFoundException
    //   6117	6123	4525	java/io/FileNotFoundException
    //   6189	6194	4525	java/io/FileNotFoundException
    //   6260	6265	4525	java/io/FileNotFoundException
    //   6331	6352	4525	java/io/FileNotFoundException
    //   6418	6423	4525	java/io/FileNotFoundException
    //   6489	6494	4525	java/io/FileNotFoundException
    //   6560	6585	4525	java/io/FileNotFoundException
    //   6691	6699	4525	java/io/FileNotFoundException
    //   6765	6770	4525	java/io/FileNotFoundException
    //   6995	7003	4525	java/io/FileNotFoundException
    //   7069	7074	4525	java/io/FileNotFoundException
    //   7140	7143	4525	java/io/FileNotFoundException
    //   7400	7408	4525	java/io/FileNotFoundException
    //   7474	7479	4525	java/io/FileNotFoundException
    //   7545	7554	4525	java/io/FileNotFoundException
    //   7620	7643	4525	java/io/FileNotFoundException
    //   7709	7715	4525	java/io/FileNotFoundException
    //   7781	7788	4525	java/io/FileNotFoundException
    //   7854	7860	4525	java/io/FileNotFoundException
    //   7926	7931	4525	java/io/FileNotFoundException
    //   7997	8010	4525	java/io/FileNotFoundException
    //   8076	8083	4525	java/io/FileNotFoundException
    //   3997	4011	4723	finally
    //   4725	4728	4723	finally
    //   3804	3811	5050	finally
    //   3818	3824	5050	finally
    //   3831	3834	5050	finally
    //   4750	4757	5050	finally
    //   4764	4770	5050	finally
    //   4776	4789	5050	finally
    //   4795	4801	5050	finally
    //   4807	4819	5050	finally
    //   4833	4840	5050	finally
    //   4846	4856	5050	finally
    //   4887	4892	5050	finally
    //   4898	4903	5050	finally
    //   4909	4946	5050	finally
    //   4952	4973	5050	finally
    //   4979	4986	5050	finally
    //   4992	4997	5050	finally
    //   5003	5016	5050	finally
    //   5022	5028	5050	finally
    //   5034	5043	5050	finally
    //   5554	5557	5050	finally
    //   5563	5570	5050	finally
    //   5576	5583	5050	finally
    //   5590	5595	5050	finally
    //   136	141	5260	java/io/IOException
    //   207	212	5260	java/io/IOException
    //   278	283	5260	java/io/IOException
    //   349	354	5260	java/io/IOException
    //   420	427	5260	java/io/IOException
    //   493	500	5260	java/io/IOException
    //   566	578	5260	java/io/IOException
    //   644	650	5260	java/io/IOException
    //   716	722	5260	java/io/IOException
    //   788	794	5260	java/io/IOException
    //   860	867	5260	java/io/IOException
    //   933	942	5260	java/io/IOException
    //   1008	1020	5260	java/io/IOException
    //   1091	1100	5260	java/io/IOException
    //   1166	1173	5260	java/io/IOException
    //   1239	1248	5260	java/io/IOException
    //   1314	1319	5260	java/io/IOException
    //   1385	1390	5260	java/io/IOException
    //   1444	1453	5260	java/io/IOException
    //   1507	1517	5260	java/io/IOException
    //   1571	1580	5260	java/io/IOException
    //   1634	1647	5260	java/io/IOException
    //   1701	1719	5260	java/io/IOException
    //   1773	1794	5260	java/io/IOException
    //   1848	1861	5260	java/io/IOException
    //   1915	1933	5260	java/io/IOException
    //   1987	1995	5260	java/io/IOException
    //   2066	2079	5260	java/io/IOException
    //   2145	2163	5260	java/io/IOException
    //   2229	2249	5260	java/io/IOException
    //   2315	2340	5260	java/io/IOException
    //   2406	2431	5260	java/io/IOException
    //   2497	2509	5260	java/io/IOException
    //   2575	2584	5260	java/io/IOException
    //   2650	2663	5260	java/io/IOException
    //   2729	2734	5260	java/io/IOException
    //   2800	2805	5260	java/io/IOException
    //   2873	2881	5260	java/io/IOException
    //   2947	2966	5260	java/io/IOException
    //   3032	3038	5260	java/io/IOException
    //   3104	3111	5260	java/io/IOException
    //   3177	3182	5260	java/io/IOException
    //   3248	3253	5260	java/io/IOException
    //   3319	3339	5260	java/io/IOException
    //   3405	3412	5260	java/io/IOException
    //   3478	3486	5260	java/io/IOException
    //   3552	3559	5260	java/io/IOException
    //   3642	3650	5260	java/io/IOException
    //   3716	3727	5260	java/io/IOException
    //   3793	3798	5260	java/io/IOException
    //   3913	3918	5260	java/io/IOException
    //   3984	3989	5260	java/io/IOException
    //   4120	4132	5260	java/io/IOException
    //   4198	4205	5260	java/io/IOException
    //   4271	4278	5260	java/io/IOException
    //   4344	4352	5260	java/io/IOException
    //   4425	4437	5260	java/io/IOException
    //   4516	4522	5260	java/io/IOException
    //   5117	5122	5260	java/io/IOException
    //   5187	5192	5260	java/io/IOException
    //   5257	5260	5260	java/io/IOException
    //   5661	5666	5260	java/io/IOException
    //   5732	5737	5260	java/io/IOException
    //   5803	5811	5260	java/io/IOException
    //   5877	5882	5260	java/io/IOException
    //   5948	5953	5260	java/io/IOException
    //   6019	6051	5260	java/io/IOException
    //   6117	6123	5260	java/io/IOException
    //   6189	6194	5260	java/io/IOException
    //   6260	6265	5260	java/io/IOException
    //   6331	6352	5260	java/io/IOException
    //   6418	6423	5260	java/io/IOException
    //   6489	6494	5260	java/io/IOException
    //   6560	6585	5260	java/io/IOException
    //   6691	6699	5260	java/io/IOException
    //   6765	6770	5260	java/io/IOException
    //   6995	7003	5260	java/io/IOException
    //   7069	7074	5260	java/io/IOException
    //   7140	7143	5260	java/io/IOException
    //   7400	7408	5260	java/io/IOException
    //   7474	7479	5260	java/io/IOException
    //   7545	7554	5260	java/io/IOException
    //   7620	7643	5260	java/io/IOException
    //   7709	7715	5260	java/io/IOException
    //   7781	7788	5260	java/io/IOException
    //   7854	7860	5260	java/io/IOException
    //   7926	7931	5260	java/io/IOException
    //   7997	8010	5260	java/io/IOException
    //   8076	8083	5260	java/io/IOException
    //   3834	3847	5542	finally
    //   4731	4743	5542	finally
    //   5544	5547	5542	finally
    //   6778	6792	6835	finally
    //   6837	6840	6835	finally
    //   6588	6595	6927	finally
    //   6599	6605	6927	finally
    //   6609	6612	6927	finally
    //   6859	6864	6927	finally
    //   6868	6884	6927	finally
    //   6888	6895	6927	finally
    //   6899	6907	6927	finally
    //   6915	6924	6927	finally
    //   7318	7321	6927	finally
    //   7325	7334	6927	finally
    //   136	141	7143	org/json/JSONException
    //   207	212	7143	org/json/JSONException
    //   278	283	7143	org/json/JSONException
    //   349	354	7143	org/json/JSONException
    //   420	427	7143	org/json/JSONException
    //   493	500	7143	org/json/JSONException
    //   566	578	7143	org/json/JSONException
    //   644	650	7143	org/json/JSONException
    //   716	722	7143	org/json/JSONException
    //   788	794	7143	org/json/JSONException
    //   860	867	7143	org/json/JSONException
    //   933	942	7143	org/json/JSONException
    //   1008	1020	7143	org/json/JSONException
    //   1091	1100	7143	org/json/JSONException
    //   1166	1173	7143	org/json/JSONException
    //   1239	1248	7143	org/json/JSONException
    //   1314	1319	7143	org/json/JSONException
    //   1385	1390	7143	org/json/JSONException
    //   2066	2079	7143	org/json/JSONException
    //   2145	2163	7143	org/json/JSONException
    //   2229	2249	7143	org/json/JSONException
    //   2315	2340	7143	org/json/JSONException
    //   2406	2431	7143	org/json/JSONException
    //   2497	2509	7143	org/json/JSONException
    //   2575	2584	7143	org/json/JSONException
    //   2650	2663	7143	org/json/JSONException
    //   2729	2734	7143	org/json/JSONException
    //   2800	2805	7143	org/json/JSONException
    //   2873	2881	7143	org/json/JSONException
    //   2947	2966	7143	org/json/JSONException
    //   3032	3038	7143	org/json/JSONException
    //   3104	3111	7143	org/json/JSONException
    //   3177	3182	7143	org/json/JSONException
    //   3248	3253	7143	org/json/JSONException
    //   3319	3339	7143	org/json/JSONException
    //   3405	3412	7143	org/json/JSONException
    //   3478	3486	7143	org/json/JSONException
    //   3552	3559	7143	org/json/JSONException
    //   3642	3650	7143	org/json/JSONException
    //   3716	3727	7143	org/json/JSONException
    //   3793	3798	7143	org/json/JSONException
    //   3913	3918	7143	org/json/JSONException
    //   3984	3989	7143	org/json/JSONException
    //   4120	4132	7143	org/json/JSONException
    //   4198	4205	7143	org/json/JSONException
    //   4271	4278	7143	org/json/JSONException
    //   4344	4352	7143	org/json/JSONException
    //   4425	4437	7143	org/json/JSONException
    //   4516	4522	7143	org/json/JSONException
    //   5117	5122	7143	org/json/JSONException
    //   5187	5192	7143	org/json/JSONException
    //   5257	5260	7143	org/json/JSONException
    //   5661	5666	7143	org/json/JSONException
    //   5732	5737	7143	org/json/JSONException
    //   5803	5811	7143	org/json/JSONException
    //   5877	5882	7143	org/json/JSONException
    //   5948	5953	7143	org/json/JSONException
    //   6019	6051	7143	org/json/JSONException
    //   6117	6123	7143	org/json/JSONException
    //   6189	6194	7143	org/json/JSONException
    //   6260	6265	7143	org/json/JSONException
    //   6331	6352	7143	org/json/JSONException
    //   6418	6423	7143	org/json/JSONException
    //   6489	6494	7143	org/json/JSONException
    //   6560	6585	7143	org/json/JSONException
    //   6691	6699	7143	org/json/JSONException
    //   6765	6770	7143	org/json/JSONException
    //   6995	7003	7143	org/json/JSONException
    //   7069	7074	7143	org/json/JSONException
    //   7140	7143	7143	org/json/JSONException
    //   7400	7408	7143	org/json/JSONException
    //   7474	7479	7143	org/json/JSONException
    //   7545	7554	7143	org/json/JSONException
    //   7620	7643	7143	org/json/JSONException
    //   7709	7715	7143	org/json/JSONException
    //   7781	7788	7143	org/json/JSONException
    //   7854	7860	7143	org/json/JSONException
    //   7926	7931	7143	org/json/JSONException
    //   7997	8010	7143	org/json/JSONException
    //   8076	8083	7143	org/json/JSONException
    //   6612	6625	7309	finally
    //   6843	6855	7309	finally
    //   7311	7314	7309	finally
    //   8091	8105	8148	finally
    //   8150	8153	8148	finally
    //   4666	4680	8156	finally
    //   8158	8161	8156	finally
    //   5485	5499	8164	finally
    //   8166	8169	8164	finally
    //   7252	7266	8172	finally
    //   8174	8177	8172	finally
    //   136	141	8180	java/lang/Throwable
    //   207	212	8180	java/lang/Throwable
    //   278	283	8180	java/lang/Throwable
    //   349	354	8180	java/lang/Throwable
    //   420	427	8180	java/lang/Throwable
    //   493	500	8180	java/lang/Throwable
    //   566	578	8180	java/lang/Throwable
    //   644	650	8180	java/lang/Throwable
    //   716	722	8180	java/lang/Throwable
    //   788	794	8180	java/lang/Throwable
    //   860	867	8180	java/lang/Throwable
    //   933	942	8180	java/lang/Throwable
    //   1008	1020	8180	java/lang/Throwable
    //   1091	1100	8180	java/lang/Throwable
    //   1166	1173	8180	java/lang/Throwable
    //   1239	1248	8180	java/lang/Throwable
    //   1314	1319	8180	java/lang/Throwable
    //   1385	1390	8180	java/lang/Throwable
    //   1444	1453	8180	java/lang/Throwable
    //   1507	1517	8180	java/lang/Throwable
    //   1571	1580	8180	java/lang/Throwable
    //   1634	1647	8180	java/lang/Throwable
    //   1701	1719	8180	java/lang/Throwable
    //   1773	1794	8180	java/lang/Throwable
    //   1848	1861	8180	java/lang/Throwable
    //   1915	1933	8180	java/lang/Throwable
    //   1987	1995	8180	java/lang/Throwable
    //   2066	2079	8180	java/lang/Throwable
    //   2145	2163	8180	java/lang/Throwable
    //   2229	2249	8180	java/lang/Throwable
    //   2315	2340	8180	java/lang/Throwable
    //   2406	2431	8180	java/lang/Throwable
    //   2497	2509	8180	java/lang/Throwable
    //   2575	2584	8180	java/lang/Throwable
    //   2650	2663	8180	java/lang/Throwable
    //   2729	2734	8180	java/lang/Throwable
    //   2800	2805	8180	java/lang/Throwable
    //   2873	2881	8180	java/lang/Throwable
    //   2947	2966	8180	java/lang/Throwable
    //   3032	3038	8180	java/lang/Throwable
    //   3104	3111	8180	java/lang/Throwable
    //   3177	3182	8180	java/lang/Throwable
    //   3248	3253	8180	java/lang/Throwable
    //   3319	3339	8180	java/lang/Throwable
    //   3405	3412	8180	java/lang/Throwable
    //   3478	3486	8180	java/lang/Throwable
    //   3552	3559	8180	java/lang/Throwable
    //   3642	3650	8180	java/lang/Throwable
    //   3716	3727	8180	java/lang/Throwable
    //   3793	3798	8180	java/lang/Throwable
    //   3913	3918	8180	java/lang/Throwable
    //   3984	3989	8180	java/lang/Throwable
    //   4120	4132	8180	java/lang/Throwable
    //   4198	4205	8180	java/lang/Throwable
    //   4271	4278	8180	java/lang/Throwable
    //   4344	4352	8180	java/lang/Throwable
    //   4425	4437	8180	java/lang/Throwable
    //   4516	4522	8180	java/lang/Throwable
    //   5117	5122	8180	java/lang/Throwable
    //   5187	5192	8180	java/lang/Throwable
    //   5257	5260	8180	java/lang/Throwable
    //   5661	5666	8180	java/lang/Throwable
    //   5732	5737	8180	java/lang/Throwable
    //   5803	5811	8180	java/lang/Throwable
    //   5877	5882	8180	java/lang/Throwable
    //   5948	5953	8180	java/lang/Throwable
    //   6019	6051	8180	java/lang/Throwable
    //   6117	6123	8180	java/lang/Throwable
    //   6189	6194	8180	java/lang/Throwable
    //   6260	6265	8180	java/lang/Throwable
    //   6331	6352	8180	java/lang/Throwable
    //   6418	6423	8180	java/lang/Throwable
    //   6489	6494	8180	java/lang/Throwable
    //   6560	6585	8180	java/lang/Throwable
    //   6691	6699	8180	java/lang/Throwable
    //   6765	6770	8180	java/lang/Throwable
    //   6995	7003	8180	java/lang/Throwable
    //   7069	7074	8180	java/lang/Throwable
    //   7140	7143	8180	java/lang/Throwable
    //   7400	7408	8180	java/lang/Throwable
    //   7474	7479	8180	java/lang/Throwable
    //   7545	7554	8180	java/lang/Throwable
    //   7620	7643	8180	java/lang/Throwable
    //   7709	7715	8180	java/lang/Throwable
    //   7781	7788	8180	java/lang/Throwable
    //   7854	7860	8180	java/lang/Throwable
    //   7926	7931	8180	java/lang/Throwable
    //   7997	8010	8180	java/lang/Throwable
    //   8076	8083	8180	java/lang/Throwable
    //   8321	8335	8378	finally
    //   8380	8383	8378	finally
    //   136	141	8386	finally
    //   207	212	8386	finally
    //   278	283	8386	finally
    //   349	354	8386	finally
    //   420	427	8386	finally
    //   493	500	8386	finally
    //   566	578	8386	finally
    //   644	650	8386	finally
    //   716	722	8386	finally
    //   788	794	8386	finally
    //   860	867	8386	finally
    //   933	942	8386	finally
    //   1008	1020	8386	finally
    //   1091	1100	8386	finally
    //   1166	1173	8386	finally
    //   1239	1248	8386	finally
    //   1314	1319	8386	finally
    //   1385	1390	8386	finally
    //   1444	1453	8386	finally
    //   1507	1517	8386	finally
    //   1571	1580	8386	finally
    //   1634	1647	8386	finally
    //   1701	1719	8386	finally
    //   1773	1794	8386	finally
    //   1848	1861	8386	finally
    //   1915	1933	8386	finally
    //   1987	1995	8386	finally
    //   2066	2079	8386	finally
    //   2145	2163	8386	finally
    //   2229	2249	8386	finally
    //   2315	2340	8386	finally
    //   2406	2431	8386	finally
    //   2497	2509	8386	finally
    //   2575	2584	8386	finally
    //   2650	2663	8386	finally
    //   2729	2734	8386	finally
    //   2800	2805	8386	finally
    //   2873	2881	8386	finally
    //   2947	2966	8386	finally
    //   3032	3038	8386	finally
    //   3104	3111	8386	finally
    //   3177	3182	8386	finally
    //   3248	3253	8386	finally
    //   3319	3339	8386	finally
    //   3405	3412	8386	finally
    //   3478	3486	8386	finally
    //   3552	3559	8386	finally
    //   3642	3650	8386	finally
    //   3716	3727	8386	finally
    //   3793	3798	8386	finally
    //   3913	3918	8386	finally
    //   3984	3989	8386	finally
    //   4120	4132	8386	finally
    //   4198	4205	8386	finally
    //   4271	4278	8386	finally
    //   4344	4352	8386	finally
    //   4425	4437	8386	finally
    //   4516	4522	8386	finally
    //   4539	4557	8386	finally
    //   4569	4582	8386	finally
    //   4594	4600	8386	finally
    //   4612	4617	8386	finally
    //   4629	4639	8386	finally
    //   4651	4658	8386	finally
    //   5117	5122	8386	finally
    //   5187	5192	8386	finally
    //   5257	5260	8386	finally
    //   5274	5292	8386	finally
    //   5304	5317	8386	finally
    //   5329	5334	8386	finally
    //   5346	5351	8386	finally
    //   5363	5401	8386	finally
    //   5413	5419	8386	finally
    //   5431	5436	8386	finally
    //   5448	5458	8386	finally
    //   5470	5477	8386	finally
    //   5661	5666	8386	finally
    //   5732	5737	8386	finally
    //   5803	5811	8386	finally
    //   5877	5882	8386	finally
    //   5948	5953	8386	finally
    //   6019	6051	8386	finally
    //   6117	6123	8386	finally
    //   6189	6194	8386	finally
    //   6260	6265	8386	finally
    //   6331	6352	8386	finally
    //   6418	6423	8386	finally
    //   6489	6494	8386	finally
    //   6560	6585	8386	finally
    //   6691	6699	8386	finally
    //   6765	6770	8386	finally
    //   6995	7003	8386	finally
    //   7069	7074	8386	finally
    //   7140	7143	8386	finally
    //   7157	7170	8386	finally
    //   7182	7188	8386	finally
    //   7200	7205	8386	finally
    //   7217	7225	8386	finally
    //   7237	7244	8386	finally
    //   7400	7408	8386	finally
    //   7474	7479	8386	finally
    //   7545	7554	8386	finally
    //   7620	7643	8386	finally
    //   7709	7715	8386	finally
    //   7781	7788	8386	finally
    //   7854	7860	8386	finally
    //   7926	7931	8386	finally
    //   7997	8010	8386	finally
    //   8076	8083	8386	finally
    //   8194	8212	8386	finally
    //   8224	8237	8386	finally
    //   8249	8255	8386	finally
    //   8267	8272	8386	finally
    //   8284	8294	8386	finally
    //   8306	8313	8386	finally
    //   8396	8410	8453	finally
    //   8455	8458	8453	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileTransfer$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */