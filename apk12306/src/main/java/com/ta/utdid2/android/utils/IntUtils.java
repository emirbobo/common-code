package com.ta.utdid2.android.utils;

import com.bangcle.andjni.JniLib;

public class IntUtils
{
  static
  {
    JniLib.a(IntUtils.class, 1062);
  }
  
  public static native byte[] getBytes(int paramInt);
  
  public static native byte[] getBytes(byte[] paramArrayOfByte, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\android\utils\IntUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */