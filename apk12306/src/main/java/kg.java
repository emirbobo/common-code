public class kg
  extends Exception
{
  private Throwable a = null;
  
  public kg() {}
  
  public kg(Throwable paramThrowable)
  {
    this.a = paramThrowable;
  }
  
  public Throwable getCause()
  {
    return this.a;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\kg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */