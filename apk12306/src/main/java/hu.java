import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public final class hu
  extends fy
{
  private int a = -1;
  
  public hu() {}
  
  public hu(fh paramfh)
  {
    super(paramfh);
  }
  
  private int b()
    throws IOException
  {
    if (this.a < 0)
    {
      Enumeration localEnumeration = this.a.elements();
      for (int i = 0; localEnumeration.hasMoreElements(); i = ((fg)localEnumeration.nextElement()).b().d().a() + i) {}
      this.a = i;
    }
    return this.a;
  }
  
  final int a()
    throws IOException
  {
    int i = b();
    return i + (id.a(i) + 1);
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    fs localfs = paramfs.b();
    int i = b();
    paramfs.b(49);
    paramfs.a(i);
    paramfs = this.a.elements();
    while (paramfs.hasMoreElements()) {
      localfs.a((fg)paramfs.nextElement());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */