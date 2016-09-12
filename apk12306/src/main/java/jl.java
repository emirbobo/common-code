public final class jl
{
  public Object a;
  private jm a;
  public kk a;
  public li a;
  public boolean a;
  public Object b;
  public boolean b;
  
  public jl(kk paramkk)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Li = null;
    this.jdField_a_of_type_Jm = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Kk = paramkk;
  }
  
  public jl(kk paramkk, lc paramlc)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_Li = null;
    this.jdField_a_of_type_Jm = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Kk = paramkk;
    paramkk = paramlc.a;
    paramlc.c();
  }
  
  public final li a(long paramLong)
    throws jm
  {
    for (;;)
    {
      Object localObject1;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Kk.a())
        {
          kk localkk = this.jdField_a_of_type_Kk;
          Long localLong = new java/lang/Long;
          localLong.<init>(paramLong);
          Boolean localBoolean1 = new java/lang/Boolean;
          localBoolean1.<init>(this.jdField_a_of_type_Boolean);
          Boolean localBoolean2 = new java/lang/Boolean;
          localBoolean2.<init>(this.jdField_b_of_type_Boolean);
          if (this.jdField_a_of_type_Jm == null)
          {
            localObject1 = "false";
            li localli2 = this.jdField_a_of_type_Li;
            jm localjm = this.jdField_a_of_type_Jm;
            localkk.a(400, new Object[] { this, localLong, localBoolean1, localBoolean2, localObject1, localli2 }, localjm);
          }
        }
        else
        {
          if (!this.jdField_b_of_type_Boolean) {
            continue;
          }
          localObject1 = this.jdField_a_of_type_Li;
          return (li)localObject1;
        }
        localObject1 = "true";
        continue;
        localObject1 = this.jdField_a_of_type_Jm;
        if (localObject1 == null) {
          if (paramLong != -1L) {
            break label223;
          }
        }
      }
      try
      {
        this.jdField_a_of_type_JavaLangObject.wait();
        while ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Jm != null))
        {
          localObject1 = this.jdField_a_of_type_Jm;
          this.jdField_a_of_type_Jm = null;
          this.jdField_a_of_type_Kk.a(401, null, this.jdField_a_of_type_Jm);
          throw ((Throwable)localObject1);
          localObject2 = finally;
          throw ((Throwable)localObject2);
          label223:
          this.jdField_a_of_type_JavaLangObject.wait(paramLong);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;) {}
        this.jdField_a_of_type_Kk.a(402, new Object[] { this.jdField_a_of_type_Li });
        li localli1 = this.jdField_a_of_type_Li;
      }
    }
  }
  
  public final void a()
    throws jm
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Jm != null) {
          throw this.jdField_a_of_type_Jm;
        }
      }
    }
    boolean bool = this.jdField_a_of_type_Boolean;
    if (!bool) {}
    try
    {
      this.jdField_b_of_type_JavaLangObject.wait();
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_Jm == null) {
          throw at.a(6);
        }
        throw this.jdField_a_of_type_Jm;
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
  }
  
  public final void a(long paramLong)
    throws jm
  {
    if ((a(paramLong) == null) && (!this.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Kk.a()) {
        this.jdField_a_of_type_Kk.a(406, new Object[] { new Long(paramLong) });
      }
      throw new jm(32000);
    }
  }
  
  public final void a(jm arg1)
  {
    this.jdField_a_of_type_Kk.a(405, new Object[] { this }, ???);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Jm = ???;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
    }
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaLangObject.notifyAll();
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public final void a(li paramli)
  {
    this.jdField_a_of_type_Kk.a(404, new Object[] { this, paramli });
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_Li = paramli;
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */