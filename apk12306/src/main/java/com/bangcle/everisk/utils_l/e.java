package com.bangcle.everisk.utils_l;

import android.content.Context;
import android.os.Build;
import com.bangcle.everisk.shell.LibProc;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class e
{
  private static int aa = 10000;
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = null;
    byte[] arrayOfByte = a(paramString, null, paramInt);
    if (arrayOfByte == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = new java/lang/String;
        paramString.<init>(arrayOfByte, "utf-8");
      }
      catch (Exception paramString)
      {
        LibProc.a(paramString);
        paramString = (String)localObject;
      }
    }
  }
  
  public static byte[] a(String paramString1, String paramString2, int paramInt)
  {
    aa = 10000;
    int i = 0;
    for (;;)
    {
      int j;
      int k;
      long l;
      try
      {
        locala = b(paramString1, paramString2);
        if (locala.U != null)
        {
          j = locala.U.length;
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("url: ");
          LibProc.a("RiskStub.HTTP", paramString1 + ", path: " + paramString2 + ", ret=" + locala.T + ",len: " + j);
          if (locala.z())
          {
            paramString1 = null;
            return paramString1;
          }
        }
        else
        {
          j = 0;
          continue;
        }
      }
      catch (Exception paramString1)
      {
        a locala;
        LibProc.a(paramString1);
        paramString1 = null;
        continue;
        if (locala.T == 1)
        {
          k = 1;
          if (k != 0)
          {
            aa = 10000;
            paramString1 = locala.U;
          }
        }
        else
        {
          k = 0;
          continue;
        }
        k = i;
        if (paramInt != -1)
        {
          i++;
          k = i;
          if (i >= paramInt)
          {
            paramString1 = null;
            continue;
          }
        }
        if (j > 0)
        {
          i = k;
          if (paramString2 != null) {
            continue;
          }
        }
        l = aa;
      }
      try
      {
        Thread.sleep(l);
        j = aa + aa;
        aa = j;
        i = k;
        if (j <= 900000) {
          continue;
        }
        aa = 900000;
        i = k;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  private static a b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 37	com/bangcle/everisk/utils_l/a
    //   5: dup
    //   6: invokespecial 90	com/bangcle/everisk/utils_l/a:<init>	()V
    //   9: astore 7
    //   11: ldc 92
    //   13: new 43	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 94
    //   19: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 96
    //   28: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: new 98	java/net/URL
    //   40: astore 6
    //   42: aload 6
    //   44: aload_0
    //   45: invokespecial 99	java/net/URL:<init>	(Ljava/lang/String;)V
    //   48: aload 6
    //   50: invokevirtual 103	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: checkcast 105	java/net/HttpURLConnection
    //   56: astore 6
    //   58: aload 6
    //   60: ldc 107
    //   62: invokevirtual 110	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   65: aload_1
    //   66: ifnull +180 -> 246
    //   69: ldc 92
    //   71: new 43	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 112
    //   77: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 96
    //   86: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: new 114	java/io/File
    //   98: dup
    //   99: aload_1
    //   100: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   103: astore 8
    //   105: aload 8
    //   107: invokevirtual 118	java/io/File:getParent	()Ljava/lang/String;
    //   110: invokestatic 122	com/bangcle/everisk/utils_l/e:e	(Ljava/lang/String;)Z
    //   113: ifne +53 -> 166
    //   116: ldc 124
    //   118: new 43	java/lang/StringBuilder
    //   121: dup
    //   122: ldc 126
    //   124: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload 8
    //   129: invokevirtual 118	java/io/File:getParent	()Ljava/lang/String;
    //   132: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 96
    //   137: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: aload 7
    //   148: aconst_null
    //   149: invokevirtual 130	com/bangcle/everisk/utils_l/a:c	(Ljava/lang/Exception;)Lcom/bangcle/everisk/utils_l/a;
    //   152: astore_0
    //   153: aload_0
    //   154: areturn
    //   155: astore_0
    //   156: aload 7
    //   158: aload_0
    //   159: invokevirtual 130	com/bangcle/everisk/utils_l/a:c	(Ljava/lang/Exception;)Lcom/bangcle/everisk/utils_l/a;
    //   162: astore_0
    //   163: goto -10 -> 153
    //   166: aload 8
    //   168: invokevirtual 133	java/io/File:exists	()Z
    //   171: istore_3
    //   172: iload_3
    //   173: ifeq +188 -> 361
    //   176: aload 8
    //   178: invokevirtual 137	java/io/File:length	()J
    //   181: lstore 4
    //   183: ldc 124
    //   185: new 43	java/lang/StringBuilder
    //   188: dup
    //   189: ldc -117
    //   191: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   194: lload 4
    //   196: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   199: ldc 96
    //   201: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: lload 4
    //   212: lconst_0
    //   213: lcmp
    //   214: ifeq +32 -> 246
    //   217: aload 6
    //   219: ldc -112
    //   221: new 43	java/lang/StringBuilder
    //   224: dup
    //   225: ldc -110
    //   227: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: lload 4
    //   232: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   235: ldc -108
    //   237: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokevirtual 151	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   246: new 153	java/io/ByteArrayOutputStream
    //   249: dup
    //   250: invokespecial 154	java/io/ByteArrayOutputStream:<init>	()V
    //   253: astore 9
    //   255: aload 6
    //   257: invokevirtual 158	java/net/HttpURLConnection:getResponseCode	()I
    //   260: istore_2
    //   261: sipush 200
    //   264: iload_2
    //   265: if_icmpeq +120 -> 385
    //   268: sipush 206
    //   271: iload_2
    //   272: if_icmpeq +113 -> 385
    //   275: new 43	java/lang/StringBuilder
    //   278: astore 6
    //   280: aload 6
    //   282: ldc -96
    //   284: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   287: ldc 124
    //   289: aload 6
    //   291: iload_2
    //   292: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: ldc 96
    //   297: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: sipush 416
    //   309: iload_2
    //   310: if_icmpne +12 -> 322
    //   313: iload_3
    //   314: ifeq +8 -> 322
    //   317: aload_1
    //   318: invokestatic 162	com/bangcle/everisk/utils_l/e:c	(Ljava/lang/String;)Z
    //   321: pop
    //   322: aload 7
    //   324: aconst_null
    //   325: invokevirtual 164	com/bangcle/everisk/utils_l/a:b	(Ljava/lang/Exception;)Lcom/bangcle/everisk/utils_l/a;
    //   328: pop
    //   329: aconst_null
    //   330: astore 6
    //   332: aload 9
    //   334: invokevirtual 167	java/io/ByteArrayOutputStream:close	()V
    //   337: aload 6
    //   339: ifnull +8 -> 347
    //   342: aload 6
    //   344: invokevirtual 170	java/io/InputStream:close	()V
    //   347: aload 7
    //   349: invokevirtual 77	com/bangcle/everisk/utils_l/a:z	()Z
    //   352: ifeq +220 -> 572
    //   355: aload 7
    //   357: astore_0
    //   358: goto -205 -> 153
    //   361: aload_1
    //   362: invokestatic 173	com/bangcle/everisk/utils_l/e:d	(Ljava/lang/String;)Z
    //   365: ifne +360 -> 725
    //   368: ldc -81
    //   370: ldc -79
    //   372: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   375: aload 7
    //   377: aconst_null
    //   378: invokevirtual 130	com/bangcle/everisk/utils_l/a:c	(Ljava/lang/Exception;)Lcom/bangcle/everisk/utils_l/a;
    //   381: astore_0
    //   382: goto -229 -> 153
    //   385: aload 6
    //   387: invokevirtual 181	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   390: ldc -73
    //   392: invokeinterface 189 2 0
    //   397: checkcast 191	java/util/List
    //   400: iconst_0
    //   401: invokeinterface 194 2 0
    //   406: checkcast 20	java/lang/String
    //   409: astore 8
    //   411: new 43	java/lang/StringBuilder
    //   414: astore 10
    //   416: aload 10
    //   418: ldc -60
    //   420: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   423: ldc 124
    //   425: aload 10
    //   427: aload 8
    //   429: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc 96
    //   434: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   443: aload 6
    //   445: invokevirtual 200	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   448: astore 6
    //   450: sipush 1024
    //   453: newarray <illegal type>
    //   455: astore 8
    //   457: aload 6
    //   459: aload 8
    //   461: invokevirtual 204	java/io/InputStream:read	([B)I
    //   464: istore_2
    //   465: iload_2
    //   466: iconst_m1
    //   467: if_icmpeq +28 -> 495
    //   470: aload 9
    //   472: aload 8
    //   474: iconst_0
    //   475: iload_2
    //   476: invokevirtual 208	java/io/ByteArrayOutputStream:write	([BII)V
    //   479: goto -22 -> 457
    //   482: astore 8
    //   484: aload 7
    //   486: aload 8
    //   488: invokevirtual 164	com/bangcle/everisk/utils_l/a:b	(Ljava/lang/Exception;)Lcom/bangcle/everisk/utils_l/a;
    //   491: pop
    //   492: goto -160 -> 332
    //   495: new 43	java/lang/StringBuilder
    //   498: astore 8
    //   500: aload 8
    //   502: ldc -46
    //   504: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   507: ldc 124
    //   509: aload 8
    //   511: aload 9
    //   513: invokevirtual 213	java/io/ByteArrayOutputStream:size	()I
    //   516: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   519: ldc 96
    //   521: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   530: aload 7
    //   532: iconst_1
    //   533: putfield 61	com/bangcle/everisk/utils_l/a:T	I
    //   536: goto -204 -> 332
    //   539: astore 8
    //   541: aload 7
    //   543: aload 8
    //   545: invokevirtual 164	com/bangcle/everisk/utils_l/a:b	(Ljava/lang/Exception;)Lcom/bangcle/everisk/utils_l/a;
    //   548: pop
    //   549: goto -217 -> 332
    //   552: astore 8
    //   554: aconst_null
    //   555: astore 6
    //   557: aload 8
    //   559: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   562: aload 7
    //   564: aconst_null
    //   565: invokevirtual 130	com/bangcle/everisk/utils_l/a:c	(Ljava/lang/Exception;)Lcom/bangcle/everisk/utils_l/a;
    //   568: pop
    //   569: goto -237 -> 332
    //   572: aload 7
    //   574: aload 9
    //   576: invokevirtual 217	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   579: putfield 41	com/bangcle/everisk/utils_l/a:U	[B
    //   582: aload 7
    //   584: getfield 41	com/bangcle/everisk/utils_l/a:U	[B
    //   587: arraylength
    //   588: ifne +9 -> 597
    //   591: aload 7
    //   593: astore_0
    //   594: goto -441 -> 153
    //   597: aload_1
    //   598: ifnull +66 -> 664
    //   601: ldc 124
    //   603: new 43	java/lang/StringBuilder
    //   606: dup
    //   607: ldc -37
    //   609: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   612: aload 7
    //   614: getfield 41	com/bangcle/everisk/utils_l/a:U	[B
    //   617: arraylength
    //   618: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   621: ldc 96
    //   623: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: new 221	java/io/RandomAccessFile
    //   635: dup
    //   636: aload_1
    //   637: ldc -33
    //   639: invokespecial 225	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   642: astore_1
    //   643: aload_1
    //   644: aload_1
    //   645: invokevirtual 226	java/io/RandomAccessFile:length	()J
    //   648: invokevirtual 229	java/io/RandomAccessFile:seek	(J)V
    //   651: aload_1
    //   652: aload 7
    //   654: getfield 41	com/bangcle/everisk/utils_l/a:U	[B
    //   657: invokevirtual 232	java/io/RandomAccessFile:write	([B)V
    //   660: aload_1
    //   661: invokevirtual 233	java/io/RandomAccessFile:close	()V
    //   664: ldc 124
    //   666: new 43	java/lang/StringBuilder
    //   669: dup
    //   670: ldc -21
    //   672: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   675: aload_0
    //   676: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc -19
    //   681: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload 7
    //   686: getfield 61	com/bangcle/everisk/utils_l/a:T	I
    //   689: invokevirtual 64	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   698: aload 7
    //   700: astore_0
    //   701: goto -548 -> 153
    //   704: astore 8
    //   706: goto -149 -> 557
    //   709: astore 8
    //   711: aconst_null
    //   712: astore 6
    //   714: goto -173 -> 541
    //   717: astore 8
    //   719: aconst_null
    //   720: astore 6
    //   722: goto -238 -> 484
    //   725: lconst_0
    //   726: lstore 4
    //   728: goto -545 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	731	0	paramString1	String
    //   0	731	1	paramString2	String
    //   260	216	2	i	int
    //   1	313	3	bool	boolean
    //   181	546	4	l	long
    //   40	681	6	localObject1	Object
    //   9	690	7	locala	a
    //   103	370	8	localObject2	Object
    //   482	5	8	localEOFException1	java.io.EOFException
    //   498	12	8	localStringBuilder1	StringBuilder
    //   539	5	8	localIOException1	java.io.IOException
    //   552	6	8	localException1	Exception
    //   704	1	8	localException2	Exception
    //   709	1	8	localIOException2	java.io.IOException
    //   717	1	8	localEOFException2	java.io.EOFException
    //   253	322	9	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   414	12	10	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	65	155	java/io/IOException
    //   450	457	482	java/io/EOFException
    //   457	465	482	java/io/EOFException
    //   470	479	482	java/io/EOFException
    //   495	536	482	java/io/EOFException
    //   450	457	539	java/io/IOException
    //   457	465	539	java/io/IOException
    //   470	479	539	java/io/IOException
    //   495	536	539	java/io/IOException
    //   255	261	552	java/lang/Exception
    //   275	306	552	java/lang/Exception
    //   317	322	552	java/lang/Exception
    //   322	329	552	java/lang/Exception
    //   385	450	552	java/lang/Exception
    //   450	457	704	java/lang/Exception
    //   457	465	704	java/lang/Exception
    //   470	479	704	java/lang/Exception
    //   495	536	704	java/lang/Exception
    //   255	261	709	java/io/IOException
    //   275	306	709	java/io/IOException
    //   317	322	709	java/io/IOException
    //   322	329	709	java/io/IOException
    //   385	450	709	java/io/IOException
    //   255	261	717	java/io/EOFException
    //   275	306	717	java/io/EOFException
    //   317	322	717	java/io/EOFException
    //   322	329	717	java/io/EOFException
    //   385	450	717	java/io/EOFException
  }
  
  public static String c(Context paramContext)
  {
    String str2 = "";
    str1 = str2;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getFilesDir();
        if (paramContext != null) {
          continue;
        }
        paramContext = str2;
      }
      catch (Exception paramContext)
      {
        LibProc.a(paramContext);
        paramContext = str1;
        continue;
      }
      return paramContext;
      str1 = str2;
      str2 = paramContext.getCanonicalPath();
      paramContext = str2;
      if (str2 == null) {
        paramContext = "";
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("delete file ");
      LibProc.a("RiskStubShell.File", paramString);
      localObject = new java/io/File;
      ((File)localObject).<init>(paramString);
      bool = ((File)localObject).delete();
      return bool;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  /* Error */
  public static boolean c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: iconst_0
    //   7: istore 4
    //   9: ldc_w 259
    //   12: new 43	java/lang/StringBuilder
    //   15: dup
    //   16: ldc_w 261
    //   19: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 96
    //   28: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: ldc_w 259
    //   40: new 43	java/lang/StringBuilder
    //   43: dup
    //   44: ldc_w 263
    //   47: invokespecial 48	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   50: aload_1
    //   51: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: ldc 96
    //   56: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 70	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 73	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: new 114	java/io/File
    //   68: astore 5
    //   70: aload 5
    //   72: aload_0
    //   73: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: aload 5
    //   78: invokevirtual 133	java/io/File:exists	()Z
    //   81: ifne +8 -> 89
    //   84: iload 4
    //   86: istore_3
    //   87: iload_3
    //   88: ireturn
    //   89: new 114	java/io/File
    //   92: astore 5
    //   94: aload 5
    //   96: aload_1
    //   97: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: iload 4
    //   102: istore_3
    //   103: aload 5
    //   105: invokevirtual 118	java/io/File:getParent	()Ljava/lang/String;
    //   108: invokestatic 122	com/bangcle/everisk/utils_l/e:e	(Ljava/lang/String;)Z
    //   111: ifeq -24 -> 87
    //   114: new 265	java/io/BufferedInputStream
    //   117: astore 5
    //   119: new 267	java/io/FileInputStream
    //   122: astore 8
    //   124: aload 8
    //   126: aload_0
    //   127: invokespecial 268	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   130: aload 5
    //   132: aload 8
    //   134: invokespecial 271	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   137: new 273	java/io/BufferedOutputStream
    //   140: astore_0
    //   141: new 275	java/io/FileOutputStream
    //   144: astore 7
    //   146: aload 7
    //   148: aload_1
    //   149: invokespecial 276	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   152: aload_0
    //   153: aload 7
    //   155: invokespecial 279	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   158: sipush 1024
    //   161: newarray <illegal type>
    //   163: astore_1
    //   164: aload 5
    //   166: aload_1
    //   167: invokevirtual 280	java/io/BufferedInputStream:read	([B)I
    //   170: istore_2
    //   171: iload_2
    //   172: iconst_m1
    //   173: if_icmpeq +63 -> 236
    //   176: aload_0
    //   177: aload_1
    //   178: iconst_0
    //   179: iload_2
    //   180: invokevirtual 281	java/io/BufferedOutputStream:write	([BII)V
    //   183: goto -19 -> 164
    //   186: astore 6
    //   188: aload 5
    //   190: astore_1
    //   191: aload 6
    //   193: astore 5
    //   195: aload 5
    //   197: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   200: aload_1
    //   201: ifnull +7 -> 208
    //   204: aload_1
    //   205: invokevirtual 282	java/io/BufferedInputStream:close	()V
    //   208: iload 4
    //   210: istore_3
    //   211: aload_0
    //   212: ifnull -125 -> 87
    //   215: aload_0
    //   216: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   219: iload 4
    //   221: istore_3
    //   222: goto -135 -> 87
    //   225: astore_0
    //   226: aload_0
    //   227: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   230: iload 4
    //   232: istore_3
    //   233: goto -146 -> 87
    //   236: aload_0
    //   237: invokevirtual 286	java/io/BufferedOutputStream:flush	()V
    //   240: iconst_1
    //   241: istore_3
    //   242: aload 5
    //   244: invokevirtual 282	java/io/BufferedInputStream:close	()V
    //   247: aload_0
    //   248: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   251: goto -164 -> 87
    //   254: astore_0
    //   255: aload_0
    //   256: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   259: goto -172 -> 87
    //   262: astore_1
    //   263: aload_1
    //   264: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   267: goto -20 -> 247
    //   270: astore_1
    //   271: aload_1
    //   272: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   275: goto -67 -> 208
    //   278: astore_0
    //   279: aconst_null
    //   280: astore 5
    //   282: aload 6
    //   284: astore_1
    //   285: aload 5
    //   287: ifnull +8 -> 295
    //   290: aload 5
    //   292: invokevirtual 282	java/io/BufferedInputStream:close	()V
    //   295: aload_1
    //   296: ifnull +7 -> 303
    //   299: aload_1
    //   300: invokevirtual 283	java/io/BufferedOutputStream:close	()V
    //   303: aload_0
    //   304: athrow
    //   305: astore 5
    //   307: aload 5
    //   309: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   312: goto -17 -> 295
    //   315: astore_1
    //   316: aload_1
    //   317: invokestatic 31	com/bangcle/everisk/shell/LibProc:a	(Ljava/lang/Exception;)V
    //   320: goto -17 -> 303
    //   323: astore_0
    //   324: aload 6
    //   326: astore_1
    //   327: goto -42 -> 285
    //   330: astore 6
    //   332: aload_0
    //   333: astore_1
    //   334: aload 6
    //   336: astore_0
    //   337: goto -52 -> 285
    //   340: astore 6
    //   342: aload_1
    //   343: astore 5
    //   345: aload_0
    //   346: astore_1
    //   347: aload 6
    //   349: astore_0
    //   350: goto -65 -> 285
    //   353: astore 5
    //   355: aconst_null
    //   356: astore_0
    //   357: aload 7
    //   359: astore_1
    //   360: goto -165 -> 195
    //   363: astore_0
    //   364: aconst_null
    //   365: astore 6
    //   367: aload 5
    //   369: astore_1
    //   370: aload_0
    //   371: astore 5
    //   373: aload 6
    //   375: astore_0
    //   376: goto -181 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramString1	String
    //   0	379	1	paramString2	String
    //   170	10	2	i	int
    //   86	156	3	bool1	boolean
    //   7	224	4	bool2	boolean
    //   68	223	5	localObject1	Object
    //   305	3	5	localException1	Exception
    //   343	1	5	str1	String
    //   353	15	5	localException2	Exception
    //   371	1	5	str2	String
    //   1	1	6	localObject2	Object
    //   186	139	6	localException3	Exception
    //   330	5	6	localObject3	Object
    //   340	8	6	localObject4	Object
    //   365	9	6	localObject5	Object
    //   4	354	7	localFileOutputStream	FileOutputStream
    //   122	11	8	localFileInputStream	FileInputStream
    // Exception table:
    //   from	to	target	type
    //   158	164	186	java/lang/Exception
    //   164	171	186	java/lang/Exception
    //   176	183	186	java/lang/Exception
    //   236	240	186	java/lang/Exception
    //   215	219	225	java/lang/Exception
    //   247	251	254	java/lang/Exception
    //   242	247	262	java/lang/Exception
    //   204	208	270	java/lang/Exception
    //   65	84	278	finally
    //   89	100	278	finally
    //   103	137	278	finally
    //   290	295	305	java/lang/Exception
    //   299	303	315	java/lang/Exception
    //   137	158	323	finally
    //   158	164	330	finally
    //   164	171	330	finally
    //   176	183	330	finally
    //   236	240	330	finally
    //   195	200	340	finally
    //   65	84	353	java/lang/Exception
    //   89	100	353	java/lang/Exception
    //   103	137	353	java/lang/Exception
    //   137	158	363	java/lang/Exception
  }
  
  public static ArrayList d(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    LibProc.a("RiskStubShell.ExtractZipFile", "zfile: " + paramString1 + ", DstDir: " + paramString2);
    FileInputStream localFileInputStream;
    ZipInputStream localZipInputStream;
    byte[] arrayOfByte;
    ZipEntry localZipEntry;
    Object localObject;
    try
    {
      localFileInputStream = new java/io/FileInputStream;
      localFileInputStream.<init>(paramString1);
      localZipInputStream = new java/util/zip/ZipInputStream;
      localZipInputStream.<init>(localFileInputStream);
      arrayOfByte = new byte['Ā'];
      for (;;)
      {
        localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry == null) {
          break label305;
        }
        paramString1 = new java/io/File;
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        paramString1.<init>(paramString2 + "/" + localZipEntry.getName());
        localObject = new java/io/File;
        ((File)localObject).<init>(paramString1.getParentFile().getPath());
        if (!localZipEntry.isDirectory()) {
          break;
        }
        if (!paramString1.exists()) {
          paramString1.mkdirs();
        }
        localZipInputStream.closeEntry();
      }
      return localArrayList;
    }
    catch (Exception paramString1)
    {
      LibProc.a("RiskStubShell.ExtractZipFile", "ERROR: " + paramString1.getMessage());
      LibProc.a(paramString1);
    }
    for (;;)
    {
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      localFileOutputStream.<init>(paramString1);
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>("ze.getName: ");
      LibProc.a("RiskStubShell.ExtractZipFile", paramString1.getAbsolutePath());
      localArrayList.add(localZipEntry.getName());
      for (;;)
      {
        int i = localZipInputStream.read(arrayOfByte);
        if (i <= 0) {
          break;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
      }
      localZipInputStream.closeEntry();
      localFileOutputStream.close();
      break;
      label305:
      localFileInputStream.close();
      localZipInputStream.close();
    }
  }
  
  private static boolean d(String paramString)
  {
    for (;;)
    {
      try
      {
        localFile = new java/io/File;
        localFile.<init>(paramString);
        if (!localFile.isFile()) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramString)
      {
        File localFile;
        boolean bool = false;
        continue;
      }
      return bool;
      bool = localFile.createNewFile();
    }
  }
  
  public static boolean e(String paramString)
  {
    boolean bool2 = false;
    try
    {
      File localFile = new java/io/File;
      localFile.<init>(paramString);
      if (!localFile.exists()) {
        bool1 = localFile.mkdirs();
      }
      for (;;)
      {
        return bool1;
        if (localFile.isDirectory())
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (c(paramString)) {
            bool1 = localFile.mkdirs();
          }
        }
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
  }
  
  public static String f(String paramString)
  {
    String str = Build.CPU_ABI;
    Object localObject = new File(paramString + "/lib");
    if (!((File)localObject).exists())
    {
      localObject = str;
      return (String)localObject;
    }
    paramString = new File(paramString + "lib/libRiskStub.so");
    int i;
    if (!paramString.exists())
    {
      localObject = ((File)localObject).listFiles();
      i = 0;
      label85:
      if (i < localObject.length) {
        if ((localObject[i].getName().endsWith(".so")) && (!localObject[i].getName().contains("DexHelper"))) {
          paramString = new File(localObject[i].getPath());
        }
      }
    }
    for (;;)
    {
      localObject = str;
      if (!paramString.exists()) {
        break;
      }
      for (;;)
      {
        try
        {
          localObject = new com/bangcle/everisk/utils_l/c;
          ((c)localObject).<init>(paramString);
          paramString = new java/lang/StringBuilder;
          paramString.<init>("ARCH: <");
          LibProc.a("RiskStubShell.ABI", ((c)localObject).E().F() + ">");
          if ((((c)localObject).E().F() != 3) && (((c)localObject).E().F() != 62)) {
            continue;
          }
          paramString = "x86";
        }
        catch (Exception paramString)
        {
          LibProc.a(paramString);
          paramString = str;
          continue;
        }
        LibProc.a("RiskStubShell.ABI", "ABI: <" + paramString + ">");
        localObject = paramString;
        break;
        i++;
        break label85;
        if (((c)localObject).E().F() == 40)
        {
          if (str.contains("arm")) {
            continue;
          }
          LibProc.a("RiskStubShell.ABI", "SO is ARM, BUT CPU_ABI is x86. 1");
          paramString = "armeabi";
        }
        else
        {
          paramString = new java/lang/StringBuilder;
          paramString.<init>("other:");
          paramString = ((c)localObject).E().F();
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bangcle\everisk\utils_l\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */