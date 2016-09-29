package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.ByteArrayOutputStream;

class LruDiskCache$StrictLineReader$1
  extends ByteArrayOutputStream
{
  static
  {
    JniLib.a(1.class, 943);
  }
  
  LruDiskCache$StrictLineReader$1(LruDiskCache.StrictLineReader paramStrictLineReader, int paramInt)
  {
    super(paramInt);
  }
  
  public native String toString();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$StrictLineReader$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */