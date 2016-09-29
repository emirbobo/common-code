package cn.domob.android.f;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cn.domob.android.i.c;
import cn.domob.android.i.f;
import cn.domob.android.i.h;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class b
{
  private static final int B = 4096;
  private static final String C = "ctwap";
  public static final String a = "sid";
  private static f c = new f(b.class.getSimpleName());
  private static boolean d = false;
  private static HashMap<String, Integer> e = new HashMap();
  private static final int f = 2;
  private static final String k = "connection";
  private static final String l = "time";
  private static final long m = -1L;
  private static a w;
  private byte[] A;
  protected URL b;
  private boolean g = false;
  private String h;
  private a i;
  private boolean j = false;
  private HttpURLConnection n;
  private Context o;
  private String p;
  private String q;
  private HashMap<String, String> r;
  private Proxy s;
  private String t;
  private int u;
  private b v;
  private String x;
  private int y;
  private String z;
  
  public b(Context paramContext)
  {
    this(paramContext, null, null, null, "POST", null, 20000);
  }
  
  public b(Context paramContext, String paramString1, String paramString2, HashMap<String, String> paramHashMap, String paramString3, String paramString4, int paramInt)
  {
    this.o = paramContext;
    this.q = paramString2;
    this.r = paramHashMap;
    this.p = paramString3;
    this.t = paramString4;
    this.u = paramInt;
    this.h = paramString1;
    if ((this.o != null) || (this.p == null)) {
      this.p = "GET";
    }
    try
    {
      q();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        c.b("get error when dealing with apn");
        c.a(paramContext);
      }
    }
    catch (Error paramContext)
    {
      for (;;)
      {
        c.b("get error when dealing with apn");
        c.a(paramContext);
      }
    }
  }
  
  public static void a(a parama)
  {
    w = parama;
  }
  
  private final void a(String paramString, int paramInt)
  {
    c.b(this, "setProxy -- proxy:" + paramString + "| port:" + paramInt);
    this.s = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(paramString, paramInt));
  }
  
  protected static boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext == null) {
          continue;
        }
        bool = paramContext.isConnected();
        if (!bool) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramContext)
      {
        c.a(paramContext);
        boolean bool = false;
        continue;
      }
      return bool;
      bool = false;
    }
  }
  
  private void f(String paramString)
  {
    this.h = i(paramString);
    if (this.v != null) {
      this.v.a(this.h);
    }
    c.d(String.format("try to use the new domain(%s) to connect again", new Object[] { this.h }));
    h();
  }
  
  private String g(String paramString)
  {
    int i2;
    int i1;
    label101:
    String str1;
    if (this.v != null)
    {
      String[] arrayOfString = this.v.b();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        i2 = 0;
        i1 = 0;
        if (i2 < arrayOfString.length - 1) {
          if ((i1 != 0) || ((!h.e(arrayOfString[i2])) && (paramString.equals(arrayOfString[i2])))) {
            if (e.get(arrayOfString[(i2 + 1)]) != null)
            {
              i1 = ((Integer)e.get(arrayOfString[(i2 + 1)])).intValue();
              if (i1 >= 2) {
                break label203;
              }
              str1 = arrayOfString[(i2 + 1)];
              label114:
              str2 = str1;
              if (str1 == null)
              {
                str2 = str1;
                if (arrayOfString[(arrayOfString.length - 1)] != null)
                {
                  str2 = str1;
                  if (arrayOfString[(arrayOfString.length - 1)].equals(paramString))
                  {
                    d = true;
                    t();
                    this.v.a(this.v.c());
                    c.d("all domains have been masked");
                  }
                }
              }
            }
          }
        }
      }
    }
    for (String str2 = str1;; str2 = null)
    {
      return str2;
      i1 = 0;
      break label101;
      label203:
      i1 = 1;
      for (;;)
      {
        i2++;
        break;
      }
      str1 = null;
      break label114;
    }
  }
  
  private String h(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    if (!h.e(paramString))
    {
      int i1 = paramString.indexOf(".");
      str1 = str2;
      if (i1 >= 0)
      {
        str1 = str2;
        if (i1 < paramString.length() - 1) {
          str1 = paramString.substring(i1 + 1);
        }
      }
    }
    return str1;
  }
  
  private String i(String paramString)
  {
    String str;
    do
    {
      str = h.a(5);
    } while (!str.matches(".*\\d.*"));
    return "http://" + str + "." + paramString;
  }
  
  private boolean j(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!h.e(paramString)) {}
    try
    {
      localObject1 = new org/json/JSONObject;
      JSONTokener localJSONTokener = new org/json/JSONTokener;
      localJSONTokener.<init>(paramString);
      ((JSONObject)localObject1).<init>(localJSONTokener);
      paramString = (String)localObject1;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        c.a(paramString);
        paramString = null;
        continue;
        boolean bool = false;
      }
    }
    localObject1 = localObject2;
    if (paramString != null) {
      localObject1 = paramString.optString("sid", null);
    }
    if (this.o == null) {
      c.e("Context is null, but it is a parameter of the method isNetworkAvailable");
    }
    if ((h.e((String)localObject1)) && (a(this.o)))
    {
      bool = true;
      return bool;
    }
  }
  
  private void q()
  {
    if (this.o == null) {}
    for (;;)
    {
      return;
      Object localObject3 = null;
      Object localObject1 = null;
      try
      {
        Cursor localCursor = c.t(this.o);
        if (localCursor != null)
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          if (localCursor.getCount() > 0)
          {
            localObject1 = localCursor;
            localObject3 = localCursor;
            localCursor.moveToFirst();
            localObject1 = localCursor;
            localObject3 = localCursor;
            String str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("proxy"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            int i1 = localCursor.getInt(localCursor.getColumnIndexOrThrow("port"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            String str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("apn"));
            localObject1 = localCursor;
            localObject3 = localCursor;
            Object localObject5 = c;
            localObject1 = localCursor;
            localObject3 = localCursor;
            Object localObject4 = new java/lang/StringBuilder;
            localObject1 = localCursor;
            localObject3 = localCursor;
            ((StringBuilder)localObject4).<init>();
            localObject1 = localCursor;
            localObject3 = localCursor;
            ((f)localObject5).b(this, "Current apnType is " + str1);
            localObject1 = localCursor;
            localObject3 = localCursor;
            localObject4 = c;
            localObject1 = localCursor;
            localObject3 = localCursor;
            localObject5 = new java/lang/StringBuilder;
            localObject1 = localCursor;
            localObject3 = localCursor;
            ((StringBuilder)localObject5).<init>();
            localObject1 = localCursor;
            localObject3 = localCursor;
            ((f)localObject4).b(this, "proxy:" + str2 + "| port:" + i1);
            if (str2 != null)
            {
              localObject1 = localCursor;
              localObject3 = localCursor;
              if ((!str2.trim().equals("")) && (i1 != 0))
              {
                localObject1 = localCursor;
                localObject3 = localCursor;
                if (!str1.equalsIgnoreCase("ctwap"))
                {
                  localObject1 = localCursor;
                  localObject3 = localCursor;
                  c.b(this, "ad request use proxy");
                  localObject1 = localCursor;
                  localObject3 = localCursor;
                  a(str2, i1);
                }
              }
            }
          }
        }
        if (localCursor == null) {
          continue;
        }
        localCursor.close();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localObject3 = localObject1;
        c.e(this, "获取APN失败。");
        localObject3 = localObject1;
        c.a(localIllegalArgumentException);
        if (localObject1 == null) {
          continue;
        }
        ((Cursor)localObject1).close();
      }
      finally
      {
        if (localObject3 != null) {
          ((Cursor)localObject3).close();
        }
      }
    }
  }
  
  private void r()
  {
    String str = h(this.h);
    int i1;
    if (e.containsKey(str))
    {
      i1 = ((Integer)e.get(str)).intValue();
      Object localObject = e;
      i1++;
      ((HashMap)localObject).put(str, new Integer(i1));
      if (i1 < 2) {
        break label91;
      }
      localObject = g(str);
      if (h.e((String)localObject)) {
        break label83;
      }
      f((String)localObject);
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label83:
      this.j = true;
      continue;
      label91:
      f(str);
    }
  }
  
  private a s()
  {
    if (this.i == null) {
      this.i = new a(this.o, "connection");
    }
    return this.i;
  }
  
  private void t()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("time", new Long(System.currentTimeMillis()));
    s().a(localHashMap);
  }
  
  public String a()
  {
    return this.x;
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void a(b paramb)
  {
    this.v = paramb;
  }
  
  public void a(String paramString)
  {
    this.x = paramString;
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    this.r = paramHashMap;
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void b()
  {
    c.a(this, "Do HTTP connection.");
    h();
  }
  
  public void b(Context paramContext)
  {
    this.o = paramContext;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore_2
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 120	cn/domob/android/f/b:h	Ljava/lang/String;
    //   14: ifnull +483 -> 497
    //   17: aload_0
    //   18: getfield 120	cn/domob/android/f/b:h	Ljava/lang/String;
    //   21: invokevirtual 253	java/lang/String:length	()I
    //   24: ifeq +473 -> 497
    //   27: aload_0
    //   28: getfield 114	cn/domob/android/f/b:p	Ljava/lang/String;
    //   31: ldc 122
    //   33: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifeq +438 -> 474
    //   39: aload_0
    //   40: getfield 116	cn/domob/android/f/b:t	Ljava/lang/String;
    //   43: ifnull +431 -> 474
    //   46: aload_0
    //   47: getfield 120	cn/domob/android/f/b:h	Ljava/lang/String;
    //   50: ldc_w 393
    //   53: invokevirtual 250	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   56: iconst_m1
    //   57: if_icmpne +323 -> 380
    //   60: new 395	java/net/URL
    //   63: astore 6
    //   65: new 139	java/lang/StringBuilder
    //   68: astore 7
    //   70: aload 7
    //   72: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   75: aload 6
    //   77: aload 7
    //   79: aload_0
    //   80: getfield 120	cn/domob/android/f/b:h	Ljava/lang/String;
    //   83: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc_w 393
    //   89: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: aload_0
    //   93: getfield 116	cn/domob/android/f/b:t	Ljava/lang/String;
    //   96: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokespecial 396	java/net/URL:<init>	(Ljava/lang/String;)V
    //   105: aload_0
    //   106: aload 6
    //   108: putfield 398	cn/domob/android/f/b:b	Ljava/net/URL;
    //   111: aload_0
    //   112: getfield 398	cn/domob/android/f/b:b	Ljava/net/URL;
    //   115: ifnull +984 -> 1099
    //   118: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   121: astore 6
    //   123: new 139	java/lang/StringBuilder
    //   126: astore 7
    //   128: aload 7
    //   130: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   133: aload 6
    //   135: aload 7
    //   137: ldc_w 400
    //   140: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_0
    //   144: getfield 398	cn/domob/android/f/b:b	Ljava/net/URL;
    //   147: invokevirtual 401	java/net/URL:toString	()Ljava/lang/String;
    //   150: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokevirtual 128	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   159: iconst_1
    //   160: invokestatic 406	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   163: aload_0
    //   164: getfield 174	cn/domob/android/f/b:s	Ljava/net/Proxy;
    //   167: ifnull +342 -> 509
    //   170: aload_0
    //   171: aload_0
    //   172: getfield 398	cn/domob/android/f/b:b	Ljava/net/URL;
    //   175: aload_0
    //   176: getfield 174	cn/domob/android/f/b:s	Ljava/net/Proxy;
    //   179: invokevirtual 410	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   182: checkcast 403	java/net/HttpURLConnection
    //   185: putfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   188: aload_0
    //   189: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   192: ifnull +907 -> 1099
    //   195: aload_0
    //   196: getfield 110	cn/domob/android/f/b:q	Ljava/lang/String;
    //   199: ifnull +27 -> 226
    //   202: aload_0
    //   203: getfield 110	cn/domob/android/f/b:q	Ljava/lang/String;
    //   206: invokevirtual 253	java/lang/String:length	()I
    //   209: ifeq +17 -> 226
    //   212: aload_0
    //   213: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   216: ldc_w 414
    //   219: aload_0
    //   220: getfield 110	cn/domob/android/f/b:q	Ljava/lang/String;
    //   223: invokevirtual 418	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload_0
    //   227: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   230: iconst_0
    //   231: invokevirtual 421	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   234: aload_0
    //   235: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   238: aload_0
    //   239: getfield 118	cn/domob/android/f/b:u	I
    //   242: invokevirtual 424	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   245: aload_0
    //   246: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   249: aload_0
    //   250: getfield 118	cn/domob/android/f/b:u	I
    //   253: invokevirtual 427	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   256: aload_0
    //   257: getfield 112	cn/domob/android/f/b:r	Ljava/util/HashMap;
    //   260: ifnull +289 -> 549
    //   263: aload_0
    //   264: getfield 112	cn/domob/android/f/b:r	Ljava/util/HashMap;
    //   267: invokevirtual 431	java/util/HashMap:keySet	()Ljava/util/Set;
    //   270: invokeinterface 437 1 0
    //   275: astore 7
    //   277: aload 7
    //   279: invokeinterface 442 1 0
    //   284: ifeq +265 -> 549
    //   287: aload 7
    //   289: invokeinterface 446 1 0
    //   294: checkcast 206	java/lang/String
    //   297: astore 6
    //   299: aload_0
    //   300: getfield 112	cn/domob/android/f/b:r	Ljava/util/HashMap;
    //   303: aload 6
    //   305: invokevirtual 230	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   308: checkcast 206	java/lang/String
    //   311: astore_2
    //   312: aload_2
    //   313: ifnull -36 -> 277
    //   316: aload_0
    //   317: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   320: aload 6
    //   322: aload_2
    //   323: invokevirtual 449	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto -49 -> 277
    //   329: astore 4
    //   331: aconst_null
    //   332: astore_2
    //   333: aload_2
    //   334: astore 5
    //   336: aload_3
    //   337: astore 6
    //   339: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   342: aload_0
    //   343: ldc_w 451
    //   346: invokevirtual 338	cn/domob/android/i/f:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   349: aload_2
    //   350: astore 5
    //   352: aload_3
    //   353: astore 6
    //   355: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   358: aload 4
    //   360: invokevirtual 131	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   363: aload_3
    //   364: ifnull +7 -> 371
    //   367: aload_3
    //   368: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   371: aload_2
    //   372: ifnull +7 -> 379
    //   375: aload_2
    //   376: invokevirtual 457	java/io/ByteArrayOutputStream:close	()V
    //   379: return
    //   380: new 395	java/net/URL
    //   383: astore 6
    //   385: new 139	java/lang/StringBuilder
    //   388: astore 7
    //   390: aload 7
    //   392: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   395: aload 6
    //   397: aload 7
    //   399: aload_0
    //   400: getfield 120	cn/domob/android/f/b:h	Ljava/lang/String;
    //   403: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: ldc_w 459
    //   409: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload_0
    //   413: getfield 116	cn/domob/android/f/b:t	Ljava/lang/String;
    //   416: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokespecial 396	java/net/URL:<init>	(Ljava/lang/String;)V
    //   425: aload_0
    //   426: aload 6
    //   428: putfield 398	cn/domob/android/f/b:b	Ljava/net/URL;
    //   431: goto -320 -> 111
    //   434: astore 6
    //   436: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   439: new 139	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 461
    //   449: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: getfield 120	cn/domob/android/f/b:h	Ljava/lang/String;
    //   456: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: ldc_w 463
    //   462: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokevirtual 284	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   471: goto -360 -> 111
    //   474: new 395	java/net/URL
    //   477: astore 6
    //   479: aload 6
    //   481: aload_0
    //   482: getfield 120	cn/domob/android/f/b:h	Ljava/lang/String;
    //   485: invokespecial 396	java/net/URL:<init>	(Ljava/lang/String;)V
    //   488: aload_0
    //   489: aload 6
    //   491: putfield 398	cn/domob/android/f/b:b	Ljava/net/URL;
    //   494: goto -383 -> 111
    //   497: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   500: ldc_w 465
    //   503: invokevirtual 284	cn/domob/android/i/f:e	(Ljava/lang/String;)V
    //   506: goto -395 -> 111
    //   509: aload_0
    //   510: aload_0
    //   511: getfield 398	cn/domob/android/f/b:b	Ljava/net/URL;
    //   514: invokevirtual 468	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   517: checkcast 403	java/net/HttpURLConnection
    //   520: putfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   523: goto -335 -> 188
    //   526: astore_3
    //   527: aconst_null
    //   528: astore_2
    //   529: aload_2
    //   530: ifnull +7 -> 537
    //   533: aload_2
    //   534: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   537: aload 4
    //   539: ifnull +8 -> 547
    //   542: aload 4
    //   544: invokevirtual 457	java/io/ByteArrayOutputStream:close	()V
    //   547: aload_3
    //   548: athrow
    //   549: aload_0
    //   550: getfield 114	cn/domob/android/f/b:p	Ljava/lang/String;
    //   553: ldc 94
    //   555: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   558: ifeq +213 -> 771
    //   561: aload_0
    //   562: getfield 116	cn/domob/android/f/b:t	Ljava/lang/String;
    //   565: ifnull +206 -> 771
    //   568: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   571: ldc_w 470
    //   574: invokevirtual 128	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   577: aload_0
    //   578: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   581: ldc 94
    //   583: invokevirtual 473	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   586: aload_0
    //   587: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   590: iconst_1
    //   591: invokevirtual 476	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   594: aload_0
    //   595: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   598: ldc_w 478
    //   601: ldc_w 480
    //   604: invokevirtual 418	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   607: aload_0
    //   608: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   611: ldc_w 482
    //   614: aload_0
    //   615: getfield 116	cn/domob/android/f/b:t	Ljava/lang/String;
    //   618: invokevirtual 253	java/lang/String:length	()I
    //   621: invokestatic 485	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   624: invokevirtual 418	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   627: aload_0
    //   628: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   631: invokevirtual 489	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   634: astore_2
    //   635: new 491	java/io/BufferedWriter
    //   638: astore 7
    //   640: new 493	java/io/OutputStreamWriter
    //   643: astore 6
    //   645: aload 6
    //   647: aload_2
    //   648: invokespecial 496	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   651: aload 7
    //   653: aload 6
    //   655: sipush 4096
    //   658: invokespecial 499	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   661: aload 7
    //   663: ifnull +26 -> 689
    //   666: aload 7
    //   668: aload_0
    //   669: getfield 116	cn/domob/android/f/b:t	Ljava/lang/String;
    //   672: invokevirtual 502	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   675: aload 7
    //   677: invokevirtual 505	java/io/BufferedWriter:flush	()V
    //   680: aload 7
    //   682: invokevirtual 506	java/io/BufferedWriter:close	()V
    //   685: aload_2
    //   686: invokevirtual 509	java/io/OutputStream:close	()V
    //   689: aload_0
    //   690: aload_0
    //   691: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   694: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   697: putfield 514	cn/domob/android/f/b:y	I
    //   700: aload_0
    //   701: getfield 514	cn/domob/android/f/b:y	I
    //   704: sipush 301
    //   707: if_icmpeq +13 -> 720
    //   710: aload_0
    //   711: getfield 514	cn/domob/android/f/b:y	I
    //   714: sipush 302
    //   717: if_icmpne +73 -> 790
    //   720: new 395	java/net/URL
    //   723: astore_2
    //   724: aload_2
    //   725: aload_0
    //   726: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   729: ldc_w 516
    //   732: invokevirtual 519	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   735: invokespecial 396	java/net/URL:<init>	(Ljava/lang/String;)V
    //   738: aload_0
    //   739: aload_2
    //   740: invokevirtual 468	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   743: checkcast 403	java/net/HttpURLConnection
    //   746: putfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   749: aload_0
    //   750: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   753: iconst_0
    //   754: invokevirtual 421	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   757: aload_0
    //   758: aload_0
    //   759: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   762: invokevirtual 512	java/net/HttpURLConnection:getResponseCode	()I
    //   765: putfield 514	cn/domob/android/f/b:y	I
    //   768: goto -68 -> 700
    //   771: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   774: ldc_w 521
    //   777: invokevirtual 128	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   780: aload_0
    //   781: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   784: invokevirtual 524	java/net/HttpURLConnection:connect	()V
    //   787: goto -98 -> 689
    //   790: aload_0
    //   791: getfield 514	cn/domob/android/f/b:y	I
    //   794: sipush 200
    //   797: if_icmplt +294 -> 1091
    //   800: aload_0
    //   801: getfield 514	cn/domob/android/f/b:y	I
    //   804: sipush 304
    //   807: if_icmpgt +284 -> 1091
    //   810: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   813: astore_2
    //   814: new 139	java/lang/StringBuilder
    //   817: astore 5
    //   819: aload 5
    //   821: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   824: aload_2
    //   825: aload 5
    //   827: ldc_w 526
    //   830: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_0
    //   834: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   837: invokevirtual 530	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   840: invokevirtual 533	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   843: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   846: invokevirtual 128	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   849: new 453	java/io/BufferedInputStream
    //   852: dup
    //   853: aload_0
    //   854: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   857: invokevirtual 537	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   860: sipush 4096
    //   863: invokespecial 540	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   866: astore_2
    //   867: sipush 4096
    //   870: newarray <illegal type>
    //   872: astore_3
    //   873: new 456	java/io/ByteArrayOutputStream
    //   876: astore 5
    //   878: aload 5
    //   880: sipush 4096
    //   883: invokespecial 541	java/io/ByteArrayOutputStream:<init>	(I)V
    //   886: aload_2
    //   887: aload_3
    //   888: invokevirtual 545	java/io/BufferedInputStream:read	([B)I
    //   891: istore_1
    //   892: iload_1
    //   893: iconst_m1
    //   894: if_icmpeq +24 -> 918
    //   897: aload 5
    //   899: aload_3
    //   900: iconst_0
    //   901: iload_1
    //   902: invokevirtual 548	java/io/ByteArrayOutputStream:write	([BII)V
    //   905: goto -19 -> 886
    //   908: astore 4
    //   910: aload_2
    //   911: astore_3
    //   912: aload 5
    //   914: astore_2
    //   915: goto -582 -> 333
    //   918: aload_0
    //   919: aload 5
    //   921: invokevirtual 552	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   924: putfield 554	cn/domob/android/f/b:A	[B
    //   927: new 206	java/lang/String
    //   930: astore_3
    //   931: aload_3
    //   932: aload_0
    //   933: getfield 554	cn/domob/android/f/b:A	[B
    //   936: ldc_w 556
    //   939: invokespecial 559	java/lang/String:<init>	([BLjava/lang/String;)V
    //   942: aload_0
    //   943: aload_3
    //   944: putfield 561	cn/domob/android/f/b:z	Ljava/lang/String;
    //   947: aload_2
    //   948: astore_3
    //   949: aload 5
    //   951: astore_2
    //   952: aload_2
    //   953: astore 5
    //   955: aload_3
    //   956: astore 6
    //   958: aload_0
    //   959: getfield 412	cn/domob/android/f/b:n	Ljava/net/HttpURLConnection;
    //   962: invokevirtual 564	java/net/HttpURLConnection:disconnect	()V
    //   965: aload_3
    //   966: ifnull +7 -> 973
    //   969: aload_3
    //   970: invokevirtual 454	java/io/BufferedInputStream:close	()V
    //   973: aload_2
    //   974: ifnull -595 -> 379
    //   977: aload_2
    //   978: invokevirtual 457	java/io/ByteArrayOutputStream:close	()V
    //   981: goto -602 -> 379
    //   984: astore_2
    //   985: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   988: aload_2
    //   989: invokevirtual 131	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   992: goto -613 -> 379
    //   995: astore_3
    //   996: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   999: aload_3
    //   1000: invokevirtual 131	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1003: goto -30 -> 973
    //   1006: astore_3
    //   1007: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   1010: aload_3
    //   1011: invokevirtual 131	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1014: goto -643 -> 371
    //   1017: astore_2
    //   1018: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   1021: aload_2
    //   1022: invokevirtual 131	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1025: goto -646 -> 379
    //   1028: astore_2
    //   1029: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   1032: aload_2
    //   1033: invokevirtual 131	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1036: goto -499 -> 537
    //   1039: astore_2
    //   1040: getstatic 82	cn/domob/android/f/b:c	Lcn/domob/android/i/f;
    //   1043: aload_2
    //   1044: invokevirtual 131	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   1047: goto -500 -> 547
    //   1050: astore_3
    //   1051: goto -522 -> 529
    //   1054: astore_3
    //   1055: aload 5
    //   1057: astore 4
    //   1059: goto -530 -> 529
    //   1062: astore_3
    //   1063: aload 6
    //   1065: astore_2
    //   1066: aload 5
    //   1068: astore 4
    //   1070: goto -541 -> 529
    //   1073: astore 4
    //   1075: aconst_null
    //   1076: astore 5
    //   1078: aload_2
    //   1079: astore_3
    //   1080: aload 5
    //   1082: astore_2
    //   1083: goto -750 -> 333
    //   1086: astore 4
    //   1088: goto -755 -> 333
    //   1091: aconst_null
    //   1092: astore_2
    //   1093: aload 5
    //   1095: astore_3
    //   1096: goto -144 -> 952
    //   1099: aconst_null
    //   1100: astore_3
    //   1101: goto -136 -> 965
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1104	0	this	b
    //   891	11	1	i1	int
    //   7	971	2	localObject1	Object
    //   984	5	2	localIOException1	java.io.IOException
    //   1017	5	2	localIOException2	java.io.IOException
    //   1028	5	2	localIOException3	java.io.IOException
    //   1039	5	2	localIOException4	java.io.IOException
    //   1065	28	2	localObject2	Object
    //   9	359	3	localObject3	Object
    //   526	22	3	localObject4	Object
    //   872	98	3	localObject5	Object
    //   995	5	3	localIOException5	java.io.IOException
    //   1006	5	3	localIOException6	java.io.IOException
    //   1050	1	3	localObject6	Object
    //   1054	1	3	localObject7	Object
    //   1062	1	3	localObject8	Object
    //   1079	22	3	localObject9	Object
    //   1	1	4	localObject10	Object
    //   329	214	4	localException1	Exception
    //   908	1	4	localException2	Exception
    //   1057	12	4	localObject11	Object
    //   1073	1	4	localException3	Exception
    //   1086	1	4	localException4	Exception
    //   4	1090	5	localObject12	Object
    //   63	364	6	localObject13	Object
    //   434	1	6	localMalformedURLException	java.net.MalformedURLException
    //   477	587	6	localObject14	Object
    //   68	613	7	localObject15	Object
    // Exception table:
    //   from	to	target	type
    //   111	188	329	java/lang/Exception
    //   188	226	329	java/lang/Exception
    //   226	277	329	java/lang/Exception
    //   277	312	329	java/lang/Exception
    //   316	326	329	java/lang/Exception
    //   509	523	329	java/lang/Exception
    //   549	661	329	java/lang/Exception
    //   666	689	329	java/lang/Exception
    //   689	700	329	java/lang/Exception
    //   700	720	329	java/lang/Exception
    //   720	768	329	java/lang/Exception
    //   771	787	329	java/lang/Exception
    //   790	867	329	java/lang/Exception
    //   10	111	434	java/net/MalformedURLException
    //   380	431	434	java/net/MalformedURLException
    //   474	494	434	java/net/MalformedURLException
    //   497	506	434	java/net/MalformedURLException
    //   111	188	526	finally
    //   188	226	526	finally
    //   226	277	526	finally
    //   277	312	526	finally
    //   316	326	526	finally
    //   509	523	526	finally
    //   549	661	526	finally
    //   666	689	526	finally
    //   689	700	526	finally
    //   700	720	526	finally
    //   720	768	526	finally
    //   771	787	526	finally
    //   790	867	526	finally
    //   886	892	908	java/lang/Exception
    //   897	905	908	java/lang/Exception
    //   918	947	908	java/lang/Exception
    //   977	981	984	java/io/IOException
    //   969	973	995	java/io/IOException
    //   367	371	1006	java/io/IOException
    //   375	379	1017	java/io/IOException
    //   533	537	1028	java/io/IOException
    //   542	547	1039	java/io/IOException
    //   867	886	1050	finally
    //   886	892	1054	finally
    //   897	905	1054	finally
    //   918	947	1054	finally
    //   339	349	1062	finally
    //   355	363	1062	finally
    //   958	965	1062	finally
    //   867	886	1073	java/lang/Exception
    //   958	965	1086	java/lang/Exception
  }
  
  public void c(String paramString)
  {
    this.p = paramString;
  }
  
  public void d(String paramString)
  {
    this.q = paramString;
  }
  
  public byte[] d()
  {
    return this.A;
  }
  
  public String e()
  {
    return this.z;
  }
  
  public void e(String paramString)
  {
    this.t = paramString;
  }
  
  public int f()
  {
    return this.y;
  }
  
  public String g()
  {
    return this.t;
  }
  
  public String h()
  {
    c();
    this.j = false;
    long l1;
    if ((this.g) && (this.v != null) && (j(e())))
    {
      c.d(this.h + " has been masked!");
      if (d)
      {
        l1 = s().a("time", -1L);
        if ((l1 > 0L) && (86400000L + l1 < System.currentTimeMillis()))
        {
          e = new HashMap();
          d = false;
          r();
        }
      }
    }
    for (;;)
    {
      if ((this.j) && (w != null))
      {
        c.b(this, "Call test listener");
        w.a(this);
      }
      return this.z;
      if (l1 == -1L) {
        t();
      }
      this.j = true;
      continue;
      r();
      continue;
      this.j = true;
    }
  }
  
  public boolean i()
  {
    return this.g;
  }
  
  public String j()
  {
    return this.h;
  }
  
  public Context k()
  {
    return this.o;
  }
  
  public String l()
  {
    return this.p;
  }
  
  public String m()
  {
    return this.q;
  }
  
  public HashMap<String, String> n()
  {
    return this.r;
  }
  
  public String o()
  {
    return this.t;
  }
  
  public int p()
  {
    return this.u;
  }
  
  static abstract interface a
  {
    public abstract void a(b paramb);
  }
  
  public static abstract interface b
  {
    public abstract String a();
    
    public abstract void a(String paramString);
    
    public abstract String[] b();
    
    public abstract String c();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\f\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */