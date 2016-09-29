import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public final class gr
  extends fv
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private int jdField_a_of_type_Int;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  private gr(byte[] paramArrayOfByte, int paramInt)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  static gr a(int paramInt, InputStream paramInputStream)
    throws IOException
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("truncated BIT STRING detected");
    }
    int i = paramInputStream.read();
    byte[] arrayOfByte = new byte[paramInt - 1];
    if ((arrayOfByte.length != 0) && (jd.a(paramInputStream, arrayOfByte) != arrayOfByte.length)) {
      throw new EOFException("EOF encountered in middle of BIT STRING");
    }
    return new gr(arrayOfByte, i);
  }
  
  private String a()
  {
    StringBuffer localStringBuffer = new StringBuffer("#");
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Object localObject = new fs(localByteArrayOutputStream);
    try
    {
      ((fs)localObject).a(this);
      localObject = localByteArrayOutputStream.toByteArray();
      for (int i = 0; i != localObject.length; i++)
      {
        localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(localObject[i] >>> 4 & 0xF)]);
        localStringBuffer.append(jdField_a_of_type_ArrayOfChar[(localObject[i] & 0xF)]);
      }
      return localIOException.toString();
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException("internal error encoding BitString");
    }
  }
  
  final int a()
  {
    return id.a(this.jdField_a_of_type_ArrayOfByte.length + 1) + 1 + this.jdField_a_of_type_ArrayOfByte.length + 1;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    byte[] arrayOfByte = new byte[this.jdField_a_of_type_ArrayOfByte.length + 1];
    arrayOfByte[0] = ((byte)(byte)this.jdField_a_of_type_Int);
    System.arraycopy(this.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 1, arrayOfByte.length - 1);
    paramfs.a(3, arrayOfByte);
  }
  
  final boolean a()
  {
    return false;
  }
  
  protected final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramfv instanceof gr)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramfv = (gr)paramfv;
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == paramfv.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (at.a(this.jdField_a_of_type_ArrayOfByte, paramfv.jdField_a_of_type_ArrayOfByte)) {
          bool1 = true;
        }
      }
    }
  }
  
  public final int hashCode()
  {
    return this.jdField_a_of_type_Int ^ at.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public final String toString()
  {
    return a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */