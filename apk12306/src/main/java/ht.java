import java.io.IOException;
import java.util.Enumeration;

public final class ht
  extends fw
{
  private int a = -1;
  
  public ht() {}
  
  public ht(fh paramfh)
  {
    super(paramfh);
  }
  
  private int c()
    throws IOException
  {
    if (this.a < 0)
    {
      Enumeration localEnumeration = a();
      for (int i = 0; localEnumeration.hasMoreElements(); i = ((fg)localEnumeration.nextElement()).b().d().a() + i) {}
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
    fs localfs = paramfs.b();
    int i = c();
    paramfs.b(48);
    paramfs.a(i);
    paramfs = a();
    while (paramfs.hasMoreElements()) {
      localfs.a((fg)paramfs.nextElement());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */