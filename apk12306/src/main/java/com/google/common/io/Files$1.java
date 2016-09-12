package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

final class Files$1
  implements InputSupplier<FileInputStream>
{
  static
  {
    JniLib.a(1.class, 837);
  }
  
  Files$1(File paramFile) {}
  
  public native FileInputStream getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\Files$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */