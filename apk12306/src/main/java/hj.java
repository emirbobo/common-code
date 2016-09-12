import java.io.IOException;

public final class hj
  implements fx
{
  private ga a;
  
  hj(ga paramga)
  {
    this.a = paramga;
  }
  
  public final fv a()
    throws IOException
  {
    return new hi(this.a.a());
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */