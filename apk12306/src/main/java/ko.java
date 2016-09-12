import java.io.IOException;
import java.io.InputStream;

public final class ko
  extends InputStream
{
  private int jdField_a_of_type_Int;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  
  public ko(InputStream paramInputStream)
  {
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
    this.jdField_a_of_type_Int = 0;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final int read()
    throws IOException
  {
    int i = this.jdField_a_of_type_JavaIoInputStream.read();
    if (i != -1) {
      this.jdField_a_of_type_Int += 1;
    }
    return i;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ko.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */