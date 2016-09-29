package cn.domob.android.ads.a;

import android.content.Context;
import android.net.Uri;
import cn.domob.android.i.f;

class a
{
  private static final String e = "url";
  private static final String f = "failsafe";
  private static final String g = "pkg";
  private static final String h = "activity";
  private static final String i = "param";
  f a = new f(a.class.getSimpleName());
  private Context b;
  private Uri c;
  private a d;
  
  a(Context paramContext, Uri paramUri, a parama)
  {
    this.b = paramContext;
    this.c = paramUri;
    this.d = parama;
  }
  
  /* Error */
  private android.content.Intent a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 11
    //   3: invokevirtual 64	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 7
    //   8: aload_1
    //   9: ldc 17
    //   11: invokevirtual 64	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 6
    //   16: aload_1
    //   17: ldc 20
    //   19: invokevirtual 64	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 4
    //   24: aload_1
    //   25: ldc 23
    //   27: invokevirtual 64	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 5
    //   32: aload 7
    //   34: ifnull +150 -> 184
    //   37: aload 7
    //   39: invokestatic 68	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   42: astore 4
    //   44: new 70	android/content/Intent
    //   47: astore_1
    //   48: aload_1
    //   49: ldc 72
    //   51: aload 4
    //   53: invokespecial 75	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   56: aload_1
    //   57: ldc 76
    //   59: invokevirtual 80	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   62: pop
    //   63: aload_1
    //   64: ifnull +252 -> 316
    //   67: aload 5
    //   69: ifnull +247 -> 316
    //   72: aload 5
    //   74: ldc 82
    //   76: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   79: ifne +237 -> 316
    //   82: aload_0
    //   83: getfield 48	cn/domob/android/ads/a/a:a	Lcn/domob/android/i/f;
    //   86: new 90	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   93: ldc 93
    //   95: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload 5
    //   100: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokevirtual 102	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   109: aload 5
    //   111: ldc 104
    //   113: invokevirtual 108	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   116: astore 4
    //   118: aload 4
    //   120: arraylength
    //   121: istore_3
    //   122: iconst_0
    //   123: istore_2
    //   124: iload_2
    //   125: iload_3
    //   126: if_icmpge +190 -> 316
    //   129: aload 4
    //   131: iload_2
    //   132: aaload
    //   133: ldc 110
    //   135: invokevirtual 108	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   138: astore 5
    //   140: aload_1
    //   141: aload 5
    //   143: iconst_0
    //   144: aaload
    //   145: aload 5
    //   147: iconst_1
    //   148: aaload
    //   149: invokevirtual 114	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   152: pop
    //   153: iinc 2 1
    //   156: goto -32 -> 124
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_1
    //   163: aload_0
    //   164: getfield 48	cn/domob/android/ads/a/a:a	Lcn/domob/android/i/f;
    //   167: ldc 116
    //   169: invokevirtual 118	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 48	cn/domob/android/ads/a/a:a	Lcn/domob/android/i/f;
    //   176: aload 4
    //   178: invokevirtual 121	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   181: goto -118 -> 63
    //   184: aload 6
    //   186: ifnull +116 -> 302
    //   189: aload 6
    //   191: ldc 82
    //   193: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   196: ifne +106 -> 302
    //   199: aload 4
    //   201: ifnull +56 -> 257
    //   204: aload 4
    //   206: ldc 82
    //   208: invokevirtual 88	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   211: ifne +46 -> 257
    //   214: aload_0
    //   215: getfield 48	cn/domob/android/ads/a/a:a	Lcn/domob/android/i/f;
    //   218: ldc 123
    //   220: invokevirtual 102	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   223: new 70	android/content/Intent
    //   226: dup
    //   227: invokespecial 124	android/content/Intent:<init>	()V
    //   230: astore_1
    //   231: aload_1
    //   232: new 126	android/content/ComponentName
    //   235: dup
    //   236: aload 6
    //   238: aload 4
    //   240: invokespecial 129	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: invokevirtual 133	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   246: pop
    //   247: aload_1
    //   248: ldc 76
    //   250: invokevirtual 136	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   253: pop
    //   254: goto -191 -> 63
    //   257: aload_0
    //   258: getfield 48	cn/domob/android/ads/a/a:a	Lcn/domob/android/i/f;
    //   261: ldc -118
    //   263: invokevirtual 102	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   266: aload_0
    //   267: getfield 50	cn/domob/android/ads/a/a:b	Landroid/content/Context;
    //   270: invokevirtual 144	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   273: aload 6
    //   275: invokevirtual 150	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   278: astore 4
    //   280: aload 4
    //   282: astore_1
    //   283: aload 4
    //   285: ifnull -222 -> 63
    //   288: aload 4
    //   290: ldc 76
    //   292: invokevirtual 136	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   295: pop
    //   296: aload 4
    //   298: astore_1
    //   299: goto -236 -> 63
    //   302: aload_0
    //   303: getfield 48	cn/domob/android/ads/a/a:a	Lcn/domob/android/i/f;
    //   306: ldc -104
    //   308: invokevirtual 118	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   311: aconst_null
    //   312: astore_1
    //   313: goto -250 -> 63
    //   316: aload_1
    //   317: areturn
    //   318: astore 4
    //   320: goto -157 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	a
    //   0	323	1	paramUri	Uri
    //   123	31	2	j	int
    //   121	6	3	k	int
    //   22	108	4	localObject1	Object
    //   159	80	4	localException1	Exception
    //   278	19	4	localIntent	android.content.Intent
    //   318	1	4	localException2	Exception
    //   30	116	5	localObject2	Object
    //   14	260	6	str1	String
    //   6	32	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   37	56	159	java/lang/Exception
    //   56	63	318	java/lang/Exception
  }
  
  protected void a()
  {
    Object localObject = a(this.c);
    String str;
    if (localObject == null) {
      try
      {
        localObject = new java/lang/Exception;
        ((Exception)localObject).<init>("Action intent is null.");
        throw ((Throwable)localObject);
      }
      catch (Exception localException1)
      {
        this.a.e("Failed to launch app with URL:" + this.c.toString());
        this.a.a(localException1);
        if (this.d != null) {
          this.d.b_();
        }
        str = this.c.getQueryParameter("failsafe");
        if (str == null) {}
      }
    }
    try
    {
      f localf = this.a;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localf.a("Backup action ----- Open landing page with URL:" + str);
      if (this.d != null) {
        this.d.a_(str);
      }
      for (;;)
      {
        return;
        this.b.startActivity(str);
        if (this.d != null) {
          this.d.a_();
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        this.a.e("Invalid failsafe URL.");
        this.a.a(localException2);
      }
    }
  }
  
  static abstract interface a
  {
    public abstract void a_();
    
    public abstract void a_(String paramString);
    
    public abstract void b_();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */