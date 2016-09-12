package cn.domob.android.e;

import android.content.Context;
import cn.domob.android.i.f;
import org.json.JSONArray;
import org.json.JSONException;

public class c
{
  private static int b = 20;
  private static c c;
  f a = new f(c.class.getSimpleName());
  
  protected static c a()
  {
    try
    {
      if (c == null)
      {
        localc = new cn/domob/android/e/c;
        localc.<init>();
        c = localc;
      }
      c localc = c;
      return localc;
    }
    finally {}
  }
  
  /* Error */
  private String a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: new 40	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   10: aload_2
    //   11: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc 47
    //   16: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: aload_3
    //   20: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 49
    //   25: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_3
    //   29: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 51
    //   34: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 53
    //   39: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc 55
    //   44: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: astore_2
    //   51: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   54: lstore 7
    //   56: new 66	java/lang/StringBuffer
    //   59: dup
    //   60: invokespecial 67	java/lang/StringBuffer:<init>	()V
    //   63: astore_3
    //   64: aload_1
    //   65: invokestatic 72	cn/domob/android/e/b:a	(Landroid/content/Context;)Lcn/domob/android/e/b;
    //   68: iconst_1
    //   69: anewarray 74	java/lang/String
    //   72: dup
    //   73: iconst_0
    //   74: ldc 76
    //   76: aastore
    //   77: aload_2
    //   78: iconst_2
    //   79: anewarray 74	java/lang/String
    //   82: dup
    //   83: iconst_0
    //   84: ldc 78
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: lload 7
    //   91: invokestatic 82	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   94: aastore
    //   95: ldc 84
    //   97: invokevirtual 87	cn/domob/android/e/b:a	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore_2
    //   101: aload_2
    //   102: ifnull +144 -> 246
    //   105: aload_2
    //   106: astore_1
    //   107: aload_0
    //   108: getfield 31	cn/domob/android/e/c:a	Lcn/domob/android/i/f;
    //   111: ldc 89
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_2
    //   120: invokeinterface 95 1 0
    //   125: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   128: aastore
    //   129: dup
    //   130: iconst_1
    //   131: getstatic 14	cn/domob/android/e/c:b	I
    //   134: invokestatic 100	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: invokestatic 104	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   141: invokevirtual 106	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   144: aload_2
    //   145: astore_1
    //   146: aload_2
    //   147: invokeinterface 95 1 0
    //   152: getstatic 14	cn/domob/android/e/c:b	I
    //   155: if_icmple +78 -> 233
    //   158: aload_2
    //   159: astore_1
    //   160: getstatic 14	cn/domob/android/e/c:b	I
    //   163: istore 4
    //   165: aload_2
    //   166: astore_1
    //   167: aload_2
    //   168: invokeinterface 110 1 0
    //   173: pop
    //   174: iconst_0
    //   175: istore 5
    //   177: iload 4
    //   179: istore 6
    //   181: iload 5
    //   183: iload 4
    //   185: if_icmpge +64 -> 249
    //   188: aload_2
    //   189: astore_1
    //   190: aload_3
    //   191: aload_2
    //   192: aload_2
    //   193: ldc 76
    //   195: invokeinterface 114 2 0
    //   200: invokeinterface 118 2 0
    //   205: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   208: pop
    //   209: aload_2
    //   210: astore_1
    //   211: aload_3
    //   212: ldc 123
    //   214: invokevirtual 121	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   217: pop
    //   218: aload_2
    //   219: astore_1
    //   220: aload_2
    //   221: invokeinterface 126 1 0
    //   226: pop
    //   227: iinc 5 1
    //   230: goto -53 -> 177
    //   233: aload_2
    //   234: astore_1
    //   235: aload_2
    //   236: invokeinterface 95 1 0
    //   241: istore 4
    //   243: goto -78 -> 165
    //   246: iconst_0
    //   247: istore 6
    //   249: aload_2
    //   250: ifnull +18 -> 268
    //   253: aload_2
    //   254: invokeinterface 129 1 0
    //   259: ifne +9 -> 268
    //   262: aload_2
    //   263: invokeinterface 132 1 0
    //   268: aload 9
    //   270: astore_1
    //   271: aload_3
    //   272: invokevirtual 135	java/lang/StringBuffer:length	()I
    //   275: ifle +33 -> 308
    //   278: aload_3
    //   279: invokevirtual 136	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   282: astore_1
    //   283: aload_1
    //   284: invokevirtual 140	java/lang/String:getBytes	()[B
    //   287: arraylength
    //   288: iload 6
    //   290: bipush 10
    //   292: imul
    //   293: if_icmpgt +85 -> 378
    //   296: aload_1
    //   297: iconst_0
    //   298: aload_1
    //   299: invokevirtual 141	java/lang/String:length	()I
    //   302: iconst_1
    //   303: isub
    //   304: invokevirtual 145	java/lang/String:substring	(II)Ljava/lang/String;
    //   307: astore_1
    //   308: aload_1
    //   309: areturn
    //   310: astore_3
    //   311: aconst_null
    //   312: astore_2
    //   313: aload_2
    //   314: astore_1
    //   315: aload_0
    //   316: getfield 31	cn/domob/android/e/c:a	Lcn/domob/android/i/f;
    //   319: aload_3
    //   320: invokevirtual 148	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   323: aload 9
    //   325: astore_1
    //   326: aload_2
    //   327: ifnull -19 -> 308
    //   330: aload 9
    //   332: astore_1
    //   333: aload_2
    //   334: invokeinterface 129 1 0
    //   339: ifne -31 -> 308
    //   342: aload_2
    //   343: invokeinterface 132 1 0
    //   348: aload 9
    //   350: astore_1
    //   351: goto -43 -> 308
    //   354: astore_2
    //   355: aconst_null
    //   356: astore_1
    //   357: aload_1
    //   358: ifnull +18 -> 376
    //   361: aload_1
    //   362: invokeinterface 129 1 0
    //   367: ifne +9 -> 376
    //   370: aload_1
    //   371: invokeinterface 132 1 0
    //   376: aload_2
    //   377: athrow
    //   378: aload_0
    //   379: getfield 31	cn/domob/android/e/c:a	Lcn/domob/android/i/f;
    //   382: new 40	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   389: ldc -106
    //   391: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: iload 6
    //   396: bipush 10
    //   398: imul
    //   399: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   402: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokevirtual 156	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   408: aload 9
    //   410: astore_1
    //   411: goto -103 -> 308
    //   414: astore_2
    //   415: goto -58 -> 357
    //   418: astore_3
    //   419: goto -106 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	this	c
    //   0	422	1	paramContext	Context
    //   0	422	2	paramString1	String
    //   0	422	3	paramString2	String
    //   163	79	4	i	int
    //   175	53	5	j	int
    //   179	220	6	k	int
    //   54	36	7	l	long
    //   1	408	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   64	101	310	java/lang/Exception
    //   64	101	354	finally
    //   107	144	414	finally
    //   146	158	414	finally
    //   160	165	414	finally
    //   167	174	414	finally
    //   190	209	414	finally
    //   211	218	414	finally
    //   220	227	414	finally
    //   235	243	414	finally
    //   315	323	414	finally
    //   107	144	418	java/lang/Exception
    //   146	158	418	java/lang/Exception
    //   160	165	418	java/lang/Exception
    //   167	174	418	java/lang/Exception
    //   190	209	418	java/lang/Exception
    //   211	218	418	java/lang/Exception
    //   220	227	418	java/lang/Exception
    //   235	243	418	java/lang/Exception
  }
  
  protected void a(int paramInt)
  {
    this.a.b("freq maximum uploading number now is assigned to " + paramInt);
    b = paramInt;
  }
  
  protected void a(Context paramContext, JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      this.a.b("ad response contains array is null");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject1 = null;
        try
        {
          localObject2 = paramJSONArray.getString(i);
          localObject1 = localObject2;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Object localObject2;
            this.a.a(localJSONException);
          }
        }
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localObject2 = ((String)localObject1).split("_");
          if ((localObject2 != null) && (localObject2.length == 4)) {
            localObject1 = localObject2[0];
          }
        }
        try
        {
          j = Integer.valueOf(localObject2[1]).intValue();
          k = Integer.valueOf(localObject2[2]).intValue();
          l = Long.valueOf(localObject2[3]).longValue();
          m = b.a(paramContext).a("frequency_id = ?", new String[] { localObject1 });
          if (m != 0) {
            break label216;
          }
          this.a.b("Database does not contain the freqid which from ad response: " + (String)localObject1);
          b.a(paramContext).a((String)localObject1, j, k, l);
          i++;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int j;
            int k;
            long l;
            int m;
            this.a.a(localException);
            continue;
            if (m > 0)
            {
              if (m > 1)
              {
                this.a.e(String.format("Database contains %d same freqid", new Object[] { Integer.valueOf(m) }));
                b.a(paramContext).a(localException);
              }
              if (b.a(paramContext).a("frequency_id= ? and end_time = ?", new String[] { localException, String.valueOf(l) }) == 1)
              {
                this.a.b("ending timestamp is the same, so only update limit number ");
                b.a(paramContext).a(localException, j, k);
              }
              else
              {
                this.a.b("ending timestamp is not the same, so delete the old data, insert new data");
                b.a(paramContext).a(localException);
                b.a(paramContext).a(localException, j, k, l);
              }
            }
          }
        }
      }
    }
  }
  
  protected String[] a(Context paramContext)
  {
    String[] arrayOfString = new String[2];
    if (b > 0)
    {
      b.a(paramContext).c();
      arrayOfString[0] = a(paramContext, "imp_times", "imp_limit_times");
      this.a.b("upload imp list is " + arrayOfString[0]);
      arrayOfString[1] = a(paramContext, "click_times", "click_limit_times");
      this.a.b("upload click list is " + arrayOfString[1]);
    }
    return arrayOfString;
  }
  
  protected boolean b()
  {
    if (b > 0) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.a.d(String.format("because uploadMaxNum is %s Less than or equal 0, all freq control function is closed.", new Object[] { Integer.valueOf(b) }));
      }
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\e\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */