import java.util.Hashtable;

public final class jx
{
  Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private jl jdField_a_of_type_Jl;
  jm jdField_a_of_type_Jm = null;
  kk jdField_a_of_type_Kk;
  boolean jdField_a_of_type_Boolean = false;
  private jl b;
  private jl c;
  
  public jx(kk paramkk)
  {
    this.jdField_a_of_type_Kk = paramkk;
    this.jdField_a_of_type_Jl = new jl(paramkk);
    this.b = new jl(paramkk);
    this.c = new jl(paramkk);
  }
  
  public final jl a(li paramli)
  {
    if ((paramli instanceof kp))
    {
      paramli = b((kp)paramli);
      return paramli;
    }
    if ((paramli instanceof kw)) {
      paramli = this.jdField_a_of_type_Jl;
    }
    for (;;)
    {
      paramli = (jl)this.jdField_a_of_type_JavaUtilHashtable.get(paramli);
      break;
      if ((paramli instanceof kr)) {
        paramli = this.b;
      } else if ((paramli instanceof ks)) {
        paramli = this.c;
      } else {
        paramli = new Integer(paramli.c());
      }
    }
  }
  
  final jl b(li paramli)
  {
    if ((paramli instanceof kx)) {
      paramli = this.jdField_a_of_type_Jl;
    }
    for (;;)
    {
      return paramli;
      if ((paramli instanceof kq)) {
        paramli = this.b;
      } else {
        paramli = (jl)this.jdField_a_of_type_JavaUtilHashtable.get(new Integer(paramli.c()));
      }
    }
  }
  
  public final jl c(li paramli)
  {
    Object localObject;
    if ((paramli instanceof kq)) {
      localObject = this.b;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Kk.a()) {
        this.jdField_a_of_type_Kk.a(301, new Object[] { paramli, localObject });
      }
      return (jl)this.jdField_a_of_type_JavaUtilHashtable.remove(localObject);
      if ((paramli instanceof ks)) {
        localObject = this.c;
      } else {
        localObject = new Integer(paramli.c());
      }
    }
  }
  
  protected final jl d(li paramli)
  {
    jl localjl;
    Object localObject;
    if ((paramli instanceof kw))
    {
      localjl = this.jdField_a_of_type_Jl;
      localObject = localjl;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Kk.a()) {
        this.jdField_a_of_type_Kk.a(300, new Object[] { paramli, localObject, localjl.toString() });
      }
      this.jdField_a_of_type_JavaUtilHashtable.put(localObject, localjl);
      if (this.jdField_a_of_type_Boolean) {
        localjl.a(this.jdField_a_of_type_Jm);
      }
      return localjl;
      if ((paramli instanceof kr))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_Jm = null;
        this.b = new jl(this.jdField_a_of_type_Kk);
        localjl = this.b;
        localObject = localjl;
      }
      else if ((paramli instanceof ks))
      {
        this.c = new jl(this.jdField_a_of_type_Kk);
        localjl = this.c;
        localObject = localjl;
      }
      else if ((paramli instanceof lb))
      {
        localObject = new Integer(paramli.c());
        localjl = a(paramli);
      }
      else if ((paramli instanceof lc))
      {
        localObject = new Integer(paramli.c());
        localjl = new jl(this.jdField_a_of_type_Kk, (lc)paramli);
      }
      else
      {
        localObject = new Integer(paramli.c());
        localjl = new jl(this.jdField_a_of_type_Kk);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */