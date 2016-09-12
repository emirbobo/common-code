import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class lf
  extends li
{
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public lf(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super((byte)8);
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
  }
  
  protected final byte a()
  {
    return 2;
  }
  
  public final byte[] b()
    throws jm
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      for (int i = 0; i < this.jdField_a_of_type_ArrayOfJavaLangString.length; i++)
      {
        localDataOutputStream.writeUTF(this.jdField_a_of_type_ArrayOfJavaLangString[i]);
        localDataOutputStream.writeByte(this.jdField_a_of_type_ArrayOfInt[i]);
      }
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new jm(localIOException);
    }
  }
  
  protected final byte[] b_()
    throws jm
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new java/io/DataOutputStream;
      ((DataOutputStream)localObject).<init>(localByteArrayOutputStream);
      ((DataOutputStream)localObject).writeShort(this.b);
      ((DataOutputStream)localObject).flush();
      localObject = localByteArrayOutputStream.toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new jm(localIOException);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\lf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */