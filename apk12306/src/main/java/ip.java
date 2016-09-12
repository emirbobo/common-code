import java.io.IOException;

public class ip
  extends IOException
{
  private Exception a;
  
  public ip(String paramString)
  {
    super(paramString);
  }
  
  public ip(String paramString, Exception paramException)
  {
    super(paramString);
    this.a = paramException;
  }
  
  public Throwable getCause()
  {
    return this.a;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\ip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */