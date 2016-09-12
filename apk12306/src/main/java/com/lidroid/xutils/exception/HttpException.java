package com.lidroid.xutils.exception;

import com.bangcle.andjni.JniLib;

public class HttpException
  extends BaseException
{
  private static final long serialVersionUID = 1L;
  private int exceptionCode;
  
  static
  {
    JniLib.a(HttpException.class, 979);
  }
  
  public HttpException() {}
  
  public HttpException(int paramInt)
  {
    this.exceptionCode = paramInt;
  }
  
  public HttpException(int paramInt, String paramString)
  {
    super(paramString);
    this.exceptionCode = paramInt;
  }
  
  public HttpException(int paramInt, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.exceptionCode = paramInt;
  }
  
  public HttpException(int paramInt, Throwable paramThrowable)
  {
    super(paramThrowable);
    this.exceptionCode = paramInt;
  }
  
  public HttpException(String paramString)
  {
    super(paramString);
  }
  
  public HttpException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public HttpException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
  
  public native int getExceptionCode();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\exception\HttpException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */