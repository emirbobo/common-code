import java.io.IOException;

public final class fj
  extends IOException
{
  private Throwable a;
  
  fj(String paramString)
  {
    super(paramString);
  }
  
  fj(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.a = paramThrowable;
  }
  
  public final Throwable getCause()
  {
    return this.a;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\fj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */