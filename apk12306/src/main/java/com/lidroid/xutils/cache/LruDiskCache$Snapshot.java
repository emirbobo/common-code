package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;

public final class LruDiskCache$Snapshot
  implements Closeable
{
  private final String diskKey;
  private final FileInputStream[] ins;
  private final long[] lengths;
  private final long sequenceNumber;
  
  static
  {
    JniLib.a(Snapshot.class, 942);
  }
  
  private LruDiskCache$Snapshot(LruDiskCache paramLruDiskCache, String paramString, long paramLong, FileInputStream[] paramArrayOfFileInputStream, long[] paramArrayOfLong)
  {
    this.diskKey = paramString;
    this.sequenceNumber = paramLong;
    this.ins = paramArrayOfFileInputStream;
    this.lengths = paramArrayOfLong;
  }
  
  public native void close();
  
  public native LruDiskCache.Editor edit()
    throws IOException;
  
  public native FileInputStream getInputStream(int paramInt);
  
  public native long getLength(int paramInt);
  
  public native String getString(int paramInt)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$Snapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */