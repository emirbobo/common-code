import java.io.IOException;

public final class gv
  implements fg, hx
{
  private ga a;
  
  public gv(ga paramga)
  {
    this.a = paramga;
  }
  
  public final fv a()
    throws IOException
  {
    try
    {
      gu localgu = new gu(this.a.a());
      return localgu;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new fj(localIllegalArgumentException.getMessage(), localIllegalArgumentException);
    }
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
      throw new fu("unable to get DER object", localIOException);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new fu("unable to get DER object", localIllegalArgumentException);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\gv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */