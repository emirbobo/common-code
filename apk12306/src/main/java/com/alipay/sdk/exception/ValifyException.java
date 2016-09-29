package com.alipay.sdk.exception;

import com.bangcle.andjni.JniLib;

public final class ValifyException
  extends Exception
{
  private static final long serialVersionUID = 7405333891987087563L;
  
  static
  {
    JniLib.a(ValifyException.class, 112);
  }
  
  public ValifyException()
  {
    this(null, null);
  }
  
  public ValifyException(String paramString)
  {
    this(paramString, null);
  }
  
  public ValifyException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    printException(paramString, paramThrowable);
  }
  
  public ValifyException(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public static native void printException(String paramString, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\exception\ValifyException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */