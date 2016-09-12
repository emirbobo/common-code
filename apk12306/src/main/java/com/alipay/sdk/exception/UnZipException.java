package com.alipay.sdk.exception;

import com.bangcle.andjni.JniLib;

public final class UnZipException
  extends Exception
{
  private static final long serialVersionUID = 7405333891987087563L;
  
  static
  {
    JniLib.a(UnZipException.class, 111);
  }
  
  public UnZipException()
  {
    this(null, null);
  }
  
  public UnZipException(String paramString)
  {
    this(paramString, null);
  }
  
  public UnZipException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    printException(paramString, paramThrowable);
  }
  
  public UnZipException(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public static native void printException(String paramString, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\exception\UnZipException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */