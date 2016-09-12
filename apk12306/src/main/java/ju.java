import java.util.Vector;

public final class ju
  implements Runnable
{
  private static int jdField_a_of_type_Int = 10;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Thread jdField_a_of_type_JavaLangThread;
  private Vector jdField_a_of_type_JavaUtilVector;
  private ji jdField_a_of_type_Ji;
  private js jdField_a_of_type_Js;
  private kk jdField_a_of_type_Kk;
  private boolean jdField_a_of_type_Boolean = false;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Vector jdField_b_of_type_JavaUtilVector;
  private boolean jdField_b_of_type_Boolean = false;
  private Object jdField_c_of_type_JavaLangObject = new Object();
  private boolean jdField_c_of_type_Boolean = false;
  
  ju(kk paramkk, js paramjs)
  {
    this.jdField_a_of_type_Kk = paramkk;
    this.jdField_a_of_type_Js = paramjs;
    this.jdField_a_of_type_JavaUtilVector = new Vector(jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaUtilVector = new Vector(jdField_a_of_type_Int);
  }
  
  protected final Thread a()
  {
    return this.jdField_a_of_type_JavaLangThread;
  }
  
  public final void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangThread = new Thread(this, "MQTT Client Callback");
      this.jdField_a_of_type_JavaLangThread.start();
    }
  }
  
  public final void a(Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Ji != null)
    {
      this.jdField_a_of_type_Kk.a(708, null, paramThrowable);
      ji localji = this.jdField_a_of_type_Ji;
      if (localji.jdField_a_of_type_Dz != null) {
        localji.jdField_a_of_type_Dz.b(paramThrowable);
      }
      if ((localji.jdField_a_of_type_Ea.equals(ea.d)) && (localji.jdField_a_of_type_Boolean)) {
        localji.a(localji.b, null);
      }
    }
  }
  
  public final void a(ji paramji)
  {
    this.jdField_a_of_type_Ji = paramji;
  }
  
  public final void a(jl paramjl)
  {
    if (this.jdField_a_of_type_Ji != null) {
      this.jdField_b_of_type_JavaUtilVector.addElement(paramjl);
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_Kk.a()) {
        this.jdField_a_of_type_Kk.a(715, new Object[] { paramjl });
      }
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public final void a(lc paramlc)
  {
    if (this.jdField_a_of_type_Ji != null) {
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          int j = this.jdField_a_of_type_JavaUtilVector.size();
          int i = jdField_a_of_type_Int;
          if (j < i) {}
        }
      }
    }
    try
    {
      this.jdField_a_of_type_Kk.a(709);
      this.jdField_c_of_type_JavaLangObject.wait();
      if (!this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_JavaUtilVector.addElement(paramlc);
      }
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_Kk.a(710);
        this.jdField_b_of_type_JavaLangObject.notifyAll();
        return;
        paramlc = finally;
        throw paramlc;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void b()
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	ju:jdField_a_of_type_Boolean	Z
    //   4: ifeq +93 -> 97
    //   7: aload_0
    //   8: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   11: sipush 700
    //   14: invokevirtual 124	kk:a	(I)V
    //   17: aload_0
    //   18: iconst_0
    //   19: putfield 28	ju:jdField_a_of_type_Boolean	Z
    //   22: invokestatic 132	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   25: aload_0
    //   26: getfield 54	ju:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   29: invokevirtual 133	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   32: ifne +55 -> 87
    //   35: aload_0
    //   36: getfield 32	ju:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   39: astore_1
    //   40: aload_1
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 34	ju:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   46: astore_3
    //   47: aload_3
    //   48: monitorenter
    //   49: aload_0
    //   50: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   53: sipush 701
    //   56: invokevirtual 124	kk:a	(I)V
    //   59: aload_0
    //   60: getfield 34	ju:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   63: invokevirtual 115	java/lang/Object:notifyAll	()V
    //   66: aload_3
    //   67: monitorexit
    //   68: aload_0
    //   69: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   72: sipush 702
    //   75: invokevirtual 124	kk:a	(I)V
    //   78: aload_0
    //   79: getfield 32	ju:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   82: invokevirtual 127	java/lang/Object:wait	()V
    //   85: aload_1
    //   86: monitorexit
    //   87: aload_0
    //   88: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   91: sipush 703
    //   94: invokevirtual 124	kk:a	(I)V
    //   97: return
    //   98: astore_2
    //   99: aload_3
    //   100: monitorexit
    //   101: aload_2
    //   102: athrow
    //   103: astore_2
    //   104: aload_1
    //   105: monitorexit
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: goto -22 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	ju
    //   108	1	1	localInterruptedException	InterruptedException
    //   98	4	2	localObject2	Object
    //   103	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	68	98	finally
    //   42	49	103	finally
    //   68	87	103	finally
    //   99	103	103	finally
    //   35	42	108	java/lang/InterruptedException
    //   104	108	108	java/lang/InterruptedException
  }
  
  public final void c()
  {
    this.jdField_b_of_type_Boolean = true;
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Kk.a(711);
      this.jdField_c_of_type_JavaLangObject.notifyAll();
      synchronized (this.jdField_c_of_type_JavaLangObject)
      {
        boolean bool = this.jdField_c_of_type_Boolean;
        if (!bool) {}
      }
    }
    try
    {
      this.jdField_a_of_type_Kk.a(712);
      this.jdField_c_of_type_JavaLangObject.wait();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
      localObject3 = finally;
      throw ((Throwable)localObject3);
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	ju:jdField_a_of_type_Boolean	Z
    //   4: ifeq +562 -> 566
    //   7: aload_0
    //   8: getfield 34	ju:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 49	ju:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   18: invokevirtual 140	java/util/Vector:isEmpty	()Z
    //   21: ifeq +30 -> 51
    //   24: aload_0
    //   25: getfield 51	ju:jdField_b_of_type_JavaUtilVector	Ljava/util/Vector;
    //   28: invokevirtual 140	java/util/Vector:isEmpty	()Z
    //   31: ifeq +20 -> 51
    //   34: aload_0
    //   35: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   38: sipush 704
    //   41: invokevirtual 124	kk:a	(I)V
    //   44: aload_0
    //   45: getfield 34	ju:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   48: invokevirtual 127	java/lang/Object:wait	()V
    //   51: aload_1
    //   52: monitorexit
    //   53: aload_0
    //   54: getfield 28	ju:jdField_a_of_type_Boolean	Z
    //   57: ifeq +97 -> 154
    //   60: aload_0
    //   61: getfield 51	ju:jdField_b_of_type_JavaUtilVector	Ljava/util/Vector;
    //   64: invokevirtual 140	java/util/Vector:isEmpty	()Z
    //   67: ifne +63 -> 130
    //   70: aload_0
    //   71: getfield 67	ju:jdField_a_of_type_Ji	Lji;
    //   74: ifnull +56 -> 130
    //   77: aload_0
    //   78: getfield 51	ju:jdField_b_of_type_JavaUtilVector	Ljava/util/Vector;
    //   81: iconst_0
    //   82: invokevirtual 144	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   85: checkcast 146	jl
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 51	ju:jdField_b_of_type_JavaUtilVector	Ljava/util/Vector;
    //   93: iconst_0
    //   94: invokevirtual 149	java/util/Vector:removeElementAt	(I)V
    //   97: aload_0
    //   98: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   101: invokevirtual 109	kk:a	()Z
    //   104: ifeq +21 -> 125
    //   107: aload_0
    //   108: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   111: sipush 705
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: aastore
    //   122: invokevirtual 112	kk:a	(I[Ljava/lang/Object;)V
    //   125: aload_0
    //   126: getfield 67	ju:jdField_a_of_type_Ji	Lji;
    //   129: astore_1
    //   130: aload_0
    //   131: getfield 49	ju:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   134: invokevirtual 140	java/util/Vector:isEmpty	()Z
    //   137: ifne +17 -> 154
    //   140: aload_0
    //   141: getfield 30	ju:jdField_b_of_type_Boolean	Z
    //   144: ifeq +53 -> 197
    //   147: aload_0
    //   148: getfield 49	ju:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   151: invokevirtual 152	java/util/Vector:clear	()V
    //   154: aload_0
    //   155: getfield 36	ju:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   158: astore_2
    //   159: aload_2
    //   160: monitorenter
    //   161: aload_0
    //   162: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   165: sipush 706
    //   168: invokevirtual 124	kk:a	(I)V
    //   171: aload_0
    //   172: getfield 36	ju:jdField_c_of_type_JavaLangObject	Ljava/lang/Object;
    //   175: invokevirtual 115	java/lang/Object:notifyAll	()V
    //   178: aload_2
    //   179: monitorexit
    //   180: goto -180 -> 0
    //   183: astore_1
    //   184: aload_2
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    //   188: astore_2
    //   189: aload_1
    //   190: monitorexit
    //   191: aload_2
    //   192: athrow
    //   193: astore_1
    //   194: goto -141 -> 53
    //   197: aload_0
    //   198: getfield 42	ju:jdField_a_of_type_Js	Ljs;
    //   201: getfield 155	js:jdField_a_of_type_Boolean	Z
    //   204: ifeq -50 -> 154
    //   207: aload_0
    //   208: iconst_1
    //   209: putfield 38	ju:jdField_c_of_type_Boolean	Z
    //   212: aload_0
    //   213: getfield 49	ju:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   216: iconst_0
    //   217: invokevirtual 144	java/util/Vector:elementAt	(I)Ljava/lang/Object;
    //   220: checkcast 157	lc
    //   223: astore_2
    //   224: aload_0
    //   225: getfield 49	ju:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   228: iconst_0
    //   229: invokevirtual 149	java/util/Vector:removeElementAt	(I)V
    //   232: aload_0
    //   233: getfield 42	ju:jdField_a_of_type_Js	Ljs;
    //   236: getfield 155	js:jdField_a_of_type_Boolean	Z
    //   239: ifeq +169 -> 408
    //   242: aload_0
    //   243: getfield 67	ju:jdField_a_of_type_Ji	Lji;
    //   246: ifnull +162 -> 408
    //   249: aload_2
    //   250: getfield 159	lc:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   253: astore_1
    //   254: aload_1
    //   255: ifnull +350 -> 605
    //   258: aload_0
    //   259: getfield 42	ju:jdField_a_of_type_Js	Ljs;
    //   262: getfield 162	js:jdField_a_of_type_Jy	Ljy;
    //   265: aload_1
    //   266: invokevirtual 167	jy:a	(Ljava/lang/String;)Ljr;
    //   269: astore_1
    //   270: aload_0
    //   271: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   274: invokevirtual 109	kk:a	()Z
    //   277: ifeq +49 -> 326
    //   280: aload_0
    //   281: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   284: astore 5
    //   286: aload_1
    //   287: getfield 170	jr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   290: astore_3
    //   291: new 172	java/lang/Integer
    //   294: astore 4
    //   296: aload 4
    //   298: aload_2
    //   299: invokevirtual 174	lc:c	()I
    //   302: invokespecial 175	java/lang/Integer:<init>	(I)V
    //   305: aload 5
    //   307: sipush 713
    //   310: iconst_2
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_3
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload 4
    //   322: aastore
    //   323: invokevirtual 112	kk:a	(I[Ljava/lang/Object;)V
    //   326: aload_0
    //   327: getfield 67	ju:jdField_a_of_type_Ji	Lji;
    //   330: astore 4
    //   332: aload_2
    //   333: getfield 178	lc:jdField_a_of_type_Jn	Ljn;
    //   336: astore_3
    //   337: aload 4
    //   339: getfield 77	ji:jdField_a_of_type_Dz	Ldz;
    //   342: ifnull +35 -> 377
    //   345: aload 4
    //   347: getfield 77	ji:jdField_a_of_type_Dz	Ldz;
    //   350: astore 4
    //   352: aload_1
    //   353: getfield 170	jr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   356: astore_1
    //   357: new 180	java/lang/String
    //   360: astore_1
    //   361: aload_1
    //   362: aload_3
    //   363: getfield 185	jn:jdField_a_of_type_ArrayOfByte	[B
    //   366: invokespecial 188	java/lang/String:<init>	([B)V
    //   369: aload 4
    //   371: aload_1
    //   372: invokeinterface 191 2 0
    //   377: aload_2
    //   378: getfield 178	lc:jdField_a_of_type_Jn	Ljn;
    //   381: getfield 192	jn:jdField_a_of_type_Int	I
    //   384: iconst_1
    //   385: if_icmpne +31 -> 416
    //   388: aload_0
    //   389: getfield 42	ju:jdField_a_of_type_Js	Ljs;
    //   392: astore_1
    //   393: new 194	ky
    //   396: astore_3
    //   397: aload_3
    //   398: aload_2
    //   399: invokespecial 196	ky:<init>	(Llc;)V
    //   402: aload_1
    //   403: aload_3
    //   404: invokevirtual 199	js:a	(Lli;)Ljl;
    //   407: pop
    //   408: aload_0
    //   409: iconst_0
    //   410: putfield 38	ju:jdField_c_of_type_Boolean	Z
    //   413: goto -259 -> 154
    //   416: aload_2
    //   417: getfield 178	lc:jdField_a_of_type_Jn	Ljn;
    //   420: getfield 192	jn:jdField_a_of_type_Int	I
    //   423: iconst_2
    //   424: if_icmpne -16 -> 408
    //   427: aload_0
    //   428: getfield 42	ju:jdField_a_of_type_Js	Ljs;
    //   431: getfield 202	js:jdField_a_of_type_Jt	Ljt;
    //   434: astore_3
    //   435: aload_3
    //   436: getfield 205	jt:jdField_a_of_type_Kk	Lkk;
    //   439: invokevirtual 109	kk:a	()Z
    //   442: ifeq +38 -> 480
    //   445: aload_3
    //   446: getfield 205	jt:jdField_a_of_type_Kk	Lkk;
    //   449: astore_1
    //   450: new 172	java/lang/Integer
    //   453: astore 4
    //   455: aload 4
    //   457: aload_2
    //   458: invokevirtual 174	lc:c	()I
    //   461: invokespecial 175	java/lang/Integer:<init>	(I)V
    //   464: aload_1
    //   465: sipush 641
    //   468: iconst_1
    //   469: anewarray 4	java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: aload 4
    //   476: aastore
    //   477: invokevirtual 112	kk:a	(I[Ljava/lang/Object;)V
    //   480: aload_3
    //   481: getfield 208	jt:jdField_a_of_type_Jj	Ljj;
    //   484: aload_2
    //   485: invokestatic 211	jt:b	(Lli;)Ljava/lang/String;
    //   488: invokevirtual 214	jj:a	(Ljava/lang/String;)V
    //   491: aload_3
    //   492: getfield 217	jt:c	Ljava/util/Hashtable;
    //   495: astore_1
    //   496: new 172	java/lang/Integer
    //   499: astore_3
    //   500: aload_3
    //   501: aload_2
    //   502: invokevirtual 174	lc:c	()I
    //   505: invokespecial 175	java/lang/Integer:<init>	(I)V
    //   508: aload_1
    //   509: aload_3
    //   510: invokevirtual 223	java/util/Hashtable:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   513: pop
    //   514: new 225	kz
    //   517: astore_1
    //   518: aload_1
    //   519: aload_2
    //   520: invokespecial 226	kz:<init>	(Llc;)V
    //   523: aload_0
    //   524: getfield 42	ju:jdField_a_of_type_Js	Ljs;
    //   527: aload_1
    //   528: invokevirtual 199	js:a	(Lli;)Ljl;
    //   531: pop
    //   532: goto -124 -> 408
    //   535: astore_1
    //   536: aload_0
    //   537: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   540: sipush 714
    //   543: aconst_null
    //   544: aload_1
    //   545: invokevirtual 72	kk:a	(I[Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   548: aload_0
    //   549: getfield 42	ju:jdField_a_of_type_Js	Ljs;
    //   552: new 228	jm
    //   555: dup
    //   556: aload_1
    //   557: invokespecial 230	jm:<init>	(Ljava/lang/Throwable;)V
    //   560: invokevirtual 233	js:a	(Ljm;)V
    //   563: goto -155 -> 408
    //   566: aload_0
    //   567: getfield 49	ju:jdField_a_of_type_JavaUtilVector	Ljava/util/Vector;
    //   570: invokevirtual 152	java/util/Vector:clear	()V
    //   573: aload_0
    //   574: getfield 32	ju:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   577: astore_2
    //   578: aload_2
    //   579: monitorenter
    //   580: aload_0
    //   581: getfield 40	ju:jdField_a_of_type_Kk	Lkk;
    //   584: sipush 707
    //   587: invokevirtual 124	kk:a	(I)V
    //   590: aload_0
    //   591: getfield 32	ju:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   594: invokevirtual 115	java/lang/Object:notifyAll	()V
    //   597: aload_2
    //   598: monitorexit
    //   599: return
    //   600: astore_1
    //   601: aload_2
    //   602: monitorexit
    //   603: aload_1
    //   604: athrow
    //   605: aconst_null
    //   606: astore_1
    //   607: goto -337 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	this	ju
    //   183	7	1	localObject2	Object
    //   193	1	1	localInterruptedException	InterruptedException
    //   253	275	1	localObject3	Object
    //   535	22	1	localException	Exception
    //   600	4	1	localObject4	Object
    //   606	1	1	localObject5	Object
    //   188	4	2	localObject7	Object
    //   290	220	3	localObject9	Object
    //   294	181	4	localObject10	Object
    //   284	22	5	localkk	kk
    // Exception table:
    //   from	to	target	type
    //   161	180	183	finally
    //   14	51	188	finally
    //   51	53	188	finally
    //   7	14	193	java/lang/InterruptedException
    //   189	193	193	java/lang/InterruptedException
    //   249	254	535	java/lang/Exception
    //   258	270	535	java/lang/Exception
    //   270	326	535	java/lang/Exception
    //   326	377	535	java/lang/Exception
    //   377	408	535	java/lang/Exception
    //   416	480	535	java/lang/Exception
    //   480	532	535	java/lang/Exception
    //   580	599	600	finally
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */