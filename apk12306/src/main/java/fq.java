import java.io.ByteArrayInputStream;
import java.io.InputStream;

public abstract class fq
  extends fv
  implements fr
{
  byte[] a;
  
  public fq(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("string cannot be null");
    }
    this.a = paramArrayOfByte;
  }
  
  public final fv a()
  {
    return b();
  }
  
  public final InputStream a()
  {
    return new ByteArrayInputStream(this.a);
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof fq)) {}
    for (boolean bool = false;; bool = at.a(this.a, paramfv.a))
    {
      return bool;
      paramfv = (fq)paramfv;
    }
  }
  
  public byte[] b()
  {
    return this.a;
  }
  
  final fv c()
  {
    return new he(this.a);
  }
  
  final fv d()
  {
    return new he(this.a);
  }
  
  public int hashCode()
  {
    return at.a(b());
  }
  
  public String toString()
  {
    return "#" + new String(jb.a(this.a));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */