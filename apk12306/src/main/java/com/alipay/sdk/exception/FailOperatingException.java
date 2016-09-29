package com.alipay.sdk.exception;

import com.bangcle.andjni.JniLib;

public final class FailOperatingException
  extends Exception
{
  private static final long serialVersionUID = 5908800852030168641L;
  
  static
  {
    JniLib.a(FailOperatingException.class, 109);
  }
  
  public FailOperatingException()
  {
    this(null, null);
  }
  
  public FailOperatingException(String paramString)
  {
    this(paramString, null);
  }
  
  public FailOperatingException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    printException(paramString, paramThrowable);
  }
  
  public FailOperatingException(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public static native void printException(String paramString, Throwable paramThrowable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\exception\FailOperatingException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */