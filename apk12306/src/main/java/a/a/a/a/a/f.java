package a.a.a.a.a;

import android.content.ContentValues;
import android.content.Context;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

class f
{
  private static f b = null;
  private static final String c = "rgid";
  private static final String d = "expires";
  private static final String e = "resource";
  private static final String f = "rid";
  private static final String g = "url";
  private static final String h = "type";
  private static final String i = "width";
  private static final String j = "height";
  cn.domob.android.i.f a = new cn.domob.android.i.f(f.class.getSimpleName());
  private int k = 20;
  private int l = 20;
  private boolean m = true;
  
  protected static f a()
  {
    try
    {
      if (b == null)
      {
        localf = new a/a/a/a/a/f;
        localf.<init>();
        b = localf;
      }
      f localf = b;
      return localf;
    }
    finally {}
  }
  
  private void a(Context paramContext, String paramString, ContentValues paramContentValues)
  {
    b.a(paramContext).a("resourceGroup", paramContentValues, "Rgid = ?", new String[] { paramString });
  }
  
  private void a(File paramFile)
  {
    if (paramFile == null) {}
    for (;;)
    {
      return;
      try
      {
        if (!paramFile.isFile()) {
          break label32;
        }
        paramFile.delete();
      }
      catch (Exception paramFile)
      {
        this.a.a(paramFile);
      }
      continue;
      label32:
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if ((arrayOfFile == null) || (arrayOfFile.length == 0))
        {
          paramFile.delete();
        }
        else
        {
          for (int n = 0; n < arrayOfFile.length; n++) {
            a(arrayOfFile[n]);
          }
          paramFile.delete();
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      a(new File(paramString));
    }
  }
  
  private void h(Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Expires");
    localStringBuffer.append(" != ? and ");
    localStringBuffer.append("Expires");
    localStringBuffer.append(" < ? ");
    int n = a(paramContext, localStringBuffer.toString(), new String[] { String.valueOf(0L), String.valueOf(System.currentTimeMillis()) }, null, 0);
    this.a.b("delete expired group number is " + n);
  }
  
  private void i(Context paramContext)
  {
    a(d.b().b(paramContext));
    b.a(paramContext).b();
  }
  
  private Hashtable<String, String> j(Context paramContext)
  {
    localHashtable = new Hashtable();
    try
    {
      if (d.b().a())
      {
        paramContext = d.b().a(paramContext);
        Object localObject = new java/io/File;
        ((File)localObject).<init>(paramContext);
        if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
        {
          localObject = ((File)localObject).listFiles();
          if (localObject != null) {
            for (int n = 0; n < localObject.length; n++)
            {
              String str = localObject[n].getAbsolutePath();
              if ((str != null) && (str.length() > 0))
              {
                int i1 = str.lastIndexOf("/");
                if ((i1 != -1) && (i1 < str.length() - 1))
                {
                  str = str.substring(i1 + 1);
                  if (str.length() > 0)
                  {
                    StringBuilder localStringBuilder = new java/lang/StringBuilder;
                    localStringBuilder.<init>();
                    localHashtable.put(str, paramContext + "/" + str);
                  }
                }
              }
            }
          }
        }
      }
      return localHashtable;
    }
    catch (Exception paramContext)
    {
      this.a.a(paramContext);
    }
  }
  
  /* Error */
  protected int a(Context paramContext, String paramString1, String[] paramArrayOfString, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 15
    //   6: aconst_null
    //   7: astore 13
    //   9: aconst_null
    //   10: astore 14
    //   12: iconst_0
    //   13: istore 6
    //   15: iconst_0
    //   16: istore 7
    //   18: aload 13
    //   20: astore 11
    //   22: aload_1
    //   23: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   26: ldc 75
    //   28: iconst_1
    //   29: anewarray 79	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc -57
    //   36: aastore
    //   37: aload_2
    //   38: aload_3
    //   39: aload 4
    //   41: aconst_null
    //   42: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_2
    //   46: aload 15
    //   48: astore 4
    //   50: aload_2
    //   51: ifnull +335 -> 386
    //   54: aload 13
    //   56: astore 11
    //   58: aload_2
    //   59: astore 12
    //   61: iload 6
    //   63: istore 7
    //   65: aload_2
    //   66: invokeinterface 207 1 0
    //   71: istore 6
    //   73: aload 13
    //   75: astore 11
    //   77: aload_2
    //   78: astore 12
    //   80: iload 6
    //   82: istore 7
    //   84: aload_2
    //   85: invokeinterface 210 1 0
    //   90: pop
    //   91: aload 13
    //   93: astore 11
    //   95: aload_2
    //   96: astore 12
    //   98: iload 6
    //   100: istore 7
    //   102: aload_2
    //   103: iload 5
    //   105: invokeinterface 214 2 0
    //   110: istore 10
    //   112: iload 10
    //   114: ifne +40 -> 154
    //   117: iconst_0
    //   118: istore 6
    //   120: aload_2
    //   121: ifnull +18 -> 139
    //   124: aload_2
    //   125: invokeinterface 217 1 0
    //   130: ifne +9 -> 139
    //   133: aload_2
    //   134: invokeinterface 220 1 0
    //   139: iconst_0
    //   140: ifeq +11 -> 151
    //   143: new 222	java/lang/NullPointerException
    //   146: dup
    //   147: invokespecial 223	java/lang/NullPointerException:<init>	()V
    //   150: athrow
    //   151: iload 6
    //   153: ireturn
    //   154: iconst_0
    //   155: istore 8
    //   157: aload 14
    //   159: astore_3
    //   160: iload 6
    //   162: istore 7
    //   164: aload_3
    //   165: astore 4
    //   167: aload_3
    //   168: astore 11
    //   170: aload_2
    //   171: astore 12
    //   173: iload 8
    //   175: aload_2
    //   176: invokeinterface 207 1 0
    //   181: iload 5
    //   183: isub
    //   184: if_icmpge +202 -> 386
    //   187: aload_3
    //   188: astore 11
    //   190: aload_2
    //   191: astore 12
    //   193: aload_2
    //   194: aload_2
    //   195: ldc -57
    //   197: invokeinterface 226 2 0
    //   202: invokeinterface 229 2 0
    //   207: astore 13
    //   209: aload_3
    //   210: astore 11
    //   212: aload_2
    //   213: astore 12
    //   215: aload_1
    //   216: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   219: ldc 16
    //   221: iconst_2
    //   222: anewarray 79	java/lang/String
    //   225: dup
    //   226: iconst_0
    //   227: ldc -25
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: ldc -23
    //   234: aastore
    //   235: ldc 77
    //   237: iconst_1
    //   238: anewarray 79	java/lang/String
    //   241: dup
    //   242: iconst_0
    //   243: aload 13
    //   245: aastore
    //   246: aconst_null
    //   247: aconst_null
    //   248: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   251: astore 4
    //   253: aload 4
    //   255: ifnull +115 -> 370
    //   258: aload 4
    //   260: invokeinterface 210 1 0
    //   265: pop
    //   266: iconst_0
    //   267: istore 7
    //   269: iload 7
    //   271: aload 4
    //   273: invokeinterface 207 1 0
    //   278: if_icmpge +47 -> 325
    //   281: aload 4
    //   283: aload 4
    //   285: ldc -25
    //   287: invokeinterface 226 2 0
    //   292: invokeinterface 237 2 0
    //   297: istore 9
    //   299: aload_1
    //   300: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   303: iload 9
    //   305: invokestatic 239	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   308: invokevirtual 240	a/a/a/a/a/b:b	(Ljava/lang/String;)V
    //   311: aload 4
    //   313: invokeinterface 243 1 0
    //   318: pop
    //   319: iinc 7 1
    //   322: goto -53 -> 269
    //   325: new 143	java/lang/StringBuilder
    //   328: astore_3
    //   329: aload_3
    //   330: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   333: aload_0
    //   334: aload_3
    //   335: invokestatic 160	a/a/a/a/a/d:b	()La/a/a/a/a/d;
    //   338: aload_1
    //   339: invokevirtual 175	a/a/a/a/a/d:a	(Landroid/content/Context;)Ljava/lang/String;
    //   342: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc -73
    //   347: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload 13
    //   352: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokespecial 165	a/a/a/a/a/f:a	(Ljava/lang/String;)V
    //   361: aload_1
    //   362: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   365: aload 13
    //   367: invokevirtual 244	a/a/a/a/a/b:a	(Ljava/lang/String;)V
    //   370: aload_2
    //   371: invokeinterface 243 1 0
    //   376: pop
    //   377: iinc 8 1
    //   380: aload 4
    //   382: astore_3
    //   383: goto -223 -> 160
    //   386: aload_2
    //   387: ifnull +18 -> 405
    //   390: aload_2
    //   391: invokeinterface 217 1 0
    //   396: ifne +9 -> 405
    //   399: aload_2
    //   400: invokeinterface 220 1 0
    //   405: iload 7
    //   407: istore 6
    //   409: aload 4
    //   411: ifnull -260 -> 151
    //   414: iload 7
    //   416: istore 6
    //   418: aload 4
    //   420: invokeinterface 217 1 0
    //   425: ifne -274 -> 151
    //   428: aload 4
    //   430: invokeinterface 220 1 0
    //   435: iload 7
    //   437: istore 6
    //   439: goto -288 -> 151
    //   442: astore_3
    //   443: aconst_null
    //   444: astore_1
    //   445: aconst_null
    //   446: astore_2
    //   447: iconst_0
    //   448: istore 5
    //   450: aload_0
    //   451: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   454: aload_3
    //   455: invokevirtual 97	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   458: aload_2
    //   459: ifnull +18 -> 477
    //   462: aload_2
    //   463: invokeinterface 217 1 0
    //   468: ifne +9 -> 477
    //   471: aload_2
    //   472: invokeinterface 220 1 0
    //   477: iload 5
    //   479: istore 6
    //   481: aload_1
    //   482: ifnull -331 -> 151
    //   485: iload 5
    //   487: istore 6
    //   489: aload_1
    //   490: invokeinterface 217 1 0
    //   495: ifne -344 -> 151
    //   498: aload_1
    //   499: invokeinterface 220 1 0
    //   504: iload 5
    //   506: istore 6
    //   508: goto -357 -> 151
    //   511: astore_1
    //   512: aload 12
    //   514: astore_2
    //   515: aload_2
    //   516: ifnull +18 -> 534
    //   519: aload_2
    //   520: invokeinterface 217 1 0
    //   525: ifne +9 -> 534
    //   528: aload_2
    //   529: invokeinterface 220 1 0
    //   534: aload 11
    //   536: ifnull +20 -> 556
    //   539: aload 11
    //   541: invokeinterface 217 1 0
    //   546: ifne +10 -> 556
    //   549: aload 11
    //   551: invokeinterface 220 1 0
    //   556: aload_1
    //   557: athrow
    //   558: astore_1
    //   559: aload 4
    //   561: astore 11
    //   563: goto -48 -> 515
    //   566: astore_3
    //   567: aload_1
    //   568: astore 11
    //   570: aload_3
    //   571: astore_1
    //   572: goto -57 -> 515
    //   575: astore_3
    //   576: aconst_null
    //   577: astore_1
    //   578: iload 7
    //   580: istore 5
    //   582: goto -132 -> 450
    //   585: astore_3
    //   586: aload 4
    //   588: astore_1
    //   589: iload 6
    //   591: istore 5
    //   593: goto -143 -> 450
    //   596: astore_1
    //   597: aload_3
    //   598: astore 4
    //   600: iload 6
    //   602: istore 5
    //   604: aload_1
    //   605: astore_3
    //   606: aload 4
    //   608: astore_1
    //   609: goto -159 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	this	f
    //   0	612	1	paramContext	Context
    //   0	612	2	paramString1	String
    //   0	612	3	paramArrayOfString	String[]
    //   0	612	4	paramString2	String
    //   0	612	5	paramInt	int
    //   13	588	6	n	int
    //   16	563	7	i1	int
    //   155	223	8	i2	int
    //   297	7	9	i3	int
    //   110	3	10	bool	boolean
    //   20	549	11	localObject1	Object
    //   1	512	12	str1	String
    //   7	359	13	str2	String
    //   10	148	14	localObject2	Object
    //   4	43	15	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   22	46	442	java/lang/Exception
    //   22	46	511	finally
    //   65	73	511	finally
    //   84	91	511	finally
    //   102	112	511	finally
    //   173	187	511	finally
    //   193	209	511	finally
    //   215	253	511	finally
    //   258	266	558	finally
    //   269	319	558	finally
    //   325	370	558	finally
    //   370	377	558	finally
    //   450	458	566	finally
    //   65	73	575	java/lang/Exception
    //   84	91	575	java/lang/Exception
    //   102	112	575	java/lang/Exception
    //   258	266	585	java/lang/Exception
    //   269	319	585	java/lang/Exception
    //   325	370	585	java/lang/Exception
    //   370	377	585	java/lang/Exception
    //   173	187	596	java/lang/Exception
    //   193	209	596	java/lang/Exception
    //   215	253	596	java/lang/Exception
  }
  
  /* Error */
  protected g a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +343 -> 344
    //   4: aload_2
    //   5: invokevirtual 110	java/lang/String:length	()I
    //   8: ifle +336 -> 344
    //   11: aload_3
    //   12: ifnull +332 -> 344
    //   15: aload_3
    //   16: invokevirtual 110	java/lang/String:length	()I
    //   19: ifle +325 -> 344
    //   22: aload_1
    //   23: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   26: ldc 16
    //   28: iconst_4
    //   29: anewarray 79	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: ldc -23
    //   36: aastore
    //   37: dup
    //   38: iconst_1
    //   39: ldc -9
    //   41: aastore
    //   42: dup
    //   43: iconst_2
    //   44: ldc -7
    //   46: aastore
    //   47: dup
    //   48: iconst_3
    //   49: ldc -5
    //   51: aastore
    //   52: ldc -3
    //   54: iconst_2
    //   55: anewarray 79	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: aload_2
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload_3
    //   65: aastore
    //   66: aconst_null
    //   67: aconst_null
    //   68: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore 6
    //   73: aload 6
    //   75: ifnull +247 -> 322
    //   78: aload 6
    //   80: astore 7
    //   82: aload 6
    //   84: invokeinterface 210 1 0
    //   89: ifeq +233 -> 322
    //   92: aload 6
    //   94: astore 7
    //   96: aload 6
    //   98: aload 6
    //   100: ldc -23
    //   102: invokeinterface 226 2 0
    //   107: invokeinterface 229 2 0
    //   112: astore 8
    //   114: aload 6
    //   116: astore 7
    //   118: aload_0
    //   119: aload 8
    //   121: aload 6
    //   123: aload 6
    //   125: ldc -9
    //   127: invokeinterface 226 2 0
    //   132: invokeinterface 257 2 0
    //   137: invokevirtual 260	a/a/a/a/a/f:a	(Ljava/lang/String;J)Z
    //   140: ifeq +158 -> 298
    //   143: aload 6
    //   145: astore 7
    //   147: new 262	android/content/ContentValues
    //   150: astore_3
    //   151: aload 6
    //   153: astore 7
    //   155: aload_3
    //   156: invokespecial 263	android/content/ContentValues:<init>	()V
    //   159: aload 6
    //   161: astore 7
    //   163: aload_3
    //   164: ldc_w 265
    //   167: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   170: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   173: invokevirtual 273	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   176: aload 6
    //   178: astore 7
    //   180: aload_0
    //   181: aload_1
    //   182: aload_2
    //   183: aload_3
    //   184: invokespecial 275	a/a/a/a/a/f:a	(Landroid/content/Context;Ljava/lang/String;Landroid/content/ContentValues;)V
    //   187: aload 6
    //   189: astore 7
    //   191: aload 6
    //   193: aload 6
    //   195: ldc -7
    //   197: invokeinterface 226 2 0
    //   202: invokeinterface 237 2 0
    //   207: istore 4
    //   209: aload 6
    //   211: astore 7
    //   213: aload 6
    //   215: aload 6
    //   217: ldc -5
    //   219: invokeinterface 226 2 0
    //   224: invokeinterface 237 2 0
    //   229: istore 5
    //   231: aload 6
    //   233: astore 7
    //   235: new 277	a/a/a/a/a/g
    //   238: astore_1
    //   239: aload 6
    //   241: astore 7
    //   243: aload_1
    //   244: invokespecial 278	a/a/a/a/a/g:<init>	()V
    //   247: aload 6
    //   249: astore 7
    //   251: aload_1
    //   252: aload 8
    //   254: invokevirtual 281	a/a/a/a/a/g:a	(Ljava/lang/String;)La/a/a/a/a/g;
    //   257: iload 4
    //   259: invokevirtual 284	a/a/a/a/a/g:a	(I)La/a/a/a/a/g;
    //   262: iload 5
    //   264: invokevirtual 286	a/a/a/a/a/g:b	(I)La/a/a/a/a/g;
    //   267: astore_1
    //   268: aload_1
    //   269: astore_2
    //   270: aload 6
    //   272: ifnull +24 -> 296
    //   275: aload_1
    //   276: astore_2
    //   277: aload 6
    //   279: invokeinterface 217 1 0
    //   284: ifne +12 -> 296
    //   287: aload 6
    //   289: invokeinterface 220 1 0
    //   294: aload_1
    //   295: astore_2
    //   296: aload_2
    //   297: areturn
    //   298: aload 6
    //   300: astore 7
    //   302: invokestatic 289	a/a/a/a/a/d:c	()La/a/a/a/a/a$b;
    //   305: astore_1
    //   306: aload_1
    //   307: ifnull +15 -> 322
    //   310: aload 6
    //   312: astore 7
    //   314: aload_1
    //   315: aload_2
    //   316: aload_3
    //   317: invokeinterface 294 3 0
    //   322: aload 6
    //   324: ifnull +20 -> 344
    //   327: aload 6
    //   329: invokeinterface 217 1 0
    //   334: ifne +10 -> 344
    //   337: aload 6
    //   339: invokeinterface 220 1 0
    //   344: aconst_null
    //   345: astore_2
    //   346: goto -50 -> 296
    //   349: astore_1
    //   350: aconst_null
    //   351: astore 6
    //   353: aload 6
    //   355: astore 7
    //   357: aload_0
    //   358: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   361: aload_1
    //   362: invokevirtual 97	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   365: aload 6
    //   367: ifnull -23 -> 344
    //   370: aload 6
    //   372: invokeinterface 217 1 0
    //   377: ifne -33 -> 344
    //   380: aload 6
    //   382: invokeinterface 220 1 0
    //   387: goto -43 -> 344
    //   390: astore_1
    //   391: aconst_null
    //   392: astore 7
    //   394: aload 7
    //   396: ifnull +20 -> 416
    //   399: aload 7
    //   401: invokeinterface 217 1 0
    //   406: ifne +10 -> 416
    //   409: aload 7
    //   411: invokeinterface 220 1 0
    //   416: aload_1
    //   417: athrow
    //   418: astore_1
    //   419: goto -25 -> 394
    //   422: astore_1
    //   423: goto -70 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	f
    //   0	426	1	paramContext	Context
    //   0	426	2	paramString1	String
    //   0	426	3	paramString2	String
    //   207	51	4	n	int
    //   229	34	5	i1	int
    //   71	310	6	localCursor1	android.database.Cursor
    //   80	330	7	localCursor2	android.database.Cursor
    //   112	141	8	str	String
    // Exception table:
    //   from	to	target	type
    //   22	73	349	java/lang/Exception
    //   22	73	390	finally
    //   82	92	418	finally
    //   96	114	418	finally
    //   118	143	418	finally
    //   147	151	418	finally
    //   155	159	418	finally
    //   163	176	418	finally
    //   180	187	418	finally
    //   191	209	418	finally
    //   213	231	418	finally
    //   235	239	418	finally
    //   243	247	418	finally
    //   251	268	418	finally
    //   302	306	418	finally
    //   314	322	418	finally
    //   357	365	418	finally
    //   82	92	422	java/lang/Exception
    //   96	114	422	java/lang/Exception
    //   118	143	422	java/lang/Exception
    //   147	151	422	java/lang/Exception
    //   155	159	422	java/lang/Exception
    //   163	176	422	java/lang/Exception
    //   180	187	422	java/lang/Exception
    //   191	209	422	java/lang/Exception
    //   213	231	422	java/lang/Exception
    //   235	239	422	java/lang/Exception
    //   243	247	422	java/lang/Exception
    //   251	268	422	java/lang/Exception
    //   302	306	422	java/lang/Exception
    //   314	322	422	java/lang/Exception
  }
  
  protected void a(Context paramContext, int paramInt)
  {
    this.a.b(String.format("update the max number of group can saved in phone. old value: %d new value: %d", new Object[] { Integer.valueOf(this.l), Integer.valueOf(paramInt) }));
    if ((this.m) || (this.l != paramInt))
    {
      if (paramInt <= 0)
      {
        d.d();
        i(paramContext);
      }
      this.l = paramInt;
      this.m = false;
      c(paramContext);
    }
  }
  
  protected void a(Context paramContext, JSONArray paramJSONArray, String paramString1, String paramString2, String paramString3)
  {
    int n = 0;
    if (paramJSONArray == null)
    {
      this.a.b("ad response cache jsonarray is null");
      return;
    }
    int i1 = 0;
    label21:
    Object localObject1;
    int i2;
    if (i1 < paramJSONArray.length())
    {
      localObject1 = paramJSONArray.optJSONObject(i1);
      if (localObject1 == null) {
        i2 = n;
      }
    }
    for (;;)
    {
      i1++;
      n = i2;
      break label21;
      String str1 = ((JSONObject)localObject1).optString("rgid");
      long l1 = ((JSONObject)localObject1).optLong("expires", -1L);
      localObject1 = ((JSONObject)localObject1).optJSONArray("resource");
      if ((str1 != null) && (str1.length() > 0))
      {
        if (b.a(paramContext).a("resourceGroup", "Rgid = ?", new String[] { str1 }) == 0)
        {
          Object localObject2 = new ContentValues();
          ((ContentValues)localObject2).put("Rgid", str1);
          ((ContentValues)localObject2).put("Expires", Long.valueOf(l1));
          ((ContentValues)localObject2).put("UseDate", Long.valueOf(System.currentTimeMillis()));
          ((ContentValues)localObject2).put("State", Integer.valueOf(0));
          ((ContentValues)localObject2).put("Tracker", paramString1);
          ((ContentValues)localObject2).put("Ppid", paramString2);
          ((ContentValues)localObject2).put("EventTrackerURL", paramString3);
          i2 = n;
          if (b.a(paramContext).a("resourceGroup", (ContentValues)localObject2))
          {
            i2 = n;
            if (localObject1 != null)
            {
              i2 = 0;
              while (i2 < ((JSONArray)localObject1).length())
              {
                Object localObject3 = ((JSONArray)localObject1).optJSONObject(i2);
                int i3 = n;
                if (localObject3 != null)
                {
                  String str2 = ((JSONObject)localObject3).optString("rid");
                  localObject2 = ((JSONObject)localObject3).optString("url");
                  int i4 = ((JSONObject)localObject3).optInt("type", 0);
                  int i6 = ((JSONObject)localObject3).optInt("width", 0);
                  int i5 = ((JSONObject)localObject3).optInt("height", 0);
                  i3 = n;
                  if (str2 != null)
                  {
                    i3 = n;
                    if (str2.length() > 0)
                    {
                      localObject3 = new c();
                      ((c)localObject3).a(str2);
                      ((c)localObject3).b(str1);
                      ((c)localObject3).a(i4);
                      ((c)localObject3).c((String)localObject2);
                      ((c)localObject3).b(0);
                      ((c)localObject3).c(i6);
                      ((c)localObject3).d(i5);
                      i3 = n;
                      if (b.a(paramContext).a((c)localObject3)) {
                        i3 = n + 1;
                      }
                    }
                  }
                }
                i2++;
                n = i3;
              }
            }
          }
        }
        else
        {
          this.a.b("this groupID has been saved in DB");
          i2 = n;
        }
      }
      else
      {
        this.a.d("cache groupID is not available");
        i2 = n;
        continue;
        if (n > 0) {
          d.b().d(paramContext);
        }
        a().g(paramContext);
        break;
        i2 = n;
      }
    }
  }
  
  protected boolean a(Context paramContext)
  {
    if (this.k > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((bool) || (!bool)) {}
      return bool;
    }
  }
  
  /* Error */
  protected boolean a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   4: ldc 16
    //   6: iconst_3
    //   7: anewarray 79	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc -23
    //   14: aastore
    //   15: dup
    //   16: iconst_1
    //   17: ldc -9
    //   19: aastore
    //   20: dup
    //   21: iconst_2
    //   22: ldc -25
    //   24: aastore
    //   25: ldc_w 396
    //   28: iconst_1
    //   29: anewarray 79	java/lang/String
    //   32: dup
    //   33: iconst_0
    //   34: aload_2
    //   35: aastore
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 8
    //   43: aload 8
    //   45: ifnull +223 -> 268
    //   48: aload 8
    //   50: astore 7
    //   52: aload 8
    //   54: invokeinterface 210 1 0
    //   59: ifeq +209 -> 268
    //   62: iconst_0
    //   63: istore_3
    //   64: iconst_1
    //   65: istore 6
    //   67: iload 6
    //   69: istore 5
    //   71: aload 8
    //   73: astore 7
    //   75: iload_3
    //   76: aload 8
    //   78: invokeinterface 207 1 0
    //   83: if_icmpge +188 -> 271
    //   86: aload 8
    //   88: astore 7
    //   90: aload 8
    //   92: aload 8
    //   94: ldc -23
    //   96: invokeinterface 226 2 0
    //   101: invokeinterface 229 2 0
    //   106: astore 9
    //   108: aload 8
    //   110: astore 7
    //   112: aload_0
    //   113: aload 9
    //   115: aload 8
    //   117: aload 8
    //   119: ldc -9
    //   121: invokeinterface 226 2 0
    //   126: invokeinterface 257 2 0
    //   131: invokevirtual 260	a/a/a/a/a/f:a	(Ljava/lang/String;J)Z
    //   134: ifne +116 -> 250
    //   137: aload 8
    //   139: astore 7
    //   141: aload_0
    //   142: aload 9
    //   144: invokespecial 165	a/a/a/a/a/f:a	(Ljava/lang/String;)V
    //   147: aload 8
    //   149: astore 7
    //   151: aload 8
    //   153: aload 8
    //   155: ldc -25
    //   157: invokeinterface 226 2 0
    //   162: invokeinterface 237 2 0
    //   167: istore 4
    //   169: aload 8
    //   171: astore 7
    //   173: new 262	android/content/ContentValues
    //   176: astore 9
    //   178: aload 8
    //   180: astore 7
    //   182: aload 9
    //   184: invokespecial 263	android/content/ContentValues:<init>	()V
    //   187: aload 8
    //   189: astore 7
    //   191: aload 9
    //   193: ldc -23
    //   195: ldc_w 398
    //   198: invokevirtual 343	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload 8
    //   203: astore 7
    //   205: aload 9
    //   207: ldc -9
    //   209: lconst_0
    //   210: invokestatic 270	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   213: invokevirtual 273	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   216: aload 8
    //   218: astore 7
    //   220: aload_1
    //   221: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   224: ldc 16
    //   226: aload 9
    //   228: ldc_w 400
    //   231: iconst_1
    //   232: anewarray 79	java/lang/String
    //   235: dup
    //   236: iconst_0
    //   237: iload 4
    //   239: invokestatic 239	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   242: aastore
    //   243: invokevirtual 82	a/a/a/a/a/b:a	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   246: pop
    //   247: iconst_0
    //   248: istore 6
    //   250: aload 8
    //   252: astore 7
    //   254: aload 8
    //   256: invokeinterface 243 1 0
    //   261: pop
    //   262: iinc 3 1
    //   265: goto -198 -> 67
    //   268: iconst_1
    //   269: istore 5
    //   271: aload 8
    //   273: ifnull +153 -> 426
    //   276: aload 8
    //   278: invokeinterface 217 1 0
    //   283: ifne +143 -> 426
    //   286: aload 8
    //   288: invokeinterface 220 1 0
    //   293: iload 5
    //   295: ifeq +111 -> 406
    //   298: iconst_1
    //   299: istore_3
    //   300: new 262	android/content/ContentValues
    //   303: dup
    //   304: invokespecial 263	android/content/ContentValues:<init>	()V
    //   307: astore 7
    //   309: aload 7
    //   311: ldc_w 345
    //   314: iload_3
    //   315: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   318: invokevirtual 348	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   321: aload_0
    //   322: aload_1
    //   323: aload_2
    //   324: aload 7
    //   326: invokespecial 275	a/a/a/a/a/f:a	(Landroid/content/Context;Ljava/lang/String;Landroid/content/ContentValues;)V
    //   329: iload 5
    //   331: ireturn
    //   332: astore 9
    //   334: aconst_null
    //   335: astore 8
    //   337: aload 8
    //   339: astore 7
    //   341: aload_0
    //   342: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   345: aload 9
    //   347: invokevirtual 97	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   350: aload 8
    //   352: ifnull +68 -> 420
    //   355: aload 8
    //   357: invokeinterface 217 1 0
    //   362: ifne +58 -> 420
    //   365: aload 8
    //   367: invokeinterface 220 1 0
    //   372: iconst_0
    //   373: istore 5
    //   375: goto -82 -> 293
    //   378: astore_1
    //   379: aconst_null
    //   380: astore 7
    //   382: aload 7
    //   384: ifnull +20 -> 404
    //   387: aload 7
    //   389: invokeinterface 217 1 0
    //   394: ifne +10 -> 404
    //   397: aload 7
    //   399: invokeinterface 220 1 0
    //   404: aload_1
    //   405: athrow
    //   406: iconst_0
    //   407: istore_3
    //   408: goto -108 -> 300
    //   411: astore_1
    //   412: goto -30 -> 382
    //   415: astore 9
    //   417: goto -80 -> 337
    //   420: iconst_0
    //   421: istore 5
    //   423: goto -130 -> 293
    //   426: goto -133 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	f
    //   0	429	1	paramContext	Context
    //   0	429	2	paramString	String
    //   63	345	3	n	int
    //   167	71	4	i1	int
    //   69	353	5	bool1	boolean
    //   65	184	6	bool2	boolean
    //   50	348	7	localObject1	Object
    //   41	325	8	localCursor	android.database.Cursor
    //   106	121	9	localObject2	Object
    //   332	14	9	localException1	Exception
    //   415	1	9	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	43	332	java/lang/Exception
    //   0	43	378	finally
    //   52	62	411	finally
    //   75	86	411	finally
    //   90	108	411	finally
    //   112	137	411	finally
    //   141	147	411	finally
    //   151	169	411	finally
    //   173	178	411	finally
    //   182	187	411	finally
    //   191	201	411	finally
    //   205	216	411	finally
    //   220	247	411	finally
    //   254	262	411	finally
    //   341	350	411	finally
    //   52	62	415	java/lang/Exception
    //   75	86	415	java/lang/Exception
    //   90	108	415	java/lang/Exception
    //   112	137	415	java/lang/Exception
    //   141	147	415	java/lang/Exception
    //   151	169	415	java/lang/Exception
    //   173	178	415	java/lang/Exception
    //   182	187	415	java/lang/Exception
    //   191	201	415	java/lang/Exception
    //   205	216	415	java/lang/Exception
    //   220	247	415	java/lang/Exception
    //   254	262	415	java/lang/Exception
  }
  
  protected boolean a(String paramString, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() != 0)
      {
        bool1 = bool2;
        if (!paramString.equals("empty"))
        {
          if (paramLong > 0L) {
            break label49;
          }
          bool1 = bool2;
        }
      }
    }
    for (;;)
    {
      return bool1;
      try
      {
        label49:
        File localFile = new java/io/File;
        localFile.<init>(paramString);
        bool1 = bool2;
        if (localFile.exists())
        {
          long l1 = localFile.length();
          bool1 = bool2;
          if (l1 == paramLong) {
            bool1 = true;
          }
        }
      }
      catch (Exception paramString)
      {
        this.a.a(paramString);
        bool1 = bool2;
      }
    }
  }
  
  protected int b()
  {
    return this.l;
  }
  
  /* Error */
  protected String b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 392	a/a/a/a/a/f:g	(Landroid/content/Context;)V
    //   5: new 114	java/lang/StringBuffer
    //   8: dup
    //   9: invokespecial 115	java/lang/StringBuffer:<init>	()V
    //   12: astore 6
    //   14: aload 6
    //   16: ldc_w 408
    //   19: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   22: pop
    //   23: aload 6
    //   25: ldc 117
    //   27: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   30: pop
    //   31: aload 6
    //   33: ldc_w 410
    //   36: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   39: pop
    //   40: aload 6
    //   42: ldc 117
    //   44: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   47: pop
    //   48: aload 6
    //   50: ldc_w 412
    //   53: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   56: pop
    //   57: aload 6
    //   59: ldc_w 345
    //   62: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   65: pop
    //   66: aload 6
    //   68: ldc_w 414
    //   71: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   74: pop
    //   75: aload 6
    //   77: invokevirtual 128	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   80: astore 6
    //   82: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   85: lstore 4
    //   87: new 114	java/lang/StringBuffer
    //   90: dup
    //   91: invokespecial 115	java/lang/StringBuffer:<init>	()V
    //   94: astore 7
    //   96: aload_1
    //   97: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   100: ldc 75
    //   102: iconst_1
    //   103: anewarray 79	java/lang/String
    //   106: dup
    //   107: iconst_0
    //   108: ldc -57
    //   110: aastore
    //   111: aload 6
    //   113: iconst_3
    //   114: anewarray 79	java/lang/String
    //   117: dup
    //   118: iconst_0
    //   119: lconst_0
    //   120: invokestatic 132	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: lload 4
    //   128: invokestatic 132	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   131: aastore
    //   132: dup
    //   133: iconst_2
    //   134: iconst_1
    //   135: invokestatic 239	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   138: aastore
    //   139: ldc_w 416
    //   142: aconst_null
    //   143: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   146: astore 6
    //   148: aload 6
    //   150: ifnull +157 -> 307
    //   153: aload 6
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   160: ldc_w 418
    //   163: iconst_2
    //   164: anewarray 4	java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: aload 6
    //   171: invokeinterface 207 1 0
    //   176: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: aload_0
    //   183: getfield 61	a/a/a/a/a/f:k	I
    //   186: invokestatic 302	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: invokestatic 306	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   193: invokevirtual 155	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   196: aload 6
    //   198: astore_1
    //   199: aload 6
    //   201: invokeinterface 207 1 0
    //   206: aload_0
    //   207: getfield 61	a/a/a/a/a/f:k	I
    //   210: if_icmple +83 -> 293
    //   213: aload 6
    //   215: astore_1
    //   216: aload_0
    //   217: getfield 61	a/a/a/a/a/f:k	I
    //   220: istore_2
    //   221: aload 6
    //   223: astore_1
    //   224: aload 6
    //   226: invokeinterface 210 1 0
    //   231: pop
    //   232: iconst_0
    //   233: istore_3
    //   234: iload_3
    //   235: iload_2
    //   236: if_icmpge +71 -> 307
    //   239: aload 6
    //   241: astore_1
    //   242: aload 7
    //   244: aload 6
    //   246: aload 6
    //   248: ldc -57
    //   250: invokeinterface 226 2 0
    //   255: invokeinterface 229 2 0
    //   260: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   263: pop
    //   264: aload 6
    //   266: astore_1
    //   267: aload 7
    //   269: ldc_w 420
    //   272: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   275: pop
    //   276: aload 6
    //   278: astore_1
    //   279: aload 6
    //   281: invokeinterface 243 1 0
    //   286: pop
    //   287: iinc 3 1
    //   290: goto -56 -> 234
    //   293: aload 6
    //   295: astore_1
    //   296: aload 6
    //   298: invokeinterface 207 1 0
    //   303: istore_2
    //   304: goto -83 -> 221
    //   307: aload 6
    //   309: ifnull +20 -> 329
    //   312: aload 6
    //   314: invokeinterface 217 1 0
    //   319: ifne +10 -> 329
    //   322: aload 6
    //   324: invokeinterface 220 1 0
    //   329: aload 7
    //   331: invokevirtual 421	java/lang/StringBuffer:length	()I
    //   334: ifle +105 -> 439
    //   337: aload 7
    //   339: invokevirtual 128	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   342: astore_1
    //   343: aload_1
    //   344: iconst_0
    //   345: aload_1
    //   346: invokevirtual 110	java/lang/String:length	()I
    //   349: iconst_1
    //   350: isub
    //   351: invokevirtual 424	java/lang/String:substring	(II)Ljava/lang/String;
    //   354: astore_1
    //   355: aload_1
    //   356: areturn
    //   357: astore 7
    //   359: aconst_null
    //   360: astore 6
    //   362: aload 6
    //   364: astore_1
    //   365: aload_0
    //   366: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   369: aload 7
    //   371: invokevirtual 97	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   374: ldc_w 426
    //   377: astore 7
    //   379: aload 7
    //   381: astore_1
    //   382: aload 6
    //   384: ifnull -29 -> 355
    //   387: aload 7
    //   389: astore_1
    //   390: aload 6
    //   392: invokeinterface 217 1 0
    //   397: ifne -42 -> 355
    //   400: aload 6
    //   402: invokeinterface 220 1 0
    //   407: aload 7
    //   409: astore_1
    //   410: goto -55 -> 355
    //   413: astore 6
    //   415: aconst_null
    //   416: astore_1
    //   417: aload_1
    //   418: ifnull +18 -> 436
    //   421: aload_1
    //   422: invokeinterface 217 1 0
    //   427: ifne +9 -> 436
    //   430: aload_1
    //   431: invokeinterface 220 1 0
    //   436: aload 6
    //   438: athrow
    //   439: ldc_w 426
    //   442: astore_1
    //   443: goto -88 -> 355
    //   446: astore 6
    //   448: goto -31 -> 417
    //   451: astore 7
    //   453: goto -91 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	456	0	this	f
    //   0	456	1	paramContext	Context
    //   220	84	2	n	int
    //   233	55	3	i1	int
    //   85	42	4	l1	long
    //   12	389	6	localObject1	Object
    //   413	24	6	localObject2	Object
    //   446	1	6	localObject3	Object
    //   94	244	7	localStringBuffer	StringBuffer
    //   357	13	7	localException1	Exception
    //   377	31	7	str	String
    //   451	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   96	148	357	java/lang/Exception
    //   96	148	413	finally
    //   156	196	446	finally
    //   199	213	446	finally
    //   216	221	446	finally
    //   224	232	446	finally
    //   242	264	446	finally
    //   267	276	446	finally
    //   279	287	446	finally
    //   296	304	446	finally
    //   365	374	446	finally
    //   156	196	451	java/lang/Exception
    //   199	213	451	java/lang/Exception
    //   216	221	451	java/lang/Exception
    //   224	232	451	java/lang/Exception
    //   242	264	451	java/lang/Exception
    //   267	276	451	java/lang/Exception
    //   279	287	451	java/lang/Exception
    //   296	304	451	java/lang/Exception
  }
  
  /* Error */
  protected boolean b(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   4: ldc 75
    //   6: iconst_1
    //   7: anewarray 79	java/lang/String
    //   10: dup
    //   11: iconst_0
    //   12: ldc -25
    //   14: aastore
    //   15: ldc_w 396
    //   18: iconst_1
    //   19: anewarray 79	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: aload_2
    //   25: aastore
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +41 -> 74
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: invokeinterface 207 1 0
    //   44: istore_3
    //   45: iload_3
    //   46: ifle +28 -> 74
    //   49: aload_2
    //   50: ifnull +18 -> 68
    //   53: aload_2
    //   54: invokeinterface 217 1 0
    //   59: ifne +9 -> 68
    //   62: aload_2
    //   63: invokeinterface 220 1 0
    //   68: iconst_1
    //   69: istore 4
    //   71: iload 4
    //   73: ireturn
    //   74: aload_2
    //   75: ifnull +18 -> 93
    //   78: aload_2
    //   79: invokeinterface 217 1 0
    //   84: ifne +9 -> 93
    //   87: aload_2
    //   88: invokeinterface 220 1 0
    //   93: iconst_0
    //   94: istore 4
    //   96: goto -25 -> 71
    //   99: astore 5
    //   101: aconst_null
    //   102: astore_2
    //   103: aload_2
    //   104: astore_1
    //   105: aload_0
    //   106: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   109: aload 5
    //   111: invokevirtual 97	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   114: aload_2
    //   115: ifnull -22 -> 93
    //   118: aload_2
    //   119: invokeinterface 217 1 0
    //   124: ifne -31 -> 93
    //   127: aload_2
    //   128: invokeinterface 220 1 0
    //   133: goto -40 -> 93
    //   136: astore_1
    //   137: aconst_null
    //   138: astore 5
    //   140: aload_1
    //   141: astore_2
    //   142: aload 5
    //   144: ifnull +20 -> 164
    //   147: aload 5
    //   149: invokeinterface 217 1 0
    //   154: ifne +10 -> 164
    //   157: aload 5
    //   159: invokeinterface 220 1 0
    //   164: aload_2
    //   165: athrow
    //   166: astore_2
    //   167: aload_1
    //   168: astore 5
    //   170: goto -28 -> 142
    //   173: astore 5
    //   175: goto -72 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	f
    //   0	178	1	paramContext	Context
    //   0	178	2	paramString	String
    //   44	2	3	n	int
    //   69	26	4	bool	boolean
    //   99	11	5	localException1	Exception
    //   138	31	5	localContext	Context
    //   173	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	32	99	java/lang/Exception
    //   0	32	136	finally
    //   38	45	166	finally
    //   105	114	166	finally
    //   38	45	173	java/lang/Exception
  }
  
  protected void c(Context paramContext)
  {
    h(paramContext);
    d(paramContext);
  }
  
  protected void d(Context paramContext)
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("State");
    ((StringBuffer)localObject).append(" = ?");
    localObject = ((StringBuffer)localObject).toString();
    int n = this.l;
    n = a(paramContext, (String)localObject, new String[] { String.valueOf(1) }, "UseDate DESC", n);
    this.a.b("delete excess group number is " + n);
  }
  
  /* Error */
  protected boolean e(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   6: ldc_w 433
    //   9: invokevirtual 155	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   12: invokestatic 138	java/lang/System:currentTimeMillis	()J
    //   15: lstore 6
    //   17: aload_1
    //   18: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   21: ldc 75
    //   23: iconst_1
    //   24: anewarray 79	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: ldc -57
    //   31: aastore
    //   32: ldc_w 435
    //   35: iconst_2
    //   36: anewarray 79	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: lload 6
    //   43: invokestatic 132	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: lconst_0
    //   50: invokestatic 132	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: aastore
    //   54: aconst_null
    //   55: aconst_null
    //   56: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   59: astore 8
    //   61: aload 8
    //   63: ifnull +241 -> 304
    //   66: aload 8
    //   68: invokeinterface 210 1 0
    //   73: istore_3
    //   74: iload_3
    //   75: ifeq +229 -> 304
    //   78: iconst_0
    //   79: istore_3
    //   80: iload_3
    //   81: istore 5
    //   83: iload_2
    //   84: aload 8
    //   86: invokeinterface 207 1 0
    //   91: if_icmpge +57 -> 148
    //   94: iload_3
    //   95: istore 4
    //   97: iload_3
    //   98: istore 5
    //   100: aload_0
    //   101: aload_1
    //   102: aload 8
    //   104: aload 8
    //   106: ldc -57
    //   108: invokeinterface 226 2 0
    //   113: invokeinterface 229 2 0
    //   118: invokevirtual 437	a/a/a/a/a/f:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   121: ifne +6 -> 127
    //   124: iconst_1
    //   125: istore 4
    //   127: iload 4
    //   129: istore 5
    //   131: aload 8
    //   133: invokeinterface 243 1 0
    //   138: pop
    //   139: iinc 2 1
    //   142: iload 4
    //   144: istore_3
    //   145: goto -65 -> 80
    //   148: iload_3
    //   149: istore 4
    //   151: aload 8
    //   153: ifnull +26 -> 179
    //   156: iload_3
    //   157: istore 4
    //   159: aload 8
    //   161: invokeinterface 217 1 0
    //   166: ifne +13 -> 179
    //   169: aload 8
    //   171: invokeinterface 220 1 0
    //   176: iload_3
    //   177: istore 4
    //   179: iload 4
    //   181: ireturn
    //   182: astore 8
    //   184: aconst_null
    //   185: astore_1
    //   186: iconst_0
    //   187: istore_3
    //   188: aload_0
    //   189: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   192: aload 8
    //   194: invokevirtual 97	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   197: iload_3
    //   198: istore 4
    //   200: aload_1
    //   201: ifnull -22 -> 179
    //   204: iload_3
    //   205: istore 4
    //   207: aload_1
    //   208: invokeinterface 217 1 0
    //   213: ifne -34 -> 179
    //   216: aload_1
    //   217: invokeinterface 220 1 0
    //   222: iload_3
    //   223: istore 4
    //   225: goto -46 -> 179
    //   228: astore_1
    //   229: aconst_null
    //   230: astore 8
    //   232: aload 8
    //   234: ifnull +20 -> 254
    //   237: aload 8
    //   239: invokeinterface 217 1 0
    //   244: ifne +10 -> 254
    //   247: aload 8
    //   249: invokeinterface 220 1 0
    //   254: aload_1
    //   255: athrow
    //   256: astore_1
    //   257: goto -25 -> 232
    //   260: astore 8
    //   262: aload_1
    //   263: astore 9
    //   265: aload 8
    //   267: astore_1
    //   268: aload 9
    //   270: astore 8
    //   272: goto -40 -> 232
    //   275: astore 9
    //   277: aload 8
    //   279: astore_1
    //   280: aload 9
    //   282: astore 8
    //   284: iconst_0
    //   285: istore_3
    //   286: goto -98 -> 188
    //   289: astore 9
    //   291: iload 5
    //   293: istore_3
    //   294: aload 8
    //   296: astore_1
    //   297: aload 9
    //   299: astore 8
    //   301: goto -113 -> 188
    //   304: iconst_0
    //   305: istore_3
    //   306: goto -158 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	f
    //   0	309	1	paramContext	Context
    //   1	139	2	n	int
    //   73	233	3	bool1	boolean
    //   95	129	4	bool2	boolean
    //   81	211	5	bool3	boolean
    //   15	27	6	l1	long
    //   59	111	8	localCursor	android.database.Cursor
    //   182	11	8	localException1	Exception
    //   230	18	8	localObject1	Object
    //   260	6	8	localObject2	Object
    //   270	30	8	localObject3	Object
    //   263	6	9	localContext	Context
    //   275	6	9	localException2	Exception
    //   289	9	9	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   17	61	182	java/lang/Exception
    //   17	61	228	finally
    //   66	74	256	finally
    //   83	94	256	finally
    //   100	124	256	finally
    //   131	139	256	finally
    //   188	197	260	finally
    //   66	74	275	java/lang/Exception
    //   83	94	289	java/lang/Exception
    //   100	124	289	java/lang/Exception
    //   131	139	289	java/lang/Exception
  }
  
  protected void f(Context paramContext)
  {
    Hashtable localHashtable = j(paramContext);
    Iterator localIterator = localHashtable.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!b(paramContext, str)) {
        a((String)localHashtable.get(str));
      }
    }
  }
  
  /* Error */
  protected void g(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   4: invokevirtual 465	cn/domob/android/i/f:a	()Z
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_1
    //   12: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   15: ldc 75
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: aconst_null
    //   21: aconst_null
    //   22: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   25: astore 8
    //   27: aload_0
    //   28: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   31: astore 10
    //   33: new 143	java/lang/StringBuilder
    //   36: astore 9
    //   38: aload 9
    //   40: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   43: aload 10
    //   45: aload 9
    //   47: ldc_w 467
    //   50: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 8
    //   55: invokeinterface 207 1 0
    //   60: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 155	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   69: aload 8
    //   71: ifnull +373 -> 444
    //   74: aload 8
    //   76: invokeinterface 210 1 0
    //   81: ifeq +363 -> 444
    //   84: iconst_0
    //   85: istore_2
    //   86: iload_2
    //   87: aload 8
    //   89: invokeinterface 207 1 0
    //   94: if_icmpge +350 -> 444
    //   97: new 114	java/lang/StringBuffer
    //   100: astore 13
    //   102: aload 13
    //   104: invokespecial 115	java/lang/StringBuffer:<init>	()V
    //   107: aload 8
    //   109: aload 8
    //   111: ldc -57
    //   113: invokeinterface 226 2 0
    //   118: invokeinterface 229 2 0
    //   123: astore 12
    //   125: aload 8
    //   127: aload 8
    //   129: ldc 117
    //   131: invokeinterface 226 2 0
    //   136: invokeinterface 257 2 0
    //   141: lstore 6
    //   143: aload 8
    //   145: aload 8
    //   147: ldc_w 265
    //   150: invokeinterface 226 2 0
    //   155: invokeinterface 257 2 0
    //   160: lstore 4
    //   162: aload 8
    //   164: aload 8
    //   166: ldc_w 345
    //   169: invokeinterface 226 2 0
    //   174: invokeinterface 237 2 0
    //   179: istore_3
    //   180: aload 8
    //   182: aload 8
    //   184: ldc_w 352
    //   187: invokeinterface 226 2 0
    //   192: invokeinterface 229 2 0
    //   197: astore 10
    //   199: aload 8
    //   201: aload 8
    //   203: ldc_w 350
    //   206: invokeinterface 226 2 0
    //   211: invokeinterface 229 2 0
    //   216: astore 9
    //   218: aload 8
    //   220: aload 8
    //   222: ldc_w 354
    //   225: invokeinterface 226 2 0
    //   230: invokeinterface 229 2 0
    //   235: astore 11
    //   237: aload 13
    //   239: ldc_w 469
    //   242: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   245: pop
    //   246: aload 13
    //   248: aload 12
    //   250: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   253: pop
    //   254: aload 13
    //   256: ldc_w 471
    //   259: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   262: pop
    //   263: aload 13
    //   265: ldc_w 473
    //   268: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   271: pop
    //   272: aload 13
    //   274: lload 6
    //   276: invokevirtual 476	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   279: pop
    //   280: aload 13
    //   282: ldc_w 471
    //   285: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   288: pop
    //   289: aload 13
    //   291: ldc_w 478
    //   294: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   297: pop
    //   298: aload 13
    //   300: lload 4
    //   302: invokevirtual 476	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   305: pop
    //   306: aload 13
    //   308: ldc_w 471
    //   311: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   314: pop
    //   315: aload 13
    //   317: ldc_w 480
    //   320: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   323: pop
    //   324: aload 13
    //   326: iload_3
    //   327: invokevirtual 483	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   330: pop
    //   331: aload 13
    //   333: ldc_w 471
    //   336: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   339: pop
    //   340: aload 13
    //   342: ldc_w 485
    //   345: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   348: pop
    //   349: aload 13
    //   351: aload 10
    //   353: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   356: pop
    //   357: aload 13
    //   359: ldc_w 471
    //   362: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   365: pop
    //   366: aload 13
    //   368: ldc_w 487
    //   371: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   374: pop
    //   375: aload 13
    //   377: aload 9
    //   379: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   382: pop
    //   383: aload 13
    //   385: ldc_w 471
    //   388: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   391: pop
    //   392: aload 13
    //   394: ldc_w 489
    //   397: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   400: pop
    //   401: aload 13
    //   403: aload 11
    //   405: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   408: pop
    //   409: aload 13
    //   411: ldc_w 471
    //   414: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   417: pop
    //   418: aload_0
    //   419: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   422: aload 13
    //   424: invokevirtual 128	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   427: invokevirtual 490	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   430: aload 8
    //   432: invokeinterface 243 1 0
    //   437: pop
    //   438: iinc 2 1
    //   441: goto -355 -> 86
    //   444: aload 8
    //   446: ifnull +20 -> 466
    //   449: aload 8
    //   451: invokeinterface 217 1 0
    //   456: ifne +10 -> 466
    //   459: aload 8
    //   461: invokeinterface 220 1 0
    //   466: aload_1
    //   467: invokestatic 73	a/a/a/a/a/b:a	(Landroid/content/Context;)La/a/a/a/a/b;
    //   470: ldc 16
    //   472: aconst_null
    //   473: aconst_null
    //   474: aconst_null
    //   475: aconst_null
    //   476: aconst_null
    //   477: invokevirtual 202	a/a/a/a/a/b:a	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   480: astore_1
    //   481: aload_1
    //   482: astore 8
    //   484: aload_0
    //   485: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   488: astore 9
    //   490: aload_1
    //   491: astore 8
    //   493: new 143	java/lang/StringBuilder
    //   496: astore 10
    //   498: aload_1
    //   499: astore 8
    //   501: aload 10
    //   503: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   506: aload_1
    //   507: astore 8
    //   509: aload 9
    //   511: aload 10
    //   513: ldc_w 492
    //   516: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: aload_1
    //   520: invokeinterface 207 1 0
    //   525: invokevirtual 152	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   528: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokevirtual 155	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   534: aload_1
    //   535: ifnull +526 -> 1061
    //   538: aload_1
    //   539: astore 8
    //   541: aload_1
    //   542: invokeinterface 210 1 0
    //   547: ifeq +514 -> 1061
    //   550: iconst_0
    //   551: istore_2
    //   552: aload_1
    //   553: astore 8
    //   555: iload_2
    //   556: aload_1
    //   557: invokeinterface 207 1 0
    //   562: if_icmpge +499 -> 1061
    //   565: aload_1
    //   566: astore 8
    //   568: new 114	java/lang/StringBuffer
    //   571: astore 17
    //   573: aload_1
    //   574: astore 8
    //   576: aload 17
    //   578: invokespecial 115	java/lang/StringBuffer:<init>	()V
    //   581: aload_1
    //   582: astore 8
    //   584: aload_1
    //   585: aload_1
    //   586: ldc_w 494
    //   589: invokeinterface 226 2 0
    //   594: invokeinterface 229 2 0
    //   599: astore 13
    //   601: aload_1
    //   602: astore 8
    //   604: aload_1
    //   605: aload_1
    //   606: ldc -57
    //   608: invokeinterface 226 2 0
    //   613: invokeinterface 229 2 0
    //   618: astore 12
    //   620: aload_1
    //   621: astore 8
    //   623: aload_1
    //   624: aload_1
    //   625: ldc_w 496
    //   628: invokeinterface 226 2 0
    //   633: invokeinterface 229 2 0
    //   638: astore 14
    //   640: aload_1
    //   641: astore 8
    //   643: aload_1
    //   644: aload_1
    //   645: ldc_w 498
    //   648: invokeinterface 226 2 0
    //   653: invokeinterface 229 2 0
    //   658: astore 9
    //   660: aload_1
    //   661: astore 8
    //   663: aload_1
    //   664: aload_1
    //   665: ldc -23
    //   667: invokeinterface 226 2 0
    //   672: invokeinterface 229 2 0
    //   677: astore 11
    //   679: aload_1
    //   680: astore 8
    //   682: aload_1
    //   683: aload_1
    //   684: ldc_w 500
    //   687: invokeinterface 226 2 0
    //   692: invokeinterface 229 2 0
    //   697: astore 16
    //   699: aload_1
    //   700: astore 8
    //   702: aload_1
    //   703: aload_1
    //   704: ldc -9
    //   706: invokeinterface 226 2 0
    //   711: invokeinterface 229 2 0
    //   716: astore 10
    //   718: aload_1
    //   719: astore 8
    //   721: aload_1
    //   722: aload_1
    //   723: ldc_w 502
    //   726: invokeinterface 226 2 0
    //   731: invokeinterface 229 2 0
    //   736: astore 15
    //   738: aload_1
    //   739: astore 8
    //   741: aload 17
    //   743: ldc_w 504
    //   746: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   749: pop
    //   750: aload_1
    //   751: astore 8
    //   753: aload 17
    //   755: aload 13
    //   757: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   760: pop
    //   761: aload_1
    //   762: astore 8
    //   764: aload 17
    //   766: ldc_w 471
    //   769: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   772: pop
    //   773: aload_1
    //   774: astore 8
    //   776: aload 17
    //   778: ldc_w 469
    //   781: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   784: pop
    //   785: aload_1
    //   786: astore 8
    //   788: aload 17
    //   790: aload 12
    //   792: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   795: pop
    //   796: aload_1
    //   797: astore 8
    //   799: aload 17
    //   801: ldc_w 471
    //   804: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   807: pop
    //   808: aload_1
    //   809: astore 8
    //   811: aload 17
    //   813: ldc_w 506
    //   816: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   819: pop
    //   820: aload_1
    //   821: astore 8
    //   823: aload 17
    //   825: aload 14
    //   827: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   830: pop
    //   831: aload_1
    //   832: astore 8
    //   834: aload 17
    //   836: ldc_w 471
    //   839: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   842: pop
    //   843: aload_1
    //   844: astore 8
    //   846: aload 17
    //   848: ldc_w 508
    //   851: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   854: pop
    //   855: aload_1
    //   856: astore 8
    //   858: aload 17
    //   860: aload 9
    //   862: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   865: pop
    //   866: aload_1
    //   867: astore 8
    //   869: aload 17
    //   871: ldc_w 471
    //   874: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   877: pop
    //   878: aload_1
    //   879: astore 8
    //   881: aload 17
    //   883: ldc_w 510
    //   886: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   889: pop
    //   890: aload_1
    //   891: astore 8
    //   893: aload 17
    //   895: aload 11
    //   897: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   900: pop
    //   901: aload_1
    //   902: astore 8
    //   904: aload 17
    //   906: ldc_w 471
    //   909: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   912: pop
    //   913: aload_1
    //   914: astore 8
    //   916: aload 17
    //   918: ldc_w 512
    //   921: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   924: pop
    //   925: aload_1
    //   926: astore 8
    //   928: aload 17
    //   930: aload 16
    //   932: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   935: pop
    //   936: aload_1
    //   937: astore 8
    //   939: aload 17
    //   941: ldc_w 471
    //   944: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   947: pop
    //   948: aload_1
    //   949: astore 8
    //   951: aload 17
    //   953: ldc_w 514
    //   956: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   959: pop
    //   960: aload_1
    //   961: astore 8
    //   963: aload 17
    //   965: aload 10
    //   967: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   970: pop
    //   971: aload_1
    //   972: astore 8
    //   974: aload 17
    //   976: ldc_w 471
    //   979: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   982: pop
    //   983: aload_1
    //   984: astore 8
    //   986: aload 17
    //   988: ldc_w 516
    //   991: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   994: pop
    //   995: aload_1
    //   996: astore 8
    //   998: aload 17
    //   1000: aload 15
    //   1002: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1005: pop
    //   1006: aload_1
    //   1007: astore 8
    //   1009: aload 17
    //   1011: ldc_w 471
    //   1014: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1017: pop
    //   1018: aload_1
    //   1019: astore 8
    //   1021: aload 17
    //   1023: ldc_w 518
    //   1026: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1029: pop
    //   1030: aload_1
    //   1031: astore 8
    //   1033: aload_0
    //   1034: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   1037: aload 17
    //   1039: invokevirtual 128	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1042: invokevirtual 490	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   1045: aload_1
    //   1046: astore 8
    //   1048: aload_1
    //   1049: invokeinterface 243 1 0
    //   1054: pop
    //   1055: iinc 2 1
    //   1058: goto -506 -> 552
    //   1061: aload_1
    //   1062: ifnull -1052 -> 10
    //   1065: aload_1
    //   1066: invokeinterface 217 1 0
    //   1071: ifne -1061 -> 10
    //   1074: aload_1
    //   1075: invokeinterface 220 1 0
    //   1080: goto -1070 -> 10
    //   1083: astore 9
    //   1085: aconst_null
    //   1086: astore_1
    //   1087: aload_1
    //   1088: astore 8
    //   1090: aload_0
    //   1091: getfield 59	a/a/a/a/a/f:a	Lcn/domob/android/i/f;
    //   1094: aload 9
    //   1096: invokevirtual 97	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1099: aload_1
    //   1100: ifnull -1090 -> 10
    //   1103: aload_1
    //   1104: invokeinterface 217 1 0
    //   1109: ifne -1099 -> 10
    //   1112: aload_1
    //   1113: invokeinterface 220 1 0
    //   1118: goto -1108 -> 10
    //   1121: astore_1
    //   1122: aconst_null
    //   1123: astore 8
    //   1125: aload 8
    //   1127: ifnull +20 -> 1147
    //   1130: aload 8
    //   1132: invokeinterface 217 1 0
    //   1137: ifne +10 -> 1147
    //   1140: aload 8
    //   1142: invokeinterface 220 1 0
    //   1147: aload_1
    //   1148: athrow
    //   1149: astore_1
    //   1150: goto -25 -> 1125
    //   1153: astore_1
    //   1154: goto -29 -> 1125
    //   1157: astore 9
    //   1159: aload 8
    //   1161: astore_1
    //   1162: goto -75 -> 1087
    //   1165: astore 9
    //   1167: goto -80 -> 1087
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1170	0	this	f
    //   0	1170	1	paramContext	Context
    //   85	971	2	n	int
    //   179	148	3	i1	int
    //   160	141	4	l1	long
    //   141	134	6	l2	long
    //   25	1135	8	localObject1	Object
    //   36	825	9	localObject2	Object
    //   1083	12	9	localException1	Exception
    //   1157	1	9	localException2	Exception
    //   1165	1	9	localException3	Exception
    //   31	935	10	localObject3	Object
    //   235	661	11	str1	String
    //   123	668	12	str2	String
    //   100	656	13	localObject4	Object
    //   638	188	14	str3	String
    //   736	265	15	str4	String
    //   697	234	16	str5	String
    //   571	467	17	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   11	27	1083	java/lang/Exception
    //   11	27	1121	finally
    //   27	69	1149	finally
    //   74	84	1149	finally
    //   86	438	1149	finally
    //   449	466	1149	finally
    //   466	481	1149	finally
    //   484	490	1153	finally
    //   493	498	1153	finally
    //   501	506	1153	finally
    //   509	534	1153	finally
    //   541	550	1153	finally
    //   555	565	1153	finally
    //   568	573	1153	finally
    //   576	581	1153	finally
    //   584	601	1153	finally
    //   604	620	1153	finally
    //   623	640	1153	finally
    //   643	660	1153	finally
    //   663	679	1153	finally
    //   682	699	1153	finally
    //   702	718	1153	finally
    //   721	738	1153	finally
    //   741	750	1153	finally
    //   753	761	1153	finally
    //   764	773	1153	finally
    //   776	785	1153	finally
    //   788	796	1153	finally
    //   799	808	1153	finally
    //   811	820	1153	finally
    //   823	831	1153	finally
    //   834	843	1153	finally
    //   846	855	1153	finally
    //   858	866	1153	finally
    //   869	878	1153	finally
    //   881	890	1153	finally
    //   893	901	1153	finally
    //   904	913	1153	finally
    //   916	925	1153	finally
    //   928	936	1153	finally
    //   939	948	1153	finally
    //   951	960	1153	finally
    //   963	971	1153	finally
    //   974	983	1153	finally
    //   986	995	1153	finally
    //   998	1006	1153	finally
    //   1009	1018	1153	finally
    //   1021	1030	1153	finally
    //   1033	1045	1153	finally
    //   1048	1055	1153	finally
    //   1090	1099	1153	finally
    //   27	69	1157	java/lang/Exception
    //   74	84	1157	java/lang/Exception
    //   86	438	1157	java/lang/Exception
    //   449	466	1157	java/lang/Exception
    //   466	481	1157	java/lang/Exception
    //   484	490	1165	java/lang/Exception
    //   493	498	1165	java/lang/Exception
    //   501	506	1165	java/lang/Exception
    //   509	534	1165	java/lang/Exception
    //   541	550	1165	java/lang/Exception
    //   555	565	1165	java/lang/Exception
    //   568	573	1165	java/lang/Exception
    //   576	581	1165	java/lang/Exception
    //   584	601	1165	java/lang/Exception
    //   604	620	1165	java/lang/Exception
    //   623	640	1165	java/lang/Exception
    //   643	660	1165	java/lang/Exception
    //   663	679	1165	java/lang/Exception
    //   682	699	1165	java/lang/Exception
    //   702	718	1165	java/lang/Exception
    //   721	738	1165	java/lang/Exception
    //   741	750	1165	java/lang/Exception
    //   753	761	1165	java/lang/Exception
    //   764	773	1165	java/lang/Exception
    //   776	785	1165	java/lang/Exception
    //   788	796	1165	java/lang/Exception
    //   799	808	1165	java/lang/Exception
    //   811	820	1165	java/lang/Exception
    //   823	831	1165	java/lang/Exception
    //   834	843	1165	java/lang/Exception
    //   846	855	1165	java/lang/Exception
    //   858	866	1165	java/lang/Exception
    //   869	878	1165	java/lang/Exception
    //   881	890	1165	java/lang/Exception
    //   893	901	1165	java/lang/Exception
    //   904	913	1165	java/lang/Exception
    //   916	925	1165	java/lang/Exception
    //   928	936	1165	java/lang/Exception
    //   939	948	1165	java/lang/Exception
    //   951	960	1165	java/lang/Exception
    //   963	971	1165	java/lang/Exception
    //   974	983	1165	java/lang/Exception
    //   986	995	1165	java/lang/Exception
    //   998	1006	1165	java/lang/Exception
    //   1009	1018	1165	java/lang/Exception
    //   1021	1030	1165	java/lang/Exception
    //   1033	1045	1165	java/lang/Exception
    //   1048	1055	1165	java/lang/Exception
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\a\a\a\a\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */