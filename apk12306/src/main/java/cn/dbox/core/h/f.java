package cn.dbox.core.h;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.util.Log;
import cn.dbox.core.c;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Key;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class f
{
  private static d a = new d(f.class.getSimpleName());
  private static final String b = "DES";
  private static final String c = "com.android.browser";
  private static final String d = "com.google.android.browser";
  private static final String e = "com.android.browser.BrowserActivity";
  private static final char[] f = { 100, 111, 109, 111, 98 };
  private static final String g = "cn.domob.ui.main.DViewManager";
  private static final String h = "showWall";
  
  public static Intent a(Context paramContext, Uri paramUri)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (paramUri != null)
      {
        if (!e.a(paramContext, "com.android.browser")) {
          break label60;
        }
        paramUri = new Intent("android.intent.action.VIEW", paramUri);
        paramUri.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
      }
    }
    for (;;)
    {
      if (paramContext.getPackageManager().resolveActivity(paramUri, 65536) == null) {}
      for (localObject1 = localObject2;; localObject1 = paramUri)
      {
        return (Intent)localObject1;
        label60:
        if (!e.a(paramContext, "com.google.android.browser")) {
          break label97;
        }
        paramUri = new Intent("android.intent.action.VIEW", paramUri);
        paramUri.setClassName("com.google.android.browser", "com.android.browser.BrowserActivity");
        break;
      }
      label97:
      paramUri = null;
    }
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f3;
    float f1;
    float f6;
    float f5;
    float f2;
    float f4;
    if (i <= j)
    {
      f3 = i / 2;
      f1 = i;
      f6 = i;
      f5 = i;
      f2 = i;
      j = i;
      f4 = 0.0F;
    }
    for (;;)
    {
      Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect2 = new Rect((int)f4, (int)0.0F, (int)f6, (int)f1);
      Rect localRect1 = new Rect((int)0.0F, (int)0.0F, (int)f5, (int)f2);
      RectF localRectF = new RectF(localRect1);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, f3, f3, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect2, localRect1, localPaint);
      return localBitmap;
      f3 = j / 2;
      f4 = (i - j) / 2;
      f6 = i - f4;
      f1 = j;
      f5 = j;
      f2 = j;
      i = j;
    }
  }
  
  public static String a()
  {
    return new String(f);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = paramString1.getBytes("UTF-8");
      paramString1 = new byte[16];
      System.arraycopy(localObject, 0, paramString1, 0, Math.min(localObject.length, 16));
      paramString2 = paramString2.getBytes("UTF-8");
      localObject = new javax/crypto/spec/SecretKeySpec;
      ((SecretKeySpec)localObject).<init>(paramString1, "AES");
      paramString1 = Cipher.getInstance("AES/ECB/PKCS7Padding");
      paramString1.init(1, (Key)localObject);
      paramString2 = a.b(paramString1.doFinal(paramString2), 2);
      paramString1 = new java/lang/String;
      paramString1.<init>(paramString2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1 = "";
      }
    }
  }
  
  public static String a(HashMap<String, String> paramHashMap)
  {
    Object localObject1;
    StringBuilder localStringBuilder;
    Object localObject2;
    try
    {
      localObject1 = new java/util/ArrayList;
      ((ArrayList)localObject1).<init>();
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localObject2 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject2).<init>(str, (String)paramHashMap.get(str));
        ((List)localObject1).add(localObject2);
        continue;
        return paramHashMap;
      }
    }
    catch (Exception paramHashMap)
    {
      a.a(paramHashMap);
      paramHashMap = null;
    }
    for (;;)
    {
      paramHashMap = new org/apache/http/client/entity/UrlEncodedFormEntity;
      paramHashMap.<init>((List)localObject1, "UTF-8");
      localObject1 = new java/io/BufferedReader;
      localObject2 = new java/io/InputStreamReader;
      ((InputStreamReader)localObject2).<init>(paramHashMap.getContent());
      ((BufferedReader)localObject1).<init>((Reader)localObject2);
      for (;;)
      {
        paramHashMap = ((BufferedReader)localObject1).readLine();
        if (paramHashMap == null) {
          break;
        }
        localStringBuilder.append(paramHashMap);
      }
      paramHashMap = localStringBuilder.toString();
    }
  }
  
  private static String a(byte[] paramArrayOfByte, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    if (i < j)
    {
      paramString = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (paramString.length() == 1) {
        localStringBuilder.append("0").append(paramString);
      }
      for (;;)
      {
        i++;
        break;
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    new AlertDialog.Builder(paramContext).setTitle(paramString1).setMessage(paramString2).setNegativeButton("确定", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        ((Activity)this.a).finish();
      }
    }).show();
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder("DrwSDK 缺少权限：\n");
    if ((-1 == paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE")) && (e.a(3, false)))
    {
      Log.e("DrwSDK", "you must have android.permission.WRITE_EXTERNAL_STORAGE permission !");
      localStringBuilder.append("android.permission.WRITE_EXTERNAL_STORAGE \n");
    }
    for (int i = 1;; i = 0)
    {
      if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.INTERNET"))
      {
        Log.e("DrwSDK", "you must have android.permission.INTERNET permission !");
        localStringBuilder.append("android.permission.INTERNET \n");
        i = 1;
      }
      if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE"))
      {
        Log.e("DrwSDK", "you must have android.permission.READ_PHONE_STATE permission !");
        localStringBuilder.append("android.permission.READ_PHONE_STATE \n");
        i = 1;
      }
      if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE"))
      {
        Log.e("DrwSDK", "you must have android.permission.ACCESS_NETWORK_STATE permission !");
        localStringBuilder.append("android.permission.ACCESS_NETWORK_STATE \n");
        i = 1;
      }
      try
      {
        if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION"))
        {
          Log.e("DrwSDK", "you must have android.permission.ACCESS_COARSE_LOCATION permission !");
          localStringBuilder.append("android.permission.ACCESS_COARSE_LOCATION \n");
          i = 1;
        }
        if (i != 0) {
          a(paramContext, "DrwSDK", localStringBuilder.toString());
        }
        if (i != 0) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          a.a(paramContext);
          Log.e("SDK", "checking android.permission.ACCESS_COARSE_LOCATION throws exception");
          bool = false;
          continue;
          bool = false;
        }
      }
      return bool;
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    try
    {
      int i = paramContext.checkCallingOrSelfPermission(paramString);
      if (i == 0) {
        bool = true;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
      }
    }
    return bool;
  }
  
  public static boolean a(c paramc)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        if (!e()) {
          continue;
        }
        if ((paramc.d() != null) && (paramc.c() != null)) {
          continue;
        }
        Log.e("", "not set adwall ppid and ipb");
      }
      catch (Exception paramc)
      {
        a.a(paramc);
        continue;
      }
      catch (Error paramc)
      {
        a.a(paramc);
        continue;
      }
      return bool;
      bool = true;
      continue;
      Log.e("", "local has not adwall sdk");
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static Drawable b(Context paramContext, String paramString)
    throws Exception
  {
    a.b(" load source file:" + paramString);
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(paramString);
      paramContext = new android/graphics/drawable/BitmapDrawable;
      paramContext.<init>(localBitmap);
      return paramContext;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        System.gc();
        a.d("out of memory");
        paramContext = null;
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
        a.e("Failed to load source file:" + paramString);
        paramContext = null;
      }
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(Integer.valueOf("000900".substring(0, 2))).append(".").append(Integer.valueOf("000900".substring(2, 4))).append(".").append(Integer.valueOf("000900".substring(4, 6)));
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
        String str = "000900";
      }
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new javax/crypto/spec/DESKeySpec;
      ((DESKeySpec)localObject).<init>(paramString1.getBytes());
      SecretKey localSecretKey = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
      paramString1 = Cipher.getInstance("DES");
      localObject = new javax/crypto/spec/IvParameterSpec;
      ((IvParameterSpec)localObject).<init>("12345678".getBytes());
      paramString1.init(1, localSecretKey, (AlgorithmParameterSpec)localObject);
      paramString1 = a.a(paramString1.doFinal(paramString2.getBytes()), 2);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        a.b("des encode error");
        paramString1 = null;
      }
    }
  }
  
  public static HashMap<String, String> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      String[] arrayOfString1 = paramString.split("&");
      int j = arrayOfString1.length;
      int i = 0;
      for (;;)
      {
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          try
          {
            if (arrayOfString2.length == 2) {
              localHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), URLDecoder.decode(arrayOfString2[1], "UTF-8"));
            }
            for (;;)
            {
              i++;
              break;
              localHashMap.put(URLDecoder.decode(arrayOfString2[0], "UTF-8"), "");
            }
          }
          catch (UnsupportedEncodingException localUnsupportedEncodingException)
          {
            for (;;)
            {
              a.a(localUnsupportedEncodingException);
              a.e("URL decode params String error:" + paramString);
            }
          }
        }
      }
    }
    return localHashMap;
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
      a.c("access wifi state is enabled");
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String c()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("20140918".substring(0, 4)).append("-").append("20140918".substring(4, 6)).append("-").append("20140918".substring(6, 8));
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
        String str = "20140918";
      }
    }
  }
  
  public static String c(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      paramString = "";
    }
    for (;;)
    {
      return paramString;
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.reset();
        localMessageDigest.update(paramString.getBytes("UTF-8"));
        paramString = a(localMessageDigest.digest(), "");
      }
      catch (Exception paramString)
      {
        a.a(paramString);
        paramString = "";
      }
    }
  }
  
  public static boolean c(Context paramContext)
  {
    if (((WifiManager)paramContext.getSystemService("wifi")).getWifiState() == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramString != null) && (!paramString.equals(""))) {}
    for (boolean bool = e.a(paramContext, paramString);; bool = false) {
      return bool;
    }
  }
  
  public static String d()
  {
    return new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINESE).format(new Date());
  }
  
  /* Error */
  public static String d(String paramString)
  {
    // Byte code:
    //   0: new 564	java/io/FileInputStream
    //   3: astore_2
    //   4: aload_2
    //   5: aload_0
    //   6: invokespecial 565	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: aload_2
    //   10: astore_0
    //   11: sipush 1024
    //   14: newarray <illegal type>
    //   16: astore 4
    //   18: aload_2
    //   19: astore_0
    //   20: ldc_w 510
    //   23: invokestatic 515	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_3
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload 4
    //   32: invokevirtual 571	java/io/InputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +78 -> 115
    //   40: aload_2
    //   41: astore_0
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 574	java/security/MessageDigest:update	([BII)V
    //   50: goto -23 -> 27
    //   53: astore_3
    //   54: aload_2
    //   55: astore_0
    //   56: getstatic 45	cn/dbox/core/h/f:a	Lcn/dbox/core/h/d;
    //   59: astore 4
    //   61: aload_2
    //   62: astore_0
    //   63: new 222	java/lang/StringBuilder
    //   66: astore 5
    //   68: aload_2
    //   69: astore_0
    //   70: aload 5
    //   72: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   75: aload_2
    //   76: astore_0
    //   77: aload 4
    //   79: ldc -40
    //   81: aload 5
    //   83: ldc_w 576
    //   86: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 579	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 294	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 582	cn/dbox/core/h/d:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 585	java/io/InputStream:close	()V
    //   110: ldc -40
    //   112: astore_3
    //   113: aload_3
    //   114: areturn
    //   115: aload_2
    //   116: astore_0
    //   117: aload_3
    //   118: invokevirtual 524	java/security/MessageDigest:digest	()[B
    //   121: ldc -40
    //   123: invokestatic 526	cn/dbox/core/h/f:a	([BLjava/lang/String;)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_3
    //   128: astore_0
    //   129: aload_0
    //   130: astore_3
    //   131: aload_2
    //   132: ifnull -19 -> 113
    //   135: aload_2
    //   136: invokevirtual 585	java/io/InputStream:close	()V
    //   139: aload_0
    //   140: astore_3
    //   141: goto -28 -> 113
    //   144: astore_2
    //   145: getstatic 45	cn/dbox/core/h/f:a	Lcn/dbox/core/h/d;
    //   148: aload_2
    //   149: invokevirtual 263	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   152: aload_0
    //   153: astore_3
    //   154: goto -41 -> 113
    //   157: astore_0
    //   158: getstatic 45	cn/dbox/core/h/f:a	Lcn/dbox/core/h/d;
    //   161: aload_0
    //   162: invokevirtual 263	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   165: goto -55 -> 110
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 585	java/io/InputStream:close	()V
    //   179: aload_2
    //   180: athrow
    //   181: astore_0
    //   182: getstatic 45	cn/dbox/core/h/f:a	Lcn/dbox/core/h/d;
    //   185: aload_0
    //   186: invokevirtual 263	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   189: goto -10 -> 179
    //   192: astore_2
    //   193: goto -22 -> 171
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_2
    //   199: goto -145 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	paramString	String
    //   35	12	1	i	int
    //   3	133	2	localFileInputStream	java.io.FileInputStream
    //   144	5	2	localIOException	java.io.IOException
    //   168	12	2	localObject1	Object
    //   192	1	2	localObject2	Object
    //   198	1	2	localObject3	Object
    //   26	17	3	localMessageDigest	MessageDigest
    //   53	37	3	localException1	Exception
    //   112	42	3	str	String
    //   196	1	3	localException2	Exception
    //   16	62	4	localObject4	Object
    //   66	16	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	18	53	java/lang/Exception
    //   20	27	53	java/lang/Exception
    //   29	36	53	java/lang/Exception
    //   42	50	53	java/lang/Exception
    //   117	127	53	java/lang/Exception
    //   135	139	144	java/io/IOException
    //   106	110	157	java/io/IOException
    //   0	9	168	finally
    //   175	179	181	java/io/IOException
    //   11	18	192	finally
    //   20	27	192	finally
    //   29	36	192	finally
    //   42	50	192	finally
    //   56	61	192	finally
    //   63	68	192	finally
    //   70	75	192	finally
    //   77	102	192	finally
    //   117	127	192	finally
    //   0	9	196	java/lang/Exception
  }
  
  public static boolean d(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {}
    }
    for (boolean bool = paramContext.isAvailable();; bool = false)
    {
      if (bool) {
        a.b("Check your network connection is normal");
      }
      for (;;)
      {
        return bool;
        a.b("Check the network connection is abnormal");
      }
    }
  }
  
  public static boolean e()
  {
    return h("cn.domob.ui.main.DViewManager");
  }
  
  public static boolean e(String paramString)
  {
    if (paramString == null) {}
    for (boolean bool = false;; bool = Pattern.compile("[0-9]*").matcher(paramString).matches()) {
      return bool;
    }
  }
  
  public static String f(String paramString)
  {
    return String.format(paramString, new Object[] { new String(f) });
  }
  
  public static boolean g(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean h(String paramString)
  {
    try
    {
      Class.forName(paramString);
      bool = true;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
    return bool;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\h\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */