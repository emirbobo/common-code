import java.io.IOException;
import java.io.InputStream;

public final class gh
  implements fr
{
  private ga a;
  
  gh(ga paramga)
  {
    this.a = paramga;
  }
  
  public final fv a()
    throws IOException
  {
    return new gf(jd.a(a()));
  }
  
  public final InputStream a()
  {
    return new go(this.a);
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
      throw new fu("IOException converting stream to byte array: " + localIOException.getMessage(), localIOException);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */