import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class lc
  extends kv
{
  public String a;
  public jn a;
  private byte[] a;
  
  public lc(byte paramByte, byte[] paramArrayOfByte)
    throws jm, IOException
  {
    super((byte)3);
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_Jn = new ld();
    this.jdField_a_of_type_Jn.a(paramByte >> 1 & 0x3);
    if ((paramByte & 0x1) == 1) {
      this.jdField_a_of_type_Jn.a(true);
    }
    if ((paramByte & 0x8) == 8) {
      ((ld)this.jdField_a_of_type_Jn).b(true);
    }
    ko localko = new ko(new ByteArrayInputStream(paramArrayOfByte));
    DataInputStream localDataInputStream = new DataInputStream(localko);
    this.jdField_a_of_type_JavaLangString = localDataInputStream.readUTF();
    if (this.jdField_a_of_type_Jn.jdField_a_of_type_Int > 0) {
      this.b = localDataInputStream.readUnsignedShort();
    }
    localDataInputStream.close();
    paramArrayOfByte = new byte[paramArrayOfByte.length - localko.a()];
    localDataInputStream.readFully(paramArrayOfByte);
    this.jdField_a_of_type_Jn.a(paramArrayOfByte);
  }
  
  public lc(String paramString, jn paramjn)
  {
    super((byte)3);
    this.jdField_a_of_type_ArrayOfByte = null;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Jn = paramjn;
  }
  
  protected final byte a()
  {
    byte b3 = (byte)(this.jdField_a_of_type_Jn.jdField_a_of_type_Int << 1);
    byte b2 = b3;
    if (this.jdField_a_of_type_Jn.jdField_a_of_type_Boolean) {
      b2 = (byte)(b3 | 0x1);
    }
    byte b1 = b2;
    if (this.jdField_a_of_type_Jn.b)
    {
      b2 = (byte)(b2 | 0x8);
      b1 = b2;
    }
    return b1;
  }
  
  public final void a(int paramInt)
  {
    super.a(paramInt);
    if ((this.jdField_a_of_type_Jn instanceof ld)) {
      jn localjn = this.jdField_a_of_type_Jn;
    }
  }
  
  public final boolean a()
  {
    return true;
  }
  
  public final int b()
  {
    int i = 0;
    try
    {
      int j = b().length;
      i = j;
    }
    catch (jm localjm)
    {
      for (;;) {}
    }
    return i;
  }
  
  public final byte[] b()
    throws jm
  {
    if (this.jdField_a_of_type_ArrayOfByte == null) {
      this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Jn.jdField_a_of_type_ArrayOfByte;
    }
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  protected final byte[] b_()
    throws jm
  {
    try
    {
      Object localObject = new java/io/ByteArrayOutputStream;
      ((ByteArrayOutputStream)localObject).<init>();
      DataOutputStream localDataOutputStream = new java/io/DataOutputStream;
      localDataOutputStream.<init>((OutputStream)localObject);
      localDataOutputStream.writeUTF(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Jn.jdField_a_of_type_Int > 0) {
        localDataOutputStream.writeShort(this.b);
      }
      localDataOutputStream.flush();
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      throw new jm(localIOException);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\lc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */