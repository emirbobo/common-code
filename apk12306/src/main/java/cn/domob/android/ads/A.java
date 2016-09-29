package cn.domob.android.ads;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import cn.domob.android.f.c;
import cn.domob.android.f.g;
import cn.domob.android.i.f;
import cn.domob.android.i.h;

public abstract class a
  extends WebView
{
  public static final int c = -1;
  private static f d = new f(a.class.getSimpleName());
  private static final int o = 20;
  public a.a a;
  public a.b b;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private int j;
  private boolean k = false;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private String p;
  private g q;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext);
    c();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginState(WebSettings.PluginState.ON);
    getSettings().setCacheMode(-1);
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    this.j = 20;
    if (paramInt != -1)
    {
      d.a("Init WebView with custom background color.");
      setBackgroundColor(paramInt);
    }
    setWebViewClient(new a.1(this));
    setWebChromeClient(new a.2(this));
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 146	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: invokevirtual 150	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   7: astore 4
    //   9: new 152	java/lang/StringBuilder
    //   12: astore_3
    //   13: aload_3
    //   14: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   17: aload 4
    //   19: aload_3
    //   20: ldc -100
    //   22: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_1
    //   26: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 169	java/lang/ClassLoader:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore 4
    //   37: aload 4
    //   39: ifnonnull +22 -> 61
    //   42: ldc -85
    //   44: astore_1
    //   45: aload_1
    //   46: areturn
    //   47: astore_1
    //   48: getstatic 64	cn/domob/android/ads/a:d	Lcn/domob/android/i/f;
    //   51: aload_1
    //   52: invokevirtual 174	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   55: ldc -85
    //   57: astore_1
    //   58: goto -13 -> 45
    //   61: new 152	java/lang/StringBuilder
    //   64: astore_3
    //   65: aload_3
    //   66: invokespecial 154	java/lang/StringBuilder:<init>	()V
    //   69: aload_3
    //   70: aload_0
    //   71: invokevirtual 178	cn/domob/android/ads/a:getContext	()Landroid/content/Context;
    //   74: invokevirtual 184	android/content/Context:getFilesDir	()Ljava/io/File;
    //   77: invokevirtual 189	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: getstatic 192	java/io/File:separator	Ljava/lang/String;
    //   86: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_1
    //   90: invokevirtual 160	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_3
    //   97: new 186	java/io/File
    //   100: dup
    //   101: aload_3
    //   102: invokespecial 193	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore_1
    //   106: new 195	java/io/FileOutputStream
    //   109: astore 5
    //   111: aload 5
    //   113: aload_1
    //   114: invokespecial 198	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   117: sipush 8192
    //   120: newarray <illegal type>
    //   122: astore_1
    //   123: aload 4
    //   125: aload_1
    //   126: invokevirtual 204	java/io/InputStream:read	([B)I
    //   129: istore_2
    //   130: iload_2
    //   131: iconst_m1
    //   132: if_icmpeq +74 -> 206
    //   135: aload 5
    //   137: aload_1
    //   138: iconst_0
    //   139: iload_2
    //   140: invokevirtual 208	java/io/FileOutputStream:write	([BII)V
    //   143: goto -20 -> 123
    //   146: astore_1
    //   147: ldc -85
    //   149: astore_3
    //   150: aload_3
    //   151: astore_1
    //   152: aload 4
    //   154: ifnull -109 -> 45
    //   157: aload_3
    //   158: astore_1
    //   159: aload 5
    //   161: ifnull -116 -> 45
    //   164: aload 4
    //   166: invokevirtual 211	java/io/InputStream:close	()V
    //   169: aload 5
    //   171: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   174: aload_3
    //   175: astore_1
    //   176: goto -131 -> 45
    //   179: astore_1
    //   180: aload_3
    //   181: astore_1
    //   182: goto -137 -> 45
    //   185: astore_1
    //   186: getstatic 64	cn/domob/android/ads/a:d	Lcn/domob/android/i/f;
    //   189: aload_1
    //   190: invokevirtual 174	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   193: ldc -85
    //   195: astore_1
    //   196: goto -151 -> 45
    //   199: astore_1
    //   200: ldc -85
    //   202: astore_1
    //   203: goto -158 -> 45
    //   206: aload_3
    //   207: astore_1
    //   208: aload 4
    //   210: ifnull -165 -> 45
    //   213: aload_3
    //   214: astore_1
    //   215: aload 5
    //   217: ifnull -172 -> 45
    //   220: aload 4
    //   222: invokevirtual 211	java/io/InputStream:close	()V
    //   225: aload 5
    //   227: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   230: aload_3
    //   231: astore_1
    //   232: goto -187 -> 45
    //   235: astore_1
    //   236: aload_3
    //   237: astore_1
    //   238: goto -193 -> 45
    //   241: astore_1
    //   242: aload 4
    //   244: ifnull +18 -> 262
    //   247: aload 5
    //   249: ifnull +13 -> 262
    //   252: aload 4
    //   254: invokevirtual 211	java/io/InputStream:close	()V
    //   257: aload 5
    //   259: invokevirtual 212	java/io/FileOutputStream:close	()V
    //   262: aload_1
    //   263: athrow
    //   264: astore_3
    //   265: goto -3 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	a
    //   0	268	1	paramString	String
    //   129	11	2	i1	int
    //   12	225	3	localObject1	Object
    //   264	1	3	localIOException	java.io.IOException
    //   7	246	4	localObject2	Object
    //   109	149	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	37	47	java/lang/Exception
    //   123	130	146	java/io/IOException
    //   135	143	146	java/io/IOException
    //   164	174	179	java/io/IOException
    //   61	97	185	java/lang/Exception
    //   106	117	199	java/io/FileNotFoundException
    //   220	230	235	java/io/IOException
    //   123	130	241	finally
    //   135	143	241	finally
    //   252	262	264	java/io/IOException
  }
  
  private void c()
  {
    setHorizontalScrollBarEnabled(false);
    setHorizontalScrollbarOverlay(false);
    setVerticalScrollBarEnabled(false);
    setVerticalScrollbarOverlay(false);
    getSettings().setSupportZoom(false);
  }
  
  private void d()
  {
    if ((this.b != null) && (!this.n))
    {
      this.n = true;
      d.a("WebView finish callback.");
      this.b.a(this);
    }
  }
  
  private void e()
  {
    if ((this.b != null) && (!this.n))
    {
      this.n = true;
      d.a("WebView failed callback.");
      this.b.b(this);
    }
  }
  
  private void f()
  {
    if ((this.b != null) && (!this.n))
    {
      this.n = true;
      d.a("WebView timeout callback.");
      this.b.c(this);
    }
  }
  
  public String a(String paramString, String[] paramArrayOfString)
  {
    String str = paramString;
    if (paramArrayOfString != null)
    {
      str = paramString;
      if (paramArrayOfString.length != 0)
      {
        int i2 = paramArrayOfString.length;
        for (int i1 = 0;; i1++)
        {
          str = paramString;
          if (i1 >= i2) {
            break;
          }
          str = paramArrayOfString[i1];
          d.a("Insert js file :" + str);
          str = "file://" + b(str);
          d.a("JS file path :" + str);
          paramString = "<script src=\"" + str + "\"></script>" + paramString;
        }
      }
    }
    return str;
  }
  
  public void a()
  {
    if ((this.e != null) || (this.f != null) || (this.g != null) || (this.h != null) || (this.i != null))
    {
      getSettings().setUseWideViewPort(true);
      super.loadDataWithBaseURL(this.e, this.f, this.g, this.h, this.i);
    }
  }
  
  public void a(int paramInt)
  {
    d.a("WebView's timeout is set as :" + paramInt);
    this.j = paramInt;
  }
  
  public void a(a.a parama)
  {
    this.a = parama;
  }
  
  public void a(a.b paramb)
  {
    this.b = paramb;
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      localObject = "javascript:" + paramString;
      d.b(String.format("BaseWebView instance executes js: %s", new Object[] { localObject }));
      Activity localActivity = (Activity)getContext();
      paramString = new cn/domob/android/ads/a$3;
      paramString.<init>(this, (String)localObject);
      localActivity.runOnUiThread(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    d.a(String.format("Load WebView with url = %s and data = %s.", new Object[] { paramString1, paramString2 }));
    new a.c(this).start();
    int i1;
    int i2;
    if (!h.e(paramString1))
    {
      i1 = 1;
      if (h.e(paramString2)) {
        break label74;
      }
      i2 = 1;
      label54:
      if ((i1 == 0) || (i2 != 0)) {
        break label80;
      }
      loadUrl(paramString1);
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label74:
      i2 = 0;
      break label54;
      label80:
      if ((i1 == 0) && (i2 != 0)) {
        loadData(paramString2, "text/html", "UTF-8");
      } else if ((i1 != 0) && (i2 != 0)) {
        loadDataWithBaseURL(paramString1 + "/", paramString2, "text/html", "UTF-8", null);
      } else {
        d.e(String.format("Error happened when loading WebView with URL = %s and data = %s", new Object[] { paramString1, paramString2 }));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    loadDataWithBaseURL(null, paramString1, paramString2, paramString3, null);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!h.e(paramString2))
    {
      paramString2 = a(paramString2, null);
      this.e = paramString1;
      this.f = paramString2;
      this.g = paramString3;
      this.h = paramString4;
      this.i = paramString5;
      super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
    }
    for (;;)
    {
      return;
      d.e("Data is null or empty while calling 'loadDataWithBaseURL'.");
    }
  }
  
  public void loadUrl(String paramString)
  {
    this.p = paramString;
    try
    {
      if (paramString.startsWith("javascript:")) {
        super.loadUrl(paramString);
      }
      for (;;)
      {
        return;
        d.a(String.format("loadUrl() is called with url = %s.", new Object[] { paramString }));
        a.4 local4 = new cn/domob/android/ads/a$4;
        local4.<init>(this);
        this.q = local4;
        c.a().a(getContext(), paramString, null, this.q);
      }
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\A.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */