import java.io.IOException;

public class gs
  extends fv
{
  private static fe jdField_a_of_type_Fe = new fe(false);
  private static final byte[] jdField_a_of_type_ArrayOfByte = { -1 };
  private static fe jdField_b_of_type_Fe = new fe(true);
  private static final byte[] jdField_b_of_type_ArrayOfByte = { 0 };
  private byte[] c;
  
  public gs(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;; arrayOfByte = jdField_b_of_type_ArrayOfByte)
    {
      this.c = arrayOfByte;
      return;
    }
  }
  
  gs(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 1) {
      throw new IllegalArgumentException("byte value should have 1 byte in it");
    }
    if (paramArrayOfByte[0] == 0) {
      this.c = jdField_b_of_type_ArrayOfByte;
    }
    for (;;)
    {
      return;
      if (paramArrayOfByte[0] == 255) {
        this.c = jdField_a_of_type_ArrayOfByte;
      } else {
        this.c = at.a(paramArrayOfByte);
      }
    }
  }
  
  static fe a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 1) {
      throw new IllegalArgumentException("byte value should have 1 byte in it");
    }
    if (paramArrayOfByte[0] == 0) {
      paramArrayOfByte = jdField_a_of_type_Fe;
    }
    for (;;)
    {
      return paramArrayOfByte;
      if (paramArrayOfByte[0] == 255) {
        paramArrayOfByte = jdField_b_of_type_Fe;
      } else {
        paramArrayOfByte = new fe(paramArrayOfByte);
      }
    }
  }
  
  final int a()
  {
    return 3;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(1, this.c);
  }
  
  final boolean a()
  {
    return false;
  }
  
  protected final boolean a(fv paramfv)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramfv != null)
    {
      if ((paramfv instanceof gs)) {
        break label19;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label19:
      bool1 = bool2;
      if (this.c[0] == ((gs)paramfv).c[0]) {
        bool1 = true;
      }
    }
  }
  
  public int hashCode()
  {
    return this.c[0];
  }
  
  public String toString()
  {
    if (this.c[0] != 0) {}
    for (String str = "TRUE";; str = "FALSE") {
      return str;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */