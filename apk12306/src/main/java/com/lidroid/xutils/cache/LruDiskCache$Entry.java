package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.IOException;

final class LruDiskCache$Entry
{
  private LruDiskCache.Editor currentEditor;
  private final String diskKey;
  private long expiryTimestamp = Long.MAX_VALUE;
  private final long[] lengths;
  private boolean readable;
  private long sequenceNumber;
  
  static
  {
    JniLib.a(Entry.class, 941);
  }
  
  private LruDiskCache$Entry(LruDiskCache paramLruDiskCache, String paramString)
  {
    this.diskKey = paramString;
    this.lengths = new long[LruDiskCache.access$7(paramLruDiskCache)];
  }
  
  private native IOException invalidLengths(String[] paramArrayOfString)
    throws IOException;
  
  private native void setLengths(String[] paramArrayOfString, int paramInt)
    throws IOException;
  
  public native File getCleanFile(int paramInt);
  
  public native File getDirtyFile(int paramInt);
  
  public native String getLengths()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$Entry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */