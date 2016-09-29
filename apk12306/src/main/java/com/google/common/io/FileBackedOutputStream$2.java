package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;

class FileBackedOutputStream$2
  implements InputSupplier<InputStream>
{
  static
  {
    JniLib.a(2.class, 834);
  }
  
  FileBackedOutputStream$2(FileBackedOutputStream paramFileBackedOutputStream) {}
  
  public native InputStream getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\FileBackedOutputStream$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */