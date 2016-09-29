package cn.domob.android.offerwall;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class l
{
  private static m a = new m(l.class.getSimpleName());
  
  public static Drawable a(Context paramContext, String paramString)
  {
    try
    {
      BitmapDrawable localBitmapDrawable = new android/graphics/drawable/BitmapDrawable;
      localBitmapDrawable.<init>(BitmapFactory.decodeStream(paramContext.getAssets().open(paramString)));
      paramContext = localBitmapDrawable;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        a.a(paramContext);
        a.e("Failed to load source file:" + paramString);
        paramContext = null;
      }
    }
    return paramContext;
  }
  
  public static String a()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(Integer.valueOf("020000".substring(0, 2))).append(".").append(Integer.valueOf("020000".substring(2, 4))).append(".").append(Integer.valueOf("020000".substring(4, 6)));
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
        String str = "020000";
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
      localObject2 = new org/apache/http/client/entity/UrlEncodedFormEntity;
      ((UrlEncodedFormEntity)localObject2).<init>((List)localObject1, "UTF-8");
      paramHashMap = new java/io/BufferedReader;
      localObject1 = new java/io/InputStreamReader;
      ((InputStreamReader)localObject1).<init>(((HttpEntity)localObject2).getContent());
      paramHashMap.<init>((Reader)localObject1);
      for (;;)
      {
        localObject1 = paramHashMap.readLine();
        if (localObject1 == null) {
          break;
        }
        localStringBuilder.append((String)localObject1);
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
  
  public static HashMap<String, String> a(String paramString)
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
    StringBuilder localStringBuilder = new StringBuilder("DomobSDK 缺少权限：\n");
    if ((-1 == paramContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE")) && (f.a(3, false)))
    {
      Log.e("DomobSDK", "you must have android.permission.WRITE_EXTERNAL_STORAGE permission !");
      localStringBuilder.append("android.permission.WRITE_EXTERNAL_STORAGE \n");
    }
    for (int i = 1;; i = 0)
    {
      if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.INTERNET"))
      {
        Log.e("DomobSDK", "you must have android.permission.INTERNET permission !");
        localStringBuilder.append("android.permission.INTERNET \n");
        i = 1;
      }
      if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE"))
      {
        Log.e("DomobSDK", "you must have android.permission.READ_PHONE_STATE permission !");
        localStringBuilder.append("android.permission.READ_PHONE_STATE \n");
        i = 1;
      }
      if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE"))
      {
        Log.e("DomobSDK", "you must have android.permission.ACCESS_NETWORK_STATE permission !");
        localStringBuilder.append("android.permission.ACCESS_NETWORK_STATE \n");
        i = 1;
      }
      if (-1 == paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION"))
      {
        Log.e("DomobSDK", "you must have android.permission.ACCESS_COARSE_LOCATION permission !");
        localStringBuilder.append("android.permission.ACCESS_COARSE_LOCATION \n");
        i = 1;
      }
      if (i != 0) {
        a(paramContext, "DomobSDK", localStringBuilder.toString());
      }
      if (i == 0) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
    }
  }
  
  public static String b()
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("20120809".substring(0, 4)).append("-").append("20120809".substring(4, 6)).append("-").append("20120809".substring(6, 8));
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
        String str = "20120809";
      }
    }
  }
  
  public static String b(Context paramContext, String paramString)
  {
    String str2 = Build.MODEL;
    String str1 = "1.5";
    if (Build.VERSION.RELEASE.length() > 0) {
      str1 = Build.VERSION.RELEASE;
    }
    paramContext = String.format("<script>var SDK_VERSION = '%s'; var DEVICE = '%s'; var OS = '%s'; var OS_VERSION = '%s'; var CARRIER = '%s'; var NETWORK = '%s';</script>", new Object[] { "020000", str2, "android", str1, f.q(paramContext), f.o(paramContext) });
    return paramContext + paramString;
  }
  
  public static String b(String paramString)
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
  
  /* Error */
  public static String c(String paramString)
  {
    // Byte code:
    //   0: new 338	java/io/FileInputStream
    //   3: astore_2
    //   4: aload_2
    //   5: aload_0
    //   6: invokespecial 339	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: aload_2
    //   10: astore_0
    //   11: sipush 1024
    //   14: newarray <illegal type>
    //   16: astore 4
    //   18: aload_2
    //   19: astore_0
    //   20: ldc_w 312
    //   23: invokestatic 318	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_3
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload 4
    //   32: invokevirtual 345	java/io/InputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +78 -> 115
    //   40: aload_2
    //   41: astore_0
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 348	java/security/MessageDigest:update	([BII)V
    //   50: goto -23 -> 27
    //   53: astore_3
    //   54: aload_2
    //   55: astore_0
    //   56: getstatic 24	cn/domob/android/offerwall/l:a	Lcn/domob/android/offerwall/m;
    //   59: astore 5
    //   61: aload_2
    //   62: astore_0
    //   63: new 58	java/lang/StringBuilder
    //   66: astore 4
    //   68: aload_2
    //   69: astore_0
    //   70: aload 4
    //   72: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   75: aload_2
    //   76: astore_0
    //   77: aload 5
    //   79: ldc -60
    //   81: aload 4
    //   83: ldc_w 350
    //   86: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_3
    //   90: invokevirtual 353	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   93: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokevirtual 356	cn/domob/android/offerwall/m:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 359	java/io/InputStream:close	()V
    //   110: ldc -60
    //   112: astore_3
    //   113: aload_3
    //   114: areturn
    //   115: aload_2
    //   116: astore_0
    //   117: aload_3
    //   118: invokevirtual 333	java/security/MessageDigest:digest	()[B
    //   121: ldc -60
    //   123: invokestatic 335	cn/domob/android/offerwall/l:a	([BLjava/lang/String;)Ljava/lang/String;
    //   126: astore_3
    //   127: aload_3
    //   128: astore_0
    //   129: aload_0
    //   130: astore_3
    //   131: aload_2
    //   132: ifnull -19 -> 113
    //   135: aload_2
    //   136: invokevirtual 359	java/io/InputStream:close	()V
    //   139: aload_0
    //   140: astore_3
    //   141: goto -28 -> 113
    //   144: astore_2
    //   145: getstatic 24	cn/domob/android/offerwall/l:a	Lcn/domob/android/offerwall/m;
    //   148: aload_2
    //   149: invokevirtual 56	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   152: aload_0
    //   153: astore_3
    //   154: goto -41 -> 113
    //   157: astore_0
    //   158: getstatic 24	cn/domob/android/offerwall/l:a	Lcn/domob/android/offerwall/m;
    //   161: aload_0
    //   162: invokevirtual 56	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
    //   165: goto -55 -> 110
    //   168: astore_2
    //   169: aconst_null
    //   170: astore_0
    //   171: aload_0
    //   172: ifnull +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 359	java/io/InputStream:close	()V
    //   179: aload_2
    //   180: athrow
    //   181: astore_0
    //   182: getstatic 24	cn/domob/android/offerwall/l:a	Lcn/domob/android/offerwall/m;
    //   185: aload_0
    //   186: invokevirtual 56	cn/domob/android/offerwall/m:a	(Ljava/lang/Throwable;)V
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
    //   144	5	2	localIOException	IOException
    //   168	12	2	localObject1	Object
    //   192	1	2	localObject2	Object
    //   198	1	2	localObject3	Object
    //   26	17	3	localMessageDigest	MessageDigest
    //   53	37	3	localException1	Exception
    //   112	42	3	str	String
    //   196	1	3	localException2	Exception
    //   16	66	4	localObject4	Object
    //   59	19	5	localm	m
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
  
  public static boolean d(String paramString)
  {
    return Pattern.compile("[0-9]*").matcher(paramString).matches();
  }
  
  public static boolean e(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */