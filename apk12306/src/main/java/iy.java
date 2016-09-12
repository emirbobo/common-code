public final class iy
  extends IllegalStateException
{
  private Throwable a;
  
  iy(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.a = paramThrowable;
  }
  
  public final Throwable getCause()
  {
    return this.a;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */