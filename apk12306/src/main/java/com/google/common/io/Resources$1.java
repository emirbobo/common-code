package com.google.common.io;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

final class Resources$1
  implements InputSupplier<InputStream>
{
  static
  {
    JniLib.a(1.class, 850);
  }
  
  Resources$1(URL paramURL) {}
  
  public native InputStream getInput()
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\io\Resources$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */