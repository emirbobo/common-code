package cn.domob.android.i;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.Key;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

public class h
{
  private static f a = new f(h.class.getSimpleName());
  private static final String b = "DES";
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {}
    for (;;)
    {
      int i = 2;
      int m = 1;
      int j = paramInt1;
      paramInt1 = i;
      i = paramInt2;
      paramInt2 = j;
      while (paramInt1 <= i)
      {
        int n = m;
        int k = paramInt2;
        j = i;
        if (i % paramInt1 == 0)
        {
          n = m;
          k = paramInt2;
          j = i;
          if (paramInt2 % paramInt1 == 0)
          {
            n = m * paramInt1;
            j = i / paramInt1;
            k = paramInt2 / paramInt1;
          }
        }
        paramInt1++;
        m = n;
        paramInt2 = k;
        i = j;
      }
      return m;
      i = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
  }
  
  public static String a()
  {
    return new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINESE).format(new Date());
  }
  
  public static String a(int paramInt)
  {
    Random localRandom = new Random();
    int i = 0;
    Object localObject2 = "";
    if (i < paramInt)
    {
      String str;
      label35:
      int j;
      label59:
      Object localObject1;
      if (localRandom.nextInt(2) % 2 == 0)
      {
        str = "char";
        if (!"char".equalsIgnoreCase(str)) {
          break label110;
        }
        if (localRandom.nextInt(2) % 2 != 0) {
          break label104;
        }
        j = 65;
        localObject1 = (String)localObject2 + (char)(j + localRandom.nextInt(26));
      }
      for (;;)
      {
        i++;
        localObject2 = localObject1;
        break;
        str = "num";
        break label35;
        label104:
        j = 97;
        break label59;
        label110:
        localObject1 = localObject2;
        if ("num".equalsIgnoreCase(str)) {
          localObject1 = (String)localObject2 + String.valueOf(localRandom.nextInt(10));
        }
      }
    }
    return (String)localObject2;
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
      paramString2 = b.b(paramString1.doFinal(paramString2), 2);
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
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      Object localObject = new javax/crypto/spec/DESKeySpec;
      ((DESKeySpec)localObject).<init>(paramString1.getBytes());
      localObject = SecretKeyFactory.getInstance("DES").generateSecret((KeySpec)localObject);
      Cipher localCipher = Cipher.getInstance("DES");
      paramString1 = new javax/crypto/spec/IvParameterSpec;
      paramString1.<init>("12345678".getBytes());
      localCipher.init(1, (Key)localObject, paramString1);
      paramString1 = b.a(localCipher.doFinal(paramString2.getBytes()), 2);
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
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    for (boolean bool = false;; bool = Pattern.compile("[0-9]*").matcher(paramString).matches()) {
      return bool;
    }
  }
  
  public static String c(String paramString)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(Integer.valueOf(paramString.substring(0, 2))).append(".").append(Integer.valueOf(paramString.substring(2, 4))).append(".").append(Integer.valueOf(paramString.substring(4, 6)));
      localObject = ((StringBuilder)localObject).toString();
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
      }
    }
    return paramString;
  }
  
  public static String d(String paramString)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append(paramString.substring(0, 4)).append("-").append(paramString.substring(4, 6)).append("-").append(paramString.substring(6, 8));
      localObject = ((StringBuilder)localObject).toString();
      paramString = (String)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a.a(localException);
      }
    }
    return paramString;
  }
  
  public static boolean e(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */