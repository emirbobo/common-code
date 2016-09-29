package com.lidroid.xutils.exception;

public class BaseException
  extends Exception
{
  private static final long serialVersionUID = 1L;
  
  public BaseException() {}
  
  public BaseException(String paramString)
  {
    super(paramString);
  }
  
  public BaseException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public BaseException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\exception\BaseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */