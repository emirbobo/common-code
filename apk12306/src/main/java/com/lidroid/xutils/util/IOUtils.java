package com.lidroid.xutils.util;

import android.database.Cursor;
import com.bangcle.andjni.JniLib;
import java.io.Closeable;

public class IOUtils
{
  static
  {
    JniLib.a(IOUtils.class, 1022);
  }
  
  public static native void closeQuietly(Cursor paramCursor);
  
  public static native void closeQuietly(Closeable paramCloseable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\IOUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */