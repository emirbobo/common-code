import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class hq
  extends fv
{
  private static final char[] jdField_a_of_type_ArrayOfChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public hq(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
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
    return id.a(this.jdField_a_of_type_ArrayOfByte.length) + 1 + this.jdField_a_of_type_ArrayOfByte.length;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(28, this.jdField_a_of_type_ArrayOfByte);
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof hq)) {}
    for (boolean bool = false;; bool = at.a(this.jdField_a_of_type_ArrayOfByte, ((hq)paramfv).jdField_a_of_type_ArrayOfByte)) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    return at.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public final String toString()
  {
    return a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */