package com.ut.device;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class UTDevice
{
  static
  {
    JniLib.a(UTDevice.class, 1136);
  }
  
  public static native String getUtdid(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ut\device\UTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */