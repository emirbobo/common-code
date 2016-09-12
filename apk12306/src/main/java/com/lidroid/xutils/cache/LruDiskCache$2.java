package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.OutputStream;

class LruDiskCache$2
  extends OutputStream
{
  static
  {
    JniLib.a(2.class, 938);
  }
  
  public native void write(int paramInt)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */