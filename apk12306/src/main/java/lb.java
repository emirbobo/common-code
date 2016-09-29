import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class lb
  extends kv
{
  public lb(la paramla)
  {
    super((byte)6);
    a(paramla.c());
  }
  
  public lb(byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)6);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.b = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  protected final byte a()
  {
    return 2;
  }
  
  protected final byte[] b_()
    throws jm
  {
    return d();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\lb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */