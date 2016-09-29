import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class hy
  extends ib
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = true;
  
  hy(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    super(paramInputStream, paramInt);
    this.jdField_a_of_type_Int = paramInputStream.read();
    this.jdField_b_of_type_Int = paramInputStream.read();
    if (this.jdField_b_of_type_Int < 0) {
      throw new EOFException();
    }
    a();
  }
  
  private boolean a()
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      a();
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  final void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    a();
  }
  
  public final int read()
    throws IOException
  {
    int i;
    if (a()) {
      i = -1;
    }
    for (;;)
    {
      return i;
      int j = this.jdField_a_of_type_JavaIoInputStream.read();
      if (j < 0) {
        throw new EOFException();
      }
      i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = j;
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((this.jdField_b_of_type_Boolean) || (paramInt2 < 3)) {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return paramInt1;
      if (this.jdField_a_of_type_Boolean)
      {
        paramInt1 = -1;
      }
      else
      {
        paramInt2 = this.jdField_a_of_type_JavaIoInputStream.read(paramArrayOfByte, paramInt1 + 2, paramInt2 - 2);
        if (paramInt2 < 0) {
          throw new EOFException();
        }
        paramArrayOfByte[paramInt1] = ((byte)(byte)this.jdField_a_of_type_Int);
        paramArrayOfByte[(paramInt1 + 1)] = ((byte)(byte)this.jdField_b_of_type_Int);
        this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaIoInputStream.read();
        this.jdField_b_of_type_Int = this.jdField_a_of_type_JavaIoInputStream.read();
        if (this.jdField_b_of_type_Int < 0) {
          throw new EOFException();
        }
        paramInt1 = paramInt2 + 2;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */