package com.alipay.sdk.exception;

import com.bangcle.andjni.JniLib;

public final class AppErrorException
  extends Exception
{
  private static final long serialVersionUID = 4918321648798599467L;
  
  static
  {
    JniLib.a(AppErrorException.class, 108);
  }
  
  public AppErrorException(Class paramClass)
  {
    this(paramClass, null, null);
  }
  
  public AppErrorException(Class paramClass, String paramString)
  {
    this(paramClass, paramString, null);
  }
  
  public AppErrorException(Class paramClass, String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    printException(paramClass, paramString, paramThrowable);
  }
  
  public AppErrorException(Class paramClass, Throwable paramThrowable)
  {
    this(paramClass, null, paramThrowable);
  }
  
  public static native void printException(Class paramClass, String paramString, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\exception\AppErrorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */