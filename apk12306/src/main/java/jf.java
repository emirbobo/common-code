import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class jf
{
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  static
  {
    Collections.unmodifiableList(new ArrayList());
  }
  
  public jf(String paramString, List paramList, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilList = Collections.unmodifiableList(paramList);
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public final byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */