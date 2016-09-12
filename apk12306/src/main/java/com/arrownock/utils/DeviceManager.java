package com.arrownock.utils;

import com.bangcle.andjni.JniLib;

public class DeviceManager
{
  static
  {
    JniLib.a(DeviceManager.class, 180);
  }
  
  public static native void setHost(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\arrownock\utils\DeviceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */