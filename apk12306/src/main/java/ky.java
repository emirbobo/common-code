import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class ky
  extends kp
{
  public ky(lc paramlc)
  {
    super((byte)4);
    this.b = paramlc.c();
  }
  
  public ky(byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)4);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.b = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  protected final byte[] b_()
    throws jm
  {
    return d();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ky.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */