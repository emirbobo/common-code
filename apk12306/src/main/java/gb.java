public abstract class gb
  extends fv
  implements fz
{
  int jdField_a_of_type_Int;
  fg jdField_a_of_type_Fg = null;
  boolean jdField_a_of_type_Boolean = true;
  
  public gb(boolean paramBoolean, int paramInt, fg paramfg)
  {
    if ((paramfg instanceof ff))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = paramInt;
      if (!this.jdField_a_of_type_Boolean) {
        break label52;
      }
    }
    for (this.jdField_a_of_type_Fg = paramfg;; this.jdField_a_of_type_Fg = paramfg)
    {
      return;
      this.jdField_a_of_type_Boolean = paramBoolean;
      break;
      label52:
      paramfg.b();
    }
  }
  
  public final fv a()
  {
    return b();
  }
  
  final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramfv instanceof gb)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramfv = (gb)paramfv;
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == paramfv.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_Boolean == paramfv.jdField_a_of_type_Boolean) {
          if (this.jdField_a_of_type_Fg == null)
          {
            bool1 = bool2;
            if (paramfv.jdField_a_of_type_Fg != null) {}
          }
          else
          {
            while (this.jdField_a_of_type_Fg.b().equals(paramfv.jdField_a_of_type_Fg.b()))
            {
              bool1 = true;
              break;
            }
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  final fv c()
  {
    return new hn(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_Fg);
  }
  
  final fv d()
  {
    return new hv(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, this.jdField_a_of_type_Fg);
  }
  
  public int hashCode()
  {
    int j = this.jdField_a_of_type_Int;
    int i = j;
    if (this.jdField_a_of_type_Fg != null) {
      i = j ^ this.jdField_a_of_type_Fg.hashCode();
    }
    return i;
  }
  
  public String toString()
  {
    return "[" + this.jdField_a_of_type_Int + "]" + this.jdField_a_of_type_Fg;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */