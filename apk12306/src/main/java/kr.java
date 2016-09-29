import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class kr
  extends li
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public kr(String paramString1, boolean paramBoolean, int paramInt, String paramString2)
  {
    super((byte)1);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString2;
  }
  
  protected final byte a()
  {
    return 0;
  }
  
  public final boolean a()
  {
    return false;
  }
  
  public final byte[] b()
    throws jm
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>();
      Object localObject = new java/io/DataOutputStream;
      ((DataOutputStream)localObject).<init>(localByteArrayOutputStream);
      ((DataOutputStream)localObject).writeUTF(this.jdField_a_of_type_JavaLangString);
      if (this.b != null) {
        ((DataOutputStream)localObject).writeUTF(this.b);
      }
      ((DataOutputStream)localObject).flush();
      localObject = localByteArrayOutputStream.toByteArray();
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
      ((DataOutputStream)localObject).writeUTF("MQIsdp");
      ((DataOutputStream)localObject).write(3);
      int i = 0;
      if (this.jdField_a_of_type_Boolean) {
        i = 2;
      }
      int j = i;
      if (this.b != null) {
        j = (byte)(i | 0x80);
      }
      ((DataOutputStream)localObject).write(j);
      ((DataOutputStream)localObject).writeShort(this.jdField_a_of_type_Int);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */