package cn.dbox.core.d;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class k
{
  private static final String a = "ImageGetFromHttp";
  private static cn.dbox.core.h.d b = new cn.dbox.core.h.d(d.class.getSimpleName());
  
  /* Error */
  public static android.graphics.Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 42	org/apache/http/impl/client/DefaultHttpClient
    //   6: dup
    //   7: invokespecial 43	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   10: astore 5
    //   12: new 45	org/apache/http/client/methods/HttpGet
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 46	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aload 5
    //   24: aload 6
    //   26: invokeinterface 52 2 0
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 58 1 0
    //   38: invokeinterface 64 1 0
    //   43: istore_1
    //   44: iload_1
    //   45: sipush 200
    //   48: if_icmpeq +60 -> 108
    //   51: getstatic 30	cn/dbox/core/d/k:b	Lcn/dbox/core/h/d;
    //   54: astore_2
    //   55: new 66	java/lang/StringBuilder
    //   58: astore_3
    //   59: aload_3
    //   60: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   63: aload_2
    //   64: ldc 10
    //   66: aload_3
    //   67: ldc 69
    //   69: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload_1
    //   73: invokevirtual 76	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: ldc 78
    //   78: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokevirtual 85	cn/dbox/core/h/d:d	(Ljava/lang/Object;Ljava/lang/String;)V
    //   91: aload 5
    //   93: invokeinterface 89 1 0
    //   98: invokeinterface 94 1 0
    //   103: aload 4
    //   105: astore_0
    //   106: aload_0
    //   107: areturn
    //   108: aload_2
    //   109: invokeinterface 98 1 0
    //   114: astore 7
    //   116: aload 7
    //   118: ifnull +108 -> 226
    //   121: aload 7
    //   123: invokeinterface 104 1 0
    //   128: astore_2
    //   129: new 6	cn/dbox/core/d/k$a
    //   132: astore_3
    //   133: aload_3
    //   134: aload_2
    //   135: invokespecial 107	cn/dbox/core/d/k$a:<init>	(Ljava/io/InputStream;)V
    //   138: aload_3
    //   139: invokestatic 113	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   142: astore_3
    //   143: aload_2
    //   144: ifnull +7 -> 151
    //   147: aload_2
    //   148: invokevirtual 118	java/io/InputStream:close	()V
    //   151: aload 7
    //   153: invokeinterface 121 1 0
    //   158: aload 5
    //   160: invokeinterface 89 1 0
    //   165: invokeinterface 94 1 0
    //   170: aload_3
    //   171: astore_0
    //   172: goto -66 -> 106
    //   175: astore_3
    //   176: aconst_null
    //   177: astore_2
    //   178: aload_2
    //   179: ifnull +7 -> 186
    //   182: aload_2
    //   183: invokevirtual 118	java/io/InputStream:close	()V
    //   186: aload 7
    //   188: invokeinterface 121 1 0
    //   193: aload_3
    //   194: athrow
    //   195: astore_0
    //   196: aload 6
    //   198: invokevirtual 124	org/apache/http/client/methods/HttpGet:abort	()V
    //   201: getstatic 30	cn/dbox/core/d/k:b	Lcn/dbox/core/h/d;
    //   204: aload_0
    //   205: invokevirtual 127	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   208: aload 5
    //   210: invokeinterface 89 1 0
    //   215: invokeinterface 94 1 0
    //   220: aload 4
    //   222: astore_0
    //   223: goto -117 -> 106
    //   226: aload 5
    //   228: invokeinterface 89 1 0
    //   233: invokeinterface 94 1 0
    //   238: aload 4
    //   240: astore_0
    //   241: goto -135 -> 106
    //   244: astore_2
    //   245: aload 6
    //   247: invokevirtual 124	org/apache/http/client/methods/HttpGet:abort	()V
    //   250: getstatic 30	cn/dbox/core/d/k:b	Lcn/dbox/core/h/d;
    //   253: astore_2
    //   254: new 66	java/lang/StringBuilder
    //   257: astore_3
    //   258: aload_3
    //   259: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   262: aload_2
    //   263: ldc 10
    //   265: aload_3
    //   266: ldc -127
    //   268: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 85	cn/dbox/core/h/d:d	(Ljava/lang/Object;Ljava/lang/String;)V
    //   281: aload 5
    //   283: invokeinterface 89 1 0
    //   288: invokeinterface 94 1 0
    //   293: aload 4
    //   295: astore_0
    //   296: goto -190 -> 106
    //   299: astore_0
    //   300: aload 6
    //   302: invokevirtual 124	org/apache/http/client/methods/HttpGet:abort	()V
    //   305: getstatic 30	cn/dbox/core/d/k:b	Lcn/dbox/core/h/d;
    //   308: aload_0
    //   309: invokevirtual 127	cn/dbox/core/h/d:a	(Ljava/lang/Throwable;)V
    //   312: aload 5
    //   314: invokeinterface 89 1 0
    //   319: invokeinterface 94 1 0
    //   324: aload 4
    //   326: astore_0
    //   327: goto -221 -> 106
    //   330: astore_0
    //   331: aload 5
    //   333: invokeinterface 89 1 0
    //   338: invokeinterface 94 1 0
    //   343: aload_0
    //   344: athrow
    //   345: astore_3
    //   346: goto -168 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramString	String
    //   43	30	1	i	int
    //   31	152	2	localObject1	Object
    //   244	1	2	localIllegalStateException	IllegalStateException
    //   253	10	2	locald	cn.dbox.core.h.d
    //   58	113	3	localObject2	Object
    //   175	19	3	localObject3	Object
    //   257	9	3	localStringBuilder	StringBuilder
    //   345	1	3	localObject4	Object
    //   1	324	4	localObject5	Object
    //   10	322	5	localDefaultHttpClient	org.apache.http.impl.client.DefaultHttpClient
    //   20	281	6	localHttpGet	org.apache.http.client.methods.HttpGet
    //   114	73	7	localHttpEntity	org.apache.http.HttpEntity
    // Exception table:
    //   from	to	target	type
    //   121	129	175	finally
    //   22	44	195	java/io/IOException
    //   51	91	195	java/io/IOException
    //   108	116	195	java/io/IOException
    //   147	151	195	java/io/IOException
    //   151	158	195	java/io/IOException
    //   182	186	195	java/io/IOException
    //   186	195	195	java/io/IOException
    //   22	44	244	java/lang/IllegalStateException
    //   51	91	244	java/lang/IllegalStateException
    //   108	116	244	java/lang/IllegalStateException
    //   147	151	244	java/lang/IllegalStateException
    //   151	158	244	java/lang/IllegalStateException
    //   182	186	244	java/lang/IllegalStateException
    //   186	195	244	java/lang/IllegalStateException
    //   22	44	299	java/lang/Exception
    //   51	91	299	java/lang/Exception
    //   108	116	299	java/lang/Exception
    //   147	151	299	java/lang/Exception
    //   151	158	299	java/lang/Exception
    //   182	186	299	java/lang/Exception
    //   186	195	299	java/lang/Exception
    //   22	44	330	finally
    //   51	91	330	finally
    //   108	116	330	finally
    //   147	151	330	finally
    //   151	158	330	finally
    //   182	186	330	finally
    //   186	195	330	finally
    //   196	208	330	finally
    //   245	281	330	finally
    //   300	312	330	finally
    //   129	143	345	finally
  }
  
  static class a
    extends FilterInputStream
  {
    public a(InputStream paramInputStream)
    {
      super();
    }
    
    public long skip(long paramLong)
      throws IOException
    {
      long l2;
      for (long l1 = 0L;; l1 = l2 + l1)
      {
        if (l1 < paramLong)
        {
          long l3 = this.in.skip(paramLong - l1);
          l2 = l3;
          if (l3 != 0L) {
            continue;
          }
          if (read() >= 0) {}
        }
        else
        {
          return l1;
        }
        l2 = 1L;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */