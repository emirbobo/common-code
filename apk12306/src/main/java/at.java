import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.arrownock.exception.ArrownockException;
import com.arrownock.im.AnIMStatus;
import com.arrownock.im.callback.AnIMBinaryCallbackData;
import com.arrownock.im.callback.AnIMGetSessionInfoCallbackData;
import com.arrownock.im.callback.AnIMMessageCallbackData;
import com.arrownock.im.callback.AnIMMessageSentCallbackData;
import com.arrownock.im.callback.AnIMNoticeCallbackData;
import com.arrownock.im.callback.AnIMReadACKCallbackData;
import com.arrownock.im.callback.AnIMReceiveACKCallbackData;
import com.arrownock.im.callback.AnIMStatusUpdateCallbackData;
import com.arrownock.im.callback.AnIMTopicBinaryCallbackData;
import com.arrownock.im.callback.AnIMTopicMessageCallbackData;
import com.arrownock.im.callback.IAnIMCallback;
import com.arrownock.live.AnLive;
import com.arrownock.live.IAnLiveEventListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.SessionDescription.Type;

public final class at
  implements dz
{
  private at(f paramf) {}
  
  public static int a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      j = 0;
      return j;
    }
    int j = paramArrayOfByte.length;
    int i = j + 1;
    for (;;)
    {
      int k = j - 1;
      j = i;
      if (k < 0) {
        break;
      }
      i = i * 257 ^ paramArrayOfByte[k];
      j = k;
    }
  }
  
  public static NetworkInfo a(Context paramContext)
  {
    return ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
  }
  
  public static String a(String paramString)
  {
    int i = 0;
    char[] arrayOfChar = paramString.toCharArray();
    int k;
    for (int j = 0; i != arrayOfChar.length; j = k)
    {
      int m = arrayOfChar[i];
      k = j;
      if (65 <= m)
      {
        k = j;
        if (90 >= m)
        {
          k = 1;
          arrayOfChar[i] = ((char)(char)(m - 65 + 97));
        }
      }
      i++;
    }
    if (j != 0) {
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return new String(a(paramArrayOfByte));
  }
  
  public static SSLSocketFactory a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, KeyManagementException
  {
    paramString1 = new ByteArrayInputStream(az.a(paramString1));
    paramString2 = new ByteArrayInputStream(az.a(paramString2));
    paramString3 = new ByteArrayInputStream(az.a(paramString3));
    Security.addProvider(new il());
    Object localObject = new iq(new InputStreamReader(paramString1));
    paramString1 = (X509Certificate)((iq)localObject).a();
    ((iq)localObject).close();
    localObject = new iq(new InputStreamReader(paramString2));
    paramString2 = (X509Certificate)((iq)localObject).a();
    ((iq)localObject).close();
    localObject = new iq(new InputStreamReader(paramString3), new eb(paramString4));
    paramString3 = (KeyPair)((iq)localObject).a();
    ((iq)localObject).close();
    localObject = KeyStore.getInstance(paramString5);
    ((KeyStore)localObject).load(null, null);
    ((KeyStore)localObject).setCertificateEntry("ca-certificate", paramString1);
    paramString1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    paramString1.init((KeyStore)localObject);
    paramString5 = KeyStore.getInstance(paramString5);
    paramString5.load(null, null);
    paramString5.setCertificateEntry("certificate", paramString2);
    paramString5.setKeyEntry("private-key", paramString3.getPrivate(), paramString4.toCharArray(), new Certificate[] { paramString2 });
    paramString2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    paramString2.init(paramString5, paramString4.toCharArray());
    paramString3 = SSLContext.getInstance("TLSv1");
    paramString3.init(paramString2.getKeyManagers(), paramString1.getTrustManagers(), null);
    return new ec(paramString3.getSocketFactory());
  }
  
  public static jm a(int paramInt)
  {
    if ((paramInt == 4) || (paramInt == 5)) {}
    for (Object localObject = new jq(paramInt);; localObject = new jm(paramInt)) {
      return (jm)localObject;
    }
  }
  
  public static jm a(Throwable paramThrowable)
  {
    if (paramThrowable.getClass().getName().equals("java.security.GeneralSecurityException")) {}
    for (paramThrowable = new jq(paramThrowable);; paramThrowable = new jm(paramThrowable)) {
      return paramThrowable;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      int k = paramString.length();
      int i = 0;
      label32:
      if (i < k)
      {
        int j = paramString.charAt(i);
        if ((j == 0) || (j == 9) || (j == 10) || (j == 13) || ((j >= 32) && (j <= 55295)) || ((j >= 57344) && (j <= 65533)) || ((j >= 65536) && (j <= 1114111))) {}
        for (j = 1;; j = 0)
        {
          bool1 = bool2;
          if (j == 0) {
            break;
          }
          i++;
          break label32;
        }
      }
      bool1 = false;
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfByte1 == paramArrayOfByte2) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramArrayOfByte1 != null)
      {
        bool1 = bool2;
        if (paramArrayOfByte2 != null)
        {
          bool1 = bool2;
          if (paramArrayOfByte1.length == paramArrayOfByte2.length)
          {
            for (int i = 0;; i++)
            {
              if (i == paramArrayOfByte1.length) {
                break label62;
              }
              bool1 = bool2;
              if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
                break;
              }
            }
            label62:
            bool1 = true;
          }
        }
      }
    }
  }
  
  public static byte[] a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      byte[] arrayOfByte = paramString.getBytes();
      for (int i = arrayOfByte.length; arrayOfByte[(i - 1)] == 61; i--) {}
      paramString = new byte[i - arrayOfByte.length / 4];
      i = 0;
      if (i < arrayOfByte.length)
      {
        if (arrayOfByte[i] == 61) {
          arrayOfByte[i] = ((byte)0);
        }
        for (;;)
        {
          i++;
          break;
          if (arrayOfByte[i] == 47) {
            arrayOfByte[i] = ((byte)63);
          } else if (arrayOfByte[i] == 43) {
            arrayOfByte[i] = ((byte)62);
          } else if ((arrayOfByte[i] >= 48) && (arrayOfByte[i] <= 57)) {
            arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] + 4));
          } else if ((arrayOfByte[i] >= 97) && (arrayOfByte[i] <= 122)) {
            arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] - 71));
          } else if ((arrayOfByte[i] >= 65) && (arrayOfByte[i] <= 90)) {
            arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] - 65));
          }
        }
      }
      i = 0;
      while (j < paramString.length - 2)
      {
        paramString[j] = ((byte)(byte)(arrayOfByte[i] << 2 & 0xFF | arrayOfByte[(i + 1)] >>> 4 & 0x3));
        paramString[(j + 1)] = ((byte)(byte)(arrayOfByte[(i + 1)] << 4 & 0xFF | arrayOfByte[(i + 2)] >>> 2 & 0xF));
        paramString[(j + 2)] = ((byte)(byte)(arrayOfByte[(i + 2)] << 6 & 0xFF | arrayOfByte[(i + 3)] & 0x3F));
        i += 4;
        j += 3;
      }
      if (j < paramString.length) {
        paramString[j] = ((byte)(byte)(arrayOfByte[i] << 2 & 0xFF | arrayOfByte[(i + 1)] >>> 4 & 0x3));
      }
      j++;
      if (j < paramString.length)
      {
        int k = arrayOfByte[(i + 1)];
        paramString[j] = ((byte)(byte)(arrayOfByte[(i + 2)] >>> 2 & 0xF | k << 4 & 0xFF));
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    byte[] arrayOfByte;
    for (paramArrayOfByte = null;; paramArrayOfByte = arrayOfByte)
    {
      return paramArrayOfByte;
      arrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    }
  }
  
  private static char[] a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length];
    for (int i = 0; i != arrayOfChar.length; i++) {
      arrayOfChar[i] = ((char)(char)(paramArrayOfByte[i] & 0xFF));
    }
    return arrayOfChar;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      Class.forName(paramString);
      bool = true;
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;) {}
    }
    return bool;
  }
  
  public final void a() {}
  
  public final void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {}
    for (;;)
    {
      return;
      Iterator localIterator = null;
      localObject11 = null;
      localObject13 = null;
      l2 = -1L;
      for (;;)
      {
        Object localObject17;
        Object localObject10;
        long l1;
        Object localObject6;
        Object localObject18;
        Object localObject15;
        try
        {
          localObject17 = new org/json/JSONObject;
          ((JSONObject)localObject17).<init>(paramString);
          paramString = ((JSONObject)localObject17).optString("from", null);
        }
        catch (JSONException paramString)
        {
          Object localObject3;
          JSONObject localJSONObject;
          int i;
          localObject10 = null;
          localObject6 = null;
          paramString = null;
          Object localObject1 = null;
          localObject4 = null;
          l1 = l2;
          continue;
        }
        try
        {
          localObject1 = ((JSONObject)localObject17).optString("message", null);
        }
        catch (JSONException localJSONException1)
        {
          localObject6 = null;
          localObject10 = paramString;
          paramString = null;
          localObject2 = null;
          localObject4 = null;
          l1 = l2;
          continue;
        }
        try
        {
          localObject3 = ((JSONObject)localObject17).optString("fileType", null);
        }
        catch (JSONException localJSONException2)
        {
          localObject11 = localObject2;
          localObject6 = null;
          localObject10 = paramString;
          localObject2 = null;
          localObject5 = null;
          paramString = null;
          l1 = l2;
          continue;
        }
        try
        {
          localObject10 = ((JSONObject)localObject17).optString("topic", null);
        }
        catch (JSONException localJSONException3)
        {
          localObject13 = localObject5;
          localObject11 = localObject2;
          localObject7 = null;
          localObject10 = paramString;
          localObject5 = null;
          paramString = null;
          localObject2 = null;
          l1 = l2;
          continue;
        }
        try
        {
          localObject11 = ((JSONObject)localObject17).optString("session_key", null);
          l1 = ((JSONObject)localObject17).optLong("timestamp", -1L);
          localObject6 = localIterator;
          if (localObject11 == null) {}
        }
        catch (JSONException localJSONException4)
        {
          localObject15 = null;
          localObject13 = localObject5;
          localObject17 = null;
          localObject8 = null;
          localObject5 = localObject10;
          localObject11 = localObject2;
          localObject10 = paramString;
          l1 = l2;
          paramString = (String)localObject15;
          localObject2 = localObject17;
          continue;
        }
        try
        {
          localObject11 = this.a.a(f.b(this.a), (String)localObject11);
          localObject6 = localIterator;
          if (!((AnIMGetSessionInfoCallbackData)localObject11).isError()) {
            localObject6 = ((AnIMGetSessionInfoCallbackData)localObject11).getParties();
          }
        }
        catch (JSONException localJSONException5)
        {
          localObject13 = localObject5;
          localObject9 = null;
          localObject5 = localObject10;
          localObject11 = localObject2;
          localObject10 = paramString;
          localObject2 = null;
          paramString = null;
          continue;
        }
        try
        {
          localObject11 = ((JSONObject)localObject17).optString("msg_id", null);
        }
        catch (JSONException localJSONException6)
        {
          localObject13 = localObject5;
          localObject5 = localObject10;
          localObject12 = localObject2;
          localObject10 = paramString;
          localObject2 = null;
          paramString = null;
          continue;
        }
        try
        {
          localJSONObject = ((JSONObject)localObject17).optJSONObject("customData");
          if (localJSONObject == null) {
            break label1531;
          }
          localIterator = localJSONObject.keys();
          localObject13 = new java/util/HashMap;
          ((HashMap)localObject13).<init>();
          try
          {
            if (!localIterator.hasNext()) {
              continue;
            }
            localObject18 = (String)localIterator.next();
            ((Map)localObject13).put(localObject18, localJSONObject.getString((String)localObject18));
            continue;
            localObject15 = paramString;
          }
          catch (JSONException localJSONException8)
          {
            localObject15 = localObject11;
            localObject11 = paramString;
            paramString = (String)localObject13;
            localObject17 = localObject10;
            localObject10 = localObject11;
            localObject11 = localObject1;
            localObject13 = localObject3;
            localObject3 = localObject17;
            localObject1 = localObject15;
          }
        }
        catch (JSONException localJSONException7)
        {
          Object localObject14 = localObject10;
          localObject15 = localObject2;
          localObject10 = paramString;
          paramString = null;
          localObject2 = localObject12;
          localObject12 = localObject5;
          localObject5 = localObject14;
          localObject14 = localObject12;
          localObject12 = localObject15;
          continue;
          continue;
          localObject14 = null;
        }
      }
      paramString = (String)localObject10;
      localObject18 = localObject6;
      localObject17 = localObject1;
      i = -1;
      localObject10 = localObject13;
      localObject13 = localObject3;
      localObject6 = localObject15;
      localObject1 = localObject11;
      localObject11 = localObject18;
      localObject3 = localObject17;
      for (;;)
      {
        switch (i)
        {
        default: 
          Log.i(f.d(this.a), "Wrong message type: " + i);
          break;
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
        case 11: 
        case 12: 
        case 21: 
        case 22: 
        case 31: 
        case 32: 
        case 33: 
        case 34: 
        case 35: 
          try
          {
            i = ((JSONObject)localObject17).optInt("msg_type", -1);
            localObject15 = localObject3;
            localObject3 = localObject11;
            localObject11 = localObject6;
            localObject6 = localObject13;
            localObject13 = localObject10;
            localObject10 = localObject15;
          }
          catch (JSONException localJSONException9)
          {
            Object localObject4;
            Object localObject7;
            Object localObject8;
            Object localObject9;
            Object localObject16 = localObject10;
            localObject18 = localObject5;
            localObject17 = localObject2;
            localObject10 = paramString;
            paramString = (String)localObject14;
            Object localObject2 = localObject12;
            Object localObject5 = localObject16;
            localObject14 = localObject18;
            Object localObject12 = localObject17;
          }
        }
      }
      if (f.a(this.a) == null) {
        continue;
      }
      paramString = new AnIMMessageCallbackData((String)localObject3, paramString, (Set)localObject11, (String)localObject1, (Map)localObject6, l1);
      try
      {
        f.a(this.a).receivedMessage(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      localObject13 = new byte[0];
      if (((String)localObject1).length() != 0) {
        localObject13 = az.a((String)localObject1);
      }
      if (f.a(this.a) == null) {
        continue;
      }
      paramString = new AnIMBinaryCallbackData((String)localObject3, paramString, (Set)localObject11, (byte[])localObject13, (String)localObject10, (Map)localObject6, l1);
      try
      {
        f.a(this.a).receivedBinary(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      paramString = new AnIMTopicMessageCallbackData((String)localObject3, paramString, (String)localObject13, (String)localObject1, (Map)localObject6, l1);
      try
      {
        f.a(this.a).receivedTopicMessage(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      localObject11 = new byte[0];
      if (((String)localObject1).length() != 0) {
        localObject11 = az.a((String)localObject1);
      }
      if (f.a(this.a) == null) {
        continue;
      }
      paramString = new AnIMTopicBinaryCallbackData((String)localObject3, paramString, (String)localObject13, (byte[])localObject11, (String)localObject10, (Map)localObject6, l1);
      try
      {
        f.a(this.a).receivedTopicBinary(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      paramString = new AnIMNoticeCallbackData((String)localObject3, paramString, (String)localObject1, (Map)localObject6, l1, (String)localObject13);
      try
      {
        f.a(this.a).receivedNotice(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      paramString = new AnIMReceiveACKCallbackData((String)localObject3, paramString);
      try
      {
        f.a(this.a).receivedReceiveACK(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      paramString = new AnIMReadACKCallbackData((String)localObject3, paramString);
      try
      {
        f.a(this.a).receivedReadACK(paramString);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      new Thread(new au(this)).start();
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      new Thread(new av(this)).start();
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      localObject1 = (String)((Map)localObject6).get("sid");
      paramString = f.a(this.a);
      try
      {
        AnLive.access$400(paramString.a).validateSession((String)localObject1);
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      continue;
      if (f.a(this.a) == null) {
        continue;
      }
      localObject3 = (String)((Map)localObject6).get("o");
      try
      {
        Integer.valueOf((String)localObject3).intValue();
        paramString = AnLive.access$700(f.a(this.a).a, paramString);
        paramString.a(SessionDescription.Type.OFFER, (String)localObject1);
        paramString.b();
        continue;
        if (f.a(this.a) == null) {
          continue;
        }
        localObject3 = (String)((Map)localObject6).get("o");
        try
        {
          Integer.valueOf((String)localObject3).intValue();
          AnLive.access$700(f.a(this.a).a, paramString).a(SessionDescription.Type.ANSWER, (String)localObject1);
          continue;
          if (f.a(this.a) == null) {
            continue;
          }
          localObject3 = f.a(this.a);
          try
          {
            localObject6 = new org/json/JSONObject;
            ((JSONObject)localObject6).<init>((String)localObject1);
            AnLive.access$700(((bi)localObject3).a, paramString).a((JSONObject)localObject6);
          }
          catch (JSONException paramString)
          {
            paramString.printStackTrace();
          }
          continue;
          if (f.a(this.a) == null) {
            continue;
          }
          localObject1 = f.a(this.a);
          try
          {
            AnLive.access$900(((bi)localObject1).a).onRemotePartyDisconnected(paramString);
            AnLive.access$1000(((bi)localObject1).a);
          }
          catch (Exception paramString)
          {
            paramString = paramString;
            paramString.printStackTrace();
          }
          finally {}
        }
        catch (Exception localException1)
        {
          for (;;) {}
        }
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
  }
  
  /* Error */
  public final void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc2_w 261
    //   3: lstore_3
    //   4: aload_1
    //   5: ldc_w 525
    //   8: invokevirtual 528	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   11: ifne +103 -> 114
    //   14: aload_0
    //   15: getfield 12	at:a	Lf;
    //   18: invokestatic 365	f:a	(Lf;)Lcom/arrownock/im/callback/IAnIMCallback;
    //   21: ifnull +93 -> 114
    //   24: ldc_w 530
    //   27: aload_1
    //   28: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifne +83 -> 114
    //   34: aload_2
    //   35: ifnull +81 -> 116
    //   38: new 264	org/json/JSONObject
    //   41: astore 7
    //   43: aload 7
    //   45: aload_2
    //   46: invokespecial 265	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: aload 7
    //   51: ldc_w 532
    //   54: aconst_null
    //   55: invokevirtual 271	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: astore_2
    //   59: aload 7
    //   61: ldc_w 281
    //   64: ldc2_w 261
    //   67: invokevirtual 285	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   70: lstore 5
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 214	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +12 -> 89
    //   80: lload 5
    //   82: invokestatic 537	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   85: invokevirtual 541	java/lang/Long:longValue	()J
    //   88: lstore_3
    //   89: new 543	com/arrownock/im/callback/AnIMMessageSentCallbackData
    //   92: dup
    //   93: iconst_0
    //   94: aconst_null
    //   95: aload_1
    //   96: lload_3
    //   97: invokespecial 546	com/arrownock/im/callback/AnIMMessageSentCallbackData:<init>	(ZLcom/arrownock/exception/ArrownockException;Ljava/lang/String;J)V
    //   100: astore_1
    //   101: aload_0
    //   102: getfield 12	at:a	Lf;
    //   105: invokestatic 365	f:a	(Lf;)Lcom/arrownock/im/callback/IAnIMCallback;
    //   108: aload_1
    //   109: invokeinterface 550 2 0
    //   114: return
    //   115: astore_2
    //   116: ldc2_w 261
    //   119: lstore_3
    //   120: goto -31 -> 89
    //   123: astore_1
    //   124: aload_1
    //   125: invokevirtual 379	java/lang/Exception:printStackTrace	()V
    //   128: goto -14 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	at
    //   0	131	1	paramString1	String
    //   0	131	2	paramString2	String
    //   3	117	3	l1	long
    //   70	11	5	l2	long
    //   41	19	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   38	72	115	org/json/JSONException
    //   72	89	115	org/json/JSONException
    //   101	114	123	java/lang/Exception
  }
  
  public final void a(String paramString, Throwable paramThrowable)
  {
    if ((f.a().get(paramString) == null) && (f.a(this.a) != null)) {
      paramString = new AnIMMessageSentCallbackData(true, new ArrownockException(paramThrowable.getMessage(), 3104), paramString, -1L);
    }
    try
    {
      f.a(this.a).messageSent(paramString);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    Log.e(f.d(this.a), "General Problem occured. Exception Type: " + paramThrowable.getClass().getName() + "; Exception Message: " + paramThrowable.getMessage(), paramThrowable);
  }
  
  public final void b()
  {
    Object localObject;
    if (f.a(this.a) != null)
    {
      localObject = new AnIMStatusUpdateCallbackData(AnIMStatus.ONLINE, null);
      if ((cm.a.booleanValue()) && (!"".equals(f.e(this.a)))) {
        f.a(this.a, f.e(this.a));
      }
    }
    try
    {
      aw localaw = new aw;
      localaw.<init>(this, (AnIMStatusUpdateCallbackData)localObject);
      localObject = new java/lang/Thread;
      ((Thread)localObject).<init>(localaw);
      ((Thread)localObject).start();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public final void b(Throwable paramThrowable)
  {
    f localf = this.a;
    f.a();
    f.b(this.a);
    if (f.b(this.a))
    {
      f.a(this.a, false);
      return;
    }
    if (f.a(this.a) != null)
    {
      if ((paramThrowable == null) || (!(paramThrowable instanceof Exception))) {
        break label114;
      }
      paramThrowable = new AnIMStatusUpdateCallbackData(this.a.a(), new ArrownockException("Connection to IM server is broken.", (Exception)paramThrowable, 3106));
    }
    for (;;)
    {
      try
      {
        f.a(this.a).statusUpdate(paramThrowable);
      }
      catch (Exception paramThrowable)
      {
        paramThrowable.printStackTrace();
      }
      break;
      break;
      label114:
      if (f.c(this.a))
      {
        paramThrowable = new AnIMStatusUpdateCallbackData(this.a.a(), new ArrownockException("User logged in from other device, client force closed.", 3105));
        f.b(this.a, false);
      }
      else
      {
        paramThrowable = new AnIMStatusUpdateCallbackData(this.a.a(), null);
      }
    }
  }
  
  public final void c(Throwable paramThrowable)
  {
    Log.e(f.d(this.a), "Failed to connect to IM Server. Exception Type: " + paramThrowable.getClass().getName() + "; Exception Message: " + paramThrowable.getMessage(), paramThrowable);
    f.b(this.a);
    if (((paramThrowable instanceof jm)) && (((jm)paramThrowable).a() == 5)) {}
    for (;;)
    {
      return;
      if (f.a(this.a) != null)
      {
        paramThrowable = new AnIMStatusUpdateCallbackData(this.a.a(), new ArrownockException(paramThrowable.getMessage(), 3102));
        try
        {
          f.a(this.a).statusUpdate(paramThrowable);
        }
        catch (Exception paramThrowable)
        {
          paramThrowable.printStackTrace();
        }
      }
    }
  }
  
  public final void d(Throwable paramThrowable)
  {
    f localf = this.a;
    f.a();
    Log.e(f.d(this.a), "Failed to disconnect to IM Server. Exception Type: " + paramThrowable.getClass().getName() + "; Exception Message: " + paramThrowable.getMessage(), paramThrowable);
    if (f.a(this.a) != null) {
      paramThrowable = new AnIMStatusUpdateCallbackData(this.a.a(), new ArrownockException(paramThrowable.getMessage(), 3103));
    }
    try
    {
      f.a(this.a).statusUpdate(paramThrowable);
      return;
    }
    catch (Exception paramThrowable)
    {
      for (;;)
      {
        paramThrowable.printStackTrace();
      }
    }
  }
  
  public final void e(Throwable paramThrowable)
  {
    Object localObject;
    if (f.a(this.a) != null) {
      localObject = new AnIMStatusUpdateCallbackData(this.a.a(), new ArrownockException(paramThrowable.getMessage(), 3102));
    }
    try
    {
      paramThrowable = new ax;
      paramThrowable.<init>(this, (AnIMStatusUpdateCallbackData)localObject);
      localObject = new java/lang/Thread;
      ((Thread)localObject).<init>(paramThrowable);
      ((Thread)localObject).start();
      return;
    }
    catch (Exception paramThrowable)
    {
      for (;;)
      {
        paramThrowable.printStackTrace();
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */