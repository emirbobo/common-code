import java.io.IOException;
import java.io.InputStream;

public final class lj
  extends InputStream
{
  private int jdField_a_of_type_Int;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int c = 0;
  
  public lj(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public final int read()
    throws IOException
  {
    int j;
    int i;
    if (this.c < this.jdField_a_of_type_Int)
    {
      j = this.jdField_a_of_type_ArrayOfByte[(this.c + 0)];
      i = j;
      if (j < 0) {
        i = j + 256;
      }
      this.c += 1;
    }
    for (;;)
    {
      return i;
      if (this.c < this.jdField_a_of_type_Int + this.jdField_b_of_type_Int)
      {
        j = this.jdField_b_of_type_ArrayOfByte[(this.c + 0 - this.jdField_a_of_type_Int)];
        break;
      }
      i = -1;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\lj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */