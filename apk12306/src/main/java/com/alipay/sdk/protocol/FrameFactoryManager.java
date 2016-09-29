package com.alipay.sdk.protocol;

import com.alipay.sdk.exception.AppErrorException;
import com.alipay.sdk.exception.FailOperatingException;
import com.alipay.sdk.exception.NetErrorException;
import com.bangcle.andjni.JniLib;

public class FrameFactoryManager
{
  static
  {
    JniLib.a(FrameFactoryManager.class, 119);
  }
  
  public static native FrameData a(FrameData paramFrameData)
    throws NetErrorException, FailOperatingException, AppErrorException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\protocol\FrameFactoryManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */