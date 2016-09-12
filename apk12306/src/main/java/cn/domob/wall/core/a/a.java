package cn.domob.wall.core.a;

import android.content.Context;
import android.net.Uri;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.d;

public class a
{
  private static final String f = "url";
  private static final String g = "failsafe";
  private static final String h = "pkg";
  private static final String i = "activity";
  private static final String j = "param";
  d a = new d(a.class.getSimpleName());
  AdInfo b;
  private Context c;
  private Uri d;
  private a e;
  
  public a(Context paramContext, Uri paramUri, a parama, AdInfo paramAdInfo)
  {
    this.c = paramContext;
    this.d = paramUri;
    this.e = parama;
    this.b = paramAdInfo;
  }
  
  /* Error */
  private android.content.Intent a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 11
    //   3: invokevirtual 68	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   6: astore 7
    //   8: aload_1
    //   9: ldc 17
    //   11: invokevirtual 68	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore 6
    //   16: aload_1
    //   17: ldc 20
    //   19: invokevirtual 68	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 4
    //   24: aload_1
    //   25: ldc 23
    //   27: invokevirtual 68	android/net/Uri:getQueryParameter	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore 5
    //   32: aload_0
    //   33: getfield 50	cn/domob/wall/core/a/a:a	Lcn/domob/wall/core/h/d;
    //   36: ldc 70
    //   38: iconst_4
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: aload 7
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload 6
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: aload 4
    //   56: aastore
    //   57: dup
    //   58: iconst_3
    //   59: aload 5
    //   61: aastore
    //   62: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   65: invokevirtual 78	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   68: aload 7
    //   70: ifnull +150 -> 220
    //   73: aload 7
    //   75: invokestatic 82	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   78: astore 4
    //   80: new 84	android/content/Intent
    //   83: astore_1
    //   84: aload_1
    //   85: ldc 86
    //   87: aload 4
    //   89: invokespecial 89	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   92: aload_1
    //   93: ldc 90
    //   95: invokevirtual 94	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   98: pop
    //   99: aload_1
    //   100: ifnull +281 -> 381
    //   103: aload 5
    //   105: ifnull +276 -> 381
    //   108: aload 5
    //   110: ldc 96
    //   112: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   115: ifne +266 -> 381
    //   118: aload_0
    //   119: getfield 50	cn/domob/wall/core/a/a:a	Lcn/domob/wall/core/h/d;
    //   122: new 102	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   129: ldc 105
    //   131: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 5
    //   136: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokevirtual 78	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   145: aload 5
    //   147: ldc 114
    //   149: invokevirtual 118	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   152: astore 4
    //   154: aload 4
    //   156: arraylength
    //   157: istore_3
    //   158: iconst_0
    //   159: istore_2
    //   160: iload_2
    //   161: iload_3
    //   162: if_icmpge +219 -> 381
    //   165: aload 4
    //   167: iload_2
    //   168: aaload
    //   169: ldc 120
    //   171: invokevirtual 118	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   174: astore 5
    //   176: aload_1
    //   177: aload 5
    //   179: iconst_0
    //   180: aaload
    //   181: aload 5
    //   183: iconst_1
    //   184: aaload
    //   185: invokevirtual 124	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   188: pop
    //   189: iinc 2 1
    //   192: goto -32 -> 160
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_0
    //   200: getfield 50	cn/domob/wall/core/a/a:a	Lcn/domob/wall/core/h/d;
    //   203: ldc 126
    //   205: invokevirtual 128	cn/domob/wall/core/h/d:e	(Ljava/lang/String;)V
    //   208: aload_0
    //   209: getfield 50	cn/domob/wall/core/a/a:a	Lcn/domob/wall/core/h/d;
    //   212: aload 4
    //   214: invokevirtual 131	cn/domob/wall/core/h/d:a	(Ljava/lang/Throwable;)V
    //   217: goto -118 -> 99
    //   220: aload 6
    //   222: ifnull +145 -> 367
    //   225: aload 6
    //   227: ldc 96
    //   229: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifne +135 -> 367
    //   235: aload 4
    //   237: ifnull +73 -> 310
    //   240: aload 4
    //   242: ldc 96
    //   244: invokevirtual 100	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifne +63 -> 310
    //   250: aload_0
    //   251: getfield 50	cn/domob/wall/core/a/a:a	Lcn/domob/wall/core/h/d;
    //   254: ldc -123
    //   256: iconst_2
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload 6
    //   264: aastore
    //   265: dup
    //   266: iconst_1
    //   267: aload 4
    //   269: aastore
    //   270: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   273: invokevirtual 78	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   276: new 84	android/content/Intent
    //   279: dup
    //   280: invokespecial 134	android/content/Intent:<init>	()V
    //   283: astore_1
    //   284: aload_1
    //   285: new 136	android/content/ComponentName
    //   288: dup
    //   289: aload 6
    //   291: aload 4
    //   293: invokespecial 139	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: invokevirtual 143	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
    //   299: pop
    //   300: aload_1
    //   301: ldc 90
    //   303: invokevirtual 146	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   306: pop
    //   307: goto -208 -> 99
    //   310: aload_0
    //   311: getfield 50	cn/domob/wall/core/a/a:a	Lcn/domob/wall/core/h/d;
    //   314: ldc -108
    //   316: iconst_1
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload 6
    //   324: aastore
    //   325: invokestatic 76	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   328: invokevirtual 78	cn/domob/wall/core/h/d:b	(Ljava/lang/String;)V
    //   331: aload_0
    //   332: getfield 52	cn/domob/wall/core/a/a:c	Landroid/content/Context;
    //   335: invokevirtual 154	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   338: aload 6
    //   340: invokevirtual 160	android/content/pm/PackageManager:getLaunchIntentForPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   343: astore 4
    //   345: aload 4
    //   347: astore_1
    //   348: aload 4
    //   350: ifnull -251 -> 99
    //   353: aload 4
    //   355: ldc 90
    //   357: invokevirtual 146	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   360: pop
    //   361: aload 4
    //   363: astore_1
    //   364: goto -265 -> 99
    //   367: aload_0
    //   368: getfield 50	cn/domob/wall/core/a/a:a	Lcn/domob/wall/core/h/d;
    //   371: ldc -94
    //   373: invokevirtual 128	cn/domob/wall/core/h/d:e	(Ljava/lang/String;)V
    //   376: aconst_null
    //   377: astore_1
    //   378: goto -279 -> 99
    //   381: aload_1
    //   382: areturn
    //   383: astore 4
    //   385: goto -186 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	388	0	this	a
    //   0	388	1	paramUri	Uri
    //   159	31	2	k	int
    //   157	6	3	m	int
    //   22	144	4	localObject1	Object
    //   195	97	4	localException1	Exception
    //   343	19	4	localIntent	android.content.Intent
    //   383	1	4	localException2	Exception
    //   30	152	5	localObject2	Object
    //   14	325	6	str1	String
    //   6	68	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   73	92	195	java/lang/Exception
    //   92	99	383	java/lang/Exception
  }
  
  public void a()
  {
    Object localObject = a(this.d);
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
        this.a.e("Failed to launch app with URL:" + this.d.toString());
        this.a.a(localException1);
        str = this.d.getQueryParameter("failsafe");
        if (this.e != null) {
          this.e.a(str, this.b);
        }
        if (str == null) {}
      }
    }
    try
    {
      d locald = this.a;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      locald.b("Backup action ----- Open landing page with URL:" + str);
      if (this.e != null) {
        this.e.b(str, this.b);
      }
      for (;;)
      {
        return;
        this.c.startActivity(locald);
        if (this.e != null) {
          this.e.h(this.b);
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
  
  public static abstract interface a
  {
    public abstract void a(String paramString, AdInfo paramAdInfo);
    
    public abstract void b(String paramString, AdInfo paramAdInfo);
    
    public abstract void h(AdInfo paramAdInfo);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */