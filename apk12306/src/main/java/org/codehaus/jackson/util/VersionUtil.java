package org.codehaus.jackson.util;

import java.util.regex.Pattern;
import org.codehaus.jackson.Version;

public class VersionUtil
{
  public static final String VERSION_FILE = "VERSION.txt";
  private static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
  
  public static Version parseVersion(String paramString)
  {
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramString == null) {
      paramString = (String)localObject1;
    }
    for (;;)
    {
      return paramString;
      Object localObject3 = paramString.trim();
      paramString = (String)localObject1;
      if (((String)localObject3).length() != 0)
      {
        localObject3 = VERSION_SEPARATOR.split((CharSequence)localObject3);
        paramString = (String)localObject1;
        if (localObject3.length >= 2)
        {
          int j = parseVersionPart(localObject3[0]);
          int k = parseVersionPart(localObject3[1]);
          if (localObject3.length > 2) {
            i = parseVersionPart(localObject3[2]);
          }
          paramString = (String)localObject2;
          if (localObject3.length > 3) {
            paramString = localObject3[3];
          }
          paramString = new Version(j, k, i, paramString);
        }
      }
    }
  }
  
  protected static int parseVersionPart(String paramString)
  {
    paramString = paramString.toString();
    int k = paramString.length();
    int i = 0;
    for (int j = 0;; j++)
    {
      int m;
      if (j < k)
      {
        m = paramString.charAt(j);
        if ((m <= 57) && (m >= 48)) {}
      }
      else
      {
        return i;
      }
      i = i * 10 + (m - 48);
    }
  }
  
  /* Error */
  public static Version versionFor(Class<?> paramClass)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: aload_0
    //   7: ldc 8
    //   9: invokevirtual 68	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore 4
    //   14: aload_3
    //   15: astore_0
    //   16: aload 4
    //   18: ifnull +37 -> 55
    //   21: new 70	java/io/BufferedReader
    //   24: astore_1
    //   25: new 72	java/io/InputStreamReader
    //   28: astore_0
    //   29: aload_0
    //   30: aload 4
    //   32: ldc 74
    //   34: invokespecial 77	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   37: aload_1
    //   38: aload_0
    //   39: invokespecial 80	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: aload_1
    //   43: invokevirtual 83	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: invokestatic 85	org/codehaus/jackson/util/VersionUtil:parseVersion	(Ljava/lang/String;)Lorg/codehaus/jackson/Version;
    //   49: astore_0
    //   50: aload 4
    //   52: invokevirtual 90	java/io/InputStream:close	()V
    //   55: aload_0
    //   56: astore_1
    //   57: aload_0
    //   58: ifnonnull +7 -> 65
    //   61: invokestatic 94	org/codehaus/jackson/Version:unknownVersion	()Lorg/codehaus/jackson/Version;
    //   64: astore_1
    //   65: aload_1
    //   66: areturn
    //   67: astore_2
    //   68: aload_0
    //   69: astore_1
    //   70: new 96	java/lang/RuntimeException
    //   73: astore_3
    //   74: aload_0
    //   75: astore_1
    //   76: aload_3
    //   77: aload_2
    //   78: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   81: aload_0
    //   82: astore_1
    //   83: aload_3
    //   84: athrow
    //   85: astore_0
    //   86: aload_1
    //   87: astore_0
    //   88: goto -33 -> 55
    //   91: astore_0
    //   92: aload 4
    //   94: invokevirtual 90	java/io/InputStream:close	()V
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: athrow
    //   101: astore_0
    //   102: aload_2
    //   103: astore_1
    //   104: new 96	java/lang/RuntimeException
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: aload_3
    //   111: aload_0
    //   112: invokespecial 99	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   115: aload_2
    //   116: astore_1
    //   117: aload_3
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramClass	Class<?>
    //   5	112	1	localObject1	Object
    //   1	4	2	localObject2	Object
    //   67	49	2	localIOException	java.io.IOException
    //   3	115	3	localRuntimeException	RuntimeException
    //   12	81	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   50	55	67	java/io/IOException
    //   6	14	85	java/io/IOException
    //   70	74	85	java/io/IOException
    //   76	81	85	java/io/IOException
    //   83	85	85	java/io/IOException
    //   99	101	85	java/io/IOException
    //   104	108	85	java/io/IOException
    //   110	115	85	java/io/IOException
    //   117	119	85	java/io/IOException
    //   21	50	91	finally
    //   92	97	101	java/io/IOException
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\codehaus\jackson\util\VersionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */