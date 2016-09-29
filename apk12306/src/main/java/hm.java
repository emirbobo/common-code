import java.io.IOException;

public final class hm
  extends fv
{
  private byte[] a;
  
  public hm(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
  }
  
  final int a()
  {
    return id.a(this.a.length) + 1 + this.a.length;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.a(20, this.a);
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof hm)) {}
    for (boolean bool = false;; bool = at.a(this.a, ((hm)paramfv).a)) {
      return bool;
    }
  }
  
  public final int hashCode()
  {
    return at.a(this.a);
  }
  
  public final String toString()
  {
    return at.a(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */