import java.io.IOException;

public final class gn
  implements fz
{
  private int jdField_a_of_type_Int;
  private ga jdField_a_of_type_Ga;
  private boolean jdField_a_of_type_Boolean;
  
  gn(boolean paramBoolean, int paramInt, ga paramga)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ga = paramga;
  }
  
  public final fv a()
    throws IOException
  {
    return this.jdField_a_of_type_Ga.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int);
  }
  
  public final fv b()
  {
    try
    {
      fv localfv = a();
      return localfv;
    }
    catch (IOException localIOException)
    {
      throw new fu(localIOException.getMessage());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */