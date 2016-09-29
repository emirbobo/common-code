import java.io.IOException;

public final class hl
  implements fz
{
  private ga a;
  
  hl(ga paramga)
  {
    this.a = paramga;
  }
  
  public final fv a()
    throws IOException
  {
    return new hk(this.a.a());
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
      throw new fu(localIOException.getMessage(), localIOException);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */