import java.io.IOException;
import java.util.Enumeration;

public final class gi
  extends fw
{
  public gi() {}
  
  public gi(fh paramfh)
  {
    super(paramfh);
  }
  
  final int a()
    throws IOException
  {
    Enumeration localEnumeration = a();
    for (int i = 0; localEnumeration.hasMoreElements(); i = ((fg)localEnumeration.nextElement()).b().a() + i) {}
    return i + 2 + 2;
  }
  
  final void a(fs paramfs)
    throws IOException
  {
    paramfs.b(48);
    paramfs.b(128);
    Enumeration localEnumeration = a();
    while (localEnumeration.hasMoreElements()) {
      paramfs.a((fg)localEnumeration.nextElement());
    }
    paramfs.b(0);
    paramfs.b(0);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */