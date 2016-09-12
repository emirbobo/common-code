import java.io.IOException;

public final class fd
  implements fg, hx
{
  private int jdField_a_of_type_Int;
  private ga jdField_a_of_type_Ga;
  
  fd(int paramInt, ga paramga)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Ga = paramga;
  }
  
  public final fv a()
    throws IOException
  {
    return new gd(this.jdField_a_of_type_Int, this.jdField_a_of_type_Ga.a());
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
      throw new fu(localIOException.getMessage(), localIOException);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */