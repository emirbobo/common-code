import java.io.IOException;
import java.io.OutputStream;

public final class hs
  extends fs
{
  public hs(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public final void a(fg paramfg)
    throws IOException
  {
    if (paramfg != null)
    {
      paramfg.b().d().a(this);
      return;
    }
    throw new IOException("null object detected");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */