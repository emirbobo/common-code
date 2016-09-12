package com.google.common.io;

import com.bangcle.andjni.JniLib;
import com.google.common.annotations.Beta;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Logger;

@Beta
public final class Flushables
{
  private static final Logger logger = Logger.getLogger(Flushables.class.getName());
  
  static
  {
    JniLib.a(Flushables.class, 840);
  }
  
  public static native void flush(Flushable paramFlushable, boolean paramBoolean)
    throws IOException;
  
  public static native void flushQuietly(Flushable paramFlushable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\Flushables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */