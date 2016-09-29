import java.io.IOException;
import java.io.InputStream;

final class go
  extends InputStream
{
  private final ga jdField_a_of_type_Ga;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private boolean jdField_a_of_type_Boolean = true;
  
  go(ga paramga)
  {
    this.jdField_a_of_type_Ga = paramga;
  }
  
  public final int read()
    throws IOException
  {
    int i;
    fr localfr;
    if (this.jdField_a_of_type_JavaIoInputStream == null)
    {
      if (!this.jdField_a_of_type_Boolean) {}
      for (i = -1;; i = -1)
      {
        return i;
        localfr = (fr)this.jdField_a_of_type_Ga.a();
        if (localfr != null) {
          break;
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
    for (this.jdField_a_of_type_JavaIoInputStream = localfr.a();; this.jdField_a_of_type_JavaIoInputStream = localfr.a())
    {
      int j = this.jdField_a_of_type_JavaIoInputStream.read();
      i = j;
      if (j >= 0) {
        break;
      }
      localfr = (fr)this.jdField_a_of_type_Ga.a();
      if (localfr == null)
      {
        this.jdField_a_of_type_JavaIoInputStream = null;
        i = -1;
        break;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_JavaIoInputStream == null) {
      if (!this.jdField_a_of_type_Boolean) {
        i = -1;
      }
    }
    fr localfr;
    label70:
    do
    {
      for (;;)
      {
        return i;
        localfr = (fr)this.jdField_a_of_type_Ga.a();
        if (localfr != null) {
          break;
        }
        i = -1;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_JavaIoInputStream = localfr.a();
      i = j;
      j = this.jdField_a_of_type_JavaIoInputStream.read(paramArrayOfByte, paramInt1 + i, paramInt2 - i);
      if (j < 0) {
        break;
      }
      j += i;
      i = j;
    } while (j == paramInt2);
    i = j;
    for (;;)
    {
      break label70;
      localfr = (fr)this.jdField_a_of_type_Ga.a();
      if (localfr == null)
      {
        this.jdField_a_of_type_JavaIoInputStream = null;
        if (i <= 0)
        {
          i = -1;
          break;
        }
        break;
      }
      this.jdField_a_of_type_JavaIoInputStream = localfr.a();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */