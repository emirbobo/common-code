package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@Beta
public final class Closeables
{
  private static final Logger logger = Logger.getLogger(Closeables.class.getName());
  
  static
  {
    JniLib.a(Closeables.class, 830);
  }
  
  public static native void close(@Nullable Closeable paramCloseable, boolean paramBoolean)
    throws IOException;
  
  public static native void closeQuietly(@Nullable Closeable paramCloseable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\Closeables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */