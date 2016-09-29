import java.io.IOException;
import java.math.BigInteger;

public class ha
  extends fv
{
  private byte[] a;
  
  public ha(BigInteger paramBigInteger)
  {
    this.a = paramBigInteger.toByteArray();
  }
  
  public ha(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  final int a()
  {
    return id.a(this.a.length) + 1 + this.a.length;
  }
  
  public final BigInteger a()
  {
    return new BigInteger(this.a);
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(2, this.a);
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof ha)) {}
    for (boolean bool = false;; bool = at.a(this.a, paramfv.a))
    {
      return bool;
      paramfv = (ha)paramfv;
    }
  }
  
  public int hashCode()
  {
    int i = 0;
    int j = 0;
    while (i != this.a.length)
    {
      j ^= (this.a[i] & 0xFF) << i % 4;
      i++;
    }
    return j;
  }
  
  public String toString()
  {
    return a().toString();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ha.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */