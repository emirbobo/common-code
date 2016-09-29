public final class kk
{
  private static kl jdField_a_of_type_Kl;
  private static short jdField_a_of_type_Short = (short)0;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private short b;
  
  private kk(short paramShort, String paramString)
  {
    this.b = ((short)paramShort);
    this.jdField_a_of_type_JavaLangString = paramString;
    if ((jdField_a_of_type_Kl != null) && (jdField_a_of_type_Kl.a(this.jdField_a_of_type_JavaLangString))) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  /* Error */
  public static kk a(String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 25	kk:jdField_a_of_type_Kl	Lkl;
    //   6: ifnonnull +27 -> 33
    //   9: ldc 37
    //   11: invokestatic 41	at:b	(Ljava/lang/String;)Z
    //   14: istore_1
    //   15: iload_1
    //   16: ifeq +17 -> 33
    //   19: ldc 43
    //   21: invokestatic 49	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   24: invokevirtual 53	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   27: checkcast 27	kl
    //   30: putstatic 25	kk:jdField_a_of_type_Kl	Lkl;
    //   33: new 2	kk
    //   36: astore_2
    //   37: aload_2
    //   38: getstatic 14	kk:jdField_a_of_type_Short	S
    //   41: aload_0
    //   42: invokespecial 55	kk:<init>	(SLjava/lang/String;)V
    //   45: getstatic 14	kk:jdField_a_of_type_Short	S
    //   48: iconst_1
    //   49: iadd
    //   50: i2s
    //   51: i2s
    //   52: putstatic 14	kk:jdField_a_of_type_Short	S
    //   55: ldc 2
    //   57: monitorexit
    //   58: aload_2
    //   59: areturn
    //   60: astore_0
    //   61: ldc 2
    //   63: monitorexit
    //   64: aload_0
    //   65: athrow
    //   66: astore_2
    //   67: goto -34 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramString	String
    //   14	2	1	bool	boolean
    //   36	23	2	localkk	kk
    //   66	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   3	15	60	finally
    //   19	33	60	finally
    //   33	55	60	finally
    //   19	33	66	java/lang/Exception
  }
  
  public final void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      jdField_a_of_type_Kl.a(new kn(this.b, paramInt, null, null));
    }
  }
  
  public final void a(int paramInt, Object[] paramArrayOfObject)
  {
    if (this.jdField_a_of_type_Boolean) {
      jdField_a_of_type_Kl.a(new kn(this.b, paramInt, null, paramArrayOfObject));
    }
  }
  
  public final void a(int paramInt, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    if (this.jdField_a_of_type_Boolean) {
      jdField_a_of_type_Kl.a(new kn(this.b, paramInt, paramThrowable, paramArrayOfObject));
    }
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */