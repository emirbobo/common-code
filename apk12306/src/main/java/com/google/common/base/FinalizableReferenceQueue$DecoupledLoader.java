package com.google.common.base;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

class FinalizableReferenceQueue$DecoupledLoader
  implements FinalizableReferenceQueue.FinalizerLoader
{
  private static final String LOADING_ERROR = "Could not load Finalizer in its own class loader.Loading Finalizer in the current class loader instead. As a result, you will not be ableto garbage collect this class loader. To support reclaiming this class loader, eitherresolve the underlying issue, or move Google Collections to your system class path.";
  
  static
  {
    JniLib.a(DecoupledLoader.class, 279);
  }
  
  native URL getBaseUrl()
    throws IOException;
  
  public native Class<?> loadFinalizer();
  
  native URLClassLoader newLoader(URL paramURL);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\google\common\base\FinalizableReferenceQueue$DecoupledLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */