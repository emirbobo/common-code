package com.alipay.sdk.util;

import com.bangcle.andjni.JniLib;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

final class FileFetch$FileAccess
{
  private FileOutputStream b;
  
  static
  {
    JniLib.a(FileAccess.class, 132);
  }
  
  public FileFetch$FileAccess(FileFetch paramFileFetch)
  {
    try
    {
      FileOutputStream localFileOutputStream = new java/io/FileOutputStream;
      localFileOutputStream.<init>(FileFetch.a(paramFileFetch), true);
      this.b = localFileOutputStream;
      return;
    }
    catch (FileNotFoundException paramFileFetch)
    {
      for (;;)
      {
        paramFileFetch.printStackTrace();
      }
    }
  }
  
  public native int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public native void a();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\FileFetch$FileAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */