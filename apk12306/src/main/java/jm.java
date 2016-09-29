public class jm
  extends Exception
{
  private int jdField_a_of_type_Int;
  private Throwable jdField_a_of_type_JavaLangThrowable;
  
  public jm(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public jm(Throwable paramThrowable)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public jm(Throwable paramThrowable, byte paramByte)
  {
    this.jdField_a_of_type_Int = 32109;
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Throwable getCause()
  {
    return this.jdField_a_of_type_JavaLangThrowable;
  }
  
  public String getMessage()
  {
    return ka.a(this.jdField_a_of_type_Int);
  }
  
  public String toString()
  {
    String str2 = getMessage() + " (" + this.jdField_a_of_type_Int + ")";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaLangThrowable != null) {
      str1 = str2 + " - " + this.jdField_a_of_type_JavaLangThrowable.toString();
    }
    return str1;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */