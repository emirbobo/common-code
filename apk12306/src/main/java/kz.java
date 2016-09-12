import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class kz
  extends kp
{
  public kz(int paramInt)
  {
    super((byte)7);
    this.b = paramInt;
  }
  
  public kz(lc paramlc)
  {
    super((byte)7);
    this.b = paramlc.c();
  }
  
  public kz(byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)7);
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */