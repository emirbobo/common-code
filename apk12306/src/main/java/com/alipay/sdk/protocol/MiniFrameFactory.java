package com.alipay.sdk.protocol;

import com.alipay.sdk.exception.AppErrorException;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;
import com.bangcle.andjni.JniLib;

public class MiniFrameFactory
{
  static
  {
    JniLib.a(MiniFrameFactory.class, 120);
  }
  
  public native MiniWindowFrame a(FrameData paramFrameData)
    throws NetErrorException, FailOperatingException, AppErrorException;
  
  public native void b(FrameData paramFrameData)
    throws NetErrorException, FailOperatingException, AppErrorException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\MiniFrameFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */