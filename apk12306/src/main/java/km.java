import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class km
  implements kl
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private ByteArrayOutputStream jdField_a_of_type_JavaIoByteArrayOutputStream;
  private DataOutputStream jdField_a_of_type_JavaIoDataOutputStream;
  private File jdField_a_of_type_JavaIoFile;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private Properties jdField_a_of_type_JavaUtilProperties = new Properties();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private File jdField_b_of_type_JavaIoFile;
  private int c = 0;
  private int d = 0;
  
  public km()
  {
    String str = System.getProperty("org.eclipse.paho.client.mqttv3.trace");
    if (str == null) {}
    for (this.jdField_a_of_type_JavaIoFile = new File(System.getProperty("user.dir"), "mqtt-trace.properties");; this.jdField_a_of_type_JavaIoFile = new File(str))
    {
      a();
      return;
    }
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {}
    try
    {
      this.jdField_a_of_type_JavaIoFileOutputStream.close();
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      this.d = 0;
      File localFile = new File(this.jdField_b_of_type_JavaIoFile, "mqtt-" + this.c + ".trc");
      if (localFile.exists()) {
        localFile.delete();
      }
      try
      {
        FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
        localFileOutputStream.<init>(localFile);
        this.jdField_a_of_type_JavaIoFileOutputStream = localFileOutputStream;
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_JavaIoFile.exists()) {
      if (this.jdField_a_of_type_JavaIoFile.lastModified() == this.jdField_a_of_type_Long) {}
    }
    for (;;)
    {
      try
      {
        Properties localProperties = this.jdField_a_of_type_JavaUtilProperties;
        FileInputStream localFileInputStream = new java/io/FileInputStream;
        localFileInputStream.<init>(this.jdField_a_of_type_JavaIoFile);
        localProperties.load(localFileInputStream);
        this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.lastModified();
        this.jdField_b_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaUtilProperties.getProperty("org.eclipse.paho.client.mqttv3.trace.outputName", System.getProperty("user.dir")));
        if (this.jdField_b_of_type_JavaIoFile.exists()) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilProperties.clear();
        this.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Boolean = false;
      }
      catch (Exception localException)
      {
        this.jdField_a_of_type_JavaUtilProperties.clear();
        this.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Boolean = false;
        continue;
        this.jdField_a_of_type_Int = Integer.parseInt(this.jdField_a_of_type_JavaUtilProperties.getProperty("org.eclipse.paho.client.mqttv3.trace.count", "1"));
        this.jdField_b_of_type_Int = Integer.parseInt(this.jdField_a_of_type_JavaUtilProperties.getProperty("org.eclipse.paho.client.mqttv3.trace.limit", "5000000"));
        a();
        if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
          continue;
        }
        this.jdField_a_of_type_JavaUtilProperties.clear();
        this.jdField_a_of_type_Long = 0L;
        this.jdField_a_of_type_Boolean = false;
        continue;
        this.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream();
        this.jdField_a_of_type_JavaIoDataOutputStream = new DataOutputStream(this.jdField_a_of_type_JavaIoByteArrayOutputStream);
        this.jdField_a_of_type_Boolean = true;
        bool = true;
        continue;
      }
      return bool;
      bool = this.jdField_a_of_type_Boolean;
      continue;
      this.jdField_a_of_type_JavaUtilProperties.clear();
      this.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  /* Error */
  public final void a(kn paramkn)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_0
    //   6: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   9: aload_1
    //   10: getfield 163	kn:jdField_a_of_type_Short	S
    //   13: invokevirtual 167	java/io/DataOutputStream:writeShort	(I)V
    //   16: aload_0
    //   17: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   20: aload_1
    //   21: getfield 168	kn:jdField_a_of_type_Long	J
    //   24: invokevirtual 172	java/io/DataOutputStream:writeLong	(J)V
    //   27: aload_1
    //   28: getfield 175	kn:jdField_a_of_type_Byte	B
    //   31: istore_3
    //   32: iload_3
    //   33: istore_2
    //   34: aload_1
    //   35: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   38: ifnull +19 -> 57
    //   41: iload_3
    //   42: istore_2
    //   43: aload_1
    //   44: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   47: arraylength
    //   48: ifle +9 -> 57
    //   51: iload_3
    //   52: bipush 32
    //   54: ior
    //   55: i2b
    //   56: istore_2
    //   57: iload_2
    //   58: istore_3
    //   59: aload_1
    //   60: getfield 181	kn:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   63: ifnull +9 -> 72
    //   66: iload_2
    //   67: bipush 64
    //   69: ior
    //   70: i2b
    //   71: istore_3
    //   72: aload_0
    //   73: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   76: iload_3
    //   77: invokevirtual 184	java/io/DataOutputStream:writeByte	(I)V
    //   80: aload_0
    //   81: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   84: aload_1
    //   85: getfield 186	kn:b	S
    //   88: invokevirtual 167	java/io/DataOutputStream:writeShort	(I)V
    //   91: aload_0
    //   92: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   95: aload_1
    //   96: getfield 189	kn:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   99: invokevirtual 192	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   102: aload_1
    //   103: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   106: ifnull +86 -> 192
    //   109: aload_1
    //   110: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   113: arraylength
    //   114: ifle +78 -> 192
    //   117: aload_0
    //   118: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   121: aload_1
    //   122: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   125: arraylength
    //   126: invokevirtual 167	java/io/DataOutputStream:writeShort	(I)V
    //   129: iconst_0
    //   130: istore_2
    //   131: iload_2
    //   132: aload_1
    //   133: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   136: arraylength
    //   137: if_icmpge +55 -> 192
    //   140: aload_1
    //   141: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   144: iload_2
    //   145: aaload
    //   146: ifnull +25 -> 171
    //   149: aload_0
    //   150: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   153: aload_1
    //   154: getfield 178	kn:jdField_a_of_type_ArrayOfJavaLangObject	[Ljava/lang/Object;
    //   157: iload_2
    //   158: aaload
    //   159: invokevirtual 193	java/lang/Object:toString	()Ljava/lang/String;
    //   162: invokevirtual 192	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   165: iinc 2 1
    //   168: goto -37 -> 131
    //   171: aload_0
    //   172: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   175: ldc -61
    //   177: invokevirtual 192	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   180: goto -15 -> 165
    //   183: astore_1
    //   184: aload_0
    //   185: iconst_0
    //   186: putfield 24	km:jdField_a_of_type_Boolean	Z
    //   189: aload_0
    //   190: monitorexit
    //   191: return
    //   192: aload_1
    //   193: getfield 181	kn:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   196: ifnull +68 -> 264
    //   199: aload_1
    //   200: getfield 181	kn:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   203: invokevirtual 201	java/lang/Throwable:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   206: astore 5
    //   208: aload_0
    //   209: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   212: aload 5
    //   214: arraylength
    //   215: iconst_1
    //   216: iadd
    //   217: invokevirtual 167	java/io/DataOutputStream:writeShort	(I)V
    //   220: aload_0
    //   221: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   224: aload_1
    //   225: getfield 181	kn:jdField_a_of_type_JavaLangThrowable	Ljava/lang/Throwable;
    //   228: invokevirtual 202	java/lang/Throwable:toString	()Ljava/lang/String;
    //   231: invokevirtual 192	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   234: iload 4
    //   236: istore_2
    //   237: iload_2
    //   238: aload 5
    //   240: arraylength
    //   241: if_icmpge +23 -> 264
    //   244: aload_0
    //   245: getfield 157	km:jdField_a_of_type_JavaIoDataOutputStream	Ljava/io/DataOutputStream;
    //   248: aload 5
    //   250: iload_2
    //   251: aaload
    //   252: invokevirtual 205	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   255: invokevirtual 192	java/io/DataOutputStream:writeUTF	(Ljava/lang/String;)V
    //   258: iinc 2 1
    //   261: goto -24 -> 237
    //   264: aload_0
    //   265: getfield 137	km:jdField_a_of_type_Int	I
    //   268: iconst_1
    //   269: if_icmple +52 -> 321
    //   272: aload_0
    //   273: getfield 28	km:d	I
    //   276: aload_0
    //   277: getfield 150	km:jdField_a_of_type_JavaIoByteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
    //   280: invokevirtual 209	java/io/ByteArrayOutputStream:size	()I
    //   283: iadd
    //   284: aload_0
    //   285: getfield 143	km:jdField_b_of_type_Int	I
    //   288: if_icmple +33 -> 321
    //   291: aload_0
    //   292: aload_0
    //   293: getfield 26	km:c	I
    //   296: iconst_1
    //   297: iadd
    //   298: putfield 26	km:c	I
    //   301: aload_0
    //   302: getfield 26	km:c	I
    //   305: aload_0
    //   306: getfield 137	km:jdField_a_of_type_Int	I
    //   309: if_icmpne +8 -> 317
    //   312: aload_0
    //   313: iconst_0
    //   314: putfield 26	km:c	I
    //   317: aload_0
    //   318: invokespecial 145	km:a	()V
    //   321: aload_0
    //   322: getfield 67	km:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   325: ifnull +37 -> 362
    //   328: aload_0
    //   329: aload_0
    //   330: getfield 28	km:d	I
    //   333: aload_0
    //   334: getfield 150	km:jdField_a_of_type_JavaIoByteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
    //   337: invokevirtual 209	java/io/ByteArrayOutputStream:size	()I
    //   340: iadd
    //   341: putfield 28	km:d	I
    //   344: aload_0
    //   345: getfield 150	km:jdField_a_of_type_JavaIoByteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
    //   348: aload_0
    //   349: getfield 67	km:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   352: invokevirtual 212	java/io/ByteArrayOutputStream:writeTo	(Ljava/io/OutputStream;)V
    //   355: aload_0
    //   356: getfield 67	km:jdField_a_of_type_JavaIoFileOutputStream	Ljava/io/FileOutputStream;
    //   359: invokevirtual 215	java/io/FileOutputStream:flush	()V
    //   362: aload_0
    //   363: getfield 150	km:jdField_a_of_type_JavaIoByteArrayOutputStream	Ljava/io/ByteArrayOutputStream;
    //   366: invokevirtual 218	java/io/ByteArrayOutputStream:reset	()V
    //   369: goto -180 -> 189
    //   372: astore_1
    //   373: aload_0
    //   374: monitorexit
    //   375: aload_1
    //   376: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	this	km
    //   0	377	1	paramkn	kn
    //   33	226	2	i	int
    //   31	46	3	j	int
    //   1	234	4	k	int
    //   206	43	5	arrayOfStackTraceElement	StackTraceElement[]
    // Exception table:
    //   from	to	target	type
    //   5	32	183	java/lang/Exception
    //   34	41	183	java/lang/Exception
    //   43	51	183	java/lang/Exception
    //   59	66	183	java/lang/Exception
    //   72	129	183	java/lang/Exception
    //   131	165	183	java/lang/Exception
    //   171	180	183	java/lang/Exception
    //   192	234	183	java/lang/Exception
    //   237	258	183	java/lang/Exception
    //   264	317	183	java/lang/Exception
    //   317	321	183	java/lang/Exception
    //   321	362	183	java/lang/Exception
    //   362	369	183	java/lang/Exception
    //   5	32	372	finally
    //   34	41	372	finally
    //   43	51	372	finally
    //   59	66	372	finally
    //   72	129	372	finally
    //   131	165	372	finally
    //   171	180	372	finally
    //   184	189	372	finally
    //   192	234	372	finally
    //   237	258	372	finally
    //   264	317	372	finally
    //   317	321	372	finally
    //   321	362	372	finally
    //   362	369	372	finally
  }
  
  public final boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Boolean) && (("on".equalsIgnoreCase(this.jdField_a_of_type_JavaUtilProperties.getProperty("org.eclipse.paho.client.mqttv3.trace.client.*.status"))) || ("on".equalsIgnoreCase(this.jdField_a_of_type_JavaUtilProperties.getProperty("org.eclipse.paho.client.mqttv3.trace.client." + paramString + ".status"))))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\km.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */