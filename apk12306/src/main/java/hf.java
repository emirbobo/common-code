import java.io.IOException;
import java.io.InputStream;

public final class hf
  implements fr
{
  private hw a;
  
  hf(hw paramhw)
  {
    this.a = paramhw;
  }
  
  public final fv a()
    throws IOException
  {
    return new he(this.a.a());
  }
  
  public final InputStream a()
  {
    return this.a;
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\hf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */