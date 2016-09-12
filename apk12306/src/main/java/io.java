public final class io
  extends ip
{
  private Throwable a;
  
  public io(String paramString)
  {
    super(paramString);
  }
  
  public io(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.a = paramThrowable;
  }
  
  public final Throwable getCause()
  {
    return this.a;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\io.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */