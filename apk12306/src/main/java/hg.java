import java.io.IOException;
import java.io.OutputStream;

public final class hg
  extends fs
{
  public hg(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  final fs a()
  {
    return this;
  }
  
  public final void a(fg paramfg)
    throws IOException
  {
    if (paramfg != null)
    {
      paramfg.b().c().a(this);
      return;
    }
    throw new IOException("null object detected");
  }
  
  final fs b()
  {
    return this;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */