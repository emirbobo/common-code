import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public final class gm
  extends gb
{
  public gm(boolean paramBoolean, int paramInt, fg paramfg)
  {
    super(paramBoolean, paramInt, paramfg);
  }
  
  final int a()
    throws IOException
  {
    int i = this.jdField_a_of_type_Fg.b().a();
    if (this.jdField_a_of_type_Boolean) {
      i += id.b(this.jdField_a_of_type_Int) + id.a(i);
    }
    for (;;)
    {
      return i;
      i = i - 1 + id.b(this.jdField_a_of_type_Int);
    }
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(160, this.jdField_a_of_type_Int);
    paramfs.b(128);
    if (!this.jdField_a_of_type_Boolean)
    {
      Enumeration localEnumeration;
      if ((this.jdField_a_of_type_Fg instanceof fq)) {
        if ((this.jdField_a_of_type_Fg instanceof gf)) {
          localEnumeration = ((gf)this.jdField_a_of_type_Fg).a();
        }
      }
      for (;;)
      {
        if (!localEnumeration.hasMoreElements()) {
          break label197;
        }
        paramfs.a((fg)localEnumeration.nextElement());
        continue;
        localEnumeration = new gf(((fq)this.jdField_a_of_type_Fg).b()).a();
        continue;
        if ((this.jdField_a_of_type_Fg instanceof fw))
        {
          localEnumeration = ((fw)this.jdField_a_of_type_Fg).a();
        }
        else
        {
          if (!(this.jdField_a_of_type_Fg instanceof fy)) {
            break;
          }
          localEnumeration = ((fy)this.jdField_a_of_type_Fg).a.elements();
        }
      }
      throw new RuntimeException("not implemented: " + this.jdField_a_of_type_Fg.getClass().getName());
    }
    paramfs.a(this.jdField_a_of_type_Fg);
    label197:
    paramfs.b(0);
    paramfs.b(0);
  }
  
  final boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = this.jdField_a_of_type_Fg.b().c().a()) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */