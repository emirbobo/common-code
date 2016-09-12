import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class kq
  extends kp
{
  public int a;
  
  public kq(byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)2);
    paramArrayOfByte = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    paramArrayOfByte.readByte();
    this.a = paramArrayOfByte.readUnsignedByte();
    paramArrayOfByte.close();
  }
  
  public final boolean a()
  {
    return false;
  }
  
  protected final byte[] b_()
    throws jm
  {
    return new byte[0];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */