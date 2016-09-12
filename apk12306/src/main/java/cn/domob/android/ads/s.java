package cn.domob.android.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import cn.domob.android.i.d;
import cn.domob.android.i.f;

class s
{
  static final String a = "pb[update]";
  static final String b = "domob_update_info";
  static final String c = "ipb";
  static final String d = "info_md5";
  static final String e = "n";
  static final String f = "nt";
  static final String g = "vc";
  static final String h = "vn";
  static final String i = "u";
  static final String j = "s";
  static final String k = "md5";
  static final String l = "ul";
  static final String m = "f";
  static final String n = "sk";
  static final String o = "nrt";
  static final String p = "nri";
  static final String q = "next_time";
  static final String r = "skip_vc";
  private static f s = new f(s.class.getSimpleName());
  
  protected static void a(String paramString, Context paramContext)
  {
    s locals = new s();
    boolean bool = false;
    try
    {
      locals.b(paramString, paramContext);
      bool = true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        s.a(paramString);
      }
    }
    s.a("ExtraInfo parse and update/non-update result return " + bool);
  }
  
  private boolean a(SharedPreferences paramSharedPreferences, StringBuilder paramStringBuilder)
  {
    bool2 = false;
    try
    {
      SharedPreferences.Editor localEditor = paramSharedPreferences.edit();
      paramSharedPreferences = paramSharedPreferences.getString("info_md5", null);
      paramStringBuilder = d.b(paramStringBuilder.toString());
      if (paramSharedPreferences != null)
      {
        bool1 = bool2;
        if (paramStringBuilder != null)
        {
          bool1 = bool2;
          if (paramStringBuilder.equals(paramSharedPreferences)) {}
        }
      }
      else
      {
        localEditor.putString("info_md5", paramStringBuilder);
        localEditor.commit();
        bool1 = true;
      }
    }
    catch (Exception paramSharedPreferences)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    return bool1;
  }
  
  /* Error */
  private boolean b(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: new 140	org/json/JSONObject
    //   3: astore 8
    //   5: new 142	org/json/JSONTokener
    //   8: astore 9
    //   10: aload 9
    //   12: aload_1
    //   13: invokespecial 143	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   16: aload 8
    //   18: aload 9
    //   20: invokespecial 146	org/json/JSONObject:<init>	(Lorg/json/JSONTokener;)V
    //   23: aload 8
    //   25: astore_1
    //   26: aload_2
    //   27: ldc 11
    //   29: iconst_0
    //   30: invokevirtual 152	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   33: astore 8
    //   35: aload 8
    //   37: monitorenter
    //   38: aload 8
    //   40: invokeinterface 111 1 0
    //   45: astore 9
    //   47: aload 9
    //   49: ldc 14
    //   51: invokestatic 157	cn/domob/android/ads/h:a	()Lcn/domob/android/ads/h;
    //   54: aload_2
    //   55: invokevirtual 160	cn/domob/android/ads/h:a	(Landroid/content/Context;)Ljava/lang/String;
    //   58: invokeinterface 132 3 0
    //   63: pop
    //   64: aload 9
    //   66: invokeinterface 136 1 0
    //   71: pop
    //   72: aload_1
    //   73: ldc 8
    //   75: invokevirtual 164	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: astore 15
    //   80: aload 15
    //   82: ifnull +461 -> 543
    //   85: aload 15
    //   87: ldc 20
    //   89: aconst_null
    //   90: invokevirtual 167	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   93: astore 12
    //   95: aload 15
    //   97: ldc 23
    //   99: iconst_0
    //   100: invokevirtual 171	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   103: istore 4
    //   105: aload 15
    //   107: ldc 26
    //   109: aconst_null
    //   110: invokevirtual 167	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   113: astore_1
    //   114: aload 15
    //   116: ldc 29
    //   118: aconst_null
    //   119: invokevirtual 167	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 14
    //   124: aload 15
    //   126: ldc 32
    //   128: aconst_null
    //   129: invokevirtual 167	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: astore_2
    //   133: aload 15
    //   135: ldc 35
    //   137: aconst_null
    //   138: invokevirtual 167	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   141: astore 10
    //   143: aload 15
    //   145: ldc 38
    //   147: ldc -83
    //   149: invokevirtual 167	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   152: astore 13
    //   154: aload 15
    //   156: ldc 41
    //   158: aconst_null
    //   159: invokevirtual 167	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   162: astore 11
    //   164: aload 15
    //   166: ldc 43
    //   168: iconst_0
    //   169: invokevirtual 177	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   172: istore 7
    //   174: aload 15
    //   176: ldc 45
    //   178: iconst_0
    //   179: invokevirtual 177	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   182: istore 6
    //   184: aload 15
    //   186: ldc 48
    //   188: iconst_0
    //   189: invokevirtual 171	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   192: istore_3
    //   193: aload 15
    //   195: ldc 51
    //   197: iconst_3
    //   198: invokevirtual 171	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   201: istore 5
    //   203: aload 12
    //   205: ifnull +338 -> 543
    //   208: aload_1
    //   209: ifnull +334 -> 543
    //   212: aload 14
    //   214: ifnull +329 -> 543
    //   217: aload_2
    //   218: ifnull +325 -> 543
    //   221: aload 10
    //   223: ifnull +320 -> 543
    //   226: aload 11
    //   228: ifnull +315 -> 543
    //   231: ldc -77
    //   233: invokestatic 185	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   236: aload_1
    //   237: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   240: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   243: ifne +52 -> 295
    //   246: getstatic 74	cn/domob/android/ads/s:s	Lcn/domob/android/i/f;
    //   249: astore 9
    //   251: new 86	java/lang/StringBuilder
    //   254: astore_2
    //   255: aload_2
    //   256: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   259: aload 9
    //   261: aload_2
    //   262: ldc -60
    //   264: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_1
    //   268: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokevirtual 198	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   277: aload 8
    //   279: monitorexit
    //   280: iconst_1
    //   281: ireturn
    //   282: astore_1
    //   283: getstatic 74	cn/domob/android/ads/s:s	Lcn/domob/android/i/f;
    //   286: aload_1
    //   287: invokevirtual 104	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   290: aconst_null
    //   291: astore_1
    //   292: goto -266 -> 26
    //   295: new 86	java/lang/StringBuilder
    //   298: astore 15
    //   300: aload 15
    //   302: invokespecial 87	java/lang/StringBuilder:<init>	()V
    //   305: aload_0
    //   306: aload 8
    //   308: aload 15
    //   310: aload 12
    //   312: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: iload 4
    //   317: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 14
    //   326: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_2
    //   330: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 10
    //   335: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload 13
    //   340: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload 11
    //   345: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 7
    //   350: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   353: iload 6
    //   355: invokevirtual 96	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   358: iload_3
    //   359: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: iload 5
    //   364: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: invokespecial 203	cn/domob/android/ads/s:a	(Landroid/content/SharedPreferences;Ljava/lang/StringBuilder;)Z
    //   370: ifeq +179 -> 549
    //   373: getstatic 74	cn/domob/android/ads/s:s	Lcn/domob/android/i/f;
    //   376: ldc -51
    //   378: invokevirtual 101	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   381: aload 9
    //   383: ldc 20
    //   385: aload 12
    //   387: invokeinterface 132 3 0
    //   392: pop
    //   393: aload 9
    //   395: ldc 23
    //   397: iload 4
    //   399: invokeinterface 209 3 0
    //   404: pop
    //   405: aload 9
    //   407: ldc 26
    //   409: aload_1
    //   410: invokeinterface 132 3 0
    //   415: pop
    //   416: aload 9
    //   418: ldc 29
    //   420: aload 14
    //   422: invokeinterface 132 3 0
    //   427: pop
    //   428: aload 9
    //   430: ldc 32
    //   432: aload_2
    //   433: invokeinterface 132 3 0
    //   438: pop
    //   439: aload 9
    //   441: ldc 35
    //   443: aload 10
    //   445: invokeinterface 132 3 0
    //   450: pop
    //   451: aload 9
    //   453: ldc 38
    //   455: aload 13
    //   457: invokeinterface 132 3 0
    //   462: pop
    //   463: aload 9
    //   465: ldc 41
    //   467: aload 11
    //   469: invokeinterface 132 3 0
    //   474: pop
    //   475: aload 9
    //   477: ldc 43
    //   479: iload 7
    //   481: invokeinterface 213 3 0
    //   486: pop
    //   487: aload 9
    //   489: ldc 45
    //   491: iload 6
    //   493: invokeinterface 213 3 0
    //   498: pop
    //   499: aload 9
    //   501: ldc 48
    //   503: iload_3
    //   504: invokeinterface 209 3 0
    //   509: pop
    //   510: aload 9
    //   512: ldc 51
    //   514: iload 5
    //   516: invokeinterface 209 3 0
    //   521: pop
    //   522: aload 9
    //   524: ldc 54
    //   526: invokestatic 219	java/lang/System:currentTimeMillis	()J
    //   529: invokeinterface 223 4 0
    //   534: pop
    //   535: aload 9
    //   537: invokeinterface 136 1 0
    //   542: pop
    //   543: aload 8
    //   545: monitorexit
    //   546: goto -266 -> 280
    //   549: getstatic 74	cn/domob/android/ads/s:s	Lcn/domob/android/i/f;
    //   552: ldc -31
    //   554: invokevirtual 101	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   557: goto -14 -> 543
    //   560: astore_1
    //   561: aload 8
    //   563: monitorexit
    //   564: aload_1
    //   565: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	566	0	this	s
    //   0	566	1	paramString	String
    //   0	566	2	paramContext	Context
    //   192	312	3	i1	int
    //   103	295	4	i2	int
    //   201	314	5	i3	int
    //   182	310	6	bool1	boolean
    //   172	308	7	bool2	boolean
    //   8	528	9	localObject2	Object
    //   141	303	10	str1	String
    //   162	306	11	str2	String
    //   93	293	12	str3	String
    //   152	304	13	str4	String
    //   122	299	14	str5	String
    //   78	231	15	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	23	282	org/json/JSONException
    //   38	80	560	finally
    //   85	203	560	finally
    //   231	280	560	finally
    //   295	543	560	finally
    //   543	546	560	finally
    //   549	557	560	finally
    //   561	564	560	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */