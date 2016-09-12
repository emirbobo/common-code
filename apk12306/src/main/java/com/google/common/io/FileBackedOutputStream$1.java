package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;

class FileBackedOutputStream$1
  implements InputSupplier<InputStream>
{
  static
  {
    JniLib.a(1.class, 833);
  }
  
  FileBackedOutputStream$1(FileBackedOutputStream paramFileBackedOutputStream) {}
  
  protected native void finalize();
  
  public native InputStream getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\FileBackedOutputStream$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */