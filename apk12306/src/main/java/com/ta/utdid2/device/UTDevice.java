package com.ta.utdid2.device;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class UTDevice
{
  static
  {
    JniLib.a(UTDevice.class, 1075);
  }
  
  public static native String getUtdid(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\device\UTDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */