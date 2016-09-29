import java.io.IOException;

public class gt
  extends fv
{
  private static fi[] jdField_a_of_type_ArrayOfFi = new fi[12];
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public gt(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  static fi a(byte[] paramArrayOfByte)
  {
    Object localObject1;
    if (paramArrayOfByte.length > 1) {
      localObject1 = new fi(at.a(paramArrayOfByte));
    }
    for (;;)
    {
      return (fi)localObject1;
      if (paramArrayOfByte.length == 0) {
        throw new IllegalArgumentException("ENUMERATED has zero length");
      }
      int i = paramArrayOfByte[0] & 0xFF;
      if (i >= jdField_a_of_type_ArrayOfFi.length)
      {
        localObject1 = new fi(at.a(paramArrayOfByte));
      }
      else
      {
        Object localObject2 = jdField_a_of_type_ArrayOfFi[i];
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject2 = jdField_a_of_type_ArrayOfFi;
          localObject1 = new fi(at.a(paramArrayOfByte));
          localObject2[i] = localObject1;
        }
      }
    }
  }
  
  final int a()
  {
    return id.a(this.jdField_a_of_type_ArrayOfByte.length) + 1 + this.jdField_a_of_type_ArrayOfByte.length;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(10, this.jdField_a_of_type_ArrayOfByte);
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof gt)) {}
    for (boolean bool = false;; bool = at.a(this.jdField_a_of_type_ArrayOfByte, paramfv.jdField_a_of_type_ArrayOfByte))
    {
      return bool;
      paramfv = (gt)paramfv;
    }
  }
  
  public int hashCode()
  {
    return at.a(this.jdField_a_of_type_ArrayOfByte);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */