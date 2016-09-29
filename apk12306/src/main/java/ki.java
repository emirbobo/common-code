import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.util.Hashtable;
import java.util.Vector;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class ki
{
  private static final byte[] a = { -99, -89, -39, -128, 5, -72, -119, -100 };
  
  public ki()
  {
    new Hashtable();
  }
  
  private static String a(String paramString)
  {
    String str = null;
    if (paramString != null) {
      str = System.getProperty(paramString);
    }
    return str;
  }
  
  private static KeyStore a()
    throws kg
  {
    for (;;)
    {
      try
      {
        Class localClass = Class.forName("com.ibm.rcp.security.auth.SecurePlatform");
        Object localObject1 = localClass.getMethod("getKeyStore", null).invoke(null, null);
        if (((Boolean)localClass.getMethod("isLoggedIn", null).invoke(localObject1, null)).booleanValue())
        {
          localObject1 = (KeyStore)localClass.getMethod("getKeyStore", null).invoke(localObject1, null);
          return (KeyStore)localObject1;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Object localObject2 = null;
        continue;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.getLocalizedMessage();
        throw new kh(localIllegalAccessException);
      }
      catch (SecurityException localSecurityException)
      {
        localSecurityException.getLocalizedMessage();
        throw new kh(localSecurityException);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localNoSuchMethodException.getLocalizedMessage();
        throw new kh(localNoSuchMethodException);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.getLocalizedMessage();
        throw new kh(localIllegalArgumentException);
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        localInvocationTargetException.getLocalizedMessage();
        throw new kh(localInvocationTargetException);
      }
      Object localObject3 = null;
    }
  }
  
  /* Error */
  private static SSLContext a()
    throws kg
  {
    // Byte code:
    //   0: aconst_null
    //   1: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: astore_0
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: ldc 111
    //   13: astore_0
    //   14: aconst_null
    //   15: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +301 -> 321
    //   23: aload_0
    //   24: invokestatic 117	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   27: astore_1
    //   28: aconst_null
    //   29: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore_2
    //   33: aload_2
    //   34: ifnonnull +511 -> 545
    //   37: invokestatic 119	ki:a	()Ljava/security/KeyStore;
    //   40: astore_0
    //   41: aload_0
    //   42: ifnonnull +480 -> 522
    //   45: aload_2
    //   46: ifnonnull +496 -> 542
    //   49: ldc 121
    //   51: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   54: astore_2
    //   55: ldc 123
    //   57: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_0
    //   61: aload_0
    //   62: ifnull +475 -> 537
    //   65: aload_0
    //   66: ldc 125
    //   68: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   71: ifeq +259 -> 330
    //   74: aload_0
    //   75: invokestatic 134	ki:a	(Ljava/lang/String;)[C
    //   78: astore_0
    //   79: ldc -120
    //   81: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_3
    //   85: aload_3
    //   86: ifnonnull +448 -> 534
    //   89: invokestatic 139	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   92: astore_3
    //   93: invokestatic 144	javax/net/ssl/KeyManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   96: astore 5
    //   98: aconst_null
    //   99: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 6
    //   104: ldc -110
    //   106: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   109: astore 4
    //   111: aload 4
    //   113: ifnull +414 -> 527
    //   116: aload_2
    //   117: ifnull +405 -> 522
    //   120: aload_3
    //   121: ifnull +401 -> 522
    //   124: aload_0
    //   125: ifnull +397 -> 522
    //   128: aload 4
    //   130: ifnull +392 -> 522
    //   133: aload_3
    //   134: invokestatic 149	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   137: astore_3
    //   138: new 151	java/io/FileInputStream
    //   141: astore 5
    //   143: aload 5
    //   145: aload_2
    //   146: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   149: aload_3
    //   150: aload 5
    //   152: aload_0
    //   153: invokevirtual 158	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   156: aload 6
    //   158: ifnull +180 -> 338
    //   161: aload 4
    //   163: aload 6
    //   165: invokestatic 161	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   168: astore_2
    //   169: aload_2
    //   170: aload_3
    //   171: aload_0
    //   172: invokevirtual 165	javax/net/ssl/KeyManagerFactory:init	(Ljava/security/KeyStore;[C)V
    //   175: aload_2
    //   176: invokevirtual 169	javax/net/ssl/KeyManagerFactory:getKeyManagers	()[Ljavax/net/ssl/KeyManager;
    //   179: astore_2
    //   180: ldc -85
    //   182: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   185: astore 6
    //   187: ldc -83
    //   189: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   192: astore_0
    //   193: aload_0
    //   194: ifnull +323 -> 517
    //   197: aload_0
    //   198: ldc 125
    //   200: invokevirtual 131	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   203: ifeq +234 -> 437
    //   206: aload_0
    //   207: invokestatic 134	ki:a	(Ljava/lang/String;)[C
    //   210: astore_0
    //   211: aconst_null
    //   212: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   215: astore_3
    //   216: aload_3
    //   217: ifnonnull +297 -> 514
    //   220: invokestatic 139	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   223: astore_3
    //   224: invokestatic 176	javax/net/ssl/TrustManagerFactory:getDefaultAlgorithm	()Ljava/lang/String;
    //   227: astore 5
    //   229: aconst_null
    //   230: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 7
    //   235: ldc -78
    //   237: invokestatic 109	ki:a	(Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 4
    //   242: aload 4
    //   244: ifnull +263 -> 507
    //   247: aload 6
    //   249: ifnull +253 -> 502
    //   252: aload_3
    //   253: ifnull +249 -> 502
    //   256: aload_0
    //   257: ifnull +245 -> 502
    //   260: aload 4
    //   262: ifnull +240 -> 502
    //   265: aload_3
    //   266: invokestatic 149	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   269: astore_3
    //   270: new 151	java/io/FileInputStream
    //   273: astore 5
    //   275: aload 5
    //   277: aload 6
    //   279: invokespecial 154	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   282: aload_3
    //   283: aload 5
    //   285: aload_0
    //   286: invokevirtual 158	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   289: aload 7
    //   291: ifnull +154 -> 445
    //   294: aload 4
    //   296: aload 7
    //   298: invokestatic 181	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   301: astore_0
    //   302: aload_0
    //   303: aload_3
    //   304: invokevirtual 184	javax/net/ssl/TrustManagerFactory:init	(Ljava/security/KeyStore;)V
    //   307: aload_0
    //   308: invokevirtual 188	javax/net/ssl/TrustManagerFactory:getTrustManagers	()[Ljavax/net/ssl/TrustManager;
    //   311: astore_0
    //   312: aload_1
    //   313: aload_2
    //   314: aload_0
    //   315: aconst_null
    //   316: invokevirtual 191	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   319: aload_1
    //   320: areturn
    //   321: aload_0
    //   322: aload_1
    //   323: invokestatic 194	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   326: astore_1
    //   327: goto -299 -> 28
    //   330: aload_0
    //   331: invokevirtual 198	java/lang/String:toCharArray	()[C
    //   334: astore_0
    //   335: goto -256 -> 79
    //   338: aload 4
    //   340: invokestatic 201	javax/net/ssl/KeyManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/KeyManagerFactory;
    //   343: astore_2
    //   344: goto -175 -> 169
    //   347: astore_0
    //   348: new 82	kh
    //   351: astore_1
    //   352: aload_1
    //   353: aload_0
    //   354: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   357: aload_1
    //   358: athrow
    //   359: astore_0
    //   360: new 82	kh
    //   363: dup
    //   364: aload_0
    //   365: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   368: athrow
    //   369: astore_1
    //   370: new 82	kh
    //   373: astore_0
    //   374: aload_0
    //   375: aload_1
    //   376: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   379: aload_0
    //   380: athrow
    //   381: astore_0
    //   382: new 82	kh
    //   385: dup
    //   386: aload_0
    //   387: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   390: athrow
    //   391: astore_1
    //   392: new 82	kh
    //   395: astore_0
    //   396: aload_0
    //   397: aload_1
    //   398: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   401: aload_0
    //   402: athrow
    //   403: astore_0
    //   404: new 82	kh
    //   407: dup
    //   408: aload_0
    //   409: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   412: athrow
    //   413: astore_0
    //   414: new 82	kh
    //   417: astore_1
    //   418: aload_1
    //   419: aload_0
    //   420: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   423: aload_1
    //   424: athrow
    //   425: astore_1
    //   426: new 82	kh
    //   429: astore_0
    //   430: aload_0
    //   431: aload_1
    //   432: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   435: aload_0
    //   436: athrow
    //   437: aload_0
    //   438: invokevirtual 198	java/lang/String:toCharArray	()[C
    //   441: astore_0
    //   442: goto -231 -> 211
    //   445: aload 4
    //   447: invokestatic 204	javax/net/ssl/TrustManagerFactory:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/TrustManagerFactory;
    //   450: astore_0
    //   451: goto -149 -> 302
    //   454: astore_0
    //   455: new 82	kh
    //   458: astore_1
    //   459: aload_1
    //   460: aload_0
    //   461: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   464: aload_1
    //   465: athrow
    //   466: astore_0
    //   467: new 82	kh
    //   470: astore_1
    //   471: aload_1
    //   472: aload_0
    //   473: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   476: aload_1
    //   477: athrow
    //   478: astore_1
    //   479: new 82	kh
    //   482: astore_0
    //   483: aload_0
    //   484: aload_1
    //   485: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   488: aload_0
    //   489: athrow
    //   490: astore_0
    //   491: new 82	kh
    //   494: astore_1
    //   495: aload_1
    //   496: aload_0
    //   497: invokespecial 85	kh:<init>	(Ljava/lang/Throwable;)V
    //   500: aload_1
    //   501: athrow
    //   502: aconst_null
    //   503: astore_0
    //   504: goto -192 -> 312
    //   507: aload 5
    //   509: astore 4
    //   511: goto -264 -> 247
    //   514: goto -290 -> 224
    //   517: aconst_null
    //   518: astore_0
    //   519: goto -308 -> 211
    //   522: aconst_null
    //   523: astore_2
    //   524: goto -344 -> 180
    //   527: aload 5
    //   529: astore 4
    //   531: goto -415 -> 116
    //   534: goto -441 -> 93
    //   537: aconst_null
    //   538: astore_0
    //   539: goto -460 -> 79
    //   542: goto -487 -> 55
    //   545: aconst_null
    //   546: astore_0
    //   547: goto -506 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	329	0	localObject1	Object
    //   347	7	0	localKeyStoreException1	java.security.KeyStoreException
    //   359	6	0	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   373	7	0	localkh1	kh
    //   381	6	0	localNoSuchProviderException	java.security.NoSuchProviderException
    //   395	7	0	localkh2	kh
    //   403	6	0	localKeyManagementException	java.security.KeyManagementException
    //   413	7	0	localIOException1	java.io.IOException
    //   429	22	0	localObject2	Object
    //   454	7	0	localKeyStoreException2	java.security.KeyStoreException
    //   466	7	0	localCertificateException1	java.security.cert.CertificateException
    //   482	7	0	localkh3	kh
    //   490	7	0	localIOException2	java.io.IOException
    //   503	44	0	localObject3	Object
    //   4	354	1	localObject4	Object
    //   369	7	1	localCertificateException2	java.security.cert.CertificateException
    //   391	7	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   417	7	1	localkh4	kh
    //   425	7	1	localUnrecoverableKeyException	java.security.UnrecoverableKeyException
    //   458	19	1	localkh5	kh
    //   478	7	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   494	7	1	localkh6	kh
    //   32	492	2	localObject5	Object
    //   84	220	3	localObject6	Object
    //   109	421	4	localObject7	Object
    //   96	432	5	localObject8	Object
    //   102	176	6	str1	String
    //   233	64	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   133	156	347	java/security/KeyStoreException
    //   161	169	347	java/security/KeyStoreException
    //   169	180	347	java/security/KeyStoreException
    //   338	344	347	java/security/KeyStoreException
    //   23	28	359	java/security/NoSuchAlgorithmException
    //   28	33	359	java/security/NoSuchAlgorithmException
    //   37	41	359	java/security/NoSuchAlgorithmException
    //   49	55	359	java/security/NoSuchAlgorithmException
    //   55	61	359	java/security/NoSuchAlgorithmException
    //   65	79	359	java/security/NoSuchAlgorithmException
    //   79	85	359	java/security/NoSuchAlgorithmException
    //   89	93	359	java/security/NoSuchAlgorithmException
    //   93	111	359	java/security/NoSuchAlgorithmException
    //   133	156	359	java/security/NoSuchAlgorithmException
    //   161	169	359	java/security/NoSuchAlgorithmException
    //   169	180	359	java/security/NoSuchAlgorithmException
    //   180	193	359	java/security/NoSuchAlgorithmException
    //   197	211	359	java/security/NoSuchAlgorithmException
    //   211	216	359	java/security/NoSuchAlgorithmException
    //   220	224	359	java/security/NoSuchAlgorithmException
    //   224	242	359	java/security/NoSuchAlgorithmException
    //   265	289	359	java/security/NoSuchAlgorithmException
    //   294	302	359	java/security/NoSuchAlgorithmException
    //   302	312	359	java/security/NoSuchAlgorithmException
    //   312	319	359	java/security/NoSuchAlgorithmException
    //   321	327	359	java/security/NoSuchAlgorithmException
    //   330	335	359	java/security/NoSuchAlgorithmException
    //   338	344	359	java/security/NoSuchAlgorithmException
    //   348	359	359	java/security/NoSuchAlgorithmException
    //   370	381	359	java/security/NoSuchAlgorithmException
    //   392	403	359	java/security/NoSuchAlgorithmException
    //   414	425	359	java/security/NoSuchAlgorithmException
    //   426	437	359	java/security/NoSuchAlgorithmException
    //   437	442	359	java/security/NoSuchAlgorithmException
    //   445	451	359	java/security/NoSuchAlgorithmException
    //   455	466	359	java/security/NoSuchAlgorithmException
    //   467	478	359	java/security/NoSuchAlgorithmException
    //   479	490	359	java/security/NoSuchAlgorithmException
    //   491	502	359	java/security/NoSuchAlgorithmException
    //   133	156	369	java/security/cert/CertificateException
    //   161	169	369	java/security/cert/CertificateException
    //   169	180	369	java/security/cert/CertificateException
    //   338	344	369	java/security/cert/CertificateException
    //   23	28	381	java/security/NoSuchProviderException
    //   28	33	381	java/security/NoSuchProviderException
    //   37	41	381	java/security/NoSuchProviderException
    //   49	55	381	java/security/NoSuchProviderException
    //   55	61	381	java/security/NoSuchProviderException
    //   65	79	381	java/security/NoSuchProviderException
    //   79	85	381	java/security/NoSuchProviderException
    //   89	93	381	java/security/NoSuchProviderException
    //   93	111	381	java/security/NoSuchProviderException
    //   133	156	381	java/security/NoSuchProviderException
    //   161	169	381	java/security/NoSuchProviderException
    //   169	180	381	java/security/NoSuchProviderException
    //   180	193	381	java/security/NoSuchProviderException
    //   197	211	381	java/security/NoSuchProviderException
    //   211	216	381	java/security/NoSuchProviderException
    //   220	224	381	java/security/NoSuchProviderException
    //   224	242	381	java/security/NoSuchProviderException
    //   265	289	381	java/security/NoSuchProviderException
    //   294	302	381	java/security/NoSuchProviderException
    //   302	312	381	java/security/NoSuchProviderException
    //   312	319	381	java/security/NoSuchProviderException
    //   321	327	381	java/security/NoSuchProviderException
    //   330	335	381	java/security/NoSuchProviderException
    //   338	344	381	java/security/NoSuchProviderException
    //   348	359	381	java/security/NoSuchProviderException
    //   370	381	381	java/security/NoSuchProviderException
    //   392	403	381	java/security/NoSuchProviderException
    //   414	425	381	java/security/NoSuchProviderException
    //   426	437	381	java/security/NoSuchProviderException
    //   437	442	381	java/security/NoSuchProviderException
    //   445	451	381	java/security/NoSuchProviderException
    //   455	466	381	java/security/NoSuchProviderException
    //   467	478	381	java/security/NoSuchProviderException
    //   479	490	381	java/security/NoSuchProviderException
    //   491	502	381	java/security/NoSuchProviderException
    //   133	156	391	java/io/FileNotFoundException
    //   161	169	391	java/io/FileNotFoundException
    //   169	180	391	java/io/FileNotFoundException
    //   338	344	391	java/io/FileNotFoundException
    //   23	28	403	java/security/KeyManagementException
    //   28	33	403	java/security/KeyManagementException
    //   37	41	403	java/security/KeyManagementException
    //   49	55	403	java/security/KeyManagementException
    //   55	61	403	java/security/KeyManagementException
    //   65	79	403	java/security/KeyManagementException
    //   79	85	403	java/security/KeyManagementException
    //   89	93	403	java/security/KeyManagementException
    //   93	111	403	java/security/KeyManagementException
    //   133	156	403	java/security/KeyManagementException
    //   161	169	403	java/security/KeyManagementException
    //   169	180	403	java/security/KeyManagementException
    //   180	193	403	java/security/KeyManagementException
    //   197	211	403	java/security/KeyManagementException
    //   211	216	403	java/security/KeyManagementException
    //   220	224	403	java/security/KeyManagementException
    //   224	242	403	java/security/KeyManagementException
    //   265	289	403	java/security/KeyManagementException
    //   294	302	403	java/security/KeyManagementException
    //   302	312	403	java/security/KeyManagementException
    //   312	319	403	java/security/KeyManagementException
    //   321	327	403	java/security/KeyManagementException
    //   330	335	403	java/security/KeyManagementException
    //   338	344	403	java/security/KeyManagementException
    //   348	359	403	java/security/KeyManagementException
    //   370	381	403	java/security/KeyManagementException
    //   392	403	403	java/security/KeyManagementException
    //   414	425	403	java/security/KeyManagementException
    //   426	437	403	java/security/KeyManagementException
    //   437	442	403	java/security/KeyManagementException
    //   445	451	403	java/security/KeyManagementException
    //   455	466	403	java/security/KeyManagementException
    //   467	478	403	java/security/KeyManagementException
    //   479	490	403	java/security/KeyManagementException
    //   491	502	403	java/security/KeyManagementException
    //   133	156	413	java/io/IOException
    //   161	169	413	java/io/IOException
    //   169	180	413	java/io/IOException
    //   338	344	413	java/io/IOException
    //   133	156	425	java/security/UnrecoverableKeyException
    //   161	169	425	java/security/UnrecoverableKeyException
    //   169	180	425	java/security/UnrecoverableKeyException
    //   338	344	425	java/security/UnrecoverableKeyException
    //   265	289	454	java/security/KeyStoreException
    //   294	302	454	java/security/KeyStoreException
    //   302	312	454	java/security/KeyStoreException
    //   445	451	454	java/security/KeyStoreException
    //   265	289	466	java/security/cert/CertificateException
    //   294	302	466	java/security/cert/CertificateException
    //   302	312	466	java/security/cert/CertificateException
    //   445	451	466	java/security/cert/CertificateException
    //   265	289	478	java/io/FileNotFoundException
    //   294	302	478	java/io/FileNotFoundException
    //   302	312	478	java/io/FileNotFoundException
    //   445	451	478	java/io/FileNotFoundException
    //   265	289	490	java/io/IOException
    //   294	302	490	java/io/IOException
    //   302	312	490	java/io/IOException
    //   445	451	490	java/io/IOException
  }
  
  public static SSLSocketFactory a()
    throws kg
  {
    return a().getSocketFactory();
  }
  
  private static char[] a(String paramString)
  {
    int k = 0;
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      byte[] arrayOfByte;
      int i;
      try
      {
        arrayOfByte = kj.a(paramString.substring(5));
        for (i = 0; i < arrayOfByte.length; i++) {
          arrayOfByte[i] = ((byte)(byte)(arrayOfByte[i] ^ a[(i % a.length)]));
        }
      }
      catch (Exception paramString)
      {
        paramString = null;
      }
      if (arrayOfByte == null)
      {
        paramString = null;
      }
      else
      {
        paramString = new char[arrayOfByte.length / 2];
        int j = 0;
        for (i = k; j < arrayOfByte.length; i++)
        {
          k = j + 1;
          int m = arrayOfByte[j];
          j = k + 1;
          paramString[i] = ((char)(char)(((arrayOfByte[k] & 0xFF) << 8) + (m & 0xFF)));
        }
      }
    }
  }
  
  public static String[] a()
  {
    String[] arrayOfString = null;
    String str = a(null);
    if (str == null) {}
    for (;;)
    {
      return arrayOfString;
      Vector localVector = new Vector();
      int j = str.indexOf(',');
      int i = 0;
      while (j >= 0)
      {
        localVector.add(str.substring(i, j));
        i = j + 1;
        j = str.indexOf(',', i);
      }
      localVector.add(str.substring(i));
      arrayOfString = new String[localVector.size()];
      localVector.toArray(arrayOfString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ki.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */