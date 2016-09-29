package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.FilterOutputStream;
import java.io.OutputStream;

class LruDiskCache$Editor$FaultHidingOutputStream
  extends FilterOutputStream
{
  static
  {
    JniLib.a(FaultHidingOutputStream.class, 939);
  }
  
  private LruDiskCache$Editor$FaultHidingOutputStream(LruDiskCache.Editor paramEditor, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }
  
  public native void close();
  
  public native void flush();
  
  public native void write(int paramInt);
  
  public native void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$Editor$FaultHidingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */