import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Vector;

public class gp
  extends fv
{
  private final int jdField_a_of_type_Int;
  private final boolean jdField_a_of_type_Boolean;
  private final byte[] jdField_a_of_type_ArrayOfByte;
  
  public gp(int paramInt, fh paramfh)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramInt = 0;
    while (paramInt != paramfh.a.size()) {
      try
      {
        localByteArrayOutputStream.write(((fo)paramfh.a(paramInt)).a("DER"));
        paramInt++;
      }
      catch (IOException paramfh)
      {
        throw new fu("malformed object: " + paramfh, paramfh);
      }
    }
    this.jdField_a_of_type_ArrayOfByte = localByteArrayOutputStream.toByteArray();
  }
  
  gp(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  final int a()
    throws IOException
  {
    return id.b(this.jdField_a_of_type_Int) + id.a(this.jdField_a_of_type_ArrayOfByte.length) + this.jdField_a_of_type_ArrayOfByte.length;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    int i = 64;
    if (this.jdField_a_of_type_Boolean) {
      i = 96;
    }
    paramfs.a(i, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!(paramfv instanceof gp)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      paramfv = (gp)paramfv;
      bool1 = bool2;
      if (this.jdField_a_of_type_Boolean == paramfv.jdField_a_of_type_Boolean)
      {
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
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0) {
      return i ^ this.jdField_a_of_type_Int ^ at.a(this.jdField_a_of_type_ArrayOfByte);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */