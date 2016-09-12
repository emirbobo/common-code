import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class lg
  extends kp
{
  public lg(byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)11);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.b = paramArrayOfByte.readUnsignedShort();
    paramArrayOfByte.close();
  }
  
  protected final byte[] b_()
    throws jm
  {
    return new byte[0];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\lg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */