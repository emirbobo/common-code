import java.io.IOException;
import java.io.InputStream;

public final class jv
  implements Runnable
{
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private js jdField_a_of_type_Js = null;
  private jt jdField_a_of_type_Jt = null;
  private jx jdField_a_of_type_Jx = null;
  private kk jdField_a_of_type_Kk;
  private kt jdField_a_of_type_Kt;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public jv(kk paramkk, js paramjs, jt paramjt, jx paramjx, InputStream paramInputStream)
  {
    this.jdField_a_of_type_Kt = new kt(paramInputStream);
    this.jdField_a_of_type_Js = paramjs;
    this.jdField_a_of_type_Jt = paramjt;
    this.jdField_a_of_type_Jx = paramjx;
    this.jdField_a_of_type_Kk = paramkk;
  }
  
  public final void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      new Thread(this, "MQTT Client Comms Receiver").start();
    }
  }
  
  public final void b()
    throws IOException
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Kk.a(850);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    try
    {
      this.jdField_a_of_type_Kk.a(851);
      this.jdField_a_of_type_JavaLangObject.wait();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final void c()
  {
    this.jdField_a_of_type_Kk.a(855, new Object[] { new Boolean(true) });
    this.b = true;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	jv:jdField_a_of_type_Boolean	Z
    //   4: ifeq +198 -> 202
    //   7: aload_0
    //   8: getfield 39	jv:jdField_a_of_type_Kt	Lkt;
    //   11: ifnull +191 -> 202
    //   14: aload_0
    //   15: getfield 41	jv:jdField_a_of_type_Kk	Lkk;
    //   18: sipush 852
    //   21: invokevirtual 61	kk:a	(I)V
    //   24: aload_0
    //   25: getfield 39	jv:jdField_a_of_type_Kt	Lkt;
    //   28: invokevirtual 80	kt:a	()Lli;
    //   31: astore_2
    //   32: aload_2
    //   33: instanceof 82
    //   36: ifeq +144 -> 180
    //   39: aload_0
    //   40: getfield 30	jv:jdField_a_of_type_Jx	Ljx;
    //   43: aload_2
    //   44: invokevirtual 87	jx:a	(Lli;)Ljl;
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +76 -> 125
    //   52: aload_1
    //   53: monitorenter
    //   54: aload_0
    //   55: getfield 26	jv:jdField_a_of_type_Jt	Ljt;
    //   58: aload_2
    //   59: invokevirtual 92	jt:b	(Lli;)V
    //   62: aload_2
    //   63: instanceof 94
    //   66: ifeq +27 -> 93
    //   69: aload_2
    //   70: checkcast 94	kq
    //   73: getfield 97	kq:a	I
    //   76: ifeq +17 -> 93
    //   79: aload_0
    //   80: getfield 24	jv:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   83: astore_3
    //   84: aload_3
    //   85: monitorenter
    //   86: aload_0
    //   87: iconst_0
    //   88: putfield 22	jv:jdField_a_of_type_Boolean	Z
    //   91: aload_3
    //   92: monitorexit
    //   93: aload_1
    //   94: monitorexit
    //   95: goto -95 -> 0
    //   98: astore_2
    //   99: aload_1
    //   100: monitorexit
    //   101: aload_2
    //   102: athrow
    //   103: astore_1
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 22	jv:jdField_a_of_type_Boolean	Z
    //   109: aload_0
    //   110: getfield 28	jv:jdField_a_of_type_Js	Ljs;
    //   113: aload_1
    //   114: invokevirtual 102	js:a	(Ljm;)V
    //   117: goto -117 -> 0
    //   120: astore_2
    //   121: aload_3
    //   122: monitorexit
    //   123: aload_2
    //   124: athrow
    //   125: aload_0
    //   126: getfield 26	jv:jdField_a_of_type_Jt	Ljt;
    //   129: aload_2
    //   130: invokevirtual 92	jt:b	(Lli;)V
    //   133: goto -133 -> 0
    //   136: astore_1
    //   137: aload_0
    //   138: getfield 41	jv:jdField_a_of_type_Kk	Lkk;
    //   141: sipush 853
    //   144: aconst_null
    //   145: aload_1
    //   146: invokevirtual 105	kk:a	(I[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 22	jv:jdField_a_of_type_Boolean	Z
    //   154: aload_0
    //   155: getfield 32	jv:b	Z
    //   158: ifne +33 -> 191
    //   161: aload_0
    //   162: getfield 28	jv:jdField_a_of_type_Js	Ljs;
    //   165: new 77	jm
    //   168: dup
    //   169: aload_1
    //   170: iconst_0
    //   171: invokespecial 108	jm:<init>	(Ljava/lang/Throwable;B)V
    //   174: invokevirtual 102	js:a	(Ljm;)V
    //   177: goto -177 -> 0
    //   180: aload_0
    //   181: getfield 26	jv:jdField_a_of_type_Jt	Ljt;
    //   184: aload_2
    //   185: invokevirtual 92	jt:b	(Lli;)V
    //   188: goto -188 -> 0
    //   191: aload_0
    //   192: getfield 28	jv:jdField_a_of_type_Js	Ljs;
    //   195: aconst_null
    //   196: invokevirtual 102	js:a	(Ljm;)V
    //   199: goto -199 -> 0
    //   202: aload_0
    //   203: getfield 24	jv:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   206: astore_2
    //   207: aload_2
    //   208: monitorenter
    //   209: aload_0
    //   210: getfield 41	jv:jdField_a_of_type_Kk	Lkk;
    //   213: sipush 854
    //   216: invokevirtual 61	kk:a	(I)V
    //   219: aload_0
    //   220: getfield 24	jv:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   223: invokevirtual 111	java/lang/Object:notifyAll	()V
    //   226: aload_2
    //   227: monitorexit
    //   228: return
    //   229: astore_1
    //   230: aload_2
    //   231: monitorexit
    //   232: aload_1
    //   233: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	234	0	this	jv
    //   47	53	1	localjl	jl
    //   103	11	1	localjm	jm
    //   136	34	1	localIOException	IOException
    //   229	4	1	localObject1	Object
    //   31	39	2	localli1	li
    //   98	4	2	localObject2	Object
    //   120	65	2	localli2	li
    // Exception table:
    //   from	to	target	type
    //   54	86	98	finally
    //   93	95	98	finally
    //   121	125	98	finally
    //   14	48	103	jm
    //   52	54	103	jm
    //   99	103	103	jm
    //   125	133	103	jm
    //   180	188	103	jm
    //   86	93	120	finally
    //   14	48	136	java/io/IOException
    //   52	54	136	java/io/IOException
    //   99	103	136	java/io/IOException
    //   125	133	136	java/io/IOException
    //   180	188	136	java/io/IOException
    //   209	228	229	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */