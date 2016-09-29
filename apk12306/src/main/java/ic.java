public final class ic
{
  int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  
  public ic(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = 0;
  }
  
  public final String a()
  {
    String str;
    if (this.jdField_a_of_type_Int == -1) {
      str = null;
    }
    for (;;)
    {
      return str;
      int i = this.jdField_a_of_type_JavaLangString.indexOf('.', this.jdField_a_of_type_Int);
      if (i == -1)
      {
        str = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = -1;
      }
      else
      {
        str = this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_Int, i);
        this.jdField_a_of_type_Int = (i + 1);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */