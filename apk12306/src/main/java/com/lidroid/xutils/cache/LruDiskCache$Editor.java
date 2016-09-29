package com.lidroid.xutils.cache;

import com.bangcle.andjni.JniLib;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class LruDiskCache$Editor
{
  private boolean committed;
  private final LruDiskCache.Entry entry;
  private boolean hasErrors;
  private final boolean[] written;
  
  static
  {
    JniLib.a(Editor.class, 940);
  }
  
  private LruDiskCache$Editor(LruDiskCache paramLruDiskCache, LruDiskCache.Entry paramEntry)
  {
    this.entry = paramEntry;
    if (LruDiskCache.Entry.access$0(paramEntry)) {}
    for (paramLruDiskCache = null;; paramLruDiskCache = new boolean[LruDiskCache.access$7(paramLruDiskCache)])
    {
      this.written = paramLruDiskCache;
      return;
    }
  }
  
  public native void abort()
    throws IOException;
  
  public native void abortUnlessCommitted();
  
  public native void commit()
    throws IOException;
  
  public native String getString(int paramInt)
    throws IOException;
  
  public native InputStream newInputStream(int paramInt)
    throws IOException;
  
  public native OutputStream newOutputStream(int paramInt)
    throws IOException;
  
  public native void set(int paramInt, String paramString)
    throws IOException;
  
  public native void setEntryExpiryTimestamp(long paramLong);
  
  private class FaultHidingOutputStream
    extends FilterOutputStream
  {
    static
    {
      JniLib.a(FaultHidingOutputStream.class, 939);
    }
    
    private FaultHidingOutputStream(OutputStream paramOutputStream)
    {
      super();
    }
    
    public native void close();
    
    public native void flush();
    
    public native void write(int paramInt);
    
    public native void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\cache\LruDiskCache$Editor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */