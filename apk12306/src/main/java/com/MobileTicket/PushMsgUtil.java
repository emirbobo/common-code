package com.MobileTicket;

public class PushMsgUtil
{
  static
  {
    System.loadLibrary("encrypt");
  }
  
  public static native String decrypt(String paramString);
  
  public static native String encrypt(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\PushMsgUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */