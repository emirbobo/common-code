package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.ByteArrayOutputStream;

class FileBackedOutputStream$MemoryOutput
  extends ByteArrayOutputStream
{
  static
  {
    JniLib.a(MemoryOutput.class, 835);
  }
  
  native byte[] getBuffer();
  
  native int getCount();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\FileBackedOutputStream$MemoryOutput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */