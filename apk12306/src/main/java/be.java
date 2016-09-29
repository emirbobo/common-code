import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import com.arrownock.push.PushService;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class be
{
  private static be jdField_a_of_type_Be = null;
  private static final String jdField_a_of_type_JavaLangString = be.class.getName();
  private static final boolean jdField_a_of_type_Boolean = cm.b.booleanValue();
  private Context jdField_a_of_type_AndroidContentContext = null;
  private String b = null;
  
  private be(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, List<NameValuePair> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: new 56	java/net/URL
    //   9: astore 8
    //   11: aload 8
    //   13: aload_1
    //   14: invokespecial 59	java/net/URL:<init>	(Ljava/lang/String;)V
    //   17: aload 8
    //   19: invokevirtual 63	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   22: checkcast 65	java/net/HttpURLConnection
    //   25: astore_1
    //   26: iload 7
    //   28: istore 4
    //   30: aload_0
    //   31: invokespecial 67	be:a	()Z
    //   34: ifeq +76 -> 110
    //   37: iload 7
    //   39: istore 4
    //   41: getstatic 33	be:jdField_a_of_type_Boolean	Z
    //   44: ifeq +66 -> 110
    //   47: iload 7
    //   49: istore 4
    //   51: aload_1
    //   52: checkcast 69	javax/net/ssl/HttpsURLConnection
    //   55: astore 8
    //   57: iload 7
    //   59: istore 4
    //   61: new 71	cn
    //   64: astore 9
    //   66: iload 7
    //   68: istore 4
    //   70: aload 9
    //   72: invokespecial 72	cn:<init>	()V
    //   75: iload 7
    //   77: istore 4
    //   79: aload 8
    //   81: aload 9
    //   83: invokevirtual 76	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   86: iload 7
    //   88: istore 4
    //   90: aload_1
    //   91: checkcast 69	javax/net/ssl/HttpsURLConnection
    //   94: ldc 78
    //   96: ldc 80
    //   98: ldc 82
    //   100: ldc 84
    //   102: ldc 86
    //   104: invokestatic 91	at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/SSLSocketFactory;
    //   107: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   110: iload 7
    //   112: istore 4
    //   114: aload_1
    //   115: aload_2
    //   116: invokevirtual 98	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   119: iload 7
    //   121: istore 4
    //   123: aload_1
    //   124: iconst_1
    //   125: invokevirtual 102	java/net/HttpURLConnection:setDoInput	(Z)V
    //   128: iload 7
    //   130: istore 4
    //   132: aload_1
    //   133: iconst_1
    //   134: invokevirtual 105	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   137: iload 6
    //   139: istore 5
    //   141: iload 7
    //   143: istore 4
    //   145: aload_1
    //   146: invokevirtual 109	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   149: astore_2
    //   150: iload 6
    //   152: istore 5
    //   154: iload 7
    //   156: istore 4
    //   158: new 111	java/io/BufferedWriter
    //   161: astore 8
    //   163: iload 6
    //   165: istore 5
    //   167: iload 7
    //   169: istore 4
    //   171: new 113	java/io/OutputStreamWriter
    //   174: astore 9
    //   176: iload 6
    //   178: istore 5
    //   180: iload 7
    //   182: istore 4
    //   184: aload 9
    //   186: aload_2
    //   187: ldc 115
    //   189: invokespecial 118	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   192: iload 6
    //   194: istore 5
    //   196: iload 7
    //   198: istore 4
    //   200: aload 8
    //   202: aload 9
    //   204: invokespecial 121	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   207: iload 6
    //   209: istore 5
    //   211: iload 7
    //   213: istore 4
    //   215: aload 8
    //   217: aload_3
    //   218: invokestatic 124	be:a	(Ljava/util/List;)Ljava/lang/String;
    //   221: invokevirtual 127	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   224: iload 6
    //   226: istore 5
    //   228: iload 7
    //   230: istore 4
    //   232: aload 8
    //   234: invokevirtual 130	java/io/BufferedWriter:close	()V
    //   237: iload 6
    //   239: istore 5
    //   241: iload 7
    //   243: istore 4
    //   245: aload_2
    //   246: invokevirtual 133	java/io/OutputStream:close	()V
    //   249: iload 6
    //   251: istore 5
    //   253: iload 7
    //   255: istore 4
    //   257: aload_1
    //   258: invokevirtual 137	java/net/HttpURLConnection:getResponseCode	()I
    //   261: istore 6
    //   263: iload 6
    //   265: istore 5
    //   267: iload 6
    //   269: istore 4
    //   271: new 139	java/lang/StringBuilder
    //   274: astore_2
    //   275: iload 6
    //   277: istore 5
    //   279: iload 6
    //   281: istore 4
    //   283: aload_2
    //   284: ldc -115
    //   286: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: iload 6
    //   291: istore 5
    //   293: iload 6
    //   295: istore 4
    //   297: ldc -112
    //   299: aload_2
    //   300: iload 6
    //   302: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokestatic 157	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   311: pop
    //   312: iload 6
    //   314: istore 4
    //   316: aload_1
    //   317: ifnull +150 -> 467
    //   320: aload_1
    //   321: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   324: iload 4
    //   326: ireturn
    //   327: astore_3
    //   328: iload 5
    //   330: istore 4
    //   332: new 139	java/lang/StringBuilder
    //   335: astore_2
    //   336: iload 5
    //   338: istore 4
    //   340: aload_2
    //   341: ldc -94
    //   343: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   346: iload 5
    //   348: istore 4
    //   350: ldc -112
    //   352: aload_2
    //   353: aload_3
    //   354: invokevirtual 165	java/io/IOException:getMessage	()Ljava/lang/String;
    //   357: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 171	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   366: pop
    //   367: iload 5
    //   369: istore 4
    //   371: aload_3
    //   372: invokevirtual 174	java/io/IOException:printStackTrace	()V
    //   375: iload 5
    //   377: istore 4
    //   379: goto -63 -> 316
    //   382: astore_2
    //   383: iconst_0
    //   384: istore 5
    //   386: aconst_null
    //   387: astore_1
    //   388: new 139	java/lang/StringBuilder
    //   391: astore_3
    //   392: aload_3
    //   393: ldc -94
    //   395: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   398: ldc -112
    //   400: aload_3
    //   401: aload_2
    //   402: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   405: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 171	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   414: pop
    //   415: aload_2
    //   416: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   419: iload 5
    //   421: istore 4
    //   423: aload_1
    //   424: ifnull -100 -> 324
    //   427: aload_1
    //   428: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   431: iload 5
    //   433: istore 4
    //   435: goto -111 -> 324
    //   438: astore_2
    //   439: aconst_null
    //   440: astore_1
    //   441: aload_1
    //   442: ifnull +7 -> 449
    //   445: aload_1
    //   446: invokevirtual 160	java/net/HttpURLConnection:disconnect	()V
    //   449: aload_2
    //   450: athrow
    //   451: astore_2
    //   452: goto -11 -> 441
    //   455: astore_2
    //   456: goto -15 -> 441
    //   459: astore_2
    //   460: iload 4
    //   462: istore 5
    //   464: goto -76 -> 388
    //   467: goto -143 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	be
    //   0	470	1	paramString1	String
    //   0	470	2	paramString2	String
    //   0	470	3	paramList	List<NameValuePair>
    //   28	433	4	i	int
    //   139	324	5	j	int
    //   4	309	6	k	int
    //   1	253	7	m	int
    //   9	224	8	localObject1	Object
    //   64	139	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   145	150	327	java/io/IOException
    //   158	163	327	java/io/IOException
    //   171	176	327	java/io/IOException
    //   184	192	327	java/io/IOException
    //   200	207	327	java/io/IOException
    //   215	224	327	java/io/IOException
    //   232	237	327	java/io/IOException
    //   245	249	327	java/io/IOException
    //   257	263	327	java/io/IOException
    //   271	275	327	java/io/IOException
    //   283	289	327	java/io/IOException
    //   297	312	327	java/io/IOException
    //   6	26	382	java/lang/Exception
    //   6	26	438	finally
    //   30	37	451	finally
    //   41	47	451	finally
    //   51	57	451	finally
    //   61	66	451	finally
    //   70	75	451	finally
    //   79	86	451	finally
    //   90	110	451	finally
    //   114	119	451	finally
    //   123	128	451	finally
    //   132	137	451	finally
    //   145	150	451	finally
    //   158	163	451	finally
    //   171	176	451	finally
    //   184	192	451	finally
    //   200	207	451	finally
    //   215	224	451	finally
    //   232	237	451	finally
    //   245	249	451	finally
    //   257	263	451	finally
    //   271	275	451	finally
    //   283	289	451	finally
    //   297	312	451	finally
    //   332	336	451	finally
    //   340	346	451	finally
    //   350	367	451	finally
    //   371	375	451	finally
    //   388	419	455	finally
    //   30	37	459	java/lang/Exception
    //   41	47	459	java/lang/Exception
    //   51	57	459	java/lang/Exception
    //   61	66	459	java/lang/Exception
    //   70	75	459	java/lang/Exception
    //   79	86	459	java/lang/Exception
    //   90	110	459	java/lang/Exception
    //   114	119	459	java/lang/Exception
    //   123	128	459	java/lang/Exception
    //   132	137	459	java/lang/Exception
    //   145	150	459	java/lang/Exception
    //   158	163	459	java/lang/Exception
    //   171	176	459	java/lang/Exception
    //   184	192	459	java/lang/Exception
    //   200	207	459	java/lang/Exception
    //   215	224	459	java/lang/Exception
    //   232	237	459	java/lang/Exception
    //   245	249	459	java/lang/Exception
    //   257	263	459	java/lang/Exception
    //   271	275	459	java/lang/Exception
    //   283	289	459	java/lang/Exception
    //   297	312	459	java/lang/Exception
    //   332	336	459	java/lang/Exception
    //   340	346	459	java/lang/Exception
    //   350	367	459	java/lang/Exception
    //   371	375	459	java/lang/Exception
  }
  
  public static be a(Context paramContext, String paramString)
  {
    if (jdField_a_of_type_Be == null) {
      jdField_a_of_type_Be = new be(paramContext);
    }
    jdField_a_of_type_Be.b = paramString;
    return jdField_a_of_type_Be;
  }
  
  /* Error */
  private static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 139	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: new 199	java/io/BufferedReader
    //   11: dup
    //   12: new 201	java/io/InputStreamReader
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 204	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   20: invokespecial 207	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_0
    //   24: aload_0
    //   25: invokevirtual 210	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_2
    //   29: aload_2
    //   30: ifnull +29 -> 59
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: ldc -44
    //   42: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: goto -22 -> 24
    //   49: astore_2
    //   50: aload_0
    //   51: invokevirtual 213	java/io/BufferedReader:close	()V
    //   54: aload_1
    //   55: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: areturn
    //   59: aload_0
    //   60: invokevirtual 213	java/io/BufferedReader:close	()V
    //   63: goto -9 -> 54
    //   66: astore_0
    //   67: goto -13 -> 54
    //   70: astore_1
    //   71: aload_0
    //   72: invokevirtual 213	java/io/BufferedReader:close	()V
    //   75: aload_1
    //   76: athrow
    //   77: astore_0
    //   78: goto -24 -> 54
    //   81: astore_0
    //   82: goto -7 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramInputStream	java.io.InputStream
    //   7	48	1	localStringBuilder	StringBuilder
    //   70	6	1	localObject	Object
    //   28	7	2	str	String
    //   49	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   24	29	49	java/io/IOException
    //   33	46	49	java/io/IOException
    //   59	63	66	java/io/IOException
    //   24	29	70	finally
    //   33	46	70	finally
    //   50	54	77	java/io/IOException
    //   71	75	81	java/io/IOException
  }
  
  private static String a(List<NameValuePair> paramList)
    throws UnsupportedEncodingException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    int i = 1;
    if (paramList.hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)paramList.next();
      int j = i;
      if (localNameValuePair.getValue() != null)
      {
        if (i == 0) {
          break label103;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(URLEncoder.encode(localNameValuePair.getName(), "UTF-8"));
        localStringBuilder.append("=");
        localStringBuilder.append(URLEncoder.encode(localNameValuePair.getValue(), "UTF-8"));
        j = i;
        i = j;
        break;
        label103:
        localStringBuilder.append("&");
      }
    }
    return localStringBuilder.toString();
  }
  
  private List<NameValuePair> a()
  {
    int m = 0;
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      try
      {
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("android_id", Settings.Secure.getString(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "android_id"));
        localArrayList.add(localObject1);
        localObject1 = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
        Object localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("network_operator", ((TelephonyManager)localObject1).getNetworkOperator());
        localArrayList.add(localObject3);
        localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("phone_type", String.valueOf(((TelephonyManager)localObject1).getPhoneType()));
        localArrayList.add(localObject3);
        localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("phone_id", ((TelephonyManager)localObject1).getDeviceId());
        localArrayList.add(localObject3);
        localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("sim_operator", ((TelephonyManager)localObject1).getSimOperator());
        localArrayList.add(localObject3);
        localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("network_type", String.valueOf(((TelephonyManager)localObject1).getNetworkType()));
        localArrayList.add(localObject3);
        localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("line1_number", ((TelephonyManager)localObject1).getLine1Number());
        localArrayList.add(localObject3);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("board", Build.BOARD);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("bootloader", Build.BOOTLOADER);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("brand", Build.BRAND);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("cpu_abi", Build.CPU_ABI);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("cpu_abi2", Build.CPU_ABI2);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("device", Build.DEVICE);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("display", Build.DISPLAY);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("fingerprint", Build.FINGERPRINT);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("hardware", Build.HARDWARE);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("build_id", Build.ID);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("manufacturer", Build.MANUFACTURER);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("model", Build.MODEL);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("product", Build.PRODUCT);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("tags", Build.TAGS);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("type", Build.TYPE);
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("sdk_version", String.valueOf(Build.VERSION.SDK_INT));
        localArrayList.add(localObject1);
        localObject1 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject1).<init>("release_version", Build.VERSION.RELEASE);
        localArrayList.add(localObject1);
        localObject1 = this.jdField_a_of_type_AndroidContentContext.getApplicationContext().getResources().getDisplayMetrics();
        localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("screen_width", String.valueOf(((DisplayMetrics)localObject1).widthPixels));
        localArrayList.add(localObject3);
        localObject3 = new org/apache/http/message/BasicNameValuePair;
        ((BasicNameValuePair)localObject3).<init>("screen_height", String.valueOf(((DisplayMetrics)localObject1).heightPixels));
        localArrayList.add(localObject3);
        localObject1 = d();
        int j;
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split("\n");
          int n = localObject1.length;
          i = 0;
          j = 0;
          if (i < n)
          {
            localObject3 = localObject1[i];
            int k = j;
            String str;
            if (localObject3 != null)
            {
              k = j;
              if (((String)localObject3).indexOf(":") > 0)
              {
                str = ((String)localObject3).substring(0, ((String)localObject3).indexOf(":")).trim();
                if (!"Processor".equals(str)) {
                  continue;
                }
                str = ((String)localObject3).substring(((String)localObject3).indexOf(":") + 1);
                k = j;
                if (str != null)
                {
                  localObject3 = new org/apache/http/message/BasicNameValuePair;
                  ((BasicNameValuePair)localObject3).<init>("cpu_name", str.trim());
                  localArrayList.add(localObject3);
                  k = j;
                }
              }
            }
            i++;
            j = k;
            continue;
            k = j;
            if (!"processor".equals(str)) {
              continue;
            }
            k = j + 1;
            continue;
          }
          if (j > 0)
          {
            localObject1 = new org/apache/http/message/BasicNameValuePair;
            ((BasicNameValuePair)localObject1).<init>("cpu_cores", String.valueOf(j));
            localArrayList.add(localObject1);
          }
        }
        localObject1 = e();
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).split("\n");
          j = localObject1.length;
          i = m;
          if (i < j)
          {
            localObject3 = localObject1[i];
            if ((localObject3 == null) || (((String)localObject3).indexOf(":") <= 0) || (!"MemTotal".equals(((String)localObject3).substring(0, ((String)localObject3).indexOf(":")).trim()))) {
              continue;
            }
            localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf(":") + 1);
            if (localObject3 == null) {
              continue;
            }
            localObject1 = localObject3;
            if (((String)localObject3).indexOf("kB") > 0) {
              localObject1 = ((String)localObject3).substring(0, ((String)localObject3).indexOf("kB"));
            }
            localObject3 = new org/apache/http/message/BasicNameValuePair;
            ((BasicNameValuePair)localObject3).<init>("mem_total", ((String)localObject1).trim());
            localArrayList.add(localObject3);
          }
        }
        localObject1 = localArrayList;
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i;
        Object localObject2 = null;
        continue;
      }
      return (List<NameValuePair>)localObject1;
      i++;
    }
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(PushService.LOG_TAG, 0).getBoolean("secureConnection", true);
  }
  
  private String c()
  {
    for (;;)
    {
      try
      {
        localObject3 = ((TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone")).getDeviceId();
        localObject2 = Build.SERIAL;
        str3 = Settings.Secure.getString(this.jdField_a_of_type_AndroidContentContext.getContentResolver(), "android_id");
        if ((localObject3 == null) || (((String)localObject3).equals("000000000000000")) || ("".equals(((String)localObject3).trim())))
        {
          localObject1 = "";
          if ((localObject2 != null) && (!((String)localObject2).trim().equals("unknown"))) {
            continue;
          }
          localObject2 = "";
          if ((str3 != null) && (!"".equals(str3.trim()))) {
            continue;
          }
          str3 = "";
          if (("".equals(localObject1)) && ("".equals(localObject2)) && ("".equals(str3))) {
            break label362;
          }
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          localObject1 = (String)localObject1 + (String)localObject2 + str3;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = UUID.randomUUID().toString();
          }
        }
      }
      catch (Exception localException)
      {
        Object localObject3;
        Object localObject2;
        String str3;
        Object localObject1;
        int i;
        localException.printStackTrace();
        str1 = "";
        return str1;
      }
      try
      {
        localObject2 = MessageDigest.getInstance("MD5").digest(((String)localObject2).getBytes());
        localObject1 = new java/lang/StringBuffer;
        ((StringBuffer)localObject1).<init>();
        i = 0;
        if (i >= localObject2.length) {
          break label329;
        }
        ((StringBuffer)localObject1).append(Integer.toHexString(localObject2[i] & 0xFF | 0x100).substring(1, 3));
        i++;
        continue;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("D");
        localObject1 = (String)localObject3;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        str2 = "";
        continue;
      }
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>("S");
      localObject2 = (String)localObject2;
      continue;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>("A");
      str3 = str3;
      continue;
      label329:
      String str1 = str1.toString();
      str1 = "2" + str1;
      continue;
      label362:
      String str2 = null;
    }
  }
  
  private static String d()
  {
    try
    {
      String str = a(Runtime.getRuntime().exec("cat /proc/cpuinfo").getInputStream());
      return str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private static String e()
  {
    try
    {
      String str = a(Runtime.getRuntime().exec("cat /proc/meminfo").getInputStream());
      return str;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  public final String a()
  {
    String str2 = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(jdField_a_of_type_JavaLangString, 0).getString("com.arrownock.internal.device.DEVICE_ID", "");
    String str1 = str2;
    if (str2.length() == 0)
    {
      str2 = c();
      str1 = str2;
      if (!"".equals(str2))
      {
        this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(jdField_a_of_type_JavaLangString, 0).edit().putString("com.arrownock.internal.device.DEVICE_ID", str2).commit();
        str1 = str2;
      }
    }
    return str1;
  }
  
  public final void a()
  {
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        localSharedPreferences = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(jdField_a_of_type_JavaLangString, 0);
        boolean bool = localSharedPreferences.getBoolean("com.arrownock.internal.device.IS_REPORTED", false);
        localObject2 = Boolean.valueOf(bool);
        localObject1 = localObject2;
      }
      catch (Exception localException2)
      {
        SharedPreferences localSharedPreferences;
        Object localObject2;
        Object localObject1;
        Boolean localBoolean;
        Log.w("DeviceManager", localException2.getMessage());
        continue;
      }
      try
      {
        if (((Boolean)localObject2).booleanValue())
        {
          float f = Float.parseFloat(localSharedPreferences.getString("com.arrownock.internal.device.SDK_VERSION", "0"));
          localObject1 = localObject2;
          if (Float.parseFloat("2.25.3") > f) {
            localObject1 = Boolean.valueOf(false);
          }
        }
      }
      catch (Exception localException1)
      {
        localBoolean = Boolean.valueOf(false);
      }
    }
    if (!((Boolean)localObject1).booleanValue())
    {
      localObject1 = new bf;
      ((bf)localObject1).<init>(this, localSharedPreferences);
      localObject2 = new java/lang/Thread;
      ((Thread)localObject2).<init>((Runnable)localObject1);
      ((Thread)localObject2).start();
    }
    a(false);
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject;
    if (this.b != null)
    {
      localObject = Long.valueOf(this.jdField_a_of_type_AndroidContentContext.getSharedPreferences(jdField_a_of_type_JavaLangString, 0).getLong("com.arrownock.internal.device.LAST_LOCATION_REPORT", -1L));
      long l = Calendar.getInstance().getTimeInMillis();
      if ((!paramBoolean) && (((Long)localObject).longValue() >= 0L) && (Long.valueOf(l).longValue() - ((Long)localObject).longValue() < 86400000L)) {}
    }
    try
    {
      localObject = new az;
      ((az)localObject).<init>();
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      bd localbd = new bd;
      localbd.<init>(this);
      ((az)localObject).a(localContext, localbd);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.w("DeviceManager", localException.getMessage());
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */