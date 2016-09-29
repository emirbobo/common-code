import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public final class le
  extends kp
{
  private int[] a;
  
  public le(byte[] paramArrayOfByte)
    throws IOException
  {
    super((byte)9);
    DataInputStream localDataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfByte));
    this.b = localDataInputStream.readUnsignedShort();
    int i = 0;
    this.a = new int[paramArrayOfByte.length - 2];
    for (int j = localDataInputStream.read(); j != -1; j = localDataInputStream.read())
    {
      this.a[i] = j;
      i++;
    }
    localDataInputStream.close();
  }
  
  protected final byte[] b_()
    throws jm
  {
    return new byte[0];
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\le.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */