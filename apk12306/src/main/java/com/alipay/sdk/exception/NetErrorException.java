package com.alipay.sdk.exception;

import com.bangcle.andjni.JniLib;

public final class NetErrorException
  extends Exception
{
  public static final int NET_CONNECTION_ERROR = 0;
  public static final int SERVER_ERROR = 1;
  public static final int SSL_ERROR = 2;
  private static final long serialVersionUID = 8374198311711795611L;
  private int errorCode = 0;
  
  static
  {
    JniLib.a(NetErrorException.class, 110);
  }
  
  public NetErrorException()
  {
    this(null, null);
  }
  
  public NetErrorException(String paramString)
  {
    this(paramString, null);
  }
  
  public NetErrorException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    printException(paramString, paramThrowable);
  }
  
  public NetErrorException(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public static native void printException(String paramString, Throwable paramThrowable);
  
  public final native int getErrorCode();
  
  public final native void setErrorCode(int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\exception\NetErrorException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */