package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

final class Files$2
  implements OutputSupplier<FileOutputStream>
{
  static
  {
    JniLib.a(2.class, 838);
  }
  
  Files$2(File paramFile, boolean paramBoolean) {}
  
  public native FileOutputStream getOutput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\Files$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */