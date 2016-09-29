import java.io.IOException;
import java.util.Enumeration;

public final class hi
  extends fw
{
  private int a = -1;
  
  public hi() {}
  
  public hi(fh paramfh)
  {
    super(paramfh);
  }
  
  private int c()
    throws IOException
  {
    if (this.a < 0)
    {
      Enumeration localEnumeration = a();
      for (int i = 0; localEnumeration.hasMoreElements(); i = ((fg)localEnumeration.nextElement()).b().c().a() + i) {}
      this.a = i;
    }
    return this.a;
  }
  
  final int a()
    throws IOException
  {
    int i = c();
    return i + (id.a(i) + 1);
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    fs localfs = paramfs.a();
    int i = c();
    paramfs.b(48);
    paramfs.a(i);
    paramfs = a();
    while (paramfs.hasMoreElements()) {
      localfs.a((fg)paramfs.nextElement());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */