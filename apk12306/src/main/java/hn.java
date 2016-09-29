import java.io.IOException;

public final class hn
  extends gb
{
  public hn(boolean paramBoolean, int paramInt, fg paramfg)
  {
    super(paramBoolean, paramInt, paramfg);
  }
  
  final int a()
    throws IOException
  {
    int i = this.jdField_a_of_type_Fg.b().c().a();
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
    int i = 160;
    fv localfv = this.jdField_a_of_type_Fg.b().c();
    if (this.jdField_a_of_type_Boolean)
    {
      paramfs.a(160, this.jdField_a_of_type_Int);
      paramfs.a(localfv.a());
      paramfs.a(localfv);
      return;
    }
    if (localfv.a()) {}
    for (;;)
    {
      paramfs.a(i, this.jdField_a_of_type_Int);
      paramfs.a(localfv);
      break;
      i = 128;
    }
  }
  
  final boolean a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (boolean bool = true;; bool = this.jdField_a_of_type_Fg.b().c().a()) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */