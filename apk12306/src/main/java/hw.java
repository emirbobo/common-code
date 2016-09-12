import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

final class hw
  extends ib
{
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private final int jdField_a_of_type_Int;
  private int b;
  
  hw(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream, paramInt);
    if (paramInt < 0) {
      throw new IllegalArgumentException("negative lengths not allowed");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramInt;
    if (paramInt == 0) {
      a();
    }
  }
  
  final int a()
  {
    return this.b;
  }
  
  final byte[] a()
    throws IOException
  {
    byte[] arrayOfByte;
    if (this.b == 0) {
      arrayOfByte = jdField_a_of_type_ArrayOfByte;
    }
    for (;;)
    {
      return arrayOfByte;
      arrayOfByte = new byte[this.b];
      int i = this.b - jd.a(this.jdField_a_of_type_JavaIoInputStream, arrayOfByte);
      this.b = i;
      if (i != 0) {
        throw new EOFException("DEF length " + this.jdField_a_of_type_Int + " object truncated by " + this.b);
      }
      a();
    }
  }
  
  public final int read()
    throws IOException
  {
    int i;
    if (this.b == 0) {
      i = -1;
    }
    for (;;)
    {
      return i;
      int j = this.jdField_a_of_type_JavaIoInputStream.read();
      if (j < 0) {
        throw new EOFException("DEF length " + this.jdField_a_of_type_Int + " object truncated by " + this.b);
      }
      int k = this.b - 1;
      this.b = k;
      i = j;
      if (k == 0)
      {
        a();
        i = j;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b == 0) {
      paramInt1 = -1;
    }
    for (;;)
    {
      return paramInt1;
      paramInt2 = Math.min(paramInt2, this.b);
      paramInt2 = this.jdField_a_of_type_JavaIoInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 < 0) {
        throw new EOFException("DEF length " + this.jdField_a_of_type_Int + " object truncated by " + this.b);
      }
      int i = this.b - paramInt2;
      this.b = i;
      paramInt1 = paramInt2;
      if (i == 0)
      {
        a();
        paramInt1 = paramInt2;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */