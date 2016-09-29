import java.io.IOException;

public class ho
  extends fv
{
  private byte[] a;
  
  ho(byte[] paramArrayOfByte)
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
    paramfs.b(23);
    int j = this.a.length;
    paramfs.a(j);
    for (int i = 0; i != j; i++) {
      paramfs.b(this.a[i]);
    }
  }
  
  final boolean a()
  {
    return false;
  }
  
  final boolean a(fv paramfv)
  {
    if (!(paramfv instanceof ho)) {}
    for (boolean bool = false;; bool = at.a(this.a, ((ho)paramfv).a)) {
      return bool;
    }
  }
  
  public int hashCode()
  {
    return at.a(this.a);
  }
  
  public String toString()
  {
    return at.a(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */