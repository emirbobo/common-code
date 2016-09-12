import java.io.IOException;

public class gy
  extends fv
{
  private byte[] a;
  
  gy(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  final int a()
  {
    int i = this.a.length;
    return i + (id.a(i) + 1);
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(24, this.a);
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof gy)) {}
    for (boolean bool = false;; bool = at.a(this.a, ((gy)paramfv).a)) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return at.a(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */