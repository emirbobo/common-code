package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Beta
public final class FileBackedOutputStream
  extends OutputStream
{
  private File file;
  private final int fileThreshold;
  private MemoryOutput memory;
  private OutputStream out;
  private final boolean resetOnFinalize;
  private final InputSupplier<InputStream> supplier;
  
  static
  {
    JniLib.a(FileBackedOutputStream.class, 836);
  }
  
  public FileBackedOutputStream(int paramInt)
  {
    this(paramInt, false);
  }
  
  public FileBackedOutputStream(int paramInt, boolean paramBoolean)
  {
    this.fileThreshold = paramInt;
    this.resetOnFinalize = paramBoolean;
    this.memory = new MemoryOutput(null);
    this.out = this.memory;
    if (paramBoolean) {}
    for (this.supplier = new InputSupplier()
        {
          static
          {
            JniLib.a(1.class, 833);
          }
          
          protected native void finalize();
          
          public native InputStream getInput()
            throws IOException;
        };; this.supplier = new InputSupplier()
        {
          static
          {
            JniLib.a(2.class, 834);
          }
          
          public native InputStream getInput()
            throws IOException;
        }) {
      return;
    }
  }
  
  private native InputStream openStream()
    throws IOException;
  
  private native void update(int paramInt)
    throws IOException;
  
  public native void close()
    throws IOException;
  
  public native void flush()
    throws IOException;
  
  @VisibleForTesting
  native File getFile();
  
  public native InputSupplier<InputStream> getSupplier();
  
  public native void reset()
    throws IOException;
  
  public native void write(int paramInt)
    throws IOException;
  
  public native void write(byte[] paramArrayOfByte)
    throws IOException;
  
  public native void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  private static class MemoryOutput
    extends ByteArrayOutputStream
  {
    static
    {
      JniLib.a(MemoryOutput.class, 835);
    }
    
    native byte[] getBuffer();
    
    native int getCount();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\FileBackedOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */