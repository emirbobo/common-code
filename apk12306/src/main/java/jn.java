public class jn
{
  public int a;
  public boolean a;
  public byte[] a;
  public boolean b = false;
  private boolean c = true;
  
  public jn()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    a(new byte[0]);
  }
  
  public jn(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Boolean = false;
    a(paramArrayOfByte);
  }
  
  private void a()
    throws IllegalStateException
  {
    if (!this.c) {
      throw new IllegalStateException();
    }
  }
  
  public final void a(int paramInt)
  {
    a();
    if ((paramInt < 0) || (paramInt > 2)) {
      throw new IllegalArgumentException();
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void a(boolean paramBoolean)
  {
    a();
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    a();
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public String toString()
  {
    return new String(this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */