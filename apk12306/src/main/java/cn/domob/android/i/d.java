package cn.domob.android.i;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

public class d
{
  private static f a = new f(d.class.getSimpleName());
  
  /* Error */
  public static String a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_2
    //   3: astore_0
    //   4: aload_1
    //   5: invokestatic 36	cn/domob/android/i/h:e	(Ljava/lang/String;)Z
    //   8: ifne +111 -> 119
    //   11: aload_2
    //   12: astore_0
    //   13: invokestatic 42	cn/domob/android/i/c:h	()Z
    //   16: ifeq +103 -> 119
    //   19: new 44	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   26: invokestatic 51	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   29: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 4
    //   41: new 44	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   48: astore_3
    //   49: new 63	java/io/BufferedReader
    //   52: astore_1
    //   53: new 65	java/io/FileReader
    //   56: astore_0
    //   57: new 67	java/io/File
    //   60: astore_2
    //   61: aload_2
    //   62: aload 4
    //   64: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: aload_2
    //   69: invokespecial 71	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   72: aload_1
    //   73: aload_0
    //   74: invokespecial 74	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   77: aload_1
    //   78: astore_0
    //   79: aload_1
    //   80: invokevirtual 77	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +36 -> 121
    //   88: aload_1
    //   89: astore_0
    //   90: aload_3
    //   91: aload_2
    //   92: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: goto -19 -> 77
    //   99: astore_2
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 80	java/io/FileNotFoundException:printStackTrace	()V
    //   106: aload_1
    //   107: ifnull +7 -> 114
    //   110: aload_1
    //   111: invokevirtual 83	java/io/BufferedReader:close	()V
    //   114: aload_3
    //   115: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: astore_0
    //   119: aload_0
    //   120: areturn
    //   121: aload_1
    //   122: ifnull -8 -> 114
    //   125: aload_1
    //   126: invokevirtual 83	java/io/BufferedReader:close	()V
    //   129: goto -15 -> 114
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   137: goto -23 -> 114
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   145: goto -31 -> 114
    //   148: astore_2
    //   149: aconst_null
    //   150: astore_1
    //   151: aload_1
    //   152: astore_0
    //   153: aload_2
    //   154: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   157: aload_1
    //   158: ifnull -44 -> 114
    //   161: aload_1
    //   162: invokevirtual 83	java/io/BufferedReader:close	()V
    //   165: goto -51 -> 114
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   173: goto -59 -> 114
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_0
    //   179: aload_0
    //   180: ifnull +7 -> 187
    //   183: aload_0
    //   184: invokevirtual 83	java/io/BufferedReader:close	()V
    //   187: aload_1
    //   188: athrow
    //   189: astore_0
    //   190: aload_0
    //   191: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   194: goto -7 -> 187
    //   197: astore_1
    //   198: goto -19 -> 179
    //   201: astore_2
    //   202: goto -51 -> 151
    //   205: astore_2
    //   206: aconst_null
    //   207: astore_1
    //   208: goto -108 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramContext	Context
    //   0	211	1	paramString	String
    //   1	91	2	localObject	Object
    //   99	4	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   148	6	2	localIOException1	java.io.IOException
    //   201	1	2	localIOException2	java.io.IOException
    //   205	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   48	67	3	localStringBuilder	StringBuilder
    //   39	24	4	str	String
    // Exception table:
    //   from	to	target	type
    //   79	84	99	java/io/FileNotFoundException
    //   90	96	99	java/io/FileNotFoundException
    //   125	129	132	java/io/IOException
    //   110	114	140	java/io/IOException
    //   49	77	148	java/io/IOException
    //   161	165	168	java/io/IOException
    //   49	77	176	finally
    //   183	187	189	java/io/IOException
    //   79	84	197	finally
    //   90	96	197	finally
    //   102	106	197	finally
    //   153	157	197	finally
    //   79	84	201	java/io/IOException
    //   90	96	201	java/io/IOException
    //   49	77	205	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 89	java/io/FileInputStream
    //   3: astore_2
    //   4: aload_2
    //   5: aload_0
    //   6: invokespecial 90	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   9: aload_2
    //   10: astore_0
    //   11: sipush 1024
    //   14: newarray <illegal type>
    //   16: astore 4
    //   18: aload_2
    //   19: astore_0
    //   20: ldc 92
    //   22: invokestatic 98	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   25: astore_3
    //   26: aload_2
    //   27: astore_0
    //   28: aload_2
    //   29: aload 4
    //   31: invokevirtual 104	java/io/InputStream:read	([B)I
    //   34: istore_1
    //   35: iload_1
    //   36: ifle +77 -> 113
    //   39: aload_2
    //   40: astore_0
    //   41: aload_3
    //   42: aload 4
    //   44: iconst_0
    //   45: iload_1
    //   46: invokevirtual 108	java/security/MessageDigest:update	([BII)V
    //   49: goto -23 -> 26
    //   52: astore_3
    //   53: aload_2
    //   54: astore_0
    //   55: getstatic 22	cn/domob/android/i/d:a	Lcn/domob/android/i/f;
    //   58: astore 5
    //   60: aload_2
    //   61: astore_0
    //   62: new 44	java/lang/StringBuilder
    //   65: astore 4
    //   67: aload_2
    //   68: astore_0
    //   69: aload 4
    //   71: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   74: aload_2
    //   75: astore_0
    //   76: aload 5
    //   78: ldc 110
    //   80: aload 4
    //   82: ldc 112
    //   84: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_3
    //   88: invokevirtual 115	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokevirtual 118	cn/domob/android/i/f:e	(Ljava/lang/Object;Ljava/lang/String;)V
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 119	java/io/InputStream:close	()V
    //   108: ldc 110
    //   110: astore_3
    //   111: aload_3
    //   112: areturn
    //   113: aload_2
    //   114: astore_0
    //   115: aload_3
    //   116: invokevirtual 123	java/security/MessageDigest:digest	()[B
    //   119: ldc 110
    //   121: invokestatic 126	cn/domob/android/i/d:a	([BLjava/lang/String;)Ljava/lang/String;
    //   124: astore_3
    //   125: aload_3
    //   126: astore_0
    //   127: aload_0
    //   128: astore_3
    //   129: aload_2
    //   130: ifnull -19 -> 111
    //   133: aload_2
    //   134: invokevirtual 119	java/io/InputStream:close	()V
    //   137: aload_0
    //   138: astore_3
    //   139: goto -28 -> 111
    //   142: astore_2
    //   143: getstatic 22	cn/domob/android/i/d:a	Lcn/domob/android/i/f;
    //   146: aload_2
    //   147: invokevirtual 129	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   150: aload_0
    //   151: astore_3
    //   152: goto -41 -> 111
    //   155: astore_0
    //   156: getstatic 22	cn/domob/android/i/d:a	Lcn/domob/android/i/f;
    //   159: aload_0
    //   160: invokevirtual 129	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   163: goto -55 -> 108
    //   166: astore_2
    //   167: aconst_null
    //   168: astore_0
    //   169: aload_0
    //   170: ifnull +7 -> 177
    //   173: aload_0
    //   174: invokevirtual 119	java/io/InputStream:close	()V
    //   177: aload_2
    //   178: athrow
    //   179: astore_0
    //   180: getstatic 22	cn/domob/android/i/d:a	Lcn/domob/android/i/f;
    //   183: aload_0
    //   184: invokevirtual 129	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   187: goto -10 -> 177
    //   190: astore_2
    //   191: goto -22 -> 169
    //   194: astore_3
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -144 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramString	String
    //   34	12	1	i	int
    //   3	131	2	localFileInputStream	java.io.FileInputStream
    //   142	5	2	localIOException	java.io.IOException
    //   166	12	2	localObject1	Object
    //   190	1	2	localObject2	Object
    //   196	1	2	localObject3	Object
    //   25	17	3	localMessageDigest	MessageDigest
    //   52	36	3	localException1	Exception
    //   110	42	3	str	String
    //   194	1	3	localException2	Exception
    //   16	65	4	localObject4	Object
    //   58	19	5	localf	f
    // Exception table:
    //   from	to	target	type
    //   11	18	52	java/lang/Exception
    //   20	26	52	java/lang/Exception
    //   28	35	52	java/lang/Exception
    //   41	49	52	java/lang/Exception
    //   115	125	52	java/lang/Exception
    //   133	137	142	java/io/IOException
    //   104	108	155	java/io/IOException
    //   0	9	166	finally
    //   173	177	179	java/io/IOException
    //   11	18	190	finally
    //   20	26	190	finally
    //   28	35	190	finally
    //   41	49	190	finally
    //   55	60	190	finally
    //   62	67	190	finally
    //   69	74	190	finally
    //   76	100	190	finally
    //   115	125	190	finally
    //   0	9	194	java/lang/Exception
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
  
  /* Error */
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: invokestatic 42	cn/domob/android/i/c:h	()Z
    //   6: ifeq +138 -> 144
    //   9: aload_2
    //   10: ifnull +134 -> 144
    //   13: aload_0
    //   14: invokestatic 36	cn/domob/android/i/h:e	(Ljava/lang/String;)Z
    //   17: ifne +127 -> 144
    //   20: aload_1
    //   21: invokestatic 36	cn/domob/android/i/h:e	(Ljava/lang/String;)Z
    //   24: ifne +120 -> 144
    //   27: new 44	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   34: invokestatic 51	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   37: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: astore_0
    //   48: new 67	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 5
    //   58: aload 5
    //   60: invokevirtual 147	java/io/File:exists	()Z
    //   63: ifne +95 -> 158
    //   66: aload 5
    //   68: invokevirtual 150	java/io/File:mkdir	()Z
    //   71: istore_3
    //   72: iload_3
    //   73: ifeq +71 -> 144
    //   76: aconst_null
    //   77: astore 6
    //   79: new 152	java/io/BufferedWriter
    //   82: astore 5
    //   84: new 154	java/io/FileWriter
    //   87: astore 7
    //   89: new 44	java/lang/StringBuilder
    //   92: astore 8
    //   94: aload 8
    //   96: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   99: aload 7
    //   101: aload 8
    //   103: aload_0
    //   104: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload_1
    //   108: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: iconst_0
    //   115: invokespecial 157	java/io/FileWriter:<init>	(Ljava/lang/String;Z)V
    //   118: aload 5
    //   120: aload 7
    //   122: invokespecial 160	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   125: aload 5
    //   127: astore_0
    //   128: aload 5
    //   130: aload_2
    //   131: invokevirtual 163	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   134: aload 5
    //   136: ifnull +8 -> 144
    //   139: aload 5
    //   141: invokevirtual 164	java/io/BufferedWriter:close	()V
    //   144: return
    //   145: astore 5
    //   147: aload 5
    //   149: invokevirtual 165	java/lang/Exception:printStackTrace	()V
    //   152: iload 4
    //   154: istore_3
    //   155: goto -83 -> 72
    //   158: iconst_1
    //   159: istore_3
    //   160: goto -88 -> 72
    //   163: astore_0
    //   164: aload_0
    //   165: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   168: goto -24 -> 144
    //   171: astore_2
    //   172: aconst_null
    //   173: astore_1
    //   174: aload_1
    //   175: astore_0
    //   176: aload_2
    //   177: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   180: aload_1
    //   181: ifnull -37 -> 144
    //   184: aload_1
    //   185: invokevirtual 164	java/io/BufferedWriter:close	()V
    //   188: goto -44 -> 144
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   196: goto -52 -> 144
    //   199: astore_0
    //   200: aload 6
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +7 -> 211
    //   207: aload_1
    //   208: invokevirtual 164	java/io/BufferedWriter:close	()V
    //   211: aload_0
    //   212: athrow
    //   213: astore_1
    //   214: aload_1
    //   215: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   218: goto -7 -> 211
    //   221: astore_1
    //   222: aload_0
    //   223: astore_2
    //   224: aload_1
    //   225: astore_0
    //   226: aload_2
    //   227: astore_1
    //   228: goto -25 -> 203
    //   231: astore_2
    //   232: aload 5
    //   234: astore_1
    //   235: goto -61 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramString1	String
    //   0	238	1	paramString2	String
    //   0	238	2	paramString3	String
    //   71	89	3	bool1	boolean
    //   1	152	4	bool2	boolean
    //   56	84	5	localObject1	Object
    //   145	88	5	localException	Exception
    //   77	124	6	localObject2	Object
    //   87	34	7	localFileWriter	java.io.FileWriter
    //   92	10	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   66	72	145	java/lang/Exception
    //   139	144	163	java/io/IOException
    //   79	125	171	java/io/IOException
    //   184	188	191	java/io/IOException
    //   79	125	199	finally
    //   207	211	213	java/io/IOException
    //   128	134	221	finally
    //   176	180	221	finally
    //   128	134	231	java/io/IOException
  }
  
  public static Drawable b(Context paramContext, String paramString)
  {
    try
    {
      paramContext = new android/graphics/drawable/BitmapDrawable;
      ClassLoader localClassLoader = h.class.getClassLoader();
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      paramContext.<init>(BitmapFactory.decodeStream(localClassLoader.getResourceAsStream("assets/" + paramString)));
      return paramContext;
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
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */