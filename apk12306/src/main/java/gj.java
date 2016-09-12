import java.io.IOException;

public final class gj
  implements fx
{
  private ga a;
  
  gj(ga paramga)
  {
    this.a = paramga;
  }
  
  public final fv a()
    throws IOException
  {
    return new gi(this.a.a());
  }
  
  public final fv b()
  {
    try
    {
      fv localfv = a();
      return localfv;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException.getMessage());
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */