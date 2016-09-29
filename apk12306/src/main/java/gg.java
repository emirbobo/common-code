import java.util.Enumeration;

final class gg
  implements Enumeration
{
  private int jdField_a_of_type_Int = 0;
  
  gg(gf paramgf) {}
  
  public final boolean hasMoreElements()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_Gf.a.length) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final Object nextElement()
  {
    fq[] arrayOffq = this.jdField_a_of_type_Gf.a;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    return arrayOffq[i];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */