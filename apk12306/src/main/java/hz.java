import java.io.IOException;
import java.util.Enumeration;

final class hz
  implements Enumeration
{
  private fl jdField_a_of_type_Fl;
  private Object jdField_a_of_type_JavaLangObject;
  
  public hz(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Fl = new fl(paramArrayOfByte, (byte)0);
    this.jdField_a_of_type_JavaLangObject = a();
  }
  
  private Object a()
  {
    try
    {
      fv localfv = this.jdField_a_of_type_Fl.a();
      return localfv;
    }
    catch (IOException localIOException)
    {
      throw new fu("malformed DER construction: " + localIOException, localIOException);
    }
  }
  
  public final boolean hasMoreElements()
  {
    if (this.jdField_a_of_type_JavaLangObject != null) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final Object nextElement()
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    this.jdField_a_of_type_JavaLangObject = a();
    return localObject;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */